package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.q1;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class GuavaCodec implements ObjectSerializer, ObjectDeserializer {
    public static GuavaCodec instance;

    public GuavaCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    static {
        instance = new GuavaCodec();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.google.common.collect.ArrayListMultimap] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if ((r101 instanceof ParameterizedType) == false) goto L6;
        r101 = ((ParameterizedType) r101).getRawType();
    L6:
        if (r101 != ArrayListMultimap.class) goto L15;
        ?? r103 = (T) ArrayListMultimap.create();
        Iterator<Map.Entry<String, Object>> r104 = r100.parseObject().entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<String, Object> r105 = r104.next();
        Object r106 = r105.getValue();
        if ((r106 instanceof Collection) == true) goto L12;
        r103.put(r105.getKey(), r106);
        goto L9
    L12:
        r103.putAll(r105.getKey(), (List) r106);
        goto L9
    L14:
        return r103;
    L15:
        return null;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if ((r101 instanceof q1) == false) goto L6;
        r100.write(((q1) r101).asMap());
        return;
    }
}

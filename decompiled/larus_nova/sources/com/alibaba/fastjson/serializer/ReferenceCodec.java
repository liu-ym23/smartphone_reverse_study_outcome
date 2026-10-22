package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class ReferenceCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ReferenceCodec instance = null;

    public ReferenceCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        instance = new ReferenceCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        ParameterizedType r103 = (ParameterizedType) r101;
        Object r104 = r100.parseObject(r103.getActualTypeArguments()[0]);
        Type r105 = r103.getRawType();
        if (r105 != AtomicReference.class) goto L7;
        return (T) new AtomicReference(r104);
    L7:
        if (r105 != WeakReference.class) goto L11;
        return (T) new WeakReference(r104);
    L11:
        if (r105 != SoftReference.class) goto L15;
        return (T) new SoftReference(r104);
    L15:
        throw new UnsupportedOperationException(r105.toString());
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if ((r101 instanceof AtomicReference) == false) goto L5;
        Object r105 = ((AtomicReference) r101).get();
    L6:
        r100.write(r105);
        return;
    L5:
        r105 = ((Reference) r101).get();
        goto L6
    }
}

package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class JavaObjectDeserializer implements ObjectDeserializer {
    public static final JavaObjectDeserializer instance = null;

    public JavaObjectDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        instance = new JavaObjectDeserializer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if ((r101 instanceof GenericArrayType) == false) goto L10;
        Type r103 = ((GenericArrayType) r101).getGenericComponentType();
        if ((r103 instanceof TypeVariable) == false) goto L7;
        r103 = ((TypeVariable) r103).getBounds()[0];
    L7:
        ArrayList r104 = new ArrayList();
        r100.parseArray(r103, r104);
        T r105 = (T) ((Object[]) Array.newInstance(TypeUtils.getRawClass(r103), r104.size()));
        r104.toArray(r105);
        return r105;
    L10:
        if ((r101 instanceof Class) == false) goto L24;
        if (r101 == Object.class) goto L24;
        if (r101 == Serializable.class) goto L24;
        if (r101 == Cloneable.class) goto L24;
        if (r101 == Closeable.class) goto L24;
        if (r101 == Comparable.class) goto L24;
        return (T) r100.parseObject(r101);
    L24:
        return (T) r100.parse(r102);
    }
}

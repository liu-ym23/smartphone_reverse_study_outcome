package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes28.dex */
public class EnumerationSerializer implements ObjectSerializer {
    public static EnumerationSerializer instance;

    public EnumerationSerializer() {
    }

    static {
        instance = new EnumerationSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r110, Object r111, Object r112, Type r113, int r114) throws IOException {
        SerializeWriter r115 = r110.out;
        if (r111 != null) goto L6;
        r115.writeNull(SerializerFeature.WriteNullListAsEmpty);
        return;
    L6:
        int r100 = 0;
        if (r115.isEnabled(SerializerFeature.WriteClassName) == true) goto L9;
    L11:
        Type r116 = null;
    L12:
        Enumeration r101 = (Enumeration) r111;
        SerialContext r102 = r110.context;
        r110.setContext(r102, r111, r112, 0);
        r115.append('[');     // Catch: Throwable -> L26
    L15:
        if (r101.hasMoreElements() == false) goto L23;
        Object r103 = r101.nextElement();     // Catch: Throwable -> L26
        int r117 = r100 + 1;     // Catch: Throwable -> L26
        if (r100 == 0) goto L19;
        r115.append(',');     // Catch: Throwable -> L26
    L19:
        if (r103 != null) goto L21;
        r115.writeNull();     // Catch: Throwable -> L26
    L22:
        r100 = r117;
        goto L15
    L21:
        r110.getObjectWriter(r103.getClass()).write(r110, r103, Integer.valueOf(r117 - 1), r116, 0);     // Catch: Throwable -> L26
        goto L22
    L23:
        r115.append(']');     // Catch: Throwable -> L26
        r110.context = r102;
        return;
    L26:
        th = move-exception;
        r110.context = r102;
        throw th;
    L9:
        if ((r113 instanceof ParameterizedType) == false) goto L11;
        r116 = ((ParameterizedType) r113).getActualTypeArguments()[0];
        goto L12
    }
}

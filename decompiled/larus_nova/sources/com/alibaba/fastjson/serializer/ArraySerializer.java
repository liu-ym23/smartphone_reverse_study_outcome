package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    public ArraySerializer(Class<?> r100, ObjectSerializer r101) {
        this.componentType = r100;
        this.compObjectSerializer = r101;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r110, Object r111, Object r112, Type r113, int r114) throws IOException {
        SerializeWriter r115 = r110.out;
        if (r111 != null) goto L6;
        r115.writeNull(SerializerFeature.WriteNullListAsEmpty);
        return;
    L6:
        Object[] r116 = (Object[]) r111;
        int r100 = r116.length;
        SerialContext r101 = r110.context;
        int r102 = 0;
        r110.setContext(r101, r111, r112, 0);
        r115.append('[');     // Catch: Throwable -> L27
    L8:
        if (r102 >= r100) goto L24;
        if (r102 == 0) goto L11;
        r115.append(',');     // Catch: Throwable -> L27
    L11:
        Object r103 = r116[r102];     // Catch: Throwable -> L27
        if (r103 != null) goto L20;
        if (r115.isEnabled(SerializerFeature.WriteNullStringAsEmpty) == true) goto L16;
    L18:
        r115.append("null");     // Catch: Throwable -> L27
    L23:
        r102 = r102 + 1;     // Catch: Throwable -> L27
        goto L8
    L16:
        if ((r111 instanceof String[]) == false) goto L18;
        r115.writeString("");     // Catch: Throwable -> L27
        goto L23
    L20:
        if (r103.getClass() != this.componentType) goto L22;
        this.compObjectSerializer.write(r110, r103, Integer.valueOf(r102), null, 0);     // Catch: Throwable -> L27
        goto L23
    L22:
        r110.getObjectWriter(r103.getClass()).write(r110, r103, Integer.valueOf(r102), null, 0);     // Catch: Throwable -> L27
        goto L23
    L24:
        r115.append(']');     // Catch: Throwable -> L27
        r110.context = r101;
        return;
    L27:
        th = move-exception;
        r110.context = r101;
        throw th;
    }
}

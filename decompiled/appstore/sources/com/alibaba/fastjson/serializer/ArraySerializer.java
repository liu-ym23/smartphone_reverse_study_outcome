package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    public ArraySerializer(Class<?> r10, ObjectSerializer r11) {
        this.componentType = r10;
        this.compObjectSerializer = r11;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        if (r11 == null) goto L5;
        int r15 = 0;
        if ((r11 instanceof boolean[]) == false) goto L20;
        boolean[] r16 = (boolean[]) r11;
        r14.write(91);
    L13:
        if (r15 >= r16.length) goto L17;
        if (r15 == 0) goto L16;
        r14.write(44);
    L16:
        r14.write(r16[r15]);
        r15 = r15 + 1;
        goto L13
    L17:
        r14.write(93);
        return;
    L20:
        if ((r11 instanceof byte[]) == false) goto L24;
        r14.writeByteArray((byte[]) r11);
        return;
    L24:
        if ((r11 instanceof char[]) == false) goto L28;
        r14.writeString(new String((char[]) r11));
        return;
    L28:
        if ((r11 instanceof double[]) == false) goto L47;
        double[] r17 = (double[]) r11;
        int r18 = r17.length - 1;
        if (r18 != (-1)) goto L33;
        r14.append("[]");
        return;
    L33:
        r14.write(91);
    L34:
        if (r15 >= r18) goto L40;
        double r19 = r17[r15];
        if (Double.isNaN(r19) == false) goto L38;
        r14.writeNull();
    L39:
        r14.write(44);
        r15 = r15 + 1;
        goto L34
    L38:
        r14.append(Double.toString(r19));
        goto L39
    L40:
        double r20 = r17[r18];
        if (Double.isNaN(r20) == false) goto L43;
        r14.writeNull();
    L44:
        r14.write(93);
        return;
    L43:
        r14.append(Double.toString(r20));
        goto L44
    L47:
        if ((r11 instanceof float[]) == false) goto L66;
        float[] r110 = (float[]) r11;
        int r21 = r110.length - 1;
        if (r21 != (-1)) goto L52;
        r14.append("[]");
        return;
    L52:
        r14.write(91);
    L53:
        if (r15 >= r21) goto L59;
        float r22 = r110[r15];
        if (Float.isNaN(r22) == false) goto L57;
        r14.writeNull();
    L58:
        r14.write(44);
        r15 = r15 + 1;
        goto L53
    L57:
        r14.append(Float.toString(r22));
        goto L58
    L59:
        float r23 = r110[r21];
        if (Float.isNaN(r23) == false) goto L62;
        r14.writeNull();
    L63:
        r14.write(93);
        return;
    L62:
        r14.append(Float.toString(r23));
        goto L63
    L66:
        if ((r11 instanceof int[]) == false) goto L76;
        int[] r111 = (int[]) r11;
        r14.write(91);
    L69:
        if (r15 >= r111.length) goto L73;
        if (r15 == 0) goto L72;
        r14.write(44);
    L72:
        r14.writeInt(r111[r15]);
        r15 = r15 + 1;
        goto L69
    L73:
        r14.write(93);
        return;
    L76:
        if ((r11 instanceof long[]) == false) goto L86;
        long[] r112 = (long[]) r11;
        r14.write(91);
    L79:
        if (r15 >= r112.length) goto L83;
        if (r15 == 0) goto L82;
        r14.write(44);
    L82:
        r14.writeLong(r112[r15]);
        r15 = r15 + 1;
        goto L79
    L83:
        r14.write(93);
        return;
    L86:
        if ((r11 instanceof short[]) == false) goto L95;
        short[] r113 = (short[]) r11;
        r14.write(91);
    L89:
        if (r15 >= r113.length) goto L93;
        if (r15 == 0) goto L92;
        r14.write(44);
    L92:
        r14.writeInt(r113[r15]);
        r15 = r15 + 1;
        goto L89
    L93:
        r14.write(93);
        return;
    L95:
        Object[] r24 = (Object[]) r11;
        int r25 = r24.length;
        SerialContext r26 = r10.context;
        r10.setContext(r26, r11, r12, 0);
        r14.write(91);     // Catch: Throwable -> L100
    L97:
        if (r15 >= r25) goto L110;
        if (r15 == 0) goto L102;
        r14.write(44);     // Catch: Throwable -> L100
    L102:
        Object r114 = r24[r15];     // Catch: Throwable -> L100
        if (r114 != null) goto L106;
        r14.append("null");     // Catch: Throwable -> L100
    L109:
        r15 = r15 + 1;     // Catch: Throwable -> L100
        goto L97
    L106:
        if (r114.getClass() != this.componentType) goto L108;
        this.compObjectSerializer.write(r10, r114, Integer.valueOf(r15), null);     // Catch: Throwable -> L100
        goto L109
    L108:
        r10.config.get(r114.getClass()).write(r10, r114, Integer.valueOf(r15), null);     // Catch: Throwable -> L100
        goto L109
    L110:
        r14.write(93);     // Catch: Throwable -> L100
        r10.context = r26;
        return;
    L100:
        th = move-exception;
        r10.context = r26;
        throw th;
    L5:
        if ((r14.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0) goto L7;
        r14.write("[]");
        return;
    L7:
        r14.writeNull();
    }
}

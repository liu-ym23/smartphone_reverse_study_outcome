package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance;

    public PrimitiveArraySerializer() {
    }

    static {
        instance = new PrimitiveArraySerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull(SerializerFeature.WriteNullListAsEmpty);
        return;
    L6:
        int r106 = 0;
        if ((r101 instanceof int[]) == false) goto L17;
        int[] r107 = (int[]) r101;
        r105.write(91);
    L10:
        if (r106 >= r107.length) goto L14;
        if (r106 == 0) goto L13;
        r105.write(44);
    L13:
        r105.writeInt(r107[r106]);
        r106 = r106 + 1;
        goto L10
    L14:
        r105.write(93);
        return;
    L17:
        if ((r101 instanceof short[]) == false) goto L27;
        short[] r108 = (short[]) r101;
        r105.write(91);
    L20:
        if (r106 >= r108.length) goto L24;
        if (r106 == 0) goto L23;
        r105.write(44);
    L23:
        r105.writeInt(r108[r106]);
        r106 = r106 + 1;
        goto L20
    L24:
        r105.write(93);
        return;
    L27:
        if ((r101 instanceof long[]) == false) goto L37;
        long[] r109 = (long[]) r101;
        r105.write(91);
    L30:
        if (r106 >= r109.length) goto L34;
        if (r106 == 0) goto L33;
        r105.write(44);
    L33:
        r105.writeLong(r109[r106]);
        r106 = r106 + 1;
        goto L30
    L34:
        r105.write(93);
        return;
    L37:
        if ((r101 instanceof boolean[]) == false) goto L47;
        boolean[] r110 = (boolean[]) r101;
        r105.write(91);
    L40:
        if (r106 >= r110.length) goto L44;
        if (r106 == 0) goto L43;
        r105.write(44);
    L43:
        r105.write(r110[r106]);
        r106 = r106 + 1;
        goto L40
    L44:
        r105.write(93);
        return;
    L47:
        if ((r101 instanceof float[]) == false) goto L61;
        float[] r111 = (float[]) r101;
        r105.write(91);
    L50:
        if (r106 >= r111.length) goto L58;
        if (r106 == 0) goto L53;
        r105.write(44);
    L53:
        float r112 = r111[r106];
        if (Float.isNaN(r112) == false) goto L56;
        r105.writeNull();
    L57:
        r106 = r106 + 1;
        goto L50
    L56:
        r105.append(Float.toString(r112));
        goto L57
    L58:
        r105.write(93);
        return;
    L61:
        if ((r101 instanceof double[]) == false) goto L75;
        double[] r113 = (double[]) r101;
        r105.write(91);
    L64:
        if (r106 >= r113.length) goto L72;
        if (r106 == 0) goto L67;
        r105.write(44);
    L67:
        double r114 = r113[r106];
        if (Double.isNaN(r114) == false) goto L70;
        r105.writeNull();
    L71:
        r106 = r106 + 1;
        goto L64
    L70:
        r105.append(Double.toString(r114));
        goto L71
    L72:
        r105.write(93);
        return;
    L75:
        if ((r101 instanceof byte[]) == false) goto L78;
        r105.writeByteArray((byte[]) r101);
        return;
    L78:
        r105.writeString((char[]) r101);
    }
}

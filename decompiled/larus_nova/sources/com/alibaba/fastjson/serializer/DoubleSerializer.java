package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class DoubleSerializer implements ObjectSerializer {
    public static final DoubleSerializer instance = null;
    private DecimalFormat decimalFormat;

    static {
        instance = new DoubleSerializer();
    }

    public DoubleSerializer() {
        this.decimalFormat = null;
    }

    public DoubleSerializer(String r100) {
        this(new DecimalFormat(r100));
    }

    public DoubleSerializer(DecimalFormat r100) {
        this.decimalFormat = r100;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull(SerializerFeature.WriteNullNumberAsZero);
        return;
    L6:
        double r106 = ((Double) r101).doubleValue();
        if (Double.isNaN(r106) == false) goto L9;
    L15:
        r105.writeNull();
        return;
    L9:
        if (Double.isInfinite(r106) == true) goto L15;
        DecimalFormat r107 = this.decimalFormat;
        if (r107 != null) goto L14;
        r105.writeDouble(r106, true);
        return;
    L14:
        r105.write(r107.format(r106));
    }
}

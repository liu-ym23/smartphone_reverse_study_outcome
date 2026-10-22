package com.bytedance.common.wschannel.converter;

/* JADX INFO: loaded from: classes2.dex */
public class MsgConverterFactory {
    private static MsgConverter DEFAULT;
    private static MsgConverter sConverter;

    public MsgConverterFactory() {
    }

    static {
        WireConverter r0 = new WireConverter();
        DEFAULT = r0;
        sConverter = r0;
    }

    public static MsgConverter getConverter() {
        return sConverter;
    }

    public static void setConverter(MsgConverter r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        sConverter = r0;
    }
}

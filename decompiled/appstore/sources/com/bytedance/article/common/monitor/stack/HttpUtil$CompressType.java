package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: classes.dex */
public final enum HttpUtil$CompressType extends Enum<HttpUtil$CompressType> {
    private static final /* synthetic */ HttpUtil$CompressType[] $VALUES = null;
    public static final HttpUtil$CompressType DEFLATER = null;
    public static final HttpUtil$CompressType GZIP = null;
    public static final HttpUtil$CompressType NONE = null;
    final int nativeInt;

    static {
        HttpUtil$CompressType r10 = new HttpUtil$CompressType("NONE", 0, 0);
        NONE = r10;
        HttpUtil$CompressType r11 = new HttpUtil$CompressType("GZIP", 1, 1);
        GZIP = r11;
        HttpUtil$CompressType r12 = new HttpUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r12;
        $VALUES = new HttpUtil$CompressType[]{r10, r11, r12};
    }

    private HttpUtil$CompressType(String r10, int r11, int r12) {
        super(r10, r11);
        this.nativeInt = r12;
    }

    public static HttpUtil$CompressType valueOf(String r10) {
        return (HttpUtil$CompressType) Enum.valueOf(HttpUtil$CompressType.class, r10);
    }

    public static HttpUtil$CompressType[] values() {
        return (HttpUtil$CompressType[]) $VALUES.clone();
    }
}

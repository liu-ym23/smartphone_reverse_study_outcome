package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: classes.dex */
public final enum HttpUtil$NetworkType extends Enum<HttpUtil$NetworkType> {
    private static final /* synthetic */ HttpUtil$NetworkType[] $VALUES = null;
    public static final HttpUtil$NetworkType MOBILE = null;
    public static final HttpUtil$NetworkType MOBILE_2G = null;
    public static final HttpUtil$NetworkType MOBILE_3G = null;
    public static final HttpUtil$NetworkType MOBILE_4G = null;
    public static final HttpUtil$NetworkType NONE = null;
    public static final HttpUtil$NetworkType WIFI = null;
    final int nativeInt;

    static {
        HttpUtil$NetworkType r10 = new HttpUtil$NetworkType("NONE", 0, 0);
        NONE = r10;
        HttpUtil$NetworkType r11 = new HttpUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r11;
        HttpUtil$NetworkType r12 = new HttpUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r12;
        HttpUtil$NetworkType r13 = new HttpUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r13;
        HttpUtil$NetworkType r14 = new HttpUtil$NetworkType("WIFI", 4, 4);
        WIFI = r14;
        HttpUtil$NetworkType r15 = new HttpUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r15;
        $VALUES = new HttpUtil$NetworkType[]{r10, r11, r12, r13, r14, r15};
    }

    private HttpUtil$NetworkType(String r10, int r11, int r12) {
        super(r10, r11);
        this.nativeInt = r12;
    }

    public static HttpUtil$NetworkType valueOf(String r10) {
        return (HttpUtil$NetworkType) Enum.valueOf(HttpUtil$NetworkType.class, r10);
    }

    public static HttpUtil$NetworkType[] values() {
        return (HttpUtil$NetworkType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }
}

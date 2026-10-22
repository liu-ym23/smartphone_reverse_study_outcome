package com.byted.cast.linkcommon.cybergarage.http;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum HTTPServerType extends Enum<HTTPServerType> {
    private static final /* synthetic */ HTTPServerType[] $VALUES = null;
    public static final HTTPServerType BDLINK_SINK = null;
    public static final HTTPServerType BDLINK_SOURCE = null;
    public static final HTTPServerType DLNA_SINK = null;
    public static final HTTPServerType DLNA_SOURCE = null;

    static {
        HTTPServerType r100 = new HTTPServerType("DLNA_SOURCE", 0);
        DLNA_SOURCE = r100;
        HTTPServerType r101 = new HTTPServerType("DLNA_SINK", 1);
        DLNA_SINK = r101;
        HTTPServerType r102 = new HTTPServerType("BDLINK_SINK", 2);
        BDLINK_SINK = r102;
        HTTPServerType r103 = new HTTPServerType("BDLINK_SOURCE", 3);
        BDLINK_SOURCE = r103;
        $VALUES = new HTTPServerType[]{r100, r101, r102, r103};
    }

    public static HTTPServerType[] values() {
        return (HTTPServerType[]) $VALUES.clone();
    }

    public static HTTPServerType valueOf(String r100) {
        return (HTTPServerType) a.a(HTTPServerType.class, r100);
    }

    private HTTPServerType(String r100, int r101) {
        super(r100, r101);
    }
}

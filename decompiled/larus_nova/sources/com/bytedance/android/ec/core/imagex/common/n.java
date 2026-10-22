package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f44653a = null;

    static {
        int[] r100 = new int[ImageUrlParser.Type.values().length];
        f44653a = r100;
        r100[ImageUrlParser.Type.PROTOCOL.ordinal()] = 1;
        r100[ImageUrlParser.Type.DOMAIN.ordinal()] = 2;
        r100[ImageUrlParser.Type.FLAG.ordinal()] = 3;
        r100[ImageUrlParser.Type.URI.ordinal()] = 4;
        r100[ImageUrlParser.Type.SERVICE_ID.ordinal()] = 5;
        r100[ImageUrlParser.Type.TMPL_NAME.ordinal()] = 6;
        r100[ImageUrlParser.Type.ParamValues.ordinal()] = 7;
        r100[ImageUrlParser.Type.FORMAT.ordinal()] = 8;
    }
}

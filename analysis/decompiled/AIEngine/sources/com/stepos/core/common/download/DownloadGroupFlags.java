package com.stepos.core.common.download;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadGroupFlags {
    public static final int FLAG_CANCELED_BY_USER = 16;
    public static final int FLAG_PAUSED_BY_CELLULAR = 4;
    public static final int FLAG_PAUSED_BY_NO_NETWORK = 2;
    public static final int FLAG_PAUSED_BY_USER = 8;
    public static final int FLAG_USE_CELLULAR = 1;
    public static final DownloadGroupFlags INSTANCE = new DownloadGroupFlags();

    private DownloadGroupFlags() {
    }
}

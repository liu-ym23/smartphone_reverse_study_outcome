package com.bytedance.android.ad.sdk.api.video;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ad/sdk/api/video/AdVideoDisplayMode;", "", "DEFAULT", "ASPECT_FILL_X", "ASPECT_FILL_Y", "ASPECT_CONTAIN", "ASPECT_COVER", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final enum AdVideoDisplayMode extends Enum<AdVideoDisplayMode> {
    public static final AdVideoDisplayMode ASPECT_CONTAIN = null;
    public static final AdVideoDisplayMode ASPECT_COVER = null;
    public static final AdVideoDisplayMode ASPECT_FILL_X = null;
    public static final AdVideoDisplayMode ASPECT_FILL_Y = null;
    public static final AdVideoDisplayMode DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdVideoDisplayMode[] f38322a = null;

    static {
        AdVideoDisplayMode r100 = new AdVideoDisplayMode("DEFAULT", 0);
        DEFAULT = r100;
        AdVideoDisplayMode r101 = new AdVideoDisplayMode("ASPECT_FILL_X", 1);
        ASPECT_FILL_X = r101;
        AdVideoDisplayMode r102 = new AdVideoDisplayMode("ASPECT_FILL_Y", 2);
        ASPECT_FILL_Y = r102;
        AdVideoDisplayMode r103 = new AdVideoDisplayMode("ASPECT_CONTAIN", 3);
        ASPECT_CONTAIN = r103;
        AdVideoDisplayMode r104 = new AdVideoDisplayMode("ASPECT_COVER", 4);
        ASPECT_COVER = r104;
        f38322a = new AdVideoDisplayMode[]{r100, r101, r102, r103, r104};
    }

    public static AdVideoDisplayMode valueOf(String r100) {
        return (AdVideoDisplayMode) a.a(AdVideoDisplayMode.class, r100);
    }

    public static AdVideoDisplayMode[] values() {
        return (AdVideoDisplayMode[]) f38322a.clone();
    }

    public AdVideoDisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}

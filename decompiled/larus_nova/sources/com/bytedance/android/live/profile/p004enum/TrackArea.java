package com.bytedance.android.live.profile.p004enum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/enum/TrackArea;", "", "", "paramName", "Ljava/lang/String;", "getParamName", "()Ljava/lang/String;", "BasicAreaArea", "BottomOperatingArea", "TopWhiteArea", "TagArea", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TrackArea extends Enum<TrackArea> {
    public static final TrackArea BasicAreaArea = null;
    public static final TrackArea BottomOperatingArea = null;
    public static final TrackArea TagArea = null;
    public static final TrackArea TopWhiteArea = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrackArea[] f86018a = null;
    private final String paramName;

    static {
        TrackArea r100 = new TrackArea("BasicAreaArea", 0, "function_list_1");
        BasicAreaArea = r100;
        TrackArea r101 = new TrackArea("BottomOperatingArea", 1, "function_list_2");
        BottomOperatingArea = r101;
        TrackArea r102 = new TrackArea("TopWhiteArea", 2, "function_list_3");
        TopWhiteArea = r102;
        TrackArea r103 = new TrackArea("TagArea", 3, "function_list_4");
        TagArea = r103;
        f86018a = new TrackArea[]{r100, r101, r102, r103};
    }

    public static TrackArea valueOf(String r100) {
        return (TrackArea) a.a(TrackArea.class, r100);
    }

    public static TrackArea[] values() {
        return (TrackArea[]) f86018a.clone();
    }

    public final String getParamName() {
        return this.paramName;
    }

    public TrackArea(String r100, int r101, String r102) {
        super(r100, r101);
        this.paramName = r102;
    }
}

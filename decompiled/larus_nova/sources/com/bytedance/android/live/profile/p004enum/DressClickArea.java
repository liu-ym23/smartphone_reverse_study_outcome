package com.bytedance.android.live.profile.p004enum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profile/enum/DressClickArea;", "", "BorderRight", "BorderLeft", "Panel", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DressClickArea extends Enum<DressClickArea> {
    public static final DressClickArea BorderLeft = null;
    public static final DressClickArea BorderRight = null;
    public static final DressClickArea Panel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DressClickArea[] f86016a = null;

    static {
        DressClickArea r100 = new DressClickArea("BorderRight", 0);
        BorderRight = r100;
        DressClickArea r101 = new DressClickArea("BorderLeft", 1);
        BorderLeft = r101;
        DressClickArea r102 = new DressClickArea("Panel", 2);
        Panel = r102;
        f86016a = new DressClickArea[]{r100, r101, r102};
    }

    public static DressClickArea valueOf(String r100) {
        return (DressClickArea) a.a(DressClickArea.class, r100);
    }

    public static DressClickArea[] values() {
        return (DressClickArea[]) f86016a.clone();
    }

    public DressClickArea(String r100, int r101) {
        super(r100, r101);
    }
}

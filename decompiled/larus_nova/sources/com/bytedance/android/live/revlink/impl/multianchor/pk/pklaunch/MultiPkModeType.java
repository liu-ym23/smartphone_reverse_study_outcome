package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiPkModeType;", "", "BOTH", "PERSONAL", "TEAM", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiPkModeType extends Enum<MultiPkModeType> {
    public static final MultiPkModeType BOTH = null;
    public static final MultiPkModeType PERSONAL = null;
    public static final MultiPkModeType TEAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiPkModeType[] f94544a = null;

    static {
        MultiPkModeType r100 = new MultiPkModeType("BOTH", 0);
        BOTH = r100;
        MultiPkModeType r101 = new MultiPkModeType("PERSONAL", 1);
        PERSONAL = r101;
        MultiPkModeType r102 = new MultiPkModeType("TEAM", 2);
        TEAM = r102;
        f94544a = new MultiPkModeType[]{r100, r101, r102};
    }

    public static MultiPkModeType valueOf(String r100) {
        return (MultiPkModeType) r27.a.a(MultiPkModeType.class, r100);
    }

    public static MultiPkModeType[] values() {
        return (MultiPkModeType[]) f94544a.clone();
    }

    public MultiPkModeType(String r100, int r101) {
        super(r100, r101);
    }
}

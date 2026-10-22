package com.bytedance.android.live.revlink.impl.pk.mixer.mapping;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/mixer/mapping/LayoutMode;", "", "Center", "CenterHorizontal", "CenterVertical", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LayoutMode extends Enum<LayoutMode> {
    public static final LayoutMode Center = null;
    public static final LayoutMode CenterHorizontal = null;
    public static final LayoutMode CenterVertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutMode[] f96721a = null;

    static {
        LayoutMode r100 = new LayoutMode("Center", 0);
        Center = r100;
        LayoutMode r101 = new LayoutMode("CenterHorizontal", 1);
        CenterHorizontal = r101;
        LayoutMode r102 = new LayoutMode("CenterVertical", 2);
        CenterVertical = r102;
        f96721a = new LayoutMode[]{r100, r101, r102};
    }

    public static LayoutMode valueOf(String r100) {
        return (LayoutMode) a.a(LayoutMode.class, r100);
    }

    public static LayoutMode[] values() {
        return (LayoutMode[]) f96721a.clone();
    }

    public LayoutMode(String r100, int r101) {
        super(r100, r101);
    }
}

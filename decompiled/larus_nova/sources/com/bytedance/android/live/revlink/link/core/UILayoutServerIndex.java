package com.bytedance.android.live.revlink.link.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/UILayoutServerIndex;", "", "Normal", "Focus", "Full", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayoutServerIndex extends Enum<UILayoutServerIndex> {
    public static final UILayoutServerIndex Focus = null;
    public static final UILayoutServerIndex Full = null;
    public static final UILayoutServerIndex Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayoutServerIndex[] f98254a = null;

    static {
        UILayoutServerIndex r100 = new UILayoutServerIndex("Normal", 0);
        Normal = r100;
        UILayoutServerIndex r101 = new UILayoutServerIndex("Focus", 1);
        Focus = r101;
        UILayoutServerIndex r102 = new UILayoutServerIndex("Full", 2);
        Full = r102;
        f98254a = new UILayoutServerIndex[]{r100, r101, r102};
    }

    public static UILayoutServerIndex valueOf(String r100) {
        return (UILayoutServerIndex) a.a(UILayoutServerIndex.class, r100);
    }

    public static UILayoutServerIndex[] values() {
        return (UILayoutServerIndex[]) f98254a.clone();
    }

    public UILayoutServerIndex(String r100, int r101) {
        super(r100, r101);
    }
}

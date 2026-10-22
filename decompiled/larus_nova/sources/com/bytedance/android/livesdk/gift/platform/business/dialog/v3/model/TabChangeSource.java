package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/TabChangeSource;", "", "Default", "Click", "Slide", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabChangeSource extends Enum<TabChangeSource> {
    public static final TabChangeSource Click = null;
    public static final TabChangeSource Default = null;
    public static final TabChangeSource Slide = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabChangeSource[] f127492a = null;

    static {
        TabChangeSource r100 = new TabChangeSource("Default", 0);
        Default = r100;
        TabChangeSource r101 = new TabChangeSource("Click", 1);
        Click = r101;
        TabChangeSource r102 = new TabChangeSource("Slide", 2);
        Slide = r102;
        f127492a = new TabChangeSource[]{r100, r101, r102};
    }

    public static TabChangeSource valueOf(String r100) {
        return (TabChangeSource) a.a(TabChangeSource.class, r100);
    }

    public static TabChangeSource[] values() {
        return (TabChangeSource[]) f127492a.clone();
    }

    public TabChangeSource(String r100, int r101) {
        super(r100, r101);
    }
}

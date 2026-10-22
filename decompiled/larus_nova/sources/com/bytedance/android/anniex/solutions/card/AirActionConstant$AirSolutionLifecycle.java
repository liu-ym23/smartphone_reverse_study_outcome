package com.bytedance.android.anniex.solutions.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle", "", "Lcom/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle;", "OnShow", "OnHide", "OnViewLoad", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AirActionConstant$AirSolutionLifecycle extends Enum<AirActionConstant$AirSolutionLifecycle> {
    public static final AirActionConstant$AirSolutionLifecycle OnHide = null;
    public static final AirActionConstant$AirSolutionLifecycle OnShow = null;
    public static final AirActionConstant$AirSolutionLifecycle OnViewLoad = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AirActionConstant$AirSolutionLifecycle[] f41338a = null;

    public static AirActionConstant$AirSolutionLifecycle valueOf(String r100) {
        return (AirActionConstant$AirSolutionLifecycle) a.a(AirActionConstant$AirSolutionLifecycle.class, r100);
    }

    public static AirActionConstant$AirSolutionLifecycle[] values() {
        return (AirActionConstant$AirSolutionLifecycle[]) f41338a.clone();
    }

    static {
        AirActionConstant$AirSolutionLifecycle r100 = new AirActionConstant$AirSolutionLifecycle("OnShow", 0);
        OnShow = r100;
        AirActionConstant$AirSolutionLifecycle r101 = new AirActionConstant$AirSolutionLifecycle("OnHide", 1);
        OnHide = r101;
        AirActionConstant$AirSolutionLifecycle r102 = new AirActionConstant$AirSolutionLifecycle("OnViewLoad", 2);
        OnViewLoad = r102;
        f41338a = new AirActionConstant$AirSolutionLifecycle[]{r100, r101, r102};
    }

    public AirActionConstant$AirSolutionLifecycle(String r100, int r101) {
        super(r100, r101);
    }
}

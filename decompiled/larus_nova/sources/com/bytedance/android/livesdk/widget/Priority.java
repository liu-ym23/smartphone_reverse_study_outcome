package com.bytedance.android.livesdk.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/widget/Priority;", "", "VrPlayer", "VrDirectionIndicator", "VrClearMode", "ZoomAndLock", "NormalPinchZoom", "RightScroll2Leave", "ClickPS2CS", "AdvanceCSGesture", "Unknown", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Priority extends Enum<Priority> {
    public static final Priority AdvanceCSGesture = null;
    public static final Priority ClickPS2CS = null;
    public static final Priority NormalPinchZoom = null;
    public static final Priority RightScroll2Leave = null;
    public static final Priority Unknown = null;
    public static final Priority VrClearMode = null;
    public static final Priority VrDirectionIndicator = null;
    public static final Priority VrPlayer = null;
    public static final Priority ZoomAndLock = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f161233a = null;

    static {
        Priority r100 = new Priority("VrPlayer", 0);
        VrPlayer = r100;
        Priority r101 = new Priority("VrDirectionIndicator", 1);
        VrDirectionIndicator = r101;
        Priority r102 = new Priority("VrClearMode", 2);
        VrClearMode = r102;
        Priority r103 = new Priority("ZoomAndLock", 3);
        ZoomAndLock = r103;
        Priority r104 = new Priority("NormalPinchZoom", 4);
        NormalPinchZoom = r104;
        Priority r105 = new Priority("RightScroll2Leave", 5);
        RightScroll2Leave = r105;
        Priority r106 = new Priority("ClickPS2CS", 6);
        ClickPS2CS = r106;
        Priority r107 = new Priority("AdvanceCSGesture", 7);
        AdvanceCSGesture = r107;
        Priority r108 = new Priority("Unknown", 8);
        Unknown = r108;
        f161233a = new Priority[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static Priority valueOf(String r100) {
        return (Priority) r27.a.a(Priority.class, r100);
    }

    public static Priority[] values() {
        return (Priority[]) f161233a.clone();
    }

    public Priority(String r100, int r101) {
        super(r100, r101);
    }
}

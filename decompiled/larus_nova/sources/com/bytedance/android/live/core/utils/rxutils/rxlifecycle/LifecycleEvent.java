package com.bytedance.android.live.core.utils.rxutils.rxlifecycle;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final enum LifecycleEvent extends Enum<LifecycleEvent> {
    public static final LifecycleEvent ATTACH = null;
    public static final LifecycleEvent CREATE = null;
    public static final LifecycleEvent CREATE_VIEW = null;
    public static final LifecycleEvent DESTROY = null;
    public static final LifecycleEvent DESTROY_VIEW = null;
    public static final LifecycleEvent DETACH = null;
    public static final LifecycleEvent PAUSE = null;
    public static final LifecycleEvent RESUME = null;
    public static final LifecycleEvent START = null;
    public static final LifecycleEvent STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LifecycleEvent[] f66372a = null;

    static {
        LifecycleEvent r100 = new LifecycleEvent("ATTACH", 0);
        ATTACH = r100;
        LifecycleEvent r101 = new LifecycleEvent("CREATE", 1);
        CREATE = r101;
        LifecycleEvent r102 = new LifecycleEvent("CREATE_VIEW", 2);
        CREATE_VIEW = r102;
        LifecycleEvent r103 = new LifecycleEvent(GXAnimation.STATE_START, 3);
        START = r103;
        LifecycleEvent r104 = new LifecycleEvent("RESUME", 4);
        RESUME = r104;
        LifecycleEvent r105 = new LifecycleEvent("PAUSE", 5);
        PAUSE = r105;
        LifecycleEvent r110 = new LifecycleEvent("STOP", 6);
        STOP = r110;
        LifecycleEvent r111 = new LifecycleEvent("DESTROY_VIEW", 7);
        DESTROY_VIEW = r111;
        LifecycleEvent r112 = new LifecycleEvent("DESTROY", 8);
        DESTROY = r112;
        LifecycleEvent r113 = new LifecycleEvent("DETACH", 9);
        DETACH = r113;
        f66372a = new LifecycleEvent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static LifecycleEvent[] values() {
        return (LifecycleEvent[]) f66372a.clone();
    }

    public static LifecycleEvent valueOf(String r100) {
        return (LifecycleEvent) a.a(LifecycleEvent.class, r100);
    }

    public LifecycleEvent(String r100, int r101) {
        super(r100, r101);
    }
}

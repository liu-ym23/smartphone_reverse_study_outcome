package com.bytedance.android.ec.vlayout.extend;

import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public final enum ViewLifeCycleHelper$STATUS extends Enum<ViewLifeCycleHelper$STATUS> {
    public static final ViewLifeCycleHelper$STATUS APPEARED = null;
    public static final ViewLifeCycleHelper$STATUS APPEARING = null;
    public static final ViewLifeCycleHelper$STATUS DISAPPEARED = null;
    public static final ViewLifeCycleHelper$STATUS DISAPPEARING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewLifeCycleHelper$STATUS[] f49100a = null;

    static {
        ViewLifeCycleHelper$STATUS r100 = new ViewLifeCycleHelper$STATUS("APPEARING", 0);
        APPEARING = r100;
        ViewLifeCycleHelper$STATUS r101 = new ViewLifeCycleHelper$STATUS("APPEARED", 1);
        APPEARED = r101;
        ViewLifeCycleHelper$STATUS r102 = new ViewLifeCycleHelper$STATUS("DISAPPEARING", 2);
        DISAPPEARING = r102;
        ViewLifeCycleHelper$STATUS r103 = new ViewLifeCycleHelper$STATUS("DISAPPEARED", 3);
        DISAPPEARED = r103;
        f49100a = new ViewLifeCycleHelper$STATUS[]{r100, r101, r102, r103};
    }

    public static ViewLifeCycleHelper$STATUS[] values() {
        return (ViewLifeCycleHelper$STATUS[]) f49100a.clone();
    }

    public static ViewLifeCycleHelper$STATUS valueOf(String r100) {
        return (ViewLifeCycleHelper$STATUS) a.a(ViewLifeCycleHelper$STATUS.class, r100);
    }

    public ViewLifeCycleHelper$STATUS(String r100, int r101) {
        super(r100, r101);
    }
}

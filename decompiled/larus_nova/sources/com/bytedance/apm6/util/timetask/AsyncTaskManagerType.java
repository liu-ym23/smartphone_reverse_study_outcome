package com.bytedance.apm6.util.timetask;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum AsyncTaskManagerType extends Enum<AsyncTaskManagerType> {
    public static final AsyncTaskManagerType CPU = null;
    public static final AsyncTaskManagerType IO = null;
    public static final AsyncTaskManagerType LIGHT_WEIGHT = null;
    public static final AsyncTaskManagerType TIME_SENSITIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsyncTaskManagerType[] f190835a = null;

    static {
        AsyncTaskManagerType r100 = new AsyncTaskManagerType("IO", 0);
        IO = r100;
        AsyncTaskManagerType r101 = new AsyncTaskManagerType("LIGHT_WEIGHT", 1);
        LIGHT_WEIGHT = r101;
        AsyncTaskManagerType r102 = new AsyncTaskManagerType("TIME_SENSITIVE", 2);
        TIME_SENSITIVE = r102;
        AsyncTaskManagerType r103 = new AsyncTaskManagerType("CPU", 3);
        CPU = r103;
        f190835a = new AsyncTaskManagerType[]{r100, r101, r102, r103};
    }

    public static AsyncTaskManagerType[] values() {
        return (AsyncTaskManagerType[]) f190835a.clone();
    }

    public static AsyncTaskManagerType valueOf(String r100) {
        return (AsyncTaskManagerType) a.a(AsyncTaskManagerType.class, r100);
    }

    public AsyncTaskManagerType(String r100, int r101) {
        super(r100, r101);
    }
}

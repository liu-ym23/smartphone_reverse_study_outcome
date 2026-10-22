package com.bytedance.android.ec.window.base.utils.taskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/utils/taskmanager/WindowExecutorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "DEFAULT", "COMPUTE_HIGH_LEVEL", "COMPUTE", "IO", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowExecutorType extends Enum<WindowExecutorType> {
    public static final WindowExecutorType COMPUTE = null;
    public static final WindowExecutorType COMPUTE_HIGH_LEVEL = null;
    public static final WindowExecutorType DEFAULT = null;
    public static final WindowExecutorType IO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowExecutorType[] f49772a = null;
    private final String value;

    static {
        WindowExecutorType r100 = new WindowExecutorType("DEFAULT", 0, "ec_default");
        DEFAULT = r100;
        WindowExecutorType r101 = new WindowExecutorType("COMPUTE_HIGH_LEVEL", 1, "ec_compute_high_level");
        COMPUTE_HIGH_LEVEL = r101;
        WindowExecutorType r102 = new WindowExecutorType("COMPUTE", 2, "ec_compute");
        COMPUTE = r102;
        WindowExecutorType r103 = new WindowExecutorType("IO", 3, "ec_io");
        IO = r103;
        f49772a = new WindowExecutorType[]{r100, r101, r102, r103};
    }

    public static WindowExecutorType valueOf(String r100) {
        return (WindowExecutorType) r27.a.a(WindowExecutorType.class, r100);
    }

    public static WindowExecutorType[] values() {
        return (WindowExecutorType[]) f49772a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public WindowExecutorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

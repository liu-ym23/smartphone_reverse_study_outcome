package com.bytedance.android.ec.store.utils.taskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/utils/taskmanager/ExecutorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "DEFAULT", "COMPUTE_HIGH_LEVEL", "COMPUTE", "IO", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExecutorType extends Enum<ExecutorType> {
    public static final ExecutorType COMPUTE = null;
    public static final ExecutorType COMPUTE_HIGH_LEVEL = null;
    public static final ExecutorType DEFAULT = null;
    public static final ExecutorType IO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecutorType[] f48690a = null;
    private final String value;

    static {
        ExecutorType r100 = new ExecutorType("DEFAULT", 0, "ec_default");
        DEFAULT = r100;
        ExecutorType r101 = new ExecutorType("COMPUTE_HIGH_LEVEL", 1, "ec_compute_high_level");
        COMPUTE_HIGH_LEVEL = r101;
        ExecutorType r102 = new ExecutorType("COMPUTE", 2, "ec_compute");
        COMPUTE = r102;
        ExecutorType r103 = new ExecutorType("IO", 3, "ec_io");
        IO = r103;
        f48690a = new ExecutorType[]{r100, r101, r102, r103};
    }

    public static ExecutorType valueOf(String r100) {
        return (ExecutorType) r27.a.a(ExecutorType.class, r100);
    }

    public static ExecutorType[] values() {
        return (ExecutorType[]) f48690a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ExecutorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

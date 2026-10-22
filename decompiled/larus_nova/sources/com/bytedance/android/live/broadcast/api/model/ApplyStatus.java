package com.bytedance.android.live.broadcast.api.model;

/* JADX INFO: loaded from: classes45.dex */
public final enum ApplyStatus extends Enum<ApplyStatus> {
    public static final ApplyStatus AlreadyHasPermission = null;
    public static final ApplyStatus CanApply = null;
    public static final ApplyStatus CanNotApply = null;
    public static final ApplyStatus Submitted = null;
    public static final ApplyStatus Unknow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyStatus[] f59013a = null;
    public int code;

    static {
        ApplyStatus r100 = new ApplyStatus("Unknow", 0, 0);
        Unknow = r100;
        ApplyStatus r101 = new ApplyStatus("CanNotApply", 1, 1);
        CanNotApply = r101;
        ApplyStatus r102 = new ApplyStatus("CanApply", 2, 2);
        CanApply = r102;
        ApplyStatus r103 = new ApplyStatus("Submitted", 3, 3);
        Submitted = r103;
        ApplyStatus r104 = new ApplyStatus("AlreadyHasPermission", 4, 99);
        AlreadyHasPermission = r104;
        f59013a = new ApplyStatus[]{r100, r101, r102, r103, r104};
    }

    public static ApplyStatus[] values() {
        return (ApplyStatus[]) f59013a.clone();
    }

    public static ApplyStatus valueOf(String r100) {
        return (ApplyStatus) r27.a.a(ApplyStatus.class, r100);
    }

    public ApplyStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}

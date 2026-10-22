package com.bytedance.android.ec.model.response.anchorv3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ScarceBuyStatus;", "", "", "status", "I", "getStatus", "()I", "NOT_INVOLVED", "TASK_ONGOING", "TASK_FINISHED", "LOTTERY_WON", "NON_REMAINING_QUALIFICATION", "NOT_QUALIFIED", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ScarceBuyStatus extends Enum<ScarceBuyStatus> {
    public static final ScarceBuyStatus LOTTERY_WON = null;
    public static final ScarceBuyStatus NON_REMAINING_QUALIFICATION = null;
    public static final ScarceBuyStatus NOT_INVOLVED = null;
    public static final ScarceBuyStatus NOT_QUALIFIED = null;
    public static final ScarceBuyStatus TASK_FINISHED = null;
    public static final ScarceBuyStatus TASK_ONGOING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScarceBuyStatus[] f47942a = null;
    private final int status;

    static {
        ScarceBuyStatus r100 = new ScarceBuyStatus("NOT_INVOLVED", 0, 1);
        NOT_INVOLVED = r100;
        ScarceBuyStatus r101 = new ScarceBuyStatus("TASK_ONGOING", 1, 2);
        TASK_ONGOING = r101;
        ScarceBuyStatus r102 = new ScarceBuyStatus("TASK_FINISHED", 2, 3);
        TASK_FINISHED = r102;
        ScarceBuyStatus r103 = new ScarceBuyStatus("LOTTERY_WON", 3, 4);
        LOTTERY_WON = r103;
        ScarceBuyStatus r104 = new ScarceBuyStatus("NON_REMAINING_QUALIFICATION", 4, 5);
        NON_REMAINING_QUALIFICATION = r104;
        ScarceBuyStatus r105 = new ScarceBuyStatus("NOT_QUALIFIED", 5, 6);
        NOT_QUALIFIED = r105;
        f47942a = new ScarceBuyStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static ScarceBuyStatus valueOf(String r100) {
        return (ScarceBuyStatus) r27.a.a(ScarceBuyStatus.class, r100);
    }

    public static ScarceBuyStatus[] values() {
        return (ScarceBuyStatus[]) f47942a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public ScarceBuyStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}

package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/concert_stage/biz/StageStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "SHOW", "HIDE", "TWO_ROWS", "ONE_ROW", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StageStatus extends Enum<StageStatus> {
    public static final StageStatus HIDE = null;
    public static final StageStatus ONE_ROW = null;
    public static final StageStatus SHOW = null;
    public static final StageStatus TWO_ROWS = null;
    public static final StageStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageStatus[] f143726a = null;
    private final int value;

    static {
        StageStatus r100 = new StageStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        StageStatus r101 = new StageStatus("SHOW", 1, 1);
        SHOW = r101;
        StageStatus r102 = new StageStatus("HIDE", 2, 2);
        HIDE = r102;
        StageStatus r103 = new StageStatus("TWO_ROWS", 3, 3);
        TWO_ROWS = r103;
        StageStatus r104 = new StageStatus("ONE_ROW", 4, 4);
        ONE_ROW = r104;
        f143726a = new StageStatus[]{r100, r101, r102, r103, r104};
    }

    public static StageStatus valueOf(String r100) {
        return (StageStatus) r27.a.a(StageStatus.class, r100);
    }

    public static StageStatus[] values() {
        return (StageStatus[]) f143726a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public StageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

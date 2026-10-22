package com.bytedance.android.live.ktv.common.model.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/SwitchStatus;", "", "", "value", "J", "getValue", "()J", "OPEN", "CLOSE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchStatus extends Enum<SwitchStatus> {
    public static final SwitchStatus CLOSE = null;
    public static final SwitchStatus OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchStatus[] f69992a = null;
    private final long value;

    static {
        SwitchStatus r100 = new SwitchStatus("OPEN", 0, 1);
        OPEN = r100;
        SwitchStatus r101 = new SwitchStatus("CLOSE", 1, 2);
        CLOSE = r101;
        f69992a = new SwitchStatus[]{r100, r101};
    }

    public static SwitchStatus valueOf(String r100) {
        return (SwitchStatus) r27.a.a(SwitchStatus.class, r100);
    }

    public static SwitchStatus[] values() {
        return (SwitchStatus[]) f69992a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public SwitchStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}

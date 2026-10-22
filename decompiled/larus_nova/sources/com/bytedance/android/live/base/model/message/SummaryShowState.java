package com.bytedance.android.live.base.model.message;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/SummaryShowState;", "", "", "value", "I", "getValue", "()I", "SummaryShowStateUnDefined", "SummaryShowStateShow", "SummaryShowStateHide", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SummaryShowState extends Enum<SummaryShowState> {
    public static final SummaryShowState SummaryShowStateHide = null;
    public static final SummaryShowState SummaryShowStateShow = null;
    public static final SummaryShowState SummaryShowStateUnDefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SummaryShowState[] f58855a = null;
    private final int value;

    static {
        SummaryShowState r100 = new SummaryShowState("SummaryShowStateUnDefined", 0, 0);
        SummaryShowStateUnDefined = r100;
        SummaryShowState r101 = new SummaryShowState("SummaryShowStateShow", 1, 1);
        SummaryShowStateShow = r101;
        SummaryShowState r102 = new SummaryShowState("SummaryShowStateHide", 2, 2);
        SummaryShowStateHide = r102;
        f58855a = new SummaryShowState[]{r100, r101, r102};
    }

    public static SummaryShowState valueOf(String r100) {
        return (SummaryShowState) r27.a.a(SummaryShowState.class, r100);
    }

    public static SummaryShowState[] values() {
        return (SummaryShowState[]) f58855a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SummaryShowState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

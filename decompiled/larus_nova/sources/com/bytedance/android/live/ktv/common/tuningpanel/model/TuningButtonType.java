package com.bytedance.android.live.ktv.common.tuningpanel.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/model/TuningButtonType;", "", "", "value", "I", "getValue", "()I", "ORIGIN_ITEM", "SCORE_ITEM", "ECHO_ITEM", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TuningButtonType extends Enum<TuningButtonType> {
    public static final TuningButtonType ECHO_ITEM = null;
    public static final TuningButtonType ORIGIN_ITEM = null;
    public static final TuningButtonType SCORE_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TuningButtonType[] f70470a = null;
    private final int value;

    static {
        TuningButtonType r100 = new TuningButtonType("ORIGIN_ITEM", 0, 0);
        ORIGIN_ITEM = r100;
        TuningButtonType r101 = new TuningButtonType("SCORE_ITEM", 1, 1);
        SCORE_ITEM = r101;
        TuningButtonType r102 = new TuningButtonType("ECHO_ITEM", 2, 2);
        ECHO_ITEM = r102;
        f70470a = new TuningButtonType[]{r100, r101, r102};
    }

    public static TuningButtonType valueOf(String r100) {
        return (TuningButtonType) a.a(TuningButtonType.class, r100);
    }

    public static TuningButtonType[] values() {
        return (TuningButtonType[]) f70470a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TuningButtonType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

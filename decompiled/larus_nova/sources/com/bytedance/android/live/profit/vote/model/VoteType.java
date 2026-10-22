package com.bytedance.android.live.profit.vote.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/VoteType;", "", "", "value", "J", "getValue", "()J", "Normal", "Ktv", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteType extends Enum<VoteType> {
    public static final VoteType Ktv = null;
    public static final VoteType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoteType[] f89236a = null;
    private final long value;

    static {
        VoteType r100 = new VoteType("Normal", 0, 1);
        Normal = r100;
        VoteType r101 = new VoteType("Ktv", 1, 2);
        Ktv = r101;
        f89236a = new VoteType[]{r100, r101};
    }

    public static VoteType valueOf(String r100) {
        return (VoteType) r27.a.a(VoteType.class, r100);
    }

    public static VoteType[] values() {
        return (VoteType[]) f89236a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public VoteType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}

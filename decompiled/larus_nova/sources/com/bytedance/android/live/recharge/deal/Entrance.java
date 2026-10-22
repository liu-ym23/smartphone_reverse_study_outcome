package com.bytedance.android.live.recharge.deal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/Entrance;", "", "", "value", "I", "getValue", "()I", "Unknown", "Wallet", "Recharge", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Entrance extends Enum<Entrance> {
    public static final Entrance Recharge = null;
    public static final Entrance Unknown = null;
    public static final Entrance Wallet = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Entrance[] f89691a = null;
    private final int value;

    static {
        Entrance r100 = new Entrance("Unknown", 0, 0);
        Unknown = r100;
        Entrance r101 = new Entrance("Wallet", 1, 1);
        Wallet = r101;
        Entrance r102 = new Entrance("Recharge", 2, 2);
        Recharge = r102;
        f89691a = new Entrance[]{r100, r101, r102};
    }

    public static Entrance valueOf(String r100) {
        return (Entrance) r27.a.a(Entrance.class, r100);
    }

    public static Entrance[] values() {
        return (Entrance[]) f89691a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Entrance(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

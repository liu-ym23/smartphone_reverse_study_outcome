package com.bytedance.android.livesdk.gift.biggift.viewModel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/viewModel/CurrentState;", "", "Init", "Combo", "DisMiss", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CurrentState extends Enum<CurrentState> {
    public static final CurrentState Combo = null;
    public static final CurrentState DisMiss = null;
    public static final CurrentState Init = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CurrentState[] f125992a = null;

    static {
        CurrentState r100 = new CurrentState("Init", 0);
        Init = r100;
        CurrentState r101 = new CurrentState("Combo", 1);
        Combo = r101;
        CurrentState r102 = new CurrentState("DisMiss", 2);
        DisMiss = r102;
        f125992a = new CurrentState[]{r100, r101, r102};
    }

    public static CurrentState valueOf(String r100) {
        return (CurrentState) r27.a.a(CurrentState.class, r100);
    }

    public static CurrentState[] values() {
        return (CurrentState[]) f125992a.clone();
    }

    public CurrentState(String r100, int r101) {
        super(r100, r101);
    }
}

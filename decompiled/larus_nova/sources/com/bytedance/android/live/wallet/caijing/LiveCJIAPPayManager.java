package com.bytedance.android.live.wallet.caijing;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveCJIAPPayManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f102660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LiveCJIAPPayManager f102661b = null;

    public LiveCJIAPPayManager() {
    }

    static {
        f102661b = new LiveCJIAPPayManager();
        f102660a = LazyKt.lazy(LiveCJIAPPayManager$iapService$2.INSTANCE);
    }
}

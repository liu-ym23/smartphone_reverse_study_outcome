package com.android.ttcjpaysdk.base.settings.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/utils/CJPaySettingStorage;", "", "()V", "isStdCashierOptEnabled", "", "()Z", "isStdCashierOptEnabled$delegate", "Lkotlin/Lazy;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySettingStorage {
    public static final CJPaySettingStorage INSTANCE = null;
    private static final Lazy isStdCashierOptEnabled$delegate = null;

    private CJPaySettingStorage() {
    }

    static {
        INSTANCE = new CJPaySettingStorage();
        isStdCashierOptEnabled$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    public final boolean isStdCashierOptEnabled() {
        return ((Boolean) isStdCashierOptEnabled$delegate.getValue()).booleanValue();
    }
}

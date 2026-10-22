package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"DefaultToastUiConfig", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "getDefaultToastUiConfig", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "DefaultToastUiConfig$delegate", "Lkotlin/Lazy;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJToastKt {
    private static final Lazy DefaultToastUiConfig$delegate = null;

    static {
        DefaultToastUiConfig$delegate = LazyKt.lazy(CJToastKt$DefaultToastUiConfig$2.INSTANCE);
    }

    public static final ToastUiConfig getDefaultToastUiConfig() {
        return (ToastUiConfig) DefaultToastUiConfig$delegate.getValue();
    }
}

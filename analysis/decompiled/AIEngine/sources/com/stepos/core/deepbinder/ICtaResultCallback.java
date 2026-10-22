package com.stepos.core.deepbinder;

import com.stepos.deepbinder.annotation.type.Callback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Callback
/* loaded from: classes.dex */
public interface ICtaResultCallback {
    void onRecycle();

    void onResult(boolean z);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static void onRecycle(ICtaResultCallback iCtaResultCallback) {
        }
    }
}

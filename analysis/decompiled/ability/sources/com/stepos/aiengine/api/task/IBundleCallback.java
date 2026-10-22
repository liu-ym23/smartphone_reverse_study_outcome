package com.stepos.aiengine.api.task;

import C7.c;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/api/task/IBundleCallback;", "", "Landroid/os/Bundle;", "bundle", "LC7/r;", "onCall", "(Landroid/os/Bundle;)V", "onResult", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IBundleCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCall(IBundleCallback iBundleCallback, Bundle bundle) {
            k.f(bundle, "bundle");
            iBundleCallback.onResult(bundle);
        }

        @c
        public static void onResult(IBundleCallback iBundleCallback, Bundle bundle) {
            k.f(bundle, "bundle");
            iBundleCallback.onCall(bundle);
        }
    }

    void onCall(Bundle bundle);

    @c
    void onResult(Bundle bundle);
}

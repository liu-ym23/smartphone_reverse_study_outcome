package com.bytedance.android.shopping.store.tabkit.brandmall;

import cl.d;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchLepus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/brandmall/NaPrefetchSyncCallback;", "Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchLepus$SyncCallback;", "()V", "fail", "", "result", "", "onFail", "onSuccess", "isFromNetEnd", "", "success", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class NaPrefetchSyncCallback implements NativePrefetchLepus.SyncCallback {
    public NaPrefetchSyncCallback() {
    }

    public abstract void onFail(String r100);

    public abstract void onSuccess(String r100, boolean r101);

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchLepus.SyncCallback
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        onFail(r100);
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchLepus.SyncCallback
    public final void success(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        d.f24079a.getClass();
        d r102 = d.a.b();
        if (r102 == null) goto L5;
        r102.n();
    L5:
        onSuccess(r100, r101);
    }
}

package com.bytedance.android.live.livepkaudience.dialog;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b0<V extends RevInteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f81800b;

    public final <R> AutoDisposeConverter<R> c() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(((RevLinkDialog) this.f81800b.f81771d).f81782k, Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(V r100) {
        this.f81800b = r100;
        this.f119692a = r100;
    }
}

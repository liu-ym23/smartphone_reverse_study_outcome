package com.bytedance.android.livesdk.interactivity.medialink.dialog.contract;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.common.d;
import t82.e;
import t82.f;

/* JADX INFO: loaded from: classes9.dex */
public abstract class MediaInteractDialogFragmentBaseContract$View<T extends e> extends BaseFragment implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f138106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f138107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f138108f;

    public abstract float T90();

    public View U90() {
        return null;
    }

    public abstract String V90();

    public ViewGroup X90() {
        return null;
    }

    public final <R> AutoDisposeConverter<R> S90() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.f138106d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public MediaInteractDialogFragmentBaseContract$View() {
        this.f138107e = getClass().getName();
    }

    public int W90(View r100) {
        return s1.f(56.0f);
    }
}

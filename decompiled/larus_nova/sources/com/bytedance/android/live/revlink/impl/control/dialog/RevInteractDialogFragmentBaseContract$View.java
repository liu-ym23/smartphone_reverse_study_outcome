package com.bytedance.android.live.revlink.impl.control.dialog;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.control.dialog.g;

/* JADX INFO: loaded from: classes47.dex */
public abstract class RevInteractDialogFragmentBaseContract$View<T extends g> extends BaseFragment implements com.bytedance.android.livesdk.common.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f92314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f92315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f92316f;

    public abstract float U90();

    public View V90() {
        return null;
    }

    public View W90() {
        return null;
    }

    public abstract String X90();

    public ViewGroup Z90() {
        return null;
    }

    public <S> AutoDisposeConverter<S> S90() {
        return AutoDispose.bind(this.f92314d.getLifecycleOwner());
    }

    public final <R> AutoDisposeConverter<R> T90() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.f92314d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public RevInteractDialogFragmentBaseContract$View() {
        this.f92315e = getClass().getName();
    }

    public Boolean aa0() {
        return Boolean.TRUE;
    }

    public int Y90(View r100) {
        return s1.f(56.0f);
    }
}

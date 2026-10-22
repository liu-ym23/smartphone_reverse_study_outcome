package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTabFragment extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f69591d;

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(View r100);

    public BaseTabFragment() {
        this.f69591d = LazyKt.lazy(BaseTabFragment$compositeDisposable$2.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((CompositeDisposable) this.f69591d.getValue()).clear();
    }

    public final void S90(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bind");
        ((CompositeDisposable) this.f69591d.getValue()).add(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = null;
        if (r101 == null) goto L7;
        Context r104 = r101.getContext();
        if (r104 == null) goto L7;
        r103 = LayoutInflater.from(r104).inflate(getLayoutId(), null);
    L7:
        initView(r103);
        return r103;
    }
}

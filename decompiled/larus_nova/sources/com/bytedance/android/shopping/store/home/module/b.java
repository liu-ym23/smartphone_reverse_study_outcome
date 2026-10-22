package com.bytedance.android.shopping.store.home.module;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.store.home.preload.resource.ECStoreResourcePreloadManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b extends QUIModule implements q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f183787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f183788m;

    public b() {
        throw null;
    }

    public abstract View k(ViewGroup r100);

    public b(int r100, Fragment r101) {
        super(r100, null);
        this.f183787l = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f183788m == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        this.f183788m = k(r101);
    L8:
        View r103 = this.f183788m;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public final View l(int r100, ViewGroup r101) {
        Context r102 = a().f450907b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        Context r103 = th.a.e(r102, true);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r104 = ((ECStoreResourcePreloadManager) ECStoreResourcePreloadManager.f183826c.getValue()).a(r103, r100);
        if (r104 != null) goto L10;
        ContextThemeWrapper r105 = new ContextThemeWrapper(th.a.e(r103, true), R.style.ECStoreActivityTheme);
        ShoppingAsyncInflater.f45268e.getClass();
        return ShoppingAsyncInflater.a.a(r105).aU(r100, r101, false);
    L10:
        return r104;
    }
}

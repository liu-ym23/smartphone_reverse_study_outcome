package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a extends QUIModule implements k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f188233l;

    public a() {
        this(null);
    }

    public abstract View k(ViewGroup r100);

    public final View l() {
        View r100 = this.f188233l;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r100;
    }

    public a(Object r100) {
        super(-1, null);
    }

    public a(int r100) {
        super(r100, null);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f188233l == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        this.f188233l = k(r101);
    L8:
        View r103 = this.f188233l;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        return r103;
    L5:
        r102 = false;
        goto L6
    }
}

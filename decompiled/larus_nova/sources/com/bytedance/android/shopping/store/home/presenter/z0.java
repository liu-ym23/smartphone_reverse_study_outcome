package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class z0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f184471a;

    public z0(View r100) {
        this.f184471a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((com.bytedance.android.shopping.store.home.entity.n) r100) == null) goto L6;
        View r101 = this.f184471a;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 1;
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
        r101.setPadding(0, ExtensionsKt.a(40), 0, 0);
        return;
    }
}

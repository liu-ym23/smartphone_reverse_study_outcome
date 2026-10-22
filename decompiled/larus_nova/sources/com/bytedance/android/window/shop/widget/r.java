package com.bytedance.android.window.shop.widget;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolBarView f190107a;

    public r(ToolBarView r100) {
        this.f190107a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L13;
        LifecycleOwner r101 = this.f190107a.getLifecycleOwner();
        if (r101 == null) goto L12;
        ConstraintLayout r102 = this.f190107a.f189894g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");
    L10:
        r102.post(new q(r101, this));
        return;
    L12:
        return;
    }
}

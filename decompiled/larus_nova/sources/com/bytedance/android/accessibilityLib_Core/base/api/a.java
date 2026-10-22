package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.accessibilityLib_Core.processor.TraverseFromType;
import com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.e;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractAccessibilityLibIsolation f38133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f38134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TraverseFromType f38135c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        if (("onViewAttachedToWindow " + r100) == null) goto L5;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L5:
        if (r100 == null) goto L8;
        Lazy r102 = ViewTraverseProcessor.f38299a;
        ViewTraverseProcessor.b(r100, e.a(r100), this.f38135c);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (("onViewDetachedToWindow, " + r100) == null) goto L6;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L6:
        AbstractAccessibilityLibIsolation.e(this.f38133a, r100);
    }

    public a(AbstractAccessibilityLibIsolation r100, View r101, TraverseFromType r102) {
        this.f38133a = r100;
        this.f38134b = r101;
        this.f38135c = r102;
    }
}

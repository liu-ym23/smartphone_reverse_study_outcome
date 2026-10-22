package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f38308a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = (View) this.f38308a.get();     // Catch: Exception -> L10
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAttachedToWindow() == true) goto L7;
        return;
    L7:
        Lazy r101 = ViewTraverseProcessor.f38299a;     // Catch: Exception -> L10
        ViewTraverseProcessor.b(r100, com.bytedance.android.accessibilityLib_Core.tool.e.a(r100), TraverseFromType.ActivityGlobalLayoutChange);     // Catch: Exception -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L14;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L14:
        Unit r104 = Unit.INSTANCE;
    }

    public d(WeakReference r100) {
        this.f38308a = r100;
    }
}

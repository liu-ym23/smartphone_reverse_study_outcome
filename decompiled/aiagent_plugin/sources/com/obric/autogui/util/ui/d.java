package com.obric.autogui.util.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: KeyboardUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f31580a = null;

    static {
        f31580a = new d();
    }

    /* JADX INFO: renamed from: lambda$Wnzm6k5_i6FQWpghLYjKocsa-Ew, reason: not valid java name */
    public static /* synthetic */ void m920lambda$Wnzm6k5_i6FQWpghLYjKocsaEw(View r0) {
        b(r0);
    }

    private d() {
    }

    public static final /* synthetic */ void a(View r0) {
        c(r0);
    }

    private static final void c(final View r1) {
        if (r1.isFocused() == false) goto L6;
        r1.post(new $$Lambda$d$Wnzm6k5_i6FQWpghLYjKocsaEw(r1));
        return;
    }

    private static final void b(View r3) {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        o.a(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.aiagent.plugin")).showSoftInput(r3, 1);
    }

    public final void a(final EditText r2, p r3) {
        p r1 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        if (r1 != null) goto L5;
    L7:
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        o.a(r4, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r4, InputMethodManager.class, "com.obric.aiagent.plugin")).restartInput((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        r2.requestFocus();
        if (r2.hasWindowFocus() == false) goto L10;
        c((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        r2.getViewTreeObserver().addOnWindowFocusChangeListener((ViewTreeObserver.OnWindowFocusChangeListener) ZeusTransformUtils.preCheckCast(new KeyboardUtils$showKeyboard$1(r2), ViewTreeObserver.OnWindowFocusChangeListener.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r1.getLifecycle().b() == i.b.f2058e) goto L7;
    }
}

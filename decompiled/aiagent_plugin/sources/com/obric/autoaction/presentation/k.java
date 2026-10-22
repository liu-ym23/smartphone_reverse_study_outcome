package com.obric.autoaction.presentation;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static /* synthetic */ void lambda$oGfkjlSVXgJXCjivC9JabPv4WOA(EditText r0, boolean r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$soeWx-J5pp1d17xsOZfbtHudRSQ, reason: not valid java name */
    public static /* synthetic */ void m637lambda$soeWxJ5pp1d17xsOZfbtHudRSQ(TextView r0) {
        b(r0);
    }

    public static final void a(final View r3, final EditText r4) {
        o.e(r3, "<this>");
        if (r4 == null) goto L13;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        r3.setEnabled(!r1);
        r4.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new ViewExtKt$attachToEditText$1$1(r4, r3), TextWatcher.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        if (d.o.o.d(r0) == true) goto L10;
        r1 = false;
        goto L11
    }

    public static final void a(final EditText r2) {
        o.e(r2, "<this>");
        r2.requestFocus();
        r2.getViewTreeObserver().addOnWindowFocusChangeListener(new $$Lambda$k$oGfkjlSVXgJXCjivC9JabPv4WOA(r2));
    }

    private static final void a(EditText r2, boolean r3) {
        if (r3 == true) goto L4;
        r2.requestFocus();
    L4:
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        o.a(r4, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r4, InputMethodManager.class, "com.obric.aiagent.plugin")).showSoftInput((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 1);
    }

    public static final void a(final TextView r1) {
        o.e(r1, "<this>");
        r1.post(new $$Lambda$k$soeWxJ5pp1d17xsOZfbtHudRSQ(r1));
    }

    private static final void b(TextView r2) {
        int r1 = 1;
        if (r2.getLineCount() == 1) goto L6;
        r1 = 8388611;
    L6:
        r2.setGravity(r1);
    }
}

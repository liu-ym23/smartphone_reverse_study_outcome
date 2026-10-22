package com.obric.oui.animation.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final List<EditText> a(View r6) {
        o.e(r6, "view");
        List<EditText> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L8;
        int r1 = 0;
        int r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L5:
        if (r1 >= r3) goto L10;
        int r4 = r1 + 1;
        View r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r1);
        o.c(r2, "child");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r2), Collection.class, "com.obric.aiagent.plugin"));
        r1 = r4;
    L10:
        return r0;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, EditText.class) == false) goto L10;
        r0.add(r6);
        goto L10
    }

    public static final void b(View r4) {
        o.e(r4, "rootView");
        List<EditText> r0 = a(r4);
        Object r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r6 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r5, InputMethodManager.class, "com.obric.aiagent.plugin");
        Iterator<EditText> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        EditText r2 = (EditText) ZeusTransformUtils.preCheckCast(r1.next(), EditText.class, "com.obric.aiagent.plugin");
        if (r6.isActive((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r6.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        goto L4
    }
}

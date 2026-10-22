package com.stepos.agentframework.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/util/A;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/view/View;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class A {
    public static final A INSTANCE = new A();

    public final void a(Context context, View view) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(view, "view");
        Object systemService = context.getSystemService("input_method");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

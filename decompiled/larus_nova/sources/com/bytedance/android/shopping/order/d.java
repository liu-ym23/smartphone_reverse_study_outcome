package com.bytedance.android.shopping.order;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewPanelFragment f179673a;

    public d(PreviewPanelFragment r100) {
        this.f179673a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L17:
        if (r101 != null) goto L20;
        return;
    L20:
        if (r101.intValue() != 2) goto L29;
        a r102 = this.f179673a.f179623d;
        if (r102 == null) goto L30;
        r102.onFailed();
        return;
    L30:
        return;
    L29:
        return;
    L6:
        if (r101.intValue() != 1) goto L17;
        a r103 = this.f179673a.f179623d;
        if (r103 == null) goto L25;
        r103.a();
    L25:
        this.f179673a.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L27;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}

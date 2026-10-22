package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f169308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f169309b;

    public g(e r100, Function0 r101) {
        this.f169308a = r100;
        this.f169309b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PopupWindow r101 = this.f169308a.f169293a;
        if (r101 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L5:
        this.f169309b.invoke();
    }
}

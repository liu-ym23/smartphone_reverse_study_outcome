package com.bytedance.android.livesdk.chatroom.view;

import android.app.Activity;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k extends om3.e {

    public static final class a extends om3.e.a {
        public a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            super(r100);
        }
    }

    @Override // om3.e, android.widget.PopupWindow
    public final void dismiss() {
        if (getContentView() != null) goto L5;
    L10:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L5:
        if (getContentView().getVisibility() != 8) goto L10;
        om3.e.c r100 = this.f524268l;
        if (r100 == null) goto L9;
        r100.bubbleDismiss();
    L9:
        c();
    }

    public k(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
        j r101 = new j(this);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f524269m = r101;
    }
}

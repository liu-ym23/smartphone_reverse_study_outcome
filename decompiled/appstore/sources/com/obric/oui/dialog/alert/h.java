package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f14321a;

    public h(Function1 r10) {
        q.g(r10, ServerElements.BODY);
        this.f14321a = r10;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r10) {
        q.g(r10, "dialog");
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r10, FrameLayout r11) {
        q.g(r10, "context");
        q.g(r11, "parent");
        this.f14321a.invoke(r11);
    }
}

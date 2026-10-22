package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OViewStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<FrameLayout, x> f35062a;

    @Override // com.obric.oui.dialog.alert.d
    public void a(OAlertDialog r1) {
        o.e(r1, "dialog");
    }

    public c(d.h.a.b<? super FrameLayout, x> r3) {
        d.h.a.b<FrameLayout, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "body");
        this.f35062a = r4;
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(Context r3, FrameLayout r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r4, "parent");
        this.f35062a.invoke(r4);
    }
}

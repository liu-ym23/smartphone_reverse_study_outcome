package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: StyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<c, x> f35149a;

    public d(d.h.a.b<? super c, x> r3) {
        d.h.a.b<c, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "body");
        this.f35149a = r4;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AbstractDialog r3) {
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "dialogContainer");
        this.f35149a.invoke(r6);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AlertDialogHost r3) {
        AlertDialogHost r4 = (AlertDialogHost) ZeusTransformUtils.wrapperContextForParams(r3, AlertDialogHost.class, "com.obric.aiagent.plugin");
        o.e(r4, "host");
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r4);
    }
}

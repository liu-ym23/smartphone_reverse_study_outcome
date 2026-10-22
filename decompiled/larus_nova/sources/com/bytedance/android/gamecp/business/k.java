package com.bytedance.android.gamecp.business;

import androidx.appcompat.app.AlertDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements com.bytedance.android.gamecp.business.gallery.transfer.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f56143a;

    public k(Function3 r100) {
        this.f56143a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.gallery.transfer.d.a
    public final void a(AlertDialog r100, com.bytedance.android.gamecp.business.gallery.transfer.e r101) {
        Function3 r102 = this.f56143a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke("dismiss", r100, r101);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gallery.transfer.d.a
    public final void b(AlertDialog r100, com.bytedance.android.gamecp.business.gallery.transfer.e r101) {
        Function3 r102 = this.f56143a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke("show", r100, r101);
        return;
    }
}

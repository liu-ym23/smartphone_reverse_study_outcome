package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.content.DialogInterface;
import android.widget.TextView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f56966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f56967b;

    public b(e r100, Function2 r101) {
        this.f56966a = r100;
        this.f56967b = r101;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        e r101 = this.f56966a;
        boolean r102 = r101.f56976f;
        if (r102 == true) goto L10;
        TextView r103 = r101.f56978h;
        if (r103 == null) goto L11;
        bv.a r104 = r101.f56972b;
        if (r104 == null) goto L12;
        r104.a(r103, r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}

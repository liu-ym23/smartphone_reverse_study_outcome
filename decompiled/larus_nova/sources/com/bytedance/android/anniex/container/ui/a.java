package com.bytedance.android.anniex.container.ui;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXDialog f40560a;

    public a(AnnieXDialog r100) {
        this.f40560a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r102, "keyEvent");
        if (r101 == 4) goto L5;
    L15:
        return false;
    L5:
        if (r102.getAction() != 1) goto L15;
        ia.f r103 = this.f40560a.f40523d;
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L15;
        HybridLogger.m("AnnieXDialog", "====intercept backPress=====", null, null, 12);
        return true;
    L9:
        if (r103.canBackPress() == true) goto L11;
        r104 = true;
        goto L12
    }
}

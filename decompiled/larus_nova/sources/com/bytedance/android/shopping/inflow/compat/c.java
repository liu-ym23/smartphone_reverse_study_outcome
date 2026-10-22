package com.bytedance.android.shopping.inflow.compat;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToggleBottomSheetFragment f176288a;

    public c(ToggleBottomSheetFragment r100) {
        this.f176288a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r102.getAction() != 1) goto L7;
        this.f176288a.getClass();
        goto L7
    }
}

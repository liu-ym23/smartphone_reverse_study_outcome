package com.bytedance.android.shopping.anchorv3.compat;

import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToggleBottomSheetFragment f164803a;

    public h(ToggleBottomSheetFragment r100) {
        this.f164803a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
        return false;
    L5:
        if (r102.getAction() != 1) goto L13;
        Function0<Boolean> r103 = this.f164803a.f164779h;
        if (r103 == null) goto L14;
        Boolean r104 = r103.invoke();
        if (r104 != null) goto L11;
        return false;
    L11:
        return r104.booleanValue();
    L14:
        return false;
    L13:
        return false;
    }
}

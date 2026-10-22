package com.bytedance.android.shopping.store.tabkit.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabKitDialogFragment f186732a;

    public h(TabKitDialogFragment r100) {
        this.f186732a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L11;
        TabKitDialogFragment r103 = this.f186732a;
        TabKitFragment r104 = r103.f186704d;
        if (r104 == null) goto L8;
        r104.S90();
    L8:
        if (r103.f186704d == null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}

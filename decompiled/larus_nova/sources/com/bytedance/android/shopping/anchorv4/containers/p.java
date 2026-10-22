package com.bytedance.android.shopping.anchorv4.containers;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.shopping.anchorv4.containers.page.u;

/* JADX INFO: loaded from: classes12.dex */
public final class p implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProductDetailMergeFragment f166227a;

    public p(ProductDetailMergeFragment r100) {
        this.f166227a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
        return false;
    L5:
        if (r102.getAction() != 1) goto L13;
        u r103 = this.f166227a.f166206g;
        if (r103 == null) goto L14;
        com.bytedance.android.shopping.anchorv4.containers.page.n r104 = r103.f166325a;
        if (r104 != null) goto L11;
        return false;
    L11:
        return r104.onBackPressed();
    L14:
        return false;
    L13:
        return false;
    }
}

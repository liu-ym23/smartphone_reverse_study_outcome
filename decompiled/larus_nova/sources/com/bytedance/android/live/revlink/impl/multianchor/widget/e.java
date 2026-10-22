package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.revlink.impl.control.s;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f95161a;

    public e(com.bytedance.android.live.revlink.impl.pk.vm.linkout.g r100) {
        this.f95161a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f95161a.onDismiss();
    }
}

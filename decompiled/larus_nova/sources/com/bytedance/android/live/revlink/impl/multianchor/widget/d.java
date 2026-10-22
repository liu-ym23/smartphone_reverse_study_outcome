package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.revlink.impl.control.s;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f95137a;

    public d(PkAutoMatchManager.b r100) {
        this.f95137a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f95137a.onDismiss();
    }
}

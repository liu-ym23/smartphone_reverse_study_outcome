package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f93826a = null;

    static {
        f93826a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.dismiss();
    }
}

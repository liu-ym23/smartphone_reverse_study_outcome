package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f145792a = null;

    static {
        f145792a = new f();
    }

    public f() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}

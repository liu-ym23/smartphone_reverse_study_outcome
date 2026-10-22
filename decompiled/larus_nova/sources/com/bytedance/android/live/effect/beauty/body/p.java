package com.bytedance.android.live.effect.beauty.body;

import android.content.DialogInterface;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f67209a = null;

    static {
        f67209a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        int r102 = com.bytedance.android.live.effect.utils.a.f68866a;
        HashMap r103 = new HashMap();
        r103.put("is_reset", "0");
        com.bytedance.android.live.effect.utils.c.a("livesdk_anchor_beautybody_reset_confirm", r103, "");
    }
}

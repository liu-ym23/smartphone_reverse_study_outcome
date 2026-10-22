package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f79715a = null;

    static {
        f79715a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        nd0.g.g(2);
        kj0.b r102 = SelfDisciplineContext.Companion.d();
        if (r102 == null) goto L6;
        kj0.b.a.a(r102, 2, null, 6);
        return;
    }
}

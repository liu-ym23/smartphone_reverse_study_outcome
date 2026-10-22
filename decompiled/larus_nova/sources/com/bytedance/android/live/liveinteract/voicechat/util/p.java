package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f80873a;

    public p(Function0 r100) {
        this.f80873a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r102 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r102 == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r102);
    L5:
        r100.dismiss();
        Function0 r103 = this.f80873a;
        if (r103 == null) goto L9;
        Unit r104 = (Unit) r103.invoke();
        return;
    }
}

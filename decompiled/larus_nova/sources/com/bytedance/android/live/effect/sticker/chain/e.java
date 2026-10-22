package com.bytedance.android.live.effect.sticker.chain;

import android.content.DialogInterface;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f68165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f68166b;

    public e(Ref.BooleanRef r100, l r101) {
        this.f68165a = r100;
        this.f68166b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (this.f68165a.element == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.X3;
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
    L5:
        this.f68166b.a();
        r100.dismiss();
    }
}

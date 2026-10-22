package com.bytedance.android.live.effect.sticker.chain;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f68164a;

    public d(l r100) {
        this.f68164a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        l r102 = this.f68164a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("3D特效取消", "reason");
        r102.f68169b = false;
        r100.dismiss();
    }
}

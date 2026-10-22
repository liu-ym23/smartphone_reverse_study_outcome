package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f62368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f62369b;

    public d(Function1 r100, Bitmap r101) {
        this.f62368a = r100;
        this.f62369b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L7;
        e.f62375f.getClass();
        Function1<? super String, Unit> r101 = e.f62374e;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke("PixelCopy success");
    L6:
        this.f62368a.invoke(this.f62369b);
        return;
    L7:
        e.f62375f.getClass();
        Function1<? super String, Unit> r103 = e.f62374e;
        if (r103 == null) goto L10;
        Unit r104 = r103.invoke("PixelCopy failed, errcode: " + r100);
    L10:
        this.f62368a.invoke(null);
    }
}

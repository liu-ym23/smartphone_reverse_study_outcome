package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f105391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f105392b;

    public b(Bitmap r100, Function1 r101) {
        this.f105391a = r100;
        this.f105392b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        ALogger.e("BlackFrameDetectionUtil", "onPixelCopyFinished:" + r100);
        if (r100 != 0) goto L7;
        Function1 r101 = this.f105392b;
        if (r101 == null) goto L11;
        Unit r102 = (Unit) r101.invoke(this.f105391a);
        return;
    L11:
        return;
    L7:
        Function1 r103 = this.f105392b;
        if (r103 == null) goto L13;
        Unit r104 = (Unit) r103.invoke(null);
        return;
    }
}

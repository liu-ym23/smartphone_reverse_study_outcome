package com.bytedance.android.livesdk.chatroom.ui.framework.widget.util;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f113523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f113524b;

    public a(Bitmap r100, Function1 r101) {
        this.f113523a = r100;
        this.f113524b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        ALogger.e("BlackFrameDetectionUtil", "onPixelCopyFinished:" + r100);
        if (r100 != 0) goto L7;
        Function1 r101 = this.f113524b;
        if (r101 == null) goto L11;
        Unit r102 = (Unit) r101.invoke(this.f113523a);
        return;
    L11:
        return;
    L7:
        Function1 r103 = this.f113524b;
        if (r103 == null) goto L13;
        Unit r104 = (Unit) r103.invoke(null);
        return;
    }
}

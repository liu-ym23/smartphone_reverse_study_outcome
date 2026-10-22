package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f114545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f114546b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f114547a;

        public a(l r100) {
            this.f114547a = r100;
        }

        public final void a() {
            Bitmap r100 = this.f114547a.f114545a;
            if (r100 != null) goto L5;
        L8:
            ALogger.e("CatchUtils", "Bitmap is black or empty");
            this.f114547a.f114546b.invoke(null);
            return;
        L5:
            if (r100.sameAs(Bitmap.createBitmap(r100.getWidth(), this.f114547a.f114545a.getHeight(), Bitmap.Config.RGB_565)) == true) goto L8;
            l r101 = this.f114547a;
            r101.f114546b.invoke(r101.f114545a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public l(Bitmap r100, Function1 r101) {
        this.f114545a = r100;
        this.f114546b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L4;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    L4:
        ALogger.e("CatchUtils", "Error capturing bitmap");
        this.f114546b.invoke(null);
    }
}

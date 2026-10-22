package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.C1661b;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f19728a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f19729b;

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f19730c;

    public b(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
        this.f19728a = uri;
        this.f19729b = bitmap;
        this.f19730c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1661b.a("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) ImageManager.h(null).remove(this.f19728a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.zac;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = (c) arrayList.get(i10);
                Bitmap bitmap = this.f19729b;
                if (bitmap != null) {
                    cVar.c(ImageManager.a(null), bitmap, false);
                } else {
                    ImageManager.f(null).put(this.f19728a, Long.valueOf(SystemClock.elapsedRealtime()));
                    Context contextA = ImageManager.a(null);
                    ImageManager.c(null);
                    cVar.b(contextA, null, false);
                }
                ImageManager.g(null).remove(cVar);
            }
        }
        this.f19730c.countDown();
        synchronized (ImageManager.f19724a) {
            ImageManager.f19725b.remove(this.f19728a);
        }
    }
}

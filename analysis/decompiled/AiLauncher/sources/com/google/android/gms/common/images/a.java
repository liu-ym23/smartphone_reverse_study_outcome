package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.C1661b;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f19726a;

    /* renamed from: b, reason: collision with root package name */
    public final ParcelFileDescriptor f19727b;

    public a(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f19726a = uri;
        this.f19727b = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException, IOException {
        C1661b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f19727b;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z10 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e10) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f19726a)), e10);
                z10 = true;
            }
            try {
                this.f19727b.close();
            } catch (IOException e11) {
                Log.e("ImageManager", "closed failed", e11);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager.b(null).post(new b(null, this.f19726a, bitmapDecodeFileDescriptor, z10, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f19726a)));
        }
    }
}

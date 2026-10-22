package com.bytedance.android.ec.hybrid.list.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.StatFs;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.ota.g2.j0;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f47344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SimpleDraweeView f47345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f47346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f47347e;

    public n(int r100, int r101, SimpleDraweeView r102, Context r103, String r104) {
        this.f47343a = r100;
        this.f47344b = r101;
        this.f47345c = r102;
        this.f47346d = r103;
        this.f47347e = r104;
    }

    public final void a() {
        boolean r100 = o.f47348a;
        Context r101 = this.f47346d;
        String r102 = this.f47347e;
        SimpleDraweeView r103 = this.f47345c;
        int r104 = this.f47343a;
        int r105 = this.f47344b;
        Drawable r106 = r103.getDrawable();
        boolean r107 = false;
        if (r106 != null) goto L30;
    L8:
        Bitmap r108 = null;
    L9:
        if (r108 == null) goto L39;
        if (new StatFs(r101.getFilesDir().getAbsolutePath()).getAvailableBytes() < j0.G2_OTA_SPACE_CHECK_BYTES) goto L16;
        r107 = true;
    L16:
        if (r107 == false) goto L40;
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(o.b(r101, r102));     // Catch: Exception -> L27
        r108.compress(Bitmap.CompressFormat.PNG, 100, r109);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r109, null);     // Catch: Exception -> L27
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Exception -> L27
        throw th;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L40:
        return;
    L39:
        return;
    L30:
        r108 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L7
        Canvas r110 = new Canvas(r108);     // Catch: Exception -> L7
        r106.setBounds(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L7
        r106.draw(r110);     // Catch: Exception -> L7
        goto L9
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

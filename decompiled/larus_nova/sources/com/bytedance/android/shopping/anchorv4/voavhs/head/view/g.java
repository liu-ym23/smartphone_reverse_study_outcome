package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FindSameView.d f168939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f168940b;

    public g(AnchorV4FindSameView.d r100, Bitmap r101) {
        this.f168939a = r100;
        this.f168940b = r101;
    }

    public final void a() {
        Bitmap r100 = this.f168940b;
        if (r100 == null) goto L30;
        AnchorV4FindSameView r101 = this.f168939a.f168893a;
        Resources r102 = this.f168939a.f168893a.getContext().getResources();
        AnchorV4FindSameView r103 = this.f168939a.f168893a;
        int r104 = com.bytedance.android.shopping.extensions.b.b(24);
        r103.getClass();
        Bitmap.Config r105 = r100.getConfig();
        if (r105 != null) goto L7;
        r105 = Bitmap.Config.ARGB_8888;
    L7:
        Bitmap r106 = r100.copy(r105, true);
        Context r107 = r103.getContext();
        int r108 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r104));
        RenderScript r109 = RenderScript.create(r107);     // Catch: Exception -> L21
        Bitmap r110 = Bitmap.createBitmap(r100);     // Catch: Exception -> L21
        Allocation r111 = Allocation.createFromBitmap(r109, r110, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Exception -> L21
        Allocation r112 = Allocation.createTyped(r109, r111.getType());     // Catch: Exception -> L21
        ScriptIntrinsicBlur r113 = ScriptIntrinsicBlur.create(r109, Element.U8_4(r109));     // Catch: Exception -> L21
    L9:
        if (r108 <= 0) goto L19;
        int r114 = r108 - 10;     // Catch: Exception -> L21
        if (r114 <= 0) goto L13;
        float r115 = 10.0f;
    L14:
        r113.setRadius(r115);     // Catch: Exception -> L21
        r113.setInput(r111);     // Catch: Exception -> L21
        r113.forEach(r112);     // Catch: Exception -> L21
        if (r114 > 0) goto L17;
        r112.copyTo(r106);     // Catch: Exception -> L21
    L18:
        r108 = r114;
        goto L9
    L17:
        r111.copyFrom(r112);     // Catch: Exception -> L21
        goto L18
    L13:
        r115 = r108;
        goto L14
    L19:
        r110.recycle();     // Catch: Exception -> L21
    L23:
        r100.recycle();
        r101.setBackground(new BitmapDrawable(r102, r106));
        return;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
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

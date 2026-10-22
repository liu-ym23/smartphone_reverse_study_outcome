package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f168032e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f168033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f168034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f168035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f168036d;

    public b() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void release() {
        Allocation r100 = this.f168035c;
        if (r100 == null) goto L5;
        r100.destroy();
        this.f168035c = null;
    L5:
        Allocation r101 = this.f168036d;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f168036d = null;
    L8:
        ScriptIntrinsicBlur r102 = this.f168034b;
        if (r102 == null) goto L11;
        r102.destroy();
        this.f168034b = null;
    L11:
        RenderScript r103 = this.f168033a;
        if (r103 == null) goto L15;
        r103.destroy();
        this.f168033a = null;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void b(Bitmap r100, Bitmap r101) {
        this.f168035c.copyFrom(r100);
        this.f168034b.setInput(this.f168035c);
        this.f168034b.forEach(this.f168036d);
        this.f168036d.copyTo(r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final boolean a(Context r100, Bitmap r101, float r102) {
        boolean r103 = true;
        if (this.f168033a == null) goto L25;
    L23:
        this.f168034b.setRadius(r102);
        Allocation r104 = Allocation.createFromBitmap(this.f168033a, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f168035c = r104;
        this.f168036d = Allocation.createTyped(this.f168033a, r104.getType());
        return true;
    L25:
        RenderScript r105 = RenderScript.create(r100);     // Catch: RSRuntimeException -> L6
        this.f168033a = r105;     // Catch: RSRuntimeException -> L6
        this.f168034b = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (f168032e != null) goto L16;
        if (r100 == null) goto L16;
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r106 = true;
    L14:
        f168032e = Boolean.valueOf(r106);
        goto L16
    L13:
        r106 = false;
    L16:
        if (f168032e == Boolean.TRUE) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}

package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f168049e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f168050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f168051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f168052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f168053d;

    public h() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void release() {
        Allocation r100 = this.f168052c;
        if (r100 == null) goto L5;
        r100.destroy();
        this.f168052c = null;
    L5:
        Allocation r101 = this.f168053d;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f168053d = null;
    L8:
        ScriptIntrinsicBlur r102 = this.f168051b;
        if (r102 == null) goto L11;
        r102.destroy();
        this.f168051b = null;
    L11:
        RenderScript r103 = this.f168050a;
        if (r103 == null) goto L15;
        r103.destroy();
        this.f168050a = null;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void b(Bitmap r100, Bitmap r101) {
        this.f168052c.copyFrom(r100);
        this.f168051b.setInput(this.f168052c);
        this.f168051b.forEach(this.f168053d);
        this.f168053d.copyTo(r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final boolean a(Context r100, Bitmap r101, float r102) {
        boolean r103 = true;
        if (this.f168050a == null) goto L25;
    L23:
        this.f168051b.setRadius(r102);
        Allocation r104 = Allocation.createFromBitmap(this.f168050a, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f168052c = r104;
        this.f168053d = Allocation.createTyped(this.f168050a, r104.getType());
        return true;
    L25:
        RenderScript r105 = RenderScript.create(r100);     // Catch: RSRuntimeException -> L6
        this.f168050a = r105;     // Catch: RSRuntimeException -> L6
        this.f168051b = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (f168049e != null) goto L16;
        if (r100 == null) goto L16;
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r106 = true;
    L14:
        f168049e = Boolean.valueOf(r106);
        goto L16
    L13:
        r106 = false;
    L16:
        if (f168049e == Boolean.TRUE) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}

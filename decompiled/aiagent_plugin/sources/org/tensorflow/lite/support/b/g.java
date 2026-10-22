package org.tensorflow.lite.support.b;

import android.graphics.Bitmap;
import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TensorImage.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.tensorflow.lite.a f40605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f40606b;

    public g() {
        this(org.tensorflow.lite.a.f40581c);
    }

    public g(org.tensorflow.lite.a r3) {
        this.f40606b = null;
        if (r3 != org.tensorflow.lite.a.f40581c) goto L5;
    L8:
        boolean r0 = true;
    L9:
        org.tensorflow.lite.support.a.a.a.a(r0, "Illegal data type for TensorImage: Only FLOAT32 and UINT8 are accepted");
        this.f40605a = r3;
        return;
    L5:
        if (r3 == org.tensorflow.lite.a.f40579a) goto L8;
        r0 = false;
        goto L9
    }

    public static g a(g r1, org.tensorflow.lite.a r2) {
        g r0 = new g(r2);
        r0.f40606b = r1.f40606b.f();
        return r0;
    }

    public void a(Bitmap r1) {
        this.f40606b = a.a(r1);
    }

    public ByteBuffer a() {
        return b().a();
    }

    public org.tensorflow.lite.support.c.a b() {
        c r0 = this.f40606b;
        if (r0 == null) goto L7;
        return r0.a(this.f40605a);
    L7:
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public Image c() {
        c r1 = this.f40606b;
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public org.tensorflow.lite.a d() {
        return this.f40605a;
    }

    public b e() {
        c r1 = this.f40606b;
        if (r1 == null) goto L7;
        return r1.e();
    L7:
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public int f() {
        c r1 = this.f40606b;
        if (r1 == null) goto L7;
        return r1.c();
    L7:
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public int g() {
        c r1 = this.f40606b;
        if (r1 == null) goto L7;
        return r1.d();
    L7:
        throw new IllegalStateException("No image has been loaded yet.");
    }
}

package bsa;

import android.opengl.GLES20;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20352a;

    public final void a() {
        ByteBuffer r100 = this.f20352a.f20337o;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        b r101 = this.f20352a;
        r101.f20337o = null;
        int[] r102 = r101.f20338p;
        boolean r103 = true;
        if (r102 == null) goto L8;
        GLES20.glDeleteTextures(1, r102, 0);
        r101.f20338p = null;
    L8:
        b.j(this.f20352a);
        b r104 = this.f20352a;
        STGLRenderer r105 = r104.f20336n;
        if (r104.f20334l > 0) goto L12;
        r103 = false;
    L12:
        r105.f(r103, r104.f20324b, r104.f20325c);
        b r106 = this.f20352a;
        r106.f20336n.d(r106.f20326d, r106.f20327e, r106.f20324b, r106.f20325c);
        f r107 = this.f20352a.f20331i;
        if (r107 == null) goto L15;
        r107.a();
    L15:
        b r108 = this.f20352a;
        r108.f20339q = false;
        r108.f20329g.requestRender();
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

    public d(b r100) {
        this.f20352a = r100;
    }
}

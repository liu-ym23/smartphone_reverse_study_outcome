package u2;

import B0.g;
import android.opengl.GLES20;
import android.util.Log;
import androidx.fragment.app.A;
import com.stepos.renderfilter.RenderFilter;
import s.AbstractC0831a;
import z2.InterfaceC1006a;

/* renamed from: u2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0939a implements InterfaceC1006a, c {

    /* renamed from: a, reason: collision with root package name */
    public final int f15482a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15483b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15484c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15485d;

    /* renamed from: e, reason: collision with root package name */
    public int f15486e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f15487f = new int[4];

    /* renamed from: g, reason: collision with root package name */
    public final int[] f15488g = new int[4];

    /* renamed from: h, reason: collision with root package name */
    public final int[] f15489h = new int[1];

    public C0939a(int i4, int i5) {
        this.f15482a = i4;
        this.f15483b = i5;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.f15484c = iArr[0];
        e(false);
        GLES20.glGenTextures(1, iArr, 0);
        int i6 = iArr[0];
        this.f15485d = i6;
        GLES20.glBindTexture(3553, i6);
        int iA = AbstractC0831a.a(5);
        GLES20.glTexImage2D(3553, 0, iA, i4, i5, 0, iA, AbstractC0831a.b(5), null);
        if (!GLES20.glIsTexture(i6)) {
            throw new A("colorTextureHandle is not valid", 6);
        }
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i6, 0);
        f();
    }

    @Override // u2.c
    public final int a() {
        return this.f15483b;
    }

    @Override // u2.c
    public final void b(int i4) {
        int i5 = this.f15485d;
        if (i5 == 0) {
            return;
        }
        c.c(i5, i4);
    }

    @Override // u2.c
    public final int d() {
        return this.f15482a;
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        int[] iArr = {this.f15485d};
        GLES20.glDeleteTextures(1, iArr, 0);
        iArr[0] = this.f15484c;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public final void e(boolean z4) {
        int iGlCheckFramebufferStatus;
        String hexString;
        int[] iArr = this.f15489h;
        GLES20.glGetIntegerv(36006, iArr, 0);
        this.f15486e = iArr[0];
        GLES20.glGetIntegerv(2978, this.f15487f, 0);
        GLES20.glGetIntegerv(3088, this.f15488g, 0);
        GLES20.glBindFramebuffer(36160, this.f15484c);
        int i4 = this.f15482a;
        int i5 = this.f15483b;
        GLES20.glViewport(0, 0, i4, i5);
        GLES20.glScissor(0, 0, i4, i5);
        if (z4 && RenderFilter.f12296g && (iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160)) != 36053) {
            switch (iGlCheckFramebufferStatus) {
                case 36054:
                    hexString = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    hexString = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    hexString = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    hexString = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    hexString = Integer.toHexString(iGlCheckFramebufferStatus);
                    break;
            }
            String strM = g.m("checkFramebufferStatus failed: ", hexString);
            Log.e("RenderFilter", strM, new Exception());
            throw new IllegalStateException(strM);
        }
    }

    public final void f() {
        GLES20.glBindFramebuffer(36160, this.f15486e);
        int[] iArr = this.f15487f;
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        int[] iArr2 = this.f15488g;
        GLES20.glScissor(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FrameBuffer{mFormat=");
        sb.append(AbstractC0831a.j(5));
        sb.append(", mWidth=");
        sb.append(this.f15482a);
        sb.append(", mHeight=");
        sb.append(this.f15483b);
        sb.append(", mHasDepth=false, mHasStencil=false, mFrameBufferHandle=");
        sb.append(this.f15484c);
        sb.append(", mDepthBufferHandle=");
        sb.append(0);
        sb.append(", mStencilBufferHandle=");
        sb.append(0);
        sb.append(", mColorTextureHandle=");
        return g.o(sb, this.f15485d, '}');
    }
}

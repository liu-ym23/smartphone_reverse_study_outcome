package h6;

import D7.N;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f4571a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final FloatBuffer f;
    public final FloatBuffer g;

    public c() {
        int iX = N.x("attribute vec4 aPos;\nattribute vec4 aTex;\nuniform mat4 uTexMat;\nvarying vec2 vTex;\nvoid main() {\n    gl_Position = aPos;\n    vTex = (uTexMat * aTex).xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTex;\nuniform samplerExternalOES sTex;\nvoid main() {\n    gl_FragColor = texture2D(sTex, vTex);\n}");
        this.f4571a = iX;
        this.b = GLES20.glGetAttribLocation(iX, "aPos");
        this.c = GLES20.glGetAttribLocation(iX, "aTex");
        this.d = GLES20.glGetUniformLocation(iX, "uTexMat");
        this.e = GLES20.glGetUniformLocation(iX, "sTex");
        this.f = N.R(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.g = N.R(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    }
}

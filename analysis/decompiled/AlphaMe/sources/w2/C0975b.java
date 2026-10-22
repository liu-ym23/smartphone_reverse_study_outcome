package w2;

import B0.g;
import android.opengl.GLES20;
import androidx.fragment.app.A;
import f1.AbstractC0557a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import z2.InterfaceC1006a;

/* renamed from: w2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0975b implements InterfaceC1006a {

    /* renamed from: a, reason: collision with root package name */
    public String f15836a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15837b;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f15841f;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f15845j;

    /* renamed from: k, reason: collision with root package name */
    public int f15846k;

    /* renamed from: l, reason: collision with root package name */
    public int f15847l;

    /* renamed from: m, reason: collision with root package name */
    public int f15848m;

    /* renamed from: n, reason: collision with root package name */
    public final IntBuffer f15849n;

    /* renamed from: o, reason: collision with root package name */
    public final IntBuffer f15850o;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f15838c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f15839d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f15840e = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f15842g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f15843h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f15844i = new HashMap();

    static {
        AbstractC0557a.N();
    }

    public C0975b(String str, String str2) {
        String strGlGetProgramInfoLog;
        this.f15836a = "";
        IntBuffer intBufferN = AbstractC0557a.N();
        this.f15849n = intBufferN;
        this.f15850o = AbstractC0557a.N();
        if (str == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("fragment shader must not be null");
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(64);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        byteBufferAllocateDirect.asFloatBuffer();
        a(str, str2);
        if (!this.f15837b) {
            StringBuilder sb = new StringBuilder("compileShader failed:\n");
            if (this.f15837b) {
                strGlGetProgramInfoLog = GLES20.glGetProgramInfoLog(this.f15846k);
                this.f15836a = strGlGetProgramInfoLog;
            } else {
                strGlGetProgramInfoLog = this.f15836a;
            }
            sb.append(strGlGetProgramInfoLog);
            throw new A(sb.toString(), 7);
        }
        intBufferN.clear();
        GLES20.glGetProgramiv(this.f15846k, 35721, intBufferN);
        int i4 = intBufferN.get(0);
        this.f15845j = new String[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            intBufferN.clear();
            intBufferN.put(0, 1);
            IntBuffer intBuffer = this.f15850o;
            intBuffer.clear();
            String strGlGetActiveAttrib = GLES20.glGetActiveAttrib(this.f15846k, i5, intBufferN, intBuffer);
            this.f15842g.put(strGlGetActiveAttrib, Integer.valueOf(GLES20.glGetAttribLocation(this.f15846k, strGlGetActiveAttrib)));
            this.f15843h.put(strGlGetActiveAttrib, Integer.valueOf(intBuffer.get(0)));
            this.f15844i.put(strGlGetActiveAttrib, Integer.valueOf(intBufferN.get(0)));
            this.f15845j[i5] = strGlGetActiveAttrib;
        }
        IntBuffer intBuffer2 = this.f15849n;
        intBuffer2.clear();
        GLES20.glGetProgramiv(this.f15846k, 35718, intBuffer2);
        int i6 = intBuffer2.get(0);
        this.f15841f = new String[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            intBuffer2.clear();
            intBuffer2.put(0, 1);
            IntBuffer intBuffer3 = this.f15850o;
            intBuffer3.clear();
            String strGlGetActiveUniform = GLES20.glGetActiveUniform(this.f15846k, i7, intBuffer2, intBuffer3);
            this.f15838c.put(strGlGetActiveUniform, Integer.valueOf(GLES20.glGetUniformLocation(this.f15846k, strGlGetActiveUniform)));
            this.f15839d.put(strGlGetActiveUniform, Integer.valueOf(intBuffer3.get(0)));
            this.f15840e.put(strGlGetActiveUniform, Integer.valueOf(intBuffer2.get(0)));
            this.f15841f[i7] = strGlGetActiveUniform;
        }
    }

    public final void a(String str, String str2) {
        this.f15847l = c(35633, str);
        int iC = c(35632, str2);
        this.f15848m = iC;
        if (this.f15847l == -1 || iC == -1) {
            this.f15837b = false;
            return;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            iGlCreateProgram = -1;
        }
        if (iGlCreateProgram == -1) {
            iGlCreateProgram = -1;
        } else {
            GLES20.glAttachShader(iGlCreateProgram, this.f15847l);
            GLES20.glAttachShader(iGlCreateProgram, this.f15848m);
            GLES20.glLinkProgram(iGlCreateProgram);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(4);
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
            IntBuffer intBufferAsIntBuffer = byteBufferAllocateDirect.asIntBuffer();
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, intBufferAsIntBuffer);
            if (intBufferAsIntBuffer.get(0) == 0) {
                this.f15836a = GLES20.glGetProgramInfoLog(iGlCreateProgram);
                iGlCreateProgram = -1;
            }
        }
        this.f15846k = iGlCreateProgram;
        if (iGlCreateProgram == -1) {
            this.f15837b = false;
        } else {
            this.f15837b = true;
        }
    }

    public final int b(String str) {
        HashMap map = this.f15838c;
        Integer numValueOf = (Integer) map.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(GLES20.glGetUniformLocation(this.f15846k, str));
            map.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    public final int c(int i4, String str) {
        IntBuffer intBufferN = AbstractC0557a.N();
        int iGlCreateShader = GLES20.glCreateShader(i4);
        if (iGlCreateShader == 0) {
            return -1;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        GLES20.glGetShaderiv(iGlCreateShader, 35713, intBufferN);
        if (intBufferN.get(0) != 0) {
            return iGlCreateShader;
        }
        String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15836a);
        sb.append(i4 == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
        this.f15836a = sb.toString();
        this.f15836a = g.r(new StringBuilder(), this.f15836a, strGlGetShaderInfoLog);
        return -1;
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        GLES20.glUseProgram(0);
        GLES20.glDeleteShader(this.f15847l);
        GLES20.glDeleteShader(this.f15848m);
        GLES20.glDeleteProgram(this.f15846k);
    }
}

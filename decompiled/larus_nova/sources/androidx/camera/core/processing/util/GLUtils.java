package androidx.camera.core.processing.util;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.ShaderProvider;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
public final class GLUtils {
    public static final String BLANK_FRAGMENT_SHADER = "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n";
    public static final String BLANK_VERTEX_SHADER = "uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n";
    public static final String DEFAULT_VERTEX_SHADER = null;
    public static final int EGL_GL_COLORSPACE_BT2020_HLG_EXT = 13632;
    public static final int EGL_GL_COLORSPACE_KHR = 12445;
    public static final int[] EMPTY_ATTRIBS = null;
    public static final String HDR_VERTEX_SHADER = null;
    public static final int[] HLG_SURFACE_ATTRIBS = null;
    public static final OutputSurface NO_OUTPUT_SURFACE = null;
    public static final int PIXEL_STRIDE = 4;
    private static final ShaderProvider SHADER_PROVIDER_DEFAULT = null;
    private static final ShaderProvider SHADER_PROVIDER_HDR_DEFAULT = null;
    private static final ShaderProvider SHADER_PROVIDER_HDR_YUV = null;
    public static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "GLUtils";
    public static final FloatBuffer TEX_BUF = null;
    public static final float[] TEX_COORDS = null;
    public static final String VAR_TEXTURE = "sTexture";
    public static final String VAR_TEXTURE_COORD = "vTextureCoord";
    public static final String VERSION_UNKNOWN = "0.0";
    public static final FloatBuffer VERTEX_BUF = null;
    public static final float[] VERTEX_COORDS = null;

    public static class BlankShaderProgram extends Program2D {
        public BlankShaderProgram() {
            super(GLUtils.BLANK_VERTEX_SHADER, GLUtils.BLANK_FRAGMENT_SHADER);
        }
    }

    public static final enum InputFormat extends Enum<InputFormat> {
        private static final /* synthetic */ InputFormat[] $VALUES = null;
        public static final InputFormat DEFAULT = null;
        public static final InputFormat UNKNOWN = null;
        public static final InputFormat YUV = null;

        private static /* synthetic */ InputFormat[] $values() {
            return new InputFormat[]{UNKNOWN, DEFAULT, YUV};
        }

        static {
            UNKNOWN = new InputFormat("UNKNOWN", 0);
            DEFAULT = new InputFormat("DEFAULT", 1);
            YUV = new InputFormat("YUV", 2);
            $VALUES = $values();
        }

        public static InputFormat[] values() {
            return (InputFormat[]) $VALUES.clone();
        }

        public static InputFormat valueOf(String r100) {
            return (InputFormat) a.a(InputFormat.class, r100);
        }

        private InputFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class Program2D {
        protected int mAlphaScaleLoc;
        protected int mPositionLoc;
        protected int mProgramHandle;
        protected int mTransMatrixLoc;

        private void loadLocations() {
            int r100 = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.mPositionLoc = r100;
            GLUtils.checkLocationOrThrow(r100, "aPosition");
            int r101 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTransMatrix");
            this.mTransMatrixLoc = r101;
            GLUtils.checkLocationOrThrow(r101, "uTransMatrix");
            int r102 = GLES20.glGetUniformLocation(this.mProgramHandle, "uAlphaScale");
            this.mAlphaScaleLoc = r102;
            GLUtils.checkLocationOrThrow(r102, "uAlphaScale");
        }

        public void delete() {
            GLES20.glDeleteProgram(this.mProgramHandle);
        }

        public void use() {
            GLES20.glUseProgram(this.mProgramHandle);
            GLUtils.checkGlErrorOrThrow("glUseProgram");
            GLES20.glEnableVertexAttribArray(this.mPositionLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, GLUtils.VERTEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
            updateTransformMatrix(GLUtils.create4x4IdentityMatrix());
            updateAlpha(1.0f);
        }

        public static /* synthetic */ void access$100(Program2D r100) {
            r100.loadLocations();
        }

        public void updateAlpha(float r100) {
            GLES20.glUniform1f(this.mAlphaScaleLoc, r100);
            GLUtils.checkGlErrorOrThrow("glUniform1f");
        }

        public void updateTransformMatrix(float[] r100) {
            GLES20.glUniformMatrix4fv(this.mTransMatrixLoc, 1, false, r100, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }

        public Program2D(String r100, String r101) {
            this.mTransMatrixLoc = -1;
            this.mAlphaScaleLoc = -1;
            this.mPositionLoc = -1;
            int r102 = GLUtils.loadShader(35633, r100);     // Catch: Throwable -> L26 IllegalStateException -> L28
            int r103 = GLUtils.loadShader(35632, r101);     // Catch: IllegalArgumentException -> L22 IllegalStateException -> L24
            int r104 = GLES20.glCreateProgram();     // Catch: IllegalArgumentException -> L18 IllegalStateException -> L20
        L41:
            GLUtils.checkGlErrorOrThrow("glCreateProgram");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glAttachShader(r104, r102);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLUtils.checkGlErrorOrThrow("glAttachShader");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glAttachShader(r104, r103);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLUtils.checkGlErrorOrThrow("glAttachShader");     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glLinkProgram(r104);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            int[] r105 = new int[1];     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            GLES20.glGetProgramiv(r104, 35714, r105, 0);     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            if (r105[0] != 1) goto L13;
            this.mProgramHandle = r104;     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
            loadLocations();
            return;
        L13:
            throw new IllegalStateException("Could not link program: " + GLES20.glGetProgramInfoLog(r104));     // Catch: IllegalArgumentException -> L14 IllegalStateException -> L16
        L14:
            e = e;
        L32:
            if (r102 == (-1)) goto L34;
            GLES20.glDeleteShader(r102);
        L34:
            if (r103 == (-1)) goto L36;
            GLES20.glDeleteShader(r103);
        L36:
            if (r104 == (-1)) goto L38;
            GLES20.glDeleteProgram(r104);
        L38:
            throw e;
        L16:
            e = e;
        L18:
            e = e;
        L31:
            r104 = -1;
        L20:
            e = e;
            goto L31
        L22:
            e = e;
        L30:
            r103 = -1;
        L24:
            e = e;
        L26:
            e = e;
            r102 = -1;
            goto L30
        }
    }

    public static class SamplerShaderProgram extends Program2D {
        private int mSamplerLoc;
        private int mTexCoordLoc;
        private int mTexMatrixLoc;

        private void loadLocations() {
            Program2D.access$100(this);
            int r100 = GLES20.glGetUniformLocation(this.mProgramHandle, GLUtils.VAR_TEXTURE);
            this.mSamplerLoc = r100;
            GLUtils.checkLocationOrThrow(r100, GLUtils.VAR_TEXTURE);
            int r101 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.mTexCoordLoc = r101;
            GLUtils.checkLocationOrThrow(r101, "aTextureCoord");
            int r102 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.mTexMatrixLoc = r102;
            GLUtils.checkLocationOrThrow(r102, "uTexMatrix");
        }

        @Override // androidx.camera.core.processing.util.GLUtils.Program2D
        public void use() {
            super.use();
            GLES20.glUniform1i(this.mSamplerLoc, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, GLUtils.TEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
        }

        public void updateTextureMatrix(float[] r100) {
            GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, r100, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }

        public SamplerShaderProgram(DynamicRange r100, ShaderProvider r101) {
            if (r100.is10BitHdr() == false) goto L5;
            String r102 = GLUtils.HDR_VERTEX_SHADER;
        L6:
            super(r102, GLUtils.access$000(r101));
            this.mSamplerLoc = -1;
            this.mTexMatrixLoc = -1;
            this.mTexCoordLoc = -1;
            loadLocations();
            return;
        L5:
            r102 = GLUtils.DEFAULT_VERTEX_SHADER;
            goto L6
        }

        private static ShaderProvider resolveDefaultShaderProvider(DynamicRange r100, InputFormat r101) {
            if (r100.is10BitHdr() == false) goto L15;
            if (r101 == InputFormat.UNKNOWN) goto L7;
            boolean r102 = true;
        L8:
            Preconditions.checkArgument(r102, "No default sampler shader available for" + r101);
            if (r101 != InputFormat.YUV) goto L13;
            return GLUtils.access$200();
        L13:
            return GLUtils.access$300();
        L7:
            r102 = false;
            goto L8
        L15:
            return GLUtils.access$400();
        }

        public SamplerShaderProgram(DynamicRange r100, InputFormat r101) {
            this(r100, resolveDefaultShaderProvider(r100, r101));
        }
    }

    static {
        EMPTY_ATTRIBS = new int[]{12344};
        HLG_SURFACE_ATTRIBS = new int[]{12445, EGL_GL_COLORSPACE_BT2020_HLG_EXT, 12344};
        Locale r100 = Locale.US;
        DEFAULT_VERTEX_SHADER = String.format(r100, "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        HDR_VERTEX_SHADER = String.format(r100, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
        SHADER_PROVIDER_DEFAULT = new AnonymousClass1();
        SHADER_PROVIDER_HDR_DEFAULT = new AnonymousClass2();
        SHADER_PROVIDER_HDR_YUV = new AnonymousClass3();
        float[] r101 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEX_COORDS = r101;
        VERTEX_BUF = createFloatBuffer(r101);
        float[] r102 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEX_COORDS = r102;
        TEX_BUF = createFloatBuffer(r102);
        NO_OUTPUT_SURFACE = OutputSurface.of(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static int createTexture() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        checkGlErrorOrThrow("glGenTextures");
        int r101 = r100[0];
        GLES20.glBindTexture(36197, r101);
        checkGlErrorOrThrow("glBindTexture " + r101);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        return r101;
    }

    public static int generateFbo() {
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        checkGlErrorOrThrow("glGenFramebuffers");
        return r100[0];
    }

    public static int generateTexture() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        checkGlErrorOrThrow("glGenTextures");
        return r100[0];
    }

    public static float[] create4x4IdentityMatrix() {
        float[] r100 = new float[16];
        Matrix.setIdentityM(r100, 0);
        return r100;
    }

    public static String getGlVersionNumber() {
        Matcher r100 = PatternProtector.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (r100.find() == true) goto L5;
        return VERSION_UNKNOWN;
    L5:
        return ((String) Preconditions.checkNotNull(r100.group(1))) + "." + ((String) Preconditions.checkNotNull(r100.group(2)));
    }

    private GLUtils() {
    }

    public static /* synthetic */ ShaderProvider access$200() {
        return SHADER_PROVIDER_HDR_YUV;
    }

    public static /* synthetic */ ShaderProvider access$300() {
        return SHADER_PROVIDER_HDR_DEFAULT;
    }

    public static /* synthetic */ ShaderProvider access$400() {
        return SHADER_PROVIDER_DEFAULT;
    }

    public static /* synthetic */ String access$000(ShaderProvider r100) {
        return getFragmentShaderSource(r100);
    }

    public static void checkEglErrorOrLog(String r100) {
        checkEglErrorOrThrow(r100);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, e.toString(), e);
    }

    public static void checkEglErrorOrThrow(String r100) {
        int r101 = EGL14.eglGetError();
        if (r101 != 12288) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100 + ": EGL error: 0x" + Integer.toHexString(r101));
    }

    public static void checkGlErrorOrThrow(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException(r100 + ": GL error 0x" + Integer.toHexString(r101));
    }

    public static void checkGlThreadOrThrow(Thread r100) {
        if (r100 != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkState(r101, "Method call must be called on the GL thread.");
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static FloatBuffer createFloatBuffer(float[] r100) {
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4);
        r101.order(ByteOrder.nativeOrder());
        FloatBuffer r102 = r101.asFloatBuffer();
        r102.put(r100);
        r102.position(0);
        return r102;
    }

    public static void deleteFbo(int r100) {
        GLES20.glDeleteFramebuffers(1, new int[]{r100}, 0);
        checkGlErrorOrThrow("glDeleteFramebuffers");
    }

    public static void deleteTexture(int r100) {
        GLES20.glDeleteTextures(1, new int[]{r100}, 0);
        checkGlErrorOrThrow("glDeleteTextures");
    }

    private static String getFragmentShaderSource(ShaderProvider r100) {
        String r101 = r100.createFragmentShader(VAR_TEXTURE, VAR_TEXTURE_COORD);     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        if (r101.contains(VAR_TEXTURE_COORD) == false) goto L11;
        if (r101.contains(VAR_TEXTURE) == false) goto L11;
        return r101;
    L11:
        throw new IllegalArgumentException("Invalid fragment shader");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L17;
        throw th;
    L17:
        throw new IllegalArgumentException("Unable retrieve fragment shader source", th);
    }

    public static void checkInitializedOrThrow(AtomicBoolean r100, boolean r101) {
        if (r101 != r100.get()) goto L5;
        boolean r102 = true;
    L6:
        if (r101 == false) goto L8;
        String r103 = "OpenGlRenderer is not initialized";
    L9:
        Preconditions.checkState(r102, r103);
        return;
    L8:
        r103 = "OpenGlRenderer is already initialized";
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public static void checkLocationOrThrow(int r100, String r101) {
        if (r100 < 0) goto L5;
        return;
    L5:
        throw new IllegalStateException("Unable to locate '" + r101 + "' in program");
    }

    public static int[] chooseSurfaceAttrib(String r100, DynamicRange r101) {
        int[] r102 = EMPTY_ATTRIBS;
        if (r101.getEncoding() == 3) goto L5;
        return r102;
    L5:
        if (r100.contains("EGL_EXT_gl_colorspace_bt2020_hlg") == true) goto L10;
        Logger.w(TAG, "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        return r102;
    L10:
        return HLG_SURFACE_ATTRIBS;
    }

    public static Map<InputFormat, Program2D> createPrograms(DynamicRange r110, Map<InputFormat, ShaderProvider> r111) {
        HashMap r100 = new HashMap();
        InputFormat[] r101 = InputFormat.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L25;
        InputFormat r104 = r101[r103];
        ShaderProvider r105 = r111.get(r104);
        if (r105 == null) goto L8;
        Object r106 = new SamplerShaderProgram(r110, r105);
    L24:
        Objects.toString(r104);
        r106.toString();
        r100.put(r104, r106);
        r103 = r103 + 1;
        goto L3
    L8:
        if (r104 == InputFormat.YUV) goto L23;
        InputFormat r107 = InputFormat.DEFAULT;
        if (r104 == r107) goto L23;
        if (r104 != InputFormat.UNKNOWN) goto L15;
        boolean r108 = true;
    L16:
        Preconditions.checkState(r108, "Unhandled input format: " + r104);
        if (r110.is10BitHdr() == false) goto L19;
        r106 = new BlankShaderProgram();
        goto L24
    L19:
        ShaderProvider r109 = r111.get(r107);
        if (r109 == null) goto L22;
        r106 = new SamplerShaderProgram(r110, r109);
        goto L24
    L22:
        r106 = new SamplerShaderProgram(r110, r107);
        goto L24
    L15:
        r108 = false;
    L23:
        r106 = new SamplerShaderProgram(r110, r104);
        goto L24
    L25:
        return r100;
    }

    public static Size getSurfaceSize(EGLDisplay r100, EGLSurface r101) {
        return new Size(querySurface(r100, r101, 12375), querySurface(r100, r101, 12374));
    }

    public static int loadShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        checkGlErrorOrThrow("glCreateShader type=" + r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] == 0) goto L5;
        return r102;
    L5:
        Logger.w(TAG, "Could not compile shader: " + r101);
        GLES20.glDeleteShader(r102);
        throw new IllegalStateException("Could not compile shader type " + r100 + ":" + GLES20.glGetShaderInfoLog(r102));
    }

    public static int querySurface(EGLDisplay r100, EGLSurface r101, int r102) {
        int[] r103 = new int[1];
        EGL14.eglQuerySurface(r100, r101, r102, r103, 0);
        return r103[0];
    }

    public static EGLSurface createPBufferSurface(EGLDisplay r100, EGLConfig r101, int r102, int r103) {
        EGLSurface r104 = EGL14.eglCreatePbufferSurface(r100, r101, new int[]{12375, r102, 12374, r103, 12344}, 0);
        checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (r104 == null) goto L6;
        return r104;
    L6:
        throw new IllegalStateException("surface was null");
    }

    public static EGLSurface createWindowSurface(EGLDisplay r100, EGLConfig r101, Surface r102, int[] r103) {
        EGLSurface r104 = EGL14.eglCreateWindowSurface(r100, r101, r102, r103, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (r104 == null) goto L6;
        return r104;
    L6:
        throw new IllegalStateException("surface was null");
    }
}

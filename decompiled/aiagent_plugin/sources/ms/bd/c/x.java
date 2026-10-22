package ms.bd.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f39674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39675b = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EGLDisplay f39676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EGLContext f39677b;

        public a() {
            EGLDisplay r0 = EGL14.EGL_NO_DISPLAY;
            this.f39676a = r0;
            this.f39677b = EGL14.EGL_NO_CONTEXT;
            if (r0 != EGL14.EGL_NO_DISPLAY) goto L27;
            EGLContext r1 = EGL14.EGL_NO_CONTEXT;
            EGLDisplay r3 = EGL14.eglGetDisplay(0);
            this.f39676a = r3;
            if (r3 == EGL14.EGL_NO_DISPLAY) goto L25;
            int[] r5 = new int[2];
            if (EGL14.eglInitialize(r3, r5, 0, r5, 1) == false) goto L22;
            EGLConfig r6 = a(3);
            if (r6 == null) goto L14;
            EGLDisplay r8 = this.f39676a;
            EGLContext r7 = EGL14.eglCreateContext(r8, r6, r1, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() != 12288) goto L14;
            this.f39677b = r7;
        L14:
            if (this.f39677b != EGL14.EGL_NO_CONTEXT) goto L20;
            EGLConfig r4 = a(2);
            if (r4 == null) goto L19;
            EGLDisplay r9 = this.f39676a;
            EGLContext r2 = EGL14.eglCreateContext(r9, r4, r1, new int[]{12440, 2, 12344}, 0);
            a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e80655", new byte[]{113, 61, 79, 97, 24, 39, 103, 13, 100, 69, 123, 52, 87, 71, 18, 54}), String.class, "com.obric.aiagent.plugin"));
            this.f39677b = r2;
            goto L20
        L19:
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d0f141", new byte[]{64, 60, 20, 71, 7, 35, 39, 5, 56, 33, 115, 59, 27, 65, 75, 39, 39, 2, 34, 104, 97, 51, 23, 73, 14, 102, 66, 54, 27, 66, 122, 60, 19, 76, 12}), String.class, "com.obric.aiagent.plugin"));
        L20:
            EGLDisplay r10 = this.f39676a;
            EGLContext r13 = this.f39677b;
            EGL14.eglQueryContext(r10, r13, 12440, new int[1], 0);
            return;
        L22:
            this.f39676a = null;
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "38c78d", new byte[]{55, 52, 17, 65, 11, 118, 112, 13, 61, 39, 43, 52, 25, 87, 14, 114, 60, 16, 40, 98, 98, 31, 55, 111, 86, 39}), String.class, "com.obric.aiagent.plugin"));
        L25:
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b8ec28", new byte[]{102, 52, 23, 21, 1, 42, 33, 13, 59, 115, 116, 63, 2, 87, 40, 8, 77, 72, 96, 115, 119, 51, 5, 7, 1, 46, 120}), String.class, "com.obric.aiagent.plugin"));
        L27:
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "47447a", new byte[]{0, 18, 107, 0, 9, 122, 37, 19, 100, 96, 60, 117, 84, 69, 28, 54, 34, 6}), String.class, "com.obric.aiagent.plugin"));
        }

        private EGLConfig a(int r13) {
            if (r13 < 3) goto L5;
            int r14 = 68;
        L6:
            int[] r4 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r14, 12344, 0, 12344};
            EGLConfig[] r15 = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f39676a, r4, 0, r15, 0, 1, new int[1], 0) == true) goto L11;
            return null;
        L11:
            return r15[0];
        L5:
            r14 = 4;
            goto L6
        }

        private static void a(String r9) {
            int r0 = EGL14.eglGetError();
            if (r0 != 12288) goto L6;
            return;
        L6:
            throw new RuntimeException(r9 + ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bf3da0", new byte[]{41, 36, 101, 55, 114, 103, 100, 85, 112, 59, 97, 62, 0, 64, 70}), String.class, "com.obric.aiagent.plugin")) + Integer.toHexString(r0));
        }

        public final void a() {
            EGLDisplay r0 = this.f39676a;
            if (r0 == EGL14.EGL_NO_DISPLAY) goto L5;
            EGL14.eglDestroyContext(r0, this.f39677b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f39676a);
        L5:
            this.f39676a = EGL14.EGL_NO_DISPLAY;
            this.f39677b = EGL14.EGL_NO_CONTEXT;
        }

        public final void a(EGLSurface r7) {
            if (EGL14.eglMakeCurrent(this.f39676a, r7, r7, this.f39677b) == false) goto L6;
            return;
        L6:
            throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "29a782", new byte[]{38, 60, 30, 110, 6, 46, 52, 59, 37, 117, 49, 62, 28, 87, 71, 35, 48, 17, 60, 98, 39}), String.class, "com.obric.aiagent.plugin"));
        }

        public final void finalize() {
        L7:
            th = move-exception;
            super.finalize();
            throw th;
        L3:
            if (this.f39676a == EGL14.EGL_NO_DISPLAY) goto L5;
            a();     // Catch: Throwable -> L7
        L5:
            super.finalize();
        }
    }

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "60d068", new byte[]{102, 39, 25, 87, 28, 63, 37, 30, 39, 116, 34, 54, 86}), String.class, "com.obric.aiagent.plugin");
        f39675b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7e2765", new byte[]{103, 98, 83, 81, 72}), String.class, "com.obric.aiagent.plugin");
    }

    public static String a() {
        String r1 = f39674a;
        if (r1 == null) goto L5;
        return r1;
    L5:
        StringBuilder r2 = new StringBuilder();
        a r3 = new a();     // Catch: Exception -> L8
        r3.a(EGL14.EGL_NO_SURFACE);     // Catch: Exception -> L8
        r2.append(GLES20.glGetString(7936)).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2a7a31", new byte[]{63}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        r2.append(GLES20.glGetString(7937)).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bc28a8", new byte[]{111}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        r2.append(GLES20.glGetString(7938));     // Catch: Exception -> L8
        f39674a = r2.toString();     // Catch: Exception -> L8
        r3.a();     // Catch: Exception -> L8
    L10:
        return f39674a;
    L8:
        f39674a = f39675b;
        goto L10
    }
}

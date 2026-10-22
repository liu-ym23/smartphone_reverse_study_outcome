package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.s;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
class e implements r {

    /* renamed from: a, reason: collision with root package name */
    private static final k f9122a = new k();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<SurfaceView> f9123b;

    /* renamed from: c, reason: collision with root package name */
    private int f9124c = 60;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<e> f9125d = new WeakReference<>(this);

    /* renamed from: e, reason: collision with root package name */
    private j f9126e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceRenderer f9127f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9128g;

    /* renamed from: h, reason: collision with root package name */
    private f f9129h;

    /* renamed from: i, reason: collision with root package name */
    private g f9130i;

    /* renamed from: j, reason: collision with root package name */
    private h f9131j;

    /* renamed from: k, reason: collision with root package name */
    private l f9132k;

    /* renamed from: l, reason: collision with root package name */
    private int f9133l;

    /* renamed from: m, reason: collision with root package name */
    private int f9134m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9135n;

    public abstract class b implements f {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f9136a;

        public b(int[] iArr) {
            this.f9136a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (e.this.f9134m != 2 && e.this.f9134m != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i4 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            iArr2[i4] = 12352;
            if (e.this.f9134m == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.baidu.platform.comapi.map.e.f
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f9136a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i4 = iArr[0];
            if (i4 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i4];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f9136a, eGLConfigArr, i4, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigA = a(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigA != null) {
                return eGLConfigA;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        private int f9148a;

        private d() {
            this.f9148a = 12440;
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f9148a, e.this.f9134m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (e.this.f9134m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext == null || eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            i.b("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* renamed from: com.baidu.platform.comapi.map.e$e, reason: collision with other inner class name */
    public static class C0048e implements h {
        private C0048e() {
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e4) {
                Log.e("GLRenderControl", "eglCreateWindowSurface", e4);
                return null;
            }
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface f {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface g {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public static class j extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9156a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9157b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9158c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f9159d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9160e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9161f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f9162g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f9163h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f9164i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f9165j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f9166k;

        /* renamed from: q, reason: collision with root package name */
        private boolean f9172q;

        /* renamed from: u, reason: collision with root package name */
        private i f9176u;

        /* renamed from: v, reason: collision with root package name */
        private long f9177v;

        /* renamed from: w, reason: collision with root package name */
        private long f9178w;

        /* renamed from: y, reason: collision with root package name */
        private WeakReference<e> f9180y;

        /* renamed from: r, reason: collision with root package name */
        private ArrayList<Runnable> f9173r = new ArrayList<>();

        /* renamed from: s, reason: collision with root package name */
        private boolean f9174s = true;

        /* renamed from: t, reason: collision with root package name */
        private Runnable f9175t = null;

        /* renamed from: x, reason: collision with root package name */
        private int f9179x = 60;

        /* renamed from: l, reason: collision with root package name */
        private int f9167l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f9168m = 0;

        /* renamed from: o, reason: collision with root package name */
        private boolean f9170o = true;

        /* renamed from: n, reason: collision with root package name */
        private int f9169n = 1;

        /* renamed from: p, reason: collision with root package name */
        private boolean f9171p = false;

        public j(WeakReference<e> weakReference) {
            this.f9180y = weakReference;
            setPriority(10);
        }

        /* JADX WARN: Removed duplicated region for block: B:115:0x0180 A[Catch: all -> 0x0145, TryCatch #4 {all -> 0x0145, blocks: (B:4:0x001f, B:5:0x0023, B:90:0x013f, B:94:0x014a, B:96:0x0152, B:97:0x0156, B:104:0x0166, B:105:0x0167, B:106:0x016b, B:113:0x017d, B:115:0x0180, B:117:0x018c, B:120:0x01ab, B:128:0x01cc, B:131:0x01dd, B:133:0x01e6, B:134:0x01ed, B:136:0x01ef, B:147:0x0215, B:151:0x0223, B:152:0x022e, B:167:0x0251, B:169:0x0263, B:170:0x0267, B:176:0x0273, B:177:0x0274, B:159:0x023d, B:145:0x0212, B:122:0x01b4, B:123:0x01bb, B:184:0x029c, B:171:0x0268, B:172:0x026f, B:119:0x0196, B:99:0x0158, B:100:0x0161, B:130:0x01d6, B:6:0x0024, B:8:0x0028, B:19:0x003c, B:21:0x0044, B:88:0x013c, B:22:0x0050, B:24:0x0056, B:26:0x0061, B:28:0x0065, B:30:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0083, B:38:0x0087, B:43:0x0098, B:41:0x0092, B:44:0x009b, B:46:0x009f, B:48:0x00a3, B:50:0x00a7, B:51:0x00aa, B:52:0x00b7, B:54:0x00bb, B:56:0x00bf, B:58:0x00cb, B:59:0x00d9, B:61:0x00dd, B:62:0x00e1, B:64:0x00e7, B:68:0x00ef, B:70:0x00f5, B:72:0x0101, B:73:0x0108, B:74:0x0109, B:76:0x010d, B:78:0x0111, B:79:0x0117, B:81:0x011b, B:83:0x011f, B:85:0x012e, B:182:0x0291, B:181:0x0286, B:154:0x0230, B:155:0x0239, B:138:0x01fd, B:140:0x0206, B:143:0x020d, B:108:0x016d, B:109:0x0178), top: B:201:0x001f, inners: #0, #1, #2, #3, #6, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:117:0x018c A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #4 {all -> 0x0145, blocks: (B:4:0x001f, B:5:0x0023, B:90:0x013f, B:94:0x014a, B:96:0x0152, B:97:0x0156, B:104:0x0166, B:105:0x0167, B:106:0x016b, B:113:0x017d, B:115:0x0180, B:117:0x018c, B:120:0x01ab, B:128:0x01cc, B:131:0x01dd, B:133:0x01e6, B:134:0x01ed, B:136:0x01ef, B:147:0x0215, B:151:0x0223, B:152:0x022e, B:167:0x0251, B:169:0x0263, B:170:0x0267, B:176:0x0273, B:177:0x0274, B:159:0x023d, B:145:0x0212, B:122:0x01b4, B:123:0x01bb, B:184:0x029c, B:171:0x0268, B:172:0x026f, B:119:0x0196, B:99:0x0158, B:100:0x0161, B:130:0x01d6, B:6:0x0024, B:8:0x0028, B:19:0x003c, B:21:0x0044, B:88:0x013c, B:22:0x0050, B:24:0x0056, B:26:0x0061, B:28:0x0065, B:30:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0083, B:38:0x0087, B:43:0x0098, B:41:0x0092, B:44:0x009b, B:46:0x009f, B:48:0x00a3, B:50:0x00a7, B:51:0x00aa, B:52:0x00b7, B:54:0x00bb, B:56:0x00bf, B:58:0x00cb, B:59:0x00d9, B:61:0x00dd, B:62:0x00e1, B:64:0x00e7, B:68:0x00ef, B:70:0x00f5, B:72:0x0101, B:73:0x0108, B:74:0x0109, B:76:0x010d, B:78:0x0111, B:79:0x0117, B:81:0x011b, B:83:0x011f, B:85:0x012e, B:182:0x0291, B:181:0x0286, B:154:0x0230, B:155:0x0239, B:138:0x01fd, B:140:0x0206, B:143:0x020d, B:108:0x016d, B:109:0x0178), top: B:201:0x001f, inners: #0, #1, #2, #3, #6, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x01cc A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #4 {all -> 0x0145, blocks: (B:4:0x001f, B:5:0x0023, B:90:0x013f, B:94:0x014a, B:96:0x0152, B:97:0x0156, B:104:0x0166, B:105:0x0167, B:106:0x016b, B:113:0x017d, B:115:0x0180, B:117:0x018c, B:120:0x01ab, B:128:0x01cc, B:131:0x01dd, B:133:0x01e6, B:134:0x01ed, B:136:0x01ef, B:147:0x0215, B:151:0x0223, B:152:0x022e, B:167:0x0251, B:169:0x0263, B:170:0x0267, B:176:0x0273, B:177:0x0274, B:159:0x023d, B:145:0x0212, B:122:0x01b4, B:123:0x01bb, B:184:0x029c, B:171:0x0268, B:172:0x026f, B:119:0x0196, B:99:0x0158, B:100:0x0161, B:130:0x01d6, B:6:0x0024, B:8:0x0028, B:19:0x003c, B:21:0x0044, B:88:0x013c, B:22:0x0050, B:24:0x0056, B:26:0x0061, B:28:0x0065, B:30:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0083, B:38:0x0087, B:43:0x0098, B:41:0x0092, B:44:0x009b, B:46:0x009f, B:48:0x00a3, B:50:0x00a7, B:51:0x00aa, B:52:0x00b7, B:54:0x00bb, B:56:0x00bf, B:58:0x00cb, B:59:0x00d9, B:61:0x00dd, B:62:0x00e1, B:64:0x00e7, B:68:0x00ef, B:70:0x00f5, B:72:0x0101, B:73:0x0108, B:74:0x0109, B:76:0x010d, B:78:0x0111, B:79:0x0117, B:81:0x011b, B:83:0x011f, B:85:0x012e, B:182:0x0291, B:181:0x0286, B:154:0x0230, B:155:0x0239, B:138:0x01fd, B:140:0x0206, B:143:0x020d, B:108:0x016d, B:109:0x0178), top: B:201:0x001f, inners: #0, #1, #2, #3, #6, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0242  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x0245  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x024b  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x0263 A[Catch: all -> 0x0145, TryCatch #4 {all -> 0x0145, blocks: (B:4:0x001f, B:5:0x0023, B:90:0x013f, B:94:0x014a, B:96:0x0152, B:97:0x0156, B:104:0x0166, B:105:0x0167, B:106:0x016b, B:113:0x017d, B:115:0x0180, B:117:0x018c, B:120:0x01ab, B:128:0x01cc, B:131:0x01dd, B:133:0x01e6, B:134:0x01ed, B:136:0x01ef, B:147:0x0215, B:151:0x0223, B:152:0x022e, B:167:0x0251, B:169:0x0263, B:170:0x0267, B:176:0x0273, B:177:0x0274, B:159:0x023d, B:145:0x0212, B:122:0x01b4, B:123:0x01bb, B:184:0x029c, B:171:0x0268, B:172:0x026f, B:119:0x0196, B:99:0x0158, B:100:0x0161, B:130:0x01d6, B:6:0x0024, B:8:0x0028, B:19:0x003c, B:21:0x0044, B:88:0x013c, B:22:0x0050, B:24:0x0056, B:26:0x0061, B:28:0x0065, B:30:0x0071, B:32:0x007a, B:34:0x007e, B:36:0x0083, B:38:0x0087, B:43:0x0098, B:41:0x0092, B:44:0x009b, B:46:0x009f, B:48:0x00a3, B:50:0x00a7, B:51:0x00aa, B:52:0x00b7, B:54:0x00bb, B:56:0x00bf, B:58:0x00cb, B:59:0x00d9, B:61:0x00dd, B:62:0x00e1, B:64:0x00e7, B:68:0x00ef, B:70:0x00f5, B:72:0x0101, B:73:0x0108, B:74:0x0109, B:76:0x010d, B:78:0x0111, B:79:0x0117, B:81:0x011b, B:83:0x011f, B:85:0x012e, B:182:0x0291, B:181:0x0286, B:154:0x0230, B:155:0x0239, B:138:0x01fd, B:140:0x0206, B:143:0x020d, B:108:0x016d, B:109:0x0178), top: B:201:0x001f, inners: #0, #1, #2, #3, #6, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:205:0x02a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:211:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void c() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 685
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.e.j.c():void");
        }

        private boolean f() {
            return !this.f9159d && this.f9160e && !this.f9161f && this.f9167l > 0 && this.f9168m > 0 && (this.f9170o || this.f9169n == 1);
        }

        private void i() {
            if (this.f9163h) {
                this.f9176u.e();
                this.f9163h = false;
                e.f9122a.a(this);
            }
        }

        private void j() {
            if (this.f9164i) {
                this.f9164i = false;
                this.f9176u.c();
            }
        }

        public int b() {
            int i4;
            synchronized (e.f9122a) {
                i4 = this.f9169n;
            }
            return i4;
        }

        public void d() {
            synchronized (e.f9122a) {
                this.f9158c = true;
                e.f9122a.notifyAll();
                while (!this.f9157b && !this.f9159d) {
                    try {
                        e.f9122a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (e.f9122a) {
                this.f9158c = false;
                this.f9170o = true;
                this.f9172q = false;
                e.f9122a.notifyAll();
                while (!this.f9157b && this.f9159d && !this.f9172q) {
                    try {
                        e.f9122a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (e.f9122a) {
                this.f9156a = true;
                e.f9122a.notifyAll();
                while (!this.f9157b) {
                    try {
                        e.f9122a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (e.f9122a) {
                this.f9170o = true;
                e.f9122a.notifyAll();
            }
        }

        public void k() {
            synchronized (e.f9122a) {
                this.f9160e = true;
                this.f9165j = false;
                e.f9122a.notifyAll();
                while (this.f9162g && !this.f9165j && !this.f9157b) {
                    try {
                        e.f9122a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void l() {
            synchronized (e.f9122a) {
                this.f9160e = false;
                e.f9122a.notifyAll();
                while (!this.f9162g && !this.f9157b) {
                    try {
                        e.f9122a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                c();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                e.f9122a.b(this);
                throw th;
            }
            e.f9122a.b(this);
        }

        private void a(long j4) {
            long j5 = this.f9177v + 1;
            this.f9177v = j5;
            long j6 = this.f9178w + j4;
            this.f9178w = j6;
            if (j5 >= 10) {
                int i4 = (int) (j6 / j5);
                if (i4 <= 0) {
                    this.f9177v = 0L;
                    this.f9178w = 0L;
                } else {
                    this.f9179x = ((1000 / i4) + this.f9179x) / 2;
                    this.f9177v = 0L;
                    this.f9178w = 0L;
                }
            }
        }

        public void b(Runnable runnable) {
            synchronized (e.f9122a) {
                try {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.f9171p = true;
                    this.f9170o = true;
                    this.f9172q = false;
                    this.f9175t = runnable;
                    e.f9122a.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean a() {
            return this.f9163h && this.f9164i && f();
        }

        public void a(int i4) {
            if (i4 >= 0 && i4 <= 1) {
                synchronized (e.f9122a) {
                    this.f9169n = i4;
                    e.f9122a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i4, int i5) {
            synchronized (e.f9122a) {
                try {
                    this.f9167l = i4;
                    this.f9168m = i5;
                    this.f9174s = true;
                    this.f9170o = true;
                    this.f9172q = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    e.f9122a.notifyAll();
                    while (!this.f9157b && !this.f9159d && !this.f9172q && a()) {
                        try {
                            e.f9122a.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (e.f9122a) {
                    this.f9173r.add(runnable);
                    e.f9122a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    public static class k {
        private k() {
        }

        public synchronized void a(j jVar) {
            notifyAll();
        }

        public synchronized void b(j jVar) {
            jVar.f9157b = true;
            notifyAll();
        }
    }

    public interface l {
        GL a(GL gl);
    }

    public static class m extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f9181a = new StringBuilder();

        private void a() {
            if (this.f9181a.length() > 0) {
                Log.v("GLSurfaceView26", this.f9181a.toString());
                StringBuilder sb = this.f9181a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i4, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                char c4 = cArr[i4 + i6];
                if (c4 == '\n') {
                    a();
                } else {
                    this.f9181a.append(c4);
                }
            }
        }
    }

    public class n extends c {
        public n(boolean z4) {
            super(8, 8, 8, 0, z4 ? 16 : 0, 0, 0, 0);
        }
    }

    public e(SurfaceView surfaceView) {
        this.f9123b = new WeakReference<>(surfaceView);
    }

    @Override // com.baidu.platform.comapi.map.r
    public Bitmap captureImageFromSurface(int i4, int i5, int i6, int i7, Object obj, Bitmap.Config config) {
        return a(i4, i5, i6, i7, (GL10) obj, config);
    }

    public void finalize() throws Throwable {
        try {
            j jVar = this.f9126e;
            if (jVar != null) {
                jVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getDebugFlags() {
        return this.f9133l;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getFPS() {
        return this.f9124c;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getRenderMode() {
        return this.f9126e.b();
    }

    @Override // com.baidu.platform.comapi.map.r
    public s.a getViewType() {
        return s.a.OPENGL_ES;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onAttachedToWindow() {
        if (this.f9128g && this.f9127f != null) {
            j jVar = this.f9126e;
            int iB = jVar != null ? jVar.b() : 1;
            j jVar2 = new j(this.f9125d);
            this.f9126e = jVar2;
            if (iB != 1) {
                jVar2.a(iB);
            }
            this.f9126e.start();
        }
        this.f9128g = false;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onDetachedFromWindow() {
        j jVar = this.f9126e;
        if (jVar != null) {
            jVar.g();
        }
        this.f9128g = true;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onPause() {
        this.f9126e.d();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onResume() {
        this.f9126e.e();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void queueEvent(Runnable runnable) {
        this.f9126e.a(runnable);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void requestRender() {
        this.f9126e.h();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setDebugFlags(int i4) {
        this.f9133l = i4;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setFPS(int i4) {
        if (i4 <= 0) {
            return;
        }
        if (i4 > 60) {
            i4 = 60;
        }
        this.f9124c = i4;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderMode(int i4) {
        this.f9126e.a(i4);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        b();
        if (this.f9129h == null) {
            this.f9129h = new n(true);
        }
        if (this.f9130i == null) {
            this.f9130i = new d();
        }
        if (this.f9131j == null) {
            this.f9131j = new C0048e();
        }
        this.f9127f = surfaceRenderer;
        j jVar = new j(this.f9125d);
        this.f9126e = jVar;
        jVar.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        this.f9126e.a(i5, i6);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f9126e.k();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f9126e.l();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        j jVar = this.f9126e;
        if (jVar != null) {
            jVar.b(runnable);
        }
    }

    public void b(boolean z4) {
        this.f9135n = z4;
    }

    public int c() {
        SurfaceView surfaceView = this.f9123b.get();
        if (surfaceView != null) {
            return surfaceView.getHeight();
        }
        return 0;
    }

    public SurfaceHolder d() {
        SurfaceView surfaceView = this.f9123b.get();
        if (surfaceView != null) {
            return surfaceView.getHolder();
        }
        return null;
    }

    public int e() {
        SurfaceView surfaceView = this.f9123b.get();
        if (surfaceView != null) {
            return surfaceView.getWidth();
        }
        return 0;
    }

    private void b() {
        if (this.f9126e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a(g gVar) {
        b();
        this.f9130i = gVar;
    }

    public void a(f fVar) {
        b();
        this.f9129h = fVar;
    }

    public void a(boolean z4) {
        a(new n(z4));
    }

    public void a(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        a(new c(i4, i5, i6, i7, i8, i9, i10, i11));
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<e> f9150a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f9151b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f9152c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f9153d;

        /* renamed from: e, reason: collision with root package name */
        EGLConfig f9154e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f9155f;

        public i(WeakReference<e> weakReference) {
            this.f9150a = weakReference;
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f9153d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f9151b.eglMakeCurrent(this.f9152c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            e eVar = this.f9150a.get();
            if (eVar != null) {
                eVar.f9131j.destroySurface(this.f9151b, this.f9152c, this.f9153d);
            }
            this.f9153d = null;
        }

        public GL a() {
            GL gl = this.f9155f.getGL();
            e eVar = this.f9150a.get();
            if (eVar == null) {
                return gl;
            }
            if (eVar.f9132k != null) {
                gl = eVar.f9132k.a(gl);
            }
            if ((eVar.f9133l & 3) != 0) {
                return GLDebugHelper.wrap(gl, (eVar.f9133l & 1) == 0 ? 0 : 1, (eVar.f9133l & 2) != 0 ? new m() : null);
            }
            return gl;
        }

        public boolean b() {
            if (this.f9151b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f9152c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f9154e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            d();
            e eVar = this.f9150a.get();
            if (eVar != null) {
                this.f9153d = eVar.f9131j.createWindowSurface(this.f9151b, this.f9152c, this.f9154e, eVar.d());
            } else {
                this.f9153d = null;
            }
            EGLSurface eGLSurface = this.f9153d;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.f9151b.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (this.f9151b.eglMakeCurrent(this.f9152c, eGLSurface, eGLSurface, this.f9155f)) {
                return true;
            }
            a("EGLHelper", "eglMakeCurrent", this.f9151b.eglGetError());
            return false;
        }

        public void c() {
            d();
        }

        public void e() {
            if (this.f9155f != null) {
                e eVar = this.f9150a.get();
                if (eVar != null) {
                    eVar.f9130i.destroyContext(this.f9151b, this.f9152c, this.f9155f);
                }
                this.f9155f = null;
            }
            EGLDisplay eGLDisplay = this.f9152c;
            if (eGLDisplay != null) {
                this.f9151b.eglTerminate(eGLDisplay);
                this.f9152c = null;
            }
        }

        public void f() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f9151b = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f9152c = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f9151b.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            e eVar = this.f9150a.get();
            if (eVar == null) {
                this.f9154e = null;
                this.f9155f = null;
            } else {
                try {
                    this.f9154e = eVar.f9129h.chooseConfig(this.f9151b, this.f9152c);
                    this.f9155f = eVar.f9130i.createContext(this.f9151b, this.f9152c, this.f9154e);
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            EGLContext eGLContext = this.f9155f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f9155f = null;
                a("createContext");
            }
            this.f9153d = null;
        }

        public int g() {
            if (this.f9151b.eglSwapBuffers(this.f9152c, this.f9153d)) {
                return 12288;
            }
            return this.f9151b.eglGetError();
        }

        private void a(String str) {
            b(str, this.f9151b.eglGetError());
        }

        public static void a(String str, String str2, int i4) {
            Log.w(str, a(str2, i4));
        }

        public static String a(String str, int i4) {
            StringBuilder sbV = B0.g.v(str, " failed: ");
            sbV.append(a(i4));
            return sbV.toString();
        }

        public static void b(String str, int i4) {
            throw new RuntimeException(a(str, i4));
        }

        private static String a(int i4) {
            switch (i4) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i4);
            }
        }

        private static String b(int i4) {
            return "0x" + Integer.toHexString(i4);
        }
    }

    public void a(int i4) {
        b();
        this.f9134m = i4;
    }

    public class c extends b {

        /* renamed from: c, reason: collision with root package name */
        private int[] f9138c;

        /* renamed from: d, reason: collision with root package name */
        protected int f9139d;

        /* renamed from: e, reason: collision with root package name */
        protected int f9140e;

        /* renamed from: f, reason: collision with root package name */
        protected int f9141f;

        /* renamed from: g, reason: collision with root package name */
        protected int f9142g;

        /* renamed from: h, reason: collision with root package name */
        protected int f9143h;

        /* renamed from: i, reason: collision with root package name */
        protected int f9144i;

        /* renamed from: j, reason: collision with root package name */
        protected int f9145j;

        /* renamed from: k, reason: collision with root package name */
        protected int f9146k;

        public c(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            super(new int[]{12324, i4, 12323, i5, 12322, i6, 12321, i7, 12325, i8, 12326, i9, 12338, i10, 12337, i11, 12344});
            this.f9138c = new int[1];
            this.f9139d = i4;
            this.f9140e = i5;
            this.f9141f = i6;
            this.f9142g = i7;
            this.f9143h = i8;
            this.f9144i = i9;
            this.f9145j = i10;
            this.f9146k = i11;
        }

        @Override // com.baidu.platform.comapi.map.e.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            EGLConfig eGLConfig = null;
            for (EGLConfig eGLConfig2 : eGLConfigArr) {
                int iA = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                int iA2 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                if (iA >= this.f9143h && iA2 >= this.f9144i) {
                    int iA3 = a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                    int iA4 = a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                    int iA5 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                    int iA6 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                    if (iA3 == this.f9139d && iA4 == this.f9140e && iA5 == this.f9141f && iA6 == this.f9142g) {
                        if (eGLConfig == null) {
                            eGLConfig = eGLConfig2;
                        }
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.f9146k) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i4, int i5) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i4, this.f9138c) ? this.f9138c[0] : i5;
        }
    }

    private Bitmap a(int i4, int i5, int i6, int i7, GL10 gl10, Bitmap.Config config) {
        Bitmap bitmapCreateBitmap;
        int i8 = i6 * i7;
        int[] iArr = new int[i8];
        int[] iArr2 = new int[i8];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        try {
            gl10.glReadPixels(i4, i5, i6, i7, 6408, 5121, intBufferWrap);
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = i9 * i6;
                int i11 = ((i7 - i9) - 1) * i6;
                for (int i12 = 0; i12 < i6; i12++) {
                    int i13 = iArr[i10 + i12];
                    iArr2[i11 + i12] = (i13 & (-16711936)) | ((i13 << 16) & 16711680) | ((i13 >> 16) & 255);
                }
            }
            if (config == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i6, i7, Bitmap.Config.ARGB_8888);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i6, i7, config);
            }
            return a(bitmapCreateBitmap);
        } catch (GLException unused) {
            return null;
        }
    }

    public Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int i4 = width * height;
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = (iArr[i5] & 16777215) | (-16777216);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }
}

package okio.internal;

import gc.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import lb.d;
import okio.ByteString;
import sd.e0;
import sd.j;
import sd.k;
import sd.l;
import sd.t;
import sd.x;
import td.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: f, reason: collision with root package name */
    public static final x f11336f;

    /* renamed from: c, reason: collision with root package name */
    public final ClassLoader f11337c;

    /* renamed from: d, reason: collision with root package name */
    public final l f11338d;

    /* renamed from: e, reason: collision with root package name */
    public final d f11339e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: okio.internal.a$a, reason: collision with other inner class name */
    public static final class C0123a {
        public static final boolean a(x xVar) {
            x xVar2 = a.f11336f;
            ByteString byteStringP = xVar.f11982a;
            int iL = ByteString.l(byteStringP, c.f13075a);
            if (iL == -1) {
                iL = ByteString.l(xVar.f11982a, c.f13076b);
            }
            if (iL != -1) {
                byteStringP = ByteString.p(byteStringP, iL + 1, 0, 2);
            } else if (xVar.d() != null && byteStringP.d() == 2) {
                byteStringP = ByteString.f11312d;
            }
            return !o.e0(byteStringP.r(), ".class", true);
        }
    }

    static {
        String str = x.f11981b;
        f11336f = x.a.a("/");
    }

    public a(ClassLoader classLoader) {
        t systemFileSystem = l.f11959a;
        g.f(systemFileSystem, "systemFileSystem");
        this.f11337c = classLoader;
        this.f11338d = systemFileSystem;
        this.f11339e = kotlin.b.b(new zb.a<List<? extends Pair<? extends l, ? extends x>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x0268, code lost:
            
                if (r8.h < r0.f13081b) goto L101;
             */
            /* JADX WARN: Code restructure failed: missing block: B:102:0x0274, code lost:
            
                if (((java.lang.Boolean) r12.invoke(r8)).booleanValue() != false) goto L103;
             */
            /* JADX WARN: Code restructure failed: missing block: B:103:0x0276, code lost:
            
                r1.add(r8);
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x027a, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:105:0x027b, code lost:
            
                r8 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x027d, code lost:
            
                r17 = r17 + 1;
                r9 = r20;
                r10 = r21;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x028d, code lost:
            
                throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
             */
            /* JADX WARN: Code restructure failed: missing block: B:109:0x028e, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:110:0x028f, code lost:
            
                r20 = r9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x0292, code lost:
            
                r20 = r9;
                r0 = lb.n.f10413a;
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x0296, code lost:
            
                r20.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:113:0x0299, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x029b, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x029d, code lost:
            
                r20.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x02a1, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x02a2, code lost:
            
                jd.b.c(r8, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x02a5, code lost:
            
                r0 = r8;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x02a6, code lost:
            
                if (r0 == null) goto L122;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x02a8, code lost:
            
                r1 = new sd.g0(r6, r2, okio.internal.b.a(r1));
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x02b1, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x02b4, code lost:
            
                r6 = new kotlin.Pair(r1, okio.internal.a.f11336f);
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x02c8, code lost:
            
                throw r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:132:0x02d0, code lost:
            
                throw new java.io.IOException("unsupported zip: spanned");
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0111, code lost:
            
                r0 = r8.C() & 65535;
                r11 = r8.C() & 65535;
                r10 = r8.C() & 65535;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x012c, code lost:
            
                r26 = r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0137, code lost:
            
                if (r10 != (r8.C() & 65535)) goto L194;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0139, code lost:
            
                if (r0 != 0) goto L195;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x013b, code lost:
            
                if (r11 != 0) goto L196;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x013d, code lost:
            
                r15 = r9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x0142, code lost:
            
                r8.skip(4);
                r32 = r8.C() & 65535;
                r20 = new td.d(r10, r8.o() & 4294967295L, r32);
                r8.K(r32);
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x0164, code lost:
            
                r8.close();
                r13 = r13 - 20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x016d, code lost:
            
                if (r13 <= 0) goto L89;
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x016f, code lost:
            
                r9 = new sd.z(r7.C(r13));
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x017f, code lost:
            
                if (r9.o() != 117853008) goto L78;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0181, code lost:
            
                r8 = r9.o();
                r10 = r9.w();
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x018e, code lost:
            
                if (r9.o() != 1) goto L197;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0190, code lost:
            
                if (r8 != 0) goto L198;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0192, code lost:
            
                r10 = new sd.z(r7.C(r10));
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x019b, code lost:
            
                r8 = r10.o();
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x01a2, code lost:
            
                if (r8 != 101075792) goto L199;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x01a4, code lost:
            
                r10.skip(12);
                r8 = r10.o();
                r11 = r10.o();
                r28 = r10.w();
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x01bb, code lost:
            
                if (r28 != r10.w()) goto L200;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x01bd, code lost:
            
                if (r8 != 0) goto L201;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x01bf, code lost:
            
                if (r11 != 0) goto L202;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x01c1, code lost:
            
                r10.skip(8);
                r27 = new td.d(r28, r10.w(), r32);
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x01d1, code lost:
            
                r0 = lb.n.f10413a;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x01d6, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x01d8, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x01dc, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x01dd, code lost:
            
                r1 = r0;
                r20 = r27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x01e6, code lost:
            
                throw new java.io.IOException("unsupported zip: spanned");
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x01e7, code lost:
            
                r1 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x020f, code lost:
            
                throw new java.io.IOException("bad zip: expected " + okio.internal.b.b(101075792) + " but was " + okio.internal.b.b(r8));
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x0210, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:68:0x0216, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:69:0x0217, code lost:
            
                jd.b.c(r1, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x021a, code lost:
            
                r0 = r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:73:0x021e, code lost:
            
                throw r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x021f, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:77:0x0227, code lost:
            
                throw new java.io.IOException("unsupported zip: spanned");
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x0228, code lost:
            
                r0 = lb.n.f10413a;
             */
            /* JADX WARN: Code restructure failed: missing block: B:80:0x022d, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:81:0x022f, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:85:0x0235, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:86:0x0236, code lost:
            
                jd.b.c(r0, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:87:0x0239, code lost:
            
                r0 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:88:0x023a, code lost:
            
                if (r0 != null) goto L204;
             */
            /* JADX WARN: Code restructure failed: missing block: B:89:0x023c, code lost:
            
                r0 = r20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x023f, code lost:
            
                throw r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0244, code lost:
            
                r1 = new java.util.ArrayList();
                r9 = new sd.z(r7.C(r0.f13081b));
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x0254, code lost:
            
                r10 = r0.f13080a;
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x025a, code lost:
            
                r8 = okio.internal.b.c(r9);
             */
            /* JADX WARN: Code restructure failed: missing block: B:98:0x0260, code lost:
            
                r20 = r9;
                r21 = r10;
             */
            /* JADX WARN: Removed duplicated region for block: B:122:0x02a8 A[Catch: all -> 0x0240, TRY_LEAVE, TryCatch #0 {all -> 0x0240, blocks: (B:26:0x00ff, B:36:0x0164, B:38:0x016f, B:90:0x023f, B:86:0x0236, B:93:0x0244, B:122:0x02a8, B:128:0x02c8, B:119:0x02a2, B:134:0x02d4, B:137:0x02e3, B:138:0x02ea, B:139:0x02eb, B:140:0x02ee, B:143:0x02f4, B:144:0x030a, B:116:0x029d, B:27:0x0108, B:29:0x0111, B:35:0x0142, B:131:0x02cb, B:132:0x02d0, B:83:0x0231, B:39:0x0178, B:41:0x0181, B:44:0x0192, B:73:0x021e, B:69:0x0217, B:76:0x0222, B:77:0x0227, B:78:0x0228), top: B:156:0x00ff, inners: #1, #2, #10, #16 }] */
            /* JADX WARN: Removed duplicated region for block: B:126:0x02bd  */
            /* JADX WARN: Removed duplicated region for block: B:203:0x021e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:204:0x023f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:206:0x02c8 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:209:0x02c0 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:72:0x021d  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x025a A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #4 {all -> 0x028e, blocks: (B:94:0x0254, B:97:0x025a), top: B:163:0x0254 }] */
            @Override // zb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.util.List<? extends kotlin.Pair<? extends sd.l, ? extends sd.x>> invoke() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 799
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.internal.ResourceFileSystem$roots$2.invoke():java.lang.Object");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sd.l
    public final k a(x xVar) {
        if (!C0123a.a(xVar)) {
            return null;
        }
        x xVar2 = f11336f;
        xVar2.getClass();
        String strR = c.b(xVar2, xVar, true).b(xVar2).f11982a.r();
        for (Pair pair : (List) this.f11339e.getValue()) {
            k kVarA = ((l) pair.f9985a).a(((x) pair.f9986b).c(strR));
            if (kVarA != null) {
                return kVarA;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sd.l
    public final j b(x file) throws FileNotFoundException {
        g.f(file, "file");
        if (!C0123a.a(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        x xVar = f11336f;
        xVar.getClass();
        String strR = c.b(xVar, file, true).b(xVar).f11982a.r();
        Iterator it = ((List) this.f11339e.getValue()).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            try {
                return ((l) pair.f9985a).b(((x) pair.f9986b).c(strR));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // sd.l
    public final e0 c(x file) throws IOException {
        g.f(file, "file");
        if (!C0123a.a(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        x xVar = f11336f;
        xVar.getClass();
        URL resource = this.f11337c.getResource(c.b(xVar, file, false).b(xVar).f11982a.r());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + file);
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        g.e(inputStream, "getInputStream(...)");
        return jd.b.J(inputStream);
    }
}

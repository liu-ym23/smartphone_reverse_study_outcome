package m5;

import ia.d0;
import ia.f1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import k5.t;
import w7.e0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final File f6400a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6401b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6402c;

    /* renamed from: d, reason: collision with root package name */
    public final t f6403d;

    /* renamed from: e, reason: collision with root package name */
    public final na.d f6404e;

    /* renamed from: f, reason: collision with root package name */
    public final ka.g f6405f;

    /* renamed from: g, reason: collision with root package name */
    public volatile BufferedWriter f6406g;

    /* renamed from: h, reason: collision with root package name */
    public volatile long f6407h;

    public h(File file, long j2, int i2, k5.a aVar, t tVar, k5.q qVar) {
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f6400a = file;
        this.f6401b = j2;
        this.f6402c = i2;
        this.f6403d = tVar;
        na.d dVarB = d0.b(f1.plus(d0.c(), aVar.f5619d));
        this.f6404e = dVarB;
        g7.d dVar = null;
        this.f6405f = a.a.b(256, 6, null);
        file.mkdirs();
        d();
        c();
        d0.s(dVarB, null, null, new a6.r(this, dVar, 3), 3);
        if (qVar != null) {
            ((a7.d) qVar).J(k5.i.class, dVarB, new e(this, dVar, 0));
        }
        if (qVar != null) {
            ((a7.d) qVar).J(k5.m.class, dVarB, new e(this, dVar, 1));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|50|12|13|22|23|(1:25)|26|54|27|(1:29)(3:30|31|(6:52|33|(1:35)|38|(1:40)|43))|47|17|(13:19|(2:21|56)|13|22|23|(0)|26|54|27|(0)(0)|47|17|(1:48)(0))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
    
        k5.s.warn$default(r11.f6403d, "FileAuditLogger", a1.a.w("audit write failed: ", r0.getMessage()), null, 4, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: all -> 0x0106, TRY_ENTER, TryCatch #0 {all -> 0x0106, blocks: (B:12:0x0027, B:22:0x004e, B:19:0x003f), top: B:50:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4 A[Catch: all -> 0x00ed, TRY_LEAVE, TryCatch #2 {all -> 0x00ed, blocks: (B:27:0x00af, B:30:0x00b4, B:43:0x00e6, B:42:0x00e3, B:33:0x00d0, B:35:0x00d4, B:38:0x00db, B:40:0x00df), top: B:54:0x00af, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:13:0x002a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(m5.h r11, i7.c r12) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.h.a(m5.h, i7.c):java.lang.Object");
    }

    public final void b(b bVar) {
        if (this.f6405f.u(bVar) instanceof ka.m) {
            k5.s.debug$default(this.f6403d, "FileAuditLogger", "audit queue full, drop ".concat(bVar.f6379b), null, 4, null);
        }
    }

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis() - (this.f6402c * 86400000);
        File[] fileArrListFiles = this.f6400a.listFiles(new d(0));
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.lastModified() < jCurrentTimeMillis) {
                    arrayList.add(file);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((File) it.next()).delete();
                } catch (Throwable th) {
                    e0.n(th);
                }
            }
        }
    }

    public final void d() {
        File file = new File(this.f6400a, a1.a.j("audit-", new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(new Date()), ".log"));
        this.f6406g = new BufferedWriter(new FileWriter(file, true));
        this.f6407h = file.exists() ? file.length() : 0L;
    }
}

package m5;

import ia.d0;
import ia.f1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import k5.t;
import m4.i0;
import w7.e0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final File f6412a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6413b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6414c;

    /* renamed from: d, reason: collision with root package name */
    public final t f6415d;

    /* renamed from: e, reason: collision with root package name */
    public final na.d f6416e;

    /* renamed from: f, reason: collision with root package name */
    public final ka.g f6417f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f6418g;

    /* renamed from: h, reason: collision with root package name */
    public volatile BufferedWriter f6419h;

    /* renamed from: i, reason: collision with root package name */
    public volatile long f6420i;

    public j(File file, long j2, int i2, k5.a aVar, t tVar, k5.q qVar) {
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f6412a = file;
        this.f6413b = j2;
        this.f6414c = i2;
        this.f6415d = tVar;
        na.d dVarB = d0.b(f1.plus(d0.c(), aVar.f5619d));
        this.f6416e = dVarB;
        g7.d dVar = null;
        this.f6417f = a.a.b(256, 6, null);
        this.f6418g = new LinkedHashMap(64, 0.75f, true);
        file.mkdirs();
        b();
        d0.s(dVarB, null, null, new a6.r(this, dVar, 4), 3);
        if (qVar != null) {
            ((a7.d) qVar).J(k5.p.class, dVarB, new g3.c(this, dVar, 1));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|50|12|13|22|23|(1:25)|26|54|27|(1:29)(3:30|31|(6:52|33|(1:35)|38|(1:40)|43))|47|17|(13:19|(2:21|56)|13|22|23|(0)|26|54|27|(0)(0)|47|17|(1:48)(0))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010c, code lost:
    
        k5.s.warn$default(r12.f6415d, "FileTraceLogger", a1.a.w("trace write failed: ", r0.getMessage()), null, 4, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: all -> 0x0124, TRY_ENTER, TryCatch #0 {all -> 0x0124, blocks: (B:12:0x0027, B:22:0x004e, B:19:0x003f), top: B:50:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5 A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #2 {all -> 0x010b, blocks: (B:27:0x00d0, B:30:0x00d5, B:43:0x0107, B:42:0x0104, B:33:0x00f1, B:35:0x00f5, B:38:0x00fc, B:40:0x0100), top: B:54:0x00d0, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0124 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:13:0x002a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(m5.j r12, i7.c r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.j.a(m5.j, i7.c):java.lang.Object");
    }

    public final void b() {
        File file = new File(this.f6412a, a1.a.j("trace-", new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(new Date()), ".log"));
        this.f6419h = new BufferedWriter(new FileWriter(file, true));
        this.f6420i = file.exists() ? file.length() : 0L;
        File[] fileArrListFiles = this.f6412a.listFiles(new d(1));
        if (fileArrListFiles != null) {
            Iterator it = d7.r.K0(d7.n.u0(fileArrListFiles, new i0(1)), this.f6414c).iterator();
            while (it.hasNext()) {
                try {
                    ((File) it.next()).delete();
                } catch (Throwable th) {
                    e0.n(th);
                }
            }
        }
    }
}

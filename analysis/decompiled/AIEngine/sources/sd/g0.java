package sd;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 extends l {

    /* renamed from: f, reason: collision with root package name */
    public static final x f11939f;

    /* renamed from: c, reason: collision with root package name */
    public final x f11940c;

    /* renamed from: d, reason: collision with root package name */
    public final l f11941d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f11942e;

    static {
        String str = x.f11981b;
        f11939f = x.a.a("/");
    }

    public g0(x xVar, l fileSystem, LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.g.f(fileSystem, "fileSystem");
        this.f11940c = xVar;
        this.f11941d = fileSystem;
        this.f11942e = linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    @Override // sd.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final sd.k a(sd.x r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.g0.a(sd.x):sd.k");
    }

    @Override // sd.l
    public final j b(x file) {
        kotlin.jvm.internal.g.f(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // sd.l
    public final e0 c(x file) throws Throwable {
        z zVar;
        Throwable th;
        kotlin.jvm.internal.g.f(file, "file");
        x xVar = f11939f;
        xVar.getClass();
        td.f fVar = (td.f) this.f11942e.get(td.c.b(xVar, file, true));
        if (fVar == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        long j10 = fVar.f13090f;
        j jVarB = this.f11941d.b(this.f11940c);
        try {
            zVar = new z(jVarB.C(fVar.h));
            try {
                jVarB.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (jVarB != null) {
                try {
                    jVarB.close();
                } catch (Throwable th4) {
                    jd.b.c(th3, th4);
                }
            }
            zVar = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.g.f(zVar, "<this>");
        okio.internal.b.e(zVar, null);
        if (fVar.f13091g == 0) {
            return new td.e(zVar, j10, true);
        }
        return new td.e(new r(new z(new td.e(zVar, fVar.f13089e, true)), new Inflater(true)), j10, false);
    }
}

package w5;

import android.os.StatFs;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import kc.w;
import od.v;
import od.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public z f15228a;

    /* renamed from: b, reason: collision with root package name */
    public v f15229b;

    /* renamed from: c, reason: collision with root package name */
    public double f15230c;

    /* renamed from: d, reason: collision with root package name */
    public long f15231d;

    /* renamed from: e, reason: collision with root package name */
    public long f15232e;

    /* renamed from: f, reason: collision with root package name */
    public rc.d f15233f;

    public final h a() {
        long jR;
        double d7 = this.f15230c;
        z zVar = this.f15228a;
        if (zVar == null) {
            od.f.e("directory == null");
            return null;
        }
        if (d7 > 0.0d) {
            try {
                File file = zVar.toFile();
                file.mkdir();
                StatFs statFs = new StatFs(file.getAbsolutePath());
                jR = p5.f.r((long) (d7 * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.f15231d, this.f15232e);
            } catch (Exception unused) {
                jR = this.f15231d;
            }
        } else {
            jR = 0;
        }
        v vVar = this.f15229b;
        rc.d dVar = this.f15233f;
        h hVar = new h();
        hVar.f15265a = vVar;
        e eVar = new e();
        eVar.f15247c = zVar;
        eVar.f15248f = jR;
        if (jR <= 0) {
            g5.f.s("maxSize <= 0");
            return null;
        }
        eVar.f15249g = zVar.d("journal");
        eVar.f15250h = zVar.d("journal.tmp");
        eVar.i = zVar.d("journal.bkp");
        eVar.f15251j = new LinkedHashMap(0, 0.75f, true);
        eVar.f15252k = w.a(ac.a.N(w.c(), dVar.P(1)));
        vVar.getClass();
        d dVar2 = new d();
        dVar2.f15245b = vVar;
        VarHandle.storeStoreFence();
        eVar.f15261t = dVar2;
        VarHandle.storeStoreFence();
        hVar.f15266b = eVar;
        VarHandle.storeStoreFence();
        return hVar;
    }
}

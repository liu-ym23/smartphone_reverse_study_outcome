package A2;

import g1.AbstractC1451a;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f76a = 0;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object e;

    public b(long j5, e eVar, String str, String str2) {
        this.e = eVar;
        this.b = str;
        this.d = str2;
        this.c = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        switch (this.f76a) {
            case 0:
                long j5 = this.c;
                String str = this.d;
                String str2 = this.b;
                try {
                    e eVar = (e) this.e;
                    LinkedList linkedList = eVar.e;
                    if (linkedList.size() >= eVar.f87r) {
                        dVar = (d) linkedList.poll();
                        if (dVar != null) {
                            linkedList.add(dVar);
                        }
                    } else {
                        dVar = null;
                    }
                    if (dVar == null) {
                        dVar = new d();
                        dVar.b = str;
                        dVar.c = j5;
                        dVar.f78a = str2;
                        linkedList.add(dVar);
                    }
                    dVar.b = str;
                    dVar.f78a = str2;
                    dVar.c = j5;
                } catch (Throwable unused) {
                }
                int i = com.apm.insight.g.f2162q;
                if (i > 0 && i != 0) {
                    try {
                        File fileJ = N9.j.j();
                        if (fileJ != null) {
                            M.a.t(N9.j.g + " activityLifeCycle " + AbstractC1451a.i().format(new Date(j5)) + " : " + str2 + ' ' + str + '\n', fileJ, true);
                            break;
                        }
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                break;
            default:
                ((B0.d) this.e).e(this.c, this.b, this.d);
                break;
        }
    }

    public b(B0.d dVar, String str, long j5, String str2) {
        this.e = dVar;
        this.b = str;
        this.c = j5;
        this.d = str2;
    }
}

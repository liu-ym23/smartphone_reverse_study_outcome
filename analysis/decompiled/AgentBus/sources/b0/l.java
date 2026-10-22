package b0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.LocalServerSocket;
import android.widget.Toast;
import java.util.List;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1231f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1232g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1233h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1234i;

    public /* synthetic */ l(p pVar, c0.a aVar, o2 o2Var, e1 e1Var) {
        this.f1231f = 0;
        this.f1232g = pVar;
        this.f1233h = aVar;
        this.f1234i = o2Var;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f1231f;
        c7.r rVar = c7.r.f1986a;
        Object obj = this.f1234i;
        Object obj2 = this.f1233h;
        Object obj3 = this.f1232g;
        switch (i2) {
            case 0:
                p pVar = (p) obj3;
                c0.a aVar = (c0.a) obj2;
                o2 o2Var = (o2) obj;
                c0.b bVar = pVar.K;
                c0.a aVar2 = bVar.f1716b;
                try {
                    bVar.f1716b = aVar;
                    o2 o2Var2 = pVar.F;
                    int[] iArr = pVar.f1284n;
                    k.t tVar = pVar.f1291u;
                    pVar.f1284n = null;
                    pVar.f1291u = null;
                    try {
                        pVar.F = o2Var;
                        boolean z4 = bVar.f1719e;
                        try {
                            bVar.f1719e = false;
                            throw null;
                        } finally {
                        }
                    } catch (Throwable th) {
                        pVar.F = o2Var2;
                        pVar.f1284n = iArr;
                        pVar.f1291u = tVar;
                        throw th;
                    }
                } catch (Throwable th2) {
                    bVar.f1716b = aVar2;
                    throw th2;
                }
            case 1:
                a aVar3 = (a) obj3;
                s2 s2Var = (s2) obj2;
                c0.h0 h0Var = (c0.h0) obj;
                if (aVar3 != null) {
                    s2Var.a(s2Var.c(aVar3) - s2Var.f1365t);
                }
                List listJ = ib.k.j(s2Var, null, s2Var.f1365t, null);
                m0.b bVar2 = (m0.b) d7.r.X0(listJ);
                Integer num = bVar2 != null ? bVar2.f6122a : null;
                List listW = h0Var.w(num);
                if (num != null && !listW.isEmpty()) {
                    m0.b bVar3 = (m0.b) d7.r.N0(listW);
                    List listK0 = d7.r.K0(listW, 1);
                    bVar3.getClass();
                    listW = d7.r.c1(a.a.S(new m0.b(null, num)), listK0);
                }
                return d7.r.c1(listJ, listW);
            case 2:
                c6.h hVar = (c6.h) obj3;
                LocalServerSocket localServerSocket = (LocalServerSocket) obj;
                hVar.f1944f.set(false);
                ia.f1.cancel$default((ia.g1) obj2, (CancellationException) null, 1, (Object) null);
                try {
                    localServerSocket.close();
                } catch (Throwable th3) {
                    w7.e0.n(th3);
                }
                hVar.f1946h = null;
                k5.s.info$default(hVar.f1942d, "LSServer", "LocalSocket stopped", null, 4, null);
                return rVar;
            default:
                c.i iVar = (c.i) obj3;
                l0.q qVar = (l0.q) obj2;
                qVar.getClass();
                f0.c cVar = l0.r.d(qVar).f5809c;
                List list = w5.a0.f10676k;
                String strK = w5.a0.k(cVar, (w5.e) ((f1) obj).getValue());
                Object systemService = iVar.getSystemService("clipboard");
                ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("diagnostic", strK));
                }
                Toast.makeText(iVar, "诊断报告已复制到剪贴板 (" + strK.length() + " 字符)", 0).show();
                return rVar;
        }
    }

    public /* synthetic */ l(c6.h hVar, ia.w1 w1Var, ka.t tVar, LocalServerSocket localServerSocket) {
        this.f1231f = 2;
        this.f1232g = hVar;
        this.f1233h = w1Var;
        this.f1234i = localServerSocket;
    }

    public /* synthetic */ l(Object obj, Object obj2, Object obj3, int i2) {
        this.f1231f = i2;
        this.f1232g = obj;
        this.f1233h = obj2;
        this.f1234i = obj3;
    }
}

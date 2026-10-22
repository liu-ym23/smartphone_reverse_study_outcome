package ad;

import java.io.EOFException;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends c0 {

    /* renamed from: e, reason: collision with root package name */
    public static final s f575e;

    /* renamed from: f, reason: collision with root package name */
    public static final s f576f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f577g;

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f578h;
    public static final byte[] i;

    /* renamed from: a, reason: collision with root package name */
    public od.l f579a;

    /* renamed from: b, reason: collision with root package name */
    public List f580b;

    /* renamed from: c, reason: collision with root package name */
    public s f581c;

    /* renamed from: d, reason: collision with root package name */
    public long f582d;

    static {
        Pattern pattern = s.f568d;
        f575e = id.k.t("multipart/mixed");
        id.k.t("multipart/alternative");
        id.k.t("multipart/digest");
        id.k.t("multipart/parallel");
        f576f = id.k.t("multipart/form-data");
        f577g = new byte[]{58, 32};
        f578h = new byte[]{13, 10};
        i = new byte[]{45, 45};
    }

    @Override // ad.c0
    public final long a() throws EOFException {
        long j10 = this.f582d;
        if (j10 != -1) {
            return j10;
        }
        long jD = d(null, true);
        this.f582d = jD;
        return jD;
    }

    @Override // ad.c0
    public final s b() {
        return this.f581c;
    }

    @Override // ad.c0
    public final void c(od.j jVar) throws EOFException {
        d(jVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long d(od.j jVar, boolean z10) throws EOFException {
        od.i iVar;
        od.j iVar2;
        od.l lVar = this.f579a;
        List list = this.f580b;
        if (z10) {
            iVar2 = new od.i();
            iVar = iVar2;
        } else {
            iVar = 0;
            iVar2 = jVar;
        }
        int size = list.size();
        long j10 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = i;
            byte[] bArr2 = f578h;
            if (i3 >= size) {
                iVar2.getClass();
                iVar2.write(bArr);
                iVar2.t(lVar);
                iVar2.write(bArr);
                iVar2.write(bArr2);
                if (!z10) {
                    return j10;
                }
                iVar.getClass();
                long j11 = j10 + iVar.f9454f;
                iVar.d();
                return j11;
            }
            t tVar = (t) list.get(i3);
            n nVar = tVar.f573a;
            c0 c0Var = tVar.f574b;
            iVar2.getClass();
            iVar2.write(bArr);
            iVar2.t(lVar);
            iVar2.write(bArr2);
            int size2 = nVar.size();
            for (int i10 = 0; i10 < size2; i10++) {
                iVar2.v(nVar.b(i10)).write(f577g).v(nVar.d(i10)).write(bArr2);
            }
            s sVarB = c0Var.b();
            if (sVarB != null) {
                iVar2.v("Content-Type: ").v(sVarB.f570a).write(bArr2);
            }
            long jA = c0Var.a();
            if (jA != -1) {
                iVar2.v("Content-Length: ").I(jA).write(bArr2);
            } else if (z10) {
                iVar.getClass();
                iVar.d();
                return -1L;
            }
            iVar2.write(bArr2);
            if (z10) {
                j10 += jA;
            } else {
                c0Var.c(iVar2);
            }
            iVar2.write(bArr2);
            i3++;
        }
    }
}

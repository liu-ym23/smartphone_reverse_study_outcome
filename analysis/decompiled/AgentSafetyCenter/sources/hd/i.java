package hd;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends dd.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5497e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5498f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5499g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i, Object obj, Object obj2, String str) {
        super(str, true);
        this.f5497e = i;
        this.f5498f = obj;
        this.f5499g = obj2;
    }

    @Override // dd.a
    public final long a() {
        int i;
        long jA;
        v[] vVarArr;
        switch (this.f5497e) {
            case 0:
                ed.m mVar = ((o) this.f5498f).f5518c;
                z zVar = (z) ((yb.u) this.f5499g).f16098c;
                synchronized (mVar) {
                    zVar.getClass();
                    mVar.f3832n = (zVar.f5588a & 16) != 0 ? zVar.f5589b[4] : Reader.READ_DONE;
                }
                return -1L;
            case 1:
                v vVar = (v) this.f5499g;
                o oVar = (o) this.f5498f;
                try {
                    vVar.c(8, null);
                    return -1L;
                } catch (IOException e10) {
                    id.n.Companion.getClass();
                    id.n.platform.log("Http2Connection.Listener failure for " + oVar.f5520g, 4, e10);
                    try {
                        vVar.c(2, e10);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            default:
                k kVar = (k) this.f5498f;
                z zVar2 = (z) this.f5499g;
                yb.u uVar = new yb.u();
                o oVar2 = (o) kVar.f5506g;
                synchronized (oVar2.A) {
                    synchronized (oVar2) {
                        try {
                            z zVar3 = oVar2.f5533u;
                            z zVar4 = new z();
                            zVar3.getClass();
                            for (int i3 = 0; i3 < 10; i3++) {
                                if (((1 << i3) & zVar3.f5588a) != 0) {
                                    zVar4.b(i3, zVar3.f5589b[i3]);
                                }
                            }
                            for (int i10 = 0; i10 < 10; i10++) {
                                if (((1 << i10) & zVar2.f5588a) != 0) {
                                    zVar4.b(i10, zVar2.f5589b[i10]);
                                }
                            }
                            uVar.f16098c = zVar4;
                            jA = zVar4.a() - zVar3.a();
                            vVarArr = (jA == 0 || oVar2.f5519f.isEmpty()) ? null : (v[]) oVar2.f5519f.values().toArray(new v[0]);
                            z zVar5 = (z) uVar.f16098c;
                            zVar5.getClass();
                            oVar2.f5533u = zVar5;
                            oVar2.f5526n.c(new i(0, oVar2, uVar, oVar2.f5520g + " onSettings"), 0L);
                        } finally {
                        }
                    }
                    try {
                        oVar2.A.d((z) uVar.f16098c);
                    } catch (IOException e11) {
                        oVar2.d(2, 2, e11);
                    }
                }
                if (vVarArr == null) {
                    return -1L;
                }
                for (v vVar2 : vVarArr) {
                    synchronized (vVar2) {
                        vVar2.f5571f += jA;
                        if (jA > 0) {
                            vVar2.notifyAll();
                        }
                    }
                }
                return -1L;
        }
    }
}

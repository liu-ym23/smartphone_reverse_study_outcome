package u6;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final r f5712a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5713b;

    public m(n nVar, r rVar) {
        this.f5713b = nVar;
        this.f5712a = rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // p5.a
    public final Object invoke() throws Throwable {
        Throwable th;
        n nVar = this.f5713b;
        r rVar = this.f5712a;
        b bVar = b.f5672e;
        IOException iOException = null;
        try {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    nVar.a(this, bVar, iOException);
                    o6.d.a(rVar);
                    throw th;
                }
            } catch (IOException e9) {
                iOException = e9;
            }
            if (!rVar.a(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            do {
                try {
                } catch (Throwable th3) {
                    th = th3;
                    this = bVar;
                    nVar.a(this, bVar, iOException);
                    o6.d.a(rVar);
                    throw th;
                }
            } while (rVar.a(false, this));
            b bVar2 = b.f5671c;
            try {
                bVar = b.f5675h;
                nVar.a(bVar2, bVar, null);
                this = bVar2;
            } catch (IOException e10) {
                iOException = e10;
                b bVar3 = b.d;
                nVar.a(bVar3, bVar3, iOException);
                this = bVar3;
                o6.d.a(rVar);
                return b5.a0.f883a;
            }
            o6.d.a(rVar);
            return b5.a0.f883a;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}

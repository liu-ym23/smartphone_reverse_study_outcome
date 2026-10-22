package nb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6944e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f6945f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, g gVar) {
        super(str, true);
        this.f6945f = gVar;
    }

    @Override // db.a
    public final long a() throws IOException {
        switch (this.f6944e) {
            case 0:
                g gVar = this.f6945f;
                try {
                    if (gVar.h()) {
                    }
                } catch (IOException e10) {
                    gVar.c(e10, null);
                    break;
                }
                break;
            default:
                eb.i iVar = this.f6945f.f6956g;
                q7.k.b(iVar);
                iVar.e();
                break;
        }
        return -1L;
        return -1L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar) {
        super(a1.a.m(new StringBuilder(), gVar.f6961l, " writer"), true);
        this.f6945f = gVar;
    }
}

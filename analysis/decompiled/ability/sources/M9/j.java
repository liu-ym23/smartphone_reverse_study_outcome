package M9;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class j extends I9.a {
    public final /* synthetic */ o e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, o oVar, int i, int i6) {
        super(str, true);
        this.e = oVar;
        this.f = i;
        this.g = i6;
    }

    @Override // I9.a
    public final long a() throws IOException {
        o oVar = this.e;
        try {
            oVar.f991w.k(this.f, this.g, true);
            return -1L;
        } catch (IOException e) {
            oVar.c(e);
            return -1L;
        }
    }
}

package M9;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class n extends I9.a {
    public final /* synthetic */ o e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, o oVar, int i, long j5) {
        super(str, true);
        this.e = oVar;
        this.f = i;
        this.g = j5;
    }

    @Override // I9.a
    public final long a() throws IOException {
        o oVar = this.e;
        try {
            oVar.f991w.n(this.f, this.g);
            return -1L;
        } catch (IOException e) {
            oVar.c(e);
            return -1L;
        }
    }
}

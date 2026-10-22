package M9;

import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class k extends I9.a {
    public final /* synthetic */ o e;
    public final /* synthetic */ int f;
    public final /* synthetic */ V9.g g;
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str, o oVar, int i, V9.g gVar, int i6, boolean z10) {
        super(str, true);
        this.e = oVar;
        this.f = i;
        this.g = gVar;
        this.h = i6;
    }

    @Override // I9.a
    public final long a() {
        try {
            A a3 = this.e.k;
            V9.g gVar = this.g;
            int i = this.h;
            a3.getClass();
            gVar.skip(i);
            this.e.f991w.l(this.f, ErrorCode.CANCEL);
            synchronized (this.e) {
                this.e.y.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}

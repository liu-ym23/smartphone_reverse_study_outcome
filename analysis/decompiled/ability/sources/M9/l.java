package M9;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class l extends I9.a {
    public final /* synthetic */ int e;
    public final /* synthetic */ o f;
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(String str, o oVar, int i, Object obj, int i6) {
        super(str, true);
        this.e = i6;
        this.f = oVar;
        this.g = i;
        this.h = obj;
    }

    @Override // I9.a
    public final long a() throws IOException {
        switch (this.e) {
            case 0:
                this.f.k.getClass();
                try {
                    this.f.f991w.l(this.g, ErrorCode.CANCEL);
                    synchronized (this.f) {
                        this.f.y.remove(Integer.valueOf(this.g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            case 1:
                this.f.k.getClass();
                try {
                    this.f.f991w.l(this.g, ErrorCode.CANCEL);
                    synchronized (this.f) {
                        this.f.y.remove(Integer.valueOf(this.g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
            default:
                o oVar = this.f;
                try {
                    oVar.f991w.l(this.g, (ErrorCode) this.h);
                    return -1L;
                } catch (IOException e) {
                    oVar.c(e);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, o oVar, int i, List list, boolean z10) {
        super(str, true);
        this.e = 0;
        this.f = oVar;
        this.g = i;
        this.h = list;
    }
}

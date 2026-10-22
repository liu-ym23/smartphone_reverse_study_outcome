package M9;

import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class m extends I9.a {
    public final /* synthetic */ o e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, o oVar, int i, ErrorCode errorCode) {
        super(str, true);
        this.e = oVar;
        this.f = i;
    }

    @Override // I9.a
    public final long a() {
        this.e.k.getClass();
        synchronized (this.e) {
            this.e.y.remove(Integer.valueOf(this.f));
        }
        return -1L;
    }
}

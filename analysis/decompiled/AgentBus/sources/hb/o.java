package hb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class o extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f4311e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4312f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f4313g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, p pVar, int i2, long j2) {
        super(str, true);
        this.f4311e = pVar;
        this.f4312f = i2;
        this.f4313g = j2;
    }

    @Override // db.a
    public final long a() throws IOException {
        p pVar = this.f4311e;
        try {
            pVar.C.n(this.f4312f, this.f4313g);
            return -1L;
        } catch (IOException e10) {
            pVar.a(2, 2, e10);
            return -1L;
        }
    }
}

package A0;

import A0.e;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final K0.n f22a;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final D0.b f23a;

        public a(D0.b bVar) {
            this.f23a = bVar;
        }

        @Override // A0.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // A0.e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f23a);
        }
    }

    k(InputStream inputStream, D0.b bVar) {
        K0.n nVar = new K0.n(inputStream, bVar);
        this.f22a = nVar;
        nVar.mark(5242880);
    }

    @Override // A0.e
    public void b() {
        this.f22a.f();
    }

    @Override // A0.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f22a.reset();
        return this.f22a;
    }
}

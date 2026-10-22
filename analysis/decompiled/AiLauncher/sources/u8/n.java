package u8;

import u8.m;

/* loaded from: classes4.dex */
public abstract class n {

    public class a extends n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m.b f42493a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f42494b;

        public a(m.b bVar, g gVar) {
            this.f42493a = bVar;
            this.f42494b = gVar;
        }

        @Override // u8.n
        public m a() {
            return this.f42493a.c(this.f42494b, new s());
        }
    }

    public static n b(m.b bVar, g gVar) {
        return new a(bVar, gVar);
    }

    public abstract m a();
}

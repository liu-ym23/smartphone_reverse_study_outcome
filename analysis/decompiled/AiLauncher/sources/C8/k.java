package C8;

import C8.f;
import C8.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class k extends j {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1759a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, m> f1760b;

    public class a implements h.a<f.b> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u8.m f1761a;

        public a(u8.m mVar) {
            this.f1761a = mVar;
        }

        @Override // C8.h.a
        public void a(List<f.b> list) {
            m mVarB;
            for (f.b bVar : list) {
                if (bVar.isClosed() && (mVarB = k.this.b(bVar.name())) != null) {
                    mVarB.a(this.f1761a, k.this, bVar);
                }
            }
        }
    }

    public class b implements h.a<f.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u8.m f1763a;

        public b(u8.m mVar) {
            this.f1763a = mVar;
        }

        @Override // C8.h.a
        public void a(List<f.a> list) {
            for (f.a aVar : list) {
                if (aVar.isClosed()) {
                    m mVarB = k.this.b(aVar.name());
                    if (mVarB != null) {
                        mVarB.a(this.f1763a, k.this, aVar);
                    } else {
                        a(aVar.b());
                    }
                }
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, m> f1765a = new HashMap(2);

        /* renamed from: b, reason: collision with root package name */
        public boolean f1766b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1767c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1768d;

        public void a(m mVar) {
            for (String str : mVar.b()) {
                if (!this.f1765a.containsKey(str)) {
                    this.f1765a.put(str, mVar);
                }
            }
        }

        public void b(m mVar) {
            d();
            Iterator<String> it = mVar.b().iterator();
            while (it.hasNext()) {
                this.f1765a.put(it.next(), mVar);
            }
        }

        public j c() {
            d();
            this.f1768d = true;
            return this.f1765a.size() > 0 ? new k(this.f1766b, Collections.unmodifiableMap(this.f1765a)) : new l();
        }

        public final void d() {
            if (this.f1768d) {
                throw new IllegalStateException("Builder has been already built");
            }
        }

        public boolean e() {
            return this.f1767c;
        }
    }

    public k(boolean z10, Map<String, m> map) {
        this.f1759a = z10;
        this.f1760b = map;
    }

    @Override // C8.j
    public void a(u8.m mVar, h hVar) {
        int length = !this.f1759a ? -1 : mVar.length();
        hVar.b(length, new a(mVar));
        hVar.a(length, new b(mVar));
        hVar.d();
    }

    @Override // C8.j
    public m b(String str) {
        return this.f1760b.get(str);
    }
}

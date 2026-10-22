package I0;

import A0.j;
import H0.g;
import H0.m;
import H0.n;
import H0.o;
import H0.r;
import java.io.InputStream;
import z0.C1341g;
import z0.C1342h;

/* loaded from: classes.dex */
public class a implements n<g, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final C1341g<Integer> f2891b = C1341g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    private final m<g, g> f2892a;

    /* renamed from: I0.a$a, reason: collision with other inner class name */
    public static class C0037a implements o<g, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final m<g, g> f2893a = new m<>(500);

        @Override // H0.o
        public n<g, InputStream> a(r rVar) {
            return new a(this.f2893a);
        }

        @Override // H0.o
        public void b() {
        }
    }

    public a(m<g, g> mVar) {
        this.f2892a = mVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(g gVar, int i5, int i6, C1342h c1342h) {
        m<g, g> mVar = this.f2892a;
        if (mVar != null) {
            g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.f2892a.b(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) c1342h.c(f2891b)).intValue()));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar) {
        return true;
    }
}

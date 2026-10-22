package O0;

import C0.r;

/* loaded from: classes.dex */
public class e extends M0.b<c> implements r {
    public e(c cVar) {
        super(cVar);
    }

    @Override // M0.b, C0.r
    public void a() {
        ((c) this.f3994a).e().prepareToDraw();
    }

    @Override // C0.v
    public void b() {
        ((c) this.f3994a).stop();
        ((c) this.f3994a).k();
    }

    @Override // C0.v
    public int c() {
        return ((c) this.f3994a).i();
    }

    @Override // C0.v
    public Class<c> d() {
        return c.class;
    }
}

package rc;

import io.ktor.util.date.GMTDateParser;

/* loaded from: classes5.dex */
public class r extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39382d;

    /* renamed from: e, reason: collision with root package name */
    public I0 f39383e;

    /* renamed from: f, reason: collision with root package name */
    public I0 f39384f;

    public r(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, AbstractC5276d abstractC5276d3) {
        if (!(abstractC5276d instanceof r)) {
            if (abstractC5276d == null) {
                this.f39382d = new C5312v0(new C5294m(GMTDateParser.MONTH, "mathnormal"), false, true, true);
            } else {
                this.f39382d = abstractC5276d;
            }
            this.f39383e = new I0(abstractC5276d3);
            this.f39384f = new I0(abstractC5276d2);
            return;
        }
        r rVar = (r) abstractC5276d;
        this.f39382d = rVar.f39382d;
        rVar.f39383e.i(abstractC5276d3);
        rVar.f39384f.i(abstractC5276d2);
        this.f39383e = rVar.f39383e;
        this.f39384f = rVar.f39384f;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return new M0(this.f39382d, this.f39384f, this.f39383e).f(y02);
    }
}

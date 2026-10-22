package rc;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes5.dex */
public class Q0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39148d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39149e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39150f;

    public Q0(AbstractC5276d abstractC5276d, String str) {
        this.f39149e = true;
        this.f39150f = true;
        this.f39148d = abstractC5276d;
        if ("t".equals(str)) {
            this.f39150f = false;
        } else if (Const.INTENT_KEY_PKGNAME.equals(str)) {
            this.f39149e = false;
        }
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39148d.f(y02);
        if (this.f39149e) {
            abstractC5284hF.n(0.0f);
        }
        if (this.f39150f) {
            abstractC5284hF.m(0.0f);
        }
        return abstractC5284hF;
    }

    public Q0(AbstractC5276d abstractC5276d) {
        this.f39149e = true;
        this.f39150f = true;
        this.f39148d = abstractC5276d;
    }
}

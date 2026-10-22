package tc;

import com.autonavi.aps.amapapi.config.Const;
import rc.AbstractC5276d;
import rc.AbstractC5284h;
import rc.C5317y;
import rc.U0;
import rc.Y0;
import rc.a1;

/* loaded from: classes5.dex */
public class a extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public a1 f42356d = new a1();

    /* renamed from: e, reason: collision with root package name */
    public String f42357e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f42358f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f42359g;

    public a(String str, String str2) {
        this.f42357e = str;
        if (str2 == null || !str2.equals(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID)) {
            return;
        }
        this.f42358f = true;
    }

    public static boolean k() {
        return false;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        return new U0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public AbstractC5276d i() {
        if (!this.f42359g) {
            throw null;
        }
        AbstractC5276d abstractC5276d = this.f42356d.f39212d;
        return abstractC5276d == null ? new C5317y() : abstractC5276d;
    }

    public boolean j() {
        return this.f42358f;
    }
}

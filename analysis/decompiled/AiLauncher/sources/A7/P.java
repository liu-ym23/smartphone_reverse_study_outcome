package A7;

import android.content.Context;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z7.C6370e;
import z7.C6375j;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LA7/P;", "Ly7/C;", "LA7/S;", "<init>", "()V", Const.INTENT_KEY_UMID, "()LA7/S;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", "c", "(Landroid/view/View;LA7/S;)Ly7/s;", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P implements y7.C<S> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String id = "glass_refraction";

    @Override // y7.C
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y7.s a(View view, S params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        if (params.getCrossWindow()) {
            C6370e.c cVarF = C6370e.f45191a.f(view);
            if (cVarF == null) {
                return null;
            }
            O o10 = new O(cVarF);
            o10.a(params);
            return o10;
        }
        C6375j.c cVarM = C6375j.f45214a.m(view);
        if (cVarM == null) {
            return null;
        }
        C0738f c0738f = new C0738f(cVarM);
        c0738f.a(params);
        return c0738f;
    }

    @Override // y7.C
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public S get$params() {
        return new S();
    }

    @Override // y7.C
    public String getId() {
        return this.id;
    }

    @Override // y7.C
    public boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return C6370e.f45191a.n() || C6375j.f45214a.v();
    }
}

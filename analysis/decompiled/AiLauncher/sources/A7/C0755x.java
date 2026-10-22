package A7;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z7.C6370e;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LA7/x;", "Ly7/C;", "LA7/z;", "<init>", "()V", Const.INTENT_KEY_UMID, "()LA7/z;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", "c", "(Landroid/view/View;LA7/z;)Ly7/s;", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0755x implements y7.C<C0757z> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String id = "glass_text";

    @Override // y7.C
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y7.s a(View view, C0757z params) {
        C6370e.c cVarF;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        if (!params.getCrossWindow() || !(view instanceof TextView) || (cVarF = C6370e.f45191a.f(view)) == null) {
            return null;
        }
        C0754w c0754w = new C0754w(view, cVarF, params.getBlendOnly());
        c0754w.a(params);
        return c0754w;
    }

    @Override // y7.C
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0757z get$params() {
        return new C0757z();
    }

    @Override // y7.C
    public String getId() {
        return this.id;
    }

    @Override // y7.C
    public boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return C6370e.f45191a.n();
    }
}

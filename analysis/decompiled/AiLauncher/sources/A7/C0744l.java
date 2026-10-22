package A7;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z7.C6370e;
import z7.C6375j;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"LA7/l;", "Ly7/C;", "LA7/n;", "<init>", "()V", Const.INTENT_KEY_UMID, "()LA7/n;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", "c", "(Landroid/view/View;LA7/n;)Ly7/s;", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", Const.INTENT_KEY_PKGNAME, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0744l implements y7.C<C0746n> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String id = "blur";

    @Override // y7.C
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y7.s a(View view, C0746n params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        if (params.getCrossWindow()) {
            C6370e.c cVarF = C6370e.f45191a.f(view);
            if (cVarF != null) {
                U u10 = new U(cVarF);
                u10.a(params);
                return u10;
            }
            Log.i("MotionKitBlur", "自研玻璃不可用，兜底为 tint 背景");
            a0 a0Var = new a0(view);
            a0Var.a(params);
            return a0Var;
        }
        C6375j c6375j = C6375j.f45214a;
        C6375j.c cVarM = c6375j.v() ? c6375j.m(view) : null;
        if (cVarM != null) {
            G g10 = new G(cVarM);
            g10.a(params);
            return g10;
        }
        Log.i("MotionKitBlur", "窗口内玻璃不可用，兜底为 tint 背景");
        a0 a0Var2 = new a0(view);
        a0Var2.a(params);
        return a0Var2;
    }

    @Override // y7.C
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0746n get$params() {
        return new C0746n();
    }

    @Override // y7.C
    public String getId() {
        return this.id;
    }

    @Override // y7.C
    public boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return true;
    }
}

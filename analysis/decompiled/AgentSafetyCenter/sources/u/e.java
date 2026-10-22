package u;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final e f13444f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f13445g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13446c;

    static {
        int i = 1;
        f13444f = new e(i, 0);
        f13445g = new e(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, int i3) {
        super(i);
        this.f13446c = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f13446c) {
            case 0:
                s0.g gVar = (s0.g) obj;
                s2 s2Var = AndroidCompositionLocals_androidKt.f982b;
                gVar.getClass();
                if (((Context) k0.z.x(gVar, s2Var)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return g.f13462b;
                }
                d.f13437a.getClass();
                return c.f13432c;
            default:
                return Boolean.valueOf(!(((o1.s) obj).i == 2));
        }
    }
}

package v1;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final n f14504f;

    /* renamed from: g, reason: collision with root package name */
    public static final n f14505g;

    /* renamed from: h, reason: collision with root package name */
    public static final n f14506h;
    public static final n i;

    /* renamed from: j, reason: collision with root package name */
    public static final n f14507j;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14508c;

    static {
        int i3 = 1;
        f14504f = new n(i3, 0);
        f14505g = new n(i3, 1);
        f14506h = new n(i3, 2);
        i = new n(i3, 3);
        f14507j = new n(i3, 4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i3, int i10) {
        super(i3);
        this.f14508c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f14508c) {
            case 0:
                return jb.v.f6774a;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                s0.g gVar = (s0.g) obj;
                k0.e0 e0Var = AndroidCompositionLocals_androidKt.f981a;
                gVar.getClass();
                k0.z.x(gVar, e0Var);
                return ((Context) k0.z.x(gVar, AndroidCompositionLocals_androidKt.f982b)).getResources();
            default:
                return Boolean.valueOf(g0.l(obj));
        }
    }
}

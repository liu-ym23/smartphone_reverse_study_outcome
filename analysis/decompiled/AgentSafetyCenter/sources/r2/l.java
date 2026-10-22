package r2;

import androidx.lifecycle.x;
import jb.v;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends yb.l implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public static final l f10417f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f10418g;

    /* renamed from: h, reason: collision with root package name */
    public static final l f10419h;
    public static final l i;

    /* renamed from: j, reason: collision with root package name */
    public static final l f10420j;

    /* renamed from: k, reason: collision with root package name */
    public static final l f10421k;

    /* renamed from: l, reason: collision with root package name */
    public static final l f10422l;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10423c;

    static {
        int i3 = 2;
        f10417f = new l(i3, 0);
        f10418g = new l(i3, 1);
        f10419h = new l(i3, 2);
        i = new l(i3, 3);
        f10420j = new l(i3, 4);
        f10421k = new l(i3, 5);
        f10422l = new l(i3, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i3, int i10) {
        super(i3);
        this.f10423c = i10;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i3;
        switch (this.f10423c) {
            case 0:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setUpdateBlock((xb.l) obj2);
                break;
            case 1:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setReleaseBlock((xb.l) obj2);
                break;
            case 2:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setModifier((w0.m) obj2);
                break;
            case 3:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setDensity((o2.c) obj2);
                break;
            case 4:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setLifecycleOwner((x) obj2);
                break;
            case 5:
                androidx.compose.ui.viewinterop.a.c((g0) obj).setSavedStateRegistryOwner((t4.f) obj2);
                break;
            default:
                q qVarC = androidx.compose.ui.viewinterop.a.c((g0) obj);
                int iOrdinal = ((o2.l) obj2).ordinal();
                if (iOrdinal != 0) {
                    i3 = 1;
                    if (iOrdinal != 1) {
                        g5.f.a();
                        break;
                    }
                } else {
                    i3 = 0;
                }
                qVarC.setLayoutDirection(i3);
                break;
        }
        return v.f6774a;
    }
}

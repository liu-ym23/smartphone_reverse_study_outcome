package k8;

import com.stepos.agentsafetycenter.MainActivity;
import java.util.List;
import m8.k0;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7333c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ d0 f7334f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k0 f7335g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f7333c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                d0 d0Var = this.f7334f;
                k0 k0Var = this.f7335g;
                p3 p3Var = (p3) obj;
                int i3 = MainActivity.f2491h;
                p3Var.getClass();
                k0Var.F(p3Var, ((c0) d0Var).f7289c instanceof w ? "all_records" : "security_center");
                break;
            default:
                d0 d0Var2 = this.f7334f;
                k0 k0Var2 = this.f7335g;
                List list = (List) obj;
                int i10 = MainActivity.f2491h;
                list.getClass();
                k0Var2.E(((c0) d0Var2).f7289c instanceof w ? "all_records" : "security_center", list);
                break;
        }
        return vVar;
    }
}

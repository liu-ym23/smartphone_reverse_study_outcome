package k8;

import android.util.Log;
import com.stepos.agentsafetycenter.MainActivity;
import java.util.List;
import java.util.Set;
import m8.k0;
import s8.p3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7303c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0 f7304f;

    public /* synthetic */ h(int i) {
        this.f7303c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f7303c;
        jb.v vVar = jb.v.f6774a;
        k0 k0Var = this.f7304f;
        switch (i) {
            case 0:
                Set set = (Set) obj;
                int i3 = MainActivity.f2491h;
                set.getClass();
                k0Var.D(set);
                break;
            case 1:
                p3 p3Var = (p3) obj;
                int i10 = MainActivity.f2491h;
                p3Var.getClass();
                k0Var.F(p3Var, "security_center");
                break;
            case 2:
                p3 p3Var2 = (p3) obj;
                int i11 = MainActivity.f2491h;
                p3Var2.getClass();
                k0Var.F(p3Var2, "all_records");
                break;
            case 3:
                List list = (List) obj;
                int i12 = MainActivity.f2491h;
                list.getClass();
                k0Var.E("all_records", list);
                break;
            case 4:
                List list2 = (List) obj;
                int i13 = MainActivity.f2491h;
                list2.getClass();
                k0Var.C(list2);
                break;
            default:
                String str = (String) obj;
                Log.i("BehaviorAnalysis", str);
                k0Var.U(m8.a.a(k0Var.v(), false, k0.a.o(k0Var.v().f8270b, str, "\n"), null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073741821));
                break;
        }
        return vVar;
    }
}

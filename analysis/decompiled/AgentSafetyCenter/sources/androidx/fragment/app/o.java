package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements d.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1295c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ v f1296f;

    @Override // d.b
    public final void a(Object obj) {
        switch (this.f1295c) {
            case 0:
                Map map = (Map) obj;
                v vVar = this.f1296f;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                t tVar = (t) vVar.f1327x.pollFirst();
                if (tVar == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    String str = tVar.f1303c;
                    vVar.f1307c.a();
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    break;
                }
            default:
                v vVar2 = this.f1296f;
                t tVar2 = (t) vVar2.f1327x.pollFirst();
                if (tVar2 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                } else {
                    String str2 = tVar2.f1303c;
                    vVar2.f1307c.a();
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                    break;
                }
        }
    }
}

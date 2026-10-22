package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.y0;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends y0 {

    /* renamed from: f, reason: collision with root package name */
    public static final x f1338f = new x(0);

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1339b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f1340c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f1341d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1342e;

    @Override // androidx.lifecycle.y0
    public final void d() {
        if (u.h(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1342e = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && y.class == obj.getClass()) {
            y yVar = (y) obj;
            if (this.f1339b.equals(yVar.f1339b) && this.f1340c.equals(yVar.f1340c) && this.f1341d.equals(yVar.f1341d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1341d.hashCode() + ((this.f1340c.hashCode() + (this.f1339b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f1339b.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f1340c.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f1341d.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}

package a1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    public final View f72b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f71a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f73c = new ArrayList();

    public v(View view) {
        this.f72b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f72b == vVar.f72b && this.f71a.equals(vVar.f71a);
    }

    public final int hashCode() {
        return this.f71a.hashCode() + (this.f72b.hashCode() * 31);
    }

    public final String toString() {
        String strN = a8.b.n(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f72b + "\n", "    values:");
        HashMap map = this.f71a;
        for (String str : map.keySet()) {
            strN = strN + "    " + str + ": " + map.get(str) + "\n";
        }
        return strN;
    }
}

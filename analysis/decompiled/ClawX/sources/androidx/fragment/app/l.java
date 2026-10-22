package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f682a;

    public l(int i8) {
        switch (i8) {
            case 1:
                this.f682a = new ArrayList(20);
                break;
            default:
                this.f682a = new ArrayList();
                new HashMap();
                new HashMap();
                break;
        }
    }

    public n6.k a() {
        return new n6.k((String[]) this.f682a.toArray(new String[0]));
    }

    public List b() {
        ArrayList arrayList;
        if (this.f682a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f682a) {
            arrayList = new ArrayList(this.f682a);
        }
        return arrayList;
    }

    public void c(String str) {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f682a;
            if (i8 >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i8))) {
                arrayList.remove(i8);
                arrayList.remove(i8);
                i8 -= 2;
            }
            i8 += 2;
        }
    }
}

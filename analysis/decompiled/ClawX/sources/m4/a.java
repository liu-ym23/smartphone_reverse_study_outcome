package m4;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final char f3895a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3896b;

    public a(char c3, List list, ArrayList arrayList) {
        this.f3895a = c3;
        this.f3896b = arrayList;
        a[] aVarArr = new a[256];
        for (int i8 = 0; i8 < 256; i8++) {
            ArrayList arrayList2 = this.f3896b;
            int size = arrayList2.size();
            Object obj = null;
            boolean z = false;
            int i9 = 0;
            Object obj2 = null;
            while (true) {
                if (i9 < size) {
                    Object obj3 = arrayList2.get(i9);
                    i9++;
                    if (((a) obj3).f3895a == i8) {
                        if (z) {
                            break;
                        }
                        z = true;
                        obj2 = obj3;
                    }
                } else if (z) {
                    obj = obj2;
                }
            }
            aVarArr[i8] = obj;
        }
    }
}

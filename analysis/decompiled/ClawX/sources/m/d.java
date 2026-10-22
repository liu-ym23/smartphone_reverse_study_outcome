package m;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e0.a0;
import java.util.Comparator;
import v0.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3871a;

    public /* synthetic */ d(int i8) {
        this.f3871a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int top;
        int top2;
        switch (this.f3871a) {
            case 0:
                top = ((g) obj).f3878b;
                top2 = ((g) obj2).f3878b;
                break;
            case 1:
                top = ((View) obj).getTop();
                top2 = ((View) obj2).getTop();
                break;
            case 2:
                int[] iArr = a0.f2285a;
                float z = ((View) obj).getZ();
                float z2 = ((View) obj2).getZ();
                if (z > z2) {
                    return -1;
                }
                return z < z2 ? 1 : 0;
            default:
                k kVar = (k) obj;
                k kVar2 = (k) obj2;
                RecyclerView recyclerView = kVar.d;
                if ((recyclerView == null) == (kVar2.d == null)) {
                    boolean z8 = kVar.f5861a;
                    if (z8 == kVar2.f5861a) {
                        int i8 = kVar2.f5862b - kVar.f5862b;
                        if (i8 != 0) {
                            return i8;
                        }
                        int i9 = kVar.f5863c - kVar2.f5863c;
                        if (i9 != 0) {
                            return i9;
                        }
                        return 0;
                    }
                    if (!z8) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
        }
        return top - top2;
    }
}

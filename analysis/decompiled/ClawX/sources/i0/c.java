package i0;

import android.graphics.Rect;
import f0.g;
import java.util.Comparator;
import t1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3102a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3103b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3104c;
    public final f d;

    public c(boolean z, f fVar) {
        this.f3104c = z;
        this.d = fVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.d.getClass();
        Rect rect = this.f3102a;
        ((g) obj).f(rect);
        Rect rect2 = this.f3103b;
        ((g) obj2).f(rect2);
        int i8 = rect.top;
        int i9 = rect2.top;
        if (i8 < i9) {
            return -1;
        }
        if (i8 > i9) {
            return 1;
        }
        int i10 = rect.left;
        int i11 = rect2.left;
        boolean z = this.f3104c;
        if (i10 < i11) {
            return z ? 1 : -1;
        }
        if (i10 > i11) {
            return z ? -1 : 1;
        }
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        if (i12 < i13) {
            return -1;
        }
        if (i12 > i13) {
            return 1;
        }
        int i14 = rect.right;
        int i15 = rect2.right;
        if (i14 < i15) {
            return z ? 1 : -1;
        }
        if (i14 > i15) {
            return z ? -1 : 1;
        }
        return 0;
    }
}

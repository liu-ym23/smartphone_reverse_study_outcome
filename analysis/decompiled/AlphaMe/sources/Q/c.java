package Q;

import L.g;
import android.graphics.Rect;
import java.util.Comparator;
import y1.f;

/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1599a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f1600b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1601c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1602d;

    public c(boolean z4, f fVar) {
        this.f1601c = z4;
        this.f1602d = fVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f1602d.getClass();
        Rect rect = this.f1599a;
        ((g) obj).e(rect);
        Rect rect2 = this.f1600b;
        ((g) obj2).e(rect2);
        int i4 = rect.top;
        int i5 = rect2.top;
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        int i6 = rect.left;
        int i7 = rect2.left;
        boolean z4 = this.f1601c;
        if (i6 < i7) {
            return z4 ? 1 : -1;
        }
        if (i6 > i7) {
            return z4 ? -1 : 1;
        }
        int i8 = rect.bottom;
        int i9 = rect2.bottom;
        if (i8 < i9) {
            return -1;
        }
        if (i8 > i9) {
            return 1;
        }
        int i10 = rect.right;
        int i11 = rect2.right;
        if (i10 < i11) {
            return z4 ? 1 : -1;
        }
        if (i10 > i11) {
            return z4 ? -1 : 1;
        }
        return 0;
    }
}

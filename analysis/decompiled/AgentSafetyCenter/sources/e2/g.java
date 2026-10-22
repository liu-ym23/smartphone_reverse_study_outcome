package e2;

import android.text.Layout;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Layout.Alignment f3431a;

    /* renamed from: b, reason: collision with root package name */
    public static final Layout.Alignment f3432b;

    static {
        Layout.Alignment[] alignmentArrValues = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = alignment;
        for (Layout.Alignment alignment3 : alignmentArrValues) {
            if (k.a(alignment3.name(), "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (k.a(alignment3.name(), "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        f3431a = alignment;
        f3432b = alignment2;
    }
}

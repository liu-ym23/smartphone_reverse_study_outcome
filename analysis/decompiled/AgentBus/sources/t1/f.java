package t1;

import android.text.Layout;
import q7.k;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Layout.Alignment f9684a;

    /* renamed from: b, reason: collision with root package name */
    public static final Layout.Alignment f9685b;

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
        f9684a = alignment;
        f9685b = alignment2;
    }
}

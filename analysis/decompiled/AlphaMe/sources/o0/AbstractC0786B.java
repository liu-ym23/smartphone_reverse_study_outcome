package o0;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* renamed from: o0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0786B {
    @DoNotInline
    public static int a(ViewGroup viewGroup, int i4) {
        return viewGroup.getChildDrawingOrder(i4);
    }

    @DoNotInline
    public static void b(ViewGroup viewGroup, boolean z4) {
        viewGroup.suppressLayout(z4);
    }
}

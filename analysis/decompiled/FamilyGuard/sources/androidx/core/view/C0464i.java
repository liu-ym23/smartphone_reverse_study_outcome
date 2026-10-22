package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: androidx.core.view.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0464i {
    public static void a(int i5, int i6, int i7, Rect rect, Rect rect2, int i8) {
        Gravity.apply(i5, i6, i7, rect, rect2, i8);
    }

    public static int b(int i5, int i6) {
        return Gravity.getAbsoluteGravity(i5, i6);
    }
}

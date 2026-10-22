package androidx.appcompat.widget;

import android.widget.AbsListView;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.appcompat.widget.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0225s0 {
    @DoNotInline
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    @DoNotInline
    public static void b(AbsListView absListView, boolean z4) {
        absListView.setSelectedChildViewEnabled(z4);
    }
}

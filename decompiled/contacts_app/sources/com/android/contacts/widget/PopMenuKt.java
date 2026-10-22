package com.android.contacts.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.OPopover;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"show", "", "Lcom/obric/oui/popover/OPopover;", "anchor", "Landroid/view/View;", "offsetX", "", "offsetY", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PopMenuKt {
    public static final void show(OPopover r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "anchor");
        show$default(r7, r8, 0, 0, 6, null);
    }

    public static final void show(OPopover r7, View r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "anchor");
        show$default(r7, r8, r9, 0, 4, null);
    }

    public static /* synthetic */ void show$default(OPopover r1, View r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        show(r1, r2, r3, r4);
    }

    public static final void show(OPopover r10, View r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "anchor");
        int[] r3 = new int[2];
        r11.getLocationOnScreen(r3);
        int r5 = ((r3[1] + r11.getHeight()) + r10.getMeasuredHeight()) + r13;
        Context r6 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");
        if (r5 < OUnitExtensionKt.getScreenHeight(r6)) goto L5;
        int r7 = 48;
        int r8 = -r13;
    L6:
        int r2 = r7;
        r10.setTargetLocation(new Point(r3[0], r3[1]));
        OPopover.show$default(r10, r11, r2, true, 0.0f, r12, r8, false, 64, null);
        return;
    L5:
        r7 = 80;
        r8 = r13;
        goto L6
    }
}

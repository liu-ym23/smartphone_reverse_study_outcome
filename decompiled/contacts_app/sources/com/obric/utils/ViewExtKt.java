package com.obric.utils;

import android.graphics.Rect;
import android.view.View;
import com.GlobalProxyLancet;
import com.obric.oui.bouncelayout.ONestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"TAG", "", "scrollToFocusedView", "", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewExtKt {
    private static final String TAG = "ViewExt";

    public static /* synthetic */ void $r8$lambda$wG2Tl8oTbrWEt047lY2Q1CRLem4(View r0, ONestedScrollView r1) {
        scrollToFocusedView$lambda$0(r0, r1);
    }

    public static final void scrollToFocusedView(final ONestedScrollView r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        final View r0 = r2.findFocus();
        if (r0 != null) goto L5;
        return;
    L5:
        r2.post(new ViewExtKt$$ExternalSyntheticLambda0(r0, r2));
    }

    private static final void scrollToFocusedView$lambda$0(View r2, ONestedScrollView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this_scrollToFocusedView");
        Rect r0 = new Rect();     // Catch: Exception -> L7
        r2.getDrawingRect(r0);     // Catch: Exception -> L7
        r3.offsetDescendantRectToMyCoords(r2, r0);     // Catch: Exception -> L7
        int r4 = r3.getScrollY();     // Catch: Exception -> L7
        int r1 = r3.getHeight();     // Catch: Exception -> L7
        int r5 = r0.bottom;     // Catch: Exception -> L7
        int r6 = (r4 + r1) - r3.getPaddingBottom();     // Catch: Exception -> L7
        if (r5 <= r6) goto L12;
        r3.smoothScrollBy(0, r5 - r6);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error calculating scroll", e);
    }
}

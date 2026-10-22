package com.bytedance.android.ecom.arch.slice;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;

/* JADX INFO: loaded from: classes44.dex */
public final class q {
    public static TextDirectionHeuristic b(TextDirectionHeuristicCompat r100) {
        if (r100 != TextDirectionHeuristicsCompat.LTR) goto L7;
        return TextDirectionHeuristics.LTR;
    L7:
        if (r100 != TextDirectionHeuristicsCompat.RTL) goto L11;
        return TextDirectionHeuristics.RTL;
    L11:
        if (r100 != TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR) goto L15;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L15:
        if (r100 != TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL) goto L19;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L19:
        if (r100 != TextDirectionHeuristicsCompat.ANYRTL_LTR) goto L23;
        return TextDirectionHeuristics.ANYRTL_LTR;
    L23:
        if (r100 != TextDirectionHeuristicsCompat.LOCALE) goto L27;
        return TextDirectionHeuristics.LOCALE;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }

    public static StaticLayout a(CharSequence r210, int r211, TextPaint r212, int r213, Layout.Alignment r310, TextUtils.TruncateAt r311, int r312, int r313, TextDirectionHeuristicCompat r314) {
        return new StaticLayout(r210, 0, r211, r212, r213, r310, b(r314), 1.0f, 0.0f, false, r311, r312, r313);
    L5:
        e = move-exception;
        if (e.getMessage().contains("utext_close") == true) goto L9;
        throw e;
    L9:
        return new StaticLayout(r210, 0, r211, r212, r213, r310, b(r314), 1.0f, 0.0f, false, r311, r312, r313);
    }
}

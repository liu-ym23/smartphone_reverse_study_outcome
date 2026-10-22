package com.android.ttcjpaysdk.base.ui.Utils;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayAccessibilityHelper;", "", "()V", "announceForAccessibility", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "view", "Landroid/widget/TextView;", "text", "", "delay", "", "isAccessibilityEnable", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAccessibilityHelper {
    public static final CJPayAccessibilityHelper INSTANCE = null;

    static {
        INSTANCE = new CJPayAccessibilityHelper();
    }

    private CJPayAccessibilityHelper() {
    }

    private final boolean isAccessibilityEnable(Context r100) {
        if (r100 != null) goto L10;
        return false;
    L10:
        Object r101 = r100.getSystemService("accessibility");     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Exception -> L7
        return ((AccessibilityManager) r101).isEnabled();
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAccessibilityHelper#isAccessibilityEnable", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAccessibilityHelper#isAccessibilityEnable", e);
        return false;
    }

    public final void announceForAccessibility(Context r100, final TextView r101, final String r102, long r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (INSTANCE.isAccessibilityEnable(r100) == true) goto L11;
        return;
    L11:
        r101.sendAccessibilityEvent(8);     // Catch: Exception -> L8
        r101.postDelayed(new CJPayAccessibilityHelper$announceForAccessibility$1$1(r102, r101), r103);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAccessibilityHelper#announceForAccessibility", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAccessibilityHelper#announceForAccessibility", e);
    }
}

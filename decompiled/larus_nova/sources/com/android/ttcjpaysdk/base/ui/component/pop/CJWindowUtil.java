package com.android.ttcjpaysdk.base.ui.component.pop;

import android.content.Context;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJWindowUtil;", "", "()V", "isInHwMagicWindows", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJWindowUtil {
    public static final CJWindowUtil INSTANCE = null;

    static {
        INSTANCE = new CJWindowUtil();
    }

    private CJWindowUtil() {
    }

    public final boolean isInHwMagicWindows(Context r100) {
        if (r100 == null) goto L12;
        if (StringsKt.contains$default(r100.getResources().getConfiguration().toString(), "hw-magic-windows", false, 2, null) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJWindowUtil#isInHwMagicWindows", e);
        e.toString();
        return false;
    L12:
        return false;
    }
}

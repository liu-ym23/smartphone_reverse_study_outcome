package com.bytedance.android.ui.ec.widget.tools;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/tools/ECToastUtils;", "", "()V", "lastToast", "Landroid/widget/Toast;", "showToast", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "text", "", "isShortDuration", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/Boolean;)V", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECToastUtils {
    public static final ECToastUtils INSTANCE = null;
    private static Toast lastToast;

    private ECToastUtils() {
    }

    static {
        INSTANCE = new ECToastUtils();
    }

    public final void showToast(Context r100, CharSequence r101, Boolean r102) {
        if (r100 == null) goto L10;
        Context r103 = r100.getApplicationContext();
        if (r103 == null) goto L11;
        Toast r104 = lastToast;
        if (r104 == null) goto L8;
        r104.cancel();
    L8:
        lastToast = ECToast.INSTANCE.showToast(r103, r101, r102);
        return;
    L11:
        return;
    }

    public static /* synthetic */ void showToast$default(ECToastUtils r100, Context r101, CharSequence r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showToast(r101, r102, r103);
    }
}

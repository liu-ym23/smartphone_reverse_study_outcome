package com.android.ttcjpaysdk.base.ui.wrapper;

import android.app.Activity;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.ui.CJDialogToast;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/wrapper/CJDialogToastHelper;", "", "()V", "LENGTH_INFINITE", "", "LENGTH_LONG", "LENGTH_SHORT", "TAG", "", "currentToast", "Ljava/lang/ref/WeakReference;", "Lcom/android/ttcjpaysdk/base/ui/CJDialogToast;", "dismissCurrent", "", "showText", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "text", "", "duration", GXTemplateKey.GAIAX_LAYER_GRAVITY, "offsetX", "offsetY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJDialogToastHelper {
    public static final CJDialogToastHelper INSTANCE = null;
    public static final int LENGTH_INFINITE = -1;
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final String TAG = "CJTextToast";
    private static WeakReference<CJDialogToast> currentToast;

    static {
        INSTANCE = new CJDialogToastHelper();
    }

    private CJDialogToastHelper() {
    }

    @JvmStatic
    public static final void showText(Activity r100, CharSequence r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "text");
        showText$default(r100, r110, 0, 0, 0, 0, 60, null);
    }

    @JvmStatic
    public static final void showText(Activity r100, CharSequence r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "text");
        showText$default(r100, r110, r111, 0, 0, 0, 56, null);
    }

    @JvmStatic
    public static final void showText(Activity r100, CharSequence r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "text");
        showText$default(r100, r110, r111, r112, 0, 0, 48, null);
    }

    @JvmStatic
    public static final void showText(Activity r100, CharSequence r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "text");
        showText$default(r100, r110, r111, r112, r113, 0, 32, null);
    }

    @JvmStatic
    public static final void dismissCurrent() {
        WeakReference<CJDialogToast> r100 = currentToast;
        if (r100 == null) goto L7;
        CJDialogToast r101 = r100.get();
        if (r101 == null) goto L7;
        r101.dismiss();
        r101.onDestroy();
    L7:
        currentToast = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void showText(Activity r100, CharSequence r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r100.isFinishing() == false) goto L5;
    L15:
        CJLogger.b(TAG, "showText failed, activity is finishing or destroyed");
        return;
    L5:
        if (r100.isDestroyed() == true) goto L15;
        if (r101.length() != 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L13;
        return;
    L13:
        dismissCurrent();
        View r107 = null;
        CJDialogToast r108 = new CJDialogToast(r100, r107, 2, 0 == true ? 1 : 0);
        r108.setOffset(r104, r105);
        r108.showText(r101, r102, r103);
        currentToast = new WeakReference(r108);
        return;
    L10:
        r106 = false;
        goto L11
    }

    public static /* synthetic */ void showText$default(Activity r100, CharSequence r101, int r102, int r103, int r110, int r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        int r104 = 2000;
    L7:
        if ((r112 & 8) == 0) goto L9;
        int r105 = 17;
    L11:
        if ((r112 & 16) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r112 & 32) == 0) goto L17;
        int r107 = 0;
    L18:
        showText(r100, r101, r104, r105, r106, r107);
        return;
    L17:
        r107 = r111;
        goto L18
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }
}

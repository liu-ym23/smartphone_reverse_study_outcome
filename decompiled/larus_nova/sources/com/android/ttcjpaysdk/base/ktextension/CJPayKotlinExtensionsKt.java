package com.android.ttcjpaysdk.base.ktextension;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.crash.d;
import com.bytedance.crash.dumper.Scraps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u001a*\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e*\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0011\u001a*\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u000e*\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u0001*\u0004\u0018\u00010\u000f\u001a*\u0010\u0014\u001a\u00020\u0001*\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0007\u001a\"\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u001a&\u0010\u001a\u001a\u00020\u0001*\u0004\u0018\u00010\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u001cH\u0086\bø\u0001\u0000\u001a\f\u0010\u001d\u001a\u00020\u001e*\u0004\u0018\u00010\u0005\u001a\n\u0010\u001f\u001a\u00020\u001e*\u00020\u000e\u001a$\u0010 \u001a\u00020\u0001*\u0004\u0018\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\"\u0010 \u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0012\u0010!\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\"\u001a\u00020\u0004\u001a\f\u0010#\u001a\u00020\u0001*\u0004\u0018\u00010\u000f\u001a\u0016\u0010$\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"dismissSafely", "", "Landroid/app/Dialog;", "dp2px", "", "Landroid/content/Context;", "dp", "", "executeSafely", "Ljava/util/concurrent/ExecutorService;", "runnable", "Lkotlin/Function0;", "findOpt", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Landroid/app/Activity;", "id", "(Landroid/app/Activity;I)Landroid/view/View;", "(Landroid/view/View;I)Landroid/view/View;", "finishSafely", "finishSafelyDelay", "delayTime", "", Scraps.INNER_UNIT, "finishSelfDelay", "view", "ifAlive", "action", "Lkotlin/Function1;", "isAlive", "", "isVisible", "postDelaySafely", "px2dp", "spValue", "safeFinish", "showSafely", "activity", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayKotlinExtensionsKt {
    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final void dismissSafely(Dialog r100) {
        if (r100 == null) goto L17;
    L10:
        e = move-exception;
        a.f554342a.getClass();
        ALogService r101 = (ALogService) a.a(ALogService.class);
        if (r101 == null) goto L19;
        r101.e("CJPayKotlinExtensions", "Dialog.dismissSafely " + e.getMessage());
        return;
    L19:
        return;
    L4:
        if (r100.isShowing() == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L18;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);     // Catch: Exception -> L10
        return;
    L18:
        return;
    }

    public static final void finishSafely(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isFinishing()) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L11;
        r100.finish();
        return;
    }

    public static final boolean isAlive(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Activity) r100).isFinishing() == true) goto L7;
        return true;
    }

    public static final boolean isVisible(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void safeFinish(final Activity r100) {
        Runnable r101 = new RunnableC88701(r100);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r101.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r101);
    }

    public static final int dp2px(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static final void executeSafely(ExecutorService r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShutdown() == true) goto L9;
        r100.execute(new CJPayKotlinExtensionsKt$sam$java_lang_Runnable$0(r101));
        return;
    }

    public static final /* synthetic */ <T extends View> T findOpt(Activity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        T r102 = (T) r100.findViewById(r101);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return r102;
    }

    public static final void ifAlive(Context r100, Function1<? super Activity, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((r100 instanceof Activity) == true) goto L5;
        return;
    L5:
        if (((Activity) r100).isFinishing() == true) goto L9;
        r101.invoke(r100);
        return;
    }

    public static final int px2dp(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (int) (((double) (r101 * 1.0f)) / INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getApplicationContext().getResources()).scaledDensity);
    }

    public static final void showSafely(Dialog r100, Activity r101) {
        if (r100 == null) goto L22;
        if (r101 != null) goto L20;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L23;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ktextension_CJPayKotlinExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a.f554342a.getClass();
        ALogService r103 = (ALogService) a.a(ALogService.class);
        if (r103 == null) goto L24;
        r103.e("CJPayKotlinExtensions", "Dialog.showSafely " + e.getMessage());
        return;
    L24:
        return;
    L23:
        return;
    L20:
        if (r101.isFinishing() == true) goto L9;
        r102 = true;
        goto L10
    }

    public static final /* synthetic */ <T extends View> T findOpt(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        T r102 = (T) r100.findViewById(r101);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return r102;
    }

    public static final void finishSafelyDelay(final Activity r100, long r101, final Function0<Unit> r102) {
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(r100, r102), r101);
    }

    public static final void finishSelfDelay(final Activity r100, View r101, long r102) {
        if (r101 == null) goto L5;
        r101.postDelayed(new RunnableC88681(r100), r102);
        return;
    }

    public static final void postDelaySafely(final Context r100, final Function0<Unit> r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass2(r100, r101), r102);
    }

    public static final void postDelaySafely(final View r100, final Function0<Unit> r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r100 == null) goto L6;
        r100.postDelayed(new RunnableC88691(r100, r101), r102);
        return;
    }

    public static /* synthetic */ void finishSafelyDelay$default(Activity r100, long r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 300;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        finishSafelyDelay(r100, r101, r102);
    }

    public static /* synthetic */ void finishSelfDelay$default(Activity r100, View r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 300;
    L5:
        finishSelfDelay(r100, r101, r102);
    }
}

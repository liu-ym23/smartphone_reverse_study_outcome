package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/dialog/CJPayHalfPageDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "statusBarConfig", "windowConfig", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayHalfPageDialog extends Dialog {
    private final void statusBarConfig() {
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.setSoftInputMode(3);
    L5:
        Window r101 = getWindow();
        if (r101 == null) goto L8;
        r101.addFlags(Integer.MIN_VALUE);
    L8:
        Window r102 = getWindow();
        if (r102 == null) goto L12;
        r102.setStatusBarColor(ColorProtector.parseColor("#00000000"));
    L12:
        Window r103 = getWindow();
        WindowManager.LayoutParams r104 = null;
        if (r103 == null) goto L15;
        View r105 = INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_front_counter_dypay_dialog_CJPayHalfPageDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
    L16:
        if (r105 == null) goto L20;
        r105.setSystemUiVisibility(9216);
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L32;
        Window r106 = getWindow();
        if (r106 == null) goto L24;
        r104 = r106.getAttributes();
    L24:
        if (r104 == null) goto L27;
        r104.layoutInDisplayCutoutMode = 1;
    L27:
        Window r107 = getWindow();
        if (r107 == null) goto L33;
        r107.setAttributes(r104);
        return;
    L33:
        return;
    L32:
        return;
    L15:
        r105 = null;
        goto L16
    }

    private final void windowConfig() {
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.gravity = 80;
        r100.setAttributes(r101);
        return;
    }

    public CJPayHalfPageDialog(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, R.style.CJ_Pay_Dialog_Bottom_Half_Page);
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_front_counter_dypay_dialog_CJPayHalfPageDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        statusBarConfig();
        windowConfig();
    }
}

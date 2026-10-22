package com.alipay.sdk.app;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class H5OpenAuthActivity extends H5PayActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25158i;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    public void com_alipay_sdk_app_H5OpenAuthActivity__finish$___twin___() {
        super.finish();
    }

    public void com_alipay_sdk_app_H5OpenAuthActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void finish() {
        com_alipay_sdk_app_H5OpenAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_alipay_sdk_app_H5OpenAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f25158i == true) goto L11;
    L8:
        super.onDestroy();
        return;
    L11:
        a r100 = a.C0493a.a(getIntent());     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        com.alipay.sdk.m.k.a.b(this, r100, "", r100.f25772d);     // Catch: Throwable -> L10
        goto L8
    }

    public H5OpenAuthActivity() {
        this.f25158i = false;
    }

    public static View INVOKEVIRTUAL_com_alipay_sdk_app_H5OpenAuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_alipay_sdk_app_H5OpenAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(H5OpenAuthActivity r100) {
        r100.com_alipay_sdk_app_H5OpenAuthActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_alipay_sdk_app_H5OpenAuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_alipay_sdk_app_H5OpenAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(H5OpenAuthActivity r110) {
        r110.com_alipay_sdk_app_H5OpenAuthActivity__finish$___twin___();
        if ((r110 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L53
        if (r103 != null) goto L13;
    L16:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L53
        monitor-exit(r102);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r110).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r110).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r110.isFinishing() == true) goto L27;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L31;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L39;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L50
        if (r104 != null) goto L44;
        return;
    L44:
        r104.addFlags(268435456);     // Catch: Throwable -> L50
        r104.addFlags(2097152);     // Catch: Throwable -> L50
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L50
        r110.startActivity(r104);     // Catch: Throwable -> L47
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        a r101 = a.C0493a.a(r100);     // Catch: Throwable -> L22
        super.startActivity(r100);     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        Uri r102 = r100.getData();
    L7:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.toString().startsWith("alipays://platformapi/startapp") == false) goto L29;
        finish();
        return;
    L29:
        return;
    L6:
        r102 = null;
    L12:
        th = move-exception;
        if (r100 != null) goto L15;
    L17:
        String r103 = "null";
    L18:
        if (r101 == null) goto L20;
        com.alipay.sdk.m.k.a.a(r101, "biz", b.f25417p0, th, r103);
    L20:
        this.f25158i = true;
        throw th;
    L15:
        if (r100.getData() == null) goto L17;
        r103 = r100.getData().toString();
    L22:
        finish();
    }
}

package com.amap.api.maps.offlinemap;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.amap.api.mapcore.util.b5;
import com.amap.api.mapcore.util.p0;
import com.amap.api.mapcore.util.z4;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes28.dex */
public class OfflineMapActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z4 f28705a;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_amap_api_maps_offlinemap_OfflineMapActivity__finish$___twin___() {
        super.finish();
    }

    @Override // android.app.Activity
    public void finish() {
        com_amap_api_maps_offlinemap_OfflineMapActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r100) {
        com_amap_api_maps_offlinemap_OfflineMapActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_amap_api_maps_offlinemap_OfflineMapActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public void closeScr() {
        z4 r100 = this.f28705a;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.d();     // Catch: Throwable -> L7
    L5:
        finish();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public void com_amap_api_maps_offlinemap_OfflineMapActivity__onStop$___twin___() {
        super.onStop();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();     // Catch: Throwable -> L6
        z4 r100 = this.f28705a;     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.d();     // Catch: Throwable -> L6
        this.f28705a = null;     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public OfflineMapActivity() {
    }

    public static View INVOKEVIRTUAL_com_amap_api_maps_offlinemap_OfflineMapActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_amap_api_maps_offlinemap_OfflineMapActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(OfflineMapActivity r100) {
        r100.com_amap_api_maps_offlinemap_OfflineMapActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_amap_api_maps_offlinemap_OfflineMapActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_amap_api_maps_offlinemap_OfflineMapActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(OfflineMapActivity r110) {
        r110.com_amap_api_maps_offlinemap_OfflineMapActivity__finish$___twin___();
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

    public void com_amap_api_maps_offlinemap_OfflineMapActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);     // Catch: Throwable -> L11
        getWindow().setSoftInputMode(32);     // Catch: Throwable -> L11
        getWindow().setFormat(-3);     // Catch: Throwable -> L11
        requestWindowFeature(1);     // Catch: Throwable -> L11
        b5.b(getApplicationContext());     // Catch: Throwable -> L11
        p0.a(getApplicationContext());     // Catch: Throwable -> L11
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        return;
    L4:
        if (this.f28705a != null) goto L6;
        this.f28705a = new z4();     // Catch: Throwable -> L8
    L6:
        this.f28705a.a(this);     // Catch: Throwable -> L8
        this.f28705a.getClass();     // Catch: Throwable -> L8
        setContentView(this.f28705a.b());     // Catch: Throwable -> L8
        this.f28705a.e();     // Catch: Throwable -> L8
    L18:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        z4 r101 = this.f28705a;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.a(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static void com_amap_api_maps_offlinemap_OfflineMapActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(OfflineMapActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_amap_api_maps_offlinemap_OfflineMapActivity__onCreate$___twin___(r101);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L16;
        z4 r102 = this.f28705a;     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
    L10:
        finish();     // Catch: Throwable -> L13
        return false;
    L7:
        if (r102.a() == true) goto L10;
        return true;
    L13:
        th = move-exception;
        th.printStackTrace();
    L16:
        return super.onKeyDown(r100, r101);
    }
}

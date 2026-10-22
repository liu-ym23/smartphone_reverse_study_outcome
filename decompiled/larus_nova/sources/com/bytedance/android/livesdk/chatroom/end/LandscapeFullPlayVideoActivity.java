package com.bytedance.android.livesdk.chatroom.end;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/LandscapeFullPlayVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeFullPlayVideoActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f105890a = 0;

    public static final class a {
        public static void a(Context r100, String r101, int r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "url");
            Intent r105 = new Intent(r100, LandscapeFullPlayVideoActivity.class);
            r105.putExtra("position", r102);
            r105.putExtra("play_url", r101);
            if (r103 == null) goto L5;
            r105.putExtra("click_event", r103);
        L5:
            if (r104 == null) goto L7;
            r105.putExtra("click_event_params", r104);
        L7:
            r100.startActivity(r105);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f105891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f105892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LandscapeFullPlayVideoActivity f105893c;

        public b(String r100, HashMap r101, LandscapeFullPlayVideoActivity r102) {
            this.f105891a = r100;
            this.f105892b = r101;
            this.f105893c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f105891a;
            if (r101 == null) goto L17;
            HashMap r102 = this.f105892b;
            if (r102 == null) goto L18;
            LandscapeFullPlayVideoActivity r103 = this.f105893c;
            int r104 = LandscapeFullPlayVideoActivity.f105890a;
            r103.getClass();
            if (r102 == null) goto L9;
            String r105 = (String) r102.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "video_pause");
        L9:
            if (r101 != null) goto L11;
            return;
        L11:
            if (r101.length() <= 0) goto L13;
            boolean r106 = true;
        L14:
            if (r106 != true) goto L20;
            com.bytedance.android.livesdk.log.j0.l().sendLog(r101, r102, new Object[]{Room.class});
            return;
        L20:
            return;
        L13:
            r106 = false;
            goto L14
        L18:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeFullPlayVideoActivity f105894a;

        public c(LandscapeFullPlayVideoActivity r100) {
            this.f105894a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f105894a.finish();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105895a;

        public d(LiveVideoPreviewView r100) {
            this.f105895a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext()));     // Catch: Throwable -> L4
            int r101 = this.f105895a.getMeasuredWidth();     // Catch: Throwable -> L4
            LiveVideoPreviewView r102 = this.f105895a;     // Catch: Throwable -> L4
            int r103 = Math.min((int) (((r101 * 1.0f) / 343) * 192), r100);     // Catch: Throwable -> L4
            ViewGroup.LayoutParams r104 = r102.f105163d.getLayoutParams();     // Catch: Throwable -> L4
            r104.height = r103;     // Catch: Throwable -> L4
            r104.width = r101;     // Catch: Throwable -> L4
            r102.f105163d.setLayoutParams(r104);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f105896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105897b;

        public e(int r100, LiveVideoPreviewView r101) {
            this.f105896a = r100;
            this.f105897b = r101;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(LandscapeFullPlayVideoActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(LandscapeFullPlayVideoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public LandscapeFullPlayVideoActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L31
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L31
    L8:
        super.onCreate(r100);
        t8.b(getWindow());
        getWindow().addFlags(1024);
        t8.b(getWindow());
        Window r101 = getWindow();
        if (r101 == null) goto L12;
        t8.c(r101, t8.a(r101), 0);
    L12:
        setContentView(com.larus.nova.R.layout.ttlive_end_play_video_full_page_layout);
        View r102 = findViewById(com.larus.nova.R.id.end_play_back);
        if (r102 == null) goto L15;
        r102.setOnClickListener(new c(this));
    L15:
        LiveVideoPreviewView r103 = (LiveVideoPreviewView) findViewById(com.larus.nova.R.id.end_video_player_container);
        if (r103 == null) goto L34;
        int r104 = getIntent().getIntExtra("position", 0);
        String r105 = getIntent().getStringExtra("play_url");
        String r106 = getIntent().getStringExtra("click_event");
        String r107 = getIntent().getStringExtra("click_event_params");
        if (r107 == null) goto L20;
        HashMap r108 = com.bytedance.android.livesdk.dsl.util.c.h(r107);
    L21:
        r103.post(new d(r103));
        if (r105 != null) goto L24;
    L29:
        r103.setRadius(UtilityKotlinExtentionsKt.i(2));
        r103.setViewBg(null);
        r103.setTimeVisible(4);
        r103.f105178s = true;
        r103.S5(false);
        r103.f105179t = new b(r106, r108, this);
        r103.f105180u = new e(r104, r103);
        Unit r109 = Unit.INSTANCE;
        return;
    L24:
        if (r105.length() <= 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 != true) goto L29;
        r103.setDataSource(r105);
        goto L29
    L26:
        r110 = false;
        goto L27
    L20:
        r108 = null;
        goto L21
    }
}

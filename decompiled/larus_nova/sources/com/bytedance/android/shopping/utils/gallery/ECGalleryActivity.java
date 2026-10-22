package com.bytedance.android.shopping.utils.gallery;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.utils.r;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/ECGalleryActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGalleryActivity extends AbsActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f187097m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f187098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f187099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f187100l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECGalleryActivity f187101a;

        public b(ECGalleryActivity r100) {
            this.f187101a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
        public final void a() {
            ECGalleryActivity r100 = this.f187101a;
            int r101 = ECGalleryActivity.f187097m;
            r100.getClass();
            int r102 = t0.f45720a;
            Gson r103 = t0.a.f45722b;
            Intent r104 = r100.getIntent();
            if (r104 == null) goto L12;
            ArrayList<String> r105 = r104.getStringArrayListExtra("video");
            if (r105 == null) goto L12;
            ?? r106 = new ArrayList();
            Iterator r107 = r105.iterator();
        L8:
            if (r107.hasNext() == false) goto L13;
            fj.d r108 = (fj.d) GsonProtectorUtils.fromJson(r103, (String) r107.next(), fj.d.class);
            if (r108 == null) goto L8;
            r106.add(r108);
        L13:
            Intent r109 = r100.getIntent();
            if (r109 == null) goto L18;
            List r110 = r109.getStringArrayListExtra("image");
            if (r110 == null) goto L18;
        L19:
            Intent r111 = r100.getIntent();
            if (r111 == null) goto L24;
            List r112 = r111.getStringArrayListExtra("title");
            if (r112 == null) goto L24;
        L25:
            Intent r113 = r100.getIntent();
            if (r113 == null) goto L28;
            Integer r114 = Integer.valueOf(r113.getIntExtra("position", 0));
        L29:
            Intent r115 = r100.getIntent();
            if (r115 == null) goto L32;
            r115.getBooleanExtra("position", true);
        L32:
            Intent r116 = r100.getIntent();
            if (r116 == null) goto L35;
            r116.getBooleanExtra("position", false);
        L35:
            fj.d r117 = (fj.d) CollectionsKt.firstOrNull(r106);
            if (r117 == null) goto L42;
            l53.b r118 = (l53.b) r100.f187100l.getValue();
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, "mContext");
            ECUrlModel r119 = new ECUrlModel();
            if (r110 == null) goto L40;
            String r120 = (String) CollectionsKt.firstOrNull(r110);
        L41:
            r119.setUrlList(CollectionsKt.listOfNotNull(r120));
            Unit r121 = Unit.INSTANCE;
            ECGalleryActivity$openGalleryViewer$1$1$2 r122 = ECGalleryActivity$openGalleryViewer$1$1$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r117, "videoModel");
            Intrinsics.checkNotNullParameter(r122, "clickCB");
            goto L42
        L40:
            r120 = null;
        L42:
            HybridViewerDialog r123 = new HybridViewerDialog(r100);
            ArrayList r124 = new ArrayList();
            Iterator r125 = r106.iterator();
        L44:
            if (r125.hasNext() == false) goto L46;
            fj.d r126 = (fj.d) r125.next();
            int r127 = com.bytedance.android.ec.model.k.f47871n;
            r124.add(com.bytedance.android.ec.model.k.a.d(r126.f477434a, r126.f477440g, Integer.valueOf((int) r126.f477437d), Integer.valueOf((int) r126.f477438e), null));
            r123 = r123;
            goto L44
        L46:
            HybridViewerDialog r128 = r123;
            Iterator r129 = r110.iterator();
        L48:
            if (r129.hasNext() == false) goto L50;
            String r130 = (String) r129.next();
            int r131 = com.bytedance.android.ec.model.k.f47871n;
            r124.add(com.bytedance.android.ec.model.k.a.c(r130, null));
            goto L48
        L50:
            Unit r132 = Unit.INSTANCE;
            r128.a(r124, false);
            r128.f187106g.f187102f = null;
            Intrinsics.checkNotNullParameter(r112, "titles");
            List<String> r133 = CollectionsKt.mutableListOf(new String[]{""});
            Iterator r134 = r112.iterator();
        L52:
            if (r134.hasNext() == false) goto L54;
            r133.add((String) r134.next());
            goto L52
        L54:
            r133.add("");
            r128.f187105f = r133;
            r128.setOnDismissListener(new f(r100, r106, r110, r112));
            r128.setOnPageSelectedListener(new g(r100, r106, r110, r112));
            r128.setOnCancelListener(new h(r100, r106, r110, r112));
            if (r114 == null) goto L57;
            int r135 = r114.intValue();
        L58:
            r128.showAnimated(r135, r128.getRootContainer());
            return;
        L57:
            r135 = 0;
            goto L58
        L28:
            r114 = null;
        L24:
            r112 = CollectionsKt.emptyList();
        L18:
            r110 = CollectionsKt.emptyList();
        L12:
            r106 = CollectionsKt.emptyList();
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ECGalleryActivity.class.getName()));
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECGalleryActivity.class.getName()));
    L5:
        int r100 = r.f187157a;
        super.onDestroy();
    }

    public ECGalleryActivity() {
        this.f187100l = LazyKt.lazy(ECGalleryActivity$collisionNegotiator$2.INSTANCE);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.ec_commerce_layout_gallery);
        Window r101 = getWindow();
        if (r101 == null) goto L13;
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.clearFlags(2);
    L13:
        View r102 = findViewById(com.larus.nova.R.id.root_container);
        this.f187098j = r102;
        if (r102 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L16:
        r102.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.black));
        View r103 = this.f187098j;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L19:
        r103.getBackground().setAlpha(0);
        View r104 = this.f187098j;
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L22:
        r104.post(new b(this));
    }
}

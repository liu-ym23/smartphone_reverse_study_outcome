package com.bytedance.android.window.shop.innerflow;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import v19.f;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowActivity;", "Lcom/bytedance/android/ec/window/base/common/activity/ECWindowBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowActivity extends ECWindowBaseActivity implements QViewModelOwner {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f189026o = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImmersionBar f189027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f189028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.commerce.base.viewmodel.a f189029n;

    public static final class a {
    }

    public ECWindowInnerFlowActivity() {
        super(0);
        this.f189028m = LazyKt.lazy(ECWindowInnerFlowActivity$uiManager$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r100 = new ECWindowInnerFlowActivity$viewModel$2(this);
        this.f189029n = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(ECWindowInnerFlowViewModel.class), new ECWindowInnerFlowActivity$$special$$inlined$viewModels$1(this), r100);
    }

    static {
        Lazy r100 = BtmSDKWrapper.f41960a;
        BtmSDKWrapper.c(ECWindowInnerFlowActivity.class, "a1.b76473");
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity, com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ECWindowInnerFlowActivity.class.getName()));
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

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    @Override // com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity, com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECWindowInnerFlowActivity.class.getName()));
    L5:
        ((QUIManager) this.f189028m.getValue()).r(dq3.b.class);
        ((ECWindowInnerFlowViewModel) this.f189029n.getValue()).release(this);
        ImmersionBar r100 = this.f189027l;
        if (r100 == null) goto L8;
        r100.destroy();
    L8:
        super.onDestroy();
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public final void y1() {
        super.y1();
        if (this.f189027l != null) goto L5;
        this.f189027l = ImmersionBar.with(this);
    L5:
        ImmersionBar r100 = this.f189027l;
        if (r100 == null) goto L11;
        ImmersionBar r101 = r100.statusBarDarkFont(true);
        if (r101 == null) goto L12;
        r101.init();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        if (r100 == null) goto L14;
        Serializable r101 = r100.getSerializable("ec_shop_inner_flow_key_schema_params");
        if (r101 == null) goto L14;
    L19:
        if ((r101 instanceof Map) == true) goto L21;
        r101 = null;
    L21:
        Map r102 = (Map) r101;
        if (r102 == null) goto L33;
        ECWindowInnerFlowViewModel r103 = (ECWindowInnerFlowViewModel) this.f189029n.getValue();
        String r104 = (String) r102.get("sec_uid");
        if (r104 != null) goto L26;
        r104 = "";
    L26:
        String r105 = (String) r102.get("inner_flow_type");
        if (r105 == null) goto L31;
        Integer r106 = StringsKt.toIntOrNull(r105);
        if (r106 == null) goto L31;
        int r107 = r106.intValue();
    L32:
        r103.setInnerFlowParam(new b(r102, r104, r107));
    L34:
        Lazy r108 = BtmSDKWrapper.f41960a;
        if (r102 == null) goto L37;
        String r109 = (String) r102.get(PhotoEnterModel.SOURCE_BTM_TOKEN);
    L38:
        BtmSDKWrapper.a(this, "a1.b76473", r109);
        ((QUIManager) this.f189028m.getValue()).l(new dq3.b(com.bytedance.android.ec.opt.asyncInflate.c.a(z1(), com.larus.nova.R.layout.ec_activity_shop_inner_flow, null, 6)), this, false);
        ((QUIManager) this.f189028m.getValue()).c(dq3.b.class, null);
        setContentView(((QUIManager) this.f189028m.getValue()).p());
        if (((ECWindowInnerFlowViewModel) this.f189029n.getValue()).getInnerFlowParam().f189041c != 1) goto L41;
        getWindow().addFlags(128);
    L41:
        d r110 = z1().a();
        Iterator<T> r111 = ((ECWindowInnerFlowViewModel) this.f189029n.getValue()).getViewCacheTriples().iterator();
    L43:
        if (r111.hasNext() == false) goto L45;
        Triple r112 = (Triple) r111.next();
        r110.c(((Number) r112.component1()).intValue(), ((Number) r112.component2()).intValue(), (String) r112.component3());
        goto L43
    L45:
        r110.commit();
        return;
    L37:
        r109 = null;
    L31:
        r107 = 1;
        goto L32
    L33:
        r102 = null;
    L14:
        Intent r113 = getIntent();
        if (r113 == null) goto L17;
        r101 = r113.getSerializableExtra("ec_shop_inner_flow_key_schema_params");
        goto L19
    L17:
        r101 = null;
        goto L19
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        Serializable r101 = r100.getSerializable("ec_shop_inner_flow_key_schema_params");
        Serializable r102 = null;
        if ((r101 instanceof Map) == true) goto L6;
        r101 = null;
    L6:
        if (((Map) r101) == null) goto L8;
        return;
    L8:
        Intent r103 = getIntent();
        if (r103 == null) goto L11;
        Serializable r104 = r103.getSerializableExtra("ec_shop_inner_flow_key_schema_params");
    L13:
        if ((r104 instanceof Map) == false) goto L16;
        r102 = r104;
    L16:
        Map r105 = (Map) r102;
        if (r105 == null) goto L20;
        r100.putSerializable("ec_shop_inner_flow_key_schema_params", (Serializable) r105);
        return;
    L20:
        return;
    L11:
        r104 = null;
        goto L13
    }
}

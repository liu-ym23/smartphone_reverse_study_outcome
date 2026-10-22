package com.bytedanceos.appstore.buss.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.m0;
import androidx.lifecycle.s;
import com.bytedanceos.appstore.buss.AppStoreActivity;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.appstore.buss.utilities.p;
import com.bytedanceos.appstore.buss.viewmodels.AppSplashViewModel;
import com.bytedanceos.common.ad.common.AdJumpUtil;
import com.bytedanceos.common.ad.common.AdReportUtil;
import com.bytedanceos.common.ad.entity.rep.RepAdEntity;
import com.bytedanceos.common.ad.entity.rep.RepCreativeEntity;
import com.bytedanceos.common.ad.entity.rep.media.RepSplashMediaEntity;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.ui.SplashActivity;
import com.github.chrisbanes.photoview.PhotoView;
import com.obric.appstore.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/bytedanceos/appstore/buss/activity/AppSplashActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "<init>", "()V", "", "J", "Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;", "Lcom/bytedanceos/common/ad/entity/rep/media/RepSplashMediaEntity;", "adEntity", "Y", "(Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;)V", "initView", "initData", "I", "onResume", "onPause", "onDestroy", "Lp7/b;", "event", "onTimerFinishEvent", "(Lp7/b;)V", "", "time", "startTimer", "(I)V", "initSplash", "", "delay", "R", "(J)V", "Lcom/bytedanceos/appstore/buss/viewmodels/AppSplashViewModel;", "c", "Lkotlin/Lazy;", "U", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppSplashViewModel;", "adViewModel", "d", "Lcom/bytedanceos/common/ad/entity/rep/RepAdEntity;", "Lcom/bytedanceos/appstore/buss/utilities/p;", "e", "Lcom/bytedanceos/appstore/buss/utilities/p;", "timer", "", "f", "Z", "mIsTimerInit", "H", "()I", "layoutId", "Lx7/c;", "T", "()Lx7/c;", "activityTvSplashBinding", "g", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppSplashActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSplashActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppSplashActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,220:1\n75#2,13:221\n*S KotlinDebug\n*F\n+ 1 AppSplashActivity.kt\ncom/bytedanceos/appstore/buss/activity/AppSplashActivity\n*L\n50#1:221,13\n*E\n"})
public final class AppSplashActivity extends BaseActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8315g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8316h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f8317i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RepAdEntity f8319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f8320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8321f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a() {
            return AppSplashActivity.P();
        }

        public a() {
        }
    }

    static {
        f8315g = new a(null);
        f8316h = SplashActivity.EXTRA_INTRUSION;
        f8317i = 1000;
    }

    public AppSplashActivity() {
        Function0<ViewModelProvider.Factory> r10 = new AppSplashActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r11 = null;
        this.f8318c = new m0(u.b(AppSplashViewModel.class), new AppSplashActivity$special$$inlined$viewModels$default$2(this), r10, new AppSplashActivity$special$$inlined$viewModels$default$3(r11, this));
    }

    public static /* synthetic */ void K(AppSplashActivity r10, com.bytedanceos.appstore.buss.network.ad.d r11) {
        X(r10, r11);
    }

    public static /* synthetic */ void L(AppSplashActivity r10, View r11) {
        V(r10, r11);
    }

    public static /* synthetic */ void M(AppSplashActivity r10) {
        S(r10);
    }

    public static /* synthetic */ void N(AppSplashActivity r10, View r11) {
        W(r10, r11);
    }

    public static final /* synthetic */ void O(AppSplashActivity r10, long r11) {
        r10.R(r11);
    }

    public static final /* synthetic */ String P() {
        return f8316h;
    }

    public static final /* synthetic */ void Q(AppSplashActivity r10) {
        r10.initSplash();
    }

    public static final void S(AppSplashActivity r10) {
        q.g(r10, "this$0");
        r10.startActivity(new Intent(r10, AppStoreActivity.class));
        r10.finish();
        r10.overridePendingTransition(0, R.anim.splash_fade_out);
    }

    public static final void V(AppSplashActivity r10, View r11) {
        q.g(r10, "this$0");
        RepAdEntity r12 = r10.f8319d;
        if (r12 == null) goto L9;
        q.d(r12);
        if (r12.isCreativeAvailable() == false) goto L9;
        RepAdEntity r13 = r10.f8319d;
        q.d(r13);
        RepCreativeEntity r14 = (RepCreativeEntity) r13.getCreative().get(0);
        if (r14 == null) goto L9;
        AdReportParam.Event r15 = AdReportParam.Event.SPLASH_CLICK;
        r15.setClickPosType(AdReportParam.ClickPosType.SKIP);
        AdReportUtil.reportSplash(r15, (RepSplashMediaEntity) r14.getMedia());
    L9:
        r10.R(0);
    }

    public static final void W(AppSplashActivity r10, View r11) {
        q.g(r10, "this$0");
        RepAdEntity r12 = r10.f8319d;
        if (r12 != null) goto L5;
        return;
    L5:
        q.d(r12);
        if (r12.isCreativeAvailable() == false) goto L9;
        RepAdEntity r13 = r10.f8319d;
        q.d(r13);
        Object r14 = r13.getCreative().get(0);
        q.f(r14, "get(...)");
        RepCreativeEntity r15 = (RepCreativeEntity) r14;
        AdJumpUtil.jump(r10, r15);
        AdReportParam.Event r16 = AdReportParam.Event.SPLASH_CLICK;
        r16.setClickPosType("1");
        AdReportUtil.reportSplash(r16, (RepSplashMediaEntity) r15.getMedia());
        return;
    }

    public static final void X(AppSplashActivity r10, com.bytedanceos.appstore.buss.network.ad.d r11) {
        q.g(r10, "this$0");
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.ad.d.b) == false) goto L5;
        return;
    L5:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.ad.d.c) == false) goto L15;
        com.bytedanceos.appstore.buss.network.ad.d.c r12 = (com.bytedanceos.appstore.buss.network.ad.d.c) r11;
        if (r12.a() != null) goto L9;
    L12:
        r10.R(f8317i);
        return;
    L9:
        if (r12.a().isEmpty() == true) goto L12;
        r10.Y((RepAdEntity) r12.a().get(0));
        return;
    L15:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.ad.d.a) == false) goto L20;
        r10.R(f8317i);
        return;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_splash;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
        h.d(s.a(this), null, null, new AppSplashActivity$onEvent$1(this, null), 3, null);
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
        U().h().i(this, new d(this));
    }

    public final void R(long r10) {
        new Handler(getMainLooper()).postDelayed(new e(this), r10);
    }

    public final x7.c T() {
        x7.c r10 = x7.c.a(G());
        q.f(r10, "bind(...)");
        return r10;
    }

    public final AppSplashViewModel U() {
        return (AppSplashViewModel) this.f8318c.getValue();
    }

    public final void Y(RepAdEntity r10) {
        q.g(r10, "adEntity");
        if (r10.isCreativeAvailable() == false) goto L11;
        this.f8319d = r10;
        RepCreativeEntity r11 = (RepCreativeEntity) r10.getCreative().get(0);
        if (r11 == null) goto L11;
        RepSplashMediaEntity r12 = (RepSplashMediaEntity) r11.getMedia();
        if (r12 == null) goto L9;
        String r13 = r12.getCreative_url();
    L10:
        T().f25505b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        PhotoView r14 = T().f25505b;
        q.f(r14, "ivBg");
        ImageUtilKt.d(r14, r13);
        AdReportUtil.reportSplash(AdReportParam.Event.SPLASH_EXPOSURE, (RepSplashMediaEntity) r11.getMedia());
        goto L11
    L9:
        r13 = null;
    L11:
        startTimer(r10.getSet().getSettings().getDisplay_time());
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
        T().f25508e.setOnClickListener(new f(this));
        T().f25505b.setOnClickListener(new g(this));
        EventBus.getDefault().register(this);
    }

    public final void initSplash() {
        getWindow().setFlags(1024, 1024);
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        p r10 = this.f8320e;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        p r10 = this.f8320e;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        p r10 = this.f8320e;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTimerFinishEvent(@NotNull p7.b r10) {
        q.g(r10, "event");
        R(0);
    }

    public final void startTimer(int r10) {
        T().f25508e.setVisibility(0);
        if (r10 > 0) goto L7;
        r10 = 3;
    L7:
        if (this.f8320e != null) goto L9;
        TextView r11 = T().f25508e;
        q.f(r11, "tvSkip");
        this.f8320e = new p(r11, r10);
    L9:
        p r12 = this.f8320e;
        q.d(r12);
        r12.c();
        this.f8321f = true;
    }
}

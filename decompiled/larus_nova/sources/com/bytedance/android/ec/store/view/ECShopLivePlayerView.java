package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0003J\b\u0010\u0007\u001a\u00020\u0003H\u0003J\b\u0010\b\u001a\u00020\u0003H\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopLivePlayerView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPageResume", "onPagePause", "onPageStop", "onPageStart", "onPageDestroy", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopLivePlayerView extends FrameLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f48772j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f48773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public le.b f48774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f48775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f48776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f48778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f48779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f48780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LifecycleOwner f48781i;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48782a;

        public a(ECShopLivePlayerView r100) {
            this.f48782a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            ECShopLivePlayerView r101 = this.f48782a;
            int r102 = ECShopLivePlayerView.f48772j;
            r101.b("onAttach");
            Lazy r103 = UIUtils.f45548a;
            UIUtils.c().post(this.f48782a.f48780h);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            ECShopLivePlayerView r101 = this.f48782a;
            int r102 = ECShopLivePlayerView.f48772j;
            r101.b("onDetach");
            Lazy r103 = UIUtils.f45548a;
            UIUtils.c().removeCallbacks(this.f48782a.f48780h);
            this.f48782a.f();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48783a;

        public c(ECShopLivePlayerView r100) {
            this.f48783a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L9;
            ECShopLivePlayerView r102 = this.f48783a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.f48773a.setVisibility(8);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48784a;

        public d(ECShopLivePlayerView r100) {
            this.f48784a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L9;
            ECShopLivePlayerView r102 = this.f48784a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.d();
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48785a;

        public e(ECShopLivePlayerView r100) {
            this.f48785a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L9;
            ECShopLivePlayerView r102 = this.f48785a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.d();
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48786a;

        public f(ECShopLivePlayerView r100) {
            this.f48786a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L9;
            ECShopLivePlayerView r102 = this.f48786a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.d();
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48787a;

        public g(ECShopLivePlayerView r100) {
            this.f48787a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L9;
            ECShopLivePlayerView r102 = this.f48787a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.d();
            return;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48788a;

        public h(ECShopLivePlayerView r100) {
            this.f48788a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            ECShopLivePlayerView r102 = this.f48788a;
            int r103 = ECShopLivePlayerView.f48772j;
            r102.d();
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLivePlayerView f48789a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f48789a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(ECShopLivePlayerView r100) {
            this.f48789a = r100;
        }
    }

    static {
    }

    private static /* synthetic */ void getStartPlayAction$annotations() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onPageDestroy() {
        b("onPageDestroy");
        le.b r100 = this.f48774b;
        if (r100 == null) goto L7;
        IECLivePlayerClient r101 = r100.a();
        if (r101 == null) goto L7;
        r101.release();
    L7:
        this.f48774b = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPagePause() {
        b("onPagePause");
        le.b r100 = this.f48774b;
        if (r100 == null) goto L8;
        IECLivePlayerClient r101 = r100.a();
        if (r101 == null) goto L9;
        r101.stop();
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onPageResume() {
        b("onPageResume");
        le.b r100 = this.f48774b;
        if (r100 == null) goto L8;
        IECLivePlayerClient r101 = r100.a();
        if (r101 == null) goto L9;
        r101.resume();
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onPageStart() {
        b("onPageStart");
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        e();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onPageStop() {
        b("onPageStop");
        f();
    }

    public final void c() {
        le.b r100 = this.f48774b;
        if (r100 == null) goto L8;
        IECLivePlayerClient r101 = r100.a();
        if (r101 == null) goto L9;
        td.e r102 = r101.getEventHub();
        r102.getFirstFrame().observe(r101.getLifecycleOwner(), new c(this));
        r102.getStopped().observe(r101.getLifecycleOwner(), new d(this));
        r102.getReleased().observe(r101.getLifecycleOwner(), new e(this));
        r102.getPlayComplete().observe(r101.getLifecycleOwner(), new f(this));
        r102.getLiveEnd().observe(r101.getLifecycleOwner(), new g(this));
        r102.getPlayerMediaError().observe(r101.getLifecycleOwner(), new h(this));
        return;
    L9:
        return;
    }

    public final void d() {
        this.f48773a.setVisibility(0);
    }

    public final void e() {
        b("startPlay");
        le.b r100 = this.f48774b;
        if (r100 != null) goto L5;
        a();
        return;
    L5:
        if (r100 == null) goto L7;
        IECLivePlayerClient r101 = r100.a();
    L8:
        g(r101);
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void f() {
        b("stopPlay");
        le.b r100 = this.f48774b;
        if (r100 == null) goto L8;
        IECLivePlayerClient r101 = r100.a();
        if (r101 == null) goto L9;
        r101.stop();
        return;
    L9:
        return;
    }

    public final void a() {
        if (y0.a() == true) goto L5;
        return;
    L5:
        d();
        String r100 = this.f48775c;
        le.b r101 = null;
        if (r100 == null) goto L19;
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L12;
        IECPlayerViewService r104 = r103.getPlayerViewService();
        if (r104 == null) goto L12;
        le.b r105 = IECPlayerViewService.a.a(r104, getContext(), null, 0, r100, "ec_feed_shop", false, false, 384);
    L13:
        if (r105 == null) goto L19;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r106 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r105;
        r106.setScaleType(2);
        r106.f42759b.setVisibility(0);
        if (r106.a().isPlaying() == false) goto L18;
        r106.a().resumePlay();
    L20:
        if (r105 == null) goto L25;
        this.f48774b = r105;
        if (getChildCount() <= 1) goto L24;
        removeViewAt(getChildCount() - 1);
    L24:
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -1);
        r107.gravity = 17;
        addView(((com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r105).f42759b, r107);
        r101 = r105;
    L25:
        if (r101 != null) goto L28;
        return;
    L28:
        if (((com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r101).a().isPlaying() == false) goto L31;
        c();
        this.f48773a.setVisibility(8);
        return;
    L31:
        return;
    L18:
        g(r106.a());
    L12:
        r105 = null;
    L19:
        r105 = null;
        goto L20
    }

    public final void b(String r100) {
        dm.a.a("ECShopLivePlayerView").i(r100);
    }

    public final void g(IECLivePlayerClient r100) {
        String r101 = ECSettingKeys.C().get("ec_feed_shop");
        if (r101 != null) goto L5;
        r101 = ECSettingKeys.B().get("ec_feed_shop");
    L5:
        le.a.C6680a r102 = new le.a.C6680a();
        String r103 = this.f48776d;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f508895a = r103;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "resolution");
        r102.f508896b = r101;
    L11:
        ECLiveMode r104 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r104, "streamType");
        r102.f508897c = r104;
        Boolean r105 = this.f48779g;
        if (r105 == null) goto L14;
        boolean r106 = r105.booleanValue();
    L15:
        r102.f508902h = r106;
        r102.f508900f = true;
        le.a r107 = r102.a();
        if (r100 == null) goto L19;
        r100.stream(r107, new ECShopLivePlayerView$stream$1(this));
        return;
    L19:
        return;
    L14:
        r106 = true;
        goto L15
    }

    public ECShopLivePlayerView(Context r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f48781i = r101;
        ECDraweeView r102 = new ECDraweeView(r100, null, 0, 6, null);
        GenericDraweeHierarchy r103 = r102.getHierarchy();
        if (r103 == null) goto L5;
        r103.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L5:
        addView(r102, new ViewGroup.LayoutParams(-1, -1));
        Unit r104 = Unit.INSTANCE;
        this.f48773a = r102;
        this.f48780h = new i(this);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
        if (r101 == null) goto L12;
        Lifecycle r105 = r101.getLifecycle();
        if (r105 == null) goto L12;
        r105.addObserver(this);
    L12:
        addOnAttachStateChangeListener(new a(this));
        return;
    L11:
        post(new com.bytedance.android.ec.store.view.e(this));
        goto L12
    }
}

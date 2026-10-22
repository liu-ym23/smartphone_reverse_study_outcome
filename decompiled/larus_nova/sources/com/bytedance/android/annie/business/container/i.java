package com.bytedance.android.annie.business.container;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.FragmentCustomMonitorKey;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.p;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.TTPayAnnieContainerImpl;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements ia.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f38970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ia.c f38971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnnieXLiveContext f38972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w8.d f38973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f38974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f38975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.annie.bridge.method.permission.b f38976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<HybridFragment.a> f38977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f38978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f38979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f38980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f38981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f38982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AnnieXLiveHybridComponent f38983n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.annie.business.ability.schema.model.b f38984o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f38985p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f38986q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final n f38987r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f38988s;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38989a = null;

        static {
            int[] r100 = new int[FragmentCustomMonitorKey.values().length];
            r100[FragmentCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[FragmentCustomMonitorKey.IsContainerPreload.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[FragmentCustomMonitorKey.IsUserOpen.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[FragmentCustomMonitorKey.IsPrerender.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[FragmentCustomMonitorKey.HasReload.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f38989a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38990a;

        public c(i r100) {
            this.f38990a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            w8.d r102 = this.f38990a.f38973d;
            if (r102 == null) goto L6;
            r102.a(true);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38991a;

        public d(i r100) {
            this.f38991a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            HybridLogger r101 = HybridLogger.f246343a;
            k7.a.a("AnnieXLivePopAndPageComm", ((Throwable) r100).toString(), this.f38991a.f38972c);
        }
    }

    public static final class e<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38992a;

        public e(i r100) {
            this.f38992a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            y6.e r101 = (y6.e) this.f38992a.f38982m.getValue();
            String r102 = com.bytedance.android.annie.container.fragment.n.e((String) r100);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f566288a = r102;
        }
    }

    public static final class f<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38993a;

        public f(i r100) {
            this.f38993a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            y6.e r101 = (y6.e) this.f38993a.f38982m.getValue();
            String r102 = com.bytedance.android.annie.container.fragment.n.e((String) r100);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f566290c = r102;
        }
    }

    public static final class g<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f38994a;

        public g(i r100) {
            this.f38994a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            y6.e r101 = (y6.e) this.f38994a.f38982m.getValue();
            String r102 = com.bytedance.android.annie.container.fragment.n.e((String) r100);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f566291d = r102;
        }
    }

    static {
    }

    public final void c() {
        this.f38973d = ((w8.c) e(w8.c.class)).k1(this.f38971b, this.f38970a);
        this.f38974e = Observable.timer(1500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
    }

    public final void g() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onDetach: " + this.f38978i, this.f38972c);
        Disposable r101 = this.f38974e;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        w8.d r102 = this.f38973d;
        if (r102 == null) goto L9;
        r102.a(false);
        return;
    }

    @Override // ia.e
    public final void onDestroy() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onDestroy: " + this.f38978i, this.f38972c);
        s26.d r101 = s26.d.f540305c;
        com.bytedance.android.anniex.base.service.c r102 = (com.bytedance.android.anniex.base.service.c) s26.d.f540305c.d(TTPayAnnieContainerImpl.CAIJING_BID, com.bytedance.android.anniex.base.service.c.class);
        if (r102 == null) goto L5;
        r102.J0(null, this.f38971b);
    L5:
        ia.c r103 = this.f38971b;
        if ((r103 instanceof ia.e) == false) goto L8;
        ia.e r104 = (ia.e) r103;
    L9:
        if (r104 == null) goto L11;
        r104.onDestroy();
    L11:
        FragmentActivity r105 = this.f38970a;
        if (r105 == null) goto L14;
        AnnieFragmentManager.f(this.f38971b.getContainerId(), r105, 4);
    L14:
        this.f38970a = null;
        this.f38972c = null;
        this.f38974e = null;
        this.f38973d = null;
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // ia.e
    public final void onPause() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onPause: " + this.f38978i, this.f38972c);
        ia.c r101 = this.f38971b;
        if ((r101 instanceof ia.e) == false) goto L5;
        ia.e r102 = (ia.e) r101;
    L6:
        if (r102 == null) goto L8;
        r102.onPause();
    L8:
        this.f38971b.sendEvent(new m(false));
        w8.d r103 = this.f38973d;
        if (r103 == null) goto L11;
        r103.a(false);
    L11:
        FragmentActivity r104 = this.f38970a;
        if (r104 == null) goto L16;
        boolean r105 = true;
        if (r104.isFinishing() != true) goto L16;
    L17:
        if (r105 == false) goto L20;
        AnnieFragmentManager.e(this.f38971b.getContainerId(), this.f38970a, false);
        return;
    L20:
        return;
    L16:
        r105 = false;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.e
    public final void onResume() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onResume: " + this.f38978i, this.f38972c);
        ia.c r101 = this.f38971b;
        if ((r101 instanceof ia.e) == false) goto L5;
        ia.e r102 = (ia.e) r101;
    L6:
        if (r102 == null) goto L8;
        r102.onResume();
    L8:
        this.f38971b.sendEvent(new m(true));
        w8.d r103 = this.f38973d;
        if (r103 == null) goto L11;
        r103.a(true);
    L11:
        s26.d r104 = s26.d.f540305c;
        com.bytedance.android.anniex.base.service.c r105 = (com.bytedance.android.anniex.base.service.c) s26.d.f540305c.d(TTPayAnnieContainerImpl.CAIJING_BID, com.bytedance.android.anniex.base.service.c.class);
        if (r105 == null) goto L15;
        r105.K0(null, this.f38971b);
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStart() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onStart: " + this.f38978i, this.f38972c);
        ia.c r101 = this.f38971b;
        if ((r101 instanceof ia.e) == false) goto L5;
        ia.e r102 = (ia.e) r101;
    L6:
        if (r102 == null) goto L9;
        r102.onStart();
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.e
    public final void onStop() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onStop: " + this.f38978i, this.f38972c);
        ia.c r101 = this.f38971b;
        if ((r101 instanceof ia.e) == false) goto L5;
        ia.e r102 = (ia.e) r101;
    L6:
        if (r102 == null) goto L9;
        r102.onStop();
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void p() {
        HybridLogger r100 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "release: " + this.f38978i, this.f38972c);
        ((ArrayList) this.f38977h).clear();
        AnnieXLiveHybridComponent r101 = this.f38983n;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        this.f38983n = null;
    }

    @Override // ia.e
    public final void a(View r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onCreateView: " + this.f38978i, this.f38972c);
        ia.e r102 = null;
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r100;
    L6:
        this.f38985p = r103;
        ia.c r104 = this.f38971b;
        if ((r104 instanceof ia.e) == false) goto L9;
        r102 = (ia.e) r104;
    L9:
        if (r102 == null) goto L12;
        r102.a(r100);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final <T extends com.bytedance.android.annie.service.a> T e(Class<? extends T> r100) {
        AnnieXLiveContext r101 = this.f38972c;
        if (r101 == null) goto L6;
        String r102 = r101.getBizKey();
        if (r102 == null) goto L6;
    L8:
        return (T) Annie.getService(r100, r102);
    L6:
        r102 = "host";
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(WebView r100) {
        com.bytedance.android.annie.business.ability.schema.model.b r101 = this.f38984o;
        boolean r102 = false;
        if (r101 == null) goto L13;
        y36.a r103 = r101.f38878f;
        if (r103 == null) goto L9;
        Boolean r104 = (Boolean) r103.f565862b;
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L11:
        if (r105 != true) goto L13;
        r102 = true;
    L9:
        r105 = false;
    L13:
        if (r102 == false) goto L19;
        y6.e r106 = (y6.e) this.f38982m.getValue();
        String r107 = r100.getUrl();
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f566289b = r107;
        r100.evaluateJavascript("document.title", new e(this));
        r100.evaluateJavascript("document.getElementsByName('description')[0].content", new f(this));
        r100.evaluateJavascript("document.getElementsByTagName('link')[0].href", new g(this));
        return;
    }

    @Override // ia.e
    public final void onActivityCreated(Bundle r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        Map r102 = MapsKt.mapOf(TuplesKt.to("url", this.f38978i));
        AnnieXLiveContext r103 = this.f38972c;
        if (r103 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r104 = r103.getLogContext();
    L6:
        HybridLogger.k("AnnieXLivePopAndPageComm", "on_activity_created", r102, r104);
        ia.c r105 = this.f38971b;
        if ((r105 instanceof ia.e) == false) goto L9;
        ia.e r106 = (ia.e) r105;
    L10:
        if (r106 == null) goto L12;
        r106.onActivityCreated(r100);
    L12:
        s26.d r107 = s26.d.f540305c;
        com.bytedance.android.anniex.base.service.c r108 = (com.bytedance.android.anniex.base.service.c) s26.d.f540305c.d(TTPayAnnieContainerImpl.CAIJING_BID, com.bytedance.android.anniex.base.service.c.class);
        if (r108 == null) goto L16;
        r108.I0(null, this.f38971b, r100);
        return;
    L16:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // ia.e
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        HybridLogger r101 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onConfigurationChanged: " + this.f38978i, this.f38972c);
        ia.c r102 = this.f38971b;
        if ((r102 instanceof ia.e) == false) goto L5;
        ia.e r103 = (ia.e) r102;
    L6:
        if (r103 == null) goto L9;
        r103.onConfigurationChanged(r100);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void q(IHybridComponent.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXLivePopAndPageComm", "===setJSBridgeListener " + this.f38978i + " ===", null, null, 12);
        AnnieXLiveHybridComponent r102 = this.f38983n;
        if (r102 == null) goto L6;
        r102.setJSBridgeListener(r100);
        return;
    }

    @Override // ia.e
    public final void setUserVisibleHint(boolean r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "setUserVisibleHint: " + this.f38978i, this.f38972c);
        ia.c r102 = this.f38971b;
        if ((r102 instanceof ia.e) == false) goto L5;
        ia.e r103 = (ia.e) r102;
    L6:
        if (r103 == null) goto L9;
        r103.setUserVisibleHint(r100);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // ia.e
    public final void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        HybridLogger r102 = HybridLogger.f246343a;
        Map r103 = MapsKt.mapOf(TuplesKt.to("url", this.f38978i));
        AnnieXLiveContext r104 = this.f38972c;
        com.bytedance.ies.bullet.base.utils.logger.a r105 = null;
        if (r104 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r106 = r104.getLogContext();
    L6:
        HybridLogger.k("AnnieXLivePopAndPageComm", "on_view_created", r103, r106);
        ViewGroup r107 = this.f38985p;
        if (r107 == null) goto L14;
        ia.c r108 = this.f38971b;
        if ((r108 instanceof ia.e) == false) goto L11;
        ia.e r109 = (ia.e) r108;
    L12:
        if (r109 == null) goto L14;
        r109.b(r107, r101);
        Unit r110 = Unit.INSTANCE;
    L15:
        if (r110 != null) goto L21;
        Map r111 = MapsKt.mapOf(TuplesKt.to("message", "onViewCreated: rootView is null"));
        AnnieXLiveContext r112 = this.f38972c;
        if (r112 == null) goto L19;
        r105 = r112.getLogContext();
    L19:
        HybridLogger.g("AnnieXLivePopAndPageComm", "rootView_is_null", r111, r105);
        return;
    L21:
        return;
    L11:
        r109 = null;
    L14:
        r110 = null;
        goto L15
    L5:
        r106 = null;
        goto L6
    }

    public final void n(JSBridgeManager r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Iterator<T> r102 = ((w8.c) e(w8.c.class)).provideStateFulFragmentMethods(r101).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        List<HybridFragment.a> r104 = this.f38977h;
        ArrayList r105 = (ArrayList) r104;
        r105.add(r103.getValue());
        r100.registerMethod((String) r103.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r103.getValue());
        goto L4
    L6:
        FragmentActivity r106 = this.f38970a;
        if (r106 == null) goto L46;
        Iterator r107 = ((CopyOnWriteArraySet) a9.j.f2218c).iterator();
    L10:
        if (r107.hasNext() == false) goto L33;
        y6.a r108 = (y6.a) r107.next();
        Map<String, Map<Class<?>, Object>> r109 = x26.a.f562251a;
        w26.g r110 = (w26.g) x26.a.a(w26.g.class);
        if (r110 == null) goto L18;
        w26.e r111 = (w26.e) r110.n0(w26.e.class);
        if (r111 == null) goto L18;
        Boolean r112 = r111.S0();
        if (r112 == null) goto L18;
        boolean r113 = r112.booleanValue();
    L19:
        if (r113 == true) goto L20;
        if ((r101 instanceof HybridFragment) == false) goto L27;
        HybridFragment r114 = (HybridFragment) r101;
    L28:
        if (r114 == null) goto L10;
        Iterator r115 = r108.g(r106, r114).entrySet().iterator();
    L31:
        if (r115.hasNext() == false) goto L10;
        Map.Entry r116 = (Map.Entry) r115.next();
        List<HybridFragment.a> r117 = this.f38977h;
        ArrayList r118 = (ArrayList) r117;
        r118.add(r116.getValue());
        r100.registerMethod((String) r116.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r116.getValue());
        goto L31
    L27:
        r114 = null;
        goto L28
    L20:
        Iterator r119 = r108.f(r106, r101).entrySet().iterator();
    L22:
        if (r119.hasNext() == false) goto L10;
        Map.Entry r120 = (Map.Entry) r119.next();
        List<HybridFragment.a> r121 = this.f38977h;
        ArrayList r122 = (ArrayList) r121;
        r122.add(r120.getValue());
        r100.registerMethod((String) r120.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r120.getValue());
    L18:
        r113 = true;
        goto L19
    L33:
        p r123 = ((w8.c) e(w8.c.class)).X(r106, r101);
        this.f38975f = r123;
        if (r123 == null) goto L47;
        r100.registerMethod("calendar", r123.provide());
        return;
    L47:
        return;
    }

    public i(FragmentActivity r100, ia.c r101, AnnieXLiveContext r102) {
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f38970a = r100;
        this.f38971b = r101;
        this.f38972c = r102;
        this.f38977h = new ArrayList();
        this.f38978i = "unknown";
        this.f38980k = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a();
        this.f38981l = true;
        this.f38982m = LazyKt.lazy(AnnieXLivePopAndPageComm$shareInfo$2.INSTANCE);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        AnnieXLiveContext r104 = this.f38972c;     // Catch: Throwable -> L16
        Uri r105 = null;
        if (r104 == null) goto L8;
        Uri r106 = r104.getUri();     // Catch: Throwable -> L16
        if (r106 == null) goto L8;
        String r107 = UriProtector.getQueryParameter(r106, "url");     // Catch: Throwable -> L16
    L9:
        if (r107 != null) goto L14;
        AnnieXLiveContext r108 = this.f38972c;     // Catch: Throwable -> L16
        if (r108 == null) goto L13;
        r105 = r108.getUri();     // Catch: Throwable -> L16
    L13:
        r107 = String.valueOf(r105);     // Catch: Throwable -> L16
    L14:
        this.f38978i = r107;     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        HybridLogger r109 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "init: " + this.f38978i, this.f38972c);
        new l();
        this.f38986q = new j(this);
        this.f38987r = new n(this);
        return;
    L8:
        r107 = null;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final void k(int r100, String[] r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        p r104 = this.f38975f;     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r104.onRequestPermissionsResult(r100, r101, r102);     // Catch: Throwable -> L12
    L6:
        com.bytedance.android.annie.bridge.method.permission.b r105 = this.f38976g;     // Catch: Throwable -> L12
        if (r105 == null) goto L9;
        r105.onRequestPermissionsResult(r100, r101, r102);     // Catch: Throwable -> L12
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        HybridLogger r109 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXLivePopAndPageComm", "onRequestPermissionsResult===>" + r108.getMessage(), null, 12);
        return;
    L20:
        return;
    L9:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // ia.e
    public final void onActivityResult(int r100, int r101, Intent r102) {
        HybridLogger r103 = HybridLogger.f246343a;
        k7.a.b("AnnieXLivePopAndPageComm", "onActivityResult: " + this.f38978i, this.f38972c);
        Iterator r104 = ((ArrayList) this.f38977h).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((HybridFragment.a) r104.next()).onActivityResult(r100, r101, r102);
        goto L4
    L6:
        ia.c r105 = this.f38971b;
        if ((r105 instanceof ia.e) == false) goto L9;
        ia.e r106 = (ia.e) r105;
    L10:
        if (r106 == null) goto L14;
        r106.onActivityResult(r100, r101, r102);
        return;
    L14:
        return;
    L9:
        r106 = null;
        goto L10
    }
}

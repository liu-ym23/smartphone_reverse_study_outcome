package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.jsbridge.newmethods.AlertMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.CallPhoneMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.DialogMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.a3;
import com.bytedance.android.live.browser.jsbridge.newmethods.a8;
import com.bytedance.android.live.browser.jsbridge.newmethods.ae;
import com.bytedance.android.live.browser.jsbridge.newmethods.be;
import com.bytedance.android.live.browser.jsbridge.newmethods.ca;
import com.bytedance.android.live.browser.jsbridge.newmethods.ce;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.live.browser.jsbridge.newmethods.d3;
import com.bytedance.android.live.browser.jsbridge.newmethods.de;
import com.bytedance.android.live.browser.jsbridge.newmethods.e2;
import com.bytedance.android.live.browser.jsbridge.newmethods.e3;
import com.bytedance.android.live.browser.jsbridge.newmethods.e8;
import com.bytedance.android.live.browser.jsbridge.newmethods.ed;
import com.bytedance.android.live.browser.jsbridge.newmethods.f2;
import com.bytedance.android.live.browser.jsbridge.newmethods.h5;
import com.bytedance.android.live.browser.jsbridge.newmethods.l5;
import com.bytedance.android.live.browser.jsbridge.newmethods.m5;
import com.bytedance.android.live.browser.jsbridge.newmethods.mc;
import com.bytedance.android.live.browser.jsbridge.newmethods.n5;
import com.bytedance.android.live.browser.jsbridge.newmethods.o5;
import com.bytedance.android.live.browser.jsbridge.newmethods.p8;
import com.bytedance.android.live.browser.jsbridge.newmethods.q1;
import com.bytedance.android.live.browser.jsbridge.newmethods.r8;
import com.bytedance.android.live.browser.jsbridge.newmethods.rc;
import com.bytedance.android.live.browser.jsbridge.newmethods.t3;
import com.bytedance.android.live.browser.jsbridge.newmethods.u0;
import com.bytedance.android.live.browser.jsbridge.newmethods.u4;
import com.bytedance.android.live.browser.jsbridge.newmethods.u5;
import com.bytedance.android.live.browser.jsbridge.newmethods.ub;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.browser.jsbridge.newmethods.vb;
import com.bytedance.android.live.browser.jsbridge.newmethods.xa;
import com.bytedance.android.live.browser.jsbridge.newmethods.xc;
import com.bytedance.android.live.browser.jsbridge.newmethods.y7;
import com.bytedance.android.live.browser.jsbridge.newmethods.zc;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.ni1;
import com.bytedance.android.livesdk.config.pi1;
import com.bytedance.android.livesdk.config.w30;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.td;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeService implements com.bytedance.android.live.browser.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f62882a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f62883a = null;

        static {
            f62883a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ae();
        }
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f62884a = null;

        static {
            f62884a = new a0();
        }

        public a0() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new m5();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f62885a = null;

        static {
            f62885a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h30.f.a();
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b0 f62886a = null;

        static {
            f62886a = new b0();
        }

        public b0() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e8();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f62887a = null;

        static {
            f62887a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h30.f.b();
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f62888a = null;

        static {
            f62888a = new c0();
        }

        public c0() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new q1();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f62889a = null;

        static {
            f62889a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new td();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f62890a = null;

        static {
            f62890a = new e();
        }

        public e() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new AlertMethod();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f62891a = null;

        static {
            f62891a = new f();
        }

        public f() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new AlertMethod();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f62892a = null;

        static {
            f62892a = new g();
        }

        public g() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new xc();
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f62893a = null;

        static {
            f62893a = new h();
        }

        public h() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new DialogMethod();
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f62894a = null;

        static {
            f62894a = new i();
        }

        public i() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p8();
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f62895a = null;

        static {
            f62895a = new j();
        }

        public j() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new vb();
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 f62896a;

        public k(com.bytedance.ies.web.jsbridge2.d0 r100) {
            this.f62896a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            com.bytedance.ies.web.jsbridge2.d0 r100 = this.f62896a;
            if (r100 == null) goto L5;
            WebView r101 = r100.f249342b;
        L7:
            return new com.bytedance.android.livesdk.jsbridge.methods.z(r101);
        L5:
            r101 = null;
            goto L7
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f62897a = null;

        static {
            f62897a = new l();
        }

        public l() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new n5();
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f62898a = null;

        static {
            f62898a = new m();
        }

        public m() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new o5();
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f62899a = null;

        static {
            f62899a = new n();
        }

        public n() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new r8();
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f62900a = null;

        static {
            f62900a = new o();
        }

        public o() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f2();
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public p(com.bytedance.ies.web.jsbridge2.d0 r100) {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new t3();
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f62901a = null;

        static {
            f62901a = new q();
        }

        public q() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new d3();
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f62902a = null;

        static {
            f62902a = new r();
        }

        public r() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ca();
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f62903a = null;

        static {
            f62903a = new s();
        }

        public s() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new h5();
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f62904a = null;

        static {
            f62904a = new t();
        }

        public t() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new mc();
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f62905a = null;

        static {
            f62905a = new u();
        }

        public u() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new v5.d();
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 f62906a;

        public v(com.bytedance.ies.web.jsbridge2.d0 r100) {
            this.f62906a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            if (ni1.f120836a.getValue().booleanValue() == false) goto L6;
            return new FetchV3Method();
        L6:
            if (pi1.f120983a.getValue().booleanValue() == true) goto L15;
            com.bytedance.ies.web.jsbridge2.d0 r100 = this.f62906a;
            if (r100 == null) goto L11;
            WebView r101 = r100.f249342b;
        L13:
            return new a3(r101);
        L11:
            r101 = null;
            goto L13
        L15:
            return new e3();
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f62907a = null;

        static {
            f62907a = new w();
        }

        public w() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new CallPhoneMethod();
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f62908a = null;

        static {
            f62908a = new x();
        }

        public x() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new CallPhoneMethod();
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f62909a = null;

        static {
            f62909a = new y();
        }

        public y() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new zc();
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f62910a = null;

        static {
            f62910a = new z();
        }

        public z() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l5();
        }
    }

    public final IJsBridgeAssistService f() {
        return (IJsBridgeAssistService) this.f62882a.getValue();
    }

    public JsBridgeService() {
        this.f62882a = LazyKt.lazy(JsBridgeService$jsBridgeAssistService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Collection<BaseJsBridgeMethodFactory> getFactoryCollection() {
        return f().getFactoryCollection();
    }

    @Override // com.bytedance.android.live.browser.v
    public final List<String> getSafeHostList() {
        return f().getSafeHostList();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void initPermissionCheck() {
        f().initPermissionCheck();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void initTTLiveSdkJsb() {
        f().initTTLiveSdkJsb();
    }

    @Override // com.bytedance.android.live.browser.v
    public final <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass() {
        return f().provideBridgeSupportWidgetClass();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerDataShare() {
        f().registerDataShare();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerMatchShareMethods() {
        f().registerMatchShareMethods();
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerState() {
        f().registerState();
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable b(com.bytedance.android.live.browser.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "annieFactory");
        return f().registerAnnieFactory(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final d2 d(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        return new d2(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final e2 e(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        return new e2(null, r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final w30.a getStorageProcessor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return f().getStorageProcessor(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return f().provideClipMethod(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return f().provideDynamicUnRegisterWRDSMethod(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final u4 provideGetLiveNtpTimeMethod(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new u4();
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return f().provideRegisterMessageLatchMethod(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r100) {
        return f().provideRegisterMessageMethodInFeed(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return f().provideRegisterWRDSMethod(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return f().provideStateFulFragmentMethods(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        return f().registerExternalMethodFactory(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Observable<SubscriberJsEvent> registerJsEventSubscriber(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return f().registerJsEventSubscriber(r100);
    }

    @Override // com.bytedance.android.live.browser.v
    public final com.bytedance.android.live.browser.jsbridge.i.d a(String r100, JSBridgeManager r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "jsBridgeManager");
        return f().getNewCurrentState(r100, r101);
    }

    @Override // com.bytedance.android.live.browser.v
    public final IJsBridgeManager c(ILiveHybridContainer r100, kl0.c r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "bridgeImpl");
        return f().createJsBridgeManager(r100, r101, 2);
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101) {
        Intrinsics.checkNotNullParameter(r101, "registerPolicy");
        LinkedHashMap r102 = new LinkedHashMap();
        RegisterPolicy r103 = RegisterPolicy.DEFAULT;
        r102.putAll(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appInfo", new k(r100)), TuplesKt.to("fetch", new v(r100))}));
        r102.put("callPhone", w.f62907a);
        r102.put("makePhoneCall", x.f62908a);
        r102.put(DyPayConstant.KEY_SHOW_LOADING, y.f62909a);
        r102.put("hideLoading", z.f62910a);
        r102.put("imageToast", a0.f62884a);
        r102.put("handleNotificationSettings", b0.f62886a);
        r102.put("changePpeEnv", c0.f62888a);
        r102.put("vibrate", a.f62883a);
        r102.put("checkPermission", b.f62885a);
        r102.put("requestPermission", c.f62887a);
        r102.put("screenShotLocalTest", d.f62889a);
        r102.put("app.showModal", e.f62890a);
        r102.put("showModal", f.f62891a);
        r102.put("showLeaveRoomDialog", g.f62892a);
        r102.put("dialog", h.f62893a);
        r102.put("openCommentPanel", i.f62894a);
        r102.put("sendPublicScreenTextMessage", j.f62895a);
        r102.put("inputActivityEmoji", l.f62897a);
        r102.put("inputFusionEmoji", m.f62898a);
        r102.put("openEmojiPanel", n.f62899a);
        r102.put("comment", o.f62900a);
        r102.put("getAppInfo", new p(r100));
        r102.put("fetchPb", q.f62901a);
        r102.put("getClientSetting", r.f62902a);
        r102.put("getStrategyFactor", s.f62903a);
        r102.put("shareItem", t.f62904a);
        if (w30.f121494a.getValue().booleanValue() == false) goto L5;
        r102.put("setStorage", u.f62905a);
    L5:
        r102.putAll(f().provideDefaultStatefulMethods(r100, r101));
        return r102;
    }

    @Override // com.bytedance.android.live.browser.v
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101) {
        Intrinsics.checkNotNullParameter(r101, "registerPolicy");
        LinkedHashMap r102 = new LinkedHashMap();
        RegisterPolicy r103 = RegisterPolicy.DEFAULT;
        Pair[] r104 = new Pair[1];
        if (r100 == null) goto L5;
        WebView r105 = r100.f249342b;
    L6:
        r104[0] = TuplesKt.to("webviewNavigation", new de(r105));
        r102.putAll(MapsKt.mutableMapOf(r104));
        r102.put("getStorage", new v5.a());
        r102.put("removeStorage", new v5.b());
        r102.put("toast", new ed());
        r102.put("handleSharedKv", new rc());
        r102.put("isTeenMode", new u5());
        r102.put("sendMonitor", new a8());
        r102.put("sendLogV1", new ub());
        r102.put("reportADLog", new xa());
        r102.put("monitorLynx", new y7());
        r102.put("setBottomBannerVisibility", new u0());
        r102.put(AppConstants.BUNDLE_PULL_DOWN_HEIGHT, new ce());
        r102.put("dialogPullDownClose", new be());
        if (w30.f121494a.getValue().booleanValue() == true) goto L9;
        r102.put("setStorage", new v5.c());
    L9:
        r102.putAll(f().provideDefaultStatelessMethods(r100, r101));
        return r102;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.v
    public final void registerXBridgeMethods(y6.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r101, "xBridgeRegisterStrategy");
        f().registerXBridgeMethods(r100, r101);
    }

    @Override // com.bytedance.android.live.browser.v
    public final <T> void sendEventToAllJsBridges(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        f().sendEventToAllJsBridges(r100, r101);
    }

    @Override // com.bytedance.android.live.browser.v
    public final IJsBridgeManager createJsBridgeManager(Activity r100, com.bytedance.ies.web.jsbridge2.b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bridgeImpl");
        return f().createJsBridgeManager(r100, r101, r102);
    }
}

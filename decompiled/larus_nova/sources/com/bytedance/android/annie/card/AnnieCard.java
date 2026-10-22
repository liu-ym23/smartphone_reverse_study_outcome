package com.bytedance.android.annie.card;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.CardCustomMonitorKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.card.web.WebComponent;
import com.bytedance.android.annie.card.web.secLink.LiveSecLinkManager;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import com.bytedance.android.annie.container.fragment.n;
import com.bytedance.android.annie.monitor.SlardarMonitorUtils;
import com.bytedance.android.annie.param.JsGsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridKitType;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import o7.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieCard extends HybridCard implements f {
    public final AnonymousClass2 A;
    public final Lazy B;
    public volatile boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public View.OnClickListener G;
    public View.OnTouchListener H;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CardParamVoNew f39099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.annie.param.a f39100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b7.b f39101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Map<String, String>> f39102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f39103n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f39104o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.annie.card.base.b f39105p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<IHybridComponent.a> f39106q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, ? extends Object> f39107r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f39108s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f39109t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f39110u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f39111v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f39112w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f39113x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FailSubFragmentProxy f39114y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewGroup f39115z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39120a = null;

        static {
            int[] r100 = new int[CardCustomMonitorKey.values().length];
            r100[CardCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[CardCustomMonitorKey.UserOpenTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[CardCustomMonitorKey.LoadScene.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[CardCustomMonitorKey.IsContainerPreload.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[CardCustomMonitorKey.IsUserOpen.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[CardCustomMonitorKey.IsPrerender.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[CardCustomMonitorKey.HasReload.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[CardCustomMonitorKey.HintSecLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[CardCustomMonitorKey.DidAppear.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f39120a = r100;
        }
    }

    public static final class c extends com.bytedance.ies.web.jsbridge2.g<JsonObject, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieCard f39121a;

        public c(AnnieCard r100) {
            this.f39121a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final Object invoke(JsonObject r100, CallContext r101) {
            JsonObject r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            JsonElement r103 = r102.get("eventName");
            if (r103 != null) goto L5;
            return null;
        L5:
            if (r103.isJsonPrimitive() == true) goto L7;
            return null;
        L7:
            if (TextUtils.isEmpty(r103.getAsJsonPrimitive().getAsString()) == true) goto L23;
            JsonElement r104 = r102.get("noLivePrefix");
            if (r104 != null) goto L12;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L17;
            String r106 = "noLivePrefix" + r103.getAsString();
        L18:
            this.f39121a.f39102m.put(r106, (Map<String, String>) GsonProtectorUtils.fromJson(new Gson(), r102.get("params"), new com.bytedance.android.annie.card.a().getType()));
            return null;
        L17:
            r106 = r103.getAsString();
            goto L18
        L12:
            if (r104.isJsonPrimitive() == false) goto L14;
            r105 = r104.getAsJsonPrimitive().getAsBoolean();
            goto L15
        L23:
            return null;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FailSubFragmentProxy f39122a;

        public d(FailSubFragmentProxy r100) {
            this.f39122a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f39122a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieCard f39123a;

        public e(AnnieCard r100) {
            this.f39123a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FailSubFragmentProxy r100 = this.f39123a.f39114y;     // Catch: Throwable -> L10
            if (r100 == null) goto L5;
            View r101 = r100.f549023c;     // Catch: Throwable -> L10
        L6:
            if (r101 == null) goto L13;
            r101.setVisibility(8);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r101 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onInjectShareInfo(y6.e r100) {
    }

    private final m9.d getPerfEvent() {
        return (m9.d) this.B.getValue();
    }

    private final String getUrl() {
        CardParamVoNew r100 = this.f39099j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f39814b;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void b() {
        CardParamVoNew r100 = this.f39099j;
        if (r100 == null) goto L12;
        String r101 = r100.f39814b;
        if (r101 == null) goto L13;
        Set<String> r102 = SlardarMonitorUtils.f39586a;
        if (r100.f39813a != HybridKitType.LYNX) goto L9;
        String r103 = "lynx";
    L10:
        SlardarMonitorUtils.b(r101, "view", r103);
        return;
    L9:
        r103 = "H5";
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void d() {
        CardParamVoNew r100 = this.f39099j;
        if (r100 == null) goto L8;
        String r101 = r100.f39814b;
        if (r101 == null) goto L9;
        SlardarMonitorUtils.c(r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public String getBizKey() {
        return this.f39100k.getBizKey();
    }

    public final PageType getPageType() {
        CardParamVoNew r100 = this.f39099j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.I0();
    }

    public final void m() {
        CardParamVoNew r100 = this.f39099j;
        if (r100 != null) goto L5;
    L25:
        x8.b r101 = this.f39100k.f39696d;
        StringBuilder r102 = new StringBuilder("===initView end: ");
        String r103 = getUrl();
        if (r103 != null) goto L28;
        r103 = "empty";
    L28:
        r102.append(r103);
        r102.append("===");
        r101.f("AnnieCard", "init_view_end", r102.toString());
        return;
    L5:
        if (r100.f39813a != HybridKitType.LYNX) goto L7;
        IHybridComponent.HybridType r104 = IHybridComponent.HybridType.LYNX;
    L8:
        IHybridComponent r105 = getMCurrentHybridComponent();
        BaseHybridComponent r106 = null;
        if (r105 == null) goto L11;
        IHybridComponent.HybridType r107 = r105.hybridType();
    L12:
        if (r107 != r104) goto L21;
        CardParamVoNew r108 = this.f39099j;
        if (r108 == null) goto L30;
        IHybridComponent r109 = getMCurrentHybridComponent();
        if ((r109 instanceof BaseHybridComponent) == false) goto L18;
        r106 = (BaseHybridComponent) r109;
    L18:
        if (r106 == null) goto L31;
        r106.updateHybridParamsNew(r108);
        return;
    L31:
        return;
    L30:
        return;
    L21:
        removeAllViews();
        IHybridComponent r110 = getMCurrentHybridComponent();
        if (r110 == null) goto L24;
        r110.release();
    L24:
        setMCurrentHybridComponent(null);
        i(r104);
        goto L25
    L11:
        r107 = null;
        goto L12
    L7:
        r104 = IHybridComponent.HybridType.H5;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onRefresh() {
        this.f39100k.f39696d.e("AnnieCard", "===onRefresh:===");
        a7.a.a(this, null, null, 3);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        if (this.C == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.C = true;
        ExternalAddJsEventHelper.a();
        String r101 = this.f39108s;
        if (r101 == null) goto L8;
        Lazy r102 = ContainerInitialPropsManager.f39126a;
        Intrinsics.checkNotNullParameter(r101, "key");
        ((HashMap) ContainerInitialPropsManager.f39126a.getValue()).remove(r101);
    L8:
        super.release();
        String r103 = this.f39100k.getUrl();
        if (r103 != null) goto L11;
    L16:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L20;
        m9.d r105 = getPerfEvent();
        String r106 = this.f39100k.getUrl();
        Intrinsics.checkNotNull(r106);
        r105.j1(r106);
    L21:
        b7.b r107 = this.f39101l;
        if (r107 == null) goto L25;
        r107.onRelease();
    L25:
        if ((!this.f39102m.isEmpty()) == false) goto L34;
        long r108 = System.currentTimeMillis();
        Iterator r109 = ((LinkedHashMap) this.f39102m).entrySet().iterator();
    L28:
        if (r109.hasNext() == false) goto L33;
        Map.Entry r110 = (Map.Entry) r109.next();
        String r111 = (String) r110.getKey();
        Map<String, String> r112 = (Map) r110.getValue();
        if (r112.containsKey("duration") == true) goto L32;
        r112.put("duration", String.valueOf(r108 - this.f39103n));
    L32:
        ((x9.b) k(x9.b.class)).logV3(r111, r112);
        goto L28
    L33:
        ((LinkedHashMap) this.f39102m).clear();
    L34:
        ILatchService.e r113 = this.f39100k.f39693a;
        if (r113 == null) goto L37;
        r113.dispose();
    L37:
        AppCompatActivity r114 = null;
        this.f39100k.setCommonLifecycle(null);
        this.f39101l = null;
        this.f39110u = -1;
        setMReleasedFlag(true);
        this.f39100k.f39696d.e("AnnieCard", "AnnieCard release");
        this.f39105p = null;
        ((ArrayList) this.f39106q).clear();
        AnonymousClass2 r115 = this.A;
        if (r115 == null) goto L46;
        Context r116 = getContext();
        if ((r116 instanceof AppCompatActivity) == false) goto L42;
        r114 = (AppCompatActivity) r116;
    L42:
        if (r114 == null) goto L46;
        Lifecycle r117 = r114.getLifecycle();
        if (r117 == null) goto L46;
        r117.removeObserver(r115);
    L46:
        CardParamVoNew r118 = this.f39099j;
        if (r118 != null) goto L49;
    L51:
        r100 = false;
    L52:
        if (r100 == false) goto L58;
        CardParamVoNew r119 = this.f39099j;
        if (r119 == null) goto L58;
        String r120 = (String) r119.R.getValue();
        if (r120 == null) goto L58;
        Map<String, WeakReference<AnnieCard>> r121 = p8.a.f528057a;
        Intrinsics.checkNotNullParameter(r120, "url");
        WeakReference<AnnieCard> r122 = p8.a.f528057a.remove(r120);
        int r123 = x8.a.f562881a;
        x8.a.d("Annie_ComponentRecord", "remove(url=" + r120 + ") = " + r122, false);
    L58:
        y8.e.f566655a.a(getContext());
        return;
    L49:
        if (r118.d() != true) goto L51;
    L20:
        this.f39100k.f39696d.e("AnnieCard", "annie card released but url is null");
        goto L21
    L11:
        if (r103.length() <= 0) goto L13;
        boolean r124 = true;
    L14:
        if (r124 != true) goto L16;
        r104 = true;
        goto L18
    L13:
        r124 = false;
        goto L14
    }

    private final y6.c getJSBridgeManger() {
        IHybridComponent r100 = getMCurrentHybridComponent();
        if (r100 != null) goto L5;
        return null;
    L5:
        return ((BaseHybridComponent) r100).getJSBridgeManger();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean canGoBack() {
        IHybridComponent r100 = getMCurrentHybridComponent();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canGoBack();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void goBack() {
        IHybridComponent r100 = getMCurrentHybridComponent();
        if (r100 == null) goto L6;
        r100.goBack();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
        IHybridComponent r100 = getMCurrentHybridComponent();
        if (r100 == null) goto L6;
        r100.hide();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        if (getPageType() != PageType.POPUP) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l() {
        if (getPageType() == PageType.CARD) goto L7;
        FailSubFragmentProxy r100 = this.f39114y;
        if (r100 == null) goto L9;
        r100.c();
        return;
    L9:
        return;
    L7:
        ThreadUtils.c(new e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b7.b r100 = this.f39101l;
        if (r100 == null) goto L6;
        r100.onAttachedToWindow(this.f39100k.getUrl());
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
        IHybridComponent r100 = getMCurrentHybridComponent();
        if (r100 == null) goto L6;
        r100.show();
        return;
    }

    public final com.bytedance.android.annie.param.a getMAnnieContext() {
        return this.f39100k;
    }

    public final CardParamVoNew getMHybridParamVoNew() {
        return this.f39099j;
    }

    public static final /* synthetic */ m9.d h(AnnieCard r100) {
        return r100.getPerfEvent();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void c(com.bytedance.android.annie.card.base.b r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxCallback");
        IHybridComponent r101 = getMCurrentHybridComponent();
        BaseHybridComponent r102 = null;
        if (r101 == null) goto L5;
        IHybridComponent.HybridType r103 = r101.hybridType();
    L7:
        if (r103 != IHybridComponent.HybridType.LYNX) goto L14;
        IHybridComponent r104 = getMCurrentHybridComponent();
        if ((r104 instanceof BaseHybridComponent) == false) goto L11;
        r102 = (BaseHybridComponent) r104;
    L11:
        if (r102 == null) goto L15;
        r102.registerLifecycleCallback(r100);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        y6.c r101 = getJSBridgeManger();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v73, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.bytedance.android.annie.card.AnnieCard$getBaseLifecycle$1] */
    public final void i(final IHybridComponent.HybridType r210) {
        b7.b r100 = this.f39101l;
        if (r100 == null) goto L6;
        r100.onPrepareComponentStart();
    L6:
        if (this.f39108s != null) goto L14;
        CardParamVoNew r101 = this.f39099j;
        if (r101 == null) goto L14;
        String r102 = r101.o();
        if (r102 == null) goto L14;
        if ((!StringsKt.isBlank(r102)) == false) goto L14;
        this.f39108s = UriProtector.getQueryParameter(UriProtector.parse(r102), "__initialProps_data_key");
    L14:
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        String r104 = "";
        r103.element = "";
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = "";
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = "";
        if (r210 != IHybridComponent.HybridType.LYNX) goto L17;
        String r107 = "lynx";
    L18:
        String r108 = r107;
        CardParamVoNew r109 = this.f39099j;
        if (r109 == null) goto L27;
        ?? r110 = r109.o();
        if (r110 == 0) goto L23;
        r103.element = r110;
    L23:
        ?? r111 = r109.f39814b;
        if (r111 == 0) goto L27;
        r105.element = r111;
        r106.element = ListProtector.get(StringsKt.split$default(r111, new String[]{"?"}, false, 0, 6, null), 0);
    L27:
        if (AnnieConfigSettingKeys.SEND_LOG_IN_CHILD_THREAD.a().booleanValue() == false) goto L29;
        Schedulers.computation().scheduleDirect(new com.bytedance.android.annie.card.c(this, r103, r108, r105, r106));
    L39:
        if (com.bytedance.android.annie.ng.g.f39675g == false) goto L206;
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L206;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L206;
        throw new RuntimeException("不能在子线程创建Annie组件");
    L206:
        com.bytedance.android.annie.card.e r112 = com.bytedance.android.annie.ng.g.f39673e;     // Catch: Throwable -> L57
        CardParamVoNew r113 = this.f39099j;     // Catch: Throwable -> L57
        Context r114 = getContext();     // Catch: Throwable -> L57
        ?? r115 = new AnnieCard$getBaseLifecycle$1(this, r210);     // Catch: Throwable -> L57
        com.bytedance.android.annie.param.a r116 = this.f39100k;     // Catch: Throwable -> L57
        if (((HashMap) r112.f39142a).containsKey(r210) == false) goto L51;
        com.bytedance.android.annie.card.e.b r117 = (com.bytedance.android.annie.card.e.b) ((HashMap) r112.f39142a).get(r210);     // Catch: Throwable -> L57
    L52:
        if (r117 != 0) goto L54;
        IHybridComponent r118 = null;
    L55:
        setMCurrentHybridComponent(r118);     // Catch: Throwable -> L57
    L74:
        b7.b r119 = this.f39101l;
        if (r119 == null) goto L77;
        r119.onPrepareComponentEnd();
    L77:
        KeyEvent.Callback r120 = getHybridView();
        if ((r120 instanceof o7.a) == false) goto L80;
        o7.a r121 = (o7.a) r120;
    L81:
        if (r121 == null) goto L84;
        r121.b();
    L84:
        if (getMCurrentHybridComponent() == null) goto L86;
    L89:
        IHybridComponent r122 = getMCurrentHybridComponent();
        if (r122 == null) goto L92;
        r122.registerMethod("lynxReleaseSendLog", new c(this));
    L92:
        IHybridComponent r123 = getMCurrentHybridComponent();
        if (r123 == null) goto L159;
        View r124 = r123.getHybridView();
        if (r124 == null) goto L159;
        b7.b r125 = this.f39101l;
        if (r125 == null) goto L105;
        CardParamVoNew r126 = this.f39099j;
        if (r126 == null) goto L103;
        PageType r127 = r126.I0();
        if (r127 == null) goto L103;
        String r128 = r127.getPageType();
    L104:
        r125.onAttachView(r124, r210, r128);
    L103:
        r128 = null;
    L105:
        addView(r124);
        View.OnTouchListener r129 = this.H;
        if (r129 == null) goto L108;
        r124.setOnTouchListener(r129);
    L108:
        View.OnClickListener r130 = this.G;
        if (r130 == null) goto L112;
        r124.setOnClickListener(r130);
    L112:
        if (isPopup() == true) goto L159;
        CardParamVoNew r131 = this.f39099j;
        if (r131 == null) goto L118;
        String r132 = r131.g();
        if (r132 == null) goto L118;
        List r133 = StringsKt.split$default(r132, new String[]{","}, false, 0, 6, null);
    L119:
        List r134 = r133;
        if (r134 != null) goto L122;
    L125:
        boolean r135 = true;
    L127:
        if (r135 == true) goto L148;
        int r136 = r133.size();
        if (2 > r136) goto L132;
        if (r136 >= 4) goto L132;
        boolean r137 = true;
    L133:
        if (r137 == false) goto L148;
        int[] r138 = new int[r133.size()];
        Iterator r139 = r133.iterator();
        int r140 = 0;
    L136:
        if (r139.hasNext() == false) goto L138;
        r138[r140] = n.a((String) r139.next(), -1, ColorProtector.parseColor("#00000000"));
        r140 = r140 + 1;
        goto L136
    L138:
        int r141 = n.f39371a;
        Integer r142 = Integer.valueOf(t.f40076a.h());
        CardParamVoNew r143 = this.f39099j;
        if (r143 == null) goto L141;
        int r144 = r143.h();
    L142:
        ShapeDrawable r145 = n.c(r142, r144, r138);
        setBackgroundDrawable(r145);
        ViewParent r146 = getParent();
        if ((r146 instanceof FrameLayout) == false) goto L145;
        FrameLayout r147 = (FrameLayout) r146;
    L146:
        if (r147 == null) goto L159;
        r147.setBackgroundDrawable(r145);
        goto L159
    L145:
        r147 = null;
        goto L146
    L141:
        r144 = 0;
    L132:
        r137 = false;
    L148:
        CardParamVoNew r148 = this.f39099j;
        if (r148 == null) goto L159;
        String r149 = r148.s();
        if (r149 == null) goto L159;
        int r150 = n.a(r149, -1, 0);
        setBackgroundColor(r150);
        ViewParent r151 = getParent();
        if ((r151 instanceof FrameLayout) == false) goto L155;
        FrameLayout r152 = (FrameLayout) r151;
    L156:
        if (r152 == null) goto L159;
        r152.setBackgroundColor(r150);
        goto L159
    L155:
        r152 = null;
        goto L156
    L122:
        if (r134.isEmpty() == true) goto L125;
        r135 = false;
    L118:
        r133 = null;
    L159:
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L161;
        ((c9.d) k(c9.d.class)).c0(getContext(), this);
    L161:
        y6.c r153 = getJSBridgeManger();
        if (r153 == null) goto L173;
        Iterator<T> r154 = this.f39106q.iterator();
    L165:
        if (r154.hasNext() == false) goto L167;
        ((IHybridComponent.a) r154.next()).onJSBridgeCreated(r153);
        goto L165
    L167:
        ILatchService.e r155 = this.f39100k.f39693a;
        if (r155 == null) goto L171;
        r155.f(r153.d());
    L171:
        if ((r153 instanceof JSBridgeManager) == false) goto L173;
        ((JSBridgeManager) r153).f38447t.a(this);
    L173:
        CardParamVoNew r156 = this.f39099j;
        if (r156 != null) goto L176;
    L178:
        boolean r157 = false;
    L179:
        if (r157 == false) goto L204;
        CardParamVoNew r158 = this.f39099j;
        if (r158 == null) goto L204;
        String r159 = (String) r158.R.getValue();
        if (r159 == null) goto L204;
        Map<String, WeakReference<AnnieCard>> r160 = p8.a.f528057a;
        Intrinsics.checkNotNullParameter(r159, "url");
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        int r161 = x8.a.f562881a;
        x8.a.d("Annie_ComponentRecord", "add(url=" + r159 + ", card=" + this + ')', false);
        if (r159.length() != 0) goto L187;
        boolean r162 = true;
    L188:
        if (r162 == true) goto L204;
        Integer r163 = AnnieConfigSettingKeys.LIVE_ENABLE_VIEW_REMOVE.a();
        if (r163 != null) goto L194;
    L196:
        Map<String, WeakReference<AnnieCard>> r164 = p8.a.f528057a;
        if (r164.containsKey(r159) == false) goto L203;
        WeakReference r165 = (WeakReference) ((LinkedHashMap) r164).get(r159);
        if (r165 == null) goto L203;
        AnnieCard r166 = (AnnieCard) r165.get();
        if (r166 == null) goto L203;
        r166.release();
        r166.removeAllViews();
        r166.f39108s = null;
        r166.G = null;
        r166.setMCurrentHybridComponent(null);
        r166.setDestroyedFlag(true);
        Unit r167 = Unit.INSTANCE;
        x8.a.d("Annie_ComponentRecord", "destroyed url = ".concat(r159), false);
    L203:
        r164.put(r159, new WeakReference(this));
        goto L204
    L194:
        if (r163.intValue() != 0) goto L196;
        x8.a.d("Annie_ComponentRecord", "disable view remove url=".concat(r159), false);
        goto L204
    L187:
        r162 = false;
    L204:
        setMReleasedFlag(false);
        return;
    L176:
        if (r156.d() != true) goto L178;
        r157 = true;
        goto L179
    L86:
        if (r210 != IHybridComponent.HybridType.LYNX) goto L89;
        n(200, this.f39104o);
        return;
    L80:
        r121 = null;
        goto L81
    L54:
        r118 = r117.a(r114, r113, r115, r116);     // Catch: Throwable -> L57
        goto L55
    L51:
        r117 = 0;
    L57:
        th = move-exception;
        CardParamVoNew r168 = this.f39099j;
        if (r168 == null) goto L63;
        String r169 = r168.e();
        if (r169 == null) goto L63;
        q(new AnnieCard$createAndAddView$1$1(this), r169);
    L63:
        b7.b r170 = this.f39101l;
        String r171 = "unknown container error";
        if (r170 == null) goto L69;
        String r172 = th.getMessage();
        if (r172 != null) goto L68;
        r172 = "unknown container error";
    L68:
        r170.onContainerError(null, 200, r172);
    L69:
        String r173 = th.getMessage();
        if (r173 == null) goto L73;
        r171 = r173;
    L73:
        this.f39104o = r171;
        this.f39100k.f39696d.a("AnnieCard", "type: " + r210 + ", reason: " + this.f39104o);
        goto L74
    L29:
        String r174 = (String) r103.element;
        String r175 = (String) r105.element;
        String r176 = (String) r106.element;
        x9.b r177 = (x9.b) k(x9.b.class);
        Pair[] r178 = new Pair[5];
        r178[0] = TuplesKt.to("scheme", r174);
        r178[1] = TuplesKt.to(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r108);
        r178[2] = TuplesKt.to("original_url", r175);
        r178[3] = TuplesKt.to("url", r176);
        CardParamVoNew r179 = getMHybridParamVoNew();
        if (r179 == null) goto L37;
        PageType r180 = r179.I0();
        if (r180 == null) goto L37;
        String r181 = r180.getPageType();
        if (r181 == null) goto L37;
        r104 = r181;
    L37:
        r178[4] = TuplesKt.to("page_type", r104);
        r177.logV3("livesdk_live_container_load", MapsKt.mutableMapOf(r178));
        goto L39
    L17:
        r107 = "web";
        goto L18
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        if (this.f39114y == null) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f39115z;
        if (r101 != null) goto L8;
    L12:
        r101 = this;
    L13:
        Context r102 = getContext();
        Pair[] r103 = new Pair[4];
        boolean r104 = false;
        r103[0] = TuplesKt.to("theme", r100);
        CardParamVoNew r105 = this.f39099j;
        if (r105 == null) goto L16;
        PageType r106 = r105.I0();
    L18:
        if (r106 != PageType.POPUP) goto L20;
        boolean r107 = true;
    L21:
        r103[1] = TuplesKt.to("is_popup", String.valueOf(r107));
        CardParamVoNew r108 = this.f39099j;
        if (r108 == null) goto L28;
        String r109 = r108.o();
        if (r109 == null) goto L28;
        if (StringsKt.contains$default(r109, "gravity=bottom", false, 2, null) != true) goto L28;
        r104 = true;
    L28:
        r103[2] = TuplesKt.to("is_bottom_popup", String.valueOf(r104));
        r103[3] = TuplesKt.to("popup_width", String.valueOf(this.D));
        FailSubFragmentProxy r110 = u7.b.a(r101, r102, MapsKt.hashMapOf(r103), getBizKey());
        ThreadUtils.c(new d(r110));
        this.f39114y = r110;
        return;
    L20:
        r107 = false;
        goto L21
    L16:
        r106 = null;
        goto L18
    L8:
        if (getPageType() == null) goto L12;
        if (getPageType() == PageType.CARD) goto L12;
        goto L12
    }

    public final <T extends com.bytedance.android.annie.service.a> T k(Class<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) Annie.getService(r100, getBizKey());
    }

    public final void o(com.bytedance.android.annie.card.web.e r100) {
        Intrinsics.checkNotNullParameter(r100, "webCallback");
        IHybridComponent r101 = getMCurrentHybridComponent();
        BaseHybridComponent r102 = null;
        if (r101 == null) goto L5;
        IHybridComponent.HybridType r103 = r101.hybridType();
    L7:
        if (r103 != IHybridComponent.HybridType.H5) goto L13;
        IHybridComponent r104 = getMCurrentHybridComponent();
        if ((r104 instanceof BaseHybridComponent) == false) goto L11;
        r102 = (BaseHybridComponent) r104;
    L11:
        if (r102 == null) goto L15;
        r102.registerLifecycleCallback(r100);
        return;
    L15:
        return;
    L13:
        this.f39105p = r100;
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (getPageType() == PageType.POPUP) goto L13;
        x8.b r101 = this.f39100k.f39696d;
        StringBuilder r102 = new StringBuilder("onConfigurationChanged, widthDp:");
        Object r103 = "-1";
        if (r100 == null) goto L7;
        Object r104 = Integer.valueOf(r100.screenWidthDp);
    L8:
        r102.append(r104);
        r102.append(", heightDp: ");
        if (r100 == null) goto L11;
        r103 = Integer.valueOf(r100.screenHeightDp);
    L11:
        r102.append(r103);
        r101.e("AnnieCard", r102.toString());
        this.f39100k.f39697e.b(r100, this);
        return;
    L7:
        r104 = "-1";
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f39109t == false) goto L5;
        Paint r101 = new Paint();
        r101.setStrokeWidth(6.0f);
        r101.setColor(ColorProtector.parseColor(TraceEvent.DEFAULT_INSTANT_COLOR));
        r100.drawLine(0.0f, 0.0f, getWidth(), 0.0f, r101);
        r100.drawLine(0.0f, 0.0f, 0.0f, getHeight(), r101);
        r100.drawLine(getWidth(), 0.0f, getWidth(), getHeight(), r101);
        r100.drawLine(0.0f, getHeight(), getWidth(), getHeight(), r101);
    L5:
        super.onDraw(r100);
    }

    public final void setDialogWidth(int r100) {
        this.D = r100;
    }

    public final void setErrorPageCloseHandler(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "closeHandler");
        FailSubFragmentProxy r101 = this.f39114y;
        if ((r101 instanceof FailSubFragmentProxy) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (r101.f39352f != null) goto L13;
        r101.f39352f = r100;
        return;
    L13:
        return;
    }

    public final void setErrorPageRetryHandler(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "retryHandler");
        FailSubFragmentProxy r101 = this.f39114y;
        if ((r101 instanceof FailSubFragmentProxy) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (r101.f39351e != null) goto L13;
        r101.f39351e = r100;
        return;
    L13:
        return;
    }

    public final void setErrorPageRoot(ViewGroup r100) {
        this.f39115z = r100;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f39106q).add(r100);
        y6.c r101 = getJSBridgeManger();
        if (r101 == null) goto L6;
        r100.onJSBridgeCreated(r101);
        return;
    }

    public final void setMHybridParamVoNew(CardParamVoNew r100) {
        this.f39099j = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.G = r100;
        View r101 = getHybridView();
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        IHybridComponent r101 = getMCurrentHybridComponent();
        if (r101 == null) goto L6;
        r101.setOnScrollChangeListener(r100);
        return;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r100) {
        super.setOnTouchListener(r100);
        this.H = r100;
        View r101 = getHybridView();
        if (r101 == null) goto L6;
        r101.setOnTouchListener(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r100) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r100);
        return;
    L5:
        IHybridComponent r101 = getMCurrentHybridComponent();
        if (r101 == null) goto L10;
        r101.setRadius(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IHybridComponent r101 = getMCurrentHybridComponent();
        if (r101 == null) goto L6;
        r101.updateData(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        IHybridComponent r101 = getMCurrentHybridComponent();
        if (r101 == null) goto L6;
        r101.updateGlobalProps(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void a(Uri r100, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        x8.b r101 = this.f39100k.f39696d;
        StringBuilder r102 = new StringBuilder("===loadSchema:");
        String r103 = getUrl();
        if (r103 != null) goto L5;
        r103 = "empty";
    L5:
        r102.append(r103);
        r102.append("====");
        r101.e("AnnieCard", r102.toString());
        String r104 = r100.getHost();
        boolean r105 = false;
        if (r104 != null) goto L8;
    L10:
        if (r105 == true) goto L12;
        this.f39111v = true;
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f39099j = com.bytedance.android.annie.param.c.a(r100, null);
        m();
        a7.a.a(this, null, r110, 1);
        return;
    L12:
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L14;
        com.bytedance.android.annie.util.c.a(r100 + "需要重定向，不支持直接加载！");
    L14:
        this.f39100k.f39696d.a("AnnieCard", r100 + " needs to be redirected and should not be loaded directly!");
        return;
    L8:
        if (StringsKt.contains$default(r104, "webcast_redirect", false, 2, null) != true) goto L10;
        r105 = true;
        goto L10
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void f(int r100, int r101) {
        IHybridComponent r102 = getMCurrentHybridComponent();
        if ((r102 instanceof BaseHybridComponent) == false) goto L5;
        BaseHybridComponent r103 = (BaseHybridComponent) r102;
    L6:
        if (r103 == null) goto L9;
        r103.updateScreenMetrics(r100, r101);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void g(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "visibleChangeReason");
        JSONObject r102 = new JSONObject();
        r102.put("visible", r100);
        r102.put("source", r101);
        Unit r103 = Unit.INSTANCE;
        sendJsEvent("pageVisibilityChange", r102);
        if (r100 == false) goto L5;
        sendJsEvent("viewAppeared", new JSONObject());
        return;
    L5:
        sendJsEvent("viewDisappeared", new JSONObject());
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r100, Map<String, ? extends Object> r101) {
        p(CardCustomMonitorKey.HasReload, Integer.valueOf(this.f38396f ? 1 : 0));
        this.f39112w = true;
        if (r101 == null) goto L6;
        this.f39107r = r101;
    L6:
        if (this.f39107r != null) goto L12;
        String r102 = this.f39108s;
        if (r102 == null) goto L12;
        Lazy r103 = ContainerInitialPropsManager.f39126a;
        Intrinsics.checkNotNullParameter(r102, "key");
        JsonObject r104 = (JsonObject) ((HashMap) ContainerInitialPropsManager.f39126a.getValue()).get(r102);
        if (r104 == null) goto L12;
        Lazy r105 = UtilsKt.f39692a;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        this.f39107r = new JsGsonMap(r104);
        Unit r106 = Unit.INSTANCE;
    L12:
        x8.b r107 = this.f39100k.f39696d;
        StringBuilder r108 = new StringBuilder("===load: ");
        if (r100 != null) goto L15;
        String r109 = "empty";
    L16:
        r108.append(r109);
        r108.append("===");
        r107.e("AnnieCard", r108.toString());
        if (r101 != null) goto L19;
        r101 = this.f39107r;
    L19:
        super.load(r100, r101);
        return;
    L15:
        r109 = r100;
        goto L16
    }

    public final void n(int r100, String r101) {
        CardParamVoNew r102 = this.f39099j;
        if (r102 != null) goto L5;
    L24:
        CardParamVoNew r103 = this.f39099j;
        if (r103 == null) goto L27;
        String r104 = r103.f39815c;
    L29:
        if (TextUtils.isEmpty(r104) == true) goto L65;
        removeAllViews();
        IHybridComponent r105 = getMCurrentHybridComponent();
        if (r105 == null) goto L33;
        r105.release();
    L33:
        setMCurrentHybridComponent(null);
        if (r104 != null) goto L36;
    L40:
        CardParamVoNew r106 = this.f39099j;
        if (r106 == null) goto L54;
        String r107 = r106.f39814b;
        if (r107 == null) goto L54;
        String r108 = r106.o();
        if (LiveSecLinkManager.b(r107, r108, getBizKey()) == false) goto L54;
        com.bytedance.android.annie.param.a r109 = this.f39100k;
        if (r109 == null) goto L51;
        x8.b r110 = r109.f39696d;
        if (r110 == null) goto L51;
        r110.a("AnnieCard", "invalid scheme " + r108);
    L51:
        b7.b r111 = this.f39101l;
        if (r111 == null) goto L54;
        r111.onContainerError(null, 500, "invalid scheme " + r108);
    L54:
        i(IHybridComponent.HybridType.H5);
        com.bytedance.android.annie.card.base.b r112 = this.f39105p;
        if (r112 == null) goto L62;
        IHybridComponent r113 = getMCurrentHybridComponent();
        if ((r113 instanceof WebComponent) == false) goto L59;
        WebComponent r114 = (WebComponent) r113;
    L60:
        if (r114 == null) goto L62;
        r114.registerLifecycleCallback(r112);
        goto L62
    L59:
        r114 = null;
    L62:
        IHybridComponent r115 = getMCurrentHybridComponent();
        if (r115 == null) goto L72;
        a7.a.a(r115, null, this.f39107r, 1);
        return;
    L72:
        return;
    L36:
        if (l.f(r104) == false) goto L38;
        int r116 = com.bytedance.android.annie.param.c.f39699a;
        Intrinsics.checkNotNullParameter(r104, "url");
        CardParamVoNew r117 = com.bytedance.android.annie.param.c.a(UriProtector.parse("sslocal://webcast_webview?type=card&hybrid_type=h5&url=" + Uri.encode(r104)), null);
    L39:
        this.f39099j = r117;
        goto L40
    L38:
        r117 = com.bytedance.android.annie.param.c.a(UriProtector.parse(r104), null);
        goto L39
    L65:
        FailSubFragmentProxy r118 = this.f39114y;
        if (r118 == null) goto L68;
        r118.d();
    L68:
        b7.b r119 = this.f39101l;
        if (r119 == null) goto L74;
        r119.onFallback(r100, r101);
        return;
    L74:
        return;
    L27:
        r104 = null;
        goto L29
    L5:
        if (r102.f39813a != HybridKitType.LYNX) goto L24;
        String r120 = r102.f39815c;
        if ((!StringsKt.isBlank(r120)) == true) goto L11;
        r120 = null;
    L11:
        if (r120 == null) goto L24;
        b7.b r121 = this.f39101l;
        if (r121 == null) goto L15;
        r121.onInnerFallback(r100, r101);
    L15:
        b7.b r122 = this.f39101l;
        if (r122 == null) goto L18;
        r122.onInit(this.f39100k);
    L18:
        b7.b r123 = this.f39101l;
        if (r123 == null) goto L21;
        r123.onBeforeOpenContainer();
    L21:
        b7.b r124 = this.f39101l;
        if (r124 == null) goto L24;
        r124.onPrepareInitDataStart(r120, "", true);
        goto L24
    }

    public final void p(CardCustomMonitorKey r100, Object r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        if (this.f39100k.getMonitorID() != null) goto L5;
        return;
    L5:
        String r101 = this.f39100k.getMonitorID();
        Intrinsics.checkNotNull(r101);
        k9.d r102 = ((k9.e) k(k9.e.class)).V0();
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", value: " + r110 + ", monitorId: " + r101);
        switch(b.f39120a[r100.ordinal()]) {
            case 1: goto L41;
            case 2: goto L35;
            case 3: goto L31;
            case 4: goto L27;
            case 5: goto L24;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L12;
            case 9: goto L9;
            default: goto L73;
        };
    L12:
        r102.d(r101, "hint_seclink", r110.toString());
        Bundle r103 = this.f39100k.getBundle();
        if (r103 == null) goto L55;
        r103.putString("hint_seclink", r110.toString());
        return;
    L55:
        return;
    L15:
        r102.d(r101, "has_reload", r110.toString());
        Bundle r104 = this.f39100k.getBundle();
        if (r104 == null) goto L57;
        r104.putString("has_reload", r110.toString());
        return;
    L57:
        return;
    L24:
        r102.d(r101, "is_user_open", r110.toString());
        Bundle r105 = this.f39100k.getBundle();
        if (r105 == null) goto L62;
        r105.putString("is_user_open", r110.toString());
        return;
    L62:
        return;
    L27:
        r102.d(r101, "is_container_preload", r110.toString());
        Bundle r106 = this.f39100k.getBundle();
        if (r106 == null) goto L64;
        r106.putString("is_container_preload", r110.toString());
        return;
    L64:
        return;
    L73:
        return;
    L9:
        if ((r110 instanceof Long) == false) goto L11;
        r102.c(r101, "containerview_didappear", ((Number) r110).longValue());
        return;
    L11:
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", typeof value is not Long, do nothing");
        return;
    L19:
        if ((r110 instanceof Integer) == false) goto L23;
        r102.a(r101, "is_prerender", ((Number) r110).intValue());
        Bundle r107 = this.f39100k.getBundle();
        if (r107 == null) goto L59;
        r107.putString("is_prerender", r110.toString());
        return;
    L59:
        return;
    L23:
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", typeof value is not Int, do nothing");
        return;
    L31:
        if ((r110 instanceof Integer) == false) goto L33;
        r102.b(r101, ((Number) r110).intValue());
        return;
    L33:
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", typeof value is not Int, do nothing");
        return;
    L35:
        if ((r110 instanceof Long) == false) goto L39;
        r102.c(r101, "user_open_time", ((Number) r110).longValue());
        Bundle r108 = this.f39100k.getBundle();
        if (r108 == null) goto L68;
        r108.putString("user_open_time", r110.toString());
        return;
    L68:
        return;
    L39:
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", typeof value is not Long, do nothing");
        return;
    L41:
        if (this.f39113x == false) goto L43;
        return;
    L43:
        this.f39113x = true;
        if ((r110 instanceof Long) == false) goto L51;
        Number r109 = (Number) r110;
        r102.c(r101, "open_time", r109.longValue());
        Bundle r111 = this.f39100k.getBundle();
        if (r111 == null) goto L48;
        r111.putString("has_reload", r110.toString());
    L48:
        Bundle r112 = this.f39100k.getBundle();
        if (r112 == null) goto L71;
        r112.putLong("real_open_time", r109.longValue());
        return;
    L71:
        return;
    L51:
        this.f39100k.f39696d.e("AnnieCard", "setCustomMonitorKey " + r100 + ", typeof value is not Long, do nothing");
    }

    public final void q(Function0<Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "retryHandler");
        Intrinsics.checkNotNullParameter(r101, "theme");
        if (CollectionsKt.listOf(new String[]{"sjb", "light", "dark"}).contains(r101) == true) goto L5;
        return;
    L5:
        j(r101);
        FailSubFragmentProxy r102 = this.f39114y;
        FailSubFragmentProxy r103 = null;
        if (r102 == null) goto L8;
        View r104 = r102.f549023c;
    L9:
        if (r104 == null) goto L12;
        r104.setVisibility(0);
    L12:
        FailSubFragmentProxy r105 = this.f39114y;
        if (r105 == null) goto L15;
        r105.d();
    L15:
        FailSubFragmentProxy r106 = this.f39114y;
        if ((r106 instanceof FailSubFragmentProxy) == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L25;
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (r106.f39351e != null) goto L25;
        r106.f39351e = r100;
    L25:
        FailSubFragmentProxy r107 = this.f39114y;
        if ((r107 instanceof FailSubFragmentProxy) == false) goto L28;
        r103 = r107;
    L28:
        if (r103 == null) goto L36;
        Function0<Unit> r108 = this.f39100k.f39694b;
        if (r108 == null) goto L37;
        Intrinsics.checkNotNullParameter(r108, "handler");
        if (r103.f39352f != null) goto L38;
        r103.f39352f = r108;
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L8:
        r104 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v22, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.android.annie.card.AnnieCard$2] */
    public AnnieCard(final Context r110, CardParamVoNew r111, com.bytedance.android.annie.param.a r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "mAnnieContext");
        AppCompatActivity r100 = null;
        int r101 = 0;
        super(r110, null, 6, 0);
        this.f39099j = r111;
        this.f39100k = r112;
        this.f39101l = r112.getCommonLifecycle();
        this.f39102m = new LinkedHashMap();
        this.f39104o = "";
        this.f39106q = new ArrayList();
        boolean r113 = AnnieConfigSettingKeys.STROKE_SWITCH.a().booleanValue();
        this.f39109t = r113;
        this.f39110u = -1;
        this.B = LazyKt.lazy(new AnnieCard$perfEvent$2(this));
        this.D = -1;
        this.F = true;
        x8.b r102 = r112.f39696d;
        StringBuilder r103 = new StringBuilder("===init start: ");
        String r104 = getUrl();
        String r105 = "empty";
        if (r104 != null) goto L5;
        r104 = "empty";
    L5:
        r103.append(r104);
        r103.append("===");
        r102.f("AnnieCard", "init_annie_card", r103.toString());
        b7.b r106 = this.f39101l;
        if (r106 == null) goto L8;
        r106.onContainerInitEnd();
    L8:
        ExternalAddJsEventHelper.b();
        if (r112.f39694b != null) goto L11;
        r112.f39694b = new AnonymousClass1(this);
    L11:
        m();
        if (r113 == false) goto L14;
        setWillNotDraw(false);
        setPadding(6, 6, 6, 6);
    L14:
        y8.e r114 = y8.e.f566655a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r107 = y8.e.f566657c;
        monitor-enter(r107);
    L39:
        th = move-exception;
        throw th;
    L17:
        if (y8.e.f566656b != 0) goto L19;
        r110.registerComponentCallbacks(r114);     // Catch: Throwable -> L39
    L19:
        y8.e.f566656b++;     // Catch: Throwable -> L39
        monitor-exit(r107);
        if (AnnieConfigSettingKeys.MEMORY_LEAK_REPORTER.a().booleanValue() == false) goto L30;
        ?? r115 = new AnonymousClass2(this, r110);
        this.A = r115;
        if ((r110 instanceof AppCompatActivity) == false) goto L26;
        r100 = (AppCompatActivity) r110;
    L26:
        if (r100 == null) goto L30;
        Lifecycle r116 = r100.getLifecycle();
        if (r116 == 0) goto L30;
        r116.addObserver(r115);
    L30:
        r112.f39697e.c(p.f40070a.getResources());
        x8.b r117 = r112.f39696d;
        StringBuilder r118 = new StringBuilder("===init end: ");
        String r108 = getUrl();
        if (r108 == null) goto L34;
        r105 = r108;
    L34:
        r118.append(r105);
        r118.append("===");
        r117.f("AnnieCard", "init_card_end", r118.toString());
        CardCustomMonitorKey r119 = CardCustomMonitorKey.IsPrerender;
        Bundle r120 = r112.getBundle();
        if (r120 == null) goto L37;
        r101 = r120.getInt("isPrerender");
    L37:
        p(r119, Integer.valueOf(r101));
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public final void setRadius(float r100, float r101, float r102, float r103) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r100, r101, r102, r103);
        return;
    L5:
        IHybridComponent r104 = getMCurrentHybridComponent();
        if (r104 == null) goto L10;
        r104.setRadius(r100, r101, r102, r103);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Configuration r105 = p.f40070a.getResources().getConfiguration();
        if (r105 == null) goto L5;
        int r106 = r105.orientation;
    L6:
        int r107 = this.f39110u;
        if (r107 != (-1)) goto L9;
        this.f39110u = r106;
        return;
    L9:
        if (r106 == r107) goto L22;
        this.f39110u = r106;
        JSONObject r108 = new JSONObject();
        int r109 = this.f39110u;
        if (r109 != 1) goto L13;
        String r110 = "portrait";
    L18:
        if (Intrinsics.areEqual(r110, "") == true) goto L23;
        r108.put("screenOrientation", r110);
        sendJsEvent("orientationChanged", r108);
        return;
    L23:
        return;
    L13:
        if (r109 == 2) goto L15;
        r110 = "";
        goto L18
    L15:
        r110 = "landscape";
        goto L18
    L22:
        return;
    L5:
        r106 = -1;
        goto L6
    }
}

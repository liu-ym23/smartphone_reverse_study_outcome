package com.bytedance.android.annie.card.base;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.container.fragment.o;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.l;
import org.json.JSONArray;
import w8.e;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseHybridComponent implements IHybridComponent, o {
    public static final a Companion = null;
    public static final String GLOBAL_PROPS = "__globalProps";
    public static final String INITIAL_PROPS_QUERY_KEY = "initialProps";
    public static final String INJECT_NATIVE_DATA = "__globalprops";
    public static final String STATE_OBSERVER_CHANGE = "stateObserverChange";
    private final com.bytedance.android.annie.param.a annieContext;
    private AnnieXLiveContext annieXLiveContext;
    private e dataHolder;
    private DataProviderService dataProviderService;
    private String mContainerId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseHybridComponent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    public abstract JSBridgeManager getJSBridgeManger();

    public abstract View getView();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
    }

    public boolean isAnnieXComponent() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void registerLifecycleCallback(b r100);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r100) {
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r100, float r101, float r102, float r103) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
    }

    public void updateHybridParamsNew(CardParamVoNew r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public abstract void updateScreenMetrics(int r100, int r101);

    public c7.a getAnnieContext() {
        com.bytedance.android.annie.param.a r100 = this.annieContext;
        if (r100 != null) goto L7;
        AnnieXLiveContext r101 = this.annieXLiveContext;
        Intrinsics.checkNotNull(r101);
        return r101;
    L7:
        return r100;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        e r100 = this.dataHolder;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.dataProviderService.a();
        Lazy r101 = ComponentManager.f39132a;
        String r102 = this.mContainerId;
        Intrinsics.checkNotNullParameter(r102, "containerId");
        ((HashMap) ComponentManager.f39132a.getValue()).remove(r102);
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r103 = SocketManager.f40101a;
        SocketManager r104 = SocketManager.a.a();
        String r105 = this.mContainerId;
        r104.getClass();
        SocketManager.b(r105, null);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public View getHybridView() {
        return getView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String containerId() {
        return this.mContainerId;
    }

    public BaseHybridComponent(com.bytedance.android.annie.param.a r100) {
        this.annieContext = r100;
        if (r100 == null) goto L5;
        String r101 = r100.getUuid();
    L10:
        this.mContainerId = r101;
        if (r100 == null) goto L13;
        String r102 = r100.getBizKey();
    L18:
        this.dataProviderService = new DataProviderService(r102);
        Lazy r103 = ComponentManager.f39132a;
        String r104 = this.mContainerId;
        Intrinsics.checkNotNullParameter(r104, "containerId");
        Intrinsics.checkNotNullParameter(this, KtvSubElement.CONTAINER);
        Lazy r105 = ComponentManager.f39132a;
        if (((HashMap) r105.getValue()).containsKey(r104) == true) goto L22;
        ((HashMap) r105.getValue()).put(r104, new WeakReference(this));
        return;
    L22:
        return;
    L13:
        AnnieXLiveContext r106 = this.annieXLiveContext;
        if (r106 == null) goto L17;
        r102 = r106.getBizKey();
        if (r102 != null) goto L18;
    L17:
        r102 = "host";
        goto L18
    L5:
        AnnieXLiveContext r107 = this.annieXLiveContext;
        if (r107 == null) goto L9;
        r101 = r107.getUuid();
        if (r101 != null) goto L10;
    L9:
        r101 = "";
        goto L10
    }

    public <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) Annie.getService(r100, getBizKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseHybridComponent(AnnieXLiveContext r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXLiveContext");
        this(null, 1, 0 == true ? 1 : 0);
        this.annieXLiveContext = r100;
    }

    public Map<String, Object> observeWith(String r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        com.bytedance.android.anniex.assemble.a.h();
        if (l.g(r100) == false) goto L15;
        Object r104 = null;
        if (AnnieConfigSettingKeys.LIVE_HYBRID_USE_NEW_DATA_SHARE.a().booleanValue() == false) goto L74;
        JSBridgeManager r105 = getJSBridgeManger();
        if (r105 == null) goto L73;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L64
        if (r101 != null) goto L23;
    L26:
        boolean r107 = true;
    L28:
        if ((!r107) == true) goto L31;
        r101 = null;
    L31:
        if (r101 == null) goto L51;
        String r108 = UriProtector.getQueryParameter(UriProtector.parse(r101), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L64
        if (r108 == null) goto L51;
        Object r109 = Result.m9449constructorimpl(new JSONArray(r108));     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r109) == false) goto L41;
        r109 = null;
    L41:
        JSONArray r110 = (JSONArray) r109;     // Catch: Throwable -> L64
        if (r110 == null) goto L51;
        if (r110.length() <= 0) goto L46;
        r102 = true;
    L46:
        if (r102 == true) goto L49;
        r110 = null;
    L49:
        if (r110 == null) goto L51;
    L62:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L64
    L67:
        if (Result.m9455isFailureimpl(r111) == true) goto L70;
        r104 = r111;
    L70:
        this.dataProviderService.c(r100, (JSONArray) r104, r105, new BaseHybridComponent$observeWith$1$1(this));
        return this.dataProviderService.b();
    L36:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L64
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
    L51:
        String r113 = UriProtector.getQueryParameter(UriProtector.parse(r100), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L64
        if (r113 != null) goto L145;
        r110 = null;
        goto L62
    L145:
        Object r114 = Result.m9449constructorimpl(new JSONArray(r113));     // Catch: Throwable -> L55
    L58:
        if (Result.m9455isFailureimpl(r114) == false) goto L60;
        r114 = null;
    L60:
        r110 = (JSONArray) r114;     // Catch: Throwable -> L64
    L55:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L64
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L58
    L23:
        if (StringsKt.isBlank(r101) == true) goto L26;
        r107 = false;
    L64:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L67
    L73:
        return MapsKt.emptyMap();
    L74:
        e r117 = this.dataHolder;
        if (r117 != null) goto L137;
        JSBridgeManager r118 = getJSBridgeManger();
        if (r118 == null) goto L81;
        r117 = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).z0(r118, r100);
        if (r117 == null) goto L81;
        this.dataHolder = r117;
    L82:
        if (r117 != null) goto L137;
        return MapsKt.emptyMap();
    L81:
        r117 = null;
    L137:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L129
        if (r101 != null) goto L88;
    L91:
        boolean r120 = true;
    L93:
        if ((!r120) == true) goto L96;
        r101 = null;
    L96:
        if (r101 == null) goto L116;
        String r121 = UriProtector.getQueryParameter(UriProtector.parse(r101), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L129
        if (r121 == null) goto L116;
        Object r122 = Result.m9449constructorimpl(new JSONArray(r121));     // Catch: Throwable -> L101
    L104:
        if (Result.m9455isFailureimpl(r122) == false) goto L106;
        r122 = null;
    L106:
        JSONArray r123 = (JSONArray) r122;     // Catch: Throwable -> L129
        if (r123 == null) goto L116;
        if (r123.length() <= 0) goto L111;
        r102 = true;
    L111:
        if (r102 == true) goto L114;
        r123 = null;
    L114:
        if (r123 == null) goto L116;
    L127:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L129
    L132:
        if (Result.m9455isFailureimpl(r124) == true) goto L135;
        r104 = r124;
    L135:
        r117.b(r100, (JSONArray) r104, new AnonymousClass2(this));
        return r117.a();
    L101:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L129
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
    L116:
        String r126 = UriProtector.getQueryParameter(UriProtector.parse(r100), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L129
        if (r126 != null) goto L141;
        r123 = null;
        goto L127
    L141:
        Object r127 = Result.m9449constructorimpl(new JSONArray(r126));     // Catch: Throwable -> L120
    L123:
        if (Result.m9455isFailureimpl(r127) == false) goto L125;
        r127 = null;
    L125:
        r123 = (JSONArray) r127;     // Catch: Throwable -> L129
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L129
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L123
    L88:
        if (StringsKt.isBlank(r101) == true) goto L91;
        r120 = false;
    L129:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L132
    L15:
        return MapsKt.emptyMap();
    L11:
        return MapsKt.emptyMap();
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void registerMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        JSBridgeManager r102 = getJSBridgeManger();
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }

    public <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Annie.registerService(r100, r101, getBizKey());
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        JSBridgeManager r102 = getJSBridgeManger();
        if (r102 == null) goto L6;
        r102.sendJSEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <P, R> void registerMethod(String r100, g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        JSBridgeManager r102 = getJSBridgeManger();
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }

    public /* synthetic */ BaseHybridComponent(com.bytedance.android.annie.param.a r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

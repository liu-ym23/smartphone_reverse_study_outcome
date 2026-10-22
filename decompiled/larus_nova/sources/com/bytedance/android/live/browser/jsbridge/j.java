package com.bytedance.android.live.browser.jsbridge;

import android.app.Activity;
import android.webkit.GeolocationPermissions;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j implements IJsBridgeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y6.c f63222a;

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final ILiveHybridContainer getContainer() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void onGeolocationPermissionsHidePrompt() {
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void onGeolocationPermissionsShowPrompt(String r100, GeolocationPermissions.Callback r101) {
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void registerFromFactory(BaseJsBridgeMethodFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void unregisterFromFactory(BaseJsBridgeMethodFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public Activity getActivity() {
        return this.f63222a.getActivity();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final IJsBridgeMethodFactory getExposedMethodFactory() {
        return new l();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final com.bytedance.ies.web.jsbridge2.d0 getJsBridge2() {
        return this.f63222a.d();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final List<String> getMethodNameList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final com.bytedance.ies.web.jsbridge2.f0 getSupportJsBridge() {
        return this.f63222a.a();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> registerDefaultStatefulMethods() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> registerDefaultStatelessMethods() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void release() {
        this.f63222a.release();
    }

    public j(y6.c r100) {
        this.f63222a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f63222a.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f63222a.sendJSEvent(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f63222a.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager
    public final void registerMethod(String r100, n56.c r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f63222a.registerMethod(r100, r101);
    }
}

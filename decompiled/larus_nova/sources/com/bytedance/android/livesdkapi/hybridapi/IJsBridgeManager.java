package com.bytedance.android.livesdkapi.hybridapi;

import android.app.Activity;
import android.webkit.GeolocationPermissions;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import n56.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J0\u0010\u0017\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015H&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001aH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u001fH&J\u001c\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00150\u001fH&R\u0016\u0010%\u001a\u0004\u0018\u00010\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "data", "", "sendJsEvent", "(Ljava/lang/String;Ljava/lang/Object;)V", "release", PlayerResolution.SDKKEY.ORIGIN, "Landroid/webkit/GeolocationPermissions$Callback;", "callback", "onGeolocationPermissionsShowPrompt", "onGeolocationPermissionsHidePrompt", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "registerFromFactory", "unregisterFromFactory", "P", "R", "Lcom/bytedance/ies/web/jsbridge2/g;", e.f25671s, "registerMethod", "Lcom/bytedance/ies/web/jsbridge2/f$b;", ShortVideoSegments.KEY_PROP_PROVIDER, "Ln56/c;", "", "getMethodNameList", "Lcom/bytedance/android/livesdkapi/hybridapi/ILiveHybridContainer;", "getContainer", "", "registerDefaultStatefulMethods", "registerDefaultStatelessMethods", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "Lcom/bytedance/ies/web/jsbridge2/d0;", "getJsBridge2", "()Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/ies/web/jsbridge2/f0;", "getSupportJsBridge", "()Lcom/bytedance/ies/web/jsbridge2/f0;", "supportJsBridge", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeMethodFactory;", "getExposedMethodFactory", "()Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeMethodFactory;", "exposedMethodFactory", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsBridgeManager {
    Activity getActivity();

    ILiveHybridContainer getContainer();

    IJsBridgeMethodFactory getExposedMethodFactory();

    d0 getJsBridge2();

    List<String> getMethodNameList();

    f0 getSupportJsBridge();

    void onGeolocationPermissionsHidePrompt();

    void onGeolocationPermissionsShowPrompt(String r100, GeolocationPermissions.Callback r101);

    Map<String, f.b> registerDefaultStatefulMethods();

    Map<String, g<?, ?>> registerDefaultStatelessMethods();

    void registerFromFactory(BaseJsBridgeMethodFactory r100);

    void registerMethod(String r100, f.b r101);

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void registerMethod(String r100, c r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);

    void unregisterFromFactory(BaseJsBridgeMethodFactory r100);
}

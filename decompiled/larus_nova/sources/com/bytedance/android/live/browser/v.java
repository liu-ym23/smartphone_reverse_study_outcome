package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.jsbridge.newmethods.d2;
import com.bytedance.android.live.browser.jsbridge.newmethods.e2;
import com.bytedance.android.live.browser.jsbridge.newmethods.u4;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public interface v {
    com.bytedance.android.live.browser.jsbridge.i.d a(String r100, JSBridgeManager r101);

    Observable b(a0 r100);

    IJsBridgeManager c(ILiveHybridContainer r100, kl0.c r101);

    IJsBridgeManager createJsBridgeManager(Activity r100, com.bytedance.ies.web.jsbridge2.b r101, int r102);

    d2 d(HybridDialog r100);

    e2 e(HybridDialog r100);

    Collection<BaseJsBridgeMethodFactory> getFactoryCollection();

    List<String> getSafeHostList();

    w30.a getStorageProcessor(Context r100);

    void initPermissionCheck();

    void initTTLiveSdkJsb();

    <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass();

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideClipMethod(View r100);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101);

    Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r100);

    u4 provideGetLiveNtpTimeMethod(DataCenter r100);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r100);

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r100);

    com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r100);

    Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r100);

    void registerDataShare();

    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r100);

    Observable<SubscriberJsEvent> registerJsEventSubscriber(String r100);

    void registerMatchShareMethods();

    void registerState();

    void registerXBridgeMethods(y6.c r100, String r101);

    <T> void sendEventToAllJsBridges(String r100, T r101);
}

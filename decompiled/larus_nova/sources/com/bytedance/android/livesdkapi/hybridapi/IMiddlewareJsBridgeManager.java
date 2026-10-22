package com.bytedance.android.livesdkapi.hybridapi;

import android.app.Activity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J>\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/hybridapi/IMiddlewareJsBridgeManager;", "", "Lcom/bytedance/android/livesdkapi/hybridapi/ILiveHybridContainer;", KtvSubElement.CONTAINER, "Landroid/app/Activity;", "activity", "Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "jsBridgeManager", "", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "registerDefaultStatefulMethods", "Lcom/bytedance/ies/web/jsbridge2/g;", "registerDefaultStatelessMethods", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareJsBridgeManager {
    Map<String, f.b> registerDefaultStatefulMethods(ILiveHybridContainer r100, Activity r101, d0 r102, IJsBridgeManager r103);

    Map<String, g<?, ?>> registerDefaultStatelessMethods(ILiveHybridContainer r100, Activity r101, d0 r102, IJsBridgeManager r103);
}

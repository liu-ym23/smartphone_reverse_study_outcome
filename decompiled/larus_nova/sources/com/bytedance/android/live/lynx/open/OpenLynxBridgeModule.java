package com.bytedance.android.live.lynx.open;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/lynx/open/OpenLynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "func", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "", NotificationCompat.CATEGORY_CALL, "Lorg/json/JSONObject;", "data", "Lcom/bytedance/ies/web/jsbridge2/c0;", "invokeCallback$livehybrid_impl_saasRelease", "(Lorg/json/JSONObject;Lcom/bytedance/ies/web/jsbridge2/c0;)V", "invokeCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "callRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/live/lynx/open/a;", "bridgeImpl", "Lcom/bytedance/android/live/lynx/open/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenLynxBridgeModule extends LynxModule {
    private final a bridgeImpl;
    private final ConcurrentHashMap<c0, Callback> callRegistry;

    public OpenLynxBridgeModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
        super(r100);
        this.callRegistry = new ConcurrentHashMap();
        if ((r101 instanceof a) == true) goto L5;
        r101 = null;
    L5:
        a r102 = (a) r101;
        this.bridgeImpl = r102;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r102.f82628n = this;
        return;
    }

    public final void invokeCallback$livehybrid_impl_saasRelease(JSONObject r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_CALL);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Callback r103 = this.callRegistry.remove(r101);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        Object[] r104 = new Object[1];     // Catch: Throwable -> L14
        Object r105 = r100.remove("__params");     // Catch: Throwable -> L14
        if (r105 != null) goto L8;
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r104[0] = kl0.b.d(r100);     // Catch: Throwable -> L14
        r103.invoke(r104);     // Catch: Throwable -> L14
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L14
        return;
    L8:
        if ((r105 instanceof JSONObject) == false) goto L10;
        ((JSONObject) r105).remove("__data");     // Catch: Throwable -> L14
        ((JSONObject) r105).remove("__msg_type");     // Catch: Throwable -> L14
        ((JSONObject) r105).remove("__callback_id");     // Catch: Throwable -> L14
        r100.put("code", ((JSONObject) r105).remove("code"));     // Catch: Throwable -> L14
        r100.put("data", r105);     // Catch: Throwable -> L14
        goto L10
    L11:
        r107 = null;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @LynxMethod
    public final void call(String r100, ReadableMap r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "func");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r104 = kl0.b.b(r101);     // Catch: Throwable -> L14
        a r105 = this.bridgeImpl;     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        JSONObject r106 = r104.optJSONObject("data");     // Catch: Throwable -> L14
        if (r106 == null) goto L9;
        String r107 = r106.toString();     // Catch: Throwable -> L14
        if (r107 == null) goto L9;
    L10:
        c0 r108 = r105.r(r100, r107, r104.optString("namespace", "webcast"), r104.optString(com.heytap.mcssdk.constant.b.f276361k, "lynx"));     // Catch: Throwable -> L14
        this.callRegistry.put(r108, r102);     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L14
        return;
    L9:
        r107 = SliceInitService.DEFAULT_SWITCH;
        goto L10
    L11:
        r108 = null;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}

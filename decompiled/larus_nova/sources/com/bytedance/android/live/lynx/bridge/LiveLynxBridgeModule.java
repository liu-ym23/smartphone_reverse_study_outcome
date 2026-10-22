package com.bytedance.android.live.lynx.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kl0.b;
import kl0.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/lynx/bridge/LiveLynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "func", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "", NotificationCompat.CATEGORY_CALL, "Lorg/json/JSONObject;", "data", "Lcom/bytedance/ies/web/jsbridge2/c0;", "invokeCallback$livehybrid_impl_saasRelease", "(Lorg/json/JSONObject;Lcom/bytedance/ies/web/jsbridge2/c0;)V", "invokeCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "callRegistry", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkl0/c;", "bridgeImpl", "Lkl0/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLynxBridgeModule extends LynxModule {
    private final c bridgeImpl;
    private final ConcurrentHashMap<c0, Callback> callRegistry;

    public static final /* synthetic */ ConcurrentHashMap access$getCallRegistry$p(LiveLynxBridgeModule r100) {
        return r100.callRegistry;
    }

    public LiveLynxBridgeModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
        super(r100);
        this.callRegistry = new ConcurrentHashMap();
        if ((r101 instanceof c) == true) goto L5;
        r101 = null;
    L5:
        c r102 = (c) r101;
        this.bridgeImpl = r102;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r102.f503838n = this;
        return;
    }

    public final void invokeCallback$livehybrid_impl_saasRelease(JSONObject r100, c0 r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        Object r102 = r100.remove("__params");     // Catch: Throwable -> L19
        if (r102 != null) goto L6;
    L13:
        WritableMap r103 = b.d(r100);     // Catch: Throwable -> L19
        Callback r111 = this.callRegistry.remove(r110);     // Catch: Throwable -> L19
        if (r111 == null) goto L16;
        r111.invoke(new Object[]{r103});     // Catch: Throwable -> L19
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L19
        return;
    L16:
        r104 = null;
        goto L17
    L6:
        if ((r102 instanceof JSONObject) == false) goto L13;
        ((JSONObject) r102).remove("__data");     // Catch: Throwable -> L19
        ((JSONObject) r102).remove("__msg_type");     // Catch: Throwable -> L19
        r100.put(com.heytap.mcssdk.constant.b.f276361k, CastLongProtector.parseLong(((JSONObject) r102).optString("__callback_id", "0")));     // Catch: Throwable -> L19
        if (((JSONObject) r102).has("___error___") == false) goto L11;
        r100.put("code", 0);     // Catch: Throwable -> L19
        r100.put("errMsg", ((JSONObject) r102).remove("___error___"));     // Catch: Throwable -> L19
    L12:
        r100.put("data", r102);     // Catch: Throwable -> L19
        goto L13
    L11:
        r100.put("code", ((JSONObject) r102).remove("code"));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @LynxMethod
    public final void call(String r100, ReadableMap r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "func");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r104 = b.b(r101);     // Catch: Throwable -> L14
        c r105 = this.bridgeImpl;     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        JSONObject r106 = r104.optJSONObject("data");     // Catch: Throwable -> L14
        if (r106 == null) goto L9;
        String r107 = r106.toString();     // Catch: Throwable -> L14
        if (r107 == null) goto L9;
    L10:
        String r108 = r104.optString("namespace", "webcast");     // Catch: Throwable -> L14
        String r109 = r104.optString(com.heytap.mcssdk.constant.b.f276361k, "0");     // Catch: Throwable -> L14
        c0.a r110 = c0.a();     // Catch: Throwable -> L14
        r110.f249329c = r100;     // Catch: Throwable -> L14
        r110.f249330d = r107;     // Catch: Throwable -> L14
        r110.f249331e = r109;     // Catch: Throwable -> L14
        r110.f249332f = r108;     // Catch: Throwable -> L14
        c0 r111 = r110.a();     // Catch: Throwable -> L14
        access$getCallRegistry$p(this).put(r111, r102);     // Catch: Throwable -> L14
        int r112 = c.f503837r;     // Catch: Throwable -> L14
        r105.o(r111);     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r111);     // Catch: Throwable -> L14
        return;
    L9:
        r107 = SliceInitService.DEFAULT_SWITCH;
        goto L10
    L11:
        r111 = null;
    L14:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}

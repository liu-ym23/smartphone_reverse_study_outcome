package com.bytedance.applet.aibridge;

import android.os.Looper;
import aw3.l0;
import aw3.m0;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\f*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0010*\u00020\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010!H\u0002J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0010*\u00020!2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020!2\u0006\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020(*\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050*H\u0002¨\u0006,"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeBackgroundAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioResultModel;", "handleOnMainThread", "callbackWithCommandResult", "action", "", "result", "Lcom/bytedance/applet/audio/background/BackgroundAudioCommandResult;", "callbackFailure", "error", "Lcom/bytedance/applet/audio/background/BackgroundAudioError;", "toApiErr", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "requiresAppletId", "", "emptyResultModel", "toResultModel", "Lcom/bytedance/applet/audio/background/BackgroundAudioState;", IFlowAppIntentIDL.PARAM_APPLET_ID, "resolveAppletId", "toStateUpdate", "Lcom/bytedance/applet/audio/background/BackgroundAudioStateUpdate;", "Lorg/json/JSONObject;", "stringOrNull", "key", "doubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "toErrorData", "Lcom/google/gson/JsonObject;", "runOnMainThread", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeBackgroundAudioMethod extends AbsAIBridgeBackgroundAudioMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f190836b = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190837a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ContainerType.EMBED_WEB_VIEW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ContainerType.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f190837a = r100;
        }
    }

    static {
    }

    public AIBridgeBackgroundAudioMethod() {
    }

    public final Double d(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L15:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L15;
        Double r102 = Double.valueOf(r100.optDouble(r101));
        double r103 = r102.doubleValue();
        if (Double.isInfinite(r103) == false) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        return r102;
    L10:
        if (Double.isNaN(r103) == true) goto L12;
        r104 = true;
        goto L13
    }

    public final String e(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L7:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L7;
        return r100.optString(r101);
    }

    public static void b(String r100, m0 r101, f3.h r102) {
        int r103 = r101.f16456a;
        if (r103 != (-1007)) goto L5;
    L9:
        f3.a r104 = f3.a.f475267h;
    L10:
        FLogger.f375446a.e("AIBridgeBackgroundAudioMethod", "call failed, errNo=" + r104.f475285a + ", bizErrNo=" + r101.f16456a + ", action=" + r100 + ", msg=" + r101.f16457b);
        String r105 = r101.f16457b;
        JsonObject r106 = new JsonObject();
        r106.addProperty("errCode", Integer.valueOf(r101.f16456a));
        r106.addProperty("errMsg", r101.f16457b);
        f3.h.a.a(r102, r105, r104, r106, 2);
        return;
    L5:
        if (r103 == (-1006)) goto L9;
        if (r103 == (-1001)) goto L9;
        r104 = f3.a.f475265f;
        goto L10
    }

    public static void c(String r100, l0 r101, f3.h r102) {
        m0 r103 = r101.f16444b;
        if (r103 != null) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        FLogger.f375446a.i("AIBridgeBackgroundAudioMethod", "call success, action=".concat(r100));
        Intrinsics.checkNotNullParameter(AbsAIBridgeBackgroundAudioMethodIDL.b.class, "<this>");
        r102.b((AbsAIBridgeBackgroundAudioMethodIDL.b) k3.c.a(AbsAIBridgeBackgroundAudioMethodIDL.b.class), "");
        return;
    L9:
        if (r103 != null) goto L11;
        r103 = m0.f16451f;
    L11:
        b(r100, r103, r102);
        return;
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.c] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r100, ParamModel r101, final f3.h r102) {
        final AbsAIBridgeBackgroundAudioMethodIDL.a r103 = (AbsAIBridgeBackgroundAudioMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        final ?? r104 = new c(this, r100, r103, r102);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r104.invoke();
        return;
    L5:
        y.c(new d(r104));
    }
}

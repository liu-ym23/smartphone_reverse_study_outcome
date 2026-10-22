package com.bytedance.applet.aibridge;

import android.os.Looper;
import bw3.h0;
import bw3.w;
import bw3.x;
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
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J8\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0016\u0010\u001e\u001a\u00020\f*\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010 \u001a\u0004\u0018\u00010\u0010*\u00020\u0007H\u0002J\u000e\u0010!\u001a\u00020\"*\u0004\u0018\u00010#H\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010\u0010*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u001b\u0010&\u001a\u0004\u0018\u00010'*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010(J\u001b\u0010)\u001a\u0004\u0018\u00010\u001c*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020,*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0016\u0010-\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0002¨\u00060"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeInnerAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioResultModel;", "handleOnMainThread", "callbackWithStateResult", "action", "", "result", "Lcom/bytedance/applet/audio/inner/InnerAudioCommandResult;", "audioId", IFlowAppIntentIDL.PARAM_APPLET_ID, "callbackWithCommandResult", "callbackFailure", "error", "Lcom/bytedance/applet/audio/inner/InnerAudioError;", "toApiErr", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "requiresAppletId", "", "emptyResultModel", "toResultModel", "Lcom/bytedance/applet/audio/inner/InnerAudioState;", "resolveAppletId", "toStateUpdate", "Lcom/bytedance/applet/audio/inner/InnerAudioStateUpdate;", "Lorg/json/JSONObject;", "stringOrNull", "key", "doubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "booleanOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "toErrorData", "Lcom/google/gson/JsonObject;", "runOnMainThread", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeInnerAudioMethod extends AbsAIBridgeInnerAudioMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f190838b = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190839a = null;

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
            f190839a = r100;
        }
    }

    static {
    }

    public AIBridgeInnerAudioMethod() {
    }

    public static AbsAIBridgeInnerAudioMethodIDL.b e(h0 r100, String r101) {
        Intrinsics.checkNotNullParameter(AbsAIBridgeInnerAudioMethodIDL.b.class, "<this>");
        AbsAIBridgeInnerAudioMethodIDL.b r102 = (AbsAIBridgeInnerAudioMethodIDL.b) k3.c.a(AbsAIBridgeInnerAudioMethodIDL.b.class);
        r102.setAudioId(r100.f21079a);
        r102.setSrc(r100.f21080b);
        r102.setStartTime(Double.valueOf(r100.f21084f));
        r102.setAutoplay(Boolean.valueOf(r100.f21081c));
        r102.setLoop(Boolean.valueOf(r100.f21082d));
        r102.setVolume(Double.valueOf(r100.f21089k));
        r102.setPlaybackRate(Double.valueOf(r100.f21090l));
        r102.setCurrentTime(Double.valueOf(r100.f21085g));
        r102.setDuration(Double.valueOf(r100.f21086h));
        r102.setPaused(Boolean.valueOf(r100.f21087i));
        r102.setBuffered(Double.valueOf(r100.f21088j));
        r102.setAppletId(r101);
        return r102;
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

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.e] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r100, ParamModel r101, final f3.h r102) {
        final AbsAIBridgeInnerAudioMethodIDL.a r103 = (AbsAIBridgeInnerAudioMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        final ?? r104 = new e(this, r100, r103, r102);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r104.invoke();
        return;
    L5:
        y.c(new f(r104));
    }

    public static void b(String r100, x r101, String r102, f3.h r103) {
        int r104 = r101.f21136a;
        if (r104 != x.f21133i.f21136a) goto L5;
    L17:
        f3.a r105 = f3.a.f475267h;
    L18:
        FLogger.f375446a.e("AIBridgeInnerAudioMethod", "call failed, errNo=" + r105.f475285a + ", bizErrNo=" + r101.f21136a + ", action=" + r100 + ", audioId=" + r102 + ", msg=" + r101.f21137b);
        String r106 = r101.f21137b;
        JsonObject r107 = new JsonObject();
        r107.addProperty("audioId", r102);
        r107.addProperty("errCode", Integer.valueOf(r101.f21136a));
        r107.addProperty("errMsg", r101.f21137b);
        f3.h.a.a(r103, r106, r105, r107, 2);
        return;
    L5:
        if (r104 == x.f21129e.f21136a) goto L17;
        if (r104 == x.f21130f.f21136a) goto L17;
        if (r104 == x.f21134j.f21136a) goto L17;
        if (r104 == x.f21135k.f21136a) goto L17;
        if (r104 != x.f21128d.f21136a) goto L16;
        r105 = f3.a.f475276q;
        goto L18
    L16:
        r105 = f3.a.f475265f;
        goto L18
    }

    public static void c(String r100, w r101, String r102, f3.h r103) {
        if (r101.a() == false) goto L6;
        FLogger.f375446a.i("AIBridgeInnerAudioMethod", "call success, action=" + r100 + ", audioId=" + r102);
        Intrinsics.checkNotNullParameter(AbsAIBridgeInnerAudioMethodIDL.b.class, "<this>");
        r103.b((AbsAIBridgeInnerAudioMethodIDL.b) k3.c.a(AbsAIBridgeInnerAudioMethodIDL.b.class), "");
        return;
    L6:
        x r104 = r101.f21126b;
        if (r104 != null) goto L9;
        r104 = x.f21131g;
    L9:
        b(r100, r104, r102, r103);
    }
}

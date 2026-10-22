package com.bytedance.applet.aibridge.login;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.platform.model.TriggerLoginScene;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/login/OpenLoginPanelMethod;", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL$LoginParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/login/AbsOpenLoginPanelMethodIDL$LoginResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLoginPanelMethod extends AbsOpenLoginPanelMethodIDL {
    public OpenLoginPanelMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.bytedance.applet.aibridge.login.a, tj9.b] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        AbsOpenLoginPanelMethodIDL.a r103 = (AbsOpenLoginPanelMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        JSONObject r104 = r103.getTraceInfo();     // Catch: Exception -> L17
        if (r104 == null) goto L7;
        String r105 = r104.optString("enter_from", "");     // Catch: Exception -> L17
    L9:
        if (Intrinsics.areEqual(r105, "first_application_music_query") == false) goto L12;
        TriggerLoginScene r106 = TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY;     // Catch: Exception -> L17
    L15:
        b r107 = new b(r103);     // Catch: Exception -> L17
        Ref.ObjectRef r108 = new Ref.ObjectRef();     // Catch: Exception -> L17
        ?? r109 = new a(r107, r108);     // Catch: Exception -> L17
        r108.element = r109;     // Catch: Exception -> L17
        TouristManager r110 = TouristManager.f357001a;     // Catch: Exception -> L17
        r110.s(r109);     // Catch: Exception -> L17
        ITouristApi.a.a(r110, r106, false, 2);     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(AbsOpenLoginPanelMethodIDL.b.class, "<this>");     // Catch: Exception -> L17
        r102.b((ResultModel) c.a(AbsOpenLoginPanelMethodIDL.b.class), "");     // Catch: Exception -> L17
        return;
    L12:
        if (Intrinsics.areEqual(r105, "first_application_music_history_click") == false) goto L14;
        r106 = TriggerLoginScene.TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK;     // Catch: Exception -> L17
        goto L15
    L14:
        r106 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;     // Catch: Exception -> L17
        goto L15
    L7:
        r105 = null;
    L17:
        h.a.a(r102, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, null, null, 14);
    }
}

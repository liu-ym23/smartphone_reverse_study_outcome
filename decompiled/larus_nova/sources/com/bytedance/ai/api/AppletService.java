package com.bytedance.ai.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.assistant.interaction.impl.AssistantInteractionService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\r\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&JA\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00142#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H&Jh\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#H&J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H&J\n\u0010(\u001a\u0004\u0018\u00010\tH&J\u001c\u0010)\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,0+\u0018\u00010*H&J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0005H&J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\t02H&J\b\u00103\u001a\u00020\tH&J\"\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u0003H\u0016¨\u0006:"}, d2 = {"Lcom/bytedance/ai/api/AppletService;", "", "isInitialized", "", "init", "", "application", "Landroid/app/Application;", "bid", "", "isDebug", "geckoConfigs", "Lcom/ivy/ivykit/base/resource/GeckoConfigs;", "ensureInitialized", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAppletAppContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SendEventContainerMethodParamModel.EventKinds.openPage, "data", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "runApplet", IFlowAppIntentIDL.PARAM_APPLET_ID, "conversationID", "botId", RemoteMessageConst.MSGID, "replyFor", "traceInfo", "", "runAppletResult", "Lkotlin/Function0;", "publishEvent", "eventKey", "eventJson", "Lcom/google/gson/JsonObject;", "getCurDeepResearchResourceId", "getEventFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "addAppActionListener", "listener", "Lcom/bytedance/ai/api/IActionListener;", "notifyChatWillReady", "getAlarmListWithKeepStatus", "", "getGeckoEnv", "consumeBusinessDeepLink", "activity", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "finishAfterConsume", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletService {
    void a(String r100, JsonObject r101);

    boolean b(Activity r100, Uri r101, boolean r102);

    void c(String r100, String r101, Context r102, String r103, String r104, Map r105, Function0 r106);

    List<String> d();

    void e();

    void f(Map<String, ? extends Object> r100, Function1<? super Boolean, Unit> r101);

    boolean g(Context r100);

    i1<Pair<String, JSONObject>> getEventFlow();

    void h(Application r100, String r101, boolean r102, pg9.b r103);

    String i();

    boolean isInitialized();

    Object j(Continuation<? super Unit> r100);

    String k();

    void l(AssistantInteractionService.C116191 r100);
}

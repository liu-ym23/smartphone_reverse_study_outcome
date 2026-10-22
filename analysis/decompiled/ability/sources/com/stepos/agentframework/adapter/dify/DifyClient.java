package com.stepos.agentframework.adapter.dify;

import C7.f;
import C7.r;
import F9.AbstractC0226d;
import F9.B;
import F9.F;
import F9.I;
import F9.J;
import F9.K;
import F9.M;
import F9.P;
import H7.c;
import J9.i;
import android.content.Context;
import android.provider.Settings;
import android.util.Patterns;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.dify.bean.ChatEventData;
import com.stepos.agentframework.adapter.dify.bean.ChatRequestBody;
import com.stepos.agentframework.adapter.dify.bean.ErrorResult;
import com.stepos.agentframework.adapter.dify.bean.Event;
import com.stepos.agentframework.adapter.dify.bean.LikeBody;
import com.stepos.agentframework.adapter.dify.bean.SuggestResult;
import com.stepos.agentframework.adapter.dify.callback.EventListener;
import com.stepos.agentframework.adapter.dify.log.Logger;
import com.stepos.statsrpk.d;
import io.modelcontextprotocol.spec.HttpHeaders;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J)\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015JO\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJQ\u0010 \u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b'\u0010(J\"\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001f\u00105\u001a\n 4*\u0004\u0018\u000103038\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u00109¨\u0006;"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/DifyClient;", "", AppAgent.CONSTRUCT, "()V", "", "generateId", "()Ljava/lang/String;", "getUserId", "Landroid/content/Context;", "context", "", "timeOut", BffConstant.Type.Url, "LC7/r;", "init", "(Landroid/content/Context;JLjava/lang/String;)V", "secretKey", "messageId", "isLike", "userId", "feedbacks", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "input", "query", "conversationId", "tag", "Lcom/stepos/agentframework/adapter/dify/callback/EventListener;", "callback", "LR9/a;", "requestCompletionStreaming", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/stepos/agentframework/adapter/dify/callback/EventListener;)LR9/a;", "requestChatStreaming", "LU9/a;", "eventSource", "cancel", "(LU9/a;)V", "getAndroid_ID", "(Landroid/content/Context;)Ljava/lang/String;", "md5", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/dify/bean/SuggestResult;", "getSuggested", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/dify/NetImpl;", "netImpl", "Lcom/stepos/agentframework/adapter/dify/NetImpl;", "getNetImpl", "()Lcom/stepos/agentframework/adapter/dify/NetImpl;", "setNetImpl", "(Lcom/stepos/agentframework/adapter/dify/NetImpl;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Landroid/content/Context;", "Companion", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DifyClient {
    public static final String BEARER = " Bearer";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String URL = "https://api.dify.ai/";
    private static final f instance$delegate = a.b(LazyThreadSafetyMode.f4885a, new com.stepos.ability.voicewakeup.service.f(2));
    private Context context;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    public NetImpl netImpl;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR!\u0010\u0010\u001a\u00020\n8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/DifyClient$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "URL", "Ljava/lang/String;", "getURL", "()Ljava/lang/String;", "getURL$annotations", "Lcom/stepos/agentframework/adapter/dify/DifyClient;", "instance$delegate", "LC7/f;", "getInstance", "()Lcom/stepos/agentframework/adapter/dify/DifyClient;", "getInstance$annotations", "instance", "BEARER", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void getInstance$annotations() {
        }

        public static /* synthetic */ void getURL$annotations() {
        }

        public final DifyClient getInstance() {
            return (DifyClient) DifyClient.instance$delegate.getF4884a();
        }

        public final String getURL() {
            return DifyClient.URL;
        }

        private Companion() {
        }
    }

    private final String generateId() {
        String string = UUID.randomUUID().toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static final DifyClient getInstance() {
        return INSTANCE.getInstance();
    }

    public static final String getURL() {
        return INSTANCE.getURL();
    }

    private final String getUserId() {
        Context context = this.context;
        if (context != null) {
            return md5(getAndroid_ID(context));
        }
        k.n("context");
        throw null;
    }

    public static /* synthetic */ void init$default(DifyClient difyClient, Context context, long j5, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 200;
        }
        if ((i & 4) != 0) {
            str = URL;
        }
        difyClient.init(context, j5, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DifyClient instance_delegate$lambda$0() {
        return new DifyClient();
    }

    public static /* synthetic */ R9.a requestChatStreaming$default(DifyClient difyClient, String str, Map map, String str2, String str3, Object obj, EventListener eventListener, int i, Object obj2) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        if ((i & 16) != 0) {
            obj = "";
        }
        return difyClient.requestChatStreaming(str, map, str2, str3, obj, eventListener);
    }

    public static /* synthetic */ R9.a requestCompletionStreaming$default(DifyClient difyClient, String str, Map map, String str2, String str3, Object obj, EventListener eventListener, int i, Object obj2) {
        if ((i & 8) != 0) {
            str3 = "";
        }
        if ((i & 16) != 0) {
            obj = "";
        }
        return difyClient.requestCompletionStreaming(str, map, str2, str3, obj, eventListener);
    }

    public final void cancel(U9.a eventSource) {
        if (eventSource != null) {
            i iVar = ((R9.a) eventSource).f1160a;
            if (iVar != null) {
                iVar.cancel();
            } else {
                k.n("call");
                throw null;
            }
        }
    }

    public final Object feedbacks(String str, String str2, String str3, String str4, c<? super r> cVar) {
        Api api = (Api) getNetImpl().create(Api.class);
        String strK = B7.a.k(" Bearer ", str);
        LikeBody likeBody = new LikeBody();
        likeBody.setRating(str3);
        likeBody.setUser(str4);
        Object objFeedbacks = api.feedbacks(strK, str2, likeBody, cVar);
        return objFeedbacks == CoroutineSingletons.f4909a ? objFeedbacks : r.f317a;
    }

    public final String getAndroid_ID(Context context) {
        k.f(context, "context");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        k.e(string, "getString(...)");
        return string;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final NetImpl getNetImpl() {
        NetImpl netImpl = this.netImpl;
        if (netImpl != null) {
            return netImpl;
        }
        k.n("netImpl");
        throw null;
    }

    public final Object getSuggested(String str, String str2, c<? super SuggestResult> cVar) {
        return ((Api) getNetImpl().create(Api.class)).suggested(" Bearer " + str, str2, cVar);
    }

    public final void init(Context context, long timeOut, String url) {
        k.f(context, "context");
        k.f(url, "url");
        setNetImpl(new NetImpl(url, timeOut));
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
    }

    public final String md5(String str) throws NoSuchAlgorithmException {
        k.f(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            k.e(messageDigest, "getInstance(...)");
            byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
            k.e(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            k.e(bArrDigest, "digest(...)");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            String string = stringBuffer.toString();
            k.e(string, "toString(...)");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final R9.a requestChatStreaming(String secretKey, Map<String, String> input, String query, String conversationId, final Object tag, final EventListener callback) throws Exception {
        k.f(secretKey, "secretKey");
        k.f(query, "query");
        k.f(conversationId, "conversationId");
        k.f(tag, "tag");
        k.f(callback, "callback");
        F okHttpClient = getNetImpl().getOkHttpClient();
        k.c(okHttpClient);
        Gson gson = new Gson();
        ChatRequestBody.Companion companion = ChatRequestBody.INSTANCE;
        if (input == null) {
            input = new HashMap<>();
        }
        String json = gson.toJson(companion.inputStreaming(input, query, conversationId, getUserId()));
        Logger logger = Logger.INSTANCE;
        Logger.i$default(logger, B7.a.k("postJson  ", json), null, 2, null);
        J j5 = K.Companion;
        Pattern pattern = B.e;
        B bJ = AbstractC0226d.j("application/json");
        k.c(json);
        j5.getClass();
        I iB = J.b(json, bJ);
        String strL = androidx.appfunctions.metadata.a.l(getNetImpl().getBaseUrl(), "v1/chat-messages");
        Logger.i$default(logger, B7.a.n("requestChatStreaming  ", strL, "  ", json), null, 2, null);
        if (!Patterns.WEB_URL.matcher(strL).matches()) {
            throw new Exception(B7.a.k("url exception:  ", strL));
        }
        K1.a aVar = new K1.a();
        aVar.s(strL);
        aVar.i(iB);
        aVar.b(HttpHeaders.CONTENT_TYPE, "application/json");
        aVar.b("Authorization", " Bearer ".concat(secretKey));
        R9.a aVar2 = new R9.a(aVar.d(), new d() { // from class: com.stepos.agentframework.adapter.dify.DifyClient$requestChatStreaming$realEventSource$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Event.values().length];
                    try {
                        iArr[Event.MESSAGE_END.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Event.MESSAGE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Event.AGENT_MESSAGE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Event.MESSAGE_REPLACE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onClosed(U9.a eventSource) {
                k.f(eventSource, "eventSource");
                Logger.i$default(Logger.INSTANCE, "onClosed", null, 2, null);
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onClosed(eventSource, tag);
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onEvent(U9.a eventSource, String eventId, String type, String data) {
                ChatEventData chatEventData;
                k.f(eventSource, "eventSource");
                k.f(data, "data");
                Logger logger2 = Logger.INSTANCE;
                StringBuilder sbW = B7.a.w("onEvent eventId: ", eventId, " type: ", type, "  data:");
                sbW.append(data);
                Logger.d$default(logger2, sbW.toString(), null, 2, null);
                try {
                    chatEventData = (ChatEventData) this.this$0.getGson().fromJson(data, ChatEventData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    chatEventData = null;
                }
                Event event = chatEventData != null ? chatEventData.getEvent() : null;
                int i = event == null ? -1 : WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1 || i == 2 || i == 3 || i == 4) {
                    ChatEventData chatEventData2 = chatEventData;
                    EventListener eventListener = callback;
                    if (eventListener != null) {
                        EventListener.onEvent$default(eventListener, eventSource, chatEventData2, type, data, tag, null, 32, null);
                    }
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onFailure(U9.a eventSource, Throwable t9, M response) {
                ErrorResult errorResult;
                String message;
                P p;
                k.f(eventSource, "eventSource");
                String strG = (response == null || (p = response.g) == null) ? null : p.g();
                Logger.i$default(Logger.INSTANCE, "onFailure  " + t9 + "  " + strG, null, 2, null);
                try {
                    errorResult = (ErrorResult) this.this$0.getGson().fromJson(strG, ErrorResult.class);
                } catch (Exception unused) {
                    errorResult = null;
                }
                Logger.i$default(Logger.INSTANCE, "onFailure errorResult " + errorResult, null, 2, null);
                if (errorResult == null) {
                    ErrorResult errorResult2 = new ErrorResult(null, null, null, 7, null);
                    errorResult2.setCode("unknow");
                    if (t9 == null || (message = t9.getMessage()) == null) {
                        message = "";
                    }
                    errorResult2.setMessage(message);
                    errorResult2.setStatus(-1);
                    errorResult = errorResult2;
                }
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onFailure(eventSource, errorResult, response, tag);
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onOpen(U9.a eventSource, M response) {
                k.f(eventSource, "eventSource");
                k.f(response, "response");
                Logger.i$default(Logger.INSTANCE, "onOpen", null, 2, null);
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onOpen(eventSource, response, tag);
                }
            }
        });
        aVar2.a(okHttpClient);
        return aVar2;
    }

    public final R9.a requestCompletionStreaming(String secretKey, Map<String, String> input, String query, String conversationId, final Object tag, final EventListener callback) throws Exception {
        k.f(secretKey, "secretKey");
        k.f(query, "query");
        k.f(conversationId, "conversationId");
        k.f(tag, "tag");
        k.f(callback, "callback");
        F okHttpClient = getNetImpl().getOkHttpClient();
        String json = new Gson().toJson(ChatRequestBody.INSTANCE.inputStreaming(input, query, conversationId, getUserId()));
        J j5 = K.Companion;
        Pattern pattern = B.e;
        B bJ = AbstractC0226d.j("application/json");
        k.c(json);
        j5.getClass();
        I iB = J.b(json, bJ);
        String strL = androidx.appfunctions.metadata.a.l(getNetImpl().getBaseUrl(), "v1/completion-messages");
        Logger.i$default(Logger.INSTANCE, "bodyString  ".concat(json), null, 2, null);
        if (!Patterns.WEB_URL.matcher(strL).matches()) {
            throw new Exception(B7.a.k("url exception:  ", strL));
        }
        K1.a aVar = new K1.a();
        aVar.s(strL);
        aVar.i(iB);
        aVar.b(HttpHeaders.CONTENT_TYPE, "text/event-stream");
        aVar.b("Accept", "text/event-stream");
        aVar.b("Authorization", " Bearer ".concat(secretKey));
        R9.a aVar2 = new R9.a(aVar.d(), new d() { // from class: com.stepos.agentframework.adapter.dify.DifyClient$requestCompletionStreaming$realEventSource$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Event.values().length];
                    try {
                        iArr[Event.MESSAGE_END.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Event.MESSAGE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Event.MESSAGE_REPLACE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onClosed(U9.a eventSource) {
                k.f(eventSource, "eventSource");
                Logger.i$default(Logger.INSTANCE, "onClosed", null, 2, null);
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onClosed(eventSource, tag);
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onEvent(U9.a eventSource, String id, String type, String data) {
                ChatEventData chatEventData;
                k.f(eventSource, "eventSource");
                k.f(data, "data");
                Logger logger = Logger.INSTANCE;
                StringBuilder sbW = B7.a.w("onEvent  ", id, " ", type, "  ");
                sbW.append(data);
                Logger.i$default(logger, sbW.toString(), null, 2, null);
                try {
                    chatEventData = (ChatEventData) this.this$0.getGson().fromJson(data, ChatEventData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    chatEventData = null;
                }
                Event event = chatEventData != null ? chatEventData.getEvent() : null;
                int i = event == null ? -1 : WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    ChatEventData chatEventData2 = chatEventData;
                    EventListener eventListener = callback;
                    if (eventListener != null) {
                        EventListener.onEvent$default(eventListener, eventSource, chatEventData2, type, data, tag, null, 32, null);
                    }
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onFailure(U9.a eventSource, Throwable t9, M response) {
                ErrorResult errorResult;
                String message;
                P p;
                k.f(eventSource, "eventSource");
                String strG = (response == null || (p = response.g) == null) ? null : p.g();
                Logger logger = Logger.INSTANCE;
                Logger.i$default(logger, "onFailure  " + t9 + " ", null, 2, null);
                Logger.i$default(logger, B7.a.k("onFailure  ", strG), null, 2, null);
                try {
                    errorResult = (ErrorResult) this.this$0.getGson().fromJson(strG, ErrorResult.class);
                } catch (Exception unused) {
                    errorResult = null;
                }
                Logger.i$default(Logger.INSTANCE, "onFailure errorResult " + errorResult, null, 2, null);
                if (errorResult == null) {
                    ErrorResult errorResult2 = new ErrorResult(null, null, null, 7, null);
                    errorResult2.setCode("unknow");
                    if (t9 == null || (message = t9.getMessage()) == null) {
                        message = "";
                    }
                    errorResult2.setMessage(message);
                    errorResult2.setStatus(-1);
                    errorResult = errorResult2;
                }
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onFailure(eventSource, errorResult, response, tag);
                }
            }

            @Override // com.stepos.statsrpk.d
            public void onOpen(U9.a eventSource, M response) {
                k.f(eventSource, "eventSource");
                k.f(response, "response");
                Logger.i$default(Logger.INSTANCE, "onOpen", null, 2, null);
                EventListener eventListener = callback;
                if (eventListener != null) {
                    eventListener.onOpen(eventSource, response, tag);
                }
            }
        });
        k.c(okHttpClient);
        aVar2.a(okHttpClient);
        return aVar2;
    }

    public final void setNetImpl(NetImpl netImpl) {
        k.f(netImpl, "<set-?>");
        this.netImpl = netImpl;
    }
}

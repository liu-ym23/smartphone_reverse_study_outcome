package com.stepos.agentframework.adapter.coze;

import La.C0953c;
import Y8.h;
import Y8.t;
import Z8.C1172u;
import Z8.C1174w;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.coze.bean.AgentDetailResult;
import com.stepos.agentframework.adapter.coze.bean.CreateConversationResult;
import com.stepos.agentframework.adapter.coze.bean.Type;
import com.stepos.agentframework.adapter.netcore.s;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g4.C4102g;
import g4.C4103h;
import g4.ChatError;
import g4.ChatEventData;
import g4.CreateConversation;
import g4.Error;
import g4.ErrorResult;
import g4.Thinking;
import h4.InterfaceC4143a;
import i4.C4167a;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.AbstractC0913i;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.q;
import tb.AbstractC5531D;
import tb.C5530C;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001d\u0010\u0015JJ\u0010$\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0086@¢\u0006\u0004\b$\u0010%JJ\u0010(\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0086@¢\u0006\u0004\b(\u0010)J\u0090\u0001\u00108\u001a\u0002072\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\b\u0002\u0010/\u001a\u00020\u00012(\b\u0002\u00102\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u000100j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`12\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\u0006\u0010#\u001a\u000206H\u0086@¢\u0006\u0004\b8\u00109J#\u0010;\u001a\b\u0012\u0004\u0012\u00020:0,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b=\u0010>J\u0011\u0010?\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001f\u0010J\u001a\n I*\u0004\u0018\u00010H0H8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010N¨\u0006Q"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeClient;", "", "<init>", "()V", "", "k", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "", "timeOut", "url", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "LY8/t;", "l", "(Landroid/content/Context;JLjava/lang/String;Lcom/stepos/agentframework/adapter/netcore/p;)V", "secretKey", "botId", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "conversationId", "messageId", "isLike", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "bot_id", "Lcom/stepos/agentframework/adapter/coze/bean/CreateConversationResult;", "e", "Ljava/io/File;", Const.STR_FILE, "Lkotlin/Function3;", "", "", "callback", "t", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lp9/q;Le9/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "uri", "s", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Lp9/q;Le9/c;)Ljava/lang/Object;", "agentId", "cvId", "", "LK6/i;", "query", "tag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "toolOutputs", "chatId", "Lg4/j;", SpriteEventAction.AGENT_THINKING_START, "Lh4/a;", "LKb/a;", "p", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/util/HashMap;Ljava/lang/String;Lg4/j;Lh4/a;Le9/c;)Ljava/lang/Object;", "Lg4/i;", "o", "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Ljava/lang/String;", "n", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/coze/g;", "netImpl", "Lcom/stepos/agentframework/adapter/coze/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/agentframework/adapter/coze/g;", "r", "(Lcom/stepos/agentframework/adapter/coze/g;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/google/gson/Gson;", "Landroid/content/Context;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CozeClient {
    public static final String BEARER = " Bearer";
    private Context context;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    public g netImpl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CozeClient";
    private static final String URL = "https://api.coze.cn/";
    private static final h<CozeClient> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.coze.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CozeClient.m();
        }
    });
    private static final Set<String> conversationIds = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR!\u0010\u0010\u001a\u00020\n8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeClient$a;", "", "<init>", "()V", "", "URL", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "getURL$annotations", "Lcom/stepos/agentframework/adapter/coze/CozeClient;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/coze/CozeClient;", "getInstance$annotations", "instance", "BEARER", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeClient$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final CozeClient a() {
            return (CozeClient) CozeClient.instance$delegate.getValue();
        }

        public final String b() {
            return CozeClient.URL;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"com/stepos/agentframework/adapter/coze/CozeClient$b", "LKb/b;", "LKb/a;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30737d, "type", "data", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LKb/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LKb/a;)V", "", "t", "Ltb/C;", UxipConstants.f30685x, "c", "(LKb/a;Ljava/lang/Throwable;Ltb/C;)V", Const.INTENT_KEY_UMID, "(LKb/a;Ltb/C;)V", "", "requiredAction", "Z", "getRequiredAction", "()Z", "setRequiredAction", "(Z)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Kb.b {
        final /* synthetic */ InterfaceC4143a $callback;
        final /* synthetic */ Ref$ObjectRef<ChatEventData> $lastChatEventData;
        final /* synthetic */ ArrayList<String> $suggests;
        final /* synthetic */ Object $tag;
        final /* synthetic */ HashMap<String, Object> $toolOutputs;
        private boolean requiredAction;

        public b(InterfaceC4143a interfaceC4143a, Object obj, Ref$ObjectRef<ChatEventData> ref$ObjectRef, ArrayList<String> arrayList, HashMap<String, Object> map) {
            this.$callback = interfaceC4143a;
            this.$tag = obj;
            this.$lastChatEventData = ref$ObjectRef;
            this.$suggests = arrayList;
            this.$toolOutputs = map;
        }

        @Override // Kb.b
        public void a(Kb.a eventSource) {
            InterfaceC4143a interfaceC4143a;
            p.i(eventSource, "eventSource");
            s.INSTANCE.g("onClosed");
            if (this.requiredAction || (interfaceC4143a = this.$callback) == null) {
                return;
            }
            interfaceC4143a.a(eventSource, this.$tag);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, g4.b] */
        @Override // Kb.b
        public void b(Kb.a eventSource, String eventId, String type, String data) {
            ChatEventData chatEventData;
            T t10;
            ChatEventData chatEventData2;
            ChatError chatError;
            Error last_error;
            Error last_error2;
            p.i(eventSource, "eventSource");
            p.i(data, "data");
            s.INSTANCE.e("onEvent eventId: " + eventId + " type: " + type + "  data:" + data);
            C4102g c4102g = C4102g.INSTANCE;
            if (p.d(type, c4102g.b()) || p.d(type, c4102g.d())) {
                return;
            }
            if (p.d(type, c4102g.g())) {
                try {
                    chatEventData = (ChatEventData) CozeClient.this.getGson().fromJson(data, ChatEventData.class);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    chatEventData = null;
                }
                if ((chatEventData != null ? chatEventData.getType() : null) == Type.ANSWER) {
                    InterfaceC4143a interfaceC4143a = this.$callback;
                    if (interfaceC4143a != null) {
                        ChatEventData chatEventData3 = chatEventData;
                        InterfaceC4143a.e(interfaceC4143a, eventSource, chatEventData3, type, data, this.$tag, null, 32, null);
                        t10 = chatEventData3;
                    } else {
                        t10 = chatEventData;
                    }
                    this.$lastChatEventData.f34820a = t10;
                    return;
                }
                return;
            }
            if (p.d(type, c4102g.e())) {
                try {
                    content = (ChatEventData) CozeClient.this.getGson().fromJson(data, ChatEventData.class);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.requiredAction = true;
                InterfaceC4143a interfaceC4143a2 = this.$callback;
                ?? r42 = content;
                if (interfaceC4143a2 != null) {
                    InterfaceC4143a.e(interfaceC4143a2, eventSource, r42, type, data, this.$tag, null, 32, null);
                }
                this.$lastChatEventData.f34820a = r42;
                return;
            }
            if (p.d(type, c4102g.f())) {
                try {
                    chatEventData2 = (ChatEventData) CozeClient.this.getGson().fromJson(data, ChatEventData.class);
                } catch (Exception e12) {
                    e12.printStackTrace();
                    chatEventData2 = null;
                }
                if ((chatEventData2 != null ? chatEventData2.getType() : null) != Type.FOLLOW_UP) {
                    if ((chatEventData2 != null ? chatEventData2.getType() : null) != Type.FUNCTION_CALL) {
                        if ((chatEventData2 != null ? chatEventData2.getType() : null) != Type.TOOL_RESPONSE) {
                            return;
                        }
                    }
                    InterfaceC4143a interfaceC4143a3 = this.$callback;
                    if (interfaceC4143a3 != null) {
                        InterfaceC4143a.e(interfaceC4143a3, eventSource, chatEventData2, type, data, this.$tag, null, 32, null);
                        return;
                    }
                    return;
                }
                String content = chatEventData2 != null ? chatEventData2.getContent() : null;
                if (content == null || content.length() == 0) {
                    return;
                }
                ArrayList<String> arrayList = this.$suggests;
                content = chatEventData2 != null ? chatEventData2.getContent() : null;
                p.f(content);
                arrayList.add(content);
                return;
            }
            if (p.d(type, c4102g.a())) {
                if (this.$suggests.isEmpty()) {
                    return;
                }
                ChatEventData chatEventData4 = this.$lastChatEventData.f34820a;
                if (chatEventData4 != null) {
                    chatEventData4.i(this.$suggests);
                }
                InterfaceC4143a interfaceC4143a4 = this.$callback;
                if (interfaceC4143a4 != null) {
                    InterfaceC4143a.e(interfaceC4143a4, eventSource, this.$lastChatEventData.f34820a, type, data, this.$tag, null, 32, null);
                    return;
                }
                return;
            }
            if (p.d(type, c4102g.c())) {
                try {
                    chatError = (ChatError) CozeClient.this.getGson().fromJson(data, ChatError.class);
                } catch (Exception e13) {
                    e13.printStackTrace();
                    chatError = null;
                }
                int code = (chatError == null || (last_error2 = chatError.getLast_error()) == null) ? 10025 : last_error2.getCode();
                InterfaceC4143a interfaceC4143a5 = this.$callback;
                if (interfaceC4143a5 != null) {
                    interfaceC4143a5.d(eventSource, new ErrorResult(String.valueOf(code), (chatError == null || (last_error = chatError.getLast_error()) == null) ? null : last_error.getMsg(), Integer.valueOf(code), code), null, null);
                }
            }
        }

        @Override // Kb.b
        public void c(Kb.a eventSource, Throwable t10, C5530C response) {
            String message;
            AbstractC5531D body;
            p.i(eventSource, "eventSource");
            if (this.requiredAction) {
                return;
            }
            ErrorResult errorResult = null;
            String strA = (response == null || (body = response.getBody()) == null) ? null : body.A();
            s.INSTANCE.g("onFailure  " + t10 + "  " + strA);
            try {
                errorResult = (ErrorResult) CozeClient.this.getGson().fromJson(strA, ErrorResult.class);
            } catch (Exception unused) {
            }
            s.INSTANCE.g("onFailure errorResult " + errorResult);
            if (errorResult == null) {
                ErrorResult errorResult2 = new ErrorResult(null, null, null, 0, 15, null);
                errorResult2.b("unknow");
                if (t10 == null || (message = t10.getMessage()) == null) {
                    message = "";
                }
                errorResult2.c(message);
                errorResult2.d(-1);
                errorResult = errorResult2;
            }
            errorResult.e(AgentError.ERROR_CODE_NETWORK);
            InterfaceC4143a interfaceC4143a = this.$callback;
            if (interfaceC4143a != null) {
                interfaceC4143a.d(eventSource, errorResult, response, this.$tag);
            }
        }

        @Override // Kb.b
        public void d(Kb.a eventSource, C5530C response) {
            InterfaceC4143a interfaceC4143a;
            p.i(eventSource, "eventSource");
            p.i(response, "response");
            s.INSTANCE.g("onOpen");
            HashMap<String, Object> map = this.$toolOutputs;
            if ((map == null || map.isEmpty()) && (interfaceC4143a = this.$callback) != null) {
                interfaceC4143a.b(eventSource, response, this.$tag);
            }
        }
    }

    public static final CozeClient m() {
        return new CozeClient();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object q(CozeClient cozeClient, String str, String str2, String str3, List list, Object obj, HashMap map, String str4, Thinking thinking, InterfaceC4143a interfaceC4143a, InterfaceC4014c interfaceC4014c, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        if ((i10 & 8) != 0) {
            list = null;
        }
        if ((i10 & 16) != 0) {
            obj = "";
        }
        if ((i10 & 32) != 0) {
            map = null;
        }
        if ((i10 & 64) != 0) {
            str4 = null;
        }
        if ((i10 & 128) != 0) {
            thinking = null;
        }
        return cozeClient.p(str, str2, str3, list, obj, map, str4, thinking, interfaceC4143a, interfaceC4014c);
    }

    public static final t u(q qVar, long j10, long j11, boolean z10) {
        int i10 = (int) ((100 * j10) / j11);
        if (i10 > 99) {
            i10 = 99;
        }
        System.out.println((Object) ("上传进度: " + i10 + "% (" + j10 + "/" + j11 + "), 是否完成: " + z10));
        qVar.invoke(Integer.valueOf(i10), Boolean.FALSE, "");
        return t.f7040a;
    }

    public final Object e(String str, String str2, InterfaceC4014c<? super CreateConversationResult> interfaceC4014c) {
        return ((a) j().b(a.class)).a(" Bearer " + str, new CreateConversation(str2, null, 2, null), interfaceC4014c);
    }

    public final Object f(String str, String str2, String str3, String str4, InterfaceC4014c<? super t> interfaceC4014c) {
        C4103h c4103h = new C4103h();
        c4103h.a(str4);
        t tVar = t.f7040a;
        Object objD = ((a) j().b(a.class)).d(" Bearer " + str, str2, str3, c4103h, interfaceC4014c);
        return objD == C4063a.g() ? objD : t.f7040a;
    }

    public final Object g(String str, String str2, InterfaceC4014c<? super AgentDetailResult> interfaceC4014c) {
        return a.c((a) j().b(a.class), " Bearer " + str, str2, false, interfaceC4014c, 4, null);
    }

    public final String h(Context context) {
        p.i(context, "context");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        p.h(string, "getString(...)");
        return string;
    }

    /* renamed from: i, reason: from getter */
    public final Gson getGson() {
        return this.gson;
    }

    public final g j() {
        g gVar = this.netImpl;
        if (gVar != null) {
            return gVar;
        }
        p.A("netImpl");
        return null;
    }

    public final String k() {
        Context context = this.context;
        if (context == null) {
            p.A("context");
            context = null;
        }
        return n(h(context));
    }

    public final void l(Context context, long timeOut, String url, com.stepos.agentframework.adapter.netcore.p logger) {
        p.i(context, "context");
        p.i(url, "url");
        p.i(logger, "logger");
        r(new g(url, timeOut, logger));
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
    }

    public final String n(String str) throws NoSuchAlgorithmException {
        p.i(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            p.h(messageDigest, "getInstance(...)");
            byte[] bytes = str.getBytes(C0953c.UTF_8);
            p.h(bytes, "getBytes(...)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            p.h(bArrDigest, "digest(...)");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            String string = stringBuffer.toString();
            p.h(string, "toString(...)");
            return string;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final List<g4.i> o(List<? extends AbstractC0913i> query) {
        ArrayList arrayList = new ArrayList();
        List<? extends AbstractC0913i> list = query;
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        List<? extends AbstractC0913i> list2 = query;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (!(((AbstractC0913i) it.next()) instanceof AbstractC0913i.Text)) {
                    ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                    for (AbstractC0913i abstractC0913i : list2) {
                        f fVar = new f();
                        if (abstractC0913i instanceof AbstractC0913i.Text) {
                            fVar.c("text");
                            fVar.b(((AbstractC0913i.Text) abstractC0913i).getText());
                        } else if (abstractC0913i instanceof AbstractC0913i.Image) {
                            fVar.c("image");
                            AbstractC0913i.Image image = (AbstractC0913i.Image) abstractC0913i;
                            fVar.a(image.getFileId());
                            String uri = image.getUri();
                            if (uri == null) {
                                uri = image.getBase64();
                            }
                            fVar.b(uri);
                        } else if (abstractC0913i instanceof AbstractC0913i.File) {
                            fVar.c(Const.STR_FILE);
                            AbstractC0913i.File file = (AbstractC0913i.File) abstractC0913i;
                            fVar.b(file.getUri());
                            fVar.a(file.getFileId());
                        }
                        arrayList2.add(fVar);
                    }
                    g4.i iVar = new g4.i();
                    iVar.a(this.gson.toJson(arrayList2));
                    iVar.b("object_string");
                    return C1172u.e(iVar);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(list2, 10));
        for (AbstractC0913i abstractC0913i2 : list2) {
            g4.i iVar2 = new g4.i();
            p.g(abstractC0913i2, "null cannot be cast to non-null type com.stepos.common.ChatContent.Text");
            iVar2.a(((AbstractC0913i.Text) abstractC0913i2).getText());
            iVar2.b("text");
            arrayList3.add(iVar2);
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List<? extends kotlin.AbstractC0913i> r20, java.lang.Object r21, java.util.HashMap<java.lang.String, java.lang.Object> r22, java.lang.String r23, g4.Thinking r24, h4.InterfaceC4143a r25, e9.InterfaceC4014c<? super Kb.a> r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.p(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Object, java.util.HashMap, java.lang.String, g4.j, h4.a, e9.c):java.lang.Object");
    }

    public final void r(g gVar) {
        p.i(gVar, "<set-?>");
        this.netImpl = gVar;
    }

    public final Object s(Context context, String str, Uri uri, q<? super Integer, ? super Boolean, ? super String, t> qVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objT = t(context, str, new File(C4167a.c(context, uri)), qVar, interfaceC4014c);
        return objT == C4063a.g() ? objT : t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(android.content.Context r8, java.lang.String r9, java.io.File r10, final p9.q<? super java.lang.Integer, ? super java.lang.Boolean, ? super java.lang.String, Y8.t> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2 r0 = (com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2 r0 = new com.stepos.agentframework.adapter.coze.CozeClient$uploadFile$2
            r0.<init>(r7, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4e
            if (r2 != r3) goto L46
            java.lang.Object r7 = r0.L$6
            tb.y$c r7 = (tb.y.c) r7
            java.lang.Object r7 = r0.L$5
            com.stepos.agentframework.adapter.coze.requestbody.a r7 = (com.stepos.agentframework.adapter.coze.requestbody.a) r7
            java.lang.Object r7 = r0.L$4
            tb.B r7 = (tb.AbstractC5529B) r7
            java.lang.Object r7 = r0.L$3
            r11 = r7
            p9.q r11 = (p9.q) r11
            java.lang.Object r7 = r0.L$2
            java.io.File r7 = (java.io.File) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            android.content.Context r7 = (android.content.Context) r7
            kotlin.C4849c.b(r12)
            goto Lc1
        L46:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4e:
            kotlin.C4849c.b(r12)
            tb.B$a r12 = tb.AbstractC5529B.INSTANCE
            tb.x$a r2 = tb.x.INSTANCE
            java.lang.String r4 = "multipart/form-data"
            tb.x r2 = r2.b(r4)
            tb.B r12 = r12.a(r10, r2)
            com.stepos.agentframework.adapter.coze.requestbody.a r2 = new com.stepos.agentframework.adapter.coze.requestbody.a
            com.stepos.agentframework.adapter.coze.b r4 = new com.stepos.agentframework.adapter.coze.b
            r4.<init>()
            r2.<init>(r12, r4)
            tb.y$c$a r4 = tb.y.c.INSTANCE
            java.lang.String r5 = "file"
            java.lang.String r6 = r10.getPath()
            tb.y$c r4 = r4.b(r5, r6, r2)
            com.stepos.agentframework.adapter.coze.g r7 = r7.j()
            java.lang.Class<com.stepos.agentframework.adapter.coze.a> r5 = com.stepos.agentframework.adapter.coze.a.class
            java.lang.Object r7 = r7.b(r5)
            com.stepos.agentframework.adapter.coze.a r7 = (com.stepos.agentframework.adapter.coze.a) r7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = " Bearer "
            r5.append(r6)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            java.lang.Object r8 = g9.h.a(r9)
            r0.L$1 = r8
            java.lang.Object r8 = g9.h.a(r10)
            r0.L$2 = r8
            r0.L$3 = r11
            java.lang.Object r8 = g9.h.a(r12)
            r0.L$4 = r8
            java.lang.Object r8 = g9.h.a(r2)
            r0.L$5 = r8
            java.lang.Object r8 = g9.h.a(r4)
            r0.L$6 = r8
            r0.label = r3
            java.lang.Object r12 = r7.e(r5, r4, r0)
            if (r12 != r1) goto Lc1
            return r1
        Lc1:
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult r12 = (com.stepos.agentframework.adapter.coze.bean.UploadFileResult) r12
            r7 = 100
            java.lang.Integer r7 = g9.C4109a.f(r7)
            java.lang.Boolean r8 = g9.C4109a.a(r3)
            com.stepos.agentframework.adapter.coze.bean.UploadFileResult$Data r9 = r12.getData()
            java.lang.String r9 = r9.getId()
            r11.invoke(r7, r8, r9)
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeClient.t(android.content.Context, java.lang.String, java.io.File, p9.q, e9.c):java.lang.Object");
    }
}

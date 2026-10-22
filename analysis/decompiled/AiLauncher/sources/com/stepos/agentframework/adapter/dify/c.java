package com.stepos.agentframework.adapter.dify;

import La.C0953c;
import Y8.h;
import android.content.Context;
import android.provider.Settings;
import android.util.Patterns;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stepos.agentframework.adapter.dify.bean.Event;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import j4.ChatEventData;
import j4.ErrorResult;
import j4.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import k4.InterfaceC4813a;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import l4.C4871a;
import p9.InterfaceC5063a;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.x;
import tb.z;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001f\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010/¨\u00062"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "timeOut", "", "url", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;JLjava/lang/String;)V", "secretKey", "", "input", "query", "conversationId", "tag", "Lk4/a;", "callback", "LKb/a;", "l", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lk4/a;)LKb/a;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Ljava/lang/String;", "k", "(Ljava/lang/String;)Ljava/lang/String;", "messageId", "Lj4/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/dify/d;", "netImpl", "Lcom/stepos/agentframework/adapter/dify/d;", "f", "()Lcom/stepos/agentframework/adapter/dify/d;", "n", "(Lcom/stepos/agentframework/adapter/dify/d;)V", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "e", "()Lcom/google/gson/Gson;", "Landroid/content/Context;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    public static final String BEARER = " Bearer";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String URL = "https://api.dify.ai/";
    private static final h<c> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.dify.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return c.j();
        }
    });
    private Context context;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    public d netImpl;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR!\u0010\u0010\u001a\u00020\n8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/c$a;", "", "<init>", "()V", "", "URL", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "getURL$annotations", "Lcom/stepos/agentframework/adapter/dify/c;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/dify/c;", "getInstance$annotations", "instance", "BEARER", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.dify.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final c a() {
            return (c) c.instance$delegate.getValue();
        }

        public final String b() {
            return c.URL;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/stepos/agentframework/adapter/dify/c$b", "LKb/b;", "LKb/a;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30737d, "type", "data", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LKb/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LKb/a;)V", "", "t", "Ltb/C;", UxipConstants.f30685x, "c", "(LKb/a;Ljava/lang/Throwable;Ltb/C;)V", Const.INTENT_KEY_UMID, "(LKb/a;Ltb/C;)V", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Kb.b {
        final /* synthetic */ InterfaceC4813a $callback;
        final /* synthetic */ Object $tag;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
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

        public b(InterfaceC4813a interfaceC4813a, Object obj) {
            this.$callback = interfaceC4813a;
            this.$tag = obj;
        }

        @Override // Kb.b
        public void a(Kb.a eventSource) {
            p.i(eventSource, "eventSource");
            C4871a.d(C4871a.INSTANCE, "onClosed", null, 2, null);
            InterfaceC4813a interfaceC4813a = this.$callback;
            if (interfaceC4813a != null) {
                interfaceC4813a.a(eventSource, this.$tag);
            }
        }

        @Override // Kb.b
        public void b(Kb.a eventSource, String eventId, String type, String data) {
            ChatEventData chatEventData;
            p.i(eventSource, "eventSource");
            p.i(data, "data");
            C4871a.b(C4871a.INSTANCE, "onEvent eventId: " + eventId + " type: " + type + "  data:" + data, null, 2, null);
            try {
                chatEventData = (ChatEventData) c.this.getGson().fromJson(data, ChatEventData.class);
            } catch (Exception e10) {
                e10.printStackTrace();
                chatEventData = null;
            }
            Event event = chatEventData != null ? chatEventData.getEvent() : null;
            int i10 = event == null ? -1 : a.$EnumSwitchMapping$0[event.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                ChatEventData chatEventData2 = chatEventData;
                InterfaceC4813a interfaceC4813a = this.$callback;
                if (interfaceC4813a != null) {
                    InterfaceC4813a.c(interfaceC4813a, eventSource, chatEventData2, type, data, this.$tag, null, 32, null);
                }
            }
        }

        @Override // Kb.b
        public void c(Kb.a eventSource, Throwable t10, C5530C response) {
            ErrorResult errorResult;
            String message;
            AbstractC5531D body;
            p.i(eventSource, "eventSource");
            String strA = (response == null || (body = response.getBody()) == null) ? null : body.A();
            C4871a.d(C4871a.INSTANCE, "onFailure  " + t10 + "  " + strA, null, 2, null);
            try {
                errorResult = (ErrorResult) c.this.getGson().fromJson(strA, ErrorResult.class);
            } catch (Exception unused) {
                errorResult = null;
            }
            C4871a.d(C4871a.INSTANCE, "onFailure errorResult " + errorResult, null, 2, null);
            if (errorResult == null) {
                ErrorResult errorResult2 = new ErrorResult(null, null, null, 7, null);
                errorResult2.a("unknow");
                if (t10 == null || (message = t10.getMessage()) == null) {
                    message = "";
                }
                errorResult2.b(message);
                errorResult2.c(-1);
                errorResult = errorResult2;
            }
            InterfaceC4813a interfaceC4813a = this.$callback;
            if (interfaceC4813a != null) {
                interfaceC4813a.d(eventSource, errorResult, response, this.$tag);
            }
        }

        @Override // Kb.b
        public void d(Kb.a eventSource, C5530C response) {
            p.i(eventSource, "eventSource");
            p.i(response, "response");
            C4871a.d(C4871a.INSTANCE, "onOpen", null, 2, null);
            InterfaceC4813a interfaceC4813a = this.$callback;
            if (interfaceC4813a != null) {
                interfaceC4813a.b(eventSource, response, this.$tag);
            }
        }
    }

    public static final c j() {
        return new c();
    }

    public static /* synthetic */ Kb.a m(c cVar, String str, Map map, String str2, String str3, Object obj, InterfaceC4813a interfaceC4813a, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        if ((i10 & 8) != 0) {
            str3 = "";
        }
        if ((i10 & 16) != 0) {
            obj = "";
        }
        return cVar.l(str, map, str2, str3, obj, interfaceC4813a);
    }

    public final String d(Context context) {
        p.i(context, "context");
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        p.h(string, "getString(...)");
        return string;
    }

    /* renamed from: e, reason: from getter */
    public final Gson getGson() {
        return this.gson;
    }

    public final d f() {
        d dVar = this.netImpl;
        if (dVar != null) {
            return dVar;
        }
        p.A("netImpl");
        return null;
    }

    public final Object g(String str, String str2, InterfaceC4014c<? super j4.d> interfaceC4014c) {
        return ((a) f().b(a.class)).a(" Bearer " + str, str2, interfaceC4014c);
    }

    public final String h() {
        Context context = this.context;
        if (context == null) {
            p.A("context");
            context = null;
        }
        return k(d(context));
    }

    public final void i(Context context, long timeOut, String url) {
        p.i(context, "context");
        p.i(url, "url");
        n(new d(url, timeOut));
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
    }

    public final String k(String str) throws NoSuchAlgorithmException {
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

    public final Kb.a l(String secretKey, Map<String, String> input, String query, String conversationId, Object tag, InterfaceC4813a callback) throws Exception {
        p.i(secretKey, "secretKey");
        p.i(query, "query");
        p.i(conversationId, "conversationId");
        p.i(tag, "tag");
        p.i(callback, "callback");
        z zVarD = f().d();
        p.f(zVarD);
        Gson gson = new Gson();
        b.Companion companion = j4.b.INSTANCE;
        if (input == null) {
            input = new HashMap<>();
        }
        String json = gson.toJson(companion.a(input, query, conversationId, h()));
        C4871a c4871a = C4871a.INSTANCE;
        C4871a.d(c4871a, "postJson  " + json, null, 2, null);
        AbstractC5529B.Companion companion2 = AbstractC5529B.INSTANCE;
        x xVarB = x.INSTANCE.b("application/json");
        p.f(json);
        AbstractC5529B abstractC5529BD = companion2.d(xVarB, json);
        String str = f().getBaseUrl() + "v1/chat-messages";
        C4871a.d(c4871a, "requestChatStreaming  " + str + "  " + json, null, 2, null);
        if (!Patterns.WEB_URL.matcher(str).matches()) {
            throw new Exception("url exception:  " + str);
        }
        return Kb.d.b(zVarD).a(new C5528A.a().t(str).o(abstractC5529BD).a("Content-Type", "application/json").a("Authorization", " Bearer " + secretKey).b(), new b(callback, tag));
    }

    public final void n(d dVar) {
        p.i(dVar, "<set-?>");
        this.netImpl = dVar;
    }
}

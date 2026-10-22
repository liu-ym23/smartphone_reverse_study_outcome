package com.stepos.agentframework.chatcore.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.FileStorageConfig;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.net.HttpManager;
import com.stepos.net.token.TokenProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e8.UploadConfig;
import e9.InterfaceC4014c;
import j1.InterfaceC4757d;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.C0917m;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import p9.InterfaceC5074l;
import s4.C5443d;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!RD\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0011\u0010+\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ChatCoreSdk;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/session/a;", "config", "", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "apiTypes", "LY8/t;", "e", "(Landroid/content/Context;Lcom/stepos/agentframework/chatcore/session/a;Ljava/util/List;)V", "", x5.d.EXTRA_ENABLED, Const.INTENT_KEY_PKGNAME, "(Z)V", "", "uid", "k", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "sessionId", "Lcom/stepos/agentframework/chatcore/session/h0;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/h0;", "Landroid/content/Context;", "c", "()Landroid/content/Context;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)V", "lastObservedUid", "Ljava/lang/String;", "Lkotlin/Function1;", "Lj1/d$c;", UxipConstants.f30680s, "dbOpenHelperFactoryProvider", "Lp9/l;", Const.INTENT_KEY_UMID, "()Lp9/l;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "isInitialized", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class ChatCoreSdk {
    public static final ChatCoreSdk INSTANCE = new ChatCoreSdk();
    public static Context context;
    private static volatile InterfaceC5074l<? super String, ? extends InterfaceC4757d.c> dbOpenHelperFactoryProvider;
    private static volatile String lastObservedUid;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"com/stepos/agentframework/chatcore/session/ChatCoreSdk$a", "Lcom/stepos/agentframework/adapter/netcore/t;", "LK6/m;", "chatReplyInfo", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "apiType", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LK6/m;Lcom/stepos/agentframework/adapter/netcore/ApiType;)V", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.agentframework.adapter.netcore.t {
        @Override // com.stepos.agentframework.adapter.netcore.t
        public void a(C0917m chatReplyInfo, ApiType apiType) {
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            kotlin.jvm.internal.p.i(apiType, "apiType");
            PushMessageCenter.INSTANCE.V(chatReplyInfo, apiType);
        }

        @Override // com.stepos.agentframework.adapter.netcore.t
        public void b(C0917m chatReplyInfo, ApiType apiType) {
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            kotlin.jvm.internal.p.i(apiType, "apiType");
            PushMessageCenter.INSTANCE.W(chatReplyInfo, apiType);
            C5443d.b(chatReplyInfo);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements com.stepos.agentframework.adapter.netcore.m {
        public static final b INSTANCE = new b();

        @Override // com.stepos.agentframework.adapter.netcore.m
        public final Object a(InterfaceC4014c<? super String> interfaceC4014c) {
            Object objB;
            ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
            try {
                Result.Companion companion = Result.INSTANCE;
                TokenProvider tokenProvider = HttpManager.INSTANCE.config().getTokenProvider();
                objB = Result.b(tokenProvider != null ? tokenProvider.getCachedToken() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                return null;
            }
            return objB;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements com.stepos.agentframework.adapter.netcore.l {
        final /* synthetic */ String $appVerCode;
        final /* synthetic */ String $appVerName;

        public c(String str, String str2) {
            this.$appVerName = str;
            this.$appVerCode = str2;
        }

        @Override // com.stepos.agentframework.adapter.netcore.l
        public final Object a(InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
            Pair pairA = Y8.j.a("zy-device-id", J7.c.b());
            J7.a aVar = J7.a.f3739a;
            return kotlin.collections.a.m(pairA, Y8.j.a("zy-device-model", aVar.d()), Y8.j.a("zy-device-brand", aVar.c()), Y8.j.a("zy-client-type", "Android"), Y8.j.a("zy-client-lang", Locale.getDefault().toLanguageTag()), Y8.j.a("zy-system-ver", aVar.e()), Y8.j.a("zy-app-ver-name", this.$appVerName), Y8.j.a("zy-app-ver-code", this.$appVerCode));
        }
    }

    public static final boolean f(String sessionId, String outboundId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        return PushMessageCenter.INSTANCE.A(sessionId, outboundId);
    }

    public final void b(boolean enabled) {
        C5443d.a(enabled);
    }

    public final Context c() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        kotlin.jvm.internal.p.A("context");
        return null;
    }

    public final InterfaceC5074l<String, InterfaceC4757d.c> d() {
        return dbOpenHelperFactoryProvider;
    }

    public final void e(Context context2, AgentFrameworkConfig config, List<? extends ApiType> apiTypes) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(context2, "context");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(apiTypes, "apiTypes");
        com.stepos.agentframework.chatcore.intent.d.INSTANCE.i(context2);
        Context applicationContext = context2.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        j(applicationContext);
        dbOpenHelperFactoryProvider = config.d();
        Context applicationContext2 = context2.getApplicationContext();
        try {
            Result.Companion companion = Result.INSTANCE;
            J7.a aVar = J7.a.f3739a;
            kotlin.jvm.internal.p.f(applicationContext2);
            objB = Result.b(aVar.b(applicationContext2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        String str = (String) objB;
        try {
            J7.a aVar2 = J7.a.f3739a;
            kotlin.jvm.internal.p.f(applicationContext2);
            objB2 = Result.b(String.valueOf(aVar2.a(applicationContext2)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        FileStorageConfig fileStorageConfig = new FileStorageConfig(config.getAppId(), config.getAppSecret(), "clawphone", "client", La.H.G1(config.getGatewayBaseUrl(), JsonPointer.SEPARATOR), "file-storage", b.INSTANCE, new c(str, (String) (Result.g(objB2) ? "" : objB2)));
        ApiManager apiManager = ApiManager.INSTANCE;
        ApiManager.N(apiManager, context2, "", 3000L, null, new UploadConfig(null, null, "cn-shanghai", "AKLTZjM1ODQyYjYwYjZiNDQwN2E5YTJkZWJjYTM5NTY2Yjc", "WXpBelltRXlPR1JtTkRRME5HRTBPV0ZpTkdFMk56TXhNVE14TlRReVlXRQ==", false, "test-bucket-allservice", 0, 0, 419, null), fileStorageConfig, config.getAgentProxyBaseUrl(), 8, null);
        apiManager.l0(apiTypes);
        com.stepos.agentframework.chatcore.audit.k.INSTANCE.i(context2);
        com.stepos.agentframework.chatcore.safehint.a.INSTANCE.b(context2);
        TaskIngress.INSTANCE.k();
        apiManager.j0(new a());
        apiManager.k0(new p9.p() { // from class: com.stepos.agentframework.chatcore.session.D
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(ChatCoreSdk.f((String) obj, (String) obj2));
            }
        });
    }

    public final boolean g() {
        return context != null;
    }

    public final LatestRoundIds h(String sessionId) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(FwkDatabase.INSTANCE.n().j0().m(sessionId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(ExtKt.TAG, "latestRoundIds failed sid=" + sessionId + ": " + thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        ChatMessage chatMessage = (ChatMessage) objB;
        if (chatMessage != null) {
            return new LatestRoundIds(chatMessage.getPairId(), chatMessage.getMessageId());
        }
        return null;
    }

    public final void i() {
        Log.i(ExtKt.TAG, "onUserLoggedOut");
        lastObservedUid = null;
        FwkDatabase.INSTANCE.m();
        SessionActivityTracker.INSTANCE.b();
        C1927e0.INSTANCE.b();
        PushMessageCenter.INSTANCE.c0();
        com.stepos.agentframework.chatcore.intent.d.INSTANCE.h();
    }

    public final void j(Context context2) {
        kotlin.jvm.internal.p.i(context2, "<set-?>");
        context = context2;
    }

    public final void k(String uid) {
        kotlin.jvm.internal.p.i(uid, "uid");
        if (uid.length() == 0 || kotlin.jvm.internal.p.d(lastObservedUid, uid)) {
            return;
        }
        lastObservedUid = uid;
        FwkDatabase.INSTANCE.F(uid);
        Function2.c(new ChatCoreSdk$switchUser$1(null));
        C1939k0.j();
        SessionActivityTracker.INSTANCE.b();
        PushMessageCenter.INSTANCE.c0();
    }
}

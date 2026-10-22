package com.stepos.agentframework.adapter.coze;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor;
import com.stepos.agentframework.adapter.netcore.p;
import com.stepos.agentframework.adapter.netcore.s;
import h8.C4148a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import tb.z;
import yc.w;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/g;", "", "", "baseUrl", "", "timeOut", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "<init>", "(Ljava/lang/String;JLcom/stepos/agentframework/adapter/netcore/p;)V", "LY8/t;", "f", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;)Ljava/lang/Object;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Z", "Lyc/w;", "retrofit", "Lyc/w;", "getRetrofit", "()Lyc/w;", "setRetrofit", "(Lyc/w;)V", "Ltb/z;", "okHttpClient", "Ltb/z;", "e", "()Ltb/z;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ltb/z;)V", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "J", "getTimeOut", "()J", "setTimeOut", "(J)V", "Lcom/stepos/agentframework/adapter/netcore/p;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/adapter/netcore/p;", "setLogger", "(Lcom/stepos/agentframework/adapter/netcore/p;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class g {
    private String baseUrl;
    private p logger;
    public z okHttpClient;
    private w retrofit;
    private long timeOut;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/agentframework/adapter/coze/g$a", "Lcom/stepos/agentframework/adapter/coze/interceptor/LlmHttpLoggingInterceptor$a;", "", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/google/gson/Gson;", "prettyGson", "Lcom/google/gson/Gson;", "getPrettyGson", "()Lcom/google/gson/Gson;", "setPrettyGson", "(Lcom/google/gson/Gson;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements LlmHttpLoggingInterceptor.a {
        private Gson prettyGson;

        public a() {
            Gson gsonCreate = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            kotlin.jvm.internal.p.h(gsonCreate, "create(...)");
            this.prettyGson = gsonCreate;
        }

        @Override // com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor.a
        public void a(String message) throws JsonIOException {
            if (message == null || message.length() == 0) {
                return;
            }
            if (!g.this.g(message)) {
                g.this.getLogger().a(s.INSTANCE.f(), message);
                return;
            }
            p logger = g.this.getLogger();
            String strF = s.INSTANCE.f();
            Gson gson = this.prettyGson;
            String json = gson.toJson((JsonElement) gson.fromJson(message, JsonElement.class));
            kotlin.jvm.internal.p.h(json, "toJson(...)");
            logger.a(strF, json);
        }
    }

    public g(String baseUrl, long j10, p logger) {
        kotlin.jvm.internal.p.i(baseUrl, "baseUrl");
        kotlin.jvm.internal.p.i(logger, "logger");
        this.baseUrl = baseUrl;
        this.timeOut = j10;
        this.logger = logger;
        f();
    }

    public <T> T b(Class<T> cls) {
        kotlin.jvm.internal.p.i(cls, "cls");
        w wVar = this.retrofit;
        T t10 = wVar != null ? (T) wVar.c(cls) : null;
        kotlin.jvm.internal.p.f(t10);
        return t10;
    }

    /* renamed from: c, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: d, reason: from getter */
    public final p getLogger() {
        return this.logger;
    }

    public final z e() {
        z zVar = this.okHttpClient;
        if (zVar != null) {
            return zVar;
        }
        kotlin.jvm.internal.p.A("okHttpClient");
        return null;
    }

    public final void f() {
        z.a aVar = new z.a();
        long j10 = this.timeOut / 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z.a aVarU = aVar.g(j10, timeUnit).T(this.timeOut, timeUnit).W(this.timeOut, timeUnit).U(true);
        LlmHttpLoggingInterceptor llmHttpLoggingInterceptor = new LlmHttpLoggingInterceptor(new a());
        llmHttpLoggingInterceptor.e(C4148a.l() ? LlmHttpLoggingInterceptor.Level.NONE : LlmHttpLoggingInterceptor.Level.BODY);
        t tVar = t.f7040a;
        h(aVarU.a(llmHttpLoggingInterceptor).d());
        this.retrofit = new w.b().f(e()).b(this.baseUrl).a(zc.a.g(new GsonBuilder().disableHtmlEscaping().create())).d();
    }

    public final boolean g(String str) {
        try {
            JsonParser.parseString(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void h(z zVar) {
        kotlin.jvm.internal.p.i(zVar, "<set-?>");
        this.okHttpClient = zVar;
    }
}

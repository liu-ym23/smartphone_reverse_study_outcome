package com.stepos.agentframework.adapter.dify;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.stepos.agentframework.adapter.dify.interceptor.LlmHttpLoggingInterceptor;
import h8.C4148a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l4.C4871a;
import tb.z;
import yc.w;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/d;", "", "", "baseUrl", "", "timeOut", "<init>", "(Ljava/lang/String;J)V", "LY8/t;", "e", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;)Ljava/lang/Object;", "", "f", "(Ljava/lang/String;)Z", "Lyc/w;", "retrofit", "Lyc/w;", "getRetrofit", "()Lyc/w;", "setRetrofit", "(Lyc/w;)V", "Ltb/z;", "okHttpClient", "Ltb/z;", Const.INTENT_KEY_UMID, "()Ltb/z;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/z;)V", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "J", "getTimeOut", "()J", "setTimeOut", "(J)V", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {
    private String baseUrl;
    public z okHttpClient;
    private w retrofit;
    private long timeOut;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/agentframework/adapter/dify/d$a", "Lcom/stepos/agentframework/adapter/dify/interceptor/LlmHttpLoggingInterceptor$a;", "", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/google/gson/Gson;", "prettyGson", "Lcom/google/gson/Gson;", "getPrettyGson", "()Lcom/google/gson/Gson;", "setPrettyGson", "(Lcom/google/gson/Gson;)V", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements LlmHttpLoggingInterceptor.a {
        private Gson prettyGson;

        public a() {
            Gson gsonCreate = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            p.h(gsonCreate, "create(...)");
            this.prettyGson = gsonCreate;
        }

        @Override // com.stepos.agentframework.adapter.dify.interceptor.LlmHttpLoggingInterceptor.a
        public void a(String message) throws JsonIOException {
            if (message == null || message.length() == 0) {
                return;
            }
            if (!d.this.f(message)) {
                C4871a.b(C4871a.INSTANCE, message, null, 2, null);
                return;
            }
            C4871a c4871a = C4871a.INSTANCE;
            Gson gson = this.prettyGson;
            String json = gson.toJson((JsonElement) gson.fromJson(message, JsonElement.class));
            p.h(json, "toJson(...)");
            C4871a.b(c4871a, json, null, 2, null);
        }
    }

    public d(String baseUrl, long j10) {
        p.i(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        this.timeOut = j10;
        e();
    }

    public <T> T b(Class<T> cls) {
        p.i(cls, "cls");
        w wVar = this.retrofit;
        T t10 = wVar != null ? (T) wVar.c(cls) : null;
        p.f(t10);
        return t10;
    }

    /* renamed from: c, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final z d() {
        z zVar = this.okHttpClient;
        if (zVar != null) {
            return zVar;
        }
        p.A("okHttpClient");
        return null;
    }

    public final void e() {
        z.a aVar = new z.a();
        long j10 = this.timeOut / 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z.a aVarU = aVar.g(j10, timeUnit).T(this.timeOut, timeUnit).W(this.timeOut, timeUnit).U(true);
        LlmHttpLoggingInterceptor llmHttpLoggingInterceptor = new LlmHttpLoggingInterceptor(new a());
        llmHttpLoggingInterceptor.e(C4148a.l() ? LlmHttpLoggingInterceptor.Level.NONE : LlmHttpLoggingInterceptor.Level.BODY);
        t tVar = t.f7040a;
        g(aVarU.a(llmHttpLoggingInterceptor).d());
        this.retrofit = new w.b().f(d()).b(this.baseUrl).a(zc.a.g(new GsonBuilder().disableHtmlEscaping().create())).d();
    }

    public final boolean f(String str) {
        try {
            JsonParser.parseString(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void g(z zVar) {
        p.i(zVar, "<set-?>");
        this.okHttpClient = zVar;
    }
}

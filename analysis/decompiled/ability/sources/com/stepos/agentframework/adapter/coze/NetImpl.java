package com.stepos.agentframework.adapter.coze;

import D7.q;
import F9.E;
import F9.F;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import qa.N;
import ra.C1884a;
import u1.d;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/NetImpl;", "Lcom/stepos/agentframework/adapter/coze/INet;", "", "baseUrl", "", "timeOut", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", AppAgent.CONSTRUCT, "(Ljava/lang/String;JLcom/stepos/agentframework/adapter/netcore/ILogger;)V", "LF9/E;", "trustCertificate", "(LF9/E;)LF9/E;", "", "isJson", "(Ljava/lang/String;)Z", "LC7/r;", "init", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lqa/N;", "retrofit", "Lqa/N;", "getRetrofit", "()Lqa/N;", "setRetrofit", "(Lqa/N;)V", "LF9/F;", "okHttpClient", "LF9/F;", "getOkHttpClient", "()LF9/F;", "setOkHttpClient", "(LF9/F;)V", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "J", "getTimeOut", "()J", "setTimeOut", "(J)V", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "getLogger", "()Lcom/stepos/agentframework/adapter/netcore/ILogger;", "setLogger", "(Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetImpl implements INet {
    private String baseUrl;
    private ILogger logger;
    public F okHttpClient;
    private N retrofit;
    private long timeOut;

    public NetImpl(String baseUrl, long j5, ILogger logger) {
        k.f(baseUrl, "baseUrl");
        k.f(logger, "logger");
        this.baseUrl = baseUrl;
        this.timeOut = j5;
        this.logger = logger;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isJson(String str) {
        try {
            JsonParser.parseString(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final E trustCertificate(E e) throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.stepos.agentframework.adapter.coze.NetImpl$trustCertificate$trust$1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        k.e(socketFactory, "getSocketFactory(...)");
        Object objK0 = q.k0(trustManagerArr);
        k.d(objK0, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        e.d(socketFactory, (X509TrustManager) objK0);
        return e;
    }

    @Override // com.stepos.agentframework.adapter.coze.INet
    public <T> T create(Class<T> cls) {
        k.f(cls, "cls");
        N n = this.retrofit;
        T t9 = n != null ? (T) n.b(cls) : null;
        k.c(t9);
        return t9;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final ILogger getLogger() {
        return this.logger;
    }

    public final F getOkHttpClient() {
        F f = this.okHttpClient;
        if (f != null) {
            return f;
        }
        k.n("okHttpClient");
        throw null;
    }

    public final N getRetrofit() {
        return this.retrofit;
    }

    public final long getTimeOut() {
        return this.timeOut;
    }

    public final void init() {
        E e = new E();
        long j5 = this.timeOut / 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.b(j5, timeUnit);
        e.c(this.timeOut, timeUnit);
        e.e(this.timeOut, timeUnit);
        e.f = true;
        LlmHttpLoggingInterceptor llmHttpLoggingInterceptor = new LlmHttpLoggingInterceptor(new LlmHttpLoggingInterceptor.Logger() { // from class: com.stepos.agentframework.adapter.coze.NetImpl.init.1
            private Gson prettyGson;

            {
                Gson gsonCreate = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                k.e(gsonCreate, "create(...)");
                this.prettyGson = gsonCreate;
            }

            public final Gson getPrettyGson() {
                return this.prettyGson;
            }

            @Override // com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor.Logger
            public void log(String message) {
                if (message == null || message.length() == 0) {
                    return;
                }
                if (!NetImpl.this.isJson(message)) {
                    NetImpl.this.getLogger().d(Logger.INSTANCE.getTAG(), message);
                    return;
                }
                ILogger logger = NetImpl.this.getLogger();
                String tag = Logger.INSTANCE.getTAG();
                Gson gson = this.prettyGson;
                String json = gson.toJson((JsonElement) gson.fromJson(message, JsonElement.class));
                k.e(json, "toJson(...)");
                logger.d(tag, json);
            }

            public final void setPrettyGson(Gson gson) {
                k.f(gson, "<set-?>");
                this.prettyGson = gson;
            }
        });
        llmHttpLoggingInterceptor.setLevel(LlmHttpLoggingInterceptor.Level.BODY);
        e.a(llmHttpLoggingInterceptor);
        setOkHttpClient(new F(e));
        d dVar = new d(20);
        F okHttpClient = getOkHttpClient();
        Objects.requireNonNull(okHttpClient, "client == null");
        dVar.b = okHttpClient;
        dVar.I(this.baseUrl);
        ((ArrayList) dVar.d).add(C1884a.c(new GsonBuilder().disableHtmlEscaping().create()));
        this.retrofit = dVar.J();
    }

    public final void setBaseUrl(String str) {
        k.f(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setLogger(ILogger iLogger) {
        k.f(iLogger, "<set-?>");
        this.logger = iLogger;
    }

    public final void setOkHttpClient(F f) {
        k.f(f, "<set-?>");
        this.okHttpClient = f;
    }

    public final void setRetrofit(N n) {
        this.retrofit = n;
    }

    public final void setTimeOut(long j5) {
        this.timeOut = j5;
    }
}

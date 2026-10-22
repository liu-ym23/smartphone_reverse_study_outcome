package com.stepos.net;

import D7.b;
import J7.c;
import Y8.t;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.net.HttpConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import tb.z;
import yc.w;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0004\b\u0007\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0010\u0010 J/\u0010$\u001a\u00028\u0000\"\b\b\u0000\u0010!*\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b$\u0010%J&\u0010$\u001a\u00028\u0000\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0086\b¢\u0006\u0004\b$\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u001e2\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0003R\u0018\u00101\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/net/HttpManager;", "", "<init>", "()V", "Lcom/stepos/net/HttpConfig;", "config", "LY8/t;", "init", "(Lcom/stepos/net/HttpConfig;)V", "", "isInitialized", "()Z", "Lcom/stepos/net/a;", "client", "()Lcom/stepos/net/a;", "Lyc/w;", "getRetrofit", "()Lyc/w;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/stepos/net/HttpConfig$Builder;", "block", "(Landroid/content/Context;Lp9/l;)V", "()Lcom/stepos/net/HttpConfig;", "configOrNull$net_release", "configOrNull", "Ltb/z;", "okHttpClient", "()Ltb/z;", "", "baseUrlKey", "(Ljava/lang/String;)Lyc/w;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "service", "create", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "key", "getBaseUrl", "(Ljava/lang/String;)Ljava/lang/String;", "url", "addBaseUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "LD7/b;", "cacheTagInvalidator", "()LD7/b;", "shutdown", "delegate", "Lcom/stepos/net/a;", "lock", "Ljava/lang/Object;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpManager {
    private static volatile a delegate;
    public static final HttpManager INSTANCE = new HttpManager();
    private static final Object lock = new Object();

    private HttpManager() {
    }

    private final a client() {
        a aVar = delegate;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("HttpManager has not been initialized. Call HttpManager.init(...) first.");
    }

    public static /* synthetic */ Object create$default(HttpManager httpManager, String baseUrlKey, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            baseUrlKey = "__default__";
        }
        p.i(baseUrlKey, "baseUrlKey");
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        return httpManager.create(Object.class, baseUrlKey);
    }

    public static final void init(HttpConfig config) {
        p.i(config, "config");
        synchronized (lock) {
            try {
                a aVar = delegate;
                if (aVar != null) {
                    aVar.o();
                }
                delegate = new a(config);
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final boolean isInitialized() {
        return delegate != null;
    }

    public void addBaseUrl(String key, String url) {
        p.i(key, "key");
        p.i(url, "url");
        client().b(key, url);
    }

    public b cacheTagInvalidator() {
        return client().getTagInvalidator();
    }

    public HttpConfig config() {
        return client().getCurrentConfig();
    }

    public final HttpConfig configOrNull$net_release() {
        a aVar = delegate;
        if (aVar != null) {
            return aVar.getCurrentConfig();
        }
        return null;
    }

    public <T> T create(Class<T> service, String baseUrlKey) {
        p.i(service, "service");
        p.i(baseUrlKey, "baseUrlKey");
        return (T) client().h(service, baseUrlKey);
    }

    public String getBaseUrl(String key) {
        p.i(key, "key");
        a aVar = delegate;
        if (aVar != null) {
            return aVar.j(key);
        }
        return null;
    }

    public w getRetrofit(String baseUrlKey) {
        p.i(baseUrlKey, "baseUrlKey");
        return client().k(baseUrlKey);
    }

    public z okHttpClient() {
        return client().m();
    }

    public void shutdown() {
        synchronized (lock) {
            try {
                a aVar = delegate;
                if (aVar != null) {
                    aVar.o();
                }
                delegate = null;
                c.f();
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final w getRetrofit() {
        return INSTANCE.client().k("__default__");
    }

    public final /* synthetic */ <T> T create(String baseUrlKey) {
        p.i(baseUrlKey, "baseUrlKey");
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) create(Object.class, baseUrlKey);
    }

    public final void init(Context context, InterfaceC5074l<? super HttpConfig.Builder, t> block) {
        p.i(context, "context");
        p.i(block, "block");
        HttpConfig.Builder builder = new HttpConfig.Builder(context);
        block.invoke(builder);
        init(builder.build());
    }
}

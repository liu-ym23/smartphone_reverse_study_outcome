package com.stepos.net;

import B5.b;
import B7.a;
import F9.F;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.net.HttpConfig;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import qa.N;
import u5.C2037a;
import u5.C2038b;
import v5.C2059a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0004\b\u0007\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0010\u0010 J/\u0010$\u001a\u00028\u0000\"\b\b\u0000\u0010!*\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b$\u0010%J&\u0010$\u001a\u00028\u0000\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0086\b¢\u0006\u0004\b$\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u001e2\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0003R\u0018\u00101\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/net/HttpManager;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/net/HttpConfig;", "config", "LC7/r;", "init", "(Lcom/stepos/net/HttpConfig;)V", "", "isInitialized", "()Z", "Lu5/b;", "client", "()Lu5/b;", "Lqa/N;", "getRetrofit", "()Lqa/N;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/stepos/net/HttpConfig$Builder;", "block", "(Landroid/content/Context;LS7/k;)V", "()Lcom/stepos/net/HttpConfig;", "configOrNull$net_debug", "configOrNull", "LF9/F;", "okHttpClient", "()LF9/F;", "", "baseUrlKey", "(Ljava/lang/String;)Lqa/N;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "create", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "key", "getBaseUrl", "(Ljava/lang/String;)Ljava/lang/String;", BffConstant.Type.Url, "addBaseUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "Lv5/a;", "cacheTagInvalidator", "()Lv5/a;", "shutdown", "delegate", "Lu5/b;", "lock", "Ljava/lang/Object;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HttpManager {
    private static volatile C2038b delegate;
    public static final HttpManager INSTANCE = new HttpManager();
    private static final Object lock = new Object();

    private HttpManager() {
    }

    private final C2038b client() {
        C2038b c2038b = delegate;
        if (c2038b != null) {
            return c2038b;
        }
        throw new IllegalStateException("HttpManager has not been initialized. Call HttpManager.init(...) first.");
    }

    public static Object create$default(HttpManager httpManager, String baseUrlKey, int i, Object obj) {
        if ((i & 1) != 0) {
            baseUrlKey = "__default__";
        }
        k.f(baseUrlKey, "baseUrlKey");
        k.m();
        throw null;
    }

    public static final void init(HttpConfig config) {
        k.f(config, "config");
        synchronized (lock) {
            try {
                C2038b c2038b = delegate;
                if (c2038b != null) {
                    c2038b.e();
                }
                delegate = new C2038b(config);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final boolean isInitialized() {
        return delegate != null;
    }

    public void addBaseUrl(String key, String url) {
        k.f(key, "key");
        k.f(url, "url");
        C2038b c2038bClient = client();
        c2038bClient.getClass();
        if (!t.W(url, "/", false)) {
            throw new IllegalArgumentException(a.m("BaseUrl '", url, "' must end with '/'").toString());
        }
        synchronized (c2038bClient.d) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap(c2038bClient.e.getBaseUrls());
                linkedHashMap.put(key, url);
                c2038bClient.e = C2038b.c(c2038bClient.e, linkedHashMap);
                c2038bClient.b.remove(key);
                ((ConcurrentHashMap) c2038bClient.f.c).clear();
                Set setKeySet = c2038bClient.c.keySet();
                k.e(setKeySet, "<get-keys>(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    if (((C2037a) obj).b.equals(key)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c2038bClient.c.remove((C2037a) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C2059a cacheTagInvalidator() {
        return client().h;
    }

    public HttpConfig config() {
        return client().e;
    }

    public final HttpConfig configOrNull$net_debug() {
        C2038b c2038b = delegate;
        if (c2038b != null) {
            return c2038b.e;
        }
        return null;
    }

    public <T> T create(Class<T> service, String baseUrlKey) {
        k.f(service, "service");
        k.f(baseUrlKey, "baseUrlKey");
        C2038b c2038bClient = client();
        c2038bClient.getClass();
        C2037a c2037a = new C2037a(service, baseUrlKey);
        ConcurrentHashMap concurrentHashMap = c2038bClient.c;
        T t9 = (T) concurrentHashMap.get(c2037a);
        if (t9 != null) {
            return t9;
        }
        T t10 = (T) c2038bClient.d(baseUrlKey).b(service);
        concurrentHashMap.put(c2037a, t10);
        k.c(t10);
        return t10;
    }

    public String getBaseUrl(String key) {
        k.f(key, "key");
        C2038b c2038b = delegate;
        if (c2038b != null) {
            return c2038b.e.baseUrlOf(key);
        }
        return null;
    }

    public N getRetrofit(String baseUrlKey) {
        k.f(baseUrlKey, "baseUrlKey");
        return client().d(baseUrlKey);
    }

    public F okHttpClient() {
        F fA;
        C2038b c2038bClient = client();
        F f = c2038bClient.f6708a;
        if (f != null) {
            return f;
        }
        synchronized (c2038bClient.d) {
            fA = c2038bClient.f6708a;
            if (fA == null) {
                fA = c2038bClient.a();
                c2038bClient.f6708a = fA;
            }
        }
        return fA;
    }

    public void shutdown() {
        synchronized (lock) {
            try {
                C2038b c2038b = delegate;
                if (c2038b != null) {
                    c2038b.e();
                }
                delegate = null;
                b.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final N getRetrofit() {
        return INSTANCE.client().d("__default__");
    }

    public final void init(Context context, S7.k block) {
        k.f(context, "context");
        k.f(block, "block");
        HttpConfig.Builder builder = new HttpConfig.Builder(context);
        block.invoke(builder);
        init(builder.build());
    }

    public final <T> T create(String baseUrlKey) {
        k.f(baseUrlKey, "baseUrlKey");
        k.m();
        throw null;
    }
}

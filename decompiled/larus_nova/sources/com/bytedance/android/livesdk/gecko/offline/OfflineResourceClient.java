package com.bytedance.android.livesdk.gecko.offline;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import v26.j;
import v26.l;

/* JADX INFO: loaded from: classes8.dex */
public final class OfflineResourceClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f125824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f125825b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OfflineResourceClient f125826c = null;

    public static final class NetWorkImpl implements INetWork {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f125827a;

        public NetWorkImpl() {
            this.f125827a = LazyKt.lazy(OfflineResourceClient$NetWorkImpl$hostNetwork$2.INSTANCE);
        }

        public final wy5.e b(HttpResponse r100) {
            HashMap r101 = new HashMap();
            Iterator<T> r102 = r100.getHeaders().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            NameValuePair r103 = (NameValuePair) r102.next();
            r101.put(r103.getName(), r103.getValue());
            goto L4
        L6:
            Unit r104 = Unit.INSTANCE;
            return new wy5.e(r101, new String(r100.getBody(), Charsets.UTF_8), r100.getStatusCode(), r100.getReason());
        }

        @Override // com.bytedance.geckox.net.INetWork
        public final wy5.e doGet(String r100) {
            return b(((IMiddlewareHostNetwork) this.f125827a.getValue()).get(r100, CollectionsKt.emptyList()).execute());
        }

        @Override // com.bytedance.geckox.net.INetWork
        public final wy5.e doPost(String r100, List<Pair<String, String>> r110) {
            IMiddlewareHostNetwork r101 = (IMiddlewareHostNetwork) this.f125827a.getValue();
            List<NameValuePair> r102 = CollectionsKt.emptyList();
            ByteArrayOutputStream r103 = new ByteArrayOutputStream();
            if (r110 == null) goto L22;
            Iterator<T> r111 = r110.iterator();
        L6:
            if (r111.hasNext() == false) goto L22;
            Pair r104 = (Pair) r111.next();
            if (r103.size() <= 0) goto L10;
            r103.write(38);
        L10:
            String r105 = URLEncoder.encode((String) r104.first, "UTF-8");
            String r106 = (String) r104.second;
            if (r106 != null) goto L13;
            r106 = "";
        L13:
            String r107 = URLEncoder.encode(r106, "UTF-8");
            Charset r108 = Charset.forName("UTF-8");
            if (r105 == null) goto L21;
            r103.write(r105.getBytes(r108));
            r103.write(61);
            Charset r109 = Charset.forName("UTF-8");
            if (r107 == null) goto L19;
            r103.write(r107.getBytes(r109));
            goto L6
        L19:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L21:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L22:
            Unit r112 = Unit.INSTANCE;
            return b(r101.post(r100, r102, "application/x-www-form-urlencoded; charset=UTF-8", r103.toByteArray()).execute());
        }

        @Override // com.bytedance.geckox.net.INetWork
        public final wy5.e doPost(String r100, String r101) {
            IMiddlewareHostNetwork r102 = (IMiddlewareHostNetwork) this.f125827a.getValue();
            List<NameValuePair> r103 = CollectionsKt.emptyList();
            if (r101 == null) goto L6;
            byte[] r104 = r101.getBytes(Charsets.UTF_8);
            if (r104 == null) goto L6;
        L8:
            return b(r102.post(r100, r103, "application/json; charset=UTF-8", r104).execute());
        L6:
            r104 = new byte[0];
            goto L8
        }

        @Override // com.bytedance.geckox.net.INetWork
        public final void downloadFile(String r100, long r101, py5.b r110) {
            if (r110 != null) goto L4;
            return;
        L4:
            InputStream r102 = ((IMiddlewareHostNetwork) this.f125827a.getValue()).downloadFileStreaming(false, (int) r101, r100, CollectionsKt.emptyList(), null).execute().getStream();
            if (r102 != null) goto L18;
            ALogger.e("ResourceLoaderService", "null stream!");
            return;
        L18:
            ByteStreamsKt.copyTo(r102, r110, 2048);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r102, null);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r102, th);
            throw th;
        }
    }

    public interface a {
        void onError(Throwable r100);

        void onSuccess(String r100);
    }

    public interface b {
        void a(d1 r100);

        void onError(Throwable r100);
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f125828a;

        public c(a r100) {
            this.f125828a = r100;
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
        public final void a(d1 r100) {
            a r101 = this.f125828a;
            if (r100 == null) goto L5;
            String r102 = r100.f247859b;
        L6:
            r101.onSuccess(r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.b
        public final void onError(Throwable r100) {
            this.f125828a.onError(r100);
        }
    }

    public OfflineResourceClient() {
    }

    static {
        f125826c = new OfflineResourceClient();
        f125825b = g.a();
    }

    public static d1 e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        l r101 = new l();
        v26.a r102 = new v26.a(false);
        r102.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO}));
        Unit r103 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f552699b = r102;
        return d(r100, r101);
    }

    public final synchronized void a(Application r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L28
        if (f125824a == true) goto L26;
        ConcurrentHashMap<String, ResourceLoaderService> r100 = i.f246824a;     // Catch: Throwable -> L28
        boolean r101 = v.a();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r110, "application");     // Catch: Throwable -> L28
        y16.c.a("init ResourceLoader");     // Catch: Throwable -> L28
        i.f246825b = r110;     // Catch: Throwable -> L28
        i.f246826c = r101;     // Catch: Throwable -> L28
        GeckoConfig r102 = new GeckoConfig(f125825b, g.b(), new com.bytedance.ies.bullet.kit.resourceloader.f(), false, false, 16, null);     // Catch: Throwable -> L28
        ALogger.i("OfflineResourceClient", "dir = " + g.b());     // Catch: Throwable -> L28
        IMiddleWareHostContext r103 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = String.valueOf(r103.appId());     // Catch: Throwable -> L28
    L10:
        String r106 = String.valueOf(r105);     // Catch: Throwable -> L28
        IMiddleWareHostContext r107 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        if (r107 == null) goto L13;
        String r108 = r107.appName();     // Catch: Throwable -> L28
    L15:
        if (TextUtils.isEmpty(r108) == false) goto L17;
        r108 = "-1";
    L18:
        String r109 = r108;
        List r111 = CollectionsKt.mutableListOf(new String[]{"/obj/byte-gurd-source/10181/gecko/resource", "/obj/gecko-internal/10180/gecko/resource"});     // Catch: Throwable -> L28
        IMiddleWareHostContext r112 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L28
        if (r112 == null) goto L22;
        r104 = r112.getServerDeviceId();     // Catch: Throwable -> L28
    L22:
        if (TextUtils.isEmpty(r104) == false) goto L24;
        String r113 = "0";
    L25:
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L28
        j r114 = new j("gecko.zijieapi.com", "CN", r111, r106, r109, r113, r102, null, new com.bytedance.ies.bullet.kit.resourceloader.c(), new NetWorkImpl(), new NetWorkImpl(), 2176);     // Catch: Throwable -> L28
        r114.f552693n = true;     // Catch: Throwable -> L28
        r114.f552694o = true;     // Catch: Throwable -> L28
        r114.f552692m = 300000;     // Catch: Throwable -> L28
        i.a("live", r114);     // Catch: Throwable -> L28
        f125824a = true;     // Catch: Throwable -> L28
        goto L26
    L24:
        r113 = r104;
        goto L25
    L17:
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L28
        goto L18
    L13:
        r108 = null;
        goto L15
    L9:
        r105 = null;
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public static void c(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        l r102 = new l();
        v26.a r103 = new v26.a(false);
        r103.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.CDN}));
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f552699b = r103;
        b(r100, r102, new c(r101));
    }

    public static d1 d(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        String r102 = g.a();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f552698a = r102;
        d1 r103 = i.b("live", 2).h(r100, r101);
        StringBuilder r104 = new StringBuilder("url= ");
        r104.append(r100);
        r104.append(", resourceInfo = ");
        if (r103 == null) goto L5;
        String r105 = r103.toString();
    L6:
        r104.append(r105);
        ALogger.i("OfflineResourceClient", r104.toString());
        return r103;
    L5:
        r105 = null;
        goto L6
    }

    public static void b(String r100, l r101, final b r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = g.a();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f552698a = r103;
        i.b("live", 2).g(r100, r101, new OfflineResourceClient$loadAsync$1(r102), new OfflineResourceClient$loadAsync$2(r102));
    }
}

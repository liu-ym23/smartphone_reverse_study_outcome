package com.airbnb.lottie;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LottieCompositionFactory {
    private static ComponentCallbacks2 sComponentCallback;
    private static boolean sComponentCallbackRegistered;
    private static final Map<String, LottieTask<LottieComposition>> taskCache = null;

    /* JADX INFO: loaded from: classes28.dex */
    public static class a implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24691a;

        public a(String r100) {
            this.f24691a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(LottieComposition r100) {
            LottieCompositionFactory.access$000().remove(this.f24691a);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class b implements LottieListener<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24692a;

        public b(String r100) {
            this.f24692a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Throwable r100) {
            LottieCompositionFactory.access$000().remove(this.f24692a);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class c extends com.airbnb.lottie.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f24693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f24694e;

        @Override // java.lang.Runnable
        public final void run() {
            LottieCompositionFactory.access$100(this.f24693d, this.f24694e, this.f24814a, this.f24815b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(com.airbnb.lottie.e r100, com.airbnb.lottie.b r101, String r102, String r103) {
            this.f24693d = r102;
            this.f24694e = r103;
            super(r100, r101, null);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class d implements com.airbnb.lottie.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.b f24696b;

        @Override // com.airbnb.lottie.b
        public final void a(String r100) {
            this.f24696b.a(r100);
        }

        @Override // com.airbnb.lottie.b
        public final void b(LottieComposition r100) {
            m0.g.f511472b.b(this.f24695a, r100);
            this.f24696b.b(r100);
        }

        public d(String r100, com.airbnb.lottie.b r101) {
            this.f24695a = r100;
            this.f24696b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class e extends com.airbnb.lottie.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f24697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f24698e;

        @Override // java.lang.Runnable
        public final void run() {
            LottieCompositionFactory.access$200(this.f24816c, this.f24697d, this.f24698e, this.f24814a, this.f24815b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(com.airbnb.lottie.e r100, com.airbnb.lottie.b r101, Context r102, String r103, String r104) {
            this.f24697d = r103;
            this.f24698e = r104;
            super(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class f implements com.airbnb.lottie.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.b f24700b;

        @Override // com.airbnb.lottie.b
        public final void a(String r100) {
            this.f24700b.a(r100);
        }

        @Override // com.airbnb.lottie.b
        public final void b(LottieComposition r100) {
            m0.g.f511472b.b(this.f24699a, r100);
            this.f24700b.b(r100);
        }

        public f(String r100, com.airbnb.lottie.b r101) {
            this.f24699a = r100;
            this.f24700b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class g extends com.airbnb.lottie.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f24701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f24702e;

        @Override // java.lang.Runnable
        public final void run() {
            LottieCompositionFactory.access$300(this.f24701d, this.f24702e, this.f24814a, this.f24815b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(com.airbnb.lottie.e r100, com.airbnb.lottie.b r101, String r102, String r103) {
            this.f24701d = r102;
            this.f24702e = r103;
            super(r100, r101, null);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class h implements com.airbnb.lottie.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.b f24704b;

        @Override // com.airbnb.lottie.b
        public final void a(String r100) {
            this.f24704b.a(r100);
        }

        @Override // com.airbnb.lottie.b
        public final void b(LottieComposition r100) {
            m0.g.f511472b.b(this.f24703a, r100);
            this.f24704b.b(r100);
        }

        public h(String r100, com.airbnb.lottie.b r101) {
            this.f24703a = r100;
            this.f24704b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class i implements com.airbnb.lottie.g<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.h f24705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f24706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieComposition f24707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.b f24708d;

        @Override // com.airbnb.lottie.g
        public final void onFailed() {
            this.f24707c.setBitmapReady(false);
            this.f24708d.a("");
        }

        @Override // com.airbnb.lottie.g
        public final void onSuccess(Bitmap r100) {
            this.f24705a.f24784g = r100;
            if (this.f24706b.decrementAndGet() != 0) goto L6;
            this.f24707c.setBitmapReady(true);
            this.f24708d.b(this.f24707c);
            return;
        }

        public i(com.airbnb.lottie.h r100, AtomicInteger r101, LottieComposition r102, com.airbnb.lottie.b r103) {
            this.f24705a = r100;
            this.f24706b = r101;
            this.f24707c = r102;
            this.f24708d = r103;
        }
    }

    public static class j implements ComponentCallbacks2 {
        public j() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            LottieCompositionFactory.clearCache();
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            if (r100 != 5) goto L5;
        L9:
            LottieCompositionFactory.clearCache();
            return;
        L5:
            if (r100 == 10) goto L9;
            if (r100 == 40) goto L9;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class k implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f24709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24710b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() {
            return LottieCompositionFactory.fromAssetSync(this.f24709a, this.f24710b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public k(Context r100, String r101) {
            this.f24709a = r100;
            this.f24710b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class l implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f24711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f24712b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromRawResSync(this.f24711a, this.f24712b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public l(Context r100, int r101) {
            this.f24711a = r100;
            this.f24712b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class m implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f24713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24714b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromJsonInputStreamSync(this.f24713a, this.f24714b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public m(InputStream r100, String r101) {
            this.f24713a = r100;
            this.f24714b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class n implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f24715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24716b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromJsonSync(this.f24715a, this.f24716b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public n(JSONObject r100, String r101) {
            this.f24715a = r100;
            this.f24716b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class o implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24718b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromJsonStringSync(this.f24717a, this.f24718b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public o(String r100, String r101) {
            this.f24717a = r100;
            this.f24718b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class p implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsonReader f24719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24720b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromJsonReaderSync(this.f24719a, this.f24720b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public p(JsonReader r100, String r101) {
            this.f24719a = r100;
            this.f24720b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class q implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZipInputStream f24721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24722b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return LottieCompositionFactory.fromZipStreamSync(this.f24721a, this.f24722b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public q(ZipInputStream r100, String r101) {
            this.f24721a = r100;
            this.f24722b = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static class r implements Callable<com.airbnb.lottie.l<LottieComposition>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieComposition f24723a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.l<LottieComposition> call() {
            return new com.airbnb.lottie.l(this.f24723a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.airbnb.lottie.l<LottieComposition> call() throws Exception {
            return call();
        }

        public r(LottieComposition r100) {
            this.f24723a = r100;
        }
    }

    static {
        taskCache = new ConcurrentHashMap();
        sComponentCallbackRegistered = false;
        sComponentCallback = new j();
    }

    public static void clearCache() {
        int r100 = r0.c.f535396a;
        if (r0.c.a.f535397a == false) goto L6;
        taskCache.clear();
        m0.g.f511472b.f511473a.evictAll();
        return;
    }

    public static String getCurCacheList() {
        StringBuilder r100 = new StringBuilder();
        r100.append(m0.g.f511472b.f511473a.snapshot().keySet().toString());
        Map<String, LottieTask<LottieComposition>> r101 = taskCache;
        if (r101 == null) goto L6;
        r100.append(" /---/ ");
        r100.append(r101.keySet().toString());
    L6:
        return r100.toString();
    }

    private LottieCompositionFactory() {
    }

    public static /* synthetic */ Map access$000() {
        return taskCache;
    }

    public static String assetCacheKey(String r100) {
        return "asset_" + r100;
    }

    public static void checkAndRegisterLowMemoryListener(Context r100) {
        if (sComponentCallbackRegistered == false) goto L5;
        return;
    L5:
        sComponentCallbackRegistered = true;
    }

    private static boolean checkComposition(LottieComposition r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<String, com.airbnb.lottie.h>> r101 = r100.getImages().entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (r101.next().getValue().f24784g != null) goto L7;
        return false;
    L11:
        return true;
    }

    public static String rawResCacheKey(int r100) {
        return "rawRes_" + r100;
    }

    public static void setMaxCacheSize(int r100) {
        m0.g.f511472b.f511473a.resize(r100);
    }

    private static LottieTask<LottieComposition> cache(String r100, Callable<com.airbnb.lottie.l<LottieComposition>> r101) {
        if (r100 != null) goto L4;
        LottieComposition r102 = null;
    L5:
        if (r102 != null) goto L7;
        if (r100 == null) goto L13;
        Map<String, LottieTask<LottieComposition>> r103 = taskCache;
        if (r103.containsKey(r100) == false) goto L13;
        return r103.get(r100);
    L13:
        LottieTask<LottieComposition> r104 = new LottieTask(r101);
        if (r100 == null) goto L16;
        r104.addListener(new a(r100));
        r104.addFailureListener(new b(r100));
        taskCache.put(r100, r104);
    L16:
        return r104;
    L7:
        return new LottieTask(new r(r102));
    L4:
        r102 = m0.g.f511472b.a(r100);
        goto L5
    }

    private static com.airbnb.lottie.h findImageAssetForFileName(LottieComposition r100, String r101) {
        Iterator<com.airbnb.lottie.h> r102 = r100.getImages().values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        com.airbnb.lottie.h r103 = r102.next();
        if (r103.f24781d.equals(r101) == false) goto L4;
        return r103;
    L8:
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context r100, String r101) {
        Context r102 = r100.getApplicationContext();
        return cache(assetCacheKey(r101), new k(r102, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromAssetSync(Context r100, String r101) {
        String r102 = assetCacheKey(r101);     // Catch: IOException -> L8
        if (r101.endsWith(".zip") == false) goto L7;
        return fromZipStreamSync(new ZipInputStream(r100.getAssets().open(r101)), r102);
    L7:
        return fromJsonInputStreamSync(r100.getAssets().open(r101), r102);
    L8:
        e = move-exception;
        return new com.airbnb.lottie.l(e);
    }

    public static LottieTask<LottieComposition> fromJson(JSONObject r100, String r101) {
        return cache(r101, new n(r100, r101));
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream r100, String r101) {
        return cache(r101, new m(r100, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromJsonInputStreamSync(InputStream r100, String r101) {
        return fromJsonInputStreamSync(r100, r101, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader r100, String r101) {
        return cache(r101, new p(r100, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromJsonReaderSync(JsonReader r100, String r101) {
        LottieComposition r102 = s0.n.a(r100);     // Catch: Exception -> L4
        m0.g.f511472b.b(r101, r102);     // Catch: Exception -> L4
        return new com.airbnb.lottie.l(r102);
    L4:
        e = move-exception;
        return new com.airbnb.lottie.l(e);
    }

    public static LottieTask<LottieComposition> fromJsonString(String r100, String r101) {
        return cache(r101, new o(r100, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromJsonStringSync(String r100, String r101) {
        return fromJsonReaderSync(new JsonReader(new StringReader(r100)), r101);
    }

    public static com.airbnb.lottie.l<LottieComposition> fromJsonSync(JSONObject r100, String r101) {
        return fromJsonStringSync(r100.toString(), r101);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context r100, int r101) {
        Context r102 = r100.getApplicationContext();
        return cache(rawResCacheKey(r101), new l(r102, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromRawResSync(Context r100, int r101) {
        return fromJsonInputStreamSync(r100.getResources().openRawResource(r101), rawResCacheKey(r101));
    L4:
        e = move-exception;
        return new com.airbnb.lottie.l(e);
    }

    public static LottieTask<LottieComposition> fromUrl(Context r100, String r101) {
        return new LottieTask(new q0.b(new q0.c(r100, r101)));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromUrlSync(Context r100, String r101) {
        return new q0.c(r100, r101).b();
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream r100, String r101) {
        return cache(r101, new q(r100, r101));
    }

    public static com.airbnb.lottie.l<LottieComposition> fromZipStreamSync(ZipInputStream r100, String r101) {
        com.airbnb.lottie.l<LottieComposition> r102 = fromZipStreamSyncInternal(r100, r101);     // Catch: Throwable -> L5
        u0.f.c(r100);
        return r102;
    L5:
        th = move-exception;
        u0.f.c(r100);
        throw th;
    }

    private static com.airbnb.lottie.l<LottieComposition> fromZipStreamSyncInternal(ZipInputStream r100, String r101) {
        HashMap r102 = new HashMap();
        ZipEntry r103 = r100.getNextEntry();     // Catch: IOException -> L49
        LottieComposition r104 = null;
    L4:
        if (r103 == null) goto L17;
        if (r103.getName().contains("__MACOSX") == false) goto L9;
        r100.closeEntry();     // Catch: IOException -> L49
    L15:
        r103 = r100.getNextEntry();     // Catch: IOException -> L49
        goto L4
    L9:
        if (r103.getName().contains(InvRouter.FLOW_SUFFIX) == false) goto L12;
        r104 = fromJsonInputStreamSync(r100, r101, false).f24812a;     // Catch: IOException -> L49
        goto L15
    L12:
        if (r103.getName().contains(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L14;
        String[] r105 = r103.getName().split(HTTP.URL_DEFAULT);     // Catch: IOException -> L49
        r102.put(r105[r105.length - 1], BitmapFactory.decodeStream(r100));     // Catch: IOException -> L49
        goto L15
    L14:
        r100.closeEntry();     // Catch: IOException -> L49
        goto L15
    L17:
        if (r104 == null) goto L19;
        Iterator r106 = r102.entrySet().iterator();
    L22:
        if (r106.hasNext() == false) goto L40;
        Map.Entry r107 = (Map.Entry) r106.next();
        com.airbnb.lottie.h r108 = findImageAssetForFileName(r104, (String) r107.getKey());
        if (r108 == null) goto L22;
        if (r0.c.a.f535397a == true) goto L27;
        r108.f24784g = (Bitmap) r107.getValue();
        goto L22
    L27:
        Bitmap r109 = (Bitmap) r107.getValue();
        int r110 = r108.f24778a;
        int r111 = r108.f24779b;
        u0.f.a r112 = u0.f.f548112a;
        if (r109 == null) goto L38;
        if (r110 <= 0) goto L38;
        if (r111 <= 0) goto L38;
        if (r109.getWidth() == r110) goto L35;
    L37:
        r109 = Bitmap.createScaledBitmap(r109, r110, r111, true);
        goto L38
    L35:
        if (r109.getHeight() != r111) goto L37;
    L38:
        r108.f24784g = r109;
        goto L22
    L40:
        Iterator<Map.Entry<String, com.airbnb.lottie.h>> r113 = r104.getImages().entrySet().iterator();
    L42:
        if (r113.hasNext() == false) goto L47;
        Map.Entry<String, com.airbnb.lottie.h> r114 = r113.next();
        if (r114.getValue().f24784g != null) goto L42;
        return new com.airbnb.lottie.l(new IllegalStateException("There is no image for " + r114.getValue().f24781d));
    L47:
        m0.g.f511472b.b(r101, r104);
        return new com.airbnb.lottie.l(r104);
    L19:
        return new com.airbnb.lottie.l(new IllegalArgumentException("Unable to parse composition"));
    L49:
        e = move-exception;
        return new com.airbnb.lottie.l(e);
    }

    private static com.airbnb.lottie.l<LottieComposition> fromJsonInputStreamSync(InputStream r100, String r101, boolean r102) {
        com.airbnb.lottie.l<LottieComposition> r103 = fromJsonReaderSync(new JsonReader(new InputStreamReader(r100)), r101);     // Catch: Throwable -> L6
        if (r102 == false) goto L5;
        u0.f.c(r100);
    L5:
        return r103;
    L6:
        th = move-exception;
        if (r102 == false) goto L9;
        u0.f.c(r100);
    L9:
        throw th;
    }

    private static void prepareBitmapForComposition(LottieComposition r100, com.airbnb.lottie.e r101, com.airbnb.lottie.b r102) {
        if (r100.getImages() != null) goto L5;
    L21:
        r100.setBitmapReady(true);
        r102.b(r100);
        return;
    L5:
        if (r100.getImages().size() == 0) goto L21;
        if (r100.getImages() == null) goto L20;
        AtomicInteger r103 = new AtomicInteger(r100.getImages().size());
        Iterator<Map.Entry<String, com.airbnb.lottie.h>> r104 = r100.getImages().entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L33;
        Map.Entry<String, com.airbnb.lottie.h> r105 = r104.next();
        if (r101 == null) goto L11;
        com.airbnb.lottie.h r106 = r105.getValue();
        if ("%s".equals(r106.f24781d) == true) goto L16;
        r101.C(r106, new i(r106, r103, r100, r102));
        goto L11
    L16:
        r100.setNeedPolyfill(true);
        if (r103.decrementAndGet() != 0) goto L11;
        r100.setBitmapReady(true);
        r102.b(r100);
        goto L11
    L33:
        return;
    }

    public static /* synthetic */ void access$100(String r100, String r101, WeakReference r102, WeakReference r103) {
        fromJsonFileAsyncInternal(r100, r101, r102, r103);
    }

    public static /* synthetic */ void access$300(String r100, String r101, WeakReference r102, WeakReference r103) {
        fromJsonStringAsyncInternal(r100, r101, r102, r103);
    }

    public static void fromJsonFileAsync(String r100, String r101, com.airbnb.lottie.e r102, com.airbnb.lottie.b r103) {
        LottieComposition r104 = m0.g.f511472b.a(r101);
        if (checkComposition(r104) == false) goto L6;
        r103.b(r104);
        return;
    L6:
        LottieTask.EXECUTOR.execute(new c(r102, r103, r100, r101));
    }

    private static void fromJsonFileAsyncInternal(String r100, String r101, WeakReference<com.airbnb.lottie.e> r102, WeakReference<com.airbnb.lottie.b> r103) {
        if (r102.get() != null) goto L5;
        return;
    L5:
        if (r103.get() == null) goto L24;
        com.airbnb.lottie.e r104 = r102.get();
        com.airbnb.lottie.b r105 = r103.get();
        com.airbnb.lottie.l<LottieComposition> r106 = fromJsonInputStreamSync(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100)), r101, true);     // Catch: Exception -> L18
        LottieComposition r107 = r106.f24812a;     // Catch: Exception -> L18
        if (r107 == null) goto L11;
        prepareBitmapForComposition(r107, r104, new d(r101, r105));
        return;
    L11:
        if (r106.f24813b == null) goto L13;
        String r108 = "fromJsonFileAsyncInternal Unable to parse composition and composition is null. exception is: " + r106.f24813b;
    L14:
        r105.a(r108);
        return;
    L13:
        r108 = "fromJsonFileAsyncInternal Unable to parse composition and composition is null.";
    L18:
        e = move-exception;
        r105.a("fromJsonFileAsyncInternal Unable to parse composition. Error msg is " + e);
        return;
    }

    public static void fromJsonStringAsync(String r100, String r101, com.airbnb.lottie.e r102, com.airbnb.lottie.b r103) {
        LottieComposition r104 = m0.g.f511472b.a(r101);
        if (checkComposition(r104) == false) goto L6;
        r103.b(r104);
        return;
    L6:
        LottieTask.EXECUTOR.execute(new g(r102, r103, r100, r101));
    }

    private static void fromJsonStringAsyncInternal(String r100, String r101, WeakReference<com.airbnb.lottie.e> r102, WeakReference<com.airbnb.lottie.b> r103) {
        if (r102.get() != null) goto L5;
        return;
    L5:
        if (r103.get() == null) goto L22;
        com.airbnb.lottie.b r104 = r103.get();
        com.airbnb.lottie.e r105 = r102.get();
        JsonReader r106 = new JsonReader(new StringReader(r100));
        prepareBitmapForComposition(s0.n.a(r106), r105, new h(r101, r104));     // Catch: Throwable -> L10
    L9:
        u0.f.c(r106);
        return;
    L10:
        th = move-exception;
        r104.a("load composition failed from json string. " + th.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        u0.f.c(r106);
        throw th;
    }

    public static /* synthetic */ void access$200(WeakReference r100, String r101, String r102, WeakReference r103, WeakReference r104) {
        fromJsonAssetAsyncInternal(r100, r101, r102, r103, r104);
    }

    public static void fromJsonAssetAsync(Context r100, String r101, String r110, com.airbnb.lottie.e r111, com.airbnb.lottie.b r112) {
        LottieComposition r102 = m0.g.f511472b.a(r110);
        if (checkComposition(r102) == false) goto L6;
        r112.b(r102);
        return;
    L6:
        LottieTask.EXECUTOR.execute(new e(r111, r112, r100, r101, r110));
    }

    private static void fromJsonAssetAsyncInternal(WeakReference<Context> r100, String r101, String r102, WeakReference<com.airbnb.lottie.e> r103, WeakReference<com.airbnb.lottie.b> r104) {
        if (r100.get() != null) goto L5;
        return;
    L5:
        if (r103.get() != null) goto L7;
        return;
    L7:
        if (r104.get() == null) goto L25;
        Context r105 = r100.get();
        com.airbnb.lottie.b r106 = r104.get();
        com.airbnb.lottie.e r107 = r103.get();
        com.airbnb.lottie.l<LottieComposition> r108 = fromAssetSync(r105, r101);     // Catch: Exception -> L19
        LottieComposition r109 = r108.f24812a;     // Catch: Exception -> L19
        if (r109 != null) goto L17;
        String r110 = "fromJsonAssetSyncInternal Unable to parse composition and composition is null.";
        if (r108.f24813b == null) goto L15;
        r110 = "fromJsonAssetSyncInternal Unable to parse composition and composition is null.exception is: " + r108.f24813b;     // Catch: Exception -> L19
    L15:
        r106.a(r110);     // Catch: Exception -> L19
        return;
    L17:
        prepareBitmapForComposition(r109, r107, new f(r102, r106));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        r106.a("load composition failed from asset. " + e.getMessage());
        return;
    }
}

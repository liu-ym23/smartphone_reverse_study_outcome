package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.e3;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.livesdk.config.ni1;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import dagger.internal.SetBuilder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class LivePrefetchProcessor implements com.bytedance.android.live.browser.jsbridge.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f63765d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, x46.a> f63766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public Set<com.bytedance.android.live.browser.jsbridge.g> f63767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public w f63768c;

    public static final class LocalStorageImpl implements com.bytedance.ies.tools.prefetch.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f63769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f63770b;

        @Override // com.bytedance.ies.tools.prefetch.h
        public final void removeAll() {
        }

        @Override // com.bytedance.ies.tools.prefetch.h
        public final Collection b() {
            Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
            return ((com.bytedance.android.tools.superkv.e) this.f63769a.getValue()).b();
        }

        public LocalStorageImpl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            this.f63770b = r100;
            this.f63769a = LazyKt.lazy(new LivePrefetchProcessor$LocalStorageImpl$dataStore$2(this));
        }

        @Override // com.bytedance.ies.tools.prefetch.h
        public final void a(Collection r100) {
            Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
            Intrinsics.checkNotNullParameter(r100, "collection");
            ((com.bytedance.android.tools.superkv.e) this.f63769a.getValue()).a(r100);
        }

        @Override // com.bytedance.ies.tools.prefetch.h
        public final String getString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return ((com.bytedance.android.tools.superkv.e) this.f63769a.getValue()).getString(r100);
        }

        @Override // com.bytedance.ies.tools.prefetch.h
        public final void remove(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            ((com.bytedance.android.tools.superkv.e) this.f63769a.getValue()).remove(r100);
        }

        @Override // com.bytedance.ies.tools.prefetch.h
        public final void putString(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            ((com.bytedance.android.tools.superkv.e) this.f63769a.getValue()).putString(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePrefetchProcessor f63771a;

        public b(LivePrefetchProcessor r100) {
            this.f63771a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            LivePrefetchProcessor r100 = this.f63771a;
            w r101 = r100.f63768c;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L6:
            return new com.bytedance.android.live.browser.jsbridge.prefetch.a(r100, r101);
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f63772a = null;

        static {
            f63772a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            if (ni1.f120836a.getValue().booleanValue() == false) goto L6;
            return new FetchV3Method();
        L6:
            return new e3();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void init() {
        BrowserServiceImpl.Companion.getClass();
        s20.a r100 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        this.f63767b = SetBuilder.newSetBuilder(2).add(r100.f540207a.f540220m.get()).add(r100.f540207a.f540221n.get()).build();
        this.f63768c = r100.f540207a.f540215h.get();
        Set<com.bytedance.android.live.browser.jsbridge.g> r101 = this.f63767b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("providers");
    L5:
        Observable.merge(SequencesKt.asIterable(SequencesKt.map(CollectionsKt.asSequence(r101), LivePrefetchProcessor$initActual$1.INSTANCE))).subscribeOn(Schedulers.io()).filter(e.f63799a).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.f63801a);
        Observable.fromCallable(h.f63802a).subscribeOn(Schedulers.io()).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    public LivePrefetchProcessor() {
        this.f63766a = MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void a(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        if ((!this.f63766a.isEmpty()) == false) goto L5;
        r100.registerMethod("__prefetch", new b(this));
        return;
    L5:
        r100.registerMethod("__prefetch", c.f63772a);
    }

    public final x46.a c(final String r100) {
        if (r100 == null) goto L26;
        Map<String, x46.a> r101 = this.f63766a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Matcher r103 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(TTLiveWebOfflineConfig.getGroupTypePattern()), new LivePrefetchProcessor$getChannelFrom$$inlined$runCatching$lambda$1(r100)), LivePrefetchProcessor$getChannelFrom$1$2.INSTANCE));     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        String r104 = StringsKt.substringBefore$default(b(r100, r103), '/', null, 2, null);     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        int r107 = x8.a.f562881a;
        x8.a.b("LivePrefetchProcessor", "get channel from url failed, url: " + r100 + ", exception=" + r106.getMessage(), false);
    L17:
        if (Result.m9455isFailureimpl(r105) == false) goto L19;
        r105 = null;
    L19:
        x46.a r108 = r101.get((String) r105);
        if (r108 != null) goto L23;
        r108 = this.f63766a.get(null);
    L23:
        return r108;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L26:
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final Map<String, Object> getCacheByScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        x46.a r101 = c(r100);
        if (r101 == null) goto L5;
        List<PrefetchProcess> r102 = r101.getCacheByScheme(r100);
    L6:
        LinkedHashMap r103 = new LinkedHashMap();
        if (r102 == null) goto L14;
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        PrefetchProcess r105 = (PrefetchProcess) r104.next();
        com.bytedance.ies.tools.prefetch.i.b r106 = r105.f248738d;
        if (r106 == null) goto L10;
        r103.put(r105.f248740f.f248748d, r106);
    L14:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final JSONObject getCacheJsonByScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        x46.a r101 = c(r100);
        if (r101 == null) goto L48;
        List<PrefetchProcess> r102 = r101.getCacheByScheme(r100);
        if (r102 == null) goto L49;
        Iterator<T> r103 = r102.iterator();
        JSONObject r104 = null;
    L8:
        if (r103.hasNext() == false) goto L34;
        PrefetchProcess r105 = (PrefetchProcess) r103.next();
        String r106 = r105.f248740f.f248748d;
        boolean r107 = false;
        if (r106.length() != 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L8;
        com.bytedance.ies.tools.prefetch.i.b r109 = r105.f248738d;
        if (r109 == null) goto L8;
        if ((r109 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == true) goto L20;
    L22:
        if (r107 == true) goto L25;
        r109 = null;
    L25:
        if (r109 == null) goto L8;
        JSONObject r110 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r109).f63777g.getValue();
        if (r110 == null) goto L8;
        JSONObject r111 = r110.optJSONObject(TemplateNodeType.RAW);
        if (r111 == null) goto L8;
        if (r104 != null) goto L32;
        r104 = new JSONObject();
    L32:
        r104.put(r106, r111);
        goto L8
    L20:
        if (r109.f248823d != 200) goto L22;
        r107 = true;
        goto L22
    L12:
        r108 = false;
        goto L13
    L34:
        return r104;
    L49:
        return null;
    L48:
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void prefetch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        x46.a r101 = c(r100);
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public static String b(String r100, Matcher r110) {
        int r101 = StringsKt.indexOf$default(r100, "?", 0, false, 6, null);
        int r102 = StringsKt.indexOf$default(r100, "#", 0, false, 6, null);
        Integer r103 = Integer.valueOf(RangesKt.coerceAtMost(r101, r102));
        if (r103.intValue() < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L11;
        int r105 = r103.intValue();
    L13:
        if (r105 == (-1)) goto L19;
        int r111 = r110.end();
        if (r100 == null) goto L18;
        String r106 = r100.substring(r111, r105);
    L23:
        return StringsKt.trim(r106, new char[]{'/'});
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r112 = r110.end();
        if (r100 == null) goto L25;
        r106 = r100.substring(r112);
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        r105 = RangesKt.coerceAtLeast(r101, r102);
        goto L13
    L5:
        r104 = false;
        goto L6
    }
}

package com.bytedance.android.annie.service.prefetch;

import android.net.Uri;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
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

/* JADX INFO: loaded from: classes43.dex */
public final class AnniePrefetchProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, x46.a> f39930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f39931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f39932c;

    public static final class a {
    }

    public static final class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39933a = null;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f39934a = null;

            static {
                f39934a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                ((Runnable) r100).run();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.annie.service.prefetch.AnniePrefetchProcessor$b$b, reason: collision with other inner class name */
        public static final class C0748b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0748b<T> f39935a = null;

            static {
                f39935a = new C0748b();
            }

            public C0748b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
            }
        }

        static {
            f39933a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            Observable.just(r100).subscribeOn(Schedulers.io()).subscribe(a.f39934a, C0748b.f39935a);
        }
    }

    public static final class c implements com.bytedance.ies.tools.prefetch.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f39936a;

        @Override // com.bytedance.ies.tools.prefetch.g
        public final List<String> a() {
            return this.f39936a;
        }

        public c(List<String> r100) {
            this.f39936a = r100;
        }
    }

    static {
    }

    public AnniePrefetchProcessor() {
        this.f39930a = MapsKt.emptyMap();
        this.f39931b = LazyKt.lazy(AnniePrefetchProcessor$providers$2.INSTANCE);
    }

    public final String a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        int r101 = x8.a.f562881a;
        x8.a.d("AnniePrefetchProcessor", "getChannelFrom(url=" + r100 + ')', false);
        Object r102 = null;
        if (AnnieConfigSettingKeys.ANNIE_TRY_FIX_PREFETCH_OUT_OF_INDEX.a().booleanValue() == false) goto L56;
        x8.a.d("AnniePrefetchProcessor", "getChannelFromFixed(url=" + r100 + ')', false);
        Uri r103 = UriProtector.parse(r100);
        if (r103.isHierarchical() == false) goto L7;
        final String r104 = r103.getHost() + r103.getPath();
    L9:
        if (r104.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L58;
        x8.a.b("AnniePrefetchProcessor", "getChannelFromFixed, invalid url=" + r100, false);
        return null;
    L58:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L24
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L24
        Iterator<T> r108 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();     // Catch: Throwable -> L24
    L16:
        if (r108.hasNext() == false) goto L18;
        r107.add(PatternProtector.compile((String) r108.next()));     // Catch: Throwable -> L24
        goto L16
    L18:
        Matcher r109 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r107), new AnniePrefetchProcessor$getChannelFromFixed$1$2(r104)), AnniePrefetchProcessor$getChannelFromFixed$1$3.INSTANCE));     // Catch: Throwable -> L24
        if (r109 == null) goto L21;
        String r110 = StringsKt.substringBefore$default(b(r104, r109), '/', null, 2, null);     // Catch: Throwable -> L24
    L22:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L24
    L26:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L30;
        int r113 = x8.a.f562881a;
        x8.a.b("AnniePrefetchProcessor", "getChannelFromFixed Failure, exception=" + r112.getMessage(), false);
    L30:
        if (Result.m9455isFailureimpl(r111) == true) goto L34;
        r102 = r111;
    L34:
        return (String) r102;
    L21:
        r110 = null;
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L11:
        r105 = false;
        goto L12
    L7:
        r104 = toString();
        goto L9
    L56:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L45
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L45
        Iterator<T> r117 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();     // Catch: Throwable -> L45
    L37:
        if (r117.hasNext() == false) goto L39;
        r116.add(PatternProtector.compile((String) r117.next()));     // Catch: Throwable -> L45
        goto L37
    L39:
        Matcher r118 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r116), new AnniePrefetchProcessor$getChannelFrom$1$2(r100)), AnniePrefetchProcessor$getChannelFrom$1$3.INSTANCE));     // Catch: Throwable -> L45
        if (r118 == null) goto L42;
        String r119 = StringsKt.substringBefore$default(b(r100, r118), '/', null, 2, null);     // Catch: Throwable -> L45
    L43:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L45
    L47:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L51;
        int r122 = x8.a.f562881a;
        x8.a.b("AnniePrefetchProcessor", "getChannelFrom Failure, exception=" + r121.getMessage(), false);
    L51:
        if (Result.m9455isFailureimpl(r120) == true) goto L55;
        r102 = r120;
    L55:
        return (String) r102;
    L42:
        r119 = null;
    L45:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    }

    public final x46.a d(String r100) {
        if (r100 == null) goto L9;
        x46.a r101 = this.f39930a.get(a(r100));
        if (r101 != null) goto L8;
        r101 = this.f39930a.get(null);
    L8:
        return r101;
    L9:
        return null;
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

    public static final x46.a c(AnniePrefetchProcessor r100, List<String> r101) {
        x46.a r102 = x46.a.f562442b;
        t r103 = r100.f39932c;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r103 = null;
    L5:
        r103.getClass();
        x46.a.b r104 = new x46.a.b();
        com.bytedance.android.anniex.assemble.a.h();
        r104.f248779e = false;
        r104.f248776b = b.f39933a;
        r104.f248778d = new c(r101);
        r104.f248777c = new PrefetchNetworkExecutorImpl();
        return r104.a();
    }
}

package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.util.Pair;
import com.bytedance.android.livesdk.config.gj0;
import com.bytedance.android.livesdk.config.td1;
import com.bytedance.android.livesdk.f4;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.inv.export.router.InvRouter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class j implements com.bytedance.android.live.browser.jsbridge.g {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f63806a = null;

        static {
            f63806a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "channel");
            InputStream r102 = com.bytedance.android.livesdk.gecko.n.f125818b.a("prefetch." + r101 + InvRouter.FLOW_SUFFIX, r101);
            if (r102 == null) goto L18;
            Reader r103 = new InputStreamReader(r102, Charsets.UTF_8);
            if ((r103 instanceof BufferedReader) == false) goto L7;
            BufferedReader r104 = (BufferedReader) r103;
        L19:
            String r105 = TextStreamsKt.readText(r104);     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r104, null);
            if (r105 == null) goto L18;
            return new com.bytedance.android.live.browser.jsbridge.g.a(r101, r105);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r104, th);
            throw th;
        L7:
            r104 = new BufferedReader(r103, 8192);
        L18:
            return com.bytedance.android.live.browser.jsbridge.g.a.f63197c;
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f63807a = null;

        static {
            f63807a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Throwable) r100, "it");
            return com.bytedance.android.live.browser.jsbridge.g.a.f63197c;
        }
    }

    public static final class c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f63808a = null;

        static {
            f63808a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            com.bytedance.android.live.browser.jsbridge.g.a r101 = (com.bytedance.android.live.browser.jsbridge.g.a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101 == com.bytedance.android.live.browser.jsbridge.g.a.f63197c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.live.browser.jsbridge.g
    public final Observable<com.bytedance.android.live.browser.jsbridge.g.a> getConfig() {
        if (td1.f121290a.getValue().booleanValue() == false) goto L15;
        LiveResourcesDistributionImpl r100 = com.bytedance.android.livesdk.gecko.n.f125818b.f125819a;
        r100.getClass();
        if (f4.f123402a.getValue().booleanValue() == false) goto L10;
        List<Pair<String, Long>> r101 = ResLoadUtils.getAllLocalChannels(new PolarisFileWrapper(LiveGeckoConfig.c()), LiveGeckoConfig.b());
        List<String> r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        r102.add((String) ((Pair) r103.next()).first);
    L17:
        return Observable.fromIterable((Iterable) r102).subscribeOn(Schedulers.io()).map(a.f63806a).onErrorReturn(b.f63807a).filter(c.f63808a);
    L10:
        com.bytedance.android.livesdk.gecko.j r104 = r100.f125787a;
        if (r104 == null) goto L14;
        r102 = r104.b();
        if (r102 != 0) goto L17;
    L14:
        r102 = CollectionsKt.emptyList();
        goto L17
    L15:
        r102 = TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST;
        r102.addAll(gj0.f120292a.getValue());
        goto L17
    }
}

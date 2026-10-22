package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallGulPrefetch implements ECHybridNetworkTask.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f170248h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f170249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HomePageDTO f170250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECHybridNetworkVO f170251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super HomePageDTO, ? super ECHybridNetworkVO, Unit> f170252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f170253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r93.b f170254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f170255g;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallGulPrefetch$Companion$PrefetchState;", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PrefetchState {
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallGulPrefetch$Companion$a;", "", "", "switch", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "getPageName", "()Ljava/util/ArrayList;", "remainNumOfUseCache", "getRemainNumOfUseCache", "remainNumOfFirstUseCache", "getRemainNumOfFirstUseCache", "waitStrategy", "f", "fetchOnFirstScreen", "getFetchOnFirstScreen", "loadMoreOnlyByManual", "c", "removeUnusedCache", "d", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("fetch_on_first_screen")
            private final Integer fetchOnFirstScreen;

            @SerializedName("load_more_only_by_manual")
            private final Integer loadMoreOnlyByManual;

            @SerializedName("page_name")
            private final ArrayList<String> pageName;

            @SerializedName("remain_num_of_first_use_cache")
            private final Integer remainNumOfFirstUseCache;

            @SerializedName("remain_num_of_use_cache")
            private final Integer remainNumOfUseCache;

            @SerializedName("remove_unused_cache")
            private final Integer removeUnusedCache;

            /* JADX INFO: renamed from: switch, reason: not valid java name */
            @SerializedName("preload_switch")
            private final Integer f95switch;

            @SerializedName("wait_new_or_ues_old")
            private final Integer waitStrategy;

            public a() {
                this(null);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L22;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f95switch, r101.f95switch) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.remainNumOfUseCache, r101.remainNumOfUseCache) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.remainNumOfFirstUseCache, r101.remainNumOfFirstUseCache) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.waitStrategy, r101.waitStrategy) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.fetchOnFirstScreen, r101.fetchOnFirstScreen) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.loadMoreOnlyByManual, r101.loadMoreOnlyByManual) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.removeUnusedCache, r101.removeUnusedCache) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public final int hashCode() {
                Integer r100 = this.f95switch;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                ArrayList<String> r104 = this.pageName;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.remainNumOfUseCache;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.remainNumOfFirstUseCache;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                Integer r113 = this.waitStrategy;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                Integer r116 = this.fetchOnFirstScreen;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                Integer r119 = this.loadMoreOnlyByManual;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                Integer r122 = this.removeUnusedCache;
                if (r122 == null) goto L34;
                r101 = r122.hashCode();
            L34:
                return r121 + r101;
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "GulPrefetchConfig(switch=" + this.f95switch + ", pageName=" + this.pageName + ", remainNumOfUseCache=" + this.remainNumOfUseCache + ", remainNumOfFirstUseCache=" + this.remainNumOfFirstUseCache + ", waitStrategy=" + this.waitStrategy + ", fetchOnFirstScreen=" + this.fetchOnFirstScreen + ", loadMoreOnlyByManual=" + this.loadMoreOnlyByManual + ", removeUnusedCache=" + this.removeUnusedCache + ")";
            }

            public final Integer c() {
                return this.loadMoreOnlyByManual;
            }

            public final Integer d() {
                return this.removeUnusedCache;
            }

            public final Integer e() {
                return this.f95switch;
            }

            public final Integer f() {
                return this.waitStrategy;
            }

            public a(Object r100) {
                this.f95switch = null;
                this.pageName = null;
                this.remainNumOfUseCache = null;
                this.remainNumOfFirstUseCache = null;
                this.waitStrategy = null;
                this.fetchOnFirstScreen = null;
                this.loadMoreOnlyByManual = null;
                this.removeUnusedCache = null;
            }

            public final boolean a(String r100) {
                if (r100 != null) goto L5;
                return false;
            L5:
                ArrayList<String> r101 = this.pageName;
                if (r101 != null) goto L8;
                return false;
            L8:
                if (r101.contains(r100) != true) goto L17;
                Integer r102 = this.fetchOnFirstScreen;
                if (r102 != null) goto L13;
                return false;
            L13:
                if (r102.intValue() != 1) goto L18;
                return true;
            L18:
                return false;
            L17:
                return false;
            }

            public final boolean b(String r100) {
                if (r100 != null) goto L5;
                return false;
            L5:
                ArrayList<String> r101 = this.pageName;
                if (r101 != null) goto L8;
                return false;
            L8:
                if (r101.contains(r100) != true) goto L12;
                return true;
            L12:
                return false;
            }

            public final Integer g(String r100) {
                if (r100 != null) goto L5;
                return null;
            L5:
                ArrayList<String> r101 = this.pageName;
                if (r101 != null) goto L8;
            L11:
                return null;
            L8:
                if (r101.contains(r100) != true) goto L11;
                return this.remainNumOfUseCache;
            }

            public final Integer h(String r100) {
                if (r100 != null) goto L5;
                return null;
            L5:
                ArrayList<String> r101 = this.pageName;
                if (r101 != null) goto L8;
            L11:
                return null;
            L8:
                if (r101.contains(r100) != true) goto L11;
                return this.remainNumOfFirstUseCache;
            }
        }

        public static a a() {
            return (a) ECMallGulPrefetch.f170248h.getValue();
        }
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
    public final void d(String r100, String r101, ECHybridNetworkVO r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "requestVO");
    }

    static {
        f170248h = LazyKt.lazy(ECMallGulPrefetch$Companion$gulPrefetchConfig$2.INSTANCE);
    }

    public final void a() {
        Object r100 = this.f170249a;
        monitor-enter(r100);
        this.f170255g = "init";     // Catch: Throwable -> L7
        this.f170250b = null;     // Catch: Throwable -> L7
        this.f170253e = null;     // Catch: Throwable -> L7
        this.f170252d = null;     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final r93.b b() {
        HomePageDTO r100 = this.f170250b;
        if (r100 == null) goto L18;
        ArrayList r101 = new ArrayList();
        HomePageBffDTO r102 = r100.getBff();
        if (r102 == null) goto L17;
        BffBizInfo r103 = r102.getBizInfo();
        if (r103 == null) goto L17;
        List<String> r104 = r103.getFilters();
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        List r106 = StringsKt.split$default((String) r105.next(), new String[]{"_"}, false, 0, 6, null);
        if (r106.size() != 2) goto L12;
        r101.add(new r93.a(StringsKt.toIntOrNull((String) ListProtector.get(r106, 0)), (String) ListProtector.get(r106, 1)));
    L17:
        return new r93.b(r101);
    L18:
        return null;
    }

    public final void g() {
        Object r100 = this.f170249a;
        monitor-enter(r100);
        this.f170255g = "running";     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ECMallGulPrefetch() {
        this.f170249a = new Object();
        this.f170255g = "init";
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
    public final void c(String r100, final String r101, final ECHybridNetworkVO r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r110, "requestVO");
        ECHybridNetworkTask.a.C0818a.c(r100, r101, r110);
        if ((!Intrinsics.areEqual(r100, "favorite_feed")) == false) goto L5;
        return;
    L5:
        Lazy r102 = ECMallLogUtil.f47441a;
        r.b r103 = r.b.f47517b;
        ECMallLogUtil.c(r103, "on result in gul prefetch, state is " + this.f170255g);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L46
        final HomePageDTO r105 = (HomePageDTO) new Gson().fromJson(r101, HomePageDTO.class);     // Catch: Throwable -> L46
        if (r105 != null) goto L13;
        Function0<Unit> r106 = this.f170253e;     // Catch: Throwable -> L46
        if (r106 == null) goto L11;
        Unit r107 = r106.invoke();     // Catch: Throwable -> L46
    L11:
        a();     // Catch: Throwable -> L46
        return;
    L13:
        Object r108 = this.f170249a;     // Catch: Throwable -> L46
        monitor-enter(r108);     // Catch: Throwable -> L46
        String r109 = this.f170255g;     // Catch: Throwable -> L43
        int r112 = r109.hashCode();     // Catch: Throwable -> L43
        if (r112 == (-180585540)) goto L33;
        if (r112 == 3237136) goto L28;
        if (r112 == 301635111) goto L23;
    L40:
        this.f170250b = r105;     // Catch: Throwable -> L43
        this.f170251c = r110;     // Catch: Throwable -> L43
        this.f170255g = VideoEventOneOutSync.END_TYPE_FINISH;     // Catch: Throwable -> L43
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L46
        return;
    L23:
        if (r109.equals("wait_result") == false) goto L40;
        ECMallLogUtil.c(r103, "success ballback is " + this.f170252d);     // Catch: Throwable -> L43
        final Function2<? super HomePageDTO, ? super ECHybridNetworkVO, Unit> r114 = this.f170252d;     // Catch: Throwable -> L43
        ECHybridExtensionsKt.g(new ECMallGulPrefetch$onResult$$inlined$runCatching$lambda$1(r114, this, r105, r101, r110));     // Catch: Throwable -> L43
        this.f170252d = null;     // Catch: Throwable -> L43
        this.f170253e = null;     // Catch: Throwable -> L43
        this.f170255g = "init";     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L46
        return;
    L28:
        if (r109.equals("init") == false) goto L40;
        a();     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L46
        return;
    L33:
        if (r109.equals("invalid_second") == false) goto L40;
        Function0<Unit> r115 = this.f170253e;     // Catch: Throwable -> L43
        if (r115 == null) goto L37;
        Unit r116 = r115.invoke();     // Catch: Throwable -> L43
    L37:
        a();     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L46
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        Function0<Unit> r118 = this.f170253e;
        if (r118 == null) goto L53;
        Unit r119 = r118.invoke();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
    public final void e(String r100, Throwable r101, ECHybridNetworkVO r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "t");
        Object r104 = this.f170249a;
        monitor-enter(r104);
        this.f170255g = "init";     // Catch: Throwable -> L10
        Function0<Unit> r105 = this.f170253e;     // Catch: Throwable -> L10
        if (r105 == null) goto L7;
        Unit r106 = r105.invoke();     // Catch: Throwable -> L10
    L7:
        this.f170253e = null;     // Catch: Throwable -> L10
        this.f170252d = null;     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r104);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask.a
    public final void f(String r100, String r101, ECHybridNetworkVO r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "requestVO");
        ECHybridNetworkTask.a.C0818a.b(r100, r101, r102);
    }
}

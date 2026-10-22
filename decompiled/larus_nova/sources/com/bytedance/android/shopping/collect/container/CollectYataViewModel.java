package com.bytedance.android.shopping.collect.container;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.collect.repo.CollectYataQueryFetcher;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ8\u0010\u0016\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00140\u0012J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0006\u0010\u001a\u001a\u00020\u0005J2\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0013\u00102\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/collect/container/CollectYataState;", "Lcom/bytedance/android/shopping/collect/repo/a;", "queryState", "", "showPageState", "", "", "getCommonTrackerParams", "defaultState", "Lub3/a;", "getCollectCustomDataCenter", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "collectParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "customDataCenter", "Lkotlin/Function0;", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "Lcom/bytedance/kmp/ec/yata/YaTaInstance;", "yataInstance", "init", "Lcom/bytedance/android/shopping/collect/container/CollectYataQueryFrom;", "queryFrom", "requestQuery", "release", "name", "", "params", "duplicateKey", "doEventAction", "Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "getCollectParams", "()Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;", "setCollectParams", "(Lcom/bytedance/android/shopping/collect/repo/model/CollectParams;)V", "collectCustomDataCenter", "Lub3/a;", "Lcom/bytedance/android/shopping/collect/repo/CollectYataQueryFetcher;", "queryFetcher", "Lcom/bytedance/android/shopping/collect/repo/CollectYataQueryFetcher;", "Ltb3/b;", "trackerImpl", "Ltb3/b;", "btmPageFinder", "Lcom/bytedance/android/btm/api/model/PageFinder;", "Lpb3/a;", "getMonitorManager", "()Lpb3/a;", "monitorManager", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectYataViewModel extends JediViewModel<CollectYataState> {
    private PageFinder btmPageFinder;
    private ub3.a collectCustomDataCenter;
    private CollectParams collectParams;
    private CollectYataQueryFetcher queryFetcher;
    private final tb3.b trackerImpl;

    private final Map<String, String> getCommonTrackerParams() {
        Pair[] r100 = new Pair[4];
        r100[0] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r100[1] = TuplesKt.to("page_name", "collect_list_page");
        CollectParams r101 = this.collectParams;
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.getPreviousPage();
        if (r103 == null) goto L6;
    L7:
        r100[2] = TuplesKt.to("previous_page", r103);
        CollectParams r104 = this.collectParams;
        if (r104 == null) goto L10;
        String r105 = r104.getSession_id();
    L11:
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        r100[3] = TuplesKt.to("session_id", r102);
        return MapsKt.mapOf(r100);
    L10:
        r105 = null;
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public CollectYataState defaultState() {
        return new CollectYataState(null, null);
    }

    public final pb3.a getMonitorManager() {
        CollectYataQueryFetcher r100 = this.queryFetcher;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final void release() {
        CollectYataQueryFetcher r100 = this.queryFetcher;
        if (r100 == null) goto L8;
        r100.f172255c = null;
        Disposable r101 = r100.f172256d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    L9:
        return;
    }

    public CollectYataViewModel() {
        CollectCommonLog.c("CollectYataViewModel", "init");
        this.trackerImpl = new tb3.b();
    }

    public final ub3.a getCollectCustomDataCenter() {
        return this.collectCustomDataCenter;
    }

    public final CollectParams getCollectParams() {
        return this.collectParams;
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ CollectYataQueryFetcher access$getQueryFetcher$p(CollectYataViewModel r100) {
        return r100.queryFetcher;
    }

    private final void showPageState(final com.bytedance.android.shopping.collect.repo.a r100) {
        a r101 = r100.f172269c;
        if (r101 == null) goto L5;
        CollectYataSkeletonLoadingStatus r102 = r101.f172152b;
    L6:
        if (r102 == null) goto L14;
        int r103 = e.f172158a[r102.ordinal()];
        if (r103 != 1) goto L11;
        setState(new AnonymousClass1(this, r100));
        return;
    L11:
        if (r103 != 2) goto L13;
        final d r104 = r100.f172268b;
        if (r104 == null) goto L23;
        setState(new CollectYataViewModel$showPageState$$inlined$also$lambda$1(r104, this, r100));
        return;
    L23:
        return;
    L13:
        if (r103 != 3) goto L14;
        setState(new AnonymousClass3(r100));
        return;
    L14:
        CollectCommonLog.c("CollectYataViewModel", "errorStatus");
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void requestQuery(CollectYataQueryFrom r100) {
        Intrinsics.checkNotNullParameter(r100, "queryFrom");
        if (r100 != CollectYataQueryFrom.FIRST_ENTER) goto L5;
        int r101 = tb3.a.f545246a;
        tb3.a.a("start", MapsKt.emptyMap(), this);
    L5:
        CollectYataQueryFetcher r102 = this.queryFetcher;
        if (r102 == null) goto L9;
        r102.b(r100, this);
        return;
    }

    public final void setCollectParams(CollectParams r100) {
        this.collectParams = r100;
    }

    public static final /* synthetic */ void access$setQueryFetcher$p(CollectYataViewModel r100, CollectYataQueryFetcher r101) {
        r100.queryFetcher = r101;
    }

    public static final /* synthetic */ void access$showPageState(CollectYataViewModel r100, com.bytedance.android.shopping.collect.repo.a r101) {
        r100.showPageState(r101);
    }

    public final void doEventAction(String r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(getCommonTrackerParams());
        r103.putAll(r101);
        tb3.b r104 = this.trackerImpl;
        PageFinder r105 = this.btmPageFinder;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r103, "params");
        if (k.c(r102) == true) goto L5;
    L7:
        if (r102 == null) goto L9;
        r104.f545248b.add(r102);
    L9:
        LinkedHashMap r106 = new LinkedHashMap();
        r106.putAll(r104.f545249c);
        r106.putAll(r103);
        r104.f545247a.doEventAction(r100, r105, r106);
        return;
    L5:
        if (CollectionsKt.contains(r104.f545248b, r102) == false) goto L7;
    }

    public final void init(CollectParams r100, PageFinder r101, ub3.a r102, Function0<AndroidYaTaInstance> r103) {
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r103, "yataInstance");
        this.collectCustomDataCenter = r102;
        this.collectParams = r100;
        this.btmPageFinder = r101;
        if (r100 == null) goto L5;
        CollectYataQueryFetcher r104 = new CollectYataQueryFetcher(r100);
    L6:
        this.queryFetcher = r104;
        if (r104 == null) goto L9;
        r104.f172255c = new AnonymousClass2(this);
    L9:
        CollectYataQueryFetcher r105 = this.queryFetcher;
        if (r105 == null) goto L13;
        Intrinsics.checkNotNullParameter(r103, "yataInstance");
        r105.f172257e = r103;
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doEventAction$default(CollectYataViewModel r100, String r101, Map r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = MapsKt.emptyMap();
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.doEventAction(r101, r102, r103);
    }
}

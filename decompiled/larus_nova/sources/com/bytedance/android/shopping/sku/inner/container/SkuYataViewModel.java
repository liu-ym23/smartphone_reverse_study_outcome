package com.bytedance.android.shopping.sku.inner.container;

import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcher;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcherHolder;
import com.bytedance.android.shopping.sku.inner.tracker.SkuYataTracker;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0006\u0010\u0016\u001a\u00020\u0005R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R(\u0010(\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0013\u0010/\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/sku/inner/container/SkuYataState;", "Lcom/bytedance/android/shopping/sku/inner/repo/b;", "firstScreenQuery", "", "showPageState", "defaultState", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "skuParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "skuSchemaParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "", "sessionId", "Landroidx/fragment/app/Fragment;", "skuYataFragment", "init", "Lcom/bytedance/android/shopping/sku/inner/container/SkuYataQueryFrom;", "queryFrom", "requestQuery", "release", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "getSkuParams", "()Lcom/bytedance/android/ec/model/sku/SkuParams;", "setSkuParams", "(Lcom/bytedance/android/ec/model/sku/SkuParams;)V", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "getSkuSchemaParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "setSkuSchemaParams", "(Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;)V", "Lcom/bytedance/android/shopping/sku/inner/container/h0;", "staticState", "Lcom/bytedance/android/shopping/sku/inner/container/h0;", "getStaticState", "()Lcom/bytedance/android/shopping/sku/inner/container/h0;", "Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "<set-?>", "queryFetcher", "Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "getQueryFetcher", "()Lcom/bytedance/android/shopping/sku/inner/repo/SkuYataQueryFetcher;", "Lmh3/a;", "getMonitorManager", "()Lmh3/a;", "monitorManager", "Lcom/bytedance/android/shopping/sku/inner/tracker/SkuYataTracker;", "getTracker", "()Lcom/bytedance/android/shopping/sku/inner/tracker/SkuYataTracker;", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataViewModel extends JediViewModel<SkuYataState> {
    private SkuYataQueryFetcher queryFetcher;
    private SkuParams skuParams;
    private SkuSchemaParams skuSchemaParams;
    private final h0 staticState;

    public SkuYataViewModel() {
        String r110 = null;
        boolean r111 = false;
        String r210 = null;
        String r211 = null;
        String r212 = null;
        String r213 = null;
        String r214 = null;
        String r215 = null;
        String r216 = null;
        boolean r217 = false;
        int r218 = 0;
        String r112 = "";
        this.skuParams = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, r112, "", r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, 101, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, 0, "SkuYataViewModel", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, null, null, null, null, null, null, -134266881, -1, -257, 31, null);
        this.staticState = new h0(0);
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public SkuYataState defaultState() {
        return new SkuYataState(null, null);
    }

    public final mh3.a getMonitorManager() {
        SkuYataQueryFetcher r100 = this.queryFetcher;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final SkuYataTracker getTracker() {
        SkuYataQueryFetcher r100 = this.queryFetcher;
        if (r100 == null) goto L7;
        SkuYataTracker r101 = r100.f182935b;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new SkuYataTracker(this.skuParams);
    }

    public final void release() {
        SkuYataQueryFetcher r100 = this.queryFetcher;
        if (r100 == null) goto L9;
        r100.f182937d = null;
        Disposable r101 = r100.f182938e;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        SkuYataQueryFetcherHolder r102 = SkuYataQueryFetcherHolder.INSTANCE;
        r102.remove(r100.f182942i);
        Lazy r103 = SkuCommonLog.f182771a;
        SkuCommonLog.c("SkuYataQueryFetcher", "fetchers size: " + r102.size());
        return;
    }

    public final SkuYataQueryFetcher getQueryFetcher() {
        return this.queryFetcher;
    }

    public final SkuParams getSkuParams() {
        return this.skuParams;
    }

    public final SkuSchemaParams getSkuSchemaParams() {
        return this.skuSchemaParams;
    }

    public final h0 getStaticState() {
        return this.staticState;
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ SkuYataQueryFetcher access$getQueryFetcher$p(SkuYataViewModel r100) {
        return r100.queryFetcher;
    }

    private final void showPageState(com.bytedance.android.shopping.sku.inner.repo.b r100) {
        o r101 = r100.f182953b;
        if (r101 == null) goto L5;
        SkuYataSkeletonLoadingStatus r102 = r101.f182859a;
    L6:
        if (r102 == null) goto L14;
        int r103 = i0.f182853a[r102.ordinal()];
        if (r103 != 1) goto L11;
        setState(new AnonymousClass1(this));
        return;
    L11:
        if (r103 != 2) goto L13;
        final f0 r104 = r100.f182952a;
        if (r104 == null) goto L23;
        setState(new SkuYataViewModel$showPageState$2$1(r104));
        return;
    L23:
        return;
    L13:
        if (r103 != 3) goto L14;
        setState(AnonymousClass3.INSTANCE);
        return;
    L14:
        SkuCommonLog.c("SkuYataViewModel", "errorStatus");
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void requestQuery(SkuYataQueryFrom r100) {
        Intrinsics.checkNotNullParameter(r100, "queryFrom");
        SkuYataQueryFetcher r101 = this.queryFetcher;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void setSkuParams(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.skuParams = r100;
    }

    public final void setSkuSchemaParams(SkuSchemaParams r100) {
        this.skuSchemaParams = r100;
    }

    public static final /* synthetic */ void access$setQueryFetcher$p(SkuYataViewModel r100, SkuYataQueryFetcher r101) {
        r100.queryFetcher = r101;
    }

    public static final /* synthetic */ void access$showPageState(SkuYataViewModel r100, com.bytedance.android.shopping.sku.inner.repo.b r101) {
        r100.showPageState(r101);
    }

    public final void init(SkuParams r100, SkuSchemaParams r101, PageFinder r102, String r103, Fragment r104) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Intrinsics.checkNotNullParameter(r102, "pageFinder");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "skuYataFragment");
        this.skuParams = r100;
        this.skuSchemaParams = r101;
        SkuYataQueryFetcher r105 = (SkuYataQueryFetcher) SkuYataQueryFetcherHolder.INSTANCE.get(r103);
        if (r105 != null) goto L5;
        r105 = new SkuYataQueryFetcher(r103, r100, r102, r101);
    L5:
        this.queryFetcher = r105;
        Intrinsics.checkNotNullParameter(r104, "btmNode");
        r105.f182940g = new WeakReference(r104);
        SkuYataQueryFetcher r106 = this.queryFetcher;
        if (r106 == null) goto L10;
        com.bytedance.android.shopping.sku.inner.repo.b r107 = r106.f182941h;
        if (r107 == null) goto L10;
        showPageState(r107);
    L10:
        SkuYataQueryFetcher r108 = this.queryFetcher;
        if (r108 == null) goto L14;
        r108.f182937d = new AnonymousClass2(this);
        return;
    }
}

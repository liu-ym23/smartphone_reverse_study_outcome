package com.bytedance.android.shopping.store.search.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0000H\u0002J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u0019X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/store/search/viewmodel/ShopSearchResultViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "()V", "data", "Landroid/content/Intent;", "getData", "()Landroid/content/Intent;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "isFormSearchActivity", "", "()Z", "setFormSearchActivity", "(Z)V", "mRecordTime", "getMRecordTime", "setMRecordTime", "mToNewPage", "getMToNewPage", "setMToNewPage", "pageBtm", "", "getPageBtm", "()Ljava/lang/String;", "searchParam", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "initData", "", "bundle", "Landroid/os/Bundle;", "reportDuration", "viewModel", "traceTimeEnd", "traceTimePause", "traceTimeStart", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultViewModel extends BaseViewModel {
    private final Intent data;
    private long duration;
    private boolean isFormSearchActivity;
    private long mRecordTime;
    private boolean mToNewPage;
    private final String pageBtm;
    public ECShopSearchParam searchParam;

    /* JADX WARN: Multi-variable type inference failed */
    public ShopSearchResultViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.pageBtm = "a1.b7881";
        this.mRecordTime = SystemClock.elapsedRealtime();
        this.mToNewPage = true;
        this.data = new Intent();
        this.isFormSearchActivity = true;
    }

    public final ECShopSearchParam getSearchParam() {
        ECShopSearchParam r100 = this.searchParam;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        return r100;
    }

    public final void traceTimePause() {
        this.duration += SystemClock.elapsedRealtime() - this.mRecordTime;
    }

    public final void traceTimeStart() {
        this.mRecordTime = SystemClock.elapsedRealtime();
    }

    public final Intent getData() {
        return this.data;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getMRecordTime() {
        return this.mRecordTime;
    }

    public final boolean getMToNewPage() {
        return this.mToNewPage;
    }

    public final String getPageBtm() {
        return this.pageBtm;
    }

    public final boolean isFormSearchActivity() {
        return this.isFormSearchActivity;
    }

    public final void traceTimeEnd() {
        reportDuration(this);
    }

    private final void reportDuration(ShopSearchResultViewModel r110) {
        String r100 = this.pageBtm;
        PageFinder r101 = PageFinder.via(this);
        Pair[] r102 = new Pair[2];
        r102[0] = TuplesKt.to("duration", String.valueOf(this.duration / ((long) 1000)));
        ECShopSearchParam r103 = r110.searchParam;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        r102[1] = TuplesKt.to("search_word", r103.getSearchKeyword());
        Map<String, String> r104 = MapsKt.mutableMapOf(r102);
        Pair[] r105 = new Pair[16];
        ECShopSearchParam r106 = r110.searchParam;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L8:
        r105[0] = TuplesKt.to(a.KEY_SHOP_ID, r106.getShopId());
        ECShopSearchParam r107 = r110.searchParam;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L11:
        r105[1] = TuplesKt.to("follow_status", String.valueOf(r107.getFollowStatus()));
        ECShopSearchParam r108 = r110.searchParam;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L14:
        r105[2] = TuplesKt.to(a.KEY_ENTRANCE_INFO, r108.getEntranceInfo());
        ECShopSearchParam r109 = r110.searchParam;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L17:
        r105[3] = TuplesKt.to("author_id", r109.getAuthorId());
        ECShopSearchParam r111 = r110.searchParam;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L20:
        r105[4] = TuplesKt.to(a.KEY_ENTRANCE_LOCATION, r111.getEntranceLocation());
        ECShopSearchParam r112 = r110.searchParam;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L24:
        if (r112.isPreview() == false) goto L26;
        String r113 = "1";
    L27:
        r105[5] = TuplesKt.to(a.KEY_IS_ENTER_PREVIEW, r113);
        r105[6] = TuplesKt.to(a.KEY_BRAND_VERIFIED, "0");
        r105[7] = TuplesKt.to(a.KEY_CONTENT_SOURCE, "shop");
        r105[8] = TuplesKt.to("source_page", "store_page");
        r105[9] = TuplesKt.to(a.KEY_STORE_TYPE, "shop");
        ECShopSearchParam r114 = r110.searchParam;
        if (r114 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L30:
        r105[10] = TuplesKt.to("page_name", r114.getPageName());
        ECShopSearchParam r115 = r110.searchParam;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L33:
        String r116 = "";
        if (r115.isEcShare() == false) goto L42;
        ECShopSearchParam r117 = r110.searchParam;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L38:
        String r118 = r117.getShareContent();
        if (r118 != null) goto L41;
        r118 = "";
    L41:
        Pair r119 = TuplesKt.to(a.KEY_SHARE_CONTENT, r118);
    L43:
        r105[11] = r119;
        ECShopSearchParam r120 = r110.searchParam;
        if (r120 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L47:
        if (r120.isEcShare() == false) goto L56;
        ECShopSearchParam r121 = r110.searchParam;
        if (r121 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L51:
        String r122 = r121.getShareObject();
        if (r122 == null) goto L55;
        r116 = r122;
    L55:
        Pair r123 = TuplesKt.to(a.KEY_SHARE_OBJECT, r116);
    L57:
        r105[12] = r123;
        r105[13] = TuplesKt.to(a.KEY_BST_GROUP_TYPE, "product");
        ECShopSearchParam r124 = r110.searchParam;
        if (r124 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L60:
        r105[14] = TuplesKt.to("shop_search_enter_method", r124.getEnterMethod());
        r105[15] = TuplesKt.to("bst_tag", "bst_tag");
        r104.putAll(MapsKt.mapOf(r105));
        Unit r125 = Unit.INSTANCE;
        r110.doEventAction("search_result_page_view", r100, r101, r104);
        return;
    L56:
        r123 = TuplesKt.to("", "");
        goto L57
    L42:
        r119 = TuplesKt.to("", "");
        goto L43
    L26:
        r113 = "0";
        goto L27
    }

    public final void initData(Bundle r100) {
        if (r100 == null) goto L4;
        Serializable r101 = r100.getSerializable("search_param");
    L5:
        if (r101 == null) goto L9;
        ECShopSearchParam r102 = (ECShopSearchParam) r101;
        this.searchParam = r102;
        this.isFormSearchActivity = r102.isFromSearchActivity();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L4:
        r101 = null;
        goto L5
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setFormSearchActivity(boolean r100) {
        this.isFormSearchActivity = r100;
    }

    public final void setMRecordTime(long r100) {
        this.mRecordTime = r100;
    }

    public final void setMToNewPage(boolean r100) {
        this.mToNewPage = r100;
    }

    public final void setSearchParam(ECShopSearchParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchParam = r100;
    }
}

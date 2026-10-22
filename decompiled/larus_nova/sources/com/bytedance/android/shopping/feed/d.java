package com.bytedance.android.shopping.feed;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.utils.d0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.net.URLEncoder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<InflowGuessFeedResponse> f174433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<InflowGuessFeedResponse> f174434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f174435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnchorV3Param f174436d;

    public final void a() {
        if (this.f174435c == true) goto L40;
        int r100 = ud3.f.f549731a;
        String r101 = ud3.f.a(this.f174436d.getRequestParam().getAggParams(), true, true);
        InnerGuessULikeApi.f175171a.getClass();
        InnerGuessULikeApi r102 = InnerGuessULikeApi.a.f175172a;
        if (r102 == null) goto L41;
        String r103 = this.f174436d.getProductId();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        String r104 = com.bytedance.android.shopping.feed.utils.g.a();
        int r110 = com.bytedance.android.shopping.feed.utils.b.f175437a;
        String r111 = com.bytedance.android.shopping.feed.utils.b.d(this.f174436d.getRequestParam().getMetaParam());
        if (r111 != null) goto L12;
        String r112 = "";
    L13:
        String r113 = this.f174436d.getAuthorId();
        String r114 = this.f174436d.getAuthorOpenId();
        ECAnchorV3ExtraData r115 = this.f174436d.getAnchorV3ExtraData();
        if (r115 == null) goto L16;
        String r116 = r115.getShopId();
    L17:
        String r117 = this.f174436d.getVideoId();
        String r118 = d0.a();
        ECLogExtraData r119 = this.f174436d.getLogExtraData();
        if (r119 == null) goto L20;
        String r210 = r119.getEnterFrom();
    L21:
        Long r211 = this.f174436d.getFirstCategoryId();
        String r212 = this.f174436d.getFirstCategoryName();
        Long r213 = this.f174436d.getFrontCategoryId();
        String r214 = this.f174436d.getFrontCategoryName();
        if (r101 != null) goto L24;
        String r105 = null;
    L25:
        boolean r215 = this.f174436d.getRequestParam().isAds();
        boolean r216 = this.f174436d.getRequestParam().isStar();
        List<String> r120 = this.f174436d.getRequestParam().getGoodPriceParam();
        if (r120 == null) goto L31;
        String r121 = CollectionsKt.joinToString$default(r120, ",", null, null, 0, null, null, 62, null);
        if (r121 == null) goto L31;
        String r217 = r121;
    L32:
        Observable r106 = InnerGuessULikeApi.b.a(r102, r103, 0, 1, null, 0, r104, "", null, 0, r112, r113, r114, r116, r117, r118, r210, null, null, r213, r214, r211, r212, r105, r216, r215, r217, 197002);
        if (r106 == null) goto L42;
        Observable r107 = r106.subscribeOn(Schedulers.io());
        if (r107 == null) goto L43;
        Observable r108 = r107.observeOn(AndroidSchedulers.mainThread());
        if (r108 == null) goto L44;
        r108.subscribe(new b(this));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L31:
        r217 = "";
        goto L32
    L24:
        r105 = URLEncoder.encode(r101, Charsets.UTF_8.name());
        goto L25
    L20:
        r210 = null;
        goto L21
    L16:
        r116 = null;
        goto L17
    L12:
        r112 = r111;
        goto L13
    L41:
        return;
    }

    public d(AnchorV3Param r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorV3Param");
        this.f174436d = r100;
        this.f174433a = new MutableLiveData();
        this.f174434b = new MutableLiveData();
    }
}

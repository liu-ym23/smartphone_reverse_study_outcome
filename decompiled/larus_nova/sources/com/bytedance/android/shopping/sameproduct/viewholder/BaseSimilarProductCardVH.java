package com.bytedance.android.shopping.sameproduct.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.utils.CommerceButtonUtil;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rd3.g;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseSimilarProductCardVH<T> extends JediSimpleViewHolder<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public rd3.a f182426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f182427m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function3<rd3.a, Integer, View, Unit> f182428n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function2<Integer, View, Unit> f182429o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Fragment f182430p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f182431q;

    public void c4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public final SameProductViewModel d4() {
        return (SameProductViewModel) this.f182427m.getValue();
    }

    public void f4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public final void e4(rd3.a r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        Promotion r100 = r210.f();
        if (r100 == null) goto L91;
        String r101 = r100.getLink();
        if (r101 == null) goto L92;
        p r102 = p.f48130a;
        Context r103 = this.f182431q.getContext();
        int r104 = com.bytedance.android.shopping.sameproduct.helper.b.f182423a;
        SameProductViewModel r105 = d4();
        String r106 = d4().getEcomSceneId();
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r105, "viewModel");
        Intrinsics.checkNotNullParameter(r210, "anchorInflowFeedItem");
        Promotion r107 = r210.f();
        if (r107 == null) goto L85;
        PromotionProductStruct r108 = r107.getPromotionInfo();
        if (r108 == null) goto L85;
        Uri r109 = UriProtector.parse(r101);
        String r110 = UriProtector.getQueryParameter(r109, "meta_params");
        if (r110 == null) goto L19;
        JSONObject r111 = z1.g(r110);
        if (r111 == null) goto L19;
    L20:
        JSONObject r112 = r111;
        String r113 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r113 == null) goto L24;
        JSONObject r114 = z1.g(r113);
        if (r114 == null) goto L24;
    L25:
        JSONObject r115 = r114;
        SameProductPageParams r116 = r105.getPageParams();
        ArrayList r117 = new ArrayList();
        if (a2.b(r106) == false) goto L35;
        if (r106 == null) goto L35;
        List r118 = StringsKt.split$default(r106, new String[]{","}, false, 0, 6, null);
        if (r118 == null) goto L34;
        Iterator<T> r119 = r118.iterator();
    L32:
        if (r119.hasNext() == false) goto L34;
        r117.add((String) r119.next());
    L34:
        ArrayList r120 = r117;
    L36:
        r120.add("1061");
        r115.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_STATUS, CommerceButtonUtil.a(r108).getType());
        r115.put("display_rank", r210.f537239f);
        if (r116 == null) goto L39;
        String r121 = r116.getVideoId();
    L40:
        r115.put("item_id", r121);
        r115.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product");
        if (r116 != null) goto L43;
    L45:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_INFLOW_LANDING_PAGE_TYPE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_INFLOW_SIMILAR_TAB);
        r115.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card");
        r115.put("ecom_scene_id", CollectionsKt.joinToString$default(r120, ",", null, null, 0, null, null, 62, null));
        r112.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r115.toString());
        Set<String> r122 = j1.b(r109);
        Uri.Builder r123 = r109.buildUpon().clearQuery();
        ArrayList r124 = new ArrayList();
        r124.add("meta_params");
        r124.add(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS);
        r124.add("source_page");
        if (r122 == null) goto L55;
        Iterator<T> r125 = r122.iterator();
    L49:
        if (r125.hasNext() == false) goto L55;
        Iterator<T> r126 = r125;
        String r127 = (String) r125.next();
        if (CollectionsKt.contains(r124, r127) == true) goto L54;
        r123.appendQueryParameter(r127, UriProtector.getQueryParameter(r109, r127));
    L54:
        r124 = r124;
        r125 = r126;
    L55:
        JSONObject r128 = new JSONObject();
        r128.put("request_id", r210.f537237d);
        g r129 = r210.d();
        if (r129 == null) goto L58;
        String r130 = r129.a();
    L59:
        r128.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r130);
        String r131 = UriProtector.getQueryParameter(r109, com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS);
        if (r131 == null) goto L63;
        JSONObject r132 = z1.g(r131);
        if (r132 == null) goto L63;
    L64:
        r132.put(com.bytedance.android.ec.core.event.a.KEY_SAME_PRODUCT_SCENE, 2);
        if (r116 == null) goto L67;
        String r133 = r116.getSecAuthorId();
    L68:
        r132.put("sec_author_id", r133);
        r132.put("ecom_scene_id", CollectionsKt.joinToString$default(r120, ",", null, null, 0, null, null, 62, null));
        r132.put("enter_from", com.bytedance.android.ec.core.event.a.VALUE_SAME_PRODUCT_FLOW_PAGE);
        if (r116 == null) goto L71;
        String r134 = r116.getEnterFrom();
    L72:
        Uri.Builder r135 = r123.appendQueryParameter("source_page", r134);
        if (r116 == null) goto L75;
        String r136 = r116.getVideoId();
    L76:
        Uri.Builder r137 = r135.appendQueryParameter("item_id", r136).appendQueryParameter("v3_events_additions", r128.toString()).appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS, r132.toString()).appendQueryParameter("meta_params", r112.toString());
        if (r116 == null) goto L79;
        String r138 = r116.getEcomEntranceForm();
    L80:
        Uri.Builder r139 = r137.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r138);
        PromotionProductBaseStruct r140 = r108.getBaseInfo();
        if (r140 == null) goto L83;
        Integer r141 = r140.getPromotionSource();
    L84:
        r101 = r139.appendQueryParameter(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(r141)).build().toString();
        goto L85
    L83:
        r141 = null;
        goto L84
    L79:
        r138 = null;
        goto L80
    L75:
        r136 = null;
        goto L76
    L71:
        r134 = null;
        goto L72
    L67:
        r133 = null;
    L63:
        r132 = new JSONObject();
        goto L64
    L58:
        r130 = null;
        goto L59
    L43:
        if (r116.isFromFlowGuessULike() != true) goto L45;
        r115.put(com.bytedance.android.ec.core.event.a.KEY_FROM_PRODUCT_MODULE_LABEL, "guess_you_like_product");
        goto L45
    L39:
        r121 = null;
    L35:
        r120 = r117;
    L24:
        r114 = new JSONObject();
    L19:
        r111 = new JSONObject();
    L85:
        r102.openSchema(r103, r101);
        return;
    L92:
        return;
    }

    public BaseSimilarProductCardVH(Fragment r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r101);
        this.f182430p = r100;
        this.f182431q = r101;
        final KClass r102 = Reflection.getOrCreateKotlinClass(SameProductViewModel.class);
        this.f182427m = LazyKt.lazy(new BaseSimilarProductCardVH$$special$$inlined$hostViewModel$1(this, r102, r102));
        this.f182428n = new BaseSimilarProductCardVH$buyButtonOnClickListener$1(this);
        this.f182429o = new BaseSimilarProductCardVH$enterProductDetailClickListener$1(this);
    }
}

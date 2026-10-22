package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.LynxScrollLayout;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerLynxViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DrawerLynxViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridCard f123910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FixedRatioRelativeLayout f123911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f123912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f123913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FeedItem f123914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LynxScrollLayout f123915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f123916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f123917h;

    public abstract float T3();

    public abstract int U3();

    public abstract Object V3();

    public abstract String W3();

    public abstract String X3();

    public abstract ViewGroup Z3();

    public abstract String a4();

    public abstract String b4();

    public final JsonObject Y3() {
        JsonElement r100 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), V3());
        if ((r100 instanceof JsonObject) == true) goto L6;
        r100 = null;
    L6:
        return (JsonObject) r100;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L7
        r100.put("visible", true);     // Catch: JSONException -> L7
        HybridCard r101 = this.f123910a;     // Catch: JSONException -> L7
        if (r101 == null) goto L12;
        r101.sendJsEvent("H5_visibilityChange", r100);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e(a4(), "onViewAttachedToWindow" + e.toString());
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L7
        r100.put("visible", false);     // Catch: JSONException -> L7
        HybridCard r101 = this.f123910a;     // Catch: JSONException -> L7
        if (r101 == null) goto L12;
        r101.sendJsEvent("H5_visibilityChange", r100);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e(a4(), "onViewDetachedFromWindow" + e.toString());
    }

    public DrawerLynxViewHolder(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "holderItemView");
        super(r101);
        this.f123916g = r100;
        this.f123917h = r101;
        FixedRatioRelativeLayout r102 = (FixedRatioRelativeLayout) r101.findViewById(R.id.container);
        this.f123911b = r102;
        this.f123912c = (ViewGroup) r101.findViewById(R.id.lynx_container);
        this.f123913d = r101.findViewById(R.id.lynx_error_view);
        this.f123915f = (LynxScrollLayout) r101.findViewById(R.id.lynx_scroll_container);
        if (r102 == null) goto L6;
        r102.setRatio(T3());
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        this.f123914e = r100;
        FixedRatioRelativeLayout r102 = this.f123911b;
        if (r102 == null) goto L10;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        int r104 = (int) (U3() / T3());
        if (r103.width == U3()) goto L7;
    L9:
        r103.width = U3();
        r103.height = r104;
        r102.setLayoutParams(r103);
        goto L10
    L7:
        if (r103.height != r104) goto L9;
    L10:
        HybridCard r105 = this.f123910a;
        GsonMap r106 = null;
        if (r105 == null) goto L16;
        Pair[] r107 = new Pair[1];
        String r108 = W3();
        JsonObject r109 = Y3();
        if (r109 == null) goto L15;
        r106 = UtilsKt.i(r109);
    L15:
        r107[0] = TuplesKt.to(r108, r106);
        r105.updateData(MapsKt.hashMapOf(r107));
        return;
    L16:
        String r110 = b4();
        String r111 = X3() + "?initialProps=%5B%22operation_banner%22%5D";
        ((IBrowserService) jc1.k.n(IBrowserService.class)).registerOrNotifyState(new com.bytedance.android.live.browser.jsbridge.i.e.AbstractC1036e.b(W3()), Y3());
        Uri r112 = x6.a.d(r110).buildUpon().appendQueryParameter("fallback_url", r111).build();
        if (r112 == null) goto L28;
        IBrowserService r113 = (IBrowserService) jc1.k.n(IBrowserService.class);
        Context r114 = this.f123916g.getContext();
        v r115 = new v(this);
        Bundle r116 = new Bundle();
        r116.putInt("create_view_sync", 1);
        Unit r117 = Unit.INSTANCE;
        HybridCard r118 = r113.getHybridCard(r114, r112, r115, r116);
        if (r118 == null) goto L29;
        this.f123910a = r118;
        String r119 = b4();
        Pair[] r120 = new Pair[1];
        String r121 = W3();
        JsonObject r122 = Y3();
        if (r122 == null) goto L23;
        r106 = UtilsKt.i(r122);
    L23:
        r120[0] = TuplesKt.to(r121, r106);
        r118.load(r119, MapsKt.hashMapOf(r120));
        r118.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r123 = Z3();
        if (r123 == null) goto L30;
        r123.addView(r118);
        return;
    L30:
        return;
    L29:
        return;
    }
}

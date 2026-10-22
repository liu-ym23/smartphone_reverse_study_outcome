package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.order.PreviewPanelFragment;
import com.bytedance.android.shopping.order.PublishUtil;
import com.bytedance.android.shopping.order.PublishUtil$getSilentPublishModelObservable$1;
import com.bytedance.android.shopping.order.PublishUtil$getSynthesizedVideoObservable$1;
import com.bytedance.android.shopping.utils.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.share.QzonePublish;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECOpenVideoPreviewPanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenVideoPreviewPanelMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f176214e = 0;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.order.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECOpenVideoPreviewPanelMethod f176215a;

        @Override // com.bytedance.android.shopping.order.a
        public final void a() {
            ECOpenVideoPreviewPanelMethod.e(this.f176215a, 0, "成功", 4);
        }

        @Override // com.bytedance.android.shopping.order.a
        public final void b() {
            ECOpenVideoPreviewPanelMethod.e(this.f176215a, 1, null, 6);
        }

        @Override // com.bytedance.android.shopping.order.a
        public final void onFailed() {
            Intrinsics.checkNotNullParameter("publish failed", "msg");
            ECOpenVideoPreviewPanelMethod.e(this.f176215a, -1, "publish failed", 4);
        }

        public b(ECOpenVideoPreviewPanelMethod r100) {
            this.f176215a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "openCommentPostPannel";
    }

    public ECOpenVideoPreviewPanelMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r410, ECBaseBridgeMethod.a r411) {
        Intrinsics.checkNotNullParameter(r410, "params");
        Intrinsics.checkNotNullParameter(r411, "iReturn");
        Lazy r100 = ECAppInfoService.f48110a;
        if (ECAppInfoService.j() == true) goto L5;
        r411.onFailed(-1, "only support douyin");
    L5:
        JSONObject r101 = r410.optJSONObject("comment_info");
        if (r101 != null) goto L9;
        JSONObject r102 = new JSONObject();
        r102.put("code", -1);
        Unit r103 = Unit.INSTANCE;
        r411.a(r102);
        e(this, -1, "传参错误", 4);
        return;
    L9:
        ArrayList r104 = new ArrayList();
        JSONArray r110 = r101.optJSONArray("comments");     // Catch: JSONException -> L20
        if (r110 == null) goto L21;
        Iterator r111 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r110)).iterator();     // Catch: JSONException -> L20
    L14:
        if (r111.hasNext() == false) goto L21;
        Object r112 = r111.next();     // Catch: JSONException -> L20
        int r113 = dg3.a.f468378l;     // Catch: JSONException -> L20
        if ((r112 instanceof HashMap) == true) goto L18;
        r112 = null;
    L18:
        r104.add(dg3.a.C5665a.a((HashMap) r112));     // Catch: JSONException -> L20
    L21:
        long r114 = r101.optLong("anonymous");
        long r115 = r101.optLong("rank_shop");
        long r116 = r101.optLong("rank_logistic");
        JSONObject r105 = r410.optJSONObject("post_material");
        if (r105 != null) goto L25;
        JSONObject r106 = new JSONObject();
        r106.put("code", -1);
        Unit r107 = Unit.INSTANCE;
        r411.a(r106);
        e(this, -1, "传参错误", 4);
        return;
    L25:
        final String r108 = r105.optString("video_path");
        if (r108 != null) goto L28;
        r108 = "";
    L28:
        final ArrayList r109 = new ArrayList();
        JSONArray r117 = r105.optJSONArray("image_path");     // Catch: JSONException -> L38
        if (r117 == null) goto L40;
        Iterator r118 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r117)).iterator();     // Catch: JSONException -> L38
    L33:
        if (r118.hasNext() == false) goto L40;
        Object r119 = r118.next();     // Catch: JSONException -> L38
        if ((r119 instanceof String) == false) goto L33;
        r109.add(r119);     // Catch: JSONException -> L38
    L40:
        if (r104.isEmpty() == false) goto L43;
        JSONObject r120 = new JSONObject();
        r120.put("code", -1);
        Unit r121 = Unit.INSTANCE;
        r411.a(r120);
        return;
    L43:
        dg3.a r122 = (dg3.a) ListProtector.get(r104, 0);
        tl.a r123 = new tl.a(r122.f468379a, r122.f468380b, r122.f468381c, Long.valueOf(r115), Long.valueOf(r116), r122.f468383e, 1984);
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r125 = r104.iterator();
    L45:
        if (r125.hasNext() == false) goto L47;
        dg3.a r126 = (dg3.a) r125.next();
        Long r127 = r126.f468379a;
        Iterator r128 = r125;
        Long r129 = r122.f468380b;
        dg3.a r130 = r122;
        String r131 = r126.f468381c;
        Long r310 = Long.valueOf(r115);
        Long r311 = Long.valueOf(r116);
        long r132 = r115;
        Long r133 = r126.f468383e;
        Json r134 = Json.f45532b;
        long r210 = r116;
        long r211 = r114;
        r124.add(new cg3.f(r127, r129, r131, r310, r311, r133, r134.b(r126.f468384f), r134.b(r126.f468385g), Long.valueOf(r114), r126.f468382d, r126.f468386h, r126.f468387i, r126.f468388j, r126.f468389k, 114688));
        r125 = r128;
        r122 = r130;
        r115 = r132;
        r116 = r210;
        r114 = r211;
        goto L45
    L47:
        Long r135 = Long.valueOf(CastLongProtector.parseLong(r.f48132a.getCurrentUserId()));
        String r136 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo().getAppId();
        if (r136 == null) goto L50;
        long r137 = CastLongProtector.parseLong(r136);
    L51:
        cg3.g r138 = new cg3.g(r135, Long.valueOf(r137), 12L, r124);
        boolean r139 = r410.optBoolean("is_hide_panel");
        boolean r140 = r410.optBoolean("is_silent_post");
        final boolean r212 = r410.optBoolean("publish_support_image");
        if (r139 == false) goto L59;
        if (r140 == false) goto L58;
        final cg3.f r141 = (cg3.f) CollectionsKt.firstOrNull(r124);
        if (r141 == null) goto L73;
        Handler r142 = PublishUtil.f179649a;
        final Context r143 = getContext();
        Intrinsics.checkNotNullParameter(r109, "imagePaths");
        Intrinsics.checkNotNullParameter(r108, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r141, "postCommentInfo");
        final String r144 = r108;
        Disposable r145 = Observable.zip(Observable.create(new PublishUtil$getSilentPublishModelObservable$1(r143, r109, r144, r141, r212)), PublishUtil.d(r138, r123, null, null), new e(this, r138)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), new g(this));
        int r146 = j.f187149a;
        j.a(getContext(), r145);
    L73:
        JSONObject r147 = new JSONObject();
        r147.put("code", 0);
        Unit r148 = Unit.INSTANCE;
        r411.a(r147);
        return;
    L58:
        Handler r149 = PublishUtil.f179649a;
        final Context r150 = getContext();
        Intrinsics.checkNotNullParameter(r109, "images");
        Intrinsics.checkNotNullParameter(r108, "video");
        Disposable r151 = Observable.zip(Observable.create(new PublishUtil$getSynthesizedVideoObservable$1(r150, r109, r108)), PublishUtil.d(r138, r123, null, null), new com.bytedance.android.shopping.hybrid.bridges.b(this, r138)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        int r152 = j.f187149a;
        j.a(getContext(), r151);
        goto L73
    L59:
        Context r153 = getContext();
        b r154 = new b(this);
        if ((r153 instanceof FragmentActivity) == true) goto L62;
        Context r155 = null;
    L63:
        FragmentActivity r156 = (FragmentActivity) r155;
        if (r156 == null) goto L73;
        FragmentManager r157 = r156.getSupportFragmentManager();
        if (r157 == null) goto L73;
        int r158 = PreviewPanelFragment.f179622y;
        Intrinsics.checkNotNullParameter(r108, "videoMaterial");
        Intrinsics.checkNotNullParameter(r109, "imageMaterial");
        Intrinsics.checkNotNullParameter(r123, "shareInfoRequestParam");
        Intrinsics.checkNotNullParameter(r138, "postCommentRequestParam");
        Intrinsics.checkNotNullParameter(r154, "cb");
        PreviewPanelFragment r159 = new PreviewPanelFragment();
        r159.f179623d = r154;
        r159.f179625f = r108;
        r159.f179626g = r109;
        r159.f179641v = r123;
        r159.f179642w = r138;
        r159.f179643x = r153;
        LandscapeRestrictionOperation r160 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r159, null, r160);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r157, r159, r160) == true) goto L73;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L72:
        r159.show(r157, null);
        goto L73
    L62:
        r155 = r153;
        goto L63
    L50:
        r137 = 0;
        goto L51
    }

    public static void d(int r100, String r101, cg3.d r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);
        r103.put("msg", r101);
        if (r102 != null) goto L8;
    L5:
        vi.a r104 = com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostAppInfo();
        JSONObject r105 = new JSONObject();
        r105.put("eventName", "ecPostCommentResponse");
        r105.put("data", r103);
        Unit r106 = Unit.INSTANCE;
        r104.d(r105);
        return;
    L8:
        r103.put("data", new JSONObject(u0.d(r102)));     // Catch: Exception -> L7
        goto L5
    }

    public static /* synthetic */ void e(ECOpenVideoPreviewPanelMethod r100, int r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "";
    L5:
        r100.getClass();
        d(r101, r102, null);
    }
}

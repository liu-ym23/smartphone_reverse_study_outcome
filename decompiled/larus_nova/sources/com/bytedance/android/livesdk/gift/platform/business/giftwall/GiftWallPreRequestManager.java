package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import android.graphics.Bitmap;
import ca0.l;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import com.bytedance.android.scope.o;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftWallPreRequestManager implements l, o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f129625l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f129626m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f129627n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f129628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f129629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f129630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f129631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a.C2070a f129632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Pair<Long, JsonObject>> f129633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Pair<Long, JsonObject>> f129634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f129635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f129636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f129637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SendGiftRelationService f129638k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f129639a = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.giftwall.GiftWallPreRequestManager$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/giftwall/GiftWallPreRequestManager$a$a;", "", "", "giftImageWebp", "Z", "b", "()Z", "", "prefetchType", "I", "getPrefetchType", "()I", "bitmapCache", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C2070a {

            @SerializedName("bitmap_cache")
            private final boolean bitmapCache;

            @SerializedName("gift_image_webp")
            private final boolean giftImageWebp;

            @SerializedName("prefetch_type")
            private final int prefetchType;

            public C2070a() {
                this(0);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2070a) == false) goto L12;
                C2070a r101 = (C2070a) r100;
                if (this.giftImageWebp == r101.giftImageWebp) goto L8;
                return false;
            L8:
                if (this.prefetchType == r101.prefetchType) goto L10;
                return false;
            L10:
                if (this.bitmapCache == r101.bitmapCache) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public final int hashCode() {
                boolean r100 = this.giftImageWebp;
                ?? r101 = 1;
                ?? r102 = r100;
                if (r100 == false) goto L5;
                r102 = 1;
            L5:
                int r103 = ((r102 * 31) + this.prefetchType) * 31;
                boolean r104 = this.bitmapCache;
                if (r104 == true) goto L10;
                r101 = r104;
            L10:
                return r103 + r101;
            }

            public final String toString() {
                return "GiftWallImageOpt(giftImageWebp=" + this.giftImageWebp + ", prefetchType=" + this.prefetchType + ", bitmapCache=" + this.bitmapCache + ")";
            }

            public final boolean c() {
                if (this.prefetchType == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public final boolean d() {
                if (this.prefetchType != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public final boolean a() {
                return this.bitmapCache;
            }

            public final boolean b() {
                return this.giftImageWebp;
            }

            public C2070a(int r100) {
                this.giftImageWebp = false;
                this.prefetchType = 0;
                this.bitmapCache = false;
            }
        }

        static {
            f129639a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_GIFT_WALL_PRE_REQUEST", "getENABLE_GIFT_WALL_PRE_REQUEST()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "GIFT_WALL_IMAGE_OPT_CONFIG", "getGIFT_WALL_IMAGE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/giftwall/GiftWallPreRequestManager$Companion$GiftWallImageOpt;", 0))};
        }

        public a() {
        }

        public static boolean a() {
            return ((Boolean) GiftWallPreRequestManager.f129625l.getValue(GiftWallPreRequestManager.f129627n, f129639a[0])).booleanValue();
        }
    }

    @Override // ca0.l
    public final void f() {
        this.f129636i = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    static {
        f129627n = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r100 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_wall_pre_request_enable", Boolean.FALSE, Boolean.TYPE, false);
        KProperty<?>[] r101 = a.f129639a;
        KProperty<?> r110 = r101[0];
        f129625l = UltraSettingsManager.a().a(r100.f271017a, r100.f271018b, r100.getType(), r100.f271020d, r110);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_wall_image_opt_config", new a.C2070a(0), a.C2070a.class, false);
        KProperty<?> r103 = r101[1];
        f129626m = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r103);
    }

    @Override // ca0.l
    public final JsonObject h() {
        f129627n.getClass();
        if (a.a() == false) goto L5;
        String r100 = this.f129635h;
        if (r100 != null) goto L9;
        r100 = (String) this.f129629b.getValue();
    L9:
        final Pair<Long, JsonObject> r101 = this.f129633f.get(r100);
        final Pair<Long, JsonObject> r102 = this.f129634g.get(r100);
        if (r101 == null) goto L19;
        if (r102 == null) goto L19;
        if (this.f129632e.c() == false) goto L16;
        g.a(true, new GiftWallPreRequestManager$buildExhibitionData$1(this, r102, r101));
    L16:
        JsonObject r103 = new JsonObject();
        r103.addProperty("user_id", r100);
        r103.addProperty("home_data", r101.getSecond().toString());
        r103.addProperty("rare_data", r102.getSecond().toString());
        r103.addProperty("fetch_time", String.valueOf(r101.getFirst().longValue()));
        return r103;
    L19:
        return new JsonObject();
    L5:
        return new JsonObject();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f129631d.dispose();
    }

    @Override // ca0.l
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        if (this.f129632e.b() == true) goto L5;
        return;
    L5:
        f.f129646a.getClass();
        Intrinsics.checkNotNullParameter(r100, "json");
        f.b(new GiftWallWebpImageUtils$convertRareGiftImageUrl$1(r100));
    }

    @Override // ca0.l
    public final void c(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        if (this.f129632e.b() == true) goto L5;
        return;
    L5:
        f.f129646a.getClass();
        Intrinsics.checkNotNullParameter(r100, "json");
        f.b(new GiftWallWebpImageUtils$convertHomeGiftImageUrl$1(r100));
    }

    @Override // ca0.l
    public final void d(String r210) {
        Intrinsics.checkNotNullParameter(r210, "userId");
        if (((Boolean) this.f129630c.getValue()).booleanValue() == true) goto L30;
        f129627n.getClass();
        if (a.a() == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r210, this.f129636i) == false) goto L10;
        return;
    L10:
        this.f129636i = r210;
        jy0.b.a("ttlive_gift_wall", "onUserProfileShow uid=" + r210 + ", fetchExhibitionData");
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        x.a(r101, false);
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r103 = Long.valueOf(((Number) this.f129628a.getValue()).longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r103 == null) goto L13;
        r102.put("room_id", r103);
    L13:
        Integer r104 = 4;
        String r105 = r104.toString();
        Intrinsics.checkNotNullParameter("exhibition_source", "$this$setTo");
        if (r105 == null) goto L16;
        r102.put("exhibition_source", r105);
    L16:
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r210 == null) goto L19;
        r102.put("anchor_id", r210);
    L19:
        Intrinsics.checkNotNullParameter("target_open_uid", "$this$setTo");
        if (r210 == null) goto L22;
        r102.put("target_open_uid", r210);
    L22:
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        INetworkService r106 = (INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class);
        INetworkService.Biz r110 = INetworkService.Biz.Revenue;
        Observable r107 = r106.x0(r110, "/webcast/gift/exhibition/home/", TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c).map(new d(this));
        uz0.c r108 = new uz0.c();
        Intrinsics.checkNotNullParameter(r108, "$this$beforeConfigureRequest");
        x.a(r108, false);
        Map<String, String> r109 = r108.f552161b;
        Intrinsics.checkNotNullParameter(r109, "queriesMap");
        String r111 = Long.valueOf(((Number) this.f129628a.getValue()).longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r111 == null) goto L25;
        r109.put("room_id", r111);
    L25:
        Intrinsics.checkNotNullParameter("target_open_uid", "$this$setTo");
        if (r210 == null) goto L28;
        r109.put("target_open_uid", r210);
    L28:
        Intrinsics.checkNotNullParameter(r108, "$this$afterConfigureRequest");
        RxUtilKt.c(Observable.zip(r107, ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(r110, "/webcast/gift/exhibition/rare/", TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)), Extra.class, r108.f552163d, r108.f552160a, r108.f552161b, r108.f552162c).map(new e(this)), com.bytedance.android.livesdk.gift.platform.business.giftwall.a.f129640a).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r210), new c(r210)), this.f129631d);
        return;
    }

    public GiftWallPreRequestManager(k r100, SendGiftRelationService r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "sendGiftRelationService");
        this.f129637j = r100;
        this.f129638k = r101;
        this.f129628a = LazyKt.lazy(new GiftWallPreRequestManager$roomId$2(this));
        this.f129629b = LazyKt.lazy(new GiftWallPreRequestManager$anchorId$2(this));
        this.f129630c = LazyKt.lazy(new GiftWallPreRequestManager$isAnchor$2(this));
        this.f129631d = new CompositeDisposable();
        a r102 = f129627n;
        r102.getClass();
        this.f129632e = (a.C2070a) f129626m.getValue(r102, a.f129639a[1]);
        this.f129633f = new HashMap();
        this.f129634g = new HashMap();
    }

    public static final String j(GiftWallPreRequestManager r100, JsonElement r101) {
        r100.getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        JsonElement r104 = (JsonElement) CollectionsKt.firstOrNull(r101.getAsJsonObject().get(PbRequest.SwitchType.GIFT).getAsJsonObject().get("image").getAsJsonObject().get(ScoreTags.STAR_URL_LIST).getAsJsonArray());     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        String r105 = r104.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == true) goto L16;
        r102 = r106;
    L16:
        return (String) r102;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void k(GiftWallPreRequestManager r100, String r101) {
        if (r100.f129632e.a() == false) goto L5;
        FrescoImagePrefetchHelper.prefetchImageToBitmapCache(r101, Bitmap.Config.ARGB_8888, "gift_wall_icon_prefetch_bitmap");
        return;
    L5:
        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r101), "gift_wall_icon_prefetch_disk");
    }

    @Override // ca0.l
    public final String g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L15;
        f129627n.getClass();
        if (a.a() == false) goto L15;
        this.f129635h = r100;
        x0 r103 = new x0(r101);
        r103.b(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, "[gift_exhibition_data]");
        return r103.toString();
    L15:
        return r101;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final void i(GiftWallPreRequestManager r100, JsonObject r101, String r102) {
        r100.getClass();
        JsonArray r103 = r101.getAsJsonArray(ScoreTags.STAR_URL_LIST);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(r105.next().getAsString());
        goto L4
    L6:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r104.iterator();
    L7:
        ArrayList r108 = null;
        if (r107.hasNext() == false) goto L12;
        Object r109 = r107.next();
        if (StringsKt.endsWith$default((String) r109, r102, false, 2, null) == false) goto L7;
        r106.add(r109);
        goto L7
    L12:
        ArrayList r110 = new ArrayList();
        Iterator r111 = r106.iterator();
    L14:
        if (r111.hasNext() == false) goto L19;
        String r112 = (String) r111.next();
        int r113 = RevenueImageUrlService.f130574c;
        String r114 = RevenueImageUrlService.a.b(r112, r102, true);
        if (r114 == null) goto L14;
        r110.add(r114);
        goto L14
    L19:
        if ((!r110.isEmpty()) == false) goto L21;
        r108 = r110;
    L21:
        if (r108 == null) goto L40;
        JsonArray r115 = new JsonArray();
        Iterator r116 = r108.iterator();
    L24:
        if (r116.hasNext() == false) goto L26;
        r115.add((String) r116.next());
        goto L24
    L26:
        r101.add(ScoreTags.STAR_URL_LIST, r115);
        return;
    }
}

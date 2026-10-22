package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.jsbridge.methods.draft.RxDownloadApi$download$1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d1 extends com.bytedance.ies.web.jsbridge2.f<b, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f142064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.jsbridge.methods.draft.l f142065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f142066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f142067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public km3.g f142068e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010&\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$b;", "", "", "videoId", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "videoUrl", "m", "title", ce.f26395j, "type", "getType", "roomId", "e", "roomTime", "f", "", "createTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", DyPayConstant.KEY_START_TIME, RXScreenCaptureService.KEY_INDEX, "endTime", "b", "shootWay", ce.f26391f, "fragmentId", "c", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "shoppingExtras", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "h", "()Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "promotionId", "d", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "trackExtras", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", ce.f26396k, "()Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "cover", "getCover", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("cover")
        private final String cover;

        @SerializedName("create_time")
        private final long createTime;

        @SerializedName("end_time")
        private final long endTime;

        @SerializedName("fragment_id")
        private final String fragmentId;

        @SerializedName("promotion_id")
        private final String promotionId;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("room_time")
        private final String roomTime;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOOT_WAY)
        private final String shootWay;

        @SerializedName("shopping_extras")
        private final c shoppingExtras;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private final long startTime;

        @SerializedName("title")
        private final String title;

        @SerializedName("track_extras")
        private final d trackExtras;

        @SerializedName("type")
        private final String type;

        @SerializedName("video_id")
        private final String videoId;

        @SerializedName("video_url")
        private final String videoUrl;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L36;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.videoUrl, r101.videoUrl) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.roomTime, r101.roomTime) == true) goto L18;
            return false;
        L18:
            if (this.createTime == r101.createTime) goto L20;
            return false;
        L20:
            if (this.startTime == r101.startTime) goto L22;
            return false;
        L22:
            if (this.endTime == r101.endTime) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.shootWay, r101.shootWay) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.fragmentId, r101.fragmentId) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.shoppingExtras, r101.shoppingExtras) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.trackExtras, r101.trackExtras) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        public final int hashCode() {
            String r100 = this.videoId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.videoUrl;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.title;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.type;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.roomId;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.roomTime;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            long r119 = this.createTime;
            int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
            long r121 = this.startTime;
            int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
            long r123 = this.endTime;
            int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
            String r125 = this.shootWay;
            if (r125 == null) goto L29;
            int r126 = r125.hashCode();
        L30:
            int r127 = (r124 + r126) * 31;
            String r128 = this.fragmentId;
            if (r128 == null) goto L33;
            int r129 = r128.hashCode();
        L34:
            int r130 = (r127 + r129) * 31;
            c r131 = this.shoppingExtras;
            if (r131 == null) goto L37;
            int r132 = r131.hashCode();
        L38:
            int r133 = (r130 + r132) * 31;
            String r134 = this.promotionId;
            if (r134 == null) goto L41;
            int r135 = r134.hashCode();
        L42:
            int r136 = (r133 + r135) * 31;
            d r137 = this.trackExtras;
            if (r137 == null) goto L45;
            int r138 = r137.hashCode();
        L46:
            int r139 = (r136 + r138) * 31;
            String r140 = this.cover;
            if (r140 == null) goto L50;
            r101 = r140.hashCode();
        L50:
            return r139 + r101;
        L45:
            r138 = 0;
            goto L46
        L41:
            r135 = 0;
            goto L42
        L37:
            r132 = 0;
            goto L38
        L33:
            r129 = 0;
            goto L34
        L29:
            r126 = 0;
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
            return "Params(videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", title=" + this.title + ", type=" + this.type + ", roomId=" + this.roomId + ", roomTime=" + this.roomTime + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", shootWay=" + this.shootWay + ", fragmentId=" + this.fragmentId + ", shoppingExtras=" + this.shoppingExtras + ", promotionId=" + this.promotionId + ", trackExtras=" + this.trackExtras + ", cover=" + this.cover + ")";
        }

        public b() {
            c r100 = new c(0);
            d r101 = new d(0);
            Intrinsics.checkNotNullParameter("", "videoId");
            Intrinsics.checkNotNullParameter("", "videoUrl");
            Intrinsics.checkNotNullParameter("", "title");
            Intrinsics.checkNotNullParameter("", "type");
            Intrinsics.checkNotNullParameter("", "roomId");
            Intrinsics.checkNotNullParameter("", "roomTime");
            Intrinsics.checkNotNullParameter("", "shootWay");
            Intrinsics.checkNotNullParameter("", "fragmentId");
            Intrinsics.checkNotNullParameter(r100, "shoppingExtras");
            Intrinsics.checkNotNullParameter("", "promotionId");
            Intrinsics.checkNotNullParameter(r101, "trackExtras");
            Intrinsics.checkNotNullParameter("", "cover");
            this.videoId = "";
            this.videoUrl = "";
            this.title = "";
            this.type = "";
            this.roomId = "";
            this.roomTime = "";
            this.createTime = -1;
            this.startTime = -1;
            this.endTime = -1;
            this.shootWay = "";
            this.fragmentId = "";
            this.shoppingExtras = r100;
            this.promotionId = "";
            this.trackExtras = r101;
            this.cover = "";
        }

        public final long a() {
            return this.createTime;
        }

        public final long b() {
            return this.endTime;
        }

        public final String c() {
            return this.fragmentId;
        }

        public final String d() {
            return this.promotionId;
        }

        public final String e() {
            return this.roomId;
        }

        public final String f() {
            return this.roomTime;
        }

        public final String g() {
            return this.shootWay;
        }

        public final String getType() {
            return this.type;
        }

        public final c h() {
            return this.shoppingExtras;
        }

        public final long i() {
            return this.startTime;
        }

        public final String j() {
            return this.title;
        }

        public final d k() {
            return this.trackExtras;
        }

        public final String l() {
            return this.videoId;
        }

        public final String m() {
            return this.videoUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "", "", "type", "I", "getType", "()I", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "title", "c", "source", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("anchor_content")
        private final String content;

        @SerializedName("source")
        private final int source;

        @SerializedName("anchor_title")
        private final String title;

        @SerializedName("anchor_business_type")
        private final int type;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (this.type == r101.type) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
            return false;
        L12:
            if (this.source == r101.source) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = this.type * 31;
            String r101 = this.content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.title;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return ((r104 + r102) * 31) + this.source;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "ShoppingExtras(type=" + this.type + ", content=" + this.content + ", title=" + this.title + ", source=" + this.source + ")";
        }

        public final String a() {
            return this.content;
        }

        public final int b() {
            return this.source;
        }

        public final String c() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public c(int r100) {
            Intrinsics.checkNotNullParameter("", "content");
            Intrinsics.checkNotNullParameter("", "title");
            this.type = -1;
            this.content = "";
            this.title = "";
            this.source = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "", "", "anchorId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "commodityId", "b", "", "commodityType", "I", "c", "()I", "isEcom", "f", "pageName", "d", "sourcePage", "e", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("anchor_id")
        private final String anchorId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID)
        private final String commodityId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE)
        private final int commodityType;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_IS_ECOM)
        private final String isEcom;

        @SerializedName("page_name")
        private final String pageName;

        @SerializedName("source_page")
        private final String sourcePage;

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L18;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.commodityId, r101.commodityId) == true) goto L10;
            return false;
        L10:
            if (this.commodityType == r101.commodityType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isEcom, r101.isEcom) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.anchorId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.commodityId;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (((r103 + r105) * 31) + this.commodityType) * 31;
            String r107 = this.isEcom;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.pageName;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.sourcePage;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
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
            return "TrackExtras(anchorId=" + this.anchorId + ", commodityId=" + this.commodityId + ", commodityType=" + this.commodityType + ", isEcom=" + this.isEcom + ", pageName=" + this.pageName + ", sourcePage=" + this.sourcePage + ")";
        }

        public final String a() {
            return this.anchorId;
        }

        public final String b() {
            return this.commodityId;
        }

        public final int c() {
            return this.commodityType;
        }

        public final String d() {
            return this.pageName;
        }

        public final String e() {
            return this.sourcePage;
        }

        public final String f() {
            return this.isEcom;
        }

        public d(int r100) {
            Intrinsics.checkNotNullParameter("", "anchorId");
            Intrinsics.checkNotNullParameter("", "commodityId");
            Intrinsics.checkNotNullParameter("", "isEcom");
            Intrinsics.checkNotNullParameter("", "pageName");
            Intrinsics.checkNotNullParameter("", "sourcePage");
            this.anchorId = "";
            this.commodityId = "";
            this.commodityType = 0;
            this.isEcom = "";
            this.pageName = "";
            this.sourcePage = "";
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f142066c.clear();
    }

    public d1(Context r100) {
        this.f142064a = new WeakReference(r100);
        this.f142065b = new com.bytedance.android.livesdk.jsbridge.methods.draft.l();
        this.f142066c = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b r310, CallContext r311) {
        b r100 = r310;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r311, "callContext");
        String r101 = r100.getType();
        int r102 = r101.hashCode();
        if (r102 == (-681210700)) goto L9;
        if (r102 != 3322092) goto L24;
        r101.equals("live");
        return;
    L24:
        return;
    L9:
        if (r101.equals("highlight") == false) goto L23;
        Context r103 = this.f142064a.get();
        if (r103 == null) goto L25;
        com.bytedance.android.livesdk.jsbridge.methods.draft.l r104 = this.f142065b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "params");
        String r105 = UriProtector.parse(r100.m()).getLastPathSegment();
        if (r105 != null) goto L16;
        r105 = "ts";
    L16:
        final String r106 = com.bytedance.android.livesdk.chatroom.record.u.c(com.bytedance.android.live.core.utils.s1.getContext(), r105);
        if (r106 != null) goto L19;
        Observable r107 = Observable.error(new Throwable("localPath is null"));
    L20:
        Disposable r108 = r107.subscribe(new e1(this), new f1(this, r100), new g1(this, r100));
        this.f142066c.add(r108);
        this.f142067d = r108;
        return;
    L19:
        String r109 = r100.l();
        String r110 = r100.j();
        String r111 = r100.getType();
        String r112 = r100.e();
        String r113 = r100.f();
        long r114 = r100.i();
        long r115 = r100.b();
        String r116 = r100.g();
        String r117 = r100.c();
        int r210 = r100.h().getType();
        String r211 = r100.h().a();
        String r212 = r100.h().c();
        int r213 = r100.h().b();
        Room r118 = new Room();
        r118.f162599id = CastLongProtector.parseLong(r100.e());
        r118.setCreateTime(r100.a());
        com.bytedance.android.livesdk.user.f r119 = r104.f142112c.user();
        User r120 = new User();
        r120.setIdStr(r119.b().getIdString());
        r120.setNickName(r119.b().getNickName());
        com.bytedance.android.livesdk.jsbridge.methods.draft.f r121 = new com.bytedance.android.livesdk.jsbridge.methods.draft.f(r106, r109, r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, r213, r118, r120, r100.h(), r100.d(), r100.k());
        final com.bytedance.android.livesdk.jsbridge.methods.draft.h r122 = r104.f142110a;
        final String r123 = r100.m();
        r122.getClass();
        Intrinsics.checkNotNullParameter(r123, "url");
        Intrinsics.checkNotNullParameter(r106, "localPath");
        com.bytedance.android.livesdk.jsbridge.methods.draft.k r124 = r104.f142111b;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r121, "draft");
        com.bytedance.android.livesdk.jsbridge.methods.draft.k r125 = r104.f142111b;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r121, "draft");
        r107 = Observable.concat(CollectionsKt.listOf(new Observable[]{Observable.create(new RxDownloadApi$download$1(r122, r123, r106)), Observable.create(new com.bytedance.android.livesdk.jsbridge.methods.draft.j(r124, r121, r103)), Observable.create(new com.bytedance.android.livesdk.jsbridge.methods.draft.i(r125, r121, r103))}));
        goto L20
    L25:
        return;
    }
}

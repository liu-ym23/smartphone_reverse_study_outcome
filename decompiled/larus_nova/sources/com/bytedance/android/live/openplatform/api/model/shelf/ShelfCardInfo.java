package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ShelfCardInfo")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001[R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000eR\u001a\u0010%\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u001a\u0010*\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007R\u001c\u0010.\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010'R\u001c\u00102\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000eR\u001c\u00104\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010'R\u001c\u00108\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010\u000eR\u001c\u0010;\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010\u000eR\"\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010!R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010'R\u001a\u0010G\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010'R\u001a\u0010I\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bJ\u0010'R\u001a\u0010K\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\bK\u0010\u0017\u001a\u0004\bL\u0010\u0019R\u001c\u0010M\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010\u000eR\u001c\u0010O\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bO\u0010\f\u001a\u0004\bP\u0010\u000eR\u001c\u0010Q\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bQ\u0010\f\u001a\u0004\bR\u0010\u000eR\u001c\u0010S\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bS\u0010\f\u001a\u0004\bT\u0010\u000eR\u001c\u0010U\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bU\u0010\f\u001a\u0004\bV\u0010\u000eR\u001a\u0010W\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bW\u0010\u0010\u001a\u0004\bX\u0010'R\u001a\u0010Y\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bY\u0010\u0010\u001a\u0004\bZ\u0010'¨\u0006\\"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/a;", "", "cardId", "J", "getCardId", "()J", "localCardId", "O", "", "schema", "Ljava/lang/String;", "a0", "()Ljava/lang/String;", "defaultTitle", "I", "defaultCoverUrl", FaceService.girlLabel, "customizedTitle", ExifInterface.LONGITUDE_EAST, "", "isTitleChanged", "Z", "I0", "()Z", "customizedCoverUrl", "D", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Ljava/util/List;", "L", "()Ljava/util/List;", "sourcePage", "i0", "", "reviewStatus", "getReviewStatus", "()I", "fromReview", "K", "canModifyCover", "r", "status", "getStatus", "logExtra", "R", "cardSource", "s", "createInfo", "t", "reviewResultReason", "Y", "reviewTitleStatus", "getReviewTitleStatus", "reviewingTitle", "lastPassTitle", "N", "lastPassCoverUrl", "M", "Lcom/bytedance/android/live/openplatform/api/model/shelf/AuditInfo;", "auditInfoList", "q", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "getProductInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "priority", "U", "topReason", "p0", "showDuration", "f0", "isLeadsComponent", "C0", "sellingPoint", "b", "presetCardUrl", ExifInterface.LATITUDE_SOUTH, "textPosterUrl", "o0", "textPosterTitle", "j0", "screenshotUrl", "b0", "selectedCoverType", "c0", "customizedCoverType", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Source", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfCardInfo implements Parcelable, com.bytedance.android.live.openplatform.api.model.shelf.a, h {
    public static final Parcelable.Creator<ShelfCardInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f83970a;

    @SerializedName("audit_info_list")
    protected List<AuditInfo> auditInfoList;

    @SerializedName("can_modify_cover")
    protected boolean canModifyCover;

    @SerializedName("card_id")
    protected long cardId;

    @SerializedName("card_source")
    protected int cardSource;

    @SerializedName("create_info")
    protected String createInfo;

    @SerializedName("customized_cover_type")
    protected int customizedCoverType;

    @SerializedName("customized_cover_url")
    protected String customizedCoverUrl;

    @SerializedName("customized_title")
    protected String customizedTitle;

    @SerializedName("default_cover_url")
    protected String defaultCoverUrl;

    @SerializedName("default_title")
    protected String defaultTitle;

    @SerializedName("from_review")
    protected boolean fromReview;

    @SerializedName("image")
    protected List<ImageModel> image;

    @SerializedName("is_leads_component")
    protected boolean isLeadsComponent;

    @IgnoreProtoFieldCheck
    @SerializedName("is_title_changed")
    private final boolean isTitleChanged;

    @SerializedName("last_pass_img")
    protected String lastPassCoverUrl;

    @SerializedName("last_pass_title")
    protected String lastPassTitle;

    @IgnoreProtoFieldCheck
    @SerializedName("local_card_id")
    private final long localCardId;

    @SerializedName("log_extra")
    protected String logExtra;

    @SerializedName("pre_set_card_url")
    protected String presetCardUrl;

    @SerializedName("priority")
    protected int priority;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("review_result_reason")
    protected String reviewResultReason;

    @SerializedName("review_status")
    protected int reviewStatus;

    @SerializedName("review_title_status")
    protected int reviewTitleStatus;

    @SerializedName("reviewing_title")
    protected String reviewingTitle;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("screen_shot_url")
    protected String screenshotUrl;

    @SerializedName("select_cover_type")
    protected int selectedCoverType;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_SELLING_POINT)
    protected String sellingPoint;

    @SerializedName("show_duration")
    protected int showDuration;

    @SerializedName("source_page")
    protected String sourcePage;

    @SerializedName("status")
    protected long status;

    @SerializedName("text_poster_title")
    protected String textPosterTitle;

    @SerializedName("text_poster_url")
    protected String textPosterUrl;

    @SerializedName("top_reason")
    protected int topReason;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo$Source;", "", "", "value", "I", "getValue", "()I", "Phone", "PC", "Saas", "Other", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Source extends Enum<Source> {
        public static final Source Other = null;
        public static final Source PC = null;
        public static final Source Phone = null;
        public static final Source Saas = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f83971a = null;
        private final int value;

        static {
            Source r100 = new Source("Phone", 0, 0);
            Phone = r100;
            Source r101 = new Source("PC", 1, 1);
            PC = r101;
            Source r102 = new Source("Saas", 2, 2);
            Saas = r102;
            Source r103 = new Source("Other", 3, 99);
            Other = r103;
            f83971a = new Source[]{r100, r101, r102, r103};
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f83971a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a implements Parcelable.Creator<ShelfCardInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfCardInfo createFromParcel(Parcel r410) {
            Intrinsics.checkNotNullParameter(r410, "in");
            long r100 = r410.readLong();
            long r101 = r410.readLong();
            String r102 = r410.readString();
            String r103 = r410.readString();
            String r104 = r410.readString();
            String r110 = r410.readString();
            if (r410.readInt() == 0) goto L5;
            boolean r111 = true;
        L6:
            String r112 = r410.readString();
            if (r410.readInt() == 0) goto L12;
            int r105 = r410.readInt();
            ArrayList r113 = new ArrayList(r105);
        L9:
            if (r105 == 0) goto L11;
            r113.add((ImageModel) r410.readParcelable(ShelfCardInfo.class.getClassLoader()));
            r105 = r105 - 1;
            goto L9
        L11:
            ArrayList r114 = r113;
        L13:
            String r115 = r410.readString();
            int r210 = r410.readInt();
            if (r410.readInt() == 0) goto L16;
            boolean r211 = true;
        L18:
            if (r410.readInt() == 0) goto L20;
            boolean r212 = true;
        L21:
            long r213 = r410.readLong();
            String r214 = r410.readString();
            int r215 = r410.readInt();
            String r216 = r410.readString();
            String r217 = r410.readString();
            int r218 = r410.readInt();
            String r310 = r410.readString();
            String r311 = r410.readString();
            String r312 = r410.readString();
            if (r410.readInt() == 0) goto L27;
            int r106 = r410.readInt();
            ArrayList r116 = new ArrayList(r106);
        L24:
            if (r106 == 0) goto L26;
            r116.add(AuditInfo.CREATOR.createFromParcel(r410));
            r106 = r106 - 1;
            goto L24
        L26:
            ArrayList r313 = r116;
        L29:
            if (r410.readInt() == 0) goto L31;
            ProductInfo r411 = ProductInfo.CREATOR.createFromParcel(r410);
        L32:
            int r412 = r410.readInt();
            int r413 = r410.readInt();
            int r414 = r410.readInt();
            if (r410.readInt() == 0) goto L35;
            boolean r415 = true;
        L37:
            return new ShelfCardInfo(r100, r101, r102, r103, r104, r110, r111, r112, r114, r115, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r411, r412, r413, r414, r415, r410.readString(), r410.readString(), r410.readString(), r410.readString(), r410.readString(), r410.readInt(), r410.readInt());
        L35:
            r415 = false;
            goto L37
        L31:
            r411 = null;
            goto L32
        L27:
            r313 = null;
            goto L29
        L20:
            r212 = false;
            goto L21
        L16:
            r211 = false;
            goto L18
        L12:
            r114 = null;
            goto L13
        L5:
            r111 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfCardInfo[] newArray(int r100) {
            return new ShelfCardInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShelfCardInfo(long r100, long r101, String r102, String r103, String r110, String r111, boolean r112, String r113, List<? extends ImageModel> r114, String r115, int r116, boolean r117, boolean r118, long r119, String r210, int r211, String r212, String r213, int r214, String r215, String r216, String r217, List<AuditInfo> r218, ProductInfo r310, int r311, int r312, int r313, boolean r314, String r315, String r316, String r317, String r318, String r319, int r410, int r411) {
        this.cardId = r100;
        this.localCardId = r101;
        this.schema = r102;
        this.defaultTitle = r103;
        this.defaultCoverUrl = r110;
        this.customizedTitle = r111;
        this.isTitleChanged = r112;
        this.customizedCoverUrl = r113;
        this.image = r114;
        this.sourcePage = r115;
        this.reviewStatus = r116;
        this.fromReview = r117;
        this.canModifyCover = r118;
        this.status = r119;
        this.logExtra = r210;
        this.cardSource = r211;
        this.createInfo = r212;
        this.reviewResultReason = r213;
        this.reviewTitleStatus = r214;
        this.reviewingTitle = r215;
        this.lastPassTitle = r216;
        this.lastPassCoverUrl = r217;
        this.auditInfoList = r218;
        this.productInfo = r310;
        this.priority = r311;
        this.topReason = r312;
        this.showDuration = r313;
        this.isLeadsComponent = r314;
        this.sellingPoint = r315;
        this.presetCardUrl = r316;
        this.textPosterUrl = r317;
        this.textPosterTitle = r318;
        this.screenshotUrl = r319;
        this.selectedCoverType = r410;
        this.customizedCoverType = r411;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean w0() {
        if (this.f83970a != null) goto L9;
        String r100 = this.createInfo;     // Catch: JSONException -> L18
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        this.f83970a = new JSONObject(r100);     // Catch: JSONException -> L18
    L9:
        JSONObject r101 = this.f83970a;     // Catch: JSONException -> L18
        if (r101 == null) goto L21;
        JSONObject r102 = r101.optJSONObject("extra");     // Catch: JSONException -> L18
        if (r102 == null) goto L22;
        if (r102.optInt("is_default_cover_from_cache", 0) != 1) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L24:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.cardId);
        r100.writeLong(this.localCardId);
        r100.writeString(this.schema);
        r100.writeString(this.defaultTitle);
        r100.writeString(this.defaultCoverUrl);
        r100.writeString(this.customizedTitle);
        r100.writeInt(this.isTitleChanged ? 1 : 0);
        r100.writeString(this.customizedCoverUrl);
        List<ImageModel> r102 = this.image;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ImageModel> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r100.writeParcelable(r103.next(), r101);
    L9:
        r100.writeString(this.sourcePage);
        r100.writeInt(this.reviewStatus);
        r100.writeInt(this.fromReview ? 1 : 0);
        r100.writeInt(this.canModifyCover ? 1 : 0);
        r100.writeLong(this.status);
        r100.writeString(this.logExtra);
        r100.writeInt(this.cardSource);
        r100.writeString(this.createInfo);
        r100.writeString(this.reviewResultReason);
        r100.writeInt(this.reviewTitleStatus);
        r100.writeString(this.reviewingTitle);
        r100.writeString(this.lastPassTitle);
        r100.writeString(this.lastPassCoverUrl);
        List<AuditInfo> r104 = this.auditInfoList;
        if (r104 == null) goto L15;
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<AuditInfo> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        r105.next().writeToParcel(r100, 0);
    L16:
        ProductInfo r106 = this.productInfo;
        if (r106 == null) goto L19;
        r100.writeInt(1);
        r106.writeToParcel(r100, 0);
    L20:
        r100.writeInt(this.priority);
        r100.writeInt(this.topReason);
        r100.writeInt(this.showDuration);
        r100.writeInt(this.isLeadsComponent ? 1 : 0);
        r100.writeString(this.sellingPoint);
        r100.writeString(this.presetCardUrl);
        r100.writeString(this.textPosterUrl);
        r100.writeString(this.textPosterTitle);
        r100.writeString(this.screenshotUrl);
        r100.writeInt(this.selectedCoverType);
        r100.writeInt(this.customizedCoverType);
        return;
    L19:
        r100.writeInt(0);
        goto L20
    L15:
        r100.writeInt(0);
        goto L16
    L8:
        r100.writeInt(0);
        goto L9
    }

    public final boolean y0() {
        if (this.f83970a != null) goto L9;
        String r100 = this.createInfo;     // Catch: JSONException -> L18
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        this.f83970a = new JSONObject(r100);     // Catch: JSONException -> L18
    L9:
        JSONObject r101 = this.f83970a;     // Catch: JSONException -> L18
        if (r101 == null) goto L21;
        JSONObject r102 = r101.optJSONObject("extra");     // Catch: JSONException -> L18
        if (r102 == null) goto L22;
        if (r102.optInt("is_default_title_from_cache", 0) != 1) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L24:
        return false;
    }

    public final boolean J0() {
        List<AuditInfo> r100 = this.auditInfoList;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    public final String h() {
        com.bytedance.android.live.openplatform.api.utils.a r100 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        String r101 = null;
        boolean r102 = false;
        if (com.bytedance.android.live.openplatform.api.utils.a.f84001a.c() == false) goto L22;
        ProductInfo r103 = this.productInfo;
        if (r103 == null) goto L7;
        String r104 = r103.imgUrl;
    L8:
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L22;
        ProductInfo r106 = this.productInfo;
        if (r106 == null) goto L61;
        String r107 = r106.imgUrl;
        if (r107 != null) goto L21;
        return "";
    L21:
        return r107;
    L61:
        return "";
    L10:
        if (StringsKt.isBlank(r104) == true) goto L13;
        r105 = false;
        goto L14
    L7:
        r104 = null;
    L22:
        int r108 = this.selectedCoverType;
        if (r108 != 1) goto L25;
        r101 = this.presetCardUrl;
    L35:
        if (r101 != null) goto L37;
    L40:
        boolean r109 = true;
    L41:
        if (r109 == false) goto L43;
        r101 = this.customizedCoverUrl;
    L43:
        if (r101 != null) goto L45;
    L48:
        boolean r110 = true;
    L49:
        if (r110 == false) goto L51;
        r101 = this.lastPassCoverUrl;
    L51:
        if (r101 != null) goto L53;
    L54:
        r102 = true;
    L55:
        if (r102 == false) goto L57;
        r101 = this.defaultCoverUrl;
    L57:
        if (r101 != null) goto L60;
        return "";
    L60:
        return r101;
    L53:
        if (StringsKt.isBlank(r101) == false) goto L55;
    L45:
        if (StringsKt.isBlank(r101) == true) goto L48;
        r110 = false;
        goto L49
    L37:
        if (StringsKt.isBlank(r101) == true) goto L40;
        r109 = false;
        goto L41
    L25:
        if (r108 != 2) goto L27;
        r101 = this.textPosterUrl;
        goto L35
    L27:
        if (r108 != 3) goto L29;
        r101 = this.screenshotUrl;
        goto L35
    L29:
        if (r108 != 4) goto L35;
        r101 = this.customizedCoverUrl;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r100 = this.cardId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.localCardId;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.schema;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.defaultTitle;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.defaultCoverUrl;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        String r114 = this.customizedTitle;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.isTitleChanged;
        ?? r118 = 1;
        ?? r119 = r117;
        if (r117 == false) goto L21;
        r119 = 1;
    L21:
        int r120 = (r116 + r119) * 31;
        String r121 = this.customizedCoverUrl;
        if (r121 == null) goto L24;
        int r122 = r121.hashCode();
    L25:
        int r123 = (r120 + r122) * 31;
        List<ImageModel> r124 = this.image;
        if (r124 == null) goto L28;
        int r125 = r124.hashCode();
    L29:
        int r126 = (r123 + r125) * 31;
        String r127 = this.sourcePage;
        if (r127 == null) goto L32;
        int r128 = r127.hashCode();
    L33:
        int r129 = (((r126 + r128) * 31) + this.reviewStatus) * 31;
        boolean r130 = this.fromReview;
        ?? r131 = r130;
        if (r130 == false) goto L36;
        r131 = 1;
    L36:
        int r132 = (r129 + r131) * 31;
        boolean r133 = this.canModifyCover;
        ?? r134 = r133;
        if (r133 == false) goto L39;
        r134 = 1;
    L39:
        long r135 = this.status;
        int r136 = (((r132 + r134) * 31) + ((int) (r135 ^ (r135 >>> 32)))) * 31;
        String r137 = this.logExtra;
        if (r137 == null) goto L42;
        int r138 = r137.hashCode();
    L43:
        int r139 = (((r136 + r138) * 31) + this.cardSource) * 31;
        String r140 = this.createInfo;
        if (r140 == null) goto L46;
        int r141 = r140.hashCode();
    L47:
        int r142 = (r139 + r141) * 31;
        String r143 = this.reviewResultReason;
        if (r143 == null) goto L50;
        int r144 = r143.hashCode();
    L51:
        int r145 = (((r142 + r144) * 31) + this.reviewTitleStatus) * 31;
        String r146 = this.reviewingTitle;
        if (r146 == null) goto L54;
        int r147 = r146.hashCode();
    L55:
        int r148 = (r145 + r147) * 31;
        String r149 = this.lastPassTitle;
        if (r149 == null) goto L58;
        int r150 = r149.hashCode();
    L59:
        int r151 = (r148 + r150) * 31;
        String r152 = this.lastPassCoverUrl;
        if (r152 == null) goto L62;
        int r153 = r152.hashCode();
    L63:
        int r154 = (r151 + r153) * 31;
        List<AuditInfo> r155 = this.auditInfoList;
        if (r155 == null) goto L66;
        int r156 = r155.hashCode();
    L67:
        int r157 = (r154 + r156) * 31;
        ProductInfo r158 = this.productInfo;
        if (r158 == null) goto L70;
        int r159 = r158.hashCode();
    L71:
        int r160 = (((((((r157 + r159) * 31) + this.priority) * 31) + this.topReason) * 31) + this.showDuration) * 31;
        boolean r161 = this.isLeadsComponent;
        if (r161 == true) goto L75;
        r118 = r161;
    L75:
        int r162 = (r160 + r118) * 31;
        String r163 = this.sellingPoint;
        if (r163 == null) goto L78;
        int r164 = r163.hashCode();
    L79:
        int r165 = (r162 + r164) * 31;
        String r166 = this.presetCardUrl;
        if (r166 == null) goto L82;
        int r167 = r166.hashCode();
    L83:
        int r168 = (r165 + r167) * 31;
        String r169 = this.textPosterUrl;
        if (r169 == null) goto L86;
        int r170 = r169.hashCode();
    L87:
        int r171 = (r168 + r170) * 31;
        String r172 = this.textPosterTitle;
        if (r172 == null) goto L90;
        int r173 = r172.hashCode();
    L91:
        int r174 = (r171 + r173) * 31;
        String r175 = this.screenshotUrl;
        if (r175 == null) goto L95;
        r105 = r175.hashCode();
    L95:
        return ((((r174 + r105) * 31) + this.selectedCoverType) * 31) + this.customizedCoverType;
    L90:
        r173 = 0;
        goto L91
    L86:
        r170 = 0;
        goto L87
    L82:
        r167 = 0;
        goto L83
    L78:
        r164 = 0;
        goto L79
    L70:
        r159 = 0;
        goto L71
    L66:
        r156 = 0;
        goto L67
    L62:
        r153 = 0;
        goto L63
    L58:
        r150 = 0;
        goto L59
    L54:
        r147 = 0;
        goto L55
    L50:
        r144 = 0;
        goto L51
    L46:
        r141 = 0;
        goto L47
    L42:
        r138 = 0;
        goto L43
    L32:
        r128 = 0;
        goto L33
    L28:
        r125 = 0;
        goto L29
    L24:
        r122 = 0;
        goto L25
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfCardInfo(cardId=" + this.cardId + ", localCardId=" + this.localCardId + ", schema=" + this.schema + ", defaultTitle=" + this.defaultTitle + ", defaultCoverUrl=" + this.defaultCoverUrl + ", customizedTitle=" + this.customizedTitle + ", isTitleChanged=" + this.isTitleChanged + ", customizedCoverUrl=" + this.customizedCoverUrl + ", image=" + this.image + ", sourcePage=" + this.sourcePage + ", reviewStatus=" + this.reviewStatus + ", fromReview=" + this.fromReview + ", canModifyCover=" + this.canModifyCover + ", status=" + this.status + ", logExtra=" + this.logExtra + ", cardSource=" + this.cardSource + ", createInfo=" + this.createInfo + ", reviewResultReason=" + this.reviewResultReason + ", reviewTitleStatus=" + this.reviewTitleStatus + ", reviewingTitle=" + this.reviewingTitle + ", lastPassTitle=" + this.lastPassTitle + ", lastPassCoverUrl=" + this.lastPassCoverUrl + ", auditInfoList=" + this.auditInfoList + ", productInfo=" + this.productInfo + ", priority=" + this.priority + ", topReason=" + this.topReason + ", showDuration=" + this.showDuration + ", isLeadsComponent=" + this.isLeadsComponent + ", sellingPoint=" + this.sellingPoint + ", presetCardUrl=" + this.presetCardUrl + ", textPosterUrl=" + this.textPosterUrl + ", textPosterTitle=" + this.textPosterTitle + ", screenshotUrl=" + this.screenshotUrl + ", selectedCoverType=" + this.selectedCoverType + ", customizedCoverType=" + this.customizedCoverType + ")";
    }

    public final boolean v0() {
        ProductInfo r100 = this.productInfo;
        if (r100 == null) goto L5;
        String r101 = r100.productId;
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L14:
        if ((!r102) == true) goto L17;
        r100 = null;
    L17:
        if (r100 == null) goto L20;
        return true;
    L20:
        return false;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public ShelfCardInfo() {
        this.cardId = 0;
        this.schema = null;
        this.defaultTitle = null;
        this.defaultCoverUrl = null;
        this.customizedTitle = null;
        this.customizedCoverUrl = null;
        this.image = null;
        this.sourcePage = null;
        this.reviewStatus = 0;
        this.fromReview = false;
        this.canModifyCover = true;
        this.status = 0;
        this.logExtra = null;
        this.cardSource = Source.Phone.getValue();
        this.createInfo = null;
        this.reviewResultReason = null;
        this.reviewTitleStatus = 0;
        this.reviewingTitle = null;
        this.lastPassTitle = null;
        this.lastPassCoverUrl = null;
        this.auditInfoList = null;
        this.productInfo = null;
        this.priority = 0;
        this.topReason = 0;
        this.showDuration = 0;
        this.isLeadsComponent = false;
        this.sellingPoint = null;
        this.presetCardUrl = null;
        this.textPosterUrl = null;
        this.textPosterTitle = null;
        this.screenshotUrl = null;
        this.selectedCoverType = 0;
        this.customizedCoverType = 0;
    }

    public final boolean F0() {
        if (J0() == false) goto L6;
        return d(1, 1);
    L6:
        return e(1, 1);
    }

    public final String W() {
        if (J0() == false) goto L24;
        StringBuilder r100 = new StringBuilder();
        List<AuditInfo> r101 = this.auditInfoList;
        if (r101 == null) goto L23;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        AuditInfo r103 = (AuditInfo) r102.next();
        if (r103.auditStatus != 2) goto L8;
        String r104 = r103.rejectReason;
        if (r2.a(r104) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L8;
        if (r100.length() <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        r100.append("，");
    L22:
        r100.append(r104);
        goto L8
    L19:
        r105 = false;
    L23:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        return String.format(s1.B(R.string.ttlive_open_platform_review_reject_reason), Arrays.copyOf(new Object[]{r100.toString()}, 1));
    L24:
        String r107 = this.reviewResultReason;
        if (r107 != null) goto L36;
        return "";
    L36:
        return r107;
    }

    public final boolean C0() {
        return this.isLeadsComponent;
    }

    public final String D() {
        return this.customizedCoverUrl;
    }

    public final String E() {
        return this.customizedTitle;
    }

    public final String F() {
        return this.defaultCoverUrl;
    }

    public final String I() {
        return this.defaultTitle;
    }

    public final boolean I0() {
        return this.isTitleChanged;
    }

    public final boolean K() {
        return this.fromReview;
    }

    public final List<ImageModel> L() {
        return this.image;
    }

    public final String M() {
        return this.lastPassCoverUrl;
    }

    public final String N() {
        return this.lastPassTitle;
    }

    public final long O() {
        return this.localCardId;
    }

    public final String R() {
        return this.logExtra;
    }

    public final String S() {
        return this.presetCardUrl;
    }

    public final int U() {
        return this.priority;
    }

    public final String Y() {
        return this.reviewResultReason;
    }

    public final String Z() {
        return this.reviewingTitle;
    }

    public final String a0() {
        return this.schema;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final String b() {
        return this.sellingPoint;
    }

    public final String b0() {
        return this.screenshotUrl;
    }

    public final int c0() {
        return this.selectedCoverType;
    }

    public final int f0() {
        return this.showDuration;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getCardId() {
        return this.cardId;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final ProductInfo getProductInfo() {
        return this.productInfo;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getStatus() {
        return this.status;
    }

    public final String i0() {
        return this.sourcePage;
    }

    public final String j0() {
        return this.textPosterTitle;
    }

    public final String o0() {
        return this.textPosterUrl;
    }

    public final int p0() {
        return this.topReason;
    }

    public final List<AuditInfo> q() {
        return this.auditInfoList;
    }

    public final boolean r() {
        return this.canModifyCover;
    }

    public final int s() {
        return this.cardSource;
    }

    public final String t() {
        return this.createInfo;
    }

    public final int z() {
        return this.customizedCoverType;
    }

    public ShelfCardInfo(am3.g r100) {
        this.image = new ArrayList();
        this.auditInfoList = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L46;
        if (r103 == 95) goto L45;
        if (r103 != 96) goto L9;
        this.logExtra = am3.h.c(r100);
        goto L3
    L9:
        switch(r103) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            case 19: goto L24;
            case 20: goto L23;
            case 21: goto L22;
            case 22: goto L21;
            case 23: goto L20;
            case 24: goto L19;
            default: goto L10;
        };
    L19:
        this.isLeadsComponent = am3.h.a(r100);
        r102 = r102 | 1024;
        goto L3
    L20:
        this.showDuration = r100.i();
        r102 = r102 | 512;
        goto L3
    L21:
        this.topReason = r100.i();
        r102 = r102 | 256;
        goto L3
    L22:
        this.priority = r100.i();
        r102 = r102 | 128;
        goto L3
    L23:
        this.productInfo = new ProductInfo(r100);
        goto L3
    L24:
        this.lastPassCoverUrl = am3.h.c(r100);
        goto L3
    L25:
        this.lastPassTitle = am3.h.c(r100);
        goto L3
    L26:
        this.reviewingTitle = am3.h.c(r100);
        goto L3
    L27:
        this.reviewTitleStatus = r100.i();
        r102 = r102 | 64;
        goto L3
    L28:
        this.reviewResultReason = am3.h.c(r100);
        goto L3
    L29:
        this.createInfo = am3.h.c(r100);
        goto L3
    L30:
        this.cardSource = r100.i();
        r102 = r102 | 32;
        goto L3
    L31:
        this.status = r100.j();
        r102 = r102 | 16;
        goto L3
    L32:
        this.canModifyCover = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L33:
        this.fromReview = am3.h.a(r100);
        r102 = r102 | 4;
        goto L3
    L34:
        this.reviewStatus = r100.i();
        r102 = r102 | 2;
        goto L3
    L35:
        this.sourcePage = am3.h.c(r100);
        goto L3
    L36:
        List r104 = this.image;
        Parcelable r105 = x.a(r100);
    L37:
        r104.add(r105);
        goto L3
    L38:
        this.customizedCoverUrl = am3.h.c(r100);
        goto L3
    L39:
        this.customizedTitle = am3.h.c(r100);
        goto L3
    L40:
        this.defaultCoverUrl = am3.h.c(r100);
        goto L3
    L41:
        this.defaultTitle = am3.h.c(r100);
        goto L3
    L42:
        this.schema = am3.h.c(r100);
        goto L3
    L43:
        this.cardId = r100.j();
        r102 = r102 | 1;
        goto L3
    L10:
        switch(r103) {
            case 26: goto L18;
            case 27: goto L17;
            case 28: goto L16;
            case 29: goto L15;
            case 30: goto L14;
            case 31: goto L13;
            case 32: goto L12;
            default: goto L11;
        };
    L12:
        this.selectedCoverType = r100.i();
        r102 = r102 | 2048;
        goto L3
    L13:
        this.customizedCoverType = r100.i();
        r102 = r102 | 4096;
        goto L3
    L14:
        this.presetCardUrl = am3.h.c(r100);
        goto L3
    L15:
        this.screenshotUrl = am3.h.c(r100);
        goto L3
    L16:
        this.textPosterTitle = am3.h.c(r100);
        goto L3
    L17:
        this.textPosterUrl = am3.h.c(r100);
        goto L3
    L18:
        this.sellingPoint = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L45:
        r104 = this.auditInfoList;
        r105 = new AuditInfo(r100);
        goto L37
    L46:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L50;
        this.cardId = 0;
    L50:
        if (this.schema != null) goto L53;
        this.schema = null;
    L53:
        if (this.defaultTitle != null) goto L56;
        this.defaultTitle = null;
    L56:
        if (this.defaultCoverUrl != null) goto L59;
        this.defaultCoverUrl = null;
    L59:
        if (this.customizedTitle != null) goto L62;
        this.customizedTitle = null;
    L62:
        if (this.customizedCoverUrl != null) goto L65;
        this.customizedCoverUrl = null;
    L65:
        if (this.image.isEmpty() == false) goto L68;
        this.image = null;
    L68:
        if (this.sourcePage != null) goto L71;
        this.sourcePage = null;
    L71:
        if ((r102 & 2) != 0) goto L74;
        this.reviewStatus = 0;
    L74:
        if ((r102 & 4) != 0) goto L77;
        this.fromReview = false;
    L77:
        if ((r102 & 8) != 0) goto L80;
        this.canModifyCover = true;
    L80:
        if ((r102 & 16) != 0) goto L83;
        this.status = 0;
    L83:
        if (this.logExtra != null) goto L86;
        this.logExtra = null;
    L86:
        if ((r102 & 32) != 0) goto L89;
        this.cardSource = Source.Phone.getValue();
    L89:
        if (this.createInfo != null) goto L92;
        this.createInfo = null;
    L92:
        if (this.reviewResultReason != null) goto L95;
        this.reviewResultReason = null;
    L95:
        if ((r102 & 64) != 0) goto L98;
        this.reviewTitleStatus = 0;
    L98:
        if (this.reviewingTitle != null) goto L101;
        this.reviewingTitle = null;
    L101:
        if (this.lastPassTitle != null) goto L104;
        this.lastPassTitle = null;
    L104:
        if (this.lastPassCoverUrl != null) goto L107;
        this.lastPassCoverUrl = null;
    L107:
        if (this.auditInfoList.isEmpty() == false) goto L110;
        this.auditInfoList = null;
    L110:
        if (this.productInfo != null) goto L113;
        this.productInfo = null;
    L113:
        if ((r102 & 128) != 0) goto L116;
        this.priority = 0;
    L116:
        if ((r102 & 256) != 0) goto L119;
        this.topReason = 0;
    L119:
        if ((r102 & 512) != 0) goto L122;
        this.showDuration = 0;
    L122:
        if ((r102 & 1024) != 0) goto L125;
        this.isLeadsComponent = false;
    L125:
        if (this.sellingPoint != null) goto L128;
        this.sellingPoint = null;
    L128:
        if (this.presetCardUrl != null) goto L131;
        this.presetCardUrl = null;
    L131:
        if (this.textPosterUrl != null) goto L134;
        this.textPosterUrl = null;
    L134:
        if (this.textPosterTitle != null) goto L137;
        this.textPosterTitle = null;
    L137:
        if (this.screenshotUrl != null) goto L140;
        this.screenshotUrl = null;
    L140:
        if ((r102 & 2048) != 0) goto L143;
        this.selectedCoverType = 0;
    L143:
        if ((r102 & 4096) != 0) goto L217;
        this.customizedCoverType = 0;
        return;
    }

    public final boolean G0(int r100) {
        if (J0() == false) goto L6;
        return d(r100, 2);
    L6:
        return e(r100, 2);
    }

    public final boolean H0(int r100) {
        if (J0() == false) goto L6;
        return d(r100, 3);
    L6:
        return e(r100, 5);
    }

    public final Pair<Integer, String> J(String r100) {
        String r101 = this.customizedTitle;
        if (r101 != null) goto L5;
    L8:
        String r102 = this.defaultTitle;
        if (r102 == null) goto L12;
        r100 = r102;
    L12:
        if (r100 != null) goto L15;
        r100 = "小程序";
    L15:
        return TuplesKt.to(1, r100);
    L5:
        if ((!StringsKt.isBlank(r101)) != true) goto L8;
        return TuplesKt.to(2, this.customizedTitle);
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final Pair<Integer, String> a(String r100) {
        com.bytedance.android.live.openplatform.api.utils.b r101 = com.bytedance.android.live.openplatform.api.utils.b.f84002b;
        if (com.bytedance.android.live.openplatform.api.utils.b.f84002b.f() == false) goto L22;
        ProductInfo r102 = this.productInfo;
        if (r102 == null) goto L7;
        String r103 = r102.title;
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L22;
        ProductInfo r105 = this.productInfo;
        if (r105 == null) goto L19;
        String r106 = r105.title;
        if (r106 == null) goto L19;
    L23:
        return TuplesKt.to(4, r106);
    L19:
        r106 = "";
        goto L23
    L10:
        if (StringsKt.isBlank(r103) == true) goto L13;
        r104 = false;
        goto L14
    L7:
        r103 = null;
    L22:
        return J(r100);
    }

    public final boolean c(boolean r100) {
        String r101 = this.sellingPoint;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        if (r100 == false) goto L14;
        return ee0.f120119a.getValue().s();
    L14:
        return ee0.f120119a.getValue().e();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShelfCardInfo) == false) goto L76;
        ShelfCardInfo r101 = (ShelfCardInfo) r100;
        if (this.cardId == r101.cardId) goto L8;
        return false;
    L8:
        if (this.localCardId == r101.localCardId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultTitle, r101.defaultTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.defaultCoverUrl, r101.defaultCoverUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.customizedTitle, r101.customizedTitle) == true) goto L18;
        return false;
    L18:
        if (this.isTitleChanged == r101.isTitleChanged) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.customizedCoverUrl, r101.customizedCoverUrl) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L26;
        return false;
    L26:
        if (this.reviewStatus == r101.reviewStatus) goto L28;
        return false;
    L28:
        if (this.fromReview == r101.fromReview) goto L30;
        return false;
    L30:
        if (this.canModifyCover == r101.canModifyCover) goto L32;
        return false;
    L32:
        if (this.status == r101.status) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L36;
        return false;
    L36:
        if (this.cardSource == r101.cardSource) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.createInfo, r101.createInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.reviewResultReason, r101.reviewResultReason) == true) goto L42;
        return false;
    L42:
        if (this.reviewTitleStatus == r101.reviewTitleStatus) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.reviewingTitle, r101.reviewingTitle) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.lastPassTitle, r101.lastPassTitle) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.lastPassCoverUrl, r101.lastPassCoverUrl) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.auditInfoList, r101.auditInfoList) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L54;
        return false;
    L54:
        if (this.priority == r101.priority) goto L56;
        return false;
    L56:
        if (this.topReason == r101.topReason) goto L58;
        return false;
    L58:
        if (this.showDuration == r101.showDuration) goto L60;
        return false;
    L60:
        if (this.isLeadsComponent == r101.isLeadsComponent) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.sellingPoint, r101.sellingPoint) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.presetCardUrl, r101.presetCardUrl) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.textPosterUrl, r101.textPosterUrl) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.textPosterTitle, r101.textPosterTitle) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.screenshotUrl, r101.screenshotUrl) == true) goto L72;
        return false;
    L72:
        if (this.selectedCoverType == r101.selectedCoverType) goto L74;
        return false;
    L74:
        if (this.customizedCoverType == r101.customizedCoverType) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    public final String i(String r100) {
        com.bytedance.android.live.openplatform.api.utils.a r101 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        boolean r102 = false;
        if (com.bytedance.android.live.openplatform.api.utils.a.f84001a.f() == false) goto L20;
        ProductInfo r103 = this.productInfo;
        if (r103 == null) goto L7;
        String r104 = r103.title;
    L8:
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L20;
        ProductInfo r106 = this.productInfo;
        if (r106 == null) goto L19;
        String r107 = r106.title;
        if (r107 == null) goto L19;
        return r107;
    L19:
        return "";
    L10:
        if (StringsKt.isBlank(r104) == true) goto L13;
        r105 = false;
        goto L14
    L7:
        r104 = null;
    L20:
        String r108 = this.reviewingTitle;
        if (r108 != null) goto L23;
    L24:
        r102 = true;
    L25:
        if (r102 == true) goto L30;
        if (this.reviewTitleStatus != 5) goto L30;
        return this.reviewingTitle;
    L30:
        return J(r100).getSecond();
    L23:
        if (StringsKt.isBlank(r108) == false) goto L25;
        goto L24
    }

    public final String j(boolean r100) {
        String r101 = o(r100).getSecond();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public final String k(String r100) {
        return a(r100).getSecond();
    }

    public final Pair<Integer, String> o(boolean r100) {
        String r101 = null;
        if (com.bytedance.android.live.openplatform.api.utils.b.f84002b.c() == false) goto L22;
        ProductInfo r102 = this.productInfo;
        if (r102 == null) goto L7;
        String r103 = r102.imgUrl;
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L22;
        ProductInfo r105 = this.productInfo;
        if (r105 == null) goto L19;
        String r106 = r105.imgUrl;
        if (r106 == null) goto L19;
    L21:
        return TuplesKt.to(-1, r106);
    L19:
        r106 = "";
        goto L21
    L10:
        if (StringsKt.isBlank(r103) == true) goto L13;
        r104 = false;
        goto L14
    L7:
        r103 = null;
    L22:
        int r107 = this.selectedCoverType;
        if (r107 != 1) goto L25;
        Pair<Integer, String> r108 = TuplesKt.to(1, this.presetCardUrl);
    L48:
        if (r108 != null) goto L50;
    L54:
        List<ImageModel> r109 = this.image;
        if (r109 == null) goto L62;
        ImageModel r110 = (ImageModel) CollectionsKt.firstOrNull(r109);
        if (r110 == null) goto L62;
        List<String> r111 = r110.getUrls();
        if (r111 == null) goto L62;
        r101 = (String) CollectionsKt.firstOrNull(r111);
    L62:
        return TuplesKt.to(0, r101);
    L50:
        if (r2.a(r108.getSecond()) == true) goto L53;
        r108 = null;
    L53:
        if (r108 == null) goto L54;
        return r108;
    L25:
        if (r107 == 2) goto L36;
        if (r107 != 3) goto L28;
        r108 = TuplesKt.to(3, this.screenshotUrl);
        goto L48
    L28:
        if (r107 == 4) goto L31;
        r108 = null;
        goto L48
    L31:
        if (F0() == false) goto L33;
        String r112 = this.customizedCoverUrl;
    L34:
        r108 = TuplesKt.to(4, r112);
        goto L48
    L33:
        r112 = this.lastPassCoverUrl;
        goto L34
    L36:
        if (r100 == true) goto L38;
    L39:
        if (r100 == true) goto L44;
        if (d90.f120014a.getValue().b() != 1) goto L44;
    L42:
        r108 = TuplesKt.to(2, this.textPosterUrl);
    L44:
        if (r2.a(this.presetCardUrl) == false) goto L46;
        r108 = TuplesKt.to(1, this.presetCardUrl);
        goto L48
    L46:
        r108 = TuplesKt.to(3, this.screenshotUrl);
        goto L48
    L38:
        if (ee0.f120119a.getValue().h() == true) goto L42;
        goto L39
    }

    public final boolean d(int r100, int r101) {
        Object r102 = null;
        if (r100 != (-1)) goto L18;
        List<AuditInfo> r103 = this.auditInfoList;
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (((AuditInfo) r105).auditStatus != r101) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L8;
        r102 = r105;
        goto L15
    L12:
        r106 = false;
    L15:
        r102 = (AuditInfo) r102;
    L16:
        if (r102 != null) goto L46;
    L34:
        return false;
    L46:
        return true;
    L18:
        List<AuditInfo> r107 = this.auditInfoList;
        if (r107 == null) goto L34;
        Iterator<T> r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L29;
        Object r109 = r108.next();
        if (((AuditInfo) r109).auditType != r100) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L22;
        r102 = r109;
        goto L29
    L26:
        r110 = false;
    L29:
        AuditInfo r111 = (AuditInfo) r102;
        if (r111 == null) goto L34;
        if (r111.auditStatus != r101) goto L34;
        return true;
    }

    public final boolean e(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L14;
        return false;
    L14:
        if (this.reviewTitleStatus != r101) goto L21;
    L8:
        return true;
    L21:
        return false;
    L17:
        if (this.reviewStatus == r101) goto L8;
        return false;
    L5:
        if (this.reviewStatus == r101) goto L8;
        if (this.reviewTitleStatus == r101) goto L8;
        return false;
    }

    public /* synthetic */ ShelfCardInfo(String r410, String r411, String r412, String r413, String r414, String r415, boolean r510, long r511, int r512, String r513, String r514, ProductInfo r515, String r516, String r517, String r518, String r610, String r611, int r612, int r613, int r614, int r615) {
        if ((r614 & 2) == 0) goto L5;
        long r100 = d.f83974a.getAndIncrement();
    L7:
        if ((r614 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r614 & 8) == 0) goto L13;
        String r110 = null;
    L15:
        if ((r614 & 16) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r614 & 32) == 0) goto L21;
        String r112 = null;
    L23:
        if ((r614 & 128) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r614 & 512) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r614 & 4096) == 0) goto L33;
        boolean r115 = true;
    L35:
        if ((r614 & 8192) == 0) goto L37;
        long r210 = 0;
    L39:
        if ((32768 & r614) == 0) goto L41;
        int r211 = Source.Phone.getValue();
    L43:
        if ((65536 & r614) == 0) goto L45;
        String r212 = null;
    L47:
        if ((2097152 & r614) == 0) goto L49;
        String r213 = null;
    L51:
        if ((8388608 & r614) == 0) goto L53;
        ProductInfo r310 = null;
    L55:
        if ((268435456 & r614) == 0) goto L57;
        String r311 = null;
    L59:
        if ((536870912 & r614) == 0) goto L61;
        String r312 = null;
    L63:
        if ((1073741824 & r614) == 0) goto L65;
        String r313 = null;
    L67:
        if ((r614 & Integer.MIN_VALUE) == 0) goto L69;
        String r314 = null;
    L71:
        if ((r615 & 1) == 0) goto L73;
        String r416 = null;
    L75:
        if ((r615 & 2) == 0) goto L77;
        int r417 = 0;
    L79:
        if ((r615 & 4) == 0) goto L81;
        int r418 = 0;
    L82:
        this(0, r100, r101, r110, r111, r112, false, r113, null, r114, 0, false, r115, r210, null, r211, r212, null, 0, null, null, r213, null, r310, 0, 0, 0, false, r311, r312, r313, r314, r416, r417, r418);
        return;
    L81:
        r418 = r613;
        goto L82
    L77:
        r417 = r612;
        goto L79
    L73:
        r416 = r611;
        goto L75
    L69:
        r314 = r610;
        goto L71
    L65:
        r313 = r518;
        goto L67
    L61:
        r312 = r517;
        goto L63
    L57:
        r311 = r516;
        goto L59
    L53:
        r310 = r515;
        goto L55
    L49:
        r213 = r514;
        goto L51
    L45:
        r212 = r513;
        goto L47
    L41:
        r211 = r512;
        goto L43
    L37:
        r210 = r511;
        goto L39
    L33:
        r115 = r510;
        goto L35
    L29:
        r114 = r415;
        goto L31
    L25:
        r113 = r414;
        goto L27
    L21:
        r112 = r413;
        goto L23
    L17:
        r111 = r412;
        goto L19
    L13:
        r110 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public static ShelfCardInfo g(ShelfCardInfo r410, String r411, String r412, String r413, String r510, boolean r511, String r512, long r513, int r514, String r515, List r516, ProductInfo r517, int r518, String r610, String r611, String r612, String r613, String r614, int r615, int r616, int r617, int r618) {
        long r100 = 0;
        if ((r617 & 1) == 0) goto L5;
        long r101 = r410.cardId;
    L7:
        if ((r617 & 2) == 0) goto L9;
        r100 = r410.localCardId;
    L9:
        long r110 = r100;
        if ((r617 & 4) == 0) goto L12;
        String r111 = r410.schema;
    L14:
        if ((r617 & 8) == 0) goto L16;
        String r112 = r410.defaultTitle;
    L18:
        if ((r617 & 16) == 0) goto L20;
        String r113 = r410.defaultCoverUrl;
    L22:
        if ((r617 & 32) == 0) goto L24;
        String r114 = r410.customizedTitle;
    L26:
        if ((r617 & 64) == 0) goto L28;
        boolean r115 = r410.isTitleChanged;
    L30:
        if ((r617 & 128) == 0) goto L32;
        String r116 = r410.customizedCoverUrl;
    L34:
        if ((r617 & 256) == 0) goto L36;
        List<ImageModel> r117 = r410.image;
    L38:
        if ((r617 & 512) == 0) goto L40;
        String r118 = r410.sourcePage;
    L42:
        if ((r617 & 1024) == 0) goto L44;
        int r210 = r410.reviewStatus;
    L46:
        if ((r617 & 2048) == 0) goto L48;
        boolean r211 = r410.fromReview;
    L50:
        if ((r617 & 4096) == 0) goto L52;
        boolean r212 = r410.canModifyCover;
    L54:
        if ((r617 & 8192) == 0) goto L56;
        long r213 = r410.status;
    L58:
        if ((r617 & 16384) == 0) goto L60;
        String r214 = r410.logExtra;
    L62:
        if ((32768 & r617) == 0) goto L64;
        int r215 = r410.cardSource;
    L66:
        if ((65536 & r617) == 0) goto L68;
        String r216 = r410.createInfo;
    L70:
        if ((131072 & r617) == 0) goto L72;
        String r217 = r410.reviewResultReason;
    L74:
        if ((262144 & r617) == 0) goto L76;
        int r218 = r410.reviewTitleStatus;
    L78:
        if ((524288 & r617) == 0) goto L80;
        String r310 = r410.reviewingTitle;
    L82:
        if ((1048576 & r617) == 0) goto L84;
        String r311 = r410.lastPassTitle;
    L86:
        if ((2097152 & r617) == 0) goto L88;
        String r312 = r410.lastPassCoverUrl;
    L90:
        if ((4194304 & r617) == 0) goto L92;
        List r313 = r410.auditInfoList;
    L94:
        if ((8388608 & r617) == 0) goto L96;
        ProductInfo r314 = r410.productInfo;
    L98:
        if ((16777216 & r617) == 0) goto L100;
        int r315 = r410.priority;
    L102:
        if ((33554432 & r617) == 0) goto L104;
        int r316 = r410.topReason;
    L106:
        if ((67108864 & r617) == 0) goto L108;
        int r317 = r410.showDuration;
    L110:
        if ((134217728 & r617) == 0) goto L112;
        boolean r318 = r410.isLeadsComponent;
    L114:
        if ((268435456 & r617) == 0) goto L116;
        String r319 = r410.sellingPoint;
    L118:
        if ((536870912 & r617) == 0) goto L120;
        String r414 = r410.presetCardUrl;
    L122:
        if ((1073741824 & r617) == 0) goto L124;
        String r415 = r410.textPosterUrl;
    L126:
        if ((r617 & Integer.MIN_VALUE) == 0) goto L128;
        String r416 = r410.textPosterTitle;
    L130:
        if ((r618 & 1) == 0) goto L132;
        String r417 = r410.screenshotUrl;
    L134:
        if ((r618 & 2) == 0) goto L136;
        int r418 = r410.selectedCoverType;
    L138:
        if ((r618 & 4) == 0) goto L140;
        int r419 = r410.customizedCoverType;
    L141:
        r410.getClass();
        return new ShelfCardInfo(r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r414, r415, r416, r417, r418, r419);
    L140:
        r419 = r616;
        goto L141
    L136:
        r418 = r615;
        goto L138
    L132:
        r417 = r614;
        goto L134
    L128:
        r416 = r613;
        goto L130
    L124:
        r415 = r612;
        goto L126
    L120:
        r414 = r611;
        goto L122
    L116:
        r319 = r610;
        goto L118
    L112:
        r318 = false;
        goto L114
    L108:
        r317 = 0;
        goto L110
    L104:
        r316 = r518;
        goto L106
    L100:
        r315 = 0;
        goto L102
    L96:
        r314 = r517;
        goto L98
    L92:
        r313 = r516;
        goto L94
    L88:
        r312 = null;
        goto L90
    L84:
        r311 = null;
        goto L86
    L80:
        r310 = null;
        goto L82
    L76:
        r218 = 0;
        goto L78
    L72:
        r217 = null;
        goto L74
    L68:
        r216 = r515;
        goto L70
    L64:
        r215 = r514;
        goto L66
    L60:
        r214 = null;
        goto L62
    L56:
        r213 = r513;
        goto L58
    L52:
        r212 = false;
        goto L54
    L48:
        r211 = false;
        goto L50
    L44:
        r210 = 0;
        goto L46
    L40:
        r118 = null;
        goto L42
    L36:
        r117 = null;
        goto L38
    L32:
        r116 = r512;
        goto L34
    L28:
        r115 = r511;
        goto L30
    L24:
        r114 = r510;
        goto L26
    L20:
        r113 = r413;
        goto L22
    L16:
        r112 = r412;
        goto L18
    L12:
        r111 = r411;
        goto L14
    L5:
        r101 = 0;
        goto L7
    }
}

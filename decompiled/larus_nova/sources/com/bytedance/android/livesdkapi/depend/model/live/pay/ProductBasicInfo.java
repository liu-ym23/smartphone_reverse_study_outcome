package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b4\u00105R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0016\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0016\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0007R\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0007R\u0016\u0010(\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\fR\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0004R\u0016\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010\fR\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0007R\u0016\u00100\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010\fR\u0011\u00103\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductBasicInfo;", "", "", "id", "J", "", "idStr", "Ljava/lang/String;", "_ownerUserId", "_ownerOpenId", "", "status", "I", "biz", "category", "categoryContent", "title", "source", "coverUri", "Lpy/k;", "cover", "Lpy/k;", "reviewStatus", "performanceStatus", "disableReason", "saleStartTime", "saleEndTime", "refundDeadline", "introductionText", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Introduction;", "introduction", "Ljava/util/List;", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/HeaderMedia;", "headerMedia", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductTag;", PromotionProductPrivilegesStruct.TAGS, "contentTitle", "contentCategory", "contentExtentInfo", "saleStatus", "servicePeriod", "", "geoBan", "Z", "combinedViewRight", "jumpSchema", "detailSchema", "newProduct", "getOwnerUserIdStr", "()Ljava/lang/String;", "ownerUserIdStr", "<init>", "()V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductBasicInfo implements h {
    public static final int BIZ_TYPE_ALBUM = 3;
    public static final int BIZ_TYPE_COMPILATION = 5;
    public static final int BIZ_TYPE_LIVE_SHOW_TICKET = 1;
    public static final int BIZ_TYPE_PLAYLET = 4;
    public static final int BIZ_TYPE_VIDEO = 2;
    public static final int CATEGORY_TYPE_CAMERA_SINGLE = 2;
    public static final int CATEGORY_TYPE_COMBINED = 5;
    public static final int CATEGORY_TYPE_COMBINED_SUB = 6;
    public static final int CATEGORY_TYPE_COMBINED_VIDEO = 8;
    public static final int CATEGORY_TYPE_LIVE = 1;
    public static final int CATEGORY_TYPE_PRIVILEGE = 3;
    public static final int CATEGORY_TYPE_SINGLE_VIDEO = 7;
    public static final int CATEGORY_TYPE_TICKET_AND_PRIVILEGE = 4;
    public static final int CATEGORY_TYPE_UNKNOWN = 0;
    public static final Companion Companion = null;

    @SerializedName("owner_open_id")
    public String _ownerOpenId;

    @SerializedName("owner_user_id")
    public long _ownerUserId;

    @SerializedName("biz")
    public int biz;

    @SerializedName("category")
    public int category;

    @SerializedName("category_content")
    public String categoryContent;

    @SerializedName("combined_view_right")
    public int combinedViewRight;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTER_CONTENT_CATEGORY)
    public String contentCategory;

    @SerializedName("content_extent_info")
    public String contentExtentInfo;

    @SerializedName("content_title")
    public String contentTitle;

    @SerializedName("cover")
    public k cover;

    @SerializedName("cover_uri")
    public String coverUri;

    @SerializedName("detail_schema")
    public String detailSchema;

    @SerializedName("disable_reason")
    public int disableReason;

    @SerializedName("geo_ban")
    public boolean geoBan;

    @SerializedName("header_media")
    public List<HeaderMedia> headerMedia;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f162625id;

    @SerializedName("id_str")
    public String idStr;

    @SerializedName("introduction")
    public List<Introduction> introduction;

    @SerializedName("introduction_text")
    public String introductionText;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("new_product")
    public int newProduct;

    @SerializedName("performance_status")
    public int performanceStatus;

    @SerializedName("refund_deadline")
    public long refundDeadline;

    @SerializedName("review_status")
    public int reviewStatus;

    @SerializedName("sale_end_time")
    public long saleEndTime;

    @SerializedName("sale_start_time")
    public long saleStartTime;

    @SerializedName("sale_status")
    public int saleStatus;

    @SerializedName("service_period")
    public long servicePeriod;

    @SerializedName("source")
    public int source;

    @SerializedName("status")
    public int status;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<ProductTag> tags;

    @SerializedName("title")
    public String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductBasicInfo$Companion;", "", "()V", "BIZ_TYPE_ALBUM", "", "BIZ_TYPE_COMPILATION", "BIZ_TYPE_LIVE_SHOW_TICKET", "BIZ_TYPE_PLAYLET", "BIZ_TYPE_VIDEO", "CATEGORY_TYPE_CAMERA_SINGLE", "CATEGORY_TYPE_COMBINED", "CATEGORY_TYPE_COMBINED_SUB", "CATEGORY_TYPE_COMBINED_VIDEO", "CATEGORY_TYPE_LIVE", "CATEGORY_TYPE_PRIVILEGE", "CATEGORY_TYPE_SINGLE_VIDEO", "CATEGORY_TYPE_TICKET_AND_PRIVILEGE", "CATEGORY_TYPE_UNKNOWN", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getOwnerUserIdStr() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._ownerUserId);
        String r102 = this._ownerOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public ProductBasicInfo() {
        this._ownerOpenId = "0";
    }

    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, py.k] */
    public ProductBasicInfo(g r100) {
        this.introduction = new ArrayList();
        this.headerMedia = new ArrayList();
        this.tags = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L43;
        if (r102 != 5000) goto L7;
        this._ownerOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L33;
            case 10: goto L32;
            case 11: goto L31;
            case 12: goto L30;
            case 13: goto L29;
            case 14: goto L28;
            case 15: goto L27;
            case 16: goto L26;
            case 17: goto L25;
            case 18: goto L24;
            case 19: goto L22;
            case 20: goto L21;
            case 21: goto L20;
            case 22: goto L19;
            case 23: goto L18;
            case 24: goto L17;
            default: goto L8;
        };
    L17:
        this.contentExtentInfo = am3.h.c(r100);
        goto L3
    L18:
        this.contentCategory = am3.h.c(r100);
        goto L3
    L19:
        this.contentTitle = am3.h.c(r100);
        goto L3
    L20:
        List r103 = this.tags;
        h r104 = new ProductTag(r100);
    L23:
        r103.add(r104);
        goto L3
    L21:
        r103 = this.headerMedia;
        r104 = new HeaderMedia(r100);
        goto L23
    L22:
        r103 = this.introduction;
        r104 = new Introduction(r100);
        goto L23
    L24:
        this.introductionText = am3.h.c(r100);
        goto L3
    L25:
        this.refundDeadline = r100.j();
        goto L3
    L26:
        this.saleEndTime = r100.j();
        goto L3
    L27:
        this.saleStartTime = r100.j();
        goto L3
    L28:
        this.disableReason = r100.i();
        goto L3
    L29:
        this.performanceStatus = r100.i();
        goto L3
    L30:
        this.reviewStatus = r100.i();
        goto L3
    L31:
        this.cover = f.a(r100, k.class);
        goto L3
    L32:
        this.coverUri = am3.h.c(r100);
        goto L3
    L33:
        this.source = r100.i();
        goto L3
    L34:
        this.title = am3.h.c(r100);
        goto L3
    L35:
        this.categoryContent = am3.h.c(r100);
        goto L3
    L36:
        this.category = r100.i();
        goto L3
    L37:
        this.biz = r100.i();
        goto L3
    L38:
        this.status = r100.i();
        goto L3
    L39:
        this._ownerUserId = r100.j();
        goto L3
    L40:
        this.idStr = am3.h.c(r100);
        goto L3
    L41:
        this.f162625id = r100.j();
        goto L3
    L8:
        switch(r102) {
            case 26: goto L16;
            case 27: goto L15;
            case 28: goto L14;
            case 29: goto L13;
            case 30: goto L12;
            case 31: goto L11;
            case 32: goto L10;
            default: goto L9;
        };
    L10:
        this.newProduct = r100.i();
        goto L3
    L11:
        this.detailSchema = am3.h.c(r100);
        goto L3
    L12:
        this.jumpSchema = am3.h.c(r100);
        goto L3
    L13:
        this.combinedViewRight = r100.i();
        goto L3
    L14:
        this.geoBan = am3.h.a(r100);
        goto L3
    L15:
        this.servicePeriod = r100.j();
        goto L3
    L16:
        this.saleStatus = r100.i();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L43:
        r100.d(r101);
        if (this._ownerOpenId != null) goto L115;
        this._ownerOpenId = "0";
        return;
    }
}

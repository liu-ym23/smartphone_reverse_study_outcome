package com.bytedance.android.shopping.anchorv3.comment.model;

import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.MoreActions;
import com.bytedance.android.ec.model.response.PromotionProductCommentAppendDTO;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.ReplyData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.ec.model.response.g;
import com.bytedance.android.ec.model.response.o1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p53.d;
import p53.f;
import p53.i;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\u0002\u0092\u0001Bµ\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010-\u001a\u0004\u0018\u00010&\u0012\u0006\u00103\u001a\u00020&\u0012\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106\u0012\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u000106\u0012\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u000106\u0012\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u000106\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u000106\u0012\b\u0010M\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010O\u001a\u00020\f\u0012\u0006\u0010Q\u001a\u00020&\u0012\u0006\u0010R\u001a\u00020\f\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010[\u001a\u00020&\u0012\b\b\u0002\u0010^\u001a\u00020]\u0012\b\b\u0002\u0010d\u001a\u00020]\u0012\b\b\u0002\u0010g\u001a\u00020]\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010]\u0012\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020o\u0018\u000106\u0012\u0016\b\u0002\u0010s\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010r\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010w\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010~\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020&\u0012\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010&¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010(\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\u001f\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001f\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u0001068\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001f\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u0001068\u0006¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;R\u001f\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u0001068\u0006¢\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010;R\u0019\u0010F\u001a\u0004\u0018\u00010E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001f\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u0001068\u0006¢\u0006\f\n\u0004\bK\u00109\u001a\u0004\bL\u0010;R\u0019\u0010M\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\bM\u0010\u001f\u001a\u0004\bN\u0010!R\u0017\u0010O\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\bO\u0010\u000e\u001a\u0004\bP\u0010\u0010R\u0017\u0010Q\u001a\u00020&8\u0006¢\u0006\f\n\u0004\bQ\u0010(\u001a\u0004\bQ\u0010*R\u0017\u0010R\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\bR\u0010\u000e\u001a\u0004\bS\u0010\u0010R$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010(\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\u0017\u0010g\u001a\u00020]8\u0006¢\u0006\f\n\u0004\bg\u0010_\u001a\u0004\bh\u0010aR\u0019\u0010i\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\bi\u0010\u000e\u001a\u0004\bj\u0010\u0010R\u0019\u0010k\u001a\u0004\u0018\u00010]8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001f\u0010p\u001a\n\u0012\u0004\u0012\u00020o\u0018\u0001068\u0006¢\u0006\f\n\u0004\bp\u00109\u001a\u0004\bq\u0010;R%\u0010s\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010r8\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR$\u0010x\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010(\u001a\u0005\b\u0085\u0001\u0010*\"\u0005\b\u0086\u0001\u0010,R,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010.\u001a\u0005\b\u008e\u0001\u00100¨\u0006\u0093\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentNodeVO;", "Ljava/io/Serializable;", "", "", "id", "J", "getId", "()J", "productId", "getProductId", "orderId", "getOrderId", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "shopReply", "getShopReply", "commentTime", "getCommentTime", "rank", "getRank", ECPromotion.SKU, "getSku", "shopDescription", "getShopDescription", "userName", "getUserName", "Lcom/bytedance/android/ec/model/ECUrlModel;", "userAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getUserAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "likes", "getLikes", "setLikes", "(J)V", "", "liked", "Z", "getLiked", "()Z", "setLiked", "(Z)V", "consed", "Ljava/lang/Boolean;", "getConsed", "()Ljava/lang/Boolean;", "setConsed", "(Ljava/lang/Boolean;)V", "hasPostedEvent", "getHasPostedEvent", "setHasPostedEvent", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "videoInfo", "Ljava/util/List;", "getVideoInfo", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/ECCommentVideo;", "videoInfoV2", "getVideoInfoV2", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentPhotoDTO;", "imagesInfos", "getImagesInfos", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentAppendDTO;", "appendComment", "getAppendComment", "Lp53/f;", "productCardInfo", "Lp53/f;", "getProductCardInfo", "()Lp53/f;", "Lp53/i;", "tagsInfo", "getTagsInfo", "rankTypeIcon", "getRankTypeIcon", "browseCount", "getBrowseCount", "isAnonymous", "userPageSchema", "getUserPageSchema", "Lcom/bytedance/android/ec/model/response/o1;", "showOrderInfo", "Lcom/bytedance/android/ec/model/response/o1;", "getShowOrderInfo", "()Lcom/bytedance/android/ec/model/response/o1;", "setShowOrderInfo", "(Lcom/bytedance/android/ec/model/response/o1;)V", "isSameComment", "setSameComment", "", "commentRank", "I", "getCommentRank", "()I", "setCommentRank", "(I)V", "commentIndex", "getCommentIndex", "setCommentIndex", "lowQualityType", "getLowQualityType", "goldCardSchema", "getGoldCardSchema", "rankType", "Ljava/lang/Integer;", "getRankType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/response/g;", "highlights", "getHighlights", "", "logMap", "Ljava/util/Map;", "getLogMap", "()Ljava/util/Map;", "Lp53/d;", "meaninglessVO", "Lp53/d;", "getMeaninglessVO", "()Lp53/d;", "setMeaninglessVO", "(Lp53/d;)V", "Lcom/bytedance/android/ec/model/response/MoreActions;", "moreActions", "Lcom/bytedance/android/ec/model/response/MoreActions;", "getMoreActions", "()Lcom/bytedance/android/ec/model/response/MoreActions;", "setMoreActions", "(Lcom/bytedance/android/ec/model/response/MoreActions;)V", "isAuthor", "setAuthor", "Lcom/bytedance/android/ec/model/response/ReplyData;", "replyData", "Lcom/bytedance/android/ec/model/response/ReplyData;", "getReplyData", "()Lcom/bytedance/android/ec/model/response/ReplyData;", "setReplyData", "(Lcom/bytedance/android/ec/model/response/ReplyData;)V", "isSelected", "<init>", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JZLjava/lang/Boolean;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lp53/f;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/ec/model/response/o1;ZIIILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;Lp53/d;Lcom/bytedance/android/ec/model/response/MoreActions;ZLcom/bytedance/android/ec/model/response/ReplyData;Ljava/lang/Boolean;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentNodeVO implements Serializable {
    public static final a Companion = null;
    private final List<PromotionProductCommentAppendDTO> appendComment;
    private final String browseCount;
    private int commentIndex;
    private int commentRank;
    private final String commentTime;
    private Boolean consed;
    private final String content;
    private final String goldCardSchema;
    private boolean hasPostedEvent;
    private final List<g> highlights;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f164529id;
    private final List<PromotionProductCommentPhotoDTO> imagesInfos;
    private final boolean isAnonymous;
    private boolean isAuthor;
    private boolean isSameComment;

    @SerializedName("is_selected")
    private final Boolean isSelected;
    private boolean liked;
    private long likes;
    private final Map<String, String> logMap;
    private final int lowQualityType;
    private d meaninglessVO;
    private MoreActions moreActions;
    private final long orderId;
    private final f productCardInfo;
    private final long productId;
    private final long rank;
    private final Integer rankType;
    private final ECUrlModel rankTypeIcon;
    private ReplyData replyData;
    private final String shopDescription;
    private final String shopReply;
    private o1 showOrderInfo;
    private final String sku;
    private final List<i> tagsInfo;
    private final ECUrlModel userAvatar;
    private final String userName;
    private final String userPageSchema;
    private final List<PromotionVideoInfo> videoInfo;
    private final List<ECCommentVideo> videoInfoV2;

    public static final class a {
        public a() {
        }

        public static boolean a(PromotionProductCommentAppendDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "appendComment");
            if (TextUtils.isEmpty(r100.getContent()) == false) goto L15;
            List<PromotionVideoInfo> r101 = r100.getVideos();
            if (r101 != null) goto L7;
        L8:
            List<PromotionProductCommentPhotoDTO> r102 = r100.getPhotos();
            if (r102 != null) goto L11;
        L13:
            return false;
        L11:
            if ((!r102.isEmpty()) != true) goto L13;
            return true;
        L7:
            if ((!r101.isEmpty()) != true) goto L8;
            return true;
        L15:
            return true;
        }
    }

    static {
        Companion = new a();
    }

    public final List<PromotionProductCommentAppendDTO> getAppendComment() {
        return this.appendComment;
    }

    public final String getBrowseCount() {
        return this.browseCount;
    }

    public final int getCommentIndex() {
        return this.commentIndex;
    }

    public final int getCommentRank() {
        return this.commentRank;
    }

    public final String getCommentTime() {
        return this.commentTime;
    }

    public final Boolean getConsed() {
        return this.consed;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getGoldCardSchema() {
        return this.goldCardSchema;
    }

    public final boolean getHasPostedEvent() {
        return this.hasPostedEvent;
    }

    public final List<g> getHighlights() {
        return this.highlights;
    }

    public final long getId() {
        return this.f164529id;
    }

    public final List<PromotionProductCommentPhotoDTO> getImagesInfos() {
        return this.imagesInfos;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final long getLikes() {
        return this.likes;
    }

    public final Map<String, String> getLogMap() {
        return this.logMap;
    }

    public final int getLowQualityType() {
        return this.lowQualityType;
    }

    public final d getMeaninglessVO() {
        return this.meaninglessVO;
    }

    public final MoreActions getMoreActions() {
        return this.moreActions;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    public final f getProductCardInfo() {
        return this.productCardInfo;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final long getRank() {
        return this.rank;
    }

    public final Integer getRankType() {
        return this.rankType;
    }

    public final ECUrlModel getRankTypeIcon() {
        return this.rankTypeIcon;
    }

    public final ReplyData getReplyData() {
        return this.replyData;
    }

    public final String getShopDescription() {
        return this.shopDescription;
    }

    public final String getShopReply() {
        return this.shopReply;
    }

    public final o1 getShowOrderInfo() {
        return this.showOrderInfo;
    }

    public final String getSku() {
        return this.sku;
    }

    public final List<i> getTagsInfo() {
        return this.tagsInfo;
    }

    public final ECUrlModel getUserAvatar() {
        return this.userAvatar;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserPageSchema() {
        return this.userPageSchema;
    }

    public final List<PromotionVideoInfo> getVideoInfo() {
        return this.videoInfo;
    }

    public final List<ECCommentVideo> getVideoInfoV2() {
        return this.videoInfoV2;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isAuthor() {
        return this.isAuthor;
    }

    public final boolean isSameComment() {
        return this.isSameComment;
    }

    public final Boolean isSelected() {
        return this.isSelected;
    }

    public final void setAuthor(boolean r100) {
        this.isAuthor = r100;
    }

    public final void setCommentIndex(int r100) {
        this.commentIndex = r100;
    }

    public final void setCommentRank(int r100) {
        this.commentRank = r100;
    }

    public final void setConsed(Boolean r100) {
        this.consed = r100;
    }

    public final void setHasPostedEvent(boolean r100) {
        this.hasPostedEvent = r100;
    }

    public final void setLiked(boolean r100) {
        this.liked = r100;
    }

    public final void setLikes(long r100) {
        this.likes = r100;
    }

    public final void setMeaninglessVO(d r100) {
        this.meaninglessVO = r100;
    }

    public final void setMoreActions(MoreActions r100) {
        this.moreActions = r100;
    }

    public final void setReplyData(ReplyData r100) {
        this.replyData = r100;
    }

    public final void setSameComment(boolean r100) {
        this.isSameComment = r100;
    }

    public final void setShowOrderInfo(o1 r100) {
        this.showOrderInfo = r100;
    }

    public CommentNodeVO(long r110, long r111, long r112, String r113, String r114, String r210, long r211, String r212, String r213, String r214, ECUrlModel r215, long r216, boolean r217, Boolean r310, boolean r311, List<PromotionVideoInfo> r312, List<ECCommentVideo> r313, List<PromotionProductCommentPhotoDTO> r314, List<PromotionProductCommentAppendDTO> r315, f r316, List<i> r317, ECUrlModel r318, String r319, boolean r410, String r411, o1 r412, boolean r413, int r414, int r415, int r416, String r417, Integer r418, List<g> r419, Map<String, String> r510, d r511, MoreActions r512, boolean r513, ReplyData r514, Boolean r515) {
        Intrinsics.checkNotNullParameter(r113, "content");
        Intrinsics.checkNotNullParameter(r114, "shopReply");
        Intrinsics.checkNotNullParameter(r210, "commentTime");
        Intrinsics.checkNotNullParameter(r212, ECPromotion.SKU);
        Intrinsics.checkNotNullParameter(r214, "userName");
        Intrinsics.checkNotNullParameter(r215, "userAvatar");
        Intrinsics.checkNotNullParameter(r319, "browseCount");
        Intrinsics.checkNotNullParameter(r411, "userPageSchema");
        this.f164529id = r110;
        this.productId = r111;
        this.orderId = r112;
        this.content = r113;
        this.shopReply = r114;
        this.commentTime = r210;
        this.rank = r211;
        this.sku = r212;
        this.shopDescription = r213;
        this.userName = r214;
        this.userAvatar = r215;
        this.likes = r216;
        this.liked = r217;
        this.consed = r310;
        this.hasPostedEvent = r311;
        this.videoInfo = r312;
        this.videoInfoV2 = r313;
        this.imagesInfos = r314;
        this.appendComment = r315;
        this.productCardInfo = r316;
        this.tagsInfo = r317;
        this.rankTypeIcon = r318;
        this.browseCount = r319;
        this.isAnonymous = r410;
        this.userPageSchema = r411;
        this.showOrderInfo = r412;
        this.isSameComment = r413;
        this.commentRank = r414;
        this.commentIndex = r415;
        this.lowQualityType = r416;
        this.goldCardSchema = r417;
        this.rankType = r418;
        this.highlights = r419;
        this.logMap = r510;
        this.meaninglessVO = r511;
        this.moreActions = r512;
        this.isAuthor = r513;
        this.replyData = r514;
        this.isSelected = r515;
    }

    public /* synthetic */ CommentNodeVO(long r410, long r510, long r511, String r512, String r513, String r514, long r515, String r610, String r611, String r612, ECUrlModel r613, long r614, boolean r615, Boolean r616, boolean r617, List r618, List r710, List r711, List r712, f r713, List r714, ECUrlModel r715, String r716, boolean r717, String r718, o1 r719, boolean r810, int r811, int r812, int r813, String r814, Integer r815, List r816, Map r817, d r818, MoreActions r819, boolean r910, ReplyData r911, Boolean r912, int r913, int r914, DefaultConstructorMarker r915) {
        if ((r913 & 256) == 0) goto L5;
        String r110 = null;
    L7:
        if ((33554432 & r913) == 0) goto L9;
        o1 r310 = null;
    L11:
        if ((134217728 & r913) == 0) goto L13;
        int r311 = 0;
    L15:
        if ((268435456 & r913) == 0) goto L17;
        int r312 = 0;
    L19:
        if ((536870912 & r913) == 0) goto L21;
        int r313 = 0;
    L23:
        if ((1073741824 & r913) == 0) goto L25;
        String r314 = null;
    L27:
        if ((r913 & Integer.MIN_VALUE) == 0) goto L29;
        Integer r411 = null;
    L31:
        if ((r914 & 1) == 0) goto L33;
        List r412 = null;
    L35:
        if ((r914 & 2) == 0) goto L37;
        Map r413 = null;
    L39:
        if ((r914 & 4) == 0) goto L41;
        d r414 = null;
    L43:
        if ((r914 & 8) == 0) goto L45;
        MoreActions r415 = null;
    L47:
        if ((r914 & 16) == 0) goto L49;
        boolean r416 = false;
    L51:
        if ((r914 & 32) == 0) goto L53;
        ReplyData r417 = null;
    L55:
        if ((r914 & 64) == 0) goto L57;
        Boolean r418 = Boolean.FALSE;
    L58:
        this(r410, r510, r511, r512, r513, r514, r515, r610, r110, r612, r613, r614, r615, r616, r617, r618, r710, r711, r712, r713, r714, r715, r716, r717, r718, r310, r810, r311, r312, r313, r314, r411, r412, r413, r414, r415, r416, r417, r418);
        return;
    L57:
        r418 = r912;
        goto L58
    L53:
        r417 = r911;
        goto L55
    L49:
        r416 = r910;
        goto L51
    L45:
        r415 = r819;
        goto L47
    L41:
        r414 = r818;
        goto L43
    L37:
        r413 = r817;
        goto L39
    L33:
        r412 = r816;
        goto L35
    L29:
        r411 = r815;
        goto L31
    L25:
        r314 = r814;
        goto L27
    L21:
        r313 = r813;
        goto L23
    L17:
        r312 = r812;
        goto L19
    L13:
        r311 = r811;
        goto L15
    L9:
        r310 = r719;
        goto L11
    L5:
        r110 = r611;
        goto L7
    }
}

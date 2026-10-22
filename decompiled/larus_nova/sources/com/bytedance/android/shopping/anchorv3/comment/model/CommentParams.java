package com.bytedance.android.shopping.anchorv3.comment.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001BÕ\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010L\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010Y\u001a\u00020\u0002\u0012\b\b\u0002\u0010\\\u001a\u00020\u0019\u0012\b\b\u0002\u0010_\u001a\u00020\u0019\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010o\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010z\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\b\u001a\u00020\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004J\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R \u0010)\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R \u0010+\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0017\u0010,\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\u0019\u0010/\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b/\u0010!\u001a\u0004\b0\u0010#R\u0019\u00101\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b1\u0010!\u001a\u0004\b2\u0010#R\u0019\u00103\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b3\u0010!\u001a\u0004\b4\u0010#R\u0019\u00105\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b5\u0010!\u001a\u0004\b6\u0010#R\u0019\u00107\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b7\u0010!\u001a\u0004\b8\u0010#R\u0019\u00109\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R\u0019\u0010;\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b;\u0010!\u001a\u0004\b<\u0010#R\u0019\u0010>\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR'\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bI\u0010*\u001a\u0004\bJ\u0010KR*\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010S\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010!\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R$\u0010V\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010!\u001a\u0004\bW\u0010#\"\u0004\bX\u0010%R\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010-\u001a\u0004\bY\u0010.\"\u0004\bZ\u0010[R\"\u0010\\\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u001b\u001a\u0004\b]\u0010\u001d\"\u0004\b^\u0010\u001fR\"\u0010_\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010\u001b\u001a\u0004\b`\u0010\u001d\"\u0004\ba\u0010\u001fR$\u0010b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010!\u001a\u0004\bc\u0010#\"\u0004\bd\u0010%R2\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010*\u001a\u0004\bf\u0010K\"\u0004\bg\u0010hR\u0019\u0010i\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\bi\u0010!\u001a\u0004\bj\u0010#R\u0019\u0010k\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR$\u0010p\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010v\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010l\u001a\u0004\bw\u0010n\"\u0004\bx\u0010yR*\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010N\u001a\u0004\b|\u0010P\"\u0004\b}\u0010RR%\u0010~\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010!\u001a\u0004\b\u007f\u0010#\"\u0005\b\u0080\u0001\u0010%¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentParams;", "Ljava/io/Serializable;", "", "isFromProductDetail", "", "", "", "injectExtra", "getExtraStr", "enableTagRevision", "isTagRevisionPlusExpGroup", "isTagRevisionPlusStyle3", "getPassedAbParams", "getPassedCommentCommonAb", "", "getPassedTagVersion", "getPassedTitleGuideContent", "getPassedTitleGuideContentType", "Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;", "enterClickTagItem", "Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;", "getEnterClickTagItem", "()Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;", "setEnterClickTagItem", "(Lcom/bytedance/android/shopping/anchorv3/comment/model/StatTagItem;)V", "", "marginBottom", "I", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "btmId", "Ljava/lang/String;", "getBtmId", "()Ljava/lang/String;", "setBtmId", "(Ljava/lang/String;)V", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "passedAbParams", "Ljava/util/Map;", "passedCommentCommonAb", "isLuban", "Z", "()Z", "productId", "getProductId", "referKolId", "getReferKolId", "userId", "getUserId", "authorId", "getAuthorId", "shopId", "getShopId", "searchId", "getSearchId", "businessType", "getBusinessType", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentLogParams;", "logParams", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentLogParams;", "getLogParams", "()Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentLogParams;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentExtras;", "commentExtras", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentExtras;", "getCommentExtras", "()Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentExtras;", "setCommentExtras", "(Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentExtras;)V", "baseLogParams", "getBaseLogParams", "()Ljava/util/Map;", "", "topCommentIds", "Ljava/util/List;", "getTopCommentIds", "()Ljava/util/List;", "setTopCommentIds", "(Ljava/util/List;)V", "topCommentTypes", "getTopCommentTypes", "setTopCommentTypes", "pageTitle", "getPageTitle", "setPageTitle", "isStoreComment", "setStoreComment", "(Z)V", "showOrderStat", "getShowOrderStat", "setShowOrderStat", "dataType", "getDataType", "setDataType", "pageName", "getPageName", "setPageName", "extraParams", "getExtraParams", "setExtraParams", "(Ljava/util/Map;)V", "commentPreloadDataJson", "getCommentPreloadDataJson", "productMinPrice", "Ljava/lang/Long;", "getProductMinPrice", "()Ljava/lang/Long;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;", "bottomProductCardInfo", "Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;", "getBottomProductCardInfo", "()Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;", "setBottomProductCardInfo", "(Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;)V", "replyCid", "getReplyCid", "setReplyCid", "(Ljava/lang/Long;)V", "", "highlightReplyCid", "getHighlightReplyCid", "setHighlightReplyCid", "pdpSessionId", "getPdpSessionId", "setPdpSessionId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentLogParams;Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentExtras;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentParams implements Serializable {
    private final String authorId;
    private final Map<String, Object> baseLogParams;
    private BottomProductCardInfo bottomProductCardInfo;
    private String btmId;
    private final String businessType;
    private CommentExtras commentExtras;
    private final String commentPreloadDataJson;
    private int dataType;
    private StatTagItem enterClickTagItem;
    private Map<String, ? extends Object> extraParams;
    private List<String> highlightReplyCid;
    private final boolean isLuban;
    private boolean isStoreComment;
    private final CommentLogParams logParams;
    private int marginBottom;
    private String pageName;
    private String pageTitle;
    private Map<?, ?> passedAbParams;
    private Map<?, ?> passedCommentCommonAb;

    @SerializedName(a.KEY_PDP_SESSION_ID)
    private String pdpSessionId;
    private final String productId;
    private final Long productMinPrice;
    private final String referKolId;
    private Long replyCid;
    private final String searchId;
    private final String shopId;
    private int showOrderStat;
    private String sourceBtmToken;
    private List<String> topCommentIds;

    @SerializedName("top_comment_types")
    private String topCommentTypes;
    private final String userId;

    public CommentParams() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, 0, null, null, null, null, null, null, null, null, 33554431, null);
    }

    public final Map<?, ?> getPassedAbParams() {
        Map<String, ? extends Object> r100 = this.extraParams;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS);
    L7:
        if (TypeIntrinsics.isMutableMap(r102) == true) goto L9;
        r102 = null;
    L9:
        Map r103 = (Map) r102;
        if (r103 == null) goto L13;
        Object r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L13;
    L14:
        Map<?, ?> r105 = TypeIntrinsics.asMutableMap(r104);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L34
        Object r107 = r105.get("comment_common_ab");     // Catch: Throwable -> L34
        if ((r107 instanceof String) == false) goto L19;
        r101 = r107;
    L19:
        String r108 = (String) r101;     // Catch: Throwable -> L34
        if (r108 != null) goto L22;
    L25:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L28;
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L34
    L30:
        if (r110.has("bff_ab_value") == true) goto L32;
        r110.put("bff_ab_value", "1");     // Catch: Throwable -> L34
    L32:
        r105.put("comment_common_ab", r110.toString());     // Catch: Throwable -> L34
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        this.passedAbParams = r105;
        return r105;
    L28:
        r110 = new JSONObject(r108);     // Catch: Throwable -> L34
        goto L30
    L22:
        if (StringsKt.isBlank(r108) == true) goto L25;
        r109 = false;
    L34:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        r104 = new LinkedHashMap();
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public final Map<?, ?> getPassedCommentCommonAb() {
        Map<?, ?> r100 = this.passedCommentCommonAb;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Map<?, ?> r101 = getPassedAbParams();
        if ((r101 instanceof Map) == false) goto L23;
        Object r102 = r101.get("comment_common_ab");
        if ((r102 instanceof String) == true) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L23;
        this.passedCommentCommonAb = z1.k(new JSONObject(r103));     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L23:
        return this.passedCommentCommonAb;
    }

    public final long getPassedTagVersion() {
        Map<String, ? extends Object> r100 = this.extraParams;
        if (r100 == null) goto L5;
        Object r101 = r100.get("tag_version");
    L7:
        if ((r101 instanceof Long) == false) goto L10;
        return ((Number) r101).longValue();
    L10:
        if ((r101 instanceof Double) == false) goto L13;
        return (long) ((Number) r101).doubleValue();
    L13:
        if ((r101 instanceof String) == false) goto L18;
        Long r102 = StringsKt.toLongOrNull((String) r101);
        if (r102 == null) goto L18;
        return r102.longValue();
    L18:
        return 0;
    L5:
        r101 = null;
        goto L7
    }

    public final String getPassedTitleGuideContent() {
        Map<String, ? extends Object> r100 = this.extraParams;
        if (r100 == null) goto L5;
        Object r101 = r100.get("title_guide_content");
    L7:
        if ((r101 instanceof String) == true) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length() <= 0) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        return null;
    L17:
        return r102;
    L14:
        r103 = false;
        goto L15
    L5:
        r101 = null;
        goto L7
    }

    public final String getPassedTitleGuideContentType() {
        Map<String, ? extends Object> r100 = this.extraParams;
        if (r100 == null) goto L5;
        Object r101 = r100.get("title_guide_content_type");
    L7:
        if ((r101 instanceof String) == true) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length() <= 0) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        return null;
    L17:
        return r102;
    L14:
        r103 = false;
        goto L15
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isFromProductDetail() {
        CommentLogParams r100 = this.logParams;
        if (r100 == null) goto L5;
        String r101 = r100.getCommentEntrance();
    L7:
        return Intrinsics.areEqual(r101, a.VALUE_PRODUCT_DETAIL);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableTagRevision() {
        Map<?, ?> r100 = getPassedAbParams();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L11:
        String r102 = "0";
    L25:
        if (r102.length() <= 0) goto L27;
        boolean r103 = true;
    L28:
        if (r103 == false) goto L32;
        if ((!Intrinsics.areEqual(r102, "0")) == false) goto L32;
    L33:
        return true;
    L32:
        if (isTagRevisionPlusExpGroup() == true) goto L33;
        return false;
    L27:
        r103 = false;
        goto L28
    L12:
        Object r104 = r100.get("ecom_comment_ab_namespace_comment_v2");
        if ((r104 instanceof String) == true) goto L15;
        r104 = null;
    L15:
        r102 = (String) r104;
        if (r102 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L25;
    L18:
        if (r102.length() == 0) goto L21;
        r105 = false;
        goto L22
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean isTagRevisionPlusExpGroup() {
        Map<?, ?> r100 = getPassedAbParams();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Object r102 = r100.get("comment_impres_show_style");
        if (r102 == null) goto L15;
        String r103 = r102.toString();
        if (r103 == null) goto L15;
    L17:
        if (r103.length() <= 0) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == true) goto L22;
        return false;
    L22:
        if ((!Intrinsics.areEqual(r103, "0")) == false) goto L26;
        return true;
    L26:
        return false;
    L19:
        r104 = false;
    L15:
        r103 = "";
        goto L17
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean isTagRevisionPlusStyle3() {
        Map<?, ?> r100 = getPassedAbParams();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Object r102 = r100.get("comment_impres_show_style");
        if (r102 == null) goto L15;
        String r103 = r102.toString();
        if (r103 == null) goto L15;
    L17:
        if (Intrinsics.areEqual(r103, "3") == false) goto L19;
        return true;
    L19:
        if (Intrinsics.areEqual(r103, "4") == true) goto L24;
        return false;
    L24:
        return true;
    L15:
        r103 = "";
        goto L17
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final Map<String, Object> getBaseLogParams() {
        return this.baseLogParams;
    }

    public final BottomProductCardInfo getBottomProductCardInfo() {
        return this.bottomProductCardInfo;
    }

    public final String getBtmId() {
        return this.btmId;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final CommentExtras getCommentExtras() {
        return this.commentExtras;
    }

    public final String getCommentPreloadDataJson() {
        return this.commentPreloadDataJson;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final StatTagItem getEnterClickTagItem() {
        return this.enterClickTagItem;
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final List<String> getHighlightReplyCid() {
        return this.highlightReplyCid;
    }

    public final CommentLogParams getLogParams() {
        return this.logParams;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final String getPdpSessionId() {
        return this.pdpSessionId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Long getProductMinPrice() {
        return this.productMinPrice;
    }

    public final String getReferKolId() {
        return this.referKolId;
    }

    public final Long getReplyCid() {
        return this.replyCid;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final int getShowOrderStat() {
        return this.showOrderStat;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final List<String> getTopCommentIds() {
        return this.topCommentIds;
    }

    public final String getTopCommentTypes() {
        return this.topCommentTypes;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isStoreComment() {
        return this.isStoreComment;
    }

    public final String getExtraStr(Map<String, ? extends Object> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("data_type", Integer.valueOf(this.dataType));
        Map<?, ?> r102 = getPassedAbParams();
        if (r102 == null) goto L6;
        String r103 = k.d(r102);
        if (r103 == null) goto L6;
    L7:
        r101.put(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS, r103);
        String r104 = getPassedTitleGuideContent();
        if (r104 == null) goto L10;
        r101.put("title_guide_content", r104);
    L10:
        String r105 = getPassedTitleGuideContentType();
        if (r105 == null) goto L13;
        r101.put("title_guide_content_type", r105);
    L13:
        if (r100 == null) goto L16;
        r101.putAll(r100);
    L16:
        return k.d(r101);
    L6:
        r103 = "";
        goto L7
    }

    public final void setBottomProductCardInfo(BottomProductCardInfo r100) {
        this.bottomProductCardInfo = r100;
    }

    public final void setBtmId(String r100) {
        this.btmId = r100;
    }

    public final void setCommentExtras(CommentExtras r100) {
        this.commentExtras = r100;
    }

    public final void setDataType(int r100) {
        this.dataType = r100;
    }

    public final void setEnterClickTagItem(StatTagItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterClickTagItem = r100;
    }

    public final void setExtraParams(Map<String, ? extends Object> r100) {
        this.extraParams = r100;
    }

    public final void setHighlightReplyCid(List<String> r100) {
        this.highlightReplyCid = r100;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setPageName(String r100) {
        this.pageName = r100;
    }

    public final void setPageTitle(String r100) {
        this.pageTitle = r100;
    }

    public final void setPdpSessionId(String r100) {
        this.pdpSessionId = r100;
    }

    public final void setReplyCid(Long r100) {
        this.replyCid = r100;
    }

    public final void setShowOrderStat(int r100) {
        this.showOrderStat = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public final void setStoreComment(boolean r100) {
        this.isStoreComment = r100;
    }

    public final void setTopCommentIds(List<String> r100) {
        this.topCommentIds = r100;
    }

    public final void setTopCommentTypes(String r100) {
        this.topCommentTypes = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String getExtraStr$default(CommentParams r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.getExtraStr(r101);
    }

    public CommentParams(boolean r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, CommentLogParams r215, CommentExtras r216, Map<String, ? extends Object> r217, List<String> r218, String r219, String r310, boolean r311, int r312, int r313, String r314, Map<String, ? extends Object> r315, String r316, Long r317, BottomProductCardInfo r318, Long r319, List<String> r410, String r411) {
        this.isLuban = r110;
        this.productId = r111;
        this.referKolId = r112;
        this.userId = r210;
        this.authorId = r211;
        this.shopId = r212;
        this.searchId = r213;
        this.businessType = r214;
        this.logParams = r215;
        this.commentExtras = r216;
        this.baseLogParams = r217;
        this.topCommentIds = r218;
        this.topCommentTypes = r219;
        this.pageTitle = r310;
        this.isStoreComment = r311;
        this.showOrderStat = r312;
        this.dataType = r313;
        this.pageName = r314;
        this.extraParams = r315;
        this.commentPreloadDataJson = r316;
        this.productMinPrice = r317;
        this.bottomProductCardInfo = r318;
        this.replyCid = r319;
        this.highlightReplyCid = r410;
        this.pdpSessionId = r411;
        this.enterClickTagItem = new StatTagItem(0, 0, null, null, 0, false, null, 0, 255, null);
        this.btmId = "";
    }

    public /* synthetic */ CommentParams(boolean r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, CommentLogParams r315, CommentExtras r316, Map r317, List r318, String r319, String r410, boolean r411, int r412, int r413, String r414, Map r415, String r416, Long r417, BottomProductCardInfo r418, Long r419, List r510, String r511, int r512, DefaultConstructorMarker r513) {
        if ((r512 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r512 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r512 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r512 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r512 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r512 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r512 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r512 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r512 & 256) == 0) goto L37;
        CommentLogParams r111 = null;
    L39:
        if ((r512 & 512) == 0) goto L41;
        CommentExtras r112 = null;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        Map r113 = null;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        List r114 = null;
    L51:
        if ((r512 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r512 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r512 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r512 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r512 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r512 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r512 & 262144) == 0) goto L77;
        Map r119 = null;
    L79:
        if ((r512 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r512 & 1048576) == 0) goto L85;
        Long r214 = null;
    L87:
        if ((r512 & 2097152) == 0) goto L89;
        BottomProductCardInfo r215 = null;
    L91:
        if ((r512 & 4194304) == 0) goto L93;
        Long r216 = null;
    L95:
        if ((r512 & 8388608) == 0) goto L97;
        List r217 = null;
    L99:
        if ((r512 & 16777216) == 0) goto L101;
        String r109 = null;
    L102:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r213, r214, r215, r216, r217, r109);
        return;
    L101:
        r109 = r511;
        goto L102
    L97:
        r217 = r510;
        goto L99
    L93:
        r216 = r419;
        goto L95
    L89:
        r215 = r418;
        goto L91
    L85:
        r214 = r417;
        goto L87
    L81:
        r213 = r416;
        goto L83
    L77:
        r119 = r415;
        goto L79
    L73:
        r118 = r414;
        goto L75
    L69:
        r117 = r413;
        goto L71
    L65:
        r116 = r412;
        goto L67
    L61:
        r108 = r411;
        goto L63
    L57:
        r107 = r410;
        goto L59
    L53:
        r115 = r319;
        goto L55
    L49:
        r114 = r318;
        goto L51
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}

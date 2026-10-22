package com.bytedance.android.shopping.anchorv3.activities.vo;

import androidx.compose.ui.spatial.RectListKt;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStruct;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.ec.model.response.anchorv3.MFPromotionEvent;
import com.bytedance.android.ec.model.response.anchorv3.PromotionIPActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w63.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\b\u0086\b\u0018\u0000 ¥\u00012\u00020\u0001:\u0002¦\u0001B\u00ad\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\b\u0012\b\b\u0002\u0010/\u001a\u00020\b\u0012\b\b\u0002\u00100\u001a\u00020\b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u00103\u001a\u00020\u000f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00105\u001a\u00020\u0012\u0012\b\b\u0002\u00106\u001a\u00020\u0014\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00108\u001a\u00020\u0014\u0012\b\b\u0002\u00109\u001a\u00020\u0012\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010>\u001a\u00020\u000f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010A\u001a\u00020\u0014\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010+¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\bHÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0014HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0012HÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\rJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b!\u0010\rJ\t\u0010\"\u001a\u00020\u0014HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J´\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010.\u001a\u00020\b2\b\b\u0002\u0010/\u001a\u00020\b2\b\b\u0002\u00100\u001a\u00020\b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00103\u001a\u00020\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00142\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00108\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u00122\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010>\u001a\u00020\u000f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010A\u001a\u00020\u00142\n\b\u0002\u0010B\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010+HÆ\u0001¢\u0006\u0004\bG\u0010HJ\t\u0010I\u001a\u00020\u0006HÖ\u0001J\t\u0010J\u001a\u00020\u0014HÖ\u0001J\u0013\u0010L\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010M\u001a\u00020\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020\u00128F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\"\u0010\\\u001a\u00020\b8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0019\u0010-\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b-\u0010N\u001a\u0004\bb\u0010PR\u0017\u0010.\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b.\u0010]\u001a\u0004\bc\u0010_R\u0017\u0010/\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b/\u0010]\u001a\u0004\bd\u0010_R\u0017\u00100\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\be\u0010_R$\u00101\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010f\u001a\u0004\bg\u0010\r\"\u0004\bh\u0010iR$\u00102\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010f\u001a\u0004\bj\u0010\r\"\u0004\bk\u0010iR\"\u00103\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0019\u00104\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b4\u0010N\u001a\u0004\bq\u0010PR\"\u00105\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010T\u001a\u0004\b5\u0010V\"\u0004\br\u0010XR\"\u00106\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0019\u00107\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b7\u0010N\u001a\u0004\bx\u0010PR\"\u00108\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010s\u001a\u0004\by\u0010u\"\u0004\bz\u0010wR\"\u00109\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010T\u001a\u0004\b9\u0010V\"\u0004\b{\u0010XR$\u0010:\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010f\u001a\u0004\b|\u0010\r\"\u0004\b}\u0010iR$\u0010;\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010f\u001a\u0004\b~\u0010\r\"\u0004\b\u007f\u0010iR&\u0010<\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b<\u0010f\u001a\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010iR)\u0010=\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b=\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010>\u001a\u00020\u000f8\u0006¢\u0006\r\n\u0004\b>\u0010l\u001a\u0005\b\u0087\u0001\u0010nR\u001c\u0010?\u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\u000f\n\u0005\b?\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010@\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\r\n\u0004\b@\u0010f\u001a\u0005\b\u008b\u0001\u0010\rR\u0018\u0010A\u001a\u00020\u00148\u0006¢\u0006\r\n\u0004\bA\u0010s\u001a\u0005\b\u008c\u0001\u0010uR)\u0010B\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bB\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R)\u0010C\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bC\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010D\u001a\u0004\u0018\u00010'8\u0006¢\u0006\u000f\n\u0005\bD\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010E\u001a\u0004\u0018\u00010)8\u0006¢\u0006\u000f\n\u0005\bE\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010F\u001a\u0004\u0018\u00010+8\u0006¢\u0006\u000f\n\u0005\bF\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0013\u0010 \u0001\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b \u0001\u0010VR\u0013\u0010¡\u0001\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010VR\u0013\u0010¢\u0001\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010V¨\u0006§\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "", "", "checkOnActivity$ec_core_saasRelease", "()V", "checkOnActivity", "", "component1", "", "component2", "component3", "component4", "component5", "()Ljava/lang/Long;", "component6", "Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "component7", "component8", "", "component9", "", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "component17", "component18", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "component19", "component20", "component21", "Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "component22", "Lw63/b;", "component23", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "component24", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "component25", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "component26", "title", DyPayConstant.KEY_START_TIME, "endTime", "serverTime", "minPrice", "maxPrice", "discountPrice", "activityText", "isAppoint", SalesInfoStruct.SALES, "buttonPrefix", "activityType", "isOnActivity", "marketPrice", "originMaxPrice", "originMinPrice", "groupInfo", "groupDiscountPrice", "ipActivityInfo", "depositPrice", "stickSales", "mfPromotionEvent", "auctionState", "subsidizedActivity", "commonGirdleStruct", "depositPresaleActivity", "copy", "(Ljava/lang/String;JJJLjava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Ljava/lang/String;ZILjava/lang/String;IZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;Ljava/lang/Long;ILcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;Lw63/b;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "toString", "hashCode", "other", "equals", "activityName", "Ljava/lang/String;", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "needShowActivityBarStyle", "Z", "getNeedShowActivityBarStyle", "()Z", "setNeedShowActivityBarStyle", "(Z)V", "canShowActivityBarStyle", "getCanShowActivityBarStyle", "setCanShowActivityBarStyle", "curTime", "J", "getCurTime", "()J", "setCurTime", "(J)V", "getTitle", "getStartTime", "getEndTime", "getServerTime", "Ljava/lang/Long;", "getMinPrice", "setMinPrice", "(Ljava/lang/Long;)V", "getMaxPrice", "setMaxPrice", "Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "getDiscountPrice", "()Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "setDiscountPrice", "(Lcom/bytedance/android/ec/model/PromotionDiscountPrice;)V", "getActivityText", "setAppoint", "I", "getSales", "()I", "setSales", "(I)V", "getButtonPrefix", "getActivityType", "setActivityType", "setOnActivity", "getMarketPrice", "setMarketPrice", "getOriginMaxPrice", "setOriginMaxPrice", "getOriginMinPrice", "setOriginMinPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "getGroupInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "setGroupInfo", "(Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;)V", "getGroupDiscountPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "getIpActivityInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "getDepositPrice", "getStickSales", "Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "getMfPromotionEvent", "()Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;", "setMfPromotionEvent", "(Lcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;)V", "Lw63/b;", "getAuctionState", "()Lw63/b;", "setAuctionState", "(Lw63/b;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "getSubsidizedActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "getCommonGirdleStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "getDepositPresaleActivity", "()Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "isDepositActivity", "isSubsidizedActivity", "isPreSeckillActivity", "<init>", "(Ljava/lang/String;JJJLjava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Ljava/lang/String;ZILjava/lang/String;IZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;Lcom/bytedance/android/ec/model/PromotionDiscountPrice;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;Ljava/lang/Long;ILcom/bytedance/android/ec/model/response/anchorv3/MFPromotionEvent;Lw63/b;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStruct;Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityVO {
    public static final String APPOINTMENT = "appointment";
    public static final a Companion = null;
    public static final String DEPOSIT_PRESALE = "deposit_presale";
    public static final String GROUP = "group";
    public static final String PRESALE = "preseale";
    public static final String REDUCE = "reduce";
    public static final String SECKILL = "seckill";
    public static final String SECKILL_APPOINTMENT = "seckill_appointment";
    private String activityName;
    private final String activityText;
    private int activityType;
    private b auctionState;
    private final String buttonPrefix;
    private boolean canShowActivityBarStyle;
    private final CommonGirdleStruct commonGirdleStruct;
    private long curTime;
    private final PromotionDepositPresaleActivity depositPresaleActivity;
    private final Long depositPrice;
    private PromotionDiscountPrice discountPrice;
    private final long endTime;
    private final PromotionDiscountPrice groupDiscountPrice;
    private GroupInfo groupInfo;
    private final PromotionIPActivity ipActivityInfo;
    private boolean isAppoint;
    private boolean isOnActivity;
    private Long marketPrice;
    private Long maxPrice;
    private MFPromotionEvent mfPromotionEvent;
    private Long minPrice;
    private boolean needShowActivityBarStyle;
    private Long originMaxPrice;
    private Long originMinPrice;
    private int sales;
    private final long serverTime;
    private final long startTime;
    private final int stickSales;
    private final PromotionSubsidizedActivity subsidizedActivity;
    private final String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ActivityVO() {
        this(null, 0, 0, 0, null, null, null, null, false, 0, null, 0, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, RectListKt.Lower26Bits, null);
    }

    public static /* synthetic */ ActivityVO copy$default(ActivityVO r110, String r111, long r112, long r210, long r211, Long r212, Long r213, PromotionDiscountPrice r214, String r215, boolean r216, int r310, String r311, int r312, boolean r313, Long r314, Long r315, Long r316, GroupInfo r317, PromotionDiscountPrice r318, PromotionIPActivity r319, Long r410, int r411, MFPromotionEvent r412, b r413, PromotionSubsidizedActivity r414, CommonGirdleStruct r415, PromotionDepositPresaleActivity r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r417 & 2) == 0) goto L9;
        long r101 = r110.startTime;
    L11:
        if ((r417 & 4) == 0) goto L13;
        long r102 = r110.endTime;
    L15:
        if ((r417 & 8) == 0) goto L17;
        long r103 = r110.serverTime;
    L19:
        if ((r417 & 16) == 0) goto L21;
        Long r104 = r110.minPrice;
    L23:
        if ((r417 & 32) == 0) goto L25;
        Long r113 = r110.maxPrice;
    L27:
        if ((r417 & 64) == 0) goto L29;
        PromotionDiscountPrice r114 = r110.discountPrice;
    L31:
        if ((r417 & 128) == 0) goto L33;
        String r115 = r110.activityText;
    L35:
        if ((r417 & 256) == 0) goto L37;
        boolean r116 = r110.isAppoint;
    L39:
        if ((r417 & 512) == 0) goto L41;
        int r117 = r110.sales;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        String r118 = r110.buttonPrefix;
    L46:
        String r320 = r118;
        if ((r417 & 2048) == 0) goto L49;
        int r119 = r110.activityType;
    L50:
        int r321 = r119;
        if ((r417 & 4096) == 0) goto L53;
        boolean r120 = r110.isOnActivity;
    L54:
        boolean r322 = r120;
        if ((r417 & 8192) == 0) goto L57;
        Long r121 = r110.marketPrice;
    L58:
        Long r323 = r121;
        if ((r417 & 16384) == 0) goto L61;
        Long r122 = r110.originMaxPrice;
    L62:
        Long r324 = r122;
        if ((r417 & 32768) == 0) goto L65;
        Long r123 = r110.originMinPrice;
    L66:
        Long r325 = r123;
        if ((r417 & 65536) == 0) goto L69;
        GroupInfo r124 = r110.groupInfo;
    L70:
        GroupInfo r326 = r124;
        if ((r417 & 131072) == 0) goto L73;
        PromotionDiscountPrice r125 = r110.groupDiscountPrice;
    L74:
        PromotionDiscountPrice r327 = r125;
        if ((r417 & 262144) == 0) goto L77;
        PromotionIPActivity r126 = r110.ipActivityInfo;
    L78:
        PromotionIPActivity r328 = r126;
        if ((r417 & 524288) == 0) goto L81;
        Long r127 = r110.depositPrice;
    L82:
        Long r419 = r127;
        if ((r417 & 1048576) == 0) goto L85;
        int r128 = r110.stickSales;
    L86:
        int r420 = r128;
        if ((r417 & 2097152) == 0) goto L89;
        MFPromotionEvent r129 = r110.mfPromotionEvent;
    L90:
        MFPromotionEvent r421 = r129;
        if ((r417 & 4194304) == 0) goto L93;
        b r130 = r110.auctionState;
    L94:
        b r422 = r130;
        if ((r417 & 8388608) == 0) goto L97;
        PromotionSubsidizedActivity r131 = r110.subsidizedActivity;
    L98:
        PromotionSubsidizedActivity r423 = r131;
        if ((r417 & 16777216) == 0) goto L101;
        CommonGirdleStruct r132 = r110.commonGirdleStruct;
    L103:
        if ((r417 & 33554432) == 0) goto L105;
        PromotionDepositPresaleActivity r105 = r110.depositPresaleActivity;
    L107:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r419, r420, r421, r422, r423, r132, r105);
    L105:
        r105 = r416;
        goto L107
    L101:
        r132 = r415;
        goto L103
    L97:
        r131 = r414;
        goto L98
    L93:
        r130 = r413;
        goto L94
    L89:
        r129 = r412;
        goto L90
    L85:
        r128 = r411;
        goto L86
    L81:
        r127 = r410;
        goto L82
    L77:
        r126 = r319;
        goto L78
    L73:
        r125 = r318;
        goto L74
    L69:
        r124 = r317;
        goto L70
    L65:
        r123 = r316;
        goto L66
    L61:
        r122 = r315;
        goto L62
    L57:
        r121 = r314;
        goto L58
    L53:
        r120 = r313;
        goto L54
    L49:
        r119 = r312;
        goto L50
    L45:
        r118 = r311;
        goto L46
    L41:
        r117 = r310;
        goto L43
    L37:
        r116 = r216;
        goto L39
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final int component10() {
        return this.sales;
    }

    public final String component11() {
        return this.buttonPrefix;
    }

    public final int component12() {
        return this.activityType;
    }

    public final boolean component13() {
        return this.isOnActivity;
    }

    public final Long component14() {
        return this.marketPrice;
    }

    public final Long component15() {
        return this.originMaxPrice;
    }

    public final Long component16() {
        return this.originMinPrice;
    }

    public final GroupInfo component17() {
        return this.groupInfo;
    }

    public final PromotionDiscountPrice component18() {
        return this.groupDiscountPrice;
    }

    public final PromotionIPActivity component19() {
        return this.ipActivityInfo;
    }

    public final long component2() {
        return this.startTime;
    }

    public final Long component20() {
        return this.depositPrice;
    }

    public final int component21() {
        return this.stickSales;
    }

    public final MFPromotionEvent component22() {
        return this.mfPromotionEvent;
    }

    public final b component23() {
        return this.auctionState;
    }

    public final PromotionSubsidizedActivity component24() {
        return this.subsidizedActivity;
    }

    public final CommonGirdleStruct component25() {
        return this.commonGirdleStruct;
    }

    public final PromotionDepositPresaleActivity component26() {
        return this.depositPresaleActivity;
    }

    public final long component3() {
        return this.endTime;
    }

    public final long component4() {
        return this.serverTime;
    }

    public final Long component5() {
        return this.minPrice;
    }

    public final Long component6() {
        return this.maxPrice;
    }

    public final PromotionDiscountPrice component7() {
        return this.discountPrice;
    }

    public final String component8() {
        return this.activityText;
    }

    public final boolean component9() {
        return this.isAppoint;
    }

    public final ActivityVO copy(String r310, long r311, long r312, long r313, Long r314, Long r410, PromotionDiscountPrice r411, String r412, boolean r413, int r414, String r415, int r416, boolean r417, Long r418, Long r419, Long r510, GroupInfo r511, PromotionDiscountPrice r512, PromotionIPActivity r513, Long r514, int r515, MFPromotionEvent r516, b r517, PromotionSubsidizedActivity r518, CommonGirdleStruct r519, PromotionDepositPresaleActivity r610) {
        Intrinsics.checkNotNullParameter(r411, "discountPrice");
        Intrinsics.checkNotNullParameter(r512, "groupDiscountPrice");
        return new ActivityVO(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActivityVO) == false) goto L58;
        ActivityVO r101 = (ActivityVO) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (this.startTime == r101.startTime) goto L10;
        return false;
    L10:
        if (this.endTime == r101.endTime) goto L12;
        return false;
    L12:
        if (this.serverTime == r101.serverTime) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.minPrice, r101.minPrice) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.activityText, r101.activityText) == true) goto L22;
        return false;
    L22:
        if (this.isAppoint == r101.isAppoint) goto L24;
        return false;
    L24:
        if (this.sales == r101.sales) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.buttonPrefix, r101.buttonPrefix) == true) goto L28;
        return false;
    L28:
        if (this.activityType == r101.activityType) goto L30;
        return false;
    L30:
        if (this.isOnActivity == r101.isOnActivity) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.originMaxPrice, r101.originMaxPrice) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.originMinPrice, r101.originMinPrice) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.groupInfo, r101.groupInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.groupDiscountPrice, r101.groupDiscountPrice) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ipActivityInfo, r101.ipActivityInfo) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.depositPrice, r101.depositPrice) == true) goto L46;
        return false;
    L46:
        if (this.stickSales == r101.stickSales) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.mfPromotionEvent, r101.mfPromotionEvent) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.auctionState, r101.auctionState) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.subsidizedActivity, r101.subsidizedActivity) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.commonGirdleStruct, r101.commonGirdleStruct) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.depositPresaleActivity, r101.depositPresaleActivity) == true) goto L88;
        return false;
    L88:
        return true;
    L58:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.startTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.endTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.serverTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Long r109 = this.minPrice;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.maxPrice;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        PromotionDiscountPrice r115 = this.discountPrice;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        String r118 = this.activityText;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (r117 + r119) * 31;
        boolean r121 = this.isAppoint;
        ?? r122 = 1;
        ?? r123 = r121;
        if (r121 == false) goto L25;
        r123 = 1;
    L25:
        int r124 = (((r120 + r123) * 31) + this.sales) * 31;
        String r125 = this.buttonPrefix;
        if (r125 == null) goto L28;
        int r126 = r125.hashCode();
    L29:
        int r127 = (((r124 + r126) * 31) + this.activityType) * 31;
        boolean r128 = this.isOnActivity;
        if (r128 == true) goto L33;
        r122 = r128;
    L33:
        int r129 = (r127 + r122) * 31;
        Long r130 = this.marketPrice;
        if (r130 == null) goto L36;
        int r131 = r130.hashCode();
    L37:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.originMaxPrice;
        if (r133 == null) goto L40;
        int r134 = r133.hashCode();
    L41:
        int r135 = (r132 + r134) * 31;
        Long r136 = this.originMinPrice;
        if (r136 == null) goto L44;
        int r137 = r136.hashCode();
    L45:
        int r138 = (r135 + r137) * 31;
        GroupInfo r139 = this.groupInfo;
        if (r139 == null) goto L48;
        int r140 = r139.hashCode();
    L49:
        int r141 = (r138 + r140) * 31;
        PromotionDiscountPrice r142 = this.groupDiscountPrice;
        if (r142 == null) goto L52;
        int r143 = r142.hashCode();
    L53:
        int r144 = (r141 + r143) * 31;
        PromotionIPActivity r145 = this.ipActivityInfo;
        if (r145 == null) goto L56;
        int r146 = r145.hashCode();
    L57:
        int r147 = (r144 + r146) * 31;
        Long r148 = this.depositPrice;
        if (r148 == null) goto L60;
        int r149 = r148.hashCode();
    L61:
        int r150 = (((r147 + r149) * 31) + this.stickSales) * 31;
        MFPromotionEvent r151 = this.mfPromotionEvent;
        if (r151 == null) goto L64;
        int r152 = r151.hashCode();
    L65:
        int r153 = (r150 + r152) * 31;
        b r154 = this.auctionState;
        if (r154 == null) goto L68;
        int r155 = r154.hashCode();
    L69:
        int r156 = (r153 + r155) * 31;
        PromotionSubsidizedActivity r157 = this.subsidizedActivity;
        if (r157 == null) goto L72;
        int r158 = r157.hashCode();
    L73:
        int r159 = (r156 + r158) * 31;
        CommonGirdleStruct r160 = this.commonGirdleStruct;
        if (r160 == null) goto L76;
        int r161 = r160.hashCode();
    L77:
        int r162 = (r159 + r161) * 31;
        PromotionDepositPresaleActivity r163 = this.depositPresaleActivity;
        if (r163 == null) goto L81;
        r101 = r163.hashCode();
    L81:
        return r162 + r101;
    L76:
        r161 = 0;
        goto L77
    L72:
        r158 = 0;
        goto L73
    L68:
        r155 = 0;
        goto L69
    L64:
        r152 = 0;
        goto L65
    L60:
        r149 = 0;
        goto L61
    L56:
        r146 = 0;
        goto L57
    L52:
        r143 = 0;
        goto L53
    L48:
        r140 = 0;
        goto L49
    L44:
        r137 = 0;
        goto L45
    L40:
        r134 = 0;
        goto L41
    L36:
        r131 = 0;
        goto L37
    L28:
        r126 = 0;
        goto L29
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ActivityVO(title=" + this.title + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", discountPrice=" + this.discountPrice + ", activityText=" + this.activityText + ", isAppoint=" + this.isAppoint + ", sales=" + this.sales + ", buttonPrefix=" + this.buttonPrefix + ", activityType=" + this.activityType + ", isOnActivity=" + this.isOnActivity + ", marketPrice=" + this.marketPrice + ", originMaxPrice=" + this.originMaxPrice + ", originMinPrice=" + this.originMinPrice + ", groupInfo=" + this.groupInfo + ", groupDiscountPrice=" + this.groupDiscountPrice + ", ipActivityInfo=" + this.ipActivityInfo + ", depositPrice=" + this.depositPrice + ", stickSales=" + this.stickSales + ", mfPromotionEvent=" + this.mfPromotionEvent + ", auctionState=" + this.auctionState + ", subsidizedActivity=" + this.subsidizedActivity + ", commonGirdleStruct=" + this.commonGirdleStruct + ", depositPresaleActivity=" + this.depositPresaleActivity + ")";
    }

    public final void checkOnActivity$ec_core_saasRelease() {
        boolean r100 = true;
        switch(this.activityType) {
            case 1: goto L53;
            case 2: goto L50;
            case 3: goto L5;
            case 4: goto L45;
            case 5: goto L45;
            case 6: goto L34;
            case 7: goto L31;
            case 8: goto L9;
            case 9: goto L5;
            case 10: goto L65;
            case 11: goto L7;
            case 12: goto L65;
            case 13: goto L5;
            case 14: goto L65;
            default: goto L5;
        };
    L7:
        this.isOnActivity = false;
        return;
    L34:
        long r101 = getCurTime();
        long r102 = this.endTime;
        if (r101 < r102) goto L37;
        this.activityType = 0;
        this.isOnActivity = false;
        return;
    L37:
        long r103 = this.startTime;
        long r104 = getCurTime();
        if (r103 <= r104) goto L41;
    L43:
        this.isOnActivity = false;
        return;
    L41:
        if (r102 < r104) goto L43;
        this.isOnActivity = true;
        return;
    L53:
        long r105 = getCurTime();
        long r106 = this.endTime;
        if (r105 < r106) goto L56;
        this.activityType = 0;
        this.isOnActivity = false;
        return;
    L56:
        long r107 = this.startTime;
        long r108 = getCurTime();
        if (r107 <= r108) goto L60;
    L62:
        this.isOnActivity = false;
        return;
    L60:
        if (r106 < r108) goto L62;
        this.isOnActivity = true;
        return;
    L65:
        return;
    L5:
        if (getCurTime() < this.endTime) goto L63;
        this.activityType = 0;
        this.isOnActivity = false;
        return;
    L63:
        this.isOnActivity = true;
        return;
    L9:
        if (a53.a.a() != 1) goto L20;
        long r109 = this.serverTime;
        long r110 = this.endTime;
        if (r109 < r110) goto L14;
        this.activityType = 9;
        this.isOnActivity = false;
        return;
    L14:
        if (this.startTime <= r109) goto L17;
    L19:
        this.activityType = 13;
        this.isOnActivity = false;
        return;
    L17:
        if (r110 < r109) goto L19;
        this.isOnActivity = true;
        return;
    L20:
        long r111 = getCurTime();
        long r112 = this.endTime;
        if (r111 < r112) goto L23;
        this.activityType = 9;
        this.isOnActivity = false;
        return;
    L23:
        long r113 = this.startTime;
        long r114 = getCurTime();
        if (r113 <= r114) goto L27;
    L29:
        this.activityType = 13;
        this.isOnActivity = false;
        return;
    L27:
        if (r112 < r114) goto L29;
        this.isOnActivity = true;
        return;
    L31:
        if (getCurTime() < this.endTime) goto L33;
        this.activityType = 4;
        this.isOnActivity = false;
        return;
    L33:
        this.isOnActivity = true;
        return;
    L45:
        if (getCurTime() < this.endTime) goto L48;
        r100 = false;
    L48:
        this.isOnActivity = r100;
        return;
    L50:
        if (getCurTime() < this.endTime) goto L52;
        this.activityType = 4;
        this.isOnActivity = false;
        return;
    L52:
        this.isOnActivity = true;
    }

    public final String getActivityName() {
        int r100 = this.activityType;
        if (r100 == 1) goto L35;
        if (r100 != 2) goto L7;
        return PRESALE;
    L7:
        if (r100 != 3) goto L9;
        return APPOINTMENT;
    L9:
        if (r100 != 6) goto L11;
        return "group";
    L11:
        if (r100 != 8) goto L13;
        return "deposit_presale";
    L13:
        if (r100 == 14) goto L15;
        return "";
    L15:
        CommonGirdleStruct r101 = this.commonGirdleStruct;
        if (r101 == null) goto L18;
        Long r102 = Long.valueOf(r101.getType());
    L19:
        if (r102 != null) goto L22;
    L24:
        if (r102 != null) goto L27;
    L29:
        return "common_girdle";
    L27:
        if (r102.longValue() != 160) goto L29;
        return "reduce";
    L22:
        if (r102.longValue() != 150) goto L24;
        return "new_gift";
    L18:
        r102 = null;
        goto L19
    L35:
        if (this.isOnActivity == false) goto L37;
        return "seckill";
    L37:
        return SECKILL_APPOINTMENT;
    }

    public final boolean getCanShowActivityBarStyle() {
        int r100 = this.activityType;
        if (r100 != 1) goto L9;
        if (this.isOnActivity == false) goto L7;
        return true;
    L7:
        if (this.ipActivityInfo == null) goto L9;
        return true;
    L9:
        if (r100 != 2) goto L11;
        return true;
    L11:
        if (r100 != 3) goto L13;
        return true;
    L13:
        if (r100 != 6) goto L17;
        if (this.isOnActivity == false) goto L17;
        return true;
    L17:
        if (r100 != 7) goto L21;
        if (this.isOnActivity == false) goto L21;
        return true;
    L21:
        if (r100 != 12) goto L23;
        return true;
    L23:
        if (r100 == 14) goto L34;
        return false;
    L34:
        return true;
    }

    public final boolean isDepositActivity() {
        int r100 = this.activityType;
        if (r100 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 13) goto L8;
        return false;
    }

    public final boolean isPreSeckillActivity() {
        if (this.activityType == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.isOnActivity == true) goto L9;
        if (this.ipActivityInfo != null) goto L9;
        return true;
    }

    public final boolean isSubsidizedActivity() {
        if (this.activityType != 12) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getCurTime() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    public final String getActivityText() {
        return this.activityText;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final b getAuctionState() {
        return this.auctionState;
    }

    public final String getButtonPrefix() {
        return this.buttonPrefix;
    }

    public final CommonGirdleStruct getCommonGirdleStruct() {
        return this.commonGirdleStruct;
    }

    public final PromotionDepositPresaleActivity getDepositPresaleActivity() {
        return this.depositPresaleActivity;
    }

    public final Long getDepositPrice() {
        return this.depositPrice;
    }

    public final PromotionDiscountPrice getDiscountPrice() {
        return this.discountPrice;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final PromotionDiscountPrice getGroupDiscountPrice() {
        return this.groupDiscountPrice;
    }

    public final GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public final PromotionIPActivity getIpActivityInfo() {
        return this.ipActivityInfo;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final MFPromotionEvent getMfPromotionEvent() {
        return this.mfPromotionEvent;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final boolean getNeedShowActivityBarStyle() {
        return this.needShowActivityBarStyle;
    }

    public final Long getOriginMaxPrice() {
        return this.originMaxPrice;
    }

    public final Long getOriginMinPrice() {
        return this.originMinPrice;
    }

    public final int getSales() {
        return this.sales;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getStickSales() {
        return this.stickSales;
    }

    public final PromotionSubsidizedActivity getSubsidizedActivity() {
        return this.subsidizedActivity;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isAppoint() {
        return this.isAppoint;
    }

    public final boolean isOnActivity() {
        return this.isOnActivity;
    }

    public final void setActivityName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.activityName = r100;
    }

    public final void setActivityType(int r100) {
        this.activityType = r100;
    }

    public final void setAppoint(boolean r100) {
        this.isAppoint = r100;
    }

    public final void setAuctionState(b r100) {
        this.auctionState = r100;
    }

    public final void setCanShowActivityBarStyle(boolean r100) {
        this.canShowActivityBarStyle = r100;
    }

    public final void setCurTime(long r100) {
        this.curTime = r100;
    }

    public final void setDiscountPrice(PromotionDiscountPrice r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.discountPrice = r100;
    }

    public final void setGroupInfo(GroupInfo r100) {
        this.groupInfo = r100;
    }

    public final void setMarketPrice(Long r100) {
        this.marketPrice = r100;
    }

    public final void setMaxPrice(Long r100) {
        this.maxPrice = r100;
    }

    public final void setMfPromotionEvent(MFPromotionEvent r100) {
        this.mfPromotionEvent = r100;
    }

    public final void setMinPrice(Long r100) {
        this.minPrice = r100;
    }

    public final void setNeedShowActivityBarStyle(boolean r100) {
        this.needShowActivityBarStyle = r100;
    }

    public final void setOnActivity(boolean r100) {
        this.isOnActivity = r100;
    }

    public final void setOriginMaxPrice(Long r100) {
        this.originMaxPrice = r100;
    }

    public final void setOriginMinPrice(Long r100) {
        this.originMinPrice = r100;
    }

    public final void setSales(int r100) {
        this.sales = r100;
    }

    public ActivityVO(String r100, long r101, long r102, long r110, Long r111, Long r112, PromotionDiscountPrice r113, String r114, boolean r115, int r116, String r117, int r210, boolean r211, Long r212, Long r213, Long r214, GroupInfo r215, PromotionDiscountPrice r216, PromotionIPActivity r217, Long r218, int r219, MFPromotionEvent r310, b r311, PromotionSubsidizedActivity r312, CommonGirdleStruct r313, PromotionDepositPresaleActivity r314) {
        Intrinsics.checkNotNullParameter(r113, "discountPrice");
        Intrinsics.checkNotNullParameter(r216, "groupDiscountPrice");
        this.title = r100;
        this.startTime = r101;
        this.endTime = r102;
        this.serverTime = r110;
        this.minPrice = r111;
        this.maxPrice = r112;
        this.discountPrice = r113;
        this.activityText = r114;
        this.isAppoint = r115;
        this.sales = r116;
        this.buttonPrefix = r117;
        this.activityType = r210;
        this.isOnActivity = r211;
        this.marketPrice = r212;
        this.originMaxPrice = r213;
        this.originMinPrice = r214;
        this.groupInfo = r215;
        this.groupDiscountPrice = r216;
        this.ipActivityInfo = r217;
        this.depositPrice = r218;
        this.stickSales = r219;
        this.mfPromotionEvent = r310;
        this.auctionState = r311;
        this.subsidizedActivity = r312;
        this.commonGirdleStruct = r313;
        this.depositPresaleActivity = r314;
        this.activityName = "";
        this.needShowActivityBarStyle = true;
    }

    public /* synthetic */ ActivityVO(String r310, long r311, long r312, long r313, Long r314, Long r315, PromotionDiscountPrice r316, String r410, boolean r411, int r412, String r413, int r414, boolean r415, Long r416, Long r417, Long r418, GroupInfo r419, PromotionDiscountPrice r510, PromotionIPActivity r511, Long r512, int r513, MFPromotionEvent r514, b r515, PromotionSubsidizedActivity r516, CommonGirdleStruct r517, PromotionDepositPresaleActivity r518, int r519, DefaultConstructorMarker r610) {
        if ((r519 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        long r101 = 0;
        if ((r519 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r519 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r519 & 8) != 0) goto L19;
        r101 = r313;
    L19:
        if ((r519 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r519 & 32) == 0) goto L25;
        Long r110 = null;
    L27:
        if ((r519 & 64) == 0) goto L29;
        PromotionDiscountPrice r111 = new PromotionDiscountPrice(null, null, null, null, 15, null);
    L31:
        if ((r519 & 128) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r519 & 256) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r519 & 512) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r519 & 1024) == 0) goto L45;
        String r105 = null;
    L47:
        if ((r519 & 2048) == 0) goto L49;
        int r115 = 0;
    L50:
        int r611 = r115;
        if ((r519 & 4096) == 0) goto L53;
        boolean r116 = false;
    L54:
        boolean r117 = r116;
        if ((r519 & 8192) == 0) goto L57;
        Long r118 = null;
    L58:
        Long r119 = r118;
        if ((r519 & 16384) == 0) goto L61;
        Long r120 = null;
    L63:
        if ((r519 & 32768) == 0) goto L65;
        Long r121 = null;
    L67:
        if ((r519 & 65536) == 0) goto L69;
        GroupInfo r122 = null;
    L71:
        if ((r519 & 131072) == 0) goto L73;
        PromotionDiscountPrice r210 = new PromotionDiscountPrice(null, null, null, null, 15, null);
    L75:
        if ((r519 & 262144) == 0) goto L77;
        PromotionIPActivity r211 = null;
    L79:
        if ((r519 & 524288) == 0) goto L81;
        Long r212 = null;
    L83:
        if ((r519 & 1048576) == 0) goto L85;
        int r213 = 0;
    L87:
        if ((r519 & 2097152) == 0) goto L89;
        MFPromotionEvent r214 = null;
    L91:
        if ((r519 & 4194304) == 0) goto L93;
        b r215 = null;
    L95:
        if ((r519 & 8388608) == 0) goto L97;
        PromotionSubsidizedActivity r216 = null;
    L99:
        if ((r519 & 16777216) == 0) goto L101;
        CommonGirdleStruct r217 = null;
    L103:
        if ((r519 & 33554432) == 0) goto L105;
        PromotionDepositPresaleActivity r106 = null;
    L106:
        this(r100, r102, r103, r101, r104, r110, r111, r112, r113, r114, r105, r611, r117, r119, r120, r121, r122, r210, r211, r212, r213, r214, r215, r216, r217, r106);
        return;
    L105:
        r106 = r518;
        goto L106
    L101:
        r217 = r517;
        goto L103
    L97:
        r216 = r516;
        goto L99
    L93:
        r215 = r515;
        goto L95
    L89:
        r214 = r514;
        goto L91
    L85:
        r213 = r513;
        goto L87
    L81:
        r212 = r512;
        goto L83
    L77:
        r211 = r511;
        goto L79
    L73:
        r210 = r510;
        goto L75
    L69:
        r122 = r419;
        goto L71
    L65:
        r121 = r418;
        goto L67
    L61:
        r120 = r417;
        goto L63
    L57:
        r118 = r416;
        goto L58
    L53:
        r116 = r415;
        goto L54
    L49:
        r115 = r414;
        goto L50
    L45:
        r105 = r413;
        goto L47
    L41:
        r114 = r412;
        goto L43
    L37:
        r113 = r411;
        goto L39
    L33:
        r112 = r410;
        goto L35
    L29:
        r111 = r316;
        goto L31
    L25:
        r110 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L6
    }
}

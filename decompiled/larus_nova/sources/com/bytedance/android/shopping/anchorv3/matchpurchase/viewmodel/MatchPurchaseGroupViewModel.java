package com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.BaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.CombinationChannelInfo;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.CombinationComponent;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.CombinationStruct;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.DetailArea;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.HotArea;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageComponent;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageTips;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.Point;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.SingleSkuSpecInfo;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchasePageComponentDTO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.PurchaseButtonVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.SkuProductDetailParam;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.SkuSelectStruct;
import com.bytedance.android.shopping.anchorv3.matchpurchase.repository.dto.MatchPurchaseDynamicResponseDTO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import p63.e;
import p63.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\by\u0010zJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0018\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eJ\u0018\u0010\u001d\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0014\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u0014\u0010#\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010$\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R(\u00105\u001a\b\u0012\u0004\u0012\u0002040\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR*\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010>\u001a\u0004\bI\u0010@\"\u0004\bJ\u0010BR*\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u0004\bN\u0010BR(\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010>\u001a\u0004\bP\u0010@\"\u0004\bQ\u0010BR$\u0010R\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000e0X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u00106\u001a\u0004\bZ\u00108\"\u0004\b[\u0010:R(\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001b0X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u00106\u001a\u0004\b]\u00108\"\u0004\b^\u0010:R.\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010>\u001a\u0004\b`\u0010@\"\u0004\ba\u0010BR\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000e0;8\u0006¢\u0006\f\n\u0004\bb\u0010>\u001a\u0004\bc\u0010@R\u001f\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0;8\u0006¢\u0006\f\n\u0004\be\u0010>\u001a\u0004\bf\u0010@R(\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000e0;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010>\u001a\u0004\bh\u0010@\"\u0004\bi\u0010BR\"\u0010j\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010k\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR\"\u0010s\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010$\u001a\u0004\bt\u0010'\"\u0004\bu\u0010)R(\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00160;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010>\u001a\u0004\bw\u0010@\"\u0004\bx\u0010B¨\u0006{"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/viewmodel/MatchPurchaseGroupViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "params", "", "initParam", "updateSelectAllButtonStatus", "calculateCombinedCheckedResult", "getMatchPurchasePageInfo", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchasePageComponentDTO;", "dto", "generateEventParam", "", "index", "", "isProductOnSale", "toggleSelectAllButtonCheckStatus", "closeMatchPurchasePage", "initData", "isFullScreen", "fromProductDetailPage", "fromLive", "", "productId", "isChecked", "updateProductCheckStatus", "toggleProductAllCheckStatus", "Lp63/f;", "skuDetail", "updateProductSkusStatus", "emphasizeNoSkuInfoItems", "", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/SkuSelectStruct;", "checkList", "getMatchPurchasePageInfoDynamic", "TAG", "Ljava/lang/String;", "pageId", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "getParams", "()Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "setParams", "(Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;)V", "Lr63/a;", "repository", "Lr63/a;", "getRepository", "()Lr63/a;", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/SkuProductDetailParam;", "skuDetailParams", "Ljava/util/List;", "getSkuDetailParams", "()Ljava/util/List;", "setSkuDetailParams", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/CombinationVO;", "headerPictureVO", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getHeaderPictureVO", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setHeaderPictureVO", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "headerPicture", "getHeaderPicture", "setHeaderPicture", "Lp63/a;", "combinationSkusVO", "getCombinationSkusVO", "setCombinationSkusVO", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;", "purchaseButtonVO", "getPurchaseButtonVO", "setPurchaseButtonVO", "selectAllButtonCheckStatus", "getSelectAllButtonCheckStatus", "setSelectAllButtonCheckStatus", "defaultPurchaseButtonVO", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;", "getDefaultPurchaseButtonVO", "()Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;", "setDefaultPurchaseButtonVO", "(Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;)V", "", "checkStatus", "getCheckStatus", "setCheckStatus", "skusStatus", "getSkusStatus", "setSkusStatus", "combinedCheckedResult", "getCombinedCheckedResult", "setCombinedCheckedResult", "pageClosed", "getPageClosed", "Lp63/b;", "descTitleVO", "getDescTitleVO", "firstBind", "getFirstBind", "setFirstBind", "buttonInfoFetched", "Z", "getButtonInfoFetched", "()Z", "setButtonInfoFetched", "(Z)V", "buttonInfoUpdated", "getButtonInfoUpdated", "setButtonInfoUpdated", "matchingProductId", "getMatchingProductId", "setMatchingProductId", "livePanelTitle", "getLivePanelTitle", "setLivePanelTitle", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseGroupViewModel extends BaseViewModel {
    private final String TAG;
    private boolean buttonInfoFetched;
    private boolean buttonInfoUpdated;
    private List<Boolean> checkStatus;
    private QLiveData<p63.a> combinationSkusVO;
    private QLiveData<List<SkuSelectStruct>> combinedCheckedResult;
    private PurchaseButtonVO defaultPurchaseButtonVO;
    private final QLiveData<p63.b> descTitleVO;
    private QLiveData<Boolean> firstBind;
    private QLiveData<ECUrlModel> headerPicture;
    private QLiveData<CombinationVO> headerPictureVO;
    private QLiveData<String> livePanelTitle;
    private String matchingProductId;
    private final QLiveData<Boolean> pageClosed;
    private String pageId;
    private MatchPurchaseParams params;
    private QLiveData<PurchaseButtonVO> purchaseButtonVO;
    private final r63.a repository;
    private QLiveData<Boolean> selectAllButtonCheckStatus;
    private List<SkuProductDetailParam> skuDetailParams;
    private List<f> skusStatus;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseGroupViewModel f165251a;

        public a(MatchPurchaseGroupViewModel r100) {
            this.f165251a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel] */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v21, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r310) {
            MatchPurchasePageComponentDTO r100 = (MatchPurchasePageComponentDTO) r310;
            if (this.f165251a.isFullScreen() == true) goto L7;
            com.bytedance.android.ec.monitor.duration.d r101 = i.f47987a.get(MatchPurchaseHelper.f165132a);
            if (r101 == null) goto L7;
            r101.a("request_end");
        L7:
            ?? r102 = this.f165251a;
            if (r100 == null) goto L16;
            List<CombinationComponent> r103 = r100.getProductItems();
            if (r103 == null) goto L16;
            List<CombinationComponent> r104 = r103;
            ?? r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator<T> r106 = r104.iterator();
        L14:
            if (r106.hasNext() == false) goto L17;
            CombinationComponent r107 = (CombinationComponent) r106.next();
            r105.add(new SkuProductDetailParam(r107.getProductId(), r107.getPromotionId()));
        L17:
            r102.setSkuDetailParams(r105);
            if (r100 == null) goto L22;
            List<CombinationComponent> r108 = r100.getProductItems();
            if (r108 == null) goto L22;
            int r109 = r108.size();
        L23:
            MatchPurchaseGroupViewModel r110 = this.f165251a;
            ArrayList r111 = new ArrayList(r109);
            int r112 = 0;
        L24:
            int r113 = 100;
            boolean r114 = true;
            Integer r115 = null;
            if (r112 >= r109) goto L41;
            if (MatchPurchaseHelper.a() == false) goto L39;
            if (r100 == null) goto L34;
            List<CombinationComponent> r116 = r100.getProductItems();
            if (r116 == null) goto L34;
            CombinationComponent r117 = (CombinationComponent) CollectionsKt.getOrNull(r116, r112);
            if (r117 == null) goto L34;
            r115 = r117.getStatus();
        L34:
            if (r115 == null) goto L39;
            if (r115.intValue() != 100) goto L39;
        L40:
            r111.add(Boolean.valueOf(r114));
            r112 = r112 + 1;
        L39:
            r114 = false;
            goto L40
        L41:
            r110.setCheckStatus(r111);
            MatchPurchaseGroupViewModel r118 = this.f165251a;
            ArrayList r119 = new ArrayList(r109);
            int r120 = 0;
        L42:
            String r121 = "";
            if (r120 >= r109) goto L69;
            if (r100 == null) goto L48;
            List<CombinationComponent> r122 = r100.getProductItems();
            if (r122 == null) goto L48;
            CombinationComponent r123 = (CombinationComponent) CollectionsKt.getOrNull(r122, r120);
        L49:
            if (r123 == null) goto L67;
            Integer r124 = r123.getSkuType();
            if (r124 == null) goto L67;
            if (r124.intValue() != 1) goto L67;
            SingleSkuSpecInfo r125 = r123.getSpecInfo();
            if (r125 == null) goto L59;
            String r126 = r125.getSkuId();
            if (r126 == null) goto L59;
        L60:
            SingleSkuSpecInfo r127 = r123.getSpecInfo();
            if (r127 == null) goto L66;
            String r128 = r127.getSpecName();
            if (r128 == null) goto L66;
            r121 = r128;
        L66:
            f r129 = new f(r126, r121, 12);
        L68:
            r119.add(r129);
            r120 = r120 + 1;
        L59:
            r126 = "";
        L67:
            r129 = new f("", null, 14);
        L48:
            r123 = null;
            goto L49
        L69:
            r118.setSkusStatus(r119);
            QLiveData<p63.a> r130 = this.f165251a.getCombinationSkusVO();
            Boolean r131 = this.f165251a.getFirstBind().a();
            if (r131 == null) goto L72;
            boolean r132 = r131.booleanValue();
        L73:
            List<Boolean> r133 = this.f165251a.getCheckStatus();
            List<f> r134 = this.f165251a.getSkusStatus();
            Intrinsics.checkNotNullParameter(r133, "checkStatus");
            Intrinsics.checkNotNullParameter(r134, "skuStatus");
            if (r100 == null) goto L116;
            List<CombinationComponent> r135 = r100.getProductItems();
            if (r135 == null) goto L116;
            BaseInfo r136 = r100.getBaseInfo();
            if (r136 == null) goto L81;
            String r137 = r136.getCombinationId();
        L82:
            List<CombinationComponent> r138 = r135;
            ArrayList r139 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r138, 10));
            Iterator<T> r210 = r138.iterator();
            int r140 = 0;
        L84:
            if (r210.hasNext() == false) goto L115;
            T r141 = r210.next();
            int r311 = r140 + 1;
            if (r140 >= 0) goto L88;
            CollectionsKt.throwIndexOverflow();
        L88:
            CombinationComponent r142 = (CombinationComponent) r141;
            String r143 = r142.getProductId();
            String r144 = r142.getPromotionId();
            ECUrlModel r145 = r142.getImage();
            Integer r146 = r142.getSkuType();
            if (r146 != null) goto L92;
        L94:
            boolean r147 = false;
        L95:
            Boolean r211 = (Boolean) CollectionsKt.getOrNull(r133, r140);
            if (r211 == null) goto L98;
            boolean r212 = r211.booleanValue();
        L99:
            Integer r213 = r142.getStatus();
            if (r213 != null) goto L103;
        L105:
            boolean r214 = false;
        L106:
            String r148 = r142.getName();
            f r215 = (f) CollectionsKt.getOrNull(r134, r140);
            PromotionProductPrice r216 = r142.getPrice();
            ImageTips r217 = r142.getImageTips();
            SingleSkuSpecInfo r218 = r142.getSpecInfo();
            String r219 = r142.getSchema();
            CombinationChannelInfo r149 = r142.getChannelInfo();
            if (r149 == null) goto L109;
            Long r220 = r149.getChannelId();
        L110:
            CombinationChannelInfo r150 = r142.getChannelInfo();
            if (r150 == null) goto L113;
            Long r312 = r150.getChannelType();
        L114:
            ArrayList r151 = r139;
            r151.add(new e(r132, r143, r144, r145, r147, r212, r148, r216, r215, r214, r217, r218, false, r219, r220, r312));
            r137 = r137;
            r139 = r151;
            r140 = r311;
            r113 = 100;
            goto L84
        L113:
            r312 = null;
            goto L114
        L109:
            r220 = null;
            goto L110
        L103:
            if (r213.intValue() != r113) goto L105;
            r214 = true;
            goto L106
        L98:
            r212 = false;
            goto L99
        L92:
            if (r146.intValue() != 0) goto L94;
            r147 = true;
            goto L95
        L115:
            p63.a r152 = new p63.a(r137, r139);
        L117:
            r130.g(r152);
            QLiveData<CombinationVO> r153 = this.f165251a.getHeaderPictureVO();
            boolean r154 = this.f165251a.isFullScreen();
            if (r100 == null) goto L122;
            ImageComponent r155 = r100.getImageComponent();
            if (r155 == null) goto L122;
            CombinationStruct r156 = r155.getCombinationStruct();
        L123:
            if (r154 == false) goto L198;
            if (r156 == null) goto L198;
            List<HotArea> r157 = r156.getImageHotAreas();
            if (r157 == null) goto L180;
            List<HotArea> r158 = r157;
            ?? r159 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r158, 10));
            Iterator<T> r160 = r158.iterator();
        L129:
            if (r160.hasNext() == false) goto L181;
            HotArea r161 = (HotArea) r160.next();
            DetailArea r162 = r161.getDetailArea();
            if (r162 == null) goto L133;
            ECUrlModel r163 = r162.getIcon();
        L134:
            DetailArea r164 = r161.getDetailArea();
            if (r164 == null) goto L140;
            String r165 = r164.getText();
            if (r165 == null) goto L140;
            String r166 = r165;
        L141:
            DetailArea r167 = r161.getDetailArea();
            if (r167 == null) goto L147;
            String r168 = r167.getSubText();
            if (r168 == null) goto L147;
            String r169 = r168;
        L148:
            DetailArea r170 = r161.getDetailArea();
            if (r170 == null) goto L154;
            String r171 = r170.getUrl();
            if (r171 == null) goto L154;
            String r172 = r171;
        L155:
            DetailArea r173 = r161.getDetailArea();
            if (r173 == null) goto L158;
            String r174 = r173.getProductId();
        L159:
            DetailArea r175 = r161.getDetailArea();
            if (r175 == null) goto L162;
            String r176 = r175.getDirection();
        L163:
            if (r176 != null) goto L166;
        L178:
            int r177 = 0;
        L179:
            r159.add(new p63.c(r163, r166, r169, r172, r174, r177));
            goto L129
        L166:
            switch(r176.hashCode()) {
                case -1383228885: goto L176;
                case 115029: goto L173;
                case 3317767: goto L171;
                case 108511772: goto L169;
                default: goto L178;
            };
        L171:
            r176.equals("left");
            goto L178
        L169:
            if (r176.equals("right") == false) goto L178;
            r177 = 1;
            goto L179
        L173:
            if (r176.equals("top") == false) goto L178;
            r177 = 2;
            goto L179
        L176:
            if (r176.equals("bottom") == false) goto L178;
            r177 = 3;
            goto L179
        L162:
            r176 = null;
            goto L163
        L158:
            r174 = null;
        L154:
            r172 = "";
        L147:
            r169 = "";
        L140:
            r166 = "";
            goto L141
        L133:
            r163 = null;
        L181:
            ?? r178 = r159;
            List<HotArea> r179 = r156.getImageHotAreas();
            if (r179 == null) goto L192;
            List<HotArea> r180 = r179;
            ArrayList r181 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r180, 10));
            Iterator<T> r182 = r180.iterator();
        L185:
            if (r182.hasNext() == false) goto L191;
            Point r183 = ((HotArea) r182.next()).getPoint();
            if (r183 != null) goto L190;
            r183 = new Point(0, 0);
        L190:
            r181.add(r183);
            goto L185
        L191:
            List r184 = r181;
        L193:
            ECUrlModel r185 = r156.getImage();
            if (r185 == null) goto L196;
            Integer r186 = Integer.valueOf(r185.getHeight());
        L197:
            CombinationVO r187 = new CombinationVO(k.f(r186), r178, r184, null, true, false);
        L199:
            r153.g(r187);
            QLiveData<ECUrlModel> r188 = this.f165251a.getHeaderPicture();
            if (r100 == null) goto L206;
            ImageComponent r189 = r100.getImageComponent();
            if (r189 == null) goto L206;
            CombinationStruct r190 = r189.getCombinationStruct();
            if (r190 == null) goto L206;
            ECUrlModel r191 = r190.getImage();
        L207:
            r188.g(r191);
            QLiveData<p63.b> r192 = this.f165251a.getDescTitleVO();
            boolean r193 = this.f165251a.isFullScreen();
            if (r100 == null) goto L212;
            BaseInfo r194 = r100.getBaseInfo();
            if (r194 == null) goto L212;
            String r195 = r194.getRecommendContent();
        L213:
            HashMap<String, JSONObject> r196 = j.f44312a;
            if (j.e(r195) == false) goto L217;
            if (r193 == false) goto L217;
            p63.b r197 = new p63.b(r195);
        L218:
            r192.g(r197);
            MatchPurchaseGroupViewModel r198 = this.f165251a;
            if (r100 == null) goto L224;
            BuyButtonComponent r199 = r100.getBuyButtonComponent();
            if (r199 == null) goto L224;
            PurchaseButtonVO r1100 = new PurchaseButtonVO(CollectionsKt.listOf(r199), null, null, 6, null);
        L225:
            r198.setDefaultPurchaseButtonVO(r1100);
            if (this.f165251a.getButtonInfoFetched() == false) goto L231;
            if (this.f165251a.getButtonInfoUpdated() == true) goto L231;
            this.f165251a.getPurchaseButtonVO().g(this.f165251a.getDefaultPurchaseButtonVO());
        L231:
            if (this.f165251a.isFullScreen() == true) goto L239;
            QLiveData<String> r200 = this.f165251a.getLivePanelTitle();
            if (r100 == null) goto L237;
            BaseInfo r201 = r100.getBaseInfo();
            if (r201 == null) goto L237;
            String r1101 = r201.getCombinationTitle();
        L238:
            r200.g(r1101);
        L237:
            r1101 = null;
        L239:
            this.f165251a.getFirstBind().g(Boolean.FALSE);
            MatchPurchaseGroupViewModel.access$calculateCombinedCheckedResult(this.f165251a);
            MatchPurchaseGroupViewModel.access$generateEventParam(this.f165251a, r100);
            return;
        L224:
            r1100 = null;
        L217:
            r197 = null;
        L212:
            r195 = null;
        L206:
            r191 = null;
            goto L207
        L196:
            r186 = null;
            goto L197
        L192:
            r184 = CollectionsKt.emptyList();
            goto L193
        L180:
            r159 = CollectionsKt.emptyList();
        L198:
            r187 = null;
        L122:
            r156 = null;
            goto L123
        L81:
            r137 = null;
        L116:
            r152 = null;
            goto L117
        L72:
            r132 = false;
        L22:
            r109 = 0;
        L16:
            r105 = CollectionsKt.emptyList();
            goto L17
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f165252a = null;

        static {
            f165252a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.c(String.valueOf(((Throwable) r100).getMessage()));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseGroupViewModel f165253a;

        public c(MatchPurchaseGroupViewModel r100) {
            this.f165253a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MatchPurchaseDynamicResponseDTO r101 = (MatchPurchaseDynamicResponseDTO) r100;
            this.f165253a.setButtonInfoFetched(true);
            this.f165253a.setButtonInfoUpdated(true);
            QLiveData<PurchaseButtonVO> r102 = this.f165253a.getPurchaseButtonVO();
            if (r101 == null) goto L8;
            BuyButtonComponent r103 = r101.getComponent();
            if (r103 == null) goto L8;
            PurchaseButtonVO r104 = new PurchaseButtonVO(CollectionsKt.listOf(r103), r103.getDiscountPrice(), r103.getTips());
        L9:
            r102.g(r104);
            return;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseGroupViewModel f165254a;

        public d(MatchPurchaseGroupViewModel r100) {
            this.f165254a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f165254a.setButtonInfoFetched(true);
            this.f165254a.setButtonInfoUpdated(false);
            if (Intrinsics.areEqual(this.f165254a.getFirstBind().a(), Boolean.FALSE) == false) goto L5;
            this.f165254a.getPurchaseButtonVO().g(this.f165254a.getDefaultPurchaseButtonVO());
        L5:
            ECExceptionMonitor.c(String.valueOf(r101.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MatchPurchaseGroupViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.TAG = "MatchPurchaseGroupViewM";
        this.params = new MatchPurchaseParams("", null, "", 0, 0, null, null, null, null, null, null, null, null, null, null, false, false, null, null, 524272, null);
        this.repository = r63.b.f536329b;
        this.skuDetailParams = CollectionsKt.emptyList();
        this.headerPictureVO = new QLiveData();
        this.headerPicture = new QLiveData();
        this.combinationSkusVO = new QLiveData();
        this.purchaseButtonVO = new QLiveData();
        this.selectAllButtonCheckStatus = new QLiveData();
        this.checkStatus = new ArrayList();
        this.skusStatus = new ArrayList();
        this.combinedCheckedResult = new QLiveData();
        QLiveData<Boolean> r101 = new QLiveData();
        this.pageClosed = r101;
        this.descTitleVO = new QLiveData();
        this.firstBind = new QLiveData();
        this.matchingProductId = "";
        this.livePanelTitle = new QLiveData();
        r101.g(Boolean.FALSE);
        QLiveData<Boolean> r102 = this.firstBind;
        Boolean r103 = Boolean.TRUE;
        r102.g(r103);
        this.selectAllButtonCheckStatus.g(r103);
    }

    private final void calculateCombinedCheckedResult() {
        QLiveData<List<SkuSelectStruct>> r100 = this.combinedCheckedResult;
        List<Boolean> r101 = this.checkStatus;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L15;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((Boolean) r105).booleanValue() == true) goto L11;
    L13:
        SkuSelectStruct r107 = null;
    L14:
        r102.add(r107);
        r104 = r106;
        goto L4
    L11:
        if (isProductOnSale(r104) == false) goto L13;
        r107 = new SkuSelectStruct(((SkuProductDetailParam) ListProtector.get(this.skuDetailParams, r104)).getProductId(), ((SkuProductDetailParam) ListProtector.get(this.skuDetailParams, r104)).getPromotionId(), ((f) ListProtector.get(this.skusStatus, r104)).f527906a);
        goto L14
    L15:
        r100.g(CollectionsKt.filterNotNull(r102));
    }

    public final void closeMatchPurchasePage() {
        this.pageClosed.g(Boolean.TRUE);
        this.repository.a();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void emphasizeNoSkuInfoItems() {
        p63.a r100 = this.combinationSkusVO.a();
        p63.a r101 = null;
        ArrayList r102 = null;
        if (r100 == null) goto L31;
        String r103 = r100.f527878a;
        List<e> r104 = r100.f527879b;
        if (r104 == null) goto L30;
        List<e> r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
        int r108 = 0;
    L8:
        if (r107.hasNext() == false) goto L29;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        e r111 = (e) r109;
        if (Intrinsics.areEqual((Boolean) CollectionsKt.getOrNull(this.checkStatus, r108), Boolean.TRUE) == false) goto L27;
        f r112 = (f) CollectionsKt.getOrNull(this.skusStatus, r108);
        if (r112 == null) goto L17;
        String r113 = r112.f527906a;
    L19:
        if (r113 != null) goto L21;
    L24:
        boolean r114 = true;
    L25:
        if (r114 == false) goto L27;
        e r115 = e.b(r111, false, null, true, 61439);
    L28:
        r106.add(r115);
        r108 = r110;
        goto L8
    L21:
        if (r113.length() == 0) goto L24;
        r114 = false;
        goto L25
    L17:
        r113 = null;
    L27:
        r115 = e.b(r111, false, null, false, 65535);
        goto L28
    L29:
        r102 = r106;
    L30:
        r101 = new p63.a(r103, r102);
    L31:
        this.combinationSkusVO.g(r101);
    }

    public final boolean fromLive() {
        Object r100 = BtmSDK.INSTANCE.createReportParams("a1.b08434.c0.d0", PageFinder.via(this.pageId)).get("btm_pre");
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r101 = (String) r100;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (StringsKt.startsWith$default(r101, "a1.b0715", false, 2, null) == false) goto L11;
    L14:
        return true;
    L11:
        if (StringsKt.startsWith$default(r101, "a1128.b3295", false, 2, null) == true) goto L14;
        if (StringsKt.startsWith$default(r101, "a1128.b7947", false, 2, null) == true) goto L14;
        return false;
    }

    public final boolean fromProductDetailPage() {
        if (this.params.getTag() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFullScreen() {
        return this.params.isFullScreen();
    }

    public final void toggleSelectAllButtonCheckStatus() {
        Boolean r100 = this.selectAllButtonCheckStatus.a();
        if (r100 == null) goto L6;
        r100.booleanValue();
        this.selectAllButtonCheckStatus.g(Boolean.valueOf(!r100.booleanValue()));
        toggleProductAllCheckStatus(!r100.booleanValue());
        return;
    }

    private final void getMatchPurchasePageInfo() {
        if (isFullScreen() == true) goto L7;
        com.bytedance.android.ec.monitor.duration.d r100 = i.f47987a.get(MatchPurchaseHelper.f165132a);
        if (r100 == null) goto L7;
        r100.a("request_start");
    L7:
        bg4.b.b(this.repository.b(this.params, 0)).subscribe(new a(this), b.f165252a);
    }

    private final void updateSelectAllButtonStatus() {
        if (MatchPurchaseHelper.a() == true) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.checkStatus.iterator();
        boolean r101 = true;
        int r102 = 0;
    L7:
        if (r100.hasNext() == false) goto L18;
        Object r103 = r100.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        if (((Boolean) r103).booleanValue() == true) goto L16;
        if (isProductOnSale(r102) == false) goto L16;
        r101 = false;
    L16:
        r102 = r104;
        goto L7
    L18:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r101), this.selectAllButtonCheckStatus.a())) == false) goto L25;
        this.selectAllButtonCheckStatus.g(Boolean.valueOf(r101));
        return;
    }

    public final boolean getButtonInfoFetched() {
        return this.buttonInfoFetched;
    }

    public final boolean getButtonInfoUpdated() {
        return this.buttonInfoUpdated;
    }

    public final List<Boolean> getCheckStatus() {
        return this.checkStatus;
    }

    public final QLiveData<p63.a> getCombinationSkusVO() {
        return this.combinationSkusVO;
    }

    public final QLiveData<List<SkuSelectStruct>> getCombinedCheckedResult() {
        return this.combinedCheckedResult;
    }

    public final PurchaseButtonVO getDefaultPurchaseButtonVO() {
        return this.defaultPurchaseButtonVO;
    }

    public final QLiveData<p63.b> getDescTitleVO() {
        return this.descTitleVO;
    }

    public final QLiveData<Boolean> getFirstBind() {
        return this.firstBind;
    }

    public final QLiveData<ECUrlModel> getHeaderPicture() {
        return this.headerPicture;
    }

    public final QLiveData<CombinationVO> getHeaderPictureVO() {
        return this.headerPictureVO;
    }

    public final QLiveData<String> getLivePanelTitle() {
        return this.livePanelTitle;
    }

    public final String getMatchingProductId() {
        return this.matchingProductId;
    }

    public final QLiveData<Boolean> getPageClosed() {
        return this.pageClosed;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final MatchPurchaseParams getParams() {
        return this.params;
    }

    public final QLiveData<PurchaseButtonVO> getPurchaseButtonVO() {
        return this.purchaseButtonVO;
    }

    public final r63.a getRepository() {
        return this.repository;
    }

    public final QLiveData<Boolean> getSelectAllButtonCheckStatus() {
        return this.selectAllButtonCheckStatus;
    }

    public final List<SkuProductDetailParam> getSkuDetailParams() {
        return this.skuDetailParams;
    }

    public final List<f> getSkusStatus() {
        return this.skusStatus;
    }

    public static final /* synthetic */ void access$calculateCombinedCheckedResult(MatchPurchaseGroupViewModel r100) {
        r100.calculateCombinedCheckedResult();
    }

    private final void generateEventParam(MatchPurchasePageComponentDTO r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        List<CombinationComponent> r111 = r110.getProductItems();
        if (r111 == null) goto L12;
        List<CombinationComponent> r112 = r111;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L10;
        r100.add(((CombinationComponent) r113.next()).getProductId());
        goto L8
    L10:
        String r114 = CollectionsKt.joinToString$default(r100, "_", null, null, 0, null, null, 62, null);
        if (r114 == null) goto L12;
    L13:
        this.matchingProductId = r114;
        return;
    L12:
        r114 = "";
        goto L13
    }

    private final void initParam(MatchPurchaseParams r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.params = r100;
    }

    private final boolean isProductOnSale(int r100) {
        p63.a r101 = this.combinationSkusVO.a();
        if (r101 == null) goto L9;
        List<e> r102 = r101.f527879b;
        if (r102 == null) goto L9;
        e r103 = (e) CollectionsKt.getOrNull(r102, r100);
        if (r103 == null) goto L9;
        return r103.f527899k;
    L9:
        return true;
    }

    public final void getMatchPurchasePageInfoDynamic(List<SkuSelectStruct> r100) {
        Intrinsics.checkNotNullParameter(r100, "checkList");
        bg4.b.b(this.repository.c(this.params, r100)).subscribe(new c(this), new d(this));
    }

    public final void initData(MatchPurchaseParams r100) {
        initParam(r100);
        getMatchPurchasePageInfo();
    }

    public final void setButtonInfoFetched(boolean r100) {
        this.buttonInfoFetched = r100;
    }

    public final void setButtonInfoUpdated(boolean r100) {
        this.buttonInfoUpdated = r100;
    }

    public final void setCheckStatus(List<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.checkStatus = r100;
    }

    public final void setCombinationSkusVO(QLiveData<p63.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.combinationSkusVO = r100;
    }

    public final void setCombinedCheckedResult(QLiveData<List<SkuSelectStruct>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.combinedCheckedResult = r100;
    }

    public final void setDefaultPurchaseButtonVO(PurchaseButtonVO r100) {
        this.defaultPurchaseButtonVO = r100;
    }

    public final void setFirstBind(QLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.firstBind = r100;
    }

    public final void setHeaderPicture(QLiveData<ECUrlModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.headerPicture = r100;
    }

    public final void setHeaderPictureVO(QLiveData<CombinationVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.headerPictureVO = r100;
    }

    public final void setLivePanelTitle(QLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.livePanelTitle = r100;
    }

    public final void setMatchingProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.matchingProductId = r100;
    }

    public final void setPageId(String r100) {
        this.pageId = r100;
    }

    public final void setParams(MatchPurchaseParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setPurchaseButtonVO(QLiveData<PurchaseButtonVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.purchaseButtonVO = r100;
    }

    public final void setSelectAllButtonCheckStatus(QLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectAllButtonCheckStatus = r100;
    }

    public final void setSkuDetailParams(List<SkuProductDetailParam> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.skuDetailParams = r100;
    }

    public final void setSkusStatus(List<f> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.skusStatus = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void toggleProductAllCheckStatus(boolean r110) {
        List<Boolean> r100 = this.checkStatus;
        boolean r101 = true;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        if (((Boolean) r102.next()).booleanValue() != r110) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L9;
        r101 = false;
        goto L16
    L13:
        r103 = false;
    L16:
        if (r101 == false) goto L18;
        return;
    L18:
        int r104 = this.checkStatus.size();
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L21;
        ListProtector.set(this.checkStatus, r105, Boolean.valueOf(r110));
        r105 = r105 + 1;
        goto L19
    L21:
        p63.a r106 = this.combinationSkusVO.a();
        p63.a r107 = null;
        ArrayList r108 = null;
        if (r106 == null) goto L38;
        String r109 = r106.f527878a;
        List<e> r111 = r106.f527879b;
        if (r111 == null) goto L37;
        List<e> r112 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
        int r115 = 0;
    L27:
        if (r114.hasNext() == false) goto L36;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        e r118 = (e) r116;
        if (r110 == false) goto L34;
        boolean r119 = r118.f527899k;
    L35:
        r113.add(e.b(r118, r119, null, false, 61407));
        r115 = r117;
        goto L27
    L34:
        r119 = false;
        goto L35
    L36:
        r108 = r113;
    L37:
        r107 = new p63.a(r109, r108);
    L38:
        this.combinationSkusVO.g(r107);
        calculateCombinedCheckedResult();
        return;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ void access$generateEventParam(MatchPurchaseGroupViewModel r100, MatchPurchasePageComponentDTO r101) {
        r100.generateEventParam(r101);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void updateProductCheckStatus(String r100, boolean r110) {
        Iterator<SkuProductDetailParam> r101 = this.skuDetailParams.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().getProductId(), r100) == true) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 != (-1)) goto L12;
        return;
    L12:
        if (((Boolean) ListProtector.get(this.checkStatus, r102)).booleanValue() == r110) goto L39;
        ListProtector.set(this.checkStatus, r102, Boolean.valueOf(r110));
        p63.a r103 = this.combinationSkusVO.a();
        p63.a r104 = null;
        ArrayList r105 = null;
        if (r103 == null) goto L31;
        String r106 = r103.f527878a;
        List<e> r107 = r103.f527879b;
        if (r107 == null) goto L30;
        List<e> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r111 = r108.iterator();
        int r112 = 0;
    L20:
        if (r111.hasNext() == false) goto L29;
        Object r113 = r111.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        e r115 = (e) r113;
        if (r112 != r102) goto L27;
        e r116 = e.b(r115, r110, null, false, 61407);
    L28:
        r109.add(r116);
        r112 = r114;
        goto L20
    L27:
        r116 = e.b(r115, false, null, false, 65535);
        goto L28
    L29:
        r105 = r109;
    L30:
        r104 = new p63.a(r106, r105);
    L31:
        this.combinationSkusVO.g(r104);
        calculateCombinedCheckedResult();
        updateSelectAllButtonStatus();
        return;
    L39:
        return;
    L9:
        r102 = -1;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void updateProductSkusStatus(String r110, f r111) {
        Intrinsics.checkNotNullParameter(r111, "skuDetail");
        Iterator<SkuProductDetailParam> r100 = this.skuDetailParams.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r100.next().getProductId(), r110) == true) goto L11;
        r101 = r101 + 1;
    L11:
        if (r101 < this.skusStatus.size()) goto L14;
        return;
    L14:
        if (r111.f527906a.length() != 0) goto L16;
        boolean r112 = true;
    L17:
        p63.a r102 = this.combinationSkusVO.a();
        p63.a r103 = null;
        ArrayList r104 = null;
        if (r102 == null) goto L34;
        String r105 = r102.f527878a;
        List<e> r106 = r102.f527879b;
        if (r106 == null) goto L33;
        List<e> r107 = r106;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
        int r113 = 0;
    L23:
        if (r109.hasNext() == false) goto L32;
        Object r114 = r109.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        e r116 = (e) r114;
        if (r113 != r101) goto L30;
        e r117 = e.b(r116, false, r111, r112, 61183);
    L31:
        r108.add(r117);
        r113 = r115;
        goto L23
    L30:
        r117 = e.b(r116, false, null, false, 65535);
        goto L31
    L32:
        r104 = r108;
    L33:
        r103 = new p63.a(r105, r104);
    L34:
        this.combinationSkusVO.g(r103);
        ListProtector.set(this.skusStatus, r101, r111);
        calculateCombinedCheckedResult();
        return;
    L16:
        r112 = false;
        goto L17
    L9:
        r101 = -1;
        goto L11
    }
}

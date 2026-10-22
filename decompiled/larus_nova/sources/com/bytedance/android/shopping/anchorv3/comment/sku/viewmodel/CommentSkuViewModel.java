package com.bytedance.android.shopping.anchorv3.comment.sku.viewmodel;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.shopping.anchorv3.activities.quick.base.BaseViewModel;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import fc3.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u009d\u0001\u0010\u0017\u001a\u00020\u000f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2 \u0010\u0011\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR)\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u00188\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR)\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u00188\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00188\u0006¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR?\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00100R<\u00101\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R*\u00104\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/sku/viewmodel/CommentSkuViewModel;", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/BaseViewModel;", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentParams;", "getCommentParams", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductSkuStruct;", "skuInfoList", "", "", "preSelectSkuInfo", "title", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "content", "", "commentTitleChangeCB", "confirmSkuCB", "Lkotlin/Function0;", "dialogDismissCB", "commentParams", "Lfc3/a;", "actionContext", "initParams", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "skuInfo", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getSkuInfo", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "preSkuInfo", "getPreSkuInfo", "skuRequestInfo", "getSkuRequestInfo", "productTitle", "getProductTitle", "", "resetSku", "getResetSku", "Lkotlin/jvm/functions/Function1;", "getCommentTitleChangeCB", "()Lkotlin/jvm/functions/Function1;", "setCommentTitleChangeCB", "(Lkotlin/jvm/functions/Function1;)V", "Lfc3/a;", "getActionContext", "()Lfc3/a;", "setActionContext", "(Lfc3/a;)V", "Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentParams;", "confirmSkuCallBack", "getConfirmSkuCallBack", "setConfirmSkuCallBack", "dialogDissmissCallBack", "Lkotlin/jvm/functions/Function0;", "getDialogDissmissCallBack", "()Lkotlin/jvm/functions/Function0;", "setDialogDissmissCallBack", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentSkuViewModel extends BaseViewModel {
    private a actionContext;
    private CommentParams commentParams;
    private Function1<? super String, Unit> commentTitleChangeCB;
    private Function1<? super Map<String, String>, Unit> confirmSkuCallBack;
    private Function0<Unit> dialogDissmissCallBack;
    private final QLiveData<Map<String, String>> preSkuInfo;
    private final QLiveData<String> productTitle;
    private final QLiveData<Boolean> resetSku;
    private final QLiveData<List<PromotionProductSkuStruct>> skuInfo;
    private final QLiveData<Map<String, String>> skuRequestInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public CommentSkuViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.skuInfo = new QLiveData();
        this.preSkuInfo = new QLiveData();
        this.skuRequestInfo = new QLiveData();
        this.productTitle = new QLiveData();
        this.resetSku = new QLiveData();
    }

    public final a getActionContext() {
        return this.actionContext;
    }

    public final CommentParams getCommentParams() {
        return this.commentParams;
    }

    public final Function1<String, Unit> getCommentTitleChangeCB() {
        return this.commentTitleChangeCB;
    }

    public final Function1<Map<String, String>, Unit> getConfirmSkuCallBack() {
        return this.confirmSkuCallBack;
    }

    public final Function0<Unit> getDialogDissmissCallBack() {
        return this.dialogDissmissCallBack;
    }

    public final QLiveData<Map<String, String>> getPreSkuInfo() {
        return this.preSkuInfo;
    }

    public final QLiveData<String> getProductTitle() {
        return this.productTitle;
    }

    public final QLiveData<Boolean> getResetSku() {
        return this.resetSku;
    }

    public final QLiveData<List<PromotionProductSkuStruct>> getSkuInfo() {
        return this.skuInfo;
    }

    public final QLiveData<Map<String, String>> getSkuRequestInfo() {
        return this.skuRequestInfo;
    }

    public final void setActionContext(a r100) {
        this.actionContext = r100;
    }

    public final void setCommentTitleChangeCB(Function1<? super String, Unit> r100) {
        this.commentTitleChangeCB = r100;
    }

    public final void setConfirmSkuCallBack(Function1<? super Map<String, String>, Unit> r100) {
        this.confirmSkuCallBack = r100;
    }

    public final void setDialogDissmissCallBack(Function0<Unit> r100) {
        this.dialogDissmissCallBack = r100;
    }

    public final void initParams(List<PromotionProductSkuStruct> r100, Map<String, String> r101, String r102, Function1<? super String, Unit> r103, Function1<? super Map<String, String>, Unit> r104, Function0<Unit> r105, CommentParams r106, a r107) {
        Intrinsics.checkNotNullParameter(r101, "preSelectSkuInfo");
        Intrinsics.checkNotNullParameter(r105, "dialogDismissCB");
        QLiveData<List<PromotionProductSkuStruct>> r108 = this.skuInfo;
        if (r108 == null) goto L5;
        r108.e(r100);
    L5:
        this.preSkuInfo.e(r101);
        QLiveData<String> r109 = this.productTitle;
        if (r109 == null) goto L8;
        r109.e(r102);
    L8:
        this.skuRequestInfo.e(r101);
        this.commentParams = r106;
        this.commentTitleChangeCB = r103;
        this.confirmSkuCallBack = r104;
        this.dialogDissmissCallBack = r105;
        this.actionContext = r107;
    }
}

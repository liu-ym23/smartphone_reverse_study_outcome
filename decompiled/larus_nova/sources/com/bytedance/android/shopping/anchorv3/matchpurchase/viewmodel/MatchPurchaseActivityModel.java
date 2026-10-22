package com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.AllCombinationStruct;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.anchorv3.matchpurchase.MatchPurchaseHelper;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchasePageComponentDTO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.MatchPurchaseParams;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.ShopBrandVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.ShopComponent;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/viewmodel/MatchPurchaseActivityModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "getMatchPurchasePageInfo", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "params", "initData", "Lr63/a;", "repository", "Lr63/a;", "getRepository", "()Lr63/a;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/ShopBrandVO;", "shopBrandVO", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getShopBrandVO", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setShopBrandVO", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "", "pageCount", "getPageCount", "", "pageClosed", "getPageClosed", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "getParams", "()Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;", "setParams", "(Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseParams;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseActivityModel extends BaseViewModel {
    private final QLiveData<Boolean> pageClosed;
    private final QLiveData<Integer> pageCount;
    private MatchPurchaseParams params;
    private final r63.a repository;
    private QLiveData<ShopBrandVO> shopBrandVO;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchPurchaseActivityModel f165249a;

        public a(MatchPurchaseActivityModel r100) {
            this.f165249a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            MatchPurchasePageComponentDTO r111 = (MatchPurchasePageComponentDTO) r110;
            d r100 = i.f47987a.get(MatchPurchaseHelper.f165132a);
            if (r100 == null) goto L5;
            r100.a("request_end");
        L5:
            this.f165249a.getPageCount().g(Integer.valueOf(this.f165249a.getRepository().getPageCount()));
            QLiveData<ShopBrandVO> r101 = this.f165249a.getShopBrandVO();
            Object r102 = null;
            if (r111 == null) goto L22;
            ShopComponent r112 = r111.getShopComponent();
            if (r112 == null) goto L22;
            ECUrlModel r103 = r112.getTitleIcon();
            String r104 = r112.getTitle();
            AllCombinationStruct r105 = r112.getAllCombinationStruct();
            if (r105 == null) goto L13;
            ECUrlModel r106 = r105.getArrowIcon();
        L14:
            AllCombinationStruct r107 = r112.getAllCombinationStruct();
            if (r107 == null) goto L17;
            String r108 = r107.getText();
        L18:
            AllCombinationStruct r113 = r112.getAllCombinationStruct();
            if (r113 == null) goto L21;
            r102 = r113.getUrl();
        L21:
            r102 = new ShopBrandVO(r103, r104, r106, r108, r102);
            goto L22
        L17:
            r108 = null;
            goto L18
        L13:
            r106 = null;
        L22:
            r101.g(r102);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f165250a = null;

        static {
            f165250a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.c(String.valueOf(((Throwable) r100).getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MatchPurchaseActivityModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.repository = r63.b.f536329b;
        this.shopBrandVO = new QLiveData();
        this.pageCount = new QLiveData();
        this.pageClosed = new QLiveData();
        this.params = new MatchPurchaseParams("", null, "", 0, 0, null, null, null, null, null, null, null, null, null, null, false, false, null, null, 524272, null);
    }

    private final void getMatchPurchasePageInfo() {
        d r100 = i.f47987a.get(MatchPurchaseHelper.f165132a);
        if (r100 == null) goto L5;
        r100.a("request_start");
    L5:
        bg4.b.b(this.repository.b(this.params, 0)).subscribe(new a(this), b.f165250a);
    }

    public final QLiveData<Boolean> getPageClosed() {
        return this.pageClosed;
    }

    public final QLiveData<Integer> getPageCount() {
        return this.pageCount;
    }

    public final MatchPurchaseParams getParams() {
        return this.params;
    }

    public final r63.a getRepository() {
        return this.repository;
    }

    public final QLiveData<ShopBrandVO> getShopBrandVO() {
        return this.shopBrandVO;
    }

    public final void initData(MatchPurchaseParams r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.params = r100;
        getMatchPurchasePageInfo();
    }

    public final void setParams(MatchPurchaseParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setShopBrandVO(QLiveData<ShopBrandVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shopBrandVO = r100;
    }
}

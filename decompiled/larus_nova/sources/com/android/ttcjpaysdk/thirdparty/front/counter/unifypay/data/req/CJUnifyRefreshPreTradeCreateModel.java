package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.CJUnifyTradeCreateScene;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateModel;", "", "reqParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq;", "isSilentReload", "", "forceHomePageUI", "needStartVerify", "isRetry", "scene", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyTradeCreateScene;", "targetState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq;ZZZZLcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyTradeCreateScene;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;)V", "getForceHomePageUI", "()Z", "setRetry", "(Z)V", "getNeedStartVerify", "getReqParams", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq;", "getScene", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyTradeCreateScene;", "setScene", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyTradeCreateScene;)V", "getTargetState", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "setTargetState", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;)V", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyRefreshPreTradeCreateModel {
    private final boolean forceHomePageUI;
    private boolean isRetry;
    private final boolean isSilentReload;
    private final boolean needStartVerify;
    private final CJUnifyRefreshPreTradeCreateReq reqParams;
    private CJUnifyTradeCreateScene scene;
    private UnifyPayHomepageState targetState;

    public final boolean getForceHomePageUI() {
        return this.forceHomePageUI;
    }

    public final boolean getNeedStartVerify() {
        return this.needStartVerify;
    }

    public final CJUnifyRefreshPreTradeCreateReq getReqParams() {
        return this.reqParams;
    }

    public final CJUnifyTradeCreateScene getScene() {
        return this.scene;
    }

    public final UnifyPayHomepageState getTargetState() {
        return this.targetState;
    }

    public final boolean isRetry() {
        return this.isRetry;
    }

    public final boolean isSilentReload() {
        return this.isSilentReload;
    }

    public final void setRetry(boolean r100) {
        this.isRetry = r100;
    }

    public final void setScene(CJUnifyTradeCreateScene r100) {
        this.scene = r100;
    }

    public final void setTargetState(UnifyPayHomepageState r100) {
        this.targetState = r100;
    }

    public CJUnifyRefreshPreTradeCreateModel(CJUnifyRefreshPreTradeCreateReq r100, boolean r101, boolean r102, boolean r103, boolean r104, CJUnifyTradeCreateScene r105, UnifyPayHomepageState r106) {
        Intrinsics.checkNotNullParameter(r100, "reqParams");
        this.reqParams = r100;
        this.isSilentReload = r101;
        this.forceHomePageUI = r102;
        this.needStartVerify = r103;
        this.isRetry = r104;
        this.scene = r105;
        this.targetState = r106;
    }

    public /* synthetic */ CJUnifyRefreshPreTradeCreateModel(CJUnifyRefreshPreTradeCreateReq r100, boolean r101, boolean r110, boolean r111, boolean r112, CJUnifyTradeCreateScene r113, UnifyPayHomepageState r114, int r115, DefaultConstructorMarker r116) {
        boolean r102 = false;
        if ((r115 & 2) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r115 & 4) == 0) goto L9;
        boolean r104 = true;
    L11:
        if ((r115 & 8) == 0) goto L13;
        boolean r105 = false;
    L15:
        if ((r115 & 16) != 0) goto L18;
        r102 = r112;
    L18:
        UnifyPayHomepageState r106 = null;
        if ((r115 & 32) == 0) goto L21;
        CJUnifyTradeCreateScene r107 = null;
    L23:
        if ((r115 & 64) != 0) goto L26;
        r106 = r114;
    L26:
        this(r100, r103, r104, r105, r102, r107, r106);
        return;
    L21:
        r107 = r113;
        goto L23
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}

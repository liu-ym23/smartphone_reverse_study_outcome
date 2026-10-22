package com.android.ttcjpaysdk.thirdparty.payagain.proxy;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/proxy/PayAgainBaseProxy;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "proxyCallback", "Lcom/android/ttcjpaysdk/thirdparty/payagain/proxy/PayAgainBaseProxy$ProxyCallback;", "getProxyCallback", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/proxy/PayAgainBaseProxy$ProxyCallback;", "setProxyCallback", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/proxy/PayAgainBaseProxy$ProxyCallback;)V", "ProxyCallback", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PayAgainBaseProxy {
    private FragmentActivity activity;
    private ProxyCallback proxyCallback;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JN\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&J2\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0013H&J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H&J$\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0013H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0007H&J\u001e\u0010&\u001a\u00020\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010(\u001a\u00020\u0013H&J(\u0010)\u001a\u00020\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u0013H&J\u0012\u0010*\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u0013H&¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/proxy/PayAgainBaseProxy$ProxyCallback;", "", "closeAllIfNecessary", "", "getErrorDialogClickListener", "Landroid/view/View$OnClickListener;", "action", "", "dialog", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "jumpUrl", "", "appId", "merchantId", "onErrorDialogBtnClick", "hideFullLoading", "isShowMask", "", "isDoAnim", "hideLoading", "isBindNewCardForPay", "code", "hideLoadingForMethodPage", "isFrontMethod", "isHitLoadingUniform", "isDialogLoading", "onBindCardPayResult", "result", "checkList", "params", "Lorg/json/JSONObject;", "setIsQueryConnecting", "isQueryConnecting", "setPayAgainGuideLoading", "isShow", "loadingType", "showFullLoading", "payMessage", "isPayScene", DyPayConstant.KEY_SHOW_LOADING, "showLoadingForMethodPage", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ProxyCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void showLoadingForMethodPage$default(ProxyCallback r100, boolean r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = true;
            L6:
                r100.showLoadingForMethodPage(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingForMethodPage");
            }

            public static /* synthetic */ void hideFullLoading$default(ProxyCallback r100, boolean r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = true;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = false;
            L9:
                r100.hideFullLoading(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideFullLoading");
            }

            public static /* synthetic */ void showFullLoading$default(ProxyCallback r100, String r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = "";
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = true;
            L9:
                r100.showFullLoading(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFullLoading");
            }

            public static /* synthetic */ void showLoading$default(ProxyCallback r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
                if (r105 != null) goto L15;
                if ((r104 & 1) == 0) goto L7;
                r101 = "";
            L7:
                if ((r104 & 2) == 0) goto L10;
                r102 = false;
            L10:
                if ((r104 & 4) == 0) goto L12;
                r103 = true;
            L12:
                r100.showLoading(r101, r102, r103);
                return;
            L15:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
            }

            public static /* synthetic */ void hideLoading$default(ProxyCallback r100, boolean r101, boolean r102, boolean r103, String r104, int r105, Object r106) {
                if (r106 != null) goto L18;
                if ((r105 & 1) == 0) goto L7;
                r101 = true;
            L7:
                if ((r105 & 2) == 0) goto L10;
                r102 = false;
            L10:
                if ((r105 & 4) == 0) goto L13;
                r103 = false;
            L13:
                if ((r105 & 8) == 0) goto L15;
                r104 = null;
            L15:
                r100.hideLoading(r101, r102, r103, r104);
                return;
            L18:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideLoading");
            }
        }

        void closeAllIfNecessary();

        View.OnClickListener getErrorDialogClickListener(int r100, Dialog r101, Activity r102, String r103, String r104, String r105, View.OnClickListener r106);

        void hideFullLoading(boolean r100, boolean r101);

        void hideLoading(boolean r100, boolean r101, boolean r102, String r103);

        void hideLoadingForMethodPage();

        boolean isFrontMethod();

        boolean isHitLoadingUniform(boolean r100);

        void onBindCardPayResult(String r100, String r101, JSONObject r102);

        void setIsQueryConnecting(boolean r100);

        void setPayAgainGuideLoading(boolean r100, int r101);

        void showFullLoading(String r100, boolean r101);

        void showLoading(String r100, boolean r101, boolean r102);

        void showLoadingForMethodPage(boolean r100);
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final ProxyCallback getProxyCallback() {
        return this.proxyCallback;
    }

    public PayAgainBaseProxy(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.activity = r100;
    }

    public final void setActivity(FragmentActivity r100) {
        this.activity = r100;
    }

    public final void setProxyCallback(ProxyCallback r100) {
        this.proxyCallback = r100;
    }
}

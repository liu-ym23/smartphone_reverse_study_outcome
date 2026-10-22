package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.wrapper;

import android.content.res.Configuration;
import android.os.Bundle;
import com.android.ttcjpaysdk.thirdparty.base.CJBaseBusinessWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.result.fragment.CJPayCompleteFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&JF\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0004H&¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/wrapper/IDyPayCoreWrapper;", "Lcom/android/ttcjpaysdk/thirdparty/base/CJBaseBusinessWrapper;", "Lcom/android/ttcjpaysdk/thirdparty/counter/result/fragment/CJPayCompleteFragment$OnFragmentListener;", WidgetCostModule.TYPE_ON_CREATE, "", "isAgain", "", "savedInstanceState", "Landroid/os/Bundle;", "onPayResult", "delayTime", "", "code", "", "callBackInfo", "", "", "isIgnore", "isForceClose", "onResume", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDyPayCoreWrapper extends CJBaseBusinessWrapper, CJPayCompleteFragment.OnFragmentListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDisableBack(IDyPayCoreWrapper r100) {
            return CJBaseBusinessWrapper.DefaultImpls.isDisableBack(r100);
        }

        public static void onConfigurationChanged(IDyPayCoreWrapper r100, Configuration r101) {
            Intrinsics.checkNotNullParameter(r101, "newConfig");
            CJBaseBusinessWrapper.DefaultImpls.onConfigurationChanged(r100, r101);
        }

        public static /* synthetic */ void onCreate$default(IDyPayCoreWrapper r100, boolean r101, Bundle r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = false;
        L7:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.onCreate(r101, r102);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreate");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onPayResult$default(IDyPayCoreWrapper r100, long r101, int r110, Map r111, boolean r112, boolean r113, int r114, Object r115) {
            if (r115 != null) goto L20;
            if ((r114 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            long r102 = r101;
            if ((r114 & 4) == 0) goto L9;
            r111 = null;
        L9:
            Map r103 = r111;
            if ((r114 & 8) == 0) goto L12;
            boolean r104 = false;
        L14:
            if ((r114 & 16) == 0) goto L16;
            boolean r105 = false;
        L17:
            r100.onPayResult(r102, r110, r103, r104, r105);
            return;
        L16:
            r105 = r113;
            goto L17
        L12:
            r104 = r112;
            goto L14
        L20:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPayResult");
        }
    }

    void onCreate(boolean r100, Bundle r101);

    void onPayResult(long r100, int r101, Map<String, String> r102, boolean r103, boolean r104);

    void onResume();
}

package com.android.ttcjpaysdk.integrated.counter;

import android.content.Context;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.Utils.PaymentUIUtils;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.IntegratedCounterResponseData;
import com.android.ttcjpaysdk.thirdparty.data.CashDeskShowConf;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayUIStyleUtils;", "", "()V", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUIStyleUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J:\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015J*\u0010\u001c\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayUIStyleUtils$Companion;", "", "()V", "isFullScreenResultStyle", "", "isFullScreenStyle", "isGResultStyle", "isGStyle", "isIESResultStyle", "isIESStyle", "isNewDyPayStyle", "isQueryOnlyWithoutUI", "setHollowLabel", "", "view", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "maxCorner", "", "height", "", "updateLabel", "textColor", "", "strokeColor", "bgColor", "corner", "updateLabelStyle", "isEnable", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final boolean isGResultStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.result_page_show_style != 2) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        private final boolean isIESResultStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.result_page_show_style != 3) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        public final boolean isFullScreenResultStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.result_page_show_style != 1) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        public final boolean isFullScreenStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.show_style != 1) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        public final boolean isGStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.show_style != 2) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        public final boolean isIESStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L12;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L13;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.show_style != 3) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        public final boolean isNewDyPayStyle() {
            CounterResponseBean r100 = ShareData.checkoutResponseBean;
            if (r100 == null) goto L11;
            IntegratedCounterResponseData r101 = r100.data;
            if (r101 == null) goto L11;
            CashDeskShowConf r102 = r101.cashdesk_show_conf;
            if (r102 == null) goto L11;
            if (r102.show_style != 6) goto L11;
            boolean r103 = true;
        L12:
            if (r103 == true) goto L26;
            if (r100 == null) goto L21;
            IntegratedCounterResponseData r104 = r100.data;
            if (r104 == null) goto L21;
            CashDeskShowConf r105 = r104.cashdesk_show_conf;
            if (r105 == null) goto L21;
            if (r105.show_style != 7) goto L21;
            boolean r106 = true;
        L22:
            if (r106 == true) goto L27;
            return false;
        L27:
            return true;
        L21:
            r106 = false;
            goto L22
        L26:
            return true;
        L11:
            r103 = false;
            goto L12
        }

        public final boolean isQueryOnlyWithoutUI() {
            String r100 = ShareData.getSelectMethod();
            if (r100 == null) goto L29;
            CounterResponseBean r101 = ShareData.checkoutResponseBean;
            if (r101 == null) goto L29;
            if (r101.data.cashdesk_show_conf == null) goto L29;
            if (Intrinsics.areEqual(r100, "wx") == true) goto L16;
            if (Intrinsics.areEqual(r100, "alipay") == true) goto L16;
            if (Intrinsics.areEqual(r100, "dypay") == true) goto L16;
        L23:
            if (Intrinsics.areEqual(r100, "qrcode") == true) goto L25;
        L27:
            return false;
        L25:
            if (isGResultStyle() == false) goto L27;
            return true;
        L16:
            if (isGResultStyle() == false) goto L18;
        L28:
            return true;
        L18:
            if (isIESResultStyle() == true) goto L28;
            if (ShareData.checkoutResponseBean.data.cashdesk_show_conf.remain_time_s != 0) goto L23;
        L29:
            return false;
        }

        public final void setHollowLabel(TextView r100, Context r101, int r102, float r103) {
            PaymentUIUtils.Companion.setHollowLabel(r100, r101, r102, r103);
        }

        public final void updateLabelStyle(TextView r100, Context r110, boolean r111, int r112) {
            PaymentUIUtils.Companion.updateLabelStyle$default(PaymentUIUtils.Companion, r100, r110, r111, r112, null, 16, null);
        }

        public final void updateLabel(TextView r100, Context r110, String r111, String r112, String r113, float r114) {
            Intrinsics.checkNotNullParameter(r111, "textColor");
            Intrinsics.checkNotNullParameter(r112, "strokeColor");
            Intrinsics.checkNotNullParameter(r113, "bgColor");
            PaymentUIUtils.Companion.updateLabel(r100, r110, r111, r112, r113, r114);
        }

        public static /* synthetic */ void setHollowLabel$default(Companion r100, TextView r101, Context r102, int r103, float r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L5;
            r104 = 16.0f;
        L5:
            r100.setHollowLabel(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayUIStyleUtils() {
    }
}

package com.android.ttcjpaysdk.base.ui.component;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ui.CJPaySquareToast;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJToast;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJToast {
    public static final Companion Companion = null;
    private static final String TAG = "CJPayStdToastComponent";
    private static long lastShowTime;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010H\u0002J[\u0010\u0014\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJToast$Companion;", "", "()V", "TAG", "", "lastShowTime", "", "isValidToastInfo", "", "msg", "subMsg", "iconType", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/Context;Ljava/util/Map;)Z", "reportToastEvent", "", "showToast", "styleType", "duration", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;I)Z", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean showToast(Context r110, String r111) {
            return showToast$default(this, r110, r111, null, null, null, 0, 60, null);
        }

        public final boolean showToast(Context r110, String r111, String r112) {
            return showToast$default(this, r110, r111, r112, null, null, 0, 56, null);
        }

        public final boolean showToast(Context r110, String r111, String r112, Integer r113) {
            return showToast$default(this, r110, r111, r112, r113, null, 0, 48, null);
        }

        public final boolean showToast(Context r110, String r111, String r112, Integer r113, Map<String, Object> r114) {
            return showToast$default(this, r110, r111, r112, r113, r114, 0, 32, null);
        }

        private final void reportToastEvent(String r100, String r101, Map<String, Object> r102) {
            if (r102 != null) goto L4;
            r102 = new LinkedHashMap();
        L4:
            Map<String, Object> r103 = r102;
            if (r100 != null) goto L7;
            r100 = "";
        L7:
            r103.put(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG, r100);
            if (r101 != null) goto L10;
            r101 = "";
        L10:
            r103.put("error_msg", r101);
            CJReporter.h(CJReporter.f202294a, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_cashier_toast", r103, null, 56);
        }

        private final boolean isValidToastInfo(String r100, String r101, Integer r110, Context r111, Map<String, Object> r112) {
            CJLogger.d(CJToast.TAG, "processConfirmResultInfo text:" + r100 + " sub_text:" + r101 + ' ');
            if (r111 == null) goto L29;
            if (r100 == null) goto L29;
            if (r100.length() != 0) goto L9;
            boolean r113 = true;
        L10:
            if (r113 == false) goto L12;
            return false;
        L12:
            if (r101 != null) goto L14;
        L17:
            boolean r114 = true;
        L18:
            if (r114 == false) goto L23;
            if (r110 != null) goto L21;
        L22:
            return false;
        L21:
            if (r110.intValue() < 0) goto L22;
        L23:
            long r115 = System.currentTimeMillis();
            if ((r115 - CJToast.access$getLastShowTime$cp()) >= 1000) goto L27;
            CJLogger.d(CJToast.TAG, "reportToastEvent duration is too short");
            return true;
        L27:
            CJToast.access$setLastShowTime$cp(r115);
            reportToastEvent(r100, r101, r112);
            return true;
        L14:
            if (r101.length() == 0) goto L17;
            r114 = false;
            goto L18
        L9:
            r113 = false;
        L29:
            return false;
        }

        public final boolean showToast(final Context r100, final String r101, final String r102, final Integer r110, Map<String, Object> r111, int r112) {
            CJLogger.d(CJToast.TAG, "showResultToast msg:" + r101 + " resultShowInfo:" + r101);
            boolean r103 = false;
            if (isValidToastInfo(r101, r102, r110, r100, r111) == false) goto L17;
            CJLoading.Companion r113 = CJLoading.Companion;
            Boolean r114 = r113.getInstance().isDialogLoadingViewShowing();
            if (r114 == null) goto L7;
            r103 = r114.booleanValue();
        L7:
            if (r103 == false) goto L14;
            CJLoading r104 = r113.getInstance();
            if (r110 == null) goto L11;
            int r115 = r110.intValue();
        L12:
            r104.updateDialogLoadingStatus(r101, r102, r115, true);
            return true;
        L11:
            r115 = CJPaySquareToast.SquareToastType.ERROR.getValue();
            goto L12
        L14:
            b.i(new CJToast$Companion$showToast$1(r100, r110, r101, r102));
            return true;
        L17:
            if (TextUtils.isEmpty(r101) == false) goto L19;
            return false;
        L19:
            if (r112 == Integer.MIN_VALUE) goto L21;
            CJPayBasicUtils.displayToast(r100, r101, r112);
        L22:
            return true;
        L21:
            CJPayBasicUtils.displayToastInternal(r100, r101, 0);
            goto L22
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean isValidToastInfo$default(Companion r100, String r101, String r102, Integer r103, Context r110, Map r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L6;
            r111 = null;
        L6:
            return r100.isValidToastInfo(r101, r102, r103, r110, r111);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean showToast$default(Companion r100, Context r110, String r111, String r112, Integer r113, Map r114, int r115, int r116, Object r117) {
            if ((r116 & 4) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r116 & 8) == 0) goto L9;
            Integer r102 = -1;
        L11:
            if ((r116 & 16) == 0) goto L13;
            Map r103 = null;
        L15:
            if ((r116 & 32) == 0) goto L17;
            int r104 = Integer.MIN_VALUE;
        L19:
            return r100.showToast(r110, r111, r101, r102, r103, r104);
        L17:
            r104 = r115;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJToast() {
    }

    public static final /* synthetic */ long access$getLastShowTime$cp() {
        return lastShowTime;
    }

    public static final /* synthetic */ void access$setLastShowTime$cp(long r100) {
        lastShowTime = r100;
    }
}

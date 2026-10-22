package com.android.ttcjpaysdk.base.service;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "", "onResult", "", "code", "", "msg", "data", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayIntegratedSignCallback {
    public static final String CODE_LYNX_PROCESSING = "6";
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR-\u0010\u000b\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR-\u0010\r\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback$Companion;", "", "()V", "CJ_PAY_DYPAY_CANCEL", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "getCJ_PAY_DYPAY_CANCEL", "()Landroid/util/Pair;", "CJ_PAY_DYPAY_FAILED", "getCJ_PAY_DYPAY_FAILED", "CJ_PAY_DYPAY_PROCESSING", "getCJ_PAY_DYPAY_PROCESSING", "CJ_PAY_DYPAY_SUCCESS", "getCJ_PAY_DYPAY_SUCCESS", "CODE_LYNX_PROCESSING", "getStandardResult", "code", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Pair<String, String> CJ_PAY_DYPAY_CANCEL = null;
        private static final Pair<String, String> CJ_PAY_DYPAY_FAILED = null;
        private static final Pair<String, String> CJ_PAY_DYPAY_PROCESSING = null;
        private static final Pair<String, String> CJ_PAY_DYPAY_SUCCESS = null;
        public static final String CODE_LYNX_PROCESSING = "6";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            CJ_PAY_DYPAY_SUCCESS = new Pair("0", "成功");
            CJ_PAY_DYPAY_CANCEL = new Pair("1", "取消");
            CJ_PAY_DYPAY_FAILED = new Pair("2", "失败");
            CJ_PAY_DYPAY_PROCESSING = new Pair("3", "处理中");
        }

        public final Pair<String, String> getCJ_PAY_DYPAY_CANCEL() {
            return CJ_PAY_DYPAY_CANCEL;
        }

        public final Pair<String, String> getCJ_PAY_DYPAY_FAILED() {
            return CJ_PAY_DYPAY_FAILED;
        }

        public final Pair<String, String> getCJ_PAY_DYPAY_PROCESSING() {
            return CJ_PAY_DYPAY_PROCESSING;
        }

        public final Pair<String, String> getCJ_PAY_DYPAY_SUCCESS() {
            return CJ_PAY_DYPAY_SUCCESS;
        }

        public final Pair<String, String> getStandardResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Pair<String, String> r101 = CJ_PAY_DYPAY_SUCCESS;
            if (Intrinsics.areEqual(r100, r101.first) == true) goto L16;
            Pair<String, String> r102 = CJ_PAY_DYPAY_CANCEL;
            if (Intrinsics.areEqual(r100, r102.first) == true) goto L17;
            Pair<String, String> r103 = CJ_PAY_DYPAY_FAILED;
            if (Intrinsics.areEqual(r100, r103.first) == true) goto L18;
            Pair<String, String> r104 = CJ_PAY_DYPAY_PROCESSING;
            if (Intrinsics.areEqual(r100, r104.first) == true) goto L14;
            return r103;
        L14:
            return r104;
        L18:
            return r103;
        L17:
            return r102;
        L16:
            return r101;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onResult(String r100, String r101, String r102);
}

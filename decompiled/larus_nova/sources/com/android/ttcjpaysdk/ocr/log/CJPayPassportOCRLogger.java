package com.android.ttcjpaysdk.ocr.log;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/log/CJPayPassportOCRLogger;", "Lcom/android/ttcjpaysdk/ocr/log/CJPayOCRMvpLogger;", "()V", "logPassportOCRClick", "", "buttonName", "", "logPassportOCRImp", "logPassportOCRUploadClick", "type", "result", "errReason", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPassportOCRLogger implements CJPayOCRMvpLogger {
    public static final Companion Companion = null;
    public static final String WALLET_IDENTIFIED_VERIFICATION_CLICK = "wallet_identified_verification_click";
    public static final String WALLET_IDENTIFIED_VERIFICATION_IMP = "wallet_identified_verification_imp";
    public static final String WALLET_IDENTIFIED_VERIFICATION_SUBMIT = "wallet_identified_verification_submit";
    public static final String WALLET_IDENTIFIED_VERIFICATION_UPLOAD_CLICK = "wallet_identified_verification_upload_click";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/log/CJPayPassportOCRLogger$Companion;", "", "()V", "WALLET_IDENTIFIED_VERIFICATION_CLICK", "", "WALLET_IDENTIFIED_VERIFICATION_IMP", "WALLET_IDENTIFIED_VERIFICATION_SUBMIT", "WALLET_IDENTIFIED_VERIFICATION_UPLOAD_CLICK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayPassportOCRLogger() {
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public JSONObject getCommonUploadParams() {
        return CJPayOCRMvpLogger.DefaultImpls.getCommonUploadParams(this);
    }

    public final void logPassportOCRImp() {
        JSONObject r100 = getCommonUploadParams();
        KtSafeMethodExtensionKt.safePut(r100, "upload_type", "passport");
        CJPayCallBackCenter.getInstance().onEvent("wallet_identified_verification_imp", new JSONObject[]{r100});
    }

    public final void logPassportOCRClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        JSONObject r101 = getCommonUploadParams();
        KtSafeMethodExtensionKt.safePut(r101, "upload_type", "passport");
        KtSafeMethodExtensionKt.safePut(r101, "type", r100);
        CJPayCallBackCenter.getInstance().onEvent("wallet_identified_verification_click", new JSONObject[]{r101});
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void logOcrRetry(int r100, String r101) {
        CJPayOCRMvpLogger.DefaultImpls.logOcrRetry(this, r100, r101);
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void mergeParams(JSONObject r100, JSONObject r101) {
        CJPayOCRMvpLogger.DefaultImpls.mergeParams(this, r100, r101);
    }

    public final void logPassportOCRUploadClick(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "result");
        JSONObject r103 = getCommonUploadParams();
        KtSafeMethodExtensionKt.safePut(r103, "upload_type", "passport");
        KtSafeMethodExtensionKt.safePut(r103, "type", r100);
        KtSafeMethodExtensionKt.safePut(r103, "result", r101);
        KtSafeMethodExtensionKt.safePut(r103, "err_reason", r102);
        CJPayCallBackCenter.getInstance().onEvent("wallet_identified_verification_upload_click", new JSONObject[]{r103});
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void monitorLog(String r100, String r101, String r102, String r103, String r104) {
        CJPayOCRMvpLogger.DefaultImpls.monitorLog(this, r100, r101, r102, r103, r104);
    }
}

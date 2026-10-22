package com.android.ttcjpaysdk.ocr.log;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.data.OnceOCRResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004JL\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000eJ*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u0004¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/ocr/log/CJPayBankOCRLogger;", "Lcom/android/ttcjpaysdk/ocr/log/CJPayOCRMvpLogger;", "()V", "uploadOcrAuthPageClick", "", "permissionStr", "", "uploadOcrAuthPageImp", "uploadOcrScanningPageImp", "uploadOcrScanningResult", "result", "stayTime", "", "cardInputType", "", "errorCode", "errorMsg", "requestCount", "callbackCount", "numLength", "walletAddbcardOrcScanningFailPopClick", "buttonName", "walletAddbcardOrcScanningFailPopImp", "walletAddbcardOrcScanningPageClick", "walletAddbcardOrcScanningPageTitleImp", "title", "walletAddbcardOrcScanningPhotoBack", "isChoose", "walletAddbcardOrcScanningSingleResult", "onceOCRResult", "Lcom/android/ttcjpaysdk/ocr/data/OnceOCRResult;", "walletAddbcardOrcScanningStart", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBankOCRLogger implements CJPayOCRMvpLogger {
    public CJPayBankOCRLogger() {
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public JSONObject getCommonUploadParams() {
        return CJPayOCRMvpLogger.DefaultImpls.getCommonUploadParams(this);
    }

    public final void uploadOcrAuthPageImp() {
        JSONObject r100 = getCommonUploadParams();
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orcauth_page_imp", new JSONObject[]{r100});
    }

    public final void uploadOcrScanningPageImp() {
        JSONObject r100 = getCommonUploadParams();
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_page_jmp", new JSONObject[]{r100});
    }

    public final void walletAddbcardOrcScanningStart() {
        JSONObject r100 = getCommonUploadParams();
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_start", new JSONObject[]{r100});
    }

    public final void uploadOcrAuthPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionStr");
        JSONObject r101 = getCommonUploadParams();
        r101.put("button_name", r100);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orcauth_page_click", new JSONObject[]{r101});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#uploadOcrAuthPageClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#uploadOcrAuthPageClick", e);
        goto L7
    }

    public final void walletAddbcardOrcScanningPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        JSONObject r101 = getCommonUploadParams();
        r101.put("button_name", r100);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_page_click", new JSONObject[]{r101});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningPageClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningPageClick", e);
        goto L7
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void logOcrRetry(int r100, String r101) {
        CJPayOCRMvpLogger.DefaultImpls.logOcrRetry(this, r100, r101);
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void mergeParams(JSONObject r100, JSONObject r101) {
        CJPayOCRMvpLogger.DefaultImpls.mergeParams(this, r100, r101);
    }

    public final void walletAddbcardOrcScanningPhotoBack(long r100, int r101) {
        JSONObject r102 = getCommonUploadParams();
        r102.put("stay_time", r100);     // Catch: Exception -> L5
        r102.put("is_choose", r101);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_photo_back", new JSONObject[]{r102});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningPhotoBack", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningPhotoBack", e);
        goto L7
    }

    public final void walletAddbcardOrcScanningSingleResult(OnceOCRResult r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "onceOCRResult");
        JSONObject r102 = getCommonUploadParams();
        r102.put("result", r100.getResult());     // Catch: Exception -> L5
        r102.put("error_code", r100.getCode());     // Catch: Exception -> L5
        r102.put("error_message", r100.getMsg());     // Catch: Exception -> L5
        r102.put("card_input_type", r100.getCardInputType());     // Catch: Exception -> L5
        r102.put("single_time", r100.getSingleTime());     // Catch: Exception -> L5
        r102.put("image_size", r100.getImageSize());     // Catch: Exception -> L5
        r102.put("stay_time", r100.getStayTime());     // Catch: Exception -> L5
        r102.put("num_length", r101);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_single_result", new JSONObject[]{r102});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningSingleResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningSingleResult", e);
        goto L7
    }

    public final void walletAddbcardOrcScanningFailPopImp(int r100, String r101, String r102) {
        JSONObject r103 = getCommonUploadParams();
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        r104.put("card_input_type", r100);     // Catch: Exception -> L12
        r104.put("page_from", "银行卡ocr");     // Catch: Exception -> L12
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r104.put("error_code", r101);     // Catch: Exception -> L12
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r104.put("error_message", r102);     // Catch: Exception -> L12
        mergeParams(r104, r103);     // Catch: Exception -> L12
    L14:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_fail_pop_imp", new JSONObject[]{r103});
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningFailPopImp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningFailPopImp", e);
        goto L14
    }

    public final void walletAddbcardOrcScanningPageTitleImp(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        JSONObject r103 = getCommonUploadParams();
        r103.put("title", r100);     // Catch: Exception -> L5
        r103.put("error_code", r101);     // Catch: Exception -> L5
        r103.put("error_msg", r102);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_page_title_imp", new JSONObject[]{r103});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningPageTitleImp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningPageTitleImp", e);
        goto L7
    }

    public final void walletAddbcardOrcScanningFailPopClick(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        JSONObject r104 = getCommonUploadParams();
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L12
        r105.put("card_input_type", r101);     // Catch: Exception -> L12
        r105.put("button_name", r100);     // Catch: Exception -> L12
        r105.put("page_from", "银行卡ocr");     // Catch: Exception -> L12
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r105.put("error_code", r102);     // Catch: Exception -> L12
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r105.put("error_message", r103);     // Catch: Exception -> L12
        mergeParams(r105, r104);     // Catch: Exception -> L12
    L14:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_fail_pop_click", new JSONObject[]{r104});
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#walletAddbcardOrcScanningFailPopClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#walletAddbcardOrcScanningFailPopClick", e);
        goto L14
    }

    public static /* synthetic */ void walletAddbcardOrcScanningSingleResult$default(CJPayBankOCRLogger r100, OnceOCRResult r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.walletAddbcardOrcScanningSingleResult(r101, r102);
    }

    @Override // com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger
    public void monitorLog(String r100, String r101, String r102, String r103, String r104) {
        CJPayOCRMvpLogger.DefaultImpls.monitorLog(this, r100, r101, r102, r103, r104);
    }

    public final void uploadOcrScanningResult(String r100, long r101, int r102, String r103, String r104, int r105, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "result");
        JSONObject r106 = getCommonUploadParams();
        r106.put("result", r100);     // Catch: Exception -> L12
        r106.put("card_input_type", r102);     // Catch: Exception -> L12
        r106.put("stay_time", r101);     // Catch: Exception -> L12
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r106.put("error_code", r103);     // Catch: Exception -> L12
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r106.put("error_message", r104);     // Catch: Exception -> L12
        r106.put("request_count", r105);     // Catch: Exception -> L12
        r106.put("callback_count", r110);     // Catch: Exception -> L12
        r106.put("num_length", r111);     // Catch: Exception -> L12
    L14:
        CJPayCallBackCenter.getInstance().onEvent("wallet_addbcard_orc_scanning_result", new JSONObject[]{r106});
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBankOCRLogger#uploadOcrScanningResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBankOCRLogger#uploadOcrScanningResult", e);
        goto L14
    }

    public static /* synthetic */ void uploadOcrScanningResult$default(CJPayBankOCRLogger r110, String r111, long r112, int r113, String r114, String r115, int r116, int r117, int r210, int r211, Object r212) {
        if ((r211 & 128) == 0) goto L5;
        int r118 = 0;
    L6:
        r110.uploadOcrScanningResult(r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L5:
        r118 = r210;
        goto L6
    }
}

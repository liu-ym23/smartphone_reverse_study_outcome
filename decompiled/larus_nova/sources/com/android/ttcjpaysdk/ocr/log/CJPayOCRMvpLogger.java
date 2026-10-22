package com.android.ttcjpaysdk.ocr.log;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.ocr.OCRService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J8\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/log/CJPayOCRMvpLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "getCommonUploadParams", "Lorg/json/JSONObject;", "logOcrRetry", "", "result", "", "scene", "", "mergeParams", "src", "dst", "monitorLog", "tag", "methodName", "errorCode", "errorMessage", "ext", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayOCRMvpLogger extends MvpLogger {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static JSONObject getCommonUploadParams(CJPayOCRMvpLogger r100) {
            CJPayHostInfo r101 = OCRService.hostInfo;
            String r102 = "";
            if (r101 == null) goto L5;
            String r103 = r101.merchantId;
        L6:
            if (r101 == null) goto L8;
            r102 = r101.appId;
        L8:
            JSONObject r104 = CJPayParamsUtils.getCommonLogParams(r103, r102);
            JSONObject r105 = new JSONObject(OCRDevice.getInstance().getParams());     // Catch: Exception -> L14
            Iterator<String> r106 = r105.keys();     // Catch: Exception -> L14
        L11:
            if (r106.hasNext() == false) goto L16;
            String r107 = r106.next();     // Catch: Exception -> L14
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L14
            String r108 = r107;     // Catch: Exception -> L14
            r104.put(r108, JSONObjectProtectorUtils.getString(r105, r108));     // Catch: Exception -> L14
        L16:
            return r104;
        L14:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayOCRMvpLogger#getCommonUploadParams", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRMvpLogger#getCommonUploadParams", e);
            goto L16
        L5:
            r103 = "";
            goto L6
        }

        public static void logOcrRetry(CJPayOCRMvpLogger r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "scene");
            JSONObject r103 = r100.getCommonUploadParams();
            KtSafeMethodExtensionKt.safePut(r103, "scene", r102);
            KtSafeMethodExtensionKt.safePut(r103, "result", Integer.valueOf(r101));
            CJPayCallBackCenter.getInstance().onEvent("wallet_rd_ocr_retry_result", new JSONObject[]{r103});
        }

        public static void mergeParams(CJPayOCRMvpLogger r100, JSONObject r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "src");
            Intrinsics.checkNotNullParameter(r102, "dst");
            Iterator<String> r103 = r101.keys();     // Catch: Exception -> L8
        L5:
            if (r103.hasNext() == false) goto L15;
            String r104 = r103.next();     // Catch: Exception -> L8
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L8
            String r105 = r104;     // Catch: Exception -> L8
            r102.put(r105, r101.optString(r105));     // Catch: Exception -> L8
            goto L5
        L15:
            return;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayOCRMvpLogger#mergeParams", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRMvpLogger#mergeParams", e);
        }

        public static /* synthetic */ void logOcrRetry$default(CJPayOCRMvpLogger r100, int r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = "";
        L6:
            r100.logOcrRetry(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logOcrRetry");
        }

        public static void monitorLog(CJPayOCRMvpLogger r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "methodName");
            JSONObject r106 = new JSONObject();     // Catch: Exception -> L15
            r106.put("tag", r101);     // Catch: Exception -> L15
            r106.put("method_name", r102);     // Catch: Exception -> L15
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r106.put("error_code", r103);     // Catch: Exception -> L15
            if (r104 != null) goto L10;
            r104 = "";
        L10:
            r106.put("error_msg", r104);     // Catch: Exception -> L15
            if (r105 != null) goto L13;
            r105 = "";
        L13:
            r106.put("ext", r105);     // Catch: Exception -> L15
            CJLogger.d("monitor", "serviceName: wallet_rd_exception_log, params: " + r106);     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayOCRMvpLogger#monitorLog", e);
        }

        public static /* synthetic */ void monitorLog$default(CJPayOCRMvpLogger r100, String r101, String r102, String r103, String r110, String r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L6;
            r111 = "";
        L6:
            r100.monitorLog(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorLog");
        }
    }

    JSONObject getCommonUploadParams();

    void logOcrRetry(int r100, String r101);

    void mergeParams(JSONObject r100, JSONObject r101);

    void monitorLog(String r100, String r101, String r102, String r103, String r104);
}

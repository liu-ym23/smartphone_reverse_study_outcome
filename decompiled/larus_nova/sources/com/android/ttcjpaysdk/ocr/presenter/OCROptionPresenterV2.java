package com.android.ttcjpaysdk.ocr.presenter;

import android.util.Base64;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/presenter/OCROptionPresenterV2;", "Lcom/android/ttcjpaysdk/ocr/presenter/CJPayBasePresenter;", "()V", "fetchOCRResult", "", "data", "", "idType", "", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayCallback;", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCROptionPresenterV2 extends CJPayBasePresenter {
    public static final Companion Companion = null;
    public static final String DEFAULT_OCR_API = "bytepay.member_product.ocr_recognize_all_text";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/presenter/OCROptionPresenterV2$Companion;", "", "()V", "DEFAULT_OCR_API", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OCROptionPresenterV2() {
    }

    public final void fetchOCRResult(byte[] r100, String r101, ICJPayCallback r102) {
        JSONObject r103 = new JSONObject();
        String r104 = "";
        if (r101 != null) goto L22;
        r101 = "";
    L22:
        r103.put("type", r101);     // Catch: Throwable -> L19
        String r105 = OCRDevice.getInstance().getRiskInfo();     // Catch: Throwable -> L19
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        r103.put(DyVerifyReqConstants.Key.RISK_INFO, r104);     // Catch: Throwable -> L19
        JSONObject r106 = OCRDevice.getInstance().getExtParams();     // Catch: Throwable -> L19
        if (r106 == null) goto L17;
        Iterator<Map.Entry<String, String>> r107 = KtSafeMethodExtensionKt.toMap(r106).entrySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r107.hasNext() == false) goto L17;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Throwable -> L19
        r103.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L19
    L17:
        r103.put("img_data", Base64.encodeToString(r100, 2));     // Catch: Throwable -> L19
        sendRequest(r102, r103, DEFAULT_OCR_API);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("OCROptionPresenterV2#fetchOCRResult", th);
        CJBasicCommonUtils.logCatch("CJCatch", "OCROptionPresenterV2#fetchOCRResult", th);
    }
}

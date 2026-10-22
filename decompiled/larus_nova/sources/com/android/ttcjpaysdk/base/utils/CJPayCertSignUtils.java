package com.android.ttcjpaysdk.base.utils;

import com.android.ttcjpaysdk.base.service.CertSignParams;
import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import com.bytedance.caijing.sdk.infra.base.encrypt.CJEncrypt;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayCertSignUtils;", "", "()V", "TAG", "", "getCertData", "Lcom/android/ttcjpaysdk/base/service/CertSignParams;", "ext", "needCertSign", "", "curVerifyProduct", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCertSignUtils {
    public static final CJPayCertSignUtils INSTANCE = null;
    private static final String TAG = null;

    private CJPayCertSignUtils() {
    }

    static {
        INSTANCE = new CJPayCertSignUtils();
        TAG = "CJPayCertSignUtils";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CertSignParams getCertData(String r110) {
        if (r110 != null) goto L29;
        String r100 = null;
    L8:
        if (r100 != null) goto L10;
        r100 = (String) CJEncrypt.b().f559397c;     // Catch: Exception -> L5
    L10:
        String r101 = r100;
        if (r110 == null) goto L14;
        String r102 = new JSONObject(r110).optString("sign_factor");     // Catch: Exception -> L5
    L16:
        if (r102 != null) goto L18;
        String r103 = "";
    L19:
        if (r110 == null) goto L21;
        String r111 = new JSONObject(r110).optString("sign_factor_id");     // Catch: Exception -> L5
    L22:
        if (r111 != null) goto L24;
        String r104 = "";
    L25:
        CJLogger.d(TAG, "getCertData : pin:" + r101 + " signFactor:" + r103 + " signFactorId:" + r104);     // Catch: Exception -> L5
        return new CertSignParams(null, null, r101, null, r103, r104, null, 75, null);
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCertSignUtils#getCertData", e);
        CJLogger.b(TAG, "getCertData error: " + e.getMessage());
        return null;
    L24:
        r104 = r111;
        goto L25
    L21:
        r111 = null;
        goto L22
    L18:
        r103 = r102;
        goto L19
    L14:
        r102 = null;
        goto L16
    L29:
        r100 = new JSONObject(r110).optString("pin");     // Catch: Exception -> L5
        goto L8
    }

    public final boolean needCertSign(String r100) {
        Intrinsics.checkNotNullParameter(r100, "curVerifyProduct");
        return Intrinsics.areEqual(r100, DyVerifyFlow.CERT.getValue());
    }
}

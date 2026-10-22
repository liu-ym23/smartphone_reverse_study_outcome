package com.android.ttcjpaysdk.facelive.utils;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceLiveResultUtil;", "", "()V", "faceActionFailed", "", "statusCode", "", "(Ljava/lang/Integer;)Z", "getCertStatusCode", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Integer;", "getFaceLiveErrorCode", "", "getFaceLiveErrorDetailMsg", "getFaceLiveErrorMsg", "getFaceSdkData", "getVideoPath", "hasVideoPath", "isFaceCheckSuccess", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceLiveResultUtil {
    public static final CJPayFaceLiveResultUtil INSTANCE = null;

    static {
        INSTANCE = new CJPayFaceLiveResultUtil();
    }

    private CJPayFaceLiveResultUtil() {
    }

    public final boolean faceActionFailed(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.intValue() != 3062011) goto L7;
        return true;
    }

    public final Integer getCertStatusCode(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = r100.optJSONObject("jsonData");     // Catch: Throwable -> L12
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.has("status_code") == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L18;
        return Integer.valueOf(r101.optInt("status_code"));
    L18:
        return null;
    L12:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceLiveResultUtil#getCertStatusCode", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceLiveResultUtil#getCertStatusCode", th);
        return null;
    }

    public final String getFaceLiveErrorCode(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100.optString("errorCode");
    }

    public final String getFaceLiveErrorDetailMsg(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100.optString("errorDetail");
    }

    public final String getFaceLiveErrorMsg(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100.optString("errorMsg");
    }

    public final String getFaceSdkData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = r100.optJSONObject("jsonData");
        if (r101 == null) goto L5;
        String r102 = r101.optString("sdk_data");
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final String getVideoPath(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = r100.optJSONObject("jsonData");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.optString("video_path");
    }

    public final boolean hasVideoPath(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = r100.optJSONObject("jsonData");
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.has("video_path");
    }

    public final boolean isFaceCheckSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100.optBoolean("success");
    }
}

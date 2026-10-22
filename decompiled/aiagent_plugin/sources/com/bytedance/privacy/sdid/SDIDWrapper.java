package com.bytedance.privacy.sdid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class SDIDWrapper {
    private static final String KEY_CODE = "errCode";
    private static final String KEY_MSG = "errMsg";
    private static final String KEY_OAID = "oaid";
    private static final String KEY_UDID = "udid";
    private static final String METHOD_GET_OAID = "get_oaid";
    private static final String METHOD_GET_UDID = "get_udid";
    private static final Uri OAID_URI = null;
    private static final String TAG = "SDIDWrapper";
    private static final Uri UDID_URI = null;

    public SDIDWrapper() {
    }

    static {
        OAID_URI = Uri.parse("content://com.bytedance.securityserver.oaidprovider");
        UDID_URI = Uri.parse("content://com.bytedance.securityserver.udidprovider");
    }

    public static String getOAID(Context r4) {
        Bundle r5 = callProvider((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), OAID_URI, METHOD_GET_OAID);
        int r0 = r5.getInt(KEY_CODE, -1000);
        if (r0 != 0) goto L7;
        return r5.getString(KEY_OAID, "");
    L7:
        throw new SDIDException(r0, r5.getString(KEY_MSG, "Unknown error"));
    }

    public static String getUDID(Context r4) {
        Bundle r5 = callProvider((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), UDID_URI, METHOD_GET_UDID);
        int r0 = r5.getInt(KEY_CODE, -1000);
        if (r0 != 0) goto L7;
        return r5.getString(KEY_UDID, "");
    L7:
        throw new SDIDException(r0, r5.getString(KEY_MSG, "Unknown error"));
    }

    private static Bundle callProvider(Context r6, Uri r7, String r8) {
        Bundle r9 = ZeusProviderTransform.call(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r7, r8, null, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 SecurityException -> L11
        if (r9 == null) goto L7;
        return r9;
    L7:
        throw new SDIDException(-100, "Provider returned null");     // Catch: Exception -> L8 SecurityException -> L11
    L11:
        e = move-exception;
        throw new SDIDException(-1, "Permission denied: " + e.getMessage());
    L8:
        e = move-exception;
        throw new SDIDException(-1000, "Unexpected error: " + e.getMessage());
    }
}

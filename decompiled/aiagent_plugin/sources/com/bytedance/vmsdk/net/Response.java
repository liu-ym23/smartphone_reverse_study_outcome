package com.bytedance.vmsdk.net;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Response {
    private final String TAG;
    private final byte[] body;
    private ReadableMap headers;
    private long mNativeResponse;
    private final String mimeType;
    private final int status;
    private final String url;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private static native long nativeCreateResponse(Response r0);

    public Response(String r3, int r4, Map r5, InputStream r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.TAG = "Response";
        if (r3 == null) goto L15;
        if (r4 < 200) goto L13;
        this.url = r3;
        this.status = r4;
        this.mimeType = r7;
        this.headers = JavaOnlyMap.a(r8);
        if (r6 != null) goto L9;
        this.body = null;
    L10:
        this.mNativeResponse = nativeCreateResponse(this);
        return;
    L9:
        this.body = getBodyBytesInternal(r6);
        goto L10
    L13:
        throw new IllegalArgumentException("Invalid status code: " + r4);
    L15:
        throw new IllegalArgumentException("url == null");
    }

    public int getStatusCode() {
        return this.status;
    }

    public ReadableMap getHeaders() {
        return this.headers;
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] getBodyBytes() {
        return this.body;
    }

    public byte[] getBodyBytesInternal(InputStream r5) {
        byte[] r0 = new byte[1024];
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: IOException -> L10
    L4:
        int r3 = r5.read(r0, 0, 1024);     // Catch: IOException -> L10
        if (r3 <= 0) goto L7;
        r1.write(r0, 0, r3);     // Catch: IOException -> L10
    L7:
        if (r3 > 0) goto L4;
        return r1.toByteArray();
    L10:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_net_Response_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("Response", "failed to read response body: " + e.getMessage());
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_net_Response_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

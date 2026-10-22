package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.obric.matrix.a.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: MatrixServiceResultReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MatrixServiceResultReceiver extends ResultReceiver {
    public static final a Companion = null;
    private static final String KEY_EXTRA_DATA = "EXTRA_DATA";
    private static final String TAG = "MatrixServiceResultReceiver";
    private final c mResultCallback;

    /* JADX INFO: compiled from: MatrixServiceResultReceiver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public MatrixServiceResultReceiver(Handler r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        o.e(r5, "resultCallback");
        super(r3);
        this.mResultCallback = r5;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int r5, Bundle r6) {
        super.onReceiveResult(r5, r6);
        if (r6 == null) goto L12;
        byte[] r1 = r6.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L13
        if (r1 == null) goto L12;
        ad r2 = (ad) ZeusTransformUtils.preCheckCast(ad.f33286a.decode(r1), ad.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        this.mResultCallback.a(r2, com.obric.matrix.platform.sdk.ones.internal.b.a.f33683a.a(r6.getString(KEY_EXTRA_DATA)));     // Catch: Exception -> L9
        return;
    L9:
        e = e;
    L15:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "onReceiveResult exception " + e.getMessage(), null, 4, null);
        if (r2 == null) goto L18;
        this.mResultCallback.a(r2, new JSONObject());
        return;
    L18:
        if (r5 != 0) goto L21;
        r5 = -20004;
    L21:
        c r4 = this.mResultCallback;
        ad r7 = new ad.a().b(Integer.valueOf(r5)).a("receive result exception").a();
        o.c(r7, "Builder().statusCode(err…RESULT_EXCEPTION).build()");
        r4.a(r7, new JSONObject());
        return;
    L13:
        e = e;
        r2 = null;
    L12:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L13
    }
}

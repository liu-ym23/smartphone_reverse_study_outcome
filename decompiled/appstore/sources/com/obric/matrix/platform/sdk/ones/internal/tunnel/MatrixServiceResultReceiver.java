package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.obric.matrix.proto.Response;
import hc.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver;", "Landroid/os/ResultReceiver;", "Landroid/os/Handler;", "handler", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;", "resultCallback", "<init>", "(Landroid/os/Handler;Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;)V", "", "resultCode", "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "(ILandroid/os/Bundle;)V", "mResultCallback", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/IResultCallback;", "Companion", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixServiceResultReceiver extends ResultReceiver {

    @NotNull
    public static final a Companion = null;

    @NotNull
    private static final String KEY_EXTRA_DATA = "EXTRA_DATA";

    @NotNull
    private static final String TAG = "MatrixServiceResultReceiver";

    @NotNull
    private final IResultCallback mResultCallback;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public MatrixServiceResultReceiver(@Nullable Handler r10, @NotNull IResultCallback r11) {
        q.g(r11, "resultCallback");
        super(r10);
        this.mResultCallback = r11;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int r10, @Nullable Bundle r11) {
        super.onReceiveResult(r10, r11);
        if (r11 == null) goto L14;
        byte[] r12 = r11.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L11
        if (r12 == null) goto L14;
        Response r13 = Response.ADAPTER.decode(r12);     // Catch: Exception -> L11
        this.mResultCallback.onResponse(r13, hc.a.f20397a.a(r11.getString(KEY_EXTRA_DATA)));     // Catch: Exception -> L9
        return;
    L9:
        e = e;
    L15:
        b.b(TAG, "onReceiveResult exception " + e.getMessage(), null, 4, null);
        if (r13 == null) goto L18;
        this.mResultCallback.onResponse(r13, new JSONObject());
        return;
    L18:
        if (r10 != 0) goto L21;
        r10 = -20004;
    L21:
        IResultCallback r14 = this.mResultCallback;
        Response r15 = new Response.a().i(Integer.valueOf(r10)).e("receive result exception").c();
        q.f(r15, "Builder().statusCode(err…RESULT_EXCEPTION).build()");
        r14.onResponse(r15, new JSONObject());
        return;
    L11:
        e = e;
        r13 = null;
    L14:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L11
    }
}

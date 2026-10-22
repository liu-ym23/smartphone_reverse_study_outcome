package com.stepos.agentframework.adapter.bff;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import java.net.URI;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/u;", "Lorg/java_websocket/client/b;", "Ljava/net/URI;", "uri", "Lcom/stepos/agentframework/adapter/bff/q;", "callback", "<init>", "(Ljava/net/URI;Lcom/stepos/agentframework/adapter/bff/q;)V", "Lnc/h;", "handshakedata", "LY8/t;", "X", "(Lnc/h;)V", "", "data", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", SingleFileBundle.KEY_BYTES, ExifInterface.LONGITUDE_WEST, "(Ljava/nio/ByteBuffer;)V", "", "code", "reason", "", "remote", "R", "(ILjava/lang/String;Z)V", "Ljava/lang/Exception;", Const.LBS_FAIL_BD_EX, "U", "(Ljava/lang/Exception;)V", "Lcom/stepos/agentframework/adapter/bff/q;", "getCallback", "()Lcom/stepos/agentframework/adapter/bff/q;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class u extends org.java_websocket.client.b {
    private final q callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(URI uri, q callback) {
        super(uri);
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(callback, "callback");
        this.callback = callback;
    }

    @Override // org.java_websocket.client.b
    public void R(int code, String reason, boolean remote) {
        this.callback.a(code, reason, remote);
    }

    @Override // org.java_websocket.client.b
    public void U(Exception ex) {
        this.callback.c(ex);
    }

    @Override // org.java_websocket.client.b
    public void V(String data) {
        this.callback.d(data);
    }

    @Override // org.java_websocket.client.b
    public void W(ByteBuffer bytes) {
        super.W(bytes);
        this.callback.b(bytes);
    }

    @Override // org.java_websocket.client.b
    public void X(nc.h handshakedata) {
        this.callback.e();
    }
}

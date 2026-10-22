package com.bytedance.rpc.transport.ttnet;

import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.rpc.transport.StreamClosedCallback;
import com.bytedance.rpc.transport.TransportInput;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultTransportInput implements TransportInput {
    private StreamClosedCallback streamClosedCallback;
    private TypedInput typedInput;

    static /* synthetic */ StreamClosedCallback access$000(DefaultTransportInput r0) {
        return r0.streamClosedCallback;
    }

    public DefaultTransportInput(TypedInput r1, StreamClosedCallback r2) {
        this.typedInput = r1;
        this.streamClosedCallback = r2;
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public String contentType() {
        return this.typedInput.mimeType();
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public long contentLength() throws IOException {
        return this.typedInput.length();
    }

    @Override // com.bytedance.rpc.transport.TransportInput
    public InputStream in() throws IOException {
        final InputStream r0 = this.typedInput.in();
        return new AnonymousClass1(this, r0);
    }
}

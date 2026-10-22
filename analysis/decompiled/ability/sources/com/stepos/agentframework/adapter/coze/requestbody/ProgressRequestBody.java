package com.stepos.agentframework.adapter.coze.requestbody;

import F9.B;
import F9.K;
import M0.i;
import S7.o;
import V9.g;
import V9.h;
import V9.j;
import V9.q;
import V9.u;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0013R,\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/requestbody/ProgressRequestBody;", "LF9/K;", "delegate", "Lkotlin/Function3;", "", "", "LC7/r;", "listener", AppAgent.CONSTRUCT, "(LF9/K;LS7/o;)V", "LF9/B;", "contentType", "()LF9/B;", "contentLength", "()J", "LV9/h;", "sink", "writeTo", "(LV9/h;)V", "LF9/K;", "LS7/o;", "CountingSink", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProgressRequestBody extends K {
    private final K delegate;
    private final o listener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R,\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/requestbody/ProgressRequestBody$CountingSink;", "LV9/j;", "LV9/u;", "delegate", "", "contentLength", "Lkotlin/Function3;", "", "LC7/r;", "listener", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/coze/requestbody/ProgressRequestBody;LV9/u;JLS7/o;)V", "LV9/g;", AgentBusWakeContract.EXTRA_SOURCE, "byteCount", "write", "(LV9/g;J)V", "J", "LS7/o;", "bytesWritten", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class CountingSink extends j {
        private long bytesWritten;
        private final long contentLength;
        private final o listener;
        final /* synthetic */ ProgressRequestBody this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountingSink(ProgressRequestBody progressRequestBody, u delegate, long j5, o listener) {
            super(delegate);
            k.f(delegate, "delegate");
            k.f(listener, "listener");
            this.this$0 = progressRequestBody;
            this.contentLength = j5;
            this.listener = listener;
        }

        @Override // V9.j, V9.u
        public void write(g source, long byteCount) throws IOException {
            k.f(source, "source");
            super.write(source, byteCount);
            long j5 = this.bytesWritten + byteCount;
            this.bytesWritten = j5;
            this.listener.invoke(Long.valueOf(j5), Long.valueOf(this.contentLength), Boolean.valueOf(this.bytesWritten == this.contentLength));
        }
    }

    public ProgressRequestBody(K delegate, o listener) {
        k.f(delegate, "delegate");
        k.f(listener, "listener");
        this.delegate = delegate;
        this.listener = listener;
    }

    @Override // F9.K
    public long contentLength() {
        return this.delegate.contentLength();
    }

    @Override // F9.K
    public B contentType() {
        return this.delegate.contentType();
    }

    @Override // F9.K
    public void writeTo(h sink) throws IOException {
        k.f(sink, "sink");
        if (sink instanceof g) {
            this.delegate.writeTo(sink);
            return;
        }
        q qVarP = i.p(new CountingSink(this, sink, contentLength(), this.listener));
        this.delegate.writeTo(qVarP);
        qVarP.flush();
    }
}

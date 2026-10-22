package com.stepos.agentframework.adapter.coze.requestbody;

import Mb.AbstractC0973k;
import Mb.C0966d;
import Mb.G;
import Mb.InterfaceC0967e;
import Mb.u;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.q;
import tb.AbstractC5529B;
import tb.x;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0013R,\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/requestbody/a;", "Ltb/B;", "delegate", "Lkotlin/Function3;", "", "", "LY8/t;", "listener", "<init>", "(Ltb/B;Lp9/q;)V", "Ltb/x;", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", Const.INTENT_KEY_APIKEY, "()J", "LMb/e;", "sink", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "Ltb/B;", "Lp9/q;", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a extends AbstractC5529B {
    private final AbstractC5529B delegate;
    private final q<Long, Long, Boolean, t> listener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R,\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/requestbody/a$a;", "LMb/k;", "LMb/G;", "delegate", "", "contentLength", "Lkotlin/Function3;", "", "LY8/t;", "listener", "<init>", "(Lcom/stepos/agentframework/adapter/coze/requestbody/a;LMb/G;JLp9/q;)V", "LMb/d;", "source", "byteCount", "K", "(LMb/d;J)V", "J", "Lp9/q;", "bytesWritten", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.requestbody.a$a, reason: collision with other inner class name */
    public final class C0245a extends AbstractC0973k {
        private long bytesWritten;
        private final long contentLength;
        private final q<Long, Long, Boolean, t> listener;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0245a(a aVar, G delegate, long j10, q<? super Long, ? super Long, ? super Boolean, t> listener) {
            super(delegate);
            p.i(delegate, "delegate");
            p.i(listener, "listener");
            this.this$0 = aVar;
            this.contentLength = j10;
            this.listener = listener;
        }

        @Override // Mb.AbstractC0973k, Mb.G
        public void K(C0966d source, long byteCount) throws IOException {
            p.i(source, "source");
            super.K(source, byteCount);
            long j10 = this.bytesWritten + byteCount;
            this.bytesWritten = j10;
            this.listener.invoke(Long.valueOf(j10), Long.valueOf(this.contentLength), Boolean.valueOf(this.bytesWritten == this.contentLength));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(AbstractC5529B delegate, q<? super Long, ? super Long, ? super Boolean, t> listener) {
        p.i(delegate, "delegate");
        p.i(listener, "listener");
        this.delegate = delegate;
        this.listener = listener;
    }

    @Override // tb.AbstractC5529B
    public long a() {
        return this.delegate.a();
    }

    @Override // tb.AbstractC5529B
    /* renamed from: b */
    public x getContentType() {
        return this.delegate.getContentType();
    }

    @Override // tb.AbstractC5529B
    public void g(InterfaceC0967e sink) throws IOException {
        p.i(sink, "sink");
        if (sink instanceof C0966d) {
            this.delegate.g(sink);
            return;
        }
        InterfaceC0967e interfaceC0967eB = u.b(new C0245a(this, sink, a(), this.listener));
        this.delegate.g(interfaceC0967eB);
        interfaceC0967eB.flush();
    }
}

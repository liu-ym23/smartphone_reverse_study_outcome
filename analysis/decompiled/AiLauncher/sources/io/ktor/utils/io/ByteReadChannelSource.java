package io.ktor.utils.io;

import Ua.C1058h;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.InterfaceC4084k;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteReadChannelSource;", "Lfb/k;", "Lio/ktor/utils/io/ByteReadChannel;", "origin", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "Lfb/a;", "sink", "", "byteCount", "readAtMostTo", "(Lfb/a;J)J", "LY8/t;", "close", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadChannelSource implements InterfaceC4084k {
    private final ByteReadChannel origin;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.utils.io.ByteReadChannelSource$readAtMostTo$1", f = "ByteReadChannelSource.kt", l = {29}, m = "invokeSuspend")
    /* renamed from: io.ktor.utils.io.ByteReadChannelSource$readAtMostTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ByteReadChannelSource.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            ByteReadChannel byteReadChannel = ByteReadChannelSource.this.origin;
            this.label = 1;
            Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, this, 1, null);
            return objAwaitContent$default == objG ? objG : objAwaitContent$default;
        }
    }

    public ByteReadChannelSource(ByteReadChannel origin) {
        kotlin.jvm.internal.p.i(origin, "origin");
        this.origin = origin;
    }

    @Override // fb.InterfaceC4084k, java.lang.AutoCloseable, fb.InterfaceC4083j
    public void close() {
        ByteReadChannelKt.cancel(this.origin);
    }

    @Override // fb.InterfaceC4084k
    public long readAtMostTo(C4074a sink, long byteCount) throws InterruptedException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (this.origin.getReadBuffer().k()) {
            C1058h.b(null, new AnonymousClass1(null), 1, null);
        }
        if (this.origin.getReadBuffer().k()) {
            return -1L;
        }
        return this.origin.getReadBuffer().readAtMostTo(sink, byteCount);
    }
}

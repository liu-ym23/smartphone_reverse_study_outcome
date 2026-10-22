package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ByteChannel$writeBuffer$1 extends FunctionReferenceImpl implements InterfaceC5074l<Throwable, ClosedWriteChannelException> {
    public static final ByteChannel$writeBuffer$1 INSTANCE = new ByteChannel$writeBuffer$1();

    public ByteChannel$writeBuffer$1() {
        super(1, ClosedWriteChannelException.class, "<init>", "<init>(Ljava/lang/Throwable;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public final ClosedWriteChannelException invoke(Throwable th) {
        return new ClosedWriteChannelException(th);
    }
}

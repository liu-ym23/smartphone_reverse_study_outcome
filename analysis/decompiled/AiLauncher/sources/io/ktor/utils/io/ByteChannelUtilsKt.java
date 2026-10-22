package io.ktor.utils.io;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lkotlinx/coroutines/g;", "job", "LY8/t;", "attachJob", "(Lio/ktor/utils/io/ByteChannel;Lkotlinx/coroutines/g;)V", "Lio/ktor/utils/io/ChannelJob;", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/utils/io/ChannelJob;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelUtilsKt {
    public static final void attachJob(final ByteChannel byteChannel, g job) {
        p.i(byteChannel, "<this>");
        p.i(job, "job");
        job.J(new InterfaceC5074l() { // from class: io.ktor.utils.io.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ByteChannelUtilsKt.attachJob$lambda$0(byteChannel, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t attachJob$lambda$0(ByteChannel byteChannel, Throwable th) {
        if (th != null) {
            byteChannel.cancel(th);
        }
        return t.f7040a;
    }

    public static final void attachJob(ByteChannel byteChannel, ChannelJob job) {
        p.i(byteChannel, "<this>");
        p.i(job, "job");
        attachJob(byteChannel, job.getJob());
    }
}

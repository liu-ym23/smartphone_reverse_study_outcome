package io.ktor.client.request.forms;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/request/forms/ChannelProvider;", "", "", ContentDisposition.Parameters.Size, "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "block", "<init>", "(Ljava/lang/Long;Lp9/a;)V", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "Lp9/a;", "getBlock", "()Lp9/a;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChannelProvider {
    private final InterfaceC5063a<ByteReadChannel> block;
    private final Long size;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelProvider(Long l10, InterfaceC5063a<? extends ByteReadChannel> block) {
        p.i(block, "block");
        this.size = l10;
        this.block = block;
    }

    public final InterfaceC5063a<ByteReadChannel> getBlock() {
        return this.block;
    }

    public final Long getSize() {
        return this.size;
    }

    public /* synthetic */ ChannelProvider(Long l10, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : l10, interfaceC5063a);
    }
}

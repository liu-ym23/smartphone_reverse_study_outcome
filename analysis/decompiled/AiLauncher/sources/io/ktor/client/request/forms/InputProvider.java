package io.ktor.client.request.forms;

import fb.v;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/request/forms/InputProvider;", "", "", ContentDisposition.Parameters.Size, "Lkotlin/Function0;", "Lfb/v;", "Lio/ktor/utils/io/core/Input;", "block", "<init>", "(Ljava/lang/Long;Lp9/a;)V", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "Lp9/a;", "getBlock", "()Lp9/a;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputProvider {
    private final InterfaceC5063a<v> block;
    private final Long size;

    /* JADX WARN: Multi-variable type inference failed */
    public InputProvider(Long l10, InterfaceC5063a<? extends v> block) {
        p.i(block, "block");
        this.size = l10;
        this.block = block;
    }

    public final InterfaceC5063a<v> getBlock() {
        return this.block;
    }

    public final Long getSize() {
        return this.size;
    }

    public /* synthetic */ InputProvider(Long l10, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : l10, interfaceC5063a);
    }
}

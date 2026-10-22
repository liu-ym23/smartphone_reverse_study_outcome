package io.ktor.client.engine;

import Y8.t;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class UtilsKt$attachToUserJob$cleanupHandler$1 implements InterfaceC5074l<Throwable, t> {
    final /* synthetic */ kotlinx.coroutines.g $callJob;

    public UtilsKt$attachToUserJob$cleanupHandler$1(kotlinx.coroutines.g gVar) {
        this.$callJob = gVar;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        invoke2(th);
        return t.f7040a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (th == null) {
            return;
        }
        this.$callJob.i(new CancellationException(th.getMessage()));
    }
}

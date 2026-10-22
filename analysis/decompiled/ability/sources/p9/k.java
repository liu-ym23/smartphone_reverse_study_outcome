package p9;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public final class k implements n, c, q9.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.flow.h f5561a;

    public k(kotlinx.coroutines.flow.h hVar) {
        this.f5561a = hVar;
    }

    @Override // q9.g
    public final c c(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return e.e(this, hVar, i, bufferOverflow);
    }

    @Override // p9.c
    public final Object collect(d dVar, H7.c cVar) {
        this.f5561a.collect(dVar, cVar);
        return CoroutineSingletons.f4909a;
    }
}

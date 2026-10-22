package p9;

import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public final class l implements t, c, q9.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f5562a;

    public l(j jVar) {
        this.f5562a = jVar;
    }

    @Override // q9.g
    public final c c(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return (((i < 0 || i >= 2) && i != -2) || bufferOverflow != BufferOverflow.b) ? e.e(this, hVar, i, bufferOverflow) : this;
    }

    @Override // p9.c
    public final Object collect(d dVar, H7.c cVar) {
        return this.f5562a.collect(dVar, cVar);
    }

    @Override // p9.t
    public final Object getValue() {
        return this.f5562a.getValue();
    }
}

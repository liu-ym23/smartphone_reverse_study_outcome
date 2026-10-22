package bf9;

import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: classes30.dex */
public final class i0 implements juc.d<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2 f18846a;

    public i0() {
        this.f18846a = luc.n.a("TimeTransform", luc.e.g.f510855a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f18846a;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Long.valueOf(r100.decodeLong() * 1000);
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        long r102 = ((Number) r101).longValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeLong(r102 / 1000);
    }
}

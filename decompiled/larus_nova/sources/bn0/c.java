package bn0;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends j implements b, h<u60.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f19700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u60.a f19701f;

    public final String toString() {
        return "com.bytedance.android.live.multilink.external.api.core.scope.__ScopeImpl_MultiLinkRoomScope";
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f19700e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f19701f;
    }

    public c(u60.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f19701f = r100;
        Object r101 = k.f470908a;
        this.f19700e = r100.i();
    }
}

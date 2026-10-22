package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import cc2.p;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends p<cc2.k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<cc2.k> f138858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<cc2.k> f138859g;

    @Override // cc2.p
    public final Set<cc2.k> b() {
        return this.f138858f;
    }

    @Override // cc2.p
    public final Set<cc2.k> c() {
        return this.f138859g;
    }

    public h(k r100) {
        super(true, r100);
        this.f138858f = SetsKt.setOf(new cc2.k[]{cc2.k.b.f23202c, cc2.k.a.f23200c});
        this.f138859g = SetsKt.emptySet();
    }
}

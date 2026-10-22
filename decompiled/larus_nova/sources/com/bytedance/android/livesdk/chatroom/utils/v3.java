package com.bytedance.android.livesdk.chatroom.utils;

import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class v3 extends cc2.p<cc2.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<cc2.b> f114653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<cc2.b> f114654g;

    @Override // cc2.p
    public final Set<cc2.b> b() {
        return this.f114654g;
    }

    @Override // cc2.p
    public final Set<cc2.b> c() {
        return this.f114653f;
    }

    public v3(w3 r100) {
        super(true, r100);
        this.f114653f = SetsKt.emptySet();
        this.f114654g = SetsKt.setOf(new cc2.b[]{cc2.b.c.f23146c, cc2.b.C0428b.f23144c, cc2.b.a.f23142c});
    }
}

package com.bytedance.android.live.revlink.impl.service;

import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends i11.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p11.a f97515a;

    public a(c r100) {
        this.f97515a = r100;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r100, List<? extends p> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r101, "list");
        p11.a r102 = this.f97515a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}

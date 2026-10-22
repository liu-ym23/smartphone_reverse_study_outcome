package com.bytedance.android.live.core.tetris.layer.view;

import j70.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f65879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f65880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f65881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f65882d;

    public final void c() {
        this.f65881c = true;
        if ((true ^ ((ArrayList) this.f65880b).isEmpty()) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 first，所以不能有 aboveList");
    }

    public final void d() {
        this.f65882d = true;
        if ((true ^ ((ArrayList) this.f65879a).isEmpty()) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 last，所以不能有 belowList");
    }

    public b() {
        this.f65879a = new ArrayList();
        this.f65880b = new ArrayList();
    }

    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        ((ArrayList) this.f65880b).add(r100);
        if (this.f65881c == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 first，所以不能有 aboveList");
    }

    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        ((ArrayList) this.f65879a).add(r100);
        if (this.f65882d == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 last，所以不能有 belowList");
    }
}

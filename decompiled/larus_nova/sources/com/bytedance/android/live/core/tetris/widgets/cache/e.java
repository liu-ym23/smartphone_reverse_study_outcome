package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<String> f65974b;

    public e() {
        this(0);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.h
    public final void a() {
        super.a();
        this.f65974b.clear();
    }

    public e(int r100) {
        this.f65974b = new ArrayDeque();
    }
}

package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f180704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180705b;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.r
    public final void t() {
        if (this.f180704a.get() == true) goto L6;
        run();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.r
    public final String getName() {
        return this.f180705b;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f180705b = r100;
        this.f180704a = new AtomicBoolean(false);
    }
}

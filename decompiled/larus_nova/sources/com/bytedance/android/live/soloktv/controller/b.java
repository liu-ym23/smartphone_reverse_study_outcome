package com.bytedance.android.live.soloktv.controller;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.soloktv.controller.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b<T extends l> implements c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f101035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f101036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f101037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f101038e;

    public abstract void b();

    @Override // com.bytedance.android.live.soloktv.controller.c
    public void onClear() {
    }

    public final Context getContext() {
        return this.f101035b;
    }

    public final void c(l r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        e r101 = this.f101036c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public b(LifecycleOwner r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f101037d = r100;
        this.f101038e = r101;
        this.f101035b = r101.getContext();
    }
}

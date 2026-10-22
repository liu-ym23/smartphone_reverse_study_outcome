package com.bytedance.android.live.soloktv.controller;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.soloktv.controller.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<T extends l> extends h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f101031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f101032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f101033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f101034e;

    public abstract void c();

    public final Context getContext() {
        return this.f101031b;
    }

    public final void d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        e r101 = this.f101032c;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public a(LifecycleOwner r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f101033d = r100;
        this.f101034e = r101;
        this.f101031b = r101.getContext();
    }
}

package com.bytedance.android.anniex.base.builder;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends UIComponentBuilder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FragmentActivity f40271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ka.a f40272k;

    public final FragmentActivity e() {
        FragmentActivity r100 = this.f40271j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragmentActivity");
        return null;
    }

    public c() {
    }

    public final void d(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f40271j = r100;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f40258a = r100;
    }
}

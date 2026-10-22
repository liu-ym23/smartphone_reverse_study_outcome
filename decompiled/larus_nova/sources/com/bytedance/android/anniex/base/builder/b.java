package com.bytedance.android.anniex.base.builder;

import android.app.Activity;
import com.bytedance.ies.bullet.base.core.common.Components;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends UIComponentBuilder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Activity f40268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ka.b f40269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Components f40270l;

    public b() {
        this.f40270l = Components.Fragment;
    }

    public final void d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f40268j = r100;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f40258a = r100;
    }
}

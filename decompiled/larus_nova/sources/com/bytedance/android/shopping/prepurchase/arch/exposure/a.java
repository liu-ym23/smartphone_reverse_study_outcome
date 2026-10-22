package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f180880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, c> f180881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f180882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f180883d;

    public a(ConfigurationBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        LifecycleOwner r101 = r100.f180858a;
        Intrinsics.checkNotNull(r101);
        this.f180880a = r101;
        this.f180881b = r100.f180861d;
        this.f180882c = r100.f180859b;
        this.f180883d = r100.f180860c;
    }
}

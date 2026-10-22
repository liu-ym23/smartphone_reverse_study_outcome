package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class ConfigurationBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleOwner f180858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f180859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f180860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super View, c> f180861d;

    public ConfigurationBuilder() {
        this.f180860c = 100;
        this.f180861d = ConfigurationBuilder$algorithm$1.INSTANCE;
    }
}

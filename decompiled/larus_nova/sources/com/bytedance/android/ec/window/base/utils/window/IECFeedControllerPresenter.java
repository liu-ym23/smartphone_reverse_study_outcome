package com.bytedance.android.ec.window.base.utils.window;

import android.content.Context;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class IECFeedControllerPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f49780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f49781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f49782c;

    public abstract Context b();

    public abstract ECWindowShopLiveData c();

    public abstract LifecycleOwner d();

    public abstract boolean e();

    public abstract boolean f();

    public IECFeedControllerPresenter() {
        this.f49780a = new a();
        this.f49781b = LazyKt.lazy(new IECFeedControllerPresenter$croppedStateObserver$2(this));
        this.f49782c = LazyKt.lazy(new IECFeedControllerPresenter$lifecycleEventObserver$2(this));
    }

    public final void a() {
        c().observe(d(), (Observer) this.f49781b.getValue());
        d().getLifecycle().addObserver((LifecycleEventObserver) this.f49782c.getValue());
    }
}

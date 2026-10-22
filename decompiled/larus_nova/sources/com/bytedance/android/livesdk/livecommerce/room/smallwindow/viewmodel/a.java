package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f151888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f151889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f151890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f151891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f151892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f151893f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C2337a {
    }

    public interface b {
        void d(List<yi2.b> r100);
    }

    static {
    }

    public a() {
        this.f151892e = null;
        this.f151893f = null;
        this.f151888a = LazyKt.lazy(LiveSmallWindowViewModel$countDownHandler$2.INSTANCE);
        this.f151889b = new c(this);
    }
}

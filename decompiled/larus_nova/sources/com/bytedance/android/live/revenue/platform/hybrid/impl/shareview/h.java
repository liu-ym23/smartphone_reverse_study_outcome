package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevShareViewServiceImpl f91453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f91454b;

    public h(RevShareViewServiceImpl r100, Context r101) {
        this.f91453a = r100;
        this.f91454b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r101 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c) r100;
        Intrinsics.checkNotNullParameter(r101, "sharer");
        final RevShareViewServiceImpl$waitSharer$3$1 r102 = new RevShareViewServiceImpl$waitSharer$3$1(this, r101);
        LifecycleEventObserver r103 = new RevShareViewServiceImpl$waitSharer$3$observer$1(this, r102);
        if (((Activity) this.f91454b).isDestroyed() == true) goto L6;
        r101.b();
        ((LifecycleOwner) this.f91454b).getLifecycle().addObserver(r103);
        this.f91453a.f91418b.put(this.f91454b, new l.a(r101));
        return r101;
    L6:
        r102.invoke2();
        throw new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "context has been destroyed");
    }
}

package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes12.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f165697a;

    public w(Function1 r100) {
        this.f165697a = r100;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCollectionChanged(mi.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f165697a.invoke(new u(r100.f514034a, r100.f514035b));
    }
}

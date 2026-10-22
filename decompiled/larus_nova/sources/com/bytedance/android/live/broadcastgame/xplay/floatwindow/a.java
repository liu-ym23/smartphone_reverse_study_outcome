package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f62139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.core.arch.mvvm.c<Boolean> f62140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f62141c;

    public a(DataCenter r100, PropertyOwner r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "isInteractive");
        Intrinsics.checkNotNullParameter(r102, "env");
        this.f62139a = r100;
        this.f62140b = r101;
        this.f62141c = r102;
    }
}

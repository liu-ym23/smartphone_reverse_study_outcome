package com.bytedance.android.live.cloudgrouplive.im;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import vlc.d;

/* JADX INFO: loaded from: classes45.dex */
public final class CloudGroupLiveMsgManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f64459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f64460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f64461c;

    public CloudGroupLiveMsgManager() {
        this.f64460b = new CopyOnWriteArrayList();
        this.f64461c = LazyKt.lazy(new CloudGroupLiveMsgManager$mOnMessageListener$2(this));
    }
}

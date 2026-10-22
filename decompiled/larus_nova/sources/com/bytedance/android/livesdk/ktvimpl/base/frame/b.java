package com.bytedance.android.livesdk.ktvimpl.base.frame;

import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<? extends IKWidget<?>>, IKWidget<?>> f142510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends DataContext>, Pair<DataContext, Disposable>> f142511b;

    public b() {
        this.f142510a = new HashMap();
        this.f142511b = new ConcurrentHashMap();
    }
}

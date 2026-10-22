package com.bytedance.android.ec.store.view;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class ECTagCountdownTickScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f48845a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<WeakReference<a>> f48846b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f48847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ECTagCountdownTickScheduler$tickRunnable$1 f48848d = null;

    public interface a {
        boolean onTick(long r100);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.ec.store.view.ECTagCountdownTickScheduler$tickRunnable$1] */
    static {
        f48845a = new Handler(Looper.getMainLooper());
        f48846b = new ArrayList();
        f48848d = new ECTagCountdownTickScheduler$tickRunnable$1();
    }
}

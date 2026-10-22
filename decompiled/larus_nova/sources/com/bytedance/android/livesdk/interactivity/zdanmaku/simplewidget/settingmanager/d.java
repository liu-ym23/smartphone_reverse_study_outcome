package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class d<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f141802a = null;

    static {
        f141802a = new d();
    }

    public d() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = SimpleSettingManager.f141793a;
        AtomicBoolean r101 = SimpleSettingManager.f141798f;
        if (r101.get() == false) goto L6;
        SimpleSettingManager.e(null);
        return;
    L6:
        long r102 = System.currentTimeMillis();
        o r103 = SimpleSettingManager.b();
        r101.set(true);
        long r104 = System.currentTimeMillis() - r102;
        int r105 = i.f141754a;
        i.d("prefetch simple setting done in " + r104 + "ms, setting: " + r103 + ", thread: " + ThreadMethodProxy.currentThread().getName());
        SimpleSettingManager.e(r103);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}

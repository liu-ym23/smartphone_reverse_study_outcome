package com.bytedance.android.livesdk.room.placeholder.behavior;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, p> f157768a;

    public final synchronized void b() {
        monitor-enter(this);
        Iterator<T> r100 = this.f157768a.values().iterator();     // Catch: Throwable -> L14
    L5:
        if (r100.hasNext() == false) goto L11;
        p r101 = (p) r100.next();     // Catch: Throwable -> L14
        ExtendedToolbarButton r102 = r101.f157771c;     // Catch: Throwable -> L14
        if (r102 == null) goto L5;
        x3 r103 = r101.f157770b;     // Catch: Throwable -> L14
        if (r103 == null) goto L5;
        r103.f(r102, r101);     // Catch: Throwable -> L14
        goto L5
    L11:
        this.f157768a.clear();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public o() {
        this.f157768a = new ConcurrentHashMap();
    }

    public final synchronized void c(long r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f157768a.contains(Long.valueOf(r100)) == false) goto L13;
        p r101 = this.f157768a.get(Long.valueOf(r100));     // Catch: Throwable -> L15
        if (r101 == null) goto L12;
        ExtendedToolbarButton r102 = r101.f157771c;     // Catch: Throwable -> L15
        if (r102 == null) goto L12;
        x3 r103 = r101.f157770b;     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        r103.f(r102, r101);     // Catch: Throwable -> L15
    L12:
        this.f157768a.remove(Long.valueOf(r100));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public final synchronized void a(ExtendedToolbarButton.c r100, p r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.TOOLBAR);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "behavior");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");     // Catch: Throwable -> L9
        x3 r102 = r101.f157770b;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.p(r100, r101);     // Catch: Throwable -> L9
    L6:
        r101.f157771c = r100;     // Catch: Throwable -> L9
        this.f157768a.put(Long.valueOf(r101.f157775g), r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}

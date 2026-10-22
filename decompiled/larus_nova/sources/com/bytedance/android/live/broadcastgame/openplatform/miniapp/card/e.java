package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f61754d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<d> f61755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f61756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f61757c;

    public static final class a {
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f61757c = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        d r100 = this.f61755a.poll();     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        boolean r101 = true;
    L7:
        this.f61756b = r101;     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        r100.a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        r101 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public e() {
        this.f61755a = new LinkedList();
    }

    public final synchronized void a(String r100, Function1 r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "taskName");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "block");     // Catch: Throwable -> L12
        f r102 = new f(this, r101, r100);     // Catch: Throwable -> L12
        this.f61755a.offer(r102);     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        this.f61755a.size();     // Catch: Throwable -> L12
        LinkedList<d> r103 = this.f61755a;     // Catch: Throwable -> L12
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L12
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L12
    L5:
        if (r105.hasNext() == false) goto L7;
        r104.add(((d) r105.next()).f61753a);     // Catch: Throwable -> L12
        goto L5
    L7:
        r104.toString();     // Catch: Throwable -> L12
        v.a();     // Catch: Throwable -> L12
        if (this.f61756b == true) goto L10;
        b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}

package com.bytedance.android.scope.tree;

import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f163460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f163461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f163462c;

    public abstract void f();

    public abstract void onEvent(b r100);

    public final void e() {
        ReentrantReadWriteLock r100 = this.f163461b;
        ReentrantReadWriteLock.ReadLock r101 = r100.readLock();
        int r102 = 0;
        if (r100.getWriteHoldCount() != 0) goto L5;
        int r103 = r100.getReadHoldCount();
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101.unlock();
        r104 = r104 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r105 = r100.writeLock();
        r105.lock();
    L21:
        th = move-exception;
    L25:
        if (r102 >= r103) goto L27;
        r101.lock();
        r102 = r102 + 1;
        goto L25
    L27:
        r105.unlock();
        throw th;
    L11:
        if (this.f163460a == true) goto L24;
        f();     // Catch: Throwable -> L21
        this.f163460a = true;     // Catch: Throwable -> L21
        b.a r106 = new b.a(this);     // Catch: Throwable -> L21
        Iterator r107 = ((ArrayList) this.f163462c).iterator();     // Catch: Throwable -> L21
    L14:
        if (r107.hasNext() == false) goto L16;
        ((a) r107.next()).onEvent(r106);     // Catch: Throwable -> L21
        goto L14
    L16:
        ((ArrayList) this.f163462c).clear();     // Catch: Throwable -> L21
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L17:
        if (r102 >= r103) goto L19;
        r101.lock();
        r102 = r102 + 1;
        goto L17
    L19:
        r105.unlock();
        return;
    L24:
        throw new IllegalStateException("Node is destroyed");     // Catch: Throwable -> L21
    L5:
        r103 = 0;
        goto L6
    }

    public a() {
        this.f163461b = new ReentrantReadWriteLock();
        this.f163462c = new ArrayList();
    }

    public final void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        if (this.f163460a == true) goto L18;
        if (r100.f163460a == true) goto L16;
        if (this == r100) goto L14;
        if (((ArrayList) this.f163462c).contains(r100) == true) goto L12;
        ((ArrayList) this.f163462c).add(r100);
        return;
    L12:
        throw new IllegalArgumentException("Listener already exists");
    L14:
        throw new IllegalArgumentException("Adding this as listener");
    L16:
        throw new IllegalStateException("Node is destroyed");
    L18:
        throw new IllegalStateException("Node is destroyed");
    }
}

package com.obric.legacy;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DestroyObservable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/legacy/DestroyObservable;", "", "host", "(Ljava/lang/Object;)V", "getHost", "()Ljava/lang/Object;", "isDestroyed", "", "observers", "", "Lcom/obric/legacy/DestroyObserver;", "kotlin.jvm.PlatformType", "", "addObserver", "", "observer", "onDestroy", "removeObserver", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DestroyObservable {
    private final Object host;
    private boolean isDestroyed;
    private final Set<DestroyObserver> observers;

    public DestroyObservable(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.host = r2;
        this.observers = Collections.newSetFromMap(new WeakHashMap());
    }

    public final Object getHost() {
        return this.host;
    }

    public final synchronized void onDestroy() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        List r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L21
    L24:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Set<DestroyObserver> r2 = this.observers;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "observers");     // Catch: Throwable -> L10
        r0 = CollectionsKt.toList(r2);     // Catch: Throwable -> L10
        Object r3 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.m810isSuccessimpl(r3) == false) goto L24;
        Iterator r4 = r0.iterator();     // Catch: Throwable -> L21
    L16:
        if (r4.hasNext() == false) goto L18;
        ((DestroyObserver) r4.next()).onDestroy(this.host);     // Catch: Throwable -> L21
        goto L16
    L18:
        this.observers.clear();     // Catch: Throwable -> L21
        this.isDestroyed = true;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        r3 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L13
    }

    public final synchronized boolean isDestroyed() {
        monitor-enter(this);
        boolean r0 = this.isDestroyed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void addObserver(DestroyObserver r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "observer");     // Catch: Throwable -> L12
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.observers.contains(r2) == true) goto L10;
        this.observers.add(r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void removeObserver(DestroyObserver r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "observer");     // Catch: Throwable -> L10
        if (this.isDestroyed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.observers.remove(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

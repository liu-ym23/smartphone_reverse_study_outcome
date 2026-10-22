package com.stepos.deepbinder.core.entity.pool;

import java.util.ArrayDeque;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectPool<T> {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_SIZE = 100;
    private final ArrayDeque<T> availableObjects;
    private volatile long borrowCount;
    private volatile long createCount;
    private final a<T> creator;
    private final int maxSize;
    private final l<T, n> reset;
    private volatile long returnCount;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObjectPool(int i10, a<? extends T> creator, l<? super T, n> lVar) {
        g.f(creator, "creator");
        this.maxSize = i10;
        this.creator = creator;
        this.reset = lVar;
        this.availableObjects = new ArrayDeque<>(i10);
    }

    public final T borrowObject() {
        T tRemoveLast;
        synchronized (this.availableObjects) {
            tRemoveLast = this.availableObjects.isEmpty() ? null : this.availableObjects.removeLast();
        }
        this.borrowCount++;
        if (tRemoveLast != null) {
            return tRemoveLast;
        }
        this.createCount++;
        return this.creator.invoke();
    }

    public final void clear() {
        synchronized (this.availableObjects) {
            this.availableObjects.clear();
            n nVar = n.f10413a;
        }
    }

    public final void returnObject(T t8) {
        if (t8 == null) {
            return;
        }
        l<T, n> lVar = this.reset;
        if (lVar != null) {
            lVar.invoke(t8);
        }
        synchronized (this.availableObjects) {
            try {
                if (this.availableObjects.size() < this.maxSize) {
                    this.availableObjects.addLast(t8);
                    this.returnCount++;
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int size() {
        int size;
        synchronized (this.availableObjects) {
            size = this.availableObjects.size();
        }
        return size;
    }

    public /* synthetic */ ObjectPool(int i10, a aVar, l lVar, int i11, e eVar) {
        this((i11 & 1) != 0 ? 100 : i10, aVar, (i11 & 4) != 0 ? null : lVar);
    }
}

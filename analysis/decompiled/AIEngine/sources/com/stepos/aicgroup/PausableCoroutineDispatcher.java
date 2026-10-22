package com.stepos.aicgroup;

import android.util.Log;
import androidx.appcompat.app.l;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PausableCoroutineDispatcher extends CoroutineDispatcher {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f5651m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f5652a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5653b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5654c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5655d;

    /* renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock f5656e;
    public volatile int h;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f5657j;

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Pair<kotlin.coroutines.d, Runnable>> f5658k;

    /* renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f5659l;

    public /* synthetic */ PausableCoroutineDispatcher(CoroutineDispatcher coroutineDispatcher, String str, int i10, int i11, kotlin.jvm.internal.e eVar) {
        this(coroutineDispatcher, str, (i11 & 4) != 0 ? Integer.MAX_VALUE : i10);
    }

    public final void K() {
        int i10 = 0;
        while (true) {
            int i11 = this.f5657j.get();
            if (i11 >= this.h) {
                break;
            }
            if (this.f5657j.compareAndSet(i11, i11 + 1)) {
                Pair<kotlin.coroutines.d, Runnable> pairPoll = this.f5658k.poll();
                if (pairPoll == null) {
                    this.f5657j.decrementAndGet();
                    break;
                } else {
                    this.f5652a.dispatch(pairPoll.f9985a, pairPoll.f9986b);
                    i10++;
                }
            }
        }
        if (i10 > 0) {
            String str = this.f5655d;
            String str2 = this.f5653b;
            int i12 = this.h;
            StringBuilder sbF = h0.e.f("[", str2, "] 放行 ", i10, " 个排队任务（并发上限 ");
            sbF.append(i12);
            sbF.append("）");
            Log.d(str, sbF.toString());
        }
    }

    public final void cancelAll(String reason) {
        kotlin.jvm.internal.g.f(reason, "reason");
        ConcurrentHashMap.KeySetView keySetView = this.f5659l;
        int size = keySetView.size();
        Iterator it = keySetView.iterator();
        while (it.hasNext()) {
            ((Job) it.next()).cancel(new CancellationException(reason));
        }
        keySetView.clear();
        this.f5658k.clear();
        ai.onnxruntime.a.y(h0.e.f("[", this.f5653b, "] 取消 ", size, " 个活跃 Job，清空待执行队列，原因: "), reason, this.f5655d);
    }

    public final int currentConcurrency() {
        return this.h;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(kotlin.coroutines.d context, Runnable block) {
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = this.f5656e;
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(block, "block");
        Job job = (Job) context.get(Job.Key);
        if (job != null && this.f5659l.add(job)) {
            job.invokeOnCompletion(new f(0, this, job));
        }
        l lVar = new l(block, this);
        reentrantReadWriteLock.readLock().lock();
        while (true) {
            try {
                int i10 = this.f5657j.get();
                if (i10 >= this.h) {
                    z = false;
                    break;
                } else if (this.f5657j.compareAndSet(i10, i10 + 1)) {
                    z = true;
                    break;
                }
            } catch (Throwable th) {
                reentrantReadWriteLock.readLock().unlock();
                throw th;
            }
        }
        if (z) {
            this.f5652a.dispatch(context, lVar);
        } else {
            this.f5658k.offer(new Pair<>(context, lVar));
        }
        reentrantReadWriteLock.readLock().unlock();
    }

    public final int getActiveJobCount() {
        return this.f5659l.size();
    }

    public final int getPendingCount() {
        return this.f5658k.size();
    }

    public final boolean isPaused() {
        return this.h == 0;
    }

    public final boolean pause() {
        this.f5656e.writeLock().lock();
        try {
            if (this.h == 0) {
                return false;
            }
            this.h = 0;
            this.f5656e.writeLock().unlock();
            return true;
        } finally {
            this.f5656e.writeLock().unlock();
        }
    }

    public final boolean resume() {
        this.f5656e.writeLock().lock();
        try {
            int i10 = this.h;
            int i11 = this.f5654c;
            boolean z = i10 < i11;
            if (z) {
                this.h = i11;
            }
            if (z) {
                K();
            }
            return z;
        } finally {
            this.f5656e.writeLock().unlock();
        }
    }

    public final boolean resumeOneSlot() {
        this.f5656e.writeLock().lock();
        try {
            if (this.h < this.f5654c) {
                this.h++;
            }
            boolean z = this.h >= this.f5654c;
            this.f5656e.writeLock().unlock();
            K();
            return z;
        } catch (Throwable th) {
            this.f5656e.writeLock().unlock();
            throw th;
        }
    }

    public PausableCoroutineDispatcher(CoroutineDispatcher delegate, String dispatcherName, int i10) {
        kotlin.jvm.internal.g.f(delegate, "delegate");
        kotlin.jvm.internal.g.f(dispatcherName, "dispatcherName");
        this.f5652a = delegate;
        this.f5653b = dispatcherName;
        this.f5654c = i10;
        this.f5655d = "PausableDispatcher";
        this.f5656e = new ReentrantReadWriteLock();
        this.h = i10;
        this.f5657j = new AtomicInteger(0);
        this.f5658k = new ConcurrentLinkedQueue<>();
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        kotlin.jvm.internal.g.e(keySetViewNewKeySet, "newKeySet(...)");
        this.f5659l = keySetViewNewKeySet;
    }
}

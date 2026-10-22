package com.bytedance.android.livesdk.room.Task.base;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class LiveTask implements gs2.a, gs2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownLatch f157555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f157556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f157557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f157558d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157559a;

        public b(LiveTask r100) {
            this.f157559a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f157559a.f157556b.getValue()).iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((gs2.b) r100.next()).c();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f157561b;

        public c(LiveTask r100, Throwable r101) {
            this.f157560a = r100;
            this.f157561b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f157560a.f157556b.getValue()).iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((gs2.b) r100.next()).b(this.f157561b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157562a;

        public d(LiveTask r100) {
            this.f157562a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f157562a.f157556b.getValue()).iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((gs2.b) r100.next()).a();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157563a;

        public e(LiveTask r100) {
            this.f157563a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = ((CopyOnWriteArrayList) this.f157563a.f157556b.getValue()).iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((gs2.b) r100.next()).e();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    @Override // gs2.b
    public final void a() {
        fs2.d.a(new d(this));
    }

    @Override // gs2.b
    public final void c() {
        fs2.d.a(new b(this));
    }

    @Override // gs2.b
    public final void e() {
        fs2.d.a(new e(this));
    }

    public final String toString() {
        List<String> r100 = this.f157557c;
        if (r100 == null) goto L5;
        String r101 = CollectionsKt.joinToString$default(r100, " | ", null, null, 0, null, null, 62, null);
    L7:
        return "LiveTask(name " + taskID() + ", dependList is " + r101 + ')';
    L5:
        r101 = null;
        goto L7
    }

    public LiveTask() {
        this.f157556b = LazyKt.lazy(LiveTask$copyOnWriteArrayList$2.INSTANCE);
        this.f157557c = new ArrayList();
        this.f157558d = -1;
    }

    public final int hashCode() {
        return taskID().hashCode();
    }

    public List<String> f() {
        return this.f157557c;
    }

    @Override // gs2.b
    public final void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        fs2.d.a(new c(this, r100));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTask) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(taskID(), ((LiveTask) r100).taskID());
    }
}

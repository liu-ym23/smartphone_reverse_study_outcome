package bt3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20545f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20546g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f20547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<e> f20548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<Message> f20549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f20550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f20551e;

    public static class a {
        public a() {
        }

        public final boolean a(Object r100, Object r101) {
            e r102 = (e) r100;
            Runnable r103 = (Runnable) r101;
            if (r103 != null) goto L10;
            if (r102 == null) goto L15;
            Message r104 = r102.f20554a;
            if (r104 == null) goto L15;
            if (r104.getCallback() == null) goto L15;
        L16:
            return false;
        L15:
            return true;
        L10:
            if (r102 == null) goto L16;
            Message r105 = r102.f20554a;
            if (r105 == null) goto L16;
            if (r103.equals(r105.getCallback()) == false) goto L16;
            goto L15
        }
    }

    public static class b {
        public b() {
        }

        public final boolean a(Object r100, Object r101) {
            Message r102 = (Message) r100;
            Runnable r103 = (Runnable) r101;
            if (r103 != null) goto L8;
            if (r102 != null) goto L6;
        L11:
            return true;
        L6:
            if (r102.getCallback() == null) goto L11;
        L12:
            return false;
        L8:
            if (r102 == null) goto L12;
            if (r103.equals(r102.getCallback()) == false) goto L12;
            goto L11
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20552a;

        public final void a() {
        L3:
            if (((ConcurrentLinkedQueue) this.f20552a.f20549c).isEmpty() == true) goto L14;
            Object r100 = this.f20552a.f20551e;
            monitor-enter(r100);
            if (this.f20552a.f20550d == null) goto L9;
            this.f20552a.f20550d.sendMessageAtFrontOfQueue((Message) ((ConcurrentLinkedQueue) this.f20552a.f20549c).poll());     // Catch: Throwable -> L11
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        L14:
            b();
        }

        public final void b() {
        L3:
            if (((ConcurrentLinkedQueue) this.f20552a.f20548b).isEmpty() == true) goto L14;
            Object r100 = this.f20552a.f20551e;
            monitor-enter(r100);
            e r101 = (e) ((ConcurrentLinkedQueue) this.f20552a.f20548b).poll();     // Catch: Throwable -> L11
            if (this.f20552a.f20550d == null) goto L9;
            this.f20552a.f20550d.sendMessageAtTime(r101.f20554a, r101.f20555b);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(f r100) {
            this.f20552a = r100;
        }
    }

    public class d extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f20553c;

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r100 = this.f20553c.f20551e;
            monitor-enter(r100);
            f r101 = this.f20553c;     // Catch: Throwable -> L11
            r101.f20550d = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            this.f20553c.f20550d.post(new c(this.f20553c));
        L14:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            k.b.f190610a.a(th);
        L11:
            th = move-exception;
            throw th;
        }

        public d(f r100, String r101) {
            this.f20553c = r100;
            super(r101);
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f20554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f20555b;

        public e(Message r100, long r101) {
            this.f20554a = r100;
            this.f20555b = r101;
        }
    }

    static {
        f20545f = new a();
        f20546g = new b();
    }

    public f(String r100) {
        this.f20548b = new ConcurrentLinkedQueue();
        this.f20549c = new ConcurrentLinkedQueue();
        this.f20551e = new Object();
        this.f20547a = new d(this, r100);
    }

    public final void a(Runnable r100) {
        if (((ConcurrentLinkedQueue) this.f20548b).isEmpty() == true) goto L5;
    L6:
        Queue<e> r101 = this.f20548b;
        a r102 = f20545f;
        Iterator r103 = ((ConcurrentLinkedQueue) r101).iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        if (r102.a(r103.next(), r100) == false) goto L8;
        r103.remove();
        goto L8
    L12:
        Queue<Message> r104 = this.f20549c;
        b r105 = f20546g;
        Iterator r106 = ((ConcurrentLinkedQueue) r104).iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        if (r105.a(r106.next(), r100) == false) goto L14;
        r106.remove();
    L19:
        if (this.f20550d == null) goto L32;
        this.f20550d.removeCallbacks(r100);
        return;
    L32:
        return;
    L5:
        if (((ConcurrentLinkedQueue) this.f20549c).isEmpty() == true) goto L19;
        goto L6
    }

    public final boolean b(Message r100, long r101) {
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        long r102 = SystemClock.uptimeMillis() + r101;
        if (this.f20550d != null) goto L20;
        Object r103 = this.f20551e;
        monitor-enter(r103);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.f20550d != null) goto L14;
        ((ConcurrentLinkedQueue) this.f20548b).add(new e(r100, r102));     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
    L20:
        return this.f20550d.sendMessageAtTime(r100, r102);
    }
}

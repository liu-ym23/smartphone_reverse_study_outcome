package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f24473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f24474b;

    public b() {
    }

    private static void c(Collection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator r11 = r10.iterator();
        ArrayList r12 = null;
    L6:
        if (r11.hasNext() == false) goto L14;
        ((Subscription) r11.next()).unsubscribe();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r12 != null) goto L13;
        r12 = new ArrayList();
    L13:
        r12.add(th);
        goto L6
    L14:
        rx.exceptions.a.d(r12);
    }

    public void a(Subscription r10) {
        if (r10.isUnsubscribed() == false) goto L6;
        return;
    L6:
        if (this.f24474b == true) goto L22;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f24474b == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L22
    L11:
        if (this.f24473a != null) goto L15;
        this.f24473a = new HashSet(4);     // Catch: Throwable -> L13
    L15:
        this.f24473a.add(r10);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L22:
        r10.unsubscribe();
    }

    public void b(Subscription r10) {
        if (this.f24474b == true) goto L20;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f24474b == true) goto L16;
        Set r11 = this.f24473a;     // Catch: Throwable -> L14
        if (r11 == null) goto L16;
        boolean r12 = r11.remove(r10);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (r12 == false) goto L22;
        r10.unsubscribe();
        return;
    L22:
        return;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f24474b;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.f24474b == true) goto L16;
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (this.f24474b == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        this.f24474b = true;     // Catch: Throwable -> L9
        Set r10 = this.f24473a;     // Catch: Throwable -> L9
        this.f24473a = null;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        c(r10);
        return;
    }
}

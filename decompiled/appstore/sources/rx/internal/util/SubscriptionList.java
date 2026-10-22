package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscriptionList implements Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f24382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f24383b;

    public SubscriptionList() {
    }

    public static void c(Collection r10) {
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
        if (this.f24383b == true) goto L22;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f24383b == true) goto L18;
        List r11 = this.f24382a;     // Catch: Throwable -> L13
        if (r11 != null) goto L15;
        r11 = new LinkedList();     // Catch: Throwable -> L13
        this.f24382a = r11;     // Catch: Throwable -> L13
    L15:
        r11.add(r10);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L13
    L22:
        r10.unsubscribe();
    }

    public void b(Subscription r10) {
        if (this.f24383b == true) goto L19;
        monitor-enter(this);
        List r11 = this.f24382a;     // Catch: Throwable -> L13
        if (this.f24383b == true) goto L15;
        if (r11 == null) goto L15;
        boolean r12 = r11.remove(r10);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r12 == false) goto L21;
        r10.unsubscribe();
        return;
    L21:
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.f24383b;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.f24383b == true) goto L16;
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (this.f24383b == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        this.f24383b = true;     // Catch: Throwable -> L9
        List r10 = this.f24382a;     // Catch: Throwable -> L9
        this.f24382a = null;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        c(r10);
        return;
    }

    public SubscriptionList(Subscription... r10) {
        this.f24382a = new LinkedList(Arrays.asList(r10));
    }

    public SubscriptionList(Subscription r10) {
        LinkedList r11 = new LinkedList();
        this.f24382a = r11;
        r11.add(r10);
    }
}

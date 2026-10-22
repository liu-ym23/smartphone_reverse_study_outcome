package a44;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T extends v34.b<T>> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f1760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Condition f1761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Condition f1762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f1763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, T> f1764g;

    @Override // a44.a
    public final List take() {
        this.f1760c.lock();     // Catch: Throwable -> L24
    L4:
        if (this.f1759b != 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
        this.f1762e.await();     // Catch: Throwable -> L24
        goto L4
    L9:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L24
    L11:
        if (this.f1759b != 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L21;
        T r103 = this.f1763f;     // Catch: Throwable -> L24
        if (r103 == null) goto L18;
        this.f1763f = (T) r103.getNext();     // Catch: Throwable -> L24
        r103.setNext(null);     // Catch: Throwable -> L24
        HashMap<String, T> r104 = this.f1764g;     // Catch: Throwable -> L24
        TypeIntrinsics.asMutableMap(r104).remove(r103.id());     // Catch: Throwable -> L24
        this.f1759b--;     // Catch: Throwable -> L24
    L19:
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L24
        r101.add(r103);     // Catch: Throwable -> L24
        if (r101.size() < 20) goto L11;
    L18:
        r103 = null;
    L21:
        this.f1761d.signalAll();     // Catch: Throwable -> L24
        this.f1760c.unlock();
        return r101;
    L13:
        r102 = false;
        goto L14
    L6:
        r100 = false;
    L24:
        th = move-exception;
        this.f1760c.unlock();
        throw th;
    }

    public b() {
        this.f1758a = Integer.MAX_VALUE;
        ReentrantLock r100 = new ReentrantLock();
        this.f1760c = r100;
        this.f1761d = r100.newCondition();
        this.f1762e = r100.newCondition();
        this.f1764g = new HashMap();
    }

    public final void a(T r100) {
        if (TextUtils.isEmpty(r100.id()) == false) goto L5;
        return;
    L5:
        if (this.f1764g.containsKey(r100.id()) == true) goto L31;
        v34.b r101 = this.f1763f;
        if (r101 != null) goto L10;
    L19:
        r100.setNext(r101);
        this.f1763f = r100;
    L20:
        HashMap<String, T> r102 = this.f1764g;
        String r103 = r100.id();
        Intrinsics.checkNotNull(r103);
        r102.put(r103, r100);
        this.f1759b++;
    L22:
        if (this.f1759b != this.f1758a) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L32;
        this.f1761d.await();
        goto L22
    L32:
        return;
    L24:
        r104 = false;
        goto L25
    L10:
        if (r100.getPriority() >= r101.getPriority()) goto L19;
    L12:
        v34.b r105 = (v34.b) r101.getNext();
        if (r105 == null) goto L18;
        if (r100.getPriority() >= r105.getPriority()) goto L18;
        r101 = r105;
    L18:
        r100.setNext(r105);
        r101.setNext(r100);
        goto L20
    }

    @Override // a44.a
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f1764g.containsKey(r100);
    }
}

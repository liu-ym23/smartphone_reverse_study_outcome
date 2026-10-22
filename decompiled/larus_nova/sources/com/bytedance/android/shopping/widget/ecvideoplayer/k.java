package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f187409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f187410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f187411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<j> f187412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile j f187413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f187414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile j f187415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile j f187416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECVideoPlayer f187417i;

    public final void e() {
        Object r100 = this.f187414f;
        monitor-enter(r100);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (this.f187412d.size() < 2) goto L32;
        j r101 = this.f187412d.peekLast();     // Catch: Throwable -> L35
        if (r101 != null) goto L10;
        monitor-exit(r100);
        return;
    L10:
        int r102 = this.f187412d.size() - 2;     // Catch: Throwable -> L35
        int r103 = this.f187412d.size() - 1;     // Catch: Throwable -> L35
    L12:
        if (r102 < 0) goto L21;
        int r104 = this.f187412d.get(r102).getType();     // Catch: Throwable -> L35
        if (r101.getType() == 4) goto L18;
        if (r104 == 4) goto L21;
    L18:
        if (r101.getType() == r104) goto L19;
        r102 = r102 - 1;     // Catch: Throwable -> L35
        goto L12
    L19:
        Integer r105 = Integer.valueOf(r102);     // Catch: Throwable -> L35
    L22:
        if (r105 == null) goto L32;
        r105.intValue();     // Catch: Throwable -> L35
        int r106 = a.f187394a;     // Catch: Throwable -> L35
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L35
        r107.append("PlayerTaskExecutor");     // Catch: Throwable -> L35
        r107.append(hashCode());     // Catch: Throwable -> L35
        r107.append(" shrink begin from ");     // Catch: Throwable -> L35
        r107.append(r105);     // Catch: Throwable -> L35
        r107.append(" - ");     // Catch: Throwable -> L35
        r107.append(r103);     // Catch: Throwable -> L35
        r107.append(" queue: ");     // Catch: Throwable -> L35
        int r108 = ECVideoView.f187372h;     // Catch: Throwable -> L35
        r107.append(null);     // Catch: Throwable -> L35
        a.a(r107.toString());     // Catch: Throwable -> L35
        Iterator<j> r109 = this.f187412d.iterator();     // Catch: Throwable -> L35
        Iterator r110 = CollectionsKt.withIndex(r109);     // Catch: Throwable -> L35
    L25:
        if (r110.hasNext() == false) goto L31;
        IndexedValue r111 = (IndexedValue) r110.next();     // Catch: Throwable -> L35
        if (r111.getIndex() < r105.intValue()) goto L25;
        if (r111.getIndex() >= r103) goto L25;
        r109.remove();     // Catch: Throwable -> L35
        goto L25
    L31:
        int r112 = a.f187394a;     // Catch: Throwable -> L35
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L35
        r113.append("PlayerTaskExecutor");     // Catch: Throwable -> L35
        r113.append(hashCode());     // Catch: Throwable -> L35
        r113.append(" shrink end queue: ");     // Catch: Throwable -> L35
        int r114 = ECVideoView.f187372h;     // Catch: Throwable -> L35
        r113.append(null);     // Catch: Throwable -> L35
        a.a(r113.toString());     // Catch: Throwable -> L35
    L21:
        r105 = null;
    L32:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r100);
    }

    public k(ECVideoPlayer r100) {
        Intrinsics.checkNotNullParameter(r100, "ecVideoPlayer");
        this.f187417i = r100;
        this.f187409a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("PlayerTaskExecutor"));
        this.f187412d = new LinkedList();
        this.f187414f = new Object();
        this.f187416h = new f(-1);
    }

    public final void a(j r100) {
        Object r101 = this.f187414f;
        monitor-enter(r101);
        Iterator<j> r102 = this.f187412d.iterator();     // Catch: Throwable -> L16
        int r103 = a.f187394a;     // Catch: Throwable -> L16
        int r104 = ECVideoView.f187372h;     // Catch: Throwable -> L16
        a.a("PlayerTaskExecutor" + hashCode() + " addErrorTask begin queue: null");     // Catch: Throwable -> L16
    L6:
        if (r102.hasNext() == false) goto L13;
        j r105 = r102.next();     // Catch: Throwable -> L16
        if (r105.getType() == 4) goto L13;
        if (r105.getType() == 0) goto L13;
        r102.remove();     // Catch: Throwable -> L16
    L13:
        int r106 = a.f187394a;     // Catch: Throwable -> L16
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L16
        r107.append("PlayerTaskExecutor");     // Catch: Throwable -> L16
        r107.append(hashCode());     // Catch: Throwable -> L16
        r107.append(" addErrorTask end queue: ");     // Catch: Throwable -> L16
        int r108 = ECVideoView.f187372h;     // Catch: Throwable -> L16
        r107.append(null);     // Catch: Throwable -> L16
        a.a(r107.toString());     // Catch: Throwable -> L16
        a.a("PlayerTaskExecutor" + hashCode() + " enqueue to first " + r100.b());     // Catch: Throwable -> L16
        this.f187412d.addFirst(r100);     // Catch: Throwable -> L16
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean b(j r110) {
        Object r100 = this.f187414f;
        monitor-enter(r100);
        j r101 = this.f187412d.peekFirst();     // Catch: Throwable -> L82
        if (r101 != null) goto L7;
    L8:
        j r102 = this.f187415g;     // Catch: Throwable -> L82
        if (r102 != null) goto L11;
    L14:
        j r103 = this.f187412d.peekLast();     // Catch: Throwable -> L82
        if (r103 != null) goto L17;
        r103 = this.f187415g;     // Catch: Throwable -> L82
    L17:
        if (r103 != null) goto L19;
        r103 = this.f187416h;     // Catch: Throwable -> L82
    L19:
        int r104 = r103.getType();     // Catch: Throwable -> L82
        int r105 = r110.getType();     // Catch: Throwable -> L82
        if (r105 == 0) goto L65;
        if (r105 != 1) goto L23;
        if (r104 != 0) goto L56;
    L62:
        monitor-exit(r100);
        return true;
    L56:
        if ((r103 instanceof m) == true) goto L58;
    L77:
        int r106 = a.f187394a;     // Catch: Throwable -> L82
        a.a("PlayerTaskExecutor" + hashCode() + " can't enqueue " + r110.b() + ", because last is " + r103.b());     // Catch: Throwable -> L82
        monitor-exit(r100);
        return false;
    L58:
        if (((m) r103).f187421c != 0) goto L60;
        boolean r107 = true;
    L61:
        if (r107 == false) goto L77;
    L60:
        r107 = false;
        goto L61
    L23:
        if (r105 == 2) goto L49;
        if (r105 == 4) goto L41;
        if (r105 == 5) goto L38;
        if (r105 != 7) goto L77;
        if (r104 == 0) goto L32;
        if (r104 == 1) goto L32;
        if (r104 != 7) goto L77;
    L32:
        if ((r103 instanceof m) == false) goto L34;
        ((m) r110).f187421c = ((m) r103).f187421c;     // Catch: Throwable -> L82
    L35:
        monitor-exit(r100);
        return true;
    L34:
        ((m) r110).f187421c = r104;     // Catch: Throwable -> L82
        goto L35
    L38:
        if (this.f187412d.isEmpty() == false) goto L77;
        monitor-exit(r100);
        return true;
    L41:
        if (r104 != 2) goto L43;
    L47:
        monitor-exit(r100);
        return true;
    L43:
        if (r104 == (-1)) goto L47;
        if (r104 == 4) goto L47;
        if (r104 == 6) goto L47;
        if (r104 != 5) goto L77;
    L49:
        if (r104 == 0) goto L52;
        if (r104 == 1) goto L52;
        if (r104 != 7) goto L77;
    L52:
        monitor-exit(r100);
        return true;
    L65:
        if ((r103 instanceof m) == true) goto L67;
    L71:
        if (r104 == 6) goto L80;
        if (r104 == 5) goto L80;
        if (r104 == 1) goto L80;
        if (r104 == 2) goto L80;
        if (r104 != 4) goto L77;
    L80:
        monitor-exit(r100);
        return true;
    L67:
        if (((m) r103).f187421c != 1) goto L69;
        boolean r108 = true;
    L70:
        if (r108 == true) goto L80;
    L69:
        r108 = false;
        goto L70
    L11:
        if (r102.getType() != 3) goto L14;
    L12:
        monitor-exit(r100);
        return false;
    L7:
        if (r101.getType() == 3) goto L12;
    L82:
        th = move-exception;
        throw th;
    }

    public final void c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "playerTask");
        Object r101 = this.f187414f;
        monitor-enter(r101);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f187411c == false) goto L8;
        monitor-exit(r101);
        return;
    L8:
        Intrinsics.checkNotNullParameter(this, "<set-?>");     // Catch: Throwable -> L26
        r100.f187407a = this;     // Catch: Throwable -> L26
        if (r100.getType() != 3) goto L12;
        this.f187411c = true;     // Catch: Throwable -> L26
        this.f187412d.clear();     // Catch: Throwable -> L26
        int r102 = a.f187394a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " clear all task enqueue " + r100.b());     // Catch: Throwable -> L26
        this.f187412d.add(r100);     // Catch: Throwable -> L26
    L21:
        if (this.f187410b == true) goto L23;
        this.f187410b = true;     // Catch: Throwable -> L26
        d(null);     // Catch: Throwable -> L26
    L23:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r101);
        return;
    L12:
        if (r100.getType() != 10) goto L15;
        this.f187413e = r100;     // Catch: Throwable -> L26
        goto L21
    L15:
        if (r100.getType() != 6) goto L18;
        a(r100);     // Catch: Throwable -> L26
        goto L21
    L18:
        if (b(r100) == false) goto L21;
        int r104 = a.f187394a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " enqueue " + r100.b());     // Catch: Throwable -> L26
        this.f187412d.add(r100);     // Catch: Throwable -> L26
        e();     // Catch: Throwable -> L26
        goto L21
    }

    public final void d(j r100) {
        Object r101 = this.f187414f;
        monitor-enter(r101);
        if (r100 != null) goto L45;
    L8:
        String r102 = null;
        if (r100 == null) goto L16;
        if (r100.getType() != 3) goto L16;
        this.f187409a.shutdown();     // Catch: Throwable -> L26
        this.f187415g = null;     // Catch: Throwable -> L26
        this.f187410b = false;     // Catch: Throwable -> L26
        monitor-exit(r101);
        return;
    L16:
        if (this.f187413e != null) goto L18;
    L28:
        j r103 = this.f187412d.peekFirst();     // Catch: Throwable -> L26
        if (r103 != null) goto L31;
    L36:
        j r104 = this.f187412d.pollFirst();     // Catch: Throwable -> L26
    L37:
        if (r104 != null) goto L39;
        this.f187415g = null;     // Catch: Throwable -> L26
        this.f187410b = false;     // Catch: Throwable -> L26
    L40:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r101);
        return;
    L39:
        int r106 = a.f187394a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " execute next " + r104.b());     // Catch: Throwable -> L26
        this.f187415g = r104;     // Catch: Throwable -> L26
        this.f187409a.execute(r104);     // Catch: Throwable -> L26
        goto L40
    L31:
        if (r103.getType() != 0) goto L36;
        if (this.f187417i.f187339c == false) goto L35;
        r104 = this.f187412d.pollFirst();     // Catch: Throwable -> L26
        goto L37
    L35:
        r104 = null;
        goto L37
    L18:
        if (this.f187417i.f187343g.f187406d != 7) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L28;
        j r108 = this.f187413e;     // Catch: Throwable -> L26
        this.f187413e = null;     // Catch: Throwable -> L26
        int r109 = a.f187394a;     // Catch: Throwable -> L26
        StringBuilder r110 = new StringBuilder("PlayerTaskExecutor");     // Catch: Throwable -> L26
        r110.append(hashCode());     // Catch: Throwable -> L26
        r110.append(" execute priority ");     // Catch: Throwable -> L26
        if (r108 == null) goto L25;
        r102 = r108.b();     // Catch: Throwable -> L26
    L25:
        r110.append(r102);     // Catch: Throwable -> L26
        a.a(r110.toString());     // Catch: Throwable -> L26
        this.f187409a.execute(r108);     // Catch: Throwable -> L26
        goto L40
    L20:
        r107 = false;
        goto L21
    L45:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r100.getType() == 10) goto L8;
        this.f187416h = r100;     // Catch: Throwable -> L26
        goto L8
    }
}

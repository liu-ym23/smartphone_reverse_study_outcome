package db;

import android.annotation.SuppressLint;
import androidx.appcompat.widget.z0;
import cb.v;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.PrioritySort;
import hb.g;
import java.io.Closeable;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"UnspecifiedRegisterReceiverFlag"})
/* loaded from: classes.dex */
public final class d implements Closeable, b {

    /* renamed from: a, reason: collision with root package name */
    public final g f8437a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.b f8438b;

    /* renamed from: c, reason: collision with root package name */
    public final bb.a f8439c;

    /* renamed from: d, reason: collision with root package name */
    public final fb.b f8440d;

    /* renamed from: e, reason: collision with root package name */
    public final hb.c f8441e;
    public final v h;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f8442j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8443k;

    /* renamed from: l, reason: collision with root package name */
    public final PrioritySort f8444l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f8445m;

    /* renamed from: n, reason: collision with root package name */
    public volatile NetworkType f8446n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f8447o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f8448p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f8449q;
    public final c r;

    /* renamed from: s, reason: collision with root package name */
    public final z0 f8450s;

    public d(g gVar, androidx.lifecycle.b bVar, bb.a aVar, fb.b bVar2, hb.c logger, v vVar, int i10, String namespace, PrioritySort prioritySort) {
        kotlin.jvm.internal.g.f(logger, "logger");
        kotlin.jvm.internal.g.f(namespace, "namespace");
        kotlin.jvm.internal.g.f(prioritySort, "prioritySort");
        this.f8437a = gVar;
        this.f8438b = bVar;
        this.f8439c = aVar;
        this.f8440d = bVar2;
        this.f8441e = logger;
        this.h = vVar;
        this.f8442j = i10;
        this.f8443k = namespace;
        this.f8444l = prioritySort;
        this.f8445m = new Object();
        this.f8446n = NetworkType.f8174c;
        this.f8448p = true;
        this.f8449q = 500L;
        c cVar = new c(this);
        this.r = cVar;
        synchronized (bVar2.f8783b) {
            bVar2.f8784c.add(cVar);
        }
        this.f8450s = new z0(this, 12);
    }

    public final void C() {
        if (this.f8442j > 0) {
            this.f8437a.c(this.f8449q, this.f8450s);
        }
    }

    public final void K() {
        synchronized (this.f8445m) {
            this.f8449q = 500L;
            if (this.f8442j > 0) {
                this.f8437a.d(this.f8450s);
            }
            C();
            this.f8441e.a("PriorityIterator backoffTime reset to " + this.f8449q + " milliseconds");
            n nVar = n.f10413a;
        }
    }

    public final void P() {
        synchronized (this.f8445m) {
            K();
            this.f8448p = false;
            this.f8447o = false;
            C();
            this.f8441e.a("PriorityIterator started");
            n nVar = n.f10413a;
        }
    }

    @Override // db.b
    public final void a(String str) {
        this.f8437a.b(new android.llama.cpp.b(8, this, str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f8445m) {
            fb.b bVar = this.f8440d;
            c networkChangeListener = this.r;
            kotlin.jvm.internal.g.f(networkChangeListener, "networkChangeListener");
            synchronized (bVar.f8783b) {
                bVar.f8784c.remove(networkChangeListener);
            }
            n nVar = n.f10413a;
        }
    }

    public final boolean o() {
        return (this.f8448p || this.f8447o) ? false : true;
    }

    public final void w() {
        synchronized (this.f8445m) {
            if (this.f8442j > 0) {
                this.f8437a.d(this.f8450s);
            }
            this.f8447o = true;
            this.f8448p = false;
            this.f8439c.o();
            this.f8441e.a("PriorityIterator paused");
            n nVar = n.f10413a;
        }
    }
}

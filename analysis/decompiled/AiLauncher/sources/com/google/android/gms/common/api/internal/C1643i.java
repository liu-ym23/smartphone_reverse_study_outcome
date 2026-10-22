package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.C1669j;
import java.util.concurrent.Executor;
import t2.ExecutorC5504a;

/* renamed from: com.google.android.gms.common.api.internal.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1643i<L> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f19624a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f19625b;

    /* renamed from: c, reason: collision with root package name */
    public volatile a f19626c;

    /* renamed from: com.google.android.gms.common.api.internal.i$a */
    public static final class a<L> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f19627a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19628b;

        public a(L l10, String str) {
            this.f19627a = l10;
            this.f19628b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f19627a == aVar.f19627a && this.f19628b.equals(aVar.f19628b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f19627a) * 31) + this.f19628b.hashCode();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.i$b */
    public interface b<L> {
        void a(L l10);

        void b();
    }

    public C1643i(Looper looper, L l10, String str) {
        this.f19624a = new ExecutorC5504a(looper);
        this.f19625b = C1669j.l(l10, "Listener must not be null");
        this.f19626c = new a(l10, C1669j.e(str));
    }

    public void a() {
        this.f19625b = null;
        this.f19626c = null;
    }

    public a<L> b() {
        return this.f19626c;
    }

    public void c(final b<? super L> bVar) {
        C1669j.l(bVar, "Notifier must not be null");
        this.f19624a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.T
            @Override // java.lang.Runnable
            public final void run() {
                this.f19569a.d(bVar);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(b bVar) {
        Object obj = this.f19625b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e10) {
            bVar.b();
            throw e10;
        }
    }

    public C1643i(Executor executor, L l10, String str) {
        this.f19624a = (Executor) C1669j.l(executor, "Executor must not be null");
        this.f19625b = C1669j.l(l10, "Listener must not be null");
        this.f19626c = new a(l10, C1669j.e(str));
    }
}

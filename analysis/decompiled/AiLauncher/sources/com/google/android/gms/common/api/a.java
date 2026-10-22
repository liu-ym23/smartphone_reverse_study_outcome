package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.InterfaceC1639e;
import com.google.android.gms.common.api.internal.InterfaceC1646l;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.C1663d;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a<O extends d> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0224a f19492a;

    /* renamed from: b, reason: collision with root package name */
    public final g f19493b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19494c;

    /* renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0224a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, C1663d c1663d, O o10, d.a aVar, d.b bVar) {
            return (T) b(context, looper, c1663d, o10, aVar, bVar);
        }

        public T b(Context context, Looper looper, C1663d c1663d, O o10, InterfaceC1639e interfaceC1639e, InterfaceC1646l interfaceC1646l) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: q0, reason: collision with root package name */
        public static final c f19495q0 = new c(null);

        /* renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0225a extends d {
            Account getAccount();
        }

        public interface b extends d {
            GoogleSignInAccount b();
        }

        public static final class c implements d {
            public c() {
            }

            public /* synthetic */ c(j jVar) {
            }
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(String str);

        boolean b();

        String c();

        void d(AbstractC1662c.InterfaceC0227c interfaceC0227c);

        void disconnect();

        boolean e();

        boolean f();

        Set<Scope> g();

        void h(IAccountAccessor iAccountAccessor, Set<Scope> set);

        void i(AbstractC1662c.e eVar);

        boolean j();

        int l();

        Feature[] m();

        String n();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, AbstractC0224a<C, O> abstractC0224a, g<C> gVar) {
        C1669j.l(abstractC0224a, "Cannot construct an Api with a null ClientBuilder");
        C1669j.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f19494c = str;
        this.f19492a = abstractC0224a;
        this.f19493b = gVar;
    }

    public final AbstractC0224a a() {
        return this.f19492a;
    }

    public final String b() {
        return this.f19494c;
    }
}

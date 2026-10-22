package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0500u;
import androidx.datastore.preferences.protobuf.C0500u.b;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0497q<T extends C0500u.b<T>> {
    AbstractC0497q() {
    }

    abstract int a(Map.Entry<?, ?> entry);

    abstract Object b(C0496p c0496p, S s5, int i5);

    abstract C0500u<T> c(Object obj);

    abstract C0500u<T> d(Object obj);

    abstract boolean e(S s5);

    abstract void f(Object obj);

    abstract <UT, UB> UB g(g0 g0Var, Object obj, C0496p c0496p, C0500u<T> c0500u, UB ub, o0<UT, UB> o0Var);

    abstract void h(g0 g0Var, Object obj, C0496p c0496p, C0500u<T> c0500u);

    abstract void i(AbstractC0488h abstractC0488h, Object obj, C0496p c0496p, C0500u<T> c0500u);

    abstract void j(v0 v0Var, Map.Entry<?, ?> entry);
}

package e;

import android.content.Context;
import android.content.Intent;
import j4.k;

/* renamed from: e.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0674a<I, O> {

    /* renamed from: e.a$a, reason: collision with other inner class name */
    public static final class C0207a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f16630a;

        public C0207a(T t5) {
            this.f16630a = t5;
        }

        public final T a() {
            return this.f16630a;
        }
    }

    public abstract Intent a(Context context, I i5);

    public C0207a<O> b(Context context, I i5) {
        k.g(context, "context");
        return null;
    }

    public abstract O c(int i5, Intent intent);
}

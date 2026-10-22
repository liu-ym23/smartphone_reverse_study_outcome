package com.bytedance.android.window.shop.innerflow.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class e<T> {

    public static final class a<T> extends e<T> {
        public a() {
        }
    }

    public static final class b<T> extends e<T> {
        public b() {
        }
    }

    public static final class c<T> extends e<T> {
        public c() {
        }
    }

    public static final class d<T> extends e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f189193a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f189193a, ((d) r100).f189193a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f189193a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(vo=" + this.f189193a + ")";
        }

        public d(T r100) {
            this.f189193a = r100;
        }
    }

    public e() {
    }
}

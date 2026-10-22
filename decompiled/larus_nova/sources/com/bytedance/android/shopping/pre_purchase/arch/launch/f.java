package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class f<T extends j> {

    public static final class a<T extends j> extends f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f180665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f180666b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f180665a, r101.f180665a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f180666b, r101.f180666b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Throwable r100 = this.f180665a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            T r104 = this.f180666b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Failure(error=" + this.f180665a + ", fallbackData=" + this.f180666b + ")";
        }

        public a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f180665a = r100;
            this.f180666b = null;
        }
    }

    public static final class b<T extends j> extends f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f180667a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f180667a, ((b) r100).f180667a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f180667a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f180667a + ")";
        }

        public b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f180667a = r100;
        }
    }

    public f() {
    }
}

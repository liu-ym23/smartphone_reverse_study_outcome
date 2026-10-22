package com.bytedance.android.sdk.bdticketguard.utils;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164084a = 0;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f164085b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f164085b, ((b) r100).f164085b) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Throwable r100 = this.f164085b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Failure(exception=" + this.f164085b + ")";
        }

        public b(Throwable r100) {
            this.f164085b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.utils.c$c, reason: collision with other inner class name */
    public static final class C2503c<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f164086b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C2503c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f164086b, ((C2503c) r100).f164086b) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f164086b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f164086b + ")";
        }

        public C2503c(T r100) {
            this.f164086b = r100;
        }
    }

    static {
    }

    public c() {
    }

    public final Throwable a() {
        if ((this instanceof C2503c) == false) goto L6;
        return null;
    L6:
        if ((this instanceof b) == false) goto L10;
        return ((b) this).f164085b;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}

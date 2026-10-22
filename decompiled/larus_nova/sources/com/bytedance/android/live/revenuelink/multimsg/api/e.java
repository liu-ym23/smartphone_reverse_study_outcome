package com.bytedance.android.live.revenuelink.multimsg.api;

import java.lang.Exception;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class e<V, E extends Exception> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f91874a = 0;

    public static final class a {
    }

    public static final class b<E extends Exception> extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final E f91875b;

        public final int hashCode() {
            return this.f91875b.hashCode();
        }

        public final String toString() {
            return "[Failure: " + this.f91875b + ']';
        }

        public b(E r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f91875b = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.f91875b, ((b) r100).f91875b) == false) goto L10;
            return true;
        }
    }

    public static final class c<V> extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f91876b;

        public final int hashCode() {
            V r100 = this.f91876b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "[Success: " + this.f91876b + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(com.bytedance.android.live.revenuelink.multimsg.g r100) {
            this.f91876b = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
        L10:
            return false;
        L8:
            if (Intrinsics.areEqual(this.f91876b, ((c) r100).f91876b) == false) goto L10;
            return true;
        }
    }

    static {
    }

    public e() {
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class c<L, R> {

    public static final class a<L> extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f143538a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f143538a, ((a) r100).f143538a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            L r100 = this.f143538a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Left(a=" + this.f143538a + ")";
        }

        public a(L r100) {
            this.f143538a = r100;
        }
    }

    public static final class b<R> extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f143539a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f143539a, ((b) r100).f143539a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            R r100 = this.f143539a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Right(b=" + this.f143539a + ")";
        }

        public b(R r100) {
            this.f143539a = r100;
        }
    }

    public c() {
    }
}

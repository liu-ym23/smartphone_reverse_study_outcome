package aha;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class c0 implements jha.o {

    public static final class a extends c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jha.h f3493b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f3492a == r101.f3492a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3493b, r101.f3493b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f3492a * 31) + this.f3493b.hashCode();
        }

        public final String toString() {
            return "Active(refreshSequence=" + this.f3492a + ", lifecycleStage=" + this.f3493b + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3493b;
        }

        public a(int r100) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            super(r101);
            this.f3492a = r100;
            this.f3493b = r101;
        }
    }

    public static final class b extends c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jha.h f3495b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3494a, r101.f3494a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3495b, r101.f3495b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f3494a.hashCode() * 31) + this.f3495b.hashCode();
        }

        public final String toString() {
            return "Terminated(reason=" + this.f3494a + ", lifecycleStage=" + this.f3495b + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3495b;
        }

        public b(String r100) {
            jha.h.c r101 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, "reason");
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            super(r101);
            this.f3494a = r100;
            this.f3495b = r101;
        }
    }

    public c0(jha.h r100) {
    }
}

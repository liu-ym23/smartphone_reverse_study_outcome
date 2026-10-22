package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class k {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f180790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f180791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f180792c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f180790a == r101.f180790a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f180791b, r101.f180791b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f180792c, r101.f180792c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f180790a * 31;
            String r101 = this.f180791b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f180792c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "FailedState(errorCode=" + this.f180790a + ", errorMsg=" + this.f180791b + ", cause=" + this.f180792c + ')';
        }

        public a(int r100, String r101) {
            this.f180790a = r100;
            this.f180791b = r101;
            this.f180792c = null;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f180793a = null;

        static {
            f180793a = new b();
        }

        public b() {
        }
    }

    public static abstract class c extends k {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f180794a = null;

            public a() {
                super(0);
            }

            public final String toString() {
                return "Loading()";
            }

            static {
                f180794a = new a();
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f180795a = null;

            public b() {
                super(0);
            }

            public final String toString() {
                return "LoadingPreview()";
            }

            static {
                f180795a = new b();
            }
        }

        public c(int r100) {
        }
    }

    public static abstract class d extends k {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f180796a;

            public final int hashCode() {
                String r100 = this.f180796a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Cache(requestId='" + this.f180796a + "')";
            }

            public a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.f180796a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f180796a, ((a) r100).f180796a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f180797a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f180798b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f180799c;

            public final int hashCode() {
                String r100 = this.f180797a;
                if (r100 == null) goto L5;
                int r101 = r100.hashCode();
            L7:
                return (((r101 * 31) + this.f180798b) * 31) + this.f180799c;
            L5:
                r101 = 0;
                goto L7
            }

            public final String toString() {
                return "Chunk(requestId='" + this.f180797a + "', index=" + this.f180798b + ", totalChunkCount=" + this.f180799c + ')';
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L12;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f180797a, r101.f180797a) == true) goto L8;
                return false;
            L8:
                if (this.f180798b == r101.f180798b) goto L10;
                return false;
            L10:
                if (this.f180799c == r101.f180799c) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public b(String r100, int r101, int r102) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.f180797a = r100;
                this.f180798b = r101;
                this.f180799c = r102;
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f180800a;

            public final int hashCode() {
                String r100 = this.f180800a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Success(requestId='" + this.f180800a + "')";
            }

            public c(String r100) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.f180800a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f180800a, ((c) r100).f180800a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public d() {
        }
    }

    public k() {
    }
}

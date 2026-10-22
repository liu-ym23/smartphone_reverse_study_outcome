package com.bytedance.android.harmony.channel;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c<T, E> {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f58182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f58183c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            String r100 = this.f58181a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f58182b;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r102 + r105) * 31;
            boolean r107 = this.f58183c;
            if (r107 == true) goto L14;
            r104 = r107;
        L14:
            return r106 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "CloseChannel(channelId=" + this.f58181a + ", closeRead=" + this.f58182b + ", closeWrite=" + this.f58183c + ")";
        }

        @Override // com.bytedance.android.harmony.channel.c
        public final String a() {
            return this.f58181a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f58181a, r101.f58181a) == true) goto L8;
            return false;
        L8:
            if (this.f58182b == r101.f58182b) goto L10;
            return false;
        L10:
            if (this.f58183c == r101.f58183c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public a(String r100, boolean r101, boolean r102) {
            this.f58181a = r100;
            this.f58182b = r101;
            this.f58183c = r102;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f58185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f58186c;

        public final int hashCode() {
            String r100 = this.f58184a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f58185b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f58186c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CreateChannel(channelId=" + this.f58184a + ", interfaceId=" + this.f58185b + ", methodId=" + this.f58186c + ")";
        }

        @Override // com.bytedance.android.harmony.channel.c
        public final String a() {
            return this.f58184a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f58184a, r101.f58184a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f58185b, r101.f58185b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f58186c, r101.f58186c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public b(String r100, String r101, String r102) {
            this.f58184a = r100;
            this.f58185b = r101;
            this.f58186c = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.harmony.channel.c$c, reason: collision with other inner class name */
    public static final class C0923c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58187a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C0923c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f58187a, ((C0923c) r100).f58187a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f58187a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "RegisterService(interfaceId=" + this.f58187a + ")";
        }

        @Override // com.bytedance.android.harmony.channel.c
        public final String a() {
            throw new UnsupportedOperationException();
        }

        public C0923c(String r100) {
            this.f58187a = r100;
        }
    }

    public static abstract class d<T, E> extends c<T, E> {

        public static final class a<T> extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f58188a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final T f58189b;

            public final int hashCode() {
                String r100 = this.f58188a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                T r104 = this.f58189b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Data(channelId=" + this.f58188a + ", data=" + this.f58189b + ")";
            }

            @Override // com.bytedance.android.harmony.channel.c
            public final String a() {
                return this.f58188a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L10;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f58188a, r101.f58188a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f58189b, r101.f58189b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(String r100, JsonObject r101) {
                this.f58188a = r100;
                this.f58189b = r101;
            }
        }

        public static final class b<E> extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f58190a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.android.harmony.channel.b<E> f58191b;

            public final int hashCode() {
                String r100 = this.f58190a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                com.bytedance.android.harmony.channel.b<E> r104 = this.f58191b;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Error(channelId=" + this.f58190a + ", error=" + this.f58191b + ")";
            }

            @Override // com.bytedance.android.harmony.channel.c
            public final String a() {
                return this.f58190a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L10;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f58190a, r101.f58190a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f58191b, r101.f58191b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public b(String r100, com.bytedance.android.harmony.channel.b<E> r101) {
                this.f58190a = r100;
                this.f58191b = r101;
            }
        }

        public d() {
        }
    }

    public c() {
    }

    public abstract String a();
}

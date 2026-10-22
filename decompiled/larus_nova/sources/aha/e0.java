package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class e0 implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jha.h f3527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f3528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f3529f;

    public static final class a extends e0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3531h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3532i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final jha.h f3533j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, Object> f3534k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final u f3535l;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3530g, r101.f3530g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3531h, r101.f3531h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3532i, r101.f3532i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3533j, r101.f3533j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3534k, r101.f3534k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3535l, r101.f3535l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3530g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3531h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f3532i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((r106 + r108) * 31) + this.f3533j.hashCode()) * 31;
            Map<String, Object> r110 = this.f3534k;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return ((r109 + r101) * 31) + this.f3535l.hashCode();
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "END(audioScene=" + this.f3530g + ", conversationId=" + this.f3531h + ", messageId=" + this.f3532i + ", lifecycleStage=" + this.f3533j + ", ext=" + this.f3534k + ", taskMetadata=" + this.f3535l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.f3533j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.f3535l;
        }

        @Override // aha.e0
        public final String d() {
            return this.f3530g;
        }

        @Override // aha.e0
        public final String e() {
            return this.f3531h;
        }

        @Override // aha.e0
        public final String f() {
            return this.f3532i;
        }

        public a(String r100, String r110, String r111, Map r112, u r113) {
            jha.h.c r101 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r113, "taskMetadata");
            super(r100, r110, r111, r101, r112, r113);
            this.f3530g = r100;
            this.f3531h = r110;
            this.f3532i = r111;
            this.f3533j = r101;
            this.f3534k = r112;
            this.f3535l = r113;
        }
    }

    public static final class b extends e0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3536g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3537h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3538i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final jha.h f3539j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, Object> f3540k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final u f3541l;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3536g, r101.f3536g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3537h, r101.f3537h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3538i, r101.f3538i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3539j, r101.f3539j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3540k, r101.f3540k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3541l, r101.f3541l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3536g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3537h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f3538i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((r106 + r108) * 31) + this.f3539j.hashCode()) * 31;
            Map<String, Object> r110 = this.f3540k;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return ((r109 + r101) * 31) + this.f3541l.hashCode();
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PLAYING(audioScene=" + this.f3536g + ", conversationId=" + this.f3537h + ", messageId=" + this.f3538i + ", lifecycleStage=" + this.f3539j + ", ext=" + this.f3540k + ", taskMetadata=" + this.f3541l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.f3539j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.f3541l;
        }

        @Override // aha.e0
        public final String d() {
            return this.f3536g;
        }

        @Override // aha.e0
        public final String e() {
            return this.f3537h;
        }

        @Override // aha.e0
        public final String f() {
            return this.f3538i;
        }

        public b(String r100, String r110, String r111, Map r112, u r113) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r113, "taskMetadata");
            super(r100, r110, r111, r101, r112, r113);
            this.f3536g = r100;
            this.f3537h = r110;
            this.f3538i = r111;
            this.f3539j = r101;
            this.f3540k = r112;
            this.f3541l = r113;
        }
    }

    public static final class c extends e0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3542g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3543h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f3544i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final jha.h f3545j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, Object> f3546k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final u f3547l;

        public c() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f3542g, r101.f3542g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3543h, r101.f3543h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3544i, r101.f3544i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3545j, r101.f3545j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3546k, r101.f3546k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3547l, r101.f3547l) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3542g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3543h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f3544i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((r106 + r108) * 31) + this.f3545j.hashCode()) * 31;
            Map<String, Object> r110 = this.f3546k;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return ((r109 + r101) * 31) + this.f3547l.hashCode();
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PREPARING(audioScene=" + this.f3542g + ", conversationId=" + this.f3543h + ", messageId=" + this.f3544i + ", lifecycleStage=" + this.f3545j + ", ext=" + this.f3546k + ", taskMetadata=" + this.f3547l + ')';
        }

        @Override // aha.e0, jha.a
        public final jha.h a() {
            return this.f3545j;
        }

        @Override // aha.e0, aha.t
        public final u b() {
            return this.f3547l;
        }

        @Override // aha.e0
        public final String d() {
            return this.f3542g;
        }

        @Override // aha.e0
        public final String e() {
            return this.f3543h;
        }

        @Override // aha.e0
        public final String f() {
            return this.f3544i;
        }

        public c(String r100, String r110, String r111, Map r112, u r113) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r113, "taskMetadata");
            super(r100, r110, r111, r101, r112, r113);
            this.f3542g = r100;
            this.f3543h = r110;
            this.f3544i = r111;
            this.f3545j = r101;
            this.f3546k = r112;
            this.f3547l = r113;
        }
    }

    public e0() {
        throw null;
    }

    @Override // aha.t
    public final String c() {
        return b().f3670d;
    }

    @Override // aha.t
    public final String getBotId() {
        return b().f3667a;
    }

    @Override // jha.a
    public jha.h a() {
        return this.f3527d;
    }

    @Override // aha.t
    public u b() {
        return this.f3529f;
    }

    public String d() {
        return this.f3524a;
    }

    public String e() {
        return this.f3525b;
    }

    public String f() {
        return this.f3526c;
    }

    public e0(String r100, String r101, String r102, jha.h r103, Map r104, u r105) {
        this.f3524a = r100;
        this.f3525b = r101;
        this.f3526c = r102;
        this.f3527d = r103;
        this.f3528e = r104;
        this.f3529f = r105;
    }
}

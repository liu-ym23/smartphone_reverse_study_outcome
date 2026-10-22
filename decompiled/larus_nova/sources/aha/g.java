package aha;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class g implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jha.h f3551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f3552d;

    public static final class a extends g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f3554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3555g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3556h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3557i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3553e, r101.f3553e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3554f, r101.f3554f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3555g, r101.f3555g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3556h, r101.f3556h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3557i, r101.f3557i) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f3553e.hashCode() * 31) + this.f3554f.hashCode()) * 31) + this.f3555g.hashCode()) * 31) + this.f3556h.hashCode()) * 31) + this.f3557i.hashCode();
        }

        public final String toString() {
            return "Active(type=" + getType() + ", conversationId=" + this.f3555g + ')';
        }

        @Override // aha.g, jha.a
        public final jha.h a() {
            return this.f3556h;
        }

        @Override // aha.g, aha.t
        public final u b() {
            return this.f3557i;
        }

        @Override // aha.g
        public String getType() {
            return this.f3553e;
        }

        public a(String r100, Object r101, String r102, u r103) {
            jha.h.a r104 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "taskInfo");
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            Intrinsics.checkNotNullParameter(r104, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r103, "taskMetadata");
            super(r100, r101, r104, r103);
            this.f3553e = r100;
            this.f3554f = r101;
            this.f3555g = r102;
            this.f3556h = r104;
            this.f3557i = r103;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3558e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f3559f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3560g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3561h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3562i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3558e, r101.f3558e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3559f, r101.f3559f) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3560g, r101.f3560g) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3561h, r101.f3561h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3562i, r101.f3562i) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3558e.hashCode() * 31;
            Object r101 = this.f3559f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((r100 + r102) * 31) + this.f3560g.hashCode()) * 31) + this.f3561h.hashCode()) * 31) + this.f3562i.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Inactive(type=" + getType() + ", conversationId=" + this.f3560g + ')';
        }

        @Override // aha.g, jha.a
        public final jha.h a() {
            return this.f3561h;
        }

        @Override // aha.g, aha.t
        public final u b() {
            return this.f3562i;
        }

        @Override // aha.g
        public String getType() {
            return this.f3558e;
        }

        public b(String r100, Object r101, String r102, u r103) {
            jha.h.c r104 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            Intrinsics.checkNotNullParameter(r104, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r103, "taskMetadata");
            super(r100, r101, r104, r103);
            this.f3558e = r100;
            this.f3559f = r101;
            this.f3560g = r102;
            this.f3561h = r104;
            this.f3562i = r103;
        }
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
        return this.f3551c;
    }

    @Override // aha.t
    public u b() {
        return this.f3552d;
    }

    public String getType() {
        return this.f3549a;
    }

    public g(String r100, Object r101, jha.h r102, u r103) {
        this.f3549a = r100;
        this.f3550b = r101;
        this.f3551c = r102;
        this.f3552d = r103;
    }
}

package aha;

import com.huawei.hms.api.FailedBinderCallBack;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a0 implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jha.h f3462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f3463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f3464d;

    public static final class a extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f3466f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f3467g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3468h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f3469i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final u f3470j;

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
            if (Intrinsics.areEqual(this.f3465e, r101.f3465e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3466f, r101.f3466f) == true) goto L15;
            return false;
        L15:
            if (this.f3467g == r101.f3467g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3468h, r101.f3468h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3469i, r101.f3469i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3470j, r101.f3470j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3465e.hashCode() * 31;
            String r101 = this.f3466f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3467g) * 31) + this.f3468h.hashCode()) * 31;
            Map<String, Object> r105 = this.f3469i;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3470j.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(callId=" + this.f3465e + ", conversationId=" + this.f3466f + ", instanceCallState=" + this.f3467g + ", lifecycleStage=" + this.f3468h + ", ext=" + this.f3469i + ", taskMetadata=" + this.f3470j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.f3468h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.f3470j;
        }

        @Override // aha.a0
        public final int d() {
            return this.f3467g;
        }

        public a(String r100, String r101, int r102, Map r103, u r104, int r105) {
            if ((r105 & 8) == 0) goto L5;
            jha.h.a r106 = jha.h.a.f499136a;
        L7:
            if ((r105 & 16) == 0) goto L9;
            r103 = null;
        L9:
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r106, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r102, r106, r103, r104);
            this.f3465e = r100;
            this.f3466f = r101;
            this.f3467g = r102;
            this.f3468h = r106;
            this.f3469i = r103;
            this.f3470j = r104;
            return;
        L5:
            r106 = null;
            goto L7
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f3472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f3473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3474h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f3475i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final u f3476j;

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
            if (Intrinsics.areEqual(this.f3471e, r101.f3471e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3472f, r101.f3472f) == true) goto L15;
            return false;
        L15:
            if (this.f3473g == r101.f3473g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3474h, r101.f3474h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3475i, r101.f3475i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3476j, r101.f3476j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3471e.hashCode() * 31;
            String r101 = this.f3472f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3473g) * 31) + this.f3474h.hashCode()) * 31;
            Map<String, Object> r105 = this.f3475i;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3476j.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(callId=" + this.f3471e + ", conversationId=" + this.f3472f + ", instanceCallState=" + this.f3473g + ", lifecycleStage=" + this.f3474h + ", ext=" + this.f3475i + ", taskMetadata=" + this.f3476j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.f3474h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.f3476j;
        }

        @Override // aha.a0
        public final int d() {
            return this.f3473g;
        }

        public b(String r100, String r101, u r102) {
            jha.h.b r103 = jha.h.b.f499137a;
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r102, "taskMetadata");
            super(0, r103, null, r102);
            this.f3471e = r100;
            this.f3472f = r101;
            this.f3473g = 0;
            this.f3474h = r103;
            this.f3475i = null;
            this.f3476j = r102;
        }
    }

    public static final class c extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f3478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f3479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3480h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f3481i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final u f3482j;

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
            if (Intrinsics.areEqual(this.f3477e, r101.f3477e) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3478f, r101.f3478f) == true) goto L15;
            return false;
        L15:
            if (this.f3479g == r101.f3479g) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3480h, r101.f3480h) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3481i, r101.f3481i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3482j, r101.f3482j) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3477e.hashCode() * 31;
            String r101 = this.f3478f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3479g) * 31) + this.f3480h.hashCode()) * 31;
            Map<String, Object> r105 = this.f3481i;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3482j.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(callId=" + this.f3477e + ", conversationId=" + this.f3478f + ", instanceCallState=" + this.f3479g + ", lifecycleStage=" + this.f3480h + ", ext=" + this.f3481i + ", taskMetadata=" + this.f3482j + ')';
        }

        @Override // aha.a0, jha.a
        public final jha.h a() {
            return this.f3480h;
        }

        @Override // aha.a0, aha.t
        public final u b() {
            return this.f3482j;
        }

        @Override // aha.a0
        public final int d() {
            return this.f3479g;
        }

        public c(String r100, String r101, u r102) {
            jha.h.c r103 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r102, "taskMetadata");
            super(-1, r103, null, r102);
            this.f3477e = r100;
            this.f3478f = r101;
            this.f3479g = -1;
            this.f3480h = r103;
            this.f3481i = null;
            this.f3482j = r102;
        }
    }

    public a0() {
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
        return this.f3462b;
    }

    @Override // aha.t
    public u b() {
        return this.f3464d;
    }

    public int d() {
        return this.f3461a;
    }

    public a0(int r100, jha.h r101, Map r102, u r103) {
        this.f3461a = r100;
        this.f3462b = r101;
        this.f3463c = r102;
        this.f3464d = r103;
    }
}

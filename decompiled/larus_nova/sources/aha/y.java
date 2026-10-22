package aha;

import com.huawei.hms.api.FailedBinderCallBack;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class y implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3682a;

    public static final class a extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final jha.h f3686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f3687f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final u f3688g;

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
            if (Intrinsics.areEqual(this.f3683b, r101.f3683b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3684c, r101.f3684c) == true) goto L15;
            return false;
        L15:
            if (this.f3685d == r101.f3685d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3686e, r101.f3686e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3687f, r101.f3687f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3688g, r101.f3688g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3683b.hashCode() * 31;
            String r101 = this.f3684c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3685d) * 31) + this.f3686e.hashCode()) * 31;
            Map<String, Object> r105 = this.f3687f;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3688g.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(callId=" + this.f3683b + ", conversationId=" + this.f3684c + ", instanceCallState=" + this.f3685d + ", lifecycleStage=" + this.f3686e + ", ext=" + this.f3687f + ", taskMetadata=" + this.f3688g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3686e;
        }

        @Override // aha.t
        public final u b() {
            return this.f3688g;
        }

        public a(String r100, String r101, int r102, u r103) {
            jha.h.a r104 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r104, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r103, "taskMetadata");
            super(r104, null);
            this.f3683b = r100;
            this.f3684c = r101;
            this.f3685d = r102;
            this.f3686e = r104;
            this.f3687f = null;
            this.f3688g = r103;
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final jha.h f3692e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f3693f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final u f3694g;

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
            if (Intrinsics.areEqual(this.f3689b, r101.f3689b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3690c, r101.f3690c) == true) goto L15;
            return false;
        L15:
            if (this.f3691d == r101.f3691d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3692e, r101.f3692e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3693f, r101.f3693f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3694g, r101.f3694g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3689b.hashCode() * 31;
            String r101 = this.f3690c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3691d) * 31) + this.f3692e.hashCode()) * 31;
            Map<String, Object> r105 = this.f3693f;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3694g.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(callId=" + this.f3689b + ", conversationId=" + this.f3690c + ", instanceCallState=" + this.f3691d + ", lifecycleStage=" + this.f3692e + ", ext=" + this.f3693f + ", taskMetadata=" + this.f3694g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3692e;
        }

        @Override // aha.t
        public final u b() {
            return this.f3694g;
        }

        public b(String r100, String r101, u r102) {
            jha.h.b r103 = jha.h.b.f499137a;
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r102, "taskMetadata");
            super(r103, null);
            this.f3689b = r100;
            this.f3690c = r101;
            this.f3691d = 0;
            this.f3692e = r103;
            this.f3693f = null;
            this.f3694g = r102;
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final jha.h f3698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f3699f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final u f3700g;

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
            if (Intrinsics.areEqual(this.f3695b, r101.f3695b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3696c, r101.f3696c) == true) goto L15;
            return false;
        L15:
            if (this.f3697d == r101.f3697d) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3698e, r101.f3698e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3699f, r101.f3699f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3700g, r101.f3700g) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3695b.hashCode() * 31;
            String r101 = this.f3696c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f3697d) * 31) + this.f3698e.hashCode()) * 31;
            Map<String, Object> r105 = this.f3699f;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f3700g.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(callId=" + this.f3695b + ", conversationId=" + this.f3696c + ", instanceCallState=" + this.f3697d + ", lifecycleStage=" + this.f3698e + ", ext=" + this.f3699f + ", taskMetadata=" + this.f3700g + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3698e;
        }

        @Override // aha.t
        public final u b() {
            return this.f3700g;
        }

        public c(String r100, String r101, u r102) {
            jha.h.c r103 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r102, "taskMetadata");
            super(r103, null);
            this.f3695b = r100;
            this.f3696c = r101;
            this.f3697d = -1;
            this.f3698e = r103;
            this.f3699f = null;
            this.f3700g = r102;
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

    public y(jha.h r100, Map r101) {
        this.f3682a = r101;
    }
}

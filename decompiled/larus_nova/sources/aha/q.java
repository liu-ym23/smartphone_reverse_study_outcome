package aha;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatusLocal;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class q implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jha.h f3651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f3652c;

    public static final class a extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @MessageStatusLocal
        public final int f3655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Message f3656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3657h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3658i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3653d, r101.f3653d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3654e, r101.f3654e) == true) goto L15;
            return false;
        L15:
            if (this.f3655f == r101.f3655f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3656g, r101.f3656g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3657h, r101.f3657h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3658i, r101.f3658i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3653d.hashCode() * 31;
            String r101 = this.f3654e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3655f) * 31;
            Message r105 = this.f3656g;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((r104 + r102) * 31) + this.f3657h.hashCode()) * 31) + this.f3658i.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(conversationId=" + this.f3653d + ", messageId=" + this.f3654e + ", messageStatusLocal=" + this.f3655f + ", msg=" + this.f3656g + ", lifecycleStage=" + this.f3657h + ", taskMetadata=" + this.f3658i + ')';
        }

        @Override // aha.q, jha.a
        public final jha.h a() {
            return this.f3657h;
        }

        @Override // aha.q, aha.t
        public final u b() {
            return this.f3658i;
        }

        @Override // aha.q
        public final Message d() {
            return this.f3656g;
        }

        public a(String r100, String r101, int r102, Message r103, u r104) {
            jha.h.a r105 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r105, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r103, r105, r104);
            this.f3653d = r100;
            this.f3654e = r101;
            this.f3655f = r102;
            this.f3656g = r103;
            this.f3657h = r105;
            this.f3658i = r104;
        }
    }

    public static final class b extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @MessageStatusLocal
        public final int f3661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Message f3662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final jha.h f3663h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f3664i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final u f3665j;

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
            if (Intrinsics.areEqual(this.f3659d, r101.f3659d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3660e, r101.f3660e) == true) goto L15;
            return false;
        L15:
            if (this.f3661f == r101.f3661f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3662g, r101.f3662g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3663h, r101.f3663h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3664i, r101.f3664i) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3665j, r101.f3665j) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3659d.hashCode() * 31;
            String r101 = this.f3660e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3661f) * 31;
            Message r105 = this.f3662g;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (((r104 + r106) * 31) + this.f3663h.hashCode()) * 31;
            Map<String, Object> r108 = this.f3664i;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return ((r107 + r102) * 31) + this.f3665j.hashCode();
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Inactive(conversationId=" + this.f3659d + ", messageId=" + this.f3660e + ", messageStatusLocal=" + this.f3661f + ", msg=" + this.f3662g + ", lifecycleStage=" + this.f3663h + ", ext=" + this.f3664i + ", taskMetadata=" + this.f3665j + ')';
        }

        @Override // aha.q, jha.a
        public final jha.h a() {
            return this.f3663h;
        }

        @Override // aha.q, aha.t
        public final u b() {
            return this.f3665j;
        }

        @Override // aha.q
        public final Message d() {
            return this.f3662g;
        }

        public b(String r100, String r101, int r102, Message r103, Map r104, u r105) {
            jha.h.c r106 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r106, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r105, "taskMetadata");
            super(r103, r106, r105);
            this.f3659d = r100;
            this.f3660e = r101;
            this.f3661f = r102;
            this.f3662g = r103;
            this.f3663h = r106;
            this.f3664i = r104;
            this.f3665j = r105;
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
        return this.f3651b;
    }

    @Override // aha.t
    public u b() {
        return this.f3652c;
    }

    public Message d() {
        return this.f3650a;
    }

    public q(Message r100, jha.h r101, u r102) {
        this.f3650a = r100;
        this.f3651b = r101;
        this.f3652c = r102;
    }
}

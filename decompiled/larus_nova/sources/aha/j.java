package aha;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatusLocal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class j implements jha.o, t {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @MessageStatusLocal
        public final int f3601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Message f3602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final jha.h f3603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final u f3604f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3599a, r101.f3599a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3600b, r101.f3600b) == true) goto L15;
            return false;
        L15:
            if (this.f3601c == r101.f3601c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3602d, r101.f3602d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3603e, r101.f3603e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3604f, r101.f3604f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3599a.hashCode() * 31;
            String r101 = this.f3600b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3601c) * 31;
            Message r105 = this.f3602d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((r104 + r102) * 31) + this.f3603e.hashCode()) * 31) + this.f3604f.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(conversationId=" + this.f3599a + ", messageId=" + this.f3600b + ", messageStatusLocal=" + this.f3601c + ", msg=" + this.f3602d + ", lifecycleStage=" + this.f3603e + ", taskMetadata=" + this.f3604f + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3603e;
        }

        @Override // aha.t
        public final u b() {
            return this.f3604f;
        }

        public a(String r100, String r101, int r102, Message r103, jha.h.c r104, u r105) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r104, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r105, "taskMetadata");
            super(r104);
            this.f3599a = r100;
            this.f3600b = r101;
            this.f3601c = r102;
            this.f3602d = r103;
            this.f3603e = r104;
            this.f3604f = r105;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @MessageStatusLocal
        public final int f3607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Message f3608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final jha.h f3609e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final u f3610f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3605a, r101.f3605a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3606b, r101.f3606b) == true) goto L15;
            return false;
        L15:
            if (this.f3607c == r101.f3607c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3608d, r101.f3608d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3609e, r101.f3609e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3610f, r101.f3610f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3605a.hashCode() * 31;
            String r101 = this.f3606b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3607c) * 31;
            Message r105 = this.f3608d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((r104 + r102) * 31) + this.f3609e.hashCode()) * 31) + this.f3610f.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(conversationId=" + this.f3605a + ", messageId=" + this.f3606b + ", messageStatusLocal=" + this.f3607c + ", msg=" + this.f3608d + ", lifecycleStage=" + this.f3609e + ", taskMetadata=" + this.f3610f + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3609e;
        }

        @Override // aha.t
        public final u b() {
            return this.f3610f;
        }

        public b(String r100, String r101, int r102, Message r103, jha.h.a r104, u r105) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r104, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r105, "taskMetadata");
            super(r104);
            this.f3605a = r100;
            this.f3606b = r101;
            this.f3607c = r102;
            this.f3608d = r103;
            this.f3609e = r104;
            this.f3610f = r105;
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

    public j(jha.h r100) {
    }
}

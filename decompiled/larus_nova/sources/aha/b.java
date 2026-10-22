package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class b implements jha.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3483a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.h f3485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f3486d;

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
            if (Intrinsics.areEqual(this.f3484b, r101.f3484b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3485c, r101.f3485c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3486d, r101.f3486d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3484b;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3485c.hashCode()) * 31;
            Map<String, Object> r104 = this.f3486d;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(meetingId=" + this.f3484b + ", lifecycleStage=" + this.f3485c + ", ext=" + this.f3486d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3485c;
        }

        public a(String r100, Map r101) {
            jha.h.c r102 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r102, "lifecycleStage");
            super(r102, r101);
            this.f3484b = r100;
            this.f3485c = r102;
            this.f3486d = r101;
        }
    }

    /* JADX INFO: renamed from: aha.b$b, reason: collision with other inner class name */
    public static final class C0069b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.h f3488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f3489d;

        public C0069b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0069b) == true) goto L8;
            return false;
        L8:
            C0069b r101 = (C0069b) r100;
            if (Intrinsics.areEqual(this.f3487b, r101.f3487b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3488c, r101.f3488c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3489d, r101.f3489d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3487b;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3488c.hashCode()) * 31;
            Map<String, Object> r104 = this.f3489d;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Recording(meetingId=" + this.f3487b + ", lifecycleStage=" + this.f3488c + ", ext=" + this.f3489d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3488c;
        }

        public C0069b(String r100) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            super(r101, null);
            this.f3487b = r100;
            this.f3488c = r101;
            this.f3489d = null;
        }
    }

    public b(jha.h r100, Map r101) {
        this.f3483a = r101;
    }
}

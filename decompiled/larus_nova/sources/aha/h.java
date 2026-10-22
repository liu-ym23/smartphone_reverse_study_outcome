package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class h implements jha.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3564a;

    public static final class a extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.h f3566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f3567d;

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
            if (Intrinsics.areEqual(this.f3565b, r101.f3565b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3566c, r101.f3566c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3567d, r101.f3567d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f3565b.hashCode() * 31) + this.f3566c.hashCode()) * 31;
            Map<String, Object> r101 = this.f3567d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "End(messageId=" + this.f3565b + ", lifecycleStage=" + this.f3566c + ", ext=" + this.f3567d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3566c;
        }

        public a(String r100, Map r101) {
            jha.h.c r102 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r102, "lifecycleStage");
            super(r102, r101);
            this.f3565b = r100;
            this.f3566c = r102;
            this.f3567d = r101;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jha.h f3569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f3570d;

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
            if (Intrinsics.areEqual(this.f3568b, r101.f3568b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3569c, r101.f3569c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3570d, r101.f3570d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f3568b.hashCode() * 31) + this.f3569c.hashCode()) * 31;
            Map<String, Object> r101 = this.f3570d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Start(messageId=" + this.f3568b + ", lifecycleStage=" + this.f3569c + ", ext=" + this.f3570d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3569c;
        }

        public b(String r100, Map r101) {
            jha.h.a r102 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r102, "lifecycleStage");
            super(r102, r101);
            this.f3568b = r100;
            this.f3569c = r102;
            this.f3570d = r101;
        }
    }

    public h(jha.h r100, Map r101) {
        this.f3564a = r101;
    }
}

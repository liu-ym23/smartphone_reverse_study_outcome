package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class n implements jha.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jha.h f3641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f3642c;

    public static final class a extends n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ObricInteractionStateType f3644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f3645f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f3643d, r101.f3643d) == true) goto L12;
            return false;
        L12:
            if (this.f3644e == r101.f3644e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3645f, r101.f3645f) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f3643d.hashCode() * 31) + this.f3644e.hashCode()) * 31) + this.f3645f.hashCode();
        }

        public final String toString() {
            return "Active(ownerId=" + this.f3643d + ", interactionType=" + this.f3644e + ", ext=" + this.f3645f + ')';
        }

        @Override // aha.n
        public final String b() {
            return this.f3643d;
        }

        public a(String r100, ObricInteractionStateType r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "ownerId");
            Intrinsics.checkNotNullParameter(r101, "interactionType");
            Intrinsics.checkNotNullParameter(r102, "ext");
            super(r100, jha.h.a.f499136a, r102);
            this.f3643d = r100;
            this.f3644e = r101;
            this.f3645f = r102;
        }
    }

    public static final class b extends n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ObricInteractionStateType f3647e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f3648f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f3646d, r101.f3646d) == true) goto L12;
            return false;
        L12:
            if (this.f3647e == r101.f3647e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3648f, r101.f3648f) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f3646d.hashCode() * 31) + this.f3647e.hashCode()) * 31) + this.f3648f.hashCode();
        }

        public final String toString() {
            return "Inactive(ownerId=" + this.f3646d + ", interactionType=" + this.f3647e + ", ext=" + this.f3648f + ')';
        }

        @Override // aha.n
        public final String b() {
            return this.f3646d;
        }

        public b(String r100, ObricInteractionStateType r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "ownerId");
            Intrinsics.checkNotNullParameter(r101, "interactionType");
            Intrinsics.checkNotNullParameter(r102, "ext");
            super(r100, jha.h.c.f499138a, r102);
            this.f3646d = r100;
            this.f3647e = r101;
            this.f3648f = r102;
        }
    }

    public n() {
        throw null;
    }

    @Override // jha.a
    public final jha.h a() {
        return this.f3641b;
    }

    public String b() {
        return this.f3640a;
    }

    public n(String r100, jha.h r101, Map r102) {
        this.f3640a = r100;
        this.f3641b = r101;
        this.f3642c = r102;
    }
}

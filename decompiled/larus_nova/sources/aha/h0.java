package aha;

import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class h0 implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jha.h f3571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f3572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f3573c;

    public static final class a extends h0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final VoiceCaptureScene f3575e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f3576f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final jha.h f3577g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Object> f3578h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3579i;

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
            if (Intrinsics.areEqual(this.f3574d, r101.f3574d) == true) goto L12;
            return false;
        L12:
            if (this.f3575e == r101.f3575e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3576f, r101.f3576f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3577g, r101.f3577g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3578h, r101.f3578h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3579i, r101.f3579i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3574d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3575e.hashCode()) * 31;
            Integer r104 = this.f3576f;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f3577g.hashCode()) * 31;
            Map<String, Object> r107 = this.f3578h;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f3579i.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrEnd(conversationId=" + this.f3574d + ", scene=" + this.f3575e + ", sourceType=" + this.f3576f + ", lifecycleStage=" + this.f3577g + ", ext=" + this.f3578h + ", taskMetadata=" + this.f3579i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.f3577g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.f3579i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.f3578h;
        }

        public a(String r100, VoiceCaptureScene r101, Integer r102, Map r103, u r104) {
            jha.h.a r105 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r105, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r105, r103, r104);
            this.f3574d = r100;
            this.f3575e = r101;
            this.f3576f = r102;
            this.f3577g = r105;
            this.f3578h = r103;
            this.f3579i = r104;
        }
    }

    public static final class b extends h0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final VoiceCaptureScene f3581e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f3582f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final jha.h f3583g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Object> f3584h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3585i;

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
            if (Intrinsics.areEqual(this.f3580d, r101.f3580d) == true) goto L12;
            return false;
        L12:
            if (this.f3581e == r101.f3581e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3582f, r101.f3582f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3583g, r101.f3583g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3584h, r101.f3584h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3585i, r101.f3585i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3580d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3581e.hashCode()) * 31;
            Integer r104 = this.f3582f;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f3583g.hashCode()) * 31;
            Map<String, Object> r107 = this.f3584h;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f3585i.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrStart(conversationId=" + this.f3580d + ", scene=" + this.f3581e + ", sourceType=" + this.f3582f + ", lifecycleStage=" + this.f3583g + ", ext=" + this.f3584h + ", taskMetadata=" + this.f3585i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.f3583g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.f3585i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.f3584h;
        }

        public b(String r100, VoiceCaptureScene r101, Integer r102, Map r103, u r104) {
            jha.h.a r105 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r105, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r105, r103, r104);
            this.f3580d = r100;
            this.f3581e = r101;
            this.f3582f = r102;
            this.f3583g = r105;
            this.f3584h = r103;
            this.f3585i = r104;
        }
    }

    public static final class c extends h0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final VoiceCaptureScene f3587e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f3588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final jha.h f3589g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Object> f3590h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3591i;

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
            if (Intrinsics.areEqual(this.f3586d, r101.f3586d) == true) goto L12;
            return false;
        L12:
            if (this.f3587e == r101.f3587e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3588f, r101.f3588f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3589g, r101.f3589g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3590h, r101.f3590h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3591i, r101.f3591i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3586d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3587e.hashCode()) * 31;
            Integer r104 = this.f3588f;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f3589g.hashCode()) * 31;
            Map<String, Object> r107 = this.f3590h;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f3591i.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(conversationId=" + this.f3586d + ", scene=" + this.f3587e + ", sourceType=" + this.f3588f + ", lifecycleStage=" + this.f3589g + ", ext=" + this.f3590h + ", taskMetadata=" + this.f3591i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.f3589g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.f3591i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.f3590h;
        }

        public c(String r100, VoiceCaptureScene r101, Integer r102, Map r103, u r104) {
            jha.h.c r105 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r105, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r105, r103, r104);
            this.f3586d = r100;
            this.f3587e = r101;
            this.f3588f = r102;
            this.f3589g = r105;
            this.f3590h = r103;
            this.f3591i = r104;
        }
    }

    public static final class d extends h0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f3592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final VoiceCaptureScene f3593e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f3594f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final jha.h f3595g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Object> f3596h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final u f3597i;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f3592d, r101.f3592d) == true) goto L12;
            return false;
        L12:
            if (this.f3593e == r101.f3593e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3594f, r101.f3594f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3595g, r101.f3595g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3596h, r101.f3596h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3597i, r101.f3597i) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3592d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f3593e.hashCode()) * 31;
            Integer r104 = this.f3594f;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f3595g.hashCode()) * 31;
            Map<String, Object> r107 = this.f3596h;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f3597i.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(conversationId=" + this.f3592d + ", scene=" + this.f3593e + ", sourceType=" + this.f3594f + ", lifecycleStage=" + this.f3595g + ", ext=" + this.f3596h + ", taskMetadata=" + this.f3597i + ')';
        }

        @Override // aha.h0, jha.a
        public final jha.h a() {
            return this.f3595g;
        }

        @Override // aha.h0, aha.t
        public final u b() {
            return this.f3597i;
        }

        @Override // aha.h0
        public final Map<String, Object> d() {
            return this.f3596h;
        }

        public d(String r100, VoiceCaptureScene r101, Integer r102, Map r103, u r104) {
            jha.h.a r105 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r105, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r104, "taskMetadata");
            super(r105, r103, r104);
            this.f3592d = r100;
            this.f3593e = r101;
            this.f3594f = r102;
            this.f3595g = r105;
            this.f3596h = r103;
            this.f3597i = r104;
        }
    }

    public h0() {
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
        return this.f3571a;
    }

    @Override // aha.t
    public u b() {
        return this.f3573c;
    }

    public Map<String, Object> d() {
        return this.f3572b;
    }

    public h0(jha.h r100, Map r101, u r102) {
        this.f3571a = r100;
        this.f3572b = r101;
        this.f3573c = r102;
    }
}

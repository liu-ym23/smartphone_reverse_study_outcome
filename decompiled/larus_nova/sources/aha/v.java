package aha;

import com.obric.sva.sdk.utils.InteractConst;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class v implements jha.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3671a;

    public static final class a extends v {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final jha.h f3674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Object> f3675e;

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
            if (Intrinsics.areEqual(this.f3672b, r101.f3672b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3673c, r101.f3673c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3674d, r101.f3674d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3675e, r101.f3675e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3672b.hashCode() * 31;
            String r101 = this.f3673c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3674d.hashCode()) * 31;
            Map<String, Object> r105 = this.f3675e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(wakeupId=" + this.f3672b + ", wakeupSource=" + this.f3673c + ", lifecycleStage=" + this.f3674d + ", ext=" + this.f3675e + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3674d;
        }

        public a(String r100, String r101, Map r102) {
            jha.h.c r103 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_WAKEUP_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            super(r103, r102);
            this.f3672b = r100;
            this.f3673c = r101;
            this.f3674d = r103;
            this.f3675e = r102;
        }
    }

    public static final class b extends v {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final jha.h f3678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Object> f3679e;

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
            if (Intrinsics.areEqual(this.f3676b, r101.f3676b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3677c, r101.f3677c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3678d, r101.f3678d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3679e, r101.f3679e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f3676b.hashCode() * 31;
            String r101 = this.f3677c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f3678d.hashCode()) * 31;
            Map<String, Object> r105 = this.f3679e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Start(wakeupId=" + this.f3676b + ", wakeupSource=" + this.f3677c + ", lifecycleStage=" + this.f3678d + ", ext=" + this.f3679e + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.f3678d;
        }

        public b(String r100, String r101, Map r102) {
            jha.h.a r103 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_WAKEUP_ID);
            Intrinsics.checkNotNullParameter(r103, "lifecycleStage");
            super(r103, r102);
            this.f3676b = r100;
            this.f3677c = r101;
            this.f3678d = r103;
            this.f3679e = r102;
        }
    }

    public v(jha.h r100, Map r101) {
        this.f3671a = r101;
    }
}

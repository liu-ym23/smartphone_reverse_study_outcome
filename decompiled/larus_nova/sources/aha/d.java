package aha;

import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class d implements jha.o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DMTaskInfo f3498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jha.h f3499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f3500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f3501f;

    public static final class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3502g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3503h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f3504i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final DMTaskInfo f3505j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final jha.h f3506k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Map<String, String> f3507l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final u f3508m;

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
            if (Intrinsics.areEqual(this.f3502g, r101.f3502g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3503h, r101.f3503h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3504i, r101.f3504i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3505j, r101.f3505j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3506k, r101.f3506k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3507l, r101.f3507l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3508m, r101.f3508m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3502g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3503h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f3504i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            DMTaskInfo r110 = this.f3505j;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (((r109 + r111) * 31) + this.f3506k.hashCode()) * 31;
            Map<String, String> r113 = this.f3507l;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return ((r112 + r101) * 31) + this.f3508m.hashCode();
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Active(conversationId=" + this.f3502g + ", taskId=" + this.f3503h + ", dmComplexTaskState=" + this.f3504i + ", taskInfo=" + this.f3505j + ", lifecycleStage=" + this.f3506k + ", ext=" + this.f3507l + ", taskMetadata=" + this.f3508m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.f3506k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.f3508m;
        }

        @Override // aha.d
        public final String d() {
            return this.f3502g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.f3507l;
        }

        @Override // aha.d
        public final String f() {
            return this.f3503h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.f3505j;
        }

        public a(String r100, String r110, Integer r111, DMTaskInfo r112, Map r113, u r114) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r114, "taskMetadata");
            super(r100, r110, r112, r101, r113, r114);
            this.f3502g = r100;
            this.f3503h = r110;
            this.f3504i = r111;
            this.f3505j = r112;
            this.f3506k = r101;
            this.f3507l = r113;
            this.f3508m = r114;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3510h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f3511i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final DMTaskInfo f3512j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final jha.h f3513k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Map<String, String> f3514l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final u f3515m;

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
            if (Intrinsics.areEqual(this.f3509g, r101.f3509g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3510h, r101.f3510h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3511i, r101.f3511i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3512j, r101.f3512j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3513k, r101.f3513k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3514l, r101.f3514l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3515m, r101.f3515m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3509g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3510h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f3511i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            DMTaskInfo r110 = this.f3512j;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (((r109 + r111) * 31) + this.f3513k.hashCode()) * 31;
            Map<String, String> r113 = this.f3514l;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return ((r112 + r101) * 31) + this.f3515m.hashCode();
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Init(conversationId=" + this.f3509g + ", taskId=" + this.f3510h + ", dmComplexTaskState=" + this.f3511i + ", taskInfo=" + this.f3512j + ", lifecycleStage=" + this.f3513k + ", ext=" + this.f3514l + ", taskMetadata=" + this.f3515m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.f3513k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.f3515m;
        }

        @Override // aha.d
        public final String d() {
            return this.f3509g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.f3514l;
        }

        @Override // aha.d
        public final String f() {
            return this.f3510h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.f3512j;
        }

        public b(String r100, String r110, DMTaskInfo r111, Map r112, u r113) {
            jha.h.a r101 = jha.h.a.f499136a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r113, "taskMetadata");
            super(r100, r110, r111, r101, r112, r113);
            this.f3509g = r100;
            this.f3510h = r110;
            this.f3511i = null;
            this.f3512j = r111;
            this.f3513k = r101;
            this.f3514l = r112;
            this.f3515m = r113;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3516g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3517h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f3518i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final DMTaskInfo f3519j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final jha.h f3520k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Map<String, String> f3521l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final u f3522m;

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
            if (Intrinsics.areEqual(this.f3516g, r101.f3516g) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3517h, r101.f3517h) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3518i, r101.f3518i) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f3519j, r101.f3519j) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f3520k, r101.f3520k) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f3521l, r101.f3521l) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f3522m, r101.f3522m) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f3516g;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f3517h;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f3518i;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            DMTaskInfo r110 = this.f3519j;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (((r109 + r111) * 31) + this.f3520k.hashCode()) * 31;
            Map<String, String> r113 = this.f3521l;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return ((r112 + r101) * 31) + this.f3522m.hashCode();
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Terminated(conversationId=" + this.f3516g + ", taskId=" + this.f3517h + ", dmComplexTaskState=" + this.f3518i + ", taskInfo=" + this.f3519j + ", lifecycleStage=" + this.f3520k + ", ext=" + this.f3521l + ", taskMetadata=" + this.f3522m + ')';
        }

        @Override // aha.d, jha.a
        public final jha.h a() {
            return this.f3520k;
        }

        @Override // aha.d, aha.t
        public final u b() {
            return this.f3522m;
        }

        @Override // aha.d
        public final String d() {
            return this.f3516g;
        }

        @Override // aha.d
        public final Map<String, String> e() {
            return this.f3521l;
        }

        @Override // aha.d
        public final String f() {
            return this.f3517h;
        }

        @Override // aha.d
        public final DMTaskInfo g() {
            return this.f3519j;
        }

        public c(String r100, String r110, Integer r111, DMTaskInfo r112, Map r113, u r114) {
            jha.h.c r101 = jha.h.c.f499138a;
            Intrinsics.checkNotNullParameter(r101, "lifecycleStage");
            Intrinsics.checkNotNullParameter(r114, "taskMetadata");
            super(r100, r110, r112, r101, r113, r114);
            this.f3516g = r100;
            this.f3517h = r110;
            this.f3518i = r111;
            this.f3519j = r112;
            this.f3520k = r101;
            this.f3521l = r113;
            this.f3522m = r114;
        }
    }

    public d() {
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
        return this.f3499d;
    }

    @Override // aha.t
    public u b() {
        return this.f3501f;
    }

    public String d() {
        return this.f3496a;
    }

    public Map<String, String> e() {
        return this.f3500e;
    }

    public String f() {
        return this.f3497b;
    }

    public DMTaskInfo g() {
        return this.f3498c;
    }

    public d(String r100, String r101, DMTaskInfo r102, jha.h r103, Map r104, u r105) {
        this.f3496a = r100;
        this.f3497b = r101;
        this.f3498c = r102;
        this.f3499d = r103;
        this.f3500e = r104;
        this.f3501f = r105;
    }
}

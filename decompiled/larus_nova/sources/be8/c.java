package be8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f18758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f18760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f18761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f18762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f18763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f18765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f18766j;

    public c() {
        this(false, null, false, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f18757a == r101.f18757a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18758b, r101.f18758b) == true) goto L15;
        return false;
    L15:
        if (this.f18759c == r101.f18759c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18760d, r101.f18760d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18761e, r101.f18761e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18762f, r101.f18762f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f18763g, r101.f18763g) == true) goto L30;
        return false;
    L30:
        if (this.f18764h == r101.f18764h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f18765i, r101.f18765i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f18766j, r101.f18766j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f18757a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f18758b.hashCode()) * 31;
        if (this.f18759c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f18760d.hashCode()) * 31;
        f r105 = this.f18761e;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        d r109 = this.f18762f;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        e r112 = this.f18763g;
        if (r112 == null) goto L22;
        r106 = r112.hashCode();
    L22:
        int r113 = (r111 + r106) * 31;
        if (this.f18764h == true) goto L27;
        r100 = 1237;
    L27:
        return ((((r113 + r100) * 31) + this.f18765i.hashCode()) * 31) + this.f18766j.hashCode();
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillActionBarState(enabled=" + this.f18757a + ", chips=" + this.f18758b + ", showSkillItem=" + this.f18759c + ", selectedSkillIds=" + this.f18760d + ", selectedProject=" + this.f18761e + ", selectedDevice=" + this.f18762f + ", selectedFolder=" + this.f18763g + ", isCloudRuntimeSelected=" + this.f18764h + ", externallyInjectedSkillIds=" + this.f18765i + ", remoteExposedSkillIds=" + this.f18766j + ')';
    }

    public /* synthetic */ c(boolean r110, List r111, boolean r112, List r113, List r114, int r210) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = CollectionsKt.emptyList();
    L19:
        if ((r210 & 256) == 0) goto L21;
        List r115 = CollectionsKt.emptyList();
    L23:
        if ((r210 & 512) == 0) goto L25;
        List r104 = CollectionsKt.emptyList();
    L26:
        this(r100, r101, r102, r103, null, null, null, false, r115, r104);
        return;
    L25:
        r104 = null;
        goto L26
    L21:
        r115 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static c a(c r110, boolean r111, List r112, boolean r113, List r114, List r115, List r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        boolean r100 = r110.f18757a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        List r101 = r110.f18758b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r102 = r110.f18759c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        List r103 = r110.f18760d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        f r104 = r110.f18761e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        d r105 = r110.f18762f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        e r116 = r110.f18763g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        boolean r117 = r110.f18764h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        List r118 = r110.f18765i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        List r119 = r110.f18766j;
    L42:
        Intrinsics.checkNotNullParameter(r101, "chips");
        Intrinsics.checkNotNullParameter(r103, "selectedSkillIds");
        Intrinsics.checkNotNullParameter(r118, "externallyInjectedSkillIds");
        Intrinsics.checkNotNullParameter(r119, "remoteExposedSkillIds");
        return new c(r100, r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L41:
        r119 = r210;
        goto L42
    L37:
        r118 = r115;
        goto L39
    L33:
        r117 = false;
        goto L35
    L29:
        r116 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public c(boolean r100, List<b> r101, boolean r102, List<String> r103, f r104, d r105, e r106, boolean r107, List<String> r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r101, "chips");
        Intrinsics.checkNotNullParameter(r103, "selectedSkillIds");
        Intrinsics.checkNotNullParameter(r110, "externallyInjectedSkillIds");
        Intrinsics.checkNotNullParameter(r111, "remoteExposedSkillIds");
        this.f18757a = r100;
        this.f18758b = r101;
        this.f18759c = r102;
        this.f18760d = r103;
        this.f18761e = r104;
        this.f18762f = r105;
        this.f18763g = r106;
        this.f18764h = r107;
        this.f18765i = r110;
        this.f18766j = r111;
    }
}

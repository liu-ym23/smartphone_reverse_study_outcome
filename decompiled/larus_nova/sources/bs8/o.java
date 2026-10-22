package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TaskSkill> f20316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TaskSkill> f20317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TaskSkill> f20318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final be8.e f20319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f20321f;

    public o() {
        this(false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f20316a, r101.f20316a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20317b, r101.f20317b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20318c, r101.f20318c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20319d, r101.f20319d) == true) goto L21;
        return false;
    L21:
        if (this.f20320e == r101.f20320e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f20321f, r101.f20321f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f20316a.hashCode() * 31) + this.f20317b.hashCode()) * 31) + this.f20318c.hashCode()) * 31;
        be8.e r101 = this.f20319d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f20320e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Integer r107 = this.f20321f;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskSkillSessionState(selectedSkills=" + this.f20316a + ", memorizedSkills=" + this.f20317b + ", visibleSkills=" + this.f20318c + ", selectedFolder=" + this.f20319d + ", showSkillItem=" + this.f20320e + ", maxVisibleSlotCount=" + this.f20321f + ')';
    }

    public /* synthetic */ o(boolean r110, int r111) {
        List r100 = null;
        if ((r111 & 1) == 0) goto L5;
        List r101 = CollectionsKt.emptyList();
    L7:
        if ((r111 & 2) == 0) goto L9;
        List r102 = CollectionsKt.emptyList();
    L11:
        if ((r111 & 4) == 0) goto L13;
        r100 = CollectionsKt.emptyList();
    L13:
        List r103 = r100;
        if ((r111 & 16) == 0) goto L16;
        boolean r104 = false;
    L17:
        this(r101, r102, r103, null, r104, null);
        return;
    L16:
        r104 = r110;
        goto L17
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public o(List<TaskSkill> r100, List<TaskSkill> r101, List<TaskSkill> r102, be8.e r103, boolean r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "selectedSkills");
        Intrinsics.checkNotNullParameter(r101, "memorizedSkills");
        Intrinsics.checkNotNullParameter(r102, "visibleSkills");
        this.f20316a = r100;
        this.f20317b = r101;
        this.f20318c = r102;
        this.f20319d = r103;
        this.f20320e = r104;
        this.f20321f = r105;
    }

    public static o a(o r100, List r101, List r102, List r110, boolean r111, Integer r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f20316a;
    L5:
        List r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f20317b;
    L8:
        List r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r110 = r100.f20318c;
    L11:
        List r105 = r110;
        if ((r113 & 8) == 0) goto L14;
        be8.e r106 = r100.f20319d;
    L15:
        be8.e r107 = r106;
        if ((r113 & 16) == 0) goto L18;
        r111 = r100.f20320e;
    L18:
        boolean r108 = r111;
        if ((r113 & 32) == 0) goto L21;
        r112 = r100.f20321f;
    L21:
        Intrinsics.checkNotNullParameter(r103, "selectedSkills");
        Intrinsics.checkNotNullParameter(r104, "memorizedSkills");
        Intrinsics.checkNotNullParameter(r105, "visibleSkills");
        return new o(r103, r104, r105, r107, r108, r112);
    L14:
        r106 = null;
        goto L15
    }
}

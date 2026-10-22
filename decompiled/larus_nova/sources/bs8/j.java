package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TaskSkill> f20309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20310b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f20309a, r101.f20309a) == true) goto L12;
        return false;
    L12:
        if (this.f20310b == r101.f20310b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f20309a.hashCode() * 31) + this.f20310b;
    }

    public final String toString() {
        return "RecentExposedSkills(skills=" + this.f20309a + ", maxVisibleSlotCount=" + this.f20310b + ')';
    }

    public j() {
        this(CollectionsKt.emptyList(), 0);
    }

    public j(List<TaskSkill> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "skills");
        this.f20309a = r100;
        this.f20310b = r101;
    }
}

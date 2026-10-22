package bs8;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TaskSkill> f20311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20313c;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f20311a, r101.f20311a) == true) goto L12;
        return false;
    L12:
        if (this.f20312b == r101.f20312b) goto L15;
        return false;
    L15:
        if (this.f20313c == r101.f20313c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f20311a.hashCode() * 31;
        if (this.f20312b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f20313c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskSkillListCache(skills=" + this.f20311a + ", hasMore=" + this.f20312b + ", updateTimeMs=" + this.f20313c + ')';
    }

    public /* synthetic */ m(int r100) {
        this(CollectionsKt.emptyList(), false, 0);
    }

    public m(List<TaskSkill> r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "skills");
        this.f20311a = r100;
        this.f20312b = r101;
        this.f20313c = r102;
    }
}

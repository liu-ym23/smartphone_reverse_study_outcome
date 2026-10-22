package b5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.agent.skill.SkillItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJB\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lb5/d;", "", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skills", "", "total", "", "hasMore", "Lb5/h;", "counts", "<init>", "(Ljava/util/List;IZLb5/h;)V", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;IZLb5/h;)Lb5/d;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "I", "e", "Z", "c", "()Z", "Lb5/h;", "getCounts", "()Lb5/h;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: b5.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PagedSkillResponse {

    @SerializedName("counts")
    private final SkillCounts counts;
    private final boolean hasMore;
    private final List<SkillItem> skills;
    private final int total;

    public PagedSkillResponse(List<SkillItem> list, int i10, boolean z10, SkillCounts skillCounts) {
        this.skills = list;
        this.total = i10;
        this.hasMore = z10;
        this.counts = skillCounts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagedSkillResponse b(PagedSkillResponse pagedSkillResponse, List list, int i10, boolean z10, SkillCounts skillCounts, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = pagedSkillResponse.skills;
        }
        if ((i11 & 2) != 0) {
            i10 = pagedSkillResponse.total;
        }
        if ((i11 & 4) != 0) {
            z10 = pagedSkillResponse.hasMore;
        }
        if ((i11 & 8) != 0) {
            skillCounts = pagedSkillResponse.counts;
        }
        return pagedSkillResponse.a(list, i10, z10, skillCounts);
    }

    public final PagedSkillResponse a(List<SkillItem> skills, int total, boolean hasMore, SkillCounts counts) {
        return new PagedSkillResponse(skills, total, hasMore, counts);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<SkillItem> d() {
        return this.skills;
    }

    /* renamed from: e, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagedSkillResponse)) {
            return false;
        }
        PagedSkillResponse pagedSkillResponse = (PagedSkillResponse) other;
        return p.d(this.skills, pagedSkillResponse.skills) && this.total == pagedSkillResponse.total && this.hasMore == pagedSkillResponse.hasMore && p.d(this.counts, pagedSkillResponse.counts);
    }

    public int hashCode() {
        List<SkillItem> list = this.skills;
        int iHashCode = (((((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.total)) * 31) + Boolean.hashCode(this.hasMore)) * 31;
        SkillCounts skillCounts = this.counts;
        return iHashCode + (skillCounts != null ? skillCounts.hashCode() : 0);
    }

    public String toString() {
        return "PagedSkillResponse(skills=" + this.skills + ", total=" + this.total + ", hasMore=" + this.hasMore + ", counts=" + this.counts + ")";
    }

    public /* synthetic */ PagedSkillResponse(List list, int i10, boolean z10, SkillCounts skillCounts, int i11, kotlin.jvm.internal.i iVar) {
        this(list, i10, z10, (i11 & 8) != 0 ? null : skillCounts);
    }
}

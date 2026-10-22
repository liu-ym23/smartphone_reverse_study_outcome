package c5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.adapter.DisplayScope;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lc5/x;", "", "<init>", "()V", "c", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lc5/x$a;", "Lc5/x$b;", "Lc5/x$c;", "Lc5/x$d;", "Lc5/x$e;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class x {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lc5/x$b;", "Lc5/x;", "<init>", "()V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends x {
        public static final b INSTANCE = new b();

        public b() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lc5/x$c;", "Lc5/x;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "groupId", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "title", "c", DidiCardProvider.KEY_ORDER, "I", "getOrder", "showChevron", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "isClickable", Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: c5.x$c, reason: from toString */
    public static final /* data */ class GroupHeader extends x {
        private final String groupId;
        private final boolean isClickable;
        private final int order;
        private final boolean showChevron;
        private final String title;

        /* renamed from: a, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShowChevron() {
            return this.showChevron;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsClickable() {
            return this.isClickable;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GroupHeader)) {
                return false;
            }
            GroupHeader groupHeader = (GroupHeader) other;
            return kotlin.jvm.internal.p.d(this.groupId, groupHeader.groupId) && kotlin.jvm.internal.p.d(this.title, groupHeader.title) && this.order == groupHeader.order && this.showChevron == groupHeader.showChevron && this.isClickable == groupHeader.isClickable;
        }

        public int hashCode() {
            return (((((((this.groupId.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.order)) * 31) + Boolean.hashCode(this.showChevron)) * 31) + Boolean.hashCode(this.isClickable);
        }

        public String toString() {
            return "GroupHeader(groupId=" + this.groupId + ", title=" + this.title + ", order=" + this.order + ", showChevron=" + this.showChevron + ", isClickable=" + this.isClickable + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lc5/x$d;", "Lc5/x;", "<init>", "()V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends x {
        public static final d INSTANCE = new d();

        public d() {
            super(null);
        }
    }

    public /* synthetic */ x(kotlin.jvm.internal.i iVar) {
        this();
    }

    public x() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lc5/x$a;", "Lc5/x;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "isToggling", "isUninstalling", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "displayScope", "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)Lc5/x$a;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Z", "e", "()Z", "f", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "c", "()Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: c5.x$a, reason: from toString */
    public static final /* data */ class CliCard extends x {
        private final DisplayScope displayScope;
        private final boolean isToggling;
        private final boolean isUninstalling;
        private final SkillItem item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CliCard(SkillItem item, boolean z10, boolean z11, DisplayScope displayScope) {
            super(null);
            kotlin.jvm.internal.p.i(item, "item");
            this.item = item;
            this.isToggling = z10;
            this.isUninstalling = z11;
            this.displayScope = displayScope;
        }

        public static /* synthetic */ CliCard b(CliCard cliCard, SkillItem skillItem, boolean z10, boolean z11, DisplayScope displayScope, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                skillItem = cliCard.item;
            }
            if ((i10 & 2) != 0) {
                z10 = cliCard.isToggling;
            }
            if ((i10 & 4) != 0) {
                z11 = cliCard.isUninstalling;
            }
            if ((i10 & 8) != 0) {
                displayScope = cliCard.displayScope;
            }
            return cliCard.a(skillItem, z10, z11, displayScope);
        }

        public final CliCard a(SkillItem item, boolean isToggling, boolean isUninstalling, DisplayScope displayScope) {
            kotlin.jvm.internal.p.i(item, "item");
            return new CliCard(item, isToggling, isUninstalling, displayScope);
        }

        /* renamed from: c, reason: from getter */
        public final DisplayScope getDisplayScope() {
            return this.displayScope;
        }

        /* renamed from: d, reason: from getter */
        public final SkillItem getItem() {
            return this.item;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsToggling() {
            return this.isToggling;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CliCard)) {
                return false;
            }
            CliCard cliCard = (CliCard) other;
            return kotlin.jvm.internal.p.d(this.item, cliCard.item) && this.isToggling == cliCard.isToggling && this.isUninstalling == cliCard.isUninstalling && this.displayScope == cliCard.displayScope;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsUninstalling() {
            return this.isUninstalling;
        }

        public int hashCode() {
            int iHashCode = ((((this.item.hashCode() * 31) + Boolean.hashCode(this.isToggling)) * 31) + Boolean.hashCode(this.isUninstalling)) * 31;
            DisplayScope displayScope = this.displayScope;
            return iHashCode + (displayScope == null ? 0 : displayScope.hashCode());
        }

        public String toString() {
            return "CliCard(item=" + this.item + ", isToggling=" + this.isToggling + ", isUninstalling=" + this.isUninstalling + ", displayScope=" + this.displayScope + ")";
        }

        public /* synthetic */ CliCard(SkillItem skillItem, boolean z10, boolean z11, DisplayScope displayScope, int i10, kotlin.jvm.internal.i iVar) {
            this(skillItem, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? null : displayScope);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lc5/x$e;", "Lc5/x;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "isToggling", "isUninstalling", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "displayScope", "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZLcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;)Lc5/x$e;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Z", "e", "()Z", "f", "Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "c", "()Lcom/stepos/ailauncher/agent/skill/adapter/DisplayScope;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: c5.x$e, reason: from toString */
    public static final /* data */ class SkillCard extends x {
        private final DisplayScope displayScope;
        private final boolean isToggling;
        private final boolean isUninstalling;
        private final SkillItem item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkillCard(SkillItem item, boolean z10, boolean z11, DisplayScope displayScope) {
            super(null);
            kotlin.jvm.internal.p.i(item, "item");
            this.item = item;
            this.isToggling = z10;
            this.isUninstalling = z11;
            this.displayScope = displayScope;
        }

        public static /* synthetic */ SkillCard b(SkillCard skillCard, SkillItem skillItem, boolean z10, boolean z11, DisplayScope displayScope, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                skillItem = skillCard.item;
            }
            if ((i10 & 2) != 0) {
                z10 = skillCard.isToggling;
            }
            if ((i10 & 4) != 0) {
                z11 = skillCard.isUninstalling;
            }
            if ((i10 & 8) != 0) {
                displayScope = skillCard.displayScope;
            }
            return skillCard.a(skillItem, z10, z11, displayScope);
        }

        public final SkillCard a(SkillItem item, boolean isToggling, boolean isUninstalling, DisplayScope displayScope) {
            kotlin.jvm.internal.p.i(item, "item");
            return new SkillCard(item, isToggling, isUninstalling, displayScope);
        }

        /* renamed from: c, reason: from getter */
        public final DisplayScope getDisplayScope() {
            return this.displayScope;
        }

        /* renamed from: d, reason: from getter */
        public final SkillItem getItem() {
            return this.item;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsToggling() {
            return this.isToggling;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SkillCard)) {
                return false;
            }
            SkillCard skillCard = (SkillCard) other;
            return kotlin.jvm.internal.p.d(this.item, skillCard.item) && this.isToggling == skillCard.isToggling && this.isUninstalling == skillCard.isUninstalling && this.displayScope == skillCard.displayScope;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsUninstalling() {
            return this.isUninstalling;
        }

        public int hashCode() {
            int iHashCode = ((((this.item.hashCode() * 31) + Boolean.hashCode(this.isToggling)) * 31) + Boolean.hashCode(this.isUninstalling)) * 31;
            DisplayScope displayScope = this.displayScope;
            return iHashCode + (displayScope == null ? 0 : displayScope.hashCode());
        }

        public String toString() {
            return "SkillCard(item=" + this.item + ", isToggling=" + this.isToggling + ", isUninstalling=" + this.isUninstalling + ", displayScope=" + this.displayScope + ")";
        }

        public /* synthetic */ SkillCard(SkillItem skillItem, boolean z10, boolean z11, DisplayScope displayScope, int i10, kotlin.jvm.internal.i iVar) {
            this(skillItem, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? null : displayScope);
        }
    }
}

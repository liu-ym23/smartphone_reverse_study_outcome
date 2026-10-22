package com.stepos.ailauncher.agent.skill.installer;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.task.space.C3577a2;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/b;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "Lcom/stepos/ailauncher/agent/skill/installer/b$a;", "Lcom/stepos/ailauncher/agent/skill/installer/b$b;", "Lcom/stepos/ailauncher/agent/skill/installer/b$c;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class b {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/b$a;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installer.b$a, reason: from toString */
    public static final /* data */ class Failed extends b {
        private final String reason;

        public Failed(String str) {
            super(null);
            this.reason = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && p.d(this.reason, ((Failed) other).reason);
        }

        public int hashCode() {
            String str = this.reason;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Failed(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/b$b;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", C3577a2.TYPE_SKILL, "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Lcom/stepos/ailauncher/agent/skill/SkillItem;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/SkillItem;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.installer.b$b, reason: collision with other inner class name and from toString */
    public static final /* data */ class Final extends b {
        private final SkillItem skill;
        private final SkillStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Final(SkillStatus status, SkillItem skillItem) {
            super(null);
            p.i(status, "status");
            this.status = status;
            this.skill = skillItem;
        }

        /* renamed from: a, reason: from getter */
        public final SkillItem getSkill() {
            return this.skill;
        }

        /* renamed from: b, reason: from getter */
        public final SkillStatus getStatus() {
            return this.status;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Final)) {
                return false;
            }
            Final r52 = (Final) other;
            return this.status == r52.status && p.d(this.skill, r52.skill);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            SkillItem skillItem = this.skill;
            return iHashCode + (skillItem == null ? 0 : skillItem.hashCode());
        }

        public String toString() {
            return "Final(status=" + this.status + ", skill=" + this.skill + ")";
        }

        public /* synthetic */ Final(SkillStatus skillStatus, SkillItem skillItem, int i10, i iVar) {
            this(skillStatus, (i10 & 2) != 0 ? null : skillItem);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/b$c;", "Lcom/stepos/ailauncher/agent/skill/installer/b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class c extends b {
        public static final c INSTANCE = new c();

        public c() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof c);
        }

        public int hashCode() {
            return 1855907272;
        }

        public String toString() {
            return "Pending";
        }
    }

    public /* synthetic */ b(i iVar) {
        this();
    }

    public b() {
    }
}

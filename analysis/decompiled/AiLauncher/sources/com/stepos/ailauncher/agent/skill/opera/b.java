package com.stepos.ailauncher.agent.skill.opera;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/b;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/agent/skill/opera/b$a;", "Lcom/stepos/ailauncher/agent/skill/opera/b$b;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface b {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/b$a;", "Lcom/stepos/ailauncher/agent/skill/opera/b;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "inFlightStatus", "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.opera.b$a, reason: from toString */
    public static final /* data */ class Continue implements b {
        private final SkillStatus inFlightStatus;

        public Continue(SkillStatus skillStatus) {
            this.inFlightStatus = skillStatus;
        }

        /* renamed from: a, reason: from getter */
        public final SkillStatus getInFlightStatus() {
            return this.inFlightStatus;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Continue) && this.inFlightStatus == ((Continue) other).inFlightStatus;
        }

        public int hashCode() {
            SkillStatus skillStatus = this.inFlightStatus;
            if (skillStatus == null) {
                return 0;
            }
            return skillStatus.hashCode();
        }

        public String toString() {
            return "Continue(inFlightStatus=" + this.inFlightStatus + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/opera/b$b;", "Lcom/stepos/ailauncher/agent/skill/opera/b;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "status", "", C3081a.ERROR_MSG, "<init>", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.skill.opera.b$b, reason: collision with other inner class name and from toString */
    public static final /* data */ class Terminal implements b {
        private final String errorMsg;
        private final SkillStatus status;

        public Terminal(SkillStatus status, String str) {
            p.i(status, "status");
            this.status = status;
            this.errorMsg = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* renamed from: b, reason: from getter */
        public final SkillStatus getStatus() {
            return this.status;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Terminal)) {
                return false;
            }
            Terminal terminal = (Terminal) other;
            return this.status == terminal.status && p.d(this.errorMsg, terminal.errorMsg);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            String str = this.errorMsg;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Terminal(status=" + this.status + ", errorMsg=" + this.errorMsg + ")";
        }
    }
}

package com.stepos.ailauncher.oobe.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/AgentPerson;", "Ljava/io/Serializable;", "nickname", "", "template_version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getTemplate_version", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentPerson implements Serializable {
    private final String nickname;
    private final String template_version;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentPerson() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AgentPerson copy$default(AgentPerson agentPerson, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = agentPerson.nickname;
        }
        if ((i10 & 2) != 0) {
            str2 = agentPerson.template_version;
        }
        return agentPerson.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTemplate_version() {
        return this.template_version;
    }

    public final AgentPerson copy(String nickname, String template_version) {
        return new AgentPerson(nickname, template_version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentPerson)) {
            return false;
        }
        AgentPerson agentPerson = (AgentPerson) other;
        return p.d(this.nickname, agentPerson.nickname) && p.d(this.template_version, agentPerson.template_version);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getTemplate_version() {
        return this.template_version;
    }

    public int hashCode() {
        String str = this.nickname;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.template_version;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AgentPerson(nickname=" + this.nickname + ", template_version=" + this.template_version + ")";
    }

    public AgentPerson(String str, String str2) {
        this.nickname = str;
        this.template_version = str2;
    }

    public /* synthetic */ AgentPerson(String str, String str2, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}

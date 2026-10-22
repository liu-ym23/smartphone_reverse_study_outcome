package com.stepos.ailauncher.agent.aispace.skill.feishu;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/d;", "", "", "userId", "nickname", "tenantName", "avatarKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUserId", "getNickname", "getTenantName", "getAvatarKey", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.d, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeishuAccount {
    private final String avatarKey;
    private final String nickname;
    private final String tenantName;
    private final String userId;

    public FeishuAccount(String userId, String nickname, String tenantName, String str) {
        kotlin.jvm.internal.p.i(userId, "userId");
        kotlin.jvm.internal.p.i(nickname, "nickname");
        kotlin.jvm.internal.p.i(tenantName, "tenantName");
        this.userId = userId;
        this.nickname = nickname;
        this.tenantName = tenantName;
        this.avatarKey = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeishuAccount)) {
            return false;
        }
        FeishuAccount feishuAccount = (FeishuAccount) other;
        return kotlin.jvm.internal.p.d(this.userId, feishuAccount.userId) && kotlin.jvm.internal.p.d(this.nickname, feishuAccount.nickname) && kotlin.jvm.internal.p.d(this.tenantName, feishuAccount.tenantName) && kotlin.jvm.internal.p.d(this.avatarKey, feishuAccount.avatarKey);
    }

    public int hashCode() {
        int iHashCode = ((((this.userId.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.tenantName.hashCode()) * 31;
        String str = this.avatarKey;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FeishuAccount(userId=" + this.userId + ", nickname=" + this.nickname + ", tenantName=" + this.tenantName + ", avatarKey=" + this.avatarKey + ")";
    }

    public /* synthetic */ FeishuAccount(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? null : str4);
    }
}

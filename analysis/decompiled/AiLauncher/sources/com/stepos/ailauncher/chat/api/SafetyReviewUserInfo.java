package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewUserInfo;", "", "userId", "", "userName", "userIp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getUserIp", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewUserInfo {
    private final String userId;
    private final String userIp;
    private final String userName;

    public SafetyReviewUserInfo(String userId, String str, String str2) {
        p.i(userId, "userId");
        this.userId = userId;
        this.userName = str;
        this.userIp = str2;
    }

    public static /* synthetic */ SafetyReviewUserInfo copy$default(SafetyReviewUserInfo safetyReviewUserInfo, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewUserInfo.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewUserInfo.userName;
        }
        if ((i10 & 4) != 0) {
            str3 = safetyReviewUserInfo.userIp;
        }
        return safetyReviewUserInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserIp() {
        return this.userIp;
    }

    public final SafetyReviewUserInfo copy(String userId, String userName, String userIp) {
        p.i(userId, "userId");
        return new SafetyReviewUserInfo(userId, userName, userIp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewUserInfo)) {
            return false;
        }
        SafetyReviewUserInfo safetyReviewUserInfo = (SafetyReviewUserInfo) other;
        return p.d(this.userId, safetyReviewUserInfo.userId) && p.d(this.userName, safetyReviewUserInfo.userName) && p.d(this.userIp, safetyReviewUserInfo.userIp);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserIp() {
        return this.userIp;
    }

    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        int iHashCode = this.userId.hashCode() * 31;
        String str = this.userName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userIp;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SafetyReviewUserInfo(userId=" + this.userId + ", userName=" + this.userName + ", userIp=" + this.userIp + ")";
    }

    public /* synthetic */ SafetyReviewUserInfo(String str, String str2, String str3, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}

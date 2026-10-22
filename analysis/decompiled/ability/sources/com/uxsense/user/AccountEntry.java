package com.uxsense.user;

import A9.d;
import B9.T;
import B9.d0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import z9.g;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002@?BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\r\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001dJ\u0010\u0010$\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b&\u0010%JV\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b)\u0010!J\u0010\u0010*\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b*\u0010\u001fJ\u001a\u0010,\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u00103R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u0010!R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b6\u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u00109R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010:\u001a\u0004\b\u000b\u0010%\"\u0004\b;\u0010<R\"\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010:\u001a\u0004\b=\u0010%\"\u0004\b>\u0010<¨\u0006A"}, d2 = {"Lcom/uxsense/user/AccountEntry;", "", "", "userId", "", "androidUserId", "", "uuid", "nickname", "loginAt", "", "isLogin", "markTemp", AppAgent.CONSTRUCT, "(JILjava/lang/String;Ljava/lang/String;JZZ)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJILjava/lang/String;Ljava/lang/String;JZZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/user/AccountEntry;LA9/d;Lz9/g;)V", "write$Self", "component1", "()J", "component2", "()I", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "()Z", "component7", "copy", "(JILjava/lang/String;Ljava/lang/String;JZZ)Lcom/uxsense/user/AccountEntry;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "I", "getAndroidUserId", "setAndroidUserId", "(I)V", "Ljava/lang/String;", "getUuid", "getNickname", "getLoginAt", "setLoginAt", "(J)V", "Z", "setLogin", "(Z)V", "getMarkTemp", "setMarkTemp", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AccountEntry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int androidUserId;
    private boolean isLogin;
    private long loginAt;
    private boolean markTemp;
    private final String nickname;
    private final long userId;
    private final String uuid;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/user/AccountEntry$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/user/AccountEntry;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final x9.b serializer() {
            return AccountEntry$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ AccountEntry(int i, long j5, int i6, String str, String str2, long j6, boolean z10, boolean z11, d0 d0Var) {
        if (3 != (i & 3)) {
            T.g(AccountEntry$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.userId = j5;
        this.androidUserId = i6;
        if ((i & 4) == 0) {
            this.uuid = "";
        } else {
            this.uuid = str;
        }
        if ((i & 8) == 0) {
            this.nickname = "";
        } else {
            this.nickname = str2;
        }
        if ((i & 16) == 0) {
            this.loginAt = 0L;
        } else {
            this.loginAt = j6;
        }
        if ((i & 32) == 0) {
            this.isLogin = false;
        } else {
            this.isLogin = z10;
        }
        if ((i & 64) == 0) {
            this.markTemp = false;
        } else {
            this.markTemp = z11;
        }
    }

    public static /* synthetic */ AccountEntry copy$default(AccountEntry accountEntry, long j5, int i, String str, String str2, long j6, boolean z10, boolean z11, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j5 = accountEntry.userId;
        }
        long j10 = j5;
        if ((i6 & 2) != 0) {
            i = accountEntry.androidUserId;
        }
        int i10 = i;
        if ((i6 & 4) != 0) {
            str = accountEntry.uuid;
        }
        String str3 = str;
        if ((i6 & 8) != 0) {
            str2 = accountEntry.nickname;
        }
        return accountEntry.copy(j10, i10, str3, str2, (i6 & 16) != 0 ? accountEntry.loginAt : j6, (i6 & 32) != 0 ? accountEntry.isLogin : z10, (i6 & 64) != 0 ? accountEntry.markTemp : z11);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(AccountEntry self, d output, g serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.userId);
        output.encodeIntElement(serialDesc, 1, self.androidUserId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !k.b(self.uuid, "")) {
            output.encodeStringElement(serialDesc, 2, self.uuid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !k.b(self.nickname, "")) {
            output.encodeStringElement(serialDesc, 3, self.nickname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.loginAt != 0) {
            output.encodeLongElement(serialDesc, 4, self.loginAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isLogin) {
            output.encodeBooleanElement(serialDesc, 5, self.isLogin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.markTemp) {
            output.encodeBooleanElement(serialDesc, 6, self.markTemp);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAndroidUserId() {
        return this.androidUserId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLoginAt() {
        return this.loginAt;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsLogin() {
        return this.isLogin;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getMarkTemp() {
        return this.markTemp;
    }

    public final AccountEntry copy(long userId, int androidUserId, String uuid, String nickname, long loginAt, boolean isLogin, boolean markTemp) {
        k.f(uuid, "uuid");
        k.f(nickname, "nickname");
        return new AccountEntry(userId, androidUserId, uuid, nickname, loginAt, isLogin, markTemp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountEntry)) {
            return false;
        }
        AccountEntry accountEntry = (AccountEntry) other;
        return this.userId == accountEntry.userId && this.androidUserId == accountEntry.androidUserId && k.b(this.uuid, accountEntry.uuid) && k.b(this.nickname, accountEntry.nickname) && this.loginAt == accountEntry.loginAt && this.isLogin == accountEntry.isLogin && this.markTemp == accountEntry.markTemp;
    }

    public final int getAndroidUserId() {
        return this.androidUserId;
    }

    public final long getLoginAt() {
        return this.loginAt;
    }

    public final boolean getMarkTemp() {
        return this.markTemp;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return Boolean.hashCode(this.markTemp) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.androidUserId, Long.hashCode(this.userId) * 31, 31), 31, this.uuid), 31, this.nickname), 31, this.loginAt), 31, this.isLogin);
    }

    public final boolean isLogin() {
        return this.isLogin;
    }

    public final void setAndroidUserId(int i) {
        this.androidUserId = i;
    }

    public final void setLogin(boolean z10) {
        this.isLogin = z10;
    }

    public final void setLoginAt(long j5) {
        this.loginAt = j5;
    }

    public final void setMarkTemp(boolean z10) {
        this.markTemp = z10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AccountEntry(userId=");
        sb.append(this.userId);
        sb.append(", androidUserId=");
        sb.append(this.androidUserId);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", loginAt=");
        sb.append(this.loginAt);
        sb.append(", isLogin=");
        sb.append(this.isLogin);
        sb.append(", markTemp=");
        return androidx.appfunctions.metadata.a.r(sb, this.markTemp, ')');
    }

    public AccountEntry(long j5, int i, String uuid, String nickname, long j6, boolean z10, boolean z11) {
        k.f(uuid, "uuid");
        k.f(nickname, "nickname");
        this.userId = j5;
        this.androidUserId = i;
        this.uuid = uuid;
        this.nickname = nickname;
        this.loginAt = j6;
        this.isLogin = z10;
        this.markTemp = z11;
    }

    public /* synthetic */ AccountEntry(long j5, int i, String str, String str2, long j6, boolean z10, boolean z11, int i6, e eVar) {
        this(j5, i, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? "" : str2, (i6 & 16) != 0 ? 0L : j6, (i6 & 32) != 0 ? false : z10, (i6 & 64) != 0 ? false : z11);
    }
}

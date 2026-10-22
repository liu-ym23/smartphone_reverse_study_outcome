package com.uxsense.base.metadata;

import A9.d;
import B9.T;
import B9.d0;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0087\b\u0018\u0000 62\u00020\u0001:\u000276BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rBO\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b%\u0010!JL\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b(\u0010$J\u0010\u0010)\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b\u0007\u0010!R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b\b\u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u0010$R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b5\u0010!¨\u00068"}, d2 = {"Lcom/uxsense/base/metadata/FollowingUser;", "", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "", "followedAt", "", "isFollower", "isStar", "", "type", "hasChat", AppAgent.CONSTRUCT, "(Lcom/uxsense/base/metadata/User;JZZLjava/lang/String;Z)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/base/metadata/User;JZZLjava/lang/String;ZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/FollowingUser;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Lcom/uxsense/base/metadata/User;", "component2", "()J", "component3", "()Z", "component4", "component5", "()Ljava/lang/String;", "component6", "copy", "(Lcom/uxsense/base/metadata/User;JZZLjava/lang/String;Z)Lcom/uxsense/base/metadata/FollowingUser;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/uxsense/base/metadata/User;", "getUser", "J", "getFollowedAt", "Z", "Ljava/lang/String;", "getType", "getHasChat", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FollowingUser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long followedAt;
    private final boolean hasChat;
    private final boolean isFollower;
    private final boolean isStar;
    private final String type;
    private final User user;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/FollowingUser$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/FollowingUser;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return FollowingUser$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ FollowingUser(int i, User user, long j5, boolean z10, boolean z11, String str, boolean z12, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(FollowingUser$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.user = user;
        if ((i & 2) == 0) {
            this.followedAt = -1L;
        } else {
            this.followedAt = j5;
        }
        if ((i & 4) == 0) {
            this.isFollower = false;
        } else {
            this.isFollower = z10;
        }
        if ((i & 8) == 0) {
            this.isStar = false;
        } else {
            this.isStar = z11;
        }
        if ((i & 16) == 0) {
            this.type = "";
        } else {
            this.type = str;
        }
        if ((i & 32) == 0) {
            this.hasChat = false;
        } else {
            this.hasChat = z12;
        }
    }

    public static /* synthetic */ FollowingUser copy$default(FollowingUser followingUser, User user, long j5, boolean z10, boolean z11, String str, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            user = followingUser.user;
        }
        if ((i & 2) != 0) {
            j5 = followingUser.followedAt;
        }
        if ((i & 4) != 0) {
            z10 = followingUser.isFollower;
        }
        if ((i & 8) != 0) {
            z11 = followingUser.isStar;
        }
        if ((i & 16) != 0) {
            str = followingUser.type;
        }
        if ((i & 32) != 0) {
            z12 = followingUser.hasChat;
        }
        return followingUser.copy(user, j5, z10, z11, str, z12);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(FollowingUser self, d output, g serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, User$$serializer.INSTANCE, self.user);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.followedAt != -1) {
            output.encodeLongElement(serialDesc, 1, self.followedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isFollower) {
            output.encodeBooleanElement(serialDesc, 2, self.isFollower);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isStar) {
            output.encodeBooleanElement(serialDesc, 3, self.isStar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !k.b(self.type, "")) {
            output.encodeStringElement(serialDesc, 4, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.hasChat) {
            output.encodeBooleanElement(serialDesc, 5, self.hasChat);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final long getFollowedAt() {
        return this.followedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsFollower() {
        return this.isFollower;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsStar() {
        return this.isStar;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasChat() {
        return this.hasChat;
    }

    public final FollowingUser copy(User user, long followedAt, boolean isFollower, boolean isStar, String type, boolean hasChat) {
        k.f(user, "user");
        k.f(type, "type");
        return new FollowingUser(user, followedAt, isFollower, isStar, type, hasChat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowingUser)) {
            return false;
        }
        FollowingUser followingUser = (FollowingUser) other;
        return k.b(this.user, followingUser.user) && this.followedAt == followingUser.followedAt && this.isFollower == followingUser.isFollower && this.isStar == followingUser.isStar && k.b(this.type, followingUser.type) && this.hasChat == followingUser.hasChat;
    }

    public final long getFollowedAt() {
        return this.followedAt;
    }

    public final boolean getHasChat() {
        return this.hasChat;
    }

    public final String getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hasChat) + B7.a.c(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(this.user.hashCode() * 31, 31, this.followedAt), 31, this.isFollower), 31, this.isStar), 31, this.type);
    }

    public final boolean isFollower() {
        return this.isFollower;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FollowingUser(user=");
        sb.append(this.user);
        sb.append(", followedAt=");
        sb.append(this.followedAt);
        sb.append(", isFollower=");
        sb.append(this.isFollower);
        sb.append(", isStar=");
        sb.append(this.isStar);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", hasChat=");
        return androidx.appfunctions.metadata.a.r(sb, this.hasChat, ')');
    }

    public FollowingUser(User user, long j5, boolean z10, boolean z11, String type, boolean z12) {
        k.f(user, "user");
        k.f(type, "type");
        this.user = user;
        this.followedAt = j5;
        this.isFollower = z10;
        this.isStar = z11;
        this.type = type;
        this.hasChat = z12;
    }

    public /* synthetic */ FollowingUser(User user, long j5, boolean z10, boolean z11, String str, boolean z12, int i, e eVar) {
        this(user, (i & 2) != 0 ? -1L : j5, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? false : z11, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? false : z12);
    }
}

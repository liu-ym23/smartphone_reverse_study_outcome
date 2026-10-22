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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000254B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b#\u0010 JB\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b&\u0010\"J\u0010\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b\u0007\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b2\u0010\"R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b3\u0010 ¨\u00066"}, d2 = {"Lcom/uxsense/base/metadata/FollowerUser;", "", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "", "followedAt", "", "isFollowing", "", "type", "hasChat", AppAgent.CONSTRUCT, "(Lcom/uxsense/base/metadata/User;JZLjava/lang/String;Z)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILcom/uxsense/base/metadata/User;JZLjava/lang/String;ZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/FollowerUser;LA9/d;Lz9/g;)V", "write$Self", "component1", "()Lcom/uxsense/base/metadata/User;", "component2", "()J", "component3", "()Z", "component4", "()Ljava/lang/String;", "component5", "copy", "(Lcom/uxsense/base/metadata/User;JZLjava/lang/String;Z)Lcom/uxsense/base/metadata/FollowerUser;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/uxsense/base/metadata/User;", "getUser", "J", "getFollowedAt", "Z", "Ljava/lang/String;", "getType", "getHasChat", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FollowerUser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long followedAt;
    private final boolean hasChat;
    private final boolean isFollowing;
    private final String type;
    private final User user;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/FollowerUser$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/FollowerUser;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return FollowerUser$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public /* synthetic */ FollowerUser(int i, User user, long j5, boolean z10, String str, boolean z11, d0 d0Var) {
        if (1 != (i & 1)) {
            T.g(FollowerUser$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.user = user;
        if ((i & 2) == 0) {
            this.followedAt = -1L;
        } else {
            this.followedAt = j5;
        }
        if ((i & 4) == 0) {
            this.isFollowing = false;
        } else {
            this.isFollowing = z10;
        }
        if ((i & 8) == 0) {
            this.type = "";
        } else {
            this.type = str;
        }
        if ((i & 16) == 0) {
            this.hasChat = false;
        } else {
            this.hasChat = z11;
        }
    }

    public static /* synthetic */ FollowerUser copy$default(FollowerUser followerUser, User user, long j5, boolean z10, String str, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            user = followerUser.user;
        }
        if ((i & 2) != 0) {
            j5 = followerUser.followedAt;
        }
        if ((i & 4) != 0) {
            z10 = followerUser.isFollowing;
        }
        if ((i & 8) != 0) {
            str = followerUser.type;
        }
        if ((i & 16) != 0) {
            z11 = followerUser.hasChat;
        }
        boolean z12 = z11;
        boolean z13 = z10;
        return followerUser.copy(user, j5, z13, str, z12);
    }

    public static final /* synthetic */ void write$Self$uxsense_release(FollowerUser self, d output, g serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, User$$serializer.INSTANCE, self.user);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.followedAt != -1) {
            output.encodeLongElement(serialDesc, 1, self.followedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isFollowing) {
            output.encodeBooleanElement(serialDesc, 2, self.isFollowing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !k.b(self.type, "")) {
            output.encodeStringElement(serialDesc, 3, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.hasChat) {
            output.encodeBooleanElement(serialDesc, 4, self.hasChat);
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
    public final boolean getIsFollowing() {
        return this.isFollowing;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHasChat() {
        return this.hasChat;
    }

    public final FollowerUser copy(User user, long followedAt, boolean isFollowing, String type, boolean hasChat) {
        k.f(user, "user");
        k.f(type, "type");
        return new FollowerUser(user, followedAt, isFollowing, type, hasChat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowerUser)) {
            return false;
        }
        FollowerUser followerUser = (FollowerUser) other;
        return k.b(this.user, followerUser.user) && this.followedAt == followerUser.followedAt && this.isFollowing == followerUser.isFollowing && k.b(this.type, followerUser.type) && this.hasChat == followerUser.hasChat;
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
        return Boolean.hashCode(this.hasChat) + B7.a.c(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(this.user.hashCode() * 31, 31, this.followedAt), 31, this.isFollowing), 31, this.type);
    }

    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FollowerUser(user=");
        sb.append(this.user);
        sb.append(", followedAt=");
        sb.append(this.followedAt);
        sb.append(", isFollowing=");
        sb.append(this.isFollowing);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", hasChat=");
        return androidx.appfunctions.metadata.a.r(sb, this.hasChat, ')');
    }

    public FollowerUser(User user, long j5, boolean z10, String type, boolean z11) {
        k.f(user, "user");
        k.f(type, "type");
        this.user = user;
        this.followedAt = j5;
        this.isFollowing = z10;
        this.type = type;
        this.hasChat = z11;
    }

    public /* synthetic */ FollowerUser(User user, long j5, boolean z10, String str, boolean z11, int i, e eVar) {
        this(user, (i & 2) != 0 ? -1L : j5, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? false : z11);
    }
}

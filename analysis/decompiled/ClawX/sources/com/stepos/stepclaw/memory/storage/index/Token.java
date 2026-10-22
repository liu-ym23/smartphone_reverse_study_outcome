package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/Token;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, GatewayAuthConstants.AUTH_MODE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "position", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "level", "Lcom/stepos/stepclaw/memory/storage/index/NgramLevel;", "<init>", "(Ljava/lang/String;ILcom/stepos/stepclaw/memory/storage/index/NgramLevel;)V", "getToken", "()Ljava/lang/String;", "getPosition", "()I", "getLevel", "()Lcom/stepos/stepclaw/memory/storage/index/NgramLevel;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Token {
    private final NgramLevel level;
    private final int position;
    private final String token;

    public Token(String token, int i8, NgramLevel level) {
        kotlin.jvm.internal.p.e(token, "token");
        kotlin.jvm.internal.p.e(level, "level");
        this.token = token;
        this.position = i8;
        this.level = level;
    }

    public static /* synthetic */ Token copy$default(Token token, String str, int i8, NgramLevel ngramLevel, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = token.token;
        }
        if ((i9 & 2) != 0) {
            i8 = token.position;
        }
        if ((i9 & 4) != 0) {
            ngramLevel = token.level;
        }
        return token.copy(str, i8, ngramLevel);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: component3, reason: from getter */
    public final NgramLevel getLevel() {
        return this.level;
    }

    public final Token copy(String token, int position, NgramLevel level) {
        kotlin.jvm.internal.p.e(token, "token");
        kotlin.jvm.internal.p.e(level, "level");
        return new Token(token, position, level);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Token)) {
            return false;
        }
        Token token = (Token) other;
        return kotlin.jvm.internal.p.a(this.token, token.token) && this.position == token.position && this.level == token.level;
    }

    public final NgramLevel getLevel() {
        return this.level;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return this.level.hashCode() + a8.b.C(this.position, this.token.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.token;
        int i8 = this.position;
        NgramLevel ngramLevel = this.level;
        StringBuilder sbU = a8.b.u("Token(token=", i8, str, ", position=", ", level=");
        sbU.append(ngramLevel);
        sbU.append(")");
        return sbU.toString();
    }
}

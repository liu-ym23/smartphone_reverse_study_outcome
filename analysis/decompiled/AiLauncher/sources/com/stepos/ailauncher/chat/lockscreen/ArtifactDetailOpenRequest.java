package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/h;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "source", "liveSessionId", "<init>", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.h, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ArtifactDetailOpenRequest {
    private final SessionArtifact artifact;
    private final String liveSessionId;
    private final String source;

    public ArtifactDetailOpenRequest(SessionArtifact artifact, String source, String str) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        kotlin.jvm.internal.p.i(source, "source");
        this.artifact = artifact;
        this.source = source;
        this.liveSessionId = str;
    }

    /* renamed from: a, reason: from getter */
    public final SessionArtifact getArtifact() {
        return this.artifact;
    }

    /* renamed from: b, reason: from getter */
    public final String getLiveSessionId() {
        return this.liveSessionId;
    }

    /* renamed from: c, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactDetailOpenRequest)) {
            return false;
        }
        ArtifactDetailOpenRequest artifactDetailOpenRequest = (ArtifactDetailOpenRequest) other;
        return kotlin.jvm.internal.p.d(this.artifact, artifactDetailOpenRequest.artifact) && kotlin.jvm.internal.p.d(this.source, artifactDetailOpenRequest.source) && kotlin.jvm.internal.p.d(this.liveSessionId, artifactDetailOpenRequest.liveSessionId);
    }

    public int hashCode() {
        int iHashCode = ((this.artifact.hashCode() * 31) + this.source.hashCode()) * 31;
        String str = this.liveSessionId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ArtifactDetailOpenRequest(artifact=" + this.artifact + ", source=" + this.source + ", liveSessionId=" + this.liveSessionId + ")";
    }
}

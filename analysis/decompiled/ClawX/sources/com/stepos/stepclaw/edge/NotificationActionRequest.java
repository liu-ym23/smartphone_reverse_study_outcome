package com.stepos.stepclaw.edge;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/edge/NotificationActionRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.KIND, "Lcom/stepos/stepclaw/edge/NotificationActionKind;", "replyText", "<init>", "(Ljava/lang/String;Lcom/stepos/stepclaw/edge/NotificationActionKind;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getKind", "()Lcom/stepos/stepclaw/edge/NotificationActionKind;", "getReplyText", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class NotificationActionRequest {
    private final String key;
    private final NotificationActionKind kind;
    private final String replyText;

    public NotificationActionRequest(String key, NotificationActionKind kind, String str) {
        p.e(key, "key");
        p.e(kind, "kind");
        this.key = key;
        this.kind = kind;
        this.replyText = str;
    }

    public static /* synthetic */ NotificationActionRequest copy$default(NotificationActionRequest notificationActionRequest, String str, NotificationActionKind notificationActionKind, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = notificationActionRequest.key;
        }
        if ((i8 & 2) != 0) {
            notificationActionKind = notificationActionRequest.kind;
        }
        if ((i8 & 4) != 0) {
            str2 = notificationActionRequest.replyText;
        }
        return notificationActionRequest.copy(str, notificationActionKind, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final NotificationActionKind getKind() {
        return this.kind;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReplyText() {
        return this.replyText;
    }

    public final NotificationActionRequest copy(String key, NotificationActionKind kind, String replyText) {
        p.e(key, "key");
        p.e(kind, "kind");
        return new NotificationActionRequest(key, kind, replyText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationActionRequest)) {
            return false;
        }
        NotificationActionRequest notificationActionRequest = (NotificationActionRequest) other;
        return p.a(this.key, notificationActionRequest.key) && this.kind == notificationActionRequest.kind && p.a(this.replyText, notificationActionRequest.replyText);
    }

    public final String getKey() {
        return this.key;
    }

    public final NotificationActionKind getKind() {
        return this.kind;
    }

    public final String getReplyText() {
        return this.replyText;
    }

    public int hashCode() {
        int iHashCode = (this.kind.hashCode() + (this.key.hashCode() * 31)) * 31;
        String str = this.replyText;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.key;
        NotificationActionKind notificationActionKind = this.kind;
        String str2 = this.replyText;
        StringBuilder sb = new StringBuilder("NotificationActionRequest(key=");
        sb.append(str);
        sb.append(", kind=");
        sb.append(notificationActionKind);
        sb.append(", replyText=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ NotificationActionRequest(String str, NotificationActionKind notificationActionKind, String str2, int i8, i iVar) {
        this(str, notificationActionKind, (i8 & 4) != 0 ? null : str2);
    }
}

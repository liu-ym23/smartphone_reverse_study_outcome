package com.stepos.stepclaw.edge;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/edge/NotificationActionResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getOk", "()Z", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class NotificationActionResult {
    private final String code;
    private final String message;
    private final boolean ok;

    public NotificationActionResult(boolean z, String str, String str2) {
        this.ok = z;
        this.code = str;
        this.message = str2;
    }

    public static /* synthetic */ NotificationActionResult copy$default(NotificationActionResult notificationActionResult, boolean z, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = notificationActionResult.ok;
        }
        if ((i8 & 2) != 0) {
            str = notificationActionResult.code;
        }
        if ((i8 & 4) != 0) {
            str2 = notificationActionResult.message;
        }
        return notificationActionResult.copy(z, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final NotificationActionResult copy(boolean ok, String code, String message) {
        return new NotificationActionResult(ok, code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationActionResult)) {
            return false;
        }
        NotificationActionResult notificationActionResult = (NotificationActionResult) other;
        return this.ok == notificationActionResult.ok && p.a(this.code, notificationActionResult.code) && p.a(this.message, notificationActionResult.message);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        String str = this.code;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.ok;
        String str = this.code;
        String str2 = this.message;
        StringBuilder sb = new StringBuilder("NotificationActionResult(ok=");
        sb.append(z);
        sb.append(", code=");
        sb.append(str);
        sb.append(", message=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ NotificationActionResult(boolean z, String str, String str2, int i8, i iVar) {
        this(z, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2);
    }
}

package a4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"La4/o;", "", "", "wsConnected", "authed", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "getWsConnected", "()Z", Const.INTENT_KEY_PKGNAME, "getAuthed", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.o, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class BffLinkStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean wsConnected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean authed;

    /* JADX WARN: Illegal instructions before constructor call */
    public BffLinkStatus() {
        boolean z10 = false;
        this(z10, z10, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffLinkStatus)) {
            return false;
        }
        BffLinkStatus bffLinkStatus = (BffLinkStatus) other;
        return this.wsConnected == bffLinkStatus.wsConnected && this.authed == bffLinkStatus.authed;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.wsConnected) * 31) + Boolean.hashCode(this.authed);
    }

    public String toString() {
        return "BffLinkStatus(wsConnected=" + this.wsConnected + ", authed=" + this.authed + ")";
    }

    public BffLinkStatus(boolean z10, boolean z11) {
        this.wsConnected = z10;
        this.authed = z11;
    }

    public /* synthetic */ BffLinkStatus(boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11);
    }
}

package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LK6/B;", "", "", "id", BundleContentBridge.KEY_ROLE, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_UMID, "()J", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.B, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RemoteChatMessage {
    private final String content;
    private final String id;
    private final String role;
    private final long time;

    public RemoteChatMessage() {
        this(null, null, null, 0L, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: d, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteChatMessage)) {
            return false;
        }
        RemoteChatMessage remoteChatMessage = (RemoteChatMessage) other;
        return p.d(this.id, remoteChatMessage.id) && p.d(this.role, remoteChatMessage.role) && p.d(this.content, remoteChatMessage.content) && this.time == remoteChatMessage.time;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.role;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "RemoteChatMessage(id=" + this.id + ", role=" + this.role + ", content=" + this.content + ", time=" + this.time + ")";
    }

    public RemoteChatMessage(String id, String str, String str2, long j10) {
        p.i(id, "id");
        this.id = id;
        this.role = str;
        this.content = str2;
        this.time = j10;
    }

    public /* synthetic */ RemoteChatMessage(String str, String str2, String str3, long j10, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? 0L : j10);
    }
}

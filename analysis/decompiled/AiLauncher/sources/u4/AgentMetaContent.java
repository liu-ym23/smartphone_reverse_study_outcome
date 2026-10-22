package u4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lu4/b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", "getType", "text", Const.INTENT_KEY_PKGNAME, "mimeType", Const.INTENT_KEY_APIKEY, "_meta", "Ljava/lang/Object;", "get_meta", "()Ljava/lang/Object;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentMetaContent {
    private final Object _meta;
    private final String mimeType;
    private final String text;
    private final String type;

    /* renamed from: a, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMetaContent)) {
            return false;
        }
        AgentMetaContent agentMetaContent = (AgentMetaContent) other;
        return p.d(this.type, agentMetaContent.type) && p.d(this.text, agentMetaContent.text) && p.d(this.mimeType, agentMetaContent.mimeType) && p.d(this._meta, agentMetaContent._meta);
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mimeType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Object obj = this._meta;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "AgentMetaContent(type=" + this.type + ", text=" + this.text + ", mimeType=" + this.mimeType + ", _meta=" + this._meta + ")";
    }
}

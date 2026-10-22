package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LK6/u;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "text", "getText", "LK6/v;", "resource", "LK6/v;", Const.INTENT_KEY_APIKEY, "()LK6/v;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.u, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FunctionCallContent {
    private final FunctionCallContentResource resource;
    private final String text;
    private final String type;

    /* renamed from: a, reason: from getter */
    public final FunctionCallContentResource getResource() {
        return this.resource;
    }

    /* renamed from: b, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCallContent)) {
            return false;
        }
        FunctionCallContent functionCallContent = (FunctionCallContent) other;
        return p.d(this.type, functionCallContent.type) && p.d(this.text, functionCallContent.text) && p.d(this.resource, functionCallContent.resource);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        FunctionCallContentResource functionCallContentResource = this.resource;
        return iHashCode2 + (functionCallContentResource != null ? functionCallContentResource.hashCode() : 0);
    }

    public String toString() {
        return "FunctionCallContent(type=" + this.type + ", text=" + this.text + ", resource=" + this.resource + ")";
    }
}

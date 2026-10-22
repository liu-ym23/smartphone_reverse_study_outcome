package e7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0016"}, d2 = {"Le7/i;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", Const.INTENT_KEY_APIKEY, "J", "()J", "id", "", Const.INTENT_KEY_PKGNAME, "F", "()F", "score", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.i, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class RerankResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RerankResult)) {
            return false;
        }
        RerankResult rerankResult = (RerankResult) other;
        return this.id == rerankResult.id && Float.compare(this.score, rerankResult.score) == 0;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + Float.hashCode(this.score);
    }

    public String toString() {
        return "RerankResult(id=" + this.id + ", score=" + this.score + ")";
    }
}

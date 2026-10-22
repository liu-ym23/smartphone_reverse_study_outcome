package e7;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\b¨\u0006\u001f"}, d2 = {"Le7/f;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "collectionId", "", Const.INTENT_KEY_PKGNAME, "[F", "getQueryVector", "()[F", "queryVector", "", "c", "F", "getWeight", "()F", "weight", Const.INTENT_KEY_UMID, "I", "getPerCollectionTopK", "perCollectionTopK", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class MultiCollectionQuery {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String collectionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final float[] queryVector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final float weight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int perCollectionTopK;

    /* renamed from: a, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiCollectionQuery)) {
            return false;
        }
        MultiCollectionQuery multiCollectionQuery = (MultiCollectionQuery) other;
        return kotlin.jvm.internal.p.d(this.collectionId, multiCollectionQuery.collectionId) && Arrays.equals(this.queryVector, multiCollectionQuery.queryVector) && this.weight == multiCollectionQuery.weight && this.perCollectionTopK == multiCollectionQuery.perCollectionTopK;
    }

    public int hashCode() {
        return (((((this.collectionId.hashCode() * 31) + Arrays.hashCode(this.queryVector)) * 31) + Float.hashCode(this.weight)) * 31) + this.perCollectionTopK;
    }

    public String toString() {
        return "MultiCollectionQuery(collectionId=" + this.collectionId + ", queryVector=" + Arrays.toString(this.queryVector) + ", weight=" + this.weight + ", perCollectionTopK=" + this.perCollectionTopK + ")";
    }
}

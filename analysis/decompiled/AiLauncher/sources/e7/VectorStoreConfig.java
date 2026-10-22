package e7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Le7/q;", "", "", "dimension", "metric", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class VectorStoreConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int dimension;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int metric;

    public VectorStoreConfig(int i10, int i11) {
        this.dimension = i10;
        this.metric = i11;
    }

    /* renamed from: a, reason: from getter */
    public final int getDimension() {
        return this.dimension;
    }

    /* renamed from: b, reason: from getter */
    public final int getMetric() {
        return this.metric;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorStoreConfig)) {
            return false;
        }
        VectorStoreConfig vectorStoreConfig = (VectorStoreConfig) other;
        return this.dimension == vectorStoreConfig.dimension && this.metric == vectorStoreConfig.metric;
    }

    public int hashCode() {
        return (Integer.hashCode(this.dimension) * 31) + Integer.hashCode(this.metric);
    }

    public String toString() {
        return "VectorStoreConfig(dimension=" + this.dimension + ", metric=" + this.metric + ")";
    }

    public /* synthetic */ VectorStoreConfig(int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(i10, (i12 & 2) != 0 ? 2 : i11);
    }
}

package V6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"LV6/i;", "", "", "score", "", "entityId", "", "entityType", Const.LBS_FAIL_BD_ENTITY, "<init>", "(FJLjava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", "()F", Const.INTENT_KEY_PKGNAME, "J", "getEntityId", "()J", "c", "Ljava/lang/String;", "getEntityType", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "getEntity", "()Ljava/lang/Object;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: V6.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SearchHit {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float score;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long entityId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String entityType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Object entity;

    public SearchHit(float f10, long j10, String entityType, Object obj) {
        p.i(entityType, "entityType");
        this.score = f10;
        this.entityId = j10;
        this.entityType = entityType;
        this.entity = obj;
    }

    /* renamed from: a, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHit)) {
            return false;
        }
        SearchHit searchHit = (SearchHit) other;
        return Float.compare(this.score, searchHit.score) == 0 && this.entityId == searchHit.entityId && p.d(this.entityType, searchHit.entityType) && p.d(this.entity, searchHit.entity);
    }

    public int hashCode() {
        int iHashCode = ((((Float.hashCode(this.score) * 31) + Long.hashCode(this.entityId)) * 31) + this.entityType.hashCode()) * 31;
        Object obj = this.entity;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "SearchHit(score=" + this.score + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ", entity=" + this.entity + ")";
    }
}

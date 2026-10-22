package c7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0012\u0010\n¨\u0006\u0018"}, d2 = {"Lc7/a;", "", "", "docId", "", "tableName", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "Ljava/lang/String;", "c", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: c7.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class FtsDocument {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long docId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tableName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    public FtsDocument(long j10, String tableName, String content) {
        p.i(tableName, "tableName");
        p.i(content, "content");
        this.docId = j10;
        this.tableName = tableName;
        this.content = content;
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final long getDocId() {
        return this.docId;
    }

    /* renamed from: c, reason: from getter */
    public final String getTableName() {
        return this.tableName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FtsDocument)) {
            return false;
        }
        FtsDocument ftsDocument = (FtsDocument) other;
        return this.docId == ftsDocument.docId && p.d(this.tableName, ftsDocument.tableName) && p.d(this.content, ftsDocument.content);
    }

    public int hashCode() {
        return (((Long.hashCode(this.docId) * 31) + this.tableName.hashCode()) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "FtsDocument(docId=" + this.docId + ", tableName=" + this.tableName + ", content=" + this.content + ")";
    }
}

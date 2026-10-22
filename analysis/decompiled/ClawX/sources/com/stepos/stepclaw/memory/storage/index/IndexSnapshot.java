package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "invertedIndex", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/Posting;", "docMetas", "Lcom/stepos/stepclaw/memory/storage/index/DocMeta;", "docContents", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getInvertedIndex", "()Ljava/util/Map;", "getDocMetas", "getDocContents", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class IndexSnapshot {
    private final Map<String, String> docContents;
    private final Map<String, DocMeta> docMetas;
    private final Map<String, List<Posting>> invertedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public IndexSnapshot(Map<String, ? extends List<Posting>> invertedIndex, Map<String, DocMeta> docMetas, Map<String, String> docContents) {
        kotlin.jvm.internal.p.e(invertedIndex, "invertedIndex");
        kotlin.jvm.internal.p.e(docMetas, "docMetas");
        kotlin.jvm.internal.p.e(docContents, "docContents");
        this.invertedIndex = invertedIndex;
        this.docMetas = docMetas;
        this.docContents = docContents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexSnapshot copy$default(IndexSnapshot indexSnapshot, Map map, Map map2, Map map3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            map = indexSnapshot.invertedIndex;
        }
        if ((i8 & 2) != 0) {
            map2 = indexSnapshot.docMetas;
        }
        if ((i8 & 4) != 0) {
            map3 = indexSnapshot.docContents;
        }
        return indexSnapshot.copy(map, map2, map3);
    }

    public final Map<String, List<Posting>> component1() {
        return this.invertedIndex;
    }

    public final Map<String, DocMeta> component2() {
        return this.docMetas;
    }

    public final Map<String, String> component3() {
        return this.docContents;
    }

    public final IndexSnapshot copy(Map<String, ? extends List<Posting>> invertedIndex, Map<String, DocMeta> docMetas, Map<String, String> docContents) {
        kotlin.jvm.internal.p.e(invertedIndex, "invertedIndex");
        kotlin.jvm.internal.p.e(docMetas, "docMetas");
        kotlin.jvm.internal.p.e(docContents, "docContents");
        return new IndexSnapshot(invertedIndex, docMetas, docContents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexSnapshot)) {
            return false;
        }
        IndexSnapshot indexSnapshot = (IndexSnapshot) other;
        return kotlin.jvm.internal.p.a(this.invertedIndex, indexSnapshot.invertedIndex) && kotlin.jvm.internal.p.a(this.docMetas, indexSnapshot.docMetas) && kotlin.jvm.internal.p.a(this.docContents, indexSnapshot.docContents);
    }

    public final Map<String, String> getDocContents() {
        return this.docContents;
    }

    public final Map<String, DocMeta> getDocMetas() {
        return this.docMetas;
    }

    public final Map<String, List<Posting>> getInvertedIndex() {
        return this.invertedIndex;
    }

    public int hashCode() {
        return this.docContents.hashCode() + ((this.docMetas.hashCode() + (this.invertedIndex.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "IndexSnapshot(invertedIndex=" + this.invertedIndex + ", docMetas=" + this.docMetas + ", docContents=" + this.docContents + ")";
    }
}

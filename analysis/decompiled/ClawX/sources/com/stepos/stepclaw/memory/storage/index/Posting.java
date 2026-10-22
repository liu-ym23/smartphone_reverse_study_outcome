package com.stepos.stepclaw.memory.storage.index;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/Posting;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "frequency", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "positions", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getDocId", "()Ljava/lang/String;", "getFrequency", "()I", "getPositions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Posting {
    private final String docId;
    private final int frequency;
    private final List<Integer> positions;

    public Posting(String docId, int i8, List<Integer> positions) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(positions, "positions");
        this.docId = docId;
        this.frequency = i8;
        this.positions = positions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Posting copy$default(Posting posting, String str, int i8, List list, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = posting.docId;
        }
        if ((i9 & 2) != 0) {
            i8 = posting.frequency;
        }
        if ((i9 & 4) != 0) {
            list = posting.positions;
        }
        return posting.copy(str, i8, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFrequency() {
        return this.frequency;
    }

    public final List<Integer> component3() {
        return this.positions;
    }

    public final Posting copy(String docId, int frequency, List<Integer> positions) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(positions, "positions");
        return new Posting(docId, frequency, positions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Posting)) {
            return false;
        }
        Posting posting = (Posting) other;
        return kotlin.jvm.internal.p.a(this.docId, posting.docId) && this.frequency == posting.frequency && kotlin.jvm.internal.p.a(this.positions, posting.positions);
    }

    public final String getDocId() {
        return this.docId;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final List<Integer> getPositions() {
        return this.positions;
    }

    public int hashCode() {
        return this.positions.hashCode() + a8.b.C(this.frequency, this.docId.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.docId;
        int i8 = this.frequency;
        List<Integer> list = this.positions;
        StringBuilder sbU = a8.b.u("Posting(docId=", i8, str, ", frequency=", ", positions=");
        sbU.append(list);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ Posting(String str, int i8, List list, int i9, kotlin.jvm.internal.i iVar) {
        this(str, i8, (i9 & 4) != 0 ? s.f1092a : list);
    }
}

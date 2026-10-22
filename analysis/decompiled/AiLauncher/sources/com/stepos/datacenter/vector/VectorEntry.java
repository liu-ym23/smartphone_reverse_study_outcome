package com.stepos.datacenter.vector;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006&"}, d2 = {"Lcom/stepos/datacenter/vector/VectorEntry;", "", "id", "", "vector", "", "label", "", QueryAlgorithmBundle.KEY_CATEGORY, "", "metadata", "collection", "<init>", "(J[FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getVector", "()[F", "getLabel", "()Ljava/lang/String;", "getCategory", "()I", "getMetadata", "getCollection", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VectorEntry {
    private final int category;
    private final String collection;
    private long id;
    private final String label;
    private final String metadata;
    private final float[] vector;

    public VectorEntry(long j10, float[] vector, String label, int i10, String metadata, String collection) {
        p.i(vector, "vector");
        p.i(label, "label");
        p.i(metadata, "metadata");
        p.i(collection, "collection");
        this.id = j10;
        this.vector = vector;
        this.label = label;
        this.category = i10;
        this.metadata = metadata;
        this.collection = collection;
    }

    public static /* synthetic */ VectorEntry copy$default(VectorEntry vectorEntry, long j10, float[] fArr, String str, int i10, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = vectorEntry.id;
        }
        long j11 = j10;
        if ((i11 & 2) != 0) {
            fArr = vectorEntry.vector;
        }
        float[] fArr2 = fArr;
        if ((i11 & 4) != 0) {
            str = vectorEntry.label;
        }
        String str4 = str;
        if ((i11 & 8) != 0) {
            i10 = vectorEntry.category;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str2 = vectorEntry.metadata;
        }
        String str5 = str2;
        if ((i11 & 32) != 0) {
            str3 = vectorEntry.collection;
        }
        return vectorEntry.copy(j11, fArr2, str4, i12, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final float[] getVector() {
        return this.vector;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMetadata() {
        return this.metadata;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCollection() {
        return this.collection;
    }

    public final VectorEntry copy(long id, float[] vector, String label, int category, String metadata, String collection) {
        p.i(vector, "vector");
        p.i(label, "label");
        p.i(metadata, "metadata");
        p.i(collection, "collection");
        return new VectorEntry(id, vector, label, category, metadata, collection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!p.d(VectorEntry.class, other != null ? other.getClass() : null)) {
            return false;
        }
        p.g(other, "null cannot be cast to non-null type com.stepos.datacenter.vector.VectorEntry");
        VectorEntry vectorEntry = (VectorEntry) other;
        return this.id == vectorEntry.id && Arrays.equals(this.vector, vectorEntry.vector) && p.d(this.label, vectorEntry.label) && this.category == vectorEntry.category && p.d(this.metadata, vectorEntry.metadata) && p.d(this.collection, vectorEntry.collection);
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getCollection() {
        return this.collection;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final float[] getVector() {
        return this.vector;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.id) * 31) + Arrays.hashCode(this.vector)) * 31) + this.label.hashCode()) * 31) + this.category) * 31) + this.metadata.hashCode()) * 31) + this.collection.hashCode();
    }

    public final void setId(long j10) {
        this.id = j10;
    }

    public String toString() {
        return "VectorEntry(id=" + this.id + ", vector=" + Arrays.toString(this.vector) + ", label=" + this.label + ", category=" + this.category + ", metadata=" + this.metadata + ", collection=" + this.collection + ")";
    }

    public /* synthetic */ VectorEntry(long j10, float[] fArr, String str, int i10, String str2, String str3, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0L : j10, fArr, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? "" : str2, (i11 & 32) != 0 ? "default" : str3);
    }
}

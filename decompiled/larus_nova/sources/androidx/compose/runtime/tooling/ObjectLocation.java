package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/tooling/ObjectLocation;", "", "group", "", "dataOffset", "<init>", "(ILjava/lang/Integer;)V", "getGroup", "()I", "getDataOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Landroidx/compose/runtime/tooling/ObjectLocation;", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObjectLocation {
    public static final int $stable = 0;
    private final Integer dataOffset;
    private final int group;

    public static /* synthetic */ ObjectLocation copy$default(ObjectLocation r100, int r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.group;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.dataOffset;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.group;
    }

    public final Integer component2() {
        return this.dataOffset;
    }

    public final ObjectLocation copy(int r100, Integer r101) {
        return new ObjectLocation(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObjectLocation) == true) goto L8;
        return false;
    L8:
        ObjectLocation r101 = (ObjectLocation) r100;
        if (this.group == r101.group) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dataOffset, r101.dataOffset) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.group * 31;
        Integer r101 = this.dataOffset;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ObjectLocation(group=" + this.group + ", dataOffset=" + this.dataOffset + ')';
    }

    public final Integer getDataOffset() {
        return this.dataOffset;
    }

    public final int getGroup() {
        return this.group;
    }

    public ObjectLocation(int r100, Integer r101) {
        this.group = r100;
        this.dataOffset = r101;
    }
}

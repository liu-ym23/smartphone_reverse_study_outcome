package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "", "sourceInfo", "Landroidx/compose/runtime/tooling/SourceInformation;", "groupOffset", "", "<init>", "(Landroidx/compose/runtime/tooling/SourceInformation;Ljava/lang/Integer;)V", "getSourceInfo", "()Landroidx/compose/runtime/tooling/SourceInformation;", "getGroupOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Landroidx/compose/runtime/tooling/SourceInformation;Ljava/lang/Integer;)Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposeStackTraceFrame {
    public static final int $stable = 8;
    private final Integer groupOffset;
    private final SourceInformation sourceInfo;

    public static /* synthetic */ ComposeStackTraceFrame copy$default(ComposeStackTraceFrame r100, SourceInformation r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sourceInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.groupOffset;
    L9:
        return r100.copy(r101, r102);
    }

    public final SourceInformation component1() {
        return this.sourceInfo;
    }

    public final Integer component2() {
        return this.groupOffset;
    }

    public final ComposeStackTraceFrame copy(SourceInformation r100, Integer r101) {
        return new ComposeStackTraceFrame(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ComposeStackTraceFrame) == true) goto L8;
        return false;
    L8:
        ComposeStackTraceFrame r101 = (ComposeStackTraceFrame) r100;
        if (Intrinsics.areEqual(this.sourceInfo, r101.sourceInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupOffset, r101.groupOffset) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.sourceInfo.hashCode() * 31;
        Integer r101 = this.groupOffset;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ComposeStackTraceFrame(sourceInfo=" + this.sourceInfo + ", groupOffset=" + this.groupOffset + ')';
    }

    public final Integer getGroupOffset() {
        return this.groupOffset;
    }

    public final SourceInformation getSourceInfo() {
        return this.sourceInfo;
    }

    public ComposeStackTraceFrame(SourceInformation r100, Integer r101) {
        this.sourceInfo = r100;
        this.groupOffset = r101;
    }
}

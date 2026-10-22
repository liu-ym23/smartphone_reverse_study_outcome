package aq9;

import com.larus.platform.api.FlowDriveFileType;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<FlowDriveFileType> f15974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15978e;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f15974a, r101.f15974a) == true) goto L12;
        return false;
    L12:
        if (this.f15975b == r101.f15975b) goto L15;
        return false;
    L15:
        if (this.f15976c == r101.f15976c) goto L18;
        return false;
    L18:
        if (this.f15977d == r101.f15977d) goto L21;
        return false;
    L21:
        if (this.f15978e == r101.f15978e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Set<FlowDriveFileType> r100 = this.f15974a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((r101 * 31) + this.f15975b) * 31) + this.f15976c) * 31) + this.f15977d) * 31) + this.f15978e;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectionPolicy(allowDriveFileTypeList=" + this.f15974a + ", currentSize=" + this.f15975b + ", maxAudioCount=" + this.f15976c + ", maxImageCount=" + this.f15977d + ", maxFileCount=" + this.f15978e + ')';
    }

    public /* synthetic */ f(int r100) {
        this(null, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Set<? extends FlowDriveFileType> r100, int r101, int r102, int r103, int r104) {
        this.f15974a = r100;
        this.f15975b = r101;
        this.f15976c = r102;
        this.f15977d = r103;
        this.f15978e = r104;
    }
}

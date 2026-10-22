package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/camera/core/impl/DynamicRanges;", "", "()V", "canMatchBitDepth", "", "dynamicRangeToTest", "Landroidx/camera/core/DynamicRange;", "fullySpecifiedDynamicRange", "canMatchEncoding", "canResolve", "fullySpecifiedDynamicRanges", "", "canResolveUnderSpecifiedTo", "underSpecifiedDynamicRange", "findAllPossibleMatches", "dynamicRangesToTest", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DynamicRanges {
    public static final DynamicRanges INSTANCE = null;

    static {
        INSTANCE = new DynamicRanges();
    }

    private DynamicRanges() {
    }

    private final boolean canMatchBitDepth(DynamicRange r100, DynamicRange r101) {
        Preconditions.checkState(r101.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (r100.getBitDepth() != 0) goto L6;
        return true;
    L6:
        if (r100.getBitDepth() == r101.getBitDepth()) goto L11;
        return false;
    L11:
        return true;
    }

    private final boolean canMatchEncoding(DynamicRange r100, DynamicRange r101) {
        Preconditions.checkState(r101.isFullySpecified(), "Fully specified range is not actually fully specified.");
        int r102 = r100.getEncoding();
        if (r102 != 0) goto L5;
        return true;
    L5:
        int r103 = r101.getEncoding();
        if (r102 != 2) goto L9;
        if (r103 == 1) goto L9;
        return true;
    L9:
        if (r102 == r103) goto L14;
        return false;
    L14:
        return true;
    }

    @JvmStatic
    public static final boolean canResolve(DynamicRange r100, Set<DynamicRange> r101) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRangeToTest");
        Intrinsics.checkNotNullParameter(r101, "fullySpecifiedDynamicRanges");
        if (r100.isFullySpecified() == true) goto L19;
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        DynamicRanges r104 = INSTANCE;
        if (r104.canResolveUnderSpecifiedTo(r100, (DynamicRange) r103) == false) goto L7;
    L12:
        if (r103 == null) goto L14;
        return true;
    L14:
        return false;
    L11:
        r103 = null;
        goto L12
    L19:
        return r101.contains(r100);
    }

    private final boolean canResolveUnderSpecifiedTo(DynamicRange r100, DynamicRange r101) {
        if (canMatchBitDepth(r100, r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (canMatchEncoding(r100, r101) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final Set<DynamicRange> findAllPossibleMatches(Set<DynamicRange> r100, Set<DynamicRange> r101) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRangesToTest");
        Intrinsics.checkNotNullParameter(r101, "fullySpecifiedDynamicRanges");
        if (r100.isEmpty() == true) goto L21;
        Set r102 = SetsKt.createSetBuilder();
        Iterator<T> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        DynamicRange r104 = (DynamicRange) r103.next();
        if (r104.isFullySpecified() == true) goto L10;
        Iterator<T> r105 = r101.iterator();
    L14:
        if (r105.hasNext() == false) goto L6;
        DynamicRange r106 = (DynamicRange) r105.next();
        if (INSTANCE.canResolveUnderSpecifiedTo(r104, r106) == false) goto L14;
        r102.add(r106);
        goto L14
    L10:
        if (r101.contains(r104) == false) goto L6;
        r102.add(r104);
        goto L6
    L19:
        return SetsKt.build(r102);
    L21:
        throw new IllegalArgumentException("Candidate dynamic range set must contain at least 1 candidate dynamic range.");
    }
}

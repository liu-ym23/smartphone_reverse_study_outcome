package androidx.compose.foundation.lazy.layout;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0003¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/StableValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class StableValue<T> {
    private final T value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StableValue m923boximpl(Object r100) {
        return new StableValue(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m924constructorimpl(T r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m925equalsimpl(Object r100, Object r101) {
        if ((r101 instanceof StableValue) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((StableValue) r101).m929unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m926equalsimpl0(Object r100, Object r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m927hashCodeimpl(Object r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m928toStringimpl(Object r100) {
        return "StableValue(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m925equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m927hashCodeimpl(this.value);
    }

    public String toString() {
        return m928toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m929unboximpl() {
        return this.value;
    }

    public final T getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ StableValue(Object r100) {
        this.value = r100;
    }
}

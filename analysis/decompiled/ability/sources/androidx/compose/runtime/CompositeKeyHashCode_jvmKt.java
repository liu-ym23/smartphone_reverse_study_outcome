package androidx.compose.runtime;

import ca.AbstractC0897f;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a\u0015\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u0003H\u0086\b\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00060\u0001j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b\u001a!\u0010\t\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a!\u0010\f\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a!\u0010\r\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a%\u0010\r\u001a\u00020\u0001*\u00060\u0001j\u0002`\u00032\n\u0010\n\u001a\u00060\u0001j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0010"}, d2 = {"CompositeKeyHashCode", "", "toLong", "Landroidx/compose/runtime/CompositeKeyHashCode;", "toString", "", "radix", "", "initial", "compoundWith", "segment", "shift", "unCompoundWith", "bottomUpCompoundWith", "CompositeKeyHashSizeBits", "EmptyCompositeKeyHashCode", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositeKeyHashCode_jvmKt {
    public static final int CompositeKeyHashSizeBits = 64;
    public static final long EmptyCompositeKeyHashCode = 0;

    public static final long CompositeKeyHashCode(int i) {
        return i;
    }

    public static final long bottomUpCompoundWith(long j5, int i, int i6) {
        return j5 ^ Long.rotateLeft(i, i6);
    }

    public static final long compoundWith(long j5, int i, int i6) {
        return Long.rotateLeft(j5, i6) ^ i;
    }

    public static final long toLong(long j5) {
        return j5;
    }

    public static final String toString(long j5, int i) {
        AbstractC0897f.r(i);
        String string = Long.toString(j5, i);
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static final long unCompoundWith(long j5, int i, int i6) {
        return Long.rotateRight(j5 ^ i, i6);
    }

    public static final long bottomUpCompoundWith(long j5, long j6, int i) {
        return j5 ^ Long.rotateLeft(j6, i);
    }
}

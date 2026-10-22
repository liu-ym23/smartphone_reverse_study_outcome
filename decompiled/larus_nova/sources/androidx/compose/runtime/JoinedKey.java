package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/JoinedKey;", "", "left", "right", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getLeft", "()Ljava/lang/Object;", "getRight", "hashCode", "", "hashCodeOf", "value", "component1", "component2", "copy", "equals", "", "other", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JoinedKey {
    public static final int $stable = 8;
    private final Object left;
    private final Object right;

    public static /* synthetic */ JoinedKey copy$default(JoinedKey r100, Object r101, Object r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.right;
    L9:
        return r100.copy(r101, r102);
    }

    public final Object component1() {
        return this.left;
    }

    public final Object component2() {
        return this.right;
    }

    public final JoinedKey copy(Object r100, Object r101) {
        return new JoinedKey(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JoinedKey) == true) goto L8;
        return false;
    L8:
        JoinedKey r101 = (JoinedKey) r100;
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String toString() {
        return "JoinedKey(left=" + this.left + ", right=" + this.right + ')';
    }

    public int hashCode() {
        return (hashCodeOf(this.left) * 31) + hashCodeOf(this.right);
    }

    public final Object getLeft() {
        return this.left;
    }

    public final Object getRight() {
        return this.right;
    }

    private final int hashCodeOf(Object r100) {
        if ((r100 instanceof Enum) == true) goto L9;
        if (r100 != null) goto L10;
        return 0;
    L10:
        return r100.hashCode();
    L9:
        return ((Enum) r100).ordinal();
    }

    public JoinedKey(Object r100, Object r101) {
        this.left = r100;
        this.right = r101;
    }
}

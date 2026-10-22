package com.android.server.permission.access.immutable;

/* JADX INFO: compiled from: IntSetExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntSetExtensionsKt {
    public static final void minusAssign(IntSet $this$minusAssign, int element) {
        $this$minusAssign.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().delete(element);
    }

    public static final MutableIntSet MutableIntSet(int[] values) {
        MutableIntSet $this$MutableIntSet_u24lambda_u245 = new MutableIntSet(null, 1, null);
        plusAssign($this$MutableIntSet_u24lambda_u245, values);
        return $this$MutableIntSet_u24lambda_u245;
    }

    public static final void plusAssign(MutableIntSet $this$plusAssign, int element) {
        $this$plusAssign.getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().put(element, true);
    }

    public static final void plusAssign(MutableIntSet $this$plusAssign, IntSet set) {
        int index$iv = 0;
        int r3 = set.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        int it = set.elementAt(index$iv);
        plusAssign($this$plusAssign, it);
        index$iv = index$iv + 1;
        goto L3
    }

    public static final void plusAssign(MutableIntSet $this$plusAssign, int[] array) {
        int r2 = array.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        int element$iv = array[r3];
        plusAssign($this$plusAssign, element$iv);
        r3 = r3 + 1;
        goto L3
    }
}

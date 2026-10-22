package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClassLiteralValue) == true) goto L8;
        return false;
    L8:
        ClassLiteralValue r6 = (ClassLiteralValue) r5;
        if (Intrinsics.areEqual(this.classId, r6.classId) == true) goto L12;
        return false;
    L12:
        if (this.arrayNestedness == r6.arrayNestedness) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    public ClassLiteralValue(ClassId r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        this.classId = r2;
        this.arrayNestedness = r3;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.arrayNestedness;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.append("kotlin/Array<");
        r3 = r3 + 1;
        goto L3
    L5:
        r0.append(this.classId);
        int r5 = this.arrayNestedness;
    L6:
        if (r2 >= r5) goto L8;
        r0.append(">");
        r2 = r2 + 1;
        goto L6
    L8:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }
}

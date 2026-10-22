package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.obric.aikernel.sdk.ext.Params;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: compiled from: IncompatibleVersionErrorData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T expectedVersion;
    private final String filePath;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IncompatibleVersionErrorData) == true) goto L8;
        return false;
    L8:
        IncompatibleVersionErrorData r6 = (IncompatibleVersionErrorData) r5;
        if (Intrinsics.areEqual(this.actualVersion, r6.actualVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expectedVersion, r6.expectedVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filePath, r6.filePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.classId, r6.classId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        T r0 = this.actualVersion;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        T r4 = this.expectedVersion;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }

    public IncompatibleVersionErrorData(T r2, T r3, String r4, ClassId r5) {
        Intrinsics.checkNotNullParameter(r4, Params.FILE_PATH);
        Intrinsics.checkNotNullParameter(r5, "classId");
        this.actualVersion = r2;
        this.expectedVersion = r3;
        this.filePath = r4;
        this.classId = r5;
    }
}

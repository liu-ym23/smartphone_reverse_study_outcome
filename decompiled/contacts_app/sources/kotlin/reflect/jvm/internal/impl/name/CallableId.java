package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.librarian.LibrarianImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallableId.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CallableId {
    private static final Companion Companion = null;

    @Deprecated
    private static final Name LOCAL_NAME = null;

    @Deprecated
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = null;
    private final Name callableName;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    /* JADX INFO: compiled from: CallableId.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallableId) == true) goto L8;
        return false;
    L8:
        CallableId r6 = (CallableId) r5;
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r6.className) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callableName, r6.callableName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pathToLocal, r6.pathToLocal) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.packageName.hashCode() * 31;
        FqName r1 = this.className;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.callableName.hashCode()) * 31;
        FqName r5 = this.pathToLocal;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public CallableId(FqName r2, FqName r3, Name r4, FqName r5) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r4, "callableName");
        this.packageName = r2;
        this.className = r3;
        this.callableName = r4;
        this.pathToLocal = r5;
    }

    public /* synthetic */ CallableId(FqName r1, FqName r2, Name r3, FqName r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    static {
        Companion = new Companion(null);
        Name r0 = SpecialNames.LOCAL;
        LOCAL_NAME = r0;
        FqName r1 = FqName.topLevel(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(LOCAL_NAME)");
        PACKAGE_FQ_NAME_FOR_LOCAL = r1;
    }

    public CallableId(FqName r9, Name r10) {
        Intrinsics.checkNotNullParameter(r9, "packageName");
        Intrinsics.checkNotNullParameter(r10, "callableName");
        this(r9, null, r10, null, 8, null);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r2 = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(r2, "packageName.asString()");
        r0.append(StringsKt.replace$default(r2, '.', '/', false, 4, null));
        r0.append(LibrarianImpl.Constants.SEPARATOR);
        FqName r1 = this.className;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append(LibrarianImpl.Constants.DOT);
    L5:
        r0.append(this.callableName);
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    }
}

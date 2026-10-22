package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: compiled from: javaTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(JavaType r2) {
        if ((r2 instanceof JavaWildcardType) == false) goto L5;
        JavaWildcardType r3 = (JavaWildcardType) r2;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.getBound() != null) goto L11;
        return false;
    L11:
        if (r3.isExtends() == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        r3 = null;
        goto L7
    }
}

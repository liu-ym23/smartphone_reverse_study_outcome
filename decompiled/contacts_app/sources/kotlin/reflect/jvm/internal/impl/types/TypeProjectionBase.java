package kotlin.reflect.jvm.internal.impl.types;

import com.android.contacts.ContactsUtils;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public TypeProjectionBase() {
    }

    public String toString() {
        if (isStarProjection() == false) goto L7;
        return ContactsUtils.CHAR_STAR;
    L7:
        if (getProjectionKind() != Variance.INVARIANT) goto L11;
        return getType().toString();
    L11:
        return getProjectionKind() + HanziToPinyin.Token.SEPARATOR + getType();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TypeProjection) == true) goto L8;
        return false;
    L8:
        TypeProjection r6 = (TypeProjection) r5;
        if (isStarProjection() == r6.isStarProjection()) goto L12;
        return false;
    L12:
        if (getProjectionKind() == r6.getProjectionKind()) goto L15;
        return false;
    L15:
        if (getType().equals(r6.getType()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType()) == true) goto L11;
        int r1 = r0 * 31;
        if (isStarProjection() == false) goto L8;
        int r2 = 17;
    L10:
        return r1 + r2;
    L8:
        r2 = getType().hashCode();
        goto L10
    L11:
        return (r0 * 31) + 19;
    }
}

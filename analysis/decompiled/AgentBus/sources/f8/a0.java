package f8;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a0 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3460a;

    public a0(ArrayList arrayList) {
        this.f3460a = arrayList;
        if (d7.e0.Z(arrayList).size() != arrayList.size()) {
            throw new IllegalArgumentException("Some properties have the same names");
        }
    }

    public final String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + this.f3460a + ')';
    }
}

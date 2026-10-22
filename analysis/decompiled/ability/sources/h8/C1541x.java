package h8;

import java.util.ArrayList;
import java.util.Map;

/* renamed from: h8.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1541x extends AbstractC1508P {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4590a;
    public final Map b;

    public C1541x(ArrayList arrayList) {
        this.f4590a = arrayList;
        Map mapX = kotlin.collections.a.X(arrayList);
        if (mapX.size() != arrayList.size()) {
            throw new IllegalArgumentException("Some properties have the same names");
        }
        this.b = mapX;
    }

    @Override // h8.AbstractC1508P
    public final boolean a(G8.f fVar) {
        return this.b.containsKey(fVar);
    }

    public final String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + this.f4590a + ')';
    }
}

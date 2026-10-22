package L0;

import com.airbnb.lottie.v;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class m implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1198a;

    /* renamed from: b, reason: collision with root package name */
    public final List f1199b;

    public m(String str, List list) {
        this.f1198a = str;
        this.f1199b = list;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return new G0.d(vVar, bVar, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f1198a + "' Shapes: " + Arrays.toString(this.f1199b.toArray()) + '}';
    }
}

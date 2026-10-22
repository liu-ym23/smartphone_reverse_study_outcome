package L0;

import com.airbnb.lottie.AbstractC0398c;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1181a;

    public h(String str, int i4) {
        this.f1181a = i4;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        if (vVar.f4582i) {
            return new G0.l(this);
        }
        AbstractC0398c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        return "MergePaths{mode=" + B0.g.B(this.f1181a) + '}';
    }
}

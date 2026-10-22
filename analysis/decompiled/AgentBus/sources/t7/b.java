package t7;

import java.util.Random;
import q7.k;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: g, reason: collision with root package name */
    public final fb.c f9770g = new fb.c(8);

    @Override // t7.a
    public final Random a() {
        Object obj = this.f9770g.get();
        k.d(obj, "get(...)");
        return (Random) obj;
    }
}

package W7;

import java.util.Random;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b extends a {
    public final K9.c c = new K9.c(2);

    @Override // W7.a
    public final Random f() {
        Object obj = this.c.get();
        k.e(obj, "get(...)");
        return (Random) obj;
    }
}

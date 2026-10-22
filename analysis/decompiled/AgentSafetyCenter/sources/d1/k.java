package d1;

import android.graphics.Path;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {
    public static final h a() {
        Path path = new Path();
        h hVar = new h();
        hVar.f2990a = path;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public static final void b(String str) {
        throw new IllegalStateException(str);
    }
}

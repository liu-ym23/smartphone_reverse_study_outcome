package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import b5.b;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.List;
import m4.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // b5.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // b5.b
    public final Object b(Context context) {
        Context applicationContext = context.getApplicationContext();
        Choreographer choreographer = Choreographer.getInstance();
        g gVar = new g(0);
        gVar.f8227f = applicationContext;
        VarHandle.storeStoreFence();
        choreographer.postFrameCallback(gVar);
        return new f8.b(19);
    }
}

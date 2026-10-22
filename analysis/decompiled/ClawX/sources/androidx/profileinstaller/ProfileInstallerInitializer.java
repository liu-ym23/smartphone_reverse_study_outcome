package androidx.profileinstaller;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import t0.g;
import t0.h;
import y0.b;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // y0.b
    public final Object create(Context context) {
        h.a(new g(this, context.getApplicationContext()));
        return new p0.b(4);
    }

    @Override // y0.b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}

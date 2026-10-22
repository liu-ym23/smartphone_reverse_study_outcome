package androidx.profileinstaller;

import android.content.Context;
import androidx.appcompat.app.o;
import g0.AbstractC0567g;
import java.util.Collections;
import java.util.List;
import n0.b;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // n0.b
    public final Object create(Context context) {
        AbstractC0567g.a(new o(4, this, context.getApplicationContext()));
        return new E3.b(3);
    }

    @Override // n0.b
    public final List dependencies() {
        return Collections.emptyList();
    }
}

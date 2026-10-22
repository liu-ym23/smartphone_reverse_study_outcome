package a9;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements e {
    public c() {
    }

    @Override // a9.e
    public final void stop() {
    }

    @Override // a9.e
    public final void v(Application r100, a r101, f7.b r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "settings");
        Intrinsics.checkNotNullParameter(r102, "listener");
    }
}

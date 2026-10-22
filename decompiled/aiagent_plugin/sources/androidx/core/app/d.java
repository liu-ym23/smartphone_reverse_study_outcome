package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BundleCompat.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class d {
    public static IBinder a(Bundle r0, String r1) {
        return androidx.core.os.d.a(r0, r1);
    }

    public static void a(Bundle r2, String r3, IBinder r4) {
        androidx.core.os.d.a(r2, r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin"));
    }
}

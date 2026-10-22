package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Bundle.kt */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1258a = null;

    static {
        f1258a = new b();
    }

    private b() {
    }

    public static final void a(Bundle r2, String r3, IBinder r4) {
        r2.putBinder(r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.aiagent.plugin"));
    }
}

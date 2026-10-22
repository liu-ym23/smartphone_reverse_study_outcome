package r2;

import android.app.Application;
import android.content.Context;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {
    static {
        kotlin.jvm.internal.g.e(h2.j.f("ProcessUtils"), "tagWithPrefix(\"ProcessUtils\")");
    }

    public static final boolean a(Context context, androidx.work.a configuration) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(configuration, "configuration");
        String processName = Application.getProcessName();
        kotlin.jvm.internal.g.e(processName, "getProcessName()");
        return processName.equals(context.getApplicationInfo().processName);
    }
}

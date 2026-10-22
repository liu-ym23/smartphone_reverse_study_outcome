package Na;

import android.app.Application;
import kotlin.jvm.internal.k;
import z2.l;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1028a;
    public static final int b;

    static {
        Application application = l.b;
        if (application == null) {
            k.n("application");
            throw null;
        }
        f1028a = application.getResources().getDisplayMetrics().widthPixels;
        Application application2 = l.b;
        if (application2 != null) {
            b = application2.getResources().getDisplayMetrics().heightPixels;
        } else {
            k.n("application");
            throw null;
        }
    }
}

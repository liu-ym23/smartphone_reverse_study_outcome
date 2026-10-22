package cb;

import android.app.Application;
import android.content.Context;
import com.obric.capabilitykit.logger.Logger;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f6086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f6087b;

    static {
        f6086a = new q();
    }

    public q() {
    }

    public final String a(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        String r11 = f6087b;
        if (r11 != null) goto L5;
    L8:
        f6087b = Application.getProcessName();
        Logger.INSTANCE.d("ProcessUtils", "processName = " + f6087b);
        return f6087b;
    L5:
        if (r11.length() == 0) goto L8;
        return r11;
    }

    public final boolean b(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        String r11 = a(r10);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (kotlin.jvm.internal.q.b(r11, r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt__StringsKt.E(r11, ":", false, 2, null) == false) goto L7;
        return false;
    }
}

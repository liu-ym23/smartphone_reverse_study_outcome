package c0;

import android.database.Cursor;
import android.os.Bundle;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6026a = null;

    static {
        f6026a = new e();
    }

    public e() {
    }

    public static final void a(Cursor r10, Bundle r11) {
        q.g(r10, "cursor");
        q.g(r11, "extras");
        r10.setExtras(r11);
    }
}

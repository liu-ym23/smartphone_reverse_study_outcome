package n9;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f22432a = null;

    static {
        f22432a = new AtomicBoolean();
    }

    public static void a(Context r10) {
        if (f22432a.getAndSet(true) == true) goto L6;
        org.threeten.bp.zone.b.c(new b(r10));
        return;
    }
}

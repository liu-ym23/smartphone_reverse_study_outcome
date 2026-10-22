package c0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f6027a = null;

    static {
        f6027a = new f();
    }

    public f() {
    }

    public static final List a(Cursor r10) {
        q.g(r10, "cursor");
        List<Uri> r11 = r10.getNotificationUris();
        q.d(r11);
        return r11;
    }

    public static final void b(Cursor r10, ContentResolver r11, List r12) {
        q.g(r10, "cursor");
        q.g(r11, "cr");
        q.g(r12, "uris");
        r10.setNotificationUris(r11, r12);
    }
}

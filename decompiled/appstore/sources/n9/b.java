package n9;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends org.threeten.bp.zone.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f22433d;

    public b(Context r10) {
        this.f22433d = r10;
    }

    @Override // org.threeten.bp.zone.b
    public void b() {
        InputStream r10 = null;
        r10 = this.f22433d.getAssets().open("org/threeten/bp/TZDB.dat");     // Catch: Throwable -> L8 IOException -> L10
        org.threeten.bp.zone.a r11 = new org.threeten.bp.zone.a(r10);     // Catch: Throwable -> L8 IOException -> L10
        if (r10 != null) goto L18;
    L6:
        c.f(r11);
        return;
    L18:
        r10.close();     // Catch: IOException -> L16
        goto L6
    L8:
        th = move-exception;
        if (r10 != null) goto L22;
    L15:
        throw th;
    L22:
        r10.close();     // Catch: IOException -> L17
    L10:
        e = move-exception;
        throw new IllegalStateException("TZDB.dat missing from assets.", e);     // Catch: Throwable -> L8
    }
}

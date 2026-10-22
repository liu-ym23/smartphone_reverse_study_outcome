package x2;

import android.os.Trace;

/* loaded from: classes.dex */
public final class j implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (g.f11112k != null) {
                g.a().c();
            }
        } finally {
            Trace.endSection();
        }
    }
}

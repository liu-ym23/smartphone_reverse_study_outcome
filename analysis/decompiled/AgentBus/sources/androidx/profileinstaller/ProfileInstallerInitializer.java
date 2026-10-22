package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import fi.iki.elonen.NanoHTTPD;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import p3.b;
import s9.d;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // p3.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // p3.b
    public final Object b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: f3.g
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                Handler handlerCreateAsync = Handler.createAsync(Looper.getMainLooper());
                int iNextInt = new Random().nextInt(Math.max(1000, 1));
                handlerCreateAsync.postDelayed(new h(applicationContext, 0), iNextInt + NanoHTTPD.SOCKET_READ_TIMEOUT);
            }
        });
        return new d(21);
    }
}

package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.stepos.core.ability.speech.AsrCloudConfig;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b2.b<a> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
    }

    @Override // b2.b
    public final List<Class<? extends b2.b<?>>> a() {
        return Collections.EMPTY_LIST;
    }

    @Override // b2.b
    public final a b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: t1.c
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                Handler handlerCreateAsync = Handler.createAsync(Looper.getMainLooper());
                int iNextInt = new Random().nextInt(Math.max(1000, 1));
                handlerCreateAsync.postDelayed(new com.stepos.core.common.cloudconfig.a(applicationContext, 1), iNextInt + AsrCloudConfig.MAX_SILENCE_MS);
            }
        });
        return new a();
    }
}

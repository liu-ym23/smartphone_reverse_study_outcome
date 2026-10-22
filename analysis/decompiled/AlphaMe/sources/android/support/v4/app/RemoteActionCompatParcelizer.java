package android.support.v4.app;

import androidx.annotation.RestrictTo;
import androidx.core.app.RemoteActionCompat;
import e.EnumC0546d;
import java.lang.reflect.InvocationTargetException;
import q0.AbstractC0822a;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0822a abstractC0822a) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(abstractC0822a);
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0822a abstractC0822a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        androidx.core.app.RemoteActionCompatParcelizer.write(remoteActionCompat, abstractC0822a);
    }
}

package cb;

import android.os.Bundle;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.version.PersonalContextData;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f6116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile PersonalContextData f6117b;

    static {
        f6116a = new y();
    }

    public y() {
    }

    public final PersonalContextData a() {
        PersonalContextData r10 = f6117b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return b();
    }

    public final PersonalContextData b() {
        Bundle r10 = EntityProvider.INSTANCE.queryPersonalContextData$capabilitykit_release();
        if (r10 == null) goto L5;
        PersonalContextData r11 = PersonalContextData.Companion.createFromBundle(r10);
        f6117b = r11;
        return r11;
    L5:
        return null;
    }
}

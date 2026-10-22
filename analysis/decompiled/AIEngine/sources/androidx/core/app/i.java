package androidx.core.app;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final NotificationManager f1513a;

    static {
        new HashSet();
    }

    public i(Context context) {
        this.f1513a = (NotificationManager) context.getSystemService("notification");
    }
}

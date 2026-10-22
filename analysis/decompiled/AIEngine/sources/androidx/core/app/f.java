package androidx.core.app;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f1487a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f1488b;

    /* renamed from: c, reason: collision with root package name */
    public final n[] f1489c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1490d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1491e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public final int f1492f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f1493g;
    public final PendingIntent h;

    public f(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, n[] nVarArr, n[] nVarArr2) {
        this.f1491e = true;
        this.f1488b = iconCompat;
        if (iconCompat != null) {
            int i10 = iconCompat.f1520a;
            if ((i10 == -1 ? ((Icon) iconCompat.f1521b).getType() : i10) == 2) {
                this.f1492f = iconCompat.b();
            }
        }
        this.f1493g = g.c(charSequence);
        this.h = pendingIntent;
        this.f1487a = bundle == null ? new Bundle() : bundle;
        this.f1489c = nVarArr;
        this.f1490d = true;
        this.f1491e = true;
    }
}

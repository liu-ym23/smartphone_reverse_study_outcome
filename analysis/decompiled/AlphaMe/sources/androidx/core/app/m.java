package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3286a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f3287b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3288c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3289d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3290e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f3291f;

    /* renamed from: g, reason: collision with root package name */
    public final PendingIntent f3292g;

    public m(String str, PendingIntent pendingIntent) {
        IconCompat iconCompatA = IconCompat.a(R.drawable.common_full_open_on_phone);
        Bundle bundle = new Bundle();
        this.f3289d = true;
        this.f3287b = iconCompatA;
        int i4 = iconCompatA.f3314a;
        if ((i4 == -1 ? E.e.c(iconCompatA.f3315b) : i4) == 2) {
            this.f3290e = iconCompatA.b();
        }
        this.f3291f = o.a(str);
        this.f3292g = pendingIntent;
        this.f3286a = bundle;
        this.f3288c = true;
        this.f3289d = true;
    }
}

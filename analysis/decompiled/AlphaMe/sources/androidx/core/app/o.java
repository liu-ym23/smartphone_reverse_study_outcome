package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public Context f3294a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f3295b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f3296c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3297d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f3298e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f3299f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f3300g;

    /* renamed from: h, reason: collision with root package name */
    public int f3301h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3302i;

    /* renamed from: j, reason: collision with root package name */
    public p f3303j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3304k;

    /* renamed from: l, reason: collision with root package name */
    public Bundle f3305l;

    /* renamed from: m, reason: collision with root package name */
    public String f3306m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3307n;

    /* renamed from: o, reason: collision with root package name */
    public Notification f3308o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f3309p;

    public static CharSequence a(String str) {
        return (str != null && str.length() > 5120) ? str.subSequence(0, BmLocated.HALF_LEFT_TOP) : str;
    }

    public final void b(n nVar) {
        if (this.f3303j != nVar) {
            this.f3303j = nVar;
            if (nVar.f3310a != this) {
                nVar.f3310a = this;
                b(nVar);
            }
        }
    }
}

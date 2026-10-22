package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1494a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f1498e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1499f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f1500g;

    /* renamed from: i, reason: collision with root package name */
    public Bundle f1501i;

    /* renamed from: j, reason: collision with root package name */
    public RemoteViews f1502j;

    /* renamed from: k, reason: collision with root package name */
    public RemoteViews f1503k;

    /* renamed from: l, reason: collision with root package name */
    public String f1504l;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1506n;

    /* renamed from: o, reason: collision with root package name */
    public final Notification f1507o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1508p;

    /* renamed from: q, reason: collision with root package name */
    @Deprecated
    public final ArrayList<String> f1509q;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<f> f1495b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<l> f1496c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<f> f1497d = new ArrayList<>();
    public final boolean h = true;

    /* renamed from: m, reason: collision with root package name */
    public int f1505m = 0;

    public g(Context context, String str) {
        Notification notification = new Notification();
        this.f1507o = notification;
        this.f1494a = context;
        this.f1504l = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f1509q = new ArrayList<>();
        this.f1506n = true;
    }

    public static CharSequence c(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final void a(String str, PendingIntent pendingIntent) {
        this.f1495b.add(new f(null, str, pendingIntent, new Bundle(), null, null));
    }

    public final Notification b() {
        h hVar = new h(this);
        g gVar = hVar.f1511b;
        gVar.getClass();
        Notification notificationBuild = hVar.f1510a.build();
        RemoteViews remoteViews = gVar.f1502j;
        if (remoteViews != null) {
            notificationBuild.contentView = remoteViews;
        }
        return notificationBuild;
    }

    public final void d(int i10, boolean z) {
        Notification notification = this.f1507o;
        if (z) {
            notification.flags = i10 | notification.flags;
        } else {
            notification.flags = (~i10) & notification.flags;
        }
    }
}

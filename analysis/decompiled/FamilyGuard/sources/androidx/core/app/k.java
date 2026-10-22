package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.j;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class k implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9544a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f9545b;

    /* renamed from: c, reason: collision with root package name */
    private final j.d f9546c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f9547d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f9548e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Bundle> f9549f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f9550g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f9551h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f9552i;

    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i5, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z5) {
            return builder.setGroupSummary(z5);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z5) {
            return builder.setLocalOnly(z5);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i5) {
            return builder.setColor(i5);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i5) {
            return builder.setVisibility(i5);
        }
    }

    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z5) {
            return builder.setAllowGeneratedReplies(z5);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            return builder.setBadgeIconType(i5);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z5) {
            return builder.setColorized(z5);
        }

        static Notification.Builder d(Notification.Builder builder, int i5) {
            return builder.setGroupAlertBehavior(i5);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j5) {
            return builder.setTimeoutAfter(j5);
        }
    }

    static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i5) {
            return builder.setSemanticAction(i5);
        }
    }

    static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z5) {
            return builder.setAllowSystemGeneratedContextualActions(z5);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z5) {
            return builder.setContextual(z5);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z5) {
            return builder.setAuthenticationRequired(z5);
        }

        static Notification.Builder b(Notification.Builder builder, int i5) {
            return builder.setForegroundServiceBehavior(i5);
        }
    }

    k(j.d dVar) {
        this.f9546c = dVar;
        Context context = dVar.f9504a;
        this.f9544a = context;
        Notification.Builder builderA = e.a(context, dVar.f9493K);
        this.f9545b = builderA;
        Notification notification = dVar.f9500R;
        int i5 = 0;
        builderA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f9512i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f9508e).setContentText(dVar.f9509f).setContentInfo(dVar.f9514k).setContentIntent(dVar.f9510g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f9511h, (notification.flags & 128) != 0).setNumber(dVar.f9515l).setProgress(dVar.f9523t, dVar.f9524u, dVar.f9525v);
        IconCompat iconCompat = dVar.f9513j;
        c.b(builderA, iconCompat == null ? null : iconCompat.o(context));
        builderA.setSubText(dVar.f9520q).setUsesChronometer(dVar.f9518o).setPriority(dVar.f9516m);
        j.f fVar = dVar.f9519p;
        if (fVar instanceof j.e) {
            ArrayList<j.a> arrayListH = ((j.e) fVar).h();
            int size = arrayListH.size();
            int i6 = 0;
            while (i6 < size) {
                j.a aVar = arrayListH.get(i6);
                i6++;
                b(aVar);
            }
        } else {
            ArrayList<j.a> arrayList = dVar.f9505b;
            int size2 = arrayList.size();
            int i7 = 0;
            while (i7 < size2) {
                j.a aVar2 = arrayList.get(i7);
                i7++;
                b(aVar2);
            }
        }
        Bundle bundle = dVar.f9486D;
        if (bundle != null) {
            this.f9550g.putAll(bundle);
        }
        this.f9547d = dVar.f9490H;
        this.f9548e = dVar.f9491I;
        this.f9545b.setShowWhen(dVar.f9517n);
        a.i(this.f9545b, dVar.f9529z);
        a.g(this.f9545b, dVar.f9526w);
        a.j(this.f9545b, dVar.f9528y);
        a.h(this.f9545b, dVar.f9527x);
        this.f9551h = dVar.f9497O;
        b.b(this.f9545b, dVar.f9485C);
        b.c(this.f9545b, dVar.f9487E);
        b.f(this.f9545b, dVar.f9488F);
        b.d(this.f9545b, dVar.f9489G);
        b.e(this.f9545b, notification.sound, notification.audioAttributes);
        ArrayList<String> arrayList2 = dVar.f9503U;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size3 = arrayList2.size();
            int i8 = 0;
            while (i8 < size3) {
                String str = arrayList2.get(i8);
                i8++;
                b.a(this.f9545b, str);
            }
        }
        this.f9552i = dVar.f9492J;
        if (dVar.f9507d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i9 = 0; i9 < dVar.f9507d.size(); i9++) {
                bundle4.putBundle(Integer.toString(i9), l.a(dVar.f9507d.get(i9)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f9550g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        Object obj = dVar.f9502T;
        if (obj != null) {
            c.c(this.f9545b, obj);
        }
        this.f9545b.setExtras(dVar.f9486D);
        d.e(this.f9545b, dVar.f9522s);
        RemoteViews remoteViews = dVar.f9490H;
        if (remoteViews != null) {
            d.c(this.f9545b, remoteViews);
        }
        RemoteViews remoteViews2 = dVar.f9491I;
        if (remoteViews2 != null) {
            d.b(this.f9545b, remoteViews2);
        }
        RemoteViews remoteViews3 = dVar.f9492J;
        if (remoteViews3 != null) {
            d.d(this.f9545b, remoteViews3);
        }
        e.b(this.f9545b, dVar.f9494L);
        e.e(this.f9545b, dVar.f9521r);
        e.f(this.f9545b, dVar.f9495M);
        e.g(this.f9545b, dVar.f9496N);
        e.d(this.f9545b, dVar.f9497O);
        if (dVar.f9484B) {
            e.c(this.f9545b, dVar.f9483A);
        }
        if (!TextUtils.isEmpty(dVar.f9493K)) {
            this.f9545b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        ArrayList<p> arrayList3 = dVar.f9506c;
        int size4 = arrayList3.size();
        while (i5 < size4) {
            p pVar = arrayList3.get(i5);
            i5++;
            f.a(this.f9545b, pVar.g());
        }
        g.a(this.f9545b, dVar.f9499Q);
        g.b(this.f9545b, j.c.a(null));
        int i10 = dVar.f9498P;
        if (i10 != 0) {
            h.b(this.f9545b, i10);
        }
        if (dVar.f9501S) {
            if (this.f9546c.f9527x) {
                this.f9551h = 2;
            } else {
                this.f9551h = 1;
            }
            this.f9545b.setVibrate(null);
            this.f9545b.setSound(null);
            int i11 = notification.defaults & (-4);
            notification.defaults = i11;
            this.f9545b.setDefaults(i11);
            if (TextUtils.isEmpty(this.f9546c.f9526w)) {
                a.g(this.f9545b, "silent");
            }
            e.d(this.f9545b, this.f9551h);
        }
    }

    private void b(j.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.n() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : r.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        f.b(builderA, aVar.f());
        g.c(builderA, aVar.j());
        h.a(builderA, aVar.i());
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f9545b, a.d(builderA));
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f9545b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        j.f fVar = this.f9546c.f9519p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews remoteViewsE = fVar != null ? fVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f9546c.f9490H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (fVar != null && (remoteViewsD = fVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (fVar != null && (remoteViewsF = this.f9546c.f9519p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (fVar != null && (bundleA = j.a(notificationD)) != null) {
            fVar.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        return this.f9545b.build();
    }
}

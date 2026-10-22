package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.j;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class k implements androidx.core.app.i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13029a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f13030b;

    /* renamed from: c, reason: collision with root package name */
    public final j.d f13031c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteViews f13032d;

    /* renamed from: e, reason: collision with root package name */
    public RemoteViews f13033e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Bundle> f13034f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f13035g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public int f13036h;

    /* renamed from: i, reason: collision with root package name */
    public RemoteViews f13037i;

    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder e(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder f(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        public static Notification.Builder g(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        public static Notification.Builder h(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    public static class c {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }
    }

    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public static final class i {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.setShortCriticalText(str);
        }
    }

    public k(j.d dVar) {
        this.f13031c = dVar;
        Context context = dVar.f12989a;
        this.f13029a = context;
        Notification.Builder builderA = e.a(context, dVar.f12978L);
        this.f13030b = builderA;
        Notification notification = dVar.f12985S;
        builderA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f12998j).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f12993e).setContentText(dVar.f12994f).setContentInfo(dVar.f13000l).setContentIntent(dVar.f12996h).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f12997i, (notification.flags & 128) != 0).setNumber(dVar.f13001m).setProgress(dVar.f13009u, dVar.f13010v, dVar.f13011w);
        IconCompat iconCompat = dVar.f12999k;
        c.b(builderA, iconCompat == null ? null : iconCompat.k(context));
        builderA.setSubText(dVar.f13006r).setUsesChronometer(dVar.f13004p).setPriority(dVar.f13002n);
        j.f fVar = dVar.f13005q;
        if (fVar instanceof j.e) {
            Iterator<j.a> it = ((j.e) fVar).h().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        } else {
            Iterator<j.a> it2 = dVar.f12990b.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
        }
        Bundle bundle = dVar.f12971E;
        if (bundle != null) {
            this.f13035g.putAll(bundle);
        }
        this.f13032d = dVar.f12975I;
        this.f13033e = dVar.f12976J;
        this.f13030b.setShowWhen(dVar.f13003o);
        a.g(this.f13030b, dVar.f12967A);
        a.e(this.f13030b, dVar.f13012x);
        a.h(this.f13030b, dVar.f13014z);
        a.f(this.f13030b, dVar.f13013y);
        this.f13036h = dVar.f12982P;
        b.b(this.f13030b, dVar.f12970D);
        b.c(this.f13030b, dVar.f12972F);
        b.f(this.f13030b, dVar.f12973G);
        b.d(this.f13030b, dVar.f12974H);
        b.e(this.f13030b, notification.sound, notification.audioAttributes);
        ArrayList<String> arrayList = dVar.f12988V;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                b.a(this.f13030b, it3.next());
            }
        }
        this.f13037i = dVar.f12977K;
        if (dVar.f12992d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i10 = 0; i10 < dVar.f12992d.size(); i10++) {
                bundle4.putBundle(Integer.toString(i10), l.a(dVar.f12992d.get(i10)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f13035g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        Object obj = dVar.f12987U;
        if (obj != null) {
            c.c(this.f13030b, obj);
        }
        this.f13030b.setExtras(dVar.f12971E);
        d.e(this.f13030b, dVar.f13008t);
        RemoteViews remoteViews = dVar.f12975I;
        if (remoteViews != null) {
            d.c(this.f13030b, remoteViews);
        }
        RemoteViews remoteViews2 = dVar.f12976J;
        if (remoteViews2 != null) {
            d.b(this.f13030b, remoteViews2);
        }
        RemoteViews remoteViews3 = dVar.f12977K;
        if (remoteViews3 != null) {
            d.d(this.f13030b, remoteViews3);
        }
        e.b(this.f13030b, dVar.f12979M);
        e.e(this.f13030b, dVar.f13007s);
        e.f(this.f13030b, dVar.f12980N);
        e.g(this.f13030b, dVar.f12981O);
        e.d(this.f13030b, dVar.f12982P);
        if (dVar.f12969C) {
            e.c(this.f13030b, dVar.f12968B);
        }
        if (!TextUtils.isEmpty(dVar.f12978L)) {
            this.f13030b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator<p> it4 = dVar.f12991c.iterator();
        while (it4.hasNext()) {
            f.a(this.f13030b, it4.next().g());
        }
        int i11 = Build.VERSION.SDK_INT;
        g.a(this.f13030b, dVar.f12984R);
        g.b(this.f13030b, j.c.a(null));
        int i12 = dVar.f12983Q;
        if (i12 != 0) {
            h.b(this.f13030b, i12);
        }
        if (i11 >= 36) {
            i.a(this.f13030b, dVar.f12995g);
        }
        if (dVar.f12986T) {
            if (this.f13031c.f13013y) {
                this.f13036h = 2;
            } else {
                this.f13036h = 1;
            }
            this.f13030b.setVibrate(null);
            this.f13030b.setSound(null);
            int i13 = notification.defaults & (-4);
            notification.defaults = i13;
            this.f13030b.setDefaults(i13);
            if (TextUtils.isEmpty(this.f13031c.f13012x)) {
                a.e(this.f13030b, "silent");
            }
            e.d(this.f13030b, this.f13036h);
        }
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f13030b;
    }

    public final void b(j.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.j() : null, aVar.h(), aVar.a());
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
        a.a(this.f13030b, a.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        j.f fVar = this.f13031c.f13005q;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews remoteViewsE = fVar != null ? fVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f13031c.f12975I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (fVar != null && (remoteViewsD = fVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (fVar != null && (remoteViewsF = this.f13031c.f13005q.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (fVar != null && (bundleA = j.a(notificationD)) != null) {
            fVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        return this.f13030b.build();
    }
}

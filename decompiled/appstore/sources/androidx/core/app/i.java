package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.appcompat.widget.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements NotificationBuilderWithBuilderAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f2497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f2498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f2499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f2500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f2501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f2502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f2504i;

    public i(h r13) {
        this.f2501f = new ArrayList();
        this.f2502g = new Bundle();
        this.f2498c = r13;
        this.f2496a = r13.f2470a;
        Notification.Builder r10 = new Notification.Builder(r13.f2470a, r13.f2469J);
        this.f2497b = r10;
        Notification r11 = r13.Q;
        Notification.Builder r12 = r10.setWhen(r11.when).setSmallIcon(r11.icon, r11.iconLevel).setContent(r11.contentView).setTicker(r11.tickerText, r13.f2478i).setVibrate(r11.vibrate).setLights(r11.ledARGB, r11.ledOnMS, r11.ledOffMS);
        if ((r11.flags & 2) == 0) goto L5;
        boolean r14 = true;
    L6:
        Notification.Builder r15 = r12.setOngoing(r14);
        if ((r11.flags & 8) == 0) goto L9;
        boolean r16 = true;
    L10:
        Notification.Builder r17 = r15.setOnlyAlertOnce(r16);
        if ((r11.flags & 16) == 0) goto L13;
        boolean r18 = true;
    L14:
        Notification.Builder r19 = r17.setAutoCancel(r18).setDefaults(r11.defaults).setContentTitle(r13.f2474e).setContentText(r13.f2475f).setContentInfo(r13.f2480k).setContentIntent(r13.f2476g).setDeleteIntent(r11.deleteIntent);
        PendingIntent r20 = r13.f2477h;
        if ((r11.flags & 128) == 0) goto L17;
        boolean r21 = true;
    L18:
        r19.setFullScreenIntent(r20, r21).setLargeIcon(r13.f2479j).setNumber(r13.f2481l).setProgress(r13.f2488s, r13.f2489t, r13.f2490u);
        r10.setSubText(r13.f2485p).setUsesChronometer(r13.f2484o).setPriority(r13.f2482m);
        Iterator r22 = r13.f2471b.iterator();
    L20:
        if (r22.hasNext() == false) goto L22;
        p.a(r22.next());
        a(null);
        goto L20
    L22:
        Bundle r23 = r13.C;
        if (r23 == null) goto L25;
        this.f2502g.putAll(r23);
    L25:
        this.f2499d = r13.G;
        this.f2500e = r13.H;
        this.f2497b.setShowWhen(r13.f2483n);
        this.f2497b.setLocalOnly(r13.f2494y).setGroup(r13.f2491v).setGroupSummary(r13.f2492w).setSortKey(r13.f2493x);
        this.f2503h = r13.N;
        this.f2497b.setCategory(r13.B).setColor(r13.D).setVisibility(r13.E).setPublicVersion(r13.F).setSound(r11.sound, r11.audioAttributes);
        ArrayList r24 = r13.T;
        if (r24 != null) goto L28;
    L33:
        this.f2504i = r13.I;
        if (r13.f2473d.size() <= 0) goto L43;
        Bundle r25 = r13.b().getBundle("android.car.EXTENSIONS");
        if (r25 != null) goto L38;
        r25 = new Bundle();
    L38:
        Bundle r26 = new Bundle(r25);
        Bundle r27 = new Bundle();
        int r28 = 0;
    L40:
        if (r28 >= r13.f2473d.size()) goto L42;
        String r110 = Integer.toString(r28);
        p.a(r13.f2473d.get(r28));
        r27.putBundle(r110, j.a(null));
        r28 = r28 + 1;
        goto L40
    L42:
        r25.putBundle("invisible_actions", r27);
        r26.putBundle("invisible_actions", r27);
        r13.b().putBundle("android.car.EXTENSIONS", r25);
        this.f2502g.putBundle("android.car.EXTENSIONS", r26);
    L43:
        int r29 = Build.VERSION.SDK_INT;
        Icon r30 = r13.S;
        if (r30 == null) goto L46;
        this.f2497b.setSmallIcon(r30);
    L46:
        this.f2497b.setExtras(r13.C).setRemoteInputHistory(r13.f2487r);
        RemoteViews r31 = r13.G;
        if (r31 == null) goto L49;
        this.f2497b.setCustomContentView(r31);
    L49:
        RemoteViews r32 = r13.H;
        if (r32 == null) goto L52;
        this.f2497b.setCustomBigContentView(r32);
    L52:
        RemoteViews r33 = r13.I;
        if (r33 == null) goto L55;
        this.f2497b.setCustomHeadsUpContentView(r33);
    L55:
        this.f2497b.setBadgeIconType(r13.K).setSettingsText(r13.f2486q).setShortcutId(r13.L).setTimeoutAfter(r13.M).setGroupAlertBehavior(r13.N);
        if (r13.A == false) goto L59;
        this.f2497b.setColorized(r13.f2495z);
    L59:
        if (TextUtils.isEmpty(r13.f2469J) == true) goto L61;
        this.f2497b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L61:
        Iterator r34 = r13.f2472c.iterator();
        if (r34.hasNext() == true) goto L79;
        this.f2497b.setAllowSystemGeneratedContextualActions(r13.P);
        this.f2497b.setBubbleMetadata(g.a(null));
        if (r29 < 31) goto L69;
        int r35 = r13.O;
        if (r35 == 0) goto L69;
        this.f2497b.setForegroundServiceBehavior(r35);
    L69:
        if (r13.R == true) goto L71;
        return;
    L71:
        if (this.f2498c.f2492w == false) goto L73;
        this.f2503h = 2;
    L74:
        this.f2497b.setVibrate(null);
        this.f2497b.setSound(null);
        int r111 = r11.defaults & (-4);
        r11.defaults = r111;
        this.f2497b.setDefaults(r111);
        if (TextUtils.isEmpty(this.f2498c.f2491v) == false) goto L77;
        this.f2497b.setGroup("silent");
    L77:
        this.f2497b.setGroupAlertBehavior(this.f2503h);
        return;
    L73:
        this.f2503h = 1;
        goto L74
    L79:
        p.a(r34.next());
        throw null;
    L28:
        if (r24.isEmpty() == true) goto L33;
        Iterator r36 = r24.iterator();
    L31:
        if (r36.hasNext() == false) goto L33;
        this.f2497b.addPerson((String) r36.next());
        goto L31
    L17:
        r21 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r16 = false;
        goto L10
    L5:
        r14 = false;
        goto L6
    }

    public final void a(NotificationCompat$Action r10) {
        throw null;
    }

    public Notification b() {
        this.f2498c.getClass();
        Notification r10 = c();
        RemoteViews r11 = this.f2498c.G;
        if (r11 == null) goto L5;
        r10.contentView = r11;
    L5:
        return r10;
    }

    public Notification c() {
        return this.f2497b.build();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.f2497b;
    }
}

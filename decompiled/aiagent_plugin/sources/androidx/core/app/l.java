package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NotificationCompatBuilder.java */
/* JADX INFO: loaded from: classes.dex */
class l implements androidx.core.app.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Notification.Builder f1115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.core.app.k.c f1116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f1117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RemoteViews f1118e;
    private final List<Bundle> f;
    private final Bundle g;
    private int h;
    private RemoteViews i;

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class a {
        static Notification.Builder a(Notification.Builder r2, CharSequence r3) {
            return r2.setSubText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static Notification.Builder a(Notification.Builder r0, boolean r1) {
            return r0.setUsesChronometer(r1);
        }

        static Notification.Builder a(Notification.Builder r0, int r1) {
            return r0.setPriority(r1);
        }

        static Notification a(Notification.Builder r0) {
            return r0.build();
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class b {
        static Notification.Builder a(Notification.Builder r0, boolean r1) {
            return r0.setShowWhen(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class c {
        static Notification.Builder a(Notification.Builder r0, Bundle r1) {
            return r0.setExtras(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class d {
        static Notification.Action.Builder a(int r2, CharSequence r3, PendingIntent r4) {
            return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
        }

        static Notification.Action.Builder a(Notification.Action.Builder r0, RemoteInput r1) {
            return r0.addRemoteInput(r1);
        }

        static Notification.Action.Builder a(Notification.Action.Builder r0, Bundle r1) {
            return r0.addExtras(r1);
        }

        static Notification.Builder a(Notification.Builder r0, Notification.Action r1) {
            return r0.addAction(r1);
        }

        static Notification.Action a(Notification.Action.Builder r0) {
            return r0.build();
        }

        static String a(Notification r0) {
            return r0.getGroup();
        }

        static Notification.Builder a(Notification.Builder r0, String r1) {
            return r0.setGroup(r1);
        }

        static Notification.Builder a(Notification.Builder r0, boolean r1) {
            return r0.setGroupSummary(r1);
        }

        static Notification.Builder b(Notification.Builder r0, boolean r1) {
            return r0.setLocalOnly(r1);
        }

        static Notification.Builder b(Notification.Builder r0, String r1) {
            return r0.setSortKey(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class e {
        static Notification.Builder a(Notification.Builder r0, String r1) {
            return r0.addPerson(r1);
        }

        static Notification.Builder b(Notification.Builder r0, String r1) {
            return r0.setCategory(r1);
        }

        static Notification.Builder a(Notification.Builder r0, int r1) {
            return r0.setColor(r1);
        }

        static Notification.Builder b(Notification.Builder r0, int r1) {
            return r0.setVisibility(r1);
        }

        static Notification.Builder a(Notification.Builder r0, Notification r1) {
            return r0.setPublicVersion(r1);
        }

        static Notification.Builder a(Notification.Builder r2, Uri r3, Object r4) {
            return r2.setSound(r3, (AudioAttributes) ZeusTransformUtils.preCheckCast(r4, AudioAttributes.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class f {
        static Notification.Action.Builder a(Icon r2, CharSequence r3, PendingIntent r4) {
            return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
        }

        static Notification.Builder a(Notification.Builder r2, Object r3) {
            return r2.setSmallIcon((Icon) ZeusTransformUtils.preCheckCast(r3, Icon.class, "com.obric.aiagent.plugin"));
        }

        static Notification.Builder a(Notification.Builder r0, Icon r1) {
            return r0.setLargeIcon(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class g {
        static Notification.Action.Builder a(Notification.Action.Builder r0, boolean r1) {
            return r0.setAllowGeneratedReplies(r1);
        }

        static Notification.Builder a(Notification.Builder r0, CharSequence[] r1) {
            return r0.setRemoteInputHistory(r1);
        }

        static Notification.Builder a(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomContentView(r1);
        }

        static Notification.Builder b(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomBigContentView(r1);
        }

        static Notification.Builder c(Notification.Builder r0, RemoteViews r1) {
            return r0.setCustomHeadsUpContentView(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class h {
        static Notification.Builder a(Context r2, String r3) {
            return new Notification.Builder((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        }

        static Notification.Builder a(Notification.Builder r0, int r1) {
            return r0.setGroupAlertBehavior(r1);
        }

        static Notification.Builder a(Notification.Builder r0, boolean r1) {
            return r0.setColorized(r1);
        }

        static Notification.Builder b(Notification.Builder r0, int r1) {
            return r0.setBadgeIconType(r1);
        }

        static Notification.Builder a(Notification.Builder r2, CharSequence r3) {
            return r2.setSettingsText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static Notification.Builder a(Notification.Builder r0, String r1) {
            return r0.setShortcutId(r1);
        }

        static Notification.Builder a(Notification.Builder r0, long r1) {
            return r0.setTimeoutAfter(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class i {
        static Notification.Action.Builder a(Notification.Action.Builder r0, int r1) {
            return r0.setSemanticAction(r1);
        }

        static Notification.Builder a(Notification.Builder r0, Person r1) {
            return r0.addPerson(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class j {
        static Notification.Action.Builder a(Notification.Action.Builder r0, boolean r1) {
            return r0.setContextual(r1);
        }

        static Notification.Builder a(Notification.Builder r2, Object r3) {
            return r2.setLocusId((LocusId) ZeusTransformUtils.preCheckCast(r3, LocusId.class, "com.obric.aiagent.plugin"));
        }

        static Notification.Builder a(Notification.Builder r0, Notification.BubbleMetadata r1) {
            return r0.setBubbleMetadata(r1);
        }

        static Notification.Builder a(Notification.Builder r0, boolean r1) {
            return r0.setAllowSystemGeneratedContextualActions(r1);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    static class k {
        static Notification.Action.Builder a(Notification.Action.Builder r0, boolean r1) {
            return r0.setAuthenticationRequired(r1);
        }

        static Notification.Builder a(Notification.Builder r0, int r1) {
            return r0.setForegroundServiceBehavior(r1);
        }
    }

    l(androidx.core.app.k.c r17) {
        this.f = new ArrayList();
        this.g = new Bundle();
        this.f1116c = r17;
        Context r2 = ZeusTransformUtils.wrapperContext(r17.f1104a, "com.obric.aiagent.plugin");
        this.f1114a = r2;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.f1115b = h.a(r17.f1104a, r17.K);
    L6:
        Notification r4 = r17.T;
        Notification.Builder r6 = this.f1115b.setWhen(r4.when).setSmallIcon(r4.icon, r4.iconLevel).setContent(r4.contentView).setTicker(r4.tickerText, r17.i).setVibrate(r4.vibrate).setLights(r4.ledARGB, r4.ledOnMS, r4.ledOffMS);
        if ((r4.flags & 2) == 0) goto L9;
        boolean r7 = true;
    L10:
        Notification.Builder r8 = r6.setOngoing(r7);
        if ((r4.flags & 8) == 0) goto L13;
        boolean r9 = true;
    L14:
        Notification.Builder r10 = r8.setOnlyAlertOnce(r9);
        if ((r4.flags & 16) == 0) goto L17;
        boolean r11 = true;
    L18:
        Notification.Builder r12 = r10.setAutoCancel(r11).setDefaults(r4.defaults).setContentTitle(r17.f1108e).setContentText(r17.f).setContentInfo(r17.k).setContentIntent(r17.g).setDeleteIntent(r4.deleteIntent);
        PendingIntent r13 = r17.h;
        if ((r4.flags & 128) == 0) goto L21;
        boolean r14 = true;
    L22:
        r12.setFullScreenIntent(r13, r14).setNumber(r17.l).setProgress(r17.t, r17.u, r17.v);
        if (Build.VERSION.SDK_INT >= 23) goto L29;
        Notification.Builder r3 = this.f1115b;
        if (r17.j != null) goto L27;
        Bitmap r15 = null;
    L28:
        r3.setLargeIcon(r15);
    L35:
        if (Build.VERSION.SDK_INT >= 21) goto L38;
        this.f1115b.setSound(r4.sound, r4.audioStreamType);
    L38:
        if (Build.VERSION.SDK_INT < 16) goto L70;
        a.a(a.a(a.a(this.f1115b, r17.q), r17.o), r17.m);
        if (Build.VERSION.SDK_INT >= 20) goto L42;
    L47:
        Iterator<androidx.core.app.k.a> r5 = r17.f1105b.iterator();
    L49:
        if (r5.hasNext() == false) goto L52;
        a((androidx.core.app.k.a) ZeusTransformUtils.preCheckCast(r5.next(), androidx.core.app.k.a.class, "com.obric.aiagent.plugin"));
    L52:
        if (r17.D == null) goto L55;
        this.g.putAll(r17.D);
    L55:
        if (Build.VERSION.SDK_INT < 20) goto L57;
    L68:
        this.f1117d = r17.H;
        this.f1118e = r17.I;
        goto L70
    L57:
        if (r17.z == false) goto L60;
        this.g.putBoolean("android.support.localOnly", true);
    L60:
        if (r17.w == null) goto L66;
        this.g.putString("android.support.groupKey", r17.w);
        if (r17.x == false) goto L64;
        this.g.putBoolean("android.support.isGroupSummary", true);
        goto L66
    L64:
        this.g.putBoolean("android.support.useSideChannel", true);
    L66:
        if (r17.y == null) goto L68;
        this.g.putString("android.support.sortKey", r17.y);
        goto L68
    L42:
        if (ZeusTransformUtils.instanceOf(r17.p, androidx.core.app.k.d.class) == false) goto L47;
        Iterator<androidx.core.app.k.a> r16 = ((androidx.core.app.k.d) ZeusTransformUtils.preCheckCast(r17.p, androidx.core.app.k.d.class, "com.obric.aiagent.plugin")).b().iterator();
    L45:
        if (r16.hasNext() == false) goto L52;
        a((androidx.core.app.k.a) ZeusTransformUtils.preCheckCast(r16.next(), androidx.core.app.k.a.class, "com.obric.aiagent.plugin"));
    L70:
        if (Build.VERSION.SDK_INT < 17) goto L73;
        b.a(this.f1115b, r17.n);
    L73:
        if (Build.VERSION.SDK_INT < 19) goto L82;
        if (Build.VERSION.SDK_INT >= 21) goto L82;
        List<String> r18 = a(a(r17.f1106c), r17.W);
        if (r18 == null) goto L82;
        if (r18.isEmpty() == true) goto L82;
        this.g.putStringArray("android.people", (String[]) ZeusTransformUtils.preCheckCast(r18.toArray(new String[r18.size()]), String[].class, "com.obric.aiagent.plugin"));
    L82:
        if (Build.VERSION.SDK_INT < 20) goto L85;
        d.b(this.f1115b, r17.z);
        d.a(this.f1115b, r17.w);
        d.b(this.f1115b, r17.y);
        d.a(this.f1115b, r17.x);
        this.h = r17.P;
    L85:
        if (Build.VERSION.SDK_INT < 21) goto L108;
        e.b(this.f1115b, r17.C);
        e.a(this.f1115b, r17.E);
        e.b(this.f1115b, r17.F);
        e.a(this.f1115b, r17.G);
        e.a(this.f1115b, r4.sound, r4.audioAttributes);
        if (Build.VERSION.SDK_INT >= 28) goto L89;
        List r19 = a(a(r17.f1106c), r17.W);
    L90:
        if (r19 != null) goto L92;
    L97:
        this.i = r17.f1103J;
        if (r17.f1107d.size() <= 0) goto L108;
        Bundle r20 = r17.a().getBundle("android.car.EXTENSIONS");
        if (r20 != null) goto L102;
        r20 = new Bundle();
    L102:
        Bundle r110 = new Bundle(r20);
        Bundle r111 = new Bundle();
        int r112 = 0;
    L104:
        if (r112 >= r17.f1107d.size()) goto L106;
        r111.putBundle(Integer.toString(r112), m.a((androidx.core.app.k.a) ZeusTransformUtils.preCheckCast(r17.f1107d.get(r112), androidx.core.app.k.a.class, "com.obric.aiagent.plugin")));
        r112 = r112 + 1;
        goto L104
    L106:
        r20.putBundle("invisible_actions", r111);
        r110.putBundle("invisible_actions", r111);
        r17.a().putBundle("android.car.EXTENSIONS", r20);
        this.g.putBundle("android.car.EXTENSIONS", r110);
        goto L108
    L92:
        if (r19.isEmpty() == true) goto L97;
        Iterator r21 = r19.iterator();
    L95:
        if (r21.hasNext() == false) goto L97;
        e.a(this.f1115b, (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin"));
        goto L95
    L89:
        r19 = r17.W;
    L108:
        if (Build.VERSION.SDK_INT < 23) goto L113;
        if (r17.V == null) goto L113;
        f.a(this.f1115b, r17.V);
    L113:
        if (Build.VERSION.SDK_INT < 24) goto L124;
        c.a(this.f1115b, r17.D);
        g.a(this.f1115b, r17.s);
        if (r17.H == null) goto L118;
        g.a(this.f1115b, r17.H);
    L118:
        if (r17.I == null) goto L121;
        g.b(this.f1115b, r17.I);
    L121:
        if (r17.f1103J == null) goto L124;
        g.c(this.f1115b, r17.f1103J);
    L124:
        if (Build.VERSION.SDK_INT < 26) goto L132;
        h.b(this.f1115b, r17.L);
        h.a(this.f1115b, r17.r);
        h.a(this.f1115b, r17.M);
        h.a(this.f1115b, r17.O);
        h.a(this.f1115b, r17.P);
        if (r17.B == false) goto L129;
        h.a(this.f1115b, r17.A);
    L129:
        if (TextUtils.isEmpty(r17.K) == true) goto L132;
        this.f1115b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L132:
        if (Build.VERSION.SDK_INT < 28) goto L138;
        Iterator<n> r22 = r17.f1106c.iterator();
    L135:
        if (r22.hasNext() == false) goto L138;
        i.a(this.f1115b, ((n) ZeusTransformUtils.preCheckCast(r22.next(), n.class, "com.obric.aiagent.plugin")).b());
    L138:
        if (Build.VERSION.SDK_INT < 29) goto L143;
        j.a(this.f1115b, r17.R);
        j.a(this.f1115b, androidx.core.app.k.b.a(r17.S));
        if (r17.N == null) goto L143;
        j.a(this.f1115b, r17.N.a());
    L143:
        if (Build.VERSION.SDK_INT < 31) goto L148;
        if (r17.Q == 0) goto L148;
        k.a(this.f1115b, r17.Q);
    L148:
        if (r17.U == true) goto L150;
        return;
    L150:
        if (this.f1116c.x == false) goto L152;
        this.h = 2;
    L153:
        this.f1115b.setVibrate(null);
        this.f1115b.setSound(null);
        r4.defaults &= -2;
        r4.defaults &= -3;
        this.f1115b.setDefaults(r4.defaults);
        if (Build.VERSION.SDK_INT >= 26) goto L156;
        return;
    L156:
        if (TextUtils.isEmpty(this.f1116c.w) == false) goto L158;
        d.a(this.f1115b, "silent");
    L158:
        h.a(this.f1115b, this.h);
        return;
    L152:
        this.h = 1;
        goto L153
    L27:
        r15 = r17.j.c();
        goto L28
    L29:
        Notification.Builder r23 = this.f1115b;
        if (r17.j != null) goto L32;
        Icon r24 = null;
    L33:
        f.a(r23, r24);
        goto L35
    L32:
        r24 = r17.j.a(r2);
        goto L33
    L21:
        r14 = false;
        goto L22
    L17:
        r11 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        this.f1115b = new Notification.Builder(r17.f1104a);
        goto L6
    }

    private static List<String> a(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return r6;
    L5:
        if (r6 != null) goto L7;
        return r5;
    L7:
        androidx.b.b r0 = new androidx.b.b(r5.size() + r6.size());
        r0.addAll(r5);
        r0.addAll(r6);
        return new ArrayList(r0);
    }

    private static List<String> a(List<n> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList(r5.size());
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0.add(((n) ZeusTransformUtils.preCheckCast(r6.next(), n.class, "com.obric.aiagent.plugin")).i());
        goto L8
    L10:
        return r0;
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f1115b;
    }

    Context getContext() {
        return this.f1114a;
    }

    public Notification b() {
        androidx.core.app.k.e r0 = this.f1116c.p;
        if (r0 == null) goto L5;
        r0.a(this);
    L5:
        if (r0 == null) goto L7;
        RemoteViews r1 = r0.b(this);
    L8:
        Notification r2 = c();
        if (r1 == null) goto L12;
        r2.contentView = r1;
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L21;
        if (r0 == null) goto L21;
        RemoteViews r3 = r0.c(this);
        if (r3 == null) goto L21;
        r2.bigContentView = r3;
    L21:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        if (r0 == null) goto L27;
        RemoteViews r5 = this.f1116c.p.d(this);
        if (r5 == null) goto L27;
        r2.headsUpContentView = r5;
    L27:
        if (Build.VERSION.SDK_INT < 16) goto L32;
        if (r0 == null) goto L32;
        Bundle r6 = androidx.core.app.k.a(r2);
        if (r6 == null) goto L32;
        r0.a(r6);
    L32:
        return r2;
    L12:
        if (this.f1116c.H == null) goto L15;
        r2.contentView = this.f1116c.H;
        goto L15
    L7:
        r1 = null;
        goto L8
    }

    private void a(androidx.core.app.k.a r6) {
        if (Build.VERSION.SDK_INT < 20) goto L37;
        IconCompat r0 = r6.a();
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r0 == null) goto L8;
        Icon r1 = r0.e();
    L9:
        Notification.Action.Builder r2 = f.a(r1, r6.b(), r6.c());
    L15:
        if (r6.g() == null) goto L20;
        RemoteInput[] r4 = p.a(r6.g());
        int r5 = r4.length;
    L17:
        if (r3 >= r5) goto L20;
        d.a(r2, r4[r3]);
        r3 = r3 + 1;
    L20:
        if (r6.d() == null) goto L22;
        Bundle r7 = new Bundle(r6.d());
    L23:
        r7.putBoolean("android.support.allowGeneratedReplies", r6.e());
        if (Build.VERSION.SDK_INT < 24) goto L26;
        g.a(r2, r6.e());
    L26:
        r7.putInt("android.support.action.semanticAction", r6.h());
        if (Build.VERSION.SDK_INT < 28) goto L30;
        i.a(r2, r6.h());
    L30:
        if (Build.VERSION.SDK_INT < 29) goto L33;
        j.a(r2, r6.i());
    L33:
        if (Build.VERSION.SDK_INT < 31) goto L35;
        k.a(r2, r6.f());
    L35:
        r7.putBoolean("android.support.action.showsUserInterface", r6.k());
        d.a(r2, r7);
        d.a(this.f1115b, d.a(r2));
        return;
    L22:
        r7 = new Bundle();
        goto L23
    L8:
        r1 = null;
        goto L9
    L10:
        if (r0 == null) goto L12;
        int r8 = r0.b();
    L13:
        r2 = d.a(r8, r6.b(), r6.c());
        goto L15
    L12:
        r8 = 0;
        goto L13
    L37:
        if (Build.VERSION.SDK_INT < 16) goto L42;
        this.f.add(m.a(this.f1115b, r6));
        return;
    }

    public Notification c() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return a.a(this.f1115b);
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L26;
        Notification r0 = a.a(this.f1115b);
        if (this.h != 0) goto L11;
    L24:
        return r0;
    L11:
        if (d.a(r0) == null) goto L18;
        if ((r0.flags & 512) == 0) goto L18;
        if (this.h != 2) goto L18;
        a(r0);
    L18:
        if (d.a(r0) == null) goto L24;
        if ((r0.flags & 512) != 0) goto L24;
        if (this.h != 1) goto L24;
        a(r0);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L54;
        c.a(this.f1115b, this.g);
        Notification r1 = a.a(this.f1115b);
        RemoteViews r2 = this.f1117d;
        if (r2 == null) goto L30;
        r1.contentView = r2;
    L30:
        RemoteViews r3 = this.f1118e;
        if (r3 == null) goto L33;
        r1.bigContentView = r3;
    L33:
        RemoteViews r4 = this.i;
        if (r4 == null) goto L37;
        r1.headsUpContentView = r4;
    L37:
        if (this.h != 0) goto L39;
    L52:
        return r1;
    L39:
        if (d.a(r1) == null) goto L46;
        if ((r1.flags & 512) == 0) goto L46;
        if (this.h != 2) goto L46;
        a(r1);
    L46:
        if (d.a(r1) == null) goto L52;
        if ((r1.flags & 512) != 0) goto L52;
        if (this.h != 1) goto L52;
        a(r1);
        goto L52
    L54:
        if (Build.VERSION.SDK_INT < 20) goto L79;
        c.a(this.f1115b, this.g);
        Notification r5 = a.a(this.f1115b);
        RemoteViews r6 = this.f1117d;
        if (r6 == null) goto L58;
        r5.contentView = r6;
    L58:
        RemoteViews r7 = this.f1118e;
        if (r7 == null) goto L62;
        r5.bigContentView = r7;
    L62:
        if (this.h != 0) goto L64;
    L77:
        return r5;
    L64:
        if (d.a(r5) == null) goto L71;
        if ((r5.flags & 512) == 0) goto L71;
        if (this.h != 2) goto L71;
        a(r5);
    L71:
        if (d.a(r5) == null) goto L77;
        if ((r5.flags & 512) != 0) goto L77;
        if (this.h != 1) goto L77;
        a(r5);
        goto L77
    L79:
        if (Build.VERSION.SDK_INT < 19) goto L91;
        SparseArray<Bundle> r8 = m.a(this.f);
        if (r8 == null) goto L83;
        this.g.putSparseParcelableArray("android.support.actionExtras", r8);
    L83:
        c.a(this.f1115b, this.g);
        Notification r9 = a.a(this.f1115b);
        RemoteViews r10 = this.f1117d;
        if (r10 == null) goto L86;
        r9.contentView = r10;
    L86:
        RemoteViews r11 = this.f1118e;
        if (r11 == null) goto L89;
        r9.bigContentView = r11;
    L89:
        return r9;
    L91:
        if (Build.VERSION.SDK_INT < 16) goto L109;
        Notification r12 = a.a(this.f1115b);
        Bundle r13 = androidx.core.app.k.a(r12);
        Bundle r14 = new Bundle(this.g);
        Iterator<String> r15 = this.g.keySet().iterator();
    L94:
        if (r15.hasNext() == false) goto L98;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (r13.containsKey(r16) == false) goto L94;
        r14.remove(r16);
        goto L94
    L98:
        r13.putAll(r14);
        SparseArray<Bundle> r17 = m.a(this.f);
        if (r17 == null) goto L101;
        androidx.core.app.k.a(r12).putSparseParcelableArray("android.support.actionExtras", r17);
    L101:
        RemoteViews r18 = this.f1117d;
        if (r18 == null) goto L104;
        r12.contentView = r18;
    L104:
        RemoteViews r19 = this.f1118e;
        if (r19 == null) goto L107;
        r12.bigContentView = r19;
    L107:
        return r12;
    L109:
        return this.f1115b.getNotification();
    }

    private void a(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        r1.defaults &= -2;
        r1.defaults &= -3;
    }
}

package com.obric.autoaction.app.notification.a;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.j;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ChannelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24568a = null;
    private static final f<c> g = null;
    private static final AtomicInteger h = null;
    private static final AtomicInteger i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NotificationManagerCompat f24570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<? extends com.obric.autoaction.app.notification.a.b>[] f24571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<Class<? extends com.obric.autoaction.app.notification.a.b>, com.obric.autoaction.app.notification.a.b> f24572e;
    private final ConcurrentHashMap<String, b> f;

    /* JADX INFO: compiled from: ChannelManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a() {
            return (c) ZeusTransformUtils.preCheckCast(c.c().b(), c.class, "com.obric.aiagent.plugin");
        }

        public final int b() {
            return c.d().incrementAndGet();
        }
    }

    /* JADX INFO: compiled from: ChannelManager.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.app.notification.b.b f24573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24574b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24573a, r6.f24573a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f24574b, r6.f24574b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f24573a.hashCode() * 31;
            String r1 = this.f24574b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ManagedNotifier(notifier=" + this.f24573a + ", tag=" + this.f24574b + ')';
        }

        public final com.obric.autoaction.app.notification.b.b a() {
            return this.f24573a;
        }

        public final String b() {
            return this.f24574b;
        }
    }

    public static /* synthetic */ c lambda$ENvcNNCecfocB9Sqc5Yl20_TWEI() {
        return e();
    }

    public c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f24569b = r5;
        NotificationManagerCompat r6 = NotificationManagerCompat.a(r5);
        o.c(r6, "from(...)");
        this.f24570c = r6;
        this.f24571d = new Class[]{com.obric.autoaction.app.notification.a.a.class, d.class};
        this.f24572e = new HashMap();
        this.f = new ConcurrentHashMap();
    }

    public static final /* synthetic */ f c() {
        return g;
    }

    public static final /* synthetic */ AtomicInteger d() {
        return i;
    }

    public final Context getContext() {
        return this.f24569b;
    }

    static {
        f24568a = new a(null);
        g = g.a($$Lambda$c$ENvcNNCecfocB9Sqc5Yl20_TWEI.INSTANCE);
        h = new AtomicInteger(1000);
        i = new AtomicInteger(0);
    }

    private static final c e() {
        return new c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        NotificationManagerCompat r2 = this.f24570c;
        Class<? extends com.obric.autoaction.app.notification.a.b>[] r3 = this.f24571d;
        int r4 = r3.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L10;
        Class<? extends com.obric.autoaction.app.notification.a.b> r6 = r3[r5];
        com.obric.autoaction.app.notification.a.b r7 = r6.newInstance();     // Catch: Throwable -> L7
        com.obric.autoaction.app.notification.a.b r8 = (com.obric.autoaction.app.notification.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.notification.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        r8.a(this);     // Catch: Throwable -> L7
        r8.a(r2);     // Catch: Throwable -> L7
        com.obric.autoaction.app.notification.a.b r9 = (com.obric.autoaction.app.notification.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.notification.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        j r10 = r9.a(this.f24569b).a();     // Catch: Throwable -> L7
        o.c(r10, "build(...)");     // Catch: Throwable -> L7
        this.f24570c.a(r10);     // Catch: Throwable -> L7
        ((Map) ZeusTransformUtils.preCheckCast(this.f24572e, Map.class, "com.obric.aiagent.plugin")).put(r6, r9);     // Catch: Throwable -> L7
        Loog.INSTANCE.i("CHANNEL-MAN", "created channel: " + r9.a());     // Catch: Throwable -> L7
    L9:
        r5 = r5 + 1;
    L7:
        th = move-exception;
        Loog.INSTANCE.e("CHANNEL-MAN", "unable to create channel: " + r6 + ", " + th, th);
        goto L9
    L10:
        r2.a();
    }

    public final boolean a(com.obric.autoaction.app.notification.b.b r6) {
        com.obric.autoaction.app.notification.b.b r7 = (com.obric.autoaction.app.notification.b.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autoaction.app.notification.b.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "notifier");
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r7.d()), b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = r1.a().e();
        this.f24570c.a(r1.b(), r3);     // Catch: Exception -> L8
        this.f.remove(r7.d());     // Catch: Exception -> L8
        Loog.INSTANCE.d("CHANNEL-MAN", "cancelled notification: " + r3);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        Loog.INSTANCE.e("CHANNEL-MAN", "cannot cancel notifier from notification manager; reason: " + e.getMessage());
        return false;
    }

    public final boolean a(String r5) {
        o.e(r5, DbHelper.COL_ID);
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r5), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L13;
        Loog.INSTANCE.w("CHANNEL-MAN", "notifier id " + r5 + " not found; trying to decode the notifierId as a standardized format");
        b(r5);     // Catch: Throwable -> L9
        return true;
    L9:
        Loog.INSTANCE.w("CHANNEL-MAN", "notifier id " + r5 + " not found; nor does notifierId in a standardized format");
        return false;
    L13:
        return a(r0.a());
    }

    private final boolean b(String r14) {
        if (d.o.o.b(r14, "T/", false, 2, null) == false) goto L7;
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), "/", 2, false, 4, null);
        String r1 = r14.substring(2, r0);
        o.c(r1, "substring(...)");
        String r15 = r14.substring(r0 + 1);
        o.c(r15, "substring(...)");
        int r16 = Integer.parseInt(r15);
        this.f24570c.a(r1, r16);
        return true;
    L7:
        if (d.o.o.b(r14, "C/", false, 2, null) == false) goto L10;
        String r17 = r14.substring(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), "/", 2, false, 4, null) + 1);
        o.c(r17, "substring(...)");
        int r18 = Integer.parseInt(r17);
        this.f24570c.a(null, r18);
        return true;
    L10:
        return false;
    }

    public final void b() {
        this.f24570c.a();
        this.f.clear();
    }

    public final void a(d.h.a.b<? super b, Boolean> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r7, "predicate");
        Collection<b> r0 = this.f.values();
        o.c(r0, "<get-values>(...)");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");
        o.a(r2);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L4;
        a(r2.a());
        goto L4
    }
}

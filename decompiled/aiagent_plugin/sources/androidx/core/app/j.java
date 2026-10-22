package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NotificationChannelCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f1082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CharSequence f1083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f1085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f1086e;
    boolean f;
    Uri g;
    AudioAttributes h;
    boolean i;
    int j;
    boolean k;
    long[] l;
    String m;
    String n;

    /* JADX INFO: compiled from: NotificationChannelCompat.java */
    static class a {
        static NotificationChannel a(String r2, CharSequence r3, int r4) {
            return new NotificationChannel(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
        }

        static String a(NotificationChannel r0) {
            return r0.getId();
        }

        static int b(NotificationChannel r0) {
            return r0.getImportance();
        }

        static CharSequence c(NotificationChannel r0) {
            return r0.getName();
        }

        static String d(NotificationChannel r0) {
            return r0.getDescription();
        }

        static void a(NotificationChannel r0, String r1) {
            r0.setDescription(r1);
        }

        static String e(NotificationChannel r0) {
            return r0.getGroup();
        }

        static void b(NotificationChannel r0, String r1) {
            r0.setGroup(r1);
        }

        static boolean f(NotificationChannel r0) {
            return r0.canShowBadge();
        }

        static void a(NotificationChannel r0, boolean r1) {
            r0.setShowBadge(r1);
        }

        static Uri g(NotificationChannel r0) {
            return r0.getSound();
        }

        static void a(NotificationChannel r0, Uri r1, AudioAttributes r2) {
            r0.setSound(r1, r2);
        }

        static AudioAttributes h(NotificationChannel r0) {
            return r0.getAudioAttributes();
        }

        static boolean i(NotificationChannel r0) {
            return r0.shouldShowLights();
        }

        static void b(NotificationChannel r0, boolean r1) {
            r0.enableLights(r1);
        }

        static int j(NotificationChannel r0) {
            return r0.getLightColor();
        }

        static void a(NotificationChannel r0, int r1) {
            r0.setLightColor(r1);
        }

        static boolean k(NotificationChannel r0) {
            return r0.shouldVibrate();
        }

        static void c(NotificationChannel r0, boolean r1) {
            r0.enableVibration(r1);
        }

        static long[] l(NotificationChannel r0) {
            return r0.getVibrationPattern();
        }

        static void a(NotificationChannel r0, long[] r1) {
            r0.setVibrationPattern(r1);
        }

        static boolean m(NotificationChannel r0) {
            return r0.canBypassDnd();
        }

        static int n(NotificationChannel r0) {
            return r0.getLockscreenVisibility();
        }
    }

    /* JADX INFO: compiled from: NotificationChannelCompat.java */
    static class b {
        static String a(NotificationChannel r0) {
            return r0.getParentChannelId();
        }

        static String b(NotificationChannel r0) {
            return r0.getConversationId();
        }

        static void a(NotificationChannel r0, String r1, String r2) {
            r0.setConversationId(r1, r2);
        }

        static boolean c(NotificationChannel r0) {
            return r0.isImportantConversation();
        }
    }

    /* JADX INFO: compiled from: NotificationChannelCompat.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f1087a;

        public c(String r2, int r3) {
            this.f1087a = new j(r2, r3);
        }

        public c a(CharSequence r3) {
            this.f1087a.f1083b = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public c a(String r2) {
            this.f1087a.f1085d = r2;
            return this;
        }

        public c a(boolean r2) {
            this.f1087a.k = r2;
            return this;
        }

        public j a() {
            return this.f1087a;
        }
    }

    j(String r3, int r4) {
        this.f = true;
        this.g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.j = 0;
        this.f1082a = (String) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), String.class, "com.obric.aiagent.plugin");
        this.f1084c = r4;
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        return;
    }

    NotificationChannel a() {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return null;
    L6:
        NotificationChannel r0 = a.a(this.f1082a, this.f1083b, this.f1084c);
        a.a(r0, this.f1085d);
        a.b(r0, this.f1086e);
        a.a(r0, this.f);
        a.a(r0, this.g, this.h);
        a.b(r0, this.i);
        a.a(r0, this.j);
        a.a(r0, this.l);
        a.c(r0, this.k);
        if (Build.VERSION.SDK_INT < 30) goto L13;
        String r1 = this.m;
        if (r1 == null) goto L13;
        String r3 = this.n;
        if (r3 == null) goto L13;
        b.a(r0, r1, r3);
    L13:
        return r0;
    }
}

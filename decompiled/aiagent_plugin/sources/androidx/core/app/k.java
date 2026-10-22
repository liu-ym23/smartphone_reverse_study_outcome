package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String TAG = "NotifCompat";

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f1088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public int f1090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f1091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PendingIntent f1092e;
        private IconCompat f;
        private final p[] g;
        private final p[] h;
        private boolean i;
        private final int j;
        private final boolean k;
        private boolean l;

        /* JADX INFO: renamed from: androidx.core.app.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NotificationCompat.java */
        public static final class C0021a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IconCompat f1093a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CharSequence f1094b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f1095c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f1096d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Bundle f1097e;
            private ArrayList<p> f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;

            public C0021a(IconCompat r12, CharSequence r13, PendingIntent r14) {
                this(r12, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin"), r14, new Bundle(), null, true, 0, true, false, false);
            }

            private C0021a(IconCompat r3, CharSequence r4, PendingIntent r5, Bundle r6, p[] r7, boolean r8, int r9, boolean r10, boolean r11, boolean r12) {
                CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
                this.f1096d = true;
                this.h = true;
                this.f1093a = r3;
                this.f1094b = c.c(r13);
                this.f1095c = r5;
                this.f1097e = r6;
                if (r7 != null) goto L5;
                ArrayList<p> r14 = null;
            L6:
                this.f = r14;
                this.f1096d = r8;
                this.g = r9;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                return;
            L5:
                r14 = new ArrayList(Arrays.asList(r7));
                goto L6
            }

            private void b() {
                if (this.i == true) goto L5;
                return;
            L5:
                Objects.requireNonNull(this.f1095c, "Contextual Actions must contain a valid PendingIntent");
            }

            public a a() {
                b();
                ArrayList r1 = new ArrayList();
                ArrayList r2 = new ArrayList();
                ArrayList<p> r3 = this.f;
                if (r3 == null) goto L11;
                Iterator<p> r4 = r3.iterator();
            L6:
                if (r4.hasNext() == false) goto L11;
                p r5 = (p) ZeusTransformUtils.preCheckCast(r4.next(), p.class, "com.obric.aiagent.plugin");
                if (r5.e() == true) goto L9;
                r2.add(r5);
                goto L6
            L9:
                r1.add(r5);
            L11:
                p[] r6 = null;
                if (r1.isEmpty() == false) goto L14;
                p[] r12 = null;
            L16:
                if (r2.isEmpty() == true) goto L20;
                r6 = (p[]) ZeusTransformUtils.preCheckCast(r2.toArray(new p[r2.size()]), p[].class, "com.obric.aiagent.plugin");
            L20:
                return new a(this.f1093a, this.f1094b, this.f1095c, this.f1097e, r6, r12, this.f1096d, this.g, this.h, this.i, this.j);
            L14:
                r12 = (p[]) ZeusTransformUtils.preCheckCast(r1.toArray(new p[r1.size()]), p[].class, "com.obric.aiagent.plugin");
                goto L16
            }
        }

        a(IconCompat r3, CharSequence r4, PendingIntent r5, Bundle r6, p[] r7, p[] r8, boolean r9, int r10, boolean r11, boolean r12, boolean r13) {
            CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            this.f1089b = true;
            this.f = r3;
            if (r3 != null) goto L5;
        L7:
            this.f1091d = c.c(r14);
            this.f1092e = r5;
            if (r6 != null) goto L11;
            r6 = new Bundle();
        L11:
            this.f1088a = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.f1089b = r11;
            this.k = r12;
            this.l = r13;
            return;
        L5:
            if (r3.getType() != 2) goto L7;
            this.f1090c = r3.b();
            goto L7
        }

        public IconCompat a() {
            if (this.f != null) goto L8;
            int r0 = this.f1090c;
            if (r0 == 0) goto L8;
            this.f = IconCompat.a(null, "", r0);
        L8:
            return this.f;
        }

        public CharSequence b() {
            return this.f1091d;
        }

        public PendingIntent c() {
            return this.f1092e;
        }

        public Bundle d() {
            return this.f1088a;
        }

        public boolean e() {
            return this.i;
        }

        public boolean f() {
            return this.l;
        }

        public p[] g() {
            return this.g;
        }

        public int h() {
            return this.j;
        }

        public boolean i() {
            return this.k;
        }

        public p[] j() {
            return this.h;
        }

        public boolean k() {
            return this.f1089b;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PendingIntent f1098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PendingIntent f1099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IconCompat f1100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1102e;
        private int f;
        private String g;

        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class a {
            static Notification.BubbleMetadata a(b r2) {
                if (r2 != null) goto L6;
                return null;
            L6:
                if (r2.a() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder().setIcon(r2.d().e()).setIntent(r2.a()).setDeleteIntent(r2.c()).setAutoExpandBubble(r2.g()).setSuppressNotification(r2.h());
                if (r2.e() == 0) goto L12;
                r0.setDesiredHeight(r2.e());
            L12:
                if (r2.f() == 0) goto L15;
                r0.setDesiredHeightResId(r2.f());
            L15:
                return r0.build();
            }
        }

        /* JADX INFO: renamed from: androidx.core.app.k$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class C0022b {
            static Notification.BubbleMetadata a(b r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.b() == null) goto L8;
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder(r3.b());
            L9:
                r0.setDeleteIntent(r3.c()).setAutoExpandBubble(r3.g()).setSuppressNotification(r3.h());
                if (r3.e() == 0) goto L13;
                r0.setDesiredHeight(r3.e());
            L13:
                if (r3.f() == 0) goto L16;
                r0.setDesiredHeightResId(r3.f());
            L16:
                return r0.build();
            L8:
                r0 = new Notification.BubbleMetadata.Builder(r3.a(), r3.d().e());
                goto L9
            }
        }

        public PendingIntent a() {
            return this.f1098a;
        }

        public String b() {
            return this.g;
        }

        public PendingIntent c() {
            return this.f1099b;
        }

        public IconCompat d() {
            return this.f1100c;
        }

        public int e() {
            return this.f1101d;
        }

        public int f() {
            return this.f1102e;
        }

        public boolean g() {
            if ((this.f & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean h() {
            if ((this.f & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public static Notification.BubbleMetadata a(b r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (Build.VERSION.SDK_INT < 30) goto L10;
            return C0022b.a(r3);
        L10:
            if (Build.VERSION.SDK_INT == 29) goto L12;
            return null;
        L12:
            return a.a(r3);
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class c {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        RemoteViews f1103J;
        String K;
        int L;
        String M;
        androidx.core.content.b N;
        long O;
        int P;
        int Q;
        boolean R;
        b S;
        Notification T;
        boolean U;
        Object V;

        @Deprecated
        public ArrayList<String> W;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f1104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f1105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<n> f1106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<a> f1107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f1108e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        IconCompat j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        e p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public c(Context r6, String r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            this.f1105b = new ArrayList();
            this.f1106c = new ArrayList();
            this.f1107d = new ArrayList();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            this.Q = 0;
            this.T = new Notification();
            this.f1104a = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.K = r7;
            Notification r9 = this.T;
            r9.when = System.currentTimeMillis();
            this.T.audioStreamType = -1;
            this.m = 0;
            this.W = new ArrayList();
            this.R = true;
        }

        public c a(int r2) {
            this.T.icon = r2;
            return this;
        }

        public c a(boolean r1) {
            this.U = r1;
            return this;
        }

        public c a(CharSequence r3) {
            this.f1108e = c((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public c b(CharSequence r3) {
            this.f = c((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public c b(boolean r2) {
            a(2, r2);
            return this;
        }

        public c c(boolean r2) {
            a(8, r2);
            return this;
        }

        public c a(String r1) {
            this.C = r1;
            return this;
        }

        private void a(int r1, boolean r2) {
            if (r2 == false) goto L4;
            Notification r0 = this.T;
            r0.flags = r1 | r0.flags;
            return;
        L4:
            Notification r3 = this.T;
            int r4 = r3.flags;
            r3.flags = (~r1) & r4;
        }

        public c b(int r1) {
            this.m = r1;
            return this;
        }

        public Bundle a() {
            if (this.D != null) goto L6;
            this.D = new Bundle();
        L6:
            return this.D;
        }

        public Notification b() {
            return new l(this).b();
        }

        public static CharSequence c(CharSequence r2) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L6;
            return r3;
        L6:
            if (r3.length() > 5120) goto L8;
            return r3;
        L8:
            return r3.subSequence(0, 5120);
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class d extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1109e;
        private n f;
        private PendingIntent g;
        private PendingIntent h;
        private PendingIntent i;
        private boolean j;
        private Integer k;
        private Integer l;
        private IconCompat m;
        private CharSequence n;

        /* JADX INFO: compiled from: NotificationCompat.java */
        static class a {
            static void a(Notification.CallStyle r0, Notification.Builder r1) {
                r0.setBuilder(r1);
            }
        }

        /* JADX INFO: compiled from: NotificationCompat.java */
        static class b {
            static Notification.Builder a(Notification.Builder r0, String r1) {
                return r0.addPerson(r1);
            }

            static Notification.Builder b(Notification.Builder r0, String r1) {
                return r0.setCategory(r1);
            }
        }

        /* JADX INFO: compiled from: NotificationCompat.java */
        static class c {
            static Parcelable a(Icon r0) {
                return r0;
            }

            static void a(Notification.Builder r0, Icon r1) {
                r0.setLargeIcon(r1);
            }

            static Notification.Action.Builder a(Icon r2, CharSequence r3, PendingIntent r4) {
                return new Notification.Action.Builder(r2, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
            }
        }

        /* JADX INFO: renamed from: androidx.core.app.k$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NotificationCompat.java */
        static class C0023d {
            static Parcelable a(Person r0) {
                return r0;
            }

            static Notification.Builder a(Notification.Builder r0, Person r1) {
                return r0.addPerson(r1);
            }
        }

        /* JADX INFO: compiled from: NotificationCompat.java */
        static class e {
            static Notification.CallStyle a(Person r0, PendingIntent r1, PendingIntent r2) {
                return Notification.CallStyle.forIncomingCall(r0, r1, r2);
            }

            static Notification.CallStyle a(Person r0, PendingIntent r1) {
                return Notification.CallStyle.forOngoingCall(r0, r1);
            }

            static Notification.CallStyle b(Person r0, PendingIntent r1, PendingIntent r2) {
                return Notification.CallStyle.forScreeningCall(r0, r1, r2);
            }

            static Notification.CallStyle a(Notification.CallStyle r0, boolean r1) {
                return r0.setIsVideo(r1);
            }

            static Notification.CallStyle a(Notification.CallStyle r0, Icon r1) {
                return r0.setVerificationIcon(r1);
            }

            static Notification.CallStyle a(Notification.CallStyle r2, CharSequence r3) {
                return r2.setVerificationText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            }

            static Notification.CallStyle a(Notification.CallStyle r0, int r1) {
                return r0.setAnswerButtonColorHint(r1);
            }

            static Notification.CallStyle b(Notification.CallStyle r0, int r1) {
                return r0.setDeclineButtonColorHint(r1);
            }

            static Notification.Action.Builder a(Notification.Action.Builder r0, boolean r1) {
                return r0.setAuthenticationRequired(r1);
            }
        }

        @Override // androidx.core.app.k.e
        public String a() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public d() {
        }

        @Override // androidx.core.app.k.e
        public void a(Bundle r3) {
            super.a(r3);
            r3.putInt("android.callType", this.f1109e);
            r3.putBoolean("android.callIsVideo", this.j);
            if (this.f == null) goto L9;
            if (Build.VERSION.SDK_INT < 28) goto L7;
            r3.putParcelable("android.callPerson", C0023d.a(this.f.b()));
            goto L9
        L7:
            r3.putParcelable("android.callPersonCompat", this.f.a());
        L9:
            if (this.m != null) goto L11;
        L14:
            r3.putCharSequence("android.verificationText", this.n);
            r3.putParcelable("android.answerIntent", this.g);
            r3.putParcelable("android.declineIntent", this.h);
            r3.putParcelable("android.hangUpIntent", this.i);
            Integer r0 = this.k;
            if (r0 == null) goto L17;
            r3.putInt("android.answerColor", r0.intValue());
        L17:
            Integer r2 = this.l;
            if (r2 == null) goto L21;
            r3.putInt("android.declineColor", r2.intValue());
            return;
        L21:
            return;
        L11:
            if (Build.VERSION.SDK_INT < 23) goto L13;
            r3.putParcelable("android.verificationIcon", c.a(this.m.a(this.f1110a.f1104a)));
            goto L14
        L13:
            r3.putParcelable("android.verificationIconCompat", this.m.f());
            goto L14
        }

        @Override // androidx.core.app.k.e
        public void a(i r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
            CharSequence r1 = null;
            Notification.CallStyle r2 = null;
            r2 = null;
            r1 = null;
            if (Build.VERSION.SDK_INT < 31) goto L27;
            int r0 = this.f1109e;
            if (r0 != 1) goto L7;
            r2 = e.a(this.f.b(), this.h, this.g);
        L16:
            if (r2 == null) goto L55;
            a.a(r2, r6.a());
            Integer r7 = this.k;
            if (r7 == null) goto L20;
            e.a(r2, r7.intValue());
        L20:
            Integer r8 = this.l;
            if (r8 == null) goto L23;
            e.b(r2, r8.intValue());
        L23:
            e.a(r2, this.n);
            IconCompat r9 = this.m;
            if (r9 == null) goto L26;
            e.a(r2, r9.a(this.f1110a.f1104a));
        L26:
            e.a(r2, this.j);
            return;
        L55:
            return;
        L7:
            if (r0 != 2) goto L9;
            r2 = e.a(this.f.b(), this.i);
            goto L16
        L9:
            if (r0 != 3) goto L11;
            r2 = e.b(this.f.b(), this.i, this.g);
            goto L16
        L11:
            if (a(k.TAG, 3) == false) goto L16;
            a(k.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.f1109e));
            goto L16
        L27:
            Notification.Builder r10 = r6.a();
            n r3 = this.f;
            if (r3 == null) goto L30;
            CharSequence r4 = r3.c();
        L31:
            r10.setContentTitle(r4);
            if (this.f1110a.D != null) goto L34;
        L36:
            if (r1 != null) goto L38;
            r1 = c();
        L38:
            r10.setContentText(r1);
            if (this.f == null) goto L52;
            if (Build.VERSION.SDK_INT < 23) goto L46;
            if (this.f.d() == null) goto L46;
            c.a(r10, this.f.d().a(this.f1110a.f1104a));
        L46:
            if (Build.VERSION.SDK_INT < 28) goto L49;
            C0023d.a(r10, this.f.b());
            goto L52
        L49:
            if (Build.VERSION.SDK_INT < 21) goto L52;
            b.a(r10, this.f.e());
        L52:
            if (Build.VERSION.SDK_INT < 21) goto L57;
            b.b(r10, "call");
            return;
        L57:
            return;
        L34:
            if (this.f1110a.D.containsKey("android.text") == false) goto L36;
            r1 = this.f1110a.D.getCharSequence("android.text");
            goto L36
        L30:
            r4 = null;
            goto L31
        }

        private String c() {
            int r0 = this.f1109e;
            if (r0 == 1) goto L15;
            if (r0 == 2) goto L13;
            if (r0 == 3) goto L11;
            return null;
        L11:
            return ZeusTransformUtils.getResources(this.f1110a.f1104a, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.call_notification_screening_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_screening_text"));
        L13:
            return ZeusTransformUtils.getResources(this.f1110a.f1104a, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.call_notification_ongoing_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_ongoing_text"));
        L15:
            return ZeusTransformUtils.getResources(this.f1110a.f1104a, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.call_notification_incoming_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_incoming_text"));
        }

        private a d() {
            int r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_decline_low, "drawable", "ic_call_decline_low");
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_decline, "drawable", "ic_call_decline");
        L5:
            int r2 = r0;
            if (this.h != null) goto L10;
            return a(r2, ZeusTransformUtils.mapRes(R.string.call_notification_hang_up_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_hang_up_action"), this.l, ZeusTransformUtils.mapRes(R.color.call_notification_decline_color, "color", "call_notification_decline_color"), this.i);
        L10:
            return a(r2, ZeusTransformUtils.mapRes(R.string.call_notification_decline_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_decline_action"), this.l, ZeusTransformUtils.mapRes(R.color.call_notification_decline_color, "color", "call_notification_decline_color"), this.h);
        }

        private a e() {
            int r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_video_low, "drawable", "ic_call_answer_video_low");
            int r2 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_low, "drawable", "ic_call_answer_low");
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r0 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer_video, "drawable", "ic_call_answer_video");
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_call_answer, "drawable", "ic_call_answer");
        L6:
            if (this.g != null) goto L8;
            return null;
        L8:
            boolean r1 = this.j;
            if (r1 == false) goto L11;
            int r4 = r0;
        L13:
            if (r1 == false) goto L15;
            int r3 = ZeusTransformUtils.mapRes(R.string.call_notification_answer_video_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_answer_video_action");
        L17:
            return a(r4, r3, this.k, ZeusTransformUtils.mapRes(R.color.call_notification_answer_color, "color", "call_notification_answer_color"), this.g);
        L15:
            r3 = ZeusTransformUtils.mapRes(R.string.call_notification_answer_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "call_notification_answer_action");
            goto L17
        L11:
            r4 = r2;
            goto L13
        }

        private a a(int r3, int r4, Integer r5, int r6, PendingIntent r7) {
            if (r5 != null) goto L4;
            r5 = Integer.valueOf(androidx.core.content.a.c(this.f1110a.f1104a, r6));
        L4:
            SpannableStringBuilder r8 = new SpannableStringBuilder();
            r8.append(ZeusTransformUtils.getResources(this.f1110a.f1104a, "com.obric.aiagent.plugin").getString(r4));
            r8.setSpan(new ForegroundColorSpan(r5.intValue()), 0, r8.length(), 18);
            a r2 = new a.C0021a(IconCompat.a(this.f1110a.f1104a, r3), r8, r7).a();
            r2.d().putBoolean("key_action_priority", true);
            return r2;
        }

        private boolean a(a r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (r1.d().getBoolean("key_action_priority") == false) goto L6;
            return true;
        }

        public ArrayList<a> b() {
            a r0 = d();
            a r1 = e();
            ArrayList<a> r2 = new ArrayList(3);
            r2.add(r0);
            int r3 = 2;
            ArrayList<a> r4 = this.f1110a.f1105b;
            if (r4 == null) goto L18;
            Iterator<a> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L18;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");
            if (r6.i() == false) goto L11;
            r2.add(r6);
        L15:
            if (r1 == null) goto L6;
            if (r3 != 1) goto L6;
            r2.add(r1);
            r3 = r3 - 1;
            goto L6
        L11:
            if (a(r6) == true) goto L15;
            if (r3 <= 1) goto L15;
            r2.add(r6);
            r3 = r3 - 1;
        L18:
            if (r1 == null) goto L21;
            if (r3 < 1) goto L21;
            r2.add(r1);
        L21:
            return r2;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean a(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected c f1110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f1111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f1112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1113d;

        public String a() {
            return null;
        }

        public void a(i r2) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
        }

        public RemoteViews b(i r2) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            return null;
        }

        public RemoteViews c(i r2) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            return null;
        }

        public RemoteViews d(i r2) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            return null;
        }

        public e() {
            this.f1113d = false;
        }

        public void a(Bundle r3) {
            if (this.f1113d == false) goto L5;
            r3.putCharSequence("android.summaryText", this.f1112c);
        L5:
            CharSequence r0 = this.f1111b;
            if (r0 == null) goto L8;
            r3.putCharSequence("android.title.big", r0);
        L8:
            String r2 = a();
            if (r2 == null) goto L12;
            r3.putString("androidx.core.app.extra.COMPAT_TEMPLATE", r2);
            return;
        }
    }

    public static Bundle a(Notification r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return r2.extras;
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return null;
    L9:
        return m.a(r2);
    }
}

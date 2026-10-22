package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import org.libpag.BuildConfig;
import z.C1330b;
import z.C1331c;
import z.C1333e;

/* loaded from: classes.dex */
public class j {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f9460a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f9461b;

        /* renamed from: c, reason: collision with root package name */
        private final r[] f9462c;

        /* renamed from: d, reason: collision with root package name */
        private final r[] f9463d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9464e;

        /* renamed from: f, reason: collision with root package name */
        boolean f9465f;

        /* renamed from: g, reason: collision with root package name */
        private final int f9466g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f9467h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f9468i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f9469j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f9470k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f9471l;

        /* renamed from: androidx.core.app.j$a$a, reason: collision with other inner class name */
        public static final class C0115a {

            /* renamed from: a, reason: collision with root package name */
            private final IconCompat f9472a;

            /* renamed from: b, reason: collision with root package name */
            private final CharSequence f9473b;

            /* renamed from: c, reason: collision with root package name */
            private final PendingIntent f9474c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f9475d;

            /* renamed from: e, reason: collision with root package name */
            private final Bundle f9476e;

            /* renamed from: f, reason: collision with root package name */
            private ArrayList<r> f9477f;

            /* renamed from: g, reason: collision with root package name */
            private int f9478g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f9479h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f9480i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f9481j;

            public C0115a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private void b() {
                if (this.f9480i && this.f9474c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<r> arrayList3 = this.f9477f;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    int i5 = 0;
                    while (i5 < size) {
                        r rVar = arrayList3.get(i5);
                        i5++;
                        r rVar2 = rVar;
                        if (rVar2.j()) {
                            arrayList.add(rVar2);
                        } else {
                            arrayList2.add(rVar2);
                        }
                    }
                }
                return new a(this.f9472a, this.f9473b, this.f9474c, this.f9476e, arrayList2.isEmpty() ? null : (r[]) arrayList2.toArray(new r[arrayList2.size()]), arrayList.isEmpty() ? null : (r[]) arrayList.toArray(new r[arrayList.size()]), this.f9475d, this.f9478g, this.f9479h, this.f9480i, this.f9481j);
            }

            private C0115a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, r[] rVarArr, boolean z5, int i5, boolean z6, boolean z7, boolean z8) {
                this.f9475d = true;
                this.f9479h = true;
                this.f9472a = iconCompat;
                this.f9473b = d.d(charSequence);
                this.f9474c = pendingIntent;
                this.f9476e = bundle;
                this.f9477f = rVarArr == null ? null : new ArrayList<>(Arrays.asList(rVarArr));
                this.f9475d = z5;
                this.f9478g = i5;
                this.f9479h = z6;
                this.f9480i = z7;
                this.f9481j = z8;
            }
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, r[] rVarArr, r[] rVarArr2, boolean z5, int i5, boolean z6, boolean z7, boolean z8) {
            this.f9465f = true;
            this.f9461b = iconCompat;
            if (iconCompat != null && iconCompat.j() == 2) {
                this.f9468i = iconCompat.h();
            }
            this.f9469j = d.d(charSequence);
            this.f9470k = pendingIntent;
            this.f9460a = bundle == null ? new Bundle() : bundle;
            this.f9462c = rVarArr;
            this.f9463d = rVarArr2;
            this.f9464e = z5;
            this.f9466g = i5;
            this.f9465f = z6;
            this.f9467h = z7;
            this.f9471l = z8;
        }

        public PendingIntent a() {
            return this.f9470k;
        }

        public boolean b() {
            return this.f9464e;
        }

        public Bundle c() {
            return this.f9460a;
        }

        public IconCompat d() {
            int i5;
            if (this.f9461b == null && (i5 = this.f9468i) != 0) {
                this.f9461b = IconCompat.g(null, BuildConfig.FLAVOR, i5);
            }
            return this.f9461b;
        }

        public r[] e() {
            return this.f9462c;
        }

        public int f() {
            return this.f9466g;
        }

        public boolean g() {
            return this.f9465f;
        }

        public CharSequence h() {
            return this.f9469j;
        }

        public boolean i() {
            return this.f9471l;
        }

        public boolean j() {
            return this.f9467h;
        }
    }

    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f9482e;

        @Override // androidx.core.app.j.f
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(iVar.a()).setBigContentTitle(this.f9541b).bigText(this.f9482e);
            if (this.f9543d) {
                bigTextStyleBigText.setSummaryText(this.f9542c);
            }
        }

        @Override // androidx.core.app.j.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f9482e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static class d {

        /* renamed from: A, reason: collision with root package name */
        boolean f9483A;

        /* renamed from: B, reason: collision with root package name */
        boolean f9484B;

        /* renamed from: C, reason: collision with root package name */
        String f9485C;

        /* renamed from: D, reason: collision with root package name */
        Bundle f9486D;

        /* renamed from: G, reason: collision with root package name */
        Notification f9489G;

        /* renamed from: H, reason: collision with root package name */
        RemoteViews f9490H;

        /* renamed from: I, reason: collision with root package name */
        RemoteViews f9491I;

        /* renamed from: J, reason: collision with root package name */
        RemoteViews f9492J;

        /* renamed from: K, reason: collision with root package name */
        String f9493K;

        /* renamed from: M, reason: collision with root package name */
        String f9495M;

        /* renamed from: N, reason: collision with root package name */
        long f9496N;

        /* renamed from: Q, reason: collision with root package name */
        boolean f9499Q;

        /* renamed from: R, reason: collision with root package name */
        Notification f9500R;

        /* renamed from: S, reason: collision with root package name */
        boolean f9501S;

        /* renamed from: T, reason: collision with root package name */
        Object f9502T;

        /* renamed from: U, reason: collision with root package name */
        @Deprecated
        public ArrayList<String> f9503U;

        /* renamed from: a, reason: collision with root package name */
        public Context f9504a;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f9508e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f9509f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f9510g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f9511h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f9512i;

        /* renamed from: j, reason: collision with root package name */
        IconCompat f9513j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f9514k;

        /* renamed from: l, reason: collision with root package name */
        int f9515l;

        /* renamed from: m, reason: collision with root package name */
        int f9516m;

        /* renamed from: o, reason: collision with root package name */
        boolean f9518o;

        /* renamed from: p, reason: collision with root package name */
        f f9519p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f9520q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f9521r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence[] f9522s;

        /* renamed from: t, reason: collision with root package name */
        int f9523t;

        /* renamed from: u, reason: collision with root package name */
        int f9524u;

        /* renamed from: v, reason: collision with root package name */
        boolean f9525v;

        /* renamed from: w, reason: collision with root package name */
        String f9526w;

        /* renamed from: x, reason: collision with root package name */
        boolean f9527x;

        /* renamed from: y, reason: collision with root package name */
        String f9528y;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f9505b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<p> f9506c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        ArrayList<a> f9507d = new ArrayList<>();

        /* renamed from: n, reason: collision with root package name */
        boolean f9517n = true;

        /* renamed from: z, reason: collision with root package name */
        boolean f9529z = false;

        /* renamed from: E, reason: collision with root package name */
        int f9487E = 0;

        /* renamed from: F, reason: collision with root package name */
        int f9488F = 0;

        /* renamed from: L, reason: collision with root package name */
        int f9494L = 0;

        /* renamed from: O, reason: collision with root package name */
        int f9497O = 0;

        /* renamed from: P, reason: collision with root package name */
        int f9498P = 0;

        public d(Context context, String str) {
            Notification notification = new Notification();
            this.f9500R = notification;
            this.f9504a = context;
            this.f9493K = str;
            notification.when = System.currentTimeMillis();
            this.f9500R.audioStreamType = -1;
            this.f9516m = 0;
            this.f9503U = new ArrayList<>();
            this.f9499Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void k(int i5, boolean z5) {
            if (z5) {
                Notification notification = this.f9500R;
                notification.flags = i5 | notification.flags;
            } else {
                Notification notification2 = this.f9500R;
                notification2.flags = (~i5) & notification2.flags;
            }
        }

        public d a(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.f9486D;
                if (bundle2 == null) {
                    this.f9486D = new Bundle(bundle);
                    return this;
                }
                bundle2.putAll(bundle);
            }
            return this;
        }

        public Notification b() {
            return new k(this).c();
        }

        public Bundle c() {
            if (this.f9486D == null) {
                this.f9486D = new Bundle();
            }
            return this.f9486D;
        }

        public d e(boolean z5) {
            k(16, z5);
            return this;
        }

        public d f(String str) {
            this.f9485C = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f9510g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f9509f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f9508e = d(charSequence);
            return this;
        }

        public d j(int i5) {
            Notification notification = this.f9500R;
            notification.defaults = i5;
            if ((i5 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public d l(boolean z5) {
            k(8, z5);
            return this;
        }

        public d m(int i5) {
            this.f9516m = i5;
            return this;
        }

        public d n(boolean z5) {
            this.f9517n = z5;
            return this;
        }

        public d o(int i5) {
            this.f9500R.icon = i5;
            return this;
        }

        public d p(f fVar) {
            if (this.f9519p != fVar) {
                this.f9519p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public d q(CharSequence charSequence) {
            this.f9500R.tickerText = d(charSequence);
            return this;
        }

        public d r(int i5) {
            this.f9488F = i5;
            return this;
        }

        public d s(long j5) {
            this.f9500R.when = j5;
            return this;
        }
    }

    public static class e extends f {

        /* renamed from: e, reason: collision with root package name */
        private int f9530e;

        /* renamed from: f, reason: collision with root package name */
        private p f9531f;

        /* renamed from: g, reason: collision with root package name */
        private PendingIntent f9532g;

        /* renamed from: h, reason: collision with root package name */
        private PendingIntent f9533h;

        /* renamed from: i, reason: collision with root package name */
        private PendingIntent f9534i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f9535j;

        /* renamed from: k, reason: collision with root package name */
        private Integer f9536k;

        /* renamed from: l, reason: collision with root package name */
        private Integer f9537l;

        /* renamed from: m, reason: collision with root package name */
        private IconCompat f9538m;

        /* renamed from: n, reason: collision with root package name */
        private CharSequence f9539n;

        static class a {
            static Parcelable a(Icon icon) {
                return icon;
            }

            static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        static class b {
            static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            static Parcelable b(Person person) {
                return person;
            }
        }

        static class c {
            static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle d(Notification.CallStyle callStyle, int i5) {
                return callStyle.setAnswerButtonColorHint(i5);
            }

            static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z5) {
                return builder.setAuthenticationRequired(z5);
            }

            static Notification.CallStyle f(Notification.CallStyle callStyle, int i5) {
                return callStyle.setDeclineButtonColorHint(i5);
            }

            static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z5) {
                return callStyle.setIsVideo(z5);
            }

            static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        private boolean i(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        private a j(int i5, int i6, Integer num, int i7, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(androidx.core.content.a.c(this.f9540a.f9504a, i7));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f9540a.f9504a.getResources().getString(i6));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarA = new a.C0115a(IconCompat.f(this.f9540a.f9504a, i5), spannableStringBuilder, pendingIntent).a();
            aVarA.c().putBoolean("key_action_priority", true);
            return aVarA;
        }

        private a k() {
            int i5 = C1331c.f23941b;
            int i6 = C1331c.f23940a;
            PendingIntent pendingIntent = this.f9532g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z5 = this.f9535j;
            return j(z5 ? i5 : i6, z5 ? C1333e.f23985b : C1333e.f23984a, this.f9536k, C1330b.f23938a, pendingIntent);
        }

        private a l() {
            int i5 = C1331c.f23942c;
            PendingIntent pendingIntent = this.f9533h;
            return pendingIntent == null ? j(i5, C1333e.f23987d, this.f9537l, C1330b.f23939b, this.f9534i) : j(i5, C1333e.f23986c, this.f9537l, C1330b.f23939b, pendingIntent);
        }

        @Override // androidx.core.app.j.f
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f9530e);
            bundle.putBoolean("android.callIsVideo", this.f9535j);
            p pVar = this.f9531f;
            if (pVar != null) {
                bundle.putParcelable("android.callPerson", b.b(pVar.g()));
            }
            IconCompat iconCompat = this.f9538m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", a.a(iconCompat.o(this.f9540a.f9504a)));
            }
            bundle.putCharSequence("android.verificationText", this.f9539n);
            bundle.putParcelable("android.answerIntent", this.f9532g);
            bundle.putParcelable("android.declineIntent", this.f9533h);
            bundle.putParcelable("android.hangUpIntent", this.f9534i);
            Integer num = this.f9536k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f9537l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            Notification.CallStyle callStyleA;
            int i5 = this.f9530e;
            if (i5 == 1) {
                callStyleA = c.a(this.f9531f.g(), this.f9533h, this.f9532g);
            } else if (i5 == 2) {
                callStyleA = c.b(this.f9531f.g(), this.f9534i);
            } else if (i5 != 3) {
                if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f9530e));
                }
                callStyleA = null;
            } else {
                callStyleA = c.c(this.f9531f.g(), this.f9534i, this.f9532g);
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(iVar.a());
                Integer num = this.f9536k;
                if (num != null) {
                    c.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f9537l;
                if (num2 != null) {
                    c.f(callStyleA, num2.intValue());
                }
                c.i(callStyleA, this.f9539n);
                IconCompat iconCompat = this.f9538m;
                if (iconCompat != null) {
                    c.h(callStyleA, iconCompat.o(this.f9540a.f9504a));
                }
                c.g(callStyleA, this.f9535j);
            }
        }

        @Override // androidx.core.app.j.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList<a> h() {
            a aVarL = l();
            a aVarK = k();
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(aVarL);
            ArrayList<a> arrayList2 = this.f9540a.f9505b;
            int i5 = 2;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                int i6 = 0;
                while (i6 < size) {
                    a aVar = arrayList2.get(i6);
                    i6++;
                    a aVar2 = aVar;
                    if (aVar2.j()) {
                        arrayList.add(aVar2);
                    } else if (!i(aVar2) && i5 > 1) {
                        arrayList.add(aVar2);
                        i5--;
                    }
                    if (aVarK != null && i5 == 1) {
                        arrayList.add(aVarK);
                        i5--;
                    }
                }
            }
            if (aVarK != null && i5 >= 1) {
                arrayList.add(aVarK);
            }
            return arrayList;
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected d f9540a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f9541b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f9542c;

        /* renamed from: d, reason: collision with root package name */
        boolean f9543d = false;

        public void a(Bundle bundle) {
            if (this.f9543d) {
                bundle.putCharSequence("android.summaryText", this.f9542c);
            }
            CharSequence charSequence = this.f9541b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(i iVar);

        protected abstract String c();

        public RemoteViews d(i iVar) {
            return null;
        }

        public RemoteViews e(i iVar) {
            return null;
        }

        public RemoteViews f(i iVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f9540a != dVar) {
                this.f9540a = dVar;
                if (dVar != null) {
                    dVar.p(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}

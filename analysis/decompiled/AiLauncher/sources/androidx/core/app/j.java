package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R$color;
import androidx.core.R$drawable;
import androidx.core.R$string;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class j {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f12944a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f12945b;

        /* renamed from: c, reason: collision with root package name */
        public final r[] f12946c;

        /* renamed from: d, reason: collision with root package name */
        public final r[] f12947d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12948e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f12949f;

        /* renamed from: g, reason: collision with root package name */
        public final int f12950g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f12951h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f12952i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f12953j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f12954k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f12955l;

        /* renamed from: androidx.core.app.j$a$a, reason: collision with other inner class name */
        public static final class C0156a {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f12956a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f12957b;

            /* renamed from: c, reason: collision with root package name */
            public final PendingIntent f12958c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f12959d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f12960e;

            /* renamed from: f, reason: collision with root package name */
            public ArrayList<r> f12961f;

            /* renamed from: g, reason: collision with root package name */
            public int f12962g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f12963h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f12964i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f12965j;

            public C0156a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<r> arrayList3 = this.f12961f;
                if (arrayList3 != null) {
                    Iterator<r> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        r next = it.next();
                        if (next.j()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                return new a(this.f12956a, this.f12957b, this.f12958c, this.f12960e, arrayList2.isEmpty() ? null : (r[]) arrayList2.toArray(new r[arrayList2.size()]), arrayList.isEmpty() ? null : (r[]) arrayList.toArray(new r[arrayList.size()]), this.f12959d, this.f12962g, this.f12963h, this.f12964i, this.f12965j);
            }

            public final void b() {
                if (this.f12964i && this.f12958c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0156a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, r[] rVarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f12959d = true;
                this.f12963h = true;
                this.f12956a = iconCompat;
                this.f12957b = d.d(charSequence);
                this.f12958c = pendingIntent;
                this.f12960e = bundle;
                this.f12961f = rVarArr == null ? null : new ArrayList<>(Arrays.asList(rVarArr));
                this.f12959d = z10;
                this.f12962g = i10;
                this.f12963h = z11;
                this.f12964i = z12;
                this.f12965j = z13;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.c(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f12954k;
        }

        public boolean b() {
            return this.f12948e;
        }

        public Bundle c() {
            return this.f12944a;
        }

        public IconCompat d() {
            int i10;
            if (this.f12945b == null && (i10 = this.f12952i) != 0) {
                this.f12945b = IconCompat.c(null, "", i10);
            }
            return this.f12945b;
        }

        public r[] e() {
            return this.f12946c;
        }

        public int f() {
            return this.f12950g;
        }

        public boolean g() {
            return this.f12949f;
        }

        public CharSequence h() {
            return this.f12953j;
        }

        public boolean i() {
            return this.f12955l;
        }

        public boolean j() {
            return this.f12951h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, r[] rVarArr, r[] rVarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f12949f = true;
            this.f12945b = iconCompat;
            if (iconCompat != null && iconCompat.f() == 2) {
                this.f12952i = iconCompat.d();
            }
            this.f12953j = d.d(charSequence);
            this.f12954k = pendingIntent;
            this.f12944a = bundle == null ? new Bundle() : bundle;
            this.f12946c = rVarArr;
            this.f12947d = rVarArr2;
            this.f12948e = z10;
            this.f12950g = i10;
            this.f12949f = z11;
            this.f12951h = z12;
            this.f12955l = z13;
        }
    }

    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f12966e;

        @Override // androidx.core.app.j.f
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(iVar.a()).setBigContentTitle(this.f13026b).bigText(this.f12966e);
            if (this.f13028d) {
                bigTextStyleBigText.setSummaryText(this.f13027c);
            }
        }

        @Override // androidx.core.app.j.f
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f12966e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static class e extends f {

        /* renamed from: e, reason: collision with root package name */
        public int f13015e;

        /* renamed from: f, reason: collision with root package name */
        public p f13016f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f13017g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f13018h;

        /* renamed from: i, reason: collision with root package name */
        public PendingIntent f13019i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13020j;

        /* renamed from: k, reason: collision with root package name */
        public Integer f13021k;

        /* renamed from: l, reason: collision with root package name */
        public Integer f13022l;

        /* renamed from: m, reason: collision with root package name */
        public IconCompat f13023m;

        /* renamed from: n, reason: collision with root package name */
        public CharSequence f13024n;

        public static class a {
            public static Parcelable a(Icon icon) {
                return icon;
            }
        }

        public static class b {
            public static Parcelable a(Person person) {
                return person;
            }
        }

        public static class c {
            public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i10) {
                return callStyle.setAnswerButtonColorHint(i10);
            }

            public static Notification.CallStyle e(Notification.CallStyle callStyle, int i10) {
                return callStyle.setDeclineButtonColorHint(i10);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z10) {
                return callStyle.setIsVideo(z10);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // androidx.core.app.j.f
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f13015e);
            bundle.putBoolean("android.callIsVideo", this.f13020j);
            p pVar = this.f13016f;
            if (pVar != null) {
                bundle.putParcelable("android.callPerson", b.a(pVar.g()));
            }
            IconCompat iconCompat = this.f13023m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", a.a(iconCompat.k(this.f13025a.f12989a)));
            }
            bundle.putCharSequence("android.verificationText", this.f13024n);
            bundle.putParcelable("android.answerIntent", this.f13017g);
            bundle.putParcelable("android.declineIntent", this.f13018h);
            bundle.putParcelable("android.hangUpIntent", this.f13019i);
            Integer num = this.f13021k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f13022l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            Notification.CallStyle callStyleA;
            int i10 = this.f13015e;
            if (i10 == 1) {
                callStyleA = c.a(this.f13016f.g(), this.f13018h, this.f13017g);
            } else if (i10 == 2) {
                callStyleA = c.b(this.f13016f.g(), this.f13019i);
            } else if (i10 != 3) {
                if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f13015e));
                }
                callStyleA = null;
            } else {
                callStyleA = c.c(this.f13016f.g(), this.f13019i, this.f13017g);
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(iVar.a());
                Integer num = this.f13021k;
                if (num != null) {
                    c.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f13022l;
                if (num2 != null) {
                    c.e(callStyleA, num2.intValue());
                }
                c.h(callStyleA, this.f13024n);
                IconCompat iconCompat = this.f13023m;
                if (iconCompat != null) {
                    c.g(callStyleA, iconCompat.k(this.f13025a.f12989a));
                }
                c.f(callStyleA, this.f13020j);
            }
        }

        @Override // androidx.core.app.j.f
        public String c() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList<a> h() {
            a aVarL = l();
            a aVarK = k();
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(aVarL);
            ArrayList<a> arrayList2 = this.f13025a.f12990b;
            int i10 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!i(aVar)) {
                        arrayList.add(aVar);
                        i10--;
                    }
                    if (aVarK != null && i10 == 1) {
                        arrayList.add(aVarK);
                        i10--;
                    }
                }
            }
            if (aVarK != null && i10 >= 1) {
                arrayList.add(aVarK);
            }
            return arrayList;
        }

        public final boolean i(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a j(int i10, int i11, Integer num, int i12, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(androidx.core.content.a.c(this.f13025a.f12989a, i12));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f13025a.f12989a.getResources().getString(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarA = new a.C0156a(IconCompat.b(this.f13025a.f12989a, i10), spannableStringBuilder, pendingIntent).a();
            aVarA.c().putBoolean("key_action_priority", true);
            return aVarA;
        }

        public final a k() {
            int i10 = R$drawable.ic_call_answer_video;
            int i11 = R$drawable.ic_call_answer;
            PendingIntent pendingIntent = this.f13017g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z10 = this.f13020j;
            return j(z10 ? i10 : i11, z10 ? R$string.call_notification_answer_video_action : R$string.call_notification_answer_action, this.f13021k, R$color.call_notification_answer_color, pendingIntent);
        }

        public final a l() {
            int i10 = R$drawable.ic_call_decline;
            PendingIntent pendingIntent = this.f13018h;
            return pendingIntent == null ? j(i10, R$string.call_notification_hang_up_action, this.f13022l, R$color.call_notification_decline_color, this.f13019i) : j(i10, R$string.call_notification_decline_action, this.f13022l, R$color.call_notification_decline_color, pendingIntent);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public d f13025a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f13026b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f13027c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13028d = false;

        public void a(Bundle bundle) {
            if (this.f13028d) {
                bundle.putCharSequence("android.summaryText", this.f13027c);
            }
            CharSequence charSequence = this.f13026b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(i iVar);

        public abstract String c();

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
            if (this.f13025a != dVar) {
                this.f13025a = dVar;
                if (dVar != null) {
                    dVar.q(this);
                }
            }
        }
    }

    @Deprecated
    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        return bitmap;
    }

    public static class d {

        /* renamed from: A, reason: collision with root package name */
        public boolean f12967A;

        /* renamed from: B, reason: collision with root package name */
        public boolean f12968B;

        /* renamed from: C, reason: collision with root package name */
        public boolean f12969C;

        /* renamed from: D, reason: collision with root package name */
        public String f12970D;

        /* renamed from: E, reason: collision with root package name */
        public Bundle f12971E;

        /* renamed from: F, reason: collision with root package name */
        public int f12972F;

        /* renamed from: G, reason: collision with root package name */
        public int f12973G;

        /* renamed from: H, reason: collision with root package name */
        public Notification f12974H;

        /* renamed from: I, reason: collision with root package name */
        public RemoteViews f12975I;

        /* renamed from: J, reason: collision with root package name */
        public RemoteViews f12976J;

        /* renamed from: K, reason: collision with root package name */
        public RemoteViews f12977K;

        /* renamed from: L, reason: collision with root package name */
        public String f12978L;

        /* renamed from: M, reason: collision with root package name */
        public int f12979M;

        /* renamed from: N, reason: collision with root package name */
        public String f12980N;

        /* renamed from: O, reason: collision with root package name */
        public long f12981O;

        /* renamed from: P, reason: collision with root package name */
        public int f12982P;

        /* renamed from: Q, reason: collision with root package name */
        public int f12983Q;

        /* renamed from: R, reason: collision with root package name */
        public boolean f12984R;

        /* renamed from: S, reason: collision with root package name */
        public Notification f12985S;

        /* renamed from: T, reason: collision with root package name */
        public boolean f12986T;

        /* renamed from: U, reason: collision with root package name */
        public Object f12987U;

        /* renamed from: V, reason: collision with root package name */
        @Deprecated
        public ArrayList<String> f12988V;

        /* renamed from: a, reason: collision with root package name */
        public Context f12989a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f12990b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<p> f12991c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<a> f12992d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f12993e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f12994f;

        /* renamed from: g, reason: collision with root package name */
        public String f12995g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f12996h;

        /* renamed from: i, reason: collision with root package name */
        public PendingIntent f12997i;

        /* renamed from: j, reason: collision with root package name */
        public RemoteViews f12998j;

        /* renamed from: k, reason: collision with root package name */
        public IconCompat f12999k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f13000l;

        /* renamed from: m, reason: collision with root package name */
        public int f13001m;

        /* renamed from: n, reason: collision with root package name */
        public int f13002n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f13003o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f13004p;

        /* renamed from: q, reason: collision with root package name */
        public f f13005q;

        /* renamed from: r, reason: collision with root package name */
        public CharSequence f13006r;

        /* renamed from: s, reason: collision with root package name */
        public CharSequence f13007s;

        /* renamed from: t, reason: collision with root package name */
        public CharSequence[] f13008t;

        /* renamed from: u, reason: collision with root package name */
        public int f13009u;

        /* renamed from: v, reason: collision with root package name */
        public int f13010v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f13011w;

        /* renamed from: x, reason: collision with root package name */
        public String f13012x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f13013y;

        /* renamed from: z, reason: collision with root package name */
        public String f13014z;

        public d(Context context, String str) {
            this.f12990b = new ArrayList<>();
            this.f12991c = new ArrayList<>();
            this.f12992d = new ArrayList<>();
            this.f13003o = true;
            this.f12967A = false;
            this.f12972F = 0;
            this.f12973G = 0;
            this.f12979M = 0;
            this.f12982P = 0;
            this.f12983Q = 0;
            Notification notification = new Notification();
            this.f12985S = notification;
            this.f12989a = context;
            this.f12978L = str;
            notification.when = System.currentTimeMillis();
            this.f12985S.audioStreamType = -1;
            this.f13002n = 0;
            this.f12988V = new ArrayList<>();
            this.f12984R = true;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public d a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f12990b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new k(this).c();
        }

        public Bundle c() {
            if (this.f12971E == null) {
                this.f12971E = new Bundle();
            }
            return this.f12971E;
        }

        public d e(boolean z10) {
            l(16, z10);
            return this;
        }

        public d f(String str) {
            this.f12970D = str;
            return this;
        }

        public d g(String str) {
            this.f12978L = str;
            return this;
        }

        public d h(PendingIntent pendingIntent) {
            this.f12996h = pendingIntent;
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f12994f = d(charSequence);
            return this;
        }

        public d j(CharSequence charSequence) {
            this.f12993e = d(charSequence);
            return this;
        }

        public d k(int i10) {
            Notification notification = this.f12985S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public final void l(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.f12985S;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.f12985S;
                notification2.flags = (~i10) & notification2.flags;
            }
        }

        public d m(Bitmap bitmap) {
            this.f12999k = bitmap == null ? null : IconCompat.a(j.b(this.f12989a, bitmap));
            return this;
        }

        public d n(boolean z10) {
            this.f12967A = z10;
            return this;
        }

        public d o(int i10) {
            this.f13002n = i10;
            return this;
        }

        public d p(int i10) {
            this.f12985S.icon = i10;
            return this;
        }

        public d q(f fVar) {
            if (this.f13005q != fVar) {
                this.f13005q = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public d r(CharSequence charSequence) {
            this.f12985S.tickerText = d(charSequence);
            return this;
        }

        public d s(long j10) {
            this.f12985S.when = j10;
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, null);
        }
    }
}

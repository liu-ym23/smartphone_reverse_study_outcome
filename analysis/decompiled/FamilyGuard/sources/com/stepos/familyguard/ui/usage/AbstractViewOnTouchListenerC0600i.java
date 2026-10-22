package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0538s;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i;
import com.stepos.familyguard.ui.widget.ProgressBar;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import f2.C0702g;
import f2.C0711p;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.libpag.BuildConfig;
import w2.AbstractC1231i0;
import w2.C1216d;
import w2.C1257w;
import w2.InterfaceC1258w0;
import w2.InterfaceC1262y0;

/* renamed from: com.stepos.familyguard.ui.usage.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0600i extends RecyclerView.Adapter implements D2.t, View.OnTouchListener, InterfaceC0538s {

    /* renamed from: J, reason: collision with root package name */
    private int f15065J;

    /* renamed from: K, reason: collision with root package name */
    private int f15066K;

    /* renamed from: L, reason: collision with root package name */
    private int f15067L;

    /* renamed from: Q, reason: collision with root package name */
    private k f15069Q;

    /* renamed from: R, reason: collision with root package name */
    private InterfaceC1262y0 f15070R;

    /* renamed from: S, reason: collision with root package name */
    private InterfaceC1258w0 f15071S;

    /* renamed from: T, reason: collision with root package name */
    protected D2.i f15072T;

    /* renamed from: a, reason: collision with root package name */
    private final Context f15073a;

    /* renamed from: b, reason: collision with root package name */
    protected D2.r f15074b;

    /* renamed from: c, reason: collision with root package name */
    protected D2.r f15075c;

    /* renamed from: d, reason: collision with root package name */
    private D2.k f15076d;

    /* renamed from: e, reason: collision with root package name */
    private PackageNotificationTimesStats[] f15077e;

    /* renamed from: f, reason: collision with root package name */
    private long f15078f;

    /* renamed from: g, reason: collision with root package name */
    private long f15079g;

    /* renamed from: h, reason: collision with root package name */
    private long f15080h;

    /* renamed from: i, reason: collision with root package name */
    private String f15081i;

    /* renamed from: j, reason: collision with root package name */
    private long f15082j;

    /* renamed from: k, reason: collision with root package name */
    private UsingTimeStats[] f15083k;

    /* renamed from: l, reason: collision with root package name */
    private NotificationTimesStats[] f15084l;

    /* renamed from: m, reason: collision with root package name */
    private PickupTimesStats[] f15085m;

    /* renamed from: n, reason: collision with root package name */
    private List<C1216d> f15086n;

    /* renamed from: o, reason: collision with root package name */
    private List<C1257w> f15087o;

    /* renamed from: p, reason: collision with root package name */
    private int f15088p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f15089q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f15090r = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f15091s = -1;

    /* renamed from: t, reason: collision with root package name */
    private int f15092t = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f15093u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f15094v = -1;

    /* renamed from: w, reason: collision with root package name */
    private int f15095w = -1;

    /* renamed from: x, reason: collision with root package name */
    private int f15096x = -1;

    /* renamed from: y, reason: collision with root package name */
    private int f15097y = -1;

    /* renamed from: z, reason: collision with root package name */
    private int f15098z = -1;

    /* renamed from: A, reason: collision with root package name */
    private int f15056A = -1;

    /* renamed from: B, reason: collision with root package name */
    private int f15057B = -1;

    /* renamed from: C, reason: collision with root package name */
    private int f15058C = -1;

    /* renamed from: D, reason: collision with root package name */
    private int f15059D = -1;

    /* renamed from: E, reason: collision with root package name */
    private int f15060E = -1;

    /* renamed from: F, reason: collision with root package name */
    private int f15061F = -1;

    /* renamed from: G, reason: collision with root package name */
    private int f15062G = -1;

    /* renamed from: H, reason: collision with root package name */
    private int f15063H = -1;

    /* renamed from: I, reason: collision with root package name */
    private int f15064I = 0;

    /* renamed from: M, reason: collision with root package name */
    private int f15068M = 0;

    /* renamed from: com.stepos.familyguard.ui.usage.i$a */
    public static class a implements Comparator<C1216d> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15099a;

        public a(Context context) {
            this.f15099a = context;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1216d c1216d, C1216d c1216d2) {
            PackageUsingTimeStats packageUsingTimeStatsA = c1216d.A();
            PackageUsingTimeStats packageUsingTimeStatsA2 = c1216d2.A();
            long usingTime = packageUsingTimeStatsA == null ? 0L : packageUsingTimeStatsA.getUsingTime();
            long usingTime2 = packageUsingTimeStatsA2 != null ? packageUsingTimeStatsA2.getUsingTime() : 0L;
            if (usingTime != usingTime2) {
                return (int) (usingTime2 - usingTime);
            }
            PackageLimitInfo packageLimitInfoC = c1216d.c();
            PackageLimitInfo packageLimitInfoC2 = c1216d2.c();
            PeriodLimitInfo periodLimitInfoB = c1216d.B();
            PeriodLimitInfo periodLimitInfoB2 = c1216d2.B();
            int i5 = 0;
            int i6 = (packageLimitInfoC == null || packageLimitInfoC.getCurrentLimit(this.f15099a) == -1 || !packageLimitInfoC.isEnable()) ? 0 : 1;
            if (packageLimitInfoC2 != null && packageLimitInfoC2.getCurrentLimit(this.f15099a) != -1 && packageLimitInfoC2.isEnable()) {
                i5 = 1;
            }
            if (periodLimitInfoB != null && periodLimitInfoB.isEnable()) {
                i6 = 1;
            }
            if (periodLimitInfoB2 != null && periodLimitInfoB2.isEnable()) {
                i5 = 1;
            }
            if (i6 != i5) {
                return i5 - i6;
            }
            String strE = TextUtils.isEmpty(c1216d.a()) ? null : Z0.b.e(c1216d.a(), BuildConfig.FLAVOR);
            String strE2 = TextUtils.isEmpty(c1216d2.a()) ? null : Z0.b.e(c1216d2.a(), BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(strE)) {
                R1.a.a("BSA", "o1 = " + c1216d);
                return 1;
            }
            if (!TextUtils.isEmpty(strE2)) {
                return strE.compareTo(strE2);
            }
            R1.a.a("BSA", "o1 = " + c1216d2);
            return -1;
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$b */
    public static class b implements Comparator<C1257w> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15100a;

        public b(Context context) {
            this.f15100a = context;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1257w c1257w, C1257w c1257w2) {
            CategoryUsingTimeStats categoryUsingTimeStatsF = c1257w.f();
            CategoryUsingTimeStats categoryUsingTimeStatsF2 = c1257w2.f();
            long usingTime = categoryUsingTimeStatsF == null ? 0L : categoryUsingTimeStatsF.getUsingTime();
            long usingTime2 = categoryUsingTimeStatsF2 != null ? categoryUsingTimeStatsF2.getUsingTime() : 0L;
            if (usingTime != usingTime2) {
                return (int) (usingTime2 - usingTime);
            }
            CategoryLimitInfo categoryLimitInfoC = c1257w.c();
            CategoryLimitInfo categoryLimitInfoC2 = c1257w2.c();
            PeriodLimitInfo periodLimitInfoA = c1257w.A();
            PeriodLimitInfo periodLimitInfoA2 = c1257w2.A();
            int i5 = 0;
            int i6 = (categoryLimitInfoC == null || categoryLimitInfoC.getCurrentLimit(this.f15100a) == -1 || !categoryLimitInfoC.isEnable()) ? 0 : 1;
            if (categoryLimitInfoC2 != null && categoryLimitInfoC2.getCurrentLimit(this.f15100a) != -1 && categoryLimitInfoC2.isEnable()) {
                i5 = 1;
            }
            if (periodLimitInfoA != null && periodLimitInfoA.isEnable()) {
                i6 = 1;
            }
            if (periodLimitInfoA2 != null && periodLimitInfoA2.isEnable()) {
                i5 = 1;
            }
            if (i6 != i5) {
                return i5 - i6;
            }
            String string = this.f15100a.getString(W1.c.m(c1257w.a()));
            String string2 = this.f15100a.getString(W1.c.m(c1257w2.a()));
            String strE = TextUtils.isEmpty(string) ? null : Z0.b.e(string, BuildConfig.FLAVOR);
            String strE2 = TextUtils.isEmpty(string2) ? null : Z0.b.e(string2, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(strE)) {
                R1.a.a("BSA", "o1 = " + c1257w);
                return 1;
            }
            if (!TextUtils.isEmpty(strE2)) {
                return strE.compareTo(strE2);
            }
            R1.a.a("BSA", "o2 = " + c1257w2);
            return -1;
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$c */
    class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        ImageView f15101a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f15102b;

        /* renamed from: c, reason: collision with root package name */
        TextView f15103c;

        /* renamed from: d, reason: collision with root package name */
        TextView f15104d;

        /* renamed from: e, reason: collision with root package name */
        ProgressBar f15105e;

        /* renamed from: f, reason: collision with root package name */
        TextView f15106f;

        /* renamed from: g, reason: collision with root package name */
        View f15107g;

        c(View view) {
            super(view);
            this.f15101a = (ImageView) view.findViewById(R.id.icon);
            ImageView imageView = (ImageView) view.findViewById(R.id.mask);
            this.f15102b = imageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.f15103c = (TextView) view.findViewById(R.id.app_name);
            this.f15105e = (ProgressBar) view.findViewById(R.id.progress);
            this.f15104d = (TextView) view.findViewById(R.id.des);
            this.f15106f = (TextView) view.findViewById(R.id.limit);
            this.f15107g = view.findViewById(R.id.space);
        }

        public static /* synthetic */ boolean b(View view) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(CategoryUsingTimeStats categoryUsingTimeStats, int i5, View view) {
            if (AbstractViewOnTouchListenerC0600i.this.f15071S != null) {
                AbstractViewOnTouchListenerC0600i.this.f15071S.e(categoryUsingTimeStats.getCategoryId(), AbstractViewOnTouchListenerC0600i.this.f15073a.getString(i5));
            }
        }

        void d(C1257w c1257w) {
            final CategoryUsingTimeStats categoryUsingTimeStatsF;
            if (c1257w == null || (categoryUsingTimeStatsF = c1257w.f()) == null) {
                return;
            }
            int categoryId = categoryUsingTimeStatsF.getCategoryId();
            this.f15101a.setImageResource(W1.c.l(categoryId));
            final int iM = W1.c.m(categoryId);
            this.f15103c.setText(iM);
            this.f15103c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.familyguard.ui.usage.j
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return AbstractViewOnTouchListenerC0600i.c.b(view);
                }
            });
            long usingTime = categoryUsingTimeStatsF.getUsingTime();
            this.f15105e.setMax(C0711p.l(AbstractViewOnTouchListenerC0600i.this.f15080h));
            this.f15105e.setValue(C0711p.l(usingTime));
            this.f15105e.setMinLength((int) N1.i.a(1.0f, AbstractViewOnTouchListenerC0600i.this.f15073a));
            TextView textView = this.f15104d;
            textView.setText(C0711p.m(textView.getContext(), categoryUsingTimeStatsF.getUsingTime()));
            CategoryLimitInfo categoryLimitInfoC = c1257w.c();
            PeriodLimitInfo periodLimitInfoA = c1257w.A();
            String string = (periodLimitInfoA == null || !periodLimitInfoA.isEnable()) ? ((categoryLimitInfoC != null ? categoryLimitInfoC.getCurrentLimit(AbstractViewOnTouchListenerC0600i.this.f15073a) : -1L) == 0 && categoryLimitInfoC != null && categoryLimitInfoC.isEnable()) ? AbstractViewOnTouchListenerC0600i.this.f15073a.getResources().getStringArray(R.array.us_package_limit_time_array)[0] : (categoryLimitInfoC == null || !categoryLimitInfoC.isEnable()) ? null : AbstractViewOnTouchListenerC0600i.this.f15073a.getString(R.string.us_limited) : AbstractViewOnTouchListenerC0600i.this.f15073a.getString(R.string.us_limited);
            this.f15106f.setText(string);
            if (TextUtils.isEmpty(string)) {
                this.f15106f.setVisibility(8);
                this.f15107g.setVisibility(0);
            } else {
                this.f15106f.setVisibility(0);
                this.f15107g.setVisibility(8);
            }
            if (AbstractViewOnTouchListenerC0600i.this.u0() || (AbstractViewOnTouchListenerC0600i.this instanceof AbstractC1231i0)) {
                this.itemView.setClickable(true);
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.familyguard.ui.usage.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f15142a.c(categoryUsingTimeStatsF, iM, view);
                    }
                });
            } else {
                this.itemView.setClickable(false);
                this.itemView.setOnClickListener(null);
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$d */
    class d extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f15109a;

        d(View view) {
            super(view);
            this.f15109a = (TextView) view.findViewById(R.id.main_title);
        }

        void a(int i5) {
            this.f15109a.setText(i5);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$e */
    class e extends RecyclerView.ViewHolder {
        e(View view) {
            super(view);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$f */
    static class f implements D2.z<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        ImageView f15112a;

        f() {
        }

        @Override // D2.z
        public void b() {
            this.f15112a.setImageResource(R.drawable.us_ic_default_app);
        }

        @Override // D2.z
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable) {
            if (drawable == null) {
                this.f15112a.setImageResource(R.drawable.us_ic_default_app);
            } else {
                this.f15112a.setImageDrawable(drawable);
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$g */
    class g extends RecyclerView.ViewHolder {
        g(View view) {
            super(view);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$h */
    class h implements D2.z<String> {

        /* renamed from: a, reason: collision with root package name */
        TextView f15114a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.ViewHolder f15115b;

        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, View view) {
            if (AbstractViewOnTouchListenerC0600i.this.f15070R != null) {
                AbstractViewOnTouchListenerC0600i.this.f15070R.i(((n) this.f15115b).f15138g, str);
            }
        }

        @Override // D2.z
        public void b() {
            this.f15114a.setText(R.string.fg_ui_loading);
        }

        @Override // D2.z
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(final String str) {
            this.f15114a.setText(str);
            if (this.f15115b instanceof n) {
                if (AbstractViewOnTouchListenerC0600i.this.u0() || (AbstractViewOnTouchListenerC0600i.this instanceof AbstractC1231i0)) {
                    this.f15115b.itemView.setClickable(true);
                    this.f15115b.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.familyguard.ui.usage.l
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f15145a.d(str, view);
                        }
                    });
                } else {
                    this.f15115b.itemView.setClickable(false);
                    this.f15115b.itemView.setOnClickListener(null);
                }
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$i, reason: collision with other inner class name */
    class C0185i implements D2.z<D2.s> {

        /* renamed from: a, reason: collision with root package name */
        TextView f15117a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.ViewHolder f15118b;

        C0185i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(D2.s sVar, View view) {
            C2.m.a(AbstractViewOnTouchListenerC0600i.this.f15073a, ((j) this.f15118b).f15125f, sVar.f1197b, sVar.f1196a);
        }

        @Override // D2.z
        public void b() {
            this.f15117a.setText(R.string.fg_ui_loading);
        }

        @Override // D2.z
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(final D2.s sVar) {
            this.f15117a.setText(sVar.f1196a);
            RecyclerView.ViewHolder viewHolder = this.f15118b;
            if (viewHolder instanceof j) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.familyguard.ui.usage.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f15147a.d(sVar, view);
                    }
                });
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$j */
    class j extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        ImageView f15120a;

        /* renamed from: b, reason: collision with root package name */
        TextView f15121b;

        /* renamed from: c, reason: collision with root package name */
        TextView f15122c;

        /* renamed from: d, reason: collision with root package name */
        ProgressBar f15123d;

        /* renamed from: e, reason: collision with root package name */
        f f15124e;

        /* renamed from: f, reason: collision with root package name */
        String f15125f;

        /* renamed from: g, reason: collision with root package name */
        C0185i f15126g;

        j(View view) {
            super(view);
            this.f15120a = (ImageView) view.findViewById(R.id.icon);
            this.f15121b = (TextView) view.findViewById(R.id.app_name);
            this.f15123d = (ProgressBar) view.findViewById(R.id.progress);
            this.f15122c = (TextView) view.findViewById(R.id.des);
        }

        void a(PackageNotificationTimesStats packageNotificationTimesStats) {
            if (this.f15124e == null) {
                this.f15124e = new f();
            }
            if (this.f15126g == null) {
                this.f15126g = AbstractViewOnTouchListenerC0600i.this.new C0185i();
            }
            this.f15124e.f15112a = this.f15120a;
            C0185i c0185i = this.f15126g;
            c0185i.f15117a = this.f15121b;
            c0185i.f15118b = this;
            if (packageNotificationTimesStats != null) {
                l lVar = new l();
                String packageName = packageNotificationTimesStats.getPackageName();
                lVar.f15128a = packageName;
                this.f15125f = packageName;
                D2.r rVar = AbstractViewOnTouchListenerC0600i.this.f15074b;
                if (rVar != null) {
                    rVar.d(lVar, this.f15124e);
                }
                D2.r rVar2 = AbstractViewOnTouchListenerC0600i.this.f15075c;
                if (rVar2 != null) {
                    rVar2.d(lVar, this.f15126g);
                }
                long notificationTimes = packageNotificationTimesStats.getNotificationTimes();
                this.f15123d.setMax(AbstractViewOnTouchListenerC0600i.this.f15079g);
                this.f15123d.setValue(notificationTimes);
                ProgressBar progressBar = this.f15123d;
                progressBar.setMinLength(progressBar.getResources().getDimensionPixelSize(R.dimen.us_app_item_progressbar_min_length));
                this.f15122c.setText(AbstractViewOnTouchListenerC0600i.this.f15073a.getString(R.string.us_times_t, Long.valueOf(notificationTimes)));
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$k */
    public interface k {
        void b(int i5);
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$l */
    static class l implements D2.v<String> {

        /* renamed from: a, reason: collision with root package name */
        String f15128a;

        l() {
        }

        @Override // D2.v
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return this.f15128a;
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$m */
    class m extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f15129a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f15130b;

        m(View view) {
            super(view);
            this.f15129a = (TextView) view.findViewById(R.id.main_title);
            this.f15130b = (TextView) view.findViewById(R.id.sub_title);
        }

        void a(int i5) {
            this.f15129a.setText(i5);
        }

        void b(String str) {
            this.f15130b.setText(str);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.i$n */
    class n extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        ImageView f15132a;

        /* renamed from: b, reason: collision with root package name */
        TextView f15133b;

        /* renamed from: c, reason: collision with root package name */
        TextView f15134c;

        /* renamed from: d, reason: collision with root package name */
        TextView f15135d;

        /* renamed from: e, reason: collision with root package name */
        ProgressBar f15136e;

        /* renamed from: f, reason: collision with root package name */
        f f15137f;

        /* renamed from: g, reason: collision with root package name */
        String f15138g;

        /* renamed from: h, reason: collision with root package name */
        h f15139h;

        /* renamed from: i, reason: collision with root package name */
        View f15140i;

        n(View view) {
            super(view);
            this.f15132a = (ImageView) view.findViewById(R.id.icon);
            this.f15133b = (TextView) view.findViewById(R.id.app_name);
            this.f15136e = (ProgressBar) view.findViewById(R.id.progress);
            this.f15134c = (TextView) view.findViewById(R.id.des);
            this.f15135d = (TextView) view.findViewById(R.id.limit);
            this.f15140i = view.findViewById(R.id.space);
        }

        public static /* synthetic */ boolean a(View view) {
            return true;
        }

        void b(C1216d c1216d) {
            if (this.f15137f == null) {
                this.f15137f = new f();
            }
            if (this.f15139h == null) {
                this.f15139h = AbstractViewOnTouchListenerC0600i.this.new h();
            }
            this.f15133b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.familyguard.ui.usage.n
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return AbstractViewOnTouchListenerC0600i.n.a(view);
                }
            });
            this.f15137f.f15112a = this.f15132a;
            h hVar = this.f15139h;
            hVar.f15114a = this.f15133b;
            hVar.f15115b = this;
            PackageUsingTimeStats packageUsingTimeStatsA = c1216d.A();
            PackageLimitInfo packageLimitInfoC = c1216d.c();
            PeriodLimitInfo periodLimitInfoB = c1216d.B();
            long usingTime = packageUsingTimeStatsA != null ? packageUsingTimeStatsA.getUsingTime() : 0L;
            String string = (periodLimitInfoB == null || !periodLimitInfoB.isEnable()) ? ((packageLimitInfoC != null ? packageLimitInfoC.getCurrentLimit(AbstractViewOnTouchListenerC0600i.this.f15073a) : -1L) == 0 && packageLimitInfoC != null && packageLimitInfoC.isEnable()) ? AbstractViewOnTouchListenerC0600i.this.f15073a.getResources().getStringArray(R.array.us_package_limit_time_array)[0] : (packageLimitInfoC == null || !packageLimitInfoC.isEnable()) ? null : AbstractViewOnTouchListenerC0600i.this.f15073a.getString(R.string.us_limited) : AbstractViewOnTouchListenerC0600i.this.f15073a.getString(R.string.us_limited);
            l lVar = new l();
            String strF = c1216d.f();
            lVar.f15128a = strF;
            this.f15138g = strF;
            D2.r rVar = AbstractViewOnTouchListenerC0600i.this.f15074b;
            if (rVar != null) {
                rVar.d(lVar, this.f15137f);
            }
            D2.r rVar2 = AbstractViewOnTouchListenerC0600i.this.f15075c;
            if (rVar2 != null) {
                rVar2.d(lVar, this.f15139h);
            }
            this.f15136e.setMax(C0711p.l(AbstractViewOnTouchListenerC0600i.this.f15078f));
            this.f15136e.setValue(C0711p.l(usingTime));
            ProgressBar progressBar = this.f15136e;
            progressBar.setMinLength(progressBar.getResources().getDimensionPixelSize(R.dimen.us_app_item_progressbar_min_length));
            this.f15136e.setMinLength((int) N1.i.a(4.0f, AbstractViewOnTouchListenerC0600i.this.f15073a));
            long j5 = usingTime >= 0 ? usingTime : 0L;
            TextView textView = this.f15134c;
            textView.setText(C0711p.m(textView.getContext(), j5));
            this.f15135d.setText(string);
            if (TextUtils.isEmpty(string)) {
                this.f15135d.setVisibility(8);
                this.f15140i.setVisibility(0);
            } else {
                this.f15135d.setVisibility(0);
                this.f15140i.setVisibility(8);
            }
            this.f15135d.setVisibility(TextUtils.isEmpty(string) ? 4 : 0);
        }
    }

    public AbstractViewOnTouchListenerC0600i(Context context) {
        this.f15073a = context;
        Z(context);
    }

    private List<C1216d> J(List<C1216d> list) {
        return list;
    }

    private long K(PackageNotificationTimesStats[] packageNotificationTimesStatsArr) {
        long j5 = 0;
        if (packageNotificationTimesStatsArr != null && packageNotificationTimesStatsArr.length != 0) {
            for (PackageNotificationTimesStats packageNotificationTimesStats : packageNotificationTimesStatsArr) {
                long notificationTimes = packageNotificationTimesStats.getNotificationTimes();
                if (j5 < notificationTimes) {
                    j5 = notificationTimes;
                }
            }
        }
        return j5;
    }

    private long L(List<C1216d> list) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        Iterator<C1216d> it = list.iterator();
        long j5 = 0;
        while (it.hasNext()) {
            PackageUsingTimeStats packageUsingTimeStatsA = it.next().A();
            long usingTime = packageUsingTimeStatsA == null ? 0L : packageUsingTimeStatsA.getUsingTime();
            if (j5 < usingTime) {
                j5 = usingTime;
            }
        }
        return j5;
    }

    private long M(List<C1257w> list) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        Iterator<C1257w> it = list.iterator();
        long j5 = 0;
        while (it.hasNext()) {
            CategoryUsingTimeStats categoryUsingTimeStatsF = it.next().f();
            long usingTime = categoryUsingTimeStatsF == null ? 0L : categoryUsingTimeStatsF.getUsingTime();
            if (j5 < usingTime) {
                j5 = usingTime;
            }
        }
        return j5;
    }

    private boolean Q() {
        return (this.f15068M & 4) == 4;
    }

    private boolean R() {
        return (this.f15068M & 2) == 2;
    }

    private boolean S() {
        return (this.f15068M & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        H(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        H(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        H(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(HistogramView histogramView, boolean z5, int i5, Object obj) {
        t0(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(HistogramView histogramView, boolean z5, int i5, Object obj) {
        s0(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(HistogramView histogramView, boolean z5, int i5, Object obj) {
        m0(z5);
    }

    private void Z(Context context) {
        this.f15072T = new D2.w();
        this.f15075c = new D2.c(null);
        this.f15074b = new D2.b(this.f15072T);
        this.f15076d = new D2.k(null);
        D2.r rVar = this.f15074b;
        if (rVar != null) {
            rVar.f(this);
        }
        D2.r rVar2 = this.f15075c;
        if (rVar2 != null) {
            rVar2.f(this);
        }
        D2.k kVar = this.f15076d;
        if (kVar != null) {
            kVar.f(this);
        }
    }

    private void m0(boolean z5) {
        if (Q() == z5) {
            return;
        }
        if (z5) {
            this.f15068M |= 4;
        } else {
            this.f15068M &= -5;
        }
        k kVar = this.f15069Q;
        if (kVar != null) {
            kVar.b(this.f15068M);
        }
    }

    public static /* synthetic */ int q(PackageNotificationTimesStats packageNotificationTimesStats, PackageNotificationTimesStats packageNotificationTimesStats2) {
        return packageNotificationTimesStats2.getNotificationTimes() - packageNotificationTimesStats.getNotificationTimes();
    }

    private void s0(boolean z5) {
        if (R() == z5) {
            return;
        }
        if (z5) {
            this.f15068M |= 2;
        } else {
            this.f15068M &= -3;
        }
        k kVar = this.f15069Q;
        if (kVar != null) {
            kVar.b(this.f15068M);
        }
    }

    private void t0(boolean z5) {
        if (S() == z5) {
            return;
        }
        if (z5) {
            this.f15068M |= 1;
        } else {
            this.f15068M &= -2;
        }
        k kVar = this.f15069Q;
        if (kVar != null) {
            kVar.b(this.f15068M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        return true;
    }

    protected int B() {
        return C(F(D(E(2))));
    }

    protected int C(int i5) {
        int iN = N(7);
        int iO = O(7);
        boolean zI = I(7);
        this.f15058C = i5;
        this.f15059D = i5 + 1;
        this.f15060E = i5 + 2;
        if (iN <= 0) {
            this.f15061F = -1;
            this.f15062G = -1;
            this.f15063H = -1;
            return i5 + 3;
        }
        int i6 = i5 + 3;
        this.f15061F = i6;
        int i7 = i6 + iO;
        this.f15062G = i7 - 1;
        int i8 = zI ? i7 : -1;
        this.f15063H = i8;
        return zI ? i8 + 1 : i7;
    }

    protected int D(int i5) {
        int iN = N(3);
        int iO = O(3);
        boolean zI = I(3);
        if (iN <= 0) {
            this.f15093u = -1;
            this.f15094v = -1;
            this.f15095w = -1;
            this.f15096x = -1;
            this.f15097y = -1;
            return i5;
        }
        this.f15093u = i5;
        this.f15094v = i5 + 1;
        int i6 = i5 + 2;
        this.f15095w = i6;
        int i7 = i6 + iO;
        this.f15096x = i7 - 1;
        int i8 = zI ? i7 : -1;
        this.f15097y = i8;
        return zI ? i8 + 1 : i7;
    }

    protected int E(int i5) {
        int iN = N(4);
        int iO = O(4);
        boolean zI = I(4);
        if (iN <= 0) {
            this.f15088p = -1;
            this.f15089q = -1;
            this.f15090r = -1;
            this.f15091s = -1;
            this.f15092t = -1;
            return i5;
        }
        this.f15088p = i5;
        this.f15089q = i5 + 1;
        int i6 = i5 + 2;
        this.f15090r = i6;
        int i7 = i6 + iO;
        this.f15091s = i7 - 1;
        int i8 = zI ? i7 : -1;
        this.f15092t = i8;
        return zI ? i8 + 1 : i7;
    }

    protected int F(int i5) {
        this.f15098z = i5;
        this.f15056A = i5 + 1;
        this.f15057B = i5 + 2;
        return i5 + 3;
    }

    RecyclerView.ViewHolder G(ViewGroup viewGroup, int i5) {
        View viewG0 = g0(viewGroup.getContext(), viewGroup, i5);
        if (viewG0 == null) {
            return null;
        }
        switch (i5) {
        }
        return null;
    }

    public void H(int i5) {
        int length;
        int i6 = this.f15097y;
        int i7 = this.f15092t;
        int i8 = this.f15063H;
        if (I(i5)) {
            if (i5 == 3) {
                int size = this.f15086n.size() - this.f15065J <= 10 ? this.f15086n.size() - this.f15065J : 10;
                this.f15065J += size;
                this.f15064I = B();
                notifyItemRangeInserted(i6, size - 1);
                notifyItemChanged(i6);
                return;
            }
            if (i5 == 4) {
                length = this.f15087o.size() - this.f15066K <= Integer.MAX_VALUE ? this.f15087o.size() - this.f15066K : Integer.MAX_VALUE;
                this.f15066K += length;
                this.f15064I = B();
                notifyItemRangeInserted(i7, length - 1);
                notifyItemChanged(i7);
                return;
            }
            if (i5 == 7) {
                PackageNotificationTimesStats[] packageNotificationTimesStatsArr = this.f15077e;
                int length2 = packageNotificationTimesStatsArr.length;
                int i9 = this.f15067L;
                length = length2 - i9 <= Integer.MAX_VALUE ? packageNotificationTimesStatsArr.length - i9 : Integer.MAX_VALUE;
                this.f15067L = i9 + length;
                this.f15064I = B();
                notifyItemRangeInserted(i8, length - 1);
                notifyItemChanged(i8);
            }
        }
    }

    public boolean I(int i5) {
        return O(i5) < N(i5);
    }

    public int N(int i5) {
        PackageNotificationTimesStats[] packageNotificationTimesStatsArr;
        if (i5 == 3) {
            List<C1216d> list = this.f15086n;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        if (i5 == 4) {
            List<C1257w> list2 = this.f15087o;
            if (list2 == null) {
                return 0;
            }
            return list2.size();
        }
        if (i5 != 7 || (packageNotificationTimesStatsArr = this.f15077e) == null) {
            return 0;
        }
        return packageNotificationTimesStatsArr.length;
    }

    public int O(int i5) {
        int i6;
        int i7 = 5;
        if (i5 == 3) {
            i6 = this.f15065J;
        } else if (i5 == 4) {
            i6 = this.f15066K;
            i7 = 3;
        } else {
            if (i5 != 7) {
                return 0;
            }
            i6 = this.f15067L;
        }
        int iN = N(i5);
        if (iN <= 0) {
            return 0;
        }
        return i6 <= 0 ? Math.min(i7, iN) : Math.min(i6, iN);
    }

    protected String P() {
        return this.f15081i;
    }

    protected abstract HistogramView a0(Context context, ViewGroup viewGroup);

    protected abstract RecyclerView.ViewHolder b0(View view);

    protected abstract HistogramView c0(Context context, ViewGroup viewGroup);

    @Override // D2.t
    public boolean d(boolean z5, Object obj, D2.z zVar) {
        if ((zVar instanceof h) && (obj instanceof D2.s)) {
            zVar.a(((D2.s) obj).f1196a);
            return true;
        }
        zVar.a(obj);
        return true;
    }

    protected abstract RecyclerView.ViewHolder d0(View view);

    protected abstract HistogramView e0(Context context, ViewGroup viewGroup);

    protected abstract RecyclerView.ViewHolder f0(View view);

    public View g0(Context context, ViewGroup viewGroup, int i5) {
        if (context == null) {
            return null;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        switch (i5) {
            case 0:
                View viewInflate = layoutInflaterFrom.inflate(R.layout.stepos_list_title_text_and_line_item, viewGroup, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.sub_title);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.main_title);
                textView.setTextAppearance(this.f15073a, R.style.Widget_StepOS_List_Setting_SingleList_Title);
                T1.g.c(1.18f, textView2);
                T1.g.c(1.18f, textView);
                break;
            case 1:
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.stepos_list_title_text_and_line_item, viewGroup, false);
                T1.g.c(1.18f, (TextView) viewInflate2.findViewById(R.id.main_title));
                break;
            case 3:
                View viewInflate3 = context.getResources().getConfiguration().fontScale >= 1.18f ? layoutInflaterFrom.inflate(R.layout.us_app_usage_item_big_font, viewGroup, false) : layoutInflaterFrom.inflate(R.layout.us_app_usage_item, viewGroup, false);
                View viewFindViewById = viewInflate3.findViewById(R.id.arrow);
                if (!u0() && !(this instanceof AbstractC1231i0)) {
                    viewFindViewById.setVisibility(8);
                    break;
                } else {
                    viewFindViewById.setVisibility(0);
                    break;
                }
                break;
            case 4:
                View viewInflate4 = context.getResources().getConfiguration().fontScale >= 1.18f ? layoutInflaterFrom.inflate(R.layout.us_app_usage_item_big_font, viewGroup, false) : layoutInflaterFrom.inflate(R.layout.us_app_usage_item, viewGroup, false);
                View viewFindViewById2 = viewInflate4.findViewById(R.id.arrow);
                if (!u0() && !(this instanceof AbstractC1231i0)) {
                    viewFindViewById2.setVisibility(8);
                    break;
                } else {
                    viewFindViewById2.setVisibility(0);
                    break;
                }
                break;
            case 6:
                HistogramView histogramViewE0 = e0(context, viewGroup);
                if (histogramViewE0 != null) {
                    histogramViewE0.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: w2.j
                        @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
                        public final void a(HistogramView histogramView, boolean z5, int i6, Object obj) {
                            this.f23623a.W(histogramView, z5, i6, obj);
                        }
                    });
                }
                if (histogramViewE0 == null) {
                    break;
                }
                break;
            case 8:
                HistogramView histogramViewA0 = a0(context, viewGroup);
                if (histogramViewA0 != null) {
                    histogramViewA0.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: w2.l
                        @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
                        public final void a(HistogramView histogramView, boolean z5, int i6, Object obj) {
                            this.f23629a.Y(histogramView, z5, i6, obj);
                        }
                    });
                }
                if (histogramViewA0 == null) {
                    break;
                }
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                HistogramView histogramViewC0 = c0(context, viewGroup);
                if (histogramViewC0 != null) {
                    histogramViewC0.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: w2.k
                        @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
                        public final void a(HistogramView histogramView, boolean z5, int i6, Object obj) {
                            this.f23626a.X(histogramView, z5, i6, obj);
                        }
                    });
                }
                if (histogramViewC0 == null) {
                    break;
                }
                break;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15064I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        int i6 = this.f15098z;
        int i7 = this.f15056A;
        int i8 = this.f15057B;
        int i9 = this.f15088p;
        int i10 = this.f15089q;
        int i11 = this.f15090r;
        int i12 = this.f15091s;
        int i13 = this.f15092t;
        int i14 = this.f15093u;
        int i15 = this.f15094v;
        int i16 = this.f15095w;
        int i17 = this.f15096x;
        int i18 = this.f15097y;
        int i19 = this.f15058C;
        int i20 = this.f15059D;
        int i21 = this.f15060E;
        int i22 = this.f15061F;
        int i23 = this.f15062G;
        int i24 = this.f15063H;
        if (i5 == 0) {
            return 0;
        }
        if (i5 == i6 || i5 == i9 || i5 == i14 || i5 == i19) {
            return 2;
        }
        if (i5 == i15 || i5 == i10 || i5 == i20 || i5 == i7) {
            return 1;
        }
        if (i5 == i18 || i5 == i13 || i5 == i24) {
            return 5;
        }
        if (i5 == 1) {
            return 6;
        }
        if (i5 == i8) {
            return 9;
        }
        if (i5 == i21) {
            return 8;
        }
        if (i5 >= i16 && i5 <= i17) {
            return 3;
        }
        if (i5 < i11 || i5 > i12) {
            return (i5 < i22 || i5 > i23) ? 0 : 7;
        }
        return 4;
    }

    public void h0(Bundle bundle) {
        this.f15088p = bundle.getInt("POS_MOST_USAGE_CATEGORIES_DIVIDER", -1);
        this.f15089q = bundle.getInt("POS_MOST_USAGE_CATEGORIES_CATEGORY", -1);
        this.f15090r = bundle.getInt("POS_MOST_USAGE_CATEGORIES_START", -1);
        this.f15091s = bundle.getInt("POS_MOST_USAGE_CATEGORIES_END", -1);
        this.f15092t = bundle.getInt("POS_MOST_USAGE_CATEGORIES_EXPEND", -1);
        this.f15093u = bundle.getInt("POS_MOST_USAGE_APP_DIVIDER", -1);
        this.f15094v = bundle.getInt("POS_MOST_USAGE_APP_CATEGORY", -1);
        this.f15095w = bundle.getInt("POS_MOST_USAGE_APP_START", -1);
        this.f15096x = bundle.getInt("POS_MOST_USAGE_APP_END", -1);
        this.f15097y = bundle.getInt("POS_MOST_USAGE_APP_EXPEND", -1);
        this.f15098z = bundle.getInt("POS_PICKUP_DIVIDER", -1);
        this.f15056A = bundle.getInt("POS_PICKUP_CATEGORY", -1);
        this.f15057B = bundle.getInt("POS_PICKUP_DETAIL", -1);
        this.f15058C = bundle.getInt("POS_MOST_NOTIFICATION_DIVIDER", -1);
        this.f15059D = bundle.getInt("POS_MOST_NOTIFICATION_CATEGORY", -1);
        this.f15060E = bundle.getInt("POS_MOST_NOTIFICATION_DETAIL", -1);
        this.f15061F = bundle.getInt("POS_MOST_NOTIFICATION_APP_START", -1);
        this.f15062G = bundle.getInt("POS_MOST_NOTIFICATION_APP_END", -1);
        this.f15063H = bundle.getInt("POS_MOST_NOTIFICATION_APP_EXPEND", -1);
        this.f15064I = bundle.getInt("DISPLAY_COUNT", -1);
        this.f15065J = bundle.getInt("SHOWED_APP_USAGE", -1);
        this.f15066K = bundle.getInt("SHOWED_CATEGORY_USAGE", -1);
        this.f15067L = bundle.getInt("SHOWED_APP_NOTIFICATION", -1);
        notifyDataSetChanged();
    }

    public void i0(Bundle bundle) {
        bundle.putInt("POS_MOST_USAGE_CATEGORIES_DIVIDER", this.f15088p);
        bundle.putInt("POS_MOST_USAGE_CATEGORIES_CATEGORY", this.f15089q);
        bundle.putInt("POS_MOST_USAGE_CATEGORIES_START", this.f15090r);
        bundle.putInt("POS_MOST_USAGE_CATEGORIES_END", this.f15091s);
        bundle.putInt("POS_MOST_USAGE_CATEGORIES_EXPEND", this.f15092t);
        bundle.putInt("POS_MOST_USAGE_APP_DIVIDER", this.f15093u);
        bundle.putInt("POS_MOST_USAGE_APP_CATEGORY", this.f15094v);
        bundle.putInt("POS_MOST_USAGE_APP_START", this.f15095w);
        bundle.putInt("POS_MOST_USAGE_APP_END", this.f15096x);
        bundle.putInt("POS_MOST_USAGE_APP_EXPEND", this.f15097y);
        bundle.putInt("POS_PICKUP_DIVIDER", this.f15098z);
        bundle.putInt("POS_PICKUP_CATEGORY", this.f15056A);
        bundle.putInt("POS_PICKUP_DETAIL", this.f15057B);
        bundle.putInt("POS_MOST_NOTIFICATION_DIVIDER", this.f15058C);
        bundle.putInt("POS_MOST_NOTIFICATION_CATEGORY", this.f15059D);
        bundle.putInt("POS_MOST_NOTIFICATION_DETAIL", this.f15060E);
        bundle.putInt("POS_MOST_NOTIFICATION_APP_START", this.f15061F);
        bundle.putInt("POS_MOST_NOTIFICATION_APP_END", this.f15062G);
        bundle.putInt("POS_MOST_NOTIFICATION_APP_EXPEND", this.f15063H);
        bundle.putInt("DISPLAY_COUNT", this.f15064I);
        bundle.putInt("SHOWED_APP_USAGE", this.f15065J);
        bundle.putInt("SHOWED_CATEGORY_USAGE", this.f15066K);
        bundle.putInt("SHOWED_APP_NOTIFICATION", this.f15067L);
    }

    public void j0(PackageNotificationTimesStats[] packageNotificationTimesStatsArr) {
        this.f15077e = packageNotificationTimesStatsArr;
        if (packageNotificationTimesStatsArr == null || packageNotificationTimesStatsArr.length == 0) {
            this.f15079g = 0L;
            this.f15064I = B();
            notifyDataSetChanged();
            return;
        }
        Arrays.sort(packageNotificationTimesStatsArr, new Comparator() { // from class: w2.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractViewOnTouchListenerC0600i.q((PackageNotificationTimesStats) obj, (PackageNotificationTimesStats) obj2);
            }
        });
        if (this.f15067L <= 5) {
            PackageNotificationTimesStats[] packageNotificationTimesStatsArr2 = this.f15077e;
            this.f15067L = packageNotificationTimesStatsArr2.length < 5 ? packageNotificationTimesStatsArr2.length : 5;
        } else {
            this.f15067L = this.f15077e.length;
        }
        this.f15079g = K(packageNotificationTimesStatsArr);
        this.f15064I = B();
        notifyDataSetChanged();
    }

    public void k0(List<C1216d> list) {
        List<C1216d> listJ = J(list);
        this.f15086n = listJ;
        if (listJ == null || listJ.size() == 0) {
            this.f15078f = 0L;
            this.f15064I = B();
            notifyDataSetChanged();
            return;
        }
        R1.a.a("BSA", "setAppUsageLimitData " + C0702g.k(list));
        Collections.sort(this.f15086n, new a(this.f15073a));
        if (this.f15065J <= 5) {
            this.f15065J = this.f15086n.size() < 5 ? this.f15086n.size() : 5;
        }
        this.f15078f = L(this.f15086n);
        int iB = B();
        notifyDataSetChanged();
        this.f15064I = iB;
    }

    public void l0(List<C1257w> list) {
        this.f15087o = list;
        if (list == null || list.size() == 0) {
            this.f15080h = 0L;
            this.f15064I = B();
            notifyDataSetChanged();
            return;
        }
        Collections.sort(this.f15087o, new b(this.f15073a));
        if (this.f15066K <= 3) {
            this.f15066K = this.f15087o.size() < 3 ? this.f15086n.size() : 3;
        } else {
            this.f15066K = this.f15087o.size();
        }
        this.f15080h = M(this.f15087o);
        this.f15064I = B();
        notifyDataSetChanged();
    }

    public void n0(InterfaceC1258w0 interfaceC1258w0) {
        this.f15071S = interfaceC1258w0;
    }

    public void o0(k kVar) {
        this.f15069Q = kVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        UsingTimeStats[] usingTimeStatsArr;
        int itemViewType = getItemViewType(i5);
        if (itemViewType == 0) {
            if (viewHolder instanceof m) {
                m mVar = (m) viewHolder;
                mVar.a(R.string.us_screen_usage);
                mVar.b(P());
                return;
            }
            return;
        }
        if (itemViewType == 2) {
            return;
        }
        if (itemViewType == 1) {
            if (viewHolder instanceof d) {
                if (i5 == this.f15094v) {
                    ((d) viewHolder).a(R.string.us_most_frequently_used_app);
                    return;
                }
                if (i5 == this.f15089q) {
                    ((d) viewHolder).a(R.string.us_most_frequently_used_category);
                    return;
                } else if (i5 == this.f15056A) {
                    ((d) viewHolder).a(R.string.us_take_up_phone);
                    return;
                } else {
                    if (i5 == this.f15059D) {
                        ((d) viewHolder).a(R.string.us_receive_notification);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (itemViewType == 5) {
            if (viewHolder instanceof g) {
                if (i5 == this.f15097y) {
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f23631a.T(view);
                        }
                    });
                    return;
                } else if (i5 == this.f15092t) {
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f23633a.U(view);
                        }
                    });
                    return;
                } else {
                    if (i5 == this.f15063H) {
                        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.o
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f23637a.V(view);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (itemViewType == 3) {
            if (viewHolder instanceof n) {
                ((n) viewHolder).b(this.f15086n.get(i5 - this.f15095w));
                return;
            }
            return;
        }
        if (itemViewType == 7) {
            if (viewHolder instanceof j) {
                ((j) viewHolder).a(this.f15077e[i5 - this.f15061F]);
                return;
            }
            return;
        }
        if (itemViewType == 4) {
            if (viewHolder instanceof c) {
                ((c) viewHolder).d(this.f15087o.get(i5 - this.f15090r));
                return;
            }
            return;
        }
        if (itemViewType == 6) {
            if (!(viewHolder instanceof K) || (usingTimeStatsArr = this.f15083k) == null) {
                return;
            }
            ((HistogramView) ((K) viewHolder).itemView).setData(usingTimeStatsArr);
            return;
        }
        if (itemViewType == 8) {
            if (!(viewHolder instanceof B) || this.f15084l == null) {
                return;
            }
            String string = this.f15073a.getString(R.string.us_widget_notification_label);
            z2.i iVar = new z2.i(this.f15084l);
            int iA = (int) iVar.a();
            int iG = (int) iVar.g();
            HistogramView histogramView = (HistogramView) ((B) viewHolder).itemView;
            histogramView.setYDimensionStrings(new String[]{iA + string, ((iA + iG) / 2) + string, iG + string});
            histogramView.setData(this.f15084l);
            return;
        }
        if (itemViewType == 9 && (viewHolder instanceof H) && this.f15085m != null) {
            String string2 = this.f15073a.getString(R.string.fg_common_count);
            z2.k kVar = new z2.k(this.f15085m);
            int iA2 = (int) kVar.a();
            int iG2 = (int) kVar.g();
            HistogramView histogramView2 = (HistogramView) ((H) viewHolder).itemView;
            histogramView2.setYDimensionStrings(new String[]{iA2 + string2, ((iA2 + iG2) / 2) + string2, iG2 + string2});
            histogramView2.setData(this.f15085m);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return G(viewGroup, i5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        motionEvent.getAction();
        return false;
    }

    public void p0(InterfaceC1262y0 interfaceC1262y0) {
        this.f15070R = interfaceC1262y0;
    }

    public void q0(long j5) {
        this.f15082j = j5;
        Context context = this.f15073a;
        r0(context.getString(R.string.us_until, T1.d.a(context, j5)));
    }

    protected void r0(String str) {
        this.f15081i = str;
    }

    @androidx.lifecycle.D(AbstractC0533m.a.ON_DESTROY)
    public void releaseLoaders() {
        D2.r rVar = this.f15074b;
        if (rVar != null) {
            rVar.a();
        }
        D2.r rVar2 = this.f15075c;
        if (rVar2 != null) {
            rVar2.a();
        }
        D2.k kVar = this.f15076d;
        if (kVar != null) {
            kVar.a();
        }
    }

    @androidx.lifecycle.D(AbstractC0533m.a.ON_DESTROY)
    public void resetAppUsage() {
        this.f15065J = 0;
    }

    public void v0(NotificationTimesStats[] notificationTimesStatsArr) {
        this.f15084l = notificationTimesStatsArr;
        notifyItemChanged(this.f15060E);
    }

    public void w0(PickupTimesStats[] pickupTimesStatsArr) {
        this.f15085m = pickupTimesStatsArr;
        notifyItemChanged(this.f15057B);
    }

    public void x0(UsingTimeStats[] usingTimeStatsArr) {
        this.f15083k = usingTimeStatsArr;
        notifyItemChanged(1);
    }
}

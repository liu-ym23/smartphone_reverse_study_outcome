package com.stepos.familyguard.ui.limit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.C;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import com.stepos.common.widget.TimePicker;
import com.stepos.common.widget.m;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.ListPreference;
import com.stepos.familyguard.ui.widget.PreferenceFragment;
import com.stepos.familyguard.ui.widget.SwitchPreference;
import f2.C0711p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t2.RunnableC1124d;
import t2.Y;

/* loaded from: classes.dex */
public abstract class BaseLimitFragment extends PreferenceFragment implements Preference.d, Preference.e {

    /* renamed from: D0, reason: collision with root package name */
    private static final boolean f14818D0 = R1.a.f("BaseLimitFragment", R1.a.f4966b);

    /* renamed from: B0, reason: collision with root package name */
    private Preference f14820B0;

    /* renamed from: p0, reason: collision with root package name */
    private ListPreference f14822p0;

    /* renamed from: q0, reason: collision with root package name */
    private ListPreference f14823q0;

    /* renamed from: r0, reason: collision with root package name */
    private ListPreference f14824r0;

    /* renamed from: s0, reason: collision with root package name */
    private SwitchPreference f14825s0;

    /* renamed from: t0, reason: collision with root package name */
    private SwitchPreference f14826t0;

    /* renamed from: u0, reason: collision with root package name */
    protected PreferenceCategory f14827u0;

    /* renamed from: v0, reason: collision with root package name */
    protected Y f14828v0;

    /* renamed from: w0, reason: collision with root package name */
    private long f14829w0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private long f14830x0 = -1;

    /* renamed from: y0, reason: collision with root package name */
    private final List<Preference> f14831y0 = new ArrayList();

    /* renamed from: z0, reason: collision with root package name */
    private final Map<String, RawPeriodInfo> f14832z0 = new HashMap();

    /* renamed from: A0, reason: collision with root package name */
    private boolean f14819A0 = false;

    /* renamed from: C0, reason: collision with root package name */
    private boolean f14821C0 = false;

    private static boolean C2(CharSequence[] charSequenceArr, String str) {
        if (charSequenceArr == null || charSequenceArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (TextUtils.equals(charSequence, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(int i5, TimePicker timePicker, int i6, int i7) {
        long j5 = ((i6 * 60) + i7) * 60000;
        if (i5 == 0) {
            this.f14829w0 = j5;
            Y y5 = this.f14828v0;
            if (y5 != null) {
                y5.s().n(Long.valueOf(this.f14829w0));
                this.f14821C0 = true;
                return;
            }
            return;
        }
        this.f14830x0 = j5;
        Y y6 = this.f14828v0;
        if (y6 != null) {
            y6.v().n(Long.valueOf(this.f14830x0));
            this.f14821C0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2(boolean z5) {
        SwitchPreference switchPreference = this.f14826t0;
        if (switchPreference != null) {
            switchPreference.Z0(z5, false);
        }
        R2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(boolean z5) {
        if (z5) {
            this.f14822p0.I0(R.string.us_school_day);
            List<Preference> list = this.f14831y0;
            if (list != null) {
                for (Preference preference : list) {
                    if (preference != null && TextUtils.equals(preference.I(), W(R.string.us_work_day))) {
                        preference.I0(R.string.us_school_day);
                    }
                }
                return;
            }
            return;
        }
        this.f14822p0.I0(R.string.us_work_day);
        List<Preference> list2 = this.f14831y0;
        if (list2 != null) {
            for (Preference preference2 : list2) {
                if (preference2 != null && TextUtils.equals(preference2.I(), W(R.string.us_school_day))) {
                    preference2.I0(R.string.us_work_day);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(String str) {
        this.f14827u0.J0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(boolean z5) {
        this.f14827u0.K0(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(boolean z5) {
        this.f14825s0.t0(z5);
        this.f14826t0.t0(z5);
        R2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(boolean z5) {
        if (z5) {
            this.f14824r0.f1(String.valueOf(1));
            ListPreference listPreference = this.f14824r0;
            listPreference.G0(listPreference.Y0()[1]);
        } else {
            this.f14824r0.f1(String.valueOf(0));
            ListPreference listPreference2 = this.f14824r0;
            listPreference2.G0(listPreference2.Y0()[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(long j5) {
        this.f14830x0 = j5;
        if (j5 == 0) {
            this.f14823q0.G0(W(R.string.us_total_limit));
        } else {
            this.f14823q0.G0(C0711p.n(P1.a.a(), j5, true).trim());
        }
        if (!C2(this.f14823q0.a1(), String.valueOf(j5))) {
            j5 = -1;
        }
        this.f14823q0.f1(String.valueOf(j5));
        R2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(boolean z5) {
        SwitchPreference switchPreference = this.f14825s0;
        if (switchPreference != null) {
            switchPreference.Z0(z5, false);
        }
        R2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(long j5) {
        this.f14829w0 = j5;
        if (j5 == 0) {
            this.f14822p0.G0(W(R.string.us_total_limit));
        } else {
            this.f14822p0.G0(C0711p.n(P1.a.a(), j5, true).trim());
        }
        if (!C2(this.f14822p0.a1(), String.valueOf(j5))) {
            j5 = -1;
        }
        this.f14822p0.f1(String.valueOf(j5));
        R2();
    }

    private void R2() {
        Y y5 = this.f14828v0;
        boolean z5 = false;
        boolean z6 = y5 != null && Boolean.TRUE.equals(y5.j().e());
        Y y6 = this.f14828v0;
        boolean z7 = y6 != null && Boolean.TRUE.equals(y6.D().e());
        Y y7 = this.f14828v0;
        boolean z8 = y7 != null && Boolean.TRUE.equals(y7.p().e());
        boolean z9 = z6 && z7;
        ListPreference listPreference = this.f14822p0;
        if (listPreference != null) {
            listPreference.t0(z9);
        }
        ListPreference listPreference2 = this.f14823q0;
        if (listPreference2 != null) {
            listPreference2.t0(z9);
        }
        ListPreference listPreference3 = this.f14824r0;
        if (listPreference3 != null) {
            listPreference3.t0(z6 && (z7 || z8));
        }
        boolean z10 = z6 && z8;
        Preference preference = this.f14820B0;
        if (preference != null) {
            boolean zEquals = TextUtils.equals(preference.I(), W(R.string.us_max_period_title));
            Preference preference2 = this.f14820B0;
            if (z10 && !zEquals) {
                z5 = true;
            }
            preference2.t0(z5);
        }
        Iterator<Preference> it = this.f14831y0.iterator();
        while (it.hasNext()) {
            it.next().t0(z10);
        }
    }

    private static boolean S2(Boolean bool, boolean z5) {
        return bool != null && bool.booleanValue() == z5;
    }

    private void U2(final int i5) {
        if (w() == null) {
            return;
        }
        long j5 = i5 == 0 ? this.f14829w0 : this.f14830x0;
        new m(w(), new m.c() { // from class: t2.b
            @Override // com.stepos.common.widget.m.c
            public final void a(TimePicker timePicker, int i6, int i7) {
                this.f22554a.F2(i5, timePicker, i6, i7);
            }
        }, C0711p.q(j5), C0711p.r(j5), true).show();
    }

    private void V2(RawPeriodInfo rawPeriodInfo) {
        String str;
        this.f14819A0 = true;
        int size = this.f14832z0.values().size();
        Intent intent = new Intent(w(), (Class<?>) EditPeriodPopupLiteActivity.class);
        if (rawPeriodInfo == null) {
            intent.putExtra("delete_enable", false);
            str = "com.stepos.familyguard.digitalwellbeing.create_period";
        } else {
            intent.putExtra("source_period_info", rawPeriodInfo);
            intent.putExtra("delete_enable", size > 1);
            str = "com.stepos.familyguard.digitalwellbeing.edit_period";
        }
        intent.setAction(str);
        intent.putExtra("is_child", this.f14828v0.o().e().booleanValue());
        Q1(intent, 0);
        p2(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        SwitchPreference switchPreference;
        SwitchPreference switchPreference2;
        Y y5 = this.f14828v0;
        if (y5 == null) {
            return;
        }
        Boolean boolE = y5.D().e();
        Boolean boolE2 = this.f14828v0.p().e();
        if (boolE != null && (switchPreference2 = this.f14825s0) != null) {
            switchPreference2.Z0(boolE.booleanValue(), false);
        }
        if (boolE2 == null || (switchPreference = this.f14826t0) == null) {
            return;
        }
        switchPreference.Z0(boolE2.booleanValue(), false);
    }

    protected abstract Y D2(Bundle bundle);

    protected abstract int E2();

    protected void K2(boolean z5) {
        Y y5;
        if (!z5 || (y5 = this.f14828v0) == null) {
            return;
        }
        y5.m();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void L0() {
        super.L0();
        Y y5 = this.f14828v0;
        if (y5 == null || this.f14819A0 || !this.f14821C0) {
            return;
        }
        y5.i();
        this.f14821C0 = false;
    }

    protected void O2(List<RawPeriodInfo> list) {
        PreferenceGroup preferenceGroupY1 = (PreferenceGroup) a(W(R.string.us_limit_period_category_key));
        if (preferenceGroupY1 == null) {
            preferenceGroupY1 = Y1();
        }
        if (preferenceGroupY1 != null) {
            Iterator<Preference> it = this.f14831y0.iterator();
            while (it.hasNext()) {
                preferenceGroupY1.a1(it.next());
            }
            this.f14831y0.clear();
            this.f14832z0.clear();
            if (list != null) {
                for (RawPeriodInfo rawPeriodInfo : list) {
                    Preference preference = new Preference(w());
                    preference.J0(this.f14828v0.o().e().booleanValue() ? Q().getStringArray(R.array.us_child_weekday_type)[rawPeriodInfo.getWeekDayType()] : Q().getStringArray(R.array.us_weekday_type)[rawPeriodInfo.getWeekDayType()]);
                    preference.G0(C0711p.F(rawPeriodInfo.getStart()) + W(R.string.us_connector) + C0711p.F(rawPeriodInfo.getEnd()));
                    preference.z0(R.layout.us_period_preference_layout);
                    preference.L0(R.layout.us_empty_widget_layout);
                    preference.C0(this);
                    String str = "RawPeriod_" + rawPeriodInfo.getId();
                    preference.y0(str);
                    this.f14832z0.put(str, rawPeriodInfo);
                    SwitchPreference switchPreference = this.f14826t0;
                    if (switchPreference != null) {
                        preference.D0(switchPreference.u() + 1 + this.f14831y0.size());
                    }
                    preferenceGroupY1.S0(preference);
                    this.f14831y0.add(preference);
                }
            } else if (this.f14828v0.u().e().booleanValue()) {
                RawPeriodInfo rawPeriodInfo2 = RawPeriodInfo.getDefault();
                Preference preference2 = new Preference(w());
                preference2.J0(this.f14828v0.o().e().booleanValue() ? Q().getStringArray(R.array.us_child_weekday_type)[rawPeriodInfo2.getWeekDayType()] : Q().getStringArray(R.array.us_weekday_type)[rawPeriodInfo2.getWeekDayType()]);
                preference2.G0(C0711p.F(rawPeriodInfo2.getStart()) + W(R.string.us_connector) + C0711p.F(rawPeriodInfo2.getEnd()));
                preference2.z0(R.layout.us_period_preference_layout);
                preference2.L0(R.layout.us_empty_widget_layout);
                preference2.C0(this);
                preference2.t0(false);
                preferenceGroupY1.S0(preference2);
                this.f14831y0.add(preference2);
            }
            if (list == null || list.size() < 10) {
                this.f14820B0.t0(true);
                this.f14820B0.J0(W(R.string.us_add_period));
            } else {
                this.f14820B0.t0(false);
                this.f14820B0.J0(W(R.string.us_max_period_title));
            }
            R2();
            View viewA0 = a0();
            if (viewA0 != null) {
                viewA0.post(new RunnableC1124d(this));
            } else {
                W2();
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        this.f14819A0 = false;
        W2();
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        super.T0();
    }

    protected void T2(String str) {
        new C2.b(q()).x(R.string.us_salve_unlimitable_title).n(str).q(R.string.stepos_permission_i_know, new DialogInterface.OnClickListener() { // from class: t2.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
            }
        }).A();
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        view.findViewById(android.R.id.list_container).setFitsSystemWindows(false);
        W2();
        view.post(new RunnableC1124d(this));
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void V0(Bundle bundle) {
        super.V0(bundle);
        W2();
    }

    protected void V1() {
        ListPreference listPreference = (ListPreference) a(W(R.string.us_work_day_limit_key));
        this.f14822p0 = listPreference;
        listPreference.B0(this);
        ListPreference listPreference2 = (ListPreference) a(W(R.string.us_off_day_limit_key));
        this.f14823q0 = listPreference2;
        listPreference2.B0(this);
        SwitchPreference switchPreference = (SwitchPreference) a(W(R.string.us_limit_enable_key));
        this.f14825s0 = switchPreference;
        switchPreference.B0(this);
        ListPreference listPreference3 = (ListPreference) a(W(R.string.us_limit_over_key));
        this.f14824r0 = listPreference3;
        listPreference3.B0(this);
        PreferenceCategory preferenceCategory = (PreferenceCategory) a(W(R.string.us_limit_admin_info_key));
        this.f14827u0 = preferenceCategory;
        preferenceCategory.K0(false);
        Preference preferenceA = a(W(R.string.us_add_period_key));
        this.f14820B0 = preferenceA;
        preferenceA.C0(this);
        SwitchPreference switchPreference2 = (SwitchPreference) a(W(R.string.us_period_limit_enable_key));
        this.f14826t0 = switchPreference2;
        switchPreference2.B0(this);
        this.f14825s0.E0(false);
        this.f14826t0.E0(false);
        R2();
    }

    @Override // androidx.preference.Preference.d
    public boolean c(Preference preference, Object obj) throws NumberFormatException {
        if (this.f14828v0 == null || !m0()) {
            return false;
        }
        SwitchPreference switchPreference = this.f14825s0;
        if (switchPreference == preference) {
            if (!switchPreference.Y0()) {
                W2();
                return false;
            }
            Boolean bool = (Boolean) obj;
            if (S2(this.f14828v0.D().e(), bool.booleanValue())) {
                return true;
            }
            this.f14828v0.D().n(bool);
            this.f14821C0 = true;
        } else if (this.f14822p0 == preference) {
            long j5 = Long.parseLong((String) obj);
            if (j5 == -1) {
                U2(0);
            } else {
                this.f14828v0.s().n(Long.valueOf(j5));
                this.f14821C0 = true;
            }
        } else if (this.f14823q0 == preference) {
            long j6 = Long.parseLong((String) obj);
            if (j6 == -1) {
                U2(1);
            } else {
                this.f14828v0.v().n(Long.valueOf(j6));
                this.f14821C0 = true;
            }
        } else {
            ListPreference listPreference = this.f14824r0;
            if (listPreference == preference) {
                int iX0 = listPreference.X0(obj.toString());
                ListPreference listPreference2 = this.f14824r0;
                listPreference2.G0(listPreference2.Y0()[iX0]);
                this.f14828v0.E().n(Boolean.valueOf(iX0 == 1));
                this.f14821C0 = true;
            } else {
                SwitchPreference switchPreference2 = this.f14826t0;
                if (switchPreference2 == preference) {
                    if (!switchPreference2.Y0()) {
                        W2();
                        return false;
                    }
                    Boolean bool2 = (Boolean) obj;
                    boolean zBooleanValue = bool2.booleanValue();
                    if (zBooleanValue && !this.f14828v0.t()) {
                        this.f14826t0.Z0(false, false);
                        T2(this.f14828v0.w());
                        return false;
                    }
                    if (S2(this.f14828v0.p().e(), zBooleanValue)) {
                        return true;
                    }
                    this.f14828v0.p().n(bool2);
                    this.f14821C0 = true;
                }
            }
        }
        return true;
    }

    @Override // androidx.preference.g
    public void c2(Bundle bundle, String str) {
        U1(E2());
        V1();
    }

    @Override // androidx.preference.Preference.e
    public boolean f(Preference preference) {
        RawPeriodInfo rawPeriodInfo;
        Y y5 = this.f14828v0;
        if (y5 != null && !Boolean.TRUE.equals(y5.p().e())) {
            String strS = preference.s();
            if (W(R.string.us_add_period_key).equals(strS) || (strS != null && strS.startsWith("RawPeriod_"))) {
                return true;
            }
        }
        String strS2 = preference.s();
        if (W(R.string.us_add_period_key).equals(strS2)) {
            V2(null);
            return true;
        }
        if (!strS2.startsWith("RawPeriod_") || (rawPeriodInfo = this.f14832z0.get(strS2)) == null) {
            return false;
        }
        V2(rawPeriodInfo);
        return true;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void q0(int i5, int i6, Intent intent) {
        super.q0(i5, i6, intent);
        R1.a.a("BaseLimitFragment", "data = " + intent);
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.equals("com.stepos.familyguard.digitalwellbeing.create_period", action)) {
            this.f14828v0.A((RawPeriodInfo) intent.getParcelableExtra("dest_period_info"));
        } else if (TextUtils.equals("com.stepos.familyguard.digitalwellbeing.edit_period", action)) {
            this.f14828v0.B((RawPeriodInfo) intent.getParcelableExtra("dest_period_info"));
        } else if (TextUtils.equals("com.stepos.familyguard.digitalwellbeing.delete_period", action)) {
            this.f14828v0.e(((RawPeriodInfo) intent.getParcelableExtra("dest_period_info")).getId());
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        Y yD2 = D2(u());
        this.f14828v0 = yD2;
        if (yD2 == null) {
            return;
        }
        yD2.b().g(this, new C() { // from class: com.stepos.familyguard.ui.limit.a
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14854a.K2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.D().g(this, new C() { // from class: t2.e
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22575a.P2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.p().g(this, new C() { // from class: t2.f
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22576a.G2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.s().g(this, new C() { // from class: t2.g
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22580a.Q2(((Long) obj).longValue());
            }
        });
        this.f14828v0.v().g(this, new C() { // from class: t2.h
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22582a.N2(((Long) obj).longValue());
            }
        });
        this.f14828v0.E().g(this, new C() { // from class: t2.i
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22584a.M2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.j().g(this, new C() { // from class: t2.j
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22586a.L2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.u().g(this, new C() { // from class: t2.k
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22588a.J2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.k().g(this, new C() { // from class: t2.l
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22598a.I2((String) obj);
            }
        });
        this.f14828v0.o().g(this, new C() { // from class: t2.a
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22552a.H2(((Boolean) obj).booleanValue());
            }
        });
        this.f14828v0.F().g(this, new C() { // from class: com.stepos.familyguard.ui.limit.b
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14855a.O2((List) obj);
            }
        });
    }
}

package com.stepos.familyguard.ui.limit;

import C2.p;
import T1.g;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import androidx.core.content.res.h;
import androidx.fragment.app.ActivityC0516k;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.widget.TimePicker;
import com.stepos.common.widget.m;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.PreferenceFragment;
import f2.C0711p;
import stepos.support.v7.app.a;
import stepos.support.v7.app.d;

/* loaded from: classes.dex */
public class EditPeriodPreferenceFragment extends PreferenceFragment implements Preference.d, Preference.e {

    /* renamed from: p0, reason: collision with root package name */
    private Preference f14841p0;

    /* renamed from: q0, reason: collision with root package name */
    private Preference f14842q0;

    /* renamed from: r0, reason: collision with root package name */
    private ListPreference f14843r0;

    /* renamed from: s0, reason: collision with root package name */
    private Preference f14844s0;

    /* renamed from: t0, reason: collision with root package name */
    private RawPeriodInfo f14845t0;

    /* renamed from: u0, reason: collision with root package name */
    private RawPeriodInfo f14846u0;

    /* renamed from: v0, reason: collision with root package name */
    private Intent f14847v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f14848w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f14849x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f14850y0;

    /* renamed from: z0, reason: collision with root package name */
    private a.InterfaceC0240a f14851z0;

    private void A2(View view) {
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ != null) {
            activityC0516kQ.finish();
        }
    }

    private void B2(View view) {
        Intent intent = new Intent();
        intent.setAction(this.f14847v0.getAction());
        intent.putExtra("dest_period_info", this.f14846u0);
        intent.putExtra("delete_period_info", false);
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ != null) {
            activityC0516kQ.setResult(0, intent);
            activityC0516kQ.finish();
        }
    }

    private void C2(final boolean z5, final long j5) {
        new C2.b(q()).x(R.string.us_period_time_invalidat).q(R.string.fg_common_ok, new DialogInterface.OnClickListener() { // from class: t2.N
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f22516a.y2(z5, j5, dialogInterface, i5);
            }
        }).A();
    }

    private void D2(final boolean z5, final long j5) {
        if (w() == null) {
            return;
        }
        m mVar = new m(w(), new m.c() { // from class: t2.M
            @Override // com.stepos.common.widget.m.c
            public final void a(TimePicker timePicker, int i5, int i6) {
                this.f22513a.z2(z5, j5, timePicker, i5, i6);
            }
        }, C0711p.q(j5), C0711p.r(j5), DateFormat.is24HourFormat(w()));
        mVar.show();
        mVar.getButton(-1).setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
    }

    private void V1() {
        Preference preferenceA = a(W(R.string.us_edit_period_start_preference_key));
        this.f14841p0 = preferenceA;
        preferenceA.G0(C0711p.F(this.f14846u0.getStart()));
        this.f14841p0.C0(this);
        Preference preferenceA2 = a(W(R.string.us_edit_period_end_preference_key));
        this.f14842q0 = preferenceA2;
        preferenceA2.G0(C0711p.F(this.f14846u0.getEnd()));
        this.f14842q0.C0(this);
        ListPreference listPreference = (ListPreference) a(W(R.string.us_week_day_type_key));
        this.f14843r0 = listPreference;
        listPreference.B0(this);
        if (this.f14850y0) {
            this.f14843r0.G0(Q().getStringArray(R.array.us_child_weekday_type)[this.f14846u0.getWeekDayType()]);
            this.f14843r0.d1(R.array.us_child_weekday_type);
        } else {
            this.f14843r0.G0(Q().getStringArray(R.array.us_weekday_type)[this.f14846u0.getWeekDayType()]);
        }
        this.f14843r0.f1(Q().getStringArray(R.array.us_weekday_value)[this.f14846u0.getWeekDayType()]);
        this.f14843r0.F0(true);
        Preference preferenceA3 = a(W(R.string.us_delete_period_key));
        this.f14844s0 = preferenceA3;
        preferenceA3.L0(0);
        this.f14844s0.C0(this);
        this.f14844s0.J0(p.b(w(), -65536, this.f14844s0.I().toString()));
        this.f14844s0.K0(this.f14849x0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(DialogInterface dialogInterface, int i5) {
        if (i5 != 0) {
            dialogInterface.dismiss();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.stepos.familyguard.digitalwellbeing.delete_period");
        intent.putExtra("dest_period_info", this.f14846u0);
        intent.putExtra("delete_period_info", true);
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ != null) {
            activityC0516kQ.setResult(0, intent);
            activityC0516kQ.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(a.InterfaceC0240a interfaceC0240a) {
        interfaceC0240a.setVisible(true);
        interfaceC0240a.a(R.id.us_menu_cancel);
        interfaceC0240a.b(Q().getString(R.string.fg_common_cancel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(a.InterfaceC0240a interfaceC0240a) {
        this.f14851z0 = interfaceC0240a;
        interfaceC0240a.setVisible(true);
        interfaceC0240a.a(R.id.us_menu_save);
        interfaceC0240a.b(Q().getString(R.string.fg_common_save));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(boolean z5, long j5, DialogInterface dialogInterface, int i5) {
        D2(z5, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(boolean z5, long j5, TimePicker timePicker, int i5, int i6) {
        long j6 = ((i5 * 60) + i6) * 60000;
        if (z5) {
            if (j6 == this.f14846u0.getEnd()) {
                C2(z5, j5);
                return;
            } else {
                this.f14846u0.setStart(j6);
                this.f14841p0.G0(C0711p.F(j6));
            }
        } else if (j6 == this.f14846u0.getStart()) {
            C2(z5, j5);
            return;
        } else {
            this.f14846u0.setEnd(j6);
            this.f14842q0.G0(C0711p.F(j6));
        }
        a.InterfaceC0240a interfaceC0240a = this.f14851z0;
        if (interfaceC0240a != null) {
            interfaceC0240a.setEnabled(!this.f14845t0.equals(this.f14846u0) || this.f14848w0);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public boolean J0(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.us_menu_save) {
            B2(null);
            return true;
        }
        if (menuItem.getItemId() != R.id.us_menu_cancel) {
            return false;
        }
        A2(null);
        return true;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        stepos.support.v7.app.a supportActionBar = ((d) y1()).getSupportActionBar();
        supportActionBar.i(new a.b() { // from class: t2.K
            @Override // stepos.support.v7.app.a.b
            public final void a(a.InterfaceC0240a interfaceC0240a) {
                this.f22511a.w2(interfaceC0240a);
            }
        });
        Drawable drawableF = h.f(Q(), R.drawable.stepos_lite_popup_title_bar_bg, null);
        drawableF.setTint(T1.h.a(A1(), R.attr.colorSurface));
        supportActionBar.y(drawableF);
        supportActionBar.j(new a.b() { // from class: t2.L
            @Override // stepos.support.v7.app.a.b
            public final void a(a.InterfaceC0240a interfaceC0240a) {
                this.f22512a.x2(interfaceC0240a);
            }
        });
    }

    @Override // androidx.preference.Preference.d
    public boolean c(Preference preference, Object obj) {
        if (preference != this.f14843r0) {
            return false;
        }
        this.f14846u0.setWeekDayType(Integer.parseInt(String.valueOf(obj)));
        int iX0 = this.f14843r0.X0(obj.toString());
        ListPreference listPreference = this.f14843r0;
        listPreference.G0(listPreference.Y0()[iX0]);
        a.InterfaceC0240a interfaceC0240a = this.f14851z0;
        if (interfaceC0240a != null) {
            interfaceC0240a.setEnabled(!this.f14845t0.equals(this.f14846u0) || this.f14848w0);
        }
        return true;
    }

    @Override // androidx.preference.g
    public void c2(Bundle bundle, String str) {
        U1(R.xml.us_edit_period_preferences);
    }

    @Override // androidx.preference.Preference.e
    public boolean f(Preference preference) {
        Context contextW;
        if (this.f14841p0 == preference) {
            D2(true, this.f14846u0.getStart());
            return true;
        }
        if (this.f14842q0 == preference) {
            D2(false, this.f14846u0.getEnd());
            return true;
        }
        if (this.f14844s0 != preference || (contextW = w()) == null) {
            return false;
        }
        ColorStateList[] colorStateListArr = {h.e(contextW.getResources(), R.color.stepos_alert_showat_bottom_red, contextW.getTheme())};
        C2.b bVar = new C2.b(contextW);
        bVar.k(android.R.attr.alertDialogIcon);
        bVar.l(new String[]{W(R.string.us_delete_period)}, new DialogInterface.OnClickListener() { // from class: t2.J
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f22510a.v2(dialogInterface, i5);
            }
        }, true, colorStateListArr).A();
        return true;
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public void l2(int i5, int i6, Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (i5 == 0) {
            rect.top = g.a(view.getContext(), R.attr.marginMedium);
        }
    }

    @Override // com.stepos.familyguard.ui.widget.PreferenceFragment
    public int n2(int i5, int i6) {
        if (i5 == 0) {
            return 0;
        }
        return i5 == i6 - 1 ? 2 : 1;
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        I1(true);
        Intent intent = q().getIntent();
        this.f14847v0 = intent;
        this.f14848w0 = TextUtils.equals("com.stepos.familyguard.digitalwellbeing.create_period", intent.getAction());
        this.f14845t0 = (RawPeriodInfo) this.f14847v0.getParcelableExtra("source_period_info");
        this.f14849x0 = this.f14847v0.getBooleanExtra("delete_enable", true);
        this.f14850y0 = this.f14847v0.getBooleanExtra("is_child", false);
        if (this.f14845t0 == null) {
            this.f14845t0 = new RawPeriodInfo(1, 79200000L, 21600000L);
        }
        this.f14846u0 = new RawPeriodInfo(this.f14845t0);
        V1();
    }
}

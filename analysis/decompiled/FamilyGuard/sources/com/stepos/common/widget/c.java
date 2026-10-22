package com.stepos.common.widget;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.common.widget.DatePicker;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class c extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.f {

    /* renamed from: a, reason: collision with root package name */
    private final DatePicker f14379a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0178c f14380b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f14381c;

    /* renamed from: d, reason: collision with root package name */
    private long f14382d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f14383e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14384f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14385g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14386h;

    /* renamed from: i, reason: collision with root package name */
    private String f14387i;

    /* renamed from: j, reason: collision with root package name */
    private String f14388j;

    /* renamed from: k, reason: collision with root package name */
    private DatePicker.f f14389k;

    class a implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f14390a;

        a(View view) {
            this.f14390a = view;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f14390a.removeOnLayoutChangeListener(this);
            LinearLayout linearLayout = (LinearLayout) c.this.findViewById(R.id.extractArea);
            if (linearLayout != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
    }

    class b implements View.OnClickListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f14379a.setIsDrawFading(false);
                c.this.f14379a.setLunar(c.this.f14386h);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f14386h = !r4.f14386h;
            c.this.l();
            if (Build.DEVICE.equals("mx4pro")) {
                new Handler().postDelayed(new a(), c.this.f14382d);
            } else {
                c.this.f14379a.setLunar(c.this.f14386h);
            }
        }
    }

    /* renamed from: com.stepos.common.widget.c$c, reason: collision with other inner class name */
    public interface InterfaceC0178c {
        void a(DatePicker datePicker, int i5, int i6, int i7);
    }

    public c(Context context, InterfaceC0178c interfaceC0178c, int i5, int i6, int i7) {
        this(context, 0, interfaceC0178c, i5, i6, i7);
    }

    private void h(Context context, View view) throws Resources.NotFoundException {
        this.f14381c = (TextView) view.findViewById(H1.h.f2268p0);
        l();
        int color = context.getResources().getColor(H1.e.f2094p);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(context.getResources().getColor(H1.e.f2096r)));
        arrayList.add(Integer.valueOf(context.getResources().getColor(H1.e.f2097s)));
        this.f14379a.S(color, arrayList, context.getResources().getColor(H1.e.f2095q));
        this.f14381c.setOnClickListener(new b());
        TextView textView = (TextView) view.findViewById(H1.h.f2274s0);
        this.f14383e = textView;
        DatePicker datePicker = this.f14379a;
        textView.setText(datePicker.F(datePicker.J(), this.f14379a.getYear(), this.f14379a.getMonth(), this.f14379a.getDayOfMonth(), this.f14385g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f14386h) {
            this.f14381c.setText(this.f14388j);
        } else {
            this.f14381c.setText(this.f14387i);
        }
    }

    @Override // com.stepos.common.widget.DatePicker.f
    public void a(DatePicker datePicker, int i5, int i6, int i7) {
        TextView textView = this.f14383e;
        DatePicker datePicker2 = this.f14379a;
        textView.setText(datePicker2.F(datePicker2.J(), this.f14379a.getYear(), this.f14379a.getMonth(), this.f14379a.getDayOfMonth(), this.f14385g));
        DatePicker.f fVar = this.f14389k;
        if (fVar != null) {
            fVar.a(datePicker, i5, i6, i7);
        }
    }

    public DatePicker g() {
        return this.f14379a;
    }

    public void i(boolean z5, boolean z6) {
        this.f14386h = z5;
        this.f14379a.R(z5, z6);
        l();
        TextView textView = this.f14383e;
        DatePicker datePicker = this.f14379a;
        textView.setText(datePicker.F(datePicker.J(), this.f14379a.getYear(), this.f14379a.getMonth(), this.f14379a.getDayOfMonth(), this.f14385g));
    }

    public void j(int i5) {
        if (i5 > 2099) {
            i5 = 2099;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i5, 11, 31);
        this.f14379a.setMaxDate(calendar.getTimeInMillis());
    }

    public void k(int i5) {
        if (i5 < 1900) {
            i5 = 1900;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i5, 0, 1);
        this.f14379a.setMinDate(calendar.getTimeInMillis());
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i5) {
        if (this.f14380b != null) {
            this.f14379a.clearFocus();
            InterfaceC0178c interfaceC0178c = this.f14380b;
            DatePicker datePicker = this.f14379a;
            interfaceC0178c.a(datePicker, datePicker.getYear(), this.f14379a.getMonth(), this.f14379a.getDayOfMonth());
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f14379a.H(bundle.getInt("year"), bundle.getInt("month"), bundle.getInt("day"), this, false);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.f14379a.getYear());
        bundleOnSaveInstanceState.putInt("month", this.f14379a.getMonth());
        bundleOnSaveInstanceState.putInt("day", this.f14379a.getDayOfMonth());
        return bundleOnSaveInstanceState;
    }

    public c(Context context, int i5, InterfaceC0178c interfaceC0178c, int i6, int i7, int i8) throws Resources.NotFoundException {
        super(context, i5);
        this.f14382d = 200L;
        this.f14384f = false;
        this.f14385g = true;
        this.f14386h = false;
        this.f14380b = interfaceC0178c;
        setButton(-1, context.getText(H1.k.f2342F), this);
        setButton(-2, context.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(H1.i.f2311b, (ViewGroup) null);
        setView(viewInflate);
        viewInflate.addOnLayoutChangeListener(new a(viewInflate));
        DatePicker datePicker = (DatePicker) viewInflate.findViewById(H1.h.f2259l);
        this.f14379a = datePicker;
        datePicker.H(i6, i7, i8, this, false);
        datePicker.setIsDrawLine(false);
        datePicker.Q(context.getResources().getDimensionPixelSize(H1.f.f2141f), context.getResources().getDimensionPixelSize(H1.f.f2145h));
        this.f14387i = context.getResources().getString(H1.k.f2347e);
        this.f14388j = context.getResources().getString(H1.k.f2346d);
        h(context, viewInflate);
    }
}

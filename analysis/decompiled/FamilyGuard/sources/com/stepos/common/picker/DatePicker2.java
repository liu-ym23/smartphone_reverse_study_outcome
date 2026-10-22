package com.stepos.common.picker;

import H1.h;
import H1.i;
import H1.k;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.common.picker.WheelPicker;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class DatePicker2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final WheelPicker f13600a;

    /* renamed from: b, reason: collision with root package name */
    private final WheelPicker f13601b;

    /* renamed from: c, reason: collision with root package name */
    private final WheelPicker f13602c;

    /* renamed from: d, reason: collision with root package name */
    private int f13603d;

    /* renamed from: e, reason: collision with root package name */
    private int f13604e;

    /* renamed from: f, reason: collision with root package name */
    private int f13605f;

    /* renamed from: g, reason: collision with root package name */
    private int f13606g;

    /* renamed from: h, reason: collision with root package name */
    private int f13607h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f13608i;

    /* renamed from: j, reason: collision with root package name */
    private final String[] f13609j;

    /* renamed from: k, reason: collision with root package name */
    private String[] f13610k;

    class a implements WheelPicker.e {
        a() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i5, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.f13603d = datePicker2.n(str, datePicker2.f13603d);
            DatePicker2.this.m();
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.f13603d, DatePicker2.this.f13604e - 1, DatePicker2.this.f13605f);
        }
    }

    class b implements WheelPicker.e {
        b() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i5, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.f13604e = datePicker2.n(str, datePicker2.f13604e);
            DatePicker2.this.m();
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.f13603d, DatePicker2.this.f13604e - 1, DatePicker2.this.f13605f);
        }
    }

    class c implements WheelPicker.e {
        c() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i5, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.f13605f = datePicker2.n(str, datePicker2.f13605f);
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.f13603d, DatePicker2.this.f13604e - 1, DatePicker2.this.f13605f);
        }
    }

    public interface d {
    }

    private static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final int f13614a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13615b;

        /* renamed from: c, reason: collision with root package name */
        private final int f13616c;

        class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i5) {
                return new e[i5];
            }
        }

        /* synthetic */ e(Parcelable parcelable, int i5, int i6, int i7, a aVar) {
            this(parcelable, i5, i6, i7);
        }

        public int a() {
            return this.f13616c;
        }

        public int c() {
            return this.f13615b;
        }

        public int f() {
            return this.f13614a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13614a);
            parcel.writeInt(this.f13615b);
            parcel.writeInt(this.f13616c);
        }

        private e(Parcelable parcelable, int i5, int i6, int i7) {
            super(parcelable);
            this.f13614a = i5;
            this.f13615b = i6;
            this.f13616c = i7;
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f13614a = parcel.readInt();
            this.f13615b = parcel.readInt();
            this.f13616c = parcel.readInt();
        }
    }

    public DatePicker2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i5, int i6, int i7) {
    }

    private void k(Calendar calendar) {
        int actualMaximum = calendar.getActualMaximum(5);
        this.f13610k = new String[actualMaximum];
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i5 = 1; i5 <= actualMaximum; i5++) {
            this.f13610k[i5 - 1] = String.valueOf(i5 < 10 ? str + i5 : Integer.valueOf(i5));
        }
    }

    private void l(int i5, int i6) {
        if (i5 > i6) {
            return;
        }
        this.f13608i = new String[(i6 - i5) + 1];
        for (int i7 = i5; i7 <= i6; i7++) {
            this.f13608i[i7 - i5] = String.valueOf(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f13603d);
        calendar.set(2, this.f13604e - 1);
        k(calendar);
        int actualMaximum = calendar.getActualMaximum(5);
        if (this.f13605f > actualMaximum) {
            this.f13605f = actualMaximum;
        }
        this.f13602c.A(Arrays.asList(this.f13610k), this.f13605f - 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(String str, int i5) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w("DatePicker2", "parseInt has an error, text:" + str);
            return i5;
        }
    }

    private void p() {
        this.f13602c.setDrawFlagEnable(true);
        this.f13602c.setFlagText(getContext().getString(k.f2348f));
        s(this.f13603d, this.f13604e - 1, -1);
        this.f13602c.m(new c());
    }

    private void q() {
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i5 = 1; i5 <= 12; i5++) {
            this.f13609j[i5 - 1] = String.valueOf(i5 < 10 ? str + i5 : Integer.valueOf(i5));
        }
        this.f13601b.setDrawFlagEnable(true);
        this.f13601b.setFlagText(getContext().getString(k.f2351i));
        t(Calendar.getInstance().get(2) + 1);
        this.f13601b.m(new b());
    }

    private void r() {
        l(1900, 2099);
        this.f13600a.setItemCount(5);
        this.f13600a.setDrawFlagEnable(true);
        this.f13600a.setFlagText(getContext().getString(k.f2352j));
        u(1900, 2099, Calendar.getInstance().get(1));
        this.f13600a.m(new a());
    }

    private void s(int i5, int i6, int i7) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i5);
        calendar.set(2, i6);
        if (i7 == -1) {
            this.f13605f = calendar.get(5);
        } else {
            this.f13605f = i7;
        }
        k(calendar);
        this.f13602c.A(Arrays.asList(this.f13610k), this.f13605f - 1, true);
    }

    private void t(int i5) {
        this.f13604e = i5;
        this.f13601b.A(Arrays.asList(this.f13609j), i5 - 1, true);
    }

    private void u(int i5, int i6, int i7) {
        if (i5 == this.f13606g && i6 == this.f13607h && i7 == this.f13603d) {
            return;
        }
        l(i5, i6);
        this.f13606g = i5;
        this.f13607h = i6;
        this.f13603d = i7;
        if (i7 < i5 || i7 > i6) {
            this.f13600a.A(Arrays.asList(this.f13608i), 0, true);
        } else {
            this.f13600a.A(Arrays.asList(this.f13608i), this.f13603d - this.f13606g, true);
        }
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f13603d);
        calendar.set(2, this.f13604e - 1);
        calendar.set(5, this.f13605f);
        return calendar.getTime();
    }

    public int getDay() {
        return this.f13605f;
    }

    public WheelPicker getDayPicker() {
        return this.f13602c;
    }

    public int getMonth() {
        return this.f13604e;
    }

    public WheelPicker getMonthPicker() {
        return this.f13601b;
    }

    public int getYear() {
        return this.f13603d;
    }

    public WheelPicker getYearPicker() {
        return this.f13600a;
    }

    public void o(int i5, int i6, int i7) {
        u(this.f13606g, this.f13607h, i5);
        t(i6);
        s(i5, i6 - 1, i7);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(parcelable);
        this.f13603d = eVar.f();
        this.f13604e = eVar.c();
        this.f13605f = eVar.a();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new e(super.onSaveInstanceState(), this.f13603d, this.f13604e, this.f13605f, null);
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        o(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public void setOnDateChangedListener(d dVar) {
    }

    public DatePicker2(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13609j = new String[12];
        View.inflate(context, i.f2298L, this);
        this.f13600a = (WheelPicker) findViewById(h.f2284x0);
        this.f13601b = (WheelPicker) findViewById(h.f2236Z);
        this.f13602c = (WheelPicker) findViewById(h.f2261m);
        r();
        q();
        p();
    }
}

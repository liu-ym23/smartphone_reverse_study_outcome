package com.stepos.common.picker;

import H1.h;
import H1.i;
import H1.k;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.common.picker.TimePicker2;
import com.stepos.common.picker.WheelPicker;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class TimePicker2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final WheelPicker f13617a;

    /* renamed from: b, reason: collision with root package name */
    private final WheelPicker f13618b;

    /* renamed from: c, reason: collision with root package name */
    private final WheelPicker f13619c;

    /* renamed from: d, reason: collision with root package name */
    private int f13620d;

    /* renamed from: e, reason: collision with root package name */
    private int f13621e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13622f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13623g;

    /* renamed from: h, reason: collision with root package name */
    private String f13624h;

    /* renamed from: i, reason: collision with root package name */
    private String f13625i;

    /* renamed from: j, reason: collision with root package name */
    private final String[] f13626j;

    /* renamed from: k, reason: collision with root package name */
    private final String[] f13627k;

    /* renamed from: l, reason: collision with root package name */
    private final String[] f13628l;

    /* renamed from: m, reason: collision with root package name */
    private final String[] f13629m;

    /* renamed from: n, reason: collision with root package name */
    private List<b> f13630n;

    class a implements WheelPicker.e {
        a() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i5, View view, String str) {
            TimePicker2 timePicker2 = TimePicker2.this;
            timePicker2.f13623g = timePicker2.f13624h.equals(str);
            TimePicker2 timePicker22 = TimePicker2.this;
            timePicker22.h(timePicker22, timePicker22.f13620d, TimePicker2.this.f13621e);
        }
    }

    public interface b {
        void a(TimePicker2 timePicker2, boolean z5, int i5, int i6);
    }

    @Deprecated
    public interface c {
    }

    private static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final int f13632a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13633b;

        class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i5) {
                return new d[i5];
            }
        }

        /* synthetic */ d(Parcelable parcelable, int i5, int i6, a aVar) {
            this(parcelable, i5, i6);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13632a);
            parcel.writeInt(this.f13633b);
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f13632a = parcel.readInt();
            this.f13633b = parcel.readInt();
        }

        private d(Parcelable parcelable, int i5, int i6) {
            super(parcelable);
            this.f13632a = i5;
            this.f13633b = i6;
        }
    }

    public TimePicker2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ void a(TimePicker2 timePicker2, int i5, View view, String str) {
        timePicker2.getClass();
        try {
            timePicker2.f13620d = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w("TimePicker2", "NumberFormat parse hour has an error, text:" + str);
        }
        timePicker2.h(timePicker2, timePicker2.f13620d, timePicker2.f13621e);
    }

    public static /* synthetic */ void b(TimePicker2 timePicker2, int i5, View view, String str) {
        timePicker2.getClass();
        try {
            timePicker2.f13621e = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w("TimePicker2", "NumberFormat parse minute has an error, text:" + str);
        }
        timePicker2.h(timePicker2, timePicker2.f13620d, timePicker2.f13621e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TimePicker2 timePicker2, int i5, int i6) {
        List<b> list = this.f13630n;
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(timePicker2, this.f13623g, i5, i6);
            }
        }
    }

    private void i() {
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i5 = 0; i5 < 24; i5++) {
            this.f13626j[i5] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i5));
            if (i5 <= 9) {
                this.f13626j[i5] = str + this.f13626j[i5];
            }
        }
        for (int i6 = 1; i6 <= 12; i6++) {
            int i7 = i6 - 1;
            this.f13627k[i7] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i6));
            if (i6 < 10) {
                this.f13627k[i7] = str + this.f13627k[i7];
            }
        }
        this.f13618b.setDrawFlagEnable(true);
        this.f13618b.setFlagText(getContext().getString(k.f2349g));
        if (this.f13622f) {
            this.f13618b.A(Arrays.asList(this.f13626j), this.f13620d, true);
            this.f13617a.setVisibility(8);
        } else {
            this.f13618b.A(Arrays.asList(this.f13627k), this.f13620d - 1, true);
            this.f13617a.A(Arrays.asList(this.f13629m), 0, false);
        }
        this.f13618b.m(new WheelPicker.e() { // from class: L1.b
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(int i8, View view, String str2) {
                TimePicker2.a(this.f3807a, i8, view, str2);
            }
        });
    }

    private void j() {
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i5 = 0; i5 < 60; i5++) {
            this.f13628l[i5] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i5));
            if (i5 <= 9) {
                this.f13628l[i5] = str + this.f13628l[i5];
            }
        }
        this.f13619c.setDrawFlagEnable(true);
        this.f13619c.setFlagText(getContext().getString(k.f2350h));
        this.f13619c.A(Arrays.asList(this.f13628l), this.f13621e, true);
        this.f13619c.m(new WheelPicker.e() { // from class: L1.a
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(int i6, View view, String str2) {
                TimePicker2.b(this.f3806a, i6, view, str2);
            }
        });
    }

    private void k() {
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f13617a.setItemCount(3);
        String[] strArr = this.f13629m;
        strArr[3] = BuildConfig.FLAVOR;
        strArr[0] = BuildConfig.FLAVOR;
        String str = amPmStrings[0];
        strArr[1] = str;
        String str2 = amPmStrings[1];
        strArr[2] = str2;
        this.f13624h = str;
        this.f13625i = str2;
        this.f13617a.m(new a());
    }

    public WheelPicker getAmPmPicker() {
        return this.f13617a;
    }

    public int getHour() {
        if (!this.f13622f && !this.f13623g) {
            return this.f13620d + 12;
        }
        return this.f13620d;
    }

    public WheelPicker getHourPicker() {
        return this.f13618b;
    }

    public int getMinute() {
        return this.f13621e;
    }

    public WheelPicker getMinutePicker() {
        return this.f13619c;
    }

    public void l(int i5, int i6, boolean z5) {
        boolean z6;
        boolean z7;
        int i7;
        boolean z8 = this.f13622f != z5;
        if (this.f13620d != i5) {
            this.f13620d = i5;
            z6 = true;
        } else {
            z6 = false;
        }
        this.f13623g = true;
        if (!z5 && (i7 = this.f13620d) > 12) {
            this.f13620d = i7 - 12;
            this.f13623g = false;
            z6 = true;
        }
        if (this.f13621e != i6) {
            this.f13621e = i6;
            z7 = true;
        } else {
            z7 = false;
        }
        if (z8) {
            WheelPicker wheelPicker = this.f13618b;
            List<String> listAsList = Arrays.asList(z5 ? this.f13626j : this.f13627k);
            int i8 = this.f13620d;
            if (!z5) {
                i8--;
            }
            wheelPicker.A(listAsList, i8, true);
        }
        if (z6) {
            WheelPicker wheelPicker2 = this.f13618b;
            int i9 = this.f13620d;
            if (!z5) {
                i9--;
            }
            wheelPicker2.setCurrentItem(i9);
        }
        if (z7) {
            this.f13619c.setCurrentItem(this.f13621e);
        }
        this.f13622f = z5;
        if (z5) {
            this.f13617a.setVisibility(8);
            return;
        }
        this.f13617a.A(Arrays.asList(this.f13629m), 0, false);
        this.f13617a.setVisibility(0);
        this.f13617a.setCurrentItem(this.f13623g ? 1 : 2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        l(dVar.f13632a, dVar.f13633b, this.f13622f);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new d(super.onSaveInstanceState(), this.f13620d, this.f13621e, null);
    }

    public void set24HourFormat(boolean z5) {
        l(this.f13620d, this.f13621e, z5);
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f13617a.setEnabled(z5);
        this.f13618b.setEnabled(z5);
        this.f13619c.setEnabled(z5);
    }

    public void setHour(int i5) {
        if (i5 == getHour()) {
            return;
        }
        l(i5, this.f13621e, this.f13622f);
    }

    public void setMinute(int i5) {
        if (i5 == getMinute()) {
            return;
        }
        l(this.f13620d, i5, this.f13622f);
    }

    @Deprecated
    public void setOnTimeChangedListener(c cVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        WheelPicker wheelPicker = this.f13617a;
        if (wheelPicker != null) {
            wheelPicker.setVisibility(i5);
        }
        WheelPicker wheelPicker2 = this.f13618b;
        if (wheelPicker2 != null) {
            wheelPicker2.setVisibility(i5);
        }
        WheelPicker wheelPicker3 = this.f13619c;
        if (wheelPicker3 != null) {
            wheelPicker3.setVisibility(i5);
        }
    }

    public TimePicker2(Context context, AttributeSet attributeSet, int i5) {
        int i6;
        super(context, attributeSet, i5);
        this.f13623g = true;
        this.f13626j = new String[24];
        this.f13627k = new String[12];
        this.f13628l = new String[60];
        this.f13629m = new String[4];
        Calendar calendar = Calendar.getInstance();
        this.f13620d = calendar.get(11);
        this.f13621e = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        this.f13622f = zIs24HourFormat;
        if (!zIs24HourFormat && (i6 = this.f13620d) >= 12) {
            this.f13620d = i6 - 12;
            this.f13623g = false;
        }
        View.inflate(getContext(), i.f2309W, this);
        this.f13617a = (WheelPicker) findViewById(h.f2237a);
        this.f13618b = (WheelPicker) findViewById(h.f2279v);
        this.f13619c = (WheelPicker) findViewById(h.f2235Y);
        k();
        i();
        j();
    }
}

package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.stepos.aiengine.R;
import java.util.Locale;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements ClockHandView.a, k {
    public static final String[] h = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f5391j = {"00", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f5392k = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a, reason: collision with root package name */
    public final TimePickerView f5393a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModel f5394b;

    /* renamed from: c, reason: collision with root package name */
    public float f5395c;

    /* renamed from: d, reason: collision with root package name */
    public float f5396d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5397e = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends com.google.android.material.timepicker.a {
        public a(Context context) {
            super(context, R.string.material_hour_selection);
        }

        @Override // com.google.android.material.timepicker.a, v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            Resources resources = view.getResources();
            TimeModel timeModel = j.this.f5394b;
            bVar.k(resources.getString(timeModel.getHourContentDescriptionResId(), String.valueOf(timeModel.getHourForDisplay())));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends com.google.android.material.timepicker.a {
        public b(Context context) {
            super(context, R.string.material_minute_selection);
        }

        @Override // com.google.android.material.timepicker.a, v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.k(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(j.this.f5394b.minute)));
        }
    }

    public j(TimePickerView timePickerView, TimeModel timeModel) {
        this.f5393a = timePickerView;
        this.f5394b = timeModel;
        if (timeModel.format == 0) {
            timePickerView.f5378x.setVisibility(0);
        }
        timePickerView.f5376v.f5360m.add(this);
        timePickerView.z = this;
        timePickerView.f5379y = this;
        timePickerView.f5376v.f5367u = this;
        d(TimeModel.NUMBER_FORMAT, h);
        d(TimeModel.NUMBER_FORMAT, f5391j);
        d(TimeModel.ZERO_LEADING_NUMBER_FORMAT, f5392k);
        invalidate();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public final void a(float f8, boolean z) {
        if (this.f5397e || z) {
            return;
        }
        TimeModel timeModel = this.f5394b;
        int i10 = timeModel.hour;
        int i11 = timeModel.minute;
        int iRound = Math.round(f8);
        int i12 = timeModel.selection;
        TimePickerView timePickerView = this.f5393a;
        if (i12 == 12) {
            timeModel.setMinute((iRound + 3) / 6);
            this.f5395c = (float) Math.floor(timeModel.minute * 6);
        } else {
            int i13 = (iRound + 15) / 30;
            if (timeModel.format == 1) {
                i13 %= 12;
                if (timePickerView.f5377w.f5348w.f5370x == 2) {
                    i13 += 12;
                }
            }
            timeModel.setHour(i13);
            this.f5396d = (timeModel.getHourForDisplay() * 30) % 360;
        }
        c();
        if (timeModel.minute == i11 && timeModel.hour == i10) {
            return;
        }
        timePickerView.performHapticFeedback(4);
    }

    public final void b(int i10, boolean z) {
        boolean z3 = i10 == 12;
        TimePickerView timePickerView = this.f5393a;
        ClockHandView clockHandView = timePickerView.f5376v;
        Chip chip = timePickerView.f5375u;
        Chip chip2 = timePickerView.f5374t;
        ClockFaceView clockFaceView = timePickerView.f5377w;
        clockHandView.f5355d = z3;
        TimeModel timeModel = this.f5394b;
        timeModel.selection = i10;
        clockFaceView.o(z3 ? f5392k : timeModel.format == 1 ? f5391j : h, z3 ? R.string.material_minute_suffix : timeModel.getHourContentDescriptionResId());
        int i11 = (timeModel.selection == 10 && timeModel.format == 1 && timeModel.hour >= 12) ? 2 : 1;
        ClockHandView clockHandView2 = clockFaceView.f5348w;
        clockHandView2.f5370x = i11;
        clockHandView2.invalidate();
        timePickerView.f5376v.c(z3 ? this.f5395c : this.f5396d, z);
        boolean z10 = i10 == 12;
        chip2.setChecked(z10);
        chip2.setAccessibilityLiveRegion(z10 ? 2 : 0);
        boolean z11 = i10 == 10;
        chip.setChecked(z11);
        chip.setAccessibilityLiveRegion(z11 ? 2 : 0);
        e0.j(chip, new a(timePickerView.getContext()));
        e0.j(chip2, new b(timePickerView.getContext()));
    }

    public final void c() {
        TimeModel timeModel = this.f5394b;
        int i10 = timeModel.period;
        int hourForDisplay = timeModel.getHourForDisplay();
        int i11 = timeModel.minute;
        TimePickerView timePickerView = this.f5393a;
        Chip chip = timePickerView.f5375u;
        Chip chip2 = timePickerView.f5374t;
        timePickerView.f5378x.f(i10 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button, true);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i11));
        String str2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(hourForDisplay));
        if (!TextUtils.equals(chip2.getText(), str)) {
            chip2.setText(str);
        }
        if (TextUtils.equals(chip.getText(), str2)) {
            return;
        }
        chip.setText(str2);
    }

    public final void d(String str, String[] strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr[i10] = TimeModel.formatText(this.f5393a.getResources(), strArr[i10], str);
        }
    }

    @Override // com.google.android.material.timepicker.k
    public final void hide() {
        this.f5393a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.k
    public final void invalidate() {
        TimeModel timeModel = this.f5394b;
        this.f5396d = (timeModel.getHourForDisplay() * 30) % 360;
        this.f5395c = timeModel.minute * 6;
        b(timeModel.selection, false);
        c();
    }

    @Override // com.google.android.material.timepicker.k
    public final void show() {
        this.f5393a.setVisibility(0);
    }
}

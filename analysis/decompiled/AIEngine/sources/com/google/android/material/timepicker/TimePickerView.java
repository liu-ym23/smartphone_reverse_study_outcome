package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int B = 0;
    public MaterialTimePicker A;

    /* renamed from: t, reason: collision with root package name */
    public final Chip f5374t;

    /* renamed from: u, reason: collision with root package name */
    public final Chip f5375u;

    /* renamed from: v, reason: collision with root package name */
    public final ClockHandView f5376v;

    /* renamed from: w, reason: collision with root package name */
    public final ClockFaceView f5377w;

    /* renamed from: x, reason: collision with root package name */
    public final MaterialButtonToggleGroup f5378x;

    /* renamed from: y, reason: collision with root package name */
    public j f5379y;
    public j z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j jVar = TimePickerView.this.z;
            if (jVar != null) {
                jVar.b(((Integer) view.getTag(R.id.selection_type)).intValue(), true);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void onDoubleTap();
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f5377w = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f5378x = materialButtonToggleGroup;
        materialButtonToggleGroup.f4755o.add(new MaterialButtonToggleGroup.b() { // from class: com.google.android.material.timepicker.p
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.b
            public final void a(int i10, boolean z) {
                if (!z) {
                    int i11 = TimePickerView.B;
                    return;
                }
                j jVar = this.f5422a.f5379y;
                if (jVar != null) {
                    jVar.f5394b.setPeriod(i10 == R.id.material_clock_period_pm_button ? 1 : 0);
                }
            }
        });
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.f5374t = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.f5375u = chip2;
        this.f5376v = (ClockHandView) findViewById(R.id.material_clock_hand);
        r rVar = new r(new GestureDetector(getContext(), new q(this)));
        chip.setOnTouchListener(rVar);
        chip2.setOnTouchListener(rVar);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.f5375u.sendAccessibilityEvent(8);
        }
    }
}

package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Chip f21748a;

    /* renamed from: b, reason: collision with root package name */
    public final Chip f21749b;

    /* renamed from: c, reason: collision with root package name */
    public final ClockHandView f21750c;

    /* renamed from: d, reason: collision with root package name */
    public final ClockFaceView f21751d;

    /* renamed from: e, reason: collision with root package name */
    public final MaterialButtonToggleGroup f21752e;

    /* renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f21753f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.d(TimePickerView.this);
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.e(TimePickerView.this);
            return false;
        }
    }

    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f21756a;

        public c(GestureDetector gestureDetector) {
            this.f21756a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f21756a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public interface d {
    }

    public interface e {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ e d(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ d e(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public final void f() {
        Chip chip = this.f21748a;
        int i10 = R$id.selection_type;
        chip.setTag(i10, 12);
        this.f21749b.setTag(i10, 10);
        this.f21748a.setOnClickListener(this.f21753f);
        this.f21749b.setOnClickListener(this.f21753f);
        this.f21748a.setAccessibilityClassName("android.view.View");
        this.f21749b.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void g() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f21748a.setOnTouchListener(cVar);
        this.f21749b.setOnTouchListener(cVar);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.f21749b.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21753f = new a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f21751d = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f21752e = materialButtonToggleGroup;
        materialButtonToggleGroup.q(new MaterialButtonToggleGroup.b() { // from class: com.google.android.material.timepicker.e
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.b
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                this.f21764a.getClass();
            }
        });
        this.f21748a = (Chip) findViewById(R$id.material_minute_tv);
        this.f21749b = (Chip) findViewById(R$id.material_hour_tv);
        this.f21750c = (ClockHandView) findViewById(R$id.material_clock_hand);
        g();
        f();
    }
}

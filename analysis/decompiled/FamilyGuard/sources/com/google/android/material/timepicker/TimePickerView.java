package com.google.android.material.timepicker;

import a1.C0413f;
import a1.C0415h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: A, reason: collision with root package name */
    private final ClockHandView f13481A;

    /* renamed from: B, reason: collision with root package name */
    private final ClockFaceView f13482B;

    /* renamed from: C, reason: collision with root package name */
    private final MaterialButtonToggleGroup f13483C;

    /* renamed from: D, reason: collision with root package name */
    private final View.OnClickListener f13484D;

    /* renamed from: y, reason: collision with root package name */
    private final Chip f13485y;

    /* renamed from: z, reason: collision with root package name */
    private final Chip f13486z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.C(TimePickerView.this);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.D(TimePickerView.this);
            return false;
        }
    }

    class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f13489a;

        c(GestureDetector gestureDetector) {
            this.f13489a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f13489a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface d {
    }

    interface e {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ e C(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ d D(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    private void E() {
        Chip chip = this.f13485y;
        int i5 = C0413f.f6825H;
        chip.setTag(i5, 12);
        this.f13486z.setTag(i5, 10);
        this.f13485y.setOnClickListener(this.f13484D);
        this.f13486z.setOnClickListener(this.f13484D);
        this.f13485y.setAccessibilityClassName("android.view.View");
        this.f13486z.setAccessibilityClassName("android.view.View");
    }

    private void F() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f13485y.setOnTouchListener(cVar);
        this.f13486z.setOnTouchListener(cVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i5) {
        super.onVisibilityChanged(view, i5);
        if (view == this && i5 == 0) {
            this.f13486z.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13484D = new a();
        LayoutInflater.from(context).inflate(C0415h.f6875i, this);
        this.f13482B = (ClockFaceView) findViewById(C0413f.f6846i);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(C0413f.f6849l);
        this.f13483C = materialButtonToggleGroup;
        materialButtonToggleGroup.q(new MaterialButtonToggleGroup.b() { // from class: com.google.android.material.timepicker.f
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.b
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i6, boolean z5) {
                this.f13504a.getClass();
            }
        });
        this.f13485y = (Chip) findViewById(C0413f.f6852o);
        this.f13486z = (Chip) findViewById(C0413f.f6850m);
        this.f13481A = (ClockHandView) findViewById(C0413f.f6847j);
        F();
        E();
    }
}

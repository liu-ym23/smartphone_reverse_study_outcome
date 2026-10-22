package com.bytedance.android.livesdk.interactivity.comment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class BarrageView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f136269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f136270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f136271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f136272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animation f136273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f136274f;

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BarrageView f136275a;

        public a(BarrageView r100) {
            this.f136275a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setCheckable(true);
            r101.setChecked(this.f136275a.f136270b.isSelected());
            if (this.f136275a.f136270b.isSelected() == false) goto L5;
            String r102 = "开";
        L6:
            r101.setContentDescription("弹幕已".concat(r102));
            r101.setClassName(ToggleButton.class.getName());
            return;
        L5:
            r102 = "关";
            goto L6
        }
    }

    private int getLayoutId() {
        return R.layout.ttlive_view_barrage;
    }

    public final void a() {
        RelativeLayout.inflate(getContext(), getLayoutId(), this);
        this.f136269a = findViewById(R.id.danmu_input_layout);
        this.f136270b = findViewById(R.id.danmu_input);
        this.f136271c = findViewById(R.id.danmu_input_loading);
        this.f136272d = findViewById(R.id.danmu_input_loading_back);
        r3.e(this, new a(this));
    }

    public View getDanmuContainer() {
        return this.f136269a;
    }

    public View getDanmuInput() {
        return this.f136270b;
    }

    public BarrageView(Context r100) {
        super(r100);
        this.f136274f = false;
        a();
    }

    public final void b(boolean r110) {
        View r100 = this.f136271c;
        int r101 = 8;
        int r102 = 0;
        if (r110 == false) goto L5;
        int r103 = 0;
    L6:
        r100.setVisibility(r103);
        View r104 = this.f136272d;
        if (r110 == false) goto L9;
        r101 = 0;
    L9:
        r104.setVisibility(r101);
        View r105 = this.f136270b;
        if (r110 == false) goto L12;
        r102 = 4;
    L12:
        r105.setVisibility(r102);
        if (r110 == false) goto L15;
        RotateAnimation r111 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f136273e = r111;
        r111.setRepeatCount(-1);
        this.f136273e.setDuration(400);
        this.f136271c.startAnimation(this.f136273e);
        return;
    L15:
        this.f136271c.clearAnimation();
        this.f136273e = null;
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public BarrageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f136274f = false;
        a();
    }

    public BarrageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f136274f = false;
        a();
    }
}

package com.google.android.material.timepicker;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TimePickerClockPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements ClockHandView.a, ClockHandView.b, TimePickerView.b, TimePickerView.c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f13670a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f13671b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f13672c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimePickerView f13673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeModel f13674e;
    private float f;
    private float g;
    private boolean h;

    static /* synthetic */ TimeModel a(b r0) {
        return r0.f13674e;
    }

    static {
        f13670a = new String[]{"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        f13671b = new String[]{"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
        f13672c = new String[]{"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public b(TimePickerView r2, TimeModel r3) {
        this.h = false;
        this.f13673d = r2;
        this.f13674e = r3;
        a();
    }

    public void a() {
        if (this.f13674e.format != 0) goto L5;
        this.f13673d.showToggle();
    L5:
        this.f13673d.addOnRotateListener(this);
        this.f13673d.setOnSelectionChangeListener(this);
        this.f13673d.setOnPeriodChangeListener(this);
        this.f13673d.setOnActionUpListener(this);
        h();
        b();
    }

    @Override // com.google.android.material.timepicker.c
    public void b() {
        this.g = this.f13674e.getHourForDisplay() * f();
        this.f = this.f13674e.minute * 6;
        a(this.f13674e.selection, false);
        g();
    }

    @Override // com.google.android.material.timepicker.c
    public void c() {
        this.f13673d.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.c
    public void d() {
        this.f13673d.setVisibility(8);
    }

    private String[] e() {
        if (this.f13674e.format != 1) goto L6;
        return f13671b;
    L6:
        return f13670a;
    }

    private int f() {
        if (this.f13674e.format != 1) goto L5;
        return 15;
    L5:
        return 30;
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void onRotate(float r5, boolean r6) {
        if (this.h == false) goto L5;
        return;
    L5:
        int r0 = this.f13674e.hour;
        int r1 = this.f13674e.minute;
        int r7 = Math.round(r5);
        if (this.f13674e.selection != 12) goto L8;
        this.f13674e.setMinute((r7 + 3) / 6);
        this.f = (float) Math.floor(this.f13674e.minute * 6);
    L9:
        if (r6 == true) goto L12;
        g();
        a(r0, r1);
        return;
    L12:
        return;
    L8:
        this.f13674e.setHour((r7 + (f() / 2)) / f());
        this.g = this.f13674e.getHourForDisplay() * f();
        goto L9
    }

    private void a(int r2, int r3) {
        if (this.f13674e.minute != r3) goto L7;
        if (this.f13674e.hour != r2) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        int r4 = 4;
    L10:
        this.f13673d.performHapticFeedback(r4);
        return;
    L9:
        r4 = 1;
        goto L10
    }

    @Override // com.google.android.material.timepicker.TimePickerView.c
    public void a(int r2) {
        a(r2, true);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.b
    public void b(int r1) {
        this.f13674e.setPeriod(r1);
    }

    void a(int r7, boolean r8) {
        if (r7 != 12) goto L5;
        boolean r0 = true;
    L6:
        this.f13673d.setAnimateOnTouchUp(r0);
        this.f13674e.selection = r7;
        TimePickerView r1 = this.f13673d;
        if (r0 == false) goto L9;
        String[] r2 = f13672c;
    L11:
        if (r0 == false) goto L13;
        int r4 = R.string.material_minute_suffix;
        String r5 = "material_minute_suffix";
    L14:
        r1.setValues(r2, ZeusTransformUtils.mapRes(r4, WsChannelMultiProcessSharedProvider.STRING_TYPE, r5));
        TimePickerView r3 = this.f13673d;
        if (r0 == false) goto L17;
        float r6 = this.f;
    L18:
        r3.setHandRotation(r6, r8);
        this.f13673d.setActiveSelection(r7);
        TimePickerView r9 = this.f13673d;
        final Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13673d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final int r11 = ZeusTransformUtils.mapRes(R.string.material_hour_selection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_hour_selection");
        r9.setMinuteHourDelegate(new AnonymousClass1(this, r10, r11));
        TimePickerView r12 = this.f13673d;
        final Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13673d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final int r14 = ZeusTransformUtils.mapRes(R.string.material_minute_selection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_minute_selection");
        r12.setHourClickDelegate(new AnonymousClass2(this, r13, r14));
        return;
    L17:
        r6 = this.g;
        goto L18
    L13:
        r4 = R.string.material_hour_suffix;
        r5 = "material_hour_suffix";
        goto L14
    L9:
        r2 = e();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public void a(float r7, boolean r8) {
        this.h = true;
        int r1 = this.f13674e.minute;
        int r2 = this.f13674e.hour;
        if (this.f13674e.selection != 10) goto L12;
        this.f13673d.setHandRotation(this.g, false);
        AccessibilityManager r9 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13673d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), AccessibilityManager.class), AccessibilityManager.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == true) goto L16;
        a(12, true);
    L16:
        this.h = false;
        g();
        a(r2, r1);
        return;
    L7:
        if (r9.isTouchExplorationEnabled() == false) goto L9;
        r10 = true;
        goto L10
    L12:
        int r11 = Math.round(r7);
        if (r8 == true) goto L15;
        this.f13674e.setMinute(((r11 + 15) / 30) * 5);
        this.f = this.f13674e.minute * 6;
    L15:
        this.f13673d.setHandRotation(this.f, r8);
        goto L16
    }

    private void g() {
        this.f13673d.updateTime(this.f13674e.period, this.f13674e.getHourForDisplay(), this.f13674e.minute);
    }

    private void h() {
        a(f13670a, TimeModel.NUMBER_FORMAT);
        a(f13671b, TimeModel.NUMBER_FORMAT);
        a(f13672c, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void a(String[] r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = TimeModel.formatText(ZeusTransformUtils.getResources(this.f13673d, "com.obric.aiagent.plugin"), r4[r0], r5);
        r0 = r0 + 1;
        goto L4
    }
}

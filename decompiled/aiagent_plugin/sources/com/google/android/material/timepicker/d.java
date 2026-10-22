package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements TimePickerView.c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f13677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeModel f13678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextWatcher f13679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f13680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ChipTextInputComboView f13681e;
    private final ChipTextInputComboView f;
    private final TimePickerTextInputKeyController g;
    private final EditText h;
    private final EditText i;
    private MaterialButtonToggleGroup j;

    static /* synthetic */ TimeModel a(d r0) {
        return r0.f13678b;
    }

    public d(LinearLayout r11, final TimeModel r12) {
        this.f13679c = new TimePickerTextInputPresenter$1(this);
        this.f13680d = new TimePickerTextInputPresenter$2(this);
        this.f13677a = r11;
        this.f13678b = r12;
        Resources r1 = ZeusTransformUtils.getResources(r11, "com.obric.aiagent.plugin");
        ChipTextInputComboView r2 = (ChipTextInputComboView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.material_minute_text_input, DbHelper.COL_ID, "material_minute_text_input")), ChipTextInputComboView.class, "com.obric.aiagent.plugin");
        this.f13681e = r2;
        ChipTextInputComboView r4 = (ChipTextInputComboView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.material_hour_text_input, DbHelper.COL_ID, "material_hour_text_input")), ChipTextInputComboView.class, "com.obric.aiagent.plugin");
        this.f = r4;
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.material_label, DbHelper.COL_ID, "material_label")), TextView.class, "com.obric.aiagent.plugin");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(R.id.material_label, DbHelper.COL_ID, "material_label")), TextView.class, "com.obric.aiagent.plugin");
        r5.setText(r1.getString(ZeusTransformUtils.mapRes(R.string.material_timepicker_minute, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_timepicker_minute")));
        r6.setText(r1.getString(ZeusTransformUtils.mapRes(R.string.material_timepicker_hour, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_timepicker_hour")));
        r2.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, DbHelper.COL_ID, "selection_type"), 12);
        r4.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, DbHelper.COL_ID, "selection_type"), 10);
        if (r12.format != 0) goto L5;
        i();
    L5:
        View.OnClickListener r3 = new TimePickerTextInputPresenter$3(this);
        r4.setOnClickListener(r3);
        r2.setOnClickListener(r3);
        r4.addInputFilter(r12.getHourInputValidator());
        r2.addInputFilter(r12.getMinuteInputValidator());
        EditText r7 = r4.getTextInput().getEditText();
        this.h = r7;
        EditText r8 = r2.getTextInput().getEditText();
        this.i = r8;
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        int r9 = com.google.android.material.color.b.a(r11, ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"));
        a(r7, r9);
        a(r8, r9);
    L8:
        this.g = new TimePickerTextInputKeyController(r4, r2, r12);
        final Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final int r13 = ZeusTransformUtils.mapRes(R.string.material_hour_selection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_hour_selection");
        r4.setChipDelegate(new AnonymousClass1(this, r10, r13, r12));
        final Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        final int r0 = ZeusTransformUtils.mapRes(R.string.material_minute_selection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_minute_selection");
        r2.setChipDelegate(new AnonymousClass2(this, r14, r0, r12));
        a();
    }

    public void a() {
        g();
        a(this.f13678b);
        this.g.bind();
    }

    private void g() {
        this.h.addTextChangedListener(this.f13680d);
        this.i.addTextChangedListener(this.f13679c);
    }

    private void h() {
        this.h.removeTextChangedListener(this.f13680d);
        this.i.removeTextChangedListener(this.f13679c);
    }

    private void a(TimeModel r6) {
        h();
        Locale r0 = ZeusTransformUtils.getResources(this.f13677a, "com.obric.aiagent.plugin").getConfiguration().locale;
        String r2 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.minute)});
        String r7 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.getHourForDisplay())});
        this.f13681e.setText(r2);
        this.f.setText(r7);
        g();
        j();
    }

    private void i() {
        MaterialButtonToggleGroup r0 = (MaterialButtonToggleGroup) ZeusTransformUtils.preCheckCast(this.f13677a.findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_period_toggle, DbHelper.COL_ID, "material_clock_period_toggle")), MaterialButtonToggleGroup.class, "com.obric.aiagent.plugin");
        this.j = r0;
        r0.addOnButtonCheckedListener(new AnonymousClass3(this));
        this.j.setVisibility(0);
        j();
    }

    private void j() {
        MaterialButtonToggleGroup r0 = this.j;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f13678b.period != 0) goto L8;
        int r3 = ZeusTransformUtils.mapRes(R.id.material_clock_period_am_button, DbHelper.COL_ID, "material_clock_period_am_button");
    L9:
        r0.check(r3);
        return;
    L8:
        r3 = ZeusTransformUtils.mapRes(R.id.material_clock_period_pm_button, DbHelper.COL_ID, "material_clock_period_pm_button");
        goto L9
    }

    @Override // com.google.android.material.timepicker.TimePickerView.c
    public void a(int r5) {
        this.f13678b.selection = r5;
        ChipTextInputComboView r0 = this.f13681e;
        boolean r1 = true;
        if (r5 != 12) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        ChipTextInputComboView r2 = this.f;
        if (r5 == 10) goto L10;
        r1 = false;
    L10:
        r2.setChecked(r1);
        j();
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.c
    public void c() {
        this.f13677a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.c
    public void d() {
        View r0 = this.f13677a.getFocusedChild();
        if (r0 != null) goto L6;
        this.f13677a.setVisibility(8);
        return;
    L6:
        InputMethodManager r2 = (InputMethodManager) ZeusTransformUtils.preCheckCast(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13677a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.hideSoftInputFromWindow(r0.getWindowToken(), 0);
    L9:
        this.f13677a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.c
    public void b() {
        a(this.f13678b);
    }

    private static void a(EditText r5, int r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Field r1 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        int r2 = r1.getInt(r5);     // Catch: Throwable -> L5
        Field r3 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        Object r7 = r3.get(r5);     // Catch: Throwable -> L5
        Field r4 = r7.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L5
        r4.setAccessible(true);     // Catch: Throwable -> L5
        Drawable r8 = androidx.appcompat.a.a.a.b(r0, r2);     // Catch: Throwable -> L5
        r8.setColorFilter(r6, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L5
        r4.set(r7, new Drawable[]{r8, r8});     // Catch: Throwable -> L5
        return;
    }

    public void e() {
        ChipTextInputComboView r0 = this.f13681e;
        boolean r2 = true;
        if (this.f13678b.selection != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r3 = this.f;
        if (this.f13678b.selection == 10) goto L10;
        r2 = false;
    L10:
        r3.setChecked(r2);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void f() {
        this.f13681e.setChecked(false);
        this.f.setChecked(false);
    }
}

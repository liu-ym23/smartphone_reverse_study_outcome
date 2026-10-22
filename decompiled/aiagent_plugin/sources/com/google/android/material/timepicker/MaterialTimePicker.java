package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.a {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private c activePresenter;
    private Button cancelButton;
    private final Set<DialogInterface.OnCancelListener> cancelListeners;
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners;
    private int inputMode;
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set<View.OnClickListener> negativeButtonListeners;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private int overrideThemeResId;
    private final Set<View.OnClickListener> positiveButtonListeners;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private ViewStub textInputStub;
    private TimeModel time;
    private b timePickerClockPresenter;
    private d timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId;
    private CharSequence titleText;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TimeModel f13662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f13665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13666e;
        private CharSequence f;
        private int g;
        private CharSequence h;
        private int i;

        static /* synthetic */ TimeModel a(a r0) {
            return r0.f13662a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f13663b;
        }

        static /* synthetic */ int c(a r0) {
            return r0.f13664c;
        }

        static /* synthetic */ CharSequence d(a r0) {
            return r0.f13665d;
        }

        static /* synthetic */ int e(a r0) {
            return r0.f13666e;
        }

        static /* synthetic */ CharSequence f(a r0) {
            return r0.f;
        }

        static /* synthetic */ int g(a r0) {
            return r0.g;
        }

        static /* synthetic */ CharSequence h(a r0) {
            return r0.h;
        }

        static /* synthetic */ int i(a r0) {
            return r0.i;
        }
    }

    public MaterialTimePicker() {
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.positiveButtonTextResId = 0;
        this.negativeButtonTextResId = 0;
        this.inputMode = 0;
        this.overrideThemeResId = 0;
    }

    static /* synthetic */ Set access$1000(MaterialTimePicker r0) {
        return r0.negativeButtonListeners;
    }

    static /* synthetic */ int access$1100(MaterialTimePicker r0) {
        return r0.inputMode;
    }

    static /* synthetic */ int access$1102(MaterialTimePicker r0, int r1) {
        r0.inputMode = r1;
        return r1;
    }

    static /* synthetic */ MaterialButton access$1200(MaterialTimePicker r0) {
        return r0.modeButton;
    }

    static /* synthetic */ void access$1300(MaterialTimePicker r0, MaterialButton r1) {
        r0.updateInputMode(r1);
    }

    static /* synthetic */ MaterialTimePicker access$1400(a r0) {
        return newInstance(r0);
    }

    static /* synthetic */ Set access$900(MaterialTimePicker r0) {
        return r0.positiveButtonListeners;
    }

    private static MaterialTimePicker newInstance(a r4) {
        MaterialTimePicker r0 = new MaterialTimePicker();
        Bundle r1 = new Bundle();
        r1.putParcelable(TIME_MODEL_EXTRA, a.a(r4));
        r1.putInt(INPUT_MODE_EXTRA, a.b(r4));
        r1.putInt(TITLE_RES_EXTRA, a.c(r4));
        if (a.d(r4) == null) goto L5;
        r1.putCharSequence(TITLE_TEXT_EXTRA, a.d(r4));
    L5:
        r1.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, a.e(r4));
        if (a.f(r4) == null) goto L8;
        r1.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, a.f(r4));
    L8:
        r1.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, a.g(r4));
        if (a.h(r4) == null) goto L11;
        r1.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, a.h(r4));
    L11:
        r1.putInt(OVERRIDE_THEME_RES_ID, a.i(r4));
        r0.setArguments(r1);
        return r0;
    }

    public int getMinute() {
        return this.time.minute;
    }

    public void setMinute(int r2) {
        this.time.setMinute(r2);
        c r1 = this.activePresenter;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public void setHour(int r2) {
        this.time.setHour(r2);
        c r1 = this.activePresenter;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r11) {
        Dialog r12 = new Dialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), getThemeResId());
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r1 = com.google.android.material.g.b.a(r0, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable r3 = new MaterialShapeDrawable(r0, null, ZeusTransformUtils.mapRes(R.attr.materialTimePickerStyle, "attr", "materialTimePickerStyle"), ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_TimePicker, "style", "Widget_MaterialComponents_TimePicker"));
        TypedArray r2 = r0.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, ZeusTransformUtils.mapRes(R.attr.materialTimePickerStyle, "attr", "materialTimePickerStyle"), ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_TimePicker, "style", "Widget_MaterialComponents_TimePicker"));
        this.clockIcon = r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialTimePicker_clockIcon, "styleable", "MaterialTimePicker_clockIcon"), 0);
        this.keyboardIcon = r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialTimePicker_keyboardIcon, "styleable", "MaterialTimePicker_keyboardIcon"), 0);
        r2.recycle();
        r3.initializeElevationOverlay(r0);
        r3.setFillColor(ColorStateList.valueOf(r1));
        Window r10 = r12.getWindow();
        r10.setBackgroundDrawable(r3);
        r10.requestFeature(1);
        r10.setLayout(-2, -2);
        r3.setElevation(ViewCompat.q(r10.getDecorView()));
        return r12;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 != null) goto L5;
        r1 = getArguments();
    L5:
        restoreState(r1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable(TIME_MODEL_EXTRA, this.time);
        r3.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r3.putInt(TITLE_RES_EXTRA, this.titleResId);
        r3.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        r3.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        r3.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        r3.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        r3.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        r3.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    private void restoreState(Bundle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        TimeModel r0 = (TimeModel) ZeusTransformUtils.preCheckCast(r4.getParcelable(TIME_MODEL_EXTRA), TimeModel.class, "com.obric.aiagent.plugin");
        this.time = r0;
        if (r0 != null) goto L7;
        this.time = new TimeModel();
    L7:
        this.inputMode = r4.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = r4.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = r4.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = r4.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = r4.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = r4.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = r4.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = r4.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.material_timepicker_dialog, "layout", "material_timepicker_dialog"), r4, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        TimePickerView r7 = (TimePickerView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.material_timepicker_view, DbHelper.COL_ID, "material_timepicker_view")), TimePickerView.class, "com.obric.aiagent.plugin");
        this.timePickerView = r7;
        r7.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.material_textinput_timepicker, DbHelper.COL_ID, "material_textinput_timepicker")), ViewStub.class, "com.obric.aiagent.plugin");
        this.modeButton = (MaterialButton) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.material_timepicker_mode_button, DbHelper.COL_ID, "material_timepicker_mode_button")), MaterialButton.class, "com.obric.aiagent.plugin");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.header_title, DbHelper.COL_ID, "header_title")), TextView.class, "com.obric.aiagent.plugin");
        int r1 = this.titleResId;
        if (r1 == 0) goto L6;
        r8.setText(r1);
    L8:
        updateInputMode(this.modeButton);
        Button r9 = (Button) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.material_timepicker_ok_button, DbHelper.COL_ID, "material_timepicker_ok_button")), Button.class, "com.obric.aiagent.plugin");
        r9.setOnClickListener(new AnonymousClass1(this));
        int r2 = this.positiveButtonTextResId;
        if (r2 == 0) goto L12;
        r9.setText(r2);
    L14:
        Button r10 = (Button) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.material_timepicker_cancel_button, DbHelper.COL_ID, "material_timepicker_cancel_button")), Button.class, "com.obric.aiagent.plugin");
        this.cancelButton = r10;
        r10.setOnClickListener(new AnonymousClass2(this));
        int r11 = this.negativeButtonTextResId;
        if (r11 == 0) goto L18;
        this.cancelButton.setText(r11);
    L20:
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new AnonymousClass3(this));
        return r6;
    L18:
        if (TextUtils.isEmpty(this.negativeButtonText) == true) goto L20;
        this.cancelButton.setText(this.negativeButtonText);
        goto L20
    L12:
        if (TextUtils.isEmpty(this.positiveButtonText) == true) goto L14;
        r9.setText(this.positiveButtonText);
        goto L14
    L6:
        if (TextUtils.isEmpty(this.titleText) == true) goto L8;
        r8.setText(this.titleText);
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView r1 = this.timePickerView;
        if (r1 == null) goto L6;
        r1.setOnDoubleTapListener(null);
        this.timePickerView = null;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.aiagent.plugin");
        Iterator<DialogInterface.OnCancelListener> r0 = this.cancelListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DialogInterface.OnCancelListener) ZeusTransformUtils.preCheckCast(r0.next(), DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin")).onCancel(r6);
        goto L4
    L6:
        super.onCancel(r6);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.aiagent.plugin");
        Iterator<DialogInterface.OnDismissListener> r0 = this.dismissListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(r0.next(), DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin")).onDismiss(r6);
        goto L4
    L6:
        super.onDismiss(r6);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean r1) {
        super.setCancelable(r1);
        updateCancelButtonVisibility();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.a
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.e();
    }

    private void updateInputMode(MaterialButton r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.timePickerView != null) goto L6;
        return;
    L6:
        if (this.textInputStub == null) goto L15;
        c r0 = this.activePresenter;
        if (r0 == null) goto L11;
        r0.d();
    L11:
        c r1 = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter = r1;
        r1.c();
        this.activePresenter.b();
        Pair<Integer, Integer> r2 = dataForMode(this.inputMode);
        r5.setIconResource(((Integer) ZeusTransformUtils.preCheckCast(r2.first, Integer.class, "com.obric.aiagent.plugin")).intValue());
        r5.setContentDescription(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(((Integer) ZeusTransformUtils.preCheckCast(r2.second, Integer.class, "com.obric.aiagent.plugin")).intValue()));
        r5.sendAccessibilityEvent(4);
        return;
    }

    private void updateCancelButtonVisibility() {
        Button r0 = this.cancelButton;
        if (r0 != null) goto L5;
        return;
    L5:
        if (isCancelable() == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    private c initializeOrRetrieveActivePresenterForMode(int r1, TimePickerView r2, ViewStub r3) {
        if (r1 != 0) goto L9;
        b r4 = this.timePickerClockPresenter;
        if (r4 != null) goto L6;
        r4 = new b(r2, this.time);
    L6:
        this.timePickerClockPresenter = r4;
        return r4;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.timePickerTextInputPresenter = new d((LinearLayout) ZeusTransformUtils.preCheckCast(r3.inflate(), LinearLayout.class, "com.obric.aiagent.plugin"), this.time);
    L11:
        this.timePickerTextInputPresenter.f();
        return this.timePickerTextInputPresenter;
    }

    private Pair<Integer, Integer> dataForMode(int r4) {
        if (r4 == 0) goto L11;
        if (r4 != 1) goto L9;
        return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.material_timepicker_clock_mode_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_timepicker_clock_mode_description")));
    L9:
        throw new IllegalArgumentException("no icon for mode: " + r4);
    L11:
        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.material_timepicker_text_input_mode_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_timepicker_text_input_mode_description")));
    }

    b getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    void setActivePresenter(c r3) {
        this.activePresenter = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public boolean addOnPositiveButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        return this.positiveButtonListeners.add(r4);
    }

    public boolean removeOnPositiveButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        return this.positiveButtonListeners.remove(r4);
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        return this.negativeButtonListeners.add(r4);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        return this.negativeButtonListeners.remove(r4);
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r3) {
        DialogInterface.OnCancelListener r4 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
        return this.cancelListeners.add(r4);
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r3) {
        DialogInterface.OnCancelListener r4 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
        return this.cancelListeners.remove(r4);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
        return this.dismissListeners.add(r4);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
        return this.dismissListeners.remove(r4);
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    private int getThemeResId() {
        int r0 = this.overrideThemeResId;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        TypedValue r3 = com.google.android.material.g.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.materialTimePickerTheme, "attr", "materialTimePickerTheme"));
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.data;
    }
}

package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.stepos.aiengine.R;
import java.util.Arrays;
import java.util.Locale;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements k {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f5405a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModel f5406b;

    /* renamed from: c, reason: collision with root package name */
    public final a f5407c;

    /* renamed from: d, reason: collision with root package name */
    public final b f5408d;

    /* renamed from: e, reason: collision with root package name */
    public final ChipTextInputComboView f5409e;
    public final ChipTextInputComboView h;

    /* renamed from: j, reason: collision with root package name */
    public final EditText f5410j;

    /* renamed from: k, reason: collision with root package name */
    public final EditText f5411k;

    /* renamed from: l, reason: collision with root package name */
    public final MaterialButtonToggleGroup f5412l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends com.google.android.material.internal.h {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) throws NumberFormatException {
            try {
                boolean zIsEmpty = TextUtils.isEmpty(editable);
                n nVar = n.this;
                if (zIsEmpty) {
                    nVar.f5406b.setMinute(0);
                } else {
                    nVar.f5406b.setMinute(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends com.google.android.material.internal.h {
        public b() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) throws NumberFormatException {
            try {
                boolean zIsEmpty = TextUtils.isEmpty(editable);
                n nVar = n.this;
                if (zIsEmpty) {
                    nVar.f5406b.setHour(0);
                } else {
                    nVar.f5406b.setHour(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n.this.a(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends com.google.android.material.timepicker.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Resources f5416b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TimeModel f5417c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, Resources resources, TimeModel timeModel) {
            super(context, R.string.material_hour_selection);
            this.f5416b = resources;
            this.f5417c = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f5416b.getString(R.string.material_timepicker_hour));
            sb2.append(" ");
            Resources resources = view.getResources();
            TimeModel timeModel = this.f5417c;
            sb2.append(resources.getString(timeModel.getHourContentDescriptionResId(), String.valueOf(timeModel.getHourForDisplay())));
            bVar.k(sb2.toString());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends com.google.android.material.timepicker.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Resources f5418b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TimeModel f5419c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, Resources resources, TimeModel timeModel) {
            super(context, R.string.material_minute_selection);
            this.f5418b = resources;
            this.f5419c = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.k(this.f5418b.getString(R.string.material_timepicker_minute) + " " + view.getResources().getString(R.string.material_minute_suffix, String.valueOf(this.f5419c.minute)));
        }
    }

    public n(LinearLayout linearLayout, TimeModel timeModel) {
        a aVar = new a();
        this.f5407c = aVar;
        b bVar = new b();
        this.f5408d = bVar;
        this.f5405a = linearLayout;
        this.f5406b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f5409e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.h = chipTextInputComboView2;
        View viewFindViewById = chipTextInputComboView.findViewById(R.id.material_label);
        TextInputLayout textInputLayout = chipTextInputComboView.f5344b;
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = chipTextInputComboView2.findViewById(R.id.material_label);
        TextInputLayout textInputLayout2 = chipTextInputComboView2.f5344b;
        TextView textView2 = (TextView) viewFindViewById2;
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView.setImportantForAccessibility(2);
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        textView2.setImportantForAccessibility(2);
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.format == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R.id.material_clock_period_toggle);
            this.f5412l = materialButtonToggleGroup;
            materialButtonToggleGroup.f4755o.add(new MaterialButtonToggleGroup.b() { // from class: com.google.android.material.timepicker.m
                @Override // com.google.android.material.button.MaterialButtonToggleGroup.b
                public final void a(int i10, boolean z) {
                    if (z) {
                        this.f5404a.f5406b.setPeriod(i10 == R.id.material_clock_period_pm_button ? 1 : 0);
                    }
                }
            });
            this.f5412l.setVisibility(0);
            d();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        g hourInputValidator = timeModel.getHourInputValidator();
        EditText editText = chipTextInputComboView2.f5345c;
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = hourInputValidator;
        editText.setFilters(inputFilterArr);
        g minuteInputValidator = timeModel.getMinuteInputValidator();
        EditText editText2 = chipTextInputComboView.f5345c;
        InputFilter[] filters2 = editText2.getFilters();
        InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(filters2, filters2.length + 1);
        inputFilterArr2[filters2.length] = minuteInputValidator;
        editText2.setFilters(inputFilterArr2);
        EditText editText3 = textInputLayout2.getEditText();
        this.f5410j = editText3;
        editText3.setAccessibilityDelegate(new o(linearLayout.getResources(), R.string.material_timepicker_hour));
        EditText editText4 = textInputLayout.getEditText();
        this.f5411k = editText4;
        editText4.setAccessibilityDelegate(new o(linearLayout.getResources(), R.string.material_timepicker_minute));
        l lVar = new l(chipTextInputComboView2, chipTextInputComboView, timeModel);
        e0.j(chipTextInputComboView2.f5343a, new d(linearLayout.getContext(), resources, timeModel));
        e0.j(chipTextInputComboView.f5343a, new e(linearLayout.getContext(), resources, timeModel));
        editText3.addTextChangedListener(bVar);
        editText4.addTextChangedListener(aVar);
        c(timeModel);
        EditText editText5 = textInputLayout2.getEditText();
        EditText editText6 = textInputLayout.getEditText();
        editText5.setImeOptions(268435461);
        editText6.setImeOptions(268435462);
        editText5.setOnEditorActionListener(lVar);
        editText5.setOnKeyListener(lVar);
        editText6.setOnKeyListener(lVar);
    }

    public final void a(int i10) {
        this.f5406b.selection = i10;
        this.f5409e.setChecked(i10 == 12);
        this.h.setChecked(i10 == 10);
        d();
    }

    public final void b() {
        TimeModel timeModel = this.f5406b;
        this.f5409e.setChecked(timeModel.selection == 12);
        this.h.setChecked(timeModel.selection == 10);
    }

    public final void c(TimeModel timeModel) {
        EditText editText = this.f5410j;
        b bVar = this.f5408d;
        editText.removeTextChangedListener(bVar);
        EditText editText2 = this.f5411k;
        a aVar = this.f5407c;
        editText2.removeTextChangedListener(aVar);
        Locale locale = this.f5405a.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.minute));
        String str2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.getHourForDisplay()));
        ChipTextInputComboView chipTextInputComboView = this.f5409e;
        ChipTextInputComboView.a aVar2 = chipTextInputComboView.f5346d;
        EditText editText3 = chipTextInputComboView.f5345c;
        String text = TimeModel.formatText(chipTextInputComboView.getResources(), str);
        chipTextInputComboView.f5343a.setText(text);
        if (!TextUtils.isEmpty(text)) {
            editText3.removeTextChangedListener(aVar2);
            editText3.setText(text);
            editText3.addTextChangedListener(aVar2);
        }
        ChipTextInputComboView chipTextInputComboView2 = this.h;
        ChipTextInputComboView.a aVar3 = chipTextInputComboView2.f5346d;
        EditText editText4 = chipTextInputComboView2.f5345c;
        String text2 = TimeModel.formatText(chipTextInputComboView2.getResources(), str2);
        chipTextInputComboView2.f5343a.setText(text2);
        if (!TextUtils.isEmpty(text2)) {
            editText4.removeTextChangedListener(aVar3);
            editText4.setText(text2);
            editText4.addTextChangedListener(aVar3);
        }
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(aVar);
        d();
    }

    public final void d() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f5412l;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.f(this.f5406b.period == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button, true);
    }

    @Override // com.google.android.material.timepicker.k
    public final void hide() {
        LinearLayout linearLayout = this.f5405a;
        View focusedChild = linearLayout.getFocusedChild();
        if (focusedChild != null) {
            com.google.android.material.internal.m.a(focusedChild);
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.k
    public final void invalidate() {
        c(this.f5406b);
    }

    @Override // com.google.android.material.timepicker.k
    public final void show() {
        this.f5405a.setVisibility(0);
        a(this.f5406b.selection);
    }
}

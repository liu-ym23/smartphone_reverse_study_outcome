package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.textinputlayout.TextInputLayout;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class StepOSEditInputView extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    private final ContentObserver f14204A;

    /* renamed from: a, reason: collision with root package name */
    private TextView f14205a;

    /* renamed from: b, reason: collision with root package name */
    private View f14206b;

    /* renamed from: c, reason: collision with root package name */
    private View f14207c;

    /* renamed from: d, reason: collision with root package name */
    private View f14208d;

    /* renamed from: e, reason: collision with root package name */
    private TextInputLayout f14209e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f14210f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f14211g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f14212h;

    /* renamed from: i, reason: collision with root package name */
    private final int f14213i;

    /* renamed from: j, reason: collision with root package name */
    private final int f14214j;

    /* renamed from: k, reason: collision with root package name */
    private int f14215k;

    /* renamed from: l, reason: collision with root package name */
    private int f14216l;

    /* renamed from: m, reason: collision with root package name */
    private final String f14217m;

    /* renamed from: n, reason: collision with root package name */
    private final String f14218n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f14219o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f14220p;

    /* renamed from: q, reason: collision with root package name */
    private final int f14221q;

    /* renamed from: r, reason: collision with root package name */
    private final int f14222r;

    /* renamed from: s, reason: collision with root package name */
    private final int f14223s;

    /* renamed from: t, reason: collision with root package name */
    private final int f14224t;

    /* renamed from: u, reason: collision with root package name */
    private final int f14225u;

    /* renamed from: v, reason: collision with root package name */
    private final int f14226v;

    /* renamed from: w, reason: collision with root package name */
    private final int f14227w;

    /* renamed from: x, reason: collision with root package name */
    private int f14228x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f14229y;

    /* renamed from: z, reason: collision with root package name */
    private View.OnClickListener f14230z;

    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            super.onChange(z5);
            StepOSEditInputView.this.c();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StepOSEditInputView.this.f14207c.setSelected(!StepOSEditInputView.this.f14207c.isSelected());
            StepOSEditInputView stepOSEditInputView = StepOSEditInputView.this;
            stepOSEditInputView.setEditTextPasswordState(stepOSEditInputView.f14207c.isSelected());
            StepOSEditInputView.this.d(view);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StepOSEditInputView.this.d(view);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StepOSEditInputView.this.g();
            StepOSEditInputView.this.d(view);
        }
    }

    class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            StepOSEditInputView.this.e();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }
    }

    public StepOSEditInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void b() {
        EditText editText = this.f14210f;
        if (editText == null || this.f14211g == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f14211g.getLayoutParams();
            layoutParams3.topMargin = layoutParams2.topMargin;
            layoutParams3.bottomMargin = layoutParams2.bottomMargin;
            layoutParams3.leftMargin = layoutParams2.leftMargin;
            layoutParams3.rightMargin = layoutParams2.rightMargin;
            this.f14211g.setLayoutParams(layoutParams3);
        }
    }

    protected void c() {
        TextInputLayout textInputLayout = this.f14209e;
        boolean z5 = textInputLayout != null && textInputLayout.j();
        if (p()) {
            EditText editText = this.f14210f;
            if (editText != null && !z5 && this.f14215k != 0) {
                editText.setBackground(androidx.core.content.a.e(getContext(), this.f14215k));
            }
            TextInputLayout textInputLayout2 = this.f14209e;
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorBackgroundResource(this.f14216l);
                this.f14209e.setOriginBackgroundResource(this.f14215k);
                return;
            }
            return;
        }
        EditText editText2 = this.f14210f;
        if (editText2 != null && !z5 && this.f14214j != 0) {
            editText2.setBackground(androidx.core.content.a.e(getContext(), this.f14214j));
        }
        TextInputLayout textInputLayout3 = this.f14209e;
        if (textInputLayout3 != null) {
            textInputLayout3.setErrorBackgroundResource(this.f14213i);
            this.f14209e.setOriginBackgroundResource(this.f14214j);
        }
    }

    protected void d(View view) {
        View.OnClickListener onClickListener = this.f14230z;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    protected void e() {
        View view = this.f14206b;
        if (view == null) {
            f();
            return;
        }
        if (this.f14220p) {
            view.setVisibility(this.f14210f.length() > 0 ? 0 : 8);
        } else {
            view.setVisibility(8);
        }
        f();
    }

    protected void f() {
        View view;
        if (this.f14208d == null) {
            return;
        }
        View view2 = this.f14206b;
        if (view2 == null || view2.getVisibility() != 0 || (view = this.f14207c) == null || view.getVisibility() != 0) {
            this.f14208d.setVisibility(8);
        } else {
            this.f14208d.setVisibility(0);
        }
    }

    protected void g() {
        EditText editText = this.f14210f;
        if (editText != null) {
            editText.setText(BuildConfig.FLAVOR);
        }
    }

    public View getCleanView() {
        return this.f14206b;
    }

    public EditText getEditText() {
        return this.f14210f;
    }

    public int getInputViewContentPaddingEnd() {
        return this.f14224t;
    }

    public int getInputViewContentPaddingStart() {
        return this.f14223s;
    }

    public View getPasswordSwitchView() {
        return this.f14207c;
    }

    public TextInputLayout getTextInputLayout() {
        return this.f14209e;
    }

    public TextView getTitleView() {
        return this.f14205a;
    }

    public <T extends View> T h(int i5) {
        return (T) findViewById(i5);
    }

    protected void i(Context context, int i5) {
        this.f14229y = context.getResources().getConfiguration().getLayoutDirection() == 1;
        LayoutInflater.from(context).inflate(i5, (ViewGroup) this, true);
        this.f14205a = (TextView) findViewById(H1.h.f2262m0);
        this.f14210f = (EditText) findViewById(H1.h.f2254i0);
        this.f14209e = (TextInputLayout) findViewById(H1.h.f2260l0);
        this.f14206b = findViewById(H1.h.f2252h0);
        this.f14207c = findViewById(H1.h.f2258k0);
        this.f14208d = findViewById(H1.h.f2269q);
        this.f14211g = (ViewGroup) findViewById(H1.h.f2256j0);
        N1.a.e(this, 2);
        if (this.f14209e != null) {
            n();
        }
        if (this.f14210f != null) {
            k();
        }
        if (this.f14211g != null) {
            l();
        }
        View view = this.f14206b;
        if (view != null) {
            view.setVisibility(this.f14220p ? 0 : 8);
            j();
        }
        View view2 = this.f14207c;
        if (view2 != null) {
            view2.setVisibility(this.f14219o ? 0 : 8);
            m();
        }
        if (this.f14205a != null) {
            o();
        }
        c();
        f();
        if (this.f14229y) {
            this.f14210f.setTextDirection(4);
        }
    }

    protected void j() {
        e();
        this.f14206b.setOnClickListener(new d());
    }

    protected void k() {
        TextInputLayout textInputLayout = this.f14209e;
        if (textInputLayout == null || !textInputLayout.getLabelEnable()) {
            this.f14210f.setHint(this.f14217m);
        }
        if (this.f14226v != -1) {
            this.f14210f.setTextAppearance(getContext(), this.f14226v);
        }
        int i5 = this.f14227w;
        if (i5 != -1) {
            this.f14210f.setHintTextColor(i5);
        }
        Typeface typeface = this.f14210f.getTypeface();
        if (this.f14210f.getPaddingBottom() != this.f14210f.getPaddingTop()) {
            this.f14210f.setPaddingRelative(this.f14221q, 0, this.f14222r, 0);
        } else {
            EditText editText = this.f14210f;
            editText.setPaddingRelative(this.f14221q, editText.getPaddingTop(), this.f14222r, this.f14210f.getPaddingBottom());
        }
        this.f14210f.setInputType(this.f14228x);
        this.f14210f.setTypeface(typeface);
        this.f14210f.setBackgroundResource(this.f14214j);
        this.f14210f.addTextChangedListener(new e());
    }

    protected void l() {
        ViewGroup viewGroup = this.f14211g;
        viewGroup.setPaddingRelative(this.f14223s, viewGroup.getPaddingTop(), this.f14224t, this.f14211g.getPaddingBottom());
    }

    protected void m() {
        this.f14207c.setSelected(false);
        this.f14207c.setOnClickListener(new b());
    }

    protected void n() {
        this.f14209e.setErrorBackgroundResource(this.f14213i);
        this.f14209e.setHint(this.f14217m);
        this.f14209e.setLabelPaddingHorizontal(this.f14223s);
        this.f14209e.setErrorPaddingHorizontal(this.f14223s);
        this.f14209e.setLabelEnable(false);
    }

    protected void o() {
        Drawable drawable = this.f14212h;
        if (drawable != null) {
            if (this.f14229y) {
                this.f14205a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else {
                this.f14205a.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.f14205a.setTextAppearance(getContext(), this.f14225u);
        this.f14205a.setText(this.f14218n);
        this.f14205a.setOnClickListener(new c());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        b();
    }

    protected boolean p() {
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) {
            return "#262626".equals(Settings.Global.getString(getContext().getContentResolver(), "stepos_dark_mode_preference_color"));
        }
        return false;
    }

    protected void q() {
        Uri uriFor = Settings.Global.getUriFor("stepos_dark_mode_preference_color");
        Uri uriFor2 = Settings.Global.getUriFor("steposlab_stepos_night_mode");
        getContext().getContentResolver().registerContentObserver(uriFor, false, this.f14204A);
        getContext().getContentResolver().registerContentObserver(uriFor2, false, this.f14204A);
    }

    protected void r() {
        getContext().getContentResolver().unregisterContentObserver(this.f14204A);
    }

    protected void setEditTextPasswordState(boolean z5) {
        EditText editText = this.f14210f;
        if (editText == null) {
            return;
        }
        Typeface typeface = editText.getTypeface();
        if (z5) {
            this.f14228x = 145;
        } else {
            this.f14228x = 129;
        }
        this.f14210f.setInputType(this.f14228x);
        this.f14210f.setTypeface(typeface);
        EditText editText2 = this.f14210f;
        editText2.setSelection(editText2.getText().length());
    }

    public void setOnViewClickedListener(View.OnClickListener onClickListener) {
        this.f14230z = onClickListener;
    }

    public StepOSEditInputView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14204A = new a(getHandler());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2486Q4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2510U4, H1.i.f2303Q);
        this.f14217m = typedArrayObtainStyledAttributes.getString(H1.m.f2498S4);
        this.f14218n = typedArrayObtainStyledAttributes.getString(H1.m.g5);
        this.f14212h = typedArrayObtainStyledAttributes.getDrawable(H1.m.h5);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2534Y4, 0);
        this.f14213i = resourceId2;
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2554b5, 0);
        this.f14214j = resourceId3;
        this.f14215k = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2575e5, resourceId3);
        this.f14216l = typedArrayObtainStyledAttributes.getResourceId(H1.m.f5, resourceId2);
        this.f14219o = typedArrayObtainStyledAttributes.getBoolean(H1.m.f2561c5, false);
        this.f14220p = typedArrayObtainStyledAttributes.getBoolean(H1.m.f2568d5, false);
        this.f14228x = typedArrayObtainStyledAttributes.getInt(H1.m.f2504T4, 131073);
        this.f14223s = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2547a5, 0);
        this.f14224t = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2540Z4, 0);
        this.f14221q = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2522W4, 0);
        this.f14222r = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2516V4, 0);
        this.f14225u = typedArrayObtainStyledAttributes.getResourceId(H1.m.i5, -1);
        this.f14226v = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2528X4, -1);
        this.f14227w = typedArrayObtainStyledAttributes.getColor(H1.m.f2492R4, -1);
        typedArrayObtainStyledAttributes.recycle();
        i(context, resourceId);
    }
}

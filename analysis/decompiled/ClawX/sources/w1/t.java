package w1;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.R;
import g.g0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6169a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f6170b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f6171c;
    public final CheckableImageButton d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f6172e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f6173f;

    /* renamed from: g, reason: collision with root package name */
    public int f6174g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f6175h;

    /* renamed from: j, reason: collision with root package name */
    public View.OnLongClickListener f6176j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6177k;

    public t(TextInputLayout textInputLayout, a4.d dVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f6169a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        g0 g0Var = new g0(getContext(), null);
        this.f6170b = g0Var;
        if (k4.v.W(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f6176j;
        checkableImageButton.setOnClickListener(null);
        k4.v.k0(checkableImageButton, onLongClickListener);
        this.f6176j = null;
        checkableImageButton.setOnLongClickListener(null);
        k4.v.k0(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) dVar.f97c;
        if (typedArray.hasValue(70)) {
            this.f6172e = k4.v.C(getContext(), dVar, 70);
        }
        if (typedArray.hasValue(71)) {
            this.f6173f = p1.k.f(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            b(dVar.t(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f6174g) {
            this.f6174g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType scaleTypeT = k4.v.t(typedArray.getInt(69, -1));
            this.f6175h = scaleTypeT;
            checkableImageButton.setScaleType(scaleTypeT);
        }
        g0Var.setVisibility(8);
        g0Var.setId(R.id.textinput_prefix_text);
        g0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        g0Var.setAccessibilityLiveRegion(1);
        g0Var.setTextAppearance(typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            g0Var.setTextColor(dVar.s(62));
        }
        CharSequence text2 = typedArray.getText(60);
        this.f6171c = TextUtils.isEmpty(text2) ? null : text2;
        g0Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(g0Var);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f6170b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f6172e;
            PorterDuff.Mode mode = this.f6173f;
            TextInputLayout textInputLayout = this.f6169a;
            k4.v.e(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            k4.v.f0(textInputLayout, checkableImageButton, this.f6172e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f6176j;
        checkableImageButton.setOnClickListener(null);
        k4.v.k0(checkableImageButton, onLongClickListener);
        this.f6176j = null;
        checkableImageButton.setOnLongClickListener(null);
        k4.v.k0(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f6169a.f1359e;
        if (editText == null) {
            return;
        }
        this.f6170b.setPaddingRelative(this.d.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i8 = (this.f6171c == null || this.f6177k) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i8 == 0) ? 0 : 8);
        this.f6170b.setVisibility(i8);
        this.f6169a.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        d();
    }
}

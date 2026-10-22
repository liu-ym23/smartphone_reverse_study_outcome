package cb;

import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.k;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class i extends ConstraintLayout implements Checkable {

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f2247l0 = {R.attr.state_checked};
    public int A;
    public g B;
    public boolean C;
    public boolean D;
    public float[] E;
    public int F;
    public boolean G;
    public float H;
    public Integer I;
    public boolean J;
    public boolean K;
    public boolean L;
    public eb.a M;
    public Object N;
    public TextView O;
    public View P;
    public ImageView Q;
    public boolean R;
    public int S;
    public Integer T;
    public boolean U;
    public int V;
    public Integer W;

    /* renamed from: a0, reason: collision with root package name */
    public int f2248a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f2249b0;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f2250c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2251d0;
    public ColorStateList e0;
    public boolean f0;

    /* renamed from: g0, reason: collision with root package name */
    public final za.a f2252g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f2253h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f2254i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f2255j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f2256k0;

    /* renamed from: w, reason: collision with root package name */
    public final ya.a f2257w;

    /* renamed from: x, reason: collision with root package name */
    public int f2258x;

    /* renamed from: y, reason: collision with root package name */
    public int f2259y;

    /* renamed from: z, reason: collision with root package name */
    public int f2260z;

    /* JADX WARN: Illegal instructions before constructor call */
    public i(Context context, AttributeSet attributeSet, int i, int i3, yb.f fVar) {
        attributeSet = (i3 & 2) != 0 ? null : attributeSet;
        i = (i3 & 4) != 0 ? com.stepos.agentsafetycenter.R.attr.steposListItemStyle : i;
        context.getClass();
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(com.stepos.agentsafetycenter.R.layout.stepos_list_item, this);
        int i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_accessory;
        ImageView imageView = (ImageView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_accessory);
        if (imageView != null) {
            i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_badge;
            View viewR = id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_badge);
            if (viewR != null) {
                i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_leading_icon;
                ImageView imageView2 = (ImageView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_leading_icon);
                if (imageView2 != null) {
                    i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_right_badge;
                    View viewR2 = id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_right_badge);
                    if (viewR2 != null) {
                        i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_subtitle;
                        TextView textView = (TextView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_subtitle);
                        if (textView != null) {
                            i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_title;
                            TextView textView2 = (TextView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_title);
                            if (textView2 != null) {
                                i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_title_end;
                                TextView textView3 = (TextView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_title_end);
                                if (textView3 != null) {
                                    i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_trailing;
                                    FrameLayout frameLayout = (FrameLayout) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_trailing);
                                    if (frameLayout != null) {
                                        i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_trailing_barrier;
                                        if (((Barrier) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_trailing_barrier)) != null) {
                                            i10 = com.stepos.agentsafetycenter.R.id.stepos_list_item_value;
                                            TextView textView4 = (TextView) id.c.r(this, com.stepos.agentsafetycenter.R.id.stepos_list_item_value);
                                            if (textView4 != null) {
                                                ya.a aVar = new ya.a();
                                                aVar.f16067a = imageView;
                                                aVar.f16068b = viewR;
                                                aVar.f16069c = imageView2;
                                                aVar.f16070d = viewR2;
                                                aVar.f16071e = textView;
                                                aVar.f16072f = textView2;
                                                aVar.f16073g = textView3;
                                                aVar.f16074h = frameLayout;
                                                aVar.i = textView4;
                                                VarHandle.storeStoreFence();
                                                this.f2257w = aVar;
                                                this.C = true;
                                                this.D = true;
                                                this.J = true;
                                                this.K = true;
                                                this.V = 1;
                                                this.f2249b0 = 1;
                                                this.f2252g0 = new za.a();
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xa.a.f15600c, i, com.stepos.agentsafetycenter.R.style.StepOSWidget_ListItem);
                                                try {
                                                    typedArrayObtainStyledAttributes.getClass();
                                                    s(this, typedArrayObtainStyledAttributes);
                                                    t2.a.h(typedArrayObtainStyledAttributes, null);
                                                    return;
                                                } finally {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        g5.f.g("Missing required view with ID: ".concat(getResources().getResourceName(i10)));
        throw null;
    }

    public static void A(ImageView imageView, int i, int i3) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i3;
        imageView.setLayoutParams(layoutParams);
    }

    private final View getBadgeView() {
        return this.f2257w.f16068b;
    }

    public static final c getImageLoader() {
        return null;
    }

    private final View getRightBadgeView() {
        return this.f2257w.f16070d;
    }

    private final FrameLayout getTrailingContainer() {
        return this.f2257w.f16074h;
    }

    public static void s(i iVar, TypedArray typedArray) throws IllegalAccessException, NoSuchMethodException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CharSequence charSequence;
        za.a aVar = iVar.f2252g0;
        Resources resources = iVar.getResources();
        int dimensionPixelSize = typedArray.getDimensionPixelSize(22, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_height));
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(23, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_padding_start));
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(24, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_padding_vertical));
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(18, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_text_gap));
        iVar.f2259y = typedArray.getDimensionPixelSize(44, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_value_gap));
        iVar.f2260z = resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_content_gap);
        iVar.f2258x = dimensionPixelSize4;
        int resourceId = typedArray.getResourceId(41, 0);
        if (resourceId != 0) {
            iVar.getTitleView().setTextAppearance(resourceId);
        }
        iVar.e0 = iVar.getTitleView().getTextColors();
        int resourceId2 = typedArray.getResourceId(36, 0);
        if (resourceId2 != 0) {
            iVar.getSubtitleView().setTextAppearance(resourceId2);
        }
        int resourceId3 = typedArray.getResourceId(45, 0);
        if (resourceId3 != 0) {
            iVar.getValueView().setTextAppearance(resourceId3);
        }
        int i = typedArray.getInt(35, 1);
        TextView subtitleView = iVar.getSubtitleView();
        if (i < 1) {
            i = 1;
        }
        subtitleView.setMaxLines(i);
        iVar.setTitle(typedArray.getText(38));
        iVar.setTitleEndText(typedArray.getText(39));
        iVar.setSubtitle(typedArray.getText(34));
        CharSequence text = typedArray.getText(29);
        if (text == null) {
            text = typedArray.getText(43);
        }
        iVar.setValueText(text);
        iVar.I = typedArray.hasValue(14) ? Integer.valueOf(typedArray.getColor(14, 0)) : null;
        Drawable drawable = typedArray.getDrawable(13);
        if (drawable != null) {
            iVar.getIconView().setImageDrawable(drawable);
        }
        if (typedArray.hasValue(19)) {
            iVar.getIconView().setImageTintList(typedArray.getColorStateList(19));
        }
        iVar.K = typedArray.getBoolean(20, true);
        iVar.setIconStyle(typedArray.getInt(17, 0));
        if (typedArray.hasValue(16)) {
            iVar.setIconSize(typedArray.getDimensionPixelSize(16, 0));
        }
        if (typedArray.hasValue(15)) {
            iVar.setIconCornerRadius(typedArray.getDimension(15, 0.0f));
        }
        iVar.S = typedArray.getInt(3, 0);
        if (typedArray.hasValue(4)) {
            iVar.T = Integer.valueOf(typedArray.getColor(4, 0));
        }
        iVar.R = typedArray.getBoolean(31, false);
        iVar.V = typedArray.getInt(26, 1);
        if (typedArray.hasValue(27)) {
            iVar.W = Integer.valueOf(typedArray.getColor(27, 0));
        }
        iVar.U = typedArray.getBoolean(33, false);
        iVar.J = typedArray.getBoolean(30, true);
        Drawable drawable2 = typedArray.getDrawable(28);
        if (drawable2 == null) {
            drawable2 = typedArray.getDrawable(0);
        }
        if (drawable2 != null) {
            iVar.getAccessoryView().setImageDrawable(drawable2);
        }
        if (typedArray.hasValue(2)) {
            iVar.getAccessoryView().setImageTintList(typedArray.getColorStateList(2));
        }
        int dimensionPixelSize5 = typedArray.getDimensionPixelSize(1, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_accessory_size));
        A(iVar.getAccessoryView(), dimensionPixelSize5, dimensionPixelSize5);
        iVar.f2249b0 = typedArray.getInt(42, 1);
        CharSequence text2 = typedArray.getText(5);
        if (text2 != null) {
            iVar.f2250c0 = text2;
        }
        iVar.f2248a0 = typedArray.getInt(21, 0);
        iVar.f2251d0 = typedArray.getInt(40, 0);
        boolean z10 = typedArray.getBoolean(6, false);
        iVar.setSwitchChecked(typedArray.getBoolean(37, false));
        iVar.C = typedArray.getBoolean(25, false);
        Drawable drawable3 = typedArray.hasValue(12) ? typedArray.getDrawable(12) : null;
        iVar.f0 = typedArray.getBoolean(32, false);
        aVar.f16572a = typedArray.getDimensionPixelSize(9, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_divider_height));
        aVar.f16574c = typedArray.getDimensionPixelSize(11, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_divider_inset_start));
        aVar.f16575d = typedArray.getDimensionPixelSize(10, resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_divider_inset_end));
        aVar.f16573b = typedArray.getColor(8, iVar.getContext().getColor(com.stepos.agentsafetycenter.R.color.stepos_divider));
        iVar.setPaddingRelative(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        iVar.A = dimensionPixelSize3;
        iVar.setMinimumHeight(dimensionPixelSize);
        iVar.setClipChildren(false);
        iVar.o();
        iVar.B();
        iVar.setBackground(k.v(com.stepos.agentsafetycenter.R.drawable.stepos_bg_list_item_selector, iVar.getContext()));
        iVar.setForeground(drawable3);
        iVar.setStateListAnimator(iVar.C ? AnimatorInflater.loadStateListAnimator(iVar.getContext(), com.stepos.agentsafetycenter.R.animator.stepos_list_item_press) : null);
        iVar.h();
        iVar.p();
        iVar.setLineMode(iVar.f2248a0);
        iVar.t();
        iVar.setTrailingType(iVar.f2249b0);
        if (iVar.f2249b0 == 3 && (charSequence = iVar.f2250c0) != null) {
            iVar.f2250c0 = charSequence;
            TextView textViewW = iVar.w();
            textViewW.setText(charSequence);
            textViewW.setOnClickListener(null);
            iVar.setTrailingType(3);
        }
        iVar.setChecked(z10);
    }

    public static void z(i iVar, boolean z10) {
        za.a aVar = iVar.f2252g0;
        int dividerInsetStart = aVar.f16574c;
        int i = aVar.f16575d;
        iVar.f0 = z10;
        aVar.f16575d = i;
        if (z10) {
            dividerInsetStart = iVar.getDividerInsetStart();
        }
        aVar.f16574c = dividerInsetStart;
        iVar.invalidate();
    }

    public final void B() {
        getIconView().setVisibility((!this.K || getIconView().getDrawable() == null) ? 8 : 0);
        p();
        y();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        canvas.getClass();
        super.dispatchDraw(canvas);
        if (this.f0) {
            if (this.D && (isPressed() || this.f2253h0)) {
                return;
            }
            int height = getHeight();
            za.a.a(this.f2252g0, canvas, height - r1.f16572a, getWidth(), getLayoutDirection());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r5 = this;
            super.drawableStateChanged()
            boolean r0 = r5.isPressed()
            boolean r1 = r5.f2254i0
            if (r0 != r1) goto Ld
            goto La1
        Ld:
            r5.f2254i0 = r0
            boolean r1 = r5.D
            if (r1 != 0) goto L15
            goto La1
        L15:
            r5.invalidate()
            android.view.ViewParent r1 = r5.getParent()
            boolean r2 = r1 instanceof androidx.recyclerview.widget.RecyclerView
            r3 = 0
            r4 = 2131362666(0x7f0a036a, float:1.834512E38)
            if (r2 == 0) goto L4e
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            int r2 = r1.getChildAdapterPosition(r5)
            if (r2 > 0) goto L2e
        L2c:
            r2 = r3
            goto L7b
        L2e:
            int r2 = r2 + (-1)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.findViewHolderForAdapterPosition(r2)
            if (r1 == 0) goto L2c
            android.view.View r1 = r1.itemView
            if (r1 != 0) goto L3b
            goto L2c
        L3b:
            boolean r2 = r1 instanceof cb.i
            if (r2 == 0) goto L43
            r2 = r1
            cb.i r2 = (cb.i) r2
            goto L44
        L43:
            r2 = r3
        L44:
            if (r2 != 0) goto L7b
            android.view.View r1 = r1.findViewById(r4)
            r2 = r1
            cb.i r2 = (cb.i) r2
            goto L7b
        L4e:
            boolean r2 = r1 instanceof cb.b
            if (r2 == 0) goto L53
            goto L2c
        L53:
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L2c
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.indexOfChild(r5)
            if (r2 > 0) goto L60
            goto L2c
        L60:
            int r2 = r2 + (-1)
            android.view.View r1 = r1.getChildAt(r2)
            if (r1 != 0) goto L69
            goto L2c
        L69:
            boolean r2 = r1 instanceof cb.i
            if (r2 == 0) goto L71
            r2 = r1
            cb.i r2 = (cb.i) r2
            goto L72
        L71:
            r2 = r3
        L72:
            if (r2 != 0) goto L7b
            android.view.View r1 = r1.findViewById(r4)
            r2 = r1
            cb.i r2 = (cb.i) r2
        L7b:
            if (r2 == 0) goto L80
            r2.setNeighborBelowPressed$StepOSWidget_release(r0)
        L80:
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r0 instanceof cb.b
            if (r1 == 0) goto L8b
            cb.b r0 = (cb.b) r0
            goto L8c
        L8b:
            r0 = r3
        L8c:
            if (r0 == 0) goto L91
            r0.invalidate()
        L91:
            android.view.ViewParent r5 = r5.getParent()
            boolean r0 = r5 instanceof androidx.recyclerview.widget.RecyclerView
            if (r0 == 0) goto L9c
            r3 = r5
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
        L9c:
            if (r3 == 0) goto La1
            r3.invalidate()
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cb.i.drawableStateChanged():void");
    }

    public final void g(View view, boolean z10, int i, Integer num) {
        int color;
        if (!z10) {
            view.setVisibility(8);
            return;
        }
        if (num != null) {
            color = num.intValue();
        } else {
            color = getContext().getColor(i == 1 ? com.stepos.agentsafetycenter.R.color.stepos_list_item_badge_red : com.stepos.agentsafetycenter.R.color.stepos_list_item_badge_blue);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
        view.setImportantForAccessibility(2);
        view.setVisibility(0);
    }

    public final ImageView getAccessoryView() {
        return this.f2257w.f16067a;
    }

    public final int getBadgeStyle() {
        return this.S;
    }

    public final Integer getBadgeTint() {
        return this.T;
    }

    public final int getDividerInsetStart() {
        int paddingStart = getPaddingStart();
        int dimensionPixelSize = getBadgeView().getVisibility() == 0 ? getResources().getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_badge_size) + this.f2258x : 0;
        if (getIconView().getVisibility() == 0) {
            int i = getIconView().getLayoutParams().width;
            dimensionPixelSize = dimensionPixelSize + (i >= 0 ? i : 0) + this.f2258x;
        }
        return paddingStart + dimensionPixelSize;
    }

    public final int getIconStyle() {
        return this.f2255j0;
    }

    public final ImageView getIconView() {
        return this.f2257w.f16069c;
    }

    public final int getLineMode() {
        return this.f2248a0;
    }

    public final boolean getPressFeedbackEnabled() {
        return this.D;
    }

    public final boolean getReservesCheckSlot() {
        return this.G;
    }

    public final int getRightBadgeStyle() {
        return this.V;
    }

    public final Integer getRightBadgeTint() {
        return this.W;
    }

    public final CharSequence getRightText() {
        return getValueText();
    }

    public final boolean getShowBadge() {
        return this.R;
    }

    public final boolean getShowIcon() {
        return this.K;
    }

    public final boolean getShowRightBadge() {
        return this.U;
    }

    public final CharSequence getSubtitle() {
        return getSubtitleView().getText();
    }

    public final TextView getSubtitleView() {
        return this.f2257w.f16071e;
    }

    public final boolean getSwitchChecked() {
        eb.a aVar = this.M;
        if (aVar != null) {
            return aVar.isChecked();
        }
        return false;
    }

    public final Object getSwitchHapticFeedbackOwner$StepOSWidget_release() {
        return this.N;
    }

    public final CharSequence getTitle() {
        return getTitleView().getText();
    }

    public final CharSequence getTitleEndText() {
        return getTitleEndView().getText();
    }

    public final TextView getTitleEndView() {
        return this.f2257w.f16073g;
    }

    public final int getTitleStyle() {
        return this.f2251d0;
    }

    public final TextView getTitleView() {
        return this.f2257w.f16072f;
    }

    public final int getTrailingType() {
        return this.f2249b0;
    }

    public final CharSequence getValueText() {
        return getValueView().getText();
    }

    public final TextView getValueView() {
        return this.f2257w.i;
    }

    public final void h() {
        g(getBadgeView(), this.R, this.S, this.T);
        g(getRightBadgeView(), this.U, this.V, this.W);
        p();
        u();
        y();
    }

    public final void i(float[] fArr, int i, int i3, int i10) {
        setPressScaleEnabled(false);
        this.E = (float[]) fArr.clone();
        this.F = i;
        Context context = getContext();
        context.getClass();
        setBackground(k.f(context, fArr, i, this.D));
        setForeground(null);
        z(this, false);
        setPaddingRelative(getPaddingStart(), this.A + i3, getPaddingEnd(), this.A + i10);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r5.H >= ((java.lang.Math.min(r3, r0) / 2.0f) - 0.5f)) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            r5 = this;
            java.lang.Integer r0 = r5.I
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L32
            android.widget.ImageView r3 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r4 = new android.graphics.drawable.GradientDrawable
            r4.<init>()
            r4.setShape(r2)
            float r2 = r5.H
            r4.setCornerRadius(r2)
            int r0 = r0.intValue()
            r4.setColor(r0)
            r3.setBackground(r4)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        L32:
            int r0 = r5.f2255j0
            r3 = 3
            if (r0 != r3) goto L38
            goto L5d
        L38:
            android.widget.ImageView r0 = r5.getIconView()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L43
            goto L85
        L43:
            int r3 = r0.width
            int r0 = r0.height
            if (r3 <= 0) goto L85
            if (r0 > 0) goto L4c
            goto L85
        L4c:
            float r4 = r5.H
            int r0 = java.lang.Math.min(r3, r0)
            float r0 = (float) r0
            r3 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 - r3
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L85
        L5d:
            android.widget.ImageView r0 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setShape(r2)
            float r4 = r5.H
            r3.setCornerRadius(r4)
            r3.setColor(r2)
            r0.setBackground(r3)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        L85:
            int r0 = r5.f2255j0
            r3 = 4
            if (r0 == r3) goto La7
            r3 = 5
            if (r0 != r3) goto L8e
            goto La7
        L8e:
            android.widget.ImageView r0 = r5.getIconView()
            r1 = 0
            r0.setBackground(r1)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r2)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_CENTER
            r5.setScaleType(r0)
            return
        La7:
            android.widget.ImageView r0 = r5.getIconView()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setShape(r2)
            float r4 = r5.H
            r3.setCornerRadius(r4)
            r3.setColor(r2)
            r0.setBackground(r3)
            android.widget.ImageView r0 = r5.getIconView()
            r0.setClipToOutline(r1)
            android.widget.ImageView r5 = r5.getIconView()
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r5.setScaleType(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cb.i.o():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.L) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2247l0);
        }
        iArrOnCreateDrawableState.getClass();
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2253h0 = false;
        this.f2254i0 = false;
    }

    public final void p() {
        boolean z10 = getBadgeView().getVisibility() == 0;
        boolean z11 = getIconView().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getBadgeView().getLayoutParams();
        layoutParams.getClass();
        z2.d dVar = (z2.d) layoutParams;
        dVar.setMarginEnd((z10 && z11) ? this.f2258x : 0);
        getBadgeView().setLayoutParams(dVar);
        ViewGroup.LayoutParams layoutParams2 = getTitleView().getLayoutParams();
        layoutParams2.getClass();
        z2.d dVar2 = (z2.d) layoutParams2;
        if (z11) {
            dVar2.f16222s = getIconView().getId();
            dVar2.f16223t = -1;
            dVar2.setMarginStart(this.f2258x);
        } else if (z10) {
            dVar2.f16222s = getBadgeView().getId();
            dVar2.f16223t = -1;
            dVar2.setMarginStart(this.f2258x);
        } else {
            dVar2.f16222s = -1;
            dVar2.f16223t = 0;
            dVar2.setMarginStart(0);
        }
        getTitleView().setLayoutParams(dVar2);
    }

    public final void r() {
        CharSequence text = getSubtitleView().getText();
        TextView subtitleView = getSubtitleView();
        int i = this.f2248a0;
        int i3 = 8;
        if (i != 1 && (i == 2 || (text != null && text.length() != 0))) {
            i3 = 0;
        }
        subtitleView.setVisibility(i3);
    }

    public final void setAccessoryIcon(Drawable drawable) throws Resources.NotFoundException {
        getAccessoryView().setImageDrawable(drawable);
        v(this.f2249b0);
    }

    public final void setAccessorySize(int i) {
        A(getAccessoryView(), i, i);
    }

    public final void setAccessorySource(Object obj) throws Resources.NotFoundException {
        getAccessoryView().setImageDrawable(null);
        v(this.f2249b0);
    }

    public final void setAccessoryTint(ColorStateList colorStateList) {
        getAccessoryView().setImageTintList(colorStateList);
    }

    public final void setBadgeStyle(int i) {
        this.S = i;
        h();
    }

    public final void setBadgeTint(Integer num) {
        this.T = num;
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) throws Resources.NotFoundException {
        if (this.L == z10) {
            return;
        }
        this.L = z10;
        v(this.f2249b0);
    }

    public final void setDividerColor(int i) {
        this.f2252g0.f16573b = i;
        invalidate();
    }

    public final void setDividerInsetStart(int i) {
        if (i < 0) {
            i = getDividerInsetStart();
        }
        this.f2252g0.f16574c = i;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        setAlpha(z10 ? 1.0f : 0.3f);
    }

    public final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
        B();
    }

    public final void setIconBackgroundColor(Integer num) {
        this.I = num;
        o();
    }

    public final void setIconCornerRadius(float f5) {
        this.H = f5;
        o();
    }

    public final void setIconSize(int i) {
        A(getIconView(), i, i);
    }

    public final void setIconSource(Object obj) {
        getIconView().setImageDrawable(null);
        getIconView().setVisibility(this.K ? 0 : 8);
        y();
    }

    public final void setIconStyle(int i) {
        this.f2255j0 = i;
        Resources resources = getResources();
        if (i == 1) {
            ImageView iconView = getIconView();
            int dimensionPixelSize = resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_large);
            A(iconView, dimensionPixelSize, dimensionPixelSize);
            this.H = 0.0f;
        } else if (i == 2) {
            ImageView iconView2 = getIconView();
            int dimensionPixelSize2 = resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_square);
            A(iconView2, dimensionPixelSize2, dimensionPixelSize2);
            this.H = resources.getDimension(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_radius_square);
        } else if (i == 3) {
            ImageView iconView3 = getIconView();
            int dimensionPixelSize3 = resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_avatar);
            A(iconView3, dimensionPixelSize3, dimensionPixelSize3);
            this.H = resources.getDimension(com.stepos.agentsafetycenter.R.dimen.stepos_radius_full);
        } else if (i == 4) {
            A(getIconView(), resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_preview_width), resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_preview_height));
            this.H = resources.getDimension(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_radius_preview);
        } else if (i != 5) {
            ImageView iconView4 = getIconView();
            int dimensionPixelSize4 = resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_small);
            A(iconView4, dimensionPixelSize4, dimensionPixelSize4);
            this.H = 0.0f;
        } else {
            A(getIconView(), resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_preview_wide_width), resources.getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_preview_wide_height));
            this.H = resources.getDimension(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_icon_radius_preview);
        }
        o();
        y();
    }

    public final void setIconTint(ColorStateList colorStateList) {
        getIconView().setImageTintList(colorStateList);
    }

    public final void setIconVisible(boolean z10) {
        setShowIcon(z10);
    }

    public final void setLineMode(int i) {
        this.f2248a0 = i;
        r();
    }

    public final void setNeighborBelowPressed$StepOSWidget_release(boolean z10) {
        if (this.f2253h0 == z10) {
            return;
        }
        this.f2253h0 = z10;
        invalidate();
    }

    public final void setOnItemClickListener(g gVar) {
        this.B = gVar;
        int i = 0;
        if (gVar == null) {
            setOnClickListener(null);
            setClickable(false);
        } else {
            d dVar = new d(i);
            dVar.f2246f = this;
            VarHandle.storeStoreFence();
            setOnClickListener(dVar);
        }
    }

    public final void setPressFeedbackEnabled(boolean z10) {
        Drawable drawableV;
        if (this.D == z10) {
            return;
        }
        this.D = z10;
        float[] fArr = this.E;
        if (fArr != null) {
            Context context = getContext();
            context.getClass();
            drawableV = k.f(context, fArr, this.F, z10);
        } else {
            drawableV = z10 ? k.v(com.stepos.agentsafetycenter.R.drawable.stepos_bg_list_item_selector, getContext()) : new ColorDrawable(0);
        }
        setBackground(drawableV);
    }

    public final void setPressScaleEnabled(boolean z10) {
        this.C = z10;
        setStateListAnimator(z10 ? AnimatorInflater.loadStateListAnimator(getContext(), com.stepos.agentsafetycenter.R.animator.stepos_list_item_press) : null);
    }

    public final void setReservesCheckSlot(boolean z10) throws Resources.NotFoundException {
        if (this.G == z10) {
            return;
        }
        this.G = z10;
        v(this.f2249b0);
    }

    public final void setRightBadgeStyle(int i) {
        this.V = i;
        h();
    }

    public final void setRightBadgeTint(Integer num) {
        this.W = num;
        h();
    }

    public final void setRightText(int i) {
        setValueText(getContext().getText(i));
    }

    public final void setShowAccessory(boolean z10) {
        this.J = z10;
        v(this.f2249b0);
    }

    public final void setShowBadge(boolean z10) {
        this.R = z10;
        h();
    }

    public final void setShowDivider(boolean z10) {
        z(this, z10);
    }

    public final void setShowIcon(boolean z10) {
        this.K = z10;
        B();
    }

    public final void setShowRightBadge(boolean z10) {
        this.U = z10;
        h();
    }

    public final void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public final void setSwitchChecked(boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        x().setChecked(z10);
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.f2256k0 = z10;
        eb.a aVar = this.M;
        if (aVar != null) {
            aVar.setSwitchHapticFeedbackEnabled(z10);
        }
    }

    public final void setSwitchHapticFeedbackOwner$StepOSWidget_release(Object obj) {
        this.N = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public final void setTitleEndText(CharSequence charSequence) {
        getTitleEndView().setText(charSequence);
        getTitleEndView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void setTitleStyle(int i) {
        this.f2251d0 = i;
        t();
    }

    public final void setTrailingType(int i) throws Resources.NotFoundException {
        this.f2249b0 = i;
        v(i);
    }

    public final void setTrailingView(View view) throws Resources.NotFoundException {
        View view2 = this.P;
        if (view2 != null) {
            getTrailingContainer().removeView(view2);
        }
        this.P = view;
        if (view == null) {
            if (this.f2249b0 == 4) {
                setTrailingType(0);
                return;
            }
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup != getTrailingContainer() ? viewGroup : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        }
        getTrailingContainer().addView(view);
        setTrailingType(4);
    }

    public final void setValueText(CharSequence charSequence) {
        getValueView().setText(charSequence);
        getValueView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void t() {
        if (this.f2251d0 == 1) {
            getTitleView().setTextColor(getContext().getColor(com.stepos.agentsafetycenter.R.color.stepos_list_item_title_link));
            return;
        }
        ColorStateList colorStateList = this.e0;
        if (colorStateList != null) {
            getTitleView().setTextColor(colorStateList);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() throws Resources.NotFoundException {
        setChecked(!this.L);
    }

    public final void u() {
        boolean z10 = getRightBadgeView().getVisibility() == 0;
        boolean z11 = getTrailingContainer().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getValueView().getLayoutParams();
        layoutParams.getClass();
        z2.d dVar = (z2.d) layoutParams;
        if (z10) {
            dVar.f16224u = getRightBadgeView().getId();
            dVar.f16225v = -1;
            dVar.setMarginEnd(this.f2259y);
        } else if (z11) {
            dVar.f16224u = getTrailingContainer().getId();
            dVar.f16225v = -1;
            dVar.setMarginEnd(this.f2260z);
        } else {
            dVar.f16224u = -1;
            dVar.f16225v = 0;
            dVar.setMarginEnd(0);
        }
        getValueView().setLayoutParams(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(int r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cb.i.v(int):void");
    }

    public final TextView w() throws Resources.NotFoundException {
        TextView textView = this.O;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        textView2.setBackground(k.v(com.stepos.agentsafetycenter.R.drawable.stepos_bg_list_button, textView2.getContext()));
        textView2.setTextAppearance(com.stepos.agentsafetycenter.R.style.StepOSTextAppearance_ListItem_Button);
        textView2.setGravity(17);
        textView2.setMaxLines(2);
        textView2.setMinHeight(textView2.getResources().getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_button_min_height));
        int dimensionPixelSize = textView2.getResources().getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_button_padding_horizontal);
        int dimensionPixelSize2 = textView2.getResources().getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_list_item_button_padding_vertical);
        textView2.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        textView2.setContentDescription(textView2.getContext().getText(com.stepos.agentsafetycenter.R.string.stepos_list_item_button_desc));
        CharSequence charSequence = this.f2250c0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        }
        getTrailingContainer().addView(textView2);
        this.O = textView2;
        return textView2;
    }

    public final eb.a x() {
        eb.a aVar = this.M;
        if (aVar != null) {
            return aVar;
        }
        Context context = getContext();
        context.getClass();
        eb.a aVar2 = new eb.a(context);
        aVar2.setSwitchHapticFeedbackEnabled(this.f2256k0);
        aVar2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        aVar2.setContentDescription(aVar2.getContext().getText(com.stepos.agentsafetycenter.R.string.stepos_list_item_switch_desc));
        e eVar = new e();
        VarHandle.storeStoreFence();
        aVar2.setOnCheckedChangeListener(eVar);
        getTrailingContainer().addView(aVar2);
        this.M = aVar2;
        return aVar2;
    }

    public final void y() {
        if (this.f0) {
            this.f2252g0.f16574c = getDividerInsetStart();
            invalidate();
        }
    }

    public final void setTitle(int i) {
        getTitleView().setText(i);
    }

    public final void setIcon(int i) {
        getIconView().setImageResource(i);
        B();
    }

    public final void setRightText(CharSequence charSequence) {
        setValueText(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        getSubtitleView().setText(charSequence);
        r();
    }

    public final void setAccessoryIcon(int i) throws Resources.NotFoundException {
        getAccessoryView().setImageResource(i);
        v(this.f2249b0);
    }

    public static /* synthetic */ void getBadgeStyle$annotations() {
    }

    public static /* synthetic */ void getIconStyle$annotations() {
    }

    public static /* synthetic */ void getRightBadgeStyle$annotations() {
    }

    public static /* synthetic */ void getTrailingType$annotations() {
    }

    public static final void setImageLoader(c cVar) {
    }

    public final void setOnCheckedChangeListener(f fVar) {
    }

    public final void setOnSwitchCheckedChangeListener(h hVar) {
    }

    public final void setTitleEndText(int i) {
        setTitleEndText(getContext().getText(i));
    }

    public final void setValueText(int i) {
        setValueText(getContext().getText(i));
    }
}

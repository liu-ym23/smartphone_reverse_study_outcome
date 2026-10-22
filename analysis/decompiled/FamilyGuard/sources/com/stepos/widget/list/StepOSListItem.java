package com.stepos.widget.list;

import V3.f;
import V3.v;
import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.toggle.StepOSSwitch;
import g4.C0743a;
import h.C0744a;
import i4.InterfaceC0761a;
import j4.g;
import j4.k;
import l3.C0843a;
import l3.C0844b;
import l3.C0846d;
import l3.C0847e;
import l3.h;
import l3.l;
import l3.m;
import o3.C0902a;
import q3.C0986a;
import t3.C1146a;
import t3.j;

/* loaded from: classes.dex */
public class StepOSListItem extends ConstraintLayout implements Checkable {

    /* renamed from: y0, reason: collision with root package name */
    public static final a f16157y0 = new a(null);

    /* renamed from: z0, reason: collision with root package name */
    private static final int[] f16158z0 = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private int f16159A;

    /* renamed from: B, reason: collision with root package name */
    private int f16160B;

    /* renamed from: C, reason: collision with root package name */
    private int f16161C;

    /* renamed from: D, reason: collision with root package name */
    private c f16162D;

    /* renamed from: E, reason: collision with root package name */
    private d f16163E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f16164F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f16165G;

    /* renamed from: H, reason: collision with root package name */
    private float[] f16166H;

    /* renamed from: I, reason: collision with root package name */
    private int f16167I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f16168J;

    /* renamed from: K, reason: collision with root package name */
    private float f16169K;

    /* renamed from: L, reason: collision with root package name */
    private Integer f16170L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f16171M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f16172Q;

    /* renamed from: R, reason: collision with root package name */
    private Integer f16173R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f16174S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f16175T;

    /* renamed from: U, reason: collision with root package name */
    private StepOSSwitch f16176U;

    /* renamed from: V, reason: collision with root package name */
    private Object f16177V;

    /* renamed from: W, reason: collision with root package name */
    private TextView f16178W;

    /* renamed from: a0, reason: collision with root package name */
    private View f16179a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f16180b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f16181c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f16182d0;

    /* renamed from: e0, reason: collision with root package name */
    private Integer f16183e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f16184f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f16185g0;

    /* renamed from: h0, reason: collision with root package name */
    private Integer f16186h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f16187i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f16188j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f16189k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f16190l0;

    /* renamed from: m0, reason: collision with root package name */
    private CharSequence f16191m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f16192n0;

    /* renamed from: o0, reason: collision with root package name */
    private ColorStateList f16193o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f16194p0;

    /* renamed from: q0, reason: collision with root package name */
    private final C0986a f16195q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f16196r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f16197s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f16198t0;

    /* renamed from: u0, reason: collision with root package name */
    private final f f16199u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f16200v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f16201w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f16202x0;

    /* renamed from: y, reason: collision with root package name */
    private final C0902a f16203y;

    /* renamed from: z, reason: collision with root package name */
    private int f16204z;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final t3.c a() {
            StepOSListItem.E();
            return null;
        }

        public final void b(t3.c cVar) {
            StepOSListItem.F(cVar);
        }

        private a() {
        }
    }

    public interface b {
    }

    public interface c {
        void a(StepOSListItem stepOSListItem);
    }

    public interface d {
        void a(StepOSListItem stepOSListItem, boolean z5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    private final void A0(View view, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (bVar.getMarginEnd() == i5 && bVar.f8801B == i5) {
            return;
        }
        bVar.setMarginEnd(i5);
        bVar.f8801B = i5;
        view.setLayoutParams(bVar);
    }

    private final void B0() {
        getIconView().setVisibility((!this.f16174S || getIconView().getDrawable() == null) ? 8 : 0);
        P();
        k0();
    }

    public static final /* synthetic */ t3.c E() {
        return null;
    }

    public static final /* synthetic */ void F(t3.c cVar) {
    }

    private final void G() {
        Integer num = this.f16173R;
        int iIntValue = num != null ? num.intValue() : getResources().getDimensionPixelSize(C0847e.f18324E);
        int dimensionPixelSize = (this.f16172Q && this.f16173R == null) ? getResources().getDimensionPixelSize(C0847e.f18325F) : iIntValue;
        getAccessoryView().setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams layoutParams = getAccessoryView().getLayoutParams();
        if (layoutParams.width == dimensionPixelSize && layoutParams.height == iIntValue) {
            return;
        }
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = iIntValue;
        getAccessoryView().setLayoutParams(layoutParams);
    }

    private final void H(View view, boolean z5, int i5, Integer num) {
        int color;
        if (!z5) {
            view.setVisibility(8);
            return;
        }
        if (num != null) {
            color = num.intValue();
        } else {
            color = getContext().getColor(i5 == 1 ? C0846d.f18310q : C0846d.f18309p);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(color);
        view.setBackground(gradientDrawable);
        view.setImportantForAccessibility(2);
        view.setVisibility(0);
    }

    private final void I() {
        H(getBadgeView(), this.f16181c0, this.f16182d0, this.f16183e0);
        H(getRightBadgeView(), this.f16184f0, this.f16185g0, this.f16186h0);
        P();
        W();
        k0();
    }

    public static /* synthetic */ void K(StepOSListItem stepOSListItem, float[] fArr, int i5, boolean z5, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCardChrome");
        }
        if ((i8 & 2) != 0) {
            i5 = stepOSListItem.getContext().getColor(C0846d.f18308o);
        }
        stepOSListItem.J(fArr, i5, (i8 & 4) != 0 ? false : z5, (i8 & 8) != 0 ? 0 : i6, (i8 & 16) != 0 ? 0 : i7);
    }

    public static /* synthetic */ void M(StepOSListItem stepOSListItem, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyFlatChrome");
        }
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        stepOSListItem.L(z5);
    }

    private final void N() {
        Integer num = this.f16170L;
        if (num != null) {
            ImageView iconView = getIconView();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.f16169K);
            gradientDrawable.setColor(num.intValue());
            iconView.setBackground(gradientDrawable);
            getIconView().setClipToOutline(true);
            getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        if (e0()) {
            ImageView iconView2 = getIconView();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(this.f16169K);
            gradientDrawable2.setColor(0);
            iconView2.setBackground(gradientDrawable2);
            getIconView().setClipToOutline(true);
            getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        if (!f0()) {
            getIconView().setBackground(null);
            getIconView().setClipToOutline(false);
            getIconView().setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        ImageView iconView3 = getIconView();
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(this.f16169K);
        gradientDrawable3.setColor(0);
        iconView3.setBackground(gradientDrawable3);
        getIconView().setClipToOutline(true);
        getIconView().setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final void O(int i5) {
        Resources resources = getResources();
        if (i5 == 1) {
            u0(getIconView(), resources.getDimensionPixelSize(C0847e.f18333N));
            this.f16169K = 0.0f;
        } else if (i5 == 2) {
            u0(getIconView(), resources.getDimensionPixelSize(C0847e.f18341V));
            this.f16169K = resources.getDimension(C0847e.f18339T);
        } else if (i5 == 3) {
            u0(getIconView(), resources.getDimensionPixelSize(C0847e.f18332M));
            this.f16169K = resources.getDimension(C0847e.f18355e0);
        } else if (i5 == 4) {
            v0(getIconView(), resources.getDimensionPixelSize(C0847e.f18337R), resources.getDimensionPixelSize(C0847e.f18334O));
            this.f16169K = resources.getDimension(C0847e.f18338S);
        } else if (i5 != 5) {
            u0(getIconView(), resources.getDimensionPixelSize(C0847e.f18340U));
            this.f16169K = 0.0f;
        } else {
            v0(getIconView(), resources.getDimensionPixelSize(C0847e.f18336Q), resources.getDimensionPixelSize(C0847e.f18335P));
            this.f16169K = resources.getDimension(C0847e.f18338S);
        }
        N();
        k0();
    }

    private final void P() {
        boolean z5 = getBadgeView().getVisibility() == 0;
        boolean z6 = getIconView().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getBadgeView().getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginEnd((z5 && z6) ? this.f16204z : 0);
        getBadgeView().setLayoutParams(bVar);
        ViewGroup.LayoutParams layoutParams2 = getTitleView().getLayoutParams();
        k.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        if (z6) {
            bVar2.f8862s = getIconView().getId();
            bVar2.f8864t = -1;
            bVar2.setMarginStart(this.f16204z);
        } else if (z5) {
            bVar2.f8862s = getBadgeView().getId();
            bVar2.f8864t = -1;
            bVar2.setMarginStart(this.f16204z);
        } else {
            bVar2.f8862s = -1;
            bVar2.f8864t = 0;
            bVar2.setMarginStart(0);
        }
        getTitleView().setLayoutParams(bVar2);
    }

    private final void Q() {
        CharSequence text = getSubtitleView().getText();
        TextView subtitleView = getSubtitleView();
        int i5 = this.f16187i0;
        int i6 = 8;
        if (i5 != 1 && (i5 == 2 || (text != null && text.length() != 0))) {
            i6 = 0;
        }
        subtitleView.setVisibility(i6);
    }

    public static /* synthetic */ void S(StepOSListItem stepOSListItem, TypedArray typedArray, boolean z5, com.stepos.widget.list.a aVar, int i5, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyListItemStyledAttributes");
        }
        if ((i5 & 4) != 0) {
            aVar = com.stepos.widget.list.a.f16205U.a();
        }
        stepOSListItem.R(typedArray, z5, aVar);
    }

    private final void U() {
        setStateListAnimator(this.f16164F ? AnimatorInflater.loadStateListAnimator(getContext(), C0843a.f18279b) : null);
    }

    private final void V() {
        if (this.f16192n0 == 1) {
            getTitleView().setTextColor(getContext().getColor(C0846d.f18314u));
            return;
        }
        ColorStateList colorStateList = this.f16193o0;
        if (colorStateList != null) {
            getTitleView().setTextColor(colorStateList);
        }
    }

    private final void W() {
        boolean z5 = getRightBadgeView().getVisibility() == 0;
        boolean z6 = getTrailingContainer().getVisibility() == 0;
        ViewGroup.LayoutParams layoutParams = getValueView().getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (z5) {
            bVar.f8866u = getRightBadgeView().getId();
            bVar.f8868v = -1;
            bVar.setMarginEnd(this.f16159A);
        } else if (z6) {
            bVar.f8866u = getTrailingContainer().getId();
            bVar.f8868v = -1;
            bVar.setMarginEnd(this.f16160B);
        } else {
            bVar.f8866u = -1;
            bVar.f8868v = 0;
            bVar.setMarginEnd(0);
        }
        getValueView().setLayoutParams(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X(int r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.list.StepOSListItem.X(int):void");
    }

    private final void Y(boolean z5) {
        if (this.f16188j0 == z5) {
            return;
        }
        this.f16188j0 = z5;
        Barrier barrier = this.f16203y.f19079j;
        k.f(barrier, "steposListItemTrailingBarrier");
        barrier.setReferencedIds(z5 ? new int[]{getRightBadgeView().getId(), getTrailingContainer().getId()} : new int[]{getValueView().getId(), getRightBadgeView().getId(), getTrailingContainer().getId()});
        ViewGroup.LayoutParams layoutParams = getSubtitleView().getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.f8848l = z5 ? -1 : 0;
        bVar.f8846k = z5 ? getValueView().getId() : -1;
        getSubtitleView().setLayoutParams(bVar);
        ViewGroup.LayoutParams layoutParams2 = getValueView().getLayoutParams();
        k.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        ((ViewGroup.MarginLayoutParams) bVar2).width = z5 ? 0 : -2;
        bVar2.f8864t = z5 ? getTitleView().getId() : -1;
        bVar2.f8842i = z5 ? -1 : 0;
        bVar2.f8844j = z5 ? getSubtitleView().getId() : -1;
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = z5 ? getResources().getDimensionPixelSize(C0847e.f18345Z) : 0;
        getValueView().setLayoutParams(bVar2);
        if (!z5) {
            getValueView().setMaxLines(this.f16189k0);
        } else {
            this.f16189k0 = getValueView().getMaxLines();
            getValueView().setMaxLines(2);
        }
    }

    private final int Z(TextView textView) {
        CharSequence text;
        if (textView.getVisibility() == 8) {
            return 0;
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || (text = transformationMethod.getTransformation(textView.getText(), textView)) == null) {
            text = textView.getText();
        }
        return ((int) Math.ceil(Layout.getDesiredWidth(text, textView.getPaint()))) + textView.getCompoundPaddingStart() + textView.getCompoundPaddingEnd();
    }

    private final TextView a0() throws Resources.NotFoundException {
        TextView textView = this.f16178W;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        textView2.setBackground(C0744a.b(textView2.getContext(), l3.f.f18399e));
        textView2.setTextAppearance(l.f18485h);
        textView2.setGravity(17);
        textView2.setMaxLines(2);
        textView2.setMinHeight(textView2.getResources().getDimensionPixelSize(C0847e.f18327H));
        int dimensionPixelSize = textView2.getResources().getDimensionPixelSize(C0847e.f18328I);
        int dimensionPixelSize2 = textView2.getResources().getDimensionPixelSize(C0847e.f18329J);
        textView2.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        textView2.setContentDescription(textView2.getContext().getText(l3.k.f18470b));
        CharSequence charSequence = this.f16191m0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        }
        getTrailingContainer().addView(textView2);
        this.f16178W = textView2;
        return textView2;
    }

    private final ImageView b0() throws Resources.NotFoundException {
        ImageView imageView = this.f16180b0;
        if (imageView != null) {
            return imageView;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0847e.f18324E);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 16));
        imageView2.setImageDrawable(C0744a.b(imageView2.getContext(), l3.f.f18402h));
        imageView2.setImageTintList(ColorStateList.valueOf(imageView2.getContext().getColor(C0846d.f18311r)));
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setContentDescription(imageView2.getContext().getText(l3.k.f18471c));
        getTrailingContainer().addView(imageView2);
        this.f16180b0 = imageView2;
        return imageView2;
    }

    private final StepOSSwitch c0() {
        StepOSSwitch stepOSSwitch = this.f16176U;
        if (stepOSSwitch != null) {
            return stepOSSwitch;
        }
        Context context = getContext();
        k.f(context, "getContext(...)");
        StepOSSwitch stepOSSwitch2 = new StepOSSwitch(context, null, 0, 6, null);
        stepOSSwitch2.setSwitchHapticFeedbackEnabled(this.f16202x0);
        stepOSSwitch2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 16));
        stepOSSwitch2.setContentDescription(stepOSSwitch2.getContext().getText(l3.k.f18472d));
        stepOSSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: t3.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                StepOSListItem.d0(this.f22653a, compoundButton, z5);
            }
        });
        getTrailingContainer().addView(stepOSSwitch2);
        this.f16176U = stepOSSwitch2;
        return stepOSSwitch2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(StepOSListItem stepOSListItem, CompoundButton compoundButton, boolean z5) {
        k.g(compoundButton, "<unused var>");
        d dVar = stepOSListItem.f16163E;
        if (dVar != null) {
            dVar.a(stepOSListItem, z5);
        }
    }

    private final boolean e0() {
        if (this.f16201w0 == 3) {
            return true;
        }
        ViewGroup.LayoutParams layoutParams = getIconView().getLayoutParams();
        if (layoutParams == null) {
            return false;
        }
        int i5 = layoutParams.width;
        int i6 = layoutParams.height;
        return i5 > 0 && i6 > 0 && this.f16169K >= (((float) Math.min(i5, i6)) / 2.0f) - 0.5f;
    }

    private final boolean f0() {
        int i5 = this.f16201w0;
        return i5 == 4 || i5 == 5;
    }

    public static /* synthetic */ void getBadgeStyle$annotations() {
    }

    private final View getBadgeView() {
        View view = this.f16203y.f19072c;
        k.f(view, "steposListItemBadge");
        return view;
    }

    public static /* synthetic */ void getIconStyle$annotations() {
    }

    public static final t3.c getImageLoader() {
        f16157y0.a();
        return null;
    }

    public static /* synthetic */ void getRightBadgeStyle$annotations() {
    }

    private final View getRightBadgeView() {
        View view = this.f16203y.f19074e;
        k.f(view, "steposListItemRightBadge");
        return view;
    }

    private final Paint getSwipeOverlayPaint() {
        return (Paint) this.f16199u0.getValue();
    }

    private final FrameLayout getTrailingContainer() {
        FrameLayout frameLayout = this.f16203y.f19078i;
        k.f(frameLayout, "steposListItemTrailing");
        return frameLayout;
    }

    public static /* synthetic */ void getTrailingType$annotations() {
    }

    private final int h0() {
        int dimensionPixelSize = getBadgeView().getVisibility() == 0 ? getResources().getDimensionPixelSize(C0847e.f18326G) + this.f16204z : 0;
        return getIconView().getVisibility() == 0 ? dimensionPixelSize + kotlin.ranges.l.b(getIconView().getLayoutParams().width, 0) + this.f16204z : dimensionPixelSize;
    }

    private final void i0() {
        invalidate();
        StepOSListItem stepOSListItemM0 = m0();
        if (stepOSListItemM0 != null) {
            stepOSListItemM0.setNeighborBelowHidesDivider(getHidesAdjacentDividers$StepOSWidget_release());
        }
        ViewParent parent = getParent();
        StepOSListGroup stepOSListGroup = parent instanceof StepOSListGroup ? (StepOSListGroup) parent : null;
        if (stepOSListGroup != null) {
            stepOSListGroup.invalidate();
        }
        ViewParent parent2 = getParent();
        RecyclerView recyclerView = parent2 instanceof RecyclerView ? (RecyclerView) parent2 : null;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
        ViewParent parent3 = getParent();
        j jVar = parent3 instanceof j ? (j) parent3 : null;
        if (jVar != null) {
            jVar.v();
        }
    }

    private static final int j0(StepOSListItem stepOSListItem, int i5, int i6, View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        boolean zIsLayoutRequested = view.isLayoutRequested();
        stepOSListItem.measureChildWithMargins(view, i5, 0, i6, 0);
        if (zIsLayoutRequested) {
            view.forceLayout();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        return view.getMeasuredWidth() + bVar.getMarginStart() + bVar.getMarginEnd();
    }

    private final void k0() {
        if (this.f16194p0) {
            this.f16195q0.i(getDividerInsetStart());
            invalidate();
        }
    }

    private final StepOSListItem m0() {
        View childAt;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        View view;
        ViewParent parent = getParent();
        if (parent instanceof j) {
            return ((j) parent).A();
        }
        if (parent instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) parent;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(this);
            if (childAdapterPosition <= 0 || (viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childAdapterPosition - 1)) == null || (view = viewHolderFindViewHolderForAdapterPosition.itemView) == null) {
                return null;
            }
            StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
            if (stepOSListItem != null) {
                return stepOSListItem;
            }
            j jVar = view instanceof j ? (j) view : null;
            contentListItem$StepOSWidget_release = jVar != null ? jVar.getContentListItem$StepOSWidget_release() : null;
            return contentListItem$StepOSWidget_release == null ? (StepOSListItem) view.findViewById(h.f18418J) : contentListItem$StepOSWidget_release;
        }
        if (parent instanceof StepOSListGroup) {
            return null;
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this);
            if (iIndexOfChild <= 0 || (childAt = viewGroup.getChildAt(iIndexOfChild - 1)) == null) {
                return null;
            }
            contentListItem$StepOSWidget_release = childAt instanceof StepOSListItem ? (StepOSListItem) childAt : null;
            if (contentListItem$StepOSWidget_release == null) {
                return (StepOSListItem) childAt.findViewById(h.f18418J);
            }
        }
        return contentListItem$StepOSWidget_release;
    }

    public static /* synthetic */ void o0(StepOSListItem stepOSListItem, Object obj, Drawable drawable, int i5, Object obj2) throws Resources.NotFoundException {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAccessorySource");
        }
        if ((i5 & 2) != 0) {
            drawable = null;
        }
        stepOSListItem.n0(obj, drawable);
    }

    public static /* synthetic */ void q0(StepOSListItem stepOSListItem, Object obj, Drawable drawable, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIconSource");
        }
        if ((i5 & 2) != 0) {
            drawable = null;
        }
        stepOSListItem.p0(obj, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(StepOSListItem stepOSListItem, View view) {
        c cVar = stepOSListItem.f16162D;
        if (cVar != null) {
            cVar.a(stepOSListItem);
        }
    }

    public static final void setImageLoader(t3.c cVar) {
        f16157y0.b(cVar);
    }

    private final void setNeighborBelowHidesDivider(boolean z5) {
        if (this.f16196r0 == z5) {
            return;
        }
        this.f16196r0 = z5;
        invalidate();
    }

    public static /* synthetic */ void t0(StepOSListItem stepOSListItem, boolean z5, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setShowDivider");
        }
        if ((i7 & 2) != 0) {
            i5 = stepOSListItem.f16195q0.e();
        }
        if ((i7 & 4) != 0) {
            i6 = stepOSListItem.f16195q0.d();
        }
        stepOSListItem.s0(z5, i5, i6);
    }

    private final void u0(View view, int i5) {
        v0(view, i5, i5);
    }

    private final void v0(View view, int i5, int i6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i5;
        layoutParams.height = i6;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint x0(Context context) {
        Paint paint = new Paint();
        paint.setColor(context.getColor(C0846d.f18313t));
        return paint;
    }

    public final void J(float[] fArr, int i5, boolean z5, int i6, int i7) {
        k.g(fArr, "radii");
        setPressScaleEnabled(false);
        this.f16166H = (float[]) fArr.clone();
        this.f16167I = i5;
        Context context = getContext();
        k.f(context, "getContext(...)");
        setBackground(t3.g.a(context, fArr, i5, this.f16165G));
        setForeground(null);
        t0(this, z5, 0, 0, 6, null);
        setPaddingRelative(getPaddingStart(), this.f16161C + i6, getPaddingEnd(), this.f16161C + i7);
    }

    public final void L(boolean z5) {
        setPressScaleEnabled(false);
        this.f16166H = null;
        setBackground(this.f16165G ? C0744a.b(getContext(), l3.f.f18400f) : new ColorDrawable(0));
        setForeground(null);
        t0(this, z5, 0, 0, 6, null);
        setPaddingRelative(getPaddingStart(), this.f16161C, getPaddingEnd(), this.f16161C);
    }

    public final void R(TypedArray typedArray, boolean z5, com.stepos.widget.list.a aVar) throws Resources.NotFoundException {
        CharSequence charSequence;
        k.g(typedArray, "a");
        k.g(aVar, "indices");
        Resources resources = getResources();
        int dimensionPixelSize = typedArray.getDimensionPixelSize(aVar.y(), resources.getDimensionPixelSize(C0847e.f18331L));
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(aVar.z(), resources.getDimensionPixelSize(C0847e.f18343X));
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(aVar.A(), resources.getDimensionPixelSize(C0847e.f18344Y));
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(aVar.u(), resources.getDimensionPixelSize(C0847e.f18342W));
        this.f16159A = typedArray.getDimensionPixelSize(aVar.U(), resources.getDimensionPixelSize(C0847e.f18347a0));
        this.f16160B = resources.getDimensionPixelSize(C0847e.f18330K);
        this.f16204z = dimensionPixelSize4;
        int resourceId = typedArray.getResourceId(aVar.R(), 0);
        if (resourceId != 0) {
            getTitleView().setTextAppearance(resourceId);
        }
        this.f16193o0 = getTitleView().getTextColors();
        int resourceId2 = typedArray.getResourceId(aVar.M(), 0);
        if (resourceId2 != 0) {
            getSubtitleView().setTextAppearance(resourceId2);
        }
        int resourceId3 = typedArray.getResourceId(aVar.V(), 0);
        if (resourceId3 != 0) {
            getValueView().setTextAppearance(resourceId3);
        }
        getSubtitleView().setMaxLines(kotlin.ranges.l.b(typedArray.getInt(aVar.L(), 1), 1));
        setAdaptiveTextLayoutEnabled(typedArray.getBoolean(aVar.f(), false));
        setTitle(typedArray.getText(aVar.O()));
        setTitleEndText(typedArray.getText(aVar.P()));
        setSubtitle(typedArray.getText(aVar.K()));
        CharSequence text = typedArray.getText(aVar.F());
        if (text == null) {
            text = typedArray.getText(aVar.T());
        }
        setValueText(text);
        this.f16170L = typedArray.hasValue(aVar.q()) ? Integer.valueOf(typedArray.getColor(aVar.q(), 0)) : null;
        Drawable drawable = typedArray.getDrawable(aVar.p());
        if (drawable != null) {
            getIconView().setImageDrawable(drawable);
        }
        if (typedArray.hasValue(aVar.v())) {
            getIconView().setImageTintList(typedArray.getColorStateList(aVar.v()));
        }
        this.f16174S = typedArray.getBoolean(aVar.w(), true);
        setIconStyle(typedArray.getInt(aVar.t(), 0));
        if (typedArray.hasValue(aVar.s())) {
            setIconSize(typedArray.getDimensionPixelSize(aVar.s(), 0));
        }
        if (typedArray.hasValue(aVar.r())) {
            setIconCornerRadius(typedArray.getDimension(aVar.r(), 0.0f));
        }
        this.f16182d0 = typedArray.getInt(aVar.g(), 0);
        if (typedArray.hasValue(aVar.h())) {
            this.f16183e0 = Integer.valueOf(typedArray.getColor(aVar.h(), 0));
        }
        this.f16181c0 = typedArray.getBoolean(aVar.H(), false);
        this.f16185g0 = typedArray.getInt(aVar.C(), 1);
        if (typedArray.hasValue(aVar.D())) {
            this.f16186h0 = Integer.valueOf(typedArray.getColor(aVar.D(), 0));
        }
        this.f16184f0 = typedArray.getBoolean(aVar.J(), false);
        this.f16171M = typedArray.getBoolean(aVar.G(), true);
        Drawable drawable2 = typedArray.getDrawable(aVar.E());
        if (drawable2 == null) {
            drawable2 = typedArray.getDrawable(aVar.c());
        }
        Integer numValueOf = Integer.valueOf(typedArray.getResourceId(aVar.E(), 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        this.f16172Q = drawable2 == null || (numValueOf != null ? numValueOf.intValue() : typedArray.getResourceId(aVar.c(), l3.f.f18401g)) == l3.f.f18401g;
        ImageView accessoryView = getAccessoryView();
        if (drawable2 == null) {
            drawable2 = C0744a.b(getContext(), l3.f.f18401g);
        }
        accessoryView.setImageDrawable(drawable2);
        if (typedArray.hasValue(aVar.e())) {
            getAccessoryView().setImageTintList(typedArray.getColorStateList(aVar.e()));
        }
        this.f16173R = typedArray.hasValue(aVar.d()) ? Integer.valueOf(typedArray.getDimensionPixelSize(aVar.d(), 0)) : null;
        G();
        this.f16190l0 = typedArray.getInt(aVar.S(), 1);
        CharSequence text2 = typedArray.getText(aVar.i());
        if (text2 != null) {
            this.f16191m0 = text2;
        }
        this.f16187i0 = typedArray.getInt(aVar.x(), 0);
        this.f16192n0 = typedArray.getInt(aVar.Q(), 0);
        boolean z6 = typedArray.getBoolean(aVar.j(), false);
        setSwitchChecked(typedArray.getBoolean(aVar.N(), false));
        this.f16164F = typedArray.getBoolean(aVar.B(), false);
        Drawable drawable3 = typedArray.hasValue(aVar.o()) ? typedArray.getDrawable(aVar.o()) : null;
        this.f16194p0 = typedArray.getBoolean(aVar.I(), false);
        this.f16195q0.j(typedArray.getDimensionPixelSize(aVar.l(), resources.getDimensionPixelSize(C0847e.f18394z)));
        this.f16195q0.i(typedArray.getDimensionPixelSize(aVar.n(), resources.getDimensionPixelSize(C0847e.f18321B)));
        this.f16195q0.h(typedArray.getDimensionPixelSize(aVar.m(), resources.getDimensionPixelSize(C0847e.f18320A)));
        this.f16195q0.g(typedArray.getColor(aVar.k(), getContext().getColor(C0846d.f18307n)));
        setPaddingRelative(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        this.f16161C = dimensionPixelSize3;
        setMinimumHeight(dimensionPixelSize);
        setClipChildren(false);
        N();
        B0();
        if (z5) {
            setBackground(C0744a.b(getContext(), l3.f.f18400f));
            setForeground(drawable3);
            U();
        }
        I();
        P();
        setLineMode(this.f16187i0);
        V();
        setTrailingType(this.f16190l0);
        if (this.f16190l0 == 3 && (charSequence = this.f16191m0) != null) {
            w0(charSequence, null);
        }
        setChecked(z6);
    }

    public final void T(com.stepos.widget.list.b bVar) throws Resources.NotFoundException {
        k.g(bVar, "state");
        this.f16204z = bVar.u();
        this.f16159A = getResources().getDimensionPixelSize(C0847e.f18347a0);
        this.f16160B = getResources().getDimensionPixelSize(C0847e.f18330K);
        if (bVar.S() != 0) {
            getTitleView().setTextAppearance(bVar.S());
        }
        this.f16193o0 = getTitleView().getTextColors();
        if (bVar.N() != 0) {
            getSubtitleView().setTextAppearance(bVar.N());
        }
        if (bVar.U() != 0) {
            getValueView().setTextAppearance(bVar.U());
        }
        getSubtitleView().setMaxLines(kotlin.ranges.l.b(bVar.M(), 1));
        setAdaptiveTextLayoutEnabled(bVar.c());
        CharSequence charSequenceP = bVar.P();
        if (charSequenceP != null) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceQ = bVar.Q();
        if (charSequenceQ != null) {
            setTitleEndText(charSequenceQ);
        }
        CharSequence charSequenceL = bVar.L();
        if (charSequenceL != null) {
            setSubtitle(charSequenceL);
        }
        CharSequence charSequenceG = bVar.G();
        if (charSequenceG != null) {
            setValueText(charSequenceG);
        }
        if (bVar.n()) {
            setIconBackgroundColor(bVar.m());
        }
        if (bVar.q() != 0) {
            setIcon(bVar.q());
        }
        if (bVar.w()) {
            setIconTint(bVar.v() != null ? ColorStateList.valueOf(bVar.v().intValue()) : null);
        }
        setShowIcon(bVar.x());
        setIconStyle(bVar.t());
        if (bVar.s()) {
            setIconSize(bVar.r());
        }
        if (bVar.p()) {
            setIconCornerRadius(bVar.o());
        }
        setBadgeStyle(bVar.d());
        if (bVar.f()) {
            setBadgeTint(Integer.valueOf(bVar.e()));
        }
        setShowBadge(bVar.I());
        setRightBadgeStyle(bVar.D());
        if (bVar.F()) {
            setRightBadgeTint(Integer.valueOf(bVar.E()));
        }
        setShowRightBadge(bVar.K());
        this.f16171M = bVar.H();
        this.f16173R = bVar.b();
        setAccessoryIcon(bVar.a());
        this.f16190l0 = bVar.T();
        CharSequence charSequenceG2 = bVar.g();
        if (charSequenceG2 != null) {
            this.f16191m0 = charSequenceG2;
        }
        setTrailingType(bVar.T());
        if (bVar.T() == 3 && bVar.g() != null) {
            w0(bVar.g(), null);
        }
        setLineMode(bVar.y());
        setTitleStyle(bVar.R());
        setSwitchChecked(bVar.O());
        setPressScaleEnabled(bVar.C());
        this.f16194p0 = bVar.J();
        this.f16195q0.j(bVar.j());
        this.f16195q0.i(bVar.l());
        this.f16195q0.h(bVar.k());
        this.f16195q0.g(bVar.i());
        setMinimumHeight(bVar.z());
        setPaddingRelative(bVar.A(), bVar.B(), bVar.A(), bVar.B());
        this.f16161C = bVar.B();
        setClipChildren(false);
        N();
        B0();
        I();
        P();
        Q();
        setChecked(bVar.h());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws NumberFormatException {
        k.g(canvas, "canvas");
        if (this.f16198t0 && isEnabled()) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getSwipeOverlayPaint());
        }
        super.dispatchDraw(canvas);
        if (!this.f16194p0 || getHidesAdjacentDividers$StepOSWidget_release() || this.f16196r0) {
            return;
        }
        C0986a.c(this.f16195q0, canvas, getHeight() - this.f16195q0.f(), getWidth(), getLayoutDirection(), 0.0f, 16, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        boolean zIsPressed = isPressed();
        if (zIsPressed == this.f16197s0) {
            return;
        }
        this.f16197s0 = zIsPressed;
        i0();
    }

    public final boolean g0() {
        StepOSSwitch stepOSSwitch = this.f16176U;
        return stepOSSwitch != null && stepOSSwitch.r();
    }

    public final ImageView getAccessoryView() {
        ImageView imageView = this.f16203y.f19071b;
        k.f(imageView, "steposListItemAccessory");
        return imageView;
    }

    public final int getBadgeStyle() {
        return this.f16182d0;
    }

    public final Integer getBadgeTint() {
        return this.f16183e0;
    }

    public final int getDividerInsetStart() {
        return getPaddingStart() + h0();
    }

    public final boolean getHidesAdjacentDividers$StepOSWidget_release() {
        if (this.f16198t0) {
            return true;
        }
        return this.f16165G && isPressed();
    }

    public final int getIconStyle() {
        return this.f16201w0;
    }

    public final ImageView getIconView() {
        ImageView imageView = this.f16203y.f19073d;
        k.f(imageView, "steposListItemLeadingIcon");
        return imageView;
    }

    public final int getLineMode() {
        return this.f16187i0;
    }

    public final boolean getPressFeedbackEnabled() {
        return this.f16165G;
    }

    public final boolean getReservesCheckSlot() {
        return this.f16168J;
    }

    public final int getRightBadgeStyle() {
        return this.f16185g0;
    }

    public final Integer getRightBadgeTint() {
        return this.f16186h0;
    }

    public final CharSequence getRightText() {
        return getValueText();
    }

    public final boolean getShowBadge() {
        return this.f16181c0;
    }

    public final boolean getShowIcon() {
        return this.f16174S;
    }

    public final boolean getShowRightBadge() {
        return this.f16184f0;
    }

    public final CharSequence getSubtitle() {
        return getSubtitleView().getText();
    }

    public final TextView getSubtitleView() {
        TextView textView = this.f16203y.f19075f;
        k.f(textView, "steposListItemSubtitle");
        return textView;
    }

    public final boolean getSwitchChecked() {
        StepOSSwitch stepOSSwitch = this.f16176U;
        if (stepOSSwitch != null) {
            return stepOSSwitch.isChecked();
        }
        return false;
    }

    public final Object getSwitchHapticFeedbackOwner$StepOSWidget_release() {
        return this.f16177V;
    }

    public final CharSequence getTitle() {
        return getTitleView().getText();
    }

    public final CharSequence getTitleEndText() {
        return getTitleEndView().getText();
    }

    public final TextView getTitleEndView() {
        TextView textView = this.f16203y.f19077h;
        k.f(textView, "steposListItemTitleEnd");
        return textView;
    }

    public final int getTitleStyle() {
        return this.f16192n0;
    }

    public final TextView getTitleView() {
        TextView textView = this.f16203y.f19076g;
        k.f(textView, "steposListItemTitle");
        return textView;
    }

    public final int getTrailingType() {
        return this.f16190l0;
    }

    public final CharSequence getValueText() {
        return getValueView().getText();
    }

    public final TextView getValueView() {
        TextView textView = this.f16203y.f19080k;
        k.f(textView, "steposListItemValue");
        return textView;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f16175T;
    }

    public final void l0() throws Resources.NotFoundException {
        this.f16177V = null;
        setSwitchHapticFeedbackEnabled(false);
        setOnSwitchCheckedChangeListener(null);
        setOnCheckedChangeListener(null);
        this.f16162D = null;
        setTitle((CharSequence) null);
        setTitleEndText((CharSequence) null);
        setSubtitle((CharSequence) null);
        setValueText((CharSequence) null);
        setTitleStyle(0);
        setLineMode(0);
        setAdaptiveTextLayoutEnabled(false);
        setIcon((Drawable) null);
        setShowBadge(false);
        setShowRightBadge(false);
        setTrailingView(null);
        setAccessoryIcon(l3.f.f18401g);
        setShowAccessory(true);
        setTrailingType(1);
        setSwitchChecked(false);
        setChecked(false);
        setEnabled(true);
        this.f16196r0 = false;
        this.f16165G = true;
        this.f16168J = false;
    }

    public final void n0(Object obj, Drawable drawable) throws Resources.NotFoundException {
        this.f16172Q = false;
        G();
        getAccessoryView().setImageDrawable(drawable);
        X(this.f16190l0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (this.f16175T) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f16158z0);
        }
        k.d(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        StepOSListItem stepOSListItemM0 = m0();
        if (stepOSListItemM0 != null) {
            stepOSListItemM0.setNeighborBelowHidesDivider(false);
        }
        super.onDetachedFromWindow();
        this.f16196r0 = false;
        this.f16197s0 = false;
        this.f16198t0 = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (View.MeasureSpec.getMode(i5) == 0) {
            Y(false);
            getValueView().setMaxWidth(Integer.MAX_VALUE);
            getTitleEndView().setMaxWidth(Integer.MAX_VALUE);
            super.onMeasure(i5, i6);
            return;
        }
        int iJ0 = j0(this, i5, i6, getBadgeView()) + j0(this, i5, i6, getIconView());
        int iJ02 = j0(this, i5, i6, getRightBadgeView()) + j0(this, i5, i6, getTrailingContainer());
        ViewGroup.LayoutParams layoutParams = getTitleView().getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        boolean z5 = true;
        boolean z6 = getValueView().getVisibility() != 8;
        if (getRightBadgeView().getVisibility() == 8 && getTrailingContainer().getVisibility() == 8) {
            z5 = false;
        }
        int i7 = getRightBadgeView().getVisibility() != 8 ? this.f16159A : getTrailingContainer().getVisibility() != 8 ? this.f16160B : 0;
        int i8 = (z6 || z5) ? this.f16159A : 0;
        int iB = kotlin.ranges.l.b(((((View.MeasureSpec.getSize(i5) - getPaddingStart()) - getPaddingEnd()) - iJ0) - bVar.getMarginStart()) - iJ02, 0);
        int iB2 = kotlin.ranges.l.b((iB - i8) - (z6 ? i7 : 0), 0);
        int iZ = Z(getTitleView());
        int iZ2 = Z(getTitleEndView());
        int i9 = getTitleEndView().getVisibility() != 8 ? this.f16160B : 0;
        int iMax = Math.max(iZ + i9 + iZ2, Z(getSubtitleView()));
        int iZ3 = Z(getValueView());
        C1146a c1146a = C1146a.f22641a;
        int iC = c1146a.c(iB2, iMax, iZ3);
        int iB3 = iB2 - iC;
        int i10 = iB3 - i9;
        boolean zD = c1146a.d(this.f16200v0, z6, iZ, kotlin.ranges.l.b(i10 - c1146a.b(kotlin.ranges.l.b(i10, 0), iZ, iZ2), 0), iMax, iB3, iZ3, iC);
        Y(zD);
        if (zD) {
            iB3 = kotlin.ranges.l.b(iB - (z5 ? this.f16159A : 0), 0);
        }
        int iB4 = c1146a.b(kotlin.ranges.l.b(iB3 - i9, 0), iZ, iZ2);
        if (getTitleEndView().getMaxWidth() != iB4) {
            getTitleEndView().setMaxWidth(iB4);
        }
        if (zD) {
            iC = kotlin.ranges.l.b(iB - i7, 0);
        }
        int i11 = iC;
        if (getValueView().getMaxWidth() != i11) {
            getValueView().setMaxWidth(i11);
        }
        int i12 = (!zD || z5) ? i8 : 0;
        A0(getTitleView(), getTitleEndView().getVisibility() == 8 ? i12 : 0);
        A0(getTitleEndView(), i12);
        A0(getSubtitleView(), i12);
        super.onMeasure(i5, i6);
    }

    public final void p0(Object obj, Drawable drawable) {
        getIconView().setImageDrawable(drawable);
        getIconView().setVisibility(this.f16174S ? 0 : 8);
        k0();
    }

    public final void s0(boolean z5, int i5, int i6) {
        this.f16194p0 = z5;
        this.f16195q0.h(i6);
        C0986a c0986a = this.f16195q0;
        if (z5) {
            i5 = getDividerInsetStart();
        }
        c0986a.i(i5);
        invalidate();
    }

    public final void setAccessoryIcon(Drawable drawable) throws Resources.NotFoundException {
        this.f16172Q = false;
        getAccessoryView().setImageDrawable(drawable);
        G();
        X(this.f16190l0);
    }

    public final void setAccessorySize(int i5) {
        if (i5 >= 0) {
            this.f16173R = Integer.valueOf(i5);
            G();
        } else {
            throw new IllegalArgumentException(("accessorySize must be >= 0 but was " + i5).toString());
        }
    }

    public final void setAccessorySource(Object obj) throws Resources.NotFoundException {
        o0(this, obj, null, 2, null);
    }

    public final void setAccessoryTint(ColorStateList colorStateList) {
        getAccessoryView().setImageTintList(colorStateList);
    }

    public final void setAdaptiveTextLayoutEnabled(boolean z5) {
        if (this.f16200v0 == z5) {
            return;
        }
        this.f16200v0 = z5;
        requestLayout();
    }

    public final void setBadgeStyle(int i5) {
        this.f16182d0 = i5;
        I();
    }

    public final void setBadgeTint(Integer num) {
        this.f16183e0 = num;
        I();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) throws Resources.NotFoundException {
        if (this.f16175T == z5) {
            return;
        }
        this.f16175T = z5;
        X(this.f16190l0);
    }

    public final void setDividerColor(int i5) {
        this.f16195q0.g(i5);
        invalidate();
    }

    public final void setDividerInsetStart(int i5) {
        C0986a c0986a = this.f16195q0;
        if (i5 < 0) {
            i5 = getDividerInsetStart();
        }
        c0986a.i(i5);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        setAlpha(z5 ? 1.0f : 0.3f);
    }

    public final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
        B0();
    }

    public final void setIconBackgroundColor(Integer num) {
        this.f16170L = num;
        N();
    }

    public final void setIconCornerRadius(float f5) {
        this.f16169K = f5;
        N();
    }

    public final void setIconSize(int i5) {
        u0(getIconView(), i5);
    }

    public final void setIconSource(Object obj) {
        q0(this, obj, null, 2, null);
    }

    public final void setIconStyle(int i5) {
        this.f16201w0 = i5;
        O(i5);
    }

    public final void setIconTint(ColorStateList colorStateList) {
        getIconView().setImageTintList(colorStateList);
    }

    public final void setIconVisible(boolean z5) {
        setShowIcon(z5);
    }

    public final void setLineMode(int i5) {
        this.f16187i0 = i5;
        Q();
    }

    public final void setOnCheckedChangeListener(b bVar) {
    }

    public final void setOnItemClickListener(c cVar) {
        this.f16162D = cVar;
        if (cVar != null) {
            setOnClickListener(new View.OnClickListener() { // from class: t3.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepOSListItem.r0(this.f22652a, view);
                }
            });
        } else {
            setOnClickListener(null);
            setClickable(false);
        }
    }

    public final void setOnSwitchCheckedChangeListener(d dVar) {
        this.f16163E = dVar;
    }

    public final void setPressFeedbackEnabled(boolean z5) {
        Drawable drawableB;
        if (this.f16165G == z5) {
            return;
        }
        this.f16165G = z5;
        float[] fArr = this.f16166H;
        if (fArr != null) {
            Context context = getContext();
            k.f(context, "getContext(...)");
            drawableB = t3.g.a(context, fArr, this.f16167I, z5);
        } else {
            drawableB = z5 ? C0744a.b(getContext(), l3.f.f18400f) : new ColorDrawable(0);
        }
        setBackground(drawableB);
        i0();
    }

    public final void setPressScaleEnabled(boolean z5) {
        this.f16164F = z5;
        U();
    }

    public final void setReservesCheckSlot(boolean z5) throws Resources.NotFoundException {
        if (this.f16168J == z5) {
            return;
        }
        this.f16168J = z5;
        X(this.f16190l0);
    }

    public final void setRightBadgeStyle(int i5) {
        this.f16185g0 = i5;
        I();
    }

    public final void setRightBadgeTint(Integer num) {
        this.f16186h0 = num;
        I();
    }

    public final void setRightText(CharSequence charSequence) {
        setValueText(charSequence);
    }

    public final void setShowAccessory(boolean z5) throws Resources.NotFoundException {
        this.f16171M = z5;
        X(this.f16190l0);
    }

    public final void setShowBadge(boolean z5) {
        this.f16181c0 = z5;
        I();
    }

    public final void setShowDivider(boolean z5) {
        t0(this, z5, 0, 0, 6, null);
    }

    public final void setShowIcon(boolean z5) {
        this.f16174S = z5;
        B0();
    }

    public final void setShowRightBadge(boolean z5) {
        this.f16184f0 = z5;
        I();
    }

    public final void setSubtitle(CharSequence charSequence) {
        getSubtitleView().setText(charSequence);
        Q();
    }

    public final void setSwipeAppearanceActive$StepOSWidget_release(boolean z5) {
        if (this.f16198t0 == z5) {
            return;
        }
        this.f16198t0 = z5;
        i0();
    }

    public final void setSwitchChecked(boolean z5) {
        c0().setChecked(z5);
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z5) {
        this.f16202x0 = z5;
        StepOSSwitch stepOSSwitch = this.f16176U;
        if (stepOSSwitch != null) {
            stepOSSwitch.setSwitchHapticFeedbackEnabled(z5);
        }
    }

    public final void setSwitchHapticFeedbackOwner$StepOSWidget_release(Object obj) {
        this.f16177V = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public final void setTitleEndText(CharSequence charSequence) {
        getTitleEndView().setText(charSequence);
        getTitleEndView().setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
    }

    public final void setTitleStyle(int i5) {
        this.f16192n0 = i5;
        V();
    }

    public final void setTrailingType(int i5) throws Resources.NotFoundException {
        this.f16190l0 = i5;
        X(i5);
    }

    public final void setTrailingView(View view) throws Resources.NotFoundException {
        View view2 = this.f16179a0;
        if (view2 != null) {
            getTrailingContainer().removeView(view2);
        }
        this.f16179a0 = view;
        if (view == null) {
            if (this.f16190l0 == 4) {
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

    @Override // android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!this.f16175T);
    }

    public final void w0(CharSequence charSequence, View.OnClickListener onClickListener) throws Resources.NotFoundException {
        this.f16191m0 = charSequence;
        TextView textViewA0 = a0();
        textViewA0.setText(charSequence);
        textViewA0.setOnClickListener(onClickListener);
        setTrailingType(3);
    }

    public final void y0() {
        I();
        Q();
        TextView valueView = getValueView();
        CharSequence valueText = getValueText();
        valueView.setVisibility((valueText == null || valueText.length() == 0) ? 8 : 0);
    }

    public final void z0() {
        setIconStyle(this.f16201w0);
        N();
        B0();
        P();
    }

    public /* synthetic */ StepOSListItem(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? C0844b.f18286g : i5);
    }

    public final void setRightText(int i5) {
        setValueText(getContext().getText(i5));
    }

    public final void setTitle(int i5) {
        getTitleView().setText(i5);
    }

    public final void setIcon(int i5) {
        getIconView().setImageResource(i5);
        B0();
    }

    public final void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public final void setTitleEndText(int i5) {
        setTitleEndText(getContext().getText(i5));
    }

    public final void setValueText(int i5) {
        setValueText(getContext().getText(i5));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSListItem(final Context context, AttributeSet attributeSet, int i5) throws Exception {
        super(context, attributeSet, i5);
        k.g(context, "context");
        C0902a c0902aB = C0902a.b(LayoutInflater.from(context), this);
        k.f(c0902aB, "inflate(...)");
        this.f16203y = c0902aB;
        this.f16164F = true;
        this.f16165G = true;
        this.f16171M = true;
        this.f16172Q = true;
        this.f16174S = true;
        this.f16185g0 = 1;
        this.f16189k0 = 1;
        this.f16190l0 = 1;
        this.f16195q0 = new C0986a();
        this.f16199u0 = V3.g.a(V3.j.f5526c, new InterfaceC0761a() { // from class: t3.d
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return StepOSListItem.x0(context);
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18617U1, i5, l.f18493p);
        try {
            k.d(typedArrayObtainStyledAttributes);
            S(this, typedArrayObtainStyledAttributes, true, null, 4, null);
            v vVar = v.f5542a;
            C0743a.a(typedArrayObtainStyledAttributes, null);
        } finally {
        }
    }

    public final void setAccessoryIcon(int i5) throws Resources.NotFoundException {
        this.f16172Q = i5 == l3.f.f18401g;
        getAccessoryView().setImageResource(i5);
        G();
        X(this.f16190l0);
    }
}

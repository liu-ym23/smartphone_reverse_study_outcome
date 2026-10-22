package w6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import bb.d;
import com.stepos.agentsafetycenter.R;
import d5.e;
import d5.f;
import e3.k;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends q {
    public static final int[] C = {R.attr.state_indeterminate};
    public static final int[] D = {R.attr.state_error};
    public static final int[][] E = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int F = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public final f A;
    public final a B;
    public final LinkedHashSet i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f15270j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f15271k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15272l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15273m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15274n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f15275o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f15276p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f15277q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15278r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f15279s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f15280t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f15281u;

    /* renamed from: v, reason: collision with root package name */
    public int f15282v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f15283w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f15284x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f15285y;

    /* renamed from: z, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f15286z;

    public c(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(k7.a.a(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]), attributeSet);
        this.i = new LinkedHashSet();
        this.f15270j = new LinkedHashSet();
        Context context2 = getContext();
        f fVar = new f(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = k.f3478a;
        Drawable drawable = resources.getDrawable(R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        fVar.f3209c = drawable;
        drawable.setCallback(fVar.f3208j);
        new e(fVar.f3209c.getConstantState());
        this.A = fVar;
        a aVar = new a();
        aVar.f15268b = this;
        VarHandle.storeStoreFence();
        this.B = aVar;
        Context context3 = getContext();
        this.f15276p = getButtonDrawable();
        this.f15279s = getSuperButtonTintList();
        setSupportButtonTintList(null);
        a7.a.a(context3, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        int[] iArr = p6.a.f9818k;
        a7.a.b(context3, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        this.f15277q = (!typedArrayObtainStyledAttributes.hasValue(2) || (resourceId3 = typedArrayObtainStyledAttributes.getResourceId(2, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(2) : id.k.v(resourceId3, context3);
        if (this.f15276p != null && p5.f.F(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId4 == F && resourceId5 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f15276p = id.k.v(R.drawable.mtrl_checkbox_button, context3);
                this.f15278r = true;
                if (this.f15277q == null) {
                    this.f15277q = id.k.v(R.drawable.mtrl_checkbox_button_icon, context3);
                }
            }
        }
        if ((!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = id.k.u(resourceId2, context3)) == null) && (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = id.k.u(resourceId, context3)) == null)) {
            colorStateList = typedArrayObtainStyledAttributes.getColorStateList(3);
        }
        this.f15280t = colorStateList;
        int i = typedArrayObtainStyledAttributes.getInt(4, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f15281u = a7.a.d(i);
        this.f15272l = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.f15273m = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f15274n = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.f15275o = typedArrayObtainStyledAttributes.getText(8);
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(typedArrayObtainStyledAttributes.getInt(7, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.f15282v;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f15271k == null) {
            int i = t1.e.i(R.attr.colorControlActivated, this);
            int i3 = t1.e.i(R.attr.colorError, this);
            int i10 = t1.e.i(R.attr.colorSurface, this);
            int i11 = t1.e.i(R.attr.colorOnSurface, this);
            this.f15271k = new ColorStateList(E, new int[]{t1.e.m(i10, 1.0f, i3), t1.e.m(i10, 1.0f, i), t1.e.m(i10, 0.54f, i11), t1.e.m(i10, 0.38f, i11), t1.e.m(i10, 0.38f, i11)});
        }
        return this.f15271k;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f15279s;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        d dVar;
        Drawable drawableMutate = this.f15276p;
        ColorStateList colorStateList3 = this.f15279s;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.f15276p = drawableMutate;
        Drawable drawableMutate2 = this.f15277q;
        ColorStateList colorStateList4 = this.f15280t;
        PorterDuff.Mode mode = this.f15281u;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.f15277q = drawableMutate2;
        if (this.f15278r) {
            f fVar = this.A;
            if (fVar != null) {
                d5.d dVar2 = fVar.f3205f;
                Drawable drawable = fVar.f3209c;
                a aVar = this.B;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar.f15267a == null) {
                        aVar.f15267a = new d5.b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f15267a);
                }
                ArrayList arrayList = fVar.i;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (fVar.i.size() == 0 && (dVar = fVar.f3207h) != null) {
                        dVar2.f3201b.removeListener(dVar);
                        fVar.f3207h = null;
                    }
                }
                Drawable drawable2 = fVar.f3209c;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar.f15267a == null) {
                        aVar.f15267a = new d5.b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f15267a);
                } else if (aVar != null) {
                    if (fVar.i == null) {
                        fVar.i = new ArrayList();
                    }
                    if (!fVar.i.contains(aVar)) {
                        fVar.i.add(aVar);
                        if (fVar.f3207h == null) {
                            fVar.f3207h = new d(fVar, 2);
                        }
                        dVar2.f3201b.addListener(fVar.f3207h);
                    }
                }
            }
            Drawable drawable3 = this.f15276p;
            if ((drawable3 instanceof AnimatedStateListDrawable) && fVar != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, fVar, false);
                ((AnimatedStateListDrawable) this.f15276p).addTransition(R.id.indeterminate, R.id.unchecked, fVar, false);
            }
        }
        Drawable drawable4 = this.f15276p;
        if (drawable4 != null && (colorStateList2 = this.f15279s) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.f15277q;
        if (drawable5 != null && (colorStateList = this.f15280t) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.f15276p;
        Drawable drawable7 = this.f15277q;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f5 = intrinsicWidth / intrinsicHeight;
                if (f5 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f5);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f5 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f15276p;
    }

    public Drawable getButtonIconDrawable() {
        return this.f15277q;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f15280t;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f15281u;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f15279s;
    }

    public int getCheckedState() {
        return this.f15282v;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f15275o;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f15282v == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15272l && this.f15279s == null && this.f15280t == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        if (this.f15274n) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i10 = iArrOnCreateDrawableState[i3];
            if (i10 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i10 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i3] = 16842912;
                break;
            }
            i3++;
        }
        this.f15283w = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f15273m || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f15274n) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f15275o));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f15269c);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f15269c = getCheckedState();
        return bVar;
    }

    @Override // m.q, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(id.k.v(i, getContext()));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f15277q = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(id.k.v(i, getContext()));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f15280t == colorStateList) {
            return;
        }
        this.f15280t = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f15281u == mode) {
            return;
        }
        this.f15281u = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f15279s == colorStateList) {
            return;
        }
        this.f15279s = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f15273m = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f15282v != i) {
            this.f15282v = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            if (this.f15285y == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f15284x) {
                return;
            }
            this.f15284x = true;
            LinkedHashSet linkedHashSet = this.f15270j;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
            }
            if (this.f15282v != 2 && (onCheckedChangeListener = this.f15286z) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f15284x = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f15275o = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f15274n == z10) {
            return;
        }
        this.f15274n = z10;
        refreshDrawableState();
        Iterator it = this.i.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f15286z = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f15285y = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f15272l = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // m.q, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f15276p = drawable;
        this.f15278r = false;
        a();
    }
}

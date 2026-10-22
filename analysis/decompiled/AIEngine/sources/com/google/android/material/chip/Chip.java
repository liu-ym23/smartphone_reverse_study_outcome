package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.chip.a;
import com.google.android.material.internal.g;
import com.google.android.material.internal.i;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import t0.c;
import v0.e0;
import w0.b;
import w4.c;
import w4.d;
import y4.j;
import y4.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Chip extends f implements a.InterfaceC0036a, n, Checkable {

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.material.chip.a f4858e;
    public InsetDrawable h;

    /* renamed from: j, reason: collision with root package name */
    public RippleDrawable f4859j;

    /* renamed from: k, reason: collision with root package name */
    public View.OnClickListener f4860k;

    /* renamed from: l, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f4861l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4862m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4863n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4864o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4865p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4866q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f4867s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f4868t;

    /* renamed from: u, reason: collision with root package name */
    public final b f4869u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4870v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f4871w;

    /* renamed from: x, reason: collision with root package name */
    public final RectF f4872x;

    /* renamed from: y, reason: collision with root package name */
    public final a f4873y;
    public static final Rect z = new Rect();
    public static final int[] A = {R.attr.state_selected};
    public static final int[] B = {R.attr.state_checkable};

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends c1.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // c1.a
        public final void c(ArrayList arrayList) {
            com.google.android.material.chip.a aVar;
            arrayList.add(0);
            Rect rect = Chip.z;
            Chip chip = Chip.this;
            if (!chip.d() || (aVar = chip.f4858e) == null || !aVar.U || chip.f4860k == null) {
                return;
            }
            arrayList.add(1);
        }

        @Override // c1.a
        public final void f(int i10, w0.b bVar) {
            AccessibilityNodeInfo accessibilityNodeInfo = bVar.f13532a;
            if (i10 != 1) {
                bVar.k("");
                accessibilityNodeInfo.setBoundsInParent(Chip.z);
                return;
            }
            Chip chip = Chip.this;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                bVar.k(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                bVar.k(chip.getContext().getString(com.stepos.aiengine.R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
            bVar.b(b.a.f13535e);
            accessibilityNodeInfo.setEnabled(chip.isEnabled());
            bVar.h(Button.class.getName());
        }

        @Override // c1.a
        public final void g(int i10, boolean z) {
            Chip chip = Chip.this;
            if (i10 == 1) {
                chip.f4865p = z;
            }
            com.google.android.material.chip.a aVar = chip.f4858e;
            boolean z3 = chip.f4865p;
            boolean zR = false;
            if (aVar.V != null) {
                zR = aVar.R(z3 ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : com.google.android.material.chip.a.P0);
            }
            if (zR) {
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(b5.a.a(context, attributeSet, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.stepos.aiengine.R.attr.chipStyle);
        this.f4871w = new Rect();
        this.f4872x = new RectF();
        this.f4873y = new a();
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        com.google.android.material.chip.a aVar = new com.google.android.material.chip.a(context2, attributeSet);
        Context context3 = aVar.f4888o0;
        int[] iArr = k4.a.f9901e;
        TypedArray typedArrayD = i.d(context3, attributeSet, iArr, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        aVar.O0 = typedArrayD.hasValue(37);
        Context context4 = aVar.f4888o0;
        ColorStateList colorStateListA = c.a(context4, typedArrayD, 24);
        if (aVar.H != colorStateListA) {
            aVar.H = colorStateListA;
            aVar.onStateChange(aVar.getState());
        }
        ColorStateList colorStateListA2 = c.a(context4, typedArrayD, 11);
        if (aVar.I != colorStateListA2) {
            aVar.I = colorStateListA2;
            aVar.onStateChange(aVar.getState());
        }
        float dimension = typedArrayD.getDimension(19, 0.0f);
        if (aVar.J != dimension) {
            aVar.J = dimension;
            aVar.invalidateSelf();
            aVar.A();
        }
        if (typedArrayD.hasValue(12)) {
            aVar.G(typedArrayD.getDimension(12, 0.0f));
        }
        aVar.L(c.a(context4, typedArrayD, 22));
        aVar.M(typedArrayD.getDimension(23, 0.0f));
        aVar.W(c.a(context4, typedArrayD, 36));
        String text = typedArrayD.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(aVar.O, text)) {
            aVar.O = text;
            aVar.f4893u0.f5101d = true;
            aVar.invalidateSelf();
            aVar.A();
        }
        d dVar = (!typedArrayD.hasValue(0) || (resourceId3 = typedArrayD.getResourceId(0, 0)) == 0) ? null : new d(context4, resourceId3);
        dVar.f13591l = typedArrayD.getDimension(1, dVar.f13591l);
        aVar.X(dVar);
        int i10 = typedArrayD.getInt(3, 0);
        if (i10 == 1) {
            aVar.L0 = TextUtils.TruncateAt.START;
        } else if (i10 == 2) {
            aVar.L0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i10 == 3) {
            aVar.L0 = TextUtils.TruncateAt.END;
        }
        aVar.K(typedArrayD.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            aVar.K(typedArrayD.getBoolean(15, false));
        }
        aVar.H(c.c(context4, typedArrayD, 14));
        if (typedArrayD.hasValue(17)) {
            aVar.J(c.a(context4, typedArrayD, 17));
        }
        aVar.I(typedArrayD.getDimension(16, -1.0f));
        aVar.T(typedArrayD.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            aVar.T(typedArrayD.getBoolean(26, false));
        }
        aVar.N(c.c(context4, typedArrayD, 25));
        aVar.S(c.a(context4, typedArrayD, 30));
        aVar.P(typedArrayD.getDimension(28, 0.0f));
        aVar.C(typedArrayD.getBoolean(6, false));
        aVar.F(typedArrayD.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            aVar.F(typedArrayD.getBoolean(8, false));
        }
        aVar.D(c.c(context4, typedArrayD, 7));
        if (typedArrayD.hasValue(9)) {
            aVar.E(c.a(context4, typedArrayD, 9));
        }
        aVar.f4878e0 = (!typedArrayD.hasValue(39) || (resourceId2 = typedArrayD.getResourceId(39, 0)) == 0) ? null : l4.c.a(resourceId2, context4);
        aVar.f4879f0 = (!typedArrayD.hasValue(33) || (resourceId = typedArrayD.getResourceId(33, 0)) == 0) ? null : l4.c.a(resourceId, context4);
        float dimension2 = typedArrayD.getDimension(21, 0.0f);
        if (aVar.f4880g0 != dimension2) {
            aVar.f4880g0 = dimension2;
            aVar.invalidateSelf();
            aVar.A();
        }
        aVar.V(typedArrayD.getDimension(35, 0.0f));
        aVar.U(typedArrayD.getDimension(34, 0.0f));
        float dimension3 = typedArrayD.getDimension(41, 0.0f);
        if (aVar.f4883j0 != dimension3) {
            aVar.f4883j0 = dimension3;
            aVar.invalidateSelf();
            aVar.A();
        }
        float dimension4 = typedArrayD.getDimension(40, 0.0f);
        if (aVar.f4884k0 != dimension4) {
            aVar.f4884k0 = dimension4;
            aVar.invalidateSelf();
            aVar.A();
        }
        aVar.Q(typedArrayD.getDimension(29, 0.0f));
        aVar.O(typedArrayD.getDimension(27, 0.0f));
        float dimension5 = typedArrayD.getDimension(13, 0.0f);
        if (aVar.f4887n0 != dimension5) {
            aVar.f4887n0 = dimension5;
            aVar.invalidateSelf();
            aVar.A();
        }
        aVar.N0 = typedArrayD.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayD.recycle();
        i.a(context2, attributeSet, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action);
        i.b(context2, attributeSet, iArr, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action);
        this.f4866q = typedArrayObtainStyledAttributes.getBoolean(32, false);
        TypedValue typedValueA = w4.b.a(com.stepos.aiengine.R.attr.minTouchTargetSize, context2);
        this.f4867s = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (int) ((typedValueA == null || typedValueA.type != 5) ? context2.getResources().getDimension(com.stepos.aiengine.R.dimen.mtrl_min_touch_target_size) : typedValueA.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(aVar);
        aVar.m(getElevation());
        i.a(context2, attributeSet, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action);
        i.b(context2, attributeSet, iArr, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f4869u = new b(this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new o4.b(this));
        }
        setChecked(this.f4862m);
        setText(aVar.O);
        setEllipsize(aVar.L0);
        h();
        if (!this.f4858e.M0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.f4866q) {
            setMinHeight(this.f4867s);
        }
        this.r = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: o4.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f10754a.f4861l;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z3);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.f4872x;
        rectF.setEmpty();
        if (d() && this.f4860k != null) {
            com.google.android.material.chip.a aVar = this.f4858e;
            Rect bounds = aVar.getBounds();
            rectF.setEmpty();
            if (aVar.a0()) {
                float f8 = aVar.f4887n0 + aVar.f4886m0 + aVar.Y + aVar.f4885l0 + aVar.f4884k0;
                if (aVar.getLayoutDirection() == 0) {
                    float f9 = bounds.right;
                    rectF.right = f9;
                    rectF.left = f9 - f8;
                } else {
                    float f10 = bounds.left;
                    rectF.left = f10;
                    rectF.right = f10 + f8;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i10 = (int) closeIconTouchBounds.left;
        int i11 = (int) closeIconTouchBounds.top;
        int i12 = (int) closeIconTouchBounds.right;
        int i13 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.f4871w;
        rect.set(i10, i11, i12, i13);
        return rect;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4893u0.f5103f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z3) {
        if (this.f4864o != z3) {
            this.f4864o = z3;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z3) {
        if (this.f4863n != z3) {
            this.f4863n = z3;
            refreshDrawableState();
        }
    }

    @Override // com.google.android.material.chip.a.InterfaceC0036a
    public final void a() {
        c(this.f4867s);
        requestLayout();
        invalidateOutline();
    }

    public final void c(int i10) {
        this.f4867s = i10;
        if (!this.f4866q) {
            InsetDrawable insetDrawable = this.h;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.h = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i10 - ((int) this.f4858e.J));
        int iMax2 = Math.max(0, i10 - this.f4858e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.h;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.h = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.h != null) {
            Rect rect = new Rect();
            this.h.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                f();
                return;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        this.h = new InsetDrawable((Drawable) this.f4858e, i11, i12, i11, i12);
        f();
    }

    public final boolean d() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null) {
            return false;
        }
        Object objA = aVar.V;
        if (objA == null) {
            objA = null;
        } else if (objA instanceof o0.b) {
            objA = ((o0.b) objA).a();
        }
        return objA != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.f4870v
            if (r0 != 0) goto L9
            boolean r7 = super.dispatchHoverEvent(r8)
            return r7
        L9:
            com.google.android.material.chip.Chip$b r0 = r7.f4869u
            android.view.accessibility.AccessibilityManager r1 = r0.f3250e
            boolean r2 = r1.isEnabled()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L6b
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L1c
            goto L6b
        L1c:
            int r1 = r8.getAction()
            r2 = 7
            r5 = 256(0x100, float:3.59E-43)
            r6 = 128(0x80, float:1.8E-43)
            if (r1 == r2) goto L42
            r2 = 9
            if (r1 == r2) goto L42
            r2 = 10
            if (r1 == r2) goto L30
            goto L6b
        L30:
            int r1 = r0.f3254j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L6b
            if (r1 != r2) goto L39
            goto L71
        L39:
            r0.f3254j = r2
            r0.i(r2, r6)
            r0.i(r1, r5)
            return r4
        L42:
            float r7 = r8.getX()
            float r8 = r8.getY()
            com.google.android.material.chip.Chip r1 = com.google.android.material.chip.Chip.this
            boolean r2 = r1.d()
            if (r2 == 0) goto L5d
            android.graphics.RectF r1 = r1.getCloseIconTouchBounds()
            boolean r7 = r1.contains(r7, r8)
            if (r7 == 0) goto L5d
            r3 = r4
        L5d:
            int r7 = r0.f3254j
            if (r7 != r3) goto L62
            goto L71
        L62:
            r0.f3254j = r3
            r0.i(r3, r6)
            r0.i(r7, r5)
            return r4
        L6b:
            boolean r7 = super.dispatchHoverEvent(r8)
            if (r7 == 0) goto L72
        L71:
            return r4
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f4870v
            if (r0 != 0) goto L9
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        L9:
            com.google.android.material.chip.Chip$b r0 = r9.f4869u
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 0
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            if (r1 == r4) goto L9d
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L87
            r5 = 66
            if (r1 == r5) goto L58
            switch(r1) {
                case 19: goto L2a;
                case 20: goto L2a;
                case 21: goto L2a;
                case 22: goto L2a;
                case 23: goto L58;
                default: goto L28;
            }
        L28:
            goto L9d
        L2a:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L9d
            r7 = 19
            if (r1 == r7) goto L42
            r7 = 21
            if (r1 == r7) goto L3f
            r7 = 22
            if (r1 == r7) goto L44
            r5 = 130(0x82, float:1.82E-43)
            goto L44
        L3f:
            r5 = 17
            goto L44
        L42:
            r5 = 33
        L44:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r4
            r7 = r2
        L4a:
            if (r2 >= r1) goto L56
            boolean r8 = r0.d(r5, r6)
            if (r8 == 0) goto L56
            int r2 = r2 + 1
            r7 = r4
            goto L4a
        L56:
            r2 = r7
            goto L9d
        L58:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L9d
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L9d
            int r1 = r0.f3253i
            if (r1 == r3) goto L85
            com.google.android.material.chip.Chip r5 = com.google.android.material.chip.Chip.this
            if (r1 != 0) goto L70
            r5.performClick()
            goto L85
        L70:
            if (r1 != r4) goto L85
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r1 = r5.f4860k
            if (r1 == 0) goto L7c
            r1.onClick(r5)
        L7c:
            boolean r1 = r5.f4870v
            if (r1 == 0) goto L85
            com.google.android.material.chip.Chip$b r1 = r5.f4869u
            r1.i(r4, r4)
        L85:
            r2 = r4
            goto L9d
        L87:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L93
            r1 = 2
            boolean r2 = r0.d(r1, r6)
            goto L9d
        L93:
            boolean r1 = r10.hasModifiers(r4)
            if (r1 == 0) goto L9d
            boolean r2 = r0.d(r4, r6)
        L9d:
            if (r2 == 0) goto La4
            int r0 = r0.f3253i
            if (r0 == r3) goto La4
            return r4
        La4:
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f4858e;
        boolean zR = false;
        int i10 = 0;
        zR = false;
        if (aVar != null && com.google.android.material.chip.a.z(aVar.V)) {
            com.google.android.material.chip.a aVar2 = this.f4858e;
            ?? IsEnabled = isEnabled();
            int i11 = IsEnabled;
            if (this.f4865p) {
                i11 = IsEnabled + 1;
            }
            int i12 = i11;
            if (this.f4864o) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (this.f4863n) {
                i13 = i12 + 1;
            }
            int i14 = i13;
            if (isChecked()) {
                i14 = i13 + 1;
            }
            int[] iArr = new int[i14];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            }
            if (this.f4865p) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f4864o) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f4863n) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            zR = aVar2.R(iArr);
        }
        if (zR) {
            invalidate();
        }
    }

    public final void e() {
        com.google.android.material.chip.a aVar;
        if (!d() || (aVar = this.f4858e) == null || !aVar.U || this.f4860k == null) {
            e0.j(this, null);
            this.f4870v = false;
        } else {
            e0.j(this, this.f4869u);
            this.f4870v = true;
        }
    }

    public final void f() {
        ColorStateList colorStateListValueOf = this.f4858e.N;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        this.f4859j = new RippleDrawable(colorStateListValueOf, getBackgroundDrawable(), null);
        this.f4858e.getClass();
        setBackground(this.f4859j);
        g();
    }

    public final void g() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f4858e) == null) {
            return;
        }
        int iW = (int) (aVar.w() + aVar.f4887n0 + aVar.f4884k0);
        com.google.android.material.chip.a aVar2 = this.f4858e;
        int iV = (int) (aVar2.v() + aVar2.f4880g0 + aVar2.f4883j0);
        if (this.h != null) {
            Rect rect = new Rect();
            this.h.getPadding(rect);
            iV += rect.left;
            iW += rect.right;
        }
        setPaddingRelative(iV, getPaddingTop(), iW, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f4868t)) {
            return this.f4868t;
        }
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || !aVar.f4876a0) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        if (getParent() instanceof o4.c) {
            throw null;
        }
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.h;
        return insetDrawable == null ? this.f4858e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.c0;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4877d0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.I;
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.x());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f4858e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4887n0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || (drawable = aVar.Q) == 0) {
            return null;
        }
        return drawable instanceof o0.b ? ((o0.b) drawable).a() : drawable;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.S;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.R;
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.J;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4880g0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.L;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.M;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || (drawable = aVar.V) == 0) {
            return null;
        }
        return drawable instanceof o0.b ? ((o0.b) drawable).a() : drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.Z;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4886m0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.Y;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4885l0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.X;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.L0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f4870v) {
            b bVar = this.f4869u;
            if (bVar.f3253i == 1 || bVar.h == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public l4.c getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4879f0;
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4882i0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4881h0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.N;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.f4858e.f14023b.f14044a;
    }

    public l4.c getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4878e0;
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4884k0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            return aVar.f4883j0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f4873y);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        xb.a.g(this, this.f4858e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null && aVar.f4876a0) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z3, int i10, Rect rect) {
        super.onFocusChanged(z3, i10, rect);
        if (this.f4870v) {
            b bVar = this.f4869u;
            int i11 = bVar.f3253i;
            if (i11 != Integer.MIN_VALUE) {
                bVar.a(i11);
            }
            if (z3) {
                bVar.d(i10, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        com.google.android.material.chip.a aVar = this.f4858e;
        accessibilityNodeInfo.setCheckable(aVar != null && aVar.f4876a0);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof o4.c) {
            o4.c cVar = (o4.c) getParent();
            if (cVar.f5090c) {
                i10 = 0;
                for (int i11 = 0; i11 < cVar.getChildCount(); i11++) {
                    View childAt = cVar.getChildAt(i11);
                    if ((childAt instanceof Chip) && cVar.getChildAt(i11).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                i10 = -1;
            } else {
                i10 = -1;
            }
            Object tag = getTag(com.stepos.aiengine.R.id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.d.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i10, 1, isChecked()).f13546a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR)
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.r != i10) {
            this.r = i10;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f4863n
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.f4863n
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f4860k
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f4870v
            if (r0 == 0) goto L43
            com.google.android.material.chip.Chip$b r0 = r5.f4869u
            r0.i(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f4868t = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4859j) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4859j) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z3) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.C(z3);
        }
    }

    public void setCheckableResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.C(aVar.f4888o0.getResources().getBoolean(i10));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null) {
            this.f4862m = z3;
        } else if (aVar.f4876a0) {
            super.setChecked(z3);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.D(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.D(b1.L(i10, aVar.f4888o0));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.E(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.E(androidx.core.content.a.b(i10, aVar.f4888o0));
        }
    }

    public void setCheckedIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.F(aVar.f4888o0.getResources().getBoolean(i10));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.I == colorStateList) {
            return;
        }
        aVar.I = colorStateList;
        aVar.onStateChange(aVar.getState());
    }

    public void setChipBackgroundColorResource(int i10) {
        ColorStateList colorStateListB;
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.I == (colorStateListB = androidx.core.content.a.b(i10, aVar.f4888o0))) {
            return;
        }
        aVar.I = colorStateListB;
        aVar.onStateChange(aVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.G(f8);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.G(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f4858e;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.K0 = new WeakReference<>(null);
            }
            this.f4858e = aVar;
            aVar.M0 = false;
            aVar.K0 = new WeakReference<>(this);
            c(this.f4867s);
        }
    }

    public void setChipEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.f4887n0 == f8) {
            return;
        }
        aVar.f4887n0 = f8;
        aVar.invalidateSelf();
        aVar.A();
    }

    public void setChipEndPaddingResource(int i10) throws Resources.NotFoundException {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float dimension = aVar.f4888o0.getResources().getDimension(i10);
            if (aVar.f4887n0 != dimension) {
                aVar.f4887n0 = dimension;
                aVar.invalidateSelf();
                aVar.A();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.H(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.H(b1.L(i10, aVar.f4888o0));
        }
    }

    public void setChipIconSize(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.I(f8);
        }
    }

    public void setChipIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.I(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.J(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.J(androidx.core.content.a.b(i10, aVar.f4888o0));
        }
    }

    public void setChipIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.K(aVar.f4888o0.getResources().getBoolean(i10));
        }
    }

    public void setChipMinHeight(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.J == f8) {
            return;
        }
        aVar.J = f8;
        aVar.invalidateSelf();
        aVar.A();
    }

    public void setChipMinHeightResource(int i10) throws Resources.NotFoundException {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float dimension = aVar.f4888o0.getResources().getDimension(i10);
            if (aVar.J != dimension) {
                aVar.J = dimension;
                aVar.invalidateSelf();
                aVar.A();
            }
        }
    }

    public void setChipStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.f4880g0 == f8) {
            return;
        }
        aVar.f4880g0 = f8;
        aVar.invalidateSelf();
        aVar.A();
    }

    public void setChipStartPaddingResource(int i10) throws Resources.NotFoundException {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float dimension = aVar.f4888o0.getResources().getDimension(i10);
            if (aVar.f4880g0 != dimension) {
                aVar.f4880g0 = dimension;
                aVar.invalidateSelf();
                aVar.A();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.L(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.L(androidx.core.content.a.b(i10, aVar.f4888o0));
        }
    }

    public void setChipStrokeWidth(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.M(f8);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.M(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.N(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.Z == charSequence) {
            return;
        }
        String str = t0.a.f12898b;
        t0.a aVar2 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? t0.a.f12901e : t0.a.f12900d;
        aVar2.getClass();
        c.d dVar = t0.c.f12912a;
        aVar.Z = aVar2.c(charSequence);
        aVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.O(f8);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.O(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.N(b1.L(i10, aVar.f4888o0));
        }
        e();
    }

    public void setCloseIconSize(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.P(f8);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.P(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.Q(f8);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.Q(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.S(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.S(androidx.core.content.a.b(i10, aVar.f4888o0));
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.m(f8);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f4858e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.L0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z3) {
        this.f4866q = z3;
        c(this.f4867s);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(l4.c cVar) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.f4879f0 = cVar;
        }
    }

    public void setHideMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.f4879f0 = l4.c.a(i10, aVar.f4888o0);
        }
    }

    public void setIconEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.U(f8);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.U(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    public void setIconStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.V(f8);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.V(aVar.f4888o0.getResources().getDimension(i10));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f4858e == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.N0 = i10;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f4861l = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f4860k = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.W(colorStateList);
        }
        this.f4858e.getClass();
        f();
    }

    public void setRippleColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.W(androidx.core.content.a.b(i10, aVar.f4888o0));
            this.f4858e.getClass();
            f();
        }
    }

    @Override // y4.n
    public void setShapeAppearanceModel(j jVar) {
        this.f4858e.setShapeAppearanceModel(jVar);
    }

    public void setShowMotionSpec(l4.c cVar) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.f4878e0 = cVar;
        }
    }

    public void setShowMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.f4878e0 = l4.c.a(i10, aVar.f4888o0);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        if (!z3) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z3);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.M0 ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f4858e;
        if (aVar2 == null || TextUtils.equals(aVar2.O, charSequence)) {
            return;
        }
        aVar2.O = charSequence;
        aVar2.f4893u0.f5101d = true;
        aVar2.invalidateSelf();
        aVar2.A();
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.X(dVar);
        }
        h();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.f4884k0 == f8) {
            return;
        }
        aVar.f4884k0 = f8;
        aVar.invalidateSelf();
        aVar.A();
    }

    public void setTextEndPaddingResource(int i10) throws Resources.NotFoundException {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float dimension = aVar.f4888o0.getResources().getDimension(i10);
            if (aVar.f4884k0 != dimension) {
                aVar.f4884k0 = dimension;
                aVar.invalidateSelf();
                aVar.A();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i10, float f8) {
        super.setTextSize(i10, f8);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i10, f8, getResources().getDisplayMetrics());
            g gVar = aVar.f4893u0;
            d dVar = gVar.f5103f;
            if (dVar != null) {
                dVar.f13591l = fApplyDimension;
                gVar.f5098a.setTextSize(fApplyDimension);
                aVar.a();
            }
        }
        h();
    }

    public void setTextStartPadding(float f8) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar == null || aVar.f4883j0 == f8) {
            return;
        }
        aVar.f4883j0 = f8;
        aVar.invalidateSelf();
        aVar.A();
    }

    public void setTextStartPaddingResource(int i10) throws Resources.NotFoundException {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            float dimension = aVar.f4888o0.getResources().getDimension(i10);
            if (aVar.f4883j0 != dimension) {
                aVar.f4883j0 = dimension;
                aVar.invalidateSelf();
                aVar.A();
            }
        }
    }

    public void setCloseIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.T(z3);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.F(z3);
        }
    }

    public void setChipIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.K(z3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.X(new d(aVar.f4888o0, i10));
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f4858e;
        if (aVar != null) {
            aVar.X(new d(aVar.f4888o0, i10));
        }
        h();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.datastore.preferences.protobuf.f {
        public a() {
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void h(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            com.google.android.material.chip.a aVar = chip.f4858e;
            chip.setText(aVar.M0 ? aVar.O : chip.getText());
            chip.requestLayout();
            chip.invalidate();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void g(int i10) {
        }
    }

    public void setInternalOnCheckedChangeListener(com.google.android.material.internal.f<Chip> fVar) {
    }
}

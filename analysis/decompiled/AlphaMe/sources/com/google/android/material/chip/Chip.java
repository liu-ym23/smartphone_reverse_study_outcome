package com.google.android.material.chip;

import C1.a;
import E.g;
import E.h;
import K.S;
import Z2.I;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
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
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.C0232w;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import m1.AbstractC0769a;
import n1.C0777c;
import r1.b;
import r1.c;
import r1.d;
import r1.e;
import r1.f;
import w1.C0973d;
import y1.n;
import y1.y;

/* loaded from: classes.dex */
public class Chip extends C0232w implements e, y, Checkable {

    /* renamed from: w, reason: collision with root package name */
    public static final Rect f10571w = new Rect();

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f10572x = {R.attr.state_selected};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f10573y = {R.attr.state_checkable};

    /* renamed from: e, reason: collision with root package name */
    public f f10574e;

    /* renamed from: f, reason: collision with root package name */
    public InsetDrawable f10575f;

    /* renamed from: g, reason: collision with root package name */
    public RippleDrawable f10576g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f10577h;

    /* renamed from: i, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f10578i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10579j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10580k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10581l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10582m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10583n;

    /* renamed from: o, reason: collision with root package name */
    public int f10584o;

    /* renamed from: p, reason: collision with root package name */
    public int f10585p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f10586q;

    /* renamed from: r, reason: collision with root package name */
    public final d f10587r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10588s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f10589t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f10590u;

    /* renamed from: v, reason: collision with root package name */
    public final b f10591v;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(a.b(context, attributeSet, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.stepos.alphame.R.attr.chipStyle);
        this.f10589t = new Rect();
        this.f10590u = new RectF();
        int i4 = 0;
        this.f10591v = new b(i4, this);
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
        f fVar = new f(context2, attributeSet);
        int[] iArr = AbstractC0769a.f13539e;
        TypedArray typedArrayE = l.e(fVar.f14071y0, attributeSet, iArr, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        fVar.f14056Z0 = typedArrayE.hasValue(37);
        Context context3 = fVar.f14071y0;
        ColorStateList colorStateListY = B0.f.y(context3, typedArrayE, 24);
        if (fVar.f14021H != colorStateListY) {
            fVar.f14021H = colorStateListY;
            fVar.onStateChange(fVar.getState());
        }
        ColorStateList colorStateListY2 = B0.f.y(context3, typedArrayE, 11);
        if (fVar.f14023I != colorStateListY2) {
            fVar.f14023I = colorStateListY2;
            fVar.onStateChange(fVar.getState());
        }
        float dimension = typedArrayE.getDimension(19, Property.DEFAULT_FLOAT_VALUE);
        if (fVar.f14025J != dimension) {
            fVar.f14025J = dimension;
            fVar.invalidateSelf();
            fVar.B();
        }
        if (typedArrayE.hasValue(12)) {
            fVar.H(typedArrayE.getDimension(12, Property.DEFAULT_FLOAT_VALUE));
        }
        fVar.M(B0.f.y(context3, typedArrayE, 22));
        fVar.N(typedArrayE.getDimension(23, Property.DEFAULT_FLOAT_VALUE));
        fVar.X(B0.f.y(context3, typedArrayE, 36));
        String text = typedArrayE.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(fVar.f14035O, text)) {
            fVar.f14035O = text;
            fVar.f14018E0.f10856d = true;
            fVar.invalidateSelf();
            fVar.B();
        }
        C0973d c0973d = (!typedArrayE.hasValue(0) || (resourceId3 = typedArrayE.getResourceId(0, 0)) == 0) ? null : new C0973d(context3, resourceId3);
        c0973d.f15824l = typedArrayE.getDimension(1, c0973d.f15824l);
        fVar.Y(c0973d);
        int i5 = typedArrayE.getInt(3, 0);
        if (i5 == 1) {
            fVar.f14050W0 = TextUtils.TruncateAt.START;
        } else if (i5 == 2) {
            fVar.f14050W0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i5 == 3) {
            fVar.f14050W0 = TextUtils.TruncateAt.END;
        }
        fVar.L(typedArrayE.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            fVar.L(typedArrayE.getBoolean(15, false));
        }
        fVar.I(B0.f.D(context3, typedArrayE, 14));
        if (typedArrayE.hasValue(17)) {
            fVar.K(B0.f.y(context3, typedArrayE, 17));
        }
        fVar.J(typedArrayE.getDimension(16, -1.0f));
        fVar.U(typedArrayE.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            fVar.U(typedArrayE.getBoolean(26, false));
        }
        fVar.O(B0.f.D(context3, typedArrayE, 25));
        fVar.T(B0.f.y(context3, typedArrayE, 30));
        fVar.Q(typedArrayE.getDimension(28, Property.DEFAULT_FLOAT_VALUE));
        fVar.D(typedArrayE.getBoolean(6, false));
        fVar.G(typedArrayE.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            fVar.G(typedArrayE.getBoolean(8, false));
        }
        fVar.E(B0.f.D(context3, typedArrayE, 7));
        if (typedArrayE.hasValue(9)) {
            fVar.F(B0.f.y(context3, typedArrayE, 9));
        }
        fVar.f14061o0 = (!typedArrayE.hasValue(39) || (resourceId2 = typedArrayE.getResourceId(39, 0)) == 0) ? null : C0777c.a(resourceId2, context3);
        fVar.f14062p0 = (!typedArrayE.hasValue(33) || (resourceId = typedArrayE.getResourceId(33, 0)) == 0) ? null : C0777c.a(resourceId, context3);
        float dimension2 = typedArrayE.getDimension(21, Property.DEFAULT_FLOAT_VALUE);
        if (fVar.f14063q0 != dimension2) {
            fVar.f14063q0 = dimension2;
            fVar.invalidateSelf();
            fVar.B();
        }
        fVar.W(typedArrayE.getDimension(35, Property.DEFAULT_FLOAT_VALUE));
        fVar.V(typedArrayE.getDimension(34, Property.DEFAULT_FLOAT_VALUE));
        float dimension3 = typedArrayE.getDimension(41, Property.DEFAULT_FLOAT_VALUE);
        if (fVar.f14066t0 != dimension3) {
            fVar.f14066t0 = dimension3;
            fVar.invalidateSelf();
            fVar.B();
        }
        float dimension4 = typedArrayE.getDimension(40, Property.DEFAULT_FLOAT_VALUE);
        if (fVar.f14067u0 != dimension4) {
            fVar.f14067u0 = dimension4;
            fVar.invalidateSelf();
            fVar.B();
        }
        fVar.R(typedArrayE.getDimension(29, Property.DEFAULT_FLOAT_VALUE));
        fVar.P(typedArrayE.getDimension(27, Property.DEFAULT_FLOAT_VALUE));
        float dimension5 = typedArrayE.getDimension(13, Property.DEFAULT_FLOAT_VALUE);
        if (fVar.f14070x0 != dimension5) {
            fVar.f14070x0 = dimension5;
            fVar.invalidateSelf();
            fVar.B();
        }
        fVar.f14054Y0 = typedArrayE.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayE.recycle();
        l.a(context2, attributeSet, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action);
        l.b(context2, attributeSet, iArr, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action);
        this.f10583n = typedArrayObtainStyledAttributes.getBoolean(32, false);
        TypedValue typedValueV = AbstractC0557a.V(com.stepos.alphame.R.attr.minTouchTargetSize, context2);
        this.f10585p = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (int) ((typedValueV == null || typedValueV.type != 5) ? context2.getResources().getDimension(com.stepos.alphame.R.dimen.mtrl_min_touch_target_size) : typedValueV.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(fVar);
        fVar.n(getElevation());
        l.a(context2, attributeSet, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action);
        l.b(context2, attributeSet, iArr, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f10587r = new d(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new c(i4, this));
        }
        setChecked(this.f10579j);
        setText(fVar.f14035O);
        setEllipsize(fVar.f14050W0);
        h();
        if (!this.f10574e.f14052X0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.f10583n) {
            setMinHeight(this.f10585p);
        }
        this.f10584o = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: r1.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f14006a.f10578i;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z4);
                }
            }
        });
    }

    @NonNull
    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.f10590u;
        rectF.setEmpty();
        if (c() && this.f10577h != null) {
            f fVar = this.f10574e;
            Rect bounds = fVar.getBounds();
            rectF.setEmpty();
            if (fVar.b0()) {
                float f4 = fVar.f14070x0 + fVar.f14069w0 + fVar.f14053Y + fVar.f14068v0 + fVar.f14067u0;
                if (E.b.a(fVar) == 0) {
                    float f5 = bounds.right;
                    rectF.right = f5;
                    rectF.left = f5 - f4;
                } else {
                    float f6 = bounds.left;
                    rectF.left = f6;
                    rectF.right = f6 + f4;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i4 = (int) closeIconTouchBounds.left;
        int i5 = (int) closeIconTouchBounds.top;
        int i6 = (int) closeIconTouchBounds.right;
        int i7 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.f10589t;
        rect.set(i4, i5, i6, i7);
        return rect;
    }

    @Nullable
    private C0973d getTextAppearance() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14018E0.f10858f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z4) {
        if (this.f10581l != z4) {
            this.f10581l = z4;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z4) {
        if (this.f10580k != z4) {
            this.f10580k = z4;
            refreshDrawableState();
        }
    }

    public final void b(int i4) {
        this.f10585p = i4;
        if (!this.f10583n) {
            InsetDrawable insetDrawable = this.f10575f;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f10575f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i4 - ((int) this.f10574e.f14025J));
        int iMax2 = Math.max(0, i4 - this.f10574e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f10575f;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f10575f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i5 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i6 = iMax > 0 ? iMax / 2 : 0;
        if (this.f10575f != null) {
            Rect rect = new Rect();
            this.f10575f.getPadding(rect);
            if (rect.top == i6 && rect.bottom == i6 && rect.left == i5 && rect.right == i5) {
                f();
                return;
            }
        }
        if (getMinHeight() != i4) {
            setMinHeight(i4);
        }
        if (getMinWidth() != i4) {
            setMinWidth(i4);
        }
        this.f10575f = new InsetDrawable((Drawable) this.f10574e, i5, i6, i5, i6);
        f();
    }

    public final boolean c() {
        f fVar = this.f10574e;
        if (fVar != null) {
            Object obj = fVar.f14047V;
            if (obj == null) {
                obj = null;
            } else if (obj instanceof g) {
                ((h) ((g) obj)).getClass();
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        f fVar = this.f10574e;
        return fVar != null && fVar.f14057k0;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i4;
        if (!this.f10588s) {
            return super.dispatchHoverEvent(motionEvent);
        }
        d dVar = this.f10587r;
        AccessibilityManager accessibilityManager = dVar.f1593e;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                Chip chip = dVar.f14011n;
                int i5 = (chip.c() && chip.getCloseIconTouchBounds().contains(x4, y4)) ? 1 : 0;
                int i6 = dVar.f1598j;
                if (i6 != i5) {
                    dVar.f1598j = i5;
                    dVar.i(i5, 128);
                    dVar.i(i6, 256);
                }
                if (i5 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action == 10 && (i4 = dVar.f1598j) != Integer.MIN_VALUE) {
                if (i4 == Integer.MIN_VALUE) {
                    return true;
                }
                dVar.f1598j = Integer.MIN_VALUE;
                dVar.i(Integer.MIN_VALUE, 128);
                dVar.i(i4, 256);
                return true;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3 A[RETURN] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f10588s
            if (r0 != 0) goto L9
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        L9:
            r1.d r0 = r9.f10587r
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 1
            if (r1 == r2) goto La4
            int r1 = r10.getKeyCode()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 61
            r5 = 0
            if (r1 == r4) goto L87
            r4 = 0
            r6 = 66
            if (r1 == r6) goto L56
            switch(r1) {
                case 19: goto L2a;
                case 20: goto L2a;
                case 21: goto L2a;
                case 22: goto L2a;
                case 23: goto L56;
                default: goto L28;
            }
        L28:
            goto La4
        L2a:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto La4
            r7 = 19
            if (r1 == r7) goto L42
            r7 = 21
            if (r1 == r7) goto L3f
            r7 = 22
            if (r1 == r7) goto L44
            r6 = 130(0x82, float:1.82E-43)
            goto L44
        L3f:
            r6 = 17
            goto L44
        L42:
            r6 = 33
        L44:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r2
            r7 = r4
        L4a:
            if (r4 >= r1) goto L9d
            boolean r8 = r0.d(r6, r5)
            if (r8 == 0) goto L9d
            int r4 = r4 + 1
            r7 = r2
            goto L4a
        L56:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto La4
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto La4
            int r1 = r0.f1597i
            if (r1 == r3) goto L9f
            com.google.android.material.chip.Chip r5 = r0.f14011n
            if (r1 != 0) goto L6f
            boolean r1 = r5.performClick()
            goto L9f
        L6f:
            if (r1 != r2) goto L9f
            r5.playSoundEffect(r4)
            android.view.View$OnClickListener r1 = r5.f10577h
            if (r1 == 0) goto L7c
            r1.onClick(r5)
            r4 = r2
        L7c:
            boolean r1 = r5.f10588s
            if (r1 == 0) goto L85
            r1.d r1 = r5.f10587r
            r1.i(r2, r2)
        L85:
            r1 = r4
            goto L9f
        L87:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L93
            r1 = 2
            boolean r7 = r0.d(r1, r5)
            goto L9d
        L93:
            boolean r1 = r10.hasModifiers(r2)
            if (r1 == 0) goto La4
            boolean r7 = r0.d(r2, r5)
        L9d:
            if (r7 == 0) goto La4
        L9f:
            int r0 = r0.f1597i
            if (r0 == r3) goto La4
            return r2
        La4:
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.C0232w, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f10574e;
        if (fVar == null || !f.A(fVar.f14047V)) {
            return;
        }
        f fVar2 = this.f10574e;
        ?? IsEnabled = isEnabled();
        int i4 = IsEnabled;
        if (this.f10582m) {
            i4 = IsEnabled + 1;
        }
        int i5 = i4;
        if (this.f10581l) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (this.f10580k) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (isChecked()) {
            i7 = i6 + 1;
        }
        int[] iArr = new int[i7];
        int i8 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i8 = 1;
        }
        if (this.f10582m) {
            iArr[i8] = 16842908;
            i8++;
        }
        if (this.f10581l) {
            iArr[i8] = 16843623;
            i8++;
        }
        if (this.f10580k) {
            iArr[i8] = 16842919;
            i8++;
        }
        if (isChecked()) {
            iArr[i8] = 16842913;
        }
        if (fVar2.S(iArr)) {
            invalidate();
        }
    }

    public final void e() {
        f fVar;
        if (!c() || (fVar = this.f10574e) == null || !fVar.f14045U || this.f10577h == null) {
            S.h(this, null);
            this.f10588s = false;
        } else {
            S.h(this, this.f10587r);
            this.f10588s = true;
        }
    }

    public final void f() {
        ColorStateList colorStateListValueOf = this.f10574e.f14033N;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        this.f10576g = new RippleDrawable(colorStateListValueOf, getBackgroundDrawable(), null);
        f fVar = this.f10574e;
        if (fVar.f14044T0) {
            fVar.f14044T0 = false;
            fVar.f14046U0 = null;
            fVar.onStateChange(fVar.getState());
        }
        setBackground(this.f10576g);
        g();
    }

    public final void g() {
        f fVar;
        if (TextUtils.isEmpty(getText()) || (fVar = this.f10574e) == null) {
            return;
        }
        int iX = (int) (fVar.x() + fVar.f14070x0 + fVar.f14067u0);
        f fVar2 = this.f10574e;
        int iW = (int) (fVar2.w() + fVar2.f14063q0 + fVar2.f14066t0);
        if (this.f10575f != null) {
            Rect rect = new Rect();
            this.f10575f.getPadding(rect);
            iW += rect.left;
            iX += rect.right;
        }
        setPaddingRelative(iW, getPaddingTop(), iX, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f10586q)) {
            return this.f10586q;
        }
        if (!d()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f10575f;
        return insetDrawable == null ? this.f10574e : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14059m0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14060n0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14023I;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f fVar = this.f10574e;
        return fVar != null ? Math.max(Property.DEFAULT_FLOAT_VALUE, fVar.y()) : Property.DEFAULT_FLOAT_VALUE;
    }

    public Drawable getChipDrawable() {
        return this.f10574e;
    }

    public float getChipEndPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14070x0 : Property.DEFAULT_FLOAT_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        f fVar = this.f10574e;
        if (fVar == null || (drawable = fVar.f14039Q) == 0) {
            return null;
        }
        if (!(drawable instanceof g)) {
            return drawable;
        }
        ((h) ((g) drawable)).getClass();
        return null;
    }

    public float getChipIconSize() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14042S : Property.DEFAULT_FLOAT_VALUE;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14041R;
        }
        return null;
    }

    public float getChipMinHeight() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14025J : Property.DEFAULT_FLOAT_VALUE;
    }

    public float getChipStartPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14063q0 : Property.DEFAULT_FLOAT_VALUE;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14029L;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14031M : Property.DEFAULT_FLOAT_VALUE;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable;
        f fVar = this.f10574e;
        if (fVar == null || (drawable = fVar.f14047V) == 0) {
            return null;
        }
        if (!(drawable instanceof g)) {
            return drawable;
        }
        ((h) ((g) drawable)).getClass();
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14055Z;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14069w0 : Property.DEFAULT_FLOAT_VALUE;
    }

    public float getCloseIconSize() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14053Y : Property.DEFAULT_FLOAT_VALUE;
    }

    public float getCloseIconStartPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14068v0 : Property.DEFAULT_FLOAT_VALUE;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14051X;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14050W0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f10588s) {
            d dVar = this.f10587r;
            if (dVar.f1597i == 1 || dVar.f1596h == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Nullable
    public C0777c getHideMotionSpec() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14062p0;
        }
        return null;
    }

    public float getIconEndPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14065s0 : Property.DEFAULT_FLOAT_VALUE;
    }

    public float getIconStartPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14064r0 : Property.DEFAULT_FLOAT_VALUE;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14033N;
        }
        return null;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f10574e.f16234b.f16203a;
    }

    @Nullable
    public C0777c getShowMotionSpec() {
        f fVar = this.f10574e;
        if (fVar != null) {
            return fVar.f14061o0;
        }
        return null;
    }

    public float getTextEndPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14067u0 : Property.DEFAULT_FLOAT_VALUE;
    }

    public float getTextStartPadding() {
        f fVar = this.f10574e;
        return fVar != null ? fVar.f14066t0 : Property.DEFAULT_FLOAT_VALUE;
    }

    public final void h() {
        TextPaint paint = getPaint();
        f fVar = this.f10574e;
        if (fVar != null) {
            paint.drawableState = fVar.getState();
        }
        C0973d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f10591v);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        B0.f.x0(this, this.f10574e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10572x);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10573y);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        if (this.f10588s) {
            d dVar = this.f10587r;
            int i5 = dVar.f1597i;
            if (i5 != Integer.MIN_VALUE) {
                dVar.a(i5);
            }
            if (z4) {
                dVar.d(i4, rect);
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
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i4) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        if (this.f10584o != i4) {
            this.f10584o = i4;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.TextView, android.view.View
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
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4b
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L44
            goto L51
        L21:
            boolean r0 = r5.f10580k
            if (r0 == 0) goto L51
            if (r1 != 0) goto L57
            r5.setCloseIconPressed(r2)
            goto L57
        L2b:
            boolean r0 = r5.f10580k
            if (r0 == 0) goto L44
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f10577h
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            boolean r0 = r5.f10588s
            if (r0 == 0) goto L42
            r1.d r0 = r5.f10587r
            r0.i(r3, r3)
        L42:
            r0 = r3
            goto L45
        L44:
            r0 = r2
        L45:
            r5.setCloseIconPressed(r2)
            if (r0 != 0) goto L57
            goto L51
        L4b:
            if (r1 == 0) goto L51
            r5.setCloseIconPressed(r3)
            goto L57
        L51:
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L58
        L57:
            r2 = r3
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.f10586q = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10576g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.C0232w, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10576g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.C0232w, android.view.View
    public void setBackgroundResource(int i4) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.D(z4);
        }
    }

    public void setCheckableResource(@BoolRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.D(fVar.f14071y0.getResources().getBoolean(i4));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        f fVar = this.f10574e;
        if (fVar == null) {
            this.f10579j = z4;
        } else if (fVar.f14057k0) {
            super.setChecked(z4);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.E(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z4) {
        setCheckedIconVisible(z4);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i4) {
        setCheckedIconVisible(i4);
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.E(I.o(fVar.f14071y0, i4));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.F(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.F(B0.f.x(i4, fVar.f14071y0));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.G(fVar.f14071y0.getResources().getBoolean(i4));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14023I == colorStateList) {
            return;
        }
        fVar.f14023I = colorStateList;
        fVar.onStateChange(fVar.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i4) {
        ColorStateList colorStateListX;
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14023I == (colorStateListX = B0.f.x(i4, fVar.f14071y0))) {
            return;
        }
        fVar.f14023I = colorStateListX;
        fVar.onStateChange(fVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.H(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.H(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setChipDrawable(@NonNull f fVar) {
        f fVar2 = this.f10574e;
        if (fVar2 != fVar) {
            if (fVar2 != null) {
                fVar2.f14048V0 = new WeakReference(null);
            }
            this.f10574e = fVar;
            fVar.f14052X0 = false;
            fVar.f14048V0 = new WeakReference(this);
            b(this.f10585p);
        }
    }

    public void setChipEndPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14070x0 == f4) {
            return;
        }
        fVar.f14070x0 = f4;
        fVar.invalidateSelf();
        fVar.B();
    }

    public void setChipEndPaddingResource(@DimenRes int i4) throws Resources.NotFoundException {
        f fVar = this.f10574e;
        if (fVar != null) {
            float dimension = fVar.f14071y0.getResources().getDimension(i4);
            if (fVar.f14070x0 != dimension) {
                fVar.f14070x0 = dimension;
                fVar.invalidateSelf();
                fVar.B();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.I(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z4) {
        setChipIconVisible(z4);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(@DrawableRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.I(I.o(fVar.f14071y0, i4));
        }
    }

    public void setChipIconSize(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.J(f4);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.J(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.K(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.K(B0.f.x(i4, fVar.f14071y0));
        }
    }

    public void setChipIconVisible(@BoolRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.L(fVar.f14071y0.getResources().getBoolean(i4));
        }
    }

    public void setChipMinHeight(float f4) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14025J == f4) {
            return;
        }
        fVar.f14025J = f4;
        fVar.invalidateSelf();
        fVar.B();
    }

    public void setChipMinHeightResource(@DimenRes int i4) throws Resources.NotFoundException {
        f fVar = this.f10574e;
        if (fVar != null) {
            float dimension = fVar.f14071y0.getResources().getDimension(i4);
            if (fVar.f14025J != dimension) {
                fVar.f14025J = dimension;
                fVar.invalidateSelf();
                fVar.B();
            }
        }
    }

    public void setChipStartPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14063q0 == f4) {
            return;
        }
        fVar.f14063q0 = f4;
        fVar.invalidateSelf();
        fVar.B();
    }

    public void setChipStartPaddingResource(@DimenRes int i4) throws Resources.NotFoundException {
        f fVar = this.f10574e;
        if (fVar != null) {
            float dimension = fVar.f14071y0.getResources().getDimension(i4);
            if (fVar.f14063q0 != dimension) {
                fVar.f14063q0 = dimension;
                fVar.invalidateSelf();
                fVar.B();
            }
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.M(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.M(B0.f.x(i4, fVar.f14071y0));
        }
    }

    public void setChipStrokeWidth(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.N(f4);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.N(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i4) {
        setText(getResources().getString(i4));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.O(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14055Z == charSequence) {
            return;
        }
        String str = I.b.f812d;
        I.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? I.b.f815g : I.b.f814f;
        fVar.f14055Z = bVar.c(charSequence, bVar.f818c);
        fVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z4) {
        setCloseIconVisible(z4);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.P(f4);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.P(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconResource(@DrawableRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.O(I.o(fVar.f14071y0, i4));
        }
        e();
    }

    public void setCloseIconSize(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.Q(f4);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.Q(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconStartPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.R(f4);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.R(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.T(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.T(B0.f.x(i4, fVar.f14071y0));
        }
    }

    public void setCloseIconVisible(@BoolRes int i4) {
        setCloseIconVisible(getResources().getBoolean(i4));
    }

    @Override // androidx.appcompat.widget.C0232w, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.C0232w, android.widget.TextView
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
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i6 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i4, i5, i6, i7);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.n(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f10574e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14050W0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        this.f10583n = z4;
        b(this.f10585p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i4) {
        if (i4 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i4);
        }
    }

    public void setHideMotionSpec(@Nullable C0777c c0777c) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14062p0 = c0777c;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14062p0 = C0777c.a(i4, fVar.f14071y0);
        }
    }

    public void setIconEndPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.V(f4);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.V(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    public void setIconStartPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.W(f4);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.W(fVar.f14071y0.getResources().getDimension(i4));
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setInternalOnCheckedChangeListener(@Nullable com.google.android.material.internal.e eVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i4) {
        if (this.f10574e == null) {
            return;
        }
        super.setLayoutDirection(i4);
    }

    @Override // android.widget.TextView
    public void setLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i4);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i4) {
        super.setMaxWidth(i4);
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14054Y0 = i4;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i4) {
        if (i4 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i4);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f10578i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f10577h = onClickListener;
        e();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.X(colorStateList);
        }
        if (this.f10574e.f14044T0) {
            return;
        }
        f();
    }

    public void setRippleColorResource(@ColorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.X(B0.f.x(i4, fVar.f14071y0));
            if (this.f10574e.f14044T0) {
                return;
            }
            f();
        }
    }

    @Override // y1.y
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f10574e.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(@Nullable C0777c c0777c) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14061o0 = c0777c;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.f14061o0 = C0777c.a(i4, fVar.f14071y0);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z4) {
        if (!z4) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z4);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f fVar = this.f10574e;
        if (fVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(fVar.f14052X0 ? null : charSequence, bufferType);
        f fVar2 = this.f10574e;
        if (fVar2 == null || TextUtils.equals(fVar2.f14035O, charSequence)) {
            return;
        }
        fVar2.f14035O = charSequence;
        fVar2.f14018E0.f10856d = true;
        fVar2.invalidateSelf();
        fVar2.B();
    }

    public void setTextAppearance(@Nullable C0973d c0973d) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.Y(c0973d);
        }
        h();
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(getContext(), i4);
    }

    public void setTextEndPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14067u0 == f4) {
            return;
        }
        fVar.f14067u0 = f4;
        fVar.invalidateSelf();
        fVar.B();
    }

    public void setTextEndPaddingResource(@DimenRes int i4) throws Resources.NotFoundException {
        f fVar = this.f10574e;
        if (fVar != null) {
            float dimension = fVar.f14071y0.getResources().getDimension(i4);
            if (fVar.f14067u0 != dimension) {
                fVar.f14067u0 = dimension;
                fVar.invalidateSelf();
                fVar.B();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i4, float f4) {
        super.setTextSize(i4, f4);
        f fVar = this.f10574e;
        if (fVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i4, f4, getResources().getDisplayMetrics());
            j jVar = fVar.f14018E0;
            C0973d c0973d = jVar.f10858f;
            if (c0973d != null) {
                c0973d.f15824l = fApplyDimension;
                jVar.f10853a.setTextSize(fApplyDimension);
                fVar.B();
                fVar.invalidateSelf();
            }
        }
        h();
    }

    public void setTextStartPadding(float f4) {
        f fVar = this.f10574e;
        if (fVar == null || fVar.f14066t0 == f4) {
            return;
        }
        fVar.f14066t0 = f4;
        fVar.invalidateSelf();
        fVar.B();
    }

    public void setTextStartPaddingResource(@DimenRes int i4) throws Resources.NotFoundException {
        f fVar = this.f10574e;
        if (fVar != null) {
            float dimension = fVar.f14071y0.getResources().getDimension(i4);
            if (fVar.f14066t0 != dimension) {
                fVar.f14066t0 = dimension;
                fVar.invalidateSelf();
                fVar.B();
            }
        }
    }

    public void setCloseIconVisible(boolean z4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.U(z4);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.G(z4);
        }
    }

    public void setChipIconVisible(boolean z4) {
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.L(z4);
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
    public final void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.Y(new C0973d(fVar.f14071y0, i4));
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i4) {
        super.setTextAppearance(i4);
        f fVar = this.f10574e;
        if (fVar != null) {
            fVar.Y(new C0973d(fVar.f14071y0, i4));
        }
        h();
    }
}

package com.google.android.material.chip;

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
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import b8.h;
import c0.g;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import g.p;
import java.lang.ref.WeakReference;
import java.util.Locale;
import k4.v;
import k4.z;
import l1.b;
import l1.c;
import l1.d;
import l1.e;
import l1.f;
import p1.i;
import p1.k;
import t1.n;
import t1.x;
import x1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class Chip extends p implements e, x, Checkable {

    /* renamed from: x, reason: collision with root package name */
    public static final Rect f1290x = new Rect();
    public static final int[] y = {R.attr.state_selected};
    public static final int[] z = {R.attr.state_checkable};

    /* renamed from: e, reason: collision with root package name */
    public f f1291e;

    /* renamed from: f, reason: collision with root package name */
    public InsetDrawable f1292f;

    /* renamed from: g, reason: collision with root package name */
    public RippleDrawable f1293g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f1294h;

    /* renamed from: j, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f1295j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1296k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1297l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1298m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1299n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1300o;

    /* renamed from: p, reason: collision with root package name */
    public int f1301p;

    /* renamed from: q, reason: collision with root package name */
    public int f1302q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1303r;

    /* renamed from: s, reason: collision with root package name */
    public final d f1304s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1305t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f1306u;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f1307v;

    /* renamed from: w, reason: collision with root package name */
    public final b f1308w;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(a.a(context, attributeSet, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action), attributeSet);
        this.f1306u = new Rect();
        this.f1307v = new RectF();
        this.f1308w = new b(0, this);
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
        Context context3 = fVar.f3748l0;
        int[] iArr = d1.a.f1762c;
        TypedArray typedArrayE = k.e(context3, attributeSet, iArr, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        fVar.L0 = typedArrayE.hasValue(37);
        Context context4 = fVar.f3748l0;
        ColorStateList colorStateListD = v.D(context4, typedArrayE, 24);
        if (fVar.E != colorStateListD) {
            fVar.E = colorStateListD;
            fVar.onStateChange(fVar.getState());
        }
        ColorStateList colorStateListD2 = v.D(context4, typedArrayE, 11);
        if (fVar.F != colorStateListD2) {
            fVar.F = colorStateListD2;
            fVar.onStateChange(fVar.getState());
        }
        float dimension = typedArrayE.getDimension(19, 0.0f);
        if (fVar.G != dimension) {
            fVar.G = dimension;
            fVar.invalidateSelf();
            fVar.z();
        }
        if (typedArrayE.hasValue(12)) {
            fVar.F(typedArrayE.getDimension(12, 0.0f));
        }
        fVar.K(v.D(context4, typedArrayE, 22));
        fVar.L(typedArrayE.getDimension(23, 0.0f));
        fVar.V(v.D(context4, typedArrayE, 36));
        CharSequence text = typedArrayE.getText(5);
        text = text == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : text;
        if (!TextUtils.equals(fVar.L, text)) {
            fVar.L = text;
            fVar.f3754r0.d = true;
            fVar.invalidateSelf();
            fVar.z();
        }
        r1.d dVar = (!typedArrayE.hasValue(0) || (resourceId3 = typedArrayE.getResourceId(0, 0)) == 0) ? null : new r1.d(context4, resourceId3);
        dVar.f5082l = typedArrayE.getDimension(1, dVar.f5082l);
        fVar.W(dVar);
        int i8 = typedArrayE.getInt(3, 0);
        if (i8 == 1) {
            fVar.I0 = TextUtils.TruncateAt.START;
        } else if (i8 == 2) {
            fVar.I0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i8 == 3) {
            fVar.I0 = TextUtils.TruncateAt.END;
        }
        fVar.J(typedArrayE.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            fVar.J(typedArrayE.getBoolean(15, false));
        }
        fVar.G(v.F(context4, typedArrayE, 14));
        if (typedArrayE.hasValue(17)) {
            fVar.I(v.D(context4, typedArrayE, 17));
        }
        fVar.H(typedArrayE.getDimension(16, -1.0f));
        fVar.S(typedArrayE.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            fVar.S(typedArrayE.getBoolean(26, false));
        }
        fVar.M(v.F(context4, typedArrayE, 25));
        fVar.R(v.D(context4, typedArrayE, 30));
        fVar.O(typedArrayE.getDimension(28, 0.0f));
        fVar.B(typedArrayE.getBoolean(6, false));
        fVar.E(typedArrayE.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            fVar.E(typedArrayE.getBoolean(8, false));
        }
        fVar.C(v.F(context4, typedArrayE, 7));
        if (typedArrayE.hasValue(9)) {
            fVar.D(v.D(context4, typedArrayE, 9));
        }
        fVar.f3739b0 = (!typedArrayE.hasValue(39) || (resourceId2 = typedArrayE.getResourceId(39, 0)) == 0) ? null : e1.b.a(context4, resourceId2);
        fVar.f3740c0 = (!typedArrayE.hasValue(33) || (resourceId = typedArrayE.getResourceId(33, 0)) == 0) ? null : e1.b.a(context4, resourceId);
        float dimension2 = typedArrayE.getDimension(21, 0.0f);
        if (fVar.f3741d0 != dimension2) {
            fVar.f3741d0 = dimension2;
            fVar.invalidateSelf();
            fVar.z();
        }
        fVar.U(typedArrayE.getDimension(35, 0.0f));
        fVar.T(typedArrayE.getDimension(34, 0.0f));
        float dimension3 = typedArrayE.getDimension(41, 0.0f);
        if (fVar.f3744g0 != dimension3) {
            fVar.f3744g0 = dimension3;
            fVar.invalidateSelf();
            fVar.z();
        }
        float dimension4 = typedArrayE.getDimension(40, 0.0f);
        if (fVar.f3745h0 != dimension4) {
            fVar.f3745h0 = dimension4;
            fVar.invalidateSelf();
            fVar.z();
        }
        fVar.P(typedArrayE.getDimension(29, 0.0f));
        fVar.N(typedArrayE.getDimension(27, 0.0f));
        float dimension5 = typedArrayE.getDimension(13, 0.0f);
        if (fVar.k0 != dimension5) {
            fVar.k0 = dimension5;
            fVar.invalidateSelf();
            fVar.z();
        }
        fVar.K0 = typedArrayE.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayE.recycle();
        k.a(context2, attributeSet, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action);
        this.f1300o = typedArrayObtainStyledAttributes.getBoolean(32, false);
        TypedValue typedValueD = z.D(context2, com.stepos.stepclaw.R.attr.minTouchTargetSize);
        this.f1302q = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (int) ((typedValueD == null || typedValueD.type != 5) ? context2.getResources().getDimension(com.stepos.stepclaw.R.dimen.mtrl_min_touch_target_size) : typedValueD.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(fVar);
        fVar.l(getElevation());
        k.a(context2, attributeSet, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f1304s = new d(this, this);
        d();
        if (!zHasValue) {
            setOutlineProvider(new c(this));
        }
        setChecked(this.f1296k);
        setText(fVar.L);
        setEllipsize(fVar.I0);
        g();
        if (!this.f1291e.J0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.f1300o) {
            setMinHeight(this.f1302q);
        }
        this.f1301p = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: l1.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f3733a.f1295j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.f1307v;
        rectF.setEmpty();
        if (c() && this.f1294h != null) {
            f fVar = this.f1291e;
            Rect bounds = fVar.getBounds();
            rectF.setEmpty();
            if (fVar.Z()) {
                float f3 = fVar.k0 + fVar.f3747j0 + fVar.V + fVar.f3746i0 + fVar.f3745h0;
                if (fVar.getLayoutDirection() == 0) {
                    float f7 = bounds.right;
                    rectF.right = f7;
                    rectF.left = f7 - f3;
                } else {
                    float f9 = bounds.left;
                    rectF.left = f9;
                    rectF.right = f9 + f3;
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
        int i8 = (int) closeIconTouchBounds.left;
        int i9 = (int) closeIconTouchBounds.top;
        int i10 = (int) closeIconTouchBounds.right;
        int i11 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.f1306u;
        rect.set(i8, i9, i10, i11);
        return rect;
    }

    private r1.d getTextAppearance() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3754r0.f4720f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f1298m != z2) {
            this.f1298m = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f1297l != z2) {
            this.f1297l = z2;
            refreshDrawableState();
        }
    }

    public final void b(int i8) {
        this.f1302q = i8;
        if (!this.f1300o) {
            InsetDrawable insetDrawable = this.f1292f;
            if (insetDrawable == null) {
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f1292f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i8 - ((int) this.f1291e.G));
        int iMax2 = Math.max(0, i8 - this.f1291e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f1292f;
            if (insetDrawable2 == null) {
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f1292f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int i9 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i10 = iMax > 0 ? iMax / 2 : 0;
        if (this.f1292f != null) {
            Rect rect = new Rect();
            this.f1292f.getPadding(rect);
            if (rect.top == i10 && rect.bottom == i10 && rect.left == i9 && rect.right == i9) {
                e();
                return;
            }
        }
        if (getMinHeight() != i8) {
            setMinHeight(i8);
        }
        if (getMinWidth() != i8) {
            setMinWidth(i8);
        }
        this.f1292f = new InsetDrawable((Drawable) this.f1291e, i9, i10, i9, i10);
        e();
    }

    public final boolean c() {
        f fVar = this.f1291e;
        if (fVar == null) {
            return false;
        }
        Drawable drawable = fVar.S;
        if (drawable == null) {
            drawable = null;
        }
        return drawable != null;
    }

    public final void d() {
        f fVar;
        if (!c() || (fVar = this.f1291e) == null || !fVar.R || this.f1294h == null) {
            a0.e(this, null);
            this.f1305t = false;
        } else {
            a0.e(this, this.f1304s);
            this.f1305t = true;
        }
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
            boolean r0 = r7.f1305t
            if (r0 != 0) goto L9
            boolean r7 = super.dispatchHoverEvent(r8)
            return r7
        L9:
            l1.d r0 = r7.f1304s
            android.view.accessibility.AccessibilityManager r1 = r0.f3096h
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
            int r1 = r0.f3101m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L6b
            if (r1 != r2) goto L39
            goto L71
        L39:
            r0.f3101m = r2
            r0.r(r2, r6)
            r0.r(r1, r5)
            return r4
        L42:
            float r7 = r8.getX()
            float r8 = r8.getY()
            com.google.android.material.chip.Chip r1 = r0.f3737q
            boolean r2 = r1.c()
            if (r2 == 0) goto L5d
            android.graphics.RectF r1 = r1.getCloseIconTouchBounds()
            boolean r7 = r1.contains(r7, r8)
            if (r7 == 0) goto L5d
            r3 = r4
        L5d:
            int r7 = r0.f3101m
            if (r7 != r3) goto L62
            goto L71
        L62:
            r0.f3101m = r3
            r0.r(r3, r6)
            r0.r(r7, r5)
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
            boolean r0 = r9.f1305t
            if (r0 != 0) goto L9
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        L9:
            l1.d r0 = r9.f1304s
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
            boolean r8 = r0.m(r5, r6)
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
            int r1 = r0.f3100l
            if (r1 == r3) goto L85
            com.google.android.material.chip.Chip r5 = r0.f3737q
            if (r1 != 0) goto L70
            r5.performClick()
            goto L85
        L70:
            if (r1 != r4) goto L85
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r1 = r5.f1294h
            if (r1 == 0) goto L7c
            r1.onClick(r5)
        L7c:
            boolean r1 = r5.f1305t
            if (r1 == 0) goto L85
            l1.d r1 = r5.f1304s
            r1.r(r4, r4)
        L85:
            r2 = r4
            goto L9d
        L87:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L93
            r1 = 2
            boolean r2 = r0.m(r1, r6)
            goto L9d
        L93:
            boolean r1 = r10.hasModifiers(r4)
            if (r1 == 0) goto L9d
            boolean r2 = r0.m(r4, r6)
        L9d:
            if (r2 == 0) goto La4
            int r0 = r0.f3100l
            if (r0 == r3) goto La4
            return r4
        La4:
            boolean r9 = super.dispatchKeyEvent(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // g.p, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1291e;
        boolean zQ = false;
        int i8 = 0;
        zQ = false;
        if (fVar != null && f.y(fVar.S)) {
            f fVar2 = this.f1291e;
            ?? IsEnabled = isEnabled();
            int i9 = IsEnabled;
            if (this.f1299n) {
                i9 = IsEnabled + 1;
            }
            int i10 = i9;
            if (this.f1298m) {
                i10 = i9 + 1;
            }
            int i11 = i10;
            if (this.f1297l) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (isChecked()) {
                i12 = i11 + 1;
            }
            int[] iArr = new int[i12];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i8 = 1;
            }
            if (this.f1299n) {
                iArr[i8] = 16842908;
                i8++;
            }
            if (this.f1298m) {
                iArr[i8] = 16843623;
                i8++;
            }
            if (this.f1297l) {
                iArr[i8] = 16842919;
                i8++;
            }
            if (isChecked()) {
                iArr[i8] = 16842913;
            }
            zQ = fVar2.Q(iArr);
        }
        if (zQ) {
            invalidate();
        }
    }

    public final void e() {
        ColorStateList colorStateListValueOf = this.f1291e.K;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        this.f1293g = new RippleDrawable(colorStateListValueOf, getBackgroundDrawable(), null);
        this.f1291e.getClass();
        setBackground(this.f1293g);
        f();
    }

    public final void f() {
        f fVar;
        if (TextUtils.isEmpty(getText()) || (fVar = this.f1291e) == null) {
            return;
        }
        int iV = (int) (fVar.v() + fVar.k0 + fVar.f3745h0);
        f fVar2 = this.f1291e;
        int iU = (int) (fVar2.u() + fVar2.f3741d0 + fVar2.f3744g0);
        if (this.f1292f != null) {
            Rect rect = new Rect();
            this.f1292f.getPadding(rect);
            iU += rect.left;
            iV += rect.right;
        }
        setPaddingRelative(iU, getPaddingTop(), iV, getPaddingBottom());
    }

    public final void g() {
        TextPaint paint = getPaint();
        f fVar = this.f1291e;
        if (fVar != null) {
            paint.drawableState = fVar.getState();
        }
        r1.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f1308w);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f1303r)) {
            return this.f1303r;
        }
        f fVar = this.f1291e;
        if (fVar == null || !fVar.X) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f1292f;
        return insetDrawable == null ? this.f1291e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.Z;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3738a0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.F;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return Math.max(0.0f, fVar.w());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f1291e;
    }

    public float getChipEndPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.k0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f fVar = this.f1291e;
        if (fVar == null || (drawable = fVar.N) == null) {
            return null;
        }
        return drawable;
    }

    public float getChipIconSize() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.P;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.O;
        }
        return null;
    }

    public float getChipMinHeight() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.G;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3741d0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.I;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.J;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        f fVar = this.f1291e;
        if (fVar == null || (drawable = fVar.S) == null) {
            return null;
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.W;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3747j0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.V;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3746i0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.U;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.I0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f1305t) {
            d dVar = this.f1304s;
            if (dVar.f3100l == 1 || dVar.f3099k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public e1.b getHideMotionSpec() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3740c0;
        }
        return null;
    }

    public float getIconEndPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3743f0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3742e0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.K;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        return this.f1291e.f5475b.f5457a;
    }

    public e1.b getShowMotionSpec() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3739b0;
        }
        return null;
    }

    public float getTextEndPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3745h0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f fVar = this.f1291e;
        if (fVar != null) {
            return fVar.f3744g0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        z.J(this, this.f1291e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i8) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i8 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, y);
        }
        f fVar = this.f1291e;
        if (fVar != null && fVar.X) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i8, Rect rect) {
        super.onFocusChanged(z2, i8, rect);
        if (this.f1305t) {
            d dVar = this.f1304s;
            int i9 = dVar.f3100l;
            if (i9 != Integer.MIN_VALUE) {
                dVar.j(i9);
            }
            if (z2) {
                dVar.m(i8, rect);
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
        f fVar = this.f1291e;
        accessibilityNodeInfo.setCheckable(fVar != null && fVar.X);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i8) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i8);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        if (this.f1301p != i8) {
            this.f1301p = i8;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
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
            boolean r0 = r5.f1297l
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.f1297l
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f1294h
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f1305t
            if (r0 == 0) goto L43
            l1.d r0 = r5.f1304s
            r0.r(r2, r2)
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
        this.f1303r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f1293g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // g.p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f1293g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // g.p, android.view.View
    public void setBackgroundResource(int i8) {
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

    public void setCheckable(boolean z2) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.B(z2);
        }
    }

    public void setCheckableResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.B(fVar.f3748l0.getResources().getBoolean(i8));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        f fVar = this.f1291e;
        if (fVar == null) {
            this.f1296k = z2;
        } else if (fVar.X) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.C(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i8) {
        setCheckedIconVisible(i8);
    }

    public void setCheckedIconResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.C(h.p(fVar.f3748l0, i8));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.D(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.D(z.t(fVar.f3748l0, i8));
        }
    }

    public void setCheckedIconVisible(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.E(fVar.f3748l0.getResources().getBoolean(i8));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.F == colorStateList) {
            return;
        }
        fVar.F = colorStateList;
        fVar.onStateChange(fVar.getState());
    }

    public void setChipBackgroundColorResource(int i8) {
        ColorStateList colorStateListT;
        f fVar = this.f1291e;
        if (fVar == null || fVar.F == (colorStateListT = z.t(fVar.f3748l0, i8))) {
            return;
        }
        fVar.F = colorStateListT;
        fVar.onStateChange(fVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.F(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.F(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setChipDrawable(f fVar) {
        f fVar2 = this.f1291e;
        if (fVar2 != fVar) {
            if (fVar2 != null) {
                fVar2.H0 = new WeakReference(null);
            }
            this.f1291e = fVar;
            fVar.J0 = false;
            fVar.H0 = new WeakReference(this);
            b(this.f1302q);
        }
    }

    public void setChipEndPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.k0 == f3) {
            return;
        }
        fVar.k0 = f3;
        fVar.invalidateSelf();
        fVar.z();
    }

    public void setChipEndPaddingResource(int i8) throws Resources.NotFoundException {
        f fVar = this.f1291e;
        if (fVar != null) {
            float dimension = fVar.f3748l0.getResources().getDimension(i8);
            if (fVar.k0 != dimension) {
                fVar.k0 = dimension;
                fVar.invalidateSelf();
                fVar.z();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.G(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i8) {
        setChipIconVisible(i8);
    }

    public void setChipIconResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.G(h.p(fVar.f3748l0, i8));
        }
    }

    public void setChipIconSize(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.H(f3);
        }
    }

    public void setChipIconSizeResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.H(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.I(colorStateList);
        }
    }

    public void setChipIconTintResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.I(z.t(fVar.f3748l0, i8));
        }
    }

    public void setChipIconVisible(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.J(fVar.f3748l0.getResources().getBoolean(i8));
        }
    }

    public void setChipMinHeight(float f3) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.G == f3) {
            return;
        }
        fVar.G = f3;
        fVar.invalidateSelf();
        fVar.z();
    }

    public void setChipMinHeightResource(int i8) throws Resources.NotFoundException {
        f fVar = this.f1291e;
        if (fVar != null) {
            float dimension = fVar.f3748l0.getResources().getDimension(i8);
            if (fVar.G != dimension) {
                fVar.G = dimension;
                fVar.invalidateSelf();
                fVar.z();
            }
        }
    }

    public void setChipStartPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.f3741d0 == f3) {
            return;
        }
        fVar.f3741d0 = f3;
        fVar.invalidateSelf();
        fVar.z();
    }

    public void setChipStartPaddingResource(int i8) throws Resources.NotFoundException {
        f fVar = this.f1291e;
        if (fVar != null) {
            float dimension = fVar.f3748l0.getResources().getDimension(i8);
            if (fVar.f3741d0 != dimension) {
                fVar.f3741d0 = dimension;
                fVar.invalidateSelf();
                fVar.z();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.K(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.K(z.t(fVar.f3748l0, i8));
        }
    }

    public void setChipStrokeWidth(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.L(f3);
        }
    }

    public void setChipStrokeWidthResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.L(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i8) {
        setText(getResources().getString(i8));
    }

    public void setCloseIcon(Drawable drawable) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.M(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.W == charSequence) {
            return;
        }
        String str = c0.b.f1038b;
        c0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? c0.b.f1040e : c0.b.d;
        bVar.getClass();
        c0.f fVar2 = g.f1048a;
        fVar.W = bVar.c(charSequence);
        fVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i8) {
        setCloseIconVisible(i8);
    }

    public void setCloseIconEndPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.N(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.N(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setCloseIconResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.M(h.p(fVar.f3748l0, i8));
        }
        d();
    }

    public void setCloseIconSize(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.O(f3);
        }
    }

    public void setCloseIconSizeResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.O(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setCloseIconStartPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.P(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.P(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.R(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.R(z.t(fVar.f3748l0, i8));
        }
    }

    public void setCloseIconVisible(int i8) {
        setCloseIconVisible(getResources().getBoolean(i8));
    }

    @Override // g.p, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // g.p, android.widget.TextView
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
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i8, i9, i10, i11);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i8, i9, i10, i11);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.l(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f1291e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.I0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f1300o = z2;
        b(this.f1302q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i8) {
        if (i8 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i8);
        }
    }

    public void setHideMotionSpec(e1.b bVar) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.f3740c0 = bVar;
        }
    }

    public void setHideMotionSpecResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.f3740c0 = e1.b.a(fVar.f3748l0, i8);
        }
    }

    public void setIconEndPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.T(f3);
        }
    }

    public void setIconEndPaddingResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.T(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    public void setIconStartPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.U(f3);
        }
    }

    public void setIconStartPaddingResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.U(fVar.f3748l0.getResources().getDimension(i8));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i8) {
        if (this.f1291e == null) {
            return;
        }
        super.setLayoutDirection(i8);
    }

    @Override // android.widget.TextView
    public void setLines(int i8) {
        if (i8 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i8);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i8) {
        if (i8 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i8);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i8) {
        super.setMaxWidth(i8);
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.K0 = i8;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i8) {
        if (i8 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i8);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f1295j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f1294h = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.V(colorStateList);
        }
        this.f1291e.getClass();
        e();
    }

    public void setRippleColorResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.V(z.t(fVar.f3748l0, i8));
            this.f1291e.getClass();
            e();
        }
    }

    @Override // t1.x
    public void setShapeAppearanceModel(n nVar) {
        this.f1291e.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(e1.b bVar) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.f3739b0 = bVar;
        }
    }

    public void setShowMotionSpecResource(int i8) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.f3739b0 = e1.b.a(fVar.f3748l0, i8);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f fVar = this.f1291e;
        if (fVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        super.setText(fVar.J0 ? null : charSequence, bufferType);
        f fVar2 = this.f1291e;
        if (fVar2 == null || TextUtils.equals(fVar2.L, charSequence)) {
            return;
        }
        fVar2.L = charSequence;
        fVar2.f3754r0.d = true;
        fVar2.invalidateSelf();
        fVar2.z();
    }

    public void setTextAppearance(r1.d dVar) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.W(dVar);
        }
        g();
    }

    public void setTextAppearanceResource(int i8) {
        setTextAppearance(getContext(), i8);
    }

    public void setTextEndPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.f3745h0 == f3) {
            return;
        }
        fVar.f3745h0 = f3;
        fVar.invalidateSelf();
        fVar.z();
    }

    public void setTextEndPaddingResource(int i8) throws Resources.NotFoundException {
        f fVar = this.f1291e;
        if (fVar != null) {
            float dimension = fVar.f3748l0.getResources().getDimension(i8);
            if (fVar.f3745h0 != dimension) {
                fVar.f3745h0 = dimension;
                fVar.invalidateSelf();
                fVar.z();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i8, float f3) {
        super.setTextSize(i8, f3);
        f fVar = this.f1291e;
        if (fVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i8, f3, getResources().getDisplayMetrics());
            i iVar = fVar.f3754r0;
            r1.d dVar = iVar.f4720f;
            if (dVar != null) {
                dVar.f5082l = fApplyDimension;
                iVar.f4716a.setTextSize(fApplyDimension);
                fVar.z();
                fVar.invalidateSelf();
            }
        }
        g();
    }

    public void setTextStartPadding(float f3) {
        f fVar = this.f1291e;
        if (fVar == null || fVar.f3744g0 == f3) {
            return;
        }
        fVar.f3744g0 = f3;
        fVar.invalidateSelf();
        fVar.z();
    }

    public void setTextStartPaddingResource(int i8) throws Resources.NotFoundException {
        f fVar = this.f1291e;
        if (fVar != null) {
            float dimension = fVar.f3748l0.getResources().getDimension(i8);
            if (fVar.f3744g0 != dimension) {
                fVar.f3744g0 = dimension;
                fVar.invalidateSelf();
                fVar.z();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.S(z2);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z2) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.E(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.J(z2);
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
    public final void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.W(new r1.d(fVar.f3748l0, i8));
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i8) {
        super.setTextAppearance(i8);
        f fVar = this.f1291e;
        if (fVar != null) {
            fVar.W(new r1.d(fVar.f3748l0, i8));
        }
        g();
    }

    public void setInternalOnCheckedChangeListener(p1.e eVar) {
    }
}

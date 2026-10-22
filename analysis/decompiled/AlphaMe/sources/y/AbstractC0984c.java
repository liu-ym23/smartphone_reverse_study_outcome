package y;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import java.util.HashMap;
import v.AbstractC0950j;
import v.C0944d;

/* renamed from: y.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0984c extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f15945a;

    /* renamed from: b, reason: collision with root package name */
    public int f15946b;

    /* renamed from: c, reason: collision with root package name */
    public Context f15947c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC0950j f15948d;

    /* renamed from: e, reason: collision with root package name */
    public String f15949e;

    /* renamed from: f, reason: collision with root package name */
    public String f15950f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f15951g;

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r5 = this;
            if (r6 == 0) goto La7
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto La7
        La:
            android.content.Context r0 = r5.f15947c
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L21
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L21:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L31
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L32
        L31:
            r1 = r2
        L32:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5b
            if (r1 == 0) goto L5b
            boolean r3 = r6 instanceof java.lang.String
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f3241m
            if (r3 == 0) goto L4f
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f3241m
            java.lang.Object r3 = r3.get(r6)
            goto L50
        L4f:
            r3 = r2
        L50:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5b
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5c
        L5b:
            r3 = 0
        L5c:
            if (r3 != 0) goto L64
            if (r1 == 0) goto L64
            int r3 = r5.f(r1, r6)
        L64:
            if (r3 != 0) goto L70
            java.lang.Class<y.q> r1 = y.q.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L70
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L70
        L70:
            if (r3 != 0) goto L80
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L80:
            if (r3 == 0) goto L8f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.util.HashMap r1 = r5.f15951g
            r1.put(r0, r6)
            r5.b(r3)
            goto La7
        L8f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not find id of \""
            r5.<init>(r0)
            r5.append(r6)
            java.lang.String r6 = "\""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ConstraintHelper"
            android.util.Log.w(r6, r5)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y.AbstractC0984c.a(java.lang.String):void");
    }

    public final void b(int i4) {
        if (i4 == getId()) {
            return;
        }
        int i5 = this.f15946b + 1;
        int[] iArr = this.f15945a;
        if (i5 > iArr.length) {
            this.f15945a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f15945a;
        int i6 = this.f15946b;
        iArr2[i6] = i4;
        this.f15946b = i6 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f15947c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = constraintLayout.getChildAt(i4);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof e) && strTrim.equals(((e) layoutParams).f15976Y)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final void d(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i4 = 0; i4 < this.f15946b; i4++) {
            View view = (View) constraintLayout.f3229a.get(this.f15945a[i4]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > Property.DEFAULT_FLOAT_VALUE) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void e(ConstraintLayout constraintLayout) {
    }

    public final int f(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f15947c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = constraintLayout.getChildAt(i4);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f16152b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == 35) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f15949e = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f15950f = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f15945a, this.f15946b);
    }

    public abstract void h(C0944d c0944d, boolean z4);

    public final void i() {
        if (this.f15948d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof e) {
            ((e) layoutParams).f16009p0 = this.f15948d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f15949e;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f15950f;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f15949e = str;
        if (str == null) {
            return;
        }
        int i4 = 0;
        this.f15946b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i4);
            if (iIndexOf == -1) {
                a(str.substring(i4));
                return;
            } else {
                a(str.substring(i4, iIndexOf));
                i4 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f15950f = str;
        if (str == null) {
            return;
        }
        int i4 = 0;
        this.f15946b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i4);
            if (iIndexOf == -1) {
                c(str.substring(i4));
                return;
            } else {
                c(str.substring(i4, iIndexOf));
                i4 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f15949e = null;
        this.f15946b = 0;
        for (int i4 : iArr) {
            b(i4);
        }
    }

    @Override // android.view.View
    public final void setTag(int i4, Object obj) {
        super.setTag(i4, obj);
        if (obj == null && this.f15949e == null) {
            b(i4);
        }
    }
}

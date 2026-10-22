package z2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: c, reason: collision with root package name */
    public int[] f16184c;

    /* renamed from: f, reason: collision with root package name */
    public int f16185f;

    /* renamed from: g, reason: collision with root package name */
    public Context f16186g;

    /* renamed from: h, reason: collision with root package name */
    public w2.a f16187h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f16188j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f16189k;

    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            r5 = this;
            android.content.Context r0 = r5.f16186g
            int r1 = r6.length()
            if (r1 != 0) goto La
            goto La4
        La:
            if (r0 != 0) goto Le
            goto La4
        Le:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L20
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L20:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L30
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L31
        L30:
            r1 = r2
        L31:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L58
            if (r1 == 0) goto L58
            if (r6 == 0) goto L4c
            java.util.HashMap r3 = r1.f1007q
            if (r3 == 0) goto L4c
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L4c
            java.util.HashMap r3 = r1.f1007q
            java.lang.Object r3 = r3.get(r6)
            goto L4d
        L4c:
            r3 = r2
        L4d:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L58
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L59
        L58:
            r3 = 0
        L59:
            if (r3 != 0) goto L61
            if (r1 == 0) goto L61
            int r3 = r5.d(r1, r6)
        L61:
            if (r3 != 0) goto L6d
            java.lang.Class<z2.p> r1 = z2.p.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L6d
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L6d
        L6d:
            if (r3 != 0) goto L7d
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L7d:
            if (r3 == 0) goto L8c
            java.util.HashMap r0 = r5.f16189k
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r6)
            r5.b(r3)
            goto La4
        L8c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not find id of \""
            r5.<init>(r0)
            r5.append(r6)
            java.lang.String r6 = "\""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ConstraintHelper"
            android.util.Log.w(r6, r5)
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.b.a(java.lang.String):void");
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i3 = this.f16185f + 1;
        int[] iArr = this.f16184c;
        if (i3 > iArr.length) {
            this.f16184c = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f16184c;
        int i10 = this.f16185f;
        iArr2[i10] = i;
        this.f16185f = i10 + 1;
    }

    public final void c(String str) {
        if (str.length() == 0 || this.f16186g == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof d) && strTrim.equals(((d) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.f16186g.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
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
        }
        return 0;
    }

    public final void e() {
        if (this.f16187h == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof d) {
            ((d) layoutParams).f16219p0 = this.f16187h;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f16184c, this.f16185f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.i;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f16188j;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.i = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f16185f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f16188j = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f16185f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                c(str.substring(i));
                return;
            } else {
                c(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.i = null;
        this.f16185f = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.i == null) {
            b(i);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}

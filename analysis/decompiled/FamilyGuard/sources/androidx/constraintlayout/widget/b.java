package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.minor.Minor;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: a, reason: collision with root package name */
    protected int[] f8903a;

    /* renamed from: b, reason: collision with root package name */
    protected int f8904b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f8905c;

    /* renamed from: d, reason: collision with root package name */
    protected v.i f8906d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f8907e;

    /* renamed from: f, reason: collision with root package name */
    protected String f8908f;

    /* renamed from: g, reason: collision with root package name */
    protected String f8909g;

    /* renamed from: h, reason: collision with root package name */
    private View[] f8910h;

    /* renamed from: i, reason: collision with root package name */
    protected HashMap<Integer, String> f8911i;

    public b(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f8903a = new int[32];
        this.f8907e = false;
        this.f8910h = null;
        this.f8911i = new HashMap<>();
        this.f8905c = context;
        m(null);
    }

    private void d(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f8905c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iK = k(strTrim);
        if (iK != 0) {
            this.f8911i.put(Integer.valueOf(iK), strTrim);
            e(iK);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void e(int i5) {
        if (i5 == getId()) {
            return;
        }
        int i6 = this.f8904b + 1;
        int[] iArr = this.f8903a;
        if (i6 > iArr.length) {
            this.f8903a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f8903a;
        int i7 = this.f8904b;
        iArr2[i7] = i5;
        this.f8904b = i7 + 1;
    }

    private void f(String str) {
        if (str == null || str.length() == 0 || this.f8905c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f8831c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    e(childAt.getId());
                }
            }
        }
    }

    private int j(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f8905c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
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

    private int k(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iJ = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objG = constraintLayout.g(0, str);
            if (objG instanceof Integer) {
                iJ = ((Integer) objG).intValue();
            }
        }
        if (iJ == 0 && constraintLayout != null) {
            iJ = j(constraintLayout, str);
        }
        if (iJ == 0) {
            try {
                iJ = h.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iJ == 0 ? this.f8905c.getResources().getIdentifier(str, Minor.COLUMN_ID, this.f8905c.getPackageName()) : iJ;
    }

    protected void g() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        h((ConstraintLayout) parent);
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f8903a, this.f8904b);
    }

    protected void h(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i5 = 0; i5 < this.f8904b; i5++) {
            View viewI = constraintLayout.i(this.f8903a[i5]);
            if (viewI != null) {
                viewI.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewI.setTranslationZ(viewI.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void i(ConstraintLayout constraintLayout) {
    }

    protected View[] l(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f8910h;
        if (viewArr == null || viewArr.length != this.f8904b) {
            this.f8910h = new View[this.f8904b];
        }
        for (int i5 = 0; i5 < this.f8904b; i5++) {
            this.f8910h[i5] = constraintLayout.i(this.f8903a[i5]);
        }
        return this.f8910h;
    }

    protected void m(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f9319n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.f9116G1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f8908f = string;
                    setIds(string);
                } else if (index == i.f9122H1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f8909g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void n(v.e eVar, boolean z5) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f8908f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f8909g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f8907e) {
            super.onMeasure(i5, i6);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String str;
        int iJ;
        if (isInEditMode()) {
            setIds(this.f8908f);
        }
        v.i iVar = this.f8906d;
        if (iVar == null) {
            return;
        }
        iVar.a();
        for (int i5 = 0; i5 < this.f8904b; i5++) {
            int i6 = this.f8903a[i5];
            View viewI = constraintLayout.i(i6);
            if (viewI == null && (iJ = j(constraintLayout, (str = this.f8911i.get(Integer.valueOf(i6))))) != 0) {
                this.f8903a[i5] = iJ;
                this.f8911i.put(Integer.valueOf(iJ), str);
                viewI = constraintLayout.i(iJ);
            }
            if (viewI != null) {
                this.f8906d.b(constraintLayout.p(viewI));
            }
        }
        this.f8906d.c(constraintLayout.f8778c);
    }

    public void s() {
        if (this.f8906d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f8869v0 = (v.e) this.f8906d;
        }
    }

    protected void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f8908f = str;
        if (str == null) {
            return;
        }
        int i5 = 0;
        this.f8904b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i5);
            if (iIndexOf == -1) {
                d(str.substring(i5));
                return;
            } else {
                d(str.substring(i5, iIndexOf));
                i5 = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f8909g = str;
        if (str == null) {
            return;
        }
        int i5 = 0;
        this.f8904b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i5);
            if (iIndexOf == -1) {
                f(str.substring(i5));
                return;
            } else {
                f(str.substring(i5, iIndexOf));
                i5 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f8908f = null;
        this.f8904b = 0;
        for (int i5 : iArr) {
            e(i5);
        }
    }

    @Override // android.view.View
    public void setTag(int i5, Object obj) {
        super.setTag(i5, obj);
        if (obj == null && this.f8908f == null) {
            e(i5);
        }
    }

    public b(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f8903a = new int[32];
        this.f8907e = false;
        this.f8910h = null;
        this.f8911i = new HashMap<>();
        this.f8905c = context;
        m(attributeSet);
    }
}

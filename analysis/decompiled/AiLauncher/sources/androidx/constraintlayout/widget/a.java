package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.HashMap;
import o0.C4994b;
import o0.InterfaceC4993a;

/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f12685a;

    /* renamed from: b, reason: collision with root package name */
    public int f12686b;

    /* renamed from: c, reason: collision with root package name */
    public Context f12687c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC4993a f12688d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12689e;

    /* renamed from: f, reason: collision with root package name */
    public String f12690f;

    /* renamed from: g, reason: collision with root package name */
    public String f12691g;

    /* renamed from: h, reason: collision with root package name */
    public View[] f12692h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap<Integer, String> f12693i;

    public a(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f12685a = new int[32];
        this.f12689e = false;
        this.f12692h = null;
        this.f12693i = new HashMap<>();
        this.f12687c = context;
        o(null);
    }

    public final void e(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f12687c == null) {
            return;
        }
        String strTrim = str.trim();
        int iM = m(strTrim);
        if (iM != 0) {
            this.f12693i.put(Integer.valueOf(iM), strTrim);
            f(iM);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public final void f(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f12686b + 1;
        int[] iArr = this.f12685a;
        if (i11 > iArr.length) {
            this.f12685a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f12685a;
        int i12 = this.f12686b;
        iArr2[i12] = i10;
        this.f12686b = i12 + 1;
    }

    public final void g(String str) {
        if (str == null || str.length() == 0 || this.f12687c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f12631c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    f(childAt.getId());
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f12685a, this.f12686b);
    }

    public void h() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        i((ConstraintLayout) parent);
    }

    public void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f12686b; i10++) {
            View viewById = constraintLayout.getViewById(this.f12685a[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public final int[] k(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String[] strArrSplit = str.split(Const.STR_MART_COMMA);
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        for (String str2 : strArrSplit) {
            int iM = m(str2.trim());
            if (iM != 0) {
                iArr[i10] = iM;
                i10++;
            }
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public final int l(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f12687c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
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

    public final int m(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iL = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                iL = ((Integer) designInformation).intValue();
            }
        }
        if (iL == 0 && constraintLayout != null) {
            iL = l(constraintLayout, str);
        }
        if (iL == 0) {
            try {
                iL = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iL == 0 ? this.f12687c.getResources().getIdentifier(str, "id", this.f12687c.getPackageName()) : iL;
    }

    public View[] n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f12692h;
        if (viewArr == null || viewArr.length != this.f12686b) {
            this.f12692h = new View[this.f12686b];
        }
        for (int i10 = 0; i10 < this.f12686b; i10++) {
            this.f12692h[i10] = constraintLayout.getViewById(this.f12685a[i10]);
        }
        return this.f12692h;
    }

    public void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f12690f = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f12691g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f12690f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f12691g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f12689e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(c.a aVar, C4994b c4994b, ConstraintLayout.b bVar, SparseArray<ConstraintWidget> sparseArray) {
        c.b bVar2 = aVar.f12725e;
        int[] iArr = bVar2.f12789k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar2.f12791l0;
            if (str != null) {
                if (str.length() > 0) {
                    c.b bVar3 = aVar.f12725e;
                    bVar3.f12789k0 = k(bVar3.f12791l0);
                } else {
                    aVar.f12725e.f12789k0 = null;
                }
            }
        }
        if (c4994b == null) {
            return;
        }
        c4994b.b();
        if (aVar.f12725e.f12789k0 == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            int[] iArr2 = aVar.f12725e.f12789k0;
            if (i10 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(iArr2[i10]);
            if (constraintWidget != null) {
                c4994b.a(constraintWidget);
            }
            i10++;
        }
    }

    public void q(ConstraintWidget constraintWidget, boolean z10) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    public void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f12690f = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f12686b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                e(str.substring(i10));
                return;
            } else {
                e(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f12691g = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f12686b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                g(str.substring(i10));
                return;
            } else {
                g(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f12690f = null;
        this.f12686b = 0;
        for (int i10 : iArr) {
            f(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f12690f == null) {
            f(i10);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    public void u(androidx.constraintlayout.core.widgets.d dVar, InterfaceC4993a interfaceC4993a, SparseArray<ConstraintWidget> sparseArray) {
        interfaceC4993a.b();
        for (int i10 = 0; i10 < this.f12686b; i10++) {
            interfaceC4993a.a(sparseArray.get(this.f12685a[i10]));
        }
    }

    public void v(ConstraintLayout constraintLayout) {
        String str;
        int iL;
        if (isInEditMode()) {
            setIds(this.f12690f);
        }
        InterfaceC4993a interfaceC4993a = this.f12688d;
        if (interfaceC4993a == null) {
            return;
        }
        interfaceC4993a.b();
        for (int i10 = 0; i10 < this.f12686b; i10++) {
            int i11 = this.f12685a[i10];
            View viewById = constraintLayout.getViewById(i11);
            if (viewById == null && (iL = l(constraintLayout, (str = this.f12693i.get(Integer.valueOf(i11))))) != 0) {
                this.f12685a[i10] = iL;
                this.f12693i.put(Integer.valueOf(iL), str);
                viewById = constraintLayout.getViewById(iL);
            }
            if (viewById != null) {
                this.f12688d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f12688d.c(constraintLayout.mLayoutWidget);
    }

    public void w() {
        if (this.f12688d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f12669v0 = (ConstraintWidget) this.f12688d;
        }
    }

    public a(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f12685a = new int[32];
        this.f12689e = false;
        this.f12692h = null;
        this.f12693i = new HashMap<>();
        this.f12687c = context;
        o(attributeSet);
    }
}

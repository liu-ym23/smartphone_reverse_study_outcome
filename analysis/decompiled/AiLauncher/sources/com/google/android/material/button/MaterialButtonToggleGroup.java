package com.google.android.material.button;

import C0.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import d3.C3953a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends d {

    /* renamed from: r, reason: collision with root package name */
    public static final int f20485r = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashSet<b> f20486l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20487m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20488n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20489o;

    /* renamed from: p, reason: collision with root package name */
    public final int f20490p;

    /* renamed from: q, reason: collision with root package name */
    public Set<Integer> f20491q;

    public class a extends C1313a {
        public a() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.p0(c.g.a(0, 1, MaterialButtonToggleGroup.this.u(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public interface b {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    private String getChildrenA11yClassName() {
        return (this.f20488n ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && j(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    @Override // com.google.android.material.button.d, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        r(materialButton.getId(), materialButton.isChecked());
        N.i0(materialButton, new a());
    }

    public int getCheckedButtonId() {
        if (!this.f20488n || this.f20491q.isEmpty()) {
            return -1;
        }
        return this.f20491q.iterator().next().intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = f(i10).getId();
            if (this.f20491q.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    public final boolean j(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f20490p;
        if (i10 != -1) {
            y(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C0.c.S0(accessibilityNodeInfo).o0(c.f.b(1, getVisibleButtonCount(), false, v() ? 1 : 2));
    }

    public void q(b bVar) {
        this.f20486l.add(bVar);
    }

    public final void r(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f20491q);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f20488n && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.f20489o || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        y(hashSet);
    }

    public void s() {
        y(new HashSet());
    }

    public void setSelectionRequired(boolean z10) {
        this.f20489o = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f20488n != z10) {
            this.f20488n = z10;
            s();
        }
        z();
    }

    public final void t(int i10, boolean z10) {
        Iterator<b> it = this.f20486l.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, z10);
        }
    }

    public final int u(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && j(i11)) {
                i10++;
            }
        }
        return -1;
    }

    public boolean v() {
        return this.f20488n;
    }

    public void w(MaterialButton materialButton, boolean z10) {
        if (this.f20487m) {
            return;
        }
        r(materialButton.getId(), z10);
    }

    public final void x(int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById instanceof MaterialButton) {
            this.f20487m = true;
            ((MaterialButton) viewFindViewById).setChecked(z10);
            this.f20487m = false;
        }
    }

    public final void y(Set<Integer> set) {
        Set<Integer> set2 = this.f20491q;
        this.f20491q = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id = f(i10).getId();
            x(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                t(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    public final void z() {
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).setA11yClassName(childrenA11yClassName);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20485r;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20486l = new LinkedHashSet<>();
        this.f20487m = false;
        this.f20491q = new HashSet();
        TypedArray typedArrayI = r.i(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i10, i11, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f20490p = typedArrayI.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f20489o = typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        if (this.f20502f == null) {
            this.f20502f = Z2.r.b(new Z2.a(0.0f));
        }
        setEnabled(typedArrayI.getBoolean(R$styleable.MaterialButtonToggleGroup_android_enabled, true));
        typedArrayI.recycle();
        setImportantForAccessibility(1);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}

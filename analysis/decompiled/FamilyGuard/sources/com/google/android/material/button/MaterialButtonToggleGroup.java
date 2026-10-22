package com.google.android.material.button;

import E.c;
import a1.C0409b;
import a1.C0417j;
import a1.C0418k;
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
import androidx.core.view.C0456a;
import androidx.core.view.H;
import com.google.android.material.internal.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import t1.C1108a;
import t1.p;
import x1.C1282a;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends d {

    /* renamed from: r, reason: collision with root package name */
    private static final int f12422r = C0417j.f6930u;

    /* renamed from: l, reason: collision with root package name */
    private final LinkedHashSet<b> f12423l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f12424m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12425n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12426o;

    /* renamed from: p, reason: collision with root package name */
    private final int f12427p;

    /* renamed from: q, reason: collision with root package name */
    private Set<Integer> f12428q;

    class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.g0(c.f.a(0, 1, MaterialButtonToggleGroup.this.u(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public interface b {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i5, boolean z5);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6729p);
    }

    private String getChildrenA11yClassName() {
        return (this.f12425n ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if ((getChildAt(i6) instanceof MaterialButton) && j(i6)) {
                i5++;
            }
        }
        return i5;
    }

    private boolean j(int i5) {
        return getChildAt(i5).getVisibility() != 8;
    }

    private void r(int i5, boolean z5) {
        if (i5 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i5);
            return;
        }
        HashSet hashSet = new HashSet(this.f12428q);
        if (z5 && !hashSet.contains(Integer.valueOf(i5))) {
            if (this.f12425n && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i5));
        } else {
            if (z5 || !hashSet.contains(Integer.valueOf(i5))) {
                return;
            }
            if (!this.f12426o || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i5));
            }
        }
        y(hashSet);
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    private void t(int i5, boolean z5) {
        Iterator<b> it = this.f12423l.iterator();
        while (it.hasNext()) {
            it.next().a(this, i5, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (getChildAt(i6) == view) {
                return i5;
            }
            if ((getChildAt(i6) instanceof MaterialButton) && j(i6)) {
                i5++;
            }
        }
        return -1;
    }

    private void x(int i5, boolean z5) {
        View viewFindViewById = findViewById(i5);
        if (viewFindViewById instanceof MaterialButton) {
            this.f12424m = true;
            ((MaterialButton) viewFindViewById).setChecked(z5);
            this.f12424m = false;
        }
    }

    private void y(Set<Integer> set) {
        Set<Integer> set2 = this.f12428q;
        this.f12428q = new HashSet(set);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int id = f(i5).getId();
            x(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                t(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void z() {
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            f(i5).setA11yClassName(childrenA11yClassName);
        }
    }

    @Override // com.google.android.material.button.d, android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i5, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        r(materialButton.getId(), materialButton.isChecked());
        H.k0(materialButton, new a());
    }

    public int getCheckedButtonId() {
        if (!this.f12425n || this.f12428q.isEmpty()) {
            return -1;
        }
        return this.f12428q.iterator().next().intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int id = f(i5).getId();
            if (this.f12428q.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i5 = this.f12427p;
        if (i5 != -1) {
            y(Collections.singleton(Integer.valueOf(i5)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        E.c.E0(accessibilityNodeInfo).f0(c.e.a(1, getVisibleButtonCount(), false, v() ? 1 : 2));
    }

    public void q(b bVar) {
        this.f12423l.add(bVar);
    }

    public void s() {
        y(new HashSet());
    }

    public void setSelectionRequired(boolean z5) {
        this.f12426o = z5;
    }

    public void setSingleSelection(boolean z5) {
        if (this.f12425n != z5) {
            this.f12425n = z5;
            s();
        }
        z();
    }

    public boolean v() {
        return this.f12425n;
    }

    void w(MaterialButton materialButton, boolean z5) {
        if (this.f12424m) {
            return;
        }
        r(materialButton.getId(), z5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12422r;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f12423l = new LinkedHashSet<>();
        this.f12424m = false;
        this.f12428q = new HashSet();
        TypedArray typedArrayI = o.i(getContext(), attributeSet, C0418k.f7207s2, i5, i6, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(C0418k.f7231w2, false));
        this.f12427p = typedArrayI.getResourceId(C0418k.f7219u2, -1);
        this.f12426o = typedArrayI.getBoolean(C0418k.f7225v2, false);
        if (this.f12439f == null) {
            this.f12439f = p.c(new C1108a(0.0f));
        }
        setEnabled(typedArrayI.getBoolean(C0418k.f7213t2, true));
        typedArrayI.recycle();
        setImportantForAccessibility(1);
    }

    public void setSingleSelection(int i5) {
        setSingleSelection(getResources().getBoolean(i5));
    }
}

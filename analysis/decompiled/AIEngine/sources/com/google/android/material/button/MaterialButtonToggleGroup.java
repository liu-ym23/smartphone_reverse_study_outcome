package com.google.android.material.button;

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
import com.google.android.material.internal.i;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import v0.e0;
import w0.b;
import y4.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends c {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f4754u = 0;

    /* renamed from: o, reason: collision with root package name */
    public final LinkedHashSet<b> f4755o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4756p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4757q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final int f4758s;

    /* renamed from: t, reason: collision with root package name */
    public HashSet f4759t;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends v0.a {
        public a() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            int i10 = MaterialButtonToggleGroup.f4754u;
            int i11 = -1;
            if (view instanceof MaterialButton) {
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                    if (i12 >= materialButtonToggleGroup.getChildCount()) {
                        break;
                    }
                    if (materialButtonToggleGroup.getChildAt(i12) == view) {
                        i11 = i13;
                        break;
                    }
                    if ((materialButtonToggleGroup.getChildAt(i12) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i12).getVisibility() != 8) {
                        i13++;
                    }
                    i12++;
                }
            }
            bVar.j(b.d.a(0, 1, i11, 1, ((MaterialButton) view).r));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a(int i10, boolean z);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(b5.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f4755o = new LinkedHashSet<>();
        this.f4756p = false;
        this.f4759t = new HashSet();
        TypedArray typedArrayD = i.d(getContext(), attributeSet, k4.a.f9911p, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(7, false));
        this.f4758s = typedArrayD.getResourceId(2, -1);
        this.r = typedArrayD.getBoolean(4, false);
        if (this.h == null) {
            this.h = o.b(new y4.a(0.0f));
        }
        setEnabled(typedArrayD.getBoolean(0, true));
        typedArrayD.recycle();
        setImportantForAccessibility(1);
    }

    private String getChildrenA11yClassName() {
        return (this.f4757q ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && getChildAt(i11).getVisibility() != 8) {
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

    @Override // com.google.android.material.button.c, android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.r);
        e0.j(materialButton, new a());
    }

    public final void f(int i10, boolean z) {
        if (i10 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f4759t);
        if (z && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f4757q && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.r || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        g(hashSet);
    }

    public final void g(Set<Integer> set) {
        HashSet hashSet = this.f4759t;
        this.f4759t = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = ((MaterialButton) getChildAt(i10)).getId();
            boolean zContains = set.contains(Integer.valueOf(id2));
            View viewFindViewById = findViewById(id2);
            if (viewFindViewById instanceof MaterialButton) {
                this.f4756p = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f4756p = false;
            }
            if (hashSet.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                boolean zContains2 = set.contains(Integer.valueOf(id2));
                Iterator<b> it = this.f4755o.iterator();
                while (it.hasNext()) {
                    it.next().a(id2, zContains2);
                }
            }
        }
        invalidate();
    }

    public int getCheckedButtonId() {
        if (!this.f4757q || this.f4759t.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f4759t.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = ((MaterialButton) getChildAt(i10)).getId();
            if (this.f4759t.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f4758s;
        if (i10 != -1) {
            g(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f4757q ? 1 : 2));
    }

    public void setSelectionRequired(boolean z) {
        this.r = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f4757q != z) {
            this.f4757q = z;
            g(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            ((MaterialButton) getChildAt(i10)).setA11yClassName(childrenA11yClassName);
        }
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}

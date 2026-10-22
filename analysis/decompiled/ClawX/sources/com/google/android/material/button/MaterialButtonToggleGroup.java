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
import com.google.android.material.timepicker.i;
import com.stepos.stepclaw.R;
import e0.a0;
import j1.f;
import j1.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p1.k;
import t1.y;
import x1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends f {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f1280r = 0;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashSet f1281l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1282m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1283n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1284o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1285p;

    /* renamed from: q, reason: collision with root package name */
    public HashSet f1286q;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet);
        this.f1281l = new LinkedHashSet();
        this.f1282m = false;
        this.f1286q = new HashSet();
        TypedArray typedArrayE = k.e(getContext(), attributeSet, d1.a.f1769k, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayE.getBoolean(7, false));
        this.f1285p = typedArrayE.getResourceId(2, -1);
        this.f1284o = typedArrayE.getBoolean(4, false);
        if (this.f3480f == null) {
            this.f3480f = y.b(new t1.a(0.0f));
        }
        setEnabled(typedArrayE.getBoolean(0, true));
        typedArrayE.recycle();
        setImportantForAccessibility(1);
    }

    private String getChildrenA11yClassName() {
        return (this.f1283n ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            if ((getChildAt(i9) instanceof MaterialButton) && getChildAt(i9).getVisibility() != 8) {
                i8++;
            }
        }
        return i8;
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    @Override // j1.f, android.view.ViewGroup
    public final void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i8, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.f1271p);
        a0.e(materialButton, new h(this, 0));
    }

    public final void f(int i8, boolean z) {
        if (i8 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i8);
            return;
        }
        HashSet hashSet = new HashSet(this.f1286q);
        if (z && !hashSet.contains(Integer.valueOf(i8))) {
            if (this.f1283n && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i8));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i8))) {
                return;
            }
            if (!this.f1284o || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i8));
            }
        }
        g(hashSet);
    }

    public final void g(Set set) {
        HashSet hashSet = this.f1286q;
        this.f1286q = new HashSet(set);
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            int id = ((MaterialButton) getChildAt(i8)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f1282m = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f1282m = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f1281l.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).a();
                }
            }
        }
        invalidate();
    }

    public int getCheckedButtonId() {
        if (!this.f1283n || this.f1286q.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f1286q.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            int id = ((MaterialButton) getChildAt(i8)).getId();
            if (this.f1286q.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i8 = this.f1285p;
        if (i8 != -1) {
            g(Collections.singleton(Integer.valueOf(i8)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f1283n ? 1 : 2));
    }

    public void setSelectionRequired(boolean z) {
        this.f1284o = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f1283n != z) {
            this.f1283n = z;
            g(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            ((MaterialButton) getChildAt(i8)).setA11yClassName(childrenA11yClassName);
        }
    }

    public void setSingleSelection(int i8) {
        setSingleSelection(getResources().getBoolean(i8));
    }
}

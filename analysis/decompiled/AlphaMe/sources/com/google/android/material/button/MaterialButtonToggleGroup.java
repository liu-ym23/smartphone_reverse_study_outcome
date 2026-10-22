package com.google.android.material.button;

import K.S;
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
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.l;
import com.google.android.material.timepicker.j;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m1.AbstractC0769a;
import y1.C0987a;
import y1.z;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends d {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f10500q = 0;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f10501k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10502l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10503m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10504n;

    /* renamed from: o, reason: collision with root package name */
    public final int f10505o;

    /* renamed from: p, reason: collision with root package name */
    public HashSet f10506p;

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(C1.a.b(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet);
        this.f10501k = new LinkedHashSet();
        this.f10502l = false;
        this.f10506p = new HashSet();
        TypedArray typedArrayE = l.e(getContext(), attributeSet, AbstractC0769a.f13550p, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayE.getBoolean(7, false));
        this.f10505o = typedArrayE.getResourceId(2, -1);
        this.f10504n = typedArrayE.getBoolean(4, false);
        if (this.f10513f == null) {
            this.f10513f = z.b(new C0987a(Property.DEFAULT_FLOAT_VALUE));
        }
        setEnabled(typedArrayE.getBoolean(0, true));
        typedArrayE.recycle();
        setImportantForAccessibility(1);
    }

    @NonNull
    private String getChildrenA11yClassName() {
        return (this.f10503m ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof MaterialButton) && getChildAt(i5).getVisibility() != 8) {
                i4++;
            }
        }
        return i4;
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    @Override // com.google.android.material.button.d, android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i4, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.f10487o);
        S.h(materialButton, new r0.d(1, this));
    }

    public final void f(int i4, boolean z4) {
        if (i4 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i4);
            return;
        }
        HashSet hashSet = new HashSet(this.f10506p);
        if (z4 && !hashSet.contains(Integer.valueOf(i4))) {
            if (this.f10503m && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i4));
        } else {
            if (z4 || !hashSet.contains(Integer.valueOf(i4))) {
                return;
            }
            if (!this.f10504n || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i4));
            }
        }
        g(hashSet);
    }

    public final void g(Set set) {
        HashSet hashSet = this.f10506p;
        this.f10506p = new HashSet(set);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            int id = ((MaterialButton) getChildAt(i4)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f10502l = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f10502l = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.f10501k.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).a();
                }
            }
        }
        invalidate();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.f10503m || this.f10506p.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f10506p.iterator().next()).intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            int id = ((MaterialButton) getChildAt(i4)).getId();
            if (this.f10506p.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i4 = this.f10505o;
        if (i4 != -1) {
            g(Collections.singleton(Integer.valueOf(i4)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f10503m ? 1 : 2));
    }

    public void setSelectionRequired(boolean z4) {
        this.f10504n = z4;
    }

    public void setSingleSelection(boolean z4) {
        if (this.f10503m != z4) {
            this.f10503m = z4;
            g(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            ((MaterialButton) getChildAt(i4)).setA11yClassName(childrenA11yClassName);
        }
    }

    public void setSingleSelection(@BoolRes int i4) {
        setSingleSelection(getResources().getBoolean(i4));
    }
}

package com.google.android.material.chip;

import E.c;
import a1.C0417j;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.g;
import java.util.List;

/* loaded from: classes.dex */
public class b extends g {

    /* renamed from: i, reason: collision with root package name */
    private static final int f12638i = C0417j.f6925p;

    /* renamed from: e, reason: collision with root package name */
    private int f12639e;

    /* renamed from: f, reason: collision with root package name */
    private int f12640f;

    /* renamed from: g, reason: collision with root package name */
    private d f12641g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12642h;

    class a implements d {
        a(c cVar) {
        }
    }

    /* renamed from: com.google.android.material.chip.b$b, reason: collision with other inner class name */
    public static class C0163b extends ViewGroup.MarginLayoutParams {
        public C0163b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0163b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0163b(int i5, int i6) {
            super(i5, i6);
        }
    }

    @Deprecated
    public interface c {
    }

    public interface d {
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(e eVar, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            throw null;
        }
    }

    private boolean e(int i5) {
        return getChildAt(i5).getVisibility() == 0;
    }

    private int getVisibleChipCount() {
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if ((getChildAt(i6) instanceof Chip) && e(i6)) {
                i5++;
            }
        }
        return i5;
    }

    @Override // com.google.android.material.internal.g
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0163b);
    }

    int d(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof Chip) && e(i6)) {
                if (((Chip) childAt) == view) {
                    return i5;
                }
                i5++;
            }
        }
        return -1;
    }

    public boolean f() {
        throw null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0163b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0163b(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        throw null;
    }

    public List<Integer> getCheckedChipIds() {
        throw null;
    }

    public int getChipSpacingHorizontal() {
        return this.f12639e;
    }

    public int getChipSpacingVertical() {
        return this.f12640f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f12642h != -1) {
            throw null;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        E.c.E0(accessibilityNodeInfo).f0(c.e.a(getRowCount(), c() ? getVisibleChipCount() : -1, false, f() ? 1 : 2));
    }

    public void setChipSpacing(int i5) {
        setChipSpacingHorizontal(i5);
        setChipSpacingVertical(i5);
    }

    public void setChipSpacingHorizontal(int i5) {
        if (this.f12639e != i5) {
            this.f12639e = i5;
            setItemSpacing(i5);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i5) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i5));
    }

    public void setChipSpacingResource(int i5) {
        setChipSpacing(getResources().getDimensionPixelOffset(i5));
    }

    public void setChipSpacingVertical(int i5) {
        if (this.f12640f != i5) {
            this.f12640f = i5;
            setLineSpacing(i5);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i5) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i5));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i5) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new a(cVar));
        }
    }

    public void setOnCheckedStateChangeListener(d dVar) {
        this.f12641g = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        e.a(null, onHierarchyChangeListener);
    }

    public void setSelectionRequired(boolean z5) {
        throw null;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i5) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i5) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.g
    public void setSingleLine(boolean z5) {
        super.setSingleLine(z5);
    }

    public void setSingleSelection(boolean z5) {
        throw null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0163b(layoutParams);
    }

    public void setSingleLine(int i5) {
        setSingleLine(getResources().getBoolean(i5));
    }

    public void setSingleSelection(int i5) {
        setSingleSelection(getResources().getBoolean(i5));
    }
}

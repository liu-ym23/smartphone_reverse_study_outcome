package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes3.dex */
public final class s extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f2698a;
    public ColorStateList b;
    public final /* synthetic */ MaterialAutoCompleteTextView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MaterialAutoCompleteTextView materialAutoCompleteTextView, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.c = materialAutoCompleteTextView;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.c;
        ColorStateList colorStateList2 = materialAutoCompleteTextView.h;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.b = colorStateList;
        if (materialAutoCompleteTextView.g != 0 && materialAutoCompleteTextView.h != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{ColorUtils.compositeColors(materialAutoCompleteTextView.h.getColorForState(iArr3, 0), materialAutoCompleteTextView.g), ColorUtils.compositeColors(materialAutoCompleteTextView.h.getColorForState(iArr2, 0), materialAutoCompleteTextView.g), materialAutoCompleteTextView.g});
        }
        this.f2698a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.c;
            Drawable rippleDrawable = null;
            if (materialAutoCompleteTextView.getText().toString().contentEquals(textView.getText()) && materialAutoCompleteTextView.g != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(materialAutoCompleteTextView.g);
                if (this.b != null) {
                    colorDrawable.setTintList(this.f2698a);
                    rippleDrawable = new RippleDrawable(this.b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}

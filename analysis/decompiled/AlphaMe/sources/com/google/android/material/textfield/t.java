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

/* loaded from: classes.dex */
public final class t extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f11096a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f11097b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f11098c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, Context context, int i4, String[] strArr) {
        super(context, i4, strArr);
        this.f11098c = uVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        u uVar = this.f11098c;
        ColorStateList colorStateList2 = uVar.f11106l;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f11097b = colorStateList;
        if (uVar.f11105k != 0 && uVar.f11106l != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{D.a.b(uVar.f11106l.getColorForState(iArr3, 0), uVar.f11105k), D.a.b(uVar.f11106l.getColorForState(iArr2, 0), uVar.f11105k), uVar.f11105k});
        }
        this.f11096a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i4, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            u uVar = this.f11098c;
            Drawable rippleDrawable = null;
            if (uVar.getText().toString().contentEquals(textView.getText()) && uVar.f11105k != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(uVar.f11105k);
                if (this.f11097b != null) {
                    colorDrawable.setTintList(this.f11096a);
                    rippleDrawable = new RippleDrawable(this.f11097b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}

package com.stepos.common.picker;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class r extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelPicker f11392a;

    public r(WheelPicker wheelPicker) {
        this.f11392a = wheelPicker;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i4) {
        super.onScrollStateChanged(recyclerView, i4);
        if (i4 == 0) {
            WheelPicker wheelPicker = this.f11392a;
            TextView textViewD = WheelPicker.d(wheelPicker.f11356n);
            String str = (textViewD == null || TextUtils.isEmpty(textViewD.getText())) ? null : (String) textViewD.getText();
            if (wheelPicker.f11364v != null) {
                for (int i5 = 0; i5 < wheelPicker.f11364v.size(); i5++) {
                    ((s) wheelPicker.f11364v.get(i5)).a(str);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i4, int i5) {
        super.onScrolled(recyclerView, i4, i5);
        int i6 = WheelPicker.f11342z;
        this.f11392a.b();
    }
}

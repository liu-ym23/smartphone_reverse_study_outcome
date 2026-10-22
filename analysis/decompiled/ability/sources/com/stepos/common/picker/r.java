package com.stepos.common.picker;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class r extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelPicker f3599a;

    public r(WheelPicker wheelPicker) {
        this.f3599a = wheelPicker;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            WheelPicker wheelPicker = this.f3599a;
            TextView textViewD = WheelPicker.d(wheelPicker.n);
            String str = (textViewD == null || TextUtils.isEmpty(textViewD.getText())) ? null : (String) textViewD.getText();
            if (wheelPicker.f3583v != null) {
                for (int i6 = 0; i6 < wheelPicker.f3583v.size(); i6++) {
                    ((s) wheelPicker.f3583v.get(i6)).a(str);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        super.onScrolled(recyclerView, i, i6);
        int i10 = WheelPicker.f3576z;
        this.f3599a.b();
    }
}

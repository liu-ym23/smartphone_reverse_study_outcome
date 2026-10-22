package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class F extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2412a;
    public final MaterialCalendarGridView b;

    public F(LinearLayout linearLayout, boolean z10) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f2412a = textView;
        ViewCompat.setAccessibilityHeading(textView, true);
        this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z10) {
            return;
        }
        textView.setVisibility(8);
    }
}

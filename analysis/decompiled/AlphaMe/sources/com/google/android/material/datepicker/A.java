package com.google.android.material.datepicker;

import K.S;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class A extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f10592a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialCalendarGridView f10593b;

    public A(LinearLayout linearLayout, boolean z4) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f10592a = textView;
        WeakHashMap weakHashMap = S.f939a;
        new K.E(R.id.tag_accessibility_heading, 3).b(textView, Boolean.TRUE);
        this.f10593b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z4) {
            return;
        }
        textView.setVisibility(8);
    }
}

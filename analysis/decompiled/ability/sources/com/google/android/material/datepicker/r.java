package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class r extends M {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2434a;
    public final /* synthetic */ MaterialCalendar b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MaterialCalendar materialCalendar, Context context, int i, int i6) {
        super(context, i, false);
        this.b = materialCalendar;
        this.f2434a = i6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i = this.f2434a;
        MaterialCalendar materialCalendar = this.b;
        if (i == 0) {
            iArr[0] = materialCalendar.f2417j.getWidth();
            iArr[1] = materialCalendar.f2417j.getWidth();
        } else {
            iArr[0] = materialCalendar.f2417j.getHeight();
            iArr[1] = materialCalendar.f2417j.getHeight();
        }
    }
}

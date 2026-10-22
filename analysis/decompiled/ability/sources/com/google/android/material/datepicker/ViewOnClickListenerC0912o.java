package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* renamed from: com.google.android.material.datepicker.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ViewOnClickListenerC0912o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2431a;
    public final /* synthetic */ G b;
    public final /* synthetic */ MaterialCalendar c;

    public /* synthetic */ ViewOnClickListenerC0912o(MaterialCalendar materialCalendar, G g, int i) {
        this.f2431a = i;
        this.c = materialCalendar;
        this.b = g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2431a) {
            case 0:
                this.c.c(this.b.f2413a.getStart().monthsLater(((LinearLayoutManager) r2.f2417j.getLayoutManager()).findLastVisibleItemPosition() - 1));
                break;
            default:
                MaterialCalendar materialCalendar = this.c;
                materialCalendar.c(this.b.f2413a.getStart().monthsLater(((LinearLayoutManager) materialCalendar.f2417j.getLayoutManager()).findFirstVisibleItemPosition() + 1));
                break;
        }
    }
}

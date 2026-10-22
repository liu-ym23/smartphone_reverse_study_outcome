package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class n extends H {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10696a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10697b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(s sVar, Context context, int i4, int i5) {
        super(context, i4, false);
        this.f10697b = sVar;
        this.f10696a = i5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i4 = this.f10696a;
        s sVar = this.f10697b;
        if (i4 == 0) {
            iArr[0] = sVar.f10713j.getWidth();
            iArr[1] = sVar.f10713j.getWidth();
        } else {
            iArr[0] = sVar.f10713j.getHeight();
            iArr[1] = sVar.f10713j.getHeight();
        }
    }
}

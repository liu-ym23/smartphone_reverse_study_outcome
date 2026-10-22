package com.bytedance.android.live.revlink.impl.pk.dialog.adapter;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder f95522a;

    public c(PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r100) {
        this.f95522a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r101 = this.f95522a;
        j r102 = r101.f95519f.f95509f;
        String r103 = r101.f95518e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "queryWord");
        r102.f96016j.remove(r103);
        Map r104 = j.f();
        r104.put(String.valueOf(r102.f96032z), r102.f96016j);
        l51.a.N(r104);
        r102.f96010d.postValue(r102.f96016j);
    }
}

package com.bytedance.android.live.ui;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v implements m<String, View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f102118a;

    @Override // com.bytedance.android.live.ui.m
    public final void a() {
        this.f102118a.setTextSize(1, 8.0f);
    }

    public v(View r100) {
        Intrinsics.checkNotNullParameter(r100, "parentContext");
        this.f102118a = (TextView) r100.findViewById(R.id.fans_ticket_count);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f102118a.setText(r100);
    }

    @Override // com.bytedance.android.live.ui.m
    public /* bridge */ /* synthetic */ void update(String r100) {
        update2(r100);
    }
}

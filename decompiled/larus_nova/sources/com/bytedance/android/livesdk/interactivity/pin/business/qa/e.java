package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.a f138753a;

    public e(HighlightItem.a r100) {
        this.f138753a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        g42.i.a(new j42.e(this.f138753a));
        return true;
    }
}

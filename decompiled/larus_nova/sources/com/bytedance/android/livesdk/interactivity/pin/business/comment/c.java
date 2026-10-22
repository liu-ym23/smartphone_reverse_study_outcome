package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.c f138669a;

    public c(HighlightItem.c r100) {
        this.f138669a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        g42.i.a(new e42.b(this.f138669a));
        return true;
    }
}

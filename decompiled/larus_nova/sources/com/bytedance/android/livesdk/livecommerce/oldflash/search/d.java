package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.View;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECSearchBar f149695a;

    public d(ECSearchBar r100) {
        this.f149695a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f149695a.setText("");
        this.f149695a.clearEditFocus();
    }
}

package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.view.View;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFlashSearchDialogFragment f149698a;

    public g(LiveFlashSearchDialogFragment r100) {
        this.f149698a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        ECSearchBar r102 = (ECSearchBar) this.f149698a.ia0(R.id.search_bar);
        int r103 = 0;
        if (r102 != null) goto L5;
    L9:
        View r104 = this.f149698a.ia0(R.id.line_view);
        if (r104 != null) goto L12;
        return;
    L12:
        if (r101.booleanValue() == true) goto L15;
        r103 = 4;
    L15:
        r104.setVisibility(r103);
        return;
    L5:
        if (r101.booleanValue() == false) goto L7;
        int r105 = 0;
    L8:
        r102.setVisibility(r105);
        goto L9
    L7:
        r105 = 8;
        goto L8
    }
}

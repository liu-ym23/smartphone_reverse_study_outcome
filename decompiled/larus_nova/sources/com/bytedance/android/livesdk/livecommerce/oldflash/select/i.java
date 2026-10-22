package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFlashMultiSelectDialogFragment f149733a;

    public i(LiveFlashMultiSelectDialogFragment r100) {
        this.f149733a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!((List) r100).isEmpty()) == false) goto L7;
        ECTitleBar r101 = (ECTitleBar) this.f149733a.ia0(R.id.title_bar);
        if (r101 == null) goto L11;
        r101.setRightTextColor(th.a.a(r101.getContext(), R.color.ec_color_title_confirm));
        r101.setRightTextClickListener(new h(this));
        return;
    L11:
        return;
    L7:
        ECTitleBar r102 = (ECTitleBar) this.f149733a.ia0(R.id.title_bar);
        if (r102 == null) goto L13;
        r102.setRightTextColor(th.a.a(r102.getContext(), R.color.ec_color_title_confirm_disable));
        r102.setRightTextClickListener(null);
        return;
    }
}

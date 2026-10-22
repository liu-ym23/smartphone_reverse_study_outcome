package com.bytedance.android.shopping.feed.widget.popupview;

import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f176056a;

    public b(a r100) {
        this.f176056a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        a r101 = this.f176056a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    }
}

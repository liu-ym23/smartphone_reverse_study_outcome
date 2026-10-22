package com.bytedance.android.ec.window.base.view;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.ClickAction;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f49888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECWindowTagView f49889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f49890c;

    public g(ClickAction r100, ECWindowTagView r101, Function0 r102) {
        this.f49888a = r100;
        this.f49889b = r101;
        this.f49890c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECToast.showToast$default(ECToast.INSTANCE, this.f49889b.getContext(), this.f49888a.getToastText(), null, 4, null);
        this.f49889b.b();
    }
}

package com.bytedance.android.ec.store.view;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ClickAction;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAction f48951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTagView f48952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f48953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f48954d;

    public o(ClickAction r100, ECTagView r101, View r102, Function0 r103) {
        this.f48951a = r100;
        this.f48952b = r101;
        this.f48953c = r102;
        this.f48954d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ECToast.showToast$default(ECToast.INSTANCE, this.f48952b.getContext(), this.f48951a.getToastText(), null, 4, null);
        this.f48952b.e();
    }
}

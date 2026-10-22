package com.bytedance.android.ec.hybrid.xelement.ecomgiftlist;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLynxGiftListView f47756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f47757b;

    public d(ECLynxGiftListView r100, int r101) {
        this.f47756a = r100;
        this.f47757b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int r100 = this.f47757b;
        ECLynxGiftListView r101 = this.f47756a;
        int r102 = ECLynxGiftListView.f47745b;
        if (r100 >= r101.M().size()) goto L6;
        ListProtector.remove(this.f47756a.M(), this.f47757b);
        return;
    }
}

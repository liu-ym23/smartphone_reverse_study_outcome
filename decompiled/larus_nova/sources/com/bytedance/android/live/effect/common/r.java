package com.bytedance.android.live.effect.common;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class r<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListView f67872a;

    public r(LiveCommonStickerListView r100) {
        this.f67872a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveCommonStickerListView r101 = this.f67872a;
        LiveCommonStickerListView.c6(r101, (List) r100);
    }
}

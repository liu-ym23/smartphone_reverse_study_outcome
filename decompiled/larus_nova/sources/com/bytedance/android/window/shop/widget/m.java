package com.bytedance.android.window.shop.widget;

import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements com.bytedance.android.ec.window.base.common.bubble.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubCategoryView f190056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f190057b;

    @Override // com.bytedance.android.ec.window.base.common.bubble.g
    public final void onDismiss() {
    }

    @Override // com.bytedance.android.ec.window.base.common.bubble.g
    public final void onShow() {
        SharedPrefExtKt.putBoolean(SharedPrefExtKt.getSharePref(this.f190056a.getContext(), "ec_window_live_point"), this.f190057b, true);
    }

    public m(SubCategoryView r100, String r101) {
        this.f190056a = r100;
        this.f190057b = r101;
    }
}

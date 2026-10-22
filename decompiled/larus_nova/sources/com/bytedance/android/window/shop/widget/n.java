package com.bytedance.android.window.shop.widget;

import android.content.SharedPreferences;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolBarView f190058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.d f190059b;

    public n(ToolBarView r100, com.bytedance.android.window.shop.repository.tab.entity.d r101) {
        this.f190058a = r100;
        this.f190059b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ToolBarView r101 = this.f190058a;
        com.bytedance.android.window.shop.repository.tab.entity.d r102 = this.f190059b;
        int r103 = ToolBarView.f189887l;
        r101.getClass();
        String r104 = "filter_type_" + r102.f189531a;
        SharedPreferences r105 = this.f190058a.getContext().getSharedPreferences("ec_window", 0);
        boolean r106 = r105.getBoolean(r104, false);
        if (r106 == true) goto L6;
        r105.edit().putBoolean(r104, true).apply();
        r100.onNext(Boolean.valueOf(r106));
        return;
    L6:
        r100.onNext(Boolean.valueOf(r106));
    }
}

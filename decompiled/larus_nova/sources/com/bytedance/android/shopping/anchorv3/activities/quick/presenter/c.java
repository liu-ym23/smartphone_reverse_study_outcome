package com.bytedance.android.shopping.anchorv3.activities.quick.presenter;

import android.widget.TextView;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f164413a;

    public c(TextView r100) {
        this.f164413a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f164413a.setVisibility(8);
    }
}

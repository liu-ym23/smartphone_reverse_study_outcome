package com.bytedance.android.livesdk.interactivity.zdanmaku;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCommonAnimTrayView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindScreenCommonAnimTrayView f141587a;

    public c(WindScreenCommonAnimTrayView r100) {
        this.f141587a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 == null) goto L7;
        this.f141587a.setIcon(r101);
        return;
    }
}

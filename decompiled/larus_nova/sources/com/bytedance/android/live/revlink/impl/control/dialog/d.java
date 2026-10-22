package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f92378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f92379b;

    public d(b r100, String r101) {
        this.f92378a = r100;
        this.f92379b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        b r102 = this.f92378a;
        if (r102.f92362p == true) goto L14;
        Disposable r103 = r102.f92353g;
        if (r103 == null) goto L8;
        r103.dispose();
    L8:
        b r104 = this.f92378a;
        int r105 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal();
        if (Intrinsics.areEqual(this.f92379b, "ai") == false) goto L11;
        String r106 = "ai";
    L12:
        r104.f92353g = r104.h(0, "", r106, r105, "");
        return;
    L11:
        r106 = UploadTypeInf.TIMER;
        goto L12
    }
}

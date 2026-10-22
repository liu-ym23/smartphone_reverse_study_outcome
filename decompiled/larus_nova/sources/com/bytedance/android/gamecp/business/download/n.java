package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.gamecp.base.Result;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.l1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f52827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52828b;

    public n(Function2 r100, p r101) {
        this.f52827a = r100;
        this.f52828b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f52827a.invoke(Boolean.FALSE, new Pair(3, "get download error"));
        int r102 = GamePromoteTrack.f51759a;
        Result r103 = Result.FAIL;
        Intrinsics.checkNotNullParameter(r101, "$this$logId");
        if ((r101 instanceof CustomApiServerException) == false) goto L5;
        String r104 = ((CustomApiServerException) r101).getXTtLogId();
    L6:
        GamePromoteTrack.s(r103, r104, r101.getMessage(), l1.a(r101), this.f52828b.a());
        ToastUtil.a(R.string.gamecp_get_download_error);
        return;
    L5:
        r104 = "";
        goto L6
    }
}

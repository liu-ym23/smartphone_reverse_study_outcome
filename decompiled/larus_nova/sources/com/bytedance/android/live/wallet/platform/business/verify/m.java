package com.bytedance.android.live.wallet.platform.business.verify;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f102740a;

    public m(Function0 r100) {
        this.f102740a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ToastUtil.b("授权失败", 0);
        this.f102740a.invoke();
    }
}

package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.link.model.u0;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f96082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0 f96083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f96084c;

    public r(q r100, u0 r101, Function0 r102) {
        this.f96082a = r100;
        this.f96083b = r101;
        this.f96084c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        this.f96082a.f96077h = false;
        this.f96084c.invoke();
        ToastUtil.a(R.string.ttlive_interact_pk_ban_rm_success, 0);
    }
}

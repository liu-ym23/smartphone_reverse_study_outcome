package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.link.model.u0;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f96085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0 f96086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f96087c;

    public s(q r100, u0 r101, Function0 r102) {
        this.f96085a = r100;
        this.f96086b = r101;
        this.f96087c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.f96085a.f96077h = false;
        r101.printStackTrace();
        ToastUtil.a(R.string.ttlive_interact_pk_ban_rm_fail, 0);
    }
}

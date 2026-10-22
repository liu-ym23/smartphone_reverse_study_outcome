package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f144287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f144288b;

    public d(long r100, Function1 r101) {
        this.f144287a = r100;
        this.f144288b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.c.a.a(pd2.d.f528658n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.f144287a, r101);
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f144288b.invoke(r101);
    }
}

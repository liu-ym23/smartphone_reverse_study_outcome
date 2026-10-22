package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import xi2.d0;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f152804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f152805b;

    public b(Function1 r100, Context r101) {
        this.f152804a = r100;
        this.f152805b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d0 r101 = (d0) r100;
        if (r101 != null) goto L5;
    L9:
        Context r102 = this.f152805b;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r102, th.a.g(r102, R.string.ec_net_error));
        return;
    L5:
        if (r101.statusCode != 0) goto L9;
        if (r101.a() == null) goto L9;
        this.f152804a.invoke(r101.a());
    }
}

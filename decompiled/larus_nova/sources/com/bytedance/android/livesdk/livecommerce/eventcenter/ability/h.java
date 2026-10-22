package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f147782a;

    public h(Function0 r100) {
        this.f147782a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        xi2.q r101 = (xi2.q) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.statusCode != 0) goto L11;
        Function0 r102 = this.f147782a;
        if (r102 == null) goto L12;
        Unit r103 = (Unit) r102.invoke();
        return;
    L12:
        return;
    }
}

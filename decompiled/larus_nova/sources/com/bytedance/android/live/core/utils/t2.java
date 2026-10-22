package com.bytedance.android.live.core.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class t2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f66405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f66406b;

    public t2(Ref.ObjectRef r100, Function1 r101) {
        this.f66405a = r100;
        this.f66406b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (((AnimationStatus) this.f66405a.element) != AnimationStatus.IDLE) goto L8;
        LocalTestManager.a(new Class[]{wy.a.class});
        Function1 r102 = this.f66406b;
        if (r102 == null) goto L9;
        Unit r103 = (Unit) r102.invoke(((AnimationStatus) this.f66405a.element).name());
        return;
    L9:
        return;
    }
}

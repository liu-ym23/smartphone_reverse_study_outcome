package com.bytedance.android.gamecp.common.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class t1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f57305b;

    public t1(Ref.ObjectRef r100, Function1 r101) {
        this.f57304a = r100;
        this.f57305b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (((AnimationStatus) this.f57304a.element) != AnimationStatus.IDLE) goto L8;
        LocalTestManager.a(new Class[]{uv.a.class});
        Function1 r102 = this.f57305b;
        if (r102 == null) goto L9;
        Unit r103 = (Unit) r102.invoke(((AnimationStatus) this.f57304a.element).name());
        return;
    L9:
        return;
    }
}

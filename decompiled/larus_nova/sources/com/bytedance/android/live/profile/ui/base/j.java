package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.profile.model.LifecycleStateType;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleStateType f86333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f86334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f86335c;

    public j(LifecycleStateType r100, Function1 r101, Ref.ObjectRef r102) {
        this.f86333a = r100;
        this.f86334b = r101;
        this.f86335c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.profile.model.b r101 = (com.bytedance.android.live.profile.model.b) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f86064a.ordinal() < this.f86333a.ordinal()) goto L11;
        this.f86334b.invoke(r101);
        Disposable r102 = (Disposable) this.f86335c.element;
        if (r102 == null) goto L12;
        r102.dispose();
        return;
    L12:
        return;
    }
}

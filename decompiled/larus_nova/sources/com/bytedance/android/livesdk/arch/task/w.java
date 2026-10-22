package com.bytedance.android.livesdk.arch.task;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f103933c;

    public w(TbTaskFlower r100, x r101, Ref.ObjectRef r102) {
        this.f103931a = r100;
        this.f103932b = r101;
        this.f103933c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f103931a.e(this.f103932b, ne1.b.a.C6916a.f518859b);
        Disposable r100 = (Disposable) this.f103933c.element;
        if (r100 == null) goto L6;
        this.f103931a.f103875b.remove(r100);
        return;
    }
}

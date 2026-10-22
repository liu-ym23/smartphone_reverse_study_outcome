package com.bytedance.android.livesdk.arch.task;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f103927c;

    public u(TbTaskFlower r100, x r101, List r102) {
        this.f103925a = r100;
        this.f103926b = r101;
        this.f103927c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TbTaskFlower r101 = this.f103925a;
        TbTaskFlower.c(r101, (TaskResult) r100, this.f103926b, (d) CollectionsKt.last(this.f103927c));
    }
}

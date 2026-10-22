package com.bytedance.android.livesdk.arch.task;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f103919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f103920d;

    public s(TbTaskFlower r100, x r101, List r102, int r103) {
        this.f103917a = r100;
        this.f103918b = r101;
        this.f103919c = r102;
        this.f103920d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TbTaskFlower.c(this.f103917a, (TaskResult) r100, this.f103918b, (d) ListProtector.get(this.f103919c, this.f103920d - 1));
    }
}

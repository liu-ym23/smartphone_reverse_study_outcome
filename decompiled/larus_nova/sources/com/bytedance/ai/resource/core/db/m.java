package com.bytedance.ai.resource.core.db;

import com.bytedance.ai.model.objects.Widget;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Callable<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Widget[] f37440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f37441b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Unit call2() throws Exception {
        this.f37441b.f37376b.beginTransaction();
        this.f37441b.f37382h.handleMultiple(this.f37440a);     // Catch: Throwable -> L6
        this.f37441b.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        this.f37441b.f37376b.endTransaction();
        return r100;
    L6:
        th = move-exception;
        this.f37441b.f37376b.endTransaction();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Unit call() throws Exception {
        return call2();
    }

    public m(j r100, Widget[] r101) {
        this.f37441b = r100;
        this.f37440a = r101;
    }
}

package com.bytedance.android.shopping.order;

import android.content.Context;
import android.os.Handler;
import cg3.k;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f179676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cg3.f f179677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f179678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f179679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f179680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function2 f179681f;

    public f(Context r100, cg3.f r101, String r102, String r103, Function2 r104) {
        this.f179676a = r100;
        this.f179677b = r101;
        this.f179678c = r102;
        this.f179679d = r103;
        this.f179680e = null;
        this.f179681f = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Handler r100 = PublishUtil.f179649a;
        PublishUtil.e(this.f179676a, new k(((cg3.c) r110).f23657a, this.f179677b, this.f179678c, this.f179679d, this.f179680e, this.f179681f), true);
    }
}

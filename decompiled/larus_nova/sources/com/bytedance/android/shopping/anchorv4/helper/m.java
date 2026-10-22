package com.bytedance.android.shopping.anchorv4.helper;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f166963a;

    public m(Function0 r100) {
        this.f166963a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = JisooManager.f166873a;
        Intrinsics.checkNotNullParameter("request fail", "msg");
        dm.a.b r102 = dm.a.a("JisooManager");
        r102.b("request fail", (Throwable) r100);
        Function0 r103 = this.f166963a;
        if (r103 == null) goto L6;
        Unit r104 = (Unit) r103.invoke();
        return;
    }
}

package com.bytedance.android.livesdk.revenue.message;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevWrdsSettingItemImpl<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dc2.c<T> f157179a;

    public final class a implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f157180a;

        public a(Function1 r100) {
            this.f157180a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object r100) {
            return this.f157180a.invoke(r100);
        }
    }

    @Override // com.bytedance.android.livesdk.revenue.message.e
    public final Observable<e.a<T>> a() {
        Observable<dc2.c.b<T>> r100 = this.f157179a.f467853e;
        RevWrdsSettingItemImpl$onValueWithVersion$1 r101 = RevWrdsSettingItemImpl$onValueWithVersion$1.INSTANCE;
        Object r102 = r101;
        if (r101 == null) goto L6;
        r102 = new a(r101);
    L6:
        return (Observable<e.a<T>>) r100.map((Function) r102);
    }

    public RevWrdsSettingItemImpl(dc2.c<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157179a = r100;
    }
}

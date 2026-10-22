package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseObservableState<T> extends com.bytedance.android.live.browser.jsbridge.state.a<T> implements i.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f63887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f63888d;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseObservableState f63889a;

        public a(BaseObservableState r100) {
            this.f63889a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.android.live.browser.jsbridge.state.a.C1050a r101 = (com.bytedance.android.live.browser.jsbridge.state.a.C1050a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            BaseObservableState r102 = this.f63889a;
            T r103 = r101.f63918a;
            r102.getClass();
            if ((r103 instanceof JsonElement) == true) goto L13;
            if (r103 == null) goto L12;
            Gson r104 = r102.f63916a;
            if (r104 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("gson");
        L9:
            JsonElement r105 = GsonProtectorUtils.toJsonTree(r104, r103);
            if (r105 == null) goto L12;
            return r105;
        L12:
            return new JsonObject();
        L13:
            return (JsonElement) r103;
        }
    }

    public BaseObservableState() {
        this(false);
    }

    public abstract void i();

    public BaseObservableState(boolean r100) {
        super(0);
        this.f63888d = r100;
        this.f63887c = LazyKt.lazy(BaseObservableState$subject$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.b
    public Observable<JsonElement> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyParam");
        return ((PublishSubject) this.f63887c.getValue()).map(new a(this)).subscribeOn(Schedulers.io());
    }

    public final void h(T r100) {
        ((PublishSubject) this.f63887c.getValue()).onNext(new com.bytedance.android.live.browser.jsbridge.state.a.C1050a(r100));
    }
}

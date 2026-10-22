package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseDataObsProvider<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38401a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDataObsProvider<T> f38402a;

        public a(BaseDataObsProvider<T> r100) {
            this.f38402a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            h r101 = (h) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            BaseDataObsProvider<T> r102 = this.f38402a;
            T r103 = r101.f38410a;
            r102.getClass();
            if ((r103 instanceof JsonElement) == true) goto L10;
            if (r103 == null) goto L9;
            JsonElement r104 = d.b(r103);
            if (r104 == null) goto L9;
            return r104;
        L9:
            return new JsonObject();
        L10:
            return (JsonElement) r103;
        }
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement a(String r100) {
        return f.a(this, r100);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ g c() {
        return f.e(this);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement e(String r100, String r101) {
        return f.b(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r100, JsonElement r101) {
        return f.c(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r100, JsonElement r101) {
        return f.d(r100, r101);
    }

    public BaseDataObsProvider() {
        this.f38401a = LazyKt.lazy(BaseDataObsProvider$subject$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.e
    public Pair<String, Observable<JsonElement>> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new Pair(key(), ((PublishSubject) this.f38401a.getValue()).map(new a(this)).subscribeOn(Schedulers.io()));
    }

    public final void i(T r100) {
        ((PublishSubject) this.f38401a.getValue()).onNext(new h(r100));
    }
}

package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f66363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f66364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f66365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f66366d;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f66367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f66368b;

        public a(r r100, b r101) {
            this.f66367a = r100;
            this.f66368b = r101;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f66367a.f66363a.removeObserver(this.f66368b);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f66369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f66370b;

        public b(r r100, ObservableEmitter r101) {
            this.f66369a = r100;
            this.f66370b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f66369a.f66364b.invoke(this.f66370b, ((KVData) r100).getData());
        }
    }

    public r(DataCenter r100, Function2 r101, String r102, boolean r103) {
        this.f66363a = r100;
        this.f66364b = r101;
        this.f66365c = r102;
        this.f66366d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        b r101 = new b(this, r100);
        this.f66363a.observeForever(this.f66365c, r101, this.f66366d);
        r100.setCancellable(new a(this, r101));
    }
}

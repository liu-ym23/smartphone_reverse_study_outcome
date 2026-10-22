package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class WishFinishGestureWidget$observeRx$1<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f161396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f161397b;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WishFinishGestureWidget$observeRx$1 f161400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f161401b;

        public a(WishFinishGestureWidget$observeRx$1 r100, ObservableEmitter r101) {
            this.f161400a = r100;
            this.f161401b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101.getKey(), this.f161400a.f161397b) == false) goto L9;
            this.f161401b.onNext(r101);
            return;
        }
    }

    public WishFinishGestureWidget$observeRx$1(DataCenter r100) {
        this.f161396a = r100;
        this.f161397b = "cmd_effect_start";
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<KVData> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        final a r101 = new a(this, r100);
        r100.setDisposable(Disposables.fromAction(new AnonymousClass1(this, r101)));
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass2(this, r101), 7);
    }
}

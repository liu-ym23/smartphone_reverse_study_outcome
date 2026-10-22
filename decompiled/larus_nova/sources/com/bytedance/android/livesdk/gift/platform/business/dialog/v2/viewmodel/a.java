package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<GiftStateMachineConfig.g> f127059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Disposable f127060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f127061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f127062d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C2051a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f127063a;

        public C2051a(a r100) {
            this.f127063a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a r101 = this.f127063a;
            r101.d((GiftStateMachineConfig.Event) r100);
        }
    }

    public abstract void d(GiftStateMachineConfig.Event r100);

    public void a() {
        Disposable r100 = this.f127060b;
        if (r100 != null) goto L5;
    L7:
        this.f127061c.clear();
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f127060b.dispose();
        goto L7
    }

    public a(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f127062d = r100;
        this.f127059a = new NextLiveData();
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L9;
        k<GiftStateMachineConfig.Event> r102 = r101.getGiftActionManager();
        if (r102 == null) goto L9;
        PublishSubject r103 = r102.onEvent();
        if (r103 == null) goto L9;
        Disposable r104 = r103.subscribe(new C2051a(this));
    L10:
        this.f127060b = r104;
        this.f127061c = new CompositeDisposable();
        return;
    L9:
        r104 = null;
        goto L10
    }

    public final GiftStateMachineConfig.g c(LifecycleOwner r100, Observer<GiftStateMachineConfig.g> r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        NextLiveData<GiftStateMachineConfig.g> r102 = this.f127059a;
        if (r100 != null) goto L5;
        r100 = this.f127062d;
    L5:
        r102.observe(r100, r101);
        return this.f127059a.getValue();
    }
}

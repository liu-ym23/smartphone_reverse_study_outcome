package bk2;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QArchLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> extends QLiveData<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final QArchLiveData<T> f19297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Object f19298g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f19300b;

        public a(e r100, Object r101) {
            this.f19299a = r100;
            this.f19300b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f19299a;     // Catch: Throwable -> L4
            r100.f19298g = this.f19300b;     // Catch: Throwable -> L4
            this.f19299a.f19297f.setValue((T) this.f19300b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final T a() {
        T r100 = (T) this.f19298g;
        QLiveData.f450947e.getClass();
        if (r100 != QLiveData.f450945c) goto L7;
        return null;
    L7:
        return r100;
    }

    public e() {
        this.f19297f = new QArchLiveData();
        QLiveData.f450947e.getClass();
        this.f19298g = QLiveData.f450945c;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void d(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f19297f.observeForever(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void e(T r100) {
        QLiveData.f450947e.getClass();
        if (Intrinsics.areEqual(QLiveData.f450946d, ThreadMethodProxy.currentThread()) == false) goto L5;
        this.f19298g = r100;
        this.f19297f.setValue(r100);
        return;
    L5:
        UtilityKotlinExtentionsKt.f153057b.post(new a(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void f(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f19297f.removeObserver(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void g(T r100) {
        this.f19298g = r100;
        this.f19297f.setValue(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void b(LifecycleOwner r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f19297f.observe(r100, r101);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData
    public final void c(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f19297f.observe(r100, r101, true);
    }
}

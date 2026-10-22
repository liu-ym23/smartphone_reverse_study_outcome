package b73;

import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.shopping.anchorv4.components.base.ComponentContainer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a implements d, com.bytedance.android.ec.core.async.b, fa3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentContainer f17928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DisposableScope f17929b;

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f17929b.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void clearDisposable() {
        this.f17929b.clearDisposable();
    }

    @Override // b73.d
    public void onCreate() {
    }

    @Override // b73.d
    public void onPause() {
    }

    @Override // b73.d
    public void onResume() {
    }

    @Override // b73.d
    public final void onStart() {
    }

    @Override // b73.d
    public final void onStop() {
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f17929b.remove(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public final CompositeDisposable compositeDisposable() {
        return this.f17929b.a();
    }

    public a() {
        this.f17929b = new DisposableScope();
    }

    @Override // b73.d
    public void onDestroy() {
        clearDisposable();
    }

    public final <T> T h0(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ComponentContainer r101 = this.f17928a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.a(r100);
    }

    @Override // b73.d
    public final void x(ComponentContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "componentContainer");
        this.f17928a = r100;
    }
}

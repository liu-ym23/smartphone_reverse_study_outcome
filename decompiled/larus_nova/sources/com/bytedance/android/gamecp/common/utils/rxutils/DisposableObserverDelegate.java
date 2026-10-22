package com.bytedance.android.gamecp.common.utils.rxutils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00030\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\bH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0018\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/utils/rxutils/DisposableObserverDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/reactivex/Observer;", "Lio/reactivex/disposables/Disposable;", "Ljava/util/concurrent/atomic/AtomicReference;", "downstream", "doOnDispose", "Lkotlin/Function0;", "", "(Lio/reactivex/Observer;Lkotlin/jvm/functions/Function0;)V", "dispose", "isDisposed", "", "onComplete", LynxVideoManagerLite.EVENT_ON_ERROR, "p0", "", "onNext", "(Ljava/lang/Object;)V", "onSubscribe", "d", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisposableObserverDelegate<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private final Function0<Unit> doOnDispose;
    private final Observer<T> downstream;

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.downstream.onError(r100);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        this.downstream.onNext(r100);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper r100 = DisposableHelper.DISPOSED;
        if (get() == r100) goto L10;
        Disposable r101 = getAndSet(r100);
        if (r101 == r100) goto L11;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.doOnDispose.invoke();
        return;
    L11:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        if (compareAndSet(null, r100) == true) goto L6;
        r100.dispose();
        return;
    L6:
        this.downstream.onSubscribe(r100);
    }

    public DisposableObserverDelegate(Observer<T> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "downstream");
        Intrinsics.checkNotNullParameter(r101, "doOnDispose");
        this.downstream = r100;
        this.doOnDispose = r101;
    }

    public /* synthetic */ DisposableObserverDelegate(Observer r100, Function0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = AnonymousClass1.INSTANCE;
    L5:
        this(r100, r101);
    }
}

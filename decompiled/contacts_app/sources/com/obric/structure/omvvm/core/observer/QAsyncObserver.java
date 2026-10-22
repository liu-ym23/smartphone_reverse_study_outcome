package com.obric.structure.omvvm.core.observer;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.obric.structure.omvvm.core.util.QExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QAsyncObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/structure/omvvm/core/observer/QAsyncObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "()V", "asyncChange", "", "data", "(Ljava/lang/Object;)V", "onChanged", "value", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QAsyncObserver<T> implements Observer<T> {
    public static /* synthetic */ void $r8$lambda$aw2Z14L8dFaSxRjyHqEtxm0UjA8(QAsyncObserver r0, Object r1) {
        onChanged$lambda$0(r0, r1);
    }

    public abstract void asyncChange(T r1);

    public QAsyncObserver() {
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(final T r3) {
        QExecutor.INSTANCE.work().post(new QAsyncObserver$$ExternalSyntheticLambda0(this, r3));
    }

    private static final void onChanged$lambda$0(QAsyncObserver r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.asyncChange(r2);
    }
}

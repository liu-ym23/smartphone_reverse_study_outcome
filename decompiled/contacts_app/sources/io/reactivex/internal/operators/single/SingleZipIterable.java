package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ SingleZipIterable this$0;

        SingletonArrayFunc(SingleZipIterable r1) {
            this.this$0 = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T r3) throws Exception {
            return (R) ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{r3}), "The zipper returned a null value");
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        this.sources = r1;
        this.zipper = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> r7) {
        SingleSource[] r0 = new SingleSource[8];
        Iterator<? extends SingleSource<? extends T>> r1 = this.sources.iterator();     // Catch: Throwable -> L29
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r1.hasNext() == false) goto L15;
        SingleSource<? extends T> r4 = r1.next();     // Catch: Throwable -> L29
        if (r4 == null) goto L8;
        if (r3 != r0.length) goto L13;
        r0 = (SingleSource[]) Arrays.copyOf(r0, (r3 >> 2) + r3);     // Catch: Throwable -> L29
    L13:
        int r5 = r3 + 1;     // Catch: Throwable -> L29
        r0[r3] = r4;     // Catch: Throwable -> L29
        r3 = r5;
        goto L5
    L8:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r7);     // Catch: Throwable -> L29
        return;
    L15:
        if (r3 != 0) goto L19;
        EmptyDisposable.error(new NoSuchElementException(), r7);
        return;
    L19:
        if (r3 != 1) goto L22;
        r0[0].subscribe(new SingleMap.MapSingleObserver(r7, new SingletonArrayFunc(this)));
        return;
    L22:
        SingleZipArray.ZipCoordinator r6 = new SingleZipArray.ZipCoordinator(r7, r3, this.zipper);
        r7.onSubscribe(r6);
    L23:
        if (r2 >= r3) goto L28;
        if (r6.isDisposed() == true) goto L26;
        r0[r2].subscribe(r6.observers[r2]);
        r2 = r2 + 1;
        goto L23
    L26:
        return;
    L28:
        return;
    L29:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r7);
    }
}

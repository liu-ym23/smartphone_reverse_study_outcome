package com.obric.thread;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitSafeLazy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00028\u00008VX\u0096\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/obric/thread/InitSafeLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "lock", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "UninitializedValue", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InitSafeLazy<T> implements Lazy<T> {
    private volatile Object _value;
    private final Function0<T> initializer;
    private final Object lock;

    /* JADX INFO: compiled from: InitSafeLazy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/thread/InitSafeLazy$UninitializedValue;", "", "()V", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class UninitializedValue {
        public static final UninitializedValue INSTANCE = null;

        static {
            INSTANCE = new UninitializedValue();
        }

        private UninitializedValue() {
        }
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InitSafeLazy(Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        this.initializer = r2;
        this._value = UninitializedValue.INSTANCE;
        this.lock = new Object();
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T r0 = (T) this._value;
        if (r0 == UninitializedValue.INSTANCE) goto L5;
        return r0;
    L5:
        Object r1 = this.lock;
        monitor-enter(r1);
        T r2 = (T) this._value;
        if (r2 != UninitializedValue.INSTANCE) goto L11;
        r2 = this.initializer.invoke();     // Catch: Throwable -> L13
        this._value = r2;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r1);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value == UninitializedValue.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }
}

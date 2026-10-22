package com.android.ttcjpaysdk.base.ktextension;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/SingletonHolder;", ExifInterface.GPS_DIRECTION_TRUE, "", "creator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "instanceNone", "getInstanceNone", "()Ljava/lang/Object;", "instanceNone$delegate", "Lkotlin/Lazy;", "instanceSyn", "getInstanceSyn", "instanceSyn$delegate", "getInstance", "getUnSafeInstance", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SingletonHolder<T> {
    private final Function0<T> creator;
    private final Lazy instanceNone$delegate;
    private final Lazy instanceSyn$delegate;

    private final T getInstanceNone() {
        return (T) this.instanceNone$delegate.getValue();
    }

    private final T getInstanceSyn() {
        return (T) this.instanceSyn$delegate.getValue();
    }

    public final T getInstance() {
        return getInstanceSyn();
    }

    public final T getUnSafeInstance() {
        return getInstanceNone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingletonHolder(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.creator = r100;
        this.instanceSyn$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new SingletonHolder$instanceSyn$2(this));
        this.instanceNone$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SingletonHolder$instanceNone$2(this));
    }

    public static final /* synthetic */ Function0 access$getCreator$p(SingletonHolder r100) {
        return r100.creator;
    }
}

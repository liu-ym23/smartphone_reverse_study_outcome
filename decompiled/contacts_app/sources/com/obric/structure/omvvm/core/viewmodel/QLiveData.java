package com.obric.structure.omvvm.core.viewmodel;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import com.obric.structure.omvvm.core.util.QExecutor;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u000f\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J&\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0016\u0010\u0014\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u0017\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u001b\u001a\u00020\t2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0017\u0010\u001f\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0017\u0010 \u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/structure/omvvm/core/viewmodel/QLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "delayLiveData", "Lcom/obric/structure/omvvm/core/viewmodel/QArchLiveData;", "liveData", "mValue", "assertMainThread", "", "delayObserve", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "getValue", "()Ljava/lang/Object;", "observe", "notifyWhenObserve", "", "observeForever", "postValue", "t", "(Ljava/lang/Object;)V", "postValueInternal", "removeObserver", "removeObservers", "setOnValueSet", "onValueSet", "Lkotlin/Function1;", "Ljava/lang/Void;", "setValue", "setValueInternal", "Companion", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QLiveData<T> {
    public static final Companion Companion = null;
    private static final Object NOT_SET = null;
    private static long delayValue;
    private static final Thread mainThread = null;
    private static boolean sBindScatterOpt;
    private static Executor sExecutor;
    private static boolean sPostScatter;
    private QArchLiveData<T> delayLiveData;
    private QArchLiveData<T> liveData;
    private volatile Object mValue;

    /* JADX INFO: compiled from: QLiveData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/obric/structure/omvvm/core/viewmodel/QLiveData$Companion;", "", "()V", "NOT_SET", "getNOT_SET", "()Ljava/lang/Object;", "delayValue", "", "getDelayValue", "()J", "setDelayValue", "(J)V", "mainThread", "Ljava/lang/Thread;", "getMainThread", "()Ljava/lang/Thread;", "sBindScatterOpt", "", "getSBindScatterOpt", "()Z", "setSBindScatterOpt", "(Z)V", "sExecutor", "Ljava/util/concurrent/Executor;", "getSExecutor", "()Ljava/util/concurrent/Executor;", "setSExecutor", "(Ljava/util/concurrent/Executor;)V", "sPostScatter", "getSPostScatter", "setSPostScatter", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Object getNOT_SET() {
            return QLiveData.access$getNOT_SET$cp();
        }

        public final Thread getMainThread() {
            return QLiveData.access$getMainThread$cp();
        }

        public final long getDelayValue() {
            return QLiveData.access$getDelayValue$cp();
        }

        public final void setDelayValue(long r1) {
            QLiveData.access$setDelayValue$cp(r1);
        }

        public final boolean getSBindScatterOpt() {
            return QLiveData.access$getSBindScatterOpt$cp();
        }

        public final void setSBindScatterOpt(boolean r1) {
            QLiveData.access$setSBindScatterOpt$cp(r1);
        }

        public final boolean getSPostScatter() {
            return QLiveData.access$getSPostScatter$cp();
        }

        public final void setSPostScatter(boolean r1) {
            QLiveData.access$setSPostScatter$cp(r1);
        }

        public final Executor getSExecutor() {
            return QLiveData.access$getSExecutor$cp();
        }

        public final void setSExecutor(Executor r1) {
            QLiveData.access$setSExecutor$cp(r1);
        }
    }

    public static /* synthetic */ void $r8$lambda$CxnccW9TAmQjPQl7KIuviRBMIE8(QLiveData r0, Object r1) {
        postValueInternal$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JpBH3MGW6YFaQagqus58tMS0PlQ(QLiveData r0, Object r1) {
        postValueInternal$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JuK9Shd3AzCAOlrXIR_MNDHsGJU(QLiveData r0, Object r1) {
        setValue$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$c02i4CpEBYWRZr0pWnF36TnM4dA(QLiveData r0, Object r1) {
        postValue$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hqmHb3ufy91QtjqQmUU8jNnWml4(QLiveData r0, Object r1) {
        setValueInternal$lambda$3(r0, r1);
    }

    public QLiveData() {
        this.liveData = new QArchLiveData();
        this.mValue = NOT_SET;
    }

    public static final /* synthetic */ QArchLiveData access$getDelayLiveData$p(QLiveData r0) {
        return r0.delayLiveData;
    }

    public static final /* synthetic */ long access$getDelayValue$cp() {
        return delayValue;
    }

    public static final /* synthetic */ QArchLiveData access$getLiveData$p(QLiveData r0) {
        return r0.liveData;
    }

    public static final /* synthetic */ Thread access$getMainThread$cp() {
        return mainThread;
    }

    public static final /* synthetic */ Object access$getNOT_SET$cp() {
        return NOT_SET;
    }

    public static final /* synthetic */ boolean access$getSBindScatterOpt$cp() {
        return sBindScatterOpt;
    }

    public static final /* synthetic */ Executor access$getSExecutor$cp() {
        return sExecutor;
    }

    public static final /* synthetic */ boolean access$getSPostScatter$cp() {
        return sPostScatter;
    }

    public static final /* synthetic */ void access$setDelayValue$cp(long r0) {
        delayValue = r0;
    }

    public static final /* synthetic */ void access$setMValue$p(QLiveData r0, Object r1) {
        r0.mValue = r1;
    }

    public static final /* synthetic */ void access$setSBindScatterOpt$cp(boolean r0) {
        sBindScatterOpt = r0;
    }

    public static final /* synthetic */ void access$setSExecutor$cp(Executor r0) {
        sExecutor = r0;
    }

    public static final /* synthetic */ void access$setSPostScatter$cp(boolean r0) {
        sPostScatter = r0;
    }

    static {
        Companion = new Companion(null);
        NOT_SET = new Object();
        Thread r0 = Looper.getMainLooper().getThread();
        Intrinsics.checkNotNullExpressionValue(r0, "getMainLooper().thread");
        mainThread = r0;
        delayValue = 100;
        sPostScatter = true;
    }

    public void observe(LifecycleOwner r2, Observer<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.liveData.observe(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void delayObserve(LifecycleOwner r4, Observer<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "observer");
        if (this.delayLiveData != null) goto L11;
        QArchLiveData<T> r0 = (QArchLiveData<T>) new QArchLiveData();
        if (Intrinsics.areEqual(this.mValue, NOT_SET) == true) goto L10;
        Object r1 = this.mValue;
        if (r1 != null) goto L9;
        r1 = null;
    L9:
        r0.postValue(r1);
    L10:
        this.delayLiveData = r0;
    L11:
        QArchLiveData<T> r3 = this.delayLiveData;
        if (r3 == null) goto L15;
        r3.observe(r4, r5);
        return;
    }

    public void observe(LifecycleOwner r2, Observer<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.liveData.observe(r2, r3, r4);
    }

    public void observeForever(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.liveData.observeForever(r2);
    }

    public void removeObserver(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.liveData.removeObserver(r2);
        QArchLiveData<T> r1 = this.delayLiveData;
        if (r1 == null) goto L6;
        r1.removeObserver(r2);
        return;
    }

    public void removeObservers(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.liveData.removeObservers(r2);
        QArchLiveData<T> r1 = this.delayLiveData;
        if (r1 == null) goto L6;
        r1.removeObservers(r2);
        return;
    }

    public void setValue(final T r3) {
        assertMainThread();
        Executor r0 = sExecutor;
        if (r0 == null) goto L5;
        r0.execute(new QLiveData$$ExternalSyntheticLambda4(this, r3));
        Unit r1 = Unit.INSTANCE;
    L6:
        if (r1 != null) goto L9;
        setValueInternal(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void setValue$lambda$1(QLiveData r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setValueInternal(r2);
    }

    private final void setValueInternal(final T r3) {
        this.mValue = r3;
        QExecutor.INSTANCE.work().post(new QLiveData$$ExternalSyntheticLambda2(this, r3));
    }

    private static final void setValueInternal$lambda$3(QLiveData r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.liveData.postValue(r3);
        QArchLiveData<T> r4 = r2.delayLiveData;
        if (r4 == null) goto L6;
        r4.postValueDelay(r3, delayValue);
        return;
    }

    private final void assertMainThread() {
        if (StringsKt.equals$default(Q.INSTANCE.getChannel$omvvm_core_release(), "local_test", false, 2, null) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(Thread.currentThread(), mainThread) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot invoke  setValue  on a background thread");
    }

    public void postValue(final T r3) {
        Executor r0 = sExecutor;
        if (r0 == null) goto L5;
        r0.execute(new QLiveData$$ExternalSyntheticLambda1(this, r3));
        Unit r1 = Unit.INSTANCE;
    L6:
        if (r1 != null) goto L9;
        postValueInternal(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void postValue$lambda$4(QLiveData r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.postValueInternal(r2);
    }

    private final void postValueInternal(final T r3) {
        QExecutor.INSTANCE.work().post(new QLiveData$$ExternalSyntheticLambda3(this, r3));
    }

    private static final void postValueInternal$lambda$7(final QLiveData r2, final Object r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        QExecutor.INSTANCE.main().post(new QLiveData$$ExternalSyntheticLambda0(r2, r3));
    }

    private static final void postValueInternal$lambda$7$lambda$6(final QLiveData r2, final Object r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (sBindScatterOpt == false) goto L5;
        QVsyncFrameCaller.INSTANCE.postBind(new QLiveData$postValueInternal$1$1$1(r2, r3), sPostScatter);
        return;
    L5:
        r2.mValue = r3;
        r2.liveData.setValue(r3);
        QArchLiveData<T> r4 = r2.delayLiveData;
        if (r4 == null) goto L10;
        r4.setValue(r3);
        return;
    }

    public T getValue() {
        T r1 = (T) this.mValue;
        if (r1 != NOT_SET) goto L7;
        return null;
    L7:
        return r1;
    }

    public final void setOnValueSet(Function1<? super T, Void> r1) {
        this.liveData.setOnValueSet(r1);
    }
}

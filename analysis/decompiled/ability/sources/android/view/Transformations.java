package android.view;

import C7.c;
import C7.r;
import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t\u001aG\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0006\u001aE\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\t\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;LS7/k;)Landroidx/lifecycle/LiveData;", "Landroidx/arch/core/util/Function;", "mapFunction", "(Landroidx/lifecycle/LiveData;Landroidx/arch/core/util/Function;)Landroidx/lifecycle/LiveData;", "switchMap", "switchMapFunction", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Transformations {

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/lifecycle/Transformations$switchMap$2", "Landroidx/lifecycle/Observer;", "value", "LC7/r;", "onChanged", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LiveData;", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "setLiveData", "(Landroidx/lifecycle/LiveData;)V", "lifecycle-livedata_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.Transformations$switchMap$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Observer {
        final /* synthetic */ MediatorLiveData $result;
        final /* synthetic */ Function $switchMapFunction;
        private LiveData liveData;

        public AnonymousClass2(Function function, MediatorLiveData mediatorLiveData) {
            this.$switchMapFunction = function;
            this.$result = mediatorLiveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r onChanged$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return r.f317a;
        }

        public final LiveData getLiveData() {
            return this.liveData;
        }

        @Override // android.view.Observer
        public void onChanged(Object value) {
            LiveData liveData = (LiveData) this.$switchMapFunction.apply(value);
            LiveData liveData2 = this.liveData;
            if (liveData2 == liveData) {
                return;
            }
            if (liveData2 != null) {
                this.$result.removeSource(liveData2);
            }
            this.liveData = liveData;
            if (liveData != null) {
                MediatorLiveData mediatorLiveData = this.$result;
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C0768c(mediatorLiveData, 2)));
            }
        }

        public final void setLiveData(LiveData liveData) {
            this.liveData = liveData;
        }
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        k.f(liveData, "<this>");
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f4916a = true;
        if (liveData.isInitialized()) {
            ref$BooleanRef.f4916a = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C0780i(mediatorLiveData, ref$BooleanRef, 1)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r distinctUntilChanged$lambda$4(MediatorLiveData mediatorLiveData, Ref$BooleanRef ref$BooleanRef, Object obj) {
        T value = mediatorLiveData.getValue();
        if (ref$BooleanRef.f4916a || ((value == 0 && obj != null) || (value != 0 && !value.equals(obj)))) {
            ref$BooleanRef.f4916a = false;
            mediatorLiveData.setValue(obj);
        }
        return r.f317a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, S7.k transform) {
        k.f(liveData, "<this>");
        k.f(transform, "transform");
        MediatorLiveData mediatorLiveData = liveData.isInitialized() ? new MediatorLiveData(transform.invoke(liveData.getValue())) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C0780i(mediatorLiveData, transform, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r map$lambda$0(MediatorLiveData mediatorLiveData, S7.k kVar, Object obj) {
        mediatorLiveData.setValue(kVar.invoke(obj));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r map$lambda$1(MediatorLiveData mediatorLiveData, Function function, Object obj) {
        mediatorLiveData.setValue(function.apply(obj));
        return r.f317a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, S7.k transform) {
        LiveData liveData2;
        k.f(liveData, "<this>");
        k.f(transform, "transform");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        MediatorLiveData mediatorLiveData = (liveData.isInitialized() && (liveData2 = (LiveData) transform.invoke(liveData.getValue())) != null && liveData2.isInitialized()) ? new MediatorLiveData(liveData2.getValue()) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new R3.k(transform, ref$ObjectRef, mediatorLiveData, 1)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r switchMap$lambda$3(S7.k kVar, Ref$ObjectRef ref$ObjectRef, MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) kVar.invoke(obj);
        Object obj2 = ref$ObjectRef.f4920a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                mediatorLiveData.removeSource((LiveData) obj2);
            }
            ref$ObjectRef.f4920a = liveData;
            if (liveData != null) {
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C0768c(mediatorLiveData, 1)));
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r switchMap$lambda$3$lambda$2(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return r.f317a;
    }

    @c
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        k.f(liveData, "<this>");
        k.f(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C0780i(mediatorLiveData, mapFunction, 2)));
        return mediatorLiveData;
    }

    @c
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function switchMapFunction) {
        k.f(liveData, "<this>");
        k.f(switchMapFunction, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass2(switchMapFunction, mediatorLiveData));
        return mediatorLiveData;
    }
}

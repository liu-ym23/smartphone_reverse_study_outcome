package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\u0010\u0004\u001a\u0018\u0012\t\u0012\u0007H\u0003¢\u0006\u0002\b\u0006\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00060\u0005H\u0007\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001aJ\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012$\u0010\u0004\u001a \u0012\t\u0012\u0007H\u0003¢\u0006\u0002\b\u0006\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00060\u0005H\u0007\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\bH\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007¨\u0006\f"}, d2 = {"map", "Landroidx/lifecycle/LiveData;", "Y", "X", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "distinctUntilChanged", "lifecycle-livedata_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Transformations {

    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/lifecycle/Transformations$switchMap$2", "Landroidx/lifecycle/Observer;", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "setLiveData", "(Landroidx/lifecycle/LiveData;)V", "onChanged", "", "value", "(Ljava/lang/Object;)V", "lifecycle-livedata_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Observer {
        final /* synthetic */ MediatorLiveData $result;
        final /* synthetic */ Function $switchMapFunction;
        private LiveData liveData;

        public static /* synthetic */ Unit a(MediatorLiveData r100, Object r101) {
            return onChanged$lambda$0(r100, r101);
        }

        public final LiveData getLiveData() {
            return this.liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object r100) {
            LiveData r101 = (LiveData) this.$switchMapFunction.apply(r100);
            LiveData r102 = this.liveData;
            if (r102 != r101) goto L5;
            return;
        L5:
            if (r102 == null) goto L7;
            MediatorLiveData r103 = this.$result;
            Intrinsics.checkNotNull(r102);
            r103.removeSource(r102);
        L7:
            this.liveData = r101;
            if (r101 == null) goto L11;
            MediatorLiveData r104 = this.$result;
            Intrinsics.checkNotNull(r101);
            final MediatorLiveData r105 = this.$result;
            r104.addSource(r101, new Transformations$sam$androidx_lifecycle_Observer$0(new r(r105)));
            return;
        }

        public final void setLiveData(LiveData r100) {
            this.liveData = r100;
        }

        public AnonymousClass2(Function r100, MediatorLiveData r101) {
            this.$switchMapFunction = r100;
            this.$result = r101;
        }

        private static final Unit onChanged$lambda$0(MediatorLiveData r100, Object r101) {
            r100.setValue(r101);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Unit a(Function1 r100, Ref.ObjectRef r101, MediatorLiveData r102, Object r103) {
        return switchMap$lambda$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit b(MediatorLiveData r100, Ref.BooleanRef r101, Object r102) {
        return distinctUntilChanged$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ Unit c(MediatorLiveData r100, Function r101, Object r102) {
        return map$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(MediatorLiveData r100, Object r101) {
        return switchMap$lambda$3$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit e(MediatorLiveData r100, Function1 r101, Object r102) {
        return map$lambda$0(r100, r101, r102);
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = true;
        if (r100.isInitialized() == false) goto L5;
        r101.element = false;
        final MediatorLiveData r102 = new MediatorLiveData(r100.getValue());
    L6:
        r102.addSource(r100, new Transformations$sam$androidx_lifecycle_Observer$0(new m(r102, r101)));
        return r102;
    L5:
        r102 = new MediatorLiveData();
        goto L6
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> r100, final Function1<X, Y> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (r100.isInitialized() == false) goto L5;
        final MediatorLiveData r102 = new MediatorLiveData(r101.invoke(r100.getValue()));
    L6:
        r102.addSource(r100, new Transformations$sam$androidx_lifecycle_Observer$0(new q(r102, r101)));
        return r102;
    L5:
        r102 = new MediatorLiveData();
        goto L6
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> r100, final Function1<X, LiveData<Y>> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        if (r100.isInitialized() == false) goto L10;
        LiveData<Y> r103 = r101.invoke(r100.getValue());
        if (r103 != null) goto L7;
    L9:
        final MediatorLiveData r104 = new MediatorLiveData();
    L11:
        r104.addSource(r100, new Transformations$sam$androidx_lifecycle_Observer$0(new o(r101, r102, r104)));
        return r104;
    L7:
        if (r103.isInitialized() == false) goto L9;
        r104 = new MediatorLiveData(r103.getValue());
        goto L11
    L10:
        r104 = new MediatorLiveData();
        goto L11
    }

    private static final Unit switchMap$lambda$3$lambda$2(MediatorLiveData r100, Object r101) {
        r100.setValue(r101);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData r100, final Function r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mapFunction");
        final MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r100, new Transformations$sam$androidx_lifecycle_Observer$0(new n(r102, r101)));
        return r102;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData r100, Function r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "switchMapFunction");
        MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r100, new AnonymousClass2(r101, r102));
        return r102;
    }

    private static final Unit distinctUntilChanged$lambda$4(MediatorLiveData r100, Ref.BooleanRef r101, Object r102) {
        T r103 = r100.getValue();
        if (r101.element == true) goto L9;
        if (r103 != 0) goto L6;
        if (r102 != null) goto L9;
    L6:
        if (r103 == 0) goto L11;
        if (Intrinsics.areEqual(r103, r102) == false) goto L9;
    L11:
        return Unit.INSTANCE;
    L9:
        r101.element = false;
        r100.setValue(r102);
        goto L11
    }

    private static final Unit map$lambda$0(MediatorLiveData r100, Function1 r101, Object r102) {
        r100.setValue(r101.invoke(r102));
        return Unit.INSTANCE;
    }

    private static final Unit map$lambda$1(MediatorLiveData r100, Function r101, Object r102) {
        r100.setValue(r101.apply(r102));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, androidx.lifecycle.LiveData, java.lang.Object] */
    private static final Unit switchMap$lambda$3(Function1 r100, Ref.ObjectRef r101, final MediatorLiveData r102, Object r103) {
        ?? r104 = (LiveData) r100.invoke(r103);
        T r105 = r101.element;
        if (r105 == r104) goto L10;
        if (r105 == 0) goto L6;
        Intrinsics.checkNotNull(r105);
        r102.removeSource((LiveData) r105);
    L6:
        r101.element = r104;
        if (r104 == 0) goto L10;
        Intrinsics.checkNotNull(r104);
        LiveData r106 = (LiveData) r104;
        r102.addSource(r104, new Transformations$sam$androidx_lifecycle_Observer$0(new p(r102)));
    L10:
        return Unit.INSTANCE;
    }
}

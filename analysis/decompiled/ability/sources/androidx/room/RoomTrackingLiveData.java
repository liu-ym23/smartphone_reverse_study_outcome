package androidx.room;

import C7.r;
import H7.h;
import S7.n;
import android.view.LiveData;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.InvalidationTracker;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0001\u0002()¨\u0006*"}, d2 = {"Landroidx/room/RoomTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "Landroidx/room/RoomDatabase;", "database", "Landroidx/room/InvalidationLiveDataContainer;", "container", "", "inTransaction", "", "", "tableNames", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;)V", "LC7/r;", "refresh", "(LH7/c;)Ljava/lang/Object;", "invalidated", "()V", "compute", "onActive", "onInactive", "Landroidx/room/RoomDatabase;", "getDatabase", "()Landroidx/room/RoomDatabase;", "Landroidx/room/InvalidationLiveDataContainer;", "Z", "getInTransaction", "()Z", "Landroidx/room/InvalidationTracker$Observer;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "registeredObserver", "LH7/h;", "launchContext", "LH7/h;", "Landroidx/room/RoomCallableTrackingLiveData;", "Landroidx/room/RoomLambdaTrackingLiveData;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final h launchContext;
    private final InvalidationTracker.Observer observer;
    private final AtomicBoolean registeredObserver;

    @J7.c(c = "androidx.room.RoomTrackingLiveData$invalidated$1", f = "RoomTrackingLiveData.android.kt", l = {113}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.RoomTrackingLiveData$invalidated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RoomTrackingLiveData<T> roomTrackingLiveData, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                RoomTrackingLiveData<T> roomTrackingLiveData = this.this$0;
                this.label = 1;
                if (roomTrackingLiveData.refresh(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.room.RoomTrackingLiveData$onActive$1", f = "RoomTrackingLiveData.android.kt", l = {123}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.RoomTrackingLiveData$onActive$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07861 extends SuspendLambda implements n {
        int label;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07861(RoomTrackingLiveData<T> roomTrackingLiveData, H7.c<? super C07861> cVar) {
            super(2, cVar);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C07861(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                RoomTrackingLiveData<T> roomTrackingLiveData = this.this$0;
                this.label = 1;
                if (roomTrackingLiveData.refresh(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C07861) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", l = {82}, m = "refresh")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.RoomTrackingLiveData$refresh$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07871 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07871(RoomTrackingLiveData<T> roomTrackingLiveData, H7.c<? super C07871> cVar) {
            super(cVar);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.refresh(this);
        }
    }

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z10, String[] strArr, e eVar) {
        this(roomDatabase, invalidationLiveDataContainer, z10, strArr);
    }

    public static final /* synthetic */ void access$invalidated(RoomTrackingLiveData roomTrackingLiveData) {
        roomTrackingLiveData.invalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void invalidated() {
        boolean zHasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            AbstractC1683A.n(this.database.getCoroutineScope(), this.launchContext, new AnonymousClass1(this, null), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e A[Catch: all -> 0x002a, Exception -> 0x002c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002c, blocks: (B:12:0x0026, B:28:0x005e), top: B:45:0x0026, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #1 {all -> 0x002a, blocks: (B:12:0x0026, B:26:0x0056, B:28:0x005e, B:35:0x0075, B:32:0x006b, B:33:0x0072), top: B:45:0x0026, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0054 -> B:26:0x0056). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0084 -> B:40:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refresh(H7.c<? super C7.r> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.room.RoomTrackingLiveData.C07871
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = (androidx.room.RoomTrackingLiveData.C07871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = new androidx.room.RoomTrackingLiveData$refresh$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            int r2 = r0.I$0
            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            goto L56
        L2a:
            r7 = move-exception
            goto L7e
        L2c:
            r7 = move-exception
            goto L6b
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.b.b(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.registeredObserver
            boolean r7 = r7.compareAndSet(r3, r4)
            if (r7 == 0) goto L4c
            androidx.room.RoomDatabase r7 = r6.database
            androidx.room.InvalidationTracker r7 = r7.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r2 = r6.observer
            r7.addWeakObserver(r2)
        L4c:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.computing
            boolean r7 = r7.compareAndSet(r3, r4)
            if (r7 == 0) goto L84
            r7 = 0
            r2 = r3
        L56:
            java.util.concurrent.atomic.AtomicBoolean r5 = r6.invalid     // Catch: java.lang.Throwable -> L2a
            boolean r5 = r5.compareAndSet(r4, r3)     // Catch: java.lang.Throwable -> L2a
            if (r5 == 0) goto L73
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.label = r4     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.Object r7 = r6.compute(r0)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            if (r7 != r1) goto L69
            return r1
        L69:
            r2 = r4
            goto L56
        L6b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = "Exception while computing database live data."
            r0.<init>(r1, r7)     // Catch: java.lang.Throwable -> L2a
            throw r0     // Catch: java.lang.Throwable -> L2a
        L73:
            if (r2 == 0) goto L78
            r6.postValue(r7)     // Catch: java.lang.Throwable -> L2a
        L78:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.computing
            r7.set(r3)
            goto L85
        L7e:
            java.util.concurrent.atomic.AtomicBoolean r6 = r6.computing
            r6.set(r3)
            throw r7
        L84:
            r2 = r3
        L85:
            if (r2 == 0) goto L8f
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.invalid
            boolean r7 = r7.get()
            if (r7 != 0) goto L4c
        L8f:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refresh(H7.c):java.lang.Object");
    }

    public abstract Object compute(H7.c<? super T> cVar);

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    @Override // android.view.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        AbstractC1683A.n(this.database.getCoroutineScope(), this.launchContext, new C07861(this, null), 2);
    }

    @Override // android.view.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z10, String[] strArr) {
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z10;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.launchContext = roomDatabase.inCompatibilityMode() ? z10 ? roomDatabase.getTransactionContext$room_runtime() : roomDatabase.getQueryContext() : EmptyCoroutineContext.f4908a;
    }
}

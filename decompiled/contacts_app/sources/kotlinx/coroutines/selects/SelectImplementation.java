package kotlinx.coroutines.selects;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001HB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0011\u0010\u001f\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0011\u0010$\u001a\u00028\u0000H\u0091@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010%\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001c\u0010&\u001a\u000e\u0018\u00010\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0013\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\u001c\u0010*\u001a\u00020\u001b2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\u0014H\u0016J-\u0010.\u001a\u00028\u00002\u0010\u0010/\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u00102\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00103\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00105\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u00108\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J3\u0010'\u001a\u00020\u001b*\u0002092\u001c\u0010:\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0;H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010=JE\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010AJY\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010B\"\u0004\b\u0002\u0010>*\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H>0C2\u0006\u0010D\u001a\u0002HB2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u001b*\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010G\u001a\u00020\u0010H\u0001R \u0010\b\u001a\u0014\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "indexInSegment", "", "internalResult", "isCancelled", "isSelected", "state", "Lkotlinx/atomicfu/AtomicRef;", "checkClauseObject", "", "clauseObject", "cleanup", "selectedClause", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "doSelect", "doSelectSuspend", "findClause", "invoke", "cause", "", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", AutoTestConstant.PARAM, "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SelectImplementation<R> extends CancelHandler implements SelectBuilder<R>, SelectInstanceInternal<R> {
    private static final AtomicReferenceFieldUpdater state$FU = null;
    private List<SelectImplementation<R>.ClauseData> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;

    @Volatile
    private volatile Object state;

    /* JADX INFO: compiled from: Select.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B¶\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u001b\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0014\u0010 \u001a\u00020!2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\"R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000Rq\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", AutoTestConstant.PARAM, "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "createOnCancellationAction", "dispose", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        private final Function3<Object, Object, Object, Object> processResFunc;
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;
        final /* synthetic */ SelectImplementation<R> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ClauseData(SelectImplementation r1, Object r2, Function3<Object, ? super SelectInstance<?>, Object, Unit> r3, Function3<Object, Object, Object, ? extends Object> r4, Object r5, Object r6, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r7) {
            this.this$0 = r1;
            this.clauseObject = r2;
            this.regFunc = r3;
            this.processResFunc = r4;
            this.param = r5;
            this.block = r6;
            this.onCancellationConstructor = r7;
            this.indexInSegment = -1;
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation<R> r5) {
            if (DebugKt.getASSERTIONS_ENABLED() == false) goto L16;
            if (SelectImplementation.access$getInRegistrationPhase(r5) == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            if (r0 == true) goto L16;
            throw new AssertionError();
        L7:
            if (SelectImplementation.access$isCancelled(r5) == true) goto L10;
            r0 = false;
        L16:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L18;
        L25:
            this.regFunc.invoke(this.clauseObject, r5, this.param);
            if (SelectImplementation.access$getInternalResult$p(r5) == SelectKt.access$getNO_RESULT$p()) goto L28;
            return false;
        L28:
            return true;
        L18:
            if (SelectImplementation.access$getInternalResult$p(r5) != SelectKt.access$getNO_RESULT$p()) goto L20;
            boolean r1 = true;
        L21:
            if (r1 == true) goto L25;
            throw new AssertionError();
        L20:
            r1 = false;
            goto L21
        }

        public final Object processResult(Object r3) {
            return this.processResFunc.invoke(this.clauseObject, this.param, r3);
        }

        public final Object invokeBlock(Object r3, Continuation<? super R> r4) {
            Object r0 = this.block;
            if (this.param != SelectKt.getPARAM_CLAUSE_0()) goto L6;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function1) r0).invoke(r4);
        L6:
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) r0).invoke(r3, r4);
        }

        public final void dispose() {
            Object r0 = this.disposableHandleOrSegment;
            SelectImplementation<R> r1 = this.this$0;
            DisposableHandle r3 = null;
            if ((r0 instanceof Segment) == false) goto L6;
            ((Segment) r0).onCancellation(this.indexInSegment, null, r1.getContext());
            return;
        L6:
            if ((r0 instanceof DisposableHandle) == false) goto L8;
            r3 = (DisposableHandle) r0;
        L8:
            if (r3 == null) goto L12;
            r3.dispose();
            return;
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(SelectInstance<?> r2, Object r3) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> r0 = this.onCancellationConstructor;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.invoke(r2, this.param, r3);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: Select.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {0}, l = {431, 434}, m = "doSelectSuspend", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        AnonymousClass1(SelectImplementation<R> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SelectImplementation.access$doSelectSuspend(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Select.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {706}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
    static final class C05821 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        C05821(SelectImplementation<R> r1, Continuation<? super C05821> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SelectImplementation.access$processResultAndInvokeBlockRecoveringException(this.this$0, null, null, this);
        }
    }

    static {
        state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater r2, Function1<Object, ? extends Object> r3, Object r4) {
    L2:
        Object r1 = r2.get(r4);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r2, r4, r1, r3.invoke(r1)) == false) goto L2;
    }

    public Object doSelect(Continuation<? super R> r1) {
        return doSelect$suspendImpl(this, r1);
    }

    public static final /* synthetic */ Object access$complete(SelectImplementation r0, Continuation r1) {
        return r0.complete(r1);
    }

    public static final /* synthetic */ Object access$doSelectSuspend(SelectImplementation r0, Continuation r1) {
        return r0.doSelectSuspend(r1);
    }

    public static final /* synthetic */ boolean access$getInRegistrationPhase(SelectImplementation r0) {
        return r0.getInRegistrationPhase();
    }

    public static final /* synthetic */ Object access$getInternalResult$p(SelectImplementation r0) {
        return r0.internalResult;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getState$FU$p() {
        return state$FU;
    }

    public static final /* synthetic */ boolean access$isCancelled(SelectImplementation r0) {
        return r0.isCancelled();
    }

    public static final /* synthetic */ Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation r0, ClauseData r1, Object r2, Continuation r3) {
        return r0.processResultAndInvokeBlockRecoveringException(r1, r2, r3);
    }

    public static final /* synthetic */ void access$reregisterClause(SelectImplementation r0, Object r1) {
        r0.reregisterClause(r1);
    }

    public static final /* synthetic */ Object access$waitUntilSelected(SelectImplementation r0, Continuation r1) {
        return r0.waitUntilSelected(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> r1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r2) {
        SelectBuilder.DefaultImpls.invoke(this, r1, r2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    public void onTimeout(long r1, Function1<? super Continuation<? super R>, ? extends Object> r3) {
        SelectBuilder.DefaultImpls.onTimeout(this, r1, r3);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.context;
    }

    public SelectImplementation(CoroutineContext r2) {
        this.context = r2;
        this.state = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    private final boolean getInRegistrationPhase() {
        Object r1 = state$FU.get(this);
        if (r1 != SelectKt.access$getSTATE_REG$p()) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof List) == true) goto L8;
        return false;
    }

    private final boolean isSelected() {
        return state$FU.get(this) instanceof ClauseData;
    }

    private final boolean isCancelled() {
        if (state$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p()) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> r1, Continuation<? super R> r2) {
        if (r1.isSelected() == false) goto L7;
        return r1.complete(r2);
    L7:
        return r1.doSelectSuspend(r2);
    }

    private final Object doSelectSuspend(Continuation<? super R> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r7);
    L22:
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SelectImplementation<R> this = (SelectImplementation) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L19:
        r0.L$0 = null;
        r0.label = 2;
        r7 = this.complete(r0);
        if (r7 != r1) goto L22;
        return r1;
    L16:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = this;
        r0.label = 1;
        if (waitUntilSelected(r0) != r1) goto L19;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 r10, Function1<? super Continuation<? super R>, ? extends Object> r11) {
        register$default(this, new ClauseData(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), r11, r10.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> r10, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r11) {
        register$default(this, new ClauseData(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), null, r11, r10.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> r10, P r11, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r12) {
        register$default(this, new ClauseData(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), r11, r12, r10.getOnCancellationConstructor()), false, 1, null);
    }

    public static /* synthetic */ void register$default(SelectImplementation r0, ClauseData r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        r0.register(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    public final void register(SelectImplementation<R>.ClauseData r3, boolean r4) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        AtomicReferenceFieldUpdater r0 = state$FU;
        if ((r0.get(this) instanceof ClauseData) == false) goto L15;
        return;
    L15:
        if (r4 == true) goto L18;
        checkClauseObject(r3.clauseObject);
    L18:
        if (r3.tryRegisterAsWaiter(this) == false) goto L22;
        if (r4 == true) goto L21;
        List<SelectImplementation<R>.ClauseData> r5 = this.clauses;
        Intrinsics.checkNotNull(r5);
        r5.add(r3);
    L21:
        r3.disposableHandleOrSegment = this.disposableHandleOrSegment;
        r3.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
        return;
    L22:
        r0.set(this, r3);
        return;
    L5:
        if (state$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    private final void checkClauseObject(Object r4) {
        List<SelectImplementation<R>.ClauseData> r3 = this.clauses;
        Intrinsics.checkNotNull(r3);
        List<SelectImplementation<R>.ClauseData> r5 = r3;
        boolean r1 = true;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L16;
        if (((ClauseData) r6.next()).clauseObject != r4) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
        r1 = false;
        goto L16
    L13:
        r0 = false;
    L16:
        if (r1 == false) goto L19;
        return;
    L19:
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r4).toString());
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(DisposableHandle r1) {
        this.disposableHandleOrSegment = r1;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> r1, int r2) {
        this.disposableHandleOrSegment = r1;
        this.indexInSegment = r2;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object r1) {
        this.internalResult = r1;
    }

    private final void reregisterClause(Object r2) {
        SelectImplementation<R>.ClauseData r3 = findClause(r2);
        Intrinsics.checkNotNull(r3);
        r3.disposableHandleOrSegment = null;
        r3.indexInSegment = -1;
        register(r3, true);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object r1, Object r2) {
        if (trySelectInternal(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object r1, Object r2) {
        return SelectKt.access$TrySelectDetailedResult(trySelectInternal(r1, r2));
    }

    private final int trySelectInternal(Object r6, Object r7) {
    L2:
        AtomicReferenceFieldUpdater r0 = state$FU;
        Object r1 = r0.get(this);
        if ((r1 instanceof CancellableContinuation) == true) goto L4;
        if (Intrinsics.areEqual(r1, SelectKt.access$getSTATE_COMPLETED$p()) == false) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L20;
        if (Intrinsics.areEqual(r1, SelectKt.access$getSTATE_CANCELLED$p()) == true) goto L24;
        if (Intrinsics.areEqual(r1, SelectKt.access$getSTATE_REG$p()) == true) goto L28;
        if ((r1 instanceof List) == false) goto L36;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r1, CollectionsKt.plus((Collection) r1, r6)) == false) goto L2;
        return 1;
    L36:
        throw new IllegalStateException(("Unexpected state: " + r1).toString());
    L28:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r1, CollectionsKt.listOf(r6)) == false) goto L2;
        return 1;
    L24:
        return 2;
    L20:
        return 3;
    L18:
        r2 = r1 instanceof ClauseData;
        goto L19
    L4:
        SelectImplementation<R>.ClauseData r3 = findClause(r6);
        if (r3 == null) goto L2;
        Function1<Throwable, Unit> r4 = r3.createOnCancellationAction(this, r7);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r1, r3) == false) goto L2;
        this.internalResult = r7;
        if (SelectKt.access$tryResume((CancellableContinuation) r1, r4) == false) goto L13;
        return 0;
    L13:
        this.internalResult = null;
        return 2;
    }

    private final SelectImplementation<R>.ClauseData findClause(Object r4) {
        List<SelectImplementation<R>.ClauseData> r3 = this.clauses;
        Object r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Object r1 = r5.next();
        if (((ClauseData) r1).clauseObject != r4) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
        r0 = r1;
        goto L14
    L11:
        r2 = false;
    L14:
        SelectImplementation<R>.ClauseData r6 = (ClauseData) r0;
        if (r6 == null) goto L18;
        return r6;
    L18:
        throw new IllegalStateException(("Clause with object " + r4 + " is not found").toString());
    }

    private final Object complete(Continuation<? super R> r4) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L9:
        Object r0 = state$FU.get(this);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.ClauseData r1 = (ClauseData) r0;
        Object r2 = this.internalResult;
        cleanup(r1);
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L14;
        return r1.invokeBlock(r1.processResult(r2), r4);
    L14:
        return processResultAndInvokeBlockRecoveringException(r1, r2, r4);
    L5:
        if (isSelected() == true) goto L9;
        throw new AssertionError();
    }

    private final Object processResultAndInvokeBlockRecoveringException(SelectImplementation<R>.ClauseData r4, Object r5, Continuation<? super R> r6) {
        if ((r6 instanceof C05821) == false) goto L7;
        C05821 r0 = (C05821) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L17;
        if (r1 != 1) goto L16;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L13
    L30:
        return r3;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r3);
        Object r8 = r4.processResult(r5);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r3 = r4.invokeBlock(r8, r0);     // Catch: Throwable -> L13
        if (r3 != r7) goto L30;
        return r7;
    L13:
        th = move-exception;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L25;
        throw th;
    L25:
        if ((r0 instanceof CoroutineStackFrame) == true) goto L28;
        throw th;
    L28:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(th, r0);
    L7:
        r0 = new C05821(this, r6);
        goto L8
    }

    private final void cleanup(SelectImplementation<R>.ClauseData r3) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L9:
        List<SelectImplementation<R>.ClauseData> r0 = this.clauses;
        if (r0 != null) goto L12;
        return;
    L12:
        Iterator<T> r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        SelectImplementation<R>.ClauseData r2 = (ClauseData) r1.next();
        if (r2 == r3) goto L14;
        r2.dispose();
        goto L14
    L18:
        state$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
        return;
    L5:
        if (Intrinsics.areEqual(state$FU.get(this), r3) == true) goto L9;
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable r3) {
        AtomicReferenceFieldUpdater r4 = state$FU;
    L3:
        Object r0 = r4.get(this);
        if (r0 == SelectKt.access$getSTATE_COMPLETED$p()) goto L5;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r4, this, r0, SelectKt.access$getSTATE_CANCELLED$p()) == false) goto L3;
        List<SelectImplementation<R>.ClauseData> r5 = this.clauses;
        if (r5 != null) goto L11;
        return;
    L11:
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        ((ClauseData) r6.next()).dispose();
        goto L13
    L15:
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
        return;
    }

    private final Object waitUntilSelected(Continuation<? super Unit> r7) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r7), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        AtomicReferenceFieldUpdater r2 = access$getState$FU$p();
    L3:
        Object r3 = r2.get(this);
        if (r3 == SelectKt.access$getSTATE_REG$p()) goto L6;
        if ((r3 instanceof List) == false) goto L17;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(access$getState$FU$p(), this, r3, SelectKt.access$getSTATE_REG$p()) == false) goto L3;
        List r4 = (List) r3;
        Iterator r5 = ((Iterable) r3).iterator();
    L14:
        if (r5.hasNext() == false) goto L3;
        access$reregisterClause(this, r5.next());
        goto L14
    L17:
        if ((r3 instanceof ClauseData) == false) goto L28;
        r1.resume(Unit.INSTANCE, ((ClauseData) r3).createOnCancellationAction(this, access$getInternalResult$p(this)));
    L19:
        Object r6 = r0.getResult();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L23:
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r6;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException(("unexpected state: " + r3).toString());
    L6:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(access$getState$FU$p(), this, r3, r1) == false) goto L3;
        r1.invokeOnCancellation(this);
        goto L19
    }
}

package androidx.compose.runtime;

import C7.r;
import D7.t;
import D7.v;
import S7.n;
import androidx.collection.IntList;
import androidx.collection.ObjectList;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002BA\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/ComposePausableCompositionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroidx/collection/ObjectList;", "", "instances", "reused", "Landroidx/collection/IntList;", "operations", "", "lastOperation", "", "cause", AppAgent.CONSTRUCT, "(Landroidx/collection/ObjectList;Landroidx/collection/ObjectList;Landroidx/collection/IntList;ILjava/lang/Throwable;)V", "Li9/i;", "", "operationsSequence", "()Li9/i;", "Landroidx/collection/ObjectList;", "Landroidx/collection/IntList;", "I", "getMessage", "()Ljava/lang/String;", "getMessage$annotations", "()V", "message", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ComposePausableCompositionException extends Exception {
    private final ObjectList<Object> instances;
    private final int lastOperation;
    private final IntList operations;
    private final ObjectList<Object> reused;

    @J7.c(c = "androidx.compose.runtime.ComposePausableCompositionException$operationsSequence$1", f = "PausableComposition.kt", l = {554}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li9/k;", "", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.ComposePausableCompositionException$operationsSequence$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements n {
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = ComposePausableCompositionException.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(i9.k kVar, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(kVar, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            i9.k kVar;
            int i;
            int i6;
            int i10;
            String strJ;
            int i11;
            int i12;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i13 = this.label;
            if (i13 == 0) {
                kotlin.b.b(obj);
                kVar = (i9.k) this.L$0;
                i = 0;
                i6 = 0;
                i10 = 0;
            } else {
                if (i13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$2;
                i6 = this.I$1;
                i10 = this.I$0;
                kVar = (i9.k) this.L$0;
                kotlin.b.b(obj);
            }
            if (i10 >= Math.min(ComposePausableCompositionException.this.lastOperation, ComposePausableCompositionException.this.operations._size)) {
                return r.f317a;
            }
            int i14 = i10 + 1;
            int i15 = ComposePausableCompositionException.this.operations.get(i10);
            switch (i15) {
                case 0:
                    strJ = "up";
                    break;
                case 1:
                    strJ = androidx.appfunctions.metadata.a.j(ComposePausableCompositionException.this.instances.get(i6), "down ");
                    i6++;
                    break;
                case 2:
                    strJ = "remove " + ComposePausableCompositionException.this.operations.get(i14) + ' ' + ComposePausableCompositionException.this.operations.get(i10 + 2);
                    i14 = i10 + 3;
                    break;
                case 3:
                    strJ = "move " + ComposePausableCompositionException.this.operations.get(i14) + ' ' + ComposePausableCompositionException.this.operations.get(i10 + 2) + ' ' + ComposePausableCompositionException.this.operations.get(i10 + 3);
                    i14 = i10 + 4;
                    break;
                case 4:
                    strJ = "clear";
                    break;
                case 5:
                    i11 = i10 + 2;
                    i12 = i6 + 1;
                    strJ = "insertBottomUp " + ComposePausableCompositionException.this.operations.get(i14) + ' ' + ComposePausableCompositionException.this.instances.get(i6);
                    i14 = i11;
                    i6 = i12;
                    break;
                case 6:
                    i11 = i10 + 2;
                    i12 = i6 + 1;
                    strJ = "insertTopDown " + ComposePausableCompositionException.this.operations.get(i14) + ' ' + ComposePausableCompositionException.this.instances.get(i6);
                    i14 = i11;
                    i6 = i12;
                    break;
                case 7:
                    int i16 = i6 + 1;
                    Object obj2 = ComposePausableCompositionException.this.instances.get(i6);
                    kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
                    p.e(2, obj2);
                    i6 += 2;
                    strJ = "apply " + ((n) obj2) + ' ' + ComposePausableCompositionException.this.instances.get(i16);
                    break;
                case 8:
                    strJ = "reuse " + ComposePausableCompositionException.this.reused.get(i);
                    i++;
                    break;
                default:
                    strJ = B7.a.h(i15, "unknown op: ");
                    break;
            }
            this.L$0 = kVar;
            this.I$0 = i14;
            this.I$1 = i6;
            this.I$2 = i;
            this.label = 1;
            kVar.a(this, i10 + ": " + strJ);
            return coroutineSingletons;
        }
    }

    public ComposePausableCompositionException(ObjectList<Object> objectList, ObjectList<Object> objectList2, IntList intList, int i, Throwable th) {
        super(th);
        this.instances = objectList;
        this.reused = objectList2;
        this.operations = intList;
        this.lastOperation = i;
    }

    public static /* synthetic */ void getMessage$annotations() {
    }

    private final i9.i operationsSequence() {
        return new t(new AnonymousClass1(null));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return j9.n.S("\n            |Exception while applying pausable composition. Last 10 operations:\n            |" + v.I0(v.b1(10, kotlin.sequences.a.o0(operationsSequence())), "\n", null, null, null, 62) + "\n            ");
    }
}

package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.contactsdk.loader.ContractKt;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001}B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u00101\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H3022\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0001J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\u0011\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\u0010?J9\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0;\"\b\b\u0000\u0010A*\u00020\u00012\u001e\b\u0004\u0010B\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u0002HA0CH\u0082\bJ\u0010\u0010E\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0002J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0;J\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010I\u001a\u00020<2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;J\u000e\u0010K\u001a\u00020)2\u0006\u0010I\u001a\u00020<J.\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u00010'2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J=\u0010O\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020Q0P2\u0006\u0010R\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010TJ1\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0015\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020*H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020\u0014H\u0000¢\u0006\u0002\b]J\u001e\u0010^\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\u0014\u0010`\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J'\u0010b\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H302H\u0000¢\u0006\u0002\bcJ\u0019\u0010d\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\beJ\u0019\u0010f\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\bgJ%\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040;\"\b\b\u0000\u00103*\u00020i2\u0006\u0010j\u001a\u0002H3H\u0002¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020\u0014H\u0002J\b\u0010m\u001a\u00020\u0014H\u0002J\r\u0010n\u001a\u00020\u0014H\u0000¢\u0006\u0002\boJ\u0018\u0010p\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00072\u0006\u0010M\u001a\u00020)H\u0002J\u001c\u0010q\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J(\u0010q\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J4\u0010r\u001a\u00020\u0014*\u00020*2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0t2\n\u0010u\u001a\u00060vj\u0002`w2\u0006\u0010x\u001a\u00020)H\u0002J\u0010\u0010y\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0016\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u0006\u0012\u0002\b\u000302H\u0002J\u0013\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u0007H\u0082\u0010J\u000f\u0010z\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0082\u0010J\u0012\u0010{\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\f\u0010|\u001a\u00020)*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\t\u0010\u001d\u001a\u00020\u001eX\u0082\u0004R\u0011\u0010\u001f\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\t\u0010$\u001a\u00020%X\u0082\u0004R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)*\u00020*8BX\u0082\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00020\u000f*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006~"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "capturedCoroutines", "", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutinesMap", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/Function1;", "", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "()Z", "setEnableCreationStackTraces$kotlinx_coroutines_core", "(Z)V", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "weakRefCleanerThread", "Ljava/lang/Thread;", "debugString", "", "Lkotlinx/coroutines/Job;", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "createOwner", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "completion", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "dumpCoroutinesInfo", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "dumpCoroutinesInfoImpl", "R", ContractKt.OBRIC_ACTION_CREATE, "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesSynchronized", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "enhanceStackTraceWithThreadDump", AlogMonitor.ALOG_RESULT_INFO, "coroutineTrace", "enhanceStackTraceWithThreadDumpAsJson", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "getDynamicAttach", "hierarchyToString", "job", "hierarchyToString$kotlinx_coroutines_core", "install", "install$kotlinx_coroutines_core", "printStackTrace", "frames", "probeCoroutineCompleted", "owner", "probeCoroutineCreated", "probeCoroutineCreated$kotlinx_coroutines_core", "probeCoroutineResumed", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "uninstall$kotlinx_coroutines_core", "updateRunningState", "updateState", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "isFinished", "realCaller", "toStackTraceFrame", "toStringRepr", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImpl {
    private static final StackTraceElement ARTIFICIAL_FRAME = null;
    public static final DebugProbesImpl INSTANCE = null;
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = null;
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = null;
    private static final SimpleDateFormat dateFormat = null;
    private static final Function1<Boolean, Unit> dynamicAttach = null;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext;
    private static final DebugProbesImpl$Installations$kotlinx$VolatileWrapper installations$kotlinx$VolatileWrapper = null;
    private static boolean sanitizeStackTraces;
    private static final DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper = null;
    private static Thread weakRefCleanerThread;

    /* JADX INFO: compiled from: DebugProbesImpl.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", AlogMonitor.ALOG_RESULT_INFO, "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        public final DebugCoroutineInfoImpl info;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(Continuation<? super T> r1, DebugCoroutineInfoImpl r2) {
            this.delegate = r1;
            this.info = r2;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame r0 = getFrame();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCallerFrame();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame r0 = getFrame();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r2) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.delegate.resumeWith(r2);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private static /* synthetic */ void getDebugString$annotations(Job r0) {
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        if (DebugProbesImpl$Installations$kotlinx$VolatileWrapper.access$getInstallations$FU$p().get(installations$kotlinx$VolatileWrapper) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private DebugProbesImpl() {
    }

    public static final /* synthetic */ ConcurrentWeakMap access$getCallerInfoCache$p() {
        return callerInfoCache;
    }

    public static final /* synthetic */ boolean access$isFinished(DebugProbesImpl r0, CoroutineOwner r1) {
        return r0.isFinished(r1);
    }

    public static final /* synthetic */ void access$probeCoroutineCompleted(DebugProbesImpl r0, CoroutineOwner r1) {
        r0.probeCoroutineCompleted(r1);
    }

    static {
        DebugProbesImpl r0 = new DebugProbesImpl();
        INSTANCE = r0;
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        ignoreCoroutinesWithEmptyContext = true;
        dynamicAttach = r0.getDynamicAttach();
        callerInfoCache = new ConcurrentWeakMap(true);
        installations$kotlinx$VolatileWrapper = new DebugProbesImpl$Installations$kotlinx$VolatileWrapper(null);
        sequenceNumber$kotlinx$VolatileWrapper = new DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(null);
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean r1) {
        sanitizeStackTraces = r1;
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean r1) {
        enableCreationStackTraces = r1;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean r1) {
        ignoreCoroutinesWithEmptyContext = r1;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        DebugProbesImpl r1 = this;     // Catch: Throwable -> L4
        Object r2 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");     // Catch: Throwable -> L4
        Object r3 = Result.m803constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r2, 1));     // Catch: Throwable -> L4
    L7:
        if (Result.m809isFailureimpl(r3) == false) goto L10;
        r3 = null;
    L10:
        return (Function1) r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void install$kotlinx_coroutines_core() {
        if (DebugProbesImpl$Installations$kotlinx$VolatileWrapper.access$getInstallations$FU$p().incrementAndGet(installations$kotlinx$VolatileWrapper) <= 1) goto L5;
        return;
    L5:
        startWeakRefCleanerThread();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() == false) goto L8;
        return;
    L8:
        Function1<Boolean, Unit> r2 = dynamicAttach;
        if (r2 == null) goto L12;
        r2.invoke(true);
        return;
    }

    public final void uninstall$kotlinx_coroutines_core() {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L15;
        if (DebugProbesImpl$Installations$kotlinx$VolatileWrapper.access$getInstallations$FU$p().decrementAndGet(installations$kotlinx$VolatileWrapper) == 0) goto L7;
        return;
    L7:
        stopWeakRefCleanerThread();
        capturedCoroutinesMap.clear();
        callerInfoCache.clear();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() == false) goto L10;
        return;
    L10:
        Function1<Boolean, Unit> r2 = dynamicAttach;
        if (r2 == null) goto L16;
        r2.invoke(false);
        return;
    L16:
        return;
    L15:
        throw new IllegalStateException("Agent was not installed".toString());
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, null, "Coroutines Debugger Cleaner", 0, AnonymousClass1.INSTANCE, 21, null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread r1 = weakRefCleanerThread;
        if (r1 != null) goto L5;
        return;
    L5:
        weakRefCleanerThread = null;
        r1.interrupt();
        r1.join();
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job r5) {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L20;
        Set<CoroutineOwner<?>> r4 = getCapturedCoroutines();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Object r1 = r6.next();
        if (((CoroutineOwner) r1).delegate.getContext().get(Job.Key) == null) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        r2 = false;
        goto L11
    L13:
        ArrayList r3 = r0;
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator r8 = r3.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        CoroutineOwner r9 = (CoroutineOwner) r8.next();
        r7.put(JobKt.getJob(r9.delegate.getContext()), r9.info);
        goto L15
    L17:
        StringBuilder r10 = new StringBuilder();
        INSTANCE.build(r5, r7, r10, "");
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "StringBuilder().apply(builderAction).toString()");
        return r11;
    L20:
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void build(Job r7, Map<Job, DebugCoroutineInfoImpl> r8, StringBuilder r9, String r10) {
        DebugCoroutineInfoImpl r0 = r8.get(r7);
        if (r0 == null) goto L5;
        StackTraceElement r3 = (StackTraceElement) CollectionsKt.firstOrNull(r0.lastObservedStackTrace$kotlinx_coroutines_core());
        r9.append(r10 + getDebugString(r7) + ", continuation is " + r0.getState$kotlinx_coroutines_core() + " at line " + r3 + '\n');
        r10 = r10 + '\t';
    L8:
        Iterator<Job> r11 = r7.getChildren().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        build(r11.next(), r8, r9, r10);
        goto L10
    L12:
        return;
    L5:
        if ((r7 instanceof ScopeCoroutine) == true) goto L8;
        r9.append(r10 + getDebugString(r7) + '\n');
        r10 = r10 + '\t';
        goto L8
    }

    private final String getDebugString(Job r1) {
        if ((r1 instanceof JobSupport) == false) goto L6;
        return ((JobSupport) r1).toDebugString();
    L6:
        return r1.toString();
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(final Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> r2) {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L7;
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new AnonymousClass3(r2)));
    L7:
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        List<DebugCoroutineInfo> r0 = dumpCoroutinesInfo();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(r1);
        ArrayList r3 = new ArrayList(r1);
        ArrayList r4 = new ArrayList(r1);
        Iterator<DebugCoroutineInfo> r5 = r0.iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        DebugCoroutineInfo r6 = r5.next();
        CoroutineContext r7 = r6.getContext();
        CoroutineName r8 = (CoroutineName) r7.get(CoroutineName.Key);
        Long r9 = null;
        if (r8 == null) goto L10;
        String r10 = r8.getName();
        if (r10 == null) goto L10;
        String r11 = toStringRepr(r10);
    L11:
        CoroutineDispatcher r12 = (CoroutineDispatcher) r7.get(CoroutineDispatcher.Key);
        if (r12 == null) goto L14;
        String r13 = toStringRepr(r12);
    L15:
        StringBuilder r14 = new StringBuilder("\n                {\n                    \"name\": ").append(r11).append(",\n                    \"id\": ");
        CoroutineId r15 = (CoroutineId) r7.get(CoroutineId.Key);
        if (r15 == null) goto L18;
        r9 = Long.valueOf(r15.getId());
    L18:
        r4.add(StringsKt.trimIndent(r14.append(r9).append(",\n                    \"dispatcher\": ").append(r13).append(",\n                    \"sequenceNumber\": ").append(r6.getSequenceNumber()).append(",\n                    \"state\": \"").append(r6.getState()).append("\"\n                } \n                ").toString()));
        r3.add(r6.getLastObservedFrame());
        r2.add(r6.getLastObservedThread());
        goto L4
    L14:
        r13 = null;
    L10:
        r11 = null;
        goto L11
    L20:
        return new Object[]{"[" + CollectionsKt.joinToString$default(r4, null, null, null, 0, null, null, 63, null) + DefaultContactListAdapter.SNIPPET_END_MATCH, r2.toArray(new Thread[0]), r3.toArray(new CoroutineStackFrame[0]), r0.toArray(new DebugCoroutineInfo[0])};
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo r11) {
        List<StackTraceElement> r12 = enhanceStackTraceWithThreadDump(r11, r11.lastObservedStackTrace());
        ArrayList r0 = new ArrayList();
        Iterator<StackTraceElement> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        StackTraceElement r1 = r13.next();
        StringBuilder r2 = new StringBuilder("\n                {\n                    \"declaringClass\": \"").append(r1.getClassName()).append("\",\n                    \"methodName\": \"").append(r1.getMethodName()).append("\",\n                    \"fileName\": ");
        String r3 = r1.getFileName();
        if (r3 == null) goto L8;
        String r4 = toStringRepr(r3);
    L9:
        r0.add(StringsKt.trimIndent(r2.append(r4).append(",\n                    \"lineNumber\": ").append(r1.getLineNumber()).append("\n                }\n                ").toString()));
        goto L4
    L8:
        r4 = null;
        goto L9
    L11:
        return "[" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null) + DefaultContactListAdapter.SNIPPET_END_MATCH;
    }

    private final String toStringRepr(Object r1) {
        return DebugProbesImplKt.access$repr(r1.toString());
    }

    public final void dumpCoroutines(PrintStream r1) {
        monitor-enter(r1);
        INSTANCE.dumpCoroutinesSynchronized(r1);     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(r1);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final boolean isFinished(CoroutineOwner<?> r3) {
        CoroutineContext r2 = r3.info.getContext();
        if (r2 == null) goto L12;
        Job r4 = (Job) r2.get(Job.Key);
        if (r4 == null) goto L12;
        if (r4.isCompleted() == true) goto L10;
        return false;
    L10:
        capturedCoroutinesMap.remove(r3);
        return true;
    L12:
        return false;
    }

    private final void dumpCoroutinesSynchronized(PrintStream r9) {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L18;
        r9.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));
        Iterator r8 = SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(getCapturedCoroutines()), AnonymousClass2.INSTANCE), new DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1()).iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        CoroutineOwner r0 = (CoroutineOwner) r8.next();
        DebugCoroutineInfoImpl r1 = r0.info;
        List<StackTraceElement> r2 = r1.lastObservedStackTrace$kotlinx_coroutines_core();
        DebugProbesImpl r3 = INSTANCE;
        List<StackTraceElement> r4 = r3.enhanceStackTraceWithThreadDumpImpl(r1.getState$kotlinx_coroutines_core(), r1.lastObservedThread, r2);
        if (Intrinsics.areEqual(r1.getState$kotlinx_coroutines_core(), DebugCoroutineInfoImplKt.RUNNING) == false) goto L11;
        if (r4 != r2) goto L11;
        String r5 = r1.getState$kotlinx_coroutines_core() + " (Last suspension stacktrace, not an actual stacktrace)";
    L12:
        r9.print("\n\nCoroutine " + r0.delegate + ", state: " + r5);
        if (r2.isEmpty() == true) goto L14;
        r3.printStackTrace(r9, r4);
        goto L6
    L14:
        r9.print("\n\tat " + ARTIFICIAL_FRAME);
        r3.printStackTrace(r9, r1.getCreationStackTrace());
    L11:
        r5 = r1.getState$kotlinx_coroutines_core();
        goto L12
    L16:
        return;
    L18:
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void printStackTrace(PrintStream r3, List<StackTraceElement> r4) {
        Iterator<T> r2 = r4.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.print("\n\tat " + ((StackTraceElement) r2.next()));
        goto L4
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo r2, List<StackTraceElement> r3) {
        return enhanceStackTraceWithThreadDumpImpl(r2.getState(), r2.getLastObservedThread(), r3);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String r8, Thread r9, List<StackTraceElement> r10) {
        if (Intrinsics.areEqual(r8, DebugCoroutineInfoImplKt.RUNNING) == false) goto L42;
        if (r9 == null) goto L42;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        DebugProbesImpl r12 = this;     // Catch: Throwable -> L8
        Object r13 = Result.m803constructorimpl(r9.getStackTrace());     // Catch: Throwable -> L8
    L11:
        if (Result.m809isFailureimpl(r13) == false) goto L13;
        r13 = null;
    L13:
        StackTraceElement[] r14 = (StackTraceElement[]) r13;
        if (r14 != null) goto L16;
        return r10;
    L16:
        int r15 = r14.length;
        int r0 = 0;
        int r1 = 0;
    L18:
        if (r1 >= r15) goto L30;
        StackTraceElement r4 = r14[r1];
        if (Intrinsics.areEqual(r4.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") == true) goto L22;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == true) goto L31;
        r1 = r1 + 1;
    L31:
        Pair<Integer, Integer> r7 = findContinuationStartIndex(r1, r14, r10);
        int r16 = r7.component1().intValue();
        int r17 = r7.component2().intValue();
        if (r16 != (-1)) goto L34;
        return r10;
    L34:
        ArrayList r6 = new ArrayList((((r10.size() + r1) - r16) - 1) - r17);
        int r2 = r1 - r17;
    L35:
        if (r0 >= r2) goto L37;
        r6.add(r14[r0]);
        r0 = r0 + 1;
        goto L35
    L37:
        int r18 = r16 + 1;
        int r19 = r10.size();
    L38:
        if (r18 >= r19) goto L41;
        r6.add(r10.get(r18));
        r18 = r18 + 1;
        goto L38
    L41:
        return r6;
    L22:
        if (Intrinsics.areEqual(r4.getMethodName(), "resumeWith") == false) goto L26;
        if (Intrinsics.areEqual(r4.getFileName(), "ContinuationImpl.kt") == false) goto L26;
        r5 = true;
        goto L27
    L30:
        r1 = -1;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r13 = Result.m803constructorimpl(ResultKt.createFailure(th));
    L42:
        return r10;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int r5, StackTraceElement[] r6, List<StackTraceElement> r7) {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L11;
        int r2 = INSTANCE.findIndexOfFrame((r5 - 1) - r0, r6, r7);
        if (r2 != (-1)) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r0));
    L11:
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int r5, StackTraceElement[] r6, List<StackTraceElement> r7) {
        StackTraceElement r4 = (StackTraceElement) ArraysKt.getOrNull(r6, r5);
        if (r4 != null) goto L5;
        return -1;
    L5:
        Iterator<StackTraceElement> r8 = r7.iterator();
        int r0 = 0;
    L7:
        if (r8.hasNext() == false) goto L22;
        StackTraceElement r1 = r8.next();
        if (Intrinsics.areEqual(r1.getFileName(), r4.getFileName()) == true) goto L11;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L19;
        r0 = r0 + 1;
        goto L7
    L19:
        return r0;
    L11:
        if (Intrinsics.areEqual(r1.getClassName(), r4.getClassName()) == false) goto L15;
        if (Intrinsics.areEqual(r1.getMethodName(), r4.getMethodName()) == false) goto L15;
        r2 = true;
        goto L16
    L22:
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> r2) {
        updateState(r2, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> r2) {
        updateState(r2, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> r3, String r4) {
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L6;
        return;
    L6:
        if (ignoreCoroutinesWithEmptyContext == false) goto L11;
        if (r3.getContext() != EmptyCoroutineContext.INSTANCE) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r4, DebugCoroutineInfoImplKt.RUNNING) == true) goto L13;
        CoroutineOwner<?> r0 = owner(r3);
        if (r0 != null) goto L23;
        return;
    L23:
        updateState(r0, r3, r4);
        return;
    L13:
        if ((r3 instanceof CoroutineStackFrame) == false) goto L15;
        CoroutineStackFrame r5 = (CoroutineStackFrame) r3;
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        updateRunningState(r5, r4);
        return;
    L15:
        r5 = null;
        goto L16
    }

    private final void updateRunningState(CoroutineStackFrame r5, String r6) {
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L5;
        return;
    L5:
        ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> r0 = callerInfoCache;
        DebugCoroutineInfoImpl r1 = r0.remove(r5);
        if (r1 == null) goto L8;
        boolean r2 = false;
    L20:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
        r1.updateState$kotlinx_coroutines_core(r6, (Continuation) r5, r2);
        CoroutineStackFrame r4 = realCaller(r5);
        if (r4 != null) goto L23;
        return;
    L23:
        r0.put(r4, r1);
        return;
    L8:
        CoroutineOwner<?> r3 = owner(r5);
        if (r3 == null) goto L25;
        r1 = r3.info;
        if (r1 == null) goto L26;
        CoroutineStackFrame r7 = r1.getLastObservedFrame$kotlinx_coroutines_core();
        if (r7 == null) goto L16;
        CoroutineStackFrame r8 = realCaller(r7);
    L17:
        if (r8 == null) goto L19;
        r0.remove(r8);
    L19:
        r2 = true;
        goto L20
    L16:
        r8 = null;
        goto L17
    L26:
        return;
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame r1) {
    L2:
        r1 = r1.getCallerFrame();
        if (r1 == null) goto L4;
        if (r1.getStackTraceElement() == null) goto L2;
        return r1;
    L4:
        return null;
    }

    private final void updateState(CoroutineOwner<?> r1, Continuation<?> r2, String r3) {
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L5;
        return;
    L5:
        r1.info.updateState$kotlinx_coroutines_core(r3, r2, true);
    }

    private final CoroutineOwner<?> owner(Continuation<?> r3) {
        if ((r3 instanceof CoroutineStackFrame) == false) goto L5;
        CoroutineStackFrame r4 = (CoroutineStackFrame) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return owner(r4);
    L5:
        r4 = null;
        goto L6
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame r1) {
    L3:
        if ((r1 instanceof CoroutineOwner) == true) goto L13;
        r1 = r1.getCallerFrame();
        if (r1 != null) goto L3;
        return null;
    L13:
        return (CoroutineOwner) r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> r3) {
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L6;
        return r3;
    L6:
        if (ignoreCoroutinesWithEmptyContext == false) goto L11;
        if (r3.getContext() != EmptyCoroutineContext.INSTANCE) goto L11;
        return r3;
    L11:
        if (owner(r3) == null) goto L14;
        return r3;
    L14:
        if (enableCreationStackTraces == false) goto L16;
        StackTraceFrame r0 = toStackTraceFrame(sanitizeStackTrace(new Exception()));
    L18:
        return createOwner(r3, r0);
    L16:
        r0 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Continuation<T> createOwner(Continuation<? super T> r5, StackTraceFrame r6) {
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L5;
        return r5;
    L5:
        CoroutineOwner<?> r7 = new CoroutineOwner(r5, new DebugCoroutineInfoImpl(r5.getContext(), r6, DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.access$getSequenceNumber$FU$p().incrementAndGet(sequenceNumber$kotlinx$VolatileWrapper)));
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> r8 = capturedCoroutinesMap;
        r8.put(r7, true);
        if (isInstalled$kotlinx_coroutines_debug() == true) goto L9;
        r8.clear();
    L9:
        return r7;
    }

    private final void probeCoroutineCompleted(CoroutineOwner<?> r2) {
        capturedCoroutinesMap.remove(r2);
        CoroutineStackFrame r3 = r2.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (r3 == null) goto L9;
        CoroutineStackFrame r1 = realCaller(r3);
        if (r1 == null) goto L10;
        callerInfoCache.remove(r1);
        return;
    L10:
        return;
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T r9) {
        StackTraceElement[] r10 = r9.getStackTrace();
        int r0 = r10.length;
        int r2 = -1;
        int r1 = r10.length - 1;
        if (r1 < 0) goto L10;
    L4:
        int r3 = r1 - 1;
        if (Intrinsics.areEqual(r10[r1].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt") == true) goto L6;
        if (r3 < 0) goto L10;
        r1 = r3;
        goto L4
    L6:
        r2 = r1;
    L10:
        int r4 = r2 + 1;
        if (sanitizeStackTraces == true) goto L17;
        int r5 = r0 - r4;
        ArrayList r8 = new ArrayList(r5);
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L16;
        r8.add(r10[r6 + r4]);
        r6 = r6 + 1;
        goto L13
    L16:
        return r8;
    L17:
        ArrayList r7 = new ArrayList((r0 - r4) + 1);
    L18:
        if (r4 >= r0) goto L37;
        if (isInternalMethod(r10[r4]) == true) goto L21;
        r7.add(r10[r4]);
        r4 = r4 + 1;
        goto L18
    L21:
        ArrayList r11 = r7;
        r11.add(r10[r4]);
        int r12 = r4 + 1;
    L22:
        if (r12 >= r0) goto L26;
        if (isInternalMethod(r10[r12]) == false) goto L26;
        r12 = r12 + 1;
    L26:
        int r13 = r12 - 1;
        int r14 = r13;
    L27:
        if (r14 <= r4) goto L31;
        if (r10[r14].getFileName() != null) goto L31;
        r14 = r14 - 1;
    L31:
        if (r14 <= r4) goto L34;
        if (r14 >= r13) goto L34;
        r11.add(r10[r14]);
    L34:
        r11.add(r10[r13]);
        r4 = r12;
        goto L18
    L37:
        return r7;
    }

    private final boolean isInternalMethod(StackTraceElement r4) {
        return StringsKt.startsWith$default(r4.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L7;
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));
    L7:
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug() == false) goto L7;
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));
    L7:
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> r3) {
        StackTraceFrame r0 = null;
        if (r3.isEmpty() == true) goto L9;
        ListIterator<StackTraceElement> r2 = r3.listIterator(r3.size());
    L6:
        if (r2.hasPrevious() == false) goto L9;
        StackTraceFrame r1 = r0;
        r0 = new StackTraceFrame(r1, r2.previous());
    L9:
        return new StackTraceFrame(r0, ARTIFICIAL_FRAME);
    }
}

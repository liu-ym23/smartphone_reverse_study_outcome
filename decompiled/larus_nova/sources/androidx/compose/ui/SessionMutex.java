package androidx.compose.ui;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B1\b\u0002\u0012&\u0010\u0003\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ]\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u001121\u0010\u0013\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R0\u0010\u0003\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0088\u0001\u0003\u0092\u0001\"\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0005`\u0006¨\u0006#"}, d2 = {"Landroidx/compose/ui/SessionMutex;", ExifInterface.GPS_DIRECTION_TRUE, "", "currentSessionHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "constructor-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "()Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "currentSession", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "withSessionCancellingPrevious", "R", "sessionInitializer", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "Lkotlin/coroutines/Continuation;", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "Session", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SessionMutex<T> {
    private final AtomicReference<Session<T>> currentSessionHolder;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/SessionMutex$Session;", ExifInterface.GPS_DIRECTION_TRUE, "", "job", "Lkotlinx/coroutines/Job;", "value", "<init>", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Session<T> {

        /* JADX INFO: renamed from: job, reason: collision with root package name */
        private final Job f15172job;
        private final T value;

        public final Job getJob() {
            return this.f15172job;
        }

        public final T getValue() {
            return this.value;
        }

        public Session(Job r100, T r101) {
            this.f15172job = r100;
            this.value = r101;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SessionMutex m4318boximpl(AtomicReference r100) {
        return new SessionMutex(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static <T> AtomicReference<Session<T>> m4320constructorimpl(AtomicReference<Session<T>> r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4321equalsimpl(AtomicReference<Session<T>> r100, Object r101) {
        if ((r101 instanceof SessionMutex) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((SessionMutex) r101).m4327unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4322equalsimpl0(AtomicReference<Session<T>> r100, AtomicReference<Session<T>> r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4324hashCodeimpl(AtomicReference<Session<T>> r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4325toStringimpl(AtomicReference<Session<T>> r100) {
        return "SessionMutex(currentSessionHolder=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4321equalsimpl(this.currentSessionHolder, r100);
    }

    public int hashCode() {
        return m4324hashCodeimpl(this.currentSessionHolder);
    }

    public String toString() {
        return m4325toStringimpl(this.currentSessionHolder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ AtomicReference m4327unboximpl() {
        return this.currentSessionHolder;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> AtomicReference<Session<T>> m4319constructorimpl() {
        return m4320constructorimpl(new AtomicReference(null));
    }

    private /* synthetic */ SessionMutex(AtomicReference r100) {
        this.currentSessionHolder = r100;
    }

    /* JADX INFO: renamed from: getCurrentSession-impl, reason: not valid java name */
    public static final T m4323getCurrentSessionimpl(AtomicReference<Session<T>> r100) {
        Session<T> r101 = r100.get();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    /* JADX INFO: renamed from: withSessionCancellingPrevious-impl, reason: not valid java name */
    public static final <R> Object m4326withSessionCancellingPreviousimpl(AtomicReference<Session<T>> r100, Function1<? super CoroutineScope, ? extends T> r101, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r102, Continuation<? super R> r103) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(r101, r100, r102, null), r103);
    }
}

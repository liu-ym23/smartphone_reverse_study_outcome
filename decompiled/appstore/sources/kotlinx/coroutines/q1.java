package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.selects.SelectClause0;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 extends kotlin.coroutines.a implements Job {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q1 f21661b = null;

    static {
        f21661b = new q1();
    }

    public q1() {
        super(Job.Key);
    }

    @Override // kotlinx.coroutines.Job
    public ChildHandle attachChild(ChildJob r10) {
        return r1.f21672a;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException r10) {
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Sequence getChildren() {
        return SequencesKt__SequencesKt.e();
    }

    @Override // kotlinx.coroutines.Job
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(Function1 r10) {
        return r1.f21672a;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public Object join(Continuation r10) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job r10) {
        return Job.a.h(this, r10);
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable r10) {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(boolean r10, boolean r11, Function1 r12) {
        return r1.f21672a;
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        Job.a.a(this);
    }
}

package android.view.compose;

import C7.r;
import S7.a;
import S7.k;
import android.view.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0001\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/activity/compose/ReportDrawnComposition;", "Lkotlin/Function0;", "LC7/r;", "Landroidx/activity/FullyDrawnReporter;", "fullyDrawnReporter", "", "predicate", AppAgent.CONSTRUCT, "(Landroidx/activity/FullyDrawnReporter;LS7/a;)V", "observeReporter", "(LS7/a;)V", "invoke", "()V", "removeReporter", "Landroidx/activity/FullyDrawnReporter;", "LS7/a;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "Lkotlin/Function1;", "checkReporter", "LS7/k;", "activity-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ReportDrawnComposition implements a {
    private final k checkReporter;
    private final FullyDrawnReporter fullyDrawnReporter;
    private final a predicate;
    private final SnapshotStateObserver snapshotStateObserver;

    public ReportDrawnComposition(FullyDrawnReporter fullyDrawnReporter, a aVar) {
        this.fullyDrawnReporter = fullyDrawnReporter;
        this.predicate = aVar;
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new f(0));
        snapshotStateObserver.start();
        this.snapshotStateObserver = snapshotStateObserver;
        this.checkReporter = new ReportDrawnComposition$checkReporter$1(this);
        fullyDrawnReporter.addOnReportDrawnListener(this);
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return;
        }
        fullyDrawnReporter.addReporter();
        observeReporter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeReporter(final a predicate) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        this.snapshotStateObserver.observeReads(predicate, this.checkReporter, new a() { // from class: androidx.activity.compose.g
            @Override // S7.a
            public final Object invoke() {
                return ReportDrawnComposition.observeReporter$lambda$2(ref$BooleanRef, predicate);
            }
        });
        if (ref$BooleanRef.f4916a) {
            removeReporter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r observeReporter$lambda$2(Ref$BooleanRef ref$BooleanRef, a aVar) {
        ref$BooleanRef.f4916a = ((Boolean) aVar.invoke()).booleanValue();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r snapshotStateObserver$lambda$0(a aVar) {
        aVar.invoke();
        return r.f317a;
    }

    @Override // S7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m6invoke();
        return r.f317a;
    }

    public final void removeReporter() {
        this.snapshotStateObserver.clear(this.predicate);
        if (!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.removeReporter();
        }
        m6invoke();
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public void m6invoke() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }
}

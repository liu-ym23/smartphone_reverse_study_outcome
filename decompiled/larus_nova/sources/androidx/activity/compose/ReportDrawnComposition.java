package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/activity/compose/ReportDrawnComposition;", "Lkotlin/Function0;", "", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "predicate", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function0;)V", "checkReporter", "Lkotlin/Function1;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", AbsMethodDelegate.TAG_INVOKE, "observeReporter", "removeReporter", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ReportDrawnComposition implements Function0<Unit> {
    private final Function1<Function0<Boolean>, Unit> checkReporter;
    private final FullyDrawnReporter fullyDrawnReporter;
    private final Function0<Boolean> predicate;
    private final SnapshotStateObserver snapshotStateObserver;

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }

    public final void removeReporter() {
        this.snapshotStateObserver.clear(this.predicate);
        if (this.fullyDrawnReporter.isFullyDrawnReported() == true) goto L5;
        this.fullyDrawnReporter.removeReporter();
    L5:
        invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    private final void observeReporter(final Function0<Boolean> r100) {
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        this.snapshotStateObserver.observeReads(r100, this.checkReporter, new AnonymousClass1(r101, r100));
        if (r101.element == false) goto L6;
        removeReporter();
        return;
    }

    public ReportDrawnComposition(FullyDrawnReporter r100, Function0<Boolean> r101) {
        this.fullyDrawnReporter = r100;
        this.predicate = r101;
        SnapshotStateObserver r102 = new SnapshotStateObserver(ReportDrawnComposition$snapshotStateObserver$1.INSTANCE);
        r102.start();
        this.snapshotStateObserver = r102;
        this.checkReporter = new ReportDrawnComposition$checkReporter$1(this);
        r100.addOnReportDrawnListener(this);
        if (r100.isFullyDrawnReported() == true) goto L6;
        r100.addReporter();
        observeReporter(r101);
        return;
    }

    public static final /* synthetic */ void access$observeReporter(ReportDrawnComposition r100, Function0 r101) {
        r100.observeReporter(r101);
    }
}

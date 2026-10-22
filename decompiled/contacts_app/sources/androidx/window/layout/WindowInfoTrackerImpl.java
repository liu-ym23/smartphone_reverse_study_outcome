package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.bytedance.apm.alog.AlogMonitor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/WindowBackend;", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = null;
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl$Companion;", "", "()V", "BUFFER_CAPACITY", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", "listener", "$this$flow", "listener"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ WindowInfoTrackerImpl this$0;

        public static /* synthetic */ void $r8$lambda$LgDWJbk4b494d79uZZm3iJ0WM6A(Channel r0, WindowLayoutInfo r1) {
            m99invokeSuspend$lambda0(r0, r1);
        }

        AnonymousClass1(WindowInfoTrackerImpl r1, Activity r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$activity = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$activity, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super WindowLayoutInfo> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super WindowLayoutInfo> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            ChannelIterator r2 = (ChannelIterator) this.L$2;
            Consumer<WindowLayoutInfo> r4 = (Consumer) this.L$1;
            FlowCollector r5 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L27
        L8:
            FlowCollector r11 = r5;
        L16:
            this.L$0 = r11;     // Catch: Throwable -> L27
            this.L$1 = r4;     // Catch: Throwable -> L27
            this.L$2 = r2;     // Catch: Throwable -> L27
            this.label = 1;     // Catch: Throwable -> L27
            Object r6 = r2.hasNext(this);     // Catch: Throwable -> L27
            if (r6 != r0) goto L19;
            return r0;
        L19:
            r5 = r11;
            r10 = r6;
        L21:
            if (((Boolean) r10).booleanValue() == false) goto L25;
            this.L$0 = r5;     // Catch: Throwable -> L27
            this.L$1 = r4;     // Catch: Throwable -> L27
            this.L$2 = r2;     // Catch: Throwable -> L27
            this.label = 2;     // Catch: Throwable -> L27
            if (r5.emit((WindowLayoutInfo) r2.next(), this) != r0) goto L8;
            return r0;
        L25:
            WindowInfoTrackerImpl.access$getWindowBackend$p(this.this$0).unregisterLayoutChangeCallback(r4);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = (ChannelIterator) this.L$2;
            r4 = (Consumer) this.L$1;
            r5 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L27
            goto L21
        L14:
            ResultKt.throwOnFailure(r10);
            r11 = (FlowCollector) this.L$0;
            final Channel r3 = ChannelKt.Channel$default(10, BufferOverflow.DROP_OLDEST, null, 4, null);
            r4 = new WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0(r3);
            WindowInfoTrackerImpl.access$getWindowBackend$p(this.this$0).registerLayoutChangeCallback(this.$activity, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), r4);
            r2 = r3.iterator();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            WindowInfoTrackerImpl.access$getWindowBackend$p(this.this$0).unregisterLayoutChangeCallback(r4);
            throw th;
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        private static final void m99invokeSuspend$lambda0(Channel r1, WindowLayoutInfo r2) {
            Intrinsics.checkNotNullExpressionValue(r2, AlogMonitor.ALOG_RESULT_INFO);
            r1.mo2321trySendJP2dKIU(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator r2, WindowBackend r3) {
        Intrinsics.checkNotNullParameter(r2, "windowMetricsCalculator");
        Intrinsics.checkNotNullParameter(r3, "windowBackend");
        this.windowMetricsCalculator = r2;
        this.windowBackend = r3;
    }

    public static final /* synthetic */ WindowBackend access$getWindowBackend$p(WindowInfoTrackerImpl r0) {
        return r0.windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow<WindowLayoutInfo> windowLayoutInfo(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        return FlowKt.flow(new AnonymousClass1(this, r3, null));
    }
}

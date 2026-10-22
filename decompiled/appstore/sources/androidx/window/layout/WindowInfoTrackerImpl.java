package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5291c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowMetricsCalculator f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowBackend f5293b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/i;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", "listener", "$this$flow", "listener"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super i>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ WindowInfoTrackerImpl this$0;

        public AnonymousClass1(WindowInfoTrackerImpl r10, Activity r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$activity = r11;
            super(2, r12);
        }

        public static /* synthetic */ void a(Channel r10, i r11) {
            m4invokeSuspend$lambda0(r10, r11);
        }

        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        private static final void m4invokeSuspend$lambda0(Channel r10, i r11) {
            q.f(r11, ServerElements.INFO);
            r10.mo53trySendJP2dKIU(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$activity, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(FlowCollector<? super i> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0090 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L16;
            if (r12 == 1) goto L13;
            if (r12 != 2) goto L12;
            ChannelIterator r13 = (ChannelIterator) this.L$2;
            Consumer<i> r14 = (Consumer) this.L$1;
            FlowCollector r15 = (FlowCollector) this.L$0;
            kotlin.c.b(r10);     // Catch: Throwable -> L9
        L8:
            FlowCollector r16 = r15;
        L18:
            this.L$0 = r16;     // Catch: Throwable -> L9
            this.L$1 = r14;     // Catch: Throwable -> L9
            this.L$2 = r13;     // Catch: Throwable -> L9
            this.label = 1;     // Catch: Throwable -> L9
            Object r17 = r13.hasNext(this);     // Catch: Throwable -> L9
            if (r17 != r11) goto L21;
            return r11;
        L21:
            r15 = r16;
            r10 = r17;
        L23:
            if (((Boolean) r10).booleanValue() == false) goto L27;
            i r18 = (i) r13.next();     // Catch: Throwable -> L9
            this.L$0 = r15;     // Catch: Throwable -> L9
            this.L$1 = r14;     // Catch: Throwable -> L9
            this.L$2 = r13;     // Catch: Throwable -> L9
            this.label = 2;     // Catch: Throwable -> L9
            if (r15.emit(r18, this) != r11) goto L8;
            return r11;
        L27:
            WindowInfoTrackerImpl.a(this.this$0).unregisterLayoutChangeCallback(r14);
            return Unit.f21064a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r13 = (ChannelIterator) this.L$2;
            r14 = (Consumer) this.L$1;
            r15 = (FlowCollector) this.L$0;
            kotlin.c.b(r10);     // Catch: Throwable -> L9
            goto L23
        L16:
            kotlin.c.b(r10);
            r16 = (FlowCollector) this.L$0;
            final Channel r19 = kotlinx.coroutines.channels.e.b(10, BufferOverflow.DROP_OLDEST, null, 4, null);
            r14 = new h(r19);
            WindowInfoTrackerImpl.a(this.this$0).registerLayoutChangeCallback(this.$activity, new androidx.profileinstaller.f(), r14);
            r13 = r19.iterator();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            WindowInfoTrackerImpl.a(this.this$0).unregisterLayoutChangeCallback(r14);
            throw th;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull FlowCollector<? super i> r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f5291c = new a(null);
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator r10, WindowBackend r11) {
        q.g(r10, "windowMetricsCalculator");
        q.g(r11, "windowBackend");
        this.f5292a = r10;
        this.f5293b = r11;
    }

    public static final /* synthetic */ WindowBackend a(WindowInfoTrackerImpl r10) {
        return r10.f5293b;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow windowLayoutInfo(Activity r10) {
        q.g(r10, "activity");
        return kotlinx.coroutines.flow.c.A(new AnonymousClass1(this, r10, null));
    }
}

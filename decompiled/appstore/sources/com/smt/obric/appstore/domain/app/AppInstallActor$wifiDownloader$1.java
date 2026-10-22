package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.smt.obric.appstore.ktx.ConnectivityManagerNetworkMonitorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlinx/coroutines/CompletableDeferred;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$wifiDownloader$1", f = "AppInstallActor.kt", i = {1}, l = {483, 484}, m = "invokeSuspend", n = {"req"}, s = {"L$1"})
public final class AppInstallActor$wifiDownloader$1 extends SuspendLambda implements Function2<ActorScope<CompletableDeferred<Boolean>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.AppInstallActor$wifiDownloader$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$wifiDownloader$1$1", f = "AppInstallActor.kt", i = {}, l = {468}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<CompletableDeferred<Boolean>> $triggerWiFiDownload;
        int label;
        final /* synthetic */ AppInstallActor this$0;

        /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.AppInstallActor$wifiDownloader$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$wifiDownloader$1$1$1", f = "AppInstallActor.kt", i = {}, l = {472, 474}, m = "invokeSuspend", n = {}, s = {})
        public static final class C02161 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ Channel<CompletableDeferred<Boolean>> $triggerWiFiDownload;
            int label;
            final /* synthetic */ AppInstallActor this$0;

            public C02161(AppInstallActor r10, Channel<CompletableDeferred<Boolean>> r11, Continuation<? super C02161> r12) {
                this.this$0 = r10;
                this.$triggerWiFiDownload = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new C02161(this.this$0, this.$triggerWiFiDownload, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(Boolean r10, Continuation<? super Unit> r11) {
                return invoke(r10.booleanValue(), r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L10;
                if (r12 == 1) goto L9;
                if (r12 != 2) goto L8;
                kotlin.c.b(r10);
            L20:
                return Unit.f21064a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                kotlin.c.b(r10);
            L14:
                if (ConnectivityManagerNetworkMonitorKt.f(AppInstallActor.l(this.this$0)) == false) goto L18;
                Channel<CompletableDeferred<Boolean>> r13 = this.$triggerWiFiDownload;
                this.label = 2;
                if (r13.send(null, this) != r11) goto L20;
                return r11;
            L18:
                com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][wifiDownloader] wifiDownloader wifi disconnected");
                goto L20
            L10:
                kotlin.c.b(r10);
                this.label = 1;
                if (DelayKt.b(AnimationConstants.DURATION_2000L, this) != r11) goto L14;
                return r11;
            }

            @Nullable
            public final Object invoke(boolean r10, @Nullable Continuation<? super Unit> r11) {
                return ((C02161) create(Boolean.valueOf(r10), r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass1(AppInstallActor r10, Channel<CompletableDeferred<Boolean>> r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$triggerWiFiDownload = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$triggerWiFiDownload, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            Flow r13 = ConnectivityManagerNetworkMonitorKt.e(AppInstallActor.l(this.this$0));
            C02161 r14 = new C02161(this.this$0, this.$triggerWiFiDownload, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.h(r13, r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppInstallActor$wifiDownloader$1(AppInstallActor r10, Continuation<? super AppInstallActor$wifiDownloader$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$wifiDownloader$1 r12 = new AppInstallActor$wifiDownloader$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ActorScope<CompletableDeferred<Boolean>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0074 -> B:20:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        CompletableDeferred r13 = (CompletableDeferred) this.L$1;
        ChannelIterator r14 = (ChannelIterator) this.L$0;
        kotlin.c.b(r12);
    L20:
        boolean r15 = ((Boolean) r12).booleanValue();
        if (r13 == null) goto L23;
        tf.a.a(r13.complete(tf.a.a(r15)));
    L23:
        ChannelIterator r16 = r14;
    L11:
        this.L$0 = r16;
        this.L$1 = null;
        this.label = 1;
        Object r17 = r16.hasNext(this);
        if (r17 != r10) goto L14;
        return r10;
    L14:
        r14 = r16;
        r12 = r17;
    L16:
        if (((Boolean) r12).booleanValue() == false) goto L25;
        r13 = (CompletableDeferred) r14.next();
        AppInstallActor r18 = this.this$0;
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 2;
        r12 = AppInstallActor.G(r18, this);
        if (r12 != r10) goto L20;
        return r10;
    L25:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ChannelIterator r19 = (ChannelIterator) this.L$0;
        kotlin.c.b(r12);
        r14 = r19;
        goto L16
    L10:
        kotlin.c.b(r12);
        ActorScope r20 = (ActorScope) this.L$0;
        Channel r110 = r20.getChannel();
        kotlinx.coroutines.h.d(r20, null, null, new AnonymousClass1(this.this$0, r110, null), 3, null);
        r16 = r110.iterator();
        goto L11
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ActorScope<CompletableDeferred<Boolean>> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$wifiDownloader$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

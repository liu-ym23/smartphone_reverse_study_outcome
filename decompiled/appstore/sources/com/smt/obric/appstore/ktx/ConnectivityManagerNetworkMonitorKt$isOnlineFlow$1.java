package com.smt.obric.appstore.ktx;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.bytedanceos.common.toolbox.j;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.ktx.ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1", f = "ConnectivityManagerNetworkMonitor.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConnectivityManager $connectivityManager;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f18146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f18147b;

        public a(ProducerScope r10) {
            this.f18147b = r10;
            this.f18146a = new LinkedHashSet();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            q.g(r10, "network");
            this.f18146a.add(r10);
            this.f18147b.getChannel().mo53trySendJP2dKIU(Boolean.TRUE);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            q.g(r10, "network");
            this.f18146a.remove(r10);
            this.f18147b.getChannel().mo53trySendJP2dKIU(Boolean.valueOf(!this.f18146a.isEmpty()));
        }
    }

    public ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1(ConnectivityManager r10, Continuation<? super ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1> r11) {
        this.$connectivityManager = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1 r12 = new ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1(this.$connectivityManager, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Boolean> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L21:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        final ProducerScope r13 = (ProducerScope) this.L$0;
        final a r14 = new a(r13);
        NetworkRequest r15 = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager r16 = this.$connectivityManager;
        Result.a r17 = Result.Companion;     // Catch: Throwable -> L11
        r16.registerNetworkCallback(r15, r14);     // Catch: Throwable -> L11
        Object r18 = Result.m35constructorimpl(tf.a.a(true));     // Catch: Throwable -> L11
    L13:
        Throwable r19 = Result.m38exceptionOrNullimpl(r18);
        if (r19 == null) goto L17;
        j.j("[ConnectivityManagerNetworkMonitor] register online network callback failed, err=", r19);
        r13.getChannel().mo53trySendJP2dKIU(tf.a.a(false));
        r18 = tf.a.a(false);
    L17:
        final boolean r20 = ((Boolean) r18).booleanValue();
        r13.getChannel().mo53trySendJP2dKIU(tf.a.a(ConnectivityManagerNetworkMonitorKt.d(this.$connectivityManager)));
        final ConnectivityManager r21 = this.$connectivityManager;
        Function0<Unit> r22 = new AnonymousClass1(r20, r13, r21, r14);
        this.label = 1;
        if (ProduceKt.a(r13, r22, this) != r11) goto L21;
        return r11;
    L11:
        th = move-exception;
        Result.a r23 = Result.Companion;
        r18 = Result.m35constructorimpl(c.a(th));
        goto L13
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Boolean> r10, @Nullable Continuation<? super Unit> r11) {
        return ((ConnectivityManagerNetworkMonitorKt$isOnlineFlow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

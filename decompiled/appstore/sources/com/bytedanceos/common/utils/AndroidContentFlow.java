package com.bytedanceos.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidContentFlow implements ValueFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f10137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2 f10138c;

    /* JADX INFO: renamed from: com.bytedanceos.common.utils.AndroidContentFlow$values$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.common.utils.AndroidContentFlow$values$1", f = "ValueFlow.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidContentFlow this$0;

        /* JADX INFO: renamed from: com.bytedanceos.common.utils.AndroidContentFlow$values$1$a */
        public static final class a extends ContentObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SendChannel f10139a;

            public a(SendChannel r10) {
                this.f10139a = r10;
                super(null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean r10) {
                this.f10139a.mo53trySendJP2dKIU(Unit.f21064a);
            }
        }

        public AnonymousClass1(AndroidContentFlow r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<Object> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r12) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            kotlin.c.b(r12);
        L20:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r12);
            final ProducerScope r13 = (ProducerScope) this.L$0;
            final ContentResolver r14 = AndroidContentFlow.a(this.this$0).getContentResolver();
            SendChannel r15 = kotlinx.coroutines.channels.b.b(r13, null, -1, null, null, new AndroidContentFlow$values$1$sequential$1(r13, this.this$0, null), 13, null);
            final a r16 = new a(r15);
            AndroidContentFlow r17 = this.this$0;
            Result.a r18 = Result.Companion;     // Catch: Throwable -> L11
            r14.registerContentObserver(AndroidContentFlow.c(r17), false, r16);     // Catch: Throwable -> L11
            Object r19 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L11
        L13:
            Throwable r20 = Result.m38exceptionOrNullimpl(r19);
            if (r20 == null) goto L16;
            com.bytedanceos.common.toolbox.j.p("SimpleSettingsFlow registerContentObserver failed: " + r20);
        L16:
            r15.mo53trySendJP2dKIU(Unit.f21064a);
            Function0<Unit> r21 = new AnonymousClass3(r13, r14, r16);
            this.label = 1;
            if (ProduceKt.a(r13, r21, this) != r10) goto L20;
            return r10;
        L11:
            th = move-exception;
            Result.a r22 = Result.Companion;
            r19 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L13
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AndroidContentFlow(Context r10, Uri r11, Function2 r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "uri");
        kotlin.jvm.internal.q.g(r12, "getValue");
        this.f10136a = r10;
        this.f10137b = r11;
        this.f10138c = r12;
    }

    public static final /* synthetic */ Context a(AndroidContentFlow r10) {
        return r10.f10136a;
    }

    public static final /* synthetic */ Function2 b(AndroidContentFlow r10) {
        return r10.f10138c;
    }

    public static final /* synthetic */ Uri c(AndroidContentFlow r10) {
        return r10.f10137b;
    }

    @Override // com.bytedanceos.common.utils.ValueFlow
    public Flow values() {
        return kotlinx.coroutines.flow.c.n(kotlinx.coroutines.flow.c.k(kotlinx.coroutines.flow.c.e(new AnonymousClass1(this, null))));
    }
}

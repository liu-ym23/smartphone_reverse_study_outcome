package com.bytedanceos.appstore.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.s;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.ConfirmDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1", f = "MainActivity.kt", i = {0}, l = {99}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class MainActivity$maybeShowAutoUpdatePrompt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1$2", f = "MainActivity.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConfirmDialog $dialog;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX INFO: renamed from: com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedanceos.appstore.ui.MainActivity$maybeShowAutoUpdatePrompt$1$2$1", f = "MainActivity.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ConfirmDialog $dialog;
            final /* synthetic */ Job $job;
            int label;
            final /* synthetic */ MainActivity this$0;

            public AnonymousClass1(ConfirmDialog r10, MainActivity r11, Job r12, Continuation<? super AnonymousClass1> r13) {
                this.$dialog = r10;
                this.this$0 = r11;
                this.$job = r12;
                super(2, r13);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new AnonymousClass1(this.$dialog, this.this$0, this.$job, r11);
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
                c.b(r10);
            L11:
                j.n("auto_update_prompt show dialog");
                this.$dialog.show(this.this$0.getFragmentManager(), "switch_update_apps");
                Job r13 = this.$job;
                if (r13 == null) goto L15;
                Job.a.b(r13, null, 1, null);
            L15:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                c.b(r10);
                this.label = 1;
                if (DelayKt.b(1000, this) != r11) goto L11;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass2(MainActivity r10, ConfirmDialog r11, Continuation<? super AnonymousClass2> r12) {
            this.this$0 = r10;
            this.$dialog = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.this$0, this.$dialog, r11);
            r12.L$0 = r10;
            return r12;
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
            c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.b(r10);
            Job r13 = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
            Lifecycle r14 = this.this$0.getLifecycle();
            q.f(r14, "<get-lifecycle>(...)");
            Lifecycle.State r15 = Lifecycle.State.RESUMED;
            AnonymousClass1 r16 = new AnonymousClass1(this.$dialog, this.this$0, r13, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(r14, r15, r16, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public MainActivity$maybeShowAutoUpdatePrompt$1(Context r10, MainActivity r11, Continuation<? super MainActivity$maybeShowAutoUpdatePrompt$1> r12) {
        this.$context = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public static /* synthetic */ void a(MainActivity r10, Context r11, int r12, int r13, boolean r14, Bundle r15) {
        invokeSuspend$lambda$0(r10, r11, r12, r13, r14, r15);
    }

    private static final void invokeSuspend$lambda$0(MainActivity r10, Context r11, int r12, int r13, boolean r14, Bundle r15) {
        if (r14 == false) goto L5;
        h.d(s.a(r10), l0.b(), null, new MainActivity$maybeShowAutoUpdatePrompt$1$1$1(r11, null), 2, null);
    L5:
        if (r13 != (-2)) goto L7;
        j.n("auto_update_prompt click negative, do not prompt today = " + r14);
        return;
    L7:
        if (r13 != (-1)) goto L13;
        com.bytedanceos.common.toolbox.s.r(BaseApplication.c(), true);
        j.n("auto_update_prompt click positive");
        return;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        MainActivity$maybeShowAutoUpdatePrompt$1 r12 = new MainActivity$maybeShowAutoUpdatePrompt$1(this.$context, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        c.b(r11);
        CoroutineScope r14 = r13;
    L12:
        boolean r15 = ((Boolean) r11).booleanValue();
        j.o("auto_update_prompt shouldShow = " + r15);
        if (r15 == false) goto L15;
        ConfirmDialog r16 = ConfirmDialog.newInstance(16, true, null);
        final MainActivity r17 = this.this$0;
        final Context r18 = this.$context;
        r16.setOnClickListener(new a(r17, r18));
        h.d(r14, null, null, new AnonymousClass2(this.this$0, r16, null), 3, null);
        return Unit.f21064a;
    L15:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r11);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r20 = l0.b();
        MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1 r21 = new MainActivity$maybeShowAutoUpdatePrompt$1$shouldShow$1(this.$context, null);
        this.L$0 = r19;
        this.label = 1;
        Object r22 = h.g(r20, r21, this);
        if (r22 != r10) goto L11;
        return r10;
    L11:
        r14 = r19;
        r11 = r22;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((MainActivity$maybeShowAutoUpdatePrompt$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

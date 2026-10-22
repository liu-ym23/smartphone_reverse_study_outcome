package com.obric.appstore.buss.myapp.update;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.obric.appstore.R;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateFragment$bindUpdateAllBtn$1", f = "UpdateFragment.kt", i = {}, l = {315}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateFragment$bindUpdateAllBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Button $updateAllBtn;
    int label;
    final /* synthetic */ UpdateFragment this$0;

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$bindUpdateAllBtn$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateFragment$bindUpdateAllBtn$1$1", f = "UpdateFragment.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Button $updateAllBtn;
        int label;
        final /* synthetic */ UpdateFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$bindUpdateAllBtn$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01691 implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Button f10753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UpdateFragment f10754b;

            public C01691(Button r10, UpdateFragment r11) {
                this.f10753a = r10;
                this.f10754b = r11;
            }

            public static /* synthetic */ void a(Integer r10, UpdateFragment r11, View r12) {
                c(r10, r11, r12);
            }

            public static final void c(Integer r10, UpdateFragment r11, View r12) {
                q.g(r11, "this$0");
                if (r10 != null) goto L6;
            L8:
                UpdateFragment.h0(r11);
                com.obric.appstore.util.m.a("appstore_btn_click", UpdateFragment$bindUpdateAllBtn$1$1$1$1$2.INSTANCE);
                return;
            L6:
                if (r10.intValue() != 2) goto L8;
                UpdateFragment.g0(r11);
                com.obric.appstore.util.m.a("appstore_btn_click", UpdateFragment$bindUpdateAllBtn$1$1$1$1$1.INSTANCE);
            }

            public final Object b(final Integer r10, Continuation r11) {
                Button r12 = this.f10753a;
                int r13 = 0;
                if (r10 == null) goto L5;
                boolean r14 = true;
            L6:
                if (r14 == true) goto L9;
                r13 = 8;
            L9:
                r12.setVisibility(r13);
                Button r15 = this.f10753a;
                if (r10 != null) goto L13;
            L15:
                String r16 = this.f10754b.getString(R.string.update_all);
            L16:
                r15.setText(r16);
                Button r17 = this.f10753a;
                final UpdateFragment r18 = this.f10754b;
                r17.setOnClickListener(new i(r10, r18));
                return Unit.f21064a;
            L13:
                if (r10.intValue() != 2) goto L15;
                r16 = this.f10754b.getString(R.string.pause_all);
                goto L16
            L5:
                r14 = false;
                goto L6
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return b((Integer) r10, r11);
            }
        }

        public AnonymousClass1(UpdateFragment r10, Button r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$updateAllBtn = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$updateAllBtn, r11);
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
            if (r12 != 1) goto L6;
            kotlin.c.b(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            StateFlow r13 = UpdateFragment.f0(this.this$0).x();
            C01691 r14 = new C01691(this.$updateAllBtn, this.this$0);
            this.label = 1;
            if (r13.collect(r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public UpdateFragment$bindUpdateAllBtn$1(UpdateFragment r10, Button r11, Continuation<? super UpdateFragment$bindUpdateAllBtn$1> r12) {
        this.this$0 = r10;
        this.$updateAllBtn = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UpdateFragment$bindUpdateAllBtn$1(this.this$0, this.$updateAllBtn, r11);
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
        LifecycleOwner r13 = this.this$0.getViewLifecycleOwner();
        q.f(r13, "getViewLifecycleOwner(...)");
        Lifecycle.State r14 = Lifecycle.State.RESUMED;
        AnonymousClass1 r15 = new AnonymousClass1(this.this$0, this.$updateAllBtn, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r13, r14, r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UpdateFragment$bindUpdateAllBtn$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

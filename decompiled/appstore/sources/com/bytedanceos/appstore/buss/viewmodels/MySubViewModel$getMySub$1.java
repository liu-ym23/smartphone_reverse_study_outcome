package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.AppSubWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.MySubViewModel$getMySub$1", f = "MySubViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class MySubViewModel$getMySub$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MySubViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.MySubViewModel$getMySub$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.MySubViewModel$getMySub$1$1", f = "MySubViewModel.kt", i = {0, 0, 1}, l = {40, 50}, m = "invokeSuspend", n = {"subUn", ServerElements.LIST, ServerElements.LIST}, s = {"L$0", "L$1", "L$0"})
    @SourceDebugExtension({"SMAP\nMySubViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MySubViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/MySubViewModel$getMySub$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1855#2:82\n1855#2,2:83\n1856#2:85\n*S KotlinDebug\n*F\n+ 1 MySubViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/MySubViewModel$getMySub$1$1\n*L\n54#1:82\n61#1:83,2\n54#1:85\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r13) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            ArrayList r12 = (ArrayList) this.L$0;
            kotlin.c.b(r13);
        L34:
            h r14 = (h) r13;
            if ((r14 instanceof h.c) == false) goto L56;
            List r15 = (List) ((h.c) r14).a();
            if (r15 == null) goto L61;
            Iterator r16 = r15.iterator();
        L40:
            if (r16.hasNext() == false) goto L61;
            AppSubWrap r17 = (AppSubWrap) r16.next();
            String r18 = r17.getName();
            List<AppSubEntity> r19 = r17.getApps();
            if (r19 == null) goto L40;
            if (r19.isEmpty() == true) goto L40;
            if (r18 != null) goto L48;
        L51:
            Iterator<T> r20 = r19.iterator();
        L53:
            if (r20.hasNext() == false) goto L40;
            AppSubEntity r21 = (AppSubEntity) r20.next();
            r21.setBanner(r21.getLogo());
            r12.add(r21);
            goto L53
        L48:
            if (r18.length() == 0) goto L51;
            r12.add(r18);
        L61:
            return new h.c(new HttpResultHead(0, null, null), r12, "请求成功");
        L56:
            if ((r14 instanceof h.a) == true) goto L58;
            q.b(r14, h.b.f8818a);
            goto L61
        L58:
            return new h.a(((h.a) r14).c(), 0, null, 6, null);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ArrayList r22 = (ArrayList) this.L$1;
            Deferred r23 = (Deferred) this.L$0;
            kotlin.c.b(r13);
        L14:
            h r110 = (h) r13;
            if ((r110 instanceof h.c) == false) goto L26;
            h.c r111 = (h.c) r110;
            HttpResultHead r24 = r111.b();
            AppsWrap r25 = (AppsWrap) r111.a();
            if (r25 == null) goto L19;
            List r26 = r25.getApps();
        L20:
            new h.c(r24, r26, r111.c());
            AppsWrap r112 = (AppsWrap) r111.a();
            if (r112 == null) goto L30;
            List r113 = r112.getApps();
            if (r113 == null) goto L30;
            tf.a.a(r22.addAll(r113));
        L30:
            this.L$0 = r22;
            this.L$1 = null;
            this.label = 2;
            r13 = r23.await(this);
            if (r13 != r10) goto L33;
            return r10;
        L33:
            r12 = r22;
            goto L34
        L19:
            r26 = null;
            goto L20
        L26:
            if ((r110 instanceof h.a) == true) goto L28;
            q.b(r110, h.b.f8818a);
            goto L30
        L28:
            return new h.a(((h.a) r110).c(), 0, null, 6, null);
        L10:
            kotlin.c.b(r13);
            CoroutineScope r114 = (CoroutineScope) this.L$0;
            Deferred r27 = kotlinx.coroutines.h.b(r114, null, null, new MySubViewModel$getMySub$1$1$sub$1(null), 3, null);
            Deferred r115 = kotlinx.coroutines.h.b(r114, null, null, new MySubViewModel$getMySub$1$1$subUn$1(null), 3, null);
            ArrayList r28 = new ArrayList();
            this.L$0 = r115;
            this.L$1 = r28;
            this.label = 1;
            Object r29 = r27.await(this);
            if (r29 != r10) goto L13;
            return r10;
        L13:
            r23 = r115;
            r13 = r29;
            r22 = r28;
            goto L14
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public MySubViewModel$getMySub$1(MySubViewModel r10, Continuation<? super MySubViewModel$getMySub$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new MySubViewModel$getMySub$1(this.this$0, r11);
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
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r10);
    L12:
        r13.p(r10);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        this.this$0.g().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.g();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(null);
        this.L$0 = r14;
        this.label = 1;
        Object r17 = kotlinx.coroutines.h.g(r15, r16, this);
        if (r17 != r11) goto L11;
        return r11;
    L11:
        r10 = r17;
        r13 = r14;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((MySubViewModel$getMySub$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

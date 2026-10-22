package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.e;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Date;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel$getWishAppList$1", f = "AppWishViewModel.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class AppWishViewModel$getWishAppList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AppWishViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel$getWishAppList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h$c;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h$c;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel$getWishAppList$1$1", f = "AppWishViewModel.kt", i = {0, 0, 1}, l = {80, 101}, m = "invokeSuspend", n = {"recommendAppLiveWrap", ServerElements.LIST, ServerElements.LIST}, s = {"L$0", "L$1", "L$0"})
    @SourceDebugExtension({"SMAP\nAppWishViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWishViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppWishViewModel$getWishAppList$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n1855#2,2:161\n1855#2,2:163\n*S KotlinDebug\n*F\n+ 1 AppWishViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppWishViewModel$getWishAppList$1$1\n*L\n85#1:161,2\n104#1:163,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h.c>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AppWishViewModel this$0;

        public AnonymousClass1(AppWishViewModel r10, Continuation<? super AnonymousClass1> r11) {
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
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h.c> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r14) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            ArrayList r12 = (ArrayList) this.L$0;
            kotlin.c.b(r14);
        L42:
            h r15 = (h) r14;
            if ((r15 instanceof h.c) == false) goto L55;
            List r16 = (List) ((h.c) r15).a();
            if (r16 == null) goto L50;
            Iterator r13 = r16.iterator();
        L48:
            if (r13.hasNext() == false) goto L50;
            com.bytedanceos.common.utils.h.i(((AppEntityWrap) r13.next()).getApps());
        L50:
            if (r12 == null) goto L53;
            if (r16 == null) goto L53;
            r12.addAll(r16);
        L53:
            this.this$0.k().m(r16);
        L59:
            return new h.c(new HttpResultHead(0, null, null), r12, "请求成功");
        L55:
            if ((r15 instanceof h.a) == false) goto L57;
            h.a r17 = (h.a) r15;
            new h.a(r17.c(), r17.b(), null, 4, null);
            goto L59
        L57:
            q.b(r15, h.b.f8818a);
            goto L59
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ArrayList r18 = (ArrayList) this.L$1;
            Deferred r19 = (Deferred) this.L$0;
            kotlin.c.b(r14);
        L14:
            h r110 = (h) r14;
            if ((r110 instanceof h.c) == false) goto L35;
            AppsWrap r111 = (AppsWrap) ((h.c) r110).a();
            if (r111 == null) goto L19;
            List r112 = r111.getApps();
        L20:
            AppWishViewModel.g(this.this$0).clear();
            if (r112 != null) goto L23;
        L30:
            this.this$0.h().m(r112);
            if (r18 == null) goto L38;
            if (r112 == null) goto L38;
            r18.addAll(r112);
        L38:
            this.L$0 = r18;
            this.L$1 = null;
            this.label = 2;
            r14 = r19.await(this);
            if (r14 != r10) goto L41;
            return r10;
        L41:
            r12 = r18;
            goto L42
        L23:
            if (r112.isEmpty() == true) goto L30;
            AppWishViewModel r20 = this.this$0;
            Iterator r21 = r112.iterator();
        L27:
            if (r21.hasNext() == false) goto L29;
            String r22 = ((CommonAppEntity) r21.next()).getPkg();
            q.f(r22, "getPkg(...)");
            AppWishViewModel.g(r20).add(new AppCollectEntity(r22, "1", e.f8837a.a(new Date(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss")));
            goto L27
        L29:
            AppWishViewModel.f(this.this$0).m(AppWishViewModel.g(this.this$0));
            goto L30
        L19:
            r112 = null;
            goto L20
        L35:
            if ((r110 instanceof h.a) == false) goto L37;
            h.a r113 = (h.a) r110;
            new h.a(r113.c(), r113.b(), null, 4, null);
            goto L38
        L37:
            q.b(r110, h.b.f8818a);
            goto L38
        L10:
            kotlin.c.b(r14);
            CoroutineScope r114 = (CoroutineScope) this.L$0;
            Deferred r23 = kotlinx.coroutines.h.b(r114, null, null, new AppWishViewModel$getWishAppList$1$1$wishAppLiveWrap$1(null), 3, null);
            Deferred r115 = kotlinx.coroutines.h.b(r114, null, null, new AppWishViewModel$getWishAppList$1$1$recommendAppLiveWrap$1(null), 3, null);
            ArrayList r24 = new ArrayList();
            this.L$0 = r115;
            this.L$1 = r24;
            this.label = 1;
            Object r25 = r23.await(this);
            if (r25 != r10) goto L13;
            return r10;
        L13:
            r19 = r115;
            r14 = r25;
            r18 = r24;
            goto L14
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h.c> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppWishViewModel$getWishAppList$1(AppWishViewModel r10, Continuation<? super AppWishViewModel$getWishAppList$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppWishViewModel$getWishAppList$1(this.this$0, r11);
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
        this.this$0.m().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.m();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(this.this$0, null);
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
        return ((AppWishViewModel$getWishAppList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

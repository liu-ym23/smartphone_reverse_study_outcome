package com.bytedanceos.appstore.buss.viewmodels;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppWishRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$postWishApp$3", f = "AppDetailViewModel.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailViewModel$postWishApp$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommonAppEntity $entity;
    Object L$0;
    int label;
    final /* synthetic */ AppDetailViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$postWishApp$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/network/h$c;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$postWishApp$3$1", f = "AppDetailViewModel.kt", i = {0}, l = {190}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAppDetailViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$postWishApp$3$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1864#2,3:265\n*S KotlinDebug\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$postWishApp$3$1\n*L\n198#1:265,3\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        final /* synthetic */ CommonAppEntity $entity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AppDetailViewModel this$0;

        public AnonymousClass1(AppDetailViewModel r10, CommonAppEntity r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$entity = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$entity, r11);
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
        public final Object invokeSuspend(@NotNull Object r14) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            kotlin.c.b(r14);
        L11:
            h r15 = (h) r14;
            if ((r15 instanceof h.c) == false) goto L46;
            List r13 = (List) AppDetailViewModel.h(this.this$0).e();
            if (r13 == null) goto L16;
            List r16 = b0.z0(r13);
        L17:
            CommonAppEntity r17 = this.$entity;
            if (r17 == null) goto L43;
            AppDetailViewModel r18 = this.this$0;
            if (r16 == null) goto L43;
            AppInfoEntity r19 = (AppInfoEntity) r18.s().e();
            if (AppDetailViewModel.k(r18) == false) goto L37;
            Iterator r20 = r16.iterator();
            int r21 = 0;
        L25:
            if (r20.hasNext() == false) goto L36;
            Object r110 = r20.next();
            int r111 = r21 + 1;
            if (r21 >= 0) goto L30;
            t.q();
        L30:
            if (q.b(((CommonAppEntity) r110).getPkg(), r17.getPkg()) == true) goto L31;
            r21 = r111;
            goto L25
        L31:
            if (r19 == null) goto L34;
            r19.setIfcollect(0);
        L34:
            r16.remove(r21);
        L36:
            Bundle r22 = new Bundle();
            r22.putString("collect_button_status", "collect_button_status_add");
            f9.b.b("click_add_wishlist", r22);
        L42:
            r18.s().m(r19);
            AppDetailViewModel.h(r18).m(r16);
            goto L43
        L37:
            r16.add(0, r17);
            if (r19 == null) goto L41;
            r19.setIfcollect(1);
        L41:
            Bundle r23 = new Bundle();
            r23.putString("collect_button_status", "collect_button_status_remove");
            f9.b.b("click_add_wishlist", r23);
        L43:
            AppDetailViewModel r24 = this.this$0;
            AppDetailViewModel.m(r24, !AppDetailViewModel.k(r24));
            AppDetailViewModel.g(this.this$0).m(AppDetailViewModel.j(this.this$0));
            h.c r25 = (h.c) r15;
            Object r112 = new h.c(r25.b(), r15, r25.c());
        L51:
            return r112;
        L16:
            r16 = null;
            goto L17
        L46:
            if ((r15 instanceof h.a) == true) goto L56;
            r112 = h.b.f8818a;
            if (q.b(r15, r112) == true) goto L51;
            throw new NoWhenBranchMatchedException();
        L56:
            return r15;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r14);
            CoroutineScope r113 = (CoroutineScope) this.L$0;
            AppWishRepository r26 = AppWishRepository.f9016a;
            ArrayList r27 = AppDetailViewModel.j(this.this$0);
            this.L$0 = r113;
            this.label = 1;
            r14 = r26.h(r27, this);
            if (r14 != r10) goto L11;
            return r10;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppDetailViewModel$postWishApp$3(AppDetailViewModel r10, CommonAppEntity r11, Continuation<? super AppDetailViewModel$postWishApp$3> r12) {
        this.this$0 = r10;
        this.$entity = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppDetailViewModel$postWishApp$3(this.this$0, this.$entity, r11);
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
        MutableLiveData r14 = this.this$0.w();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(this.this$0, this.$entity, null);
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
        return ((AppDetailViewModel$postWishApp$3) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

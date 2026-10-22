package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppDetailGiftEntity;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.AppDetailGiftRepository;
import com.bytedanceos.appstore.buss.viewmodels.repository.MyGiftRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppGift$1", f = "AppDetailViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailViewModel$getAppGift$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appPackageName;
    final /* synthetic */ String $giftId;
    Object L$0;
    int label;
    final /* synthetic */ AppDetailViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppGift$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppGift$1$1", f = "AppDetailViewModel.kt", i = {0}, l = {136}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAppDetailViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$getAppGift$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1855#2,2:265\n*S KotlinDebug\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$getAppGift$1$1\n*L\n146#1:265,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        final /* synthetic */ String $appPackageName;
        final /* synthetic */ String $giftId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AppDetailViewModel this$0;

        public AnonymousClass1(String r10, String r11, AppDetailViewModel r12, Continuation<? super AnonymousClass1> r13) {
            this.$appPackageName = r10;
            this.$giftId = r11;
            this.this$0 = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$appPackageName, this.$giftId, this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
            return invoke2(r10, r11);
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [T, com.bytedanceos.appstore.buss.entity.AppDetailGiftEntity] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r13) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            kotlin.c.b(r13);
        L11:
            h r14 = (h) r13;
            if ((r14 instanceof h.c) == false) goto L30;
            Ref$ObjectRef r15 = new Ref$ObjectRef();
            h.c r16 = (h.c) r14;
            AppInfoEntity r17 = (AppInfoEntity) r16.a();
            if (r17 == null) goto L27;
            List<AppDetailGiftEntity> r18 = r17.getGifts();
            if (r18 == null) goto L27;
            AppDetailViewModel r19 = this.this$0;
            String r110 = this.$giftId;
            AppInfoEntity r20 = (AppInfoEntity) r19.s().e();
            if (r20 == null) goto L21;
            r20.setGifts(r18);
        L21:
            r19.s().m(r20);
            Iterator<T> r21 = r18.iterator();
        L23:
            if (r21.hasNext() == false) goto L27;
            ?? r22 = (AppDetailGiftEntity) r21.next();
            if (q.b(r110, r22.getId()) == false) goto L23;
            r15.element = r22;
            MyGiftRepository.f9032b.a().b(r22.convertGiftMyEntity(r17.getName(), r17.getPkg(), r17.getLogo(), r17.getDownload_url(), r17.getFilemd5(), r17.getFilesize(), r17.getVersion_code()));
        L27:
            Object r111 = new h.c(r16.b(), r15.element, r16.c());
        L35:
            return r111;
        L30:
            if ((r14 instanceof h.a) == true) goto L41;
            r111 = h.b.f8818a;
            if (q.b(r14, r111) == true) goto L35;
            throw new NoWhenBranchMatchedException();
        L41:
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r13);
            CoroutineScope r112 = (CoroutineScope) this.L$0;
            AppDetailGiftRepository r23 = AppDetailGiftRepository.f9008a;
            String r24 = this.$appPackageName;
            String r25 = this.$giftId;
            this.L$0 = r112;
            this.label = 1;
            r13 = r23.f(r24, r25, this);
            if (r13 != r10) goto L11;
            return r10;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppDetailViewModel$getAppGift$1(AppDetailViewModel r10, String r11, String r12, Continuation<? super AppDetailViewModel$getAppGift$1> r13) {
        this.this$0 = r10;
        this.$appPackageName = r11;
        this.$giftId = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppDetailViewModel$getAppGift$1(this.this$0, this.$appPackageName, this.$giftId, r11);
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
        MutableLiveData r14 = this.this$0.r();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(this.$appPackageName, this.$giftId, this.this$0, null);
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
        return ((AppDetailViewModel$getAppGift$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

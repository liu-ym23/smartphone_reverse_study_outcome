package com.bytedance.android.livesdk.livecommerce.userinfo.title.repository;

import bk2.c;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.ec.live.api.commerce.userinfo.b;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository.AbsRepository;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jf.e;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ECUserInfoRepository extends AbsRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ll2.a f152993a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1", f = "ECUserInfoRepository.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECUserInfoRepository this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1$a */
        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AnonymousClass1 f152994a;

            public a(AnonymousClass1 r100) {
                this.f152994a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                b r101 = (b) r100;
                this.f152994a.this$0.getClass();
                throw null;
            }
        }

        public AnonymousClass1(ECUserInfoRepository r100, Continuation r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            Disposable r103 = null;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            Observable r104 = (Observable) r100;
            if (r104 == null) goto L16;
            Disposable r105 = r104.subscribe(new a(this));
            if (r105 == null) goto L16;
            this.this$0.getClass();
            r103 = c.a(r105, null);
        L16:
            UtilityKotlinExtentionsKt.h(r103, AnonymousClass2.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ECUserInfoRepository r106 = this.this$0;
            r106.getClass();
            this.label = 1;
            r100 = AbsRepository.b(r106, null, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2", f = "ECUserInfoRepository.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECUserInfoRepository this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2$a */
        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AnonymousClass2 f152995a;

            public a(AnonymousClass2 r100) {
                this.f152995a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                this.f152995a.this$0.getClass();
                ((com.bytedance.android.ec.live.api.commerce.userinfo.a) r100).getClass();
                throw null;
            }
        }

        public AnonymousClass2(ECUserInfoRepository r100, Continuation r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            Disposable r103 = null;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            Function1<Observable<com.bytedance.android.ec.live.api.commerce.userinfo.a>, Unit> r104 = new AnonymousClass1(this);
            Lazy r105 = UtilityKotlinExtentionsKt.f153056a;
            Intrinsics.checkNotNullParameter(r104, "block");
            if (r100 == null) goto L14;
            r104.invoke(r100);
        L14:
            Observable r106 = (Observable) r100;
            if (r106 == null) goto L19;
            Disposable r107 = r106.subscribe(new a(this));
            if (r107 == null) goto L19;
            this.this$0.getClass();
            r103 = c.a(r107, null);
        L19:
            UtilityKotlinExtentionsKt.h(r103, AnonymousClass3.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ECUserInfoRepository r108 = this.this$0;
            r108.getClass();
            this.label = 1;
            r100 = AbsRepository.b(r108, null, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public ECUserInfoRepository() {
        throw null;
    }

    public final ll2.a c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "btmPageId");
        ll2.a r100 = this.f152993a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = true;
        int r102 = RoomContextController.f151593h;
        com.bytedance.android.ec.common.api.jump.model.a r103 = RoomContextController.a.b(null, null).l();
        UtilityKotlinExtentionsKt.h(r103, new ECUserInfoRepository$getUserInfoParams$result$1(r101));
        if (r103 != null) goto L8;
        r103 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
    L8:
        ll2.a r111 = (ll2.a) ((f) r103.buildParams(Reflection.getOrCreateKotlinClass(f.class), new f.a("c0.d0", r110, jf.b.m.f498861b, e.g.f498870b, null, null, null, 112))).buildParams(Reflection.getOrCreateKotlinClass(ll2.a.class), new ll2.a.C6707a(new ECUserInfoRepository$getUserInfoParams$result$2(this)));
        if (r101.element == false) goto L11;
        this.f152993a = r111;
    L11:
        return r111;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0072 -> B:24:0x0075). Please report as a decompilation issue!!! */
    public final Object d(Continuation<? super Boolean> r110) {
        if ((r110 instanceof ECUserInfoRepository$onLiveRoomParamsReady$1) == false) goto L7;
        ECUserInfoRepository$onLiveRoomParamsReady$1 r100 = (ECUserInfoRepository$onLiveRoomParamsReady$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        ECUserInfoRepository r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L32:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r106 = r100.I$0;
        ECUserInfoRepository r111 = (ECUserInfoRepository) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        int r107 = RoomContextController.f151593h;
        r111.getClass();
        RoomContextController r108 = RoomContextController.a.b(null, null);
        r106 = r106 + 1;
        dm.a.a("ECUserInfoRepository").i("onLiveRoomParamsReady while controller is fallback: " + r108.A().K + " retryCount " + r106);
    L18:
        if (r106 >= 5) goto L26;
        if (r108.A().K == false) goto L26;
        r100.L$0 = r111;
        r100.I$0 = r106;
        r100.label = 1;
        if (DelayKt.delay(((long) 100) + (((long) r106) * 100), r100) != r104) goto L24;
        return r104;
    L26:
        if (r108.A().K == false) goto L29;
        dm.a.a("ECUserInfoRepository").b("onLiveRoomParamsReady finally controller is fallback", null);
        return Boxing.boxBoolean(false);
    L29:
        r100.L$0 = null;
        r100.label = 2;
        r103 = r108.N(r100);
        if (r103 != r104) goto L32;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        int r109 = RoomContextController.f151593h;
        r108 = RoomContextController.a.b(null, null);
        r111 = r102;
        r106 = 0;
    L7:
        r102 = this;
        r100 = new ECUserInfoRepository$onLiveRoomParamsReady$1(r102, r110);
        goto L8
    }
}

package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppCollectEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppsWrap;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailWrap;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.e;
import com.bytedanceos.common.BaseApplication;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.m;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppDetail$1", f = "AppDetailViewModel.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailViewModel$getAppDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AppDetailViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppDetail$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppDetailWrap;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppDetailViewModel$getAppDetail$1$1", f = "AppDetailViewModel.kt", i = {0, 0, 1}, l = {93, 107}, m = "invokeSuspend", n = {"wishAppList", "wrap", "wrap"}, s = {"L$0", "L$1", "L$0"})
    @SourceDebugExtension({"SMAP\nAppDetailViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$getAppDetail$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1855#2,2:265\n*S KotlinDebug\n*F\n+ 1 AppDetailViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppDetailViewModel$getAppDetail$1$1\n*L\n110#1:265,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AppDetailViewModel this$0;

        public AnonymousClass1(AppDetailViewModel r10, Continuation<? super AnonymousClass1> r11) {
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
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
            return invoke2(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v4, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r17) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            Ref$ObjectRef r12 = (Ref$ObjectRef) this.L$0;
            kotlin.c.b(r17);
            Object r13 = r17;
        L48:
            h r14 = (h) r13;
            if ((r14 instanceof h.c) == false) goto L72;
            MutableLiveData r15 = AppDetailViewModel.h(this.this$0);
            h.c r16 = (h.c) r14;
            AppsWrap r18 = (AppsWrap) r16.a();
            if (r18 == null) goto L53;
            List r19 = r18.getApps();
        L54:
            r15.m(r19);
            AppsWrap r20 = (AppsWrap) r16.a();
            if (r20 == null) goto L70;
            List r21 = r20.getApps();
            if (r21 == null) goto L70;
            AppDetailViewModel r22 = this.this$0;
            Iterator r23 = r21.iterator();
        L60:
            if (r23.hasNext() == false) goto L70;
            CommonAppEntity r24 = (CommonAppEntity) r23.next();
            String r110 = r24.getPkg();
            q.f(r110, "getPkg(...)");
            AppCollectEntity r25 = new AppCollectEntity(r110, "1", e.f8837a.a(new Date(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss"));
            AppDetailViewModel.j(r22).add(r25);
            if (q.b(r24.getPkg(), AppDetailViewModel.f(r22)) == false) goto L60;
            AppDetailViewModel.l(r22, r25);
            TvAppDetailWrap r26 = (TvAppDetailWrap) r12.element;
            if (r26 == null) goto L66;
            AppInfoEntity r27 = r26.getAppInfoEntity();
        L67:
            if (r27 == null) goto L60;
            r27.setIfcollect(1);
            goto L60
        L66:
            r27 = null;
        L70:
            AppDetailViewModel.g(this.this$0).m(AppDetailViewModel.j(this.this$0));
            new h.c(r16.b(), AppDetailViewModel.j(this.this$0), r16.c());
        L76:
            return new h.c(new HttpResultHead(0, null, null), r12.element, "请求成功");
        L53:
            r19 = null;
            goto L54
        L72:
            if ((r14 instanceof h.a) == false) goto L74;
            new h.a(((h.a) r14).c(), 0, null, 6, null);
            goto L76
        L74:
            q.b(r14, h.b.f8818a);
            goto L76
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Ref$ObjectRef r28 = (Ref$ObjectRef) this.L$1;
            Deferred r29 = (Deferred) this.L$0;
            kotlin.c.b(r17);
            Object r30 = r17;
        L13:
            h r31 = (h) r30;
            if ((r31 instanceof h.c) == false) goto L40;
            h.c r32 = (h.c) r31;
            ?? r33 = r32.a();
            r28.element = r33;
            TvAppDetailWrap r34 = (TvAppDetailWrap) r33;
            if (r34 == null) goto L27;
            AppInfoEntity r35 = r34.getAppInfoEntity();
            if (r35 == null) goto L27;
            String r36 = r35.getScores();
            if (r36 == null) goto L27;
            Float r37 = m.f(r36);
            if (r37 == null) goto L27;
            float r38 = r37.floatValue();
            AppInfoEntity r111 = ((TvAppDetailWrap) r28.element).getAppInfoEntity();
            if (r111 == null) goto L27;
            r111.setResId(tf.a.c(com.bytedanceos.common.toolbox.e.c0(BaseApplication.c(), r38, true, "lkp_")));
        L27:
            MutableLiveData r39 = this.this$0.s();
            TvAppDetailWrap r112 = (TvAppDetailWrap) r28.element;
            if (r112 == null) goto L30;
            AppInfoEntity r113 = r112.getAppInfoEntity();
        L31:
            r39.m(r113);
            TvAppDetailWrap r40 = (TvAppDetailWrap) r28.element;
            if (r40 == null) goto L34;
            AppInfoEntity r41 = r40.getAppInfoEntity();
        L35:
            if (r41 == null) goto L38;
            r41.setIfcollect(0);
        L38:
            new h.c(r32.b(), r32.a(), r32.c());
        L44:
            this.L$0 = r28;
            this.L$1 = null;
            this.label = 2;
            r13 = r29.await(this);
            if (r13 != r10) goto L47;
            return r10;
        L47:
            r12 = r28;
            goto L48
        L34:
            r41 = null;
            goto L35
        L30:
            r113 = null;
            goto L31
        L40:
            if ((r31 instanceof h.a) == true) goto L42;
            q.b(r31, h.b.f8818a);
            goto L44
        L42:
            return new h.a(((h.a) r31).c(), 0, null, 6, null);
        L10:
            kotlin.c.b(r17);
            CoroutineScope r42 = (CoroutineScope) this.L$0;
            Deferred r114 = kotlinx.coroutines.h.b(r42, null, null, new AppDetailViewModel$getAppDetail$1$1$appDetailWrap$1(this.this$0, null), 3, null);
            r29 = kotlinx.coroutines.h.b(r42, null, null, new AppDetailViewModel$getAppDetail$1$1$wishAppList$1(null), 3, null);
            r28 = new Ref$ObjectRef();
            this.L$0 = r29;
            this.L$1 = r28;
            this.label = 1;
            r30 = r114.await(this);
            if (r30 != r10) goto L13;
            return r10;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public AppDetailViewModel$getAppDetail$1(AppDetailViewModel r10, Continuation<? super AppDetailViewModel$getAppDetail$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppDetailViewModel$getAppDetail$1(this.this$0, r11);
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
        this.this$0.p().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.p();
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
        return ((AppDetailViewModel$getAppDetail$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

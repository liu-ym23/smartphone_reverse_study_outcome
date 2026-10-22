package com.bytedanceos.appstore.buss.fragment;

import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailClassicsApps;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailRelationAppsEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.TvAppDetailWrap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.AppDetailFragment$subscribeUi$1$2$1", f = "AppDetailFragment.kt", i = {1}, l = {161, 162}, m = "invokeSuspend", n = {"relationList"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAppDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppDetailFragment$subscribeUi$1$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,636:1\n1#2:637\n*E\n"})
public final class AppDetailFragment$subscribeUi$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TvAppDetailWrap $data;
    Object L$0;
    int label;
    final /* synthetic */ AppDetailFragment this$0;

    public AppDetailFragment$subscribeUi$1$2$1(TvAppDetailWrap r10, AppDetailFragment r11, Continuation<? super AppDetailFragment$subscribeUi$1$2$1> r12) {
        this.$data = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppDetailFragment$subscribeUi$1$2$1(this.$data, this.this$0, r11);
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
        List r13 = null;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        List r14 = (List) this.L$0;
        kotlin.c.b(r10);
    L23:
        r13 = (List) r10;
        List r15 = r14;
    L24:
        ArrayList r16 = new ArrayList();
        if (r15 == null) goto L27;
        tf.a.a(r16.addAll(r15));
    L27:
        if (r13 == null) goto L29;
        tf.a.a(r16.addAll(r13));
    L29:
        PagerTypeAdapter r17 = AppDetailFragment.S(this.this$0);
        if (r17 == null) goto L33;
        r17.setList(r16);
    L33:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L15:
        r15 = (List) r10;
    L17:
        TvAppDetailClassicsApps r18 = this.$data.getClassicsApps();
        if (r18 == null) goto L24;
        this.L$0 = r15;
        this.label = 2;
        Object r19 = r18.getList(this);
        if (r19 != r11) goto L22;
        return r11;
    L22:
        r14 = r15;
        r10 = r19;
        goto L23
    L10:
        kotlin.c.b(r10);
        TvAppDetailRelationAppsEntity r20 = this.$data.getRelationApps();
        if (r20 == null) goto L16;
        this.label = 1;
        r10 = r20.getList(this);
        if (r10 != r11) goto L15;
        return r11;
    L16:
        r15 = null;
        goto L17
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppDetailFragment$subscribeUi$1$2$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

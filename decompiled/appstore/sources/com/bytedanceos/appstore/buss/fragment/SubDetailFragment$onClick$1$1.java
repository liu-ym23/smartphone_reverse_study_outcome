package com.bytedanceos.appstore.buss.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedanceos.appstore.buss.entity.netwrap.SubDetailWrap;
import com.bytedanceos.appstore.buss.viewmodels.repository.GameSubRepository;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.tracker.TrackerElement;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.SubDetailFragment$onClick$1$1", f = "SubDetailFragment.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSubDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SubDetailFragment$onClick$1$1\n+ 2 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,211:1\n50#2,9:212\n*S KotlinDebug\n*F\n+ 1 SubDetailFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SubDetailFragment$onClick$1$1\n*L\n168#1:212,9\n*E\n"})
public final class SubDetailFragment$onClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubDetailWrap $wrap;
    int label;
    final /* synthetic */ SubDetailFragment this$0;

    public SubDetailFragment$onClick$1$1(SubDetailWrap r10, SubDetailFragment r11, Continuation<? super SubDetailFragment$onClick$1$1> r12) {
        this.$wrap = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public static /* synthetic */ void a(SubDetailFragment r10, SubDetailWrap r11) {
        invokeSuspend$lambda$2$lambda$1(r10, r11);
    }

    private static final void invokeSuspend$lambda$2$lambda$1(SubDetailFragment r10, SubDetailWrap r11) {
        com.bytedanceos.appstore.buss.widget.dialog.v r12 = com.bytedanceos.appstore.buss.widget.dialog.v.f9279a;
        Context r13 = r10.getContext();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type android.app.Activity");
        r12.g((Activity) r13, r11.convertAppSubEntity());
        if (AccountDataCache.b().n() == false) goto L5;
        String r14 = "have_login";
    L6:
        Bundle r15 = new Bundle();
        r15.putString(TrackerElement.GAME_NAME, r11.getName());
        r15.putString("game_category", r11.getCategory());
        r15.putString("game_online_time", r11.getOnlineTime());
        r15.putString(NetKey.PAGE_SOURCE, "page_game_subscribe_detail");
        r15.putString("user_login_status", r14);
        f9.b.b("reserved_success", r15);
        return;
    L5:
        r14 = "not_login";
        goto L6
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SubDetailFragment$onClick$1$1(this.$wrap, this.this$0, r11);
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
    L11:
        com.bytedanceos.appstore.buss.network.h r13 = (com.bytedanceos.appstore.buss.network.h) r10;
        final SubDetailFragment r14 = this.this$0;
        final SubDetailWrap r15 = this.$wrap;
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.b) == true) goto L21;
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L18;
        Context r16 = r14.getContext();
        kotlin.jvm.internal.q.e(r16, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r16).runOnUiThread(new k1(r14, r15));
        goto L21
    L18:
        if ((r13 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L21;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r13).c());
    L21:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        GameSubRepository r17 = GameSubRepository.f9027a;
        String r18 = this.$wrap.getId();
        int r19 = this.$wrap.getStatus();
        this.label = 1;
        r10 = r17.f(r18, 1, r19, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SubDetailFragment$onClick$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

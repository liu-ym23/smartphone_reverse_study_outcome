package com.bytedanceos.appstore.buss.viewmodels.cache;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.utilities.s;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.cache.CacheMyAppsRepository$removeMyApps$1", f = "CacheMyAppsRepository.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class CacheMyAppsRepository$removeMyApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CommonAppEntity> $list;
    int label;
    final /* synthetic */ CacheMyAppsRepository this$0;

    public CacheMyAppsRepository$removeMyApps$1(List<CommonAppEntity> r10, CacheMyAppsRepository r11, Continuation<? super CacheMyAppsRepository$removeMyApps$1> r12) {
        this.$list = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new CacheMyAppsRepository$removeMyApps$1(this.$list, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L11:
        h r13 = (h) r10;
        BaseApplication r14 = BaseApplication.c();
        if ((r13 instanceof h.c) == false) goto L18;
        if (this.$list.size() != 1) goto L16;
        q.d(r14);
        String r15 = r14.getString(R.string.myapp_toast_history_delete, new Object[]{this.$list.get(0).getName()});
        q.f(r15, "getString(...)");
        s.b(r14, r15);
    L21:
        return Unit.f21064a;
    L16:
        q.d(r14);
        String r16 = r14.getResources().getQuantityString(R.plurals.delete_selected_record, this.$list.size(), new Object[]{tf.a.c(this.$list.size())});
        q.f(r16, "getQuantityString(...)");
        s.b(r14, r16);
        goto L21
    L18:
        if ((r13 instanceof h.a) == false) goto L21;
        q.d(r14);
        s.b(r14, ((h.a) r13).c());
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        CoroutineDispatcher r17 = l0.b();
        CacheMyAppsRepository$removeMyApps$1$removeNetSource$1 r18 = new CacheMyAppsRepository$removeMyApps$1$removeNetSource$1(this.$list, this.this$0, null);
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r17, r18, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((CacheMyAppsRepository$removeMyApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

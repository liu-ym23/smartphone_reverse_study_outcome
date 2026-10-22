package com.bytedanceos.appstore.buss.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.AppDetailFragment$onClick$3$1", f = "AppDetailFragment.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
public final class AppDetailFragment$onClick$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfoEntity $entity;
    int label;
    final /* synthetic */ AppDetailFragment this$0;

    public AppDetailFragment$onClick$3$1(AppDetailFragment r10, AppInfoEntity r11, Continuation<? super AppDetailFragment$onClick$3$1> r12) {
        this.this$0 = r10;
        this.$entity = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppDetailFragment$onClick$3$1(this.this$0, this.$entity, r11);
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
        byte[] r13 = com.bytedanceos.common.utils.f.b((Bitmap) r10, false);
        if (TextUtils.isEmpty(this.$entity.getShare_download_url()) == false) goto L14;
        com.bytedanceos.common.toolbox.e.o(AppDetailFragment.P(this.this$0), this.$entity.getName(), this.$entity.getDownload_url(), r13);
    L15:
        Bundle r14 = new Bundle();
        r14.putString("app_pkg", this.$entity.getPkg());
        f9.b.b("click_share", r14);
        return Unit.f21064a;
    L14:
        com.bytedanceos.common.toolbox.e.o(AppDetailFragment.P(this.this$0), this.$entity.getName(), this.$entity.getShare_download_url(), r13);
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ImageView r15 = AppDetailFragment.T(this.this$0).f25654e;
        kotlin.jvm.internal.q.f(r15, "ivLogo");
        String r16 = this.$entity.getLogo();
        this.label = 1;
        r10 = ImageUtilKt.c(r15, r16, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppDetailFragment$onClick$3$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

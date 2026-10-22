package com.obric.appstore.common.core.ui.view;

import android.graphics.drawable.Drawable;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.common.core.ui.view.ObricAppItemViewForSettings$loadAppIconAsync$1", f = "ObricAppItemViewForSettings.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAppItemViewForSettings$loadAppIconAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInfo $info;
    final /* synthetic */ String $packageName;
    int label;
    final /* synthetic */ ObricAppItemViewForSettings this$0;

    public ObricAppItemViewForSettings$loadAppIconAsync$1(ObricAppItemViewForSettings r10, AppInfo r11, String r12, Continuation<? super ObricAppItemViewForSettings$loadAppIconAsync$1> r13) {
        this.this$0 = r10;
        this.$info = r11;
        this.$packageName = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricAppItemViewForSettings$loadAppIconAsync$1(this.this$0, this.$info, this.$packageName, r11);
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
        Drawable r13 = (Drawable) r10;
        if (q.b(this.this$0.getAppInfo(), this.$info) == false) goto L14;
        if (r13 == null) goto L17;
        this.this$0.getVIcon().setImageDrawable(r13);
    L19:
        return Unit.f21064a;
    L17:
        ObricAppItemViewForSettings.g(this.this$0, this.$info);
        goto L19
    L14:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineDispatcher r14 = l0.b();
        ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1 r15 = new ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1(this.this$0, this.$packageName, null);
        this.label = 1;
        r10 = h.g(r14, r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ObricAppItemViewForSettings$loadAppIconAsync$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

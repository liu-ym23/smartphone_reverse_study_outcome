package com.obric.appstore.common.core.ui.view;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.common.core.ui.view.ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1", f = "ObricAppItemViewForSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nObricAppItemViewForSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAppItemViewForSettings.kt\ncom/obric/appstore/common/core/ui/view/ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1#2:192\n*E\n"})
public final class ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
    final /* synthetic */ String $packageName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricAppItemViewForSettings this$0;

    public ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1(ObricAppItemViewForSettings r10, String r11, Continuation<? super ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1> r12) {
        this.this$0 = r10;
        this.$packageName = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1 r12 = new ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1(this.this$0, this.$packageName, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Drawable> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L14;
        kotlin.c.b(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ObricAppItemViewForSettings r12 = this.this$0;
        String r13 = this.$packageName;
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L7
        Object r15 = Result.m35constructorimpl(r12.getContext().getPackageManager().getApplicationIcon(r13));     // Catch: Throwable -> L7
    L10:
        if (Result.m41isFailureimpl(r15) == false) goto L17;
        return null;
    L17:
        return r15;
    L7:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Drawable> r11) {
        return ((ObricAppItemViewForSettings$loadAppIconAsync$1$localIcon$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/smt/obric/appstore/domain/oapplet/OAppletInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.InstalledOApplets$refresh$result$1", f = "InstalledOApplet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InstalledOApplets$refresh$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends OAppletInfo>>>, Object> {
    int label;

    public InstalledOApplets$refresh$result$1(Continuation<? super InstalledOApplets$refresh$result$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new InstalledOApplets$refresh$result$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Result<? extends List<? extends OAppletInfo>>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L10;
        c.b(r10);
        OAppletUtil r11 = OAppletUtil.f18065a;
        Context r12 = InstalledOApplets.b();
        if (r12 != null) goto L8;
        q.y("context");
        r12 = null;
    L8:
        return Result.m34boximpl(r11.d(r12));
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Result<? extends List<OAppletInfo>>> r11) {
        return ((InstalledOApplets$refresh$result$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

package com.smt.obric.appstore.domain.sysapp.autoupdate;

import com.bytedanceos.common.toolbox.j;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistManager$init$1", f = "SysAppAutoUpdateWhitelistManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppAutoUpdateWhitelistManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a implements SettingsUpdateListener {
        public a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener
        public void onSettingsUpdate(String r10) {
            j.n("[SysAppAutoUpdateWhitelistManager] onSettingsUpdate");
            SysAppAutoUpdateWhitelistManager.b(SysAppAutoUpdateWhitelistManager.f18107a);
        }
    }

    public SysAppAutoUpdateWhitelistManager$init$1(Continuation<? super SysAppAutoUpdateWhitelistManager$init$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppAutoUpdateWhitelistManager$init$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L7;
        c.b(r10);
        MatrixSettingsManager.f11938g.a().g(new a());
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateWhitelistManager$init$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

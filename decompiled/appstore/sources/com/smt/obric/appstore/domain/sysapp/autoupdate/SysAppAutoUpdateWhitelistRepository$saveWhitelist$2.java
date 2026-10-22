package com.smt.obric.appstore.domain.sysapp.autoupdate;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistRepository$saveWhitelist$2", f = "SysAppAutoUpdateWhitelistRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSysAppAutoUpdateWhitelistRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SysAppAutoUpdateWhitelistRepository.kt\ncom/smt/obric/appstore/domain/sysapp/autoupdate/SysAppAutoUpdateWhitelistRepository$saveWhitelist$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,35:1\n43#2,8:36\n*S KotlinDebug\n*F\n+ 1 SysAppAutoUpdateWhitelistRepository.kt\ncom/smt/obric/appstore/domain/sysapp/autoupdate/SysAppAutoUpdateWhitelistRepository$saveWhitelist$2\n*L\n20#1:36,8\n*E\n"})
public final class SysAppAutoUpdateWhitelistRepository$saveWhitelist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $whitelist;
    int label;
    final /* synthetic */ SysAppAutoUpdateWhitelistRepository this$0;

    public SysAppAutoUpdateWhitelistRepository$saveWhitelist$2(SysAppAutoUpdateWhitelistRepository r10, Set<String> r11, Continuation<? super SysAppAutoUpdateWhitelistRepository$saveWhitelist$2> r12) {
        this.this$0 = r10;
        this.$whitelist = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppAutoUpdateWhitelistRepository$saveWhitelist$2(this.this$0, this.$whitelist, r11);
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
        SharedPreferences r11 = SysAppAutoUpdateWhitelistRepository.c(this.this$0);
        Set<String> r12 = this.$whitelist;
        SharedPreferences.Editor r13 = r11.edit();
        q.f(r13, "editor");
        r13.putStringSet("whitelist", r12);
        r13.commit();
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppAutoUpdateWhitelistRepository$saveWhitelist$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

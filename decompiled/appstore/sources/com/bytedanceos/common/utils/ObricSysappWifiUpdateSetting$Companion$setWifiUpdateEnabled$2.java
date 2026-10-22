package com.bytedanceos.common.utils;

import android.content.Context;
import android.provider.Settings;
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
@DebugMetadata(c = "com.bytedanceos.common.utils.ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2", f = "ObricSysappWifiUpdateSetting.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $enabled;
    int label;

    public ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2(Context r10, boolean r11, Continuation<? super ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2> r12) {
        this.$context = r10;
        this.$enabled = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2(this.$context, this.$enabled, r11);
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
        if (this.label != 0) goto L14;
        kotlin.c.b(r10);
    L9:
        th = move-exception;
        com.bytedanceos.common.toolbox.j.p("SysAppWifiUpdate setWifiUpdateEnabled failed: " + th);
    L12:
        return Unit.f21064a;
    L6:
        if (Settings.Global.putInt(this.$context.getContentResolver(), "obric_sysapp_wifi_update", this.$enabled ? 1 : 0) == true) goto L12;
        com.bytedanceos.common.toolbox.j.p("SysAppWifiUpdate setWifiUpdateEnabled failed: putInt returned false");     // Catch: Throwable -> L9
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ObricSysappWifiUpdateSetting$Companion$setWifiUpdateEnabled$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

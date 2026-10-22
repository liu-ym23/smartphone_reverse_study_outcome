package com.obric.appstore.sysapp.restore;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.utils.ObricSysappWifiUpdateSetting;
import com.obric.appstore.util.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.sysapp.restore.SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1", f = "SysAppSettingReporter.kt", i = {}, l = {11}, m = "invokeSuspend", n = {}, s = {})
public final class SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $this_reportSysappWifiUpdateSettingValue;
    int label;

    public SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1(FragmentActivity r10, Continuation<? super SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1> r11) {
        this.$this_reportSysappWifiUpdateSettingValue = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1(this.$this_reportSysappWifiUpdateSettingValue, r11);
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
        final boolean r13 = ((Boolean) r10).booleanValue();
        m.a("appstore_setting_value", new AnonymousClass1(r13));
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ObricSysappWifiUpdateSetting.Companion r14 = ObricSysappWifiUpdateSetting.f10176c;
        Context r15 = this.$this_reportSysappWifiUpdateSettingValue.getApplicationContext();
        q.f(r15, "getApplicationContext(...)");
        this.label = 1;
        r10 = r14.a(r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SysAppSettingReporterKt$reportSysappWifiUpdateSettingValue$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

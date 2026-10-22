package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.UninstallAppsFragment$downloadList$1", f = "UninstallAppsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUninstallAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$downloadList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,592:1\n1855#2,2:593\n*S KotlinDebug\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$downloadList$1\n*L\n417#1:593,2\n*E\n"})
final class UninstallAppsFragment$downloadList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAddWifi;
    final /* synthetic */ boolean $isDownloadAll;
    final /* synthetic */ boolean $isUseMobile;
    int label;
    final /* synthetic */ UninstallAppsFragment this$0;

    public UninstallAppsFragment$downloadList$1(UninstallAppsFragment r10, boolean r11, boolean r12, boolean r13, Continuation<? super UninstallAppsFragment$downloadList$1> r14) {
        this.this$0 = r10;
        this.$isDownloadAll = r11;
        this.$isAddWifi = r12;
        this.$isUseMobile = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UninstallAppsFragment$downloadList$1(this.this$0, this.$isDownloadAll, this.$isAddWifi, this.$isUseMobile, r11);
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
        if (this.label != 0) goto L31;
        kotlin.c.b(r10);
        UninstallAppsFragment.L(this.this$0).clear();
        ArrayList r11 = new ArrayList();
        CopyOnWriteArrayList r12 = UninstallAppsFragment.J(this.this$0);
        boolean r13 = this.$isDownloadAll;
        Iterator r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L13;
        CommonAppEntity r15 = (CommonAppEntity) r14.next();
        if (r13 == true) goto L11;
        if (r15.getCheckState() == false) goto L6;
    L11:
        r11.add(r15.convertAppInfo());
        goto L6
    L13:
        if (r11.isEmpty() == false) goto L16;
        com.bytedanceos.common.toolbox.j.n("execute all update, the applist is empty");
        return Unit.f21064a;
    L16:
        Bundle r16 = new Bundle();
        r16.putString("install_apps_count", String.valueOf(r11.size()));
        if (this.$isDownloadAll == false) goto L19;
        f9.b.b("click_serverapps_Install_all_confirm", r16);
    L21:
        if (com.bytedanceos.common.download.d.d(this.this$0.getActivity(), r11) == true) goto L25;
        return Unit.f21064a;
    L25:
        if (this.$isAddWifi == false) goto L27;
        com.bytedanceos.common.utils.j.e(r11, "UnInstallAppsFragment");
    L29:
        return Unit.f21064a;
    L27:
        com.bytedanceos.common.utils.j.f(r11, this.$isUseMobile, "UnInstallAppsFragment");
        goto L29
    L19:
        f9.b.b("serverapps_install_mass", r16);
        goto L21
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UninstallAppsFragment$downloadList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import java.util.ArrayList;
import java.util.Iterator;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.UninstallAppsFragment$deleteList$1", f = "UninstallAppsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUninstallAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$deleteList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,592:1\n1855#2,2:593\n*S KotlinDebug\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$deleteList$1\n*L\n449#1:593,2\n*E\n"})
final class UninstallAppsFragment$deleteList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UninstallAppsFragment this$0;

    public UninstallAppsFragment$deleteList$1(UninstallAppsFragment r10, Continuation<? super UninstallAppsFragment$deleteList$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UninstallAppsFragment$deleteList$1(this.this$0, r11);
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
        if (this.label != 0) goto L13;
        kotlin.c.b(r10);
        UninstallAppsFragment.L(this.this$0).clear();
        ArrayList r11 = new ArrayList();
        Iterator r12 = UninstallAppsFragment.J(this.this$0).iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        CommonAppEntity r13 = (CommonAppEntity) r12.next();
        if (r13.getCheckState() == false) goto L6;
        r11.add(r13);
        goto L6
    L10:
        Bundle r14 = new Bundle();
        r14.putString("uninstall_apps_count", String.valueOf(r11.size()));
        f9.b.b("serverapps_delete_mass", r14);
        UninstallAppsFragment.M(this.this$0).f(r11);
        UninstallAppsFragment.P(this.this$0, false);
        UninstallAppsFragment.N(this.this$0);
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UninstallAppsFragment$deleteList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

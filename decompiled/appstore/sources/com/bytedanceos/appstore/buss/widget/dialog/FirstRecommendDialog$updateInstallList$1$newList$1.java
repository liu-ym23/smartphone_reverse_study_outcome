package com.bytedanceos.appstore.buss.widget.dialog;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.FirstRecommendWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.widget.dialog.FirstRecommendDialog$updateInstallList$1$newList$1", f = "FirstRecommendDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFirstRecommendDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirstRecommendDialog.kt\ncom/bytedanceos/appstore/buss/widget/dialog/FirstRecommendDialog$updateInstallList$1$newList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,244:1\n1855#2:245\n1855#2,2:246\n1856#2:248\n*S KotlinDebug\n*F\n+ 1 FirstRecommendDialog.kt\ncom/bytedanceos/appstore/buss/widget/dialog/FirstRecommendDialog$updateInstallList$1$newList$1\n*L\n193#1:245\n194#1:246,2\n193#1:248\n*E\n"})
public final class FirstRecommendDialog$updateInstallList$1$newList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<CommonAppEntity>>, Object> {
    final /* synthetic */ List<FirstRecommendWrap> $list;
    int label;

    public FirstRecommendDialog$updateInstallList$1$newList$1(List<FirstRecommendWrap> r10, Continuation<? super FirstRecommendDialog$updateInstallList$1$newList$1> r11) {
        this.$list = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new FirstRecommendDialog$updateInstallList$1$newList$1(this.$list, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super List<CommonAppEntity>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L17;
        kotlin.c.b(r10);
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = this.$list.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        List<CommonAppEntity> r13 = ((FirstRecommendWrap) r12.next()).getApps();
        if (r13 == null) goto L6;
        Iterator<T> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L6;
        CommonAppEntity r15 = (CommonAppEntity) r14.next();
        if (r15.getDefault_check() != 1) goto L11;
        r11.add(r15);
        goto L11
    L15:
        return r11;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<CommonAppEntity>> r11) {
        return ((FirstRecommendDialog$updateInstallList$1$newList$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

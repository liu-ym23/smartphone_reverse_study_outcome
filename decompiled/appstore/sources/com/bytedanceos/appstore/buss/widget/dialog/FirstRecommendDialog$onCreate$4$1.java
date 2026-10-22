package com.bytedanceos.appstore.buss.widget.dialog;

import android.os.Bundle;
import android.view.View;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.R;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.widget.dialog.FirstRecommendDialog$onCreate$4$1", f = "FirstRecommendDialog.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
final class FirstRecommendDialog$onCreate$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $it;
    int label;
    final /* synthetic */ k this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.widget.dialog.FirstRecommendDialog$onCreate$4$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.widget.dialog.FirstRecommendDialog$onCreate$4$1$1", f = "FirstRecommendDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nFirstRecommendDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirstRecommendDialog.kt\ncom/bytedanceos/appstore/buss/widget/dialog/FirstRecommendDialog$onCreate$4$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,244:1\n1549#2:245\n1620#2,3:246\n1855#2,2:249\n1855#2,2:251\n*S KotlinDebug\n*F\n+ 1 FirstRecommendDialog.kt\ncom/bytedanceos/appstore/buss/widget/dialog/FirstRecommendDialog$onCreate$4$1$1\n*L\n126#1:245\n126#1:246,3\n133#1:249,2\n145#1:251,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ k this$0;

        public AnonymousClass1(k r10, Continuation<? super AnonymousClass1> r11) {
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(null, r11);
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
            if (this.label != 0) goto L28;
            kotlin.c.b(r10);
            List r11 = k.c(null);
            kotlin.jvm.internal.q.f(r11, "access$getDownloadList(...)");
            monitor-enter(r11);
            List r12 = k.c(null);     // Catch: Throwable -> L12
            kotlin.jvm.internal.q.f(r12, "access$getDownloadList(...)");     // Catch: Throwable -> L12
            ArrayList r13 = new ArrayList(kotlin.collections.u.r(r12, 10));     // Catch: Throwable -> L12
            Iterator r14 = r12.iterator();     // Catch: Throwable -> L12
        L8:
            if (r14.hasNext() == false) goto L19;
            CommonAppEntity r15 = (CommonAppEntity) r14.next();     // Catch: Throwable -> L12
            CommonAppItem r16 = r15.getItem();     // Catch: Throwable -> L12
            if (r16 == null) goto L14;
            AppInfo r17 = r16.getAppInfo();     // Catch: Throwable -> L12
        L15:
            if (r17 == null) goto L17;
            CommonAppItem r18 = r15.getItem();     // Catch: Throwable -> L12
            kotlin.jvm.internal.q.d(r18);     // Catch: Throwable -> L12
            AppInfo r19 = r18.getAppInfo();     // Catch: Throwable -> L12
        L18:
            r13.add(r19);     // Catch: Throwable -> L12
            goto L8
        L17:
            r19 = r15.convertAppInfo();     // Catch: Throwable -> L12
            goto L18
        L14:
            r17 = null;
            goto L15
        L19:
            List r20 = k.c(null);     // Catch: Throwable -> L12
            kotlin.jvm.internal.q.f(r20, "access$getDownloadList(...)");     // Catch: Throwable -> L12
            Iterator r21 = r20.iterator();     // Catch: Throwable -> L12
        L21:
            if (r21.hasNext() == false) goto L23;
            k.d(null).add(((CommonAppEntity) r21.next()).getPackageNameForFilter());     // Catch: Throwable -> L12
            goto L21
        L23:
            new Bundle().putString("firststart_pkgs", k.d(null).toString());     // Catch: Throwable -> L12
            k.b(null);     // Catch: Throwable -> L12
            kotlin.jvm.internal.q.y("binding");     // Catch: Throwable -> L12
            throw null;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public FirstRecommendDialog$onCreate$4$1(k r10, View r11, Continuation<? super FirstRecommendDialog$onCreate$4$1> r12) {
        this.$it = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new FirstRecommendDialog$onCreate$4$1(null, this.$it, r11);
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
        if (r12 != 1) goto L6;
        kotlin.c.b(r10);
        throw null;
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        List r13 = k.c(null);
        if (r13 != null) goto L11;
    L17:
        View r14 = this.$it;
        kotlin.jvm.internal.q.f(r14, "$it");
        com.bytedanceos.appstore.buss.utilities.s.c(r14, R.string.tv_first_recommend_dialog_empty_choose_toast);
        return Unit.f21064a;
    L11:
        if (r13.isEmpty() == true) goto L17;
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(null, null);
        this.label = 1;
        if (kotlinx.coroutines.h.g(r15, r16, this) != r11) goto L19;
        return r11;
    L19:
        throw null;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((FirstRecommendDialog$onCreate$4$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

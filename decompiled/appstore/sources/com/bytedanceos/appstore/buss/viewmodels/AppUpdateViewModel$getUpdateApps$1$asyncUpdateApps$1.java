package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntityKt;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1", f = "AppUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppUpdateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUpdateViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n1549#2:128\n1620#2,3:129\n*S KotlinDebug\n*F\n+ 1 AppUpdateViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1\n*L\n75#1:128\n75#1:129,3\n*E\n"})
public final class AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<CommonAppEntity>>, Object> {
    int label;
    final /* synthetic */ AppUpdateViewModel this$0;

    public AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1(AppUpdateViewModel r10, Continuation<? super AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1(this.this$0, r11);
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
        if (this.label != 0) goto L11;
        kotlin.c.b(r10);
        List r11 = BaseApplication.c().b().v("UPDATE");
        this.this$0.f().m(tf.a.c(BaseApplication.c().b().j(r11)));
        q.d(r11);
        ArrayList r12 = new ArrayList(u.r(r11, 10));
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        AppInfo r14 = (AppInfo) r13.next();
        q.d(r14);
        r12.add(CommonAppEntityKt.convertCommonAppEntity(r14));
        goto L6
    L9:
        return b0.z0(r12);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super List<CommonAppEntity>> r11) {
        return ((AppUpdateViewModel$getUpdateApps$1$asyncUpdateApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

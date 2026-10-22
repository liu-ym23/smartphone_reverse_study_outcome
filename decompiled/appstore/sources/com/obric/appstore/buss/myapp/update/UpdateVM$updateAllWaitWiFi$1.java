package com.obric.appstore.buss.myapp.update;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.smt.obric.appstore.domain.app.n;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM$updateAllWaitWiFi$1", f = "UpdateVM.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUpdateVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateVM.kt\ncom/obric/appstore/buss/myapp/update/UpdateVM$updateAllWaitWiFi$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n766#2:255\n857#2,2:256\n1549#2:258\n1620#2,3:259\n1855#2,2:262\n*S KotlinDebug\n*F\n+ 1 UpdateVM.kt\ncom/obric/appstore/buss/myapp/update/UpdateVM$updateAllWaitWiFi$1\n*L\n247#1:255\n247#1:256,2\n249#1:258\n249#1:259,3\n249#1:262,2\n*E\n"})
public final class UpdateVM$updateAllWaitWiFi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UpdateVM this$0;

    public UpdateVM$updateAllWaitWiFi$1(UpdateVM r10, Continuation<? super UpdateVM$updateAllWaitWiFi$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UpdateVM$updateAllWaitWiFi$1(this.this$0, r11);
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
        Iterator r13 = (Iterator) this.L$1;
        UpdateVM r14 = (UpdateVM) this.L$0;
        kotlin.c.b(r10);
    L22:
        if (r13.hasNext() == false) goto L27;
        com.smt.obric.appstore.domain.app.entity.a r15 = (com.smt.obric.appstore.domain.app.entity.a) r13.next();
        EnqueueAppInstallTaskUseCase r16 = UpdateVM.v(r14);
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 1;
        if (r16.a(r15, this) != r11) goto L22;
        return r11;
    L27:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        BaseApplication r17 = BaseApplication.c();
        List r18 = r17.b().v("UPDATE");
        q.d(r18);
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L16;
        Object r21 = r20.next();
        AppInfo r22 = (AppInfo) r21;
        q.d(r17);
        String r23 = r22.appPackageName;
        q.f(r23, "appPackageName");
        if (PackageInfoKTxKt.d(r17, r23, r22.sha256) == true) goto L10;
        if (r22.mAppUpdateType == 0) goto L10;
        r19.add(r21);
        goto L10
    L16:
        ArrayList r24 = new ArrayList(u.r(r19, 10));
        Iterator r25 = r19.iterator();
    L18:
        if (r25.hasNext() == false) goto L20;
        AppInfo r26 = (AppInfo) r25.next();
        q.d(r26);
        r24.add(n.f(AppInfoKtxKt.newDomainEntity$default(r26, null, 1, null), false));
        goto L18
    L20:
        UpdateVM r27 = this.this$0;
        r14 = r27;
        r13 = r24.iterator();
        goto L22
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UpdateVM$updateAllWaitWiFi$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

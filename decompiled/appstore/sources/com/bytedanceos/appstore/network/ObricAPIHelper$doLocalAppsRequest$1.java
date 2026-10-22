package com.bytedanceos.appstore.network;

import com.android.volley.VolleyError;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.UpdateAppInfoReq;
import com.obric.appstore.network.g;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.collections.k0;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.network.ObricAPIHelper$doLocalAppsRequest$1", f = "ObricAPIHelper.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nObricAPIHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAPIHelper.kt\ncom/bytedanceos/appstore/network/ObricAPIHelper$doLocalAppsRequest$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1549#2:367\n1620#2,3:368\n*S KotlinDebug\n*F\n+ 1 ObricAPIHelper.kt\ncom/bytedanceos/appstore/network/ObricAPIHelper$doLocalAppsRequest$1\n*L\n202#1:367\n202#1:368,3\n*E\n"})
public final class ObricAPIHelper$doLocalAppsRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $originBody;
    final /* synthetic */ y8.a $response;
    int label;

    public ObricAPIHelper$doLocalAppsRequest$1(String r10, y8.a r11, Continuation<? super ObricAPIHelper$doLocalAppsRequest$1> r12) {
        this.$originBody = r10;
        this.$response = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new ObricAPIHelper$doLocalAppsRequest$1(this.$originBody, this.$response, r11);
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
        c.b(r10);
    L31:
        ObricAPIHelper.f(ObricAPIHelper.f9432a, (g) r10, this.$response, AnonymousClass1.INSTANCE);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        j.e("doLocalAppsRequest: " + this.$originBody);
        Type r13 = new ObricAPIHelper$doLocalAppsRequest$1$type$1().getType();
        String r14 = this.$originBody;
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L13
        Object r16 = ObricAPIHelper.f9432a.r().fromJson(r14, r13);     // Catch: Throwable -> L13
        q.f(r16, "fromJson(...)");     // Catch: Throwable -> L13
        List r17 = (List) r16;     // Catch: Throwable -> L13
        ArrayList r18 = new ArrayList(u.r(r17, 10));     // Catch: Throwable -> L13
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L13
    L11:
        if (r19.hasNext() == false) goto L15;
        r18.add(((UpdateAppInfoReq) r19.next()).getPackageName());     // Catch: Throwable -> L13
        goto L11
    L15:
        Object r20 = Result.m35constructorimpl(r18);     // Catch: Throwable -> L13
    L19:
        if (Result.m41isFailureimpl(r20) == false) goto L21;
        r20 = null;
    L21:
        List r21 = (List) r20;
        if (r21 != null) goto L28;
        j.b("doUpdateAppsRequest: " + this.$originBody);
        y8.a r22 = this.$response;
        if (r22 == null) goto L27;
        r22.a(new y8.a.C0414a(400, k0.h(), new VolleyError("error!!!")));
    L27:
        return Unit.f21064a;
    L28:
        StoreRepo r23 = StoreRepo.f10831a;
        this.label = 1;
        r10 = r23.i(r21, this);
        if (r10 != r11) goto L31;
        return r11;
    L13:
        th = move-exception;
        Result.a r24 = Result.Companion;
        r20 = Result.m35constructorimpl(c.a(th));
        goto L19
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ObricAPIHelper$doLocalAppsRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

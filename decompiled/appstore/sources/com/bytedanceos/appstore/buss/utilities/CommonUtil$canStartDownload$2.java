package com.bytedanceos.appstore.buss.utilities;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.utilities.CommonUtil$canStartDownload$2", f = "CommonUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCommonUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonUtil.kt\ncom/bytedanceos/appstore/buss/utilities/CommonUtil$canStartDownload$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1855#2,2:291\n*S KotlinDebug\n*F\n+ 1 CommonUtil.kt\ncom/bytedanceos/appstore/buss/utilities/CommonUtil$canStartDownload$2\n*L\n143#1:291,2\n*E\n"})
public final class CommonUtil$canStartDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<CommonAppEntity> $apps;
    int label;

    public CommonUtil$canStartDownload$2(List<CommonAppEntity> r10, Continuation<? super CommonUtil$canStartDownload$2> r11) {
        this.$apps = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new CommonUtil$canStartDownload$2(this.$apps, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L25;
        kotlin.c.b(r10);
        List<CommonAppEntity> r11 = this.$apps;
        if (r11 == null) goto L23;
        if (r11.isEmpty() == true) goto L23;
        Iterator<T> r12 = this.$apps.iterator();
    L11:
        if (r12.hasNext() == false) goto L21;
        CommonAppEntity r13 = (CommonAppEntity) r12.next();
        AppInfo r14 = (AppInfo) BaseApplication.c().b().f9561c.f9576a.get(r13.getPkg());
        if (r14 == null) goto L15;
        if (CommonUtil.f8830a.g(r14) == false) goto L11;
        return tf.a.a(true);
    L15:
        return tf.a.a(true);
    L21:
        return tf.a.a(false);
    L23:
        return tf.a.a(false);
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Boolean> r11) {
        return ((CommonUtil$canStartDownload$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
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
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1", f = "AppIgnoreUpdateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAppIgnoreUpdateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppIgnoreUpdateViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1864#2,3:66\n*S KotlinDebug\n*F\n+ 1 AppIgnoreUpdateViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1\n*L\n36#1:66,3\n*E\n"})
public final class AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppIgnoreUpdateViewModel this$0;

    public AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1(AppIgnoreUpdateViewModel r10, Continuation<? super AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1(this.this$0, r11);
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
        ArrayList r11 = new ArrayList();
        List r12 = BaseApplication.c().b().v("HIDE");
        q.d(r12);
        Iterator r13 = r12.iterator();
        int r14 = 0;
    L6:
        if (r13.hasNext() == false) goto L11;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L10;
        t.q();
    L10:
        CommonAppEntity r17 = com.bytedanceos.appstore.utils.a.e((AppInfo) r15);
        r17.setRecmd_brief(BaseApplication.c().getResources().getString(R.string.app_new_version, new Object[]{r17.getVersion()}));
        r11.add(r17);
        r14 = r16;
        goto L6
    L11:
        this.this$0.f().m(r11);
        return Unit.f21064a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

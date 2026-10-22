package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.entity.netwrap.AppFeedBackEntity;
import com.bytedanceos.appstore.buss.entity.netwrap.AppFeedBackPicEntity;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.List;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.AppFeedBackViewModel$postAppFeedBack$1$entity$1", f = "AppFeedBackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppFeedBackViewModel$postAppFeedBack$1$entity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppFeedBackEntity>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ List<Integer> $list;
    int label;
    final /* synthetic */ AppFeedBackViewModel this$0;

    public AppFeedBackViewModel$postAppFeedBack$1$entity$1(List<Integer> r10, AppFeedBackViewModel r11, String r12, Continuation<? super AppFeedBackViewModel$postAppFeedBack$1$entity$1> r13) {
        this.$list = r10;
        this.this$0 = r11;
        this.$content = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppFeedBackViewModel$postAppFeedBack$1$entity$1(this.$list, this.this$0, this.$content, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super AppFeedBackEntity> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r18) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L10;
        kotlin.c.b(r18);
        String r10 = this.$list.toString();
        String r11 = r10.substring(1, r10.length() - 1);
        q.f(r11, "substring(...)");
        JSONArray r12 = this.this$0.j().w(AppFeedBackViewModel.h(this.this$0));
        ArrayList r13 = new ArrayList();
        int r14 = r12.length();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L8;
        JSONObject r16 = r12.getJSONObject(r15);
        Object r17 = r16.get("name");
        q.e(r17, "null cannot be cast to non-null type kotlin.String");
        String r19 = (String) r17;
        Object r20 = r16.get("type");
        q.e(r20, "null cannot be cast to non-null type kotlin.String");
        String r110 = (String) r20;
        Object r21 = r16.get("size");
        q.e(r21, "null cannot be cast to non-null type kotlin.Long");
        long r111 = ((Long) r21).longValue();
        Object r22 = r16.get(ServerElements.INFO);
        q.e(r22, "null cannot be cast to non-null type kotlin.String");
        r13.add(new AppFeedBackPicEntity(r19, r110, r111, (String) r22));
        r15 = r15 + 1;
        goto L5
    L8:
        return new AppFeedBackEntity("1", AppFeedBackViewModel.h(this.this$0), AppFeedBackViewModel.f(this.this$0), r11, this.$content, r13);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super AppFeedBackEntity> r11) {
        return ((AppFeedBackViewModel$postAppFeedBack$1$entity$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

package com.bytedanceos.appstore.buss.fragment;

import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.TvSearchHotKeywordsEntity;
import com.bytedanceos.appstore.buss.entity.TvSearchRecommendEntityWrap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.fragment.SearchRecommendFragment$updateUi$1", f = "SearchRecommendFragment.kt", i = {}, l = {127, 133}, m = "invokeSuspend", n = {}, s = {})
public final class SearchRecommendFragment$updateUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TvSearchRecommendEntityWrap $wrap;
    int label;
    final /* synthetic */ SearchRecommendFragment this$0;

    public SearchRecommendFragment$updateUi$1(TvSearchRecommendEntityWrap r10, SearchRecommendFragment r11, Continuation<? super SearchRecommendFragment$updateUi$1> r12) {
        this.$wrap = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SearchRecommendFragment$updateUi$1(this.$wrap, this.this$0, r11);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r10);
    L24:
        List r13 = (List) r10;
        if (r13 == null) goto L29;
        PagerTypeAdapter r14 = SearchRecommendFragment.N(this.this$0);
        if (r14 == null) goto L29;
        r14.setList(r13);
    L29:
        SearchRecommendFragment.L(this.this$0).f25782g.setVisibility(0);
        SearchRecommendFragment.L(this.this$0).f25780e.setVisibility(0);
        SearchRecommendFragment.L(this.this$0).f25781f.setVisibility(0);
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L13:
        AppEntityWrap r15 = (AppEntityWrap) r10;
        if (r15 == null) goto L18;
        BinderAdapter r16 = SearchRecommendFragment.M(this.this$0);
        if (r16 == null) goto L18;
        r16.setList(kotlin.collections.s.e(r15));
    L18:
        List<TvSearchHotKeywordsEntity> r17 = this.$wrap.getHot_keywords();
        if (r17 == null) goto L21;
        SearchRecommendFragment.O(this.this$0, r17);
    L21:
        TvSearchRecommendEntityWrap r18 = this.$wrap;
        this.label = 2;
        r10 = r18.recommendConvertListAppEntityWrap(this);
        if (r10 != r11) goto L24;
        return r11;
    L10:
        kotlin.c.b(r10);
        TvSearchRecommendEntityWrap r19 = this.$wrap;
        this.label = 1;
        r10 = r19.hotConvertAppEntityWrap(this);
        if (r10 != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SearchRecommendFragment$updateUi$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}

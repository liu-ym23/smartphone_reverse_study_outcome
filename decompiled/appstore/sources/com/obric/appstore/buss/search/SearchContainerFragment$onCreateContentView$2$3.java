package com.obric.appstore.buss.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.obric.appstore.R;
import com.obric.appstore.util.ViewUtilsKt;
import com.obric.oui.chip.OChip;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import sa.r;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/bytedanceos/common/model/SearchHotWords;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchContainerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchContainerFragment.kt\ncom/obric/appstore/buss/search/SearchContainerFragment$onCreateContentView$2$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,579:1\n304#2,2:580\n*S KotlinDebug\n*F\n+ 1 SearchContainerFragment.kt\ncom/obric/appstore/buss/search/SearchContainerFragment$onCreateContentView$2$3\n*L\n182#1:580,2\n*E\n"})
public final class SearchContainerFragment$onCreateContentView$2$3 extends Lambda implements Function1<List<? extends SearchHotWords>, Unit> {
    final /* synthetic */ r $this_apply;
    final /* synthetic */ SearchContainerFragment this$0;

    /* JADX INFO: renamed from: com.obric.appstore.buss.search.SearchContainerFragment$onCreateContentView$2$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "chip", "Lcom/obric/oui/chip/OChip;", "history", "Lcom/bytedanceos/common/model/SearchHotWords;", SlideCard.KEY_INDEX, "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function3<OChip, SearchHotWords, Integer, Unit> {
        final /* synthetic */ SearchContainerFragment this$0;

        public AnonymousClass2(SearchContainerFragment r10) {
            this.this$0 = r10;
            super(3);
        }

        public static /* synthetic */ void a(SearchContainerFragment r10, SearchHotWords r11, View r12) {
            invoke$lambda$0(r10, r11, r12);
        }

        private static final void invoke$lambda$0(SearchContainerFragment r10, SearchHotWords r11, View r12) {
            q.g(r10, "this$0");
            q.g(r11, "$history");
            SearchVM r13 = r10.T();
            String r14 = r11.getKeyword();
            q.f(r14, "getKeyword(...)");
            r13.l(r14);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(OChip r10, SearchHotWords r11, Integer r12) {
            invoke(r10, r11, r12.intValue());
            return Unit.f21064a;
        }

        public final void invoke(@NotNull OChip r10, @NotNull final SearchHotWords r11, int r12) {
            q.g(r10, "chip");
            q.g(r11, "history");
            r10.setBackgroundColor(this.this$0.requireActivity().getColor(R.color.oui_fill_element_2));
            String r13 = r11.getKeyword();
            q.f(r13, "getKeyword(...)");
            r10.setText(r13);
            r10.getTextView().setTextColor(this.this$0.requireActivity().getColor(R.color.oui_text_2));
            final SearchContainerFragment r14 = this.this$0;
            r10.setOnClickListener(new h(r14, r11));
            r10.requestLayout();
        }
    }

    public SearchContainerFragment$onCreateContentView$2$3(r r10, SearchContainerFragment r11) {
        this.$this_apply = r10;
        this.this$0 = r11;
        super(1);
    }

    public static /* synthetic */ void a(SearchContainerFragment r10, View r11) {
        invoke$lambda$0(r10, r11);
    }

    private static final void invoke$lambda$0(SearchContainerFragment r10, View r11) {
        q.g(r10, "this$0");
        r10.T().g();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchHotWords> r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends SearchHotWords> r10) {
        this.$this_apply.f24668c.setMaxRows(2);
        FlowLayout r11 = this.$this_apply.f24668c;
        q.f(r11, "searchHistoryFlowLayout");
        q.d(r10);
        final SearchContainerFragment r12 = this.this$0;
        Function1<ViewGroup, OChip> r13 = new AnonymousClass1(r12);
        AnonymousClass2 r14 = new AnonymousClass2(this.this$0);
        int r15 = 0;
        ViewUtilsKt.c(r11, r10, false, r13, r14);
        ImageView r16 = this.$this_apply.f24669d;
        final SearchContainerFragment r17 = this.this$0;
        r16.setOnClickListener(new g(r17));
        ConstraintLayout r18 = this.$this_apply.f24671f;
        q.f(r18, "sectionTitleBar");
        if (r10.isEmpty() == false) goto L5;
        r15 = 8;
    L5:
        r18.setVisibility(r15);
    }
}

package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OBaseIndicator$setViewPager2$2$releaseAction$1 extends Lambda implements Function1<OBaseIndicator.ReleaseMe, Unit> {
    final /* synthetic */ ViewPager2 $viewPager;

    public OBaseIndicator$setViewPager2$2$releaseAction$1(ViewPager2 r10) {
        this.$viewPager = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OBaseIndicator.ReleaseMe r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull OBaseIndicator.ReleaseMe r10) {
        q.g(r10, "it");
        RecyclerView.Adapter r11 = this.$viewPager.getAdapter();
        q.d(r11);
        r11.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) r10);
    }
}

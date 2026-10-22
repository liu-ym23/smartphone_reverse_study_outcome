package com.alibaba.gaiax.render.view.container.slider;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/alibaba/gaiax/render/view/container/slider/GXSliderView$startTimer$1$1", "Ljava/util/TimerTask;", "run", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXSliderView$startTimer$1$1 extends TimerTask {
    final /* synthetic */ GXSliderView this$0;

    public static /* synthetic */ void a(GXSliderView r100, int r101, int r102) {
        run$lambda$2$lambda$1$lambda$0(r100, r101, r102);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        com_alibaba_gaiax_render_view_container_slider_GXSliderView$startTimer$1$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_alibaba_gaiax_render_view_container_slider_GXSliderView$startTimer$1$1__run$___twin___() {
        ViewPager r100 = this.this$0.getViewPager();
        if (r100 == null) goto L10;
        final int r101 = r100.getCurrentItem();
        final GXSliderView r102 = this.this$0;
        ViewPager r103 = r102.getViewPager();
        if (r103 == null) goto L11;
        PagerAdapter r104 = r103.getAdapter();
        if (r104 == null) goto L12;
        final int r105 = r104.getCount();
        GXSliderView.access$getMainHandler$p(r102).post(new b(r102, r101, r105));
        return;
    L12:
        return;
    L11:
        return;
    }

    public GXSliderView$startTimer$1$1(GXSliderView r100) {
        this.this$0 = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_alibaba_gaiax_render_view_container_slider_GXSliderView$startTimer$1$1_com_larus_apm_impl_protector_RunnableLancet_run(GXSliderView$startTimer$1$1 r100) {
        r100.com_alibaba_gaiax_render_view_container_slider_GXSliderView$startTimer$1$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private static final void run$lambda$2$lambda$1$lambda$0(GXSliderView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        ViewPager r103 = r100.getViewPager();
        if (r103 == null) goto L6;
        r103.setCurrentItem((r101 + 1) % r102, true);
        return;
    }
}
